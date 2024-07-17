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
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledBVSInstruction;
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

public class TestBVSInstruction {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check BVS
	 */
	@Test 
	public void testSimpleBVSWithExtraSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        ORG     $8000\n");
		strBuilder.append("Jump	    ASLA\n");
		strBuilder.append("			ASLB\n");
		strBuilder.append("			BVS		Jump \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(4);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an BVS directive line", instructionLine.getInstruction() instanceof BvsInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check BVS
	 */
	@Test 
	public void testSimpleBVSWithoutExtraSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        ORG     $8000\n");
		strBuilder.append("Jump	    ASLA\n");
		strBuilder.append("			ASLB\n");
		strBuilder.append("			BVS		Jump\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

		
			SourceLine line = result.getSourceLines().get(4);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an BVS directive line", instructionLine.getInstruction() instanceof BvsInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check BVS
	 */
	@Test 
	public void testSimpleBVSWithWithLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     $8000\n");
		strBuilder.append("Jump	    	ASLA\n");
		strBuilder.append("				ASLB\n");
		strBuilder.append("MyBanch		BVS		Jump\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(4);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an BVS directive line", instructionLine.getInstruction() instanceof BvsInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check BVS with duplicate label
	 */
	@Test 
	public void testSimpleBVSWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        ORG     $8000\n");
		strBuilder.append("Jump	    LDA		#25\n");
		strBuilder.append("			NOP\n");
		strBuilder.append("Jump		BVS		Jump		; Jump=3FFF\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getInstructionLine(),
				AssemblerEngine.DUPLICATE_LABEL,
				"Label Jump is already defined"
			);
		
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check BVS with bad label
	 */
	@Test 
	public void testSimpleBVSWithBadLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     $8000\n");
		strBuilder.append("Jump1	    LDA		#25\n");
		strBuilder.append("				NOP\n");
		strBuilder.append("Jump			BVS		Jump2		; Jump=3FFF\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getBvsInstruction(),
				InstructionValidator.MISSING_LABEL,
				"Label Jump2 isn't defined"
			);
		
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check BVS negative jump
	 */
	@Test 
	public void testSimpleBVSWithNegativeJump() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     $8000\n");
		strBuilder.append("Jump	    	LDA		#25\n");
		strBuilder.append("				NOP\n");
		strBuilder.append("MyBanch		BVS		Jump		; Jump=24FB\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8005, engine.getCurrentPcValue());
			
			AssembledBVSInstruction line = (AssembledBVSInstruction)engine.getAssembledLine(4); 
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x29, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0xFB, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check BVS positive jump
	 */
	@Test 
	public void testSimpleBVSWithPositiveJump() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     $8000\n");
		strBuilder.append("MyBanch		BVS		Jump		; Jump=2401\n");
		strBuilder.append("				NOP\n");
		strBuilder.append("Jump			RTS			\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8004, engine.getCurrentPcValue());
			
			AssembledBVSInstruction line = (AssembledBVSInstruction)engine.getAssembledLine(2); 
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x29, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x01, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check BVS positive limit jump
	 */
	@Test 
	public void testSimpleBVSWithPositiveLimitJump1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	    	    ORG     $8000\n");
		strBuilder.append("MyBanch		BVS		Jump		; Jump=247F\n");
		strBuilder.append("				ORG     $8081\n");
		strBuilder.append("Jump			RTS			\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8082, engine.getCurrentPcValue());
			
			AssembledBVSInstruction line = (AssembledBVSInstruction)engine.getAssembledLine(2); 
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x29, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x7F, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check BVS positive limit jump
	 */
	@Test 
	public void testSimpleBVSWithPositiveLimitJump2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     $8000\n");
		strBuilder.append("MyBanch		BVS		Jump		; Jump=247F\n");
		strBuilder.append("				ORG     $8082\n");
		strBuilder.append("Jump			RTS			\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getBvsInstruction(),
				InstructionValidator.OVERFLOW_ERROR,
				"Overflow error, you should use long branch"
			);
	
			AssemblerEngine engine=AssemblerEngine.getInstance();
			
			AssembledBVSInstruction line = (AssembledBVSInstruction)engine.getAssembledLine(2); 
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check BVS negative limit jump
	 */
	@Test 
	public void testSimpleBVSWithNegativeLimitJump1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("				ORG		$8002\n");
		strBuilder.append("JUMP			RTS					\n");
		strBuilder.append("				ORG		$8080		;\n");
		strBuilder.append("VVV			BVS		JUMP		;		\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8082, engine.getCurrentPcValue());
			
			AssembledBVSInstruction line = (AssembledBVSInstruction)engine.getAssembledLine(4); 
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x29, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x80, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check BVS negative limit jump
	 */
	@Test 
	public void testSimpleBVSWithNegativeLimitJump2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("				ORG		$8001\n");
		strBuilder.append("JUMP			RTS					\n");
		strBuilder.append("				ORG		$8080		;\n");
		strBuilder.append("VVV			BVS		JUMP		;		\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getBvsInstruction(),
				InstructionValidator.OVERFLOW_ERROR,
				"Overflow error, you should use long branch"
			);
	
	
			AssemblerEngine engine=AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC counter", 0x8082, engine.getCurrentPcValue());
			
			AssembledBVSInstruction line = (AssembledBVSInstruction)engine.getAssembledLine(4); 
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
}