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

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.BplInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLBPLInstruction;
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

public class TestLBPLInstruction {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check LBPL
	 */
	@Test 
	public void testSimpleLBPLWithExtraSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        ORG     $8000\n");
		strBuilder.append("Jump	    ASLA\n");
		strBuilder.append("			ASLB\n");
		strBuilder.append("			LBPL		Jump \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(4);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an LBPL directive line", instructionLine.getInstruction() instanceof BplInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBPL
	 */
	@Test 
	public void testSimpleLBPLWithoutExtraSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        ORG     $8000\n");
		strBuilder.append("Jump	    ASLA\n");
		strBuilder.append("			ASLB\n");
		strBuilder.append("			LBPL		Jump\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(4);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an LBPL directive line", instructionLine.getInstruction() instanceof BplInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check LBPL with duplicate label
	 */
	@Test 
	public void testSimpleLBPLWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        ORG     $8000\n");
		strBuilder.append("Jump	    LDA		#25\n");
		strBuilder.append("			NOP\n");
		strBuilder.append("Jump		LBPL		Jump		; Jump=3FFF\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getInstructionLine(),
				InstructionValidator.DUPLICATE_LABEL,
				"Label Jump is already defined"
			);
	
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check LBPL with bad label
	 */
	@Test 
	public void testSimpleLBPLWithBadLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        ORG    	 	$8000\n");
		strBuilder.append("Jump1	LDA			#25\n");
		strBuilder.append("			NOP\n");
		strBuilder.append("Jump		LBPL		Jump2		; Jump=3FFF\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getBplInstruction(),
				InstructionValidator.MISSING_LABEL,
				"Label Jump2 isn't defined"
			);
		
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check LBPL
	 */
	@Test 
	public void testSimpleLBPLWithWithLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("	        	ORG     	$8000\n");
		strBuilder.append("Jump	    	ASLA\n");
		strBuilder.append("				ASLB\n");
		strBuilder.append("MyBanch		LBPL		Jump\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(4);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an LBPL directive line", instructionLine.getInstruction() instanceof BplInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBPL negative jump
	 */
	@Test 
	public void testSimpleLBPLWithNegativeJump1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     $8004\n");
		strBuilder.append("Jump	    	LDA		#25\n");
		strBuilder.append("	        	ORG     $8080\n");
		strBuilder.append("MyBanch		LBPL	Jump		; Jump=102AFF80\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getBplInstruction(),
				InstructionValidator.RELATIVE_SHORT_BRANCH,
				"You can use a short branch"
			);
		
			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8084, engine.getCurrentPcValue());
			
			AssembledLBPLInstruction line = (AssembledLBPLInstruction)engine.getAssembledLine(4);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x2A, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0x80, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBPL negative jump
	 */
	@Test 
	public void testSimpleLBPLWithNegativeJump2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     $8003\n");
		strBuilder.append("Jump	    	LDA		#25\n");
		strBuilder.append("	       	 	ORG     $8080\n");
		strBuilder.append("MyBanch		LBPL	Jump		; Jump=102AFF7F\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8084, engine.getCurrentPcValue());
			
			AssembledLBPLInstruction line = (AssembledLBPLInstruction)engine.getAssembledLine(4);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x2A, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0x7F, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBPL positive jump
	 */
	@Test 
	public void testSimpleLBPLWithPositiveJump1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     	$8000\n");
		strBuilder.append("MyBanch		LBPL		Jump		; Jump=102A007F\n");
		strBuilder.append("				ORG			$8083\n");
		strBuilder.append("Jump			RTS			\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getBplInstruction(),
				InstructionValidator.RELATIVE_SHORT_BRANCH,
				"You can use a short branch"
			);

			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8084, engine.getCurrentPcValue());
			
			AssembledLBPLInstruction line = (AssembledLBPLInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x2A, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x00, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0x7F, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBPL positive jump
	 */
	@Test 
	public void testSimpleLBPLWithPositiveJump2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     	$8000\n");
		strBuilder.append("MyBanch		LBPL		Jump		; Jump=102A0080\n");
		strBuilder.append("				ORG			$8084\n");
		strBuilder.append("Jump			RTS			\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8085, engine.getCurrentPcValue());
			
			AssembledLBPLInstruction line = (AssembledLBPLInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x2A, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x00, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0x80, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBPL positive limit jump
	 */
	@Test 
	public void testSimpleLBPLWithPositiveLimitJump1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     	$0000\n");
		strBuilder.append("MyBranch		LBPL		Jump		; Jump=102A7FFF\n");
		strBuilder.append("				ORG     	$8003\n");
		strBuilder.append("Jump			RTS			\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8004, engine.getCurrentPcValue());
			
			AssembledLBPLInstruction line = (AssembledLBPLInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x2A, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x7F, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check label", "MyBranch", line.getLabel());
			Assert.assertEquals("Check comment", "; Jump=102A7FFF", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBPL positive limit jump
	 */
	@Test 
	public void testSimpleLBPLWithPositiveLimitJump2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     	$0000\n");
		strBuilder.append("MyBanch		LBPL		Jump		; Jump=102A8000\n");
		strBuilder.append("				ORG     	$8004\n");
		strBuilder.append("Jump			RTS			\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine=AssemblerEngine.getInstance();
			
			AssembledLBPLInstruction line = (AssembledLBPLInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x2A, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBPL negative limit jump
	 */
	@Test 
	public void testSimpleLBPLWithNegativeLimitJump1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("				ORG			$0004\n");
		strBuilder.append("JUMP			RTS					\n");
		strBuilder.append("				ORG			$8000		;\n");
		strBuilder.append("VVV			LBPL		JUMP		;		\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8004, engine.getCurrentPcValue());
			
			AssembledLBPLInstruction line = (AssembledLBPLInstruction)engine.getAssembledLine(4);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x2A, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBPL negative limit jump
	 */
	@Test 
	public void testSimpleLBPLWithNegativeLimitJump2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("				ORG			$0003\n");
		strBuilder.append("JUMP			RTS					\n");
		strBuilder.append("				ORG			$8000		;\n");
		strBuilder.append("VVV			LBPL		JUMP		;		\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8004, engine.getCurrentPcValue());
			
			AssembledLBPLInstruction line = (AssembledLBPLInstruction)engine.getAssembledLine(4);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x2A, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x7F, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
}