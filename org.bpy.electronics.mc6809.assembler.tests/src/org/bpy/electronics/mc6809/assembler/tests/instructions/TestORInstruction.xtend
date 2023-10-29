/*
 * MC6809 Toolkit
 * Copyright (C) 2023  Patrick BRIOR
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
import org.bpy.electronics.mc6809.assembler.assembler.OrInstruction
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

class TestORInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check ORA immediat 
	 */
	@Test 
	def void testORAImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ORA		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORA instruction", orInstruction.instruction,"ORA")
		assertTrue("Must be an immediate addressing mode", orInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check ORA direct mode 
	 */
	@Test 
	def void testORADirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ORA		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORA instruction", orInstruction.instruction,"ORA")
		assertTrue("Must be a direct addressing mode", orInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check ORA extended mode 
	 */
	@Test 
	def void testORAExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ORA		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORA instruction", orInstruction.instruction,"ORA")
		assertTrue("Must be a extended addressing mode", orInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ORA extended mode 
	 */
	@Test 
	def void testORAExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ORA		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORA instruction", orInstruction.instruction,"ORA")
		assertTrue("Must be a extended addressing mode", orInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ORA extended indirect mode 
	 */
	@Test 
	def void testORAExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ORA		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORA instruction", orInstruction.instruction,"ORA")
		assertTrue("Must be a extended indirect addressing mode", orInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check ORA Constant-Offset Indexed 
	 */
	@Test 
	def void testORAConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORA		  	Const,X
					ORA		  	,X
					ORA		  	$9,U
					ORA		  	$9,S
					ORA		  	$9,X
					ORA		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORA instruction", orInstruction.instruction,"ORA")
		assertTrue("Must be a Constant-Offset Indexed mode", orInstruction.operand instanceof IndexedOperand)
		val indexedOperand = orInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check ORA Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testORAConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORA		  	[Const,X]
					ORA		  	[,X]
					ORA		  	[$9,U]
					ORA		  	[$9,S]
					ORA		  	[$9,X]
					ORA		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORA instruction", orInstruction.instruction,"ORA")
		assertTrue("Must be a Constant-Offset Indexed mode", orInstruction.operand instanceof IndexedOperand)
		val indexedOperand = orInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check ORA Accumulator Indexed 
	 */
	@Test 
	def void testORAAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORA		  	A,X
					ORA		  	B,X
					ORA		  	D,U
					ORA		  	A,S
					ORA		  	B,X
					ORA		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORA instruction", orInstruction.instruction,"ORA")
		assertTrue("Must be a Constant-Offset Indexed mode", orInstruction.operand instanceof IndexedOperand)
		val indexedOperand = orInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check ORA Accumulator Indexed Indirect
	 */
	@Test 
	def void testORAAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORA		  	[A,X]
					ORA		  	[B,X]
					ORA		  	[D,U]
					ORA		  	[A,S]
					ORA		  	[B,X]
					ORA		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORA instruction", orInstruction.instruction,"ORA")
		assertTrue("Must be a Constant-Offset Indexed mode", orInstruction.operand instanceof IndexedOperand)
		val indexedOperand = orInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check ORA Auto-Increment Indexed 
	 */
	@Test 
	def void testORAAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORA		  	0,--X
			       	ORA		  	0,-X
			       	ORA		  	Const,X+
			       	ORA		  	Const,X++
			       	ORA		  	0,--S
			       	ORA		  	0,-S
			       	ORA		  	Const,U+
			       	ORA		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORA instruction", orInstruction.instruction,"ORA")
		assertTrue("Must be a Constant-Offset Indexed mode", orInstruction.operand instanceof IndexedOperand)
		val indexedOperand = orInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check ORA Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testORAAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORA		  	[0,--X]
			       	ORA		  	[0,-X]
			       	ORA		  	[Const,X+]
			       	ORA		  	[Const,X++]
			       	ORA		  	[0,--S]
			       	ORA		  	[0,-S]
			       	ORA		  	[Const,U+]
			       	ORA		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORA instruction", orInstruction.instruction,"ORA")
		assertTrue("Must be a Constant-Offset Indexed mode", orInstruction.operand instanceof IndexedOperand)
		val indexedOperand = orInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check ORA Relative to PC Indexed 
	 */
	@Test 
	def void testORARelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORA		  	0,PCR
			       	ORA		  	,PCR
			       	ORA		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORA instruction", orInstruction.instruction,"ORA")
		assertTrue("Must be a Constant-Offset Indexed mode", orInstruction.operand instanceof IndexedOperand)
		val indexedOperand = orInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check ORA Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testORARelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORA		  	[0,PCR]
			       	ORA		  	[,PCR]
			       	ORA		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORA instruction", orInstruction.instruction,"ORA")
		assertTrue("Must be a Constant-Offset Indexed mode", orInstruction.operand instanceof IndexedOperand)
		val indexedOperand = orInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}

	/**
	 * Check ORB immediat 
	 */
	@Test 
	def void testORBImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ORB		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORB instruction", orInstruction.instruction,"ORB")
		assertTrue("Must be an immediate addressing mode", orInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check ORB direct mode 
	 */
	@Test 
	def void testORBDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ORB		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORB instruction", orInstruction.instruction,"ORB")
		assertTrue("Must be a direct addressing mode", orInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check ORB extended mode 
	 */
	@Test 
	def void testORBExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ORB		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORB instruction", orInstruction.instruction,"ORB")
		assertTrue("Must be a extended addressing mode", orInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ORB extended mode 
	 */
	@Test 
	def void testORBExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ORB		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORB instruction", orInstruction.instruction,"ORB")
		assertTrue("Must be a extended addressing mode", orInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ORB extended indirect mode 
	 */
	@Test 
	def void testORBExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ORB		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORB instruction", orInstruction.instruction,"ORB")
		assertTrue("Must be a extended indirect addressing mode", orInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check ORB Constant-Offset Indexed 
	 */
	@Test 
	def void testORBConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORB		  	Const,X
					ORB		  	,X
					ORB		  	$9,U
					ORB		  	$9,S
					ORB		  	$9,X
					ORB		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORB instruction", orInstruction.instruction,"ORB")
		assertTrue("Must be a Constant-Offset Indexed mode", orInstruction.operand instanceof IndexedOperand)
		val indexedOperand = orInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check ORB Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testORBConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORB		  	[Const,X]
					ORB		  	[,X]
					ORB		  	[$9,U]
					ORB		  	[$9,S]
					ORB		  	[$9,X]
					ORB		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORB instruction", orInstruction.instruction,"ORB")
		assertTrue("Must be a Constant-Offset Indexed mode", orInstruction.operand instanceof IndexedOperand)
		val indexedOperand = orInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check ORB Accumulator Indexed 
	 */
	@Test 
	def void testORBAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORB		  	A,X
					ORB		  	B,X
					ORB		  	D,U
					ORB		  	A,S
					ORB		  	B,X
					ORB		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORB instruction", orInstruction.instruction,"ORB")
		assertTrue("Must be a Constant-Offset Indexed mode", orInstruction.operand instanceof IndexedOperand)
		val indexedOperand = orInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check ORB Accumulator Indexed Indirect
	 */
	@Test 
	def void testORBAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORB		  	[A,X]
					ORB		  	[B,X]
					ORB		  	[D,U]
					ORB		  	[A,S]
					ORB		  	[B,X]
					ORB		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORB instruction", orInstruction.instruction,"ORB")
		assertTrue("Must be a Constant-Offset Indexed mode", orInstruction.operand instanceof IndexedOperand)
		val indexedOperand = orInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check ORB Auto-Increment Indexed 
	 */
	@Test 
	def void testORBAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORB		  	0,--X
			       	ORB		  	0,-X
			       	ORB		  	Const,X+
			       	ORB		  	Const,X++
			       	ORB		  	0,--S
			       	ORB		  	0,-S
			       	ORB		  	Const,U+
			       	ORB		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORB instruction", orInstruction.instruction,"ORB")
		assertTrue("Must be a Constant-Offset Indexed mode", orInstruction.operand instanceof IndexedOperand)
		val indexedOperand = orInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check ORB Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testORBAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORB		  	[0,--X]
			       	ORB		  	[0,-X]
			       	ORB		  	[Const,X+]
			       	ORB		  	[Const,X++]
			       	ORB		  	[0,--S]
			       	ORB		  	[0,-S]
			       	ORB		  	[Const,U+]
			       	ORB		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORB instruction", orInstruction.instruction,"ORB")
		assertTrue("Must be a Constant-Offset Indexed mode", orInstruction.operand instanceof IndexedOperand)
		val indexedOperand = orInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check ORB Relative to PC Indexed 
	 */
	@Test 
	def void testORBRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORB		  	0,PCR
			       	ORB		  	,PCR
			       	ORB		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORB instruction", orInstruction.instruction,"ORB")
		assertTrue("Must be a Constant-Offset Indexed mode", orInstruction.operand instanceof IndexedOperand)
		val indexedOperand = orInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check ORB Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testORBRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORB		  	[0,PCR]
			       	ORB		  	[,PCR]
			       	ORB		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof OrInstruction)

		val orInstruction = instructionLine.instruction as OrInstruction
		assertEquals("Must be an ORB instruction", orInstruction.instruction,"ORB")
		assertTrue("Must be a Constant-Offset Indexed mode", orInstruction.operand instanceof IndexedOperand)
		val indexedOperand = orInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}