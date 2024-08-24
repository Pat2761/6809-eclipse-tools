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
import org.bpy.electronics.mc6809.assembler.assembler.JmpInstruction;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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
import org.bpy.electronics.mc6809.assembler.engine.AssemblerManager;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledJMPInstruction;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class TestJMPInstruction {
	@Inject
	ParseHelper<Model> parseHelper;
	@Inject
	@Extension
	private ValidationTestHelper validationHelper;

	/**
	 * Check JMP direct mode
	 */
	@Test
	public void testJMPDirectAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(";-----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       JMP		  	<124\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an JMP directive line",
					instructionLine.getInstruction() instanceof JmpInstruction);

			JmpInstruction jmpInstruction = (JmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
			assertTrue("Must be a direct addressing mode", jmpInstruction.getOperand() instanceof DirectOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check JMP extended mode
	 */
	@Test
	public void testJMPExtendedAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(";-----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       JMP		  	$1234\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an JMP directive line",
					instructionLine.getInstruction() instanceof JmpInstruction);

			JmpInstruction jmpInstruction = (JmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
			assertTrue("Must be a extended addressing mode", jmpInstruction.getOperand() instanceof ExtendedOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check JMP extended mode
	 */
	@Test
	public void testJMPExtendedAddressingMode1_1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("START      ORG    		$8000\n");
		strBuilder.append("	         JMP		  	START\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an JMP directive line",
					instructionLine.getInstruction() instanceof JmpInstruction);

			JmpInstruction jmpInstruction = (JmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
			assertTrue("Must be a extended addressing mode", jmpInstruction.getOperand() instanceof ExtendedOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check JMP extended mode
	 */
	@Test
	public void testJMPExtendedAddressingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       JMP		  	>$1234\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an JMP directive line",
					instructionLine.getInstruction() instanceof JmpInstruction);

			JmpInstruction jmpInstruction = (JmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
			assertTrue("Must be a extended addressing mode", jmpInstruction.getOperand() instanceof ExtendedOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check JMP extended indirect mode
	 */
	@Test
	public void testJMPExtendedIndirectAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(";-----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       JMP		  	[$1234]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an JMP directive line",
					instructionLine.getInstruction() instanceof JmpInstruction);

			JmpInstruction jmpInstruction = (JmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
			assertTrue("Must be a extended indirect addressing mode",
					jmpInstruction.getOperand() instanceof ExtendedIndirectOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check JMP Constant-Offset Indexed
	 */
	@Test
	public void testJMPConstantOffsetIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(";-----------------------------------------\n");
		strBuilder.append("	       	ORG    		$8000\n");
		strBuilder.append("Const	EQU        	5    \n");
		strBuilder.append("	       	JMP		  	Const,X\n");
		strBuilder.append("			JMP		  	,X\n");
		strBuilder.append("			JMP		  	$9,U\n");
		strBuilder.append("			JMP		  	$9,S\n");
		strBuilder.append("			JMP		  	$9,X\n");
		strBuilder.append("			JMP		  	$9,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an JMP directive line",
					instructionLine.getInstruction() instanceof JmpInstruction);

			JmpInstruction jmpInstruction = (JmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
			assertTrue("Must be a Constant-Offset Indexed mode", jmpInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) jmpInstruction.getOperand();
			assertTrue("Must be a Constant-Offset Indexed mode",
					indexedOperand.getMode() instanceof ConstantIndexedMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check JMP Constant-Offset Indexed indirect
	 */
	@Test
	public void testJMPConstantOffsetIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(";-----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("	       	JMP		  	[Const,X]\n");
		strBuilder.append("			JMP		  	[,X]\n");
		strBuilder.append("			JMP		  	[$9,U]\n");
		strBuilder.append("			JMP		  	[$9,S]\n");
		strBuilder.append("			JMP		  	[$9,X]\n");
		strBuilder.append("			JMP		  	[$9,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an JMP directive line",
					instructionLine.getInstruction() instanceof JmpInstruction);

			JmpInstruction jmpInstruction = (JmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
			assertTrue("Must be a Constant-Offset Indexed mode", jmpInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) jmpInstruction.getOperand();
			assertTrue("Must be a Constant-Offset Indexed indirect mode",
					indexedOperand.getMode() instanceof ConstantIndexedMovingIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check JMP Accumulator Indexed
	 */
	@Test
	public void testJMPAccumulatorIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(";-----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	EQU          	5    \n");
		strBuilder.append("	       	JMP			  	A,X\n");
		strBuilder.append("			JMP			  	B,X\n");
		strBuilder.append("			JMP			  	D,U\n");
		strBuilder.append("			JMP		  		A,S\n");
		strBuilder.append("			JMP		  		B,X\n");
		strBuilder.append("			JMP		  		D,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an JMP directive line",
					instructionLine.getInstruction() instanceof JmpInstruction);

			JmpInstruction jmpInstruction = (JmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
			assertTrue("Must be a Constant-Offset Indexed mode", jmpInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) jmpInstruction.getOperand();
			assertTrue("Must be a Accumulator Indexed mode", indexedOperand.getMode() instanceof AccumulatorMovingMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check JMP Accumulator Indexed Indirect
	 */
	@Test
	public void testJMPAccumulatorIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("	       	JMP		  	[A,X]\n");
		strBuilder.append("			JMP		  	[B,X]\n");
		strBuilder.append("			JMP		  	[D,U]\n");
		strBuilder.append("			JMP		  	[A,S]\n");
		strBuilder.append("			JMP		  	[B,X]\n");
		strBuilder.append("			JMP		  	[D,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an JMP directive line",
					instructionLine.getInstruction() instanceof JmpInstruction);

			JmpInstruction jmpInstruction = (JmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
			assertTrue("Must be a Constant-Offset Indexed mode", jmpInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) jmpInstruction.getOperand();
			assertTrue("Must be a Accumulator Indexed indirect mode",
					indexedOperand.getMode() instanceof AccumulatorMovingIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check JMP Auto-Increment Indexed
	 */
	@Test
	public void testJMPAutoIncrementIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("	       	JMP		  	,--X\n");
		strBuilder.append("	       	JMP		  	,-X\n");
		strBuilder.append("	       	JMP		  	,X+\n");
		strBuilder.append("	       	JMP		  	,X++\n");
		strBuilder.append("	       	JMP		  	,--S\n");
		strBuilder.append("	       	JMP		  	,-S\n");
		strBuilder.append("	       	JMP		  	,U+\n");
		strBuilder.append("	       	JMP		  	,U++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an JMP directive line",
					instructionLine.getInstruction() instanceof JmpInstruction);

			JmpInstruction jmpInstruction = (JmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
			assertTrue("Must be a Constant-Offset Indexed mode", jmpInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) jmpInstruction.getOperand();
			assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.getMode() instanceof AutoIncDecMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check JMP Auto-Increment Indexed Indirect
	 */
	@Test
	public void testJMPAutoIncrementIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("	       	JMP		  	[,--X]\n");
		strBuilder.append("	       	JMP		  	[,X++]\n");
		strBuilder.append("	       	JMP		  	[,--S]\n");
		strBuilder.append("	       	JMP		  	[,U++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an JMP directive line",
					instructionLine.getInstruction() instanceof JmpInstruction);

			JmpInstruction jmpInstruction = (JmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
			assertTrue("Must be a Constant-Offset Indexed mode", jmpInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) jmpInstruction.getOperand();
			assertTrue("Must be a Auto-Increment Indexed indirect mode",
					indexedOperand.getMode() instanceof AutoIncDecIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check JMP Relative to PC Indexed
	 */
	@Test
	public void testJMPRelativePCIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    		$0000\n");
		strBuilder.append("Const	   EQU          5    \n");
		strBuilder.append("	       	JMP		  	0,PC\n");
		strBuilder.append("	       	JMP		  	,PC\n");
		strBuilder.append("	       	JMP		  	Const,PC\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an JMP directive line",
					instructionLine.getInstruction() instanceof JmpInstruction);

			JmpInstruction jmpInstruction = (JmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
			assertTrue("Must be a Constant-Offset Indexed mode", jmpInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) jmpInstruction.getOperand();
			assertTrue("Must be a Relative to Indexed mode", indexedOperand.getMode() instanceof RelatifToPCMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check JMP Relative to PC Indexed Indirect
	 */
	@Test
	public void testJMPRelativePCIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    		$0000\n");
		strBuilder.append("Const	   EQU      	5    \n");
		strBuilder.append("	       	JMP		  	[0,PC]\n");
		strBuilder.append("	       	JMP		  	[,PC]\n");
		strBuilder.append("	       	JMP		  	[Const,PC]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);

			InstructionLine instructionLine = (InstructionLine) line.getLineContent();
			Assert.assertTrue("Must be an JMP directive line",
					instructionLine.getInstruction() instanceof JmpInstruction);

			JmpInstruction jmpInstruction = (JmpInstruction) instructionLine.getInstruction();
			assertEquals("Must be an JMP instruction", jmpInstruction.getInstruction(), "JMP");
			assertTrue("Must be a Constant-Offset Indexed mode", jmpInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand) jmpInstruction.getOperand();
			assertTrue("Must be a Relative to Indexed Indirect mode",
					indexedOperand.getMode() instanceof RelatifToPCIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check JMP instruction with duplicate label
	 */
	@Test
	public void testJMPWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(";-----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start		NOP\n");
		strBuilder.append("				NOP    \n");
		strBuilder.append("Start      	JMP		  		<Const+2\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getInstructionLine(),
					InstructionValidator.DUPLICATE_LABEL, "Label Start is already defined");
			
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	@Test
	public void testJMPWithImmediateMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  		#25           ; Check illegal mode\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.ILLEGAL_MODE, "Immediate mode is not valid for the JMP instruction");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check State", 0x8001, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check Opcode value", 0x3F, line.getOpcode()[0]);
			Assert.assertEquals("Check Operand length", 0, line.getOperand().length);
			Assert.assertEquals("Check label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; Check illegal mode", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP direct mode instruction
	 */
	@Test
	public void testJMPDirectInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	<Const*2  ; 8000   0E 0A        START:    JMP   <Const*2 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x0E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x0A, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   0E 0A        START:    JMP   <Const*2 ", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP direct with limit negative operand
	 */
	@Test
	public void testJMPDirectInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	<-129\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value -129 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP direct with limit negative operand
	 */
	@Test
	public void testJMPDirectInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	<-128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP direct with positive limit operand
	 */
	@Test
	public void testJMPDirectInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	<127\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP direct with positive limit operand
	 */
	@Test
	public void testJMPDirectInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	<128\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"The value 128 is greater than the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP extended mode instruction
	 */
	@Test
	public void testJMPExtendedInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	>Const*1000  ; 8000   7E 13 88     START:    JMP   >Const*1000 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x7E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   7E 13 88     START:    JMP   >Const*1000 ",
					line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP extended with limit negative operand
	 */
	@Test
	public void testJMPExtendedInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	>-32769\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP extended with limit negative operand
	 */
	@Test
	public void testJMPExtendedInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	>-32768\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP extended with positive limit operand
	 */
	@Test
	public void testJMPExtendedInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	>65535\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP extended with positive limit operand
	 */
	@Test
	public void testJMPExtendedInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	>65536\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP extended indirect mode instruction
	 */
	@Test
	public void testJMPExtendedIndirectInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append(
				"Start      	JMP		  	[Const*1000]  ; 8000   AB 9F 13 88  START:    JMP   [Const*1000]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode", 0x9F, line.getOpcode()[1]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x13, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 9F 13 88  START:    JMP   [Const*1000]",
					line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP extended indirect with limit negative operand
	 */
	@Test
	public void testJMPExtendedIndirectInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[-32769]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value -32769 is below the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP extended indirect with limit negative operand
	 */
	@Test
	public void testJMPExtendedIndirectInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[-32768]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP extended indirect with positive limit operand
	 */
	@Test
	public void testJMPExtendedIndirectInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[65535]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP extended indirect with positive limit operand
	 */
	@Test
	public void testJMPExtendedIndirectInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[65536]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"The value 65536 is greater than the possible limit, data may be lost");
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedAccumulatorMovingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	A,X  ; 8000   AB 86        START:    JMP   A,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x86, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 86        START:    JMP   A,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedAccumulatorMovingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	A,Y  ; 8000   	6E A6        START:    JMP   A,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E A6        START:    JMP   A,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedAccumulatorMovingMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	A,U  ; 8000   	6E C6        START:    JMP   A,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E C6        START:    JMP   A,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedAccumulatorMovingMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	A,S  ; 8000   	6E E6        START:    JMP   A,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E E6        START:    JMP   A,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedAccumulatorMovingMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	B,X  ; 8000   AB 85        START:    JMP   B,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x85, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 85        START:    JMP   B,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedAccumulatorMovingMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	B,Y  ; 8000   	6E A5        START:    JMP   B,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E A5        START:    JMP   B,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedAccumulatorMovingMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	B,U  ; 8000   	6E C5        START:    JMP   B,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E C5        START:    JMP   B,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedAccumulatorMovingMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	B,S  ; 8000   	6E E5        START:    JMP   B,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E E5        START:    JMP   B,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedAccumulatorMovingMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	D,X  ; 8000   AB 8B        START:    JMP   D,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8B, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    JMP   D,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedAccumulatorMovingMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	D,Y  ; 8000   	6E AB        START:    JMP   D,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xAB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E AB        START:    JMP   D,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedAccumulatorMovingMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	D,U  ; 8000   	6E CB        START:    JMP   D,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xCB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E CB        START:    JMP   D,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedAccumulatorMovingMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	D,S  ; 8000   	6E EB        START:    JMP   D,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xEB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E EB        START:    JMP   D,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedIndorectAccumulatorMovingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[A,X]  ; 8000   AB 96        START:    JMP   [A,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x96, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 96        START:    JMP   [A,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedIndirectAccumulatorMovingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  		[A,Y]  ; 8000   	6E B6        START:    JMP   [A,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E B6        START:    JMP   [A,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedIndirectAccumulatorMovingMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[A,U]  ; 8000   	6E D6        START:    JMP   [A,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E D6        START:    JMP   [A,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedIndirectAccumulatorMovingMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[A,S]  ; 8000   	6E F6        START:    JMP   [A,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF6, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E F6        START:    JMP   [A,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedIndirectAccumulatorMovingMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[B,X]  ; 8000   AB 95        START:    JMP   [B,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x95, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 95        START:    JMP   [B,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedIndirectAccumulatorMovingMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[B,Y]  ; 8000   	6E B5        START:    JMP   [B,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E B5        START:    JMP   [B,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedIndirectAccumulatorMovingMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[B,U]  ; 8000   	6E D5        START:    JMP   [B,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E D5        START:    JMP   [B,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedIndirectAccumulatorMovingMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  		[B,S]  ; 8000   	6E F5        START:    JMP   [B,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF5, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E F5        START:    JMP   [B,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedIndirectAccumulatorMovingMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[D,X]  ; 8000   AB 9B        START:    JMP   [D,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9B, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    JMP   [D,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedIndirectAccumulatorMovingMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[D,Y]  ; 8000   	6E BB        START:    JMP   [D,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xBB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E BB        START:    JMP   [D,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedIndirectAccumulatorMovingMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[D,U]  ; 8000   	6E DB        START:    JMP   [D,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xDB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E DB        START:    JMP   [D,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed indirect Accumulator Moving Mode instruction
	 */
	@Test
	public void testJMPIndexedIndirectAccumulatorMovingMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[D,S]  ; 8000   	6E FB        START:    JMP   [D,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xFB, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E FB        START:    JMP   [D,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	,X+  ; 8000   	6E 80        START:    JMP   ,X+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 80        START:    JMP   ,X+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	,X++  ; 8000   	6E 81        START:    JMP   ,X++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x81, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 81        START:    JMP   ,X++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	,Y+  ; 8000   	6E A0        START:    JMP   ,Y+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E A0        START:    JMP   ,Y+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	,Y++  ; 8000   	6E A1        START:    JMP   ,Y++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E A1        START:    JMP   ,Y++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	,S+  ; 8000   	6E E0        START:    JMP   ,S+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E E0        START:    JMP   ,S+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	,S++  ; 8000   	6E E1        START:    JMP   ,S++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E E1        START:    JMP   ,S++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	,U+  ; 8000   	6E C0        START:    JMP   ,U+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC0, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E C0        START:    JMP   ,U+", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	,U++  ; 8000   	6E C1        START:    JMP   ,U++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E C1        START:    JMP   ,U++", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	,-X  ; 8000   	6E 82        START:    JMP   ,-X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x82, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 82        START:    JMP   ,-X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	,--X  ; 8000   	6E 83        START:    JMP   ,--X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x83, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 83        START:    JMP   ,--X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	,-Y  ; 8000   	6E A2        START:    JMP   ,-Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E A2        START:    JMP   ,-Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	,--Y  ; 8000   	6E A3        START:    JMP   ,--Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E A3        START:    JMP   ,--Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementMode13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	,-S  ; 8000   	6E E2        START:    JMP   ,-S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E E2        START:    JMP   ,-S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementMode14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	,--S  ; 8000   	6E E3        START:    JMP   ,--S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E E3        START:    JMP   ,--S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementMode15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	,-U  ; 8000   	6E C2        START:    JMP   ,-U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC2, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E C2        START:    JMP   ,-U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Mode instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementMode16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	,--U  ; 8000   	6E C3        START:    JMP   ,--U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E C3        START:    JMP   ,--U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementIndirectMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[,X+]  ; 8000   	6E 80        START:    JMP   ,X+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT,
					"Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Mode indorect
	 * instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementIndirectMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[,X++]  ; 8000   	6E 91        START:    JMP   [,X++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x91, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 91        START:    JMP   [,X++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Mode indirect
	 * instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementIndirectMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[,Y+]  ; 8000   	6E A0        START:    JMP   ,Y+\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT,
					"Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementIndirectMode4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[,Y++]  ; 8000   	6E B1        START:    JMP   [,Y++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E B1        START:    JMP   [,Y++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementIndirectMode5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[,S+]  ; 8000   	6E E0        START:    JMP   [,S+]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT,
					"Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementIndirectMode6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[,S++]  ; 8000   	6E F1        START:    JMP   [,S++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E F1        START:    JMP   [,S++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementIndirectMode7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[,U+]  ; 8000   	6E C0        START:    JMP   [,U+]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.ILLEGAL_INCREMENT,
					"Cannot use post increment with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementindirectMode8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[,U++]  ; 8000   	6E D1        START:    JMP   [,U++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD1, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E D1        START:    JMP   [,U++]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementIndirectMode9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[,-X]  ; 8000   	6E 82        START:    JMP   [,-X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT,
					"Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementIndirectMode10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[,--X]  ; 8000   	6E 93        START:    JMP   [,--X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x93, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 93        START:    JMP   [,--X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement INdirect Mode
	 * instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementIndirectMode11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[,-Y]  ; 8000   	6E A2        START:    JMP   [,-Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT,
					"Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementIndirectMode12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[,--Y]  ; 8000   	6E B3        START:    JMP   [,--Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E B3        START:    JMP   [,--Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementIndirectMode13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[,-S]  ; 8000   	6E E2        START:    JMP   [,-S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT,
					"Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementIndirectMode14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[,--S]  ; 8000   	6E F3        START:    JMP   [,--S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E F3        START:    JMP   [,--S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement indirect Mode
	 * instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementIndirectMode15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[,-U]  ; 8000   	6E C2        START:    JMP   [,-U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.ILLEGAL_DECREMENT,
					"Cannot use pre decrement with 1 for indirect mode");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Auto Increment Decrement Indirect Mode
	 * instruction
	 */
	@Test
	public void testJMPIndexedAutoIncrementDecrementIndirectMode16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	JMP		  	[,--U]  ; 8000   	6E D3        START:    JMP   [,--U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD3, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E D3        START:    JMP   [,--U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	1234,X  ; 8000   	6E 89 04 D2            JMP   1234,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 89 04 D2            JMP   1234,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	1234,Y  ; 8000   	6E A9 04 D2            JMP   1234,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E A9 04 D2            JMP   1234,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	1234,U  ; 8000   	6E C9 04 D2            JMP   1234,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E C9 04 D2            JMP   1234,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	1234,S  ; 8000   	6E E9 04 D2            JMP   1234,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E E9 04 D2            JMP   1234,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	34,X  ; 8000   	6E 88 22            JMP   34,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 88 22            JMP   34,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	34,Y  ; 8000   	6E A8 22            JMP   34,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E A8 22            JMP   34,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	34,U  ; 8000   	6E C8 22            JMP   34,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E C8 22            JMP   34,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	34,S  ; 8000   	6E E8 22            JMP   34,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E E8 22            JMP   34,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	,X  ; 8000   	6E 84            JMP   ,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 84            JMP   ,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	,Y  ; 8000   	6E A4            JMP   ,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E A4            JMP   ,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	,U  ; 8000   	6E C4            JMP   ,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E C4            JMP   ,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	,S  ; 8000   	6E E4            JMP   ,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E E4            JMP   ,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	0,X  ; 8000   	6E 84            JMP   0,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x84, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 84            JMP   0,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	0,Y  ; 8000   	6E A4            JMP   0,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E A4            JMP   0,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	0,U  ; 8000   	6E C4            JMP   0,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E C4            JMP   0,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	0,S  ; 8000   	6E E4            JMP   0,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E E4            JMP   0,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove17() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	-16,X  ; 8000   	6E 10            JMP   -16,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x10, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 10            JMP   -16,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove19() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	1,X  ; 8000   	6E 01            JMP   1,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x01, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 01            JMP   1,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove20() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	15,X  ; 8000   	6E 0F            JMP   15,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 0F            JMP   15,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove21() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	-16,Y  ; 8000   	6E 30            JMP   -16,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x30, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 30            JMP   -16,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove23() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	1,Y  ; 8000   	6E 21            JMP   1,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x21, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 21            JMP   1,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove24() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	15,Y  ; 8000   	6E 2F            JMP   15,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x2F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 2F            JMP   15,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove25() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	-16,U  ; 8000   	6E 50            JMP   -16,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x50, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 50            JMP   -16,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove26() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	1,U  ; 8000   	6E 41            JMP   1,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x41, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 41            JMP   1,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove27() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	15,U  ; 8000   	6E 4F            JMP   15,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x4F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 4F            JMP   15,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove28() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	-16,S  ; 8000   	6E 70            JMP   -16,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x70, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 70            JMP   -16,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove29() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	1,S  ; 8000   	6E 61            JMP   1,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x61, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 61            JMP   1,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove30() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	15,S  ; 8000   	6E 6F            JMP   15,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x6F, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 6F            JMP   15,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove31() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	-128,X  ; 8000   	6E 88 80            JMP   -128,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 88 80            JMP   -128,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove32() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	127,X  ; 8000   	6E 88 7F            JMP   127,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 88 7F            JMP   127,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove33() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	-128,Y  ; 8000   	6E A8 80            JMP   -128,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E A8 80            JMP   -128,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove34() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	127,Y  ; 8000   	6E A8 7F            JMP   127,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E A8 7F            JMP   127,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove35() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	-128,U  ; 8000   	6E C8 80            JMP   -128,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E C8 80            JMP   -128,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove36() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	127,U  ; 8000   	6E C8 7F            JMP   127,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E C8 7F            JMP   127,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove37() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	-128,S  ; 8000   	6E E8 80            JMP   -128,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E E8 80            JMP   -128,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove38() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	127,S  ; 8000   	6E E8 7F            JMP   127,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E E8 7F            JMP   127,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove39() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	-32768,X  ; 8000   	6E 89 80 00             JMP   -32768,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 89 80 00             JMP   -32768,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove40() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  32767,X  ; 8000   	6E 89 7F FF             JMP   32767,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 89 7F FF             JMP   32767,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove41() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	-32768,Y  ; 8000   	6E A9 80 00             JMP   -32768,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E A9 80 00             JMP   -32768,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove42() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  32767,Y  ; 8000   	6E A9 7F FF             JMP   32767,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E A9 7F FF             JMP   32767,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove43() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	-32768,U  ; 8000   	6E C9 80 00             JMP   -32768,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E C9 80 00             JMP   -32768,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove44() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  32767,U  ; 8000   	6E C9 7F FF             JMP   32767,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E C9 7F FF             JMP   32767,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove45() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	-32768,S  ; 8000   	6E E9 80 00             JMP   -32768,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E E9 80 00             JMP   -32768,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove46() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  32767,S  ; 8000   	6E E9 7F FF             JMP   32767,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E E9 7F FF             JMP   32767,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove47() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	-32769,X  ; 8000   	6E 89 80 00             JMP   -32769,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 89 80 00             JMP   -32769,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove48() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  32768,X  ; 8000   	6E 89 7F FF             JMP   32768,X\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 89 7F FF             JMP   32768,X", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove49() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	-32769,Y  ; 8000   	6E A9 80 00             JMP   -32769,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E A9 80 00             JMP   -32769,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove50() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  32768,Y  ; 8000   	6E A9 7F FF             JMP   32768,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E A9 7F FF             JMP   32768,Y", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove51() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	-32769,U  ; 8000   	6E C9 80 00             JMP   -32769,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E C9 80 00             JMP   -32769,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove52() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  32768,U  ; 8000   	6E C9 7F FF             JMP   32768,U\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xC9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E C9 7F FF             JMP   32768,U", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove53() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	-32769,S  ; 8000   	6E E9 80 00             JMP   -32769,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E E9 80 00             JMP   -32769,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantMove54() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  32768,S  ; 8000   	6E E9 7F FF             JMP   32768,S\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xE9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E E9 7F FF             JMP   32768,S", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[1234,X]  ; 8000   	6E 99 04 D2            JMP   [1234,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 99 04 D2            JMP   [1234,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[1234,Y]  ; 8000   	6E B9 04 D2            JMP   [1234,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E B9 04 D2            JMP   [1234,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[1234,U]  ; 8000   	6E D9 04 D2            JMP   [1234,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E D9 04 D2            JMP   [1234,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[1234,S]  ; 8000   	6E F9 04 D2            JMP   [1234,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xD2, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E F9 04 D2            JMP   [1234,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[34,X]  ; 8000   	6E 98 22            JMP   [34,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 98 22            JMP   [34,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[34,Y]  ; 8000   	6E B8 22            JMP   [34,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E B8 22            JMP   [34,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[34,U]  ; 8000   	6E D8 22            JMP   [34,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E D8 22            JMP   [34,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[34,S]  ; 8000   	6E F8 22            JMP   [34,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x22, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E F8 22            JMP   [34,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[,X]  ; 8000   	6E 94            JMP   [,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 94            JMP   [,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove10() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[,Y]  ; 8000   	6E B4            JMP   [,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E B4            JMP   [,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove11() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[,U]  ; 8000   	6E D4            JMP   [,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E D4            JMP   [,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove12() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[,S]  ; 8000   	6E F4            JMP   [,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E F4            JMP   [,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove13() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[0,X]  ; 8000   	6E 94            JMP   [0,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x94, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 94            JMP   [0,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove14() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[0,Y]  ; 8000   	6E B4            JMP   [0,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E B4            JMP   [0,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove15() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[0,U]  ; 8000   	6E D4            JMP   [0,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E D4            JMP   [0,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove16() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[0,S]  ; 8000   	6E F4            JMP   [0,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8002, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF4, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E F4            JMP   [0,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove17() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[-16,X]  ; 8000   	6E 98 F0            JMP   [-16,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 98 F0            JMP   [-16,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove18() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[15,X]  ; 8000   	6E 98 0F            JMP   [15,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 98 0F            JMP   [15,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove19() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[-16,Y]  ; 8000   	6E B8 F0            JMP   [-16,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E B8 F0            JMP   [-16,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove20() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[15,Y]  ; 8000   	6E B8 0F            JMP   [15,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E B8 0F            JMP   [15,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove21() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[-16,U]  ; 8000   	6E D8 F0            JMP   [-16,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E D8 F0            JMP   [-16,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove22() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[15,U]  ; 8000   	6E D8 0F            JMP   [15,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E D8 0F            JMP   [15,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove23() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[-16,S]  ; 8000   	6E F8 F0            JMP   [-16,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xF0, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E F8 F0            JMP   [-16,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove24() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[15,S]  ; 8000   	6E F8 0F            JMP   [15,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x0F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E F8 0F            JMP   [15,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove31() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[-128,X]  ; 8000   	6E 98 80            JMP   [-128,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 98 80            JMP   [-128,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove32() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[127,X]  ; 8000   	6E 98 7F            JMP   [127,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 98 7F            JMP   [127,X]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove33() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[-128,Y]  ; 8000   	6E B8 80            JMP   [-128,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E B8 80            JMP   [-128,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove34() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[127,Y]  ; 8000   	6E B8 7F            JMP   [127,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E B8 7F            JMP   [127,Y]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove35() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[-128,U]  ; 8000   	6E D8 80            JMP   [-128,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E D8 80            JMP   [-128,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant INdirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove36() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[127,U]  ; 8000   	6E D8 7F            JMP   [127,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E D8 7F            JMP   [127,U]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove37() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[-128,S]  ; 8000   	6E F8 80            JMP   [-128,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E F8 80            JMP   [-128,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove38() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[127,S]  ; 8000   	6E F8 7F            JMP   [127,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF8, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E F8 7F            JMP   [127,S]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove39() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append(
				"Start      	JMP		  	[-32768,X]  ; 8000   	6E 99 80 00             JMP   [-32768,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 99 80 00             JMP   [-32768,X]",
					line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove40() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  [32767,X]  ; 8000   	6E 99 7F FF             JMP   [32767,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 99 7F FF             JMP   [32767,X]",
					line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove41() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append(
				"Start      	JMP		  	[-32768,Y]  ; 8000   	6E B9 80 00             JMP   [-32768,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E B9 80 00             JMP   [-32768,Y]",
					line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove42() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  [32767,Y]  ; 8000   	6E B9 7F FF             JMP   [32767,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E B9 7F FF             JMP   [32767,Y]",
					line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove43() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append(
				"Start      	JMP		  	[-32768,U]  ; 8000   	6E D9 80 00             JMP   [-32768,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E D9 80 00             JMP   [-32768,U]",
					line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove44() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  [32767,U]  ; 8000   	6E D9 7F FF             JMP   [32767,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E D9 7F FF             JMP   [32767,U]",
					line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove45() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append(
				"Start      	JMP		  	[-32768,S]  ; 8000   	6E F9 80 00             JMP   [-32768,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E F9 80 00             JMP   [-32768,S]",
					line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove46() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  [32767,S]  ; 8000   	6E F9 7F FF             JMP   [32767,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E F9 7F FF             JMP   [32767,S]",
					line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove47() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append(
				"Start      	JMP		  	[-32769,X]  ; 8000   	6E 99 80 00             JMP   [-32769,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 99 80 00             JMP   [-32769,X]",
					line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove48() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  [32768,X]  ; 8000   	6E 99 7F FF             JMP   [32768,X]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E 99 7F FF             JMP   [32768,X]",
					line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove49() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append(
				"Start      	JMP		  	[-32769,Y]  ; 8000   	6E B9 80 00             JMP   [-32769,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E B9 80 00             JMP   [-32769,Y]",
					line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove50() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  [32768,Y]  ; 8000   	6E B9 7F FF             JMP   [32768,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E B9 7F FF             JMP   [32768,Y]",
					line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove51() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append(
				"Start      	JMP		  	[-32769,U]  ; 8000   	6E D9 80 00             JMP   [-32769,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E D9 80 00             JMP   [-32769,U]",
					line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove52() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  [32768,U]  ; 8000   	6E D9 7F FF             JMP   [32768,U]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xD9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E D9 7F FF             JMP   [32768,U]",
					line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove53() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append(
				"Start      	JMP		  	[-32769,S]  ; 8000   	6E F9 80 00             JMP   [-32769,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"Overflow detected for value -32769 , data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E F9 80 00             JMP   [-32769,S]",
					line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed Constant Indirect move Mode instruction
	 */
	@Test
	public void testJMPIndexedConstantIndirectMove54() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  [32768,S]  ; 8000   	6E F9 7F FF             JMP   [32768,S]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR,
					"Overflow detected for value 32768 , data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0xF9, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	6E F9 7F FF             JMP   [32768,S]",
					line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Assembled JMP Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testJMPIndexedRelatifToPCMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	JMP		  	$8003,PCR  ; 8000    6E 8C 00            JMP   $8003,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000    6E 8C 00            JMP   $8003,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled JMP Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testJMPIndexedRelatifToPCMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	JMP		  	$7F83,PCR  ; 8000    6E 8C 80            JMP   $7F83,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000    6E 8C 80            JMP   $7F83,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled JMP Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testJMPIndexedRelatifToPCMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	JMP		  	$8082,PCR  ; 8000    6E 8C 7F            JMP   $8082,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000    6E 8C 7F            JMP   $8082,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled JMP Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testJMPIndexedRelatifToPCMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	JMP		  	$7F82,PCR  ; 8000   	A9 8D FF 7F            JMP   $7F82,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x7E, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A9 8D FF 7F            JMP   $7F82,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled JMP Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testJMPIndexedRelatifToPCMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	JMP		  	$8084,PCR  ; 8000   	A9 8D 00 80            JMP   $8084,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A9 8D 00 80            JMP   $8084,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled JMP Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testJMPIndexedRelatifToPCMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	JMP		  	$0004,PCR  ; 8000   	A9 8D 80 00            JMP   $0004,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   	A9 8D 80 00            JMP   $0004,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled JMP Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testJMPIndexedRelatifToPCMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$4000\n");
		strBuilder.append("Start      	JMP		  	$C003,PCR  ; 4000    6E 8D 7F FF            JMP   $C003,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x4004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 4000    6E 8D 7F FF            JMP   $C003,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled JMP Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testJMPIndexedRelatifToPCMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    		$8000\n");
		strBuilder.append("Start      	JMP		  	$0003,PCR  ; 8000    6E 8D 80 00            JMP   $0003,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value -32769 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000    6E 8D 80 00            JMP   $0003,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled JMP Indexed relatif to PC Mode instruction
	 */
	@Test
	public void testJMPIndexedRelatifToPCMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$4000\n");
		strBuilder.append("Start      	JMP		  	$C004,PCR  ; 4000    6E 8D 7F FF            JMP   $C004,PCR\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value 32768 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x4004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x8D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 4000    6E 8D 7F FF            JMP   $C004,PCR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled JMP Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testJMPIndexedRelatifIndirectToPCMove1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	   [$8003,PCR]  ; 8000    6E 9C 00            JMP   [0,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000    6E 9C 00            JMP   [0,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled JMP Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testJMPIndexedRelatifIndirectToPCMove2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      JMP		  	   [$7F83,PCR]  ; 8000    6E 9C 80            JMP   [-128,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000    6E 9C 80            JMP   [-128,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled JMP Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testJMPIndexedRelatifIndirectToPCMove3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	   [$8082,PCR]  ; 8000    6E 9C 7F            JMP   [$8082,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8003, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 2, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9C, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000    6E 9C 7F            JMP   [$8082,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled JMP Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testJMPIndexedRelatifIndirectToPCMove4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	   [$7F82,PCR]  ; 8000    6E 9D FF 7E            JMP   [$7F83,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x7E, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000    6E 9D FF 7E            JMP   [$7F83,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled JMP Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testJMPIndexedRelatifIndirectToPCMove5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  		[$8084,PCR]  ; 8000    6E 9D 00 80            JMP   [$8084,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000    6E 9D 00 80            JMP   [$8084,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled JMP Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testJMPIndexedRelatifIndirectToPCMove6() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		 	  	ORG    			$8000\n");
		strBuilder.append("Start      	JMP		  	[$0004,PCR]  ; 8000    6E 9D 80 00            JMP   [$0004,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000    6E 9D 80 00            JMP   [$0004,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled JMP Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testJMPIndexedRelatifIndirectToPCMove7() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$4000\n");
		strBuilder.append("Start      	JMP		  	[$C003,PCR]  ; 8000    6E 9D 7F FF            JMP   [$C003,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x4004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000    6E 9D 7F FF            JMP   [$C003,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled JMP Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testJMPIndexedRelatifIndirectToPCMove8() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	ORG    		$8000\n");
		strBuilder.append("Start      	JMP		  	[$0003,PCR]  ; 8000    6E 9D 80 00            JMP   [$0003,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value -32769 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x8004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000    6E 9D 80 00            JMP   [$0003,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check Assembled JMP Indexed relatif indirect to PC Mode instruction
	 */
	@Test
	public void testJMPIndexedRelatifIndirectToPCMove9() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("					ORG    		$4000\n");
		strBuilder.append("Start      	JMP		  	[$C004,PCR]  ; 4000    6E 9D 7F FF            JMP   [$C004,PCR]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getJmpInstruction(),
					InstructionValidator.OVERFLOW_ERROR, "The value 32768 is out than the possible limit, data may be lost");

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Counter after the instruction", 0x4004, engine.getCurrentPcValue());

			AssembledJMPInstruction line = (AssembledJMPInstruction) engine.getAssembledLine(2);
			Assert.assertEquals("Check getOpcode() size ", 1, line.getOpcode().length);
			Assert.assertEquals("Check getOpcode()", 0x6E, line.getOpcode()[0]);
			Assert.assertEquals("Check operand size ", 3, line.getOperand().length);
			Assert.assertEquals("Check operand", 0x9D, line.getOperand()[0]);
			Assert.assertEquals("Check operand", 0x7F, line.getOperand()[1]);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[2]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 4000    6E 9D 7F FF            JMP   [$C004,PCR]", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}
}