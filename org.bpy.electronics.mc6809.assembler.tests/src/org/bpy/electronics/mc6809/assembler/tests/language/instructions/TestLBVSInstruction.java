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
import org.bpy.electronics.mc6809.assembler.assembler.BvsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLBVSInstruction;
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

public class TestLBVSInstruction {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check LBVS
	 */
	@Test 
	public void testSimpleLBVSWithExtraSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        ORG     $8000\n");
		strBuilder.append("Jump	    ASLA\n");
		strBuilder.append("			ASLB\n");
		strBuilder.append("			LBVS		Jump \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(4);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an LBVS directive line", instructionLine.getInstruction() instanceof BvsInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBVS
	 */
	@Test 
	public void testSimpleLBVSWithoutExtraSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        ORG     $8000\n");
		strBuilder.append("Jump	    ASLA\n");
		strBuilder.append("			ASLB\n");
		strBuilder.append("			LBVS		Jump\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(4);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an LBVS directive line", instructionLine.getInstruction() instanceof BvsInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check LBVS with duplicate label
	 */
	@Test 
	public void testSimpleLBVSWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        ORG     $8000\n");
		strBuilder.append("Jump	    LDA		#25\n");
		strBuilder.append("			NOP\n");
		strBuilder.append("Jump		LBVS		Jump		; Jump=3FFF\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getInstructionLine(),
				AssemblerEngine.DUPLICATE_LABEL,
				"Label Jump is already defined"
			);
	
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check LBVS with bad label
	 */
	@Test 
	public void testSimpleLBVSWithBadLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        ORG    	 	$8000\n");
		strBuilder.append("Jump1	LDA			#25\n");
		strBuilder.append("			NOP\n");
		strBuilder.append("Jump		LBVS		Jump2		; Jump=3FFF\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getBvsInstruction(),
				InstructionValidator.MISSING_LABEL,
				"Label Jump2 isn't defined"
			);
		
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check LBVS
	 */
	@Test 
	public void testSimpleLBVSWithWithLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("	        	ORG     	$8000\n");
		strBuilder.append("Jump	    	ASLA\n");
		strBuilder.append("				ASLB\n");
		strBuilder.append("MyBanch		LBVS		Jump\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(4);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an LBVS directive line", instructionLine.getInstruction() instanceof BvsInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBVS negative jump
	 */
	@Test 
	public void testSimpleLBVSWithNegativeJump1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     $8004\n");
		strBuilder.append("Jump	    	LDA		#25\n");
		strBuilder.append("	        	ORG     $8080\n");
		strBuilder.append("MyBanch		LBVS	Jump		; Jump=1029FF80\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getBvsInstruction(),
				AbstractInstructionAssemblyLine.RELATIVE_SHORT_BRANCH,
				"You can use a short branch"
			);
		
			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8084, engine.getCurrentPcValue());
			
			AssembledLBVSInstruction line = (AssembledLBVSInstruction)engine.getAssembledLine(4);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x29, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0x80, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBVS negative jump
	 */
	@Test 
	public void testSimpleLBVSWithNegativeJump2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     $8003\n");
		strBuilder.append("Jump	    	LDA		#25\n");
		strBuilder.append("	       	 	ORG     $8080\n");
		strBuilder.append("MyBanch		LBVS	Jump		; Jump=1029FF7F\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8084, engine.getCurrentPcValue());
			
			AssembledLBVSInstruction line = (AssembledLBVSInstruction)engine.getAssembledLine(4);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x29, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0x7F, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBVS positive jump
	 */
	@Test 
	public void testSimpleLBVSWithPositiveJump1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     	$8000\n");
		strBuilder.append("MyBanch		LBVS		Jump		; Jump=1029007F\n");
		strBuilder.append("				ORG			$8083\n");
		strBuilder.append("Jump			RTS			\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getBvsInstruction(),
				AbstractInstructionAssemblyLine.RELATIVE_SHORT_BRANCH,
				"You can use a short branch"
			);

			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8084, engine.getCurrentPcValue());
			
			AssembledLBVSInstruction line = (AssembledLBVSInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x29, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x00, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0x7F, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBVS positive jump
	 */
	@Test 
	public void testSimpleLBVSWithPositiveJump2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     	$8000\n");
		strBuilder.append("MyBanch		LBVS		Jump		; Jump=10290080\n");
		strBuilder.append("				ORG			$8084\n");
		strBuilder.append("Jump			RTS			\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8085, engine.getCurrentPcValue());
			
			AssembledLBVSInstruction line = (AssembledLBVSInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x29, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x00, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0x80, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBVS positive limit jump
	 */
	@Test 
	public void testSimpleLBVSWithPositiveLimitJump1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     	$0000\n");
		strBuilder.append("MyBranch		LBVS		Jump		; Jump=10297FFF\n");
		strBuilder.append("				ORG     	$8003\n");
		strBuilder.append("Jump			RTS			\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8004, engine.getCurrentPcValue());
			
			AssembledLBVSInstruction line = (AssembledLBVSInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x29, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x7F, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check label", "MyBranch", line.getLabel());
			Assert.assertEquals("Check comment", "; Jump=10297FFF", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBVS positive limit jump
	 */
	@Test 
	public void testSimpleLBVSWithPositiveLimitJump2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     	$0000\n");
		strBuilder.append("MyBanch		LBVS		Jump		; Jump=10298000\n");
		strBuilder.append("				ORG     	$8004\n");
		strBuilder.append("Jump			RTS			\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine=AssemblerEngine.getInstance();
			
			AssembledLBVSInstruction line = (AssembledLBVSInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x29, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBVS negative limit jump
	 */
	@Test 
	public void testSimpleLBVSWithNegativeLimitJump1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("				ORG			$0004\n");
		strBuilder.append("JUMP			RTS					\n");
		strBuilder.append("				ORG			$8000		;\n");
		strBuilder.append("VVV			LBVS		JUMP		;		\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8004, engine.getCurrentPcValue());
			
			AssembledLBVSInstruction line = (AssembledLBVSInstruction)engine.getAssembledLine(4);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x29, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBVS negative limit jump
	 */
	@Test 
	public void testSimpleLBVSWithNegativeLimitJump2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("				ORG			$0003\n");
		strBuilder.append("JUMP			RTS					\n");
		strBuilder.append("				ORG			$8000		;\n");
		strBuilder.append("VVV			LBVS		JUMP		;		\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8004, engine.getCurrentPcValue());
			
			AssembledLBVSInstruction line = (AssembledLBVSInstruction)engine.getAssembledLine(4);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x29, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x7F, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
}