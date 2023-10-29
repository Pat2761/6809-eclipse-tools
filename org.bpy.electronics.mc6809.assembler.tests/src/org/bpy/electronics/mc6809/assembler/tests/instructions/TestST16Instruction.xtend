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
import org.bpy.electronics.mc6809.assembler.assembler.St16Instruction
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue
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

class TestST16Instruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check STD direct mode 
	 */
	@Test 
	def void testSTDDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STD		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STD instruction", st16Instruction.instruction,"STD")
		assertTrue("Must be a direct addressing mode", st16Instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check STD extended mode 
	 */
	@Test 
	def void testSTDExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STD		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STD instruction", st16Instruction.instruction,"STD")
		assertTrue("Must be a extended addressing mode", st16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check STD extended mode 
	 */
	@Test 
	def void testSTDExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STD		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STD instruction", st16Instruction.instruction,"STD")
		assertTrue("Must be a extended addressing mode", st16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check STD extended indirect mode 
	 */
	@Test 
	def void testSTDExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STD		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STD instruction", st16Instruction.instruction,"STD")
		assertTrue("Must be a extended indirect addressing mode", st16Instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check STD Constant-Offset Indexed 
	 */
	@Test 
	def void testSTDConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STD		  	Const,X
					STD		  	,X
					STD		  	$9,U
					STD		  	$9,S
					STD		  	$9,X
					STD		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STD instruction", st16Instruction.instruction,"STD")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check STD Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testSTDConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STD		  	[Const,X]
					STD		  	[,X]
					STD		  	[$9,U]
					STD		  	[$9,S]
					STD		  	[$9,X]
					STD		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STD instruction", st16Instruction.instruction,"STD")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check STD Accumulator Indexed 
	 */
	@Test 
	def void testSTDAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STD		  	A,X
					STD		  	B,X
					STD		  	D,U
					STD		  	A,S
					STD		  	B,X
					STD		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STD instruction", st16Instruction.instruction,"STD")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check STD Accumulator Indexed Indirect
	 */
	@Test 
	def void testSTDAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STD		  	[A,X]
					STD		  	[B,X]
					STD		  	[D,U]
					STD		  	[A,S]
					STD		  	[B,X]
					STD		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STD instruction", st16Instruction.instruction,"STD")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check STD Auto-Increment Indexed 
	 */
	@Test 
	def void testSTDAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STD		  	0,--X
			       	STD		  	0,-X
			       	STD		  	Const,X+
			       	STD		  	Const,X++
			       	STD		  	0,--S
			       	STD		  	0,-S
			       	STD		  	Const,U+
			       	STD		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STD instruction", st16Instruction.instruction,"STD")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check STD Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testSTDAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STD		  	[0,--X]
			       	STD		  	[0,-X]
			       	STD		  	[Const,X+]
			       	STD		  	[Const,X++]
			       	STD		  	[0,--S]
			       	STD		  	[0,-S]
			       	STD		  	[Const,U+]
			       	STD		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STD instruction", st16Instruction.instruction,"STD")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check STD Relative to PC Indexed 
	 */
	@Test 
	def void testSTDRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STD		  	0,PCR
			       	STD		  	,PCR
			       	STD		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STD instruction", st16Instruction.instruction,"STD")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check STD Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testSTDRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STD		  	[0,PCR]
			       	STD		  	[,PCR]
			       	STD		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STD instruction", st16Instruction.instruction,"STD")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}

	/**
	 * Check STX direct mode 
	 */
	@Test 
	def void testSTXDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STX		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STX instruction", st16Instruction.instruction,"STX")
		assertTrue("Must be a direct addressing mode", st16Instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check STX extended mode 
	 */
	@Test 
	def void testSTXExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STX		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STX instruction", st16Instruction.instruction,"STX")
		assertTrue("Must be a extended addressing mode", st16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check STX extended mode 
	 */
	@Test 
	def void testSTXExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STX		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STX instruction", st16Instruction.instruction,"STX")
		assertTrue("Must be a extended addressing mode", st16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check STX extended indirect mode 
	 */
	@Test 
	def void testSTXExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STX		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STX instruction", st16Instruction.instruction,"STX")
		assertTrue("Must be a extended indirect addressing mode", st16Instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check STX Constant-Offset Indexed 
	 */
	@Test 
	def void testSTXConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STX		  	Const,X
					STX		  	,X
					STX		  	$9,U
					STX		  	$9,S
					STX		  	$9,X
					STX		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STX instruction", st16Instruction.instruction,"STX")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check STX Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testSTXConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STX		  	[Const,X]
					STX		  	[,X]
					STX		  	[$9,U]
					STX		  	[$9,S]
					STX		  	[$9,X]
					STX		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STX instruction", st16Instruction.instruction,"STX")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check STX Accumulator Indexed 
	 */
	@Test 
	def void testSTXAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STX		  	A,X
					STX		  	B,X
					STX		  	D,U
					STX		  	A,S
					STX		  	B,X
					STX		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STX instruction", st16Instruction.instruction,"STX")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check STX Accumulator Indexed Indirect
	 */
	@Test 
	def void testSTXAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STX		  	[A,X]
					STX		  	[B,X]
					STX		  	[D,U]
					STX		  	[A,S]
					STX		  	[B,X]
					STX		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STX instruction", st16Instruction.instruction,"STX")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check STX Auto-Increment Indexed 
	 */
	@Test 
	def void testSTXAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STX		  	0,--X
			       	STX		  	0,-X
			       	STX		  	Const,X+
			       	STX		  	Const,X++
			       	STX		  	0,--S
			       	STX		  	0,-S
			       	STX		  	Const,U+
			       	STX		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STX instruction", st16Instruction.instruction,"STX")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check STX Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testSTXAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STX		  	[0,--X]
			       	STX		  	[0,-X]
			       	STX		  	[Const,X+]
			       	STX		  	[Const,X++]
			       	STX		  	[0,--S]
			       	STX		  	[0,-S]
			       	STX		  	[Const,U+]
			       	STX		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STX instruction", st16Instruction.instruction,"STX")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check STX Relative to PC Indexed 
	 */
	@Test 
	def void testSTXRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STX		  	0,PCR
			       	STX		  	,PCR
			       	STX		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STX instruction", st16Instruction.instruction,"STX")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check STX Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testSTXRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STX		  	[0,PCR]
			       	STX		  	[,PCR]
			       	STX		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STX instruction", st16Instruction.instruction,"STX")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
	
	/**
	 * Check STY direct mode 
	 */
	@Test 
	def void testSTYDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STY		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STY instruction", st16Instruction.instruction,"STY")
		assertTrue("Must be a direct addressing mode", st16Instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check STY extended mode 
	 */
	@Test 
	def void testSTYExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STY		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STY instruction", st16Instruction.instruction,"STY")
		assertTrue("Must be a extended addressing mode", st16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check STY extended mode 
	 */
	@Test 
	def void testSTYExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STY		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STY instruction", st16Instruction.instruction,"STY")
		assertTrue("Must be a extended addressing mode", st16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check STY extended indirect mode 
	 */
	@Test 
	def void testSTYExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STY		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STY instruction", st16Instruction.instruction,"STY")
		assertTrue("Must be a extended indirect addressing mode", st16Instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check STY Constant-Offset Indexed 
	 */
	@Test 
	def void testSTYConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STY		  	Const,X
					STY		  	,X
					STY		  	$9,U
					STY		  	$9,S
					STY		  	$9,X
					STY		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STY instruction", st16Instruction.instruction,"STY")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check STY Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testSTYConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STY		  	[Const,X]
					STY		  	[,X]
					STY		  	[$9,U]
					STY		  	[$9,S]
					STY		  	[$9,X]
					STY		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STY instruction", st16Instruction.instruction,"STY")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check STY Accumulator Indexed 
	 */
	@Test 
	def void testSTYAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STY		  	A,X
					STY		  	B,X
					STY		  	D,U
					STY		  	A,S
					STY		  	B,X
					STY		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STY instruction", st16Instruction.instruction,"STY")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check STY Accumulator Indexed Indirect
	 */
	@Test 
	def void testSTYAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STY		  	[A,X]
					STY		  	[B,X]
					STY		  	[D,U]
					STY		  	[A,S]
					STY		  	[B,X]
					STY		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STY instruction", st16Instruction.instruction,"STY")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check STY Auto-Increment Indexed 
	 */
	@Test 
	def void testSTYAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STY		  	0,--X
			       	STY		  	0,-X
			       	STY		  	Const,X+
			       	STY		  	Const,X++
			       	STY		  	0,--S
			       	STY		  	0,-S
			       	STY		  	Const,U+
			       	STY		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STY instruction", st16Instruction.instruction,"STY")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check STY Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testSTYAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STY		  	[0,--X]
			       	STY		  	[0,-X]
			       	STY		  	[Const,X+]
			       	STY		  	[Const,X++]
			       	STY		  	[0,--S]
			       	STY		  	[0,-S]
			       	STY		  	[Const,U+]
			       	STY		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STY instruction", st16Instruction.instruction,"STY")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check STY Relative to PC Indexed 
	 */
	@Test 
	def void testSTYRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STY		  	0,PCR
			       	STY		  	,PCR
			       	STY		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STY instruction", st16Instruction.instruction,"STY")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check STY Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testSTYRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STY		  	[0,PCR]
			       	STY		  	[,PCR]
			       	STY		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STY instruction", st16Instruction.instruction,"STY")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
	
	/**
	 * Check STS direct mode 
	 */
	@Test 
	def void testSTSDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STS		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STS instruction", st16Instruction.instruction,"STS")
		assertTrue("Must be a direct addressing mode", st16Instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check STS extended mode 
	 */
	@Test 
	def void testSTSExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STS		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STS instruction", st16Instruction.instruction,"STS")
		assertTrue("Must be a extended addressing mode", st16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check STS extended mode 
	 */
	@Test 
	def void testSTSExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STS		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STS instruction", st16Instruction.instruction,"STS")
		assertTrue("Must be a extended addressing mode", st16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check STS extended indirect mode 
	 */
	@Test 
	def void testSTSExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STS		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STS instruction", st16Instruction.instruction,"STS")
		assertTrue("Must be a extended indirect addressing mode", st16Instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check STS Constant-Offset Indexed 
	 */
	@Test 
	def void testSTSConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STS		  	Const,X
					STS		  	,X
					STS		  	$9,U
					STS		  	$9,S
					STS		  	$9,X
					STS		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STS instruction", st16Instruction.instruction,"STS")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check STS Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testSTSConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STS		  	[Const,X]
					STS		  	[,X]
					STS		  	[$9,U]
					STS		  	[$9,S]
					STS		  	[$9,X]
					STS		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STS instruction", st16Instruction.instruction,"STS")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check STS Accumulator Indexed 
	 */
	@Test 
	def void testSTSAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STS		  	A,X
					STS		  	B,X
					STS		  	D,U
					STS		  	A,S
					STS		  	B,X
					STS		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STS instruction", st16Instruction.instruction,"STS")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check STS Accumulator Indexed Indirect
	 */
	@Test 
	def void testSTSAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STS		  	[A,X]
					STS		  	[B,X]
					STS		  	[D,U]
					STS		  	[A,S]
					STS		  	[B,X]
					STS		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STS instruction", st16Instruction.instruction,"STS")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check STS Auto-Increment Indexed 
	 */
	@Test 
	def void testSTSAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STS		  	0,--X
			       	STS		  	0,-X
			       	STS		  	Const,X+
			       	STS		  	Const,X++
			       	STS		  	0,--S
			       	STS		  	0,-S
			       	STS		  	Const,U+
			       	STS		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STS instruction", st16Instruction.instruction,"STS")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check STS Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testSTSAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STS		  	[0,--X]
			       	STS		  	[0,-X]
			       	STS		  	[Const,X+]
			       	STS		  	[Const,X++]
			       	STS		  	[0,--S]
			       	STS		  	[0,-S]
			       	STS		  	[Const,U+]
			       	STS		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STS instruction", st16Instruction.instruction,"STS")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check STS Relative to PC Indexed 
	 */
	@Test 
	def void testSTSRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STS		  	0,PCR
			       	STS		  	,PCR
			       	STS		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STS instruction", st16Instruction.instruction,"STS")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check STS Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testSTSRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STS		  	[0,PCR]
			       	STS		  	[,PCR]
			       	STS		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STS instruction", st16Instruction.instruction,"STS")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
	
	/**
	 * Check STU direct mode 
	 */
	@Test 
	def void testSTUDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STU		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STU instruction", st16Instruction.instruction,"STU")
		assertTrue("Must be a direct addressing mode", st16Instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check STU extended mode 
	 */
	@Test 
	def void testSTUExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STU		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STU instruction", st16Instruction.instruction,"STU")
		assertTrue("Must be a extended addressing mode", st16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check STU extended mode 
	 */
	@Test 
	def void testSTUExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STU		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STU instruction", st16Instruction.instruction,"STU")
		assertTrue("Must be a extended addressing mode", st16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check STU extended indirect mode 
	 */
	@Test 
	def void testSTUExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STU		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STU instruction", st16Instruction.instruction,"STU")
		assertTrue("Must be a extended indirect addressing mode", st16Instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check STU Constant-Offset Indexed 
	 */
	@Test 
	def void testSTUConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STU		  	Const,X
					STU		  	,X
					STU		  	$9,U
					STU		  	$9,S
					STU		  	$9,X
					STU		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STU instruction", st16Instruction.instruction,"STU")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check STU Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testSTUConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STU		  	[Const,X]
					STU		  	[,X]
					STU		  	[$9,U]
					STU		  	[$9,S]
					STU		  	[$9,X]
					STU		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STU instruction", st16Instruction.instruction,"STU")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check STU Accumulator Indexed 
	 */
	@Test 
	def void testSTUAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STU		  	A,X
					STU		  	B,X
					STU		  	D,U
					STU		  	A,S
					STU		  	B,X
					STU		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STU instruction", st16Instruction.instruction,"STU")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check STU Accumulator Indexed Indirect
	 */
	@Test 
	def void testSTUAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STU		  	[A,X]
					STU		  	[B,X]
					STU		  	[D,U]
					STU		  	[A,S]
					STU		  	[B,X]
					STU		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STU instruction", st16Instruction.instruction,"STU")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check STU Auto-Increment Indexed 
	 */
	@Test 
	def void testSTUAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STU		  	0,--X
			       	STU		  	0,-X
			       	STU		  	Const,X+
			       	STU		  	Const,X++
			       	STU		  	0,--S
			       	STU		  	0,-S
			       	STU		  	Const,U+
			       	STU		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STU instruction", st16Instruction.instruction,"STU")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check STU Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testSTUAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STU		  	[0,--X]
			       	STU		  	[0,-X]
			       	STU		  	[Const,X+]
			       	STU		  	[Const,X++]
			       	STU		  	[0,--S]
			       	STU		  	[0,-S]
			       	STU		  	[Const,U+]
			       	STU		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STU instruction", st16Instruction.instruction,"STU")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check STU Relative to PC Indexed 
	 */
	@Test 
	def void testSTURelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STU		  	0,PCR
			       	STU		  	,PCR
			       	STU		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STU instruction", st16Instruction.instruction,"STU")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check STU Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testSTURelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STU		  	[0,PCR]
			       	STU		  	[,PCR]
			       	STU		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST16 directive line", instructionLine.instruction instanceof St16Instruction)

		val st16Instruction = instructionLine.instruction as St16Instruction
		assertEquals("Must be an STU instruction", st16Instruction.instruction,"STU")
		assertTrue("Must be a Constant-Offset Indexed mode", st16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}