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
package org.bpy.electronics.mc6809.assembler.tests.instructions

import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import org.bpy.electronics.mc6809.assembler.assembler.Model
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Assert
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine
import org.junit.Test
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue
import org.bpy.electronics.mc6809.assembler.assembler.PshuInstruction
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledPSHUInstruction
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestPSHUInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check PHSH immediate 
	 */
	@Test 
	def void testPSHUImemdiatAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
		Registers  REG          A,B 	       
			       PSHU		  	#Registers
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an PSHU instruction line", instructionLine.instruction instanceof PshuInstruction)

	}
	/**
	 * Check PHSH A 
	 */
	@Test 
	def void testPSHUImemdiate1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       PSHU		  	PC,S,Y,X,DP,B,A,CC
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an PSHU instruction line", instructionLine.instruction instanceof PshuInstruction)

		val phshInstruction = instructionLine.instruction as PshuInstruction
		assertEquals("Must be an PSHU instruction", phshInstruction.instruction,"PSHU")
	}
	
	/**
	 * Check PHSH from REG instruction 
	 */
	@Test 
	def void testPSHUImemdiatAddressingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       		ORG    		$8000
		RegDir     		REG			A,B,X,Y	       
		PushPull        PSHU		#RegDir       ; push register
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(3) as AssembledPSHUInstruction
		
		Assert.assertEquals("Check PC Counter", 0x8002, engine.currentPcValue)
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)		
		Assert.assertEquals("Check opcode", 0x36, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)		
		Assert.assertEquals("Check operand", 0x36, line.operand.get(0))
		Assert.assertEquals("Check label", "PushPull", line.label)		
		Assert.assertEquals("Check comment", "; push register", line.comment)
	}
	
	/**
	 * Check PHSH missing REG instruction 
	 */
	@Test 
	def void testPSHUMissingReg() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
		Pshs       PSHU		  	#RegDir       ; push register
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.pshuInstruction,
			InstructionValidator::MISSING_DIRECTIVE,
			"REG RegDir directive is not defined"
		)

		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledPSHUInstruction
		
		Assert.assertEquals("Check PC COunter", 0x8001, engine.currentPcValue)
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)		
		Assert.assertEquals("Check opcode", 0x3F, line.opcode.get(0))
	}

	/**
	 * Check PSHU instruction with D and A register
	 */
	@Test 
	def void testInstructionWithAAndDRegister() {
		val result = parseHelper.parse('''
		; test PSHU without label
			 	    PSHU    A,D 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.pshuInstruction,InstructionValidator::DUPLICATE_OPTION,"D register overwrite the A register in the REG Directive")
	}

	/**
	 * Check PSHU instruction with D and B register
	 */
	@Test 
	def void testInstructionWithBAndDRegister() {
		val result = parseHelper.parse('''
		; test REG without label
			 	    PSHU    B,D 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.pshuInstruction,InstructionValidator::DUPLICATE_OPTION,"D register overwrite the B register in the REG Directive")
	}

	/**
	 * Check PSHU instruction with duplicate label
	 */
	@Test 
	def void testInstructionWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; test REG without label
		Lab1		NOP		 	
		Lab1	 	PSHU    	B,A 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.instructionLine,AssemblerEngine::DUPLICATE_LABEL,"Label Lab1 is already defined")
	}

	/**
	 * Check PSHU instruction with CC register
	 */
	@Test 
	def void testInstructionOperandCC() {
		val result = parseHelper.parse('''
		; test REG without label
			 	    PSHU   CC 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1) as AssembledPSHUInstruction
		
		Assert.assertEquals("Check PC Counter", 0x0002, engine.currentPcValue)
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)		
		Assert.assertEquals("Check opcode", 0x36, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)		
		Assert.assertEquals("Check operand", 0x01, line.operand.get(0))
	}

	/**
	 * Check PSHU instruction with A register
	 */
	@Test 
	def void testInstructionOperandA() {
		val result = parseHelper.parse('''
		; test REG without label
			 	    PSHU   A 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1) as AssembledPSHUInstruction
		
		Assert.assertEquals("Check PC Counter", 0x0002, engine.currentPcValue)
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)		
		Assert.assertEquals("Check opcode", 0x36, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)		
		Assert.assertEquals("Check operand", 0x02, line.operand.get(0))
	}

	/**
	 * Check PSHU instruction with B register
	 */
	@Test 
	def void testInstructionOperandB() {
		val result = parseHelper.parse('''
		; test REG without label
			 	    PSHU   B 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1) as AssembledPSHUInstruction
		
		Assert.assertEquals("Check PC Counter", 0x0002, engine.currentPcValue)
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)		
		Assert.assertEquals("Check opcode", 0x36, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)		
		Assert.assertEquals("Check operand", 0x04, line.operand.get(0))
	}

	/**
	 * Check PSHU instruction with D register
	 */
	@Test 
	def void testInstructionOperandD() {
		val result = parseHelper.parse('''
		; test REG without label
			 	    PSHU   D 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1) as AssembledPSHUInstruction
		
		Assert.assertEquals("Check PC Counter", 0x0002, engine.currentPcValue)
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)		
		Assert.assertEquals("Check opcode", 0x36, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)		
		Assert.assertEquals("Check operand", 0x06, line.operand.get(0))
	}

	/**
	 * Check PSHU instruction with DP register
	 */
	@Test 
	def void testInstructionOperandDP() {
		val result = parseHelper.parse('''
		; test REG without label
			 	    PSHU   DP 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1) as AssembledPSHUInstruction
		
		Assert.assertEquals("Check PC Counter", 0x0002, engine.currentPcValue)
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)		
		Assert.assertEquals("Check opcode", 0x36, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)		
		Assert.assertEquals("Check operand", 0x08, line.operand.get(0))
	}

	/**
	 * Check PSHU instruction with X register
	 */
	@Test 
	def void testInstructionOperandX() {
		val result = parseHelper.parse('''
		; test REG without label
			 	    PSHU   X 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1) as AssembledPSHUInstruction
		
		Assert.assertEquals("Check PC Counter", 0x0002, engine.currentPcValue)
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)		
		Assert.assertEquals("Check opcode", 0x36, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)		
		Assert.assertEquals("Check operand", 0x10, line.operand.get(0))
	}

	/**
	 * Check PSHU instruction with Y register
	 */
	@Test 
	def void testInstructionOperandY() {
		val result = parseHelper.parse('''
		; test REG without label
			 	    PSHU   Y 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1) as AssembledPSHUInstruction
		
		Assert.assertEquals("Check PC Counter", 0x0002, engine.currentPcValue)
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)		
		Assert.assertEquals("Check opcode", 0x36, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)		
		Assert.assertEquals("Check operand", 0x20, line.operand.get(0))
	}

	/**
	 * Check PSHU instruction with U register
	 */
	@Test 
	def void testInstructionOperandU() {
		val result = parseHelper.parse('''
		; test REG without label
			 	    PSHU   U 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.pshuInstruction,
			InstructionValidator::ILLEGAL_REGISTER,
			"U register can't be push for a PSHU instruction"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1) as AssembledPSHUInstruction
		
		Assert.assertEquals("Check PC Counter", 0x0002, engine.currentPcValue)
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)		
		Assert.assertEquals("Check opcode", 0x36, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)		
		Assert.assertEquals("Check operand", 0x40, line.operand.get(0))
	}

	/**
	 * Check PSHU instruction with S register
	 */
	@Test 
	def void testInstructionOperandS() {
		val result = parseHelper.parse('''
		; test REG without label
			 	    PSHU   S 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1) as AssembledPSHUInstruction
		
		Assert.assertEquals("Check PC Counter", 0x0002, engine.currentPcValue)
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)		
		Assert.assertEquals("Check opcode", 0x36, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)		
		Assert.assertEquals("Check operand", 0x40, line.operand.get(0))
	}

	/**
	 * Check PSHU instruction with S register
	 */
	@Test 
	def void testInstructionOperandRegS() {
		val result = parseHelper.parse('''
		; test REG without label
		REG_U		REG		U
			 	    PSHU   	#REG_U 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.pshuInstruction,
			InstructionValidator::ILLEGAL_REGISTER,
			"U register can't be push for a PSHU instruction"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledPSHUInstruction
		
		Assert.assertEquals("Check PC Counter", 0x0002, engine.currentPcValue)
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)		
		Assert.assertEquals("Check opcode", 0x36, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)		
		Assert.assertEquals("Check operand", 0x40, line.operand.get(0))
	}

	/**
	 * Check PSHU instruction with PC register
	 */
	@Test 
	def void testInstructionOperandPC() {
		val result = parseHelper.parse('''
		; test REG without label
			 	    PSHU   PC 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1) as AssembledPSHUInstruction
		
		Assert.assertEquals("Check PC Counter", 0x0002, engine.currentPcValue)
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)		
		Assert.assertEquals("Check opcode", 0x36, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)		
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0))
	}
}