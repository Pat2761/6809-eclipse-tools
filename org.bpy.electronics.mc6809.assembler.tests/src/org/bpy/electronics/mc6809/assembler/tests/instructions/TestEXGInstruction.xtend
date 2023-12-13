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
import org.bpy.electronics.mc6809.assembler.assembler.ExgInstruction
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledEXGInstruction
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestEXGInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check EXG 8 bits with extra space 
	 */
	@Test 
	def void testSimpleEXGWithExtraSpace1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       EXG		A,B  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EXG directive line", instructionLine.instruction instanceof ExgInstruction)
	}
	
	/**
	 * Check EXG 8 bits with extra space 
	 */
	@Test 
	def void testSimpleEXGWithExtraSpace2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       EXG		CC,DP  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EXG directive line", instructionLine.instruction instanceof ExgInstruction)
	}
	
	/**
	 * Check EXG 16 bits with extra space 
	 */
	@Test 
	def void testSimpleEXGWithExtraSpace3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       EXG		U,S  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EXG directive line", instructionLine.instruction instanceof ExgInstruction)
	}

	/**
	 * Check EXG 16 bits with extra space 
	 */
	@Test 
	def void testSimpleEXGWithExtraSpace4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       EXG		X,Y  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EXG directive line", instructionLine.instruction instanceof ExgInstruction)
	}

	/**
	 * Check EXG 16 bits with extra space 
	 */
	@Test 
	def void testSimpleEXGWithExtraSpace5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       EXG		X,PC  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EXG directive line", instructionLine.instruction instanceof ExgInstruction)
	}

	/**
	 * Check EXG A,A 
	 */
	@Test 
	def void testSimpleEXGResultAA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		A,A  ; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register A with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x88, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG A,B 
	 */
	@Test 
	def void testSimpleEXGResultAB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		A,B  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x89, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG A,D 
	 */
	@Test 
	def void testSimpleEXGResultAD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		A,D  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register A with a part of itself is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x80, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG A,CC 
	 */
	@Test 
	def void testSimpleEXGResultACC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		A,CC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x8A, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG A,DP 
	 */
	@Test 
	def void testSimpleEXGResultADP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		A,DP  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x8B, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG A,X 
	 */
	@Test 
	def void testSimpleEXGResultAX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		A,X  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register A with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x81, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG A,Y 
	 */
	@Test 
	def void testSimpleEXGResultAY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		A,Y  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register A with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x82, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG A,S 
	 */
	@Test 
	def void testSimpleEXGResultAS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		A,S  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register A with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x84, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG A,U 
	 */
	@Test 
	def void testSimpleEXGResultAU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		A,U  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register A with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x83, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG A,PC 
	 */
	@Test 
	def void testSimpleEXGResultAPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		A,PC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register A with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x85, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG B,A 
	 */
	@Test 
	def void testSimpleEXGResultBA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		B,A  ; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x98, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG A,B 
	 */
	@Test 
	def void testSimpleEXGResultBB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		B,B  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register B with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x99, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG B,D 
	 */
	@Test 
	def void testSimpleEXGResultBD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		B,D  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register B with a part of itself is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x90, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG B,CC 
	 */
	@Test 
	def void testSimpleEXGResultBCC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		B,CC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x9A, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG A,DP 
	 */
	@Test 
	def void testSimpleEXGResultBDP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		B,DP  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x9B, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG B,X 
	 */
	@Test 
	def void testSimpleEXGResultBX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		B,X  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register B with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x91, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG B,Y 
	 */
	@Test 
	def void testSimpleEXGResultBY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		B,Y  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register B with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x92, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG B,S 
	 */
	@Test 
	def void testSimpleEXGResultBS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		B,S  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register B with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x94, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG B,U 
	 */
	@Test 
	def void testSimpleEXGResultBU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		B,U  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register B with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x93, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG B,PC 
	 */
	@Test 
	def void testSimpleEXGResultBPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		B,PC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register B with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x95, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG CC,A 
	 */
	@Test 
	def void testSimpleEXGResultCCA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		CC,A  ; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xA8, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG CC,B 
	 */
	@Test 
	def void testSimpleEXGResultCCB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		CC,B  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xA9, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG CC,D 
	 */
	@Test 
	def void testSimpleEXGResultCCD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		CC,D  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register CC with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xA0, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG CC,CC 
	 */
	@Test 
	def void testSimpleEXGResultCCCC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		CC,CC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register CC with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xAA, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG CC,DP 
	 */
	@Test 
	def void testSimpleEXGResultCCDP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		CC,DP  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xAB, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG CC,X 
	 */
	@Test 
	def void testSimpleEXGResultCCX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		CC,X  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register CC with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xA1, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG CC,Y 
	 */
	@Test 
	def void testSimpleEXGResultCCY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		CC,Y  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register CC with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xA2, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG CC,S 
	 */
	@Test 
	def void testSimpleEXGResultCCS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		CC,S  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register CC with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xA4, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG CC,U 
	 */
	@Test 
	def void testSimpleEXGResultCCU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		CC,U  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register CC with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xA3, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG CC,PC 
	 */
	@Test 
	def void testSimpleEXGResultCCPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		CC,PC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register CC with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xA5, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}


	/**
	 * Check EXG DP,A 
	 */
	@Test 
	def void testSimpleEXGResultDPA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		DP,A  ; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xB8, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG DP,B 
	 */
	@Test 
	def void testSimpleEXGResultDPB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		DP,B  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xB9, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG DP,D 
	 */
	@Test 
	def void testSimpleEXGResultDPD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		DP,D  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register DP with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xB0, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG DP,CC 
	 */
	@Test 
	def void testSimpleEXGResultDPCC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		DP,CC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xBA, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG DP,DP 
	 */
	@Test 
	def void testSimpleEXGResultDPDP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		DP,DP  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register DP with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xBB, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG DP,X 
	 */
	@Test 
	def void testSimpleEXGResultDPX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		DP,X  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register DP with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xB1, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG DP,Y 
	 */
	@Test 
	def void testSimpleEXGResultDPY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		DP,Y  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register DP with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xB2, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG DP,S 
	 */
	@Test 
	def void testSimpleEXGResultDPS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		DP,S  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register DP with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xB4, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG DP,U 
	 */
	@Test 
	def void testSimpleEXGResultDPU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		DP,U  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register DP with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xB3, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG DP,PC 
	 */
	@Test 
	def void testSimpleEXGResultDPPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		DP,PC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register DP with a 16 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0xB5, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG D,A 
	 */
	@Test 
	def void testSimpleEXGResultDA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		D,A  ; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register D with a part of itself is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x08, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG D,B 
	 */
	@Test 
	def void testSimpleEXGResultDB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		D,B  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register D with a part of itself is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x09, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG D,D 
	 */
	@Test 
	def void testSimpleEXGResultDD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		D,D  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register D with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x00, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG D,CC 
	 */
	@Test 
	def void testSimpleEXGResultDCC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		D,CC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register D with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x0A, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG D,DP 
	 */
	@Test 
	def void testSimpleEXGResultDDP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		D,DP  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register D with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x0B, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG D,X 
	 */
	@Test 
	def void testSimpleEXGResultDX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		D,X  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x01, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG D,Y 
	 */
	@Test 
	def void testSimpleEXGResultDY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		D,Y  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x02, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG D,S 
	 */
	@Test 
	def void testSimpleEXGResultDS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		D,S  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x04, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG D,U 
	 */
	@Test 
	def void testSimpleEXGResultDU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		D,U  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x03, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG D,PC 
	 */
	@Test 
	def void testSimpleEXGResultDPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		D,PC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x05, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG X,A 
	 */
	@Test 
	def void testSimpleEXGResultXA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		X,A  ; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register X with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x18, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG X,B 
	 */
	@Test 
	def void testSimpleEXGResultXB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		X,B  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register X with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x19, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG X,D 
	 */
	@Test 
	def void testSimpleEXGResultXD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		X,D  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x10, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG X,CC 
	 */
	@Test 
	def void testSimpleEXGResultXCC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		X,CC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register X with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x1A, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG X,DP 
	 */
	@Test 
	def void testSimpleEXGResultXDP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		X,DP  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register X with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x1B, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG X,X 
	 */
	@Test 
	def void testSimpleEXGResultXX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		X,X  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register X with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x11, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG X,Y 
	 */
	@Test 
	def void testSimpleEXGResultXY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		X,Y  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x12, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG X,S 
	 */
	@Test 
	def void testSimpleEXGResultXS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		X,S  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x14, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG X,U 
	 */
	@Test 
	def void testSimpleEXGResultXU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		X,U  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x13, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG X,PC 
	 */
	@Test 
	def void testSimpleEXGResultXPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		X,PC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x15, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG Y,A 
	 */
	@Test 
	def void testSimpleEXGResultYA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		Y,A  ; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register Y with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x28, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG Y,B 
	 */
	@Test 
	def void testSimpleEXGResultYB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		Y,B  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register Y with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x29, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG Y,D 
	 */
	@Test 
	def void testSimpleEXGResultYD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		Y,D  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x20, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG Y,CC 
	 */
	@Test 
	def void testSimpleEXGResultYCC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		Y,CC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register Y with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x2A, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG Y,DP 
	 */
	@Test 
	def void testSimpleEXGResultYDP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		Y,DP  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register Y with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x2B, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG Y,X 
	 */
	@Test 
	def void testSimpleEXGResultYX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		Y,X  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x21, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG Y,Y 
	 */
	@Test 
	def void testSimpleEXGResultYY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		Y,Y  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register Y with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x22, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG Y,S 
	 */
	@Test 
	def void testSimpleEXGResultYS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		Y,S  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x24, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG X,U 
	 */
	@Test 
	def void testSimpleEXGResultYU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		Y,U  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x23, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG Y,PC 
	 */
	@Test 
	def void testSimpleEXGResultYPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		Y,PC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x25, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG U,A 
	 */
	@Test 
	def void testSimpleEXGResultUA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		U,A  ; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register U with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x38, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG U,B 
	 */
	@Test 
	def void testSimpleEXGResultUB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		U,B  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register U with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x39, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG U,D 
	 */
	@Test 
	def void testSimpleEXGResultUD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		U,D  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x30, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG U,CC 
	 */
	@Test 
	def void testSimpleEXGResultUCC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		U,CC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register U with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x3A, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG U,DP 
	 */
	@Test 
	def void testSimpleEXGResultUDP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		U,DP  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register U with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x3B, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG U,X 
	 */
	@Test 
	def void testSimpleEXGResultUX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		U,X  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x31, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG U,Y 
	 */
	@Test 
	def void testSimpleEXGResultUY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		U,Y  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x32, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG U,S 
	 */
	@Test 
	def void testSimpleEXGResultUS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		U,S  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x34, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG U,U 
	 */
	@Test 
	def void testSimpleEXGResultUU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		U,U  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register U with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x33, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG U,PC 
	 */
	@Test 
	def void testSimpleEXGResultUPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		U,PC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x35, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG S,A 
	 */
	@Test 
	def void testSimpleEXGResultSA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		S,A  ; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register S with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x48, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG S,B 
	 */
	@Test 
	def void testSimpleEXGResultSB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		S,B  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register S with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x49, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG S,D 
	 */
	@Test 
	def void testSimpleEXGResultSD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		S,D  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x40, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG S,CC 
	 */
	@Test 
	def void testSimpleEXGResultSCC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		S,CC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register S with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x4A, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG S,DP 
	 */
	@Test 
	def void testSimpleEXGResultSDP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		S,DP  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register S with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x4B, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG S,X 
	 */
	@Test 
	def void testSimpleEXGResultSX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		S,X  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x41, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG S,Y 
	 */
	@Test 
	def void testSimpleEXGResultSY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		S,Y  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x42, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG S,S 
	 */
	@Test 
	def void testSimpleEXGResultSS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		S,S  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register S with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x44, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG S,U 
	 */
	@Test 
	def void testSimpleEXGResultSU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		S,U  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x43, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG S,PC 
	 */
	@Test 
	def void testSimpleEXGResultSPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		S,PC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x45, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG PC,A 
	 */
	@Test 
	def void testSimpleEXGResultPCA() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		PC,A  ; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register PC with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x58, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG PC,B 
	 */
	@Test 
	def void testSimpleEXGResultPCB() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		PC,B  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register PC with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x59, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG PC,D 
	 */
	@Test 
	def void testSimpleEXGResultPCD() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		PC,D  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x50, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG PC,CC 
	 */
	@Test 
	def void testSimpleEXGResultPCCC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		PC,CC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register PC with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x5A, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG PC,DP 
	 */
	@Test 
	def void testSimpleEXGResultPCDP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		PC,DP  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register PC with a 8 bits register is suspicious"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x5B, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG PC,X 
	 */
	@Test 
	def void testSimpleEXGResultPCX() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		PC,X  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x51, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG PC,Y 
	 */
	@Test 
	def void testSimpleEXGResultPCY() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		PC,Y  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x52, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG PC,S 
	 */
	@Test 
	def void testSimpleEXGResultPCS() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		PC,S  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x54, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG PC,U 
	 */
	@Test 
	def void testSimpleEXGResultPCU() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		PC,U  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertNoIssues

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x53, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}

	/**
	 * Check EXG PC,PC 
	 */
	@Test 
	def void testSimpleEXGResultPCPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		ExgText	   EXG		PC,PC  			; test EXG
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		result.assertWarning(
			AssemblerPackage.eINSTANCE.exgInstruction,
			InstructionValidator::ILLEGAL_EXCHANGE,
			"Exchanging the register PC with itself has no effect"
		)

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledEXGInstruction
		Assert.assertEquals("Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x1E, line.opcode.get(0))
		Assert.assertEquals("Operand length", 1, line.operand.length)
		Assert.assertEquals("Check opcode", 0x55, line.operand.get(0))
		Assert.assertEquals("Check label", "ExgText", line.label)
		Assert.assertEquals("Check comment", "; test EXG", line.comment)
	}
}