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
import org.bpy.electronics.mc6809.assembler.assembler.JsrInstruction
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

class TestJSRInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check JSR with extra space
	 */
	@Test 
	def void testSimpleJSRWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		Origin	       	ORG    		$8000
			       		JSR			Origin 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an JSR instruction line", instructionLine.instruction instanceof JsrInstruction)
	}
	
	/**
	 * Check JSR with extra space
	 */
	@Test 
	def void testSimpleJSRWithExtraSpace2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		Origin	       	ORG    		$8000
			       		JSR			$8000 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an JSR instruction line", instructionLine.instruction instanceof JsrInstruction)
	}
	/**
	 * Check JSR direct mode 
	 */
	@Test 
	def void testJSRDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       JSR		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JsrInstruction)

		val jsrInstruction = instructionLine.instruction as JsrInstruction
		assertEquals("Must be an JSR instruction", jsrInstruction.instruction,"JSR")
		assertTrue("Must be a direct addressing mode", jsrInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check JSR extended mode 
	 */
	@Test 
	def void testJSRExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       JSR		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JsrInstruction)

		val jsrInstruction = instructionLine.instruction as JsrInstruction
		assertEquals("Must be an JSR instruction", jsrInstruction.instruction,"JSR")
		assertTrue("Must be a extended addressing mode", jsrInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check JSR extended mode 
	 */
	@Test 
	def void testJSRExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       JSR		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JsrInstruction)

		val jsrInstruction = instructionLine.instruction as JsrInstruction
		assertEquals("Must be an JSR instruction", jsrInstruction.instruction,"JSR")
		assertTrue("Must be a extended addressing mode", jsrInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check JSR extended indirect mode 
	 */
	@Test 
	def void testJSRExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       JSR		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JsrInstruction)

		val jsrInstruction = instructionLine.instruction as JsrInstruction
		assertEquals("Must be an JSR instruction", jsrInstruction.instruction,"JSR")
		assertTrue("Must be a extended indirect addressing mode", jsrInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check JSR Constant-Offset Indexed 
	 */
	@Test 
	def void testJSRConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	JSR		  	Const,X
					JSR		  	,X
					JSR		  	$9,U
					JSR		  	$9,S
					JSR		  	$9,X
					JSR		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JsrInstruction)

		val jsrInstruction = instructionLine.instruction as JsrInstruction
		assertEquals("Must be an JSR instruction", jsrInstruction.instruction,"JSR")
		assertTrue("Must be a Constant-Offset Indexed mode", jsrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = jsrInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check JSR Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testJSRConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	JSR		  	[Const,X]
					JSR		  	[,X]
					JSR		  	[$9,U]
					JSR		  	[$9,S]
					JSR		  	[$9,X]
					JSR		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JsrInstruction)

		val jsrInstruction = instructionLine.instruction as JsrInstruction
		assertEquals("Must be an JSR instruction", jsrInstruction.instruction,"JSR")
		assertTrue("Must be a Constant-Offset Indexed mode", jsrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = jsrInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check JSR Accumulator Indexed 
	 */
	@Test 
	def void testJSRAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	JSR		  	A,X
					JSR		  	B,X
					JSR		  	D,U
					JSR		  	A,S
					JSR		  	B,X
					JSR		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JsrInstruction)

		val jsrInstruction = instructionLine.instruction as JsrInstruction
		assertEquals("Must be an JSR instruction", jsrInstruction.instruction,"JSR")
		assertTrue("Must be a Constant-Offset Indexed mode", jsrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = jsrInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check JSR Accumulator Indexed Indirect
	 */
	@Test 
	def void testJSRAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	JSR		  	[A,X]
					JSR		  	[B,X]
					JSR		  	[D,U]
					JSR		  	[A,S]
					JSR		  	[B,X]
					JSR		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JsrInstruction)

		val jsrInstruction = instructionLine.instruction as JsrInstruction
		assertEquals("Must be an JSR instruction", jsrInstruction.instruction,"JSR")
		assertTrue("Must be a Constant-Offset Indexed mode", jsrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = jsrInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check JSR Auto-Jsrrement Indexed 
	 */
	@Test 
	def void testJSRAutoJsrrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	JSR		  	0,--X
			       	JSR		  	0,-X
			       	JSR		  	Const,X+
			       	JSR		  	Const,X++
			       	JSR		  	0,--S
			       	JSR		  	0,-S
			       	JSR		  	Const,U+
			       	JSR		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JsrInstruction)

		val jsrInstruction = instructionLine.instruction as JsrInstruction
		assertEquals("Must be an JSR instruction", jsrInstruction.instruction,"JSR")
		assertTrue("Must be a Constant-Offset Indexed mode", jsrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = jsrInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Jsrrement Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check JSR Auto-Jsrrement Indexed Indirect
	 */
	@Test 
	def void testJSRAutoJsrrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	JSR		  	[0,--X]
			       	JSR		  	[0,-X]
			       	JSR		  	[Const,X+]
			       	JSR		  	[Const,X++]
			       	JSR		  	[0,--S]
			       	JSR		  	[0,-S]
			       	JSR		  	[Const,U+]
			       	JSR		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JsrInstruction)

		val jsrInstruction = instructionLine.instruction as JsrInstruction
		assertEquals("Must be an JSR instruction", jsrInstruction.instruction,"JSR")
		assertTrue("Must be a Constant-Offset Indexed mode", jsrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = jsrInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Jsrrement Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check JSR Relative to PC Indexed 
	 */
	@Test 
	def void testJSRRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	JSR		  	0,PCR
			       	JSR		  	,PCR
			       	JSR		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JsrInstruction)

		val jsrInstruction = instructionLine.instruction as JsrInstruction
		assertEquals("Must be an JSR instruction", jsrInstruction.instruction,"JSR")
		assertTrue("Must be a Constant-Offset Indexed mode", jsrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = jsrInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check JSR Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testJSRRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	JSR		  	[0,PCR]
			       	JSR		  	[,PCR]
			       	JSR		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof JsrInstruction)

		val jsrInstruction = instructionLine.instruction as JsrInstruction
		assertEquals("Must be an JSR instruction", jsrInstruction.instruction,"JSR")
		assertTrue("Must be a Constant-Offset Indexed mode", jsrInstruction.operand instanceof IndexedOperand)
		val indexedOperand = jsrInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}