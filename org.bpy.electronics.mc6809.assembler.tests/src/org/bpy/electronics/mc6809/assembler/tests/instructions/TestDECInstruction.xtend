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
import org.bpy.electronics.mc6809.assembler.assembler.DecInstruction
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

class TestDECInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check DECA with extra space
	 */
	@Test 
	def void testSimpleDECAWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       DECA  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an DEC Accumulateur line", instructionLine.instruction instanceof DecInstruction)
		val decInstruction = instructionLine.instruction as DecInstruction
		Assert.assertEquals("Must be an DECA instruction", "DECA", decInstruction.instruction)
	}
	
	/**
	 * Check DECA with extra space
	 */
	@Test 
	def void testSimpleDECAWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       DECA
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an DEC Accumulateur line", instructionLine.instruction instanceof DecInstruction)
		val decInstruction = instructionLine.instruction as DecInstruction
		Assert.assertEquals("Must be an DECA instruction", "DECA", decInstruction.instruction)
	}
	
	/**
	 * Check DECA with extra space
	 */
	@Test 
	def void testSimpleDECAWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       DECA  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an DEC Accumulateur line", instructionLine.instruction instanceof DecInstruction)
		val decInstruction = instructionLine.instruction as DecInstruction
		Assert.assertEquals("Must be an DECA instruction", "DECA", decInstruction.instruction)
	}
	
	/**
	 * Check DECA with extra space
	 */
	@Test 
	def void testSimpleDECAWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       DECA					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an DEC Accumulateur line", instructionLine.instruction instanceof DecInstruction)
		val decInstruction = instructionLine.instruction as DecInstruction
		Assert.assertEquals("Must be an DECA instruction", "DECA", decInstruction.instruction)
	}
	
	/**
	 * Check DECB with extra space
	 */
	@Test 
	def void testSimpleDECBWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       DECB  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an DEC Accumulateur line", instructionLine.instruction instanceof DecInstruction)
		val decInstruction = instructionLine.instruction as DecInstruction
		Assert.assertEquals("Must be an DECB instruction", "DECB", decInstruction.instruction)
	}
	
	/**
	 * Check DECB with extra space
	 */
	@Test 
	def void testSimpleDECBWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       DECB
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an DEC Accumulateur line", instructionLine.instruction instanceof DecInstruction)
		val decInstruction = instructionLine.instruction as DecInstruction
		Assert.assertEquals("Must be an DECB instruction", "DECB", decInstruction.instruction)
	}
	
	/**
	 * Check DECB with extra space
	 */
	@Test 
	def void testSimpleDECBWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       DECB  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an DEC Accumulateur line", instructionLine.instruction instanceof DecInstruction)
		val decInstruction = instructionLine.instruction as DecInstruction
		Assert.assertEquals("Must be an DECB instruction", "DECB", decInstruction.instruction)
	}
	
	/**
	 * Check DECB with extra space
	 */
	@Test 
	def void testSimpleDECBWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       DECB					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an DEC Accumulateur line", instructionLine.instruction instanceof DecInstruction)
		val decInstruction = instructionLine.instruction as DecInstruction
		Assert.assertEquals("Must be an DECB instruction", "DECB", decInstruction.instruction)
	}
	
		/**
	 * Check DEC direct mode 
	 */
	@Test 
	def void testDECDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       DEC		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof DecInstruction)

		val decInstruction = instructionLine.instruction as DecInstruction
		assertEquals("Must be an DEC instruction", decInstruction.instruction,"DEC")
		assertTrue("Must be a direct addressing mode", decInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check DEC extended mode 
	 */
	@Test 
	def void testDECExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       DEC		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof DecInstruction)

		val decInstruction = instructionLine.instruction as DecInstruction
		assertEquals("Must be an DEC instruction", decInstruction.instruction,"DEC")
		assertTrue("Must be a extended addressing mode", decInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check DEC extended mode 
	 */
	@Test 
	def void testDECExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       DEC		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof DecInstruction)

		val decInstruction = instructionLine.instruction as DecInstruction
		assertEquals("Must be an DEC instruction", decInstruction.instruction,"DEC")
		assertTrue("Must be a extended addressing mode", decInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check DEC extended indirect mode 
	 */
	@Test 
	def void testDECExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       DEC		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof DecInstruction)

		val decInstruction = instructionLine.instruction as DecInstruction
		assertEquals("Must be an DEC instruction", decInstruction.instruction,"DEC")
		assertTrue("Must be a extended indirect addressing mode", decInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check DEC Constant-Offset Indexed 
	 */
	@Test 
	def void testDECConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	DEC		  	Const,X
					DEC		  	,X
					DEC		  	$9,U
					DEC		  	$9,S
					DEC		  	$9,X
					DEC		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof DecInstruction)

		val decInstruction = instructionLine.instruction as DecInstruction
		assertEquals("Must be an DEC instruction", decInstruction.instruction,"DEC")
		assertTrue("Must be a Constant-Offset Indexed mode", decInstruction.operand instanceof IndexedOperand)
		val indexedOperand = decInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check DEC Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testDECConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	DEC		  	[Const,X]
					DEC		  	[,X]
					DEC		  	[$9,U]
					DEC		  	[$9,S]
					DEC		  	[$9,X]
					DEC		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof DecInstruction)

		val decInstruction = instructionLine.instruction as DecInstruction
		assertEquals("Must be an DEC instruction", decInstruction.instruction,"DEC")
		assertTrue("Must be a Constant-Offset Indexed mode", decInstruction.operand instanceof IndexedOperand)
		val indexedOperand = decInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check DEC Accumulator Indexed 
	 */
	@Test 
	def void testDECAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	DEC		  	A,X
					DEC		  	B,X
					DEC		  	D,U
					DEC		  	A,S
					DEC		  	B,X
					DEC		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof DecInstruction)

		val decInstruction = instructionLine.instruction as DecInstruction
		assertEquals("Must be an DEC instruction", decInstruction.instruction,"DEC")
		assertTrue("Must be a Constant-Offset Indexed mode", decInstruction.operand instanceof IndexedOperand)
		val indexedOperand = decInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check DEC Accumulator Indexed Indirect
	 */
	@Test 
	def void testDECAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	DEC		  	[A,X]
					DEC		  	[B,X]
					DEC		  	[D,U]
					DEC		  	[A,S]
					DEC		  	[B,X]
					DEC		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof DecInstruction)

		val decInstruction = instructionLine.instruction as DecInstruction
		assertEquals("Must be an DEC instruction", decInstruction.instruction,"DEC")
		assertTrue("Must be a Constant-Offset Indexed mode", decInstruction.operand instanceof IndexedOperand)
		val indexedOperand = decInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check DEC Auto-Increment Indexed 
	 */
	@Test 
	def void testDECAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	DEC		  	0,--X
			       	DEC		  	0,-X
			       	DEC		  	Const,X+
			       	DEC		  	Const,X++
			       	DEC		  	0,--S
			       	DEC		  	0,-S
			       	DEC		  	Const,U+
			       	DEC		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof DecInstruction)

		val decInstruction = instructionLine.instruction as DecInstruction
		assertEquals("Must be an DEC instruction", decInstruction.instruction,"DEC")
		assertTrue("Must be a Constant-Offset Indexed mode", decInstruction.operand instanceof IndexedOperand)
		val indexedOperand = decInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check DEC Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testDECAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	DEC		  	[0,--X]
			       	DEC		  	[0,-X]
			       	DEC		  	[Const,X+]
			       	DEC		  	[Const,X++]
			       	DEC		  	[0,--S]
			       	DEC		  	[0,-S]
			       	DEC		  	[Const,U+]
			       	DEC		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof DecInstruction)

		val decInstruction = instructionLine.instruction as DecInstruction
		assertEquals("Must be an DEC instruction", decInstruction.instruction,"DEC")
		assertTrue("Must be a Constant-Offset Indexed mode", decInstruction.operand instanceof IndexedOperand)
		val indexedOperand = decInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check DEC Relative to PC Indexed 
	 */
	@Test 
	def void testDECRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	DEC		  	0,PCR
			       	DEC		  	,PCR
			       	DEC		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof DecInstruction)

		val decInstruction = instructionLine.instruction as DecInstruction
		assertEquals("Must be an DEC instruction", decInstruction.instruction,"DEC")
		assertTrue("Must be a Constant-Offset Indexed mode", decInstruction.operand instanceof IndexedOperand)
		val indexedOperand = decInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check DEC Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testDECRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	DEC		  	[0,PCR]
			       	DEC		  	[,PCR]
			       	DEC		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof DecInstruction)

		val decInstruction = instructionLine.instruction as DecInstruction
		assertEquals("Must be an DEC instruction", decInstruction.instruction,"DEC")
		assertTrue("Must be a Constant-Offset Indexed mode", decInstruction.operand instanceof IndexedOperand)
		val indexedOperand = decInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}