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
import org.bpy.electronics.mc6809.assembler.assembler.CmpInstruction
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

class TestCMPInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check CMPA immediat 
	 */
	@Test 
	def void testCMPAImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       CMPA		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPA instruction", cmpInstruction.instruction,"CMPA")
		assertTrue("Must be an immediate addressing mode", cmpInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check CMPA direct mode 
	 */
	@Test 
	def void testCMPADirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       CMPA		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPA instruction", cmpInstruction.instruction,"CMPA")
		assertTrue("Must be a direct addressing mode", cmpInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check CMPA extended mode 
	 */
	@Test 
	def void testCMPAExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       CMPA		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPA instruction", cmpInstruction.instruction,"CMPA")
		assertTrue("Must be a extended addressing mode", cmpInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check CMPA extended mode 
	 */
	@Test 
	def void testCMPAExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       CMPA		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPA instruction", cmpInstruction.instruction,"CMPA")
		assertTrue("Must be a extended addressing mode", cmpInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check CMPA extended indirect mode 
	 */
	@Test 
	def void testCMPAExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       CMPA		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPA instruction", cmpInstruction.instruction,"CMPA")
		assertTrue("Must be a extended indirect addressing mode", cmpInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check CMPA Constant-Offset Indexed 
	 */
	@Test 
	def void testCMPAConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPA		  	Const,X
					CMPA		  	,X
					CMPA		  	$9,U
					CMPA		  	$9,S
					CMPA		  	$9,X
					CMPA		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPA instruction", cmpInstruction.instruction,"CMPA")
		assertTrue("Must be a Constant-Offset Indexed mode", cmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = cmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check CMPA Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testCMPAConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPA		  	[Const,X]
					CMPA		  	[,X]
					CMPA		  	[$9,U]
					CMPA		  	[$9,S]
					CMPA		  	[$9,X]
					CMPA		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPA instruction", cmpInstruction.instruction,"CMPA")
		assertTrue("Must be a Constant-Offset Indexed mode", cmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = cmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check CMPA Accumulator Indexed 
	 */
	@Test 
	def void testCMPAAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPA		  	A,X
					CMPA		  	B,X
					CMPA		  	D,U
					CMPA		  	A,S
					CMPA		  	B,X
					CMPA		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPA instruction", cmpInstruction.instruction,"CMPA")
		assertTrue("Must be a Constant-Offset Indexed mode", cmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = cmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check CMPA Accumulator Indexed Indirect
	 */
	@Test 
	def void testCMPAAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPA		  	[A,X]
					CMPA		  	[B,X]
					CMPA		  	[D,U]
					CMPA		  	[A,S]
					CMPA		  	[B,X]
					CMPA		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPA instruction", cmpInstruction.instruction,"CMPA")
		assertTrue("Must be a Constant-Offset Indexed mode", cmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = cmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check CMPA Auto-Increment Indexed 
	 */
	@Test 
	def void testCMPAAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPA		  	0,--X
			       	CMPA		  	0,-X
			       	CMPA		  	Const,X+
			       	CMPA		  	Const,X++
			       	CMPA		  	0,--S
			       	CMPA		  	0,-S
			       	CMPA		  	Const,U+
			       	CMPA		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPA instruction", cmpInstruction.instruction,"CMPA")
		assertTrue("Must be a Constant-Offset Indexed mode", cmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = cmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check CMPA Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testCMPAAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPA		  	[0,--X]
			       	CMPA		  	[0,-X]
			       	CMPA		  	[Const,X+]
			       	CMPA		  	[Const,X++]
			       	CMPA		  	[0,--S]
			       	CMPA		  	[0,-S]
			       	CMPA		  	[Const,U+]
			       	CMPA		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPA instruction", cmpInstruction.instruction,"CMPA")
		assertTrue("Must be a Constant-Offset Indexed mode", cmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = cmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check CMPA Relative to PC Indexed 
	 */
	@Test 
	def void testCMPARelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPA		  	0,PCR
			       	CMPA		  	,PCR
			       	CMPA		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPA instruction", cmpInstruction.instruction,"CMPA")
		assertTrue("Must be a Constant-Offset Indexed mode", cmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = cmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check CMPA Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testCMPARelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPA		  	[0,PCR]
			       	CMPA		  	[,PCR]
			       	CMPA		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPA instruction", cmpInstruction.instruction,"CMPA")
		assertTrue("Must be a Constant-Offset Indexed mode", cmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = cmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}

	/**
	 * Check CMPB immediat 
	 */
	@Test 
	def void testCMPBImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       CMPB		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPB instruction", cmpInstruction.instruction,"CMPB")
		assertTrue("Must be an immediate addressing mode", cmpInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check CMPB direct mode 
	 */
	@Test 
	def void testCMPBDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       CMPB		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPB instruction", cmpInstruction.instruction,"CMPB")
		assertTrue("Must be a direct addressing mode", cmpInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check CMPB extended mode 
	 */
	@Test 
	def void testCMPBExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       CMPB		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPB instruction", cmpInstruction.instruction,"CMPB")
		assertTrue("Must be a extended addressing mode", cmpInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check CMPB extended mode 
	 */
	@Test 
	def void testCMPBExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       CMPB		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPB instruction", cmpInstruction.instruction,"CMPB")
		assertTrue("Must be a extended addressing mode", cmpInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check CMPB extended indirect mode 
	 */
	@Test 
	def void testCMPBExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       CMPB		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPB instruction", cmpInstruction.instruction,"CMPB")
		assertTrue("Must be a extended indirect addressing mode", cmpInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check CMPB Constant-Offset Indexed 
	 */
	@Test 
	def void testCMPBConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPB		  	Const,X
					CMPB		  	,X
					CMPB		  	$9,U
					CMPB		  	$9,S
					CMPB		  	$9,X
					CMPB		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPB instruction", cmpInstruction.instruction,"CMPB")
		assertTrue("Must be a Constant-Offset Indexed mode", cmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = cmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check CMPB Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testCMPBConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPB		  	[Const,X]
					CMPB		  	[,X]
					CMPB		  	[$9,U]
					CMPB		  	[$9,S]
					CMPB		  	[$9,X]
					CMPB		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPB instruction", cmpInstruction.instruction,"CMPB")
		assertTrue("Must be a Constant-Offset Indexed mode", cmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = cmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check CMPB Accumulator Indexed 
	 */
	@Test 
	def void testCMPBAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPB		  	A,X
					CMPB		  	B,X
					CMPB		  	D,U
					CMPB		  	A,S
					CMPB		  	B,X
					CMPB		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPB instruction", cmpInstruction.instruction,"CMPB")
		assertTrue("Must be a Constant-Offset Indexed mode", cmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = cmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check CMPB Accumulator Indexed Indirect
	 */
	@Test 
	def void testCMPBAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPB		  	[A,X]
					CMPB		  	[B,X]
					CMPB		  	[D,U]
					CMPB		  	[A,S]
					CMPB		  	[B,X]
					CMPB		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPB instruction", cmpInstruction.instruction,"CMPB")
		assertTrue("Must be a Constant-Offset Indexed mode", cmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = cmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check CMPB Auto-Increment Indexed 
	 */
	@Test 
	def void testCMPBAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPB		  	0,--X
			       	CMPB		  	0,-X
			       	CMPB		  	Const,X+
			       	CMPB		  	Const,X++
			       	CMPB		  	0,--S
			       	CMPB		  	0,-S
			       	CMPB		  	Const,U+
			       	CMPB		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPB instruction", cmpInstruction.instruction,"CMPB")
		assertTrue("Must be a Constant-Offset Indexed mode", cmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = cmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check CMPB Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testCMPBAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPB		  	[0,--X]
			       	CMPB		  	[0,-X]
			       	CMPB		  	[Const,X+]
			       	CMPB		  	[Const,X++]
			       	CMPB		  	[0,--S]
			       	CMPB		  	[0,-S]
			       	CMPB		  	[Const,U+]
			       	CMPB		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPB instruction", cmpInstruction.instruction,"CMPB")
		assertTrue("Must be a Constant-Offset Indexed mode", cmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = cmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check CMPB Relative to PC Indexed 
	 */
	@Test 
	def void testCMPBRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPB		  	0,PCR
			       	CMPB		  	,PCR
			       	CMPB		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPB instruction", cmpInstruction.instruction,"CMPB")
		assertTrue("Must be a Constant-Offset Indexed mode", cmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = cmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check CMPB Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testCMPBRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPB		  	[0,PCR]
			       	CMPB		  	[,PCR]
			       	CMPB		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof CmpInstruction)

		val cmpInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPB instruction", cmpInstruction.instruction,"CMPB")
		assertTrue("Must be a Constant-Offset Indexed mode", cmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = cmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}