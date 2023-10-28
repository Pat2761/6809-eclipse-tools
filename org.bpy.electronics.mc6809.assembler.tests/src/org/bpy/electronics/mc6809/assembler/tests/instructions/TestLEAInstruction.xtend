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
import org.bpy.electronics.mc6809.assembler.assembler.LeaInstruction
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMode
import org.bpy.electronics.mc6809.assembler.assembler.IndexedOperand
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingMode
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecMode
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCMode

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestLEAInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check LEAX Constant-Offset Indexed 
	 */
	@Test 
	def void testLEAXConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LEAX		  	Const,X
					LEAX		  	,X
					LEAX		  	$9,U
					LEAX		  	$9,S
					LEAX		  	$9,X
					LEAX		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof LeaInstruction)

		val leaInstruction = instructionLine.instruction as LeaInstruction
		assertEquals("Must be an LEAX instruction", leaInstruction.instruction,"LEAX")
		assertTrue("Must be a Constant-Offset Indexed mode", leaInstruction.operand instanceof IndexedOperand)
		val indexedOperand = leaInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check LEAX Accumulator Indexed 
	 */
	@Test 
	def void testLEAXAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LEAX		  	A,X
					LEAX		  	B,X
					LEAX		  	D,U
					LEAX		  	A,S
					LEAX		  	B,X
					LEAX		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof LeaInstruction)

		val leaInstruction = instructionLine.instruction as LeaInstruction
		assertEquals("Must be an LEAX instruction", leaInstruction.instruction,"LEAX")
		assertTrue("Must be a Constant-Offset Indexed mode", leaInstruction.operand instanceof IndexedOperand)
		val indexedOperand = leaInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check LEAX Auto-Increment Indexed 
	 */
	@Test 
	def void testLEAXAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LEAX		  	0,--X
			       	LEAX		  	0,-X
			       	LEAX		  	Const,X+
			       	LEAX		  	Const,X++
			       	LEAX		  	0,--S
			       	LEAX		  	0,-S
			       	LEAX		  	Const,U+
			       	LEAX		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof LeaInstruction)

		val leaInstruction = instructionLine.instruction as LeaInstruction
		assertEquals("Must be an LEAX instruction", leaInstruction.instruction,"LEAX")
		assertTrue("Must be a Constant-Offset Indexed mode", leaInstruction.operand instanceof IndexedOperand)
		val indexedOperand = leaInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}

	/**
	 * Check LEAX Relative to PC Indexed 
	 */
	@Test 
	def void testLEAXRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LEAX		  	0,PCR
			       	LEAX		  	,PCR
			       	LEAX		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof LeaInstruction)

		val leaInstruction = instructionLine.instruction as LeaInstruction
		assertEquals("Must be an LEAX instruction", leaInstruction.instruction,"LEAX")
		assertTrue("Must be a Constant-Offset Indexed mode", leaInstruction.operand instanceof IndexedOperand)
		val indexedOperand = leaInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}

	/**
	 * Check LEAY Constant-Offset Indexed 
	 */
	@Test 
	def void testLEAYConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LEAY		  	Const,X
					LEAY		  	,X
					LEAY		  	$9,U
					LEAY		  	$9,S
					LEAY		  	$9,X
					LEAY		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof LeaInstruction)

		val leaInstruction = instructionLine.instruction as LeaInstruction
		assertEquals("Must be an LEAY instruction", leaInstruction.instruction,"LEAY")
		assertTrue("Must be a Constant-Offset Indexed mode", leaInstruction.operand instanceof IndexedOperand)
		val indexedOperand = leaInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check LEAY Accumulator Indexed 
	 */
	@Test 
	def void testLEAYAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LEAY		  	A,X
					LEAY		  	B,X
					LEAY		  	D,U
					LEAY		  	A,S
					LEAY		  	B,X
					LEAY		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof LeaInstruction)

		val leaInstruction = instructionLine.instruction as LeaInstruction
		assertEquals("Must be an LEAY instruction", leaInstruction.instruction,"LEAY")
		assertTrue("Must be a Constant-Offset Indexed mode", leaInstruction.operand instanceof IndexedOperand)
		val indexedOperand = leaInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check LEAY Auto-Increment Indexed 
	 */
	@Test 
	def void testLEAYAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LEAY		  	0,--X
			       	LEAY		  	0,-X
			       	LEAY		  	Const,X+
			       	LEAY		  	Const,X++
			       	LEAY		  	0,--S
			       	LEAY		  	0,-S
			       	LEAY		  	Const,U+
			       	LEAY		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof LeaInstruction)

		val leaInstruction = instructionLine.instruction as LeaInstruction
		assertEquals("Must be an LEAY instruction", leaInstruction.instruction,"LEAY")
		assertTrue("Must be a Constant-Offset Indexed mode", leaInstruction.operand instanceof IndexedOperand)
		val indexedOperand = leaInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}

	/**
	 * Check LEAY Relative to PC Indexed 
	 */
	@Test 
	def void testLEAYRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LEAY		  	0,PCR
			       	LEAY		  	,PCR
			       	LEAY		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof LeaInstruction)

		val leaInstruction = instructionLine.instruction as LeaInstruction
		assertEquals("Must be an LEAY instruction", leaInstruction.instruction,"LEAY")
		assertTrue("Must be a Constant-Offset Indexed mode", leaInstruction.operand instanceof IndexedOperand)
		val indexedOperand = leaInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check LEAS Constant-Offset Indexed 
	 */
	@Test 
	def void testLEASConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LEAS		  	Const,X
					LEAS		  	,X
					LEAS		  	$9,U
					LEAS		  	$9,S
					LEAS		  	$9,X
					LEAS		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof LeaInstruction)

		val leaInstruction = instructionLine.instruction as LeaInstruction
		assertEquals("Must be an LEAS instruction", leaInstruction.instruction,"LEAS")
		assertTrue("Must be a Constant-Offset Indexed mode", leaInstruction.operand instanceof IndexedOperand)
		val indexedOperand = leaInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check LEAS Accumulator Indexed 
	 */
	@Test 
	def void testLEASAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LEAS		  	A,X
					LEAS		  	B,X
					LEAS		  	D,U
					LEAS		  	A,S
					LEAS		  	B,X
					LEAS		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof LeaInstruction)

		val leaInstruction = instructionLine.instruction as LeaInstruction
		assertEquals("Must be an LEAS instruction", leaInstruction.instruction,"LEAS")
		assertTrue("Must be a Constant-Offset Indexed mode", leaInstruction.operand instanceof IndexedOperand)
		val indexedOperand = leaInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check LEAS Auto-Increment Indexed 
	 */
	@Test 
	def void testLEASAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LEAS		  	0,--X
			       	LEAS		  	0,-X
			       	LEAS		  	Const,X+
			       	LEAS		  	Const,X++
			       	LEAS		  	0,--S
			       	LEAS		  	0,-S
			       	LEAS		  	Const,U+
			       	LEAS		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof LeaInstruction)

		val leaInstruction = instructionLine.instruction as LeaInstruction
		assertEquals("Must be an LEAS instruction", leaInstruction.instruction,"LEAS")
		assertTrue("Must be a Constant-Offset Indexed mode", leaInstruction.operand instanceof IndexedOperand)
		val indexedOperand = leaInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}

	/**
	 * Check LEAS Relative to PC Indexed 
	 */
	@Test 
	def void testLEASRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LEAS		  	0,PCR
			       	LEAS		  	,PCR
			       	LEAS		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof LeaInstruction)

		val leaInstruction = instructionLine.instruction as LeaInstruction
		assertEquals("Must be an LEAS instruction", leaInstruction.instruction,"LEAS")
		assertTrue("Must be a Constant-Offset Indexed mode", leaInstruction.operand instanceof IndexedOperand)
		val indexedOperand = leaInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}

	/**
	 * Check LEAU Constant-Offset Indexed 
	 */
	@Test 
	def void testLEAUConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LEAU		  	Const,X
					LEAU		  	,X
					LEAU		  	$9,U
					LEAU		  	$9,S
					LEAU		  	$9,X
					LEAU		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof LeaInstruction)

		val leaInstruction = instructionLine.instruction as LeaInstruction
		assertEquals("Must be an LEAU instruction", leaInstruction.instruction,"LEAU")
		assertTrue("Must be a Constant-Offset Indexed mode", leaInstruction.operand instanceof IndexedOperand)
		val indexedOperand = leaInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check LEAU Accumulator Indexed 
	 */
	@Test 
	def void testLEAUAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LEAU		  	A,X
					LEAU		  	B,X
					LEAU		  	D,U
					LEAU		  	A,S
					LEAU		  	B,X
					LEAU		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof LeaInstruction)

		val leaInstruction = instructionLine.instruction as LeaInstruction
		assertEquals("Must be an LEAU instruction", leaInstruction.instruction,"LEAU")
		assertTrue("Must be a Constant-Offset Indexed mode", leaInstruction.operand instanceof IndexedOperand)
		val indexedOperand = leaInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check LEAU Auto-Increment Indexed 
	 */
	@Test 
	def void testLEAUAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LEAU		  	0,--X
			       	LEAU		  	0,-X
			       	LEAU		  	Const,X+
			       	LEAU		  	Const,X++
			       	LEAU		  	0,--S
			       	LEAU		  	0,-S
			       	LEAU		  	Const,U+
			       	LEAU		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof LeaInstruction)

		val leaInstruction = instructionLine.instruction as LeaInstruction
		assertEquals("Must be an LEAU instruction", leaInstruction.instruction,"LEAU")
		assertTrue("Must be a Constant-Offset Indexed mode", leaInstruction.operand instanceof IndexedOperand)
		val indexedOperand = leaInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}

	/**
	 * Check LEAU Relative to PC Indexed 
	 */
	@Test 
	def void testLEAURelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LEAU		  	0,PCR
			       	LEAU		  	,PCR
			       	LEAU		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof LeaInstruction)

		val leaInstruction = instructionLine.instruction as LeaInstruction
		assertEquals("Must be an LEAU instruction", leaInstruction.instruction,"LEAU")
		assertTrue("Must be a Constant-Offset Indexed mode", leaInstruction.operand instanceof IndexedOperand)
		val indexedOperand = leaInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
}