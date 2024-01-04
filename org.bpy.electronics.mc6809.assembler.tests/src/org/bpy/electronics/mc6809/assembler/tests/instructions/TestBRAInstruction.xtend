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
import org.bpy.electronics.mc6809.assembler.assembler.BraInstruction
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledBRAInstruction
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestBRAInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check BRA
	 */
	@Test 
	def void testSimpleBRAWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump	    ASLA
					ASLB
					BRA		Jump 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(4)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BRA directive line", instructionLine.instruction instanceof BraInstruction)
	}
	
	/**
	 * Check BRA
	 */
	@Test 
	def void testSimpleBRAWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump	    ASLA
					ASLB
					BRA		Jump
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(4)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BRA directive line", instructionLine.instruction instanceof BraInstruction)
	}

	/**
	 * Check BRA
	 */
	@Test 
	def void testSimpleBRAWithWithLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump	    ASLA
					ASLB
		MyBanch		BRA		Jump
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(4)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BRA directive line", instructionLine.instruction instanceof BraInstruction)
	}

	/**
	 * Check BRA with duplicate label
	 */
	@Test 
	def void testSimpleBRAWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump	    LDA		#25
					NOP
		Jump		BRA		Jump		; Jump=3FFF
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.instructionLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"Label Jump is already defined"
		)
	
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
	}

	/**
	 * Check BRA with bad label
	 */
	@Test 
	def void testSimpleBRAWithBadLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump1	    LDA		#25
					NOP
		Jump		BRA		Jump2		; Jump=3FFF
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.braInstruction,
			InstructionValidator.MISSING_LABEL,
			"Label Jump2 isn't defined"
		)
	
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
	}
	
	/**
	 * Check BRA negative jump
	 */
	@Test 
	def void testSimpleBRAWithNegativeJump() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump	    LDA		#25
					NOP
		MyBanch		BRA		Jump		; 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		Assert.assertEquals("Check PC counter", 0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(4) as AssembledBRAInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x20, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)
		Assert.assertEquals("Check operand value", 0xFB, line.operand.get(0))
	}
	
	/**
	 * Check BRA positive jump
	 */
	@Test 
	def void testSimpleBRAWithPositiveJump() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		MyBanch		BRA		Jump		; 
					NOP
		Jump		RTS			
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		Assert.assertEquals("Check PC counter", 0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledBRAInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x20, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)
		Assert.assertEquals("Check operand value", 0x01, line.operand.get(0))
	}
	
	/**
	 * Check BRA positive limit jump
	 */
	@Test 
	def void testSimpleBRAWithPositiveLimitJump1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		MyBanch		BRA		Jump		; 
					ORG     $8081
		Jump		RTS			
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		Assert.assertEquals("Check PC counter", 0x8082, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledBRAInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x20, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)
		Assert.assertEquals("Check operand value", 0x7F, line.operand.get(0))
	}
	
	/**
	 * Check BRA positive limit jump
	 */
	@Test 
	def void testSimpleBRAWithPositiveLimitJump2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		MyBanch		BRA		Jump		; 
					ORG     $8082
		Jump		RTS			
		''')
		Assert.assertNotNull(result)

		result.assertError(
			AssemblerPackage.eINSTANCE.braInstruction,
			AbstractInstructionAssemblyLine.OVERFLOW_ERROR,
			"Overflow error, you should use long branch"
		)

		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		
		val line = engine.getAssembledLine(2) as AssembledBRAInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x3F, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)
		Assert.assertEquals("Check operand value", 0xFF, line.operand.get(0))
	}
	
	/**
	 * Check BRA negative limit jump
	 */
	@Test 
	def void testSimpleBRAWithNegativeLimitJump1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
					ORG		$8002
		JUMP		RTS					
					ORG		$8080		;
		VVV			BRA		JUMP		;		
		''')

		Assert.assertNotNull(result)
		result.assertNoErrors

		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		Assert.assertEquals("Check PC counter", 0x8082, engine.currentPcValue)
		
		val line = engine.getAssembledLine(4) as AssembledBRAInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x20, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)
		Assert.assertEquals("Check operand value", 0x80, line.operand.get(0))
	}
	
	/**
	 * Check BRA negative limit jump
	 */
	@Test 
	def void testSimpleBRAWithNegativeLimitJump2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
					ORG		$8001
		JUMP		RTS					
					ORG		$8080		;
		VVV			BRA		JUMP		;		
		''')
		Assert.assertNotNull(result)

		result.assertError(
			AssemblerPackage.eINSTANCE.braInstruction,
			AbstractInstructionAssemblyLine.OVERFLOW_ERROR,
			"Overflow error, you should use long branch"
		)

		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		Assert.assertEquals("Check PC counter", 0x8082, engine.currentPcValue)
		
		val line = engine.getAssembledLine(4) as AssembledBRAInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x3F, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)
		Assert.assertEquals("Check operand value", 0xFF, line.operand.get(0))
	}
}