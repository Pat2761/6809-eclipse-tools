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
import org.bpy.electronics.mc6809.assembler.assembler.BlsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerManager;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLBLSInstruction;
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

public class TestLBLSInstruction {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check LBLS
	 */
	@Test 
	public void testSimpleLBLSWithExtraSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        ORG     $8000\n");
		strBuilder.append("Jump	    ASLA\n");
		strBuilder.append("			ASLB\n");
		strBuilder.append("			LBLS		Jump \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(4);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an LBLS directive line", instructionLine.getInstruction() instanceof BlsInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBLS
	 */
	@Test 
	public void testSimpleLBLSWithoutExtraSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        ORG     $8000\n");
		strBuilder.append("Jump	    ASLA\n");
		strBuilder.append("			ASLB\n");
		strBuilder.append("			LBLS		Jump\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(4);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an LBLS directive line", instructionLine.getInstruction() instanceof BlsInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check LBLS with duplicate label
	 */
	@Test 
	public void testSimpleLBLSWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        ORG     $8000\n");
		strBuilder.append("Jump	    LDA		#25\n");
		strBuilder.append("			NOP\n");
		strBuilder.append("Jump		LBLS		Jump		; Jump=3FFF\n");

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
	 * Check LBLS with bad label
	 */
	@Test 
	public void testSimpleLBLSWithBadLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        ORG    	 	$8000\n");
		strBuilder.append("Jump1	LDA			#25\n");
		strBuilder.append("			NOP\n");
		strBuilder.append("Jump		LBLS		Jump2		; Jump=3FFF\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getBlsInstruction(),
				InstructionValidator.MISSING_LABEL,
				"Label Jump2 isn't defined"
			);
		
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check LBLS
	 */
	@Test 
	public void testSimpleLBLSWithWithLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("	        	ORG     	$8000\n");
		strBuilder.append("Jump	    	ASLA\n");
		strBuilder.append("				ASLB\n");
		strBuilder.append("MyBanch		LBLS		Jump\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(4);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an LBLS directive line", instructionLine.getInstruction() instanceof BlsInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBLS negative jump
	 */
	@Test 
	public void testSimpleLBLSWithNegativeJump1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     $8004\n");
		strBuilder.append("Jump	    	LDA		#25\n");
		strBuilder.append("	        	ORG     $8080\n");
		strBuilder.append("MyBanch		LBLS	Jump		; Jump=1023FF80\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getBlsInstruction(),
				InstructionValidator.RELATIVE_SHORT_BRANCH,
				"You can use a short branch"
			);
		
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC counter", 0x8084, engine.getCurrentPcValue());
			
			AssembledLBLSInstruction line = (AssembledLBLSInstruction)engine.getAssembledLine(4);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x23, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0x80, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBLS negative jump
	 */
	@Test 
	public void testSimpleLBLSWithNegativeJump2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     $8003\n");
		strBuilder.append("Jump	    	LDA		#25\n");
		strBuilder.append("	       	 	ORG     $8080\n");
		strBuilder.append("MyBanch		LBLS	Jump		; Jump=1023FF7F\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC counter", 0x8084, engine.getCurrentPcValue());
			
			AssembledLBLSInstruction line = (AssembledLBLSInstruction)engine.getAssembledLine(4);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x23, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0x7F, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBLS positive jump
	 */
	@Test 
	public void testSimpleLBLSWithPositiveJump1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     	$8000\n");
		strBuilder.append("MyBanch		LBLS		Jump		; Jump=1023007F\n");
		strBuilder.append("				ORG			$8083\n");
		strBuilder.append("Jump			RTS			\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getBlsInstruction(),
				InstructionValidator.RELATIVE_SHORT_BRANCH,
				"You can use a short branch"
			);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC counter", 0x8084, engine.getCurrentPcValue());
			
			AssembledLBLSInstruction line = (AssembledLBLSInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x23, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x00, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0x7F, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBLS positive jump
	 */
	@Test 
	public void testSimpleLBLSWithPositiveJump2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     	$8000\n");
		strBuilder.append("MyBanch		LBLS		Jump		; Jump=10230080\n");
		strBuilder.append("				ORG			$8084\n");
		strBuilder.append("Jump			RTS			\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC counter", 0x8085, engine.getCurrentPcValue());
			
			AssembledLBLSInstruction line = (AssembledLBLSInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x23, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x00, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0x80, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBLS positive limit jump
	 */
	@Test 
	public void testSimpleLBLSWithPositiveLimitJump1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     	$0000\n");
		strBuilder.append("MyBranch		LBLS		Jump		; Jump=10237FFF\n");
		strBuilder.append("				ORG     	$8003\n");
		strBuilder.append("Jump			RTS			\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC counter", 0x8004, engine.getCurrentPcValue());
			
			AssembledLBLSInstruction line = (AssembledLBLSInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x23, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x7F, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[1]);
			Assert.assertEquals("Check label", "MyBranch", line.getLabel());
			Assert.assertEquals("Check comment", "; Jump=10237FFF", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBLS positive limit jump
	 */
	@Test 
	public void testSimpleLBLSWithPositiveLimitJump2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	        	ORG     	$0000\n");
		strBuilder.append("MyBanch		LBLS		Jump		; Jump=10238000\n");
		strBuilder.append("				ORG     	$8004\n");
		strBuilder.append("Jump			RTS			\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			
			AssembledLBLSInstruction line = (AssembledLBLSInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x23, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBLS negative limit jump
	 */
	@Test 
	public void testSimpleLBLSWithNegativeLimitJump1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("				ORG			$0004\n");
		strBuilder.append("JUMP			RTS					\n");
		strBuilder.append("				ORG			$8000		;\n");
		strBuilder.append("VVV			LBLS		JUMP		;		\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC counter", 0x8004, engine.getCurrentPcValue());
			
			AssembledLBLSInstruction line = (AssembledLBLSInstruction)engine.getAssembledLine(4);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x23, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0x00, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check LBLS negative limit jump
	 */
	@Test 
	public void testSimpleLBLSWithNegativeLimitJump2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("				ORG			$0003\n");
		strBuilder.append("JUMP			RTS					\n");
		strBuilder.append("				ORG			$8000		;\n");
		strBuilder.append("VVV			LBLS		JUMP		;		\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC counter", 0x8004, engine.getCurrentPcValue());
			
			AssembledLBLSInstruction line = (AssembledLBLSInstruction)engine.getAssembledLine(4);
			Assert.assertEquals("Check opcode length", 2, line.getOpcode().length);
			Assert.assertEquals("Check opcode value", 0x10, line.getOpcode()[0]);
			Assert.assertEquals("Check opcode value", 0x23, line.getOpcode()[1]);
			Assert.assertEquals("Check operand length", 2, line.getOperand().length);
			Assert.assertEquals("Check operand value", 0x7F, line.getOperand()[0]);
			Assert.assertEquals("Check operand value", 0xFF, line.getOperand()[1]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
}