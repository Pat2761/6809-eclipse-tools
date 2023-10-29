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
import org.bpy.electronics.mc6809.assembler.assembler.RorInstruction
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

class TestRORInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check RORA with extra space
	 */
	@Test 
	def void testSimpleRORAWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       RORA  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Ror Accumulateur line", instructionLine.instruction instanceof RorInstruction)
		val rorInstruction = instructionLine.instruction as RorInstruction
		Assert.assertEquals("Must be an RORA instruction", "RORA", rorInstruction.instruction)
	}
	
	/**
	 * Check RORA with extra space
	 */
	@Test 
	def void testSimpleRORAWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       RORA
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Ror Accumulateur line", instructionLine.instruction instanceof RorInstruction)
		val rorInstruction = instructionLine.instruction as RorInstruction
		Assert.assertEquals("Must be an RORA instruction", "RORA", rorInstruction.instruction)
	}
	
	/**
	 * Check RORA with extra space
	 */
	@Test 
	def void testSimpleRORAWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       RORA  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Ror Accumulateur line", instructionLine.instruction instanceof RorInstruction)
		val rorInstruction = instructionLine.instruction as RorInstruction
		Assert.assertEquals("Must be an RORA instruction", "RORA", rorInstruction.instruction)
	}
	
	/**
	 * Check RORA with extra space
	 */
	@Test 
	def void testSimpleRORAWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       RORA					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Ror Accumulateur line", instructionLine.instruction instanceof RorInstruction)
		val rorInstruction = instructionLine.instruction as RorInstruction
		Assert.assertEquals("Must be an RORA instruction", "RORA", rorInstruction.instruction)
	}
	
	/**
	 * Check RORB with extra space
	 */
	@Test 
	def void testSimpleRORBWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       RORB  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Ror Accumulateur line", instructionLine.instruction instanceof RorInstruction)
		val rorInstruction = instructionLine.instruction as RorInstruction
		Assert.assertEquals("Must be an RORB instruction", "RORB", rorInstruction.instruction)
	}
	
	/**
	 * Check RORB with extra space
	 */
	@Test 
	def void testSimpleRORBWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       RORB
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Ror Accumulateur line", instructionLine.instruction instanceof RorInstruction)
		val rorInstruction = instructionLine.instruction as RorInstruction
		Assert.assertEquals("Must be an RORB instruction", "RORB", rorInstruction.instruction)
	}
	
	/**
	 * Check RORB with extra space
	 */
	@Test 
	def void testSimpleRORBWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       RORB  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Ror Accumulateur line", instructionLine.instruction instanceof RorInstruction)
		val rorInstruction = instructionLine.instruction as RorInstruction
		Assert.assertEquals("Must be an RORB instruction", "RORB", rorInstruction.instruction)
	}
	
	/**
	 * Check RORB with extra space
	 */
	@Test 
	def void testSimpleRORBWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       RORB					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Ror Accumulateur line", instructionLine.instruction instanceof RorInstruction)
		val rorInstruction = instructionLine.instruction as RorInstruction
		Assert.assertEquals("Must be an RORB instruction", "RORB", rorInstruction.instruction)
	}
	
		/**
	 * Check ROR direct mode 
	 */
	@Test 
	def void testRORDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ROR		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RorInstruction)

		val rorInstruction = instructionLine.instruction as RorInstruction
		assertEquals("Must be an ROR instruction", rorInstruction.instruction,"ROR")
		assertTrue("Must be a direct addressing mode", rorInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check ROR extended mode 
	 */
	@Test 
	def void testRORExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ROR		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RorInstruction)

		val RorInstruction = instructionLine.instruction as RorInstruction
		assertEquals("Must be an ROR instruction", RorInstruction.instruction,"ROR")
		assertTrue("Must be a extended addressing mode", RorInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ROR extended mode 
	 */
	@Test 
	def void testRORExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ROR		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RorInstruction)

		val RorInstruction = instructionLine.instruction as RorInstruction
		assertEquals("Must be an ROR instruction", RorInstruction.instruction,"ROR")
		assertTrue("Must be a extended addressing mode", RorInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ROR extended indirect mode 
	 */
	@Test 
	def void testRORExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ROR		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RorInstruction)

		val RorInstruction = instructionLine.instruction as RorInstruction
		assertEquals("Must be an ROR instruction", RorInstruction.instruction,"ROR")
		assertTrue("Must be a extended indirect addressing mode", RorInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check ROR Constant-Offset Indexed 
	 */
	@Test 
	def void testRORConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ROR		  	Const,X
					ROR		  	,X
					ROR		  	$9,U
					ROR		  	$9,S
					ROR		  	$9,X
					ROR		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RorInstruction)

		val RorInstruction = instructionLine.instruction as RorInstruction
		assertEquals("Must be an ROR instruction", RorInstruction.instruction,"ROR")
		assertTrue("Must be a Constant-Offset Indexed mode", RorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = RorInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check ROR Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testRORConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ROR		  	[Const,X]
					ROR		  	[,X]
					ROR		  	[$9,U]
					ROR		  	[$9,S]
					ROR		  	[$9,X]
					ROR		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RorInstruction)

		val RorInstruction = instructionLine.instruction as RorInstruction
		assertEquals("Must be an ROR instruction", RorInstruction.instruction,"ROR")
		assertTrue("Must be a Constant-Offset Indexed mode", RorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = RorInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check ROR Accumulator Indexed 
	 */
	@Test 
	def void testRORAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ROR		  	A,X
					ROR		  	B,X
					ROR		  	D,U
					ROR		  	A,S
					ROR		  	B,X
					ROR		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RorInstruction)

		val RorInstruction = instructionLine.instruction as RorInstruction
		assertEquals("Must be an ROR instruction", RorInstruction.instruction,"ROR")
		assertTrue("Must be a Constant-Offset Indexed mode", RorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = RorInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check ROR Accumulator Indexed Indirect
	 */
	@Test 
	def void testRORAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ROR		  	[A,X]
					ROR		  	[B,X]
					ROR		  	[D,U]
					ROR		  	[A,S]
					ROR		  	[B,X]
					ROR		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RorInstruction)

		val RorInstruction = instructionLine.instruction as RorInstruction
		assertEquals("Must be an ROR instruction", RorInstruction.instruction,"ROR")
		assertTrue("Must be a Constant-Offset Indexed mode", RorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = RorInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check ROR Auto-Increment Indexed 
	 */
	@Test 
	def void testRORAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ROR		  	0,--X
			       	ROR		  	0,-X
			       	ROR		  	Const,X+
			       	ROR		  	Const,X++
			       	ROR		  	0,--S
			       	ROR		  	0,-S
			       	ROR		  	Const,U+
			       	ROR		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RorInstruction)

		val RorInstruction = instructionLine.instruction as RorInstruction
		assertEquals("Must be an ROR instruction", RorInstruction.instruction,"ROR")
		assertTrue("Must be a Constant-Offset Indexed mode", RorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = RorInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check ROR Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testRORAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ROR		  	[0,--X]
			       	ROR		  	[0,-X]
			       	ROR		  	[Const,X+]
			       	ROR		  	[Const,X++]
			       	ROR		  	[0,--S]
			       	ROR		  	[0,-S]
			       	ROR		  	[Const,U+]
			       	ROR		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RorInstruction)

		val RorInstruction = instructionLine.instruction as RorInstruction
		assertEquals("Must be an ROR instruction", RorInstruction.instruction,"ROR")
		assertTrue("Must be a Constant-Offset Indexed mode", RorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = RorInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check ROR Relative to PC Indexed 
	 */
	@Test 
	def void testRORRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ROR		  	0,PCR
			       	ROR		  	,PCR
			       	ROR		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RorInstruction)

		val RorInstruction = instructionLine.instruction as RorInstruction
		assertEquals("Must be an ROR instruction", RorInstruction.instruction,"ROR")
		assertTrue("Must be a Constant-Offset Indexed mode", RorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = RorInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check ROR Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testRORRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ROR		  	[0,PCR]
			       	ROR		  	[,PCR]
			       	ROR		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RorInstruction)

		val RorInstruction = instructionLine.instruction as RorInstruction
		assertEquals("Must be an ROR instruction", RorInstruction.instruction,"ROR")
		assertTrue("Must be a Constant-Offset Indexed mode", RorInstruction.operand instanceof IndexedOperand)
		val indexedOperand = RorInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}