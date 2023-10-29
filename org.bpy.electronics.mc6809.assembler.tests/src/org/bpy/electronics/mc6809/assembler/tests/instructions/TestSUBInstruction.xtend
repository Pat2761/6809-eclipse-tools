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
import org.bpy.electronics.mc6809.assembler.assembler.SubInstruction
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

class TestSUBInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check SUBA immediat 
	 */
	@Test 
	def void testSUBAImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SUBA		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBA instruction", subInstruction.instruction,"SUBA")
		assertTrue("Must be an immediate addressing mode", subInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check SUBA direct mode 
	 */
	@Test 
	def void testSUBADirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SUBA		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBA instruction", subInstruction.instruction,"SUBA")
		assertTrue("Must be a direct addressing mode", subInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check SUBA extended mode 
	 */
	@Test 
	def void testSUBAExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SUBA		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBA instruction", subInstruction.instruction,"SUBA")
		assertTrue("Must be a extended addressing mode", subInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check SUBA extended mode 
	 */
	@Test 
	def void testSUBAExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SUBA		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBA instruction", subInstruction.instruction,"SUBA")
		assertTrue("Must be a extended addressing mode", subInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check SUBA extended indirect mode 
	 */
	@Test 
	def void testSUBAExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SUBA		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBA instruction", subInstruction.instruction,"SUBA")
		assertTrue("Must be a extended indirect addressing mode", subInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check SUBA Constant-Offset Indexed 
	 */
	@Test 
	def void testSUBAConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBA		  	Const,X
					SUBA		  	,X
					SUBA		  	$9,U
					SUBA		  	$9,S
					SUBA		  	$9,X
					SUBA		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBA instruction", subInstruction.instruction,"SUBA")
		assertTrue("Must be a Constant-Offset Indexed mode", subInstruction.operand instanceof IndexedOperand)
		val indexedOperand = subInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check SUBA Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testSUBAConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBA		  	[Const,X]
					SUBA		  	[,X]
					SUBA		  	[$9,U]
					SUBA		  	[$9,S]
					SUBA		  	[$9,X]
					SUBA		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBA instruction", subInstruction.instruction,"SUBA")
		assertTrue("Must be a Constant-Offset Indexed mode", subInstruction.operand instanceof IndexedOperand)
		val indexedOperand = subInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check SUBA Accumulator Indexed 
	 */
	@Test 
	def void testSUBAAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBA		  	A,X
					SUBA		  	B,X
					SUBA		  	D,U
					SUBA		  	A,S
					SUBA		  	B,X
					SUBA		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBA instruction", subInstruction.instruction,"SUBA")
		assertTrue("Must be a Constant-Offset Indexed mode", subInstruction.operand instanceof IndexedOperand)
		val indexedOperand = subInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check SUBA Accumulator Indexed Indirect
	 */
	@Test 
	def void testSUBAAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBA		  	[A,X]
					SUBA		  	[B,X]
					SUBA		  	[D,U]
					SUBA		  	[A,S]
					SUBA		  	[B,X]
					SUBA		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBA instruction", subInstruction.instruction,"SUBA")
		assertTrue("Must be a Constant-Offset Indexed mode", subInstruction.operand instanceof IndexedOperand)
		val indexedOperand = subInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check SUBA Auto-Increment Indexed 
	 */
	@Test 
	def void testSUBAAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBA		  	0,--X
			       	SUBA		  	0,-X
			       	SUBA		  	Const,X+
			       	SUBA		  	Const,X++
			       	SUBA		  	0,--S
			       	SUBA		  	0,-S
			       	SUBA		  	Const,U+
			       	SUBA		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBA instruction", subInstruction.instruction,"SUBA")
		assertTrue("Must be a Constant-Offset Indexed mode", subInstruction.operand instanceof IndexedOperand)
		val indexedOperand = subInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check SUBA Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testSUBAAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBA		  	[0,--X]
			       	SUBA		  	[0,-X]
			       	SUBA		  	[Const,X+]
			       	SUBA		  	[Const,X++]
			       	SUBA		  	[0,--S]
			       	SUBA		  	[0,-S]
			       	SUBA		  	[Const,U+]
			       	SUBA		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBA instruction", subInstruction.instruction,"SUBA")
		assertTrue("Must be a Constant-Offset Indexed mode", subInstruction.operand instanceof IndexedOperand)
		val indexedOperand = subInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check SUBA Relative to PC Indexed 
	 */
	@Test 
	def void testSUBARelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBA		  	0,PCR
			       	SUBA		  	,PCR
			       	SUBA		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBA instruction", subInstruction.instruction,"SUBA")
		assertTrue("Must be a Constant-Offset Indexed mode", subInstruction.operand instanceof IndexedOperand)
		val indexedOperand = subInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check SUBA Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testSUBARelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBA		  	[0,PCR]
			       	SUBA		  	[,PCR]
			       	SUBA		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBA instruction", subInstruction.instruction,"SUBA")
		assertTrue("Must be a Constant-Offset Indexed mode", subInstruction.operand instanceof IndexedOperand)
		val indexedOperand = subInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}

	/**
	 * Check SUBB immediat 
	 */
	@Test 
	def void testSUBBImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SUBB		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBB instruction", subInstruction.instruction,"SUBB")
		assertTrue("Must be an immediate addressing mode", subInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check SUBB direct mode 
	 */
	@Test 
	def void testSUBBDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SUBB		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBB instruction", subInstruction.instruction,"SUBB")
		assertTrue("Must be a direct addressing mode", subInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check SUBB extended mode 
	 */
	@Test 
	def void testSUBBExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SUBB		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBB instruction", subInstruction.instruction,"SUBB")
		assertTrue("Must be a extended addressing mode", subInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check SUBB extended mode 
	 */
	@Test 
	def void testSUBBExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SUBB		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBB instruction", subInstruction.instruction,"SUBB")
		assertTrue("Must be a extended addressing mode", subInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check SUBB extended indirect mode 
	 */
	@Test 
	def void testSUBBExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SUBB		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBB instruction", subInstruction.instruction,"SUBB")
		assertTrue("Must be a extended indirect addressing mode", subInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check SUBB Constant-Offset Indexed 
	 */
	@Test 
	def void testSUBBConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBB		  	Const,X
					SUBB		  	,X
					SUBB		  	$9,U
					SUBB		  	$9,S
					SUBB		  	$9,X
					SUBB		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBB instruction", subInstruction.instruction,"SUBB")
		assertTrue("Must be a Constant-Offset Indexed mode", subInstruction.operand instanceof IndexedOperand)
		val indexedOperand = subInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check SUBB Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testSUBBConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBB		  	[Const,X]
					SUBB		  	[,X]
					SUBB		  	[$9,U]
					SUBB		  	[$9,S]
					SUBB		  	[$9,X]
					SUBB		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBB instruction", subInstruction.instruction,"SUBB")
		assertTrue("Must be a Constant-Offset Indexed mode", subInstruction.operand instanceof IndexedOperand)
		val indexedOperand = subInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check SUBB Accumulator Indexed 
	 */
	@Test 
	def void testSUBBAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBB		  	A,X
					SUBB		  	B,X
					SUBB		  	D,U
					SUBB		  	A,S
					SUBB		  	B,X
					SUBB		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBB instruction", subInstruction.instruction,"SUBB")
		assertTrue("Must be a Constant-Offset Indexed mode", subInstruction.operand instanceof IndexedOperand)
		val indexedOperand = subInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check SUBB Accumulator Indexed Indirect
	 */
	@Test 
	def void testSUBBAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBB		  	[A,X]
					SUBB		  	[B,X]
					SUBB		  	[D,U]
					SUBB		  	[A,S]
					SUBB		  	[B,X]
					SUBB		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBB instruction", subInstruction.instruction,"SUBB")
		assertTrue("Must be a Constant-Offset Indexed mode", subInstruction.operand instanceof IndexedOperand)
		val indexedOperand = subInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check SUBB Auto-Increment Indexed 
	 */
	@Test 
	def void testSUBBAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBB		  	0,--X
			       	SUBB		  	0,-X
			       	SUBB		  	Const,X+
			       	SUBB		  	Const,X++
			       	SUBB		  	0,--S
			       	SUBB		  	0,-S
			       	SUBB		  	Const,U+
			       	SUBB		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBB instruction", subInstruction.instruction,"SUBB")
		assertTrue("Must be a Constant-Offset Indexed mode", subInstruction.operand instanceof IndexedOperand)
		val indexedOperand = subInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check SUBB Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testSUBBAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBB		  	[0,--X]
			       	SUBB		  	[0,-X]
			       	SUBB		  	[Const,X+]
			       	SUBB		  	[Const,X++]
			       	SUBB		  	[0,--S]
			       	SUBB		  	[0,-S]
			       	SUBB		  	[Const,U+]
			       	SUBB		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBB instruction", subInstruction.instruction,"SUBB")
		assertTrue("Must be a Constant-Offset Indexed mode", subInstruction.operand instanceof IndexedOperand)
		val indexedOperand = subInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check SUBB Relative to PC Indexed 
	 */
	@Test 
	def void testSUBBRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBB		  	0,PCR
			       	SUBB		  	,PCR
			       	SUBB		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBB instruction", subInstruction.instruction,"SUBB")
		assertTrue("Must be a Constant-Offset Indexed mode", subInstruction.operand instanceof IndexedOperand)
		val indexedOperand = subInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check SUBB Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testSUBBRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBB		  	[0,PCR]
			       	SUBB		  	[,PCR]
			       	SUBB		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an SUB directive line", instructionLine.instruction instanceof SubInstruction)

		val subInstruction = instructionLine.instruction as SubInstruction
		assertEquals("Must be an SUBB instruction", subInstruction.instruction,"SUBB")
		assertTrue("Must be a Constant-Offset Indexed mode", subInstruction.operand instanceof IndexedOperand)
		val indexedOperand = subInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}