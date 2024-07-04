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
import org.bpy.electronics.mc6809.assembler.assembler.AdcInstruction;
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
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledADCAInstruction;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class TestADCAInstruction {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationTestHelper;
	
	/**
	 * Check ADCA immediat 
	 */
	@Test 
	public void testADCAImemdiatAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("			ORG    		$8000\n");
		strBuilder.append("			ADCA		#124\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an ADC directive line", instructionLine.getInstruction() instanceof AdcInstruction);
	
			AdcInstruction adcInstruction = (AdcInstruction)instructionLine.getInstruction();
			assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(),"ADCA");
			assertTrue("Must be an immediate addressing mode", adcInstruction.getOperand() instanceof ImmediatOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check ADCA direct mode 
	 */
	@Test 
	public void testADCADirectAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       ADCA		  	<124\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an ADC directive line", instructionLine.getInstruction() instanceof AdcInstruction);
	
			AdcInstruction adcInstruction = (AdcInstruction)instructionLine.getInstruction();
			assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(),"ADCA");
			assertTrue("Must be a direct addressing mode", adcInstruction.getOperand() instanceof DirectOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check ADCA extended mode 
	 */
	@Test 
	public void testADCAExtendedAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       ADCA		  	$1234\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an ADC directive line", instructionLine.getInstruction() instanceof AdcInstruction);
	
			AdcInstruction adcInstruction = (AdcInstruction)instructionLine.getInstruction();
			assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(),"ADCA");
			assertTrue("Must be a extended addressing mode", adcInstruction.getOperand() instanceof ExtendedOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check ADCA extended mode 
	 */
	@Test 
	public void testADCAExtendedAddressingMode2() {
		StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("		; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       ADCA		  	>$1234\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an ADC directive line", instructionLine.getInstruction() instanceof AdcInstruction);
	
			AdcInstruction adcInstruction = (AdcInstruction)instructionLine.getInstruction();
			assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(),"ADCA");
			assertTrue("Must be a extended addressing mode", adcInstruction.getOperand() instanceof ExtendedOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check ADCA extended indirect mode 
	 */
	@Test 
	public void testADCAExtendedIndirectAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       ADCA		  	[$1234]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an ADC directive line", instructionLine.getInstruction() instanceof AdcInstruction);
	
			AdcInstruction adcInstruction = (AdcInstruction)instructionLine.getInstruction();
			assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(),"ADCA");
			assertTrue("Must be a extended indirect addressing mode", adcInstruction.getOperand() instanceof ExtendedIndirectOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check ADCA Constant-Offset Indexed 
	 */
	@Test 
	public void testADCAConstantOffsetIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("	       	ADCA		  	Const,X\n");
		strBuilder.append("			ADCA		  	,X\n");
		strBuilder.append("			ADCA		  	$9,U\n");
		strBuilder.append("			ADCA		  	$9,S\n");
		strBuilder.append("			ADCA		  	$9,X\n");
		strBuilder.append("			ADCA		  	$9,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		
			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an ADC directive line", instructionLine.getInstruction() instanceof AdcInstruction);
	
			AdcInstruction adcInstruction = (AdcInstruction)instructionLine.getInstruction();
			assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(),"ADCA");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand)adcInstruction.getOperand();
			assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.getMode() instanceof ConstantIndexedMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check ADCA Constant-Offset Indexed indirect 
	 */
	@Test 
	public void testADCAConstantOffsetIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("	       	ADCA		  	[Const,X]\n");
		strBuilder.append("			ADCA		  	[,X]\n");
		strBuilder.append("			ADCA		  	[$9,U]\n");
		strBuilder.append("			ADCA		  	[$9,S]\n");
		strBuilder.append("			ADCA		  	[$9,X]\n");
		strBuilder.append("			ADCA		  	[$9,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		
			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an ADC directive line", instructionLine.getInstruction() instanceof AdcInstruction);
	
			AdcInstruction adcInstruction = (AdcInstruction)instructionLine.getInstruction();
			assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(),"ADCA");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand)adcInstruction.getOperand();
			assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.getMode() instanceof ConstantIndexedMovingIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check ADCA Accumulator Indexed 
	 */
	@Test 
	public void testADCAAccumulatorIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("	       	ADCA		  	A,X\n");
		strBuilder.append("			ADCA		  	B,X\n");
		strBuilder.append("			ADCA		  	D,U\n");
		strBuilder.append("			ADCA		  	A,S\n");
		strBuilder.append("			ADCA		  	B,X\n");
		strBuilder.append("			ADCA		  	D,Y\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		
			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an ADC directive line", instructionLine.getInstruction() instanceof AdcInstruction);
	
			AdcInstruction adcInstruction = (AdcInstruction)instructionLine.getInstruction();
			assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(),"ADCA");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand)adcInstruction.getOperand();
			assertTrue("Must be a Accumulator Indexed mode", indexedOperand.getMode() instanceof AccumulatorMovingMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check ADCA Accumulator Indexed Indirect
	 */
	@Test 
	public void testADCAAccumulatorIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("	       	ADCA		  	[A,X]\n");
		strBuilder.append("			ADCA		  	[B,X]\n");
		strBuilder.append("			ADCA		  	[D,U]\n");
		strBuilder.append("			ADCA		  	[A,S]\n");
		strBuilder.append("			ADCA		  	[B,X]\n");
		strBuilder.append("			ADCA		  	[D,Y]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		
			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an ADC directive line", instructionLine.getInstruction() instanceof AdcInstruction);
	
			AdcInstruction adcInstruction = (AdcInstruction)instructionLine.getInstruction();
			assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(),"ADCA");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand)adcInstruction.getOperand();
			assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.getMode() instanceof AccumulatorMovingIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check ADCA Auto-Increment Indexed 
	 */
	@Test 
	public void testADCAAutoIncrementIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("	       	ADCA		  	,--X\n");
		strBuilder.append("	       	ADCA		  	,-X\n");
		strBuilder.append("	       	ADCA		  	,X+\n");
		strBuilder.append("	       	ADCA		  	,X++\n");
		strBuilder.append("	       	ADCA		  	,--S\n");
		strBuilder.append("	       	ADCA		  	,-S\n");
		strBuilder.append("	       	ADCA		  	,U+\n");
		strBuilder.append("	       	ADCA		  	,U++\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		
			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an ADC directive line", instructionLine.getInstruction() instanceof AdcInstruction);
	
			AdcInstruction adcInstruction = (AdcInstruction)instructionLine.getInstruction();
			assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(),"ADCA");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand)adcInstruction.getOperand();
			assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.getMode() instanceof AutoIncDecMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}


	/**
	 * Check ADCA Auto-Increment Indexed Indirect
	 */
	@Test 
	public void testADCAAutoIncrementIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("	       	ADCA		  	[,--X]\n");
		strBuilder.append("	       	ADCA		  	[,X++]\n");
		strBuilder.append("	       	ADCA		  	[,--S]\n");
		strBuilder.append("	       	ADCA		  	[,U++]\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		
			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an ADC directive line", instructionLine.getInstruction() instanceof AdcInstruction);
	
			AdcInstruction adcInstruction = (AdcInstruction)instructionLine.getInstruction();
			assertEquals("Must be an ADCA instruction", adcInstruction.getInstruction(),"ADCA");
			assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.getOperand() instanceof IndexedOperand);
			IndexedOperand indexedOperand = (IndexedOperand)adcInstruction.getOperand();
			assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.getMode() instanceof AutoIncDecIndirectMode);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check ADCA Relative to PC Indexed 
	 */
