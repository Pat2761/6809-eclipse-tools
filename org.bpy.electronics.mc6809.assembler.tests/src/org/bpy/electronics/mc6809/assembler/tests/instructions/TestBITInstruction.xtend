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
import org.bpy.electronics.mc6809.assembler.assembler.BitInstruction
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

class TestBITInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check BITA immediat 
	 */
	@Test 
	def void testBITAImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       BITA		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITA instruction", ld8Instruction.instruction,"BITA")
		assertTrue("Must be an immediate addressing mode", ld8Instruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check BITA direct mode 
	 */
	@Test 
	def void testBITADirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       BITA		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITA instruction", ld8Instruction.instruction,"BITA")
		assertTrue("Must be a direct addressing mode", ld8Instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check BITA extended mode 
	 */
	@Test 
	def void testBITAExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       BITA		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITA instruction", ld8Instruction.instruction,"BITA")
		assertTrue("Must be a extended addressing mode", ld8Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check BITA extended mode 
	 */
	@Test 
	def void testBITAExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       BITA		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITA instruction", ld8Instruction.instruction,"BITA")
		assertTrue("Must be a extended addressing mode", ld8Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check BITA extended indirect mode 
	 */
	@Test 
	def void testBITAExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       BITA		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITA instruction", ld8Instruction.instruction,"BITA")
		assertTrue("Must be a extended indirect addressing mode", ld8Instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check BITA Constant-Offset Indexed 
	 */
	@Test 
	def void testBITAConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BITA		  	Const,X
					BITA		  	,X
					BITA		  	$9,U
					BITA		  	$9,S
					BITA		  	$9,X
					BITA		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITA instruction", ld8Instruction.instruction,"BITA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check BITA Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testBITAConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BITA		  	[Const,X]
					BITA		  	[,X]
					BITA		  	[$9,U]
					BITA		  	[$9,S]
					BITA		  	[$9,X]
					BITA		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITA instruction", ld8Instruction.instruction,"BITA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check BITA Accumulator Indexed 
	 */
	@Test 
	def void testBITAAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BITA		  	A,X
					BITA		  	B,X
					BITA		  	D,U
					BITA		  	A,S
					BITA		  	B,X
					BITA		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITA instruction", ld8Instruction.instruction,"BITA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check BITA Accumulator Indexed Indirect
	 */
	@Test 
	def void testBITAAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BITA		  	[A,X]
					BITA		  	[B,X]
					BITA		  	[D,U]
					BITA		  	[A,S]
					BITA		  	[B,X]
					BITA		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITA instruction", ld8Instruction.instruction,"BITA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check BITA Auto-Increment Indexed 
	 */
	@Test 
	def void testBITAAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BITA		  	0,--X
			       	BITA		  	0,-X
			       	BITA		  	Const,X+
			       	BITA		  	Const,X++
			       	BITA		  	0,--S
			       	BITA		  	0,-S
			       	BITA		  	Const,U+
			       	BITA		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITA instruction", ld8Instruction.instruction,"BITA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check BITA Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testBITAAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BITA		  	[0,--X]
			       	BITA		  	[0,-X]
			       	BITA		  	[Const,X+]
			       	BITA		  	[Const,X++]
			       	BITA		  	[0,--S]
			       	BITA		  	[0,-S]
			       	BITA		  	[Const,U+]
			       	BITA		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITA instruction", ld8Instruction.instruction,"BITA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check BITA Relative to PC Indexed 
	 */
	@Test 
	def void testBITARelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BITA		  	0,PCR
			       	BITA		  	,PCR
			       	BITA		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITA instruction", ld8Instruction.instruction,"BITA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check BITA Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testBITARelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BITA		  	[0,PCR]
			       	BITA		  	[,PCR]
			       	BITA		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITA instruction", ld8Instruction.instruction,"BITA")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}

	/**
	 * Check BITB immediat 
	 */
	@Test 
	def void testBITBImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       BITB		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITB instruction", ld8Instruction.instruction,"BITB")
		assertTrue("Must be an immediate addressing mode", ld8Instruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check BITB direct mode 
	 */
	@Test 
	def void testBITBDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       BITB		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITB instruction", ld8Instruction.instruction,"BITB")
		assertTrue("Must be a direct addressing mode", ld8Instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check BITB extended mode 
	 */
	@Test 
	def void testBITBExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       BITB		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITB instruction", ld8Instruction.instruction,"BITB")
		assertTrue("Must be a extended addressing mode", ld8Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check BITB extended mode 
	 */
	@Test 
	def void testBITBExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       BITB		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITB instruction", ld8Instruction.instruction,"BITB")
		assertTrue("Must be a extended addressing mode", ld8Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check BITB extended indirect mode 
	 */
	@Test 
	def void testBITBExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       BITB		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITB instruction", ld8Instruction.instruction,"BITB")
		assertTrue("Must be a extended indirect addressing mode", ld8Instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check BITB Constant-Offset Indexed 
	 */
	@Test 
	def void testBITBConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BITB		  	Const,X
					BITB		  	,X
					BITB		  	$9,U
					BITB		  	$9,S
					BITB		  	$9,X
					BITB		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITB instruction", ld8Instruction.instruction,"BITB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check BITB Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testBITBConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BITB		  	[Const,X]
					BITB		  	[,X]
					BITB		  	[$9,U]
					BITB		  	[$9,S]
					BITB		  	[$9,X]
					BITB		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITB instruction", ld8Instruction.instruction,"BITB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check BITB Accumulator Indexed 
	 */
	@Test 
	def void testBITBAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BITB		  	A,X
					BITB		  	B,X
					BITB		  	D,U
					BITB		  	A,S
					BITB		  	B,X
					BITB		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITB instruction", ld8Instruction.instruction,"BITB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check BITB Accumulator Indexed Indirect
	 */
	@Test 
	def void testBITBAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BITB		  	[A,X]
					BITB		  	[B,X]
					BITB		  	[D,U]
					BITB		  	[A,S]
					BITB		  	[B,X]
					BITB		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITB instruction", ld8Instruction.instruction,"BITB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check BITB Auto-Increment Indexed 
	 */
	@Test 
	def void testBITBAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BITB		  	0,--X
			       	BITB		  	0,-X
			       	BITB		  	Const,X+
			       	BITB		  	Const,X++
			       	BITB		  	0,--S
			       	BITB		  	0,-S
			       	BITB		  	Const,U+
			       	BITB		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITB instruction", ld8Instruction.instruction,"BITB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check BITB Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testBITBAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BITB		  	[0,--X]
			       	BITB		  	[0,-X]
			       	BITB		  	[Const,X+]
			       	BITB		  	[Const,X++]
			       	BITB		  	[0,--S]
			       	BITB		  	[0,-S]
			       	BITB		  	[Const,U+]
			       	BITB		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITB instruction", ld8Instruction.instruction,"BITB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check BITB Relative to PC Indexed 
	 */
	@Test 
	def void testBITBRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BITB		  	0,PCR
			       	BITB		  	,PCR
			       	BITB		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITB instruction", ld8Instruction.instruction,"BITB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check BITB Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testBITBRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BITB		  	[0,PCR]
			       	BITB		  	[,PCR]
			       	BITB		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BIT directive line", instructionLine.instruction instanceof BitInstruction)

		val ld8Instruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BITB instruction", ld8Instruction.instruction,"BITB")
		assertTrue("Must be a Constant-Offset Indexed mode", ld8Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld8Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}