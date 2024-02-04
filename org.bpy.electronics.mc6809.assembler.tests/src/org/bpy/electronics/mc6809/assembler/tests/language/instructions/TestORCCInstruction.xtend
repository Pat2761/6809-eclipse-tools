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
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue
import org.bpy.electronics.mc6809.assembler.assembler.ImmediatOperand
import org.bpy.electronics.mc6809.assembler.assembler.OrCCInstruction
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledORCCInstruction
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestORCCInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check ORCC immediat 
	 */
	@Test 
	def void testORCCImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ORCC		#25
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ORCC instruction line", instructionLine.instruction instanceof OrCCInstruction)

		val orCCInstruction = instructionLine.instruction as OrCCInstruction
		assertEquals("Must be an ORCC instruction", orCCInstruction.instruction,"ORCC")
		assertTrue("Must be an immediate addressing mode", orCCInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check ORCC direct mode 
	 */
	@Test 
	def void testORCCDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG  	  		$8000
		Label	       ORCC		  	<124 ; SWI instruction
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.orCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Direct mode is not valid for the ORCC instruction"
		)
		
		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(2) as AssembledORCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertEquals("Check label", "Label", line.label)
		Assert.assertEquals("Check comment", "; SWI instruction", line.comment)
	}
	
	/**
	 * Check ORCC extended indirect mode 
	 */
	@Test 
	def void testORCCExtendedAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG  	  		$8000
			       ORCC		  	[124]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.orCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Extended mode is not valid for the ORCC instruction"
		)

		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(2) as AssembledORCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertNull("Check label", line.label)
		Assert.assertNull("Check comment", line.comment)
	}

	/**
	 * Check ORCC Constant-Offset Indexed 
	 */
	@Test 
	def void testORCCConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORCC		  	Const,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.orCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the ORCC instruction"
		)

		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(3) as AssembledORCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertNull("Check label", line.label)
		Assert.assertNull("Check comment", line.comment)
	}

	/**
	 * Check ORCC Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testORCCConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORCC		  	[Const,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.orCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the ORCC instruction"
		)

		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(3) as AssembledORCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertNull("Check label", line.label)
		Assert.assertNull("Check comment", line.comment)
	}

	/**
	 * Check ORCC Accumulator Indexed 
	 */
	@Test 
	def void testORCCAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORCC		  	A,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.orCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the ORCC instruction"
		)

		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(3) as AssembledORCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertNull("Check label", line.label)
		Assert.assertNull("Check comment", line.comment)
	}

	/**
	 * Check ORCC Accumulator Indexed Indirect
	 */
	@Test 
	def void testORCCAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORCC		  	[A,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.orCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the ORCC instruction"
		)

		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(3) as AssembledORCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertNull("Check label", line.label)
		Assert.assertNull("Check comment", line.comment)
	}

	/**
	 * Check ORCC Auto increment Indexed 
	 */
	@Test 
	def void testORCCAutoINcrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORCC		  	,X++
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.orCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the ORCC instruction"
		)

		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(3) as AssembledORCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertNull("Check label", line.label)
		Assert.assertNull("Check comment", line.comment)
	}

	/**
	 * Check ORCC Auto increment Indexed Indirect
	 */
	@Test 
	def void testORCCAutoINcrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORCC		  	[,X++]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.orCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the ORCC instruction"
		)

		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(3) as AssembledORCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertNull("Check label", line.label)
		Assert.assertNull("Check comment", line.comment)
	}

	/**
	 * Check ORCC Relative to PC Indexed 
	 */
	@Test 
	def void testORCCRelativeToPCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORCC		  	Const,PC
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.orCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the ORCC instruction"
		)

		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(3) as AssembledORCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertNull("Check label", line.label)
		Assert.assertNull("Check comment", line.comment)
	}

	/**
	 * Check ORCC Relative to PC Indexed Indirect
	 */
	@Test 
	def void testORCCRelativeToPCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ORCC		  	[Const,PC]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.orCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the ORCC instruction"
		)

		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(3) as AssembledORCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertNull("Check label", line.label)
		Assert.assertNull("Check comment", line.comment)
	}
	
	/**
	 * Check ORCC instruction with duplicate label 
	 */
	@Test 
	def void testORCCWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start		NOP
					NOP    
		Start      	ORCC		  	#Const+2
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.instructionLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"Label Start is already defined"
		)
	}
	
	/**
	 * Check Assembled ORCC immediate instruction  
	 */
	@Test 
	def void testORCCImmediatInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ORCC		  	#Const+2  ; 8000   1A 07        START:    ORCC
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledORCCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x1A, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x07, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   1A 07        START:    ORCC", line.comment)	
	}
	
	/**
	 * Check Assembled ORCC immediate with limit negative operand  
	 */
	@Test 
	def void testORCCImmediatInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ORCC		  	#-129
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.orCCInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -129 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledORCCInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}
	
	/**
	 * Check Assembled ORCC immediate with limit negative operand  
	 */
	@Test 
	def void testORCCImmediatInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ORCC		  	#-128
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledORCCInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}

	/**
	 * Check Assembled ORCC immediate with positive limit operand  
	 */
	@Test 
	def void testORCCImmediatInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ORCC		  	#127
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledORCCInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}

	/**
	 * Check Assembled ORCC immediate with positive limit operand  
	 */
	@Test 
	def void testORCCImmediatInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ORCC		  	#128
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.orCCInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 128 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledORCCInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}
}