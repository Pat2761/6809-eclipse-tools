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

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.CwaiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.ImmediatOperand;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCWAIInstruction;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
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
 
public class TestCWAIInstruction {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check CWAI immediat 
	 */
	@Test 
	public void testCWAIImemdiatAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       CWAI		  	#124\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);	
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an CWAI directive line", instructionLine.getInstruction() instanceof CwaiInstruction);
	
			CwaiInstruction cwaiInstruction = (CwaiInstruction)instructionLine.getInstruction();
			assertEquals("Must be an CWAI instruction", cwaiInstruction.getInstruction(),"CWAI");
			assertTrue("Must be an immediate addressing mode", cwaiInstruction.getOperand() instanceof ImmediatOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check CWAI direct mode 
	 */
	@Test 
	public void testCWAIDirectAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    		$8000\n");
		strBuilder.append("Label	   CWAI		  	<124       ; Illegal CWAI\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getCwaiInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Direct mode is not valid for the CWAI instruction"
			);	
			
			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
			
			AssembledCWAIInstruction line = (AssembledCWAIInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length); 
			Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]); 
			Assert.assertEquals("Check operand length", 0, line.getOperand().length); 
			Assert.assertEquals("Check label", "Label", line.getLabel()); 
			Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment()); 
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check CWAI extended mode 
	 */
	@Test 
	public void testCWAIExtendedAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    		$8000\n");
		strBuilder.append("Label      CWAI		  	$1234         ; Illegal CWAI\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getCwaiInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Extended mode is not valid for the CWAI instruction"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
			
			AssembledCWAIInstruction line = (AssembledCWAIInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length); 
			Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]); 
			Assert.assertEquals("Check operand length", 0, line.getOperand().length); 
			Assert.assertEquals("Check label", "Label", line.getLabel()); 
			Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment()); 
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check CWAI extended mode 
	 */
	@Test 
	public void testCWAIExtendedAddressingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    		$8000\n");
		strBuilder.append("Label      CWAI		  	>$1234         ; Illegal CWAI\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getCwaiInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Extended mode is not valid for the CWAI instruction"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
			
			AssembledCWAIInstruction line = (AssembledCWAIInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length); 
			Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]); 
			Assert.assertEquals("Check operand length", 0, line.getOperand().length); 
			Assert.assertEquals("Check label", "Label", line.getLabel()); 
			Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment()); 
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check CWAI extended indirect mode 
	 */
	@Test 
	public void testCWAIExtendedIndirectAddressingMode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    		$8000\n");
		strBuilder.append("Label      CWAI		  	[$1234]         ; Illegal CWAI\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getCwaiInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Indexed mode is not valid for the CWAI instruction"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
			
			AssembledCWAIInstruction line = (AssembledCWAIInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length); 
			Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]); 
			Assert.assertEquals("Check operand length", 0, line.getOperand().length); 
			Assert.assertEquals("Check label", "Label", line.getLabel()); 
			Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment()); 
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check CWAI Constant-Offset Indexed 
	 */
	@Test 
	public void testCWAIConstantOffsetIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("Label      	CWAI			  	Const,X         ; Illegal CWAI\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getCwaiInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Indexed mode is not valid for the CWAI instruction"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
			
			AssembledCWAIInstruction line = (AssembledCWAIInstruction)engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length); 
			Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]); 
			Assert.assertEquals("Check operand length", 0, line.getOperand().length); 
			Assert.assertEquals("Check label", "Label", line.getLabel()); 
			Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment()); 
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check CWAI Constant-Offset Indexed indirect 
	 */
	@Test 
	public void testCWAIConstantOffsetIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("Label      	CWAI			  	[Const,X]         ; Illegal CWAI\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getCwaiInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Indexed mode is not valid for the CWAI instruction"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
			
			AssembledCWAIInstruction line = (AssembledCWAIInstruction)engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length); 
			Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]); 
			Assert.assertEquals("Check operand length", 0, line.getOperand().length); 
			Assert.assertEquals("Check label", "Label", line.getLabel()); 
			Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment()); 
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check CWAI Accumulator Indexed 
	 */
	@Test 
	public void testCWAIAccumulatorIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("Label      	CWAI			  	A,X         ; Illegal CWAI\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getCwaiInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Indexed mode is not valid for the CWAI instruction"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
			
			AssembledCWAIInstruction line = (AssembledCWAIInstruction)engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length); 
			Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]); 
			Assert.assertEquals("Check operand length", 0, line.getOperand().length); 
			Assert.assertEquals("Check label", "Label", line.getLabel()); 
			Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment()); 
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check CWAI Accumulator Indexed Indirect
	 */
	@Test 
	public void testCWAIAccumulatorIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("Label      	CWAI			  	[A,X]         ; Illegal CWAI\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getCwaiInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Indexed mode is not valid for the CWAI instruction"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
			
			AssembledCWAIInstruction line = (AssembledCWAIInstruction)engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length); 
			Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]); 
			Assert.assertEquals("Check operand length", 0, line.getOperand().length); 
			Assert.assertEquals("Check label", "Label", line.getLabel()); 
			Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment()); 
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check CWAI Auto-Increment Indexed 
	 */
	@Test 
	public void testCWAIAutoIncrementIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("Label      	CWAI			  	,--X         ; Illegal CWAI\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getCwaiInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Indexed mode is not valid for the CWAI instruction"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
			
			AssembledCWAIInstruction line = (AssembledCWAIInstruction)engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length); 
			Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]); 
			Assert.assertEquals("Check operand length", 0, line.getOperand().length); 
			Assert.assertEquals("Check label", "Label", line.getLabel()); 
			Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment()); 
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}


	/**
	 * Check CWAI Auto-Increment Indexed Indirect
	 */
	@Test 
	public void testCWAIAutoIncrementIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("Label      	CWAI			  	[,--X]         ; Illegal CWAI\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getCwaiInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Indexed mode is not valid for the CWAI instruction"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
			
			AssembledCWAIInstruction line = (AssembledCWAIInstruction)engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length); 
			Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]); 
			Assert.assertEquals("Check operand length", 0, line.getOperand().length); 
			Assert.assertEquals("Check label", "Label", line.getLabel()); 
			Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment()); 
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check CWAI Relative to PC Indexed 
	 */
	@Test 
	public void testCWAIRelativePCIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("Label      	CWAI			  	0,PC         ; Illegal CWAI\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getCwaiInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Indexed mode is not valid for the CWAI instruction"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
			
			AssembledCWAIInstruction line = (AssembledCWAIInstruction)engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length); 
			Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]); 
			Assert.assertEquals("Check operand length", 0, line.getOperand().length); 
			Assert.assertEquals("Check label", "Label", line.getLabel()); 
			Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment()); 
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check CWAI Relative to PC Indexed Indirect 
	 */
	@Test 
	public void testCWAIRelativePCIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("Label      	CWAI			  	[0,PC]         ; Illegal CWAI\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getCwaiInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Indexed mode is not valid for the CWAI instruction"
			);

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.getCurrentPcValue());
			
			AssembledCWAIInstruction line = (AssembledCWAIInstruction)engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length); 
			Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]); 
			Assert.assertEquals("Check operand length", 0, line.getOperand().length); 
			Assert.assertEquals("Check label", "Label", line.getLabel()); 
			Assert.assertEquals("Check operand length", "; Illegal CWAI", line.getComment()); 
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check CWAI instruction with duplicate label 
	 */
	@Test 
	public void testCWAIWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start			NOP\n");
		strBuilder.append("					NOP    \n");
		strBuilder.append("Start      	CWAI			  	#Const+2\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getInstructionLine(),
					InstructionValidator.DUPLICATE_LABEL,
					"Label Start is already defined"
					);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check Assembled CWAI immediate instruction  
	 */
	@Test 
	public void testCWAIImmediatInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	CWAI			  	#Const+2  ; 8000   3C 07        START:    CWAI\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.getCurrentPcValue());
			
			AssembledCWAIInstruction line = (AssembledCWAIInstruction)engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);;	
			Assert.assertEquals("Check opcode", 0x3C, line.getOpcode()[0]);	
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);	
			Assert.assertEquals("Check operand", 0x07, line.getOperand()[0]);
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   3C 07        START:    CWAI", line.getComment());	
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check Assembled CWAI immediate with limit negative operand  
	 */
	@Test 
	public void testCWAIImmediatInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CWAI		  	#-129\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getCwaiInstruction(),
				InstructionValidator.OVERFLOW_ERROR,	
				"The value -129 is below the possible limit, data may be lost"
			);
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCWAIInstruction line = (AssembledCWAIInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check Assembled CWAI immediate with limit negative operand  
	 */
	@Test 
	public void testCWAIImmediatInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CWAI			  	#-128\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCWAIInstruction line = (AssembledCWAIInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check Assembled CWAI immediate with positive limit operand  
	 */
	@Test 
	public void testCWAIImmediatInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CWAI			  	#255\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCWAIInstruction line = (AssembledCWAIInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check Assembled CWAI immediate with positive limit operand  
	 */
	@Test 
	public void testCWAIImmediatInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	CWAI			  	#256\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getCwaiInstruction(),
				InstructionValidator.OVERFLOW_ERROR,	
				"The value 256 is greater than the possible limit, data may be lost"
			);

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledCWAIInstruction line = (AssembledCWAIInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
}