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
import org.bpy.electronics.mc6809.assembler.assembler.ImmediatOperand
import org.bpy.electronics.mc6809.assembler.assembler.AndCCInstruction
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledANDCCInstruction
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestANDCCInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check ADDA immediat 
	 */
	@Test 
	def void testANDCCImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ANDCC		#25
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ANDCC instruction line", instructionLine.instruction instanceof AndCCInstruction)

		val andCCInstruction = instructionLine.instruction as AndCCInstruction
		assertEquals("Must be an ADDA instruction", andCCInstruction.instruction,"ANDCC")
		assertTrue("Must be an immediate addressing mode", andCCInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check ANDCC direct mode 
	 */
	@Test 
	def void testANDCCDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG  	  		$8000
		Label	       ANDCC		  	<124 ; SWI instruction
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.andCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Direct mode is not valid for the ANDCC instruction"
		)
		
		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(2) as AssembledANDCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertEquals("Check label", "Label", line.label)
		Assert.assertEquals("Check comment", "; SWI instruction", line.comment)
	}
	
	/**
	 * Check ANDCC extended indirect mode 
	 */
	@Test 
	def void testANDCCExtendedAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG  	  		$8000
			       ANDCC		  	[124]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.andCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Extended mode is not valid for the ANDCC instruction"
		)

		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(2) as AssembledANDCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertNull("Check label", line.label)
		Assert.assertNull("Check comment", line.comment)
	}

	/**
	 * Check ANDCC Constant-Offset Indexed 
	 */
	@Test 
	def void testANDCCConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDCC		  	Const,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.andCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the ANDCC instruction"
		)

		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(3) as AssembledANDCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertNull("Check label", line.label)
		Assert.assertNull("Check comment", line.comment)
	}

	/**
	 * Check ANDCC Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testANDCCConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDCC		  	[Const,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.andCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the ANDCC instruction"
		)

		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(3) as AssembledANDCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertNull("Check label", line.label)
		Assert.assertNull("Check comment", line.comment)
	}

	/**
	 * Check ANDCC Accumulator Indexed 
	 */
	@Test 
	def void testANDCCAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDCC		  	A,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.andCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the ANDCC instruction"
		)

		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(3) as AssembledANDCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertNull("Check label", line.label)
		Assert.assertNull("Check comment", line.comment)
	}

	/**
	 * Check ANDCC Accumulator Indexed Indirect
	 */
	@Test 
	def void testANDCCAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDCC		  	[A,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.andCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the ANDCC instruction"
		)

		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(3) as AssembledANDCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertNull("Check label", line.label)
		Assert.assertNull("Check comment", line.comment)
	}

	/**
	 * Check ANDCC Auto increment Indexed 
	 */
	@Test 
	def void testANDCCAutoINcrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDCC		  	,X++
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.andCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the ANDCC instruction"
		)

		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(3) as AssembledANDCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertNull("Check label", line.label)
		Assert.assertNull("Check comment", line.comment)
	}

	/**
	 * Check ANDCC Auto increment Indexed Indirect
	 */
	@Test 
	def void testANDCCAutoINcrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDCC		  	[,X++]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.andCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the ANDCC instruction"
		)

		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(3) as AssembledANDCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertNull("Check label", line.label)
		Assert.assertNull("Check comment", line.comment)
	}

	/**
	 * Check ANDCC Relative to PC Indexed 
	 */
	@Test 
	def void testANDCCRelativeToPCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDCC		  	Const,PC
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.andCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the ANDCC instruction"
		)

		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(3) as AssembledANDCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertNull("Check label", line.label)
		Assert.assertNull("Check comment", line.comment)
	}

	/**
	 * Check ANDCC Relative to PC Indexed Indirect
	 */
	@Test 
	def void testANDCCRelativeToPCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDCC		  	[Const,PC]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.andCCInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the ANDCC instruction"
		)

		val engine = AssemblerEngine.instance;
		val line = engine.getAssembledLine(3) as AssembledANDCCInstruction
		Assert.assertEquals("Check size instruction", 0x1, line.opcode.length)
		Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.opcode.get(0))
		Assert.assertNull("Check label", line.label)
		Assert.assertNull("Check comment", line.comment)
	}
	
	/**
	 * Check ANDCC instruction with duplicate label 
	 */
	@Test 
	def void testANDCCWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start		NOP
					NOP    
		Start      	ANDA		  	#Const+2
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.instructionLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"Label Start is already defined"
		)
	}
	
	/**
	 * Check Assembled ANDCC immediate instruction  
	 */
	@Test 
	def void testANDCCImmediatInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ANDCC		  	#Const+2  ; 8000   1C 07        START:    ANDCC
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledANDCCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x1C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x07, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   1C 07        START:    ANDCC", line.comment)	
	}
	
	/**
	 * Check Assembled ANDCC immediate with limit negative operand  
	 */
	@Test 
	def void testANDCCImmediatInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ANDCC		  	#-129
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.andCCInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -129 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledANDCCInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}
	
	/**
	 * Check Assembled ANDCC immediate with limit negative operand  
	 */
	@Test 
	def void testANDCCImmediatInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ANDCC		  	#-128
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledANDCCInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}

	/**
	 * Check Assembled ANDCC immediate with positive limit operand  
	 */
	@Test 
	def void testANDCCImmediatInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ANDCC		  	#127
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledANDCCInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}

	/**
	 * Check Assembled ANDCC immediate with positive limit operand  
	 */
	@Test 
	def void testANDCCImmediatInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ANDCC		  	#128
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.andCCInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 128 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledANDCCInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}
}