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
package org.bpy.electronics.mc6809.assembler.tests.language.instructions

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
import org.bpy.electronics.mc6809.assembler.assembler.BmiInstruction
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLBMIInstruction
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestLBMIInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check LBMI
	 */
	@Test 
	def void testSimpleLBMIWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump	    ASLA
					ASLB
					LBMI		Jump 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(4)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LBMI directive line", instructionLine.instruction instanceof BmiInstruction)
	}
	
	/**
	 * Check LBMI
	 */
	@Test 
	def void testSimpleLBMIWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump	    ASLA
					ASLB
					LBMI		Jump
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(4)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LBMI directive line", instructionLine.instruction instanceof BmiInstruction)
	}

	/**
	 * Check LBMI with duplicate label
	 */
	@Test 
	def void testSimpleLBMIWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump	    LDA		#25
					NOP
		Jump		LBMI		Jump		; Jump=3FFF
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
	 * Check LBMI with bad label
	 */
	@Test 
	def void testSimpleLBMIWithBadLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump1	    LDA		#25
					NOP
		Jump		LBMI		Jump2		; Jump=3FFF
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.bmiInstruction,
			InstructionValidator.MISSING_LABEL,
			"Label Jump2 isn't defined"
		)
	
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
	}

	/**
	 * Check LBMI
	 */
	@Test 
	def void testSimpleLBMIWithWithLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		Jump	    ASLA
					ASLB
		MyBanch		LBMI		Jump
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(4)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LBMI directive line", instructionLine.instruction instanceof BmiInstruction)
	}
	
	/**
	 * Check LBMI negative jump
	 */
	@Test 
	def void testSimpleLBMIWithNegativeJump1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8004
		Jump	    LDA		#25
			        ORG     $8080
		MyBanch		LBMI	Jump		; Jump=1024FF80
		''')
		Assert.assertNotNull(result)
		result.assertWarning(
			AssemblerPackage.eINSTANCE.bmiInstruction,
			AbstractInstructionAssemblyLine.RELATIVE_SHORT_BRANCH,
			"You can use a short branch"
		)
		
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		Assert.assertEquals("Check PC counter", 0x8084, engine.currentPcValue)
		
		val line = engine.getAssembledLine(4) as AssembledLBMIInstruction
		Assert.assertEquals("Check opcode length", 2, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x10, line.opcode.get(0))
		Assert.assertEquals("Check opcode value", 0x2B, line.opcode.get(1))
		Assert.assertEquals("Check operand length", 2, line.operand.length)
		Assert.assertEquals("Check operand value", 0xFF, line.operand.get(0))
		Assert.assertEquals("Check operand value", 0x80, line.operand.get(1))
	}
	
	/**
	 * Check LBMI negative jump
	 */
	@Test 
	def void testSimpleLBMIWithNegativeJump2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8003
		Jump	    LDA		#25
			        ORG     $8080
		MyBanch		LBMI	Jump		; Jump=1024FF7F
		''')
		Assert.assertNotNull(result)
		result.assertNoIssues
		
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		Assert.assertEquals("Check PC counter", 0x8084, engine.currentPcValue)
		
		val line = engine.getAssembledLine(4) as AssembledLBMIInstruction
		Assert.assertEquals("Check opcode length", 2, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x10, line.opcode.get(0))
		Assert.assertEquals("Check opcode value", 0x2B, line.opcode.get(1))
		Assert.assertEquals("Check operand length", 2, line.operand.length)
		Assert.assertEquals("Check operand value", 0xFF, line.operand.get(0))
		Assert.assertEquals("Check operand value", 0x7F, line.operand.get(1))
	}
	
	/**
	 * Check LBMI positive jump
	 */
	@Test 
	def void testSimpleLBMIWithPositiveJump1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		MyBanch		LBMI		Jump		; Jump=1024007F
					ORG		$8083
		Jump		RTS			
		''')
		Assert.assertNotNull(result)
		result.assertWarning(
			AssemblerPackage.eINSTANCE.bmiInstruction,
			AbstractInstructionAssemblyLine.RELATIVE_SHORT_BRANCH,
			"You can use a short branch"
		)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		Assert.assertEquals("Check PC counter", 0x8084, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLBMIInstruction
		Assert.assertEquals("Check opcode length", 2, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x10, line.opcode.get(0))
		Assert.assertEquals("Check opcode value", 0x2B, line.opcode.get(1))
		Assert.assertEquals("Check operand length", 2, line.operand.length)
		Assert.assertEquals("Check operand value", 0x00, line.operand.get(0))
		Assert.assertEquals("Check operand value", 0x7F, line.operand.get(1))
	}
	
	/**
	 * Check LBMI positive jump
	 */
	@Test 
	def void testSimpleLBMIWithPositiveJump2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $8000
		MyBanch		LBMI		Jump		; Jump=10240080
					ORG		$8084
		Jump		RTS			
		''')
		Assert.assertNotNull(result)
		result.assertNoIssues
		
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		Assert.assertEquals("Check PC counter", 0x8085, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLBMIInstruction
		Assert.assertEquals("Check opcode length", 2, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x10, line.opcode.get(0))
		Assert.assertEquals("Check opcode value", 0x2B, line.opcode.get(1))
		Assert.assertEquals("Check operand length", 2, line.operand.length)
		Assert.assertEquals("Check operand value", 0x00, line.operand.get(0))
		Assert.assertEquals("Check operand value", 0x80, line.operand.get(1))
	}
	
	/**
	 * Check LBMI positive limit jump
	 */
	@Test 
	def void testSimpleLBMIWithPositiveLimitJump1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $0000
		MyBranch	LBMI		Jump		; Jump=10257FFF
					ORG     $8003
		Jump		RTS			
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		Assert.assertEquals("Check PC counter", 0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLBMIInstruction
		Assert.assertEquals("Check opcode length", 2, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x10, line.opcode.get(0))
		Assert.assertEquals("Check opcode value", 0x2B, line.opcode.get(1))
		Assert.assertEquals("Check operand length", 2, line.operand.length)
		Assert.assertEquals("Check operand value", 0x7F, line.operand.get(0))
		Assert.assertEquals("Check operand value", 0xFF, line.operand.get(1))
		Assert.assertEquals("Check label", "MyBranch", line.label)
		Assert.assertEquals("Check comment", "; Jump=10257FFF", line.comment)
	}
	
	/**
	 * Check LBMI positive limit jump
	 */
	@Test 
	def void testSimpleLBMIWithPositiveLimitJump2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			        ORG     $0000
		MyBanch		LBMI	Jump		; Jump=10248000
					ORG     $8004
		Jump		RTS			
		''')
		Assert.assertNotNull(result)

		result.assertNoErrors

		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		
		val line = engine.getAssembledLine(2) as AssembledLBMIInstruction
		Assert.assertEquals("Check opcode length", 2, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x10, line.opcode.get(0))
		Assert.assertEquals("Check opcode value", 0x2B, line.opcode.get(1))
		Assert.assertEquals("Check operand length", 2, line.operand.length)
		Assert.assertEquals("Check operand value", 0x80, line.operand.get(0))
		Assert.assertEquals("Check operand value", 0x00, line.operand.get(1))
	}
	
	/**
	 * Check LBMI negative limit jump
	 */
	@Test 
	def void testSimpleLBMIWithNegativeLimitJump1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
					ORG		$0004
		JUMP		RTS					
					ORG		$8000		;
		VVV			LBMI		JUMP		;		
		''')

		Assert.assertNotNull(result)
		result.assertNoErrors

		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		Assert.assertEquals("Check PC counter", 0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(4) as AssembledLBMIInstruction
		Assert.assertEquals("Check opcode length", 2, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x10, line.opcode.get(0))
		Assert.assertEquals("Check opcode value", 0x2B, line.opcode.get(1))
		Assert.assertEquals("Check operand length", 2, line.operand.length)
		Assert.assertEquals("Check operand value", 0x80, line.operand.get(0))
		Assert.assertEquals("Check operand value", 0x00, line.operand.get(1))
	}
	
	/**
	 * Check LBMI negative limit jump
	 */
	@Test 
	def void testSimpleLBMIWithNegativeLimitJump2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
					ORG		$0003
		JUMP		RTS					
					ORG		$8000		;
		VVV			LBMI		JUMP		;		
		''')
		Assert.assertNotNull(result)

		result.assertNoErrors

		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val engine=AssemblerEngine.instance
		Assert.assertEquals("Check PC counter", 0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(4) as AssembledLBMIInstruction
		Assert.assertEquals("Check opcode length", 2, line.opcode.length)
		Assert.assertEquals("Check opcode value", 0x10, line.opcode.get(0))
		Assert.assertEquals("Check opcode value", 0x2B, line.opcode.get(1))
		Assert.assertEquals("Check operand length", 2, line.operand.length)
		Assert.assertEquals("Check operand value", 0x7F, line.operand.get(0))
		Assert.assertEquals("Check operand value", 0xFF, line.operand.get(1))
	}
}