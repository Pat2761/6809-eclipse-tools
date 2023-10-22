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
import org.bpy.electronics.mc6809.assembler.assembler.AsrInstruction
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

class TestASRInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check ASRA with extra space
	 */
	@Test 
	def void testSimpleASRAWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ASRA  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ASR Accumulateur line", instructionLine.instruction instanceof AsrInstruction)
		val asrInstruction = instructionLine.instruction as AsrInstruction
		Assert.assertEquals("Must be an ASRA instruction", "ASRA", asrInstruction.instruction)
	}
	
	/**
	 * Check ASRA with extra space
	 */
	@Test 
	def void testSimpleASRAWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       ASRA
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ASR Accumulateur line", instructionLine.instruction instanceof AsrInstruction)
		val asrInstruction = instructionLine.instruction as AsrInstruction
		Assert.assertEquals("Must be an ASRA instruction", "ASRA", asrInstruction.instruction)
	}
	
	/**
	 * Check ASRA with extra space
	 */
	@Test 
	def void testSimpleASRAWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       ASRA  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ASR Accumulateur line", instructionLine.instruction instanceof AsrInstruction)
		val asrInstruction = instructionLine.instruction as AsrInstruction
		Assert.assertEquals("Must be an ASRA instruction", "ASRA", asrInstruction.instruction)
	}
	
	/**
	 * Check ASRA with extra space
	 */
	@Test 
	def void testSimpleASRAWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       ASRA					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ASR Accumulateur line", instructionLine.instruction instanceof AsrInstruction)
		val asrInstruction = instructionLine.instruction as AsrInstruction
		Assert.assertEquals("Must be an ASRA instruction", "ASRA", asrInstruction.instruction)
	}
	
	/**
	 * Check ASRB with extra space
	 */
	@Test 
	def void testSimpleASRBWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ASRB  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ASR Accumulateur line", instructionLine.instruction instanceof AsrInstruction)
		val asrInstruction = instructionLine.instruction as AsrInstruction
		Assert.assertEquals("Must be an ASRB instruction", "ASRB", asrInstruction.instruction)
	}
	
	/**
	 * Check ASRB with extra space
	 */
	@Test 
	def void testSimpleASRBWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       ASRB
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ASR Accumulateur line", instructionLine.instruction instanceof AsrInstruction)
		val asrInstruction = instructionLine.instruction as AsrInstruction
		Assert.assertEquals("Must be an ASRB instruction", "ASRB", asrInstruction.instruction)
	}
	
	/**
	 * Check ASRB with extra space
	 */
	@Test 
	def void testSimpleASRBWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       ASRB  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ASR Accumulateur line", instructionLine.instruction instanceof AsrInstruction)
		val asrInstruction = instructionLine.instruction as AsrInstruction
		Assert.assertEquals("Must be an ASRB instruction", "ASRB", asrInstruction.instruction)
	}
	
	/**
	 * Check ASRB with extra space
	 */
	@Test 
	def void testSimpleASRBWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       ASRB					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ASR Accumulateur line", instructionLine.instruction instanceof AsrInstruction)
		val asrInstruction = instructionLine.instruction as AsrInstruction
		Assert.assertEquals("Must be an ASRB instruction", "ASRB", asrInstruction.instruction)
	}
	
		/**
	 * Check ASR direct mode 
	 */
	@Test 
	def void testASRDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ASR		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AsrInstruction)

		val asrInstruction = instructionLine.instruction as AsrInstruction
		assertEquals("Must be an ASR instruction", asrInstruction.instruction,"ASR")
		assertTrue("Must be a direct addressing mode", asrInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check ASR extended mode 
	 */
	@Test 
	def void testASRExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ASR		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AsrInstruction)

		val asrInstruction = instructionLine.instruction as AsrInstruction
		assertEquals("Must be an ASR instruction", asrInstruction.instruction,"ASR")
		assertTrue("Must be a extended addressing mode", asrInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ASR extended mode 
	 */
	@Test 
	def void testASRExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ASR		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AsrInstruction)

		val asrInstruction = instructionLine.instruction as AsrInstruction
		assertEquals("Must be an ASR instruction", asrInstruction.instruction,"ASR")
		assertTrue("Must be a extended addressing mode", asrInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ASR extended indirect mode 
	 */
	@Test 
	def void testASRExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ASR		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AsrInstruction)

		val asrInstruction = instructionLine.instruction as AsrInstruction
		assertEquals("Must be an ASR instruction", asrInstruction.instruction,"ASR")
		assertTrue("Must be a extended indirect addressing mode", asrInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check ASR Constant-Offset Indexed 
	 */
	@Test 
	def void testASRConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ASR		  	Const,X
					ASR		  	,X
					ASR		  	$9,U
					ASR		  	$9,S
					ASR		  	$9,X
					ASR		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AsrInstruction)

		val asrInstruction = instructionLine.instruction as AsrInstruction
		assertEquals("Must be an ASR instruction", asrInstruction.instruction,"ASR")
		assertTrue("Must be a Constant-Offset Indexed mode", asrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = asrInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check ASR Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testASRConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ASR		  	[Const,X]
					ASR		  	[,X]
					ASR		  	[$9,U]
					ASR		  	[$9,S]
					ASR		  	[$9,X]
					ASR		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AsrInstruction)

		val asrInstruction = instructionLine.instruction as AsrInstruction
		assertEquals("Must be an ASR instruction", asrInstruction.instruction,"ASR")
		assertTrue("Must be a Constant-Offset Indexed mode", asrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = asrInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check ASR Accumulator Indexed 
	 */
	@Test 
	def void testASRAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ASR		  	A,X
					ASR		  	B,X
					ASR		  	D,U
					ASR		  	A,S
					ASR		  	B,X
					ASR		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AsrInstruction)

		val asrInstruction = instructionLine.instruction as AsrInstruction
		assertEquals("Must be an ASR instruction", asrInstruction.instruction,"ASR")
		assertTrue("Must be a Constant-Offset Indexed mode", asrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = asrInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check ASR Accumulator Indexed Indirect
	 */
	@Test 
	def void testASRAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ASR		  	[A,X]
					ASR		  	[B,X]
					ASR		  	[D,U]
					ASR		  	[A,S]
					ASR		  	[B,X]
					ASR		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AsrInstruction)

		val asrInstruction = instructionLine.instruction as AsrInstruction
		assertEquals("Must be an ASR instruction", asrInstruction.instruction,"ASR")
		assertTrue("Must be a Constant-Offset Indexed mode", asrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = asrInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check ASR Auto-Increment Indexed 
	 */
	@Test 
	def void testASRAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ASR		  	0,--X
			       	ASR		  	0,-X
			       	ASR		  	Const,X+
			       	ASR		  	Const,X++
			       	ASR		  	0,--S
			       	ASR		  	0,-S
			       	ASR		  	Const,U+
			       	ASR		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AsrInstruction)

		val asrInstruction = instructionLine.instruction as AsrInstruction
		assertEquals("Must be an ASR instruction", asrInstruction.instruction,"ASR")
		assertTrue("Must be a Constant-Offset Indexed mode", asrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = asrInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check ASR Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testASRAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ASR		  	[0,--X]
			       	ASR		  	[0,-X]
			       	ASR		  	[Const,X+]
			       	ASR		  	[Const,X++]
			       	ASR		  	[0,--S]
			       	ASR		  	[0,-S]
			       	ASR		  	[Const,U+]
			       	ASR		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AsrInstruction)

		val asrInstruction = instructionLine.instruction as AsrInstruction
		assertEquals("Must be an ASR instruction", asrInstruction.instruction,"ASR")
		assertTrue("Must be a Constant-Offset Indexed mode", asrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = asrInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check ASR Relative to PC Indexed 
	 */
	@Test 
	def void testASRRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ASR		  	0,PCR
			       	ASR		  	,PCR
			       	ASR		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AsrInstruction)

		val asrInstruction = instructionLine.instruction as AsrInstruction
		assertEquals("Must be an ASR instruction", asrInstruction.instruction,"ASR")
		assertTrue("Must be a Constant-Offset Indexed mode", asrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = asrInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check ASR Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testASRRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ASR		  	[0,PCR]
			       	ASR		  	[,PCR]
			       	ASR		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AsrInstruction)

		val asrInstruction = instructionLine.instruction as AsrInstruction
		assertEquals("Must be an ASR instruction", asrInstruction.instruction,"ASR")
		assertTrue("Must be a Constant-Offset Indexed mode", asrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = asrInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}