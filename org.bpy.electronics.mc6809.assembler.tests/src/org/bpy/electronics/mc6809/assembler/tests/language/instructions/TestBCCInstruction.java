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
import org.bpy.electronics.mc6809.assembler.assembler.BccInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerManager;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledBCCInstruction;
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

public class TestBCCInstruction {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check BCC
	 */
	@Test 
	public void testSimpleBCCWithExtraSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        ORG     $8000\n");
		strBuilder.append("Jump	    ASLA\n");
		strBuilder.append("			ASLB\n");
		strBuilder.append("			BCC		Jump \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(4);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an BCC directive line", instructionLine.getInstruction() instanceof BccInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check BCC
	 */
	@Test 
	public void testSimpleBCCWithoutExtraSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        ORG     $8000\n");
		strBuilder.append("Jump	    ASLA\n");
		strBuilder.append("			ASLB\n");
		strBuilder.append("			BCC		Jump\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

		
			SourceLine line = result.getSourceLines().get(4);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an BCC directive line", instructionLine.getInstruction() instanceof BccInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check BCC
	 */
	@Test 
	public void testSimpleBCCWithWithLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     $8000\n");
		strBuilder.append("Jump	    	ASLA\n");
		strBuilder.append("				ASLB\n");
		strBuilder.append("MyBanch		BCC		Jump\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(4);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an BCC directive line", instructionLine.getInstruction() instanceof BccInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check BCC with duplicate label
	 */
	@Test 
	public void testSimpleBCCWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        ORG     $8000\n");
		strBuilder.append("Jump	    LDA		#25\n");
		strBuilder.append("			NOP\n");
		strBuilder.append("Jump		BCC		Jump		; Jump=3FFF\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getInstructionLine(),
				InstructionValidator.DUPLICATE_LABEL,
				"Label Jump is already defined"
			);
		
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check BCC with bad label
	 */
	@Test 
	public void testSimpleBCCWithBadLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     $8000\n");
		strBuilder.append("Jump1	    LDA		#25\n");
		strBuilder.append("				NOP\n");
		strBuilder.append("Jump			BCC		Jump2		; Jump=3FFF\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getBccInstruction(),
				InstructionValidator.MISSING_LABEL,
				"Label Jump2 isn't defined"
			);
		
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check BCC negative jump
	 */
	@Test 
	public void testSimpleBCCWithNegativeJump() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     $8000\n");
		strBuilder.append("Jump	    	LDA	  #25\n");
		strBuilder.append("				NOP\n");
		strBuilder.append("MyBanch		BCC	  Jump		; Jump=24FB\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC counter", 0x8005, engine.getCurrentPcValue());
			
			AssembledBCCInstruction line = (AssembledBCCInstruction)engine.getAssembledLine(4); 
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x24, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0xFB, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check BCC positive jump
	 */
	@Test 
	public void testSimpleBCCWithPositiveJump() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     $8000\n");
		strBuilder.append("MyBanch		BCC		Jump		; Jump=2401\n");
		strBuilder.append("				NOP\n");
		strBuilder.append("Jump			RTS			\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC counter", 0x8004, engine.getCurrentPcValue());
			
			AssembledBCCInstruction line = (AssembledBCCInstruction)engine.getAssembledLine(2); 
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x24, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x01, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check BCC positive limit jump
	 */
	@Test 
	public void testSimpleBCCWithPositiveLimitJump1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	    	    ORG     $8000\n");
		strBuilder.append("MyBanch		BCC		Jump		; Jump=247F\n");
		strBuilder.append("				ORG     $8081\n");
		strBuilder.append("Jump			RTS			\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC counter", 0x8082, engine.getCurrentPcValue());
			
			AssembledBCCInstruction line = (AssembledBCCInstruction)engine.getAssembledLine(2); 
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x24, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x7F, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check BCC positive limit jump
	 */
	@Test 
	public void testSimpleBCCWithPositiveLimitJump2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     $8000\n");
		strBuilder.append("MyBanch		BCC		Jump		; Jump=247F\n");
		strBuilder.append("				ORG     $8082\n");
		strBuilder.append("Jump			RTS			\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getBccInstruction(),
				InstructionValidator.OVERFLOW_ERROR,
				"Overflow error, you should use long branch"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			
			AssembledBCCInstruction line = (AssembledBCCInstruction)engine.getAssembledLine(2); 
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check BCC negative limit jump
	 */
	@Test 
	public void testSimpleBCCWithNegativeLimitJump1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("				ORG		$8002\n");
		strBuilder.append("JUMP			RTS					\n");
		strBuilder.append("				ORG		$8080		;\n");
		strBuilder.append("VVV			BCC		JUMP		;		\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC counter", 0x8082, engine.getCurrentPcValue());
			
			AssembledBCCInstruction line = (AssembledBCCInstruction)engine.getAssembledLine(4); 
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x24, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x80, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check BCC negative limit jump
	 */
	@Test 
	public void testSimpleBCCWithNegativeLimitJump2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("				ORG		$8001\n");
		strBuilder.append("JUMP			RTS					\n");
		strBuilder.append("				ORG		$8080		;\n");
		strBuilder.append("VVV			BCC		JUMP		;		\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getBccInstruction(),
				InstructionValidator.OVERFLOW_ERROR,
				"Overflow error, you should use long branch"
			);
	
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC counter", 0x8082, engine.getCurrentPcValue());
			
			AssembledBCCInstruction line = (AssembledBCCInstruction)engine.getAssembledLine(4); 
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x3F, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
}