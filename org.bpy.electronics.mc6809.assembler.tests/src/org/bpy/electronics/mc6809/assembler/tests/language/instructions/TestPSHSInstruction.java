/*
 * MC6809 Toolkit
 * Copyright (C) 2023  Patrick BRIOR
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

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.PshsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledPSHSInstruction;
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

public class TestPSHSInstruction {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check PHSH immediate 
	 */
	@Test 
	public void testPSHSImemdiatAddressingMode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    			$8000\n");
		strBuilder.append("Registers  	REG          	A,B 	       \n");
		strBuilder.append("	       		PSHS		  	#Registers\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent(); 
			Assert.assertTrue("Must be an PSHS instruction line", instructionLine.getInstruction() instanceof PshsInstruction);

		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check PHSH A 
	 */
	@Test 
	public void testPSHSImemdiate1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       PSHS		  	PC,U,Y,X,DP,B,A,CC\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(3);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent(); 
			Assert.assertTrue("Must be an PSHS instruction line", instructionLine.getInstruction() instanceof PshsInstruction);
	
			PshsInstruction phshInstruction = (PshsInstruction)instructionLine.getInstruction();
			assertEquals("Must be an PSHS instruction", phshInstruction.getInstruction(),"PSHS");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check PHSH from REG instruction 
	 */
	@Test 
	public void testPSHSImemdiatAddressingMode3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       			ORG    		$8000\n");
		strBuilder.append("RegDir     		REG			A,B,X,Y	       \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

		AssemblerEngine engine = AssemblerEngine.getInstance();
		AssembledPSHSInstruction line = (AssembledPSHSInstruction)engine.getAssembledLine(3);
		
		Assert.assertEquals("Check PC Counter", 0x8002, engine.getCurrentPcValue());
		Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);		
		Assert.assertEquals("Check opcode", 0x34, line.getOpcode()[0]);
		Assert.assertEquals("Check operand length", 1, line.getOperand().length);		
		Assert.assertEquals("Check operand", 0x36, line.getOperand()[0]);
		Assert.assertEquals("Check label", "PushPull", line.getLabel());		
		Assert.assertEquals("Check comment", "; push register", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check PHSH missing REG instruction 
	 */
	@Test 
	public void testPSHSMissingReg() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    		$8000\n");
		strBuilder.append("Pshs       	PSHS		   #RegDir       ; push register\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getPshsInstruction(),
				InstructionValidator.EXPRESSION_ERROR,
				"Can't find RegDir definition"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledPSHSInstruction line = (AssembledPSHSInstruction)engine.getAssembledLine(2);
			
			Assert.assertEquals("Check PC COunter", 0x8002, engine.getCurrentPcValue());
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);		
			Assert.assertEquals("Check opcode", 0x34, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);		
			Assert.assertEquals("Check operand", 0x00, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check PSHS instruction with D and A register
	 */
	@Test 
	public void testInstructionWithAAndDRegister() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test PSHS without label\n");
		strBuilder.append("	 	    PSHS    	A,D 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getPshsInstruction(),
					InstructionValidator.DUPLICATE_OPTION,"D register overwrite the A register in the REG Directive");

		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check PSHS instruction with D and B register
	 */
	@Test 
	public void testInstructionWithBAndDRegister() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("	 	    PSHS    	B,D 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getPshsInstruction(),
					InstructionValidator.DUPLICATE_OPTION,"D register overwrite the B register in the REG Directive");
		
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check PSHS instruction with duplicate label
	 */
	@Test 
	public void testInstructionWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("Lab1		NOP		 	\n");
		strBuilder.append("Lab1	 	PSHS    	B,A 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getInstructionLine(),
					InstructionValidator.DUPLICATE_LABEL,"Label Lab1 is already defined");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check PSHS instruction with CC register
	 */
	@Test 
	public void testInstructionOperandCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("	 	    PSHS   CC 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledPSHSInstruction line = (AssembledPSHSInstruction)engine.getAssembledLine(1);
			
			Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);		
			Assert.assertEquals("Check opcode", 0x34, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);		
			Assert.assertEquals("Check operand", 0x01, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check PSHS instruction with A register
	 */
	@Test 
	public void testInstructionOperandA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("	 	    PSHS   A 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledPSHSInstruction line = (AssembledPSHSInstruction)engine.getAssembledLine(1);
			
			Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);		
			Assert.assertEquals("Check opcode", 0x34, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);		
			Assert.assertEquals("Check operand", 0x02, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check PSHS instruction with B register
	 */
	@Test 
	public void testInstructionOperandB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("	 	    PSHS   B 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledPSHSInstruction line = (AssembledPSHSInstruction)engine.getAssembledLine(1);
			
			Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);		
			Assert.assertEquals("Check opcode", 0x34, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);		
			Assert.assertEquals("Check operand", 0x04, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check PSHS instruction with D register
	 */
	@Test 
	public void testInstructionOperandD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("	 	    PSHS   D 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledPSHSInstruction line = (AssembledPSHSInstruction)engine.getAssembledLine(1);
			
			Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);		
			Assert.assertEquals("Check opcode", 0x34, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);		
			Assert.assertEquals("Check operand", 0x06, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check PSHS instruction with DP register
	 */
	@Test 
	public void testInstructionOperandDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("	 	    PSHS   DP 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledPSHSInstruction line = (AssembledPSHSInstruction)engine.getAssembledLine(1);
			
			Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);		
			Assert.assertEquals("Check opcode", 0x34, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);		
			Assert.assertEquals("Check operand", 0x08, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check PSHS instruction with X register
	 */
	@Test 
	public void testInstructionOperandX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("	 	    PSHS   X 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledPSHSInstruction line = (AssembledPSHSInstruction)engine.getAssembledLine(1);
			
			Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);		
			Assert.assertEquals("Check opcode", 0x34, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);		
			Assert.assertEquals("Check operand", 0x10, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check PSHS instruction with Y register
	 */
	@Test 
	public void testInstructionOperandY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("	 	    PSHS   Y 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledPSHSInstruction line = (AssembledPSHSInstruction)engine.getAssembledLine(1);
			
			Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);		
			Assert.assertEquals("Check opcode", 0x34, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);		
			Assert.assertEquals("Check operand", 0x20, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check PSHS instruction with U register
	 */
	@Test 
	public void testInstructionOperandU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("	 	    PSHS   U 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledPSHSInstruction line = (AssembledPSHSInstruction)engine.getAssembledLine(1);
			
			Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);		
			Assert.assertEquals("Check opcode", 0x34, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);		
			Assert.assertEquals("Check operand", 0x40, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check PSHS instruction with S register
	 */
	@Test 
	public void testInstructionOperandS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("	 	    PSHS   S 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getPshsInstruction(),
				InstructionValidator.ILLEGAL_REGISTER,
				"S register can't be push for a PSHS instruction"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledPSHSInstruction line = (AssembledPSHSInstruction)engine.getAssembledLine(1);
			
			Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);		
			Assert.assertEquals("Check opcode", 0x34, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);		
			Assert.assertEquals("Check operand", 0x40, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check PSHS instruction with S register
	 */
	@Test 
	public void testInstructionOperandRegS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("REG_S		REG		S\n");
		strBuilder.append("	 	    	PSHS   	#REG_S 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getPshsInstruction(),
				InstructionValidator.ILLEGAL_REGISTER,
				"S register can't be push for a PSHS instruction"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledPSHSInstruction line = (AssembledPSHSInstruction)engine.getAssembledLine(2);
			
			Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);		
			Assert.assertEquals("Check opcode", 0x34, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);		
			Assert.assertEquals("Check operand", 0x40, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check PSHS instruction with PC register
	 */
	@Test 
	public void testInstructionOperandPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("	 	    PSHS   PC 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledPSHSInstruction line = (AssembledPSHSInstruction)engine.getAssembledLine(1);
			
			Assert.assertEquals("Check PC Counter", 0x0002, engine.getCurrentPcValue());
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);		
			Assert.assertEquals("Check opcode", 0x34, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 1, line.getOperand().length);		
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
}