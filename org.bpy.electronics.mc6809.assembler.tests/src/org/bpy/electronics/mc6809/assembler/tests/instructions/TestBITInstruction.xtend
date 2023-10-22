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
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue
import org.bpy.electronics.mc6809.assembler.assembler.BitInstruction
import org.bpy.electronics.mc6809.assembler.assembler.IndexedOperand
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCMode
import org.bpy.electronics.mc6809.assembler.assembler.DirectOperand
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedOperand
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedIndirectOperand
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMode
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingMode
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingIndirectMode
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecMode
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecIndirectMode
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCIndirectMode

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestBITInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
		/**
	 * Check BIT direct mode 
	 */
	@Test 
	def void testBITDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       BIT		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof BitInstruction)

		val bitInstruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BIT instruction", bitInstruction.instruction,"BIT")
		assertTrue("Must be a direct addressing mode", bitInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check BIT extended mode 
	 */
	@Test 
	def void testBITExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       BIT		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof BitInstruction)

		val bitInstruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BIT instruction", bitInstruction.instruction,"BIT")
		assertTrue("Must be a extended addressing mode", bitInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check BIT extended mode 
	 */
	@Test 
	def void testBITExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       BIT		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof BitInstruction)

		val bitInstruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BIT instruction", bitInstruction.instruction,"BIT")
		assertTrue("Must be a extended addressing mode", bitInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check BIT extended indirect mode 
	 */
	@Test 
	def void testBITExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       BIT		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof BitInstruction)

		val bitInstruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BIT instruction", bitInstruction.instruction,"BIT")
		assertTrue("Must be a extended indirect addressing mode", bitInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check BIT Constant-Offset Indexed 
	 */
	@Test 
	def void testBITConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BIT		  	Const,X
					BIT		  	,X
					BIT		  	$9,U
					BIT		  	$9,S
					BIT		  	$9,X
					BIT		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof BitInstruction)

		val bitInstruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BIT instruction", bitInstruction.instruction,"BIT")
		assertTrue("Must be a Constant-Offset Indexed mode", bitInstruction.operand instanceof IndexedOperand)
		val indexedOperand = bitInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check BIT Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testBITConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BIT		  	[Const,X]
					BIT		  	[,X]
					BIT		  	[$9,U]
					BIT		  	[$9,S]
					BIT		  	[$9,X]
					BIT		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof BitInstruction)

		val bitInstruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BIT instruction", bitInstruction.instruction,"BIT")
		assertTrue("Must be a Constant-Offset Indexed mode", bitInstruction.operand instanceof IndexedOperand)
		val indexedOperand = bitInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check BIT Accumulator Indexed 
	 */
	@Test 
	def void testBITAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BIT		  	A,X
					BIT		  	B,X
					BIT		  	D,U
					BIT		  	A,S
					BIT		  	B,X
					BIT		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof BitInstruction)

		val bitInstruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BIT instruction", bitInstruction.instruction,"BIT")
		assertTrue("Must be a Constant-Offset Indexed mode", bitInstruction.operand instanceof IndexedOperand)
		val indexedOperand = bitInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check BIT Accumulator Indexed Indirect
	 */
	@Test 
	def void testBITAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BIT		  	[A,X]
					BIT		  	[B,X]
					BIT		  	[D,U]
					BIT		  	[A,S]
					BIT		  	[B,X]
					BIT		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof BitInstruction)

		val bitInstruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BIT instruction", bitInstruction.instruction,"BIT")
		assertTrue("Must be a Constant-Offset Indexed mode", bitInstruction.operand instanceof IndexedOperand)
		val indexedOperand = bitInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check BIT Auto-Increment Indexed 
	 */
	@Test 
	def void testBITAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BIT		  	0,--X
			       	BIT		  	0,-X
			       	BIT		  	Const,X+
			       	BIT		  	Const,X++
			       	BIT		  	0,--S
			       	BIT		  	0,-S
			       	BIT		  	Const,U+
			       	BIT		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof BitInstruction)

		val bitInstruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BIT instruction", bitInstruction.instruction,"BIT")
		assertTrue("Must be a Constant-Offset Indexed mode", bitInstruction.operand instanceof IndexedOperand)
		val indexedOperand = bitInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check BIT Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testBITAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BIT		  	[0,--X]
			       	BIT		  	[0,-X]
			       	BIT		  	[Const,X+]
			       	BIT		  	[Const,X++]
			       	BIT		  	[0,--S]
			       	BIT		  	[0,-S]
			       	BIT		  	[Const,U+]
			       	BIT		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof BitInstruction)

		val bitInstruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BIT instruction", bitInstruction.instruction,"BIT")
		assertTrue("Must be a Constant-Offset Indexed mode", bitInstruction.operand instanceof IndexedOperand)
		val indexedOperand = bitInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check BIT Relative to PC Indexed 
	 */
	@Test 
	def void testBITRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BIT		  	0,PCR
			       	BIT		  	,PCR
			       	BIT		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof BitInstruction)

		val bitInstruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BIT instruction", bitInstruction.instruction,"BIT")
		assertTrue("Must be a Constant-Offset Indexed mode", bitInstruction.operand instanceof IndexedOperand)
		val indexedOperand = bitInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check BIT Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testBITRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	BIT		  	[0,PCR]
			       	BIT		  	[,PCR]
			       	BIT		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof BitInstruction)

		val bitInstruction = instructionLine.instruction as BitInstruction
		assertEquals("Must be an BIT instruction", bitInstruction.instruction,"BIT")
		assertTrue("Must be a Constant-Offset Indexed mode", bitInstruction.operand instanceof IndexedOperand)
		val indexedOperand = bitInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}