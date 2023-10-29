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
import org.bpy.electronics.mc6809.assembler.assembler.SubdInstruction
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

class TestSUBDInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check SUBD immediat 
	 */
	@Test 
	def void testSUBDImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SUBD		  	#1242
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof SubdInstruction)

		val SubdInstruction = instructionLine.instruction as SubdInstruction
		assertEquals("Must be an SUBD instruction", SubdInstruction.instruction,"SUBD")
		assertTrue("Must be an immediate addressing mode", SubdInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check SUBD direct mode 
	 */
	@Test 
	def void testSUBDDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SUBD		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof SubdInstruction)

		val SubdInstruction = instructionLine.instruction as SubdInstruction
		assertEquals("Must be an SUBD instruction", SubdInstruction.instruction,"SUBD")
		assertTrue("Must be a direct addressing mode", SubdInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check SUBD extended mode 
	 */
	@Test 
	def void testSUBDExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SUBD		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof SubdInstruction)

		val SubdInstruction = instructionLine.instruction as SubdInstruction
		assertEquals("Must be an SUBD instruction", SubdInstruction.instruction,"SUBD")
		assertTrue("Must be a extended addressing mode", SubdInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check SUBD extended mode 
	 */
	@Test 
	def void testSUBDExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SUBD		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof SubdInstruction)

		val SubdInstruction = instructionLine.instruction as SubdInstruction
		assertEquals("Must be an SUBD instruction", SubdInstruction.instruction,"SUBD")
		assertTrue("Must be a extended addressing mode", SubdInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check SUBD extended indirect mode 
	 */
	@Test 
	def void testSUBDExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       SUBD		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof SubdInstruction)

		val SubdInstruction = instructionLine.instruction as SubdInstruction
		assertEquals("Must be an SUBD instruction", SubdInstruction.instruction,"SUBD")
		assertTrue("Must be a extended indirect addressing mode", SubdInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check SUBD Constant-Offset Indexed 
	 */
	@Test 
	def void testSUBDConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBD		  	Const,X
					SUBD		  	,X
					SUBD		  	$9,U
					SUBD		  	$9,S
					SUBD		  	$9,X
					SUBD		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof SubdInstruction)

		val SubdInstruction = instructionLine.instruction as SubdInstruction
		assertEquals("Must be an SUBD instruction", SubdInstruction.instruction,"SUBD")
		assertTrue("Must be a Constant-Offset Indexed mode", SubdInstruction.operand instanceof IndexedOperand)
		val indexedOperand = SubdInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check SUBD Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testSUBDConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBD		  	[Const,X]
					SUBD		  	[,X]
					SUBD		  	[$9,U]
					SUBD		  	[$9,S]
					SUBD		  	[$9,X]
					SUBD		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof SubdInstruction)

		val SubdInstruction = instructionLine.instruction as SubdInstruction
		assertEquals("Must be an SUBD instruction", SubdInstruction.instruction,"SUBD")
		assertTrue("Must be a Constant-Offset Indexed mode", SubdInstruction.operand instanceof IndexedOperand)
		val indexedOperand = SubdInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check SUBD Accumulator Indexed 
	 */
	@Test 
	def void testSUBDAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBD		  	A,X
					SUBD		  	B,X
					SUBD		  	D,U
					SUBD		  	A,S
					SUBD		  	B,X
					SUBD		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof SubdInstruction)

		val SubdInstruction = instructionLine.instruction as SubdInstruction
		assertEquals("Must be an SUBD instruction", SubdInstruction.instruction,"SUBD")
		assertTrue("Must be a Constant-Offset Indexed mode", SubdInstruction.operand instanceof IndexedOperand)
		val indexedOperand = SubdInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check SUBD Accumulator Indexed Indirect
	 */
	@Test 
	def void testSUBDAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBD		  	[A,X]
					SUBD		  	[B,X]
					SUBD		  	[D,U]
					SUBD		  	[A,S]
					SUBD		  	[B,X]
					SUBD		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof SubdInstruction)

		val SubdInstruction = instructionLine.instruction as SubdInstruction
		assertEquals("Must be an SUBD instruction", SubdInstruction.instruction,"SUBD")
		assertTrue("Must be a Constant-Offset Indexed mode", SubdInstruction.operand instanceof IndexedOperand)
		val indexedOperand = SubdInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check SUBD Auto-Increment Indexed 
	 */
	@Test 
	def void testSUBDAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBD		  	0,--X
			       	SUBD		  	0,-X
			       	SUBD		  	Const,X+
			       	SUBD		  	Const,X++
			       	SUBD		  	0,--S
			       	SUBD		  	0,-S
			       	SUBD		  	Const,U+
			       	SUBD		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof SubdInstruction)

		val SubdInstruction = instructionLine.instruction as SubdInstruction
		assertEquals("Must be an SUBD instruction", SubdInstruction.instruction,"SUBD")
		assertTrue("Must be a Constant-Offset Indexed mode", SubdInstruction.operand instanceof IndexedOperand)
		val indexedOperand = SubdInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check SUBD Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testSUBDAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBD		  	[0,--X]
			       	SUBD		  	[0,-X]
			       	SUBD		  	[Const,X+]
			       	SUBD		  	[Const,X++]
			       	SUBD		  	[0,--S]
			       	SUBD		  	[0,-S]
			       	SUBD		  	[Const,U+]
			       	SUBD		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof SubdInstruction)

		val SubdInstruction = instructionLine.instruction as SubdInstruction
		assertEquals("Must be an SUBD instruction", SubdInstruction.instruction,"SUBD")
		assertTrue("Must be a Constant-Offset Indexed mode", SubdInstruction.operand instanceof IndexedOperand)
		val indexedOperand = SubdInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check SUBD Relative to PC Indexed 
	 */
	@Test 
	def void testSUBDRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBD		  	0,PCR
			       	SUBD		  	,PCR
			       	SUBD		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof SubdInstruction)

		val SubdInstruction = instructionLine.instruction as SubdInstruction
		assertEquals("Must be an SUBD instruction", SubdInstruction.instruction,"SUBD")
		assertTrue("Must be a Constant-Offset Indexed mode", SubdInstruction.operand instanceof IndexedOperand)
		val indexedOperand = SubdInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check SUBD Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testSUBDRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	SUBD		  	[0,PCR]
			       	SUBD		  	[,PCR]
			       	SUBD		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof SubdInstruction)

		val SubdInstruction = instructionLine.instruction as SubdInstruction
		assertEquals("Must be an SUBD instruction", SubdInstruction.instruction,"SUBD")
		assertTrue("Must be a Constant-Offset Indexed mode", SubdInstruction.operand instanceof IndexedOperand)
		val indexedOperand = SubdInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}

}