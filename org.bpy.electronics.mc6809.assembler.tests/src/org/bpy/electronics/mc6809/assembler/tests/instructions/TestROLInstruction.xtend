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
import org.bpy.electronics.mc6809.assembler.assembler.RolInstruction
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

class TestROLInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check ROLA with extra space
	 */
	@Test 
	def void testSimpleROLAWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ROLA  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Rol Accumulateur line", instructionLine.instruction instanceof RolInstruction)
		val rolInstruction = instructionLine.instruction as RolInstruction
		Assert.assertEquals("Must be an ROLA instruction", "ROLA", rolInstruction.instruction)
	}
	
	/**
	 * Check ROLA with extra space
	 */
	@Test 
	def void testSimpleROLAWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       ROLA
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Rol Accumulateur line", instructionLine.instruction instanceof RolInstruction)
		val rolInstruction = instructionLine.instruction as RolInstruction
		Assert.assertEquals("Must be an ROLA instruction", "ROLA", rolInstruction.instruction)
	}
	
	/**
	 * Check ROLA with extra space
	 */
	@Test 
	def void testSimpleROLAWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       ROLA  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Rol Accumulateur line", instructionLine.instruction instanceof RolInstruction)
		val rolInstruction = instructionLine.instruction as RolInstruction
		Assert.assertEquals("Must be an ROLA instruction", "ROLA", rolInstruction.instruction)
	}
	
	/**
	 * Check ROLA with extra space
	 */
	@Test 
	def void testSimpleROLAWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       ROLA					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Rol Accumulateur line", instructionLine.instruction instanceof RolInstruction)
		val rolInstruction = instructionLine.instruction as RolInstruction
		Assert.assertEquals("Must be an ROLA instruction", "ROLA", rolInstruction.instruction)
	}
	
	/**
	 * Check ROLB with extra space
	 */
	@Test 
	def void testSimpleROLBWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ROLB  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Rol Accumulateur line", instructionLine.instruction instanceof RolInstruction)
		val rolInstruction = instructionLine.instruction as RolInstruction
		Assert.assertEquals("Must be an ROLB instruction", "ROLB", rolInstruction.instruction)
	}
	
	/**
	 * Check ROLB with extra space
	 */
	@Test 
	def void testSimpleROLBWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       ROLB
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Rol Accumulateur line", instructionLine.instruction instanceof RolInstruction)
		val rolInstruction = instructionLine.instruction as RolInstruction
		Assert.assertEquals("Must be an ROLB instruction", "ROLB", rolInstruction.instruction)
	}
	
	/**
	 * Check ROLB with extra space
	 */
	@Test 
	def void testSimpleROLBWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       ROLB  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Rol Accumulateur line", instructionLine.instruction instanceof RolInstruction)
		val rolInstruction = instructionLine.instruction as RolInstruction
		Assert.assertEquals("Must be an ROLB instruction", "ROLB", rolInstruction.instruction)
	}
	
	/**
	 * Check ROLB with extra space
	 */
	@Test 
	def void testSimpleROLBWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       ROLB					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Rol Accumulateur line", instructionLine.instruction instanceof RolInstruction)
		val rolInstruction = instructionLine.instruction as RolInstruction
		Assert.assertEquals("Must be an ROLB instruction", "ROLB", rolInstruction.instruction)
	}
	
		/**
	 * Check ROL direct mode 
	 */
	@Test 
	def void testROLDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ROL		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RolInstruction)

		val RolInstruction = instructionLine.instruction as RolInstruction
		assertEquals("Must be an ROL instruction", RolInstruction.instruction,"ROL")
		assertTrue("Must be a direct addressing mode", RolInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check ROL extended mode 
	 */
	@Test 
	def void testROLExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ROL		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RolInstruction)

		val RolInstruction = instructionLine.instruction as RolInstruction
		assertEquals("Must be an ROL instruction", RolInstruction.instruction,"ROL")
		assertTrue("Must be a extended addressing mode", RolInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ROL extended mode 
	 */
	@Test 
	def void testROLExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ROL		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RolInstruction)

		val RolInstruction = instructionLine.instruction as RolInstruction
		assertEquals("Must be an ROL instruction", RolInstruction.instruction,"ROL")
		assertTrue("Must be a extended addressing mode", RolInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ROL extended indirect mode 
	 */
	@Test 
	def void testROLExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ROL		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RolInstruction)

		val RolInstruction = instructionLine.instruction as RolInstruction
		assertEquals("Must be an ROL instruction", RolInstruction.instruction,"ROL")
		assertTrue("Must be a extended indirect addressing mode", RolInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check ROL Constant-Offset Indexed 
	 */
	@Test 
	def void testROLConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ROL		  	Const,X
					ROL		  	,X
					ROL		  	$9,U
					ROL		  	$9,S
					ROL		  	$9,X
					ROL		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RolInstruction)

		val RolInstruction = instructionLine.instruction as RolInstruction
		assertEquals("Must be an ROL instruction", RolInstruction.instruction,"ROL")
		assertTrue("Must be a Constant-Offset Indexed mode", RolInstruction.operand instanceof IndexedOperand)
		val indexedOperand = RolInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check ROL Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testROLConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ROL		  	[Const,X]
					ROL		  	[,X]
					ROL		  	[$9,U]
					ROL		  	[$9,S]
					ROL		  	[$9,X]
					ROL		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RolInstruction)

		val RolInstruction = instructionLine.instruction as RolInstruction
		assertEquals("Must be an ROL instruction", RolInstruction.instruction,"ROL")
		assertTrue("Must be a Constant-Offset Indexed mode", RolInstruction.operand instanceof IndexedOperand)
		val indexedOperand = RolInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check ROL Accumulator Indexed 
	 */
	@Test 
	def void testROLAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ROL		  	A,X
					ROL		  	B,X
					ROL		  	D,U
					ROL		  	A,S
					ROL		  	B,X
					ROL		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RolInstruction)

		val RolInstruction = instructionLine.instruction as RolInstruction
		assertEquals("Must be an ROL instruction", RolInstruction.instruction,"ROL")
		assertTrue("Must be a Constant-Offset Indexed mode", RolInstruction.operand instanceof IndexedOperand)
		val indexedOperand = RolInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check ROL Accumulator Indexed Indirect
	 */
	@Test 
	def void testROLAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ROL		  	[A,X]
					ROL		  	[B,X]
					ROL		  	[D,U]
					ROL		  	[A,S]
					ROL		  	[B,X]
					ROL		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RolInstruction)

		val RolInstruction = instructionLine.instruction as RolInstruction
		assertEquals("Must be an ROL instruction", RolInstruction.instruction,"ROL")
		assertTrue("Must be a Constant-Offset Indexed mode", RolInstruction.operand instanceof IndexedOperand)
		val indexedOperand = RolInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check ROL Auto-Increment Indexed 
	 */
	@Test 
	def void testROLAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ROL		  	0,--X
			       	ROL		  	0,-X
			       	ROL		  	Const,X+
			       	ROL		  	Const,X++
			       	ROL		  	0,--S
			       	ROL		  	0,-S
			       	ROL		  	Const,U+
			       	ROL		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RolInstruction)

		val RolInstruction = instructionLine.instruction as RolInstruction
		assertEquals("Must be an ROL instruction", RolInstruction.instruction,"ROL")
		assertTrue("Must be a Constant-Offset Indexed mode", RolInstruction.operand instanceof IndexedOperand)
		val indexedOperand = RolInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check ROL Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testROLAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ROL		  	[0,--X]
			       	ROL		  	[0,-X]
			       	ROL		  	[Const,X+]
			       	ROL		  	[Const,X++]
			       	ROL		  	[0,--S]
			       	ROL		  	[0,-S]
			       	ROL		  	[Const,U+]
			       	ROL		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RolInstruction)

		val RolInstruction = instructionLine.instruction as RolInstruction
		assertEquals("Must be an ROL instruction", RolInstruction.instruction,"ROL")
		assertTrue("Must be a Constant-Offset Indexed mode", RolInstruction.operand instanceof IndexedOperand)
		val indexedOperand = RolInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check ROL Relative to PC Indexed 
	 */
	@Test 
	def void testROLRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ROL		  	0,PCR
			       	ROL		  	,PCR
			       	ROL		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RolInstruction)

		val RolInstruction = instructionLine.instruction as RolInstruction
		assertEquals("Must be an ROL instruction", RolInstruction.instruction,"ROL")
		assertTrue("Must be a Constant-Offset Indexed mode", RolInstruction.operand instanceof IndexedOperand)
		val indexedOperand = RolInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check ROL Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testROLRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ROL		  	[0,PCR]
			       	ROL		  	[,PCR]
			       	ROL		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof RolInstruction)

		val RolInstruction = instructionLine.instruction as RolInstruction
		assertEquals("Must be an ROL instruction", RolInstruction.instruction,"ROL")
		assertTrue("Must be a Constant-Offset Indexed mode", RolInstruction.operand instanceof IndexedOperand)
		val indexedOperand = RolInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}