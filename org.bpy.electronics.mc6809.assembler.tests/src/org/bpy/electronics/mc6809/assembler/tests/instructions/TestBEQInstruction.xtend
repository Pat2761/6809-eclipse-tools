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
import org.bpy.electronics.mc6809.assembler.assembler.BeqInstruction
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledBEQInstruction
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestBEQInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check BEQ
	 */
	@Test 
	def void testSimpleBEQWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump	    ASLA
					ASLB
					BEQ		Jump 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(4)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BEQ directive line", instructionLine.instruction instanceof BeqInstruction)
	}
	
	/**
	 * Check BEQ
	 */
	@Test 
	def void testSimpleBEQWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump	    ASLA
					ASLB
					BEQ		Jump
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(4)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BEQ directive line", instructionLine.instruction instanceof BeqInstruction)
	}

	/**
	 * Check BEQ
	 */
	@Test 
	def void testSimpleBEQWithWithLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump	    ASLA
					ASLB
		MyBanch		BEQ		Jump
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(4)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an BEQ directive line", instructionLine.instruction instanceof BeqInstruction)
	}

	/**
	 * Check BEQ with duplicate label
	 */
	@Test 
	def void testSimpleBEQWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump	    LDA		#25
					NOP
		Jump		BEQ		Jump		; Jump=3FFF
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
	 * Check BEQ with bad label
	 */
	@Test 
	def void testSimpleBEQWithBadLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump1	    LDA		#25
					NOP
		Jump		BEQ		Jump2		; Jump=3FFF
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.beqInstruction,
			InstructionValidator.MISSING_LABEL,
			"Label Jump2 isn't defined"
		)
	
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
	}
	
	/**
	 * Check BEQ negative jump
	 */
	@Test 
	def void testSimpleBEQWithNegativeJump() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump	    LDA		#25
					NOP
		MyBanch		BEQ		Jump		; 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		Assert.assertEquals("Check PC counter", 0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(4) as AssembledBEQInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x27, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)
		Assert.assertEquals("Check operand value", 0xFB, line.operand.get(0))
	}
	
	/**
	 * Check BEQ positive jump
	 */
	@Test 
	def void testSimpleBEQWithPositiveJump() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		MyBanch		BEQ		Jump		; 
					NOP
		Jump		RTS			
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		Assert.assertEquals("Check PC counter", 0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledBEQInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x27, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)
		Assert.assertEquals("Check operand value", 0x01, line.operand.get(0))
	}
	
	/**
	 * Check BEQ positive limit jump
	 */
	@Test 
	def void testSimpleBEQWithPositiveLimitJump1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		MyBanch		BEQ		Jump		; 
					ORG     $8081
		Jump		RTS			
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		Assert.assertEquals("Check PC counter", 0x8082, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledBEQInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x27, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)
		Assert.assertEquals("Check operand value", 0x7F, line.operand.get(0))
	}
	
	/**
	 * Check BEQ positive limit jump
	 */
	@Test 
	def void testSimpleBEQWithPositiveLimitJump2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		MyBanch		BEQ		Jump		; 
					ORG     $8082
		Jump		RTS			
		''')
		Assert.assertNotNull(result)

		result.assertError(
			AssemblerPackage.eINSTANCE.beqInstruction,
			AbstractInstructionAssemblyLine.OVERFLOW_ERROR,
			"Overflow error, you should use long branch"
		)

		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		
		val line = engine.getAssembledLine(2) as AssembledBEQInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x3F, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)
		Assert.assertEquals("Check operand value", 0xFF, line.operand.get(0))
	}
	
	/**
	 * Check BEQ negative limit jump
	 */
	@Test 
	def void testSimpleBEQWithNegativeLimitJump1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
					ORG		$8002
		JUMP		RTS					
					ORG		$8080		;
		VVV			BEQ		JUMP		;		
		''')

		Assert.assertNotNull(result)
		result.assertNoErrors

		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		Assert.assertEquals("Check PC counter", 0x8082, engine.currentPcValue)
		
		val line = engine.getAssembledLine(4) as AssembledBEQInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x27, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)
		Assert.assertEquals("Check operand value", 0x80, line.operand.get(0))
	}
	
	/**
	 * Check BEQ negative limit jump
	 */
	@Test 
	def void testSimpleBEQWithNegativeLimitJump2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
					ORG		$8001
		JUMP		RTS					
					ORG		$8080		;
		VVV			BEQ		JUMP		;		
		''')
		Assert.assertNotNull(result)

		result.assertError(
			AssemblerPackage.eINSTANCE.beqInstruction,
			AbstractInstructionAssemblyLine.OVERFLOW_ERROR,
			"Overflow error, you should use long branch"
		)

		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		Assert.assertEquals("Check PC counter", 0x8082, engine.currentPcValue)
		
		val line = engine.getAssembledLine(4) as AssembledBEQInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x3F, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 1, line.operand.length)
		Assert.assertEquals("Check operand value", 0xFF, line.operand.get(0))
	}
}