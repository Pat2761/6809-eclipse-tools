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
import org.bpy.electronics.mc6809.assembler.assembler.Ld8Instruction
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue
import org.bpy.electronics.mc6809.assembler.assembler.ImmediatOperand
import org.bpy.electronics.mc6809.assembler.assembler.DirectOperand
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedOperand
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedIndirectOperand
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMode
import org.bpy.electronics.mc6809.assembler.assembler.IndexedOperand
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingMode
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecMode
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCMode
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecIndirectMode
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingIndirectMode
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCIndirectMode

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestLD8Instruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check LDA immediat 
	 */
	@Test 
	def void testLDAImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDA		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDA instruction", ld8Instruction.instruction,"LDA")
		assertTrue("Must be an immediate addressing mode", ld8Instruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check LDA direct mode 
	 */
	@Test 
	def void testLDADirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDA		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDA instruction", ld8Instruction.instruction,"LDA")
		assertTrue("Must be a direct addressing mode", ld8Instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check LDA extended mode 
	 */
	@Test 
	def void testLDAExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDA		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDA instruction", ld8Instruction.instruction,"LDA")
		assertTrue("Must be a extended addressing mode", ld8Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDA extended mode 
	 */
	@Test 
	def void testLDAExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDA		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDA instruction", ld8Instruction.instruction,"LDA")
		assertTrue("Must be a extended addressing mode", ld8Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDA extended indirect mode 
	 */
	@Test 
	def void testLDAExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDA		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDA instruction", ld8Instruction.instruction,"LDA")
		assertTrue("Must be a extended indirect addressing mode", ld8Instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check LDA Constant-Offset Indexed 
	 */
	@Test 
	def void testLDAConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDA		  	Const,X
					LDA		  	,X
					LDA		  	$9,U
					LDA		  	$9,S
					LDA		  	$9,X
					LDA		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDA instruction", ld8Instruction.instruction,"LDA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check LDA Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testLDAConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDA		  	[Const,X]
					LDA		  	[,X]
					LDA		  	[$9,U]
					LDA		  	[$9,S]
					LDA		  	[$9,X]
					LDA		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDA instruction", ld8Instruction.instruction,"LDA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check LDA Accumulator Indexed 
	 */
	@Test 
	def void testLDAAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDA		  	A,X
					LDA		  	B,X
					LDA		  	D,U
					LDA		  	A,S
					LDA		  	B,X
					LDA		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDA instruction", ld8Instruction.instruction,"LDA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check LDA Accumulator Indexed Indirect
	 */
	@Test 
	def void testLDAAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDA		  	[A,X]
					LDA		  	[B,X]
					LDA		  	[D,U]
					LDA		  	[A,S]
					LDA		  	[B,X]
					LDA		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDA instruction", ld8Instruction.instruction,"LDA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check LDA Auto-Increment Indexed 
	 */
	@Test 
	def void testLDAAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDA		  	0,--X
			       	LDA		  	0,-X
			       	LDA		  	Const,X+
			       	LDA		  	Const,X++
			       	LDA		  	0,--S
			       	LDA		  	0,-S
			       	LDA		  	Const,U+
			       	LDA		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDA instruction", ld8Instruction.instruction,"LDA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check LDA Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testLDAAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDA		  	[0,--X]
			       	LDA		  	[0,-X]
			       	LDA		  	[Const,X+]
			       	LDA		  	[Const,X++]
			       	LDA		  	[0,--S]
			       	LDA		  	[0,-S]
			       	LDA		  	[Const,U+]
			       	LDA		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDA instruction", ld8Instruction.instruction,"LDA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check LDA Relative to PC Indexed 
	 */
	@Test 
	def void testLDARelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDA		  	0,PCR
			       	LDA		  	,PCR
			       	LDA		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDA instruction", ld8Instruction.instruction,"LDA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check LDA Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testLDARelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDA		  	[0,PCR]
			       	LDA		  	[,PCR]
			       	LDA		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDA instruction", ld8Instruction.instruction,"LDA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}

	/**
	 * Check LDB immediat 
	 */
	@Test 
	def void testLDBImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDB		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDB instruction", ld8Instruction.instruction,"LDB")
		assertTrue("Must be an immediate addressing mode", ld8Instruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check LDB direct mode 
	 */
	@Test 
	def void testLDBDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDB		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDB instruction", ld8Instruction.instruction,"LDB")
		assertTrue("Must be a direct addressing mode", ld8Instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check LDB extended mode 
	 */
	@Test 
	def void testLDBExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDB		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDB instruction", ld8Instruction.instruction,"LDB")
		assertTrue("Must be a extended addressing mode", ld8Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDB extended mode 
	 */
	@Test 
	def void testLDBExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDB		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDB instruction", ld8Instruction.instruction,"LDB")
		assertTrue("Must be a extended addressing mode", ld8Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDB extended indirect mode 
	 */
	@Test 
	def void testLDBExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDB		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDB instruction", ld8Instruction.instruction,"LDB")
		assertTrue("Must be a extended indirect addressing mode", ld8Instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check LDB Constant-Offset Indexed 
	 */
	@Test 
	def void testLDBConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDB		  	Const,X
					LDB		  	,X
					LDB		  	$9,U
					LDB		  	$9,S
					LDB		  	$9,X
					LDB		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDB instruction", ld8Instruction.instruction,"LDB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check LDB Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testLDBConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDB		  	[Const,X]
					LDB		  	[,X]
					LDB		  	[$9,U]
					LDB		  	[$9,S]
					LDB		  	[$9,X]
					LDB		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDB instruction", ld8Instruction.instruction,"LDB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check LDB Accumulator Indexed 
	 */
	@Test 
	def void testLDBAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDB		  	A,X
					LDB		  	B,X
					LDB		  	D,U
					LDB		  	A,S
					LDB		  	B,X
					LDB		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDB instruction", ld8Instruction.instruction,"LDB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check LDB Accumulator Indexed Indirect
	 */
	@Test 
	def void testLDBAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDB		  	[A,X]
					LDB		  	[B,X]
					LDB		  	[D,U]
					LDB		  	[A,S]
					LDB		  	[B,X]
					LDB		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDB instruction", ld8Instruction.instruction,"LDB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check LDB Auto-Increment Indexed 
	 */
	@Test 
	def void testLDBAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDB		  	0,--X
			       	LDB		  	0,-X
			       	LDB		  	Const,X+
			       	LDB		  	Const,X++
			       	LDB		  	0,--S
			       	LDB		  	0,-S
			       	LDB		  	Const,U+
			       	LDB		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDB instruction", ld8Instruction.instruction,"LDB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check LDB Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testLDBAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDB		  	[0,--X]
			       	LDB		  	[0,-X]
			       	LDB		  	[Const,X+]
			       	LDB		  	[Const,X++]
			       	LDB		  	[0,--S]
			       	LDB		  	[0,-S]
			       	LDB		  	[Const,U+]
			       	LDB		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDB instruction", ld8Instruction.instruction,"LDB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check LDB Relative to PC Indexed 
	 */
	@Test 
	def void testLDBRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDB		  	0,PCR
			       	LDB		  	,PCR
			       	LDB		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDB instruction", ld8Instruction.instruction,"LDB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check LDB Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testLDBRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDB		  	[0,PCR]
			       	LDB		  	[,PCR]
			       	LDB		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD8 directive line", instructionLine.instruction instanceof Ld8Instruction)

		val ld8Instruction = instructionLine.instruction as Ld8Instruction
		assertEquals("Must be an LDB instruction", ld8Instruction.instruction,"LDB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}