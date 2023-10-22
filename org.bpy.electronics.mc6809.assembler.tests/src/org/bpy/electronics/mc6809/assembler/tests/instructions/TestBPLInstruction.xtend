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
import org.bpy.electronics.mc6809.assembler.assembler.BplInstruction

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestBPLInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check BPL
	 */
	@Test 
	def void testSimpleBPLWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump	    ASLA
					ASLB
					BPL		Jump 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(4)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BPL directive line", instructionLine.instruction instanceof BplInstruction)
	}
	
	/**
	 * Check LBPL
	 */
	@Test 
	def void testSimpleLBPLWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     	$8000
		Jump	    ASLA
					ASLB
					LBPL		Jump 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(4)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BPL directive line", instructionLine.instruction instanceof BplInstruction)
	}
	
	/**
	 * Check BPL
	 */
	@Test 
	def void testSimpleBPLWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump	    ASLA
					ASLB
					BPL		Jump
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(4)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BPL directive line", instructionLine.instruction instanceof BplInstruction)
	}
	
	/**
	 * Check LBPL
	 */
	@Test 
	def void testSimpleLBPLWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     	$8000
		Jump	    ASLA
					ASLB
					LBPL		Jump
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(4)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BPL directive line", instructionLine.instruction instanceof BplInstruction)
	}
	/**
	 * Check BPL
	 */
	@Test 
	def void testSimpleBPLWithWithLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump	    ASLA
					ASLB
		MyBanch		BPL		Jump
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(4)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BPL directive line", instructionLine.instruction instanceof BplInstruction)
	}
	
	/**
	 * Check LBPL
	 */
	@Test 
	def void testSimpleLBPLWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     	$8000
		Jump	    ASLA
					ASLB
					LBPL		Jump			; My Branch comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(4)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BPL directive line", instructionLine.instruction instanceof BplInstruction)
	}
}