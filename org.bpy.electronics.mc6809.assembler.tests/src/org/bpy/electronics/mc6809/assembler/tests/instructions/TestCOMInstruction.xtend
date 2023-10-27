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
import org.bpy.electronics.mc6809.assembler.assembler.ComInstruction
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

class TestCOMInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check COMA with extra space
	 */
	@Test 
	def void testSimpleCOMAWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       COMA  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an COM Accumulateur line", instructionLine.instruction instanceof ComInstruction)
		val comInstruction = instructionLine.instruction as ComInstruction
		Assert.assertEquals("Must be an COMA instruction", "COMA", comInstruction.instruction)
	}
	
	/**
	 * Check COMA with extra space
	 */
	@Test 
	def void testSimpleCOMAWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       COMA
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an COM Accumulateur line", instructionLine.instruction instanceof ComInstruction)
		val comInstruction = instructionLine.instruction as ComInstruction
		Assert.assertEquals("Must be an COMA instruction", "COMA", comInstruction.instruction)
	}
	
	/**
	 * Check COMA with extra space
	 */
	@Test 
	def void testSimpleCOMAWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       COMA  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an COM Accumulateur line", instructionLine.instruction instanceof ComInstruction)
		val comInstruction = instructionLine.instruction as ComInstruction
		Assert.assertEquals("Must be an COMA instruction", "COMA", comInstruction.instruction)
	}
	
	/**
	 * Check COMA with extra space
	 */
	@Test 
	def void testSimpleCOMAWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       COMA					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an COM Accumulateur line", instructionLine.instruction instanceof ComInstruction)
		val comInstruction = instructionLine.instruction as ComInstruction
		Assert.assertEquals("Must be an COMA instruction", "COMA", comInstruction.instruction)
	}
	
	/**
	 * Check COMB with extra space
	 */
	@Test 
	def void testSimpleCOMBWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       COMB  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an COM Accumulateur line", instructionLine.instruction instanceof ComInstruction)
		val comInstruction = instructionLine.instruction as ComInstruction
		Assert.assertEquals("Must be an COMB instruction", "COMB", comInstruction.instruction)
	}
	
	/**
	 * Check COMB with extra space
	 */
	@Test 
	def void testSimpleCOMBWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       COMB
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an COM Accumulateur line", instructionLine.instruction instanceof ComInstruction)
		val comInstruction = instructionLine.instruction as ComInstruction
		Assert.assertEquals("Must be an COMB instruction", "COMB", comInstruction.instruction)
	}
	
	/**
	 * Check COMB with extra space
	 */
	@Test 
	def void testSimpleCOMBWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       COMB  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an COM Accumulateur line", instructionLine.instruction instanceof ComInstruction)
		val comInstruction = instructionLine.instruction as ComInstruction
		Assert.assertEquals("Must be an COMB instruction", "COMB", comInstruction.instruction)
	}
	
	/**
	 * Check COMB with extra space
	 */
	@Test 
	def void testSimpleCOMBWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       COMB					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an COM Accumulateur line", instructionLine.instruction instanceof ComInstruction)
		val comInstruction = instructionLine.instruction as ComInstruction
		Assert.assertEquals("Must be an COMB instruction", "COMB", comInstruction.instruction)
	}
	
		/**
	 * Check COM direct mode 
	 */
	@Test 
	def void testCOMDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       COM		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof ComInstruction)

		val comInstruction = instructionLine.instruction as ComInstruction
		assertEquals("Must be an COM instruction", comInstruction.instruction,"COM")
		assertTrue("Must be a direct addressing mode", comInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check COM extended mode 
	 */
	@Test 
	def void testCOMExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       COM		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof ComInstruction)

		val comInstruction = instructionLine.instruction as ComInstruction
		assertEquals("Must be an COM instruction", comInstruction.instruction,"COM")
		assertTrue("Must be a extended addressing mode", comInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check COM extended mode 
	 */
	@Test 
	def void testCOMExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       COM		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof ComInstruction)

		val comInstruction = instructionLine.instruction as ComInstruction
		assertEquals("Must be an COM instruction", comInstruction.instruction,"COM")
		assertTrue("Must be a extended addressing mode", comInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check COM extended indirect mode 
	 */
	@Test 
	def void testCOMExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       COM		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof ComInstruction)

		val comInstruction = instructionLine.instruction as ComInstruction
		assertEquals("Must be an COM instruction", comInstruction.instruction,"COM")
		assertTrue("Must be a extended indirect addressing mode", comInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check COM Constant-Offset Indexed 
	 */
	@Test 
	def void testCOMConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	COM		  	Const,X
					COM		  	,X
					COM		  	$9,U
					COM		  	$9,S
					COM		  	$9,X
					COM		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof ComInstruction)

		val comInstruction = instructionLine.instruction as ComInstruction
		assertEquals("Must be an COM instruction", comInstruction.instruction,"COM")
		assertTrue("Must be a Constant-Offset Indexed mode", comInstruction.operand instanceof IndexedOperand)
		val indexedOperand = comInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check COM Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testCOMConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	COM		  	[Const,X]
					COM		  	[,X]
					COM		  	[$9,U]
					COM		  	[$9,S]
					COM		  	[$9,X]
					COM		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof ComInstruction)

		val comInstruction = instructionLine.instruction as ComInstruction
		assertEquals("Must be an COM instruction", comInstruction.instruction,"COM")
		assertTrue("Must be a Constant-Offset Indexed mode", comInstruction.operand instanceof IndexedOperand)
		val indexedOperand = comInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check COM Accumulator Indexed 
	 */
	@Test 
	def void testCOMAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	COM		  	A,X
					COM		  	B,X
					COM		  	D,U
					COM		  	A,S
					COM		  	B,X
					COM		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof ComInstruction)

		val comInstruction = instructionLine.instruction as ComInstruction
		assertEquals("Must be an COM instruction", comInstruction.instruction,"COM")
		assertTrue("Must be a Constant-Offset Indexed mode", comInstruction.operand instanceof IndexedOperand)
		val indexedOperand = comInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check COM Accumulator Indexed Indirect
	 */
	@Test 
	def void testCOMAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	COM		  	[A,X]
					COM		  	[B,X]
					COM		  	[D,U]
					COM		  	[A,S]
					COM		  	[B,X]
					COM		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof ComInstruction)

		val comInstruction = instructionLine.instruction as ComInstruction
		assertEquals("Must be an COM instruction", comInstruction.instruction,"COM")
		assertTrue("Must be a Constant-Offset Indexed mode", comInstruction.operand instanceof IndexedOperand)
		val indexedOperand = comInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check COM Auto-Increment Indexed 
	 */
	@Test 
	def void testCOMAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	COM		  	0,--X
			       	COM		  	0,-X
			       	COM		  	Const,X+
			       	COM		  	Const,X++
			       	COM		  	0,--S
			       	COM		  	0,-S
			       	COM		  	Const,U+
			       	COM		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof ComInstruction)

		val comInstruction = instructionLine.instruction as ComInstruction
		assertEquals("Must be an COM instruction", comInstruction.instruction,"COM")
		assertTrue("Must be a Constant-Offset Indexed mode", comInstruction.operand instanceof IndexedOperand)
		val indexedOperand = comInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check COM Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testCOMAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	COM		  	[0,--X]
			       	COM		  	[0,-X]
			       	COM		  	[Const,X+]
			       	COM		  	[Const,X++]
			       	COM		  	[0,--S]
			       	COM		  	[0,-S]
			       	COM		  	[Const,U+]
			       	COM		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof ComInstruction)

		val comInstruction = instructionLine.instruction as ComInstruction
		assertEquals("Must be an COM instruction", comInstruction.instruction,"COM")
		assertTrue("Must be a Constant-Offset Indexed mode", comInstruction.operand instanceof IndexedOperand)
		val indexedOperand = comInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check COM Relative to PC Indexed 
	 */
	@Test 
	def void testCOMRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	COM		  	0,PCR
			       	COM		  	,PCR
			       	COM		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof ComInstruction)

		val comInstruction = instructionLine.instruction as ComInstruction
		assertEquals("Must be an COM instruction", comInstruction.instruction,"COM")
		assertTrue("Must be a Constant-Offset Indexed mode", comInstruction.operand instanceof IndexedOperand)
		val indexedOperand = comInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check COM Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testCOMRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	COM		  	[0,PCR]
			       	COM		  	[,PCR]
			       	COM		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof ComInstruction)

		val comInstruction = instructionLine.instruction as ComInstruction
		assertEquals("Must be an COM instruction", comInstruction.instruction,"COM")
		assertTrue("Must be a Constant-Offset Indexed mode", comInstruction.operand instanceof IndexedOperand)
		val indexedOperand = comInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}