//	@Test 
//	public void testADCARelativePCIndexed() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//			       	ORG    			$8000
//		Const	   	EQU          	5    
//			       	ADCA		  	0,PC
//			       	ADCA		  	,PC
//			       	ADCA		  	Const,PC
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		val errors = result.eResource.errors
//		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
//		
//		val line = result.sourceLines.get(3)
//		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
//		
//		val instructionLine = line.lineContent as InstructionLine
//		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof AdcInstruction)
//
//		val adcInstruction = instructionLine.instruction as AdcInstruction
//		assertEquals("Must be an ADCA instruction", adcInstruction.instruction,"ADCA")
//		assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.operand instanceof IndexedOperand)
//		val indexedOperand = adcInstruction.operand as IndexedOperand
//		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
//	}
	
	/**
	 * Check ADCA Relative to PC Indexed Indirect 
	 */
//	@Test 
//	public void testADCARelativePCIndexedIndirect() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//			       	ORG    			$8000
//		Const	   	EQU          	5    
//			       	ADCA		  	[0,PC]
//			       	ADCA		  	[,PC]
//			       	ADCA		  	[Const,PC]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		val errors = result.eResource.errors
//		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
//		
//		val line = result.sourceLines.get(3)
//		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
//		
//		val instructionLine = line.lineContent as InstructionLine
//		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof AdcInstruction)
//
//		val adcInstruction = instructionLine.instruction as AdcInstruction
//		assertEquals("Must be an ADCA instruction", adcInstruction.instruction,"ADCA")
//		assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.operand instanceof IndexedOperand)
//		val indexedOperand = adcInstruction.operand as IndexedOperand
//		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
//	}
	
	/**
	 * Check ADCA instruction with duplicate label 
	 */
