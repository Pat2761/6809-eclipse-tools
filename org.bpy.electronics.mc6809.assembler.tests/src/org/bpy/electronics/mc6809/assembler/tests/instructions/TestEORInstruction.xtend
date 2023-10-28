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
import org.bpy.electronics.mc6809.assembler.assembler.EorInstruction
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

class TestEORInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check EORA immediat 
	 */
	@Test 
	def void testEORAImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       EORA		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORA instruction", eorInstruction.instruction,"EORA")
		assertTrue("Must be an immediate addressing mode", eorInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check EORA direct mode 
	 */
	@Test 
	def void testEORADirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       EORA		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORA instruction", eorInstruction.instruction,"EORA")
		assertTrue("Must be a direct addressing mode", eorInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check EORA extended mode 
	 */
	@Test 
	def void testEORAExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       EORA		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORA instruction", eorInstruction.instruction,"EORA")
		assertTrue("Must be a extended addressing mode", eorInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check EORA extended mode 
	 */
	@Test 
	def void testEORAExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       EORA		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORA instruction", eorInstruction.instruction,"EORA")
		assertTrue("Must be a extended addressing mode", eorInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check EORA extended indirect mode 
	 */
	@Test 
	def void testEORAExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       EORA		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORA instruction", eorInstruction.instruction,"EORA")
		assertTrue("Must be a extended indirect addressing mode", eorInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check EORA Constant-Offset Indexed 
	 */
	@Test 
	def void testEORAConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	EORA		  	Const,X
					EORA		  	,X
					EORA		  	$9,U
					EORA		  	$9,S
					EORA		  	$9,X
					EORA		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORA instruction", eorInstruction.instruction,"EORA")
		assertTrue("Must be a Constant-Offset Indexed mode", eorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = eorInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check EORA Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testEORAConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	EORA		  	[Const,X]
					EORA		  	[,X]
					EORA		  	[$9,U]
					EORA		  	[$9,S]
					EORA		  	[$9,X]
					EORA		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORA instruction", eorInstruction.instruction,"EORA")
		assertTrue("Must be a Constant-Offset Indexed mode", eorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = eorInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check EORA Accumulator Indexed 
	 */
	@Test 
	def void testEORAAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	EORA		  	A,X
					EORA		  	B,X
					EORA		  	D,U
					EORA		  	A,S
					EORA		  	B,X
					EORA		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORA instruction", eorInstruction.instruction,"EORA")
		assertTrue("Must be a Constant-Offset Indexed mode", eorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = eorInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check EORA Accumulator Indexed Indirect
	 */
	@Test 
	def void testEORAAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	EORA		  	[A,X]
					EORA		  	[B,X]
					EORA		  	[D,U]
					EORA		  	[A,S]
					EORA		  	[B,X]
					EORA		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORA instruction", eorInstruction.instruction,"EORA")
		assertTrue("Must be a Constant-Offset Indexed mode", eorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = eorInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check EORA Auto-Increment Indexed 
	 */
	@Test 
	def void testEORAAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	EORA		  	0,--X
			       	EORA		  	0,-X
			       	EORA		  	Const,X+
			       	EORA		  	Const,X++
			       	EORA		  	0,--S
			       	EORA		  	0,-S
			       	EORA		  	Const,U+
			       	EORA		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORA instruction", eorInstruction.instruction,"EORA")
		assertTrue("Must be a Constant-Offset Indexed mode", eorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = eorInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check EORA Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testEORAAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	EORA		  	[0,--X]
			       	EORA		  	[0,-X]
			       	EORA		  	[Const,X+]
			       	EORA		  	[Const,X++]
			       	EORA		  	[0,--S]
			       	EORA		  	[0,-S]
			       	EORA		  	[Const,U+]
			       	EORA		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORA instruction", eorInstruction.instruction,"EORA")
		assertTrue("Must be a Constant-Offset Indexed mode", eorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = eorInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check EORA Relative to PC Indexed 
	 */
	@Test 
	def void testEORARelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	EORA		  	0,PCR
			       	EORA		  	,PCR
			       	EORA		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORA instruction", eorInstruction.instruction,"EORA")
		assertTrue("Must be a Constant-Offset Indexed mode", eorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = eorInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check EORA Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testEORARelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	EORA		  	[0,PCR]
			       	EORA		  	[,PCR]
			       	EORA		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORA instruction", eorInstruction.instruction,"EORA")
		assertTrue("Must be a Constant-Offset Indexed mode", eorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = eorInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}

	/**
	 * Check EORB immediat 
	 */
	@Test 
	def void testEORBImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       EORB		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORB instruction", eorInstruction.instruction,"EORB")
		assertTrue("Must be an immediate addressing mode", eorInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check EORB direct mode 
	 */
	@Test 
	def void testEORBDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       EORB		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORB instruction", eorInstruction.instruction,"EORB")
		assertTrue("Must be a direct addressing mode", eorInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check EORB extended mode 
	 */
	@Test 
	def void testEORBExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       EORB		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORB instruction", eorInstruction.instruction,"EORB")
		assertTrue("Must be a extended addressing mode", eorInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check EORB extended mode 
	 */
	@Test 
	def void testEORBExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       EORB		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORB instruction", eorInstruction.instruction,"EORB")
		assertTrue("Must be a extended addressing mode", eorInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check EORB extended indirect mode 
	 */
	@Test 
	def void testEORBExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       EORB		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORB instruction", eorInstruction.instruction,"EORB")
		assertTrue("Must be a extended indirect addressing mode", eorInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check EORB Constant-Offset Indexed 
	 */
	@Test 
	def void testEORBConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	EORB		  	Const,X
					EORB		  	,X
					EORB		  	$9,U
					EORB		  	$9,S
					EORB		  	$9,X
					EORB		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORB instruction", eorInstruction.instruction,"EORB")
		assertTrue("Must be a Constant-Offset Indexed mode", eorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = eorInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check EORB Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testEORBConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	EORB		  	[Const,X]
					EORB		  	[,X]
					EORB		  	[$9,U]
					EORB		  	[$9,S]
					EORB		  	[$9,X]
					EORB		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORB instruction", eorInstruction.instruction,"EORB")
		assertTrue("Must be a Constant-Offset Indexed mode", eorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = eorInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check EORB Accumulator Indexed 
	 */
	@Test 
	def void testEORBAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	EORB		  	A,X
					EORB		  	B,X
					EORB		  	D,U
					EORB		  	A,S
					EORB		  	B,X
					EORB		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORB instruction", eorInstruction.instruction,"EORB")
		assertTrue("Must be a Constant-Offset Indexed mode", eorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = eorInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check EORB Accumulator Indexed Indirect
	 */
	@Test 
	def void testEORBAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	EORB		  	[A,X]
					EORB		  	[B,X]
					EORB		  	[D,U]
					EORB		  	[A,S]
					EORB		  	[B,X]
					EORB		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORB instruction", eorInstruction.instruction,"EORB")
		assertTrue("Must be a Constant-Offset Indexed mode", eorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = eorInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check EORB Auto-Increment Indexed 
	 */
	@Test 
	def void testEORBAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	EORB		  	0,--X
			       	EORB		  	0,-X
			       	EORB		  	Const,X+
			       	EORB		  	Const,X++
			       	EORB		  	0,--S
			       	EORB		  	0,-S
			       	EORB		  	Const,U+
			       	EORB		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORB instruction", eorInstruction.instruction,"EORB")
		assertTrue("Must be a Constant-Offset Indexed mode", eorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = eorInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check EORB Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testEORBAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	EORB		  	[0,--X]
			       	EORB		  	[0,-X]
			       	EORB		  	[Const,X+]
			       	EORB		  	[Const,X++]
			       	EORB		  	[0,--S]
			       	EORB		  	[0,-S]
			       	EORB		  	[Const,U+]
			       	EORB		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORB instruction", eorInstruction.instruction,"EORB")
		assertTrue("Must be a Constant-Offset Indexed mode", eorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = eorInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check EORB Relative to PC Indexed 
	 */
	@Test 
	def void testEORBRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	EORB		  	0,PCR
			       	EORB		  	,PCR
			       	EORB		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORB instruction", eorInstruction.instruction,"EORB")
		assertTrue("Must be a Constant-Offset Indexed mode", eorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = eorInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check EORB Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testEORBRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	EORB		  	[0,PCR]
			       	EORB		  	[,PCR]
			       	EORB		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an EOR directive line", instructionLine.instruction instanceof EorInstruction)

		val eorInstruction = instructionLine.instruction as EorInstruction
		assertEquals("Must be an EORB instruction", eorInstruction.instruction,"EORB")
		assertTrue("Must be a Constant-Offset Indexed mode", eorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = eorInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}