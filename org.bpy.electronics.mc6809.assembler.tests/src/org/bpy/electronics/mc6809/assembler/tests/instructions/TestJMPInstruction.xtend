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
import org.bpy.electronics.mc6809.assembler.assembler.JmpInstruction
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

class TestJMPInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check JMP with extra space
	 */
	@Test 
	def void testSimpleJMPWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		Origin	       	ORG    		$8000
			       		JMP			Origin 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an JMP instruction line", instructionLine.instruction instanceof JmpInstruction)
	}
	
	/**
	 * Check JMP with extra space
	 */
	@Test 
	def void testSimpleJMPWithExtraSpace2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		Origin	       	ORG    		$8000
			       		JMP			$8000 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an JMP instruction line", instructionLine.instruction instanceof JmpInstruction)
	}
	/**
	 * Check JMP direct mode 
	 */
	@Test 
	def void testJMPDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       JMP		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JmpInstruction)

		val jmpInstruction = instructionLine.instruction as JmpInstruction
		assertEquals("Must be an JMP instruction", jmpInstruction.instruction,"JMP")
		assertTrue("Must be a direct addressing mode", jmpInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check JMP extended mode 
	 */
	@Test 
	def void testJMPExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       JMP		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JmpInstruction)

		val jmpInstruction = instructionLine.instruction as JmpInstruction
		assertEquals("Must be an JMP instruction", jmpInstruction.instruction,"JMP")
		assertTrue("Must be a extended addressing mode", jmpInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check JMP extended mode 
	 */
	@Test 
	def void testJMPExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       JMP		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JmpInstruction)

		val jmpInstruction = instructionLine.instruction as JmpInstruction
		assertEquals("Must be an JMP instruction", jmpInstruction.instruction,"JMP")
		assertTrue("Must be a extended addressing mode", jmpInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check JMP extended indirect mode 
	 */
	@Test 
	def void testJMPExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       JMP		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JmpInstruction)

		val jmpInstruction = instructionLine.instruction as JmpInstruction
		assertEquals("Must be an JMP instruction", jmpInstruction.instruction,"JMP")
		assertTrue("Must be a extended indirect addressing mode", jmpInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check JMP Constant-Offset Indexed 
	 */
	@Test 
	def void testJMPConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	JMP		  	Const,X
					JMP		  	,X
					JMP		  	$9,U
					JMP		  	$9,S
					JMP		  	$9,X
					JMP		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JmpInstruction)

		val jmpInstruction = instructionLine.instruction as JmpInstruction
		assertEquals("Must be an JMP instruction", jmpInstruction.instruction,"JMP")
		assertTrue("Must be a Constant-Offset Indexed mode", jmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = jmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check JMP Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testJMPConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	JMP		  	[Const,X]
					JMP		  	[,X]
					JMP		  	[$9,U]
					JMP		  	[$9,S]
					JMP		  	[$9,X]
					JMP		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JmpInstruction)

		val jmpInstruction = instructionLine.instruction as JmpInstruction
		assertEquals("Must be an JMP instruction", jmpInstruction.instruction,"JMP")
		assertTrue("Must be a Constant-Offset Indexed mode", jmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = jmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check JMP Accumulator Indexed 
	 */
	@Test 
	def void testJMPAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	JMP		  	A,X
					JMP		  	B,X
					JMP		  	D,U
					JMP		  	A,S
					JMP		  	B,X
					JMP		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JmpInstruction)

		val jmpInstruction = instructionLine.instruction as JmpInstruction
		assertEquals("Must be an JMP instruction", jmpInstruction.instruction,"JMP")
		assertTrue("Must be a Constant-Offset Indexed mode", jmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = jmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check JMP Accumulator Indexed Indirect
	 */
	@Test 
	def void testJMPAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	JMP		  	[A,X]
					JMP		  	[B,X]
					JMP		  	[D,U]
					JMP		  	[A,S]
					JMP		  	[B,X]
					JMP		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JmpInstruction)

		val jmpInstruction = instructionLine.instruction as JmpInstruction
		assertEquals("Must be an JMP instruction", jmpInstruction.instruction,"JMP")
		assertTrue("Must be a Constant-Offset Indexed mode", jmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = jmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check JMP Auto-Jmprement Indexed 
	 */
	@Test 
	def void testJMPAutoJmprementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	JMP		  	0,--X
			       	JMP		  	0,-X
			       	JMP		  	Const,X+
			       	JMP		  	Const,X++
			       	JMP		  	0,--S
			       	JMP		  	0,-S
			       	JMP		  	Const,U+
			       	JMP		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JmpInstruction)

		val jmpInstruction = instructionLine.instruction as JmpInstruction
		assertEquals("Must be an JMP instruction", jmpInstruction.instruction,"JMP")
		assertTrue("Must be a Constant-Offset Indexed mode", jmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = jmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Jmprement Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check JMP Auto-Jmprement Indexed Indirect
	 */
	@Test 
	def void testJMPAutoJmprementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	JMP		  	[0,--X]
			       	JMP		  	[0,-X]
			       	JMP		  	[Const,X+]
			       	JMP		  	[Const,X++]
			       	JMP		  	[0,--S]
			       	JMP		  	[0,-S]
			       	JMP		  	[Const,U+]
			       	JMP		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JmpInstruction)

		val jmpInstruction = instructionLine.instruction as JmpInstruction
		assertEquals("Must be an JMP instruction", jmpInstruction.instruction,"JMP")
		assertTrue("Must be a Constant-Offset Indexed mode", jmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = jmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Jmprement Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check JMP Relative to PC Indexed 
	 */
	@Test 
	def void testJMPRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	JMP		  	0,PCR
			       	JMP		  	,PCR
			       	JMP		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JmpInstruction)

		val jmpInstruction = instructionLine.instruction as JmpInstruction
		assertEquals("Must be an JMP instruction", jmpInstruction.instruction,"JMP")
		assertTrue("Must be a Constant-Offset Indexed mode", jmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = jmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check JMP Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testJMPRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	JMP		  	[0,PCR]
			       	JMP		  	[,PCR]
			       	JMP		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JmpInstruction)

		val jmpInstruction = instructionLine.instruction as JmpInstruction
		assertEquals("Must be an JMP instruction", jmpInstruction.instruction,"JMP")
		assertTrue("Must be a Constant-Offset Indexed mode", jmpInstruction.operand instanceof IndexedOperand)
		val indexedOperand = jmpInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}