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
import org.bpy.electronics.mc6809.assembler.assembler.NegInstruction
import org.bpy.electronics.mc6809.assembler.assembler.DirectOperand
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedOperand

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestNegInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check NEGA with extra space
	 */
	@Test 
	def void testSimpleNEGAWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       NEGA  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Neg Accumulateur line", instructionLine.instruction instanceof NegInstruction)
		val negInstruction = instructionLine.instruction as NegInstruction
		Assert.assertEquals("Must be an NEGA instruction", "NEGA", negInstruction.instruction)
	}
	
	/**
	 * Check NEGA with extra space
	 */
	@Test 
	def void testSimpleNEGAWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       NEGA
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Neg Accumulateur line", instructionLine.instruction instanceof NegInstruction)
		val negInstruction = instructionLine.instruction as NegInstruction
		Assert.assertEquals("Must be an NEGA instruction", "NEGA", negInstruction.instruction)
	}
	
	/**
	 * Check NEGA with extra space
	 */
	@Test 
	def void testSimpleNEGAWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       NEGA  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Neg Accumulateur line", instructionLine.instruction instanceof NegInstruction)
		val negInstruction = instructionLine.instruction as NegInstruction
		Assert.assertEquals("Must be an NEGA instruction", "NEGA", negInstruction.instruction)
	}
	
	/**
	 * Check NEGA with extra space
	 */
	@Test 
	def void testSimpleNEGAWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       NEGA					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Neg Accumulateur line", instructionLine.instruction instanceof NegInstruction)
		val negInstruction = instructionLine.instruction as NegInstruction
		Assert.assertEquals("Must be an NEGA instruction", "NEGA", negInstruction.instruction)
	}
	
	/**
	 * Check NEGB with extra space
	 */
	@Test 
	def void testSimpleNEGBWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       NEGB  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Neg Accumulateur line", instructionLine.instruction instanceof NegInstruction)
		val negInstruction = instructionLine.instruction as NegInstruction
		Assert.assertEquals("Must be an NEGB instruction", "NEGB", negInstruction.instruction)
	}
	
	/**
	 * Check NEGB with extra space
	 */
	@Test 
	def void testSimpleNEGBWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       NEGB
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Neg Accumulateur line", instructionLine.instruction instanceof NegInstruction)
		val negInstruction = instructionLine.instruction as NegInstruction
		Assert.assertEquals("Must be an NEGB instruction", "NEGB", negInstruction.instruction)
	}
	
	/**
	 * Check NEGB with extra space
	 */
	@Test 
	def void testSimpleNEGBWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       NEGB  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Neg Accumulateur line", instructionLine.instruction instanceof NegInstruction)
		val negInstruction = instructionLine.instruction as NegInstruction
		Assert.assertEquals("Must be an NEGB instruction", "NEGB", negInstruction.instruction)
	}
	
	/**
	 * Check NEGB with extra space
	 */
	@Test 
	def void testSimpleNEGBWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       NEGB					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Neg Accumulateur line", instructionLine.instruction instanceof NegInstruction)
		val negInstruction = instructionLine.instruction as NegInstruction
		Assert.assertEquals("Must be an NEGB instruction", "NEGB", negInstruction.instruction)
	}
	
		/**
	 * Check NEG direct mode 
	 */
	@Test 
	def void testNEGDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       NEG		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof NegInstruction)

		val NegInstruction = instructionLine.instruction as NegInstruction
		assertEquals("Must be an NEG instruction", NegInstruction.instruction,"NEG")
		assertTrue("Must be a direct addressing mode", NegInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check NEG extended mode 
	 */
	@Test 
	def void testNEGExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       NEG		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof NegInstruction)

		val NegInstruction = instructionLine.instruction as NegInstruction
		assertEquals("Must be an NEG instruction", NegInstruction.instruction,"NEG")
		assertTrue("Must be a extended addressing mode", NegInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check NEG extended mode 
	 */
	@Test 
	def void testNEGExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       NEG		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof NegInstruction)

		val NegInstruction = instructionLine.instruction as NegInstruction
		assertEquals("Must be an NEG instruction", NegInstruction.instruction,"NEG")
		assertTrue("Must be a extended addressing mode", NegInstruction.operand instanceof ExtendedOperand)
	}

}