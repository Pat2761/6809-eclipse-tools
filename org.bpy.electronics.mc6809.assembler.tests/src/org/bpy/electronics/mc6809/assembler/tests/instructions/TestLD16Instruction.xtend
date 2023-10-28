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
import org.bpy.electronics.mc6809.assembler.assembler.Ld16Instruction
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

class TestLD16Instruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check LDD immediat 
	 */
	@Test 
	def void testLDDImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDD		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDD instruction", ld16Instruction.instruction,"LDD")
		assertTrue("Must be an immediate addressing mode", ld16Instruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check LDD direct mode 
	 */
	@Test 
	def void testLDDDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDD		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDD instruction", ld16Instruction.instruction,"LDD")
		assertTrue("Must be a direct addressing mode", ld16Instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check LDD extended mode 
	 */
	@Test 
	def void testLDDExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDD		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDD instruction", ld16Instruction.instruction,"LDD")
		assertTrue("Must be a extended addressing mode", ld16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDD extended mode 
	 */
	@Test 
	def void testLDDExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDD		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDD instruction", ld16Instruction.instruction,"LDD")
		assertTrue("Must be a extended addressing mode", ld16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDD extended indirect mode 
	 */
	@Test 
	def void testLDDExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDD		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDD instruction", ld16Instruction.instruction,"LDD")
		assertTrue("Must be a extended indirect addressing mode", ld16Instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check LDD Constant-Offset Indexed 
	 */
	@Test 
	def void testLDDConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDD		  	Const,X
					LDD		  	,X
					LDD		  	$9,U
					LDD		  	$9,S
					LDD		  	$9,X
					LDD		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDD instruction", ld16Instruction.instruction,"LDD")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check LDD Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testLDDConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDD		  	[Const,X]
					LDD		  	[,X]
					LDD		  	[$9,U]
					LDD		  	[$9,S]
					LDD		  	[$9,X]
					LDD		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDD instruction", ld16Instruction.instruction,"LDD")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check LDD Accumulator Indexed 
	 */
	@Test 
	def void testLDDAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDD		  	A,X
					LDD		  	B,X
					LDD		  	D,U
					LDD		  	A,S
					LDD		  	B,X
					LDD		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDD instruction", ld16Instruction.instruction,"LDD")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check LDD Accumulator Indexed Indirect
	 */
	@Test 
	def void testLDDAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDD		  	[A,X]
					LDD		  	[B,X]
					LDD		  	[D,U]
					LDD		  	[A,S]
					LDD		  	[B,X]
					LDD		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDD instruction", ld16Instruction.instruction,"LDD")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check LDD Auto-Increment Indexed 
	 */
	@Test 
	def void testLDDAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDD		  	0,--X
			       	LDD		  	0,-X
			       	LDD		  	Const,X+
			       	LDD		  	Const,X++
			       	LDD		  	0,--S
			       	LDD		  	0,-S
			       	LDD		  	Const,U+
			       	LDD		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDD instruction", ld16Instruction.instruction,"LDD")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check LDD Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testLDDAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDD		  	[0,--X]
			       	LDD		  	[0,-X]
			       	LDD		  	[Const,X+]
			       	LDD		  	[Const,X++]
			       	LDD		  	[0,--S]
			       	LDD		  	[0,-S]
			       	LDD		  	[Const,U+]
			       	LDD		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDD instruction", ld16Instruction.instruction,"LDD")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check LDD Relative to PC Indexed 
	 */
	@Test 
	def void testLDDRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDD		  	0,PCR
			       	LDD		  	,PCR
			       	LDD		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDD instruction", ld16Instruction.instruction,"LDD")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check LDD Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testLDDRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDD		  	[0,PCR]
			       	LDD		  	[,PCR]
			       	LDD		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDD instruction", ld16Instruction.instruction,"LDD")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}

	/**
	 * Check LDX immediat 
	 */
	@Test 
	def void testLDXImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDX		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDX instruction", ld16Instruction.instruction,"LDX")
		assertTrue("Must be an immediate addressing mode", ld16Instruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check LDX direct mode 
	 */
	@Test 
	def void testLDXDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDX		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDX instruction", ld16Instruction.instruction,"LDX")
		assertTrue("Must be a direct addressing mode", ld16Instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check LDX extended mode 
	 */
	@Test 
	def void testLDXExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDX		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDX instruction", ld16Instruction.instruction,"LDX")
		assertTrue("Must be a extended addressing mode", ld16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDX extended mode 
	 */
	@Test 
	def void testLDXExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDX		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDX instruction", ld16Instruction.instruction,"LDX")
		assertTrue("Must be a extended addressing mode", ld16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDX extended indirect mode 
	 */
	@Test 
	def void testLDXExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDX		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDX instruction", ld16Instruction.instruction,"LDX")
		assertTrue("Must be a extended indirect addressing mode", ld16Instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check LDX Constant-Offset Indexed 
	 */
	@Test 
	def void testLDXConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDX		  	Const,X
					LDX		  	,X
					LDX		  	$9,U
					LDX		  	$9,S
					LDX		  	$9,X
					LDX		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDX instruction", ld16Instruction.instruction,"LDX")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check LDX Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testLDXConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDX		  	[Const,X]
					LDX		  	[,X]
					LDX		  	[$9,U]
					LDX		  	[$9,S]
					LDX		  	[$9,X]
					LDX		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDX instruction", ld16Instruction.instruction,"LDX")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check LDX Accumulator Indexed 
	 */
	@Test 
	def void testLDXAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDX		  	A,X
					LDX		  	B,X
					LDX		  	D,U
					LDX		  	A,S
					LDX		  	B,X
					LDX		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDX instruction", ld16Instruction.instruction,"LDX")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check LDX Accumulator Indexed Indirect
	 */
	@Test 
	def void testLDXAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDX		  	[A,X]
					LDX		  	[B,X]
					LDX		  	[D,U]
					LDX		  	[A,S]
					LDX		  	[B,X]
					LDX		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDX instruction", ld16Instruction.instruction,"LDX")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check LDX Auto-Increment Indexed 
	 */
	@Test 
	def void testLDXAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDX		  	0,--X
			       	LDX		  	0,-X
			       	LDX		  	Const,X+
			       	LDX		  	Const,X++
			       	LDX		  	0,--S
			       	LDX		  	0,-S
			       	LDX		  	Const,U+
			       	LDX		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDX instruction", ld16Instruction.instruction,"LDX")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check LDX Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testLDXAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDX		  	[0,--X]
			       	LDX		  	[0,-X]
			       	LDX		  	[Const,X+]
			       	LDX		  	[Const,X++]
			       	LDX		  	[0,--S]
			       	LDX		  	[0,-S]
			       	LDX		  	[Const,U+]
			       	LDX		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDX instruction", ld16Instruction.instruction,"LDX")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check LDX Relative to PC Indexed 
	 */
	@Test 
	def void testLDXRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDX		  	0,PCR
			       	LDX		  	,PCR
			       	LDX		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDX instruction", ld16Instruction.instruction,"LDX")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check LDX Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testLDXRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDX		  	[0,PCR]
			       	LDX		  	[,PCR]
			       	LDX		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDX instruction", ld16Instruction.instruction,"LDX")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
	
	/**
	 * Check LDY immediat 
	 */
	@Test 
	def void testLDYImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDY		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDY instruction", ld16Instruction.instruction,"LDY")
		assertTrue("Must be an immediate addressing mode", ld16Instruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check LDY direct mode 
	 */
	@Test 
	def void testLDYDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDY		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDY instruction", ld16Instruction.instruction,"LDY")
		assertTrue("Must be a direct addressing mode", ld16Instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check LDY extended mode 
	 */
	@Test 
	def void testLDYExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDY		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDY instruction", ld16Instruction.instruction,"LDY")
		assertTrue("Must be a extended addressing mode", ld16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDY extended mode 
	 */
	@Test 
	def void testLDYExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDY		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDY instruction", ld16Instruction.instruction,"LDY")
		assertTrue("Must be a extended addressing mode", ld16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDY extended indirect mode 
	 */
	@Test 
	def void testLDYExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDY		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDY instruction", ld16Instruction.instruction,"LDY")
		assertTrue("Must be a extended indirect addressing mode", ld16Instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check LDY Constant-Offset Indexed 
	 */
	@Test 
	def void testLDYConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDY		  	Const,X
					LDY		  	,X
					LDY		  	$9,U
					LDY		  	$9,S
					LDY		  	$9,X
					LDY		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDY instruction", ld16Instruction.instruction,"LDY")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check LDY Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testLDYConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDY		  	[Const,X]
					LDY		  	[,X]
					LDY		  	[$9,U]
					LDY		  	[$9,S]
					LDY		  	[$9,X]
					LDY		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDY instruction", ld16Instruction.instruction,"LDY")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check LDY Accumulator Indexed 
	 */
	@Test 
	def void testLDYAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDY		  	A,X
					LDY		  	B,X
					LDY		  	D,U
					LDY		  	A,S
					LDY		  	B,X
					LDY		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDY instruction", ld16Instruction.instruction,"LDY")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check LDY Accumulator Indexed Indirect
	 */
	@Test 
	def void testLDYAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDY		  	[A,X]
					LDY		  	[B,X]
					LDY		  	[D,U]
					LDY		  	[A,S]
					LDY		  	[B,X]
					LDY		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDY instruction", ld16Instruction.instruction,"LDY")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check LDY Auto-Increment Indexed 
	 */
	@Test 
	def void testLDYAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDY		  	0,--X
			       	LDY		  	0,-X
			       	LDY		  	Const,X+
			       	LDY		  	Const,X++
			       	LDY		  	0,--S
			       	LDY		  	0,-S
			       	LDY		  	Const,U+
			       	LDY		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDY instruction", ld16Instruction.instruction,"LDY")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check LDY Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testLDYAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDY		  	[0,--X]
			       	LDY		  	[0,-X]
			       	LDY		  	[Const,X+]
			       	LDY		  	[Const,X++]
			       	LDY		  	[0,--S]
			       	LDY		  	[0,-S]
			       	LDY		  	[Const,U+]
			       	LDY		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDY instruction", ld16Instruction.instruction,"LDY")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check LDY Relative to PC Indexed 
	 */
	@Test 
	def void testLDYRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDY		  	0,PCR
			       	LDY		  	,PCR
			       	LDY		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDY instruction", ld16Instruction.instruction,"LDY")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check LDY Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testLDYRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDY		  	[0,PCR]
			       	LDY		  	[,PCR]
			       	LDY		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDY instruction", ld16Instruction.instruction,"LDY")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}

	/**
	 * Check LDS immediat 
	 */
	@Test 
	def void testLDSImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDS		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDS instruction", ld16Instruction.instruction,"LDS")
		assertTrue("Must be an immediate addressing mode", ld16Instruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check LDS direct mode 
	 */
	@Test 
	def void testLDSDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDS		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDS instruction", ld16Instruction.instruction,"LDS")
		assertTrue("Must be a direct addressing mode", ld16Instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check LDS extended mode 
	 */
	@Test 
	def void testLDSExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDS		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDS instruction", ld16Instruction.instruction,"LDS")
		assertTrue("Must be a extended addressing mode", ld16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDS extended mode 
	 */
	@Test 
	def void testLDSExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDS		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDS instruction", ld16Instruction.instruction,"LDS")
		assertTrue("Must be a extended addressing mode", ld16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDS extended indirect mode 
	 */
	@Test 
	def void testLDSExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDS		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDS instruction", ld16Instruction.instruction,"LDS")
		assertTrue("Must be a extended indirect addressing mode", ld16Instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check LDS Constant-Offset Indexed 
	 */
	@Test 
	def void testLDSConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDS		  	Const,X
					LDS		  	,X
					LDS		  	$9,U
					LDS		  	$9,S
					LDS		  	$9,X
					LDS		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDS instruction", ld16Instruction.instruction,"LDS")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check LDS Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testLDSConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDS		  	[Const,X]
					LDS		  	[,X]
					LDS		  	[$9,U]
					LDS		  	[$9,S]
					LDS		  	[$9,X]
					LDS		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDS instruction", ld16Instruction.instruction,"LDS")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check LDS Accumulator Indexed 
	 */
	@Test 
	def void testLDSAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDS		  	A,X
					LDS		  	B,X
					LDS		  	D,U
					LDS		  	A,S
					LDS		  	B,X
					LDS		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDS instruction", ld16Instruction.instruction,"LDS")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check LDS Accumulator Indexed Indirect
	 */
	@Test 
	def void testLDSAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDS		  	[A,X]
					LDS		  	[B,X]
					LDS		  	[D,U]
					LDS		  	[A,S]
					LDS		  	[B,X]
					LDS		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDS instruction", ld16Instruction.instruction,"LDS")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check LDS Auto-Increment Indexed 
	 */
	@Test 
	def void testLDSAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDS		  	0,--X
			       	LDS		  	0,-X
			       	LDS		  	Const,X+
			       	LDS		  	Const,X++
			       	LDS		  	0,--S
			       	LDS		  	0,-S
			       	LDS		  	Const,U+
			       	LDS		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDS instruction", ld16Instruction.instruction,"LDS")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check LDS Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testLDSAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDS		  	[0,--X]
			       	LDS		  	[0,-X]
			       	LDS		  	[Const,X+]
			       	LDS		  	[Const,X++]
			       	LDS		  	[0,--S]
			       	LDS		  	[0,-S]
			       	LDS		  	[Const,U+]
			       	LDS		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDS instruction", ld16Instruction.instruction,"LDS")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check LDS Relative to PC Indexed 
	 */
	@Test 
	def void testLDSRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDS		  	0,PCR
			       	LDS		  	,PCR
			       	LDS		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDS instruction", ld16Instruction.instruction,"LDS")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check LDS Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testLDSRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDS		  	[0,PCR]
			       	LDS		  	[,PCR]
			       	LDS		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDS instruction", ld16Instruction.instruction,"LDS")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}

	/**
	 * Check LDU immediat 
	 */
	@Test 
	def void testLDUImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDU		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDU instruction", ld16Instruction.instruction,"LDU")
		assertTrue("Must be an immediate addressing mode", ld16Instruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check LDU direct mode 
	 */
	@Test 
	def void testLDUDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDU		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDU instruction", ld16Instruction.instruction,"LDU")
		assertTrue("Must be a direct addressing mode", ld16Instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check LDU extended mode 
	 */
	@Test 
	def void testLDUExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDU		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDU instruction", ld16Instruction.instruction,"LDU")
		assertTrue("Must be a extended addressing mode", ld16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDU extended mode 
	 */
	@Test 
	def void testLDUExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDU		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDU instruction", ld16Instruction.instruction,"LDU")
		assertTrue("Must be a extended addressing mode", ld16Instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDU extended indirect mode 
	 */
	@Test 
	def void testLDUExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDU		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDU instruction", ld16Instruction.instruction,"LDU")
		assertTrue("Must be a extended indirect addressing mode", ld16Instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check LDU Constant-Offset Indexed 
	 */
	@Test 
	def void testLDUConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDU		  	Const,X
					LDU		  	,X
					LDU		  	$9,U
					LDU		  	$9,S
					LDU		  	$9,X
					LDU		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDU instruction", ld16Instruction.instruction,"LDU")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check LDU Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testLDUConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDU		  	[Const,X]
					LDU		  	[,X]
					LDU		  	[$9,U]
					LDU		  	[$9,S]
					LDU		  	[$9,X]
					LDU		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDU instruction", ld16Instruction.instruction,"LDU")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check LDU Accumulator Indexed 
	 */
	@Test 
	def void testLDUAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDU		  	A,X
					LDU		  	B,X
					LDU		  	D,U
					LDU		  	A,S
					LDU		  	B,X
					LDU		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDU instruction", ld16Instruction.instruction,"LDU")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check LDU Accumulator Indexed Indirect
	 */
	@Test 
	def void testLDUAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDU		  	[A,X]
					LDU		  	[B,X]
					LDU		  	[D,U]
					LDU		  	[A,S]
					LDU		  	[B,X]
					LDU		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDU instruction", ld16Instruction.instruction,"LDU")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check LDU Auto-Increment Indexed 
	 */
	@Test 
	def void testLDUAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDU		  	0,--X
			       	LDU		  	0,-X
			       	LDU		  	Const,X+
			       	LDU		  	Const,X++
			       	LDU		  	0,--S
			       	LDU		  	0,-S
			       	LDU		  	Const,U+
			       	LDU		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDU instruction", ld16Instruction.instruction,"LDU")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check LDU Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testLDUAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDU		  	[0,--X]
			       	LDU		  	[0,-X]
			       	LDU		  	[Const,X+]
			       	LDU		  	[Const,X++]
			       	LDU		  	[0,--S]
			       	LDU		  	[0,-S]
			       	LDU		  	[Const,U+]
			       	LDU		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDU instruction", ld16Instruction.instruction,"LDU")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check LDU Relative to PC Indexed 
	 */
	@Test 
	def void testLDURelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDU		  	0,PCR
			       	LDU		  	,PCR
			       	LDU		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDU instruction", ld16Instruction.instruction,"LDU")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check LDU Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testLDURelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDU		  	[0,PCR]
			       	LDU		  	[,PCR]
			       	LDU		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LD16 directive line", instructionLine.instruction instanceof Ld16Instruction)

		val ld16Instruction = instructionLine.instruction as Ld16Instruction
		assertEquals("Must be an LDU instruction", ld16Instruction.instruction,"LDU")
		assertTrue("Must be a Constant-Offset Indexed mode", ld16Instruction.operand instanceof IndexedOperand)
		val indexedOperand = ld16Instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}