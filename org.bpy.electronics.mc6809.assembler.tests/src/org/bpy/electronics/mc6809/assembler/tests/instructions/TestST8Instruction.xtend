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
import org.bpy.electronics.mc6809.assembler.assembler.St8Instruction
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

class TestST8Instruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check STA direct mode 
	 */
	@Test 
	def void testSTADirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STA		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STA instruction", st8Instruction.instruction,"STA")
		assertTrue("Must be a direct addressing mode", st8Instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check STA extended mode 
	 */
	@Test 
	def void testSTAExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STA		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STA instruction", st8Instruction.instruction,"STA")
		assertTrue("Must be a extended addressing mode", st8Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check STA extended mode 
	 */
	@Test 
	def void testSTAExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STA		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STA instruction", st8Instruction.instruction,"STA")
		assertTrue("Must be a extended addressing mode", st8Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check STA extended indirect mode 
	 */
	@Test 
	def void testSTAExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STA		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STA instruction", st8Instruction.instruction,"STA")
		assertTrue("Must be a extended indirect addressing mode", st8Instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check STA Constant-Offset Indexed 
	 */
	@Test 
	def void testSTAConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STA		  	Const,X
					STA		  	,X
					STA		  	$9,U
					STA		  	$9,S
					STA		  	$9,X
					STA		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STA instruction", st8Instruction.instruction,"STA")
		assertTrue("Must be a Constant-Offset Indexed mode", st8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st8Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check STA Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testSTAConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STA		  	[Const,X]
					STA		  	[,X]
					STA		  	[$9,U]
					STA		  	[$9,S]
					STA		  	[$9,X]
					STA		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STA instruction", st8Instruction.instruction,"STA")
		assertTrue("Must be a Constant-Offset Indexed mode", st8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st8Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check STA Accumulator Indexed 
	 */
	@Test 
	def void testSTAAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STA		  	A,X
					STA		  	B,X
					STA		  	D,U
					STA		  	A,S
					STA		  	B,X
					STA		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STA instruction", st8Instruction.instruction,"STA")
		assertTrue("Must be a Constant-Offset Indexed mode", st8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st8Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check STA Accumulator Indexed Indirect
	 */
	@Test 
	def void testSTAAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STA		  	[A,X]
					STA		  	[B,X]
					STA		  	[D,U]
					STA		  	[A,S]
					STA		  	[B,X]
					STA		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STA instruction", st8Instruction.instruction,"STA")
		assertTrue("Must be a Constant-Offset Indexed mode", st8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st8Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check STA Auto-Increment Indexed 
	 */
	@Test 
	def void testSTAAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STA		  	0,--X
			       	STA		  	0,-X
			       	STA		  	Const,X+
			       	STA		  	Const,X++
			       	STA		  	0,--S
			       	STA		  	0,-S
			       	STA		  	Const,U+
			       	STA		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STA instruction", st8Instruction.instruction,"STA")
		assertTrue("Must be a Constant-Offset Indexed mode", st8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st8Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check STA Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testSTAAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STA		  	[0,--X]
			       	STA		  	[0,-X]
			       	STA		  	[Const,X+]
			       	STA		  	[Const,X++]
			       	STA		  	[0,--S]
			       	STA		  	[0,-S]
			       	STA		  	[Const,U+]
			       	STA		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STA instruction", st8Instruction.instruction,"STA")
		assertTrue("Must be a Constant-Offset Indexed mode", st8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st8Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check STA Relative to PC Indexed 
	 */
	@Test 
	def void testSTARelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STA		  	0,PCR
			       	STA		  	,PCR
			       	STA		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STA instruction", st8Instruction.instruction,"STA")
		assertTrue("Must be a Constant-Offset Indexed mode", st8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st8Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check STA Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testSTARelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STA		  	[0,PCR]
			       	STA		  	[,PCR]
			       	STA		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STA instruction", st8Instruction.instruction,"STA")
		assertTrue("Must be a Constant-Offset Indexed mode", st8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st8Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}

	/**
	 * Check STB direct mode 
	 */
	@Test 
	def void testSTBDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STB		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STB instruction", st8Instruction.instruction,"STB")
		assertTrue("Must be a direct addressing mode", st8Instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check STB extended mode 
	 */
	@Test 
	def void testSTBExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STB		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STB instruction", st8Instruction.instruction,"STB")
		assertTrue("Must be a extended addressing mode", st8Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check STB extended mode 
	 */
	@Test 
	def void testSTBExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STB		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STB instruction", st8Instruction.instruction,"STB")
		assertTrue("Must be a extended addressing mode", st8Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check STB extended indirect mode 
	 */
	@Test 
	def void testSTBExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STB		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STB instruction", st8Instruction.instruction,"STB")
		assertTrue("Must be a extended indirect addressing mode", st8Instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check STB Constant-Offset Indexed 
	 */
	@Test 
	def void testSTBConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STB		  	Const,X
					STB		  	,X
					STB		  	$9,U
					STB		  	$9,S
					STB		  	$9,X
					STB		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STB instruction", st8Instruction.instruction,"STB")
		assertTrue("Must be a Constant-Offset Indexed mode", st8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st8Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check STB Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testSTBConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STB		  	[Const,X]
					STB		  	[,X]
					STB		  	[$9,U]
					STB		  	[$9,S]
					STB		  	[$9,X]
					STB		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STB instruction", st8Instruction.instruction,"STB")
		assertTrue("Must be a Constant-Offset Indexed mode", st8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st8Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check STB Accumulator Indexed 
	 */
	@Test 
	def void testSTBAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STB		  	A,X
					STB		  	B,X
					STB		  	D,U
					STB		  	A,S
					STB		  	B,X
					STB		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STB instruction", st8Instruction.instruction,"STB")
		assertTrue("Must be a Constant-Offset Indexed mode", st8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st8Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check STB Accumulator Indexed Indirect
	 */
	@Test 
	def void testSTBAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STB		  	[A,X]
					STB		  	[B,X]
					STB		  	[D,U]
					STB		  	[A,S]
					STB		  	[B,X]
					STB		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STB instruction", st8Instruction.instruction,"STB")
		assertTrue("Must be a Constant-Offset Indexed mode", st8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st8Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check STB Auto-Increment Indexed 
	 */
	@Test 
	def void testSTBAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STB		  	0,--X
			       	STB		  	0,-X
			       	STB		  	Const,X+
			       	STB		  	Const,X++
			       	STB		  	0,--S
			       	STB		  	0,-S
			       	STB		  	Const,U+
			       	STB		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STB instruction", st8Instruction.instruction,"STB")
		assertTrue("Must be a Constant-Offset Indexed mode", st8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st8Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check STB Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testSTBAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STB		  	[0,--X]
			       	STB		  	[0,-X]
			       	STB		  	[Const,X+]
			       	STB		  	[Const,X++]
			       	STB		  	[0,--S]
			       	STB		  	[0,-S]
			       	STB		  	[Const,U+]
			       	STB		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STB instruction", st8Instruction.instruction,"STB")
		assertTrue("Must be a Constant-Offset Indexed mode", st8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st8Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check STB Relative to PC Indexed 
	 */
	@Test 
	def void testSTBRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STB		  	0,PCR
			       	STB		  	,PCR
			       	STB		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STB instruction", st8Instruction.instruction,"STB")
		assertTrue("Must be a Constant-Offset Indexed mode", st8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st8Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check STB Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testSTBRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STB		  	[0,PCR]
			       	STB		  	[,PCR]
			       	STB		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ST8 directive line", instructionLine.instruction instanceof St8Instruction)

		val st8Instruction = instructionLine.instruction as St8Instruction
		assertEquals("Must be an STB instruction", st8Instruction.instruction,"STB")
		assertTrue("Must be a Constant-Offset Indexed mode", st8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = st8Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}