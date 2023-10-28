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
import org.bpy.electronics.mc6809.assembler.assembler.IncInstruction
import org.bpy.electronics.mc6809.assembler.assembler.IndexedOperand
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCMode
import org.bpy.electronics.mc6809.assembler.assembler.DirectOperand
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedOperand
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedIndirectOperand
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMode
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingMode
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingIndirectMode
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCIndirectMode
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecMode
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecIndirectMode

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestINCInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check INCA with extra space
	 */
	@Test 
	def void testSimpleINCAWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       INCA  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC Accumulateur line", instructionLine.instruction instanceof IncInstruction)
		val incInstruction = instructionLine.instruction as IncInstruction
		Assert.assertEquals("Must be an INCA instruction", "INCA", incInstruction.instruction)
	}
	
	/**
	 * Check INCA with extra space
	 */
	@Test 
	def void testSimpleINCAWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       INCA
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC Accumulateur line", instructionLine.instruction instanceof IncInstruction)
		val incInstruction = instructionLine.instruction as IncInstruction
		Assert.assertEquals("Must be an INCA instruction", "INCA", incInstruction.instruction)
	}
	
	/**
	 * Check INCA with extra space
	 */
	@Test 
	def void testSimpleINCAWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       INCA  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC Accumulateur line", instructionLine.instruction instanceof IncInstruction)
		val incInstruction = instructionLine.instruction as IncInstruction
		Assert.assertEquals("Must be an INCA instruction", "INCA", incInstruction.instruction)
	}
	
	/**
	 * Check INCA with extra space
	 */
	@Test 
	def void testSimpleINCAWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       INCA					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC Accumulateur line", instructionLine.instruction instanceof IncInstruction)
		val incInstruction = instructionLine.instruction as IncInstruction
		Assert.assertEquals("Must be an INCA instruction", "INCA", incInstruction.instruction)
	}
	
	/**
	 * Check INCB with extra space
	 */
	@Test 
	def void testSimpleINCBWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       INCB  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC Accumulateur line", instructionLine.instruction instanceof IncInstruction)
		val incInstruction = instructionLine.instruction as IncInstruction
		Assert.assertEquals("Must be an INCB instruction", "INCB", incInstruction.instruction)
	}
	
	/**
	 * Check INCB with extra space
	 */
	@Test 
	def void testSimpleINCBWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       INCB
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC Accumulateur line", instructionLine.instruction instanceof IncInstruction)
		val incInstruction = instructionLine.instruction as IncInstruction
		Assert.assertEquals("Must be an INCB instruction", "INCB", incInstruction.instruction)
	}
	
	/**
	 * Check INCB with extra space
	 */
	@Test 
	def void testSimpleINCBWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       INCB  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC Accumulateur line", instructionLine.instruction instanceof IncInstruction)
		val incInstruction = instructionLine.instruction as IncInstruction
		Assert.assertEquals("Must be an INCB instruction", "INCB", incInstruction.instruction)
	}
	
	/**
	 * Check INCB with extra space
	 */
	@Test 
	def void testSimpleINCBWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       INCB					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC Accumulateur line", instructionLine.instruction instanceof IncInstruction)
		val incInstruction = instructionLine.instruction as IncInstruction
		Assert.assertEquals("Must be an INCB instruction", "INCB", incInstruction.instruction)
	}
	
		/**
	 * Check INC direct mode 
	 */
	@Test 
	def void testINCDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       INC		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a direct addressing mode", incInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check INC extended mode 
	 */
	@Test 
	def void testINCExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       INC		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a extended addressing mode", incInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check INC extended mode 
	 */
	@Test 
	def void testINCExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       INC		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a extended addressing mode", incInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check INC extended indirect mode 
	 */
	@Test 
	def void testINCExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       INC		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a extended indirect addressing mode", incInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check INC Constant-Offset Indexed 
	 */
	@Test 
	def void testINCConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	INC		  	Const,X
					INC		  	,X
					INC		  	$9,U
					INC		  	$9,S
					INC		  	$9,X
					INC		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a Constant-Offset Indexed mode", incInstruction.operand instanceof IndexedOperand)
		val indexedOperand = incInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check INC Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testINCConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	INC		  	[Const,X]
					INC		  	[,X]
					INC		  	[$9,U]
					INC		  	[$9,S]
					INC		  	[$9,X]
					INC		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a Constant-Offset Indexed mode", incInstruction.operand instanceof IndexedOperand)
		val indexedOperand = incInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check INC Accumulator Indexed 
	 */
	@Test 
	def void testINCAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	INC		  	A,X
					INC		  	B,X
					INC		  	D,U
					INC		  	A,S
					INC		  	B,X
					INC		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a Constant-Offset Indexed mode", incInstruction.operand instanceof IndexedOperand)
		val indexedOperand = incInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check INC Accumulator Indexed Indirect
	 */
	@Test 
	def void testINCAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	INC		  	[A,X]
					INC		  	[B,X]
					INC		  	[D,U]
					INC		  	[A,S]
					INC		  	[B,X]
					INC		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a Constant-Offset Indexed mode", incInstruction.operand instanceof IndexedOperand)
		val indexedOperand = incInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check INC Auto-Increment Indexed 
	 */
	@Test 
	def void testINCAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	INC		  	0,--X
			       	INC		  	0,-X
			       	INC		  	Const,X+
			       	INC		  	Const,X++
			       	INC		  	0,--S
			       	INC		  	0,-S
			       	INC		  	Const,U+
			       	INC		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a Constant-Offset Indexed mode", incInstruction.operand instanceof IndexedOperand)
		val indexedOperand = incInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check INC Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testINCAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	INC		  	[0,--X]
			       	INC		  	[0,-X]
			       	INC		  	[Const,X+]
			       	INC		  	[Const,X++]
			       	INC		  	[0,--S]
			       	INC		  	[0,-S]
			       	INC		  	[Const,U+]
			       	INC		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a Constant-Offset Indexed mode", incInstruction.operand instanceof IndexedOperand)
		val indexedOperand = incInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check INC Relative to PC Indexed 
	 */
	@Test 
	def void testINCRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	INC		  	0,PCR
			       	INC		  	,PCR
			       	INC		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a Constant-Offset Indexed mode", incInstruction.operand instanceof IndexedOperand)
		val indexedOperand = incInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check INC Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testINCRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	INC		  	[0,PCR]
			       	INC		  	[,PCR]
			       	INC		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a Constant-Offset Indexed mode", incInstruction.operand instanceof IndexedOperand)
		val indexedOperand = incInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}