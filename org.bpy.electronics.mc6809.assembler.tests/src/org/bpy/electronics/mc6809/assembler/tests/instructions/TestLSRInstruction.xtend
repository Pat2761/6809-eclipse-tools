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
import org.bpy.electronics.mc6809.assembler.assembler.LsrInstruction
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

class TestLSRInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check LSRA with extra space
	 */
	@Test 
	def void testSimpleLSRAWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LSRA  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsr Accumulateur line", instructionLine.instruction instanceof LsrInstruction)
		val lsrInstruction = instructionLine.instruction as LsrInstruction
		Assert.assertEquals("Must be an LSRA instruction", "LSRA", lsrInstruction.instruction)
	}
	
	/**
	 * Check LSRA with extra space
	 */
	@Test 
	def void testSimpleLSRAWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       LSRA
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsr Accumulateur line", instructionLine.instruction instanceof LsrInstruction)
		val lsrInstruction = instructionLine.instruction as LsrInstruction
		Assert.assertEquals("Must be an LSRA instruction", "LSRA", lsrInstruction.instruction)
	}
	
	/**
	 * Check LSRA with extra space
	 */
	@Test 
	def void testSimpleLSRAWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       LSRA  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsr Accumulateur line", instructionLine.instruction instanceof LsrInstruction)
		val lsrInstruction = instructionLine.instruction as LsrInstruction
		Assert.assertEquals("Must be an LSRA instruction", "LSRA", lsrInstruction.instruction)
	}
	
	/**
	 * Check LSRA with extra space
	 */
	@Test 
	def void testSimpleLSRAWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       LSRA					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsr Accumulateur line", instructionLine.instruction instanceof LsrInstruction)
		val lsrInstruction = instructionLine.instruction as LsrInstruction
		Assert.assertEquals("Must be an LSRA instruction", "LSRA", lsrInstruction.instruction)
	}
	
	/**
	 * Check LSRB with extra space
	 */
	@Test 
	def void testSimpleLSRBWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LSRB  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsr Accumulateur line", instructionLine.instruction instanceof LsrInstruction)
		val lsrInstruction = instructionLine.instruction as LsrInstruction
		Assert.assertEquals("Must be an LSRB instruction", "LSRB", lsrInstruction.instruction)
	}
	
	/**
	 * Check LSRB with extra space
	 */
	@Test 
	def void testSimpleLSRBWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       LSRB
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsr Accumulateur line", instructionLine.instruction instanceof LsrInstruction)
		val lsrInstruction = instructionLine.instruction as LsrInstruction
		Assert.assertEquals("Must be an LSRB instruction", "LSRB", lsrInstruction.instruction)
	}
	
	/**
	 * Check LSRB with extra space
	 */
	@Test 
	def void testSimpleLSRBWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       LSRB  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsr Accumulateur line", instructionLine.instruction instanceof LsrInstruction)
		val lsrInstruction = instructionLine.instruction as LsrInstruction
		Assert.assertEquals("Must be an LSRB instruction", "LSRB", lsrInstruction.instruction)
	}
	
	/**
	 * Check LSRB with extra space
	 */
	@Test 
	def void testSimpleLSRBWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       LSRB					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsr Accumulateur line", instructionLine.instruction instanceof LsrInstruction)
		val lsrInstruction = instructionLine.instruction as LsrInstruction
		Assert.assertEquals("Must be an LSRB instruction", "LSRB", lsrInstruction.instruction)
	}
	
		/**
	 * Check LSR direct mode 
	 */
	@Test 
	def void testLSRDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LSR		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LsrInstruction)

		val LsrInstruction = instructionLine.instruction as LsrInstruction
		assertEquals("Must be an LSR instruction", LsrInstruction.instruction,"LSR")
		assertTrue("Must be a direct addressing mode", LsrInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check LSR extended mode 
	 */
	@Test 
	def void testLSRExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LSR		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LsrInstruction)

		val LsrInstruction = instructionLine.instruction as LsrInstruction
		assertEquals("Must be an LSR instruction", LsrInstruction.instruction,"LSR")
		assertTrue("Must be a extended addressing mode", LsrInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LSR extended mode 
	 */
	@Test 
	def void testLSRExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LSR		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LsrInstruction)

		val LsrInstruction = instructionLine.instruction as LsrInstruction
		assertEquals("Must be an LSR instruction", LsrInstruction.instruction,"LSR")
		assertTrue("Must be a extended addressing mode", LsrInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LSR extended indirect mode 
	 */
	@Test 
	def void testLSRExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LSR		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LsrInstruction)

		val LsrInstruction = instructionLine.instruction as LsrInstruction
		assertEquals("Must be an LSR instruction", LsrInstruction.instruction,"LSR")
		assertTrue("Must be a extended indirect addressing mode", LsrInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check LSR Constant-Offset Indexed 
	 */
	@Test 
	def void testLSRConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LSR		  	Const,X
					LSR		  	,X
					LSR		  	$9,U
					LSR		  	$9,S
					LSR		  	$9,X
					LSR		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LsrInstruction)

		val LsrInstruction = instructionLine.instruction as LsrInstruction
		assertEquals("Must be an LSR instruction", LsrInstruction.instruction,"LSR")
		assertTrue("Must be a Constant-Offset Indexed mode", LsrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = LsrInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check LSR Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testLSRConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LSR		  	[Const,X]
					LSR		  	[,X]
					LSR		  	[$9,U]
					LSR		  	[$9,S]
					LSR		  	[$9,X]
					LSR		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LsrInstruction)

		val LsrInstruction = instructionLine.instruction as LsrInstruction
		assertEquals("Must be an LSR instruction", LsrInstruction.instruction,"LSR")
		assertTrue("Must be a Constant-Offset Indexed mode", LsrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = LsrInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check LSR Accumulator Indexed 
	 */
	@Test 
	def void testLSRAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LSR		  	A,X
					LSR		  	B,X
					LSR		  	D,U
					LSR		  	A,S
					LSR		  	B,X
					LSR		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LsrInstruction)

		val LsrInstruction = instructionLine.instruction as LsrInstruction
		assertEquals("Must be an LSR instruction", LsrInstruction.instruction,"LSR")
		assertTrue("Must be a Constant-Offset Indexed mode", LsrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = LsrInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check LSR Accumulator Indexed Indirect
	 */
	@Test 
	def void testLSRAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LSR		  	[A,X]
					LSR		  	[B,X]
					LSR		  	[D,U]
					LSR		  	[A,S]
					LSR		  	[B,X]
					LSR		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LsrInstruction)

		val LsrInstruction = instructionLine.instruction as LsrInstruction
		assertEquals("Must be an LSR instruction", LsrInstruction.instruction,"LSR")
		assertTrue("Must be a Constant-Offset Indexed mode", LsrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = LsrInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check LSR Auto-Increment Indexed 
	 */
	@Test 
	def void testLSRAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LSR		  	0,--X
			       	LSR		  	0,-X
			       	LSR		  	Const,X+
			       	LSR		  	Const,X++
			       	LSR		  	0,--S
			       	LSR		  	0,-S
			       	LSR		  	Const,U+
			       	LSR		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LsrInstruction)

		val LsrInstruction = instructionLine.instruction as LsrInstruction
		assertEquals("Must be an LSR instruction", LsrInstruction.instruction,"LSR")
		assertTrue("Must be a Constant-Offset Indexed mode", LsrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = LsrInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check LSR Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testLSRAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LSR		  	[0,--X]
			       	LSR		  	[0,-X]
			       	LSR		  	[Const,X+]
			       	LSR		  	[Const,X++]
			       	LSR		  	[0,--S]
			       	LSR		  	[0,-S]
			       	LSR		  	[Const,U+]
			       	LSR		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LsrInstruction)

		val LsrInstruction = instructionLine.instruction as LsrInstruction
		assertEquals("Must be an LSR instruction", LsrInstruction.instruction,"LSR")
		assertTrue("Must be a Constant-Offset Indexed mode", LsrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = LsrInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check LSR Relative to PC Indexed 
	 */
	@Test 
	def void testLSRRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LSR		  	0,PCR
			       	LSR		  	,PCR
			       	LSR		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LsrInstruction)

		val LsrInstruction = instructionLine.instruction as LsrInstruction
		assertEquals("Must be an LSR instruction", LsrInstruction.instruction,"LSR")
		assertTrue("Must be a Constant-Offset Indexed mode", LsrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = LsrInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check LSR Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testLSRRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LSR		  	[0,PCR]
			       	LSR		  	[,PCR]
			       	LSR		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LsrInstruction)

		val LsrInstruction = instructionLine.instruction as LsrInstruction
		assertEquals("Must be an LSR instruction", LsrInstruction.instruction,"LSR")
		assertTrue("Must be a Constant-Offset Indexed mode", LsrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = LsrInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}