//	@Test 
//	public void testADCAWithDuplicateLabel() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start		NOP
//					NOP    
//		Start      	ADCA		  	#Const+2
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(AssemblerPackage.eINSTANCE.instructionLine,
//			AssemblerEngine::DUPLICATE_LABEL,
//			"Label Start is already publicined"
//		)
//	}
	
	/**
	 * Check Assembled ADCA immediate instruction  
	 */
//	@Test 
//	public void testADCAImmediatInstruction1() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	#Const+2  ; 8000   89 07        START:    ADCA
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0x89, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x07, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   89 07        START:    ADCA", line.comment)	
//	}
	
	/**
	 * Check Assembled ADCA immediate with limit negative operand  
	 */
//	@Test 
//	public void testADCAImmediatInstruction2() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	#-129
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(AssemblerPackage.eINSTANCE.adcInstruction,
//			ExpressionParser::OVERFLOW_ERROR,	
//			"The value -129 is below the possible limit, data may be lost"
//		)
//		val engine = AssemblerEngine.instance
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
//	}
	
	/**
	 * Check Assembled ADCA immediate with limit negative operand  
	 */
//	@Test 
//	public void testADCAImmediatInstruction3() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	#-128
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		val engine = AssemblerEngine.instance
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
//	}

	/**
	 * Check Assembled ADCA immediate with positive limit operand  
	 */
//	@Test 
//	public void testADCAImmediatInstruction4() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	#127
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		val engine = AssemblerEngine.instance
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
//	}

	/**
	 * Check Assembled ADCA immediate with positive limit operand  
	 */
//	@Test 
//	public void testADCAImmediatInstruction5() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	#128
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(AssemblerPackage.eINSTANCE.adcInstruction,
//			ExpressionParser::OVERFLOW_ERROR,	
//			"The value 128 is greater than the possible limit, data may be lost"
//		)
//		val engine = AssemblerEngine.instance
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
//	}
	
	/**
	 * Check Assembled ADCA direct mode instruction  
	 */
//	@Test 
//	public void testADCADirectInstruction1() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	<Const*2  ; 8000   99 0A        START:    ADCA   <Const*2 
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0x99, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x0A, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   99 0A        START:    ADCA   <Const*2 ", line.comment)	
//	}
	
	/**
	 * Check Assembled ADCA direct with limit negative operand  
	 */
//	@Test 
//	public void testADCADirectInstruction2() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	<-129
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(AssemblerPackage.eINSTANCE.adcInstruction,
//			ExpressionParser::OVERFLOW_ERROR,	
//			"The value -129 is below the possible limit, data may be lost"
//		)
//		val engine = AssemblerEngine.instance
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
//	}
	
	/**
	 * Check Assembled ADCA direct with limit negative operand  
	 */
//	@Test 
//	public void testADCADirectInstruction3() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	<-128
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		val engine = AssemblerEngine.instance
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
//	}

	/**
	 * Check Assembled ADCA direct with positive limit operand  
	 */
//	@Test 
//	public void testADCADirectInstruction4() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	<127
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		val engine = AssemblerEngine.instance
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
//	}

	/**
	 * Check Assembled ADCA direct with positive limit operand  
	 */
//	@Test 
//	public void testADCADirectInstruction5() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	<128
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(AssemblerPackage.eINSTANCE.adcInstruction,
//			ExpressionParser::OVERFLOW_ERROR,	
//			"The value 128 is greater than the possible limit, data may be lost"
//		)
//		val engine = AssemblerEngine.instance
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
//	}
	
	/**
	 * Check Assembled ADCA extended mode instruction  
	 */
//	@Test 
//	public void testADCAExtendedInstruction1() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	>Const*1000  ; 8000   B9 13 88     START:    ADCA   >Const*1000 
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xB9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   B9 13 88     START:    ADCA   >Const*1000 ", line.comment)	
//	}
	
	/**
	 * Check Assembled ADCA extended with limit negative operand  
	 */
//	@Test 
//	public void testADCAExtendedInstruction2() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	>-32769
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(AssemblerPackage.eINSTANCE.adcInstruction,
//			ExpressionParser::OVERFLOW_ERROR,	
//			"The value -32769 is below the possible limit, data may be lost"
//		)
//		val engine = AssemblerEngine.instance
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
//	}
	
	/**
	 * Check Assembled ADCA extended with limit negative operand  
	 */
//	@Test 
//	public void testADCAExtendedInstruction3() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	>-32768
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		val engine = AssemblerEngine.instance
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
//	}

	/**
	 * Check Assembled ADCA extended with positive limit operand  
	 */
//	@Test 
//	public void testADCAExtendedInstruction4() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	>65535
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		val engine = AssemblerEngine.instance
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
//	}

	/**
	 * Check Assembled ADCA extended with positive limit operand  
	 */
//	@Test 
//	public void testADCAExtendedInstruction5() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	>65536
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(AssemblerPackage.eINSTANCE.adcInstruction,
//			ExpressionParser::OVERFLOW_ERROR,	
//			"The value 65536 is greater than the possible limit, data may be lost"
//		)
//		val engine = AssemblerEngine.instance
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
//	}
	
	/**
	 * Check Assembled ADCA extended indirect mode instruction  
	 */
//	@Test 
//	public void testADCAExtendedIndirectInstruction1() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[Const*1000]  ; 8000   A9 9F 13 88  START:    ADCA   [Const*1000]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check opcode", 0x9F, line.opcode.get(1));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   A9 9F 13 88  START:    ADCA   [Const*1000]", line.comment)	
//	}
	
	/**
	 * Check Assembled ADCA extended indirect with limit negative operand  
	 */
//	@Test 
//	public void testADCAExtendedIndirectInstruction2() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-32769]
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(AssemblerPackage.eINSTANCE.adcInstruction,
//			ExpressionParser::OVERFLOW_ERROR,	
//			"The value -32769 is below the possible limit, data may be lost"
//		)
//		val engine = AssemblerEngine.instance
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
//	}
	
	/**
	 * Check Assembled ADCA extended indirect with limit negative operand  
	 */
//	@Test 
//	public void testADCAExtendedIndirectInstruction3() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-32768]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		val engine = AssemblerEngine.instance
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
//	}

	/**
	 * Check Assembled ADCA extended indirect with positive limit operand  
	 */
//	@Test 
//	public void testADCAExtendedIndirectInstruction4() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[65535]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		val engine = AssemblerEngine.instance
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
//	}

	/**
	 * Check Assembled ADCA extended indirect with positive limit operand  
	 */
//	@Test 
//	public void testADCAExtendedIndirectInstruction5() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[65536]
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(AssemblerPackage.eINSTANCE.adcInstruction,
//			ExpressionParser::OVERFLOW_ERROR,	
//			"The value 65536 is greater than the possible limit, data may be lost"
//		)
//		val engine = AssemblerEngine.instance
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
//	}
	
	/**
	 * Check Assembled ADCA Indexed Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAccumulatorMovingMode1() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	A,X  ; 8000   A9 86        START:    ADCA   A,X
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x86, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   A9 86        START:    ADCA   A,X", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAccumulatorMovingMode2() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	A,Y  ; 8000   	A9 A6        START:    ADCA   A,Y
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xA6, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 A6        START:    ADCA   A,Y", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAccumulatorMovingMode3() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	A,U  ; 8000   	A9 C6        START:    ADCA   A,U
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xC6, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 C6        START:    ADCA   A,U", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAccumulatorMovingMode4() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	A,S  ; 8000   	A9 E6        START:    ADCA   A,S
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xE6, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 E6        START:    ADCA   A,S", line.comment)	
//	}
	
	/**
	 * Check Assembled ADCA Indexed Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAccumulatorMovingMode5() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	B,X  ; 8000   A9 85        START:    ADCA   B,X
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x85, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   A9 85        START:    ADCA   B,X", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAccumulatorMovingMode6() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	B,Y  ; 8000   	A9 A5        START:    ADCA   B,Y
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xA5, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 A5        START:    ADCA   B,Y", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAccumulatorMovingMode7() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	B,U  ; 8000   	A9 C5        START:    ADCA   B,U
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xC5, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 C5        START:    ADCA   B,U", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAccumulatorMovingMode8() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	B,S  ; 8000   	A9 E5        START:    ADCA   B,S
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xE5, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 E5        START:    ADCA   B,S", line.comment)	
//	}
	
	/**
	 * Check Assembled ADCA Indexed Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAccumulatorMovingMode9() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	D,X  ; 8000   A9 8B        START:    ADCA   D,X
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x8B, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   A9 8B        START:    ADCA   D,X", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAccumulatorMovingMode10() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	D,Y  ; 8000   	A9 AB        START:    ADCA   D,Y
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xAB, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 AB        START:    ADCA   D,Y", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAccumulatorMovingMode11() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	D,U  ; 8000   	A9 CB        START:    ADCA   D,U
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xCB, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 CB        START:    ADCA   D,U", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAccumulatorMovingMode12() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	D,S  ; 8000   	A9 EB        START:    ADCA   D,S
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xEB, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 EB        START:    ADCA   D,S", line.comment)	
//	}
	
	/**
	 * Check Assembled ADCA Indexed indirect Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedIndorectAccumulatorMovingMode1() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[A,X]  ; 8000   A9 96        START:    ADCA   [A,X]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x96, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   A9 96        START:    ADCA   [A,X]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Indirect Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedIndirectAccumulatorMovingMode2() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[A,Y]  ; 8000   	A9 B6        START:    ADCA   [A,Y]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xB6, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 B6        START:    ADCA   [A,Y]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Indirect Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedIndirectAccumulatorMovingMode3() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[A,U]  ; 8000   	A9 D6        START:    ADCA   [A,U]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xD6, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 D6        START:    ADCA   [A,U]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Indirect Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedIndirectAccumulatorMovingMode4() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[A,S]  ; 8000   	A9 F6        START:    ADCA   [A,S]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xF6, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 F6        START:    ADCA   [A,S]", line.comment)	
//	}
	
	/**
	 * Check Assembled ADCA Indexed Indirect Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedIndirectAccumulatorMovingMode5() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[B,X]  ; 8000   A9 95        START:    ADCA   [B,X]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x95, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   A9 95        START:    ADCA   [B,X]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Indirect Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedIndirectAccumulatorMovingMode6() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[B,Y]  ; 8000   	A9 B5        START:    ADCA   [B,Y]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xB5, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 B5        START:    ADCA   [B,Y]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Indirect Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedIndirectAccumulatorMovingMode7() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[B,U]  ; 8000   	A9 D5        START:    ADCA   [B,U]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xD5, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 D5        START:    ADCA   [B,U]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Indirect Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedIndirectAccumulatorMovingMode8() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[B,S]  ; 8000   	A9 F5        START:    ADCA   [B,S]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xF5, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 F5        START:    ADCA   [B,S]", line.comment)	
//	}
	
	/**
	 * Check Assembled ADCA Indexed Indirect Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedIndirectAccumulatorMovingMode9() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[D,X]  ; 8000   A9 9B        START:    ADCA   [D,X]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x9B, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   A9 9B        START:    ADCA   [D,X]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed indirect Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedIndirectAccumulatorMovingMode10() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[D,Y]  ; 8000   	A9 BB        START:    ADCA   [D,Y]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xBB, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 BB        START:    ADCA   [D,Y]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Indirect Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedIndirectAccumulatorMovingMode11() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[D,U]  ; 8000   	A9 DB        START:    ADCA   [D,U]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xDB, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 DB        START:    ADCA   [D,U]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed indirect Accumulator Moving Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedIndirectAccumulatorMovingMode12() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[D,S]  ; 8000   	A9 FB        START:    ADCA   [D,S]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xFB, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 FB        START:    ADCA   [D,S]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementMode1() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	,X+  ; 8000   	A9 80        START:    ADCA   ,X+
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 80        START:    ADCA   ,X+", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementMode2() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	,X++  ; 8000   	A9 81        START:    ADCA   ,X++
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x81, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 81        START:    ADCA   ,X++", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementMode3() {
//		StringBuilder strBuilder = new StringBuilder();
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	,Y+  ; 8000   	A9 A0        START:    ADCA   ,Y+
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xA0, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 A0        START:    ADCA   ,Y+", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementMode4() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	,Y++  ; 8000   	A9 A1        START:    ADCA   ,Y++
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xA1, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 A1        START:    ADCA   ,Y++", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementMode5() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	,S+  ; 8000   	A9 E0        START:    ADCA   ,S+
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xE0, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 E0        START:    ADCA   ,S+", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementMode6() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	,S++  ; 8000   	A9 E1        START:    ADCA   ,S++
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xE1, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 E1        START:    ADCA   ,S++", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementMode7() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	,U+  ; 8000   	A9 C0        START:    ADCA   ,U+
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xC0, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 C0        START:    ADCA   ,U+", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementMode8() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	,U++  ; 8000   	A9 C1        START:    ADCA   ,U++
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xC1, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 C1        START:    ADCA   ,U++", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementMode9() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	,-X  ; 8000   	A9 82        START:    ADCA   ,-X
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x82, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 82        START:    ADCA   ,-X", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementMode10() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	,--X  ; 8000   	A9 83        START:    ADCA   ,--X
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x83, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 83        START:    ADCA   ,--X", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementMode11() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	,-Y  ; 8000   	A9 A2        START:    ADCA   ,-Y
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xA2, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 A2        START:    ADCA   ,-Y", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementMode12() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	,--Y  ; 8000   	A9 A3        START:    ADCA   ,--Y
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xA3, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 A3        START:    ADCA   ,--Y", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementMode13() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	,-S  ; 8000   	A9 E2        START:    ADCA   ,-S
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xE2, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 E2        START:    ADCA   ,-S", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementMode14() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	,--S  ; 8000   	A9 E3        START:    ADCA   ,--S
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xE3, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 E3        START:    ADCA   ,--S", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementMode15() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	,-U  ; 8000   	A9 C2        START:    ADCA   ,-U
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xC2, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 C2        START:    ADCA   ,-U", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementMode16() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	,--U  ; 8000   	A9 C3        START:    ADCA   ,--U
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xC3, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 C3        START:    ADCA   ,--U", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementIndirectMode1() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[,X+]  ; 8000   	A9 80        START:    ADCA   ,X+
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
//			"Cannot use post increment with 1 for indirect mode"
//		)
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Mode indorect instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementIndirectMode2() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[,X++]  ; 8000   	A9 91        START:    ADCA   [,X++]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x91, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 91        START:    ADCA   [,X++]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Mode indirect instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementIndirectMode3() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[,Y+]  ; 8000   	A9 A0        START:    ADCA   ,Y+
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
//			"Cannot use post increment with 1 for indirect mode"
//		)
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementIndirectMode4() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[,Y++]  ; 8000   	A9 B1        START:    ADCA   [,Y++]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xB1, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 B1        START:    ADCA   [,Y++]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementIndirectMode5() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[,S+]  ; 8000   	A9 E0        START:    ADCA   [,S+]
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
//			"Cannot use post increment with 1 for indirect mode"
//		)
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementIndirectMode6() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[,S++]  ; 8000   	A9 F1        START:    ADCA   [,S++]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xF1, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 F1        START:    ADCA   [,S++]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementIndirectMode7() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[,U+]  ; 8000   	A9 C0        START:    ADCA   [,U+]
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
//			"Cannot use post increment with 1 for indirect mode"
//		)
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementindirectMode8() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[,U++]  ; 8000   	A9 D1        START:    ADCA   [,U++]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xD1, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 D1        START:    ADCA   [,U++]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementIndirectMode9() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[,-X]  ; 8000   	A9 82        START:    ADCA   [,-X]
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
//			"Cannot use pre decrement with 1 for indirect mode"
//		)
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementIndirectMode10() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[,--X]  ; 8000   	A9 93        START:    ADCA   [,--X]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x93, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 93        START:    ADCA   [,--X]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement INdirect Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementIndirectMode11() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[,-Y]  ; 8000   	A9 A2        START:    ADCA   [,-Y]
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
//			"Cannot use pre decrement with 1 for indirect mode"
//		)
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementIndirectMode12() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[,--Y]  ; 8000   	A9 B3        START:    ADCA   [,--Y]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xB3, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 B3        START:    ADCA   [,--Y]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementIndirectMode13() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[,-S]  ; 8000   	A9 E2        START:    ADCA   [,-S]
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
//			"Cannot use pre decrement with 1 for indirect mode"
//		)
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementIndirectMode14() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[,--S]  ; 8000   	A9 F3        START:    ADCA   [,--S]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xF3, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 F3        START:    ADCA   [,--S]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement indirect Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementIndirectMode15() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[,-U]  ; 8000   	A9 C2        START:    ADCA   [,-U]
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
//			"Cannot use pre decrement with 1 for indirect mode"
//		)
//	}

	/**
	 * Check Assembled ADCA Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedAutoIncrementDecrementIndirectMode16() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Const	   	EQU          	5
//		Start      	ADCA		  	[,--U]  ; 8000   	A9 D3        START:    ADCA   [,--U]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(3) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xD3, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 D3        START:    ADCA   [,--U]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove1() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	1234,X  ; 8000   	A9 89 04 D2            ADCA   1234,X
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 89 04 D2            ADCA   1234,X", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove2() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	1234,Y  ; 8000   	A9 A9 04 D2            ADCA   1234,Y
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 A9 04 D2            ADCA   1234,Y", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove3() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	1234,U  ; 8000   	A9 C9 04 D2            ADCA   1234,U
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 C9 04 D2            ADCA   1234,U", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove4() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	1234,S  ; 8000   	A9 E9 04 D2            ADCA   1234,S
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 E9 04 D2            ADCA   1234,S", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove5() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	34,X  ; 8000   	A9 88 22            ADCA   34,X
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 88 22            ADCA   34,X", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove6() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	34,Y  ; 8000   	A9 A8 22            ADCA   34,Y
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 A8 22            ADCA   34,Y", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove7() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	34,U  ; 8000   	A9 C8 22            ADCA   34,U
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 C8 22            ADCA   34,U", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove8() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	34,S  ; 8000   	A9 E8 22            ADCA   34,S
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 E8 22            ADCA   34,S", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove9() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	,X  ; 8000   	A9 84            ADCA   ,X
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 84            ADCA   ,X", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove10() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	,Y  ; 8000   	A9 A4            ADCA   ,Y
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 A4            ADCA   ,Y", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove11() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	,U  ; 8000   	A9 C4            ADCA   ,U
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 C4            ADCA   ,U", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove12() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	,S  ; 8000   	A9 E4            ADCA   ,S
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 E4            ADCA   ,S", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove13() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	0,X  ; 8000   	A9 84            ADCA   0,X
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 84            ADCA   0,X", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove14() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	0,Y  ; 8000   	A9 A4            ADCA   0,Y
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 A4            ADCA   0,Y", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove15() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	0,U  ; 8000   	A9 C4            ADCA   0,U
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 C4            ADCA   0,U", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove16() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	0,S  ; 8000   	A9 E4            ADCA   0,S
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 E4            ADCA   0,S", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove17() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-16,X  ; 8000   	A9 10            ADCA   -16,X
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x10, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 10            ADCA   -16,X", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove19() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	1,X  ; 8000   	A9 01            ADCA   1,X
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x01, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 01            ADCA   1,X", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove20() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	15,X  ; 8000   	A9 0F            ADCA   15,X
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x0F, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 0F            ADCA   15,X", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove21() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-16,Y  ; 8000   	A9 30            ADCA   -16,Y
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x30, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 30            ADCA   -16,Y", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove23() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	1,Y  ; 8000   	A9 21            ADCA   1,Y
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x21, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 21            ADCA   1,Y", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove24() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	15,Y  ; 8000   	A9 2F            ADCA   15,Y
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x2F, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 2F            ADCA   15,Y", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove25() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-16,U  ; 8000   	A9 50            ADCA   -16,U
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x50, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 50            ADCA   -16,U", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove26() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	1,U  ; 8000   	A9 41            ADCA   1,U
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x41, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 41            ADCA   1,U", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove27() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	15,U  ; 8000   	A9 4F            ADCA   15,U
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x4F, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 4F            ADCA   15,U", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove28() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-16,S  ; 8000   	A9 70            ADCA   -16,S
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x70, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 70            ADCA   -16,S", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove29() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	1,S  ; 8000   	A9 61            ADCA   1,S
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x61, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 61            ADCA   1,S", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove30() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	15,S  ; 8000   	A9 6F            ADCA   15,S
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x6F, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 6F            ADCA   15,S", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove31() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-128,X  ; 8000   	A9 88 80            ADCA   -128,X
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 88 80            ADCA   -128,X", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove32() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	127,X  ; 8000   	A9 88 7F            ADCA   127,X
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 88 7F            ADCA   127,X", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove33() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-128,Y  ; 8000   	A9 A8 80            ADCA   -128,Y
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 A8 80            ADCA   -128,Y", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove34() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	127,Y  ; 8000   	A9 A8 7F            ADCA   127,Y
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 A8 7F            ADCA   127,Y", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove35() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-128,U  ; 8000   	A9 C8 80            ADCA   -128,U
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 C8 80            ADCA   -128,U", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove36() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	127,U  ; 8000   	A9 C8 7F            ADCA   127,U
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 C8 7F            ADCA   127,U", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove37() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-128,S  ; 8000   	A9 E8 80            ADCA   -128,S
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 E8 80            ADCA   -128,S", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove38() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	127,S  ; 8000   	A9 E8 7F            ADCA   127,S
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 E8 7F            ADCA   127,S", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove39() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-32768,X  ; 8000   	A9 89 80 00             ADCA   -32768,X
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 89 80 00             ADCA   -32768,X", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove40() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  32767,X  ; 8000   	A9 89 7F FF             ADCA   32767,X
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 89 7F FF             ADCA   32767,X", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove41() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-32768,Y  ; 8000   	A9 A9 80 00             ADCA   -32768,Y
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 A9 80 00             ADCA   -32768,Y", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove42() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  32767,Y  ; 8000   	A9 A9 7F FF             ADCA   32767,Y
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 A9 7F FF             ADCA   32767,Y", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove43() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-32768,U  ; 8000   	A9 C9 80 00             ADCA   -32768,U
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 C9 80 00             ADCA   -32768,U", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove44() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  32767,U  ; 8000   	A9 C9 7F FF             ADCA   32767,U
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 C9 7F FF             ADCA   32767,U", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove45() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-32768,S  ; 8000   	A9 E9 80 00             ADCA   -32768,S
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 E9 80 00             ADCA   -32768,S", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove46() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  32767,S  ; 8000   	A9 E9 7F FF             ADCA   32767,S
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 E9 7F FF             ADCA   32767,S", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove47() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-32769,X  ; 8000   	A9 89 80 00             ADCA   -32769,X
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"Overflow detected for value -32769 , data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 89 80 00             ADCA   -32769,X", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove48() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  32768,X  ; 8000   	A9 89 7F FF             ADCA   32768,X
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"Overflow detected for value 32768 , data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 89 7F FF             ADCA   32768,X", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove49() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-32769,Y  ; 8000   	A9 A9 80 00             ADCA   -32769,Y
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"Overflow detected for value -32769 , data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 A9 80 00             ADCA   -32769,Y", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove50() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  32768,Y  ; 8000   	A9 A9 7F FF             ADCA   32768,Y
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"Overflow detected for value 32768 , data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 A9 7F FF             ADCA   32768,Y", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove51() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-32769,U  ; 8000   	A9 C9 80 00             ADCA   -32769,U
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"Overflow detected for value -32769 , data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 C9 80 00             ADCA   -32769,U", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove52() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  32768,U  ; 8000   	A9 C9 7F FF             ADCA   32768,U
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"Overflow detected for value 32768 , data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 C9 7F FF             ADCA   32768,U", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove53() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-32769,S  ; 8000   	A9 E9 80 00             ADCA   -32769,S
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"Overflow detected for value -32769 , data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 E9 80 00             ADCA   -32769,S", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantMove54() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  32768,S  ; 8000   	A9 E9 7F FF             ADCA   32768,S
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"Overflow detected for value 32768 , data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 E9 7F FF             ADCA   32768,S", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove1() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[1234,X]  ; 8000   	A9 99 04 D2            ADCA   [1234,X]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 99 04 D2            ADCA   [1234,X]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove2() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[1234,Y]  ; 8000   	A9 B9 04 D2            ADCA   [1234,Y]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 B9 04 D2            ADCA   [1234,Y]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove3() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[1234,U]  ; 8000   	A9 D9 04 D2            ADCA   [1234,U]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 D9 04 D2            ADCA   [1234,U]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove4() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[1234,S]  ; 8000   	A9 F9 04 D2            ADCA   [1234,S]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 F9 04 D2            ADCA   [1234,S]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove5() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[34,X]  ; 8000   	A9 98 22            ADCA   [34,X]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 98 22            ADCA   [34,X]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove6() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[34,Y]  ; 8000   	A9 B8 22            ADCA   [34,Y]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 B8 22            ADCA   [34,Y]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove7() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[34,U]  ; 8000   	A9 D8 22            ADCA   [34,U]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 D8 22            ADCA   [34,U]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove8() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[34,S]  ; 8000   	A9 F8 22            ADCA   [34,S]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 F8 22            ADCA   [34,S]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove9() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[,X]  ; 8000   	A9 94            ADCA   [,X]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 94            ADCA   [,X]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove10() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[,Y]  ; 8000   	A9 B4            ADCA   [,Y]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 B4            ADCA   [,Y]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove11() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[,U]  ; 8000   	A9 D4            ADCA   [,U]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 D4            ADCA   [,U]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove12() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[,S]  ; 8000   	A9 F4            ADCA   [,S]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 F4            ADCA   [,S]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove13() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[0,X]  ; 8000   	A9 94            ADCA   [0,X]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 94            ADCA   [0,X]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove14() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[0,Y]  ; 8000   	A9 B4            ADCA   [0,Y]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 B4            ADCA   [0,Y]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove15() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[0,U]  ; 8000   	A9 D4            ADCA   [0,U]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 D4            ADCA   [0,U]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove16() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[0,S]  ; 8000   	A9 F4            ADCA   [0,S]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 F4            ADCA   [0,S]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove17() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-16,X]  ; 8000   	A9 98 F0            ADCA   [-16,X]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 98 F0            ADCA   [-16,X]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove18() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[15,X]  ; 8000   	A9 98 0F            ADCA   [15,X]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 98 0F            ADCA   [15,X]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove19() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-16,Y]  ; 8000   	A9 B8 F0            ADCA   [-16,Y]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 B8 F0            ADCA   [-16,Y]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove20() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[15,Y]  ; 8000   	A9 B8 0F            ADCA   [15,Y]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 B8 0F            ADCA   [15,Y]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove21() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-16,U]  ; 8000   	A9 D8 F0            ADCA   [-16,U]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 D8 F0            ADCA   [-16,U]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove22() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[15,U]  ; 8000   	A9 D8 0F            ADCA   [15,U]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 D8 0F            ADCA   [15,U]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove23() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-16,S]  ; 8000   	A9 F8 F0            ADCA   [-16,S]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 F8 F0            ADCA   [-16,S]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove24() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[15,S]  ; 8000   	A9 F8 0F            ADCA   [15,S]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 F8 0F            ADCA   [15,S]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove31() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-128,X]  ; 8000   	A9 98 80            ADCA   [-128,X}
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 98 80            ADCA   [-128,X}", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove32() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[127,X]  ; 8000   	A9 98 7F            ADCA   [127,X]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 98 7F            ADCA   [127,X]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove33() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-128,Y]  ; 8000   	A9 B8 80            ADCA   [-128,Y]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 B8 80            ADCA   [-128,Y]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove34() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[127,Y]  ; 8000   	A9 B8 7F            ADCA   [127,Y]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 B8 7F            ADCA   [127,Y]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove35() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-128,U]  ; 8000   	A9 D8 80            ADCA   [-128,U]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 D8 80            ADCA   [-128,U]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant INdirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove36() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[127,U]  ; 8000   	A9 D8 7F            ADCA   [127,U]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 D8 7F            ADCA   [127,U]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove37() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-128,S]  ; 8000   	A9 F8 80            ADCA   [-128,S]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 F8 80            ADCA   [-128,S]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove38() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[127,S]  ; 8000   	A9 F8 7F            ADCA   [127,S]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 F8 7F            ADCA   [127,S]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove39() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-32768,X]  ; 8000   	A9 99 80 00             ADCA   [-32768,X]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 99 80 00             ADCA   [-32768,X]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove40() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  [32767,X]  ; 8000   	A9 99 7F FF             ADCA   [32767,X]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 99 7F FF             ADCA   [32767,X]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove41() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-32768,Y]  ; 8000   	A9 B9 80 00             ADCA   [-32768,Y]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 B9 80 00             ADCA   [-32768,Y]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove42() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  [32767,Y]  ; 8000   	A9 B9 7F FF             ADCA   [32767,Y]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 B9 7F FF             ADCA   [32767,Y]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove43() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-32768,U]  ; 8000   	A9 D9 80 00             ADCA   [-32768,U]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 D9 80 00             ADCA   [-32768,U]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove44() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  [32767,U]  ; 8000   	A9 D9 7F FF             ADCA   [32767,U]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 D9 7F FF             ADCA   [32767,U]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove45() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-32768,S]  ; 8000   	A9 F9 80 00             ADCA   [-32768,S]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 F9 80 00             ADCA   [-32768,S]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove46() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  [32767,S]  ; 8000   	A9 F9 7F FF             ADCA   [32767,S]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 F9 7F FF             ADCA   [32767,S]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove47() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-32769,X]  ; 8000   	A9 99 80 00             ADCA   [-32769,X]
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"Overflow detected for value -32769 , data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 99 80 00             ADCA   [-32769,X]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove48() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  [32768,X]  ; 8000   	A9 99 7F FF             ADCA   [32768,X]
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"Overflow detected for value 32768 , data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 99 7F FF             ADCA   [32768,X]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove49() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-32769,Y]  ; 8000   	A9 B9 80 00             ADCA   [-32769,Y]
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"Overflow detected for value -32769 , data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 B9 80 00             ADCA   [-32769,Y]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove50() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  [32768,Y]  ; 8000   	A9 B9 7F FF             ADCA   [32768,Y]
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"Overflow detected for value 32768 , data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 B9 7F FF             ADCA   [32768,Y]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove51() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-32769,U]  ; 8000   	A9 D9 80 00             ADCA   [-32769,U]
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"Overflow detected for value -32769 , data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 D9 80 00             ADCA   [-32769,U]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove52() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  [32768,U]  ; 8000   	A9 D9 7F FF             ADCA   [32768,U]
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"Overflow detected for value 32768 , data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 D9 7F FF             ADCA   [32768,U]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove53() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-32769,S]  ; 8000   	A9 F9 80 00             ADCA   [-32769,S]
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"Overflow detected for value -32769 , data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 F9 80 00             ADCA   [-32769,S]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed Constant Indirect move Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedConstantIndirectMove54() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  [32768,S]  ; 8000   	A9 F9 7F FF             ADCA   [32768,S]
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"Overflow detected for value 32768 , data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 F9 7F FF             ADCA   [32768,S]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed relatif to PC Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedRelatifToPCMove1() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	0,PCR  ; 8000   	A9 8C 00            ADCA   0,PCR
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 8C 00            ADCA   0,PCR", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed relatif to PC Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedRelatifToPCMove2() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-128,PCR  ; 8000   	A9 8C 80            ADCA   -128,PCR
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 8C 80            ADCA   -128,PCR", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed relatif to PC Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedRelatifToPCMove3() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	127,PCR  ; 8000   	A9 8C 7F            ADCA   127,PCR
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 8C 7F            ADCA   127,PCR", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed relatif to PC Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedRelatifToPCMove4() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-129,PCR  ; 8000   	A9 8D FF 7F            ADCA   -129,PCR
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 8D FF 7F            ADCA   -129,PCR", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed relatif to PC Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedRelatifToPCMove5() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	128,PCR  ; 8000   	A9 8D 00 80            ADCA   128,PCR
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 8D 00 80            ADCA   128,PCR", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed relatif to PC Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedRelatifToPCMove6() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-32768,PCR  ; 8000   	A9 8D 80 00            ADCA   -32768,PCR
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 8D 80 00            ADCA   -32768,PCR", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed relatif to PC Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedRelatifToPCMove7() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	32767,PCR  ; 8000   	A9 8D 7F FF            ADCA   32767,PCR
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 8D 7F FF            ADCA   32767,PCR", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed relatif to PC Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedRelatifToPCMove8() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	-32769,PCR  ; 8000   	A9 8D 80 00            ADCA   -32769,PCR
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"The value -32769 is out than the possible limit, data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 8D 80 00            ADCA   -32769,PCR", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed relatif to PC Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedRelatifToPCMove9() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	32768,PCR  ; 8000   	A9 8D 7F FF            ADCA   32768,PCR
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"The value 32768 is out than the possible limit, data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 8D 7F FF            ADCA   32768,PCR", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed relatif indirect to PC Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedRelatifIndirectToPCMove1() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[0,PCR]  ; 8000   	A9 9C 00            ADCA   [0,PCR]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 9C 00            ADCA   [0,PCR]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed relatif indirect to PC Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedRelatifIndirectToPCMove2() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-128,PCR]  ; 8000   	A9 9C 80            ADCA   [-128,PCR]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 9C 80            ADCA   [-128,PCR]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed relatif indirect to PC Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedRelatifIndirectToPCMove3() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[127,PCR]  ; 8000   	A9 9C 7F            ADCA   [127,PCR]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 9C 7F            ADCA   [127,PCR]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed relatif indirect to PC Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedRelatifIndirectToPCMove4() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-129,PCR]  ; 8000   	A9 9D FF 7F            ADCA   [-129,PCR]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 9D FF 7F            ADCA   [-129,PCR]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed relatif indirect to PC Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedRelatifIndirectToPCMove5() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[128,PCR]  ; 8000   	A9 9D 00 80            ADCA   [128,PCR]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 9D 00 80            ADCA   [128,PCR]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed relatif indirect to PC Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedRelatifIndirectToPCMove6() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-32768,PCR]  ; 8000   	A9 9D 80 00            ADCA   [-32768,PCR]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 9D 80 00            ADCA   [-32768,PCR]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed relatif indirect to PC Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedRelatifIndirectToPCMove7() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[32767,PCR]  ; 8000   	A9 9D 7F FF            ADCA   [32767,PCR]
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 9D 7F FF            ADCA   [32767,PCR]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed relatif indirect to PC Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedRelatifIndirectToPCMove8() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//				   	ORG    			$8000
//		Start      	ADCA		  	[-32769,PCR]  ; 8000   	A9 9D 80 00            ADCA   [-32769,PCR]
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"The value -32769 is out than the possible limit, data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 9D 80 00            ADCA   [-32769,PCR]", line.comment)	
//	}

	/**
	 * Check Assembled ADCA Indexed relatif indirect to PC Mode instruction  
	 */
//	@Test 
//	public void testADCAIndexedRelatifIndirectToPCMove9() {
//		val result = parseHelper.parse('''
//				strBuilder.append("; -----------------------------------------\n");
//				strBuilder.append("		   	ORG    			$8000\n");
//				strBuilder.append("Start      	ADCA		  	[32768,PCR]  ; 8000   	A9 9D 7F FF            ADCA   [32768,PCR]\n");
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(
//			AssemblerPackage.eINSTANCE.adcInstruction,
//			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
//			"The value 32768 is out than the possible limit, data may be lost"
//		)
//		
//		val engine = AssemblerEngine.instance
//		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
//		
//		val line = engine.getAssembledLine(2) as AssembledADCAInstruction
//		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
//		Assert.assertEquals("Check opcode", 0xA9, line.opcode.get(0));	
//		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
//		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
//		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
//		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
//		Assert.assertEquals("Check Label", "Start", line.label)
//		Assert.assertEquals("Check comment", "; 8000   	A9 9D 7F FF            ADCA   [32768,PCR]", line.comment)	
//	}
}