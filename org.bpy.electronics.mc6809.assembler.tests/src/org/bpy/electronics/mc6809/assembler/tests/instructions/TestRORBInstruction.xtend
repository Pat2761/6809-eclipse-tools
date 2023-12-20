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
import org.bpy.electronics.mc6809.assembler.assembler.RorInstruction
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledRORBInstruction

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestRORBInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check RORB with extra space
	 */
	@Test 
	def void testSimpleRORBWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       RORB  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsr Accumulateur line", instructionLine.instruction instanceof RorInstruction)
		val RorInstruction = instructionLine.instruction as RorInstruction
		Assert.assertEquals("Must be an RORB instruction", "RORB", RorInstruction.instruction)
	}
	
	/**
	 * Check RORB with extra space
	 */
	@Test 
	def void testSimpleRORBWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       RORB
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsr Accumulateur line", instructionLine.instruction instanceof RorInstruction)
		val RorInstruction = instructionLine.instruction as RorInstruction
		Assert.assertEquals("Must be an RORB instruction", "RORB", RorInstruction.instruction)
	}
	
	/**
	 * Check RORB with extra space
	 */
	@Test 
	def void testSimpleRORBWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       RORB  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsr Accumulateur line", instructionLine.instruction instanceof RorInstruction)
		val RorInstruction = instructionLine.instruction as RorInstruction
		Assert.assertEquals("Must be an RORB instruction", "RORB", RorInstruction.instruction)
	}
	
	/**
	 * Check RORB with extra space
	 */
	@Test 
	def void testSimpleRORBWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       RORB					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Lsr Accumulateur line", instructionLine.instruction instanceof RorInstruction)
		val RorInstruction = instructionLine.instruction as RorInstruction
		Assert.assertEquals("Must be an RORB instruction", "RORB", RorInstruction.instruction)
	}
	
	/**
	 * Check RORB instruction with duplicate label 
	 */
	@Test 
	def void testRORBWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start		NOP
					NOP    
		Start      	RORB		  	
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.instructionLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"Label Start is already defined"
		)
	}
	
	/**
	 * Check RORB assembly instruction  
	 */
	@Test 
	def void testRORBAssembly() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	RORB		  		    ; 56   RORB
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after instruction", 0x8001, engine.currentPcValue)
		val line = engine.getAssembledLine(2) as AssembledRORBInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check opcode", 0x56, line.opcode.get(0))
		Assert.assertEquals("Check operand length", 0, line.operand.length)
		Assert.assertEquals("Check label", "Start" , line.label)
		Assert.assertEquals("Check comment", "; 56   RORB" , line.comment)
	}
}