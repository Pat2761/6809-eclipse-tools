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
import org.bpy.electronics.mc6809.assembler.assembler.TfrInstruction
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledTFRInstruction
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestTFRInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check TFR 8 bits with extra space 
	 */
	@Test 
	def void testSimpleTFRWithExtraSpace1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       TFR		A,B  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an TFR directive line", instructionLine.instruction instanceof TfrInstruction)
	}
	
	/**
	 * Check TFR 8 bits with extra space 
	 */
	@Test 
	def void testSimpleTFRWithExtraSpace2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       TFR		CC,DP  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an TFR directive line", instructionLine.instruction instanceof TfrInstruction)
	}
	
	/**
	 * Check TFR 16 bits with extra space 
	 */
	@Test 
	def void testSimpleTFRWithExtraSpace3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       TFR		U,S  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an TFR directive line", instructionLine.instruction instanceof TfrInstruction)
	}

	/**
	 * Check TFR 16 bits with extra space 
	 */
	@Test 
	def void testSimpleTFRWithExtraSpace4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       TFR		X,Y  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an TFR directive line", instructionLine.instruction instanceof TfrInstruction)
	}

	/**
	 * Check TFR 16 bits with extra space 
	 */
	@Test 
	def void testSimpleTFRWithExtraSpace5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       TFR		X,PC  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an TFR directive line", instructionLine.instruction instanceof TfrInstruction)
	}

	/**
	 * Check TFR A,A 
	 */
	@Test 
	def void testSimpleTFRResultAA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		A,A  ; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register A with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x88, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR A,B 
	 */
	@Test 
	def void testSimpleTFRResultAB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		A,B  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x89, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR A,D 
	 */
	@Test 
	def void testSimpleTFRResultAD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		A,D  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register A with a part of itself is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x80, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR A,CC 
	 */
	@Test 
	def void testSimpleTFRResultACC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		A,CC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x8A, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR A,DP 
	 */
	@Test 
	def void testSimpleTFRResultADP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		A,DP  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x8B, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR A,X 
	 */
	@Test 
	def void testSimpleTFRResultAX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		A,X  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register A with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x81, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR A,Y 
	 */
	@Test 
	def void testSimpleTFRResultAY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		A,Y  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register A with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x82, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR A,S 
	 */
	@Test 
	def void testSimpleTFRResultAS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		A,S  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register A with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x84, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR A,U 
	 */
	@Test 
	def void testSimpleTFRResultAU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		A,U  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register A with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x83, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR A,PC 
	 */
	@Test 
	def void testSimpleTFRResultAPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		A,PC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register A with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x85, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR B,A 
	 */
	@Test 
	def void testSimpleTFRResultBA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		B,A  ; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x98, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR A,B 
	 */
	@Test 
	def void testSimpleTFRResultBB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		B,B  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register B with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x99, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR B,D 
	 */
	@Test 
	def void testSimpleTFRResultBD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		B,D  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register B with a part of itself is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x90, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR B,CC 
	 */
	@Test 
	def void testSimpleTFRResultBCC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		B,CC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x9A, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR A,DP 
	 */
	@Test 
	def void testSimpleTFRResultBDP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		B,DP  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x9B, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR B,X 
	 */
	@Test 
	def void testSimpleTFRResultBX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		B,X  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register B with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x91, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR B,Y 
	 */
	@Test 
	def void testSimpleTFRResultBY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		B,Y  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register B with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x92, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR B,S 
	 */
	@Test 
	def void testSimpleTFRResultBS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		B,S  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register B with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x94, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR B,U 
	 */
	@Test 
	def void testSimpleTFRResultBU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		B,U  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register B with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x93, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR B,PC 
	 */
	@Test 
	def void testSimpleTFRResultBPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		B,PC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register B with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x95, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR CC,A 
	 */
	@Test 
	def void testSimpleTFRResultCCA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		CC,A  ; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xA8, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR CC,B 
	 */
	@Test 
	def void testSimpleTFRResultCCB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		CC,B  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xA9, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR CC,D 
	 */
	@Test 
	def void testSimpleTFRResultCCD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		CC,D  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register CC with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xA0, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR CC,CC 
	 */
	@Test 
	def void testSimpleTFRResultCCCC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		CC,CC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register CC with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xAA, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR CC,DP 
	 */
	@Test 
	def void testSimpleTFRResultCCDP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		CC,DP  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xAB, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR CC,X 
	 */
	@Test 
	def void testSimpleTFRResultCCX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		CC,X  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register CC with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xA1, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR CC,Y 
	 */
	@Test 
	def void testSimpleTFRResultCCY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		CC,Y  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register CC with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xA2, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR CC,S 
	 */
	@Test 
	def void testSimpleTFRResultCCS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		CC,S  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register CC with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xA4, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR CC,U 
	 */
	@Test 
	def void testSimpleTFRResultCCU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		CC,U  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register CC with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xA3, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR CC,PC 
	 */
	@Test 
	def void testSimpleTFRResultCCPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		CC,PC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register CC with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xA5, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}


	/**
	 * Check TFR DP,A 
	 */
	@Test 
	def void testSimpleTFRResultDPA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		DP,A  ; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xB8, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR DP,B 
	 */
	@Test 
	def void testSimpleTFRResultDPB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		DP,B  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xB9, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR DP,D 
	 */
	@Test 
	def void testSimpleTFRResultDPD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		DP,D  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register DP with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xB0, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR DP,CC 
	 */
	@Test 
	def void testSimpleTFRResultDPCC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		DP,CC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xBA, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR DP,DP 
	 */
	@Test 
	def void testSimpleTFRResultDPDP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		DP,DP  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register DP with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xBB, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR DP,X 
	 */
	@Test 
	def void testSimpleTFRResultDPX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		DP,X  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register DP with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xB1, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR DP,Y 
	 */
	@Test 
	def void testSimpleTFRResultDPY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		DP,Y  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register DP with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xB2, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR DP,S 
	 */
	@Test 
	def void testSimpleTFRResultDPS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		DP,S  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register DP with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xB4, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR DP,U 
	 */
	@Test 
	def void testSimpleTFRResultDPU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		DP,U  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register DP with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xB3, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR DP,PC 
	 */
	@Test 
	def void testSimpleTFRResultDPPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		DP,PC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register DP with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xB5, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR D,A 
	 */
	@Test 
	def void testSimpleTFRResultDA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		D,A  ; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register D with a part of itself is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x08, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR D,B 
	 */
	@Test 
	def void testSimpleTFRResultDB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		D,B  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register D with a part of itself is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x09, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR D,D 
	 */
	@Test 
	def void testSimpleTFRResultDD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		D,D  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register D with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x00, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR D,CC 
	 */
	@Test 
	def void testSimpleTFRResultDCC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		D,CC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register D with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x0A, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR D,DP 
	 */
	@Test 
	def void testSimpleTFRResultDDP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		D,DP  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register D with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x0B, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR D,X 
	 */
	@Test 
	def void testSimpleTFRResultDX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		D,X  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x01, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR D,Y 
	 */
	@Test 
	def void testSimpleTFRResultDY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		D,Y  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x02, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR D,S 
	 */
	@Test 
	def void testSimpleTFRResultDS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		D,S  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x04, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR D,U 
	 */
	@Test 
	def void testSimpleTFRResultDU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		D,U  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x03, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR D,PC 
	 */
	@Test 
	def void testSimpleTFRResultDPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		D,PC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x05, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR X,A 
	 */
	@Test 
	def void testSimpleTFRResultXA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		X,A  ; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register X with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x18, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR X,B 
	 */
	@Test 
	def void testSimpleTFRResultXB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		X,B  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register X with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x19, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR X,D 
	 */
	@Test 
	def void testSimpleTFRResultXD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		X,D  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x10, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR X,CC 
	 */
	@Test 
	def void testSimpleTFRResultXCC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		X,CC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register X with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x1A, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR X,DP 
	 */
	@Test 
	def void testSimpleTFRResultXDP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		X,DP  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register X with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x1B, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR X,X 
	 */
	@Test 
	def void testSimpleTFRResultXX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		X,X  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register X with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x11, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR X,Y 
	 */
	@Test 
	def void testSimpleTFRResultXY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		X,Y  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x12, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR X,S 
	 */
	@Test 
	def void testSimpleTFRResultXS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		X,S  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x14, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR X,U 
	 */
	@Test 
	def void testSimpleTFRResultXU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		X,U  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x13, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR X,PC 
	 */
	@Test 
	def void testSimpleTFRResultXPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		X,PC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x15, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR Y,A 
	 */
	@Test 
	def void testSimpleTFRResultYA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		Y,A  ; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register Y with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x28, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR Y,B 
	 */
	@Test 
	def void testSimpleTFRResultYB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		Y,B  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register Y with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x29, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR Y,D 
	 */
	@Test 
	def void testSimpleTFRResultYD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		Y,D  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x20, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR Y,CC 
	 */
	@Test 
	def void testSimpleTFRResultYCC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		Y,CC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register Y with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x2A, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR Y,DP 
	 */
	@Test 
	def void testSimpleTFRResultYDP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		Y,DP  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register Y with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x2B, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR Y,X 
	 */
	@Test 
	def void testSimpleTFRResultYX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		Y,X  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x21, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR Y,Y 
	 */
	@Test 
	def void testSimpleTFRResultYY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		Y,Y  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register Y with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x22, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR Y,S 
	 */
	@Test 
	def void testSimpleTFRResultYS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		Y,S  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x24, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR X,U 
	 */
	@Test 
	def void testSimpleTFRResultYU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		Y,U  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x23, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR Y,PC 
	 */
	@Test 
	def void testSimpleTFRResultYPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		Y,PC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x25, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR U,A 
	 */
	@Test 
	def void testSimpleTFRResultUA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		U,A  ; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register U with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x38, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR U,B 
	 */
	@Test 
	def void testSimpleTFRResultUB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		U,B  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register U with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x39, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR U,D 
	 */
	@Test 
	def void testSimpleTFRResultUD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		U,D  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x30, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR U,CC 
	 */
	@Test 
	def void testSimpleTFRResultUCC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		U,CC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register U with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x3A, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR U,DP 
	 */
	@Test 
	def void testSimpleTFRResultUDP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		U,DP  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register U with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x3B, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR U,X 
	 */
	@Test 
	def void testSimpleTFRResultUX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		U,X  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x31, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR U,Y 
	 */
	@Test 
	def void testSimpleTFRResultUY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		U,Y  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x32, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR U,S 
	 */
	@Test 
	def void testSimpleTFRResultUS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		U,S  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x34, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR U,U 
	 */
	@Test 
	def void testSimpleTFRResultUU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		U,U  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register U with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x33, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR U,PC 
	 */
	@Test 
	def void testSimpleTFRResultUPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		U,PC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x35, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR S,A 
	 */
	@Test 
	def void testSimpleTFRResultSA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		S,A  ; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register S with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x48, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR S,B 
	 */
	@Test 
	def void testSimpleTFRResultSB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		S,B  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register S with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x49, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR S,D 
	 */
	@Test 
	def void testSimpleTFRResultSD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		S,D  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x40, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR S,CC 
	 */
	@Test 
	def void testSimpleTFRResultSCC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		S,CC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register S with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x4A, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR S,DP 
	 */
	@Test 
	def void testSimpleTFRResultSDP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		S,DP  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register S with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x4B, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR S,X 
	 */
	@Test 
	def void testSimpleTFRResultSX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		S,X  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x41, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR S,Y 
	 */
	@Test 
	def void testSimpleTFRResultSY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		S,Y  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x42, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR S,S 
	 */
	@Test 
	def void testSimpleTFRResultSS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		S,S  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register S with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x44, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR S,U 
	 */
	@Test 
	def void testSimpleTFRResultSU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		S,U  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x43, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR S,PC 
	 */
	@Test 
	def void testSimpleTFRResultSPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		S,PC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x45, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR PC,A 
	 */
	@Test 
	def void testSimpleTFRResultPCA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		PC,A  ; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register PC with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x58, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR PC,B 
	 */
	@Test 
	def void testSimpleTFRResultPCB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		PC,B  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register PC with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x59, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR PC,D 
	 */
	@Test 
	def void testSimpleTFRResultPCD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		PC,D  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x50, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR PC,CC 
	 */
	@Test 
	def void testSimpleTFRResultPCCC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		PC,CC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register PC with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x5A, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR PC,DP 
	 */
	@Test 
	def void testSimpleTFRResultPCDP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		PC,DP  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register PC with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x5B, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR PC,X 
	 */
	@Test 
	def void testSimpleTFRResultPCX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		PC,X  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x51, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR PC,Y 
	 */
	@Test 
	def void testSimpleTFRResultPCY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		PC,Y  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x52, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR PC,S 
	 */
	@Test 
	def void testSimpleTFRResultPCS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		PC,S  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x54, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR PC,U 
	 */
	@Test 
	def void testSimpleTFRResultPCU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		PC,U  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x53, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}

	/**
	 * Check TFR PC,PC 
	 */
	@Test 
	def void testSimpleTFRResultPCPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   TFR		PC,PC  			; test TFR
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.tfrInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register PC with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledTFRInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1F, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x55, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test TFR", line.comment)
	}
}