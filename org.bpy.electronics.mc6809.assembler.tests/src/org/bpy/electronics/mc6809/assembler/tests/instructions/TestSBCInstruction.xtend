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
import org.bpy.electronics.mc6809.assembler.assembler.SbcInstruction
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

class TestSBCInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check SBCA immediat 
	 */
	@Test 
	def void testSBCAImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SBCA		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCA instruction", ld8Instruction.instruction,"SBCA")
		assertTrue("Must be an immediate addressing mode", ld8Instruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check SBCA direct mode 
	 */
	@Test 
	def void testSBCADirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SBCA		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCA instruction", ld8Instruction.instruction,"SBCA")
		assertTrue("Must be a direct addressing mode", ld8Instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check SBCA extended mode 
	 */
	@Test 
	def void testSBCAExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SBCA		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCA instruction", ld8Instruction.instruction,"SBCA")
		assertTrue("Must be a extended addressing mode", ld8Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check SBCA extended mode 
	 */
	@Test 
	def void testSBCAExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SBCA		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCA instruction", ld8Instruction.instruction,"SBCA")
		assertTrue("Must be a extended addressing mode", ld8Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check SBCA extended indirect mode 
	 */
	@Test 
	def void testSBCAExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SBCA		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCA instruction", ld8Instruction.instruction,"SBCA")
		assertTrue("Must be a extended indirect addressing mode", ld8Instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check SBCA Constant-Offset Indexed 
	 */
	@Test 
	def void testSBCAConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SBCA		  	Const,X
					SBCA		  	,X
					SBCA		  	$9,U
					SBCA		  	$9,S
					SBCA		  	$9,X
					SBCA		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCA instruction", ld8Instruction.instruction,"SBCA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check SBCA Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testSBCAConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SBCA		  	[Const,X]
					SBCA		  	[,X]
					SBCA		  	[$9,U]
					SBCA		  	[$9,S]
					SBCA		  	[$9,X]
					SBCA		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCA instruction", ld8Instruction.instruction,"SBCA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check SBCA Accumulator Indexed 
	 */
	@Test 
	def void testSBCAAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SBCA		  	A,X
					SBCA		  	B,X
					SBCA		  	D,U
					SBCA		  	A,S
					SBCA		  	B,X
					SBCA		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCA instruction", ld8Instruction.instruction,"SBCA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check SBCA Accumulator Indexed Indirect
	 */
	@Test 
	def void testSBCAAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SBCA		  	[A,X]
					SBCA		  	[B,X]
					SBCA		  	[D,U]
					SBCA		  	[A,S]
					SBCA		  	[B,X]
					SBCA		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCA instruction", ld8Instruction.instruction,"SBCA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check SBCA Auto-Increment Indexed 
	 */
	@Test 
	def void testSBCAAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SBCA		  	0,--X
			       	SBCA		  	0,-X
			       	SBCA		  	Const,X+
			       	SBCA		  	Const,X++
			       	SBCA		  	0,--S
			       	SBCA		  	0,-S
			       	SBCA		  	Const,U+
			       	SBCA		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCA instruction", ld8Instruction.instruction,"SBCA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check SBCA Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testSBCAAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SBCA		  	[0,--X]
			       	SBCA		  	[0,-X]
			       	SBCA		  	[Const,X+]
			       	SBCA		  	[Const,X++]
			       	SBCA		  	[0,--S]
			       	SBCA		  	[0,-S]
			       	SBCA		  	[Const,U+]
			       	SBCA		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCA instruction", ld8Instruction.instruction,"SBCA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check SBCA Relative to PC Indexed 
	 */
	@Test 
	def void testSBCARelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SBCA		  	0,PCR
			       	SBCA		  	,PCR
			       	SBCA		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCA instruction", ld8Instruction.instruction,"SBCA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check SBCA Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testSBCARelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SBCA		  	[0,PCR]
			       	SBCA		  	[,PCR]
			       	SBCA		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCA instruction", ld8Instruction.instruction,"SBCA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}

	/**
	 * Check SBCB immediat 
	 */
	@Test 
	def void testSBCBImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SBCB		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCB instruction", ld8Instruction.instruction,"SBCB")
		assertTrue("Must be an immediate addressing mode", ld8Instruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check SBCB direct mode 
	 */
	@Test 
	def void testSBCBDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SBCB		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCB instruction", ld8Instruction.instruction,"SBCB")
		assertTrue("Must be a direct addressing mode", ld8Instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check SBCB extended mode 
	 */
	@Test 
	def void testSBCBExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SBCB		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCB instruction", ld8Instruction.instruction,"SBCB")
		assertTrue("Must be a extended addressing mode", ld8Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check SBCB extended mode 
	 */
	@Test 
	def void testSBCBExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SBCB		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCB instruction", ld8Instruction.instruction,"SBCB")
		assertTrue("Must be a extended addressing mode", ld8Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check SBCB extended indirect mode 
	 */
	@Test 
	def void testSBCBExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SBCB		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCB instruction", ld8Instruction.instruction,"SBCB")
		assertTrue("Must be a extended indirect addressing mode", ld8Instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check SBCB Constant-Offset Indexed 
	 */
	@Test 
	def void testSBCBConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SBCB		  	Const,X
					SBCB		  	,X
					SBCB		  	$9,U
					SBCB		  	$9,S
					SBCB		  	$9,X
					SBCB		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCB instruction", ld8Instruction.instruction,"SBCB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check SBCB Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testSBCBConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SBCB		  	[Const,X]
					SBCB		  	[,X]
					SBCB		  	[$9,U]
					SBCB		  	[$9,S]
					SBCB		  	[$9,X]
					SBCB		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCB instruction", ld8Instruction.instruction,"SBCB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check SBCB Accumulator Indexed 
	 */
	@Test 
	def void testSBCBAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SBCB		  	A,X
					SBCB		  	B,X
					SBCB		  	D,U
					SBCB		  	A,S
					SBCB		  	B,X
					SBCB		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCB instruction", ld8Instruction.instruction,"SBCB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check SBCB Accumulator Indexed Indirect
	 */
	@Test 
	def void testSBCBAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SBCB		  	[A,X]
					SBCB		  	[B,X]
					SBCB		  	[D,U]
					SBCB		  	[A,S]
					SBCB		  	[B,X]
					SBCB		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCB instruction", ld8Instruction.instruction,"SBCB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check SBCB Auto-Increment Indexed 
	 */
	@Test 
	def void testSBCBAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SBCB		  	0,--X
			       	SBCB		  	0,-X
			       	SBCB		  	Const,X+
			       	SBCB		  	Const,X++
			       	SBCB		  	0,--S
			       	SBCB		  	0,-S
			       	SBCB		  	Const,U+
			       	SBCB		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCB instruction", ld8Instruction.instruction,"SBCB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check SBCB Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testSBCBAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SBCB		  	[0,--X]
			       	SBCB		  	[0,-X]
			       	SBCB		  	[Const,X+]
			       	SBCB		  	[Const,X++]
			       	SBCB		  	[0,--S]
			       	SBCB		  	[0,-S]
			       	SBCB		  	[Const,U+]
			       	SBCB		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCB instruction", ld8Instruction.instruction,"SBCB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check SBCB Relative to PC Indexed 
	 */
	@Test 
	def void testSBCBRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SBCB		  	0,PCR
			       	SBCB		  	,PCR
			       	SBCB		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCB instruction", ld8Instruction.instruction,"SBCB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check SBCB Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testSBCBRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SBCB		  	[0,PCR]
			       	SBCB		  	[,PCR]
			       	SBCB		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SBC directive line", instructionLine.instruction instanceof SbcInstruction)

		val ld8Instruction = instructionLine.instruction as SbcInstruction
		assertEquals("Must be an SBCB instruction", ld8Instruction.instruction,"SBCB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}