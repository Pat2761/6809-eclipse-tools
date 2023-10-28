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
import org.bpy.electronics.mc6809.assembler.assembler.LslInstruction
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

class TestLSLInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check LSLA with extra space
	 */
	@Test 
	def void testSimpleLSLAWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LSLA  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsl Accumulateur line", instructionLine.instruction instanceof LslInstruction)
		val lslInstruction = instructionLine.instruction as LslInstruction
		Assert.assertEquals("Must be an LSLA instruction", "LSLA", lslInstruction.instruction)
	}
	
	/**
	 * Check LSLA with extra space
	 */
	@Test 
	def void testSimpleLSLAWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       LSLA
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsl Accumulateur line", instructionLine.instruction instanceof LslInstruction)
		val lslInstruction = instructionLine.instruction as LslInstruction
		Assert.assertEquals("Must be an LSLA instruction", "LSLA", lslInstruction.instruction)
	}
	
	/**
	 * Check LSLA with extra space
	 */
	@Test 
	def void testSimpleLSLAWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       LSLA  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsl Accumulateur line", instructionLine.instruction instanceof LslInstruction)
		val lslInstruction = instructionLine.instruction as LslInstruction
		Assert.assertEquals("Must be an LSLA instruction", "LSLA", lslInstruction.instruction)
	}
	
	/**
	 * Check LSLA with extra space
	 */
	@Test 
	def void testSimpleLSLAWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       LSLA					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsl Accumulateur line", instructionLine.instruction instanceof LslInstruction)
		val lslInstruction = instructionLine.instruction as LslInstruction
		Assert.assertEquals("Must be an LSLA instruction", "LSLA", lslInstruction.instruction)
	}
	
	/**
	 * Check LSLB with extra space
	 */
	@Test 
	def void testSimpleLSLBWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LSLB  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsl Accumulateur line", instructionLine.instruction instanceof LslInstruction)
		val lslInstruction = instructionLine.instruction as LslInstruction
		Assert.assertEquals("Must be an LSLB instruction", "LSLB", lslInstruction.instruction)
	}
	
	/**
	 * Check LSLB with extra space
	 */
	@Test 
	def void testSimpleLSLBWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       LSLB
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsl Accumulateur line", instructionLine.instruction instanceof LslInstruction)
		val lslInstruction = instructionLine.instruction as LslInstruction
		Assert.assertEquals("Must be an LSLB instruction", "LSLB", lslInstruction.instruction)
	}
	
	/**
	 * Check LSLB with extra space
	 */
	@Test 
	def void testSimpleLSLBWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       LSLB  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsl Accumulateur line", instructionLine.instruction instanceof LslInstruction)
		val lslInstruction = instructionLine.instruction as LslInstruction
		Assert.assertEquals("Must be an LSLB instruction", "LSLB", lslInstruction.instruction)
	}
	
	/**
	 * Check LSLB with extra space
	 */
	@Test 
	def void testSimpleLSLBWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       LSLB					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsl Accumulateur line", instructionLine.instruction instanceof LslInstruction)
		val lslInstruction = instructionLine.instruction as LslInstruction
		Assert.assertEquals("Must be an LSLB instruction", "LSLB", lslInstruction.instruction)
	}
	
		/**
	 * Check LSL direct mode 
	 */
	@Test 
	def void testLSLDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LSL		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LslInstruction)

		val LslInstruction = instructionLine.instruction as LslInstruction
		assertEquals("Must be an LSL instruction", LslInstruction.instruction,"LSL")
		assertTrue("Must be a direct addressing mode", LslInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check LSL extended mode 
	 */
	@Test 
	def void testLSLExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LSL		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LslInstruction)

		val LslInstruction = instructionLine.instruction as LslInstruction
		assertEquals("Must be an LSL instruction", LslInstruction.instruction,"LSL")
		assertTrue("Must be a extended addressing mode", LslInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LSL extended mode 
	 */
	@Test 
	def void testLSLExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LSL		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LslInstruction)

		val LslInstruction = instructionLine.instruction as LslInstruction
		assertEquals("Must be an LSL instruction", LslInstruction.instruction,"LSL")
		assertTrue("Must be a extended addressing mode", LslInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LSL extended indirect mode 
	 */
	@Test 
	def void testLSLExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LSL		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LslInstruction)

		val LslInstruction = instructionLine.instruction as LslInstruction
		assertEquals("Must be an LSL instruction", LslInstruction.instruction,"LSL")
		assertTrue("Must be a extended indirect addressing mode", LslInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check LSL Constant-Offset Indexed 
	 */
	@Test 
	def void testLSLConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LSL		  	Const,X
					LSL		  	,X
					LSL		  	$9,U
					LSL		  	$9,S
					LSL		  	$9,X
					LSL		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LslInstruction)

		val LslInstruction = instructionLine.instruction as LslInstruction
		assertEquals("Must be an LSL instruction", LslInstruction.instruction,"LSL")
		assertTrue("Must be a Constant-Offset Indexed mode", LslInstruction.operand instanceof IndexedOperand)
		val indexedOperand = LslInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check LSL Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testLSLConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LSL		  	[Const,X]
					LSL		  	[,X]
					LSL		  	[$9,U]
					LSL		  	[$9,S]
					LSL		  	[$9,X]
					LSL		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LslInstruction)

		val LslInstruction = instructionLine.instruction as LslInstruction
		assertEquals("Must be an LSL instruction", LslInstruction.instruction,"LSL")
		assertTrue("Must be a Constant-Offset Indexed mode", LslInstruction.operand instanceof IndexedOperand)
		val indexedOperand = LslInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check LSL Accumulator Indexed 
	 */
	@Test 
	def void testLSLAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LSL		  	A,X
					LSL		  	B,X
					LSL		  	D,U
					LSL		  	A,S
					LSL		  	B,X
					LSL		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LslInstruction)

		val LslInstruction = instructionLine.instruction as LslInstruction
		assertEquals("Must be an LSL instruction", LslInstruction.instruction,"LSL")
		assertTrue("Must be a Constant-Offset Indexed mode", LslInstruction.operand instanceof IndexedOperand)
		val indexedOperand = LslInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check LSL Accumulator Indexed Indirect
	 */
	@Test 
	def void testLSLAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LSL		  	[A,X]
					LSL		  	[B,X]
					LSL		  	[D,U]
					LSL		  	[A,S]
					LSL		  	[B,X]
					LSL		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LslInstruction)

		val LslInstruction = instructionLine.instruction as LslInstruction
		assertEquals("Must be an LSL instruction", LslInstruction.instruction,"LSL")
		assertTrue("Must be a Constant-Offset Indexed mode", LslInstruction.operand instanceof IndexedOperand)
		val indexedOperand = LslInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check LSL Auto-Increment Indexed 
	 */
	@Test 
	def void testLSLAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LSL		  	0,--X
			       	LSL		  	0,-X
			       	LSL		  	Const,X+
			       	LSL		  	Const,X++
			       	LSL		  	0,--S
			       	LSL		  	0,-S
			       	LSL		  	Const,U+
			       	LSL		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LslInstruction)

		val LslInstruction = instructionLine.instruction as LslInstruction
		assertEquals("Must be an LSL instruction", LslInstruction.instruction,"LSL")
		assertTrue("Must be a Constant-Offset Indexed mode", LslInstruction.operand instanceof IndexedOperand)
		val indexedOperand = LslInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check LSL Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testLSLAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LSL		  	[0,--X]
			       	LSL		  	[0,-X]
			       	LSL		  	[Const,X+]
			       	LSL		  	[Const,X++]
			       	LSL		  	[0,--S]
			       	LSL		  	[0,-S]
			       	LSL		  	[Const,U+]
			       	LSL		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LslInstruction)

		val LslInstruction = instructionLine.instruction as LslInstruction
		assertEquals("Must be an LSL instruction", LslInstruction.instruction,"LSL")
		assertTrue("Must be a Constant-Offset Indexed mode", LslInstruction.operand instanceof IndexedOperand)
		val indexedOperand = LslInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check LSL Relative to PC Indexed 
	 */
	@Test 
	def void testLSLRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LSL		  	0,PCR
			       	LSL		  	,PCR
			       	LSL		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LslInstruction)

		val LslInstruction = instructionLine.instruction as LslInstruction
		assertEquals("Must be an LSL instruction", LslInstruction.instruction,"LSL")
		assertTrue("Must be a Constant-Offset Indexed mode", LslInstruction.operand instanceof IndexedOperand)
		val indexedOperand = LslInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check LSL Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testLSLRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LSL		  	[0,PCR]
			       	LSL		  	[,PCR]
			       	LSL		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof LslInstruction)

		val LslInstruction = instructionLine.instruction as LslInstruction
		assertEquals("Must be an LSL instruction", LslInstruction.instruction,"LSL")
		assertTrue("Must be a Constant-Offset Indexed mode", LslInstruction.operand instanceof IndexedOperand)
		val indexedOperand = LslInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}