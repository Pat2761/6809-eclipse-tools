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
import org.bpy.electronics.mc6809.assembler.assembler.CwaiInstruction
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue
import org.bpy.electronics.mc6809.assembler.assembler.ImmediatOperand
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCWAIInstruction
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)
 
class TestCWAIInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check CWAI immediat 
	 */
	@Test 
	def void testCWAIImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       CWAI		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an AND directive line", instructionLine.instruction instanceof CwaiInstruction)

		val cmpInstruction = instructionLine.instruction as CwaiInstruction
		assertEquals("Must be an CWAI instruction", cmpInstruction.instruction,"CWAI")
		assertTrue("Must be an immediate addressing mode", cmpInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check CWAI direct mode 
	 */
	@Test 
	def void testCWAIDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
		Label	   CWAI		  	<124       ; Illegal CWAI
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cwaiInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Direct mode is not valid for the CWAI instruction"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCWAIInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length) 
		Assert.assertEquals("Check opcode value", 0x3F, line.opcode.get(0)) 
		Assert.assertEquals("Check operand length", 0, line.operand.length) 
		Assert.assertEquals("Check label", 'Label', line.label) 
		Assert.assertEquals("Check operand length", "; Illegal CWAI", line.comment) 
	}

	/**
	 * Check CWAI extended mode 
	 */
	@Test 
	def void testCWAIExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
		Label      CWAI		  	$1234         ; Illegal CWAI
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cwaiInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Extended mode is not valid for the CWAI instruction"
		)

		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCWAIInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length) 
		Assert.assertEquals("Check opcode value", 0x3F, line.opcode.get(0)) 
		Assert.assertEquals("Check operand length", 0, line.operand.length) 
		Assert.assertEquals("Check label", 'Label', line.label) 
		Assert.assertEquals("Check operand length", "; Illegal CWAI", line.comment) 
	}

	/**
	 * Check CWAI extended mode 
	 */
	@Test 
	def void testCWAIExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
		Label      CWAI		  	>$1234         ; Illegal CWAI
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cwaiInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Extended mode is not valid for the CWAI instruction"
		)

		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCWAIInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length) 
		Assert.assertEquals("Check opcode value", 0x3F, line.opcode.get(0)) 
		Assert.assertEquals("Check operand length", 0, line.operand.length) 
		Assert.assertEquals("Check label", 'Label', line.label) 
		Assert.assertEquals("Check operand length", "; Illegal CWAI", line.comment) 
	}

	/**
	 * Check CWAI extended indirect mode 
	 */
	@Test 
	def void testCWAIExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
		Label      CWAI		  	[$1234]         ; Illegal CWAI
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cwaiInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the CWAI instruction"
		)

		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCWAIInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length) 
		Assert.assertEquals("Check opcode value", 0x3F, line.opcode.get(0)) 
		Assert.assertEquals("Check operand length", 0, line.operand.length) 
		Assert.assertEquals("Check label", 'Label', line.label) 
		Assert.assertEquals("Check operand length", "; Illegal CWAI", line.comment) 
	}

	/**
	 * Check CWAI Constant-Offset Indexed 
	 */
	@Test 
	def void testCWAIConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
		Label      	CWAI		  	Const,X         ; Illegal CWAI
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cwaiInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the CWAI instruction"
		)

		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCWAIInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length) 
		Assert.assertEquals("Check opcode value", 0x3F, line.opcode.get(0)) 
		Assert.assertEquals("Check operand length", 0, line.operand.length) 
		Assert.assertEquals("Check label", 'Label', line.label) 
		Assert.assertEquals("Check operand length", "; Illegal CWAI", line.comment) 
	}

	/**
	 * Check CWAI Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testCWAIConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
		Label      	CWAI		  	[Const,X]         ; Illegal CWAI
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cwaiInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the CWAI instruction"
		)

		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCWAIInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length) 
		Assert.assertEquals("Check opcode value", 0x3F, line.opcode.get(0)) 
		Assert.assertEquals("Check operand length", 0, line.operand.length) 
		Assert.assertEquals("Check label", 'Label', line.label) 
		Assert.assertEquals("Check operand length", "; Illegal CWAI", line.comment) 
	}

	/**
	 * Check CWAI Accumulator Indexed 
	 */
	@Test 
	def void testCWAIAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
		Label      	CWAI		  	A,X         ; Illegal CWAI
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cwaiInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the CWAI instruction"
		)

		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCWAIInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length) 
		Assert.assertEquals("Check opcode value", 0x3F, line.opcode.get(0)) 
		Assert.assertEquals("Check operand length", 0, line.operand.length) 
		Assert.assertEquals("Check label", 'Label', line.label) 
		Assert.assertEquals("Check operand length", "; Illegal CWAI", line.comment) 
	}

	/**
	 * Check CWAI Accumulator Indexed Indirect
	 */
	@Test 
	def void testCWAIAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
		Label      	CWAI		  	[A,X]         ; Illegal CWAI
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cwaiInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the CWAI instruction"
		)

		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCWAIInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length) 
		Assert.assertEquals("Check opcode value", 0x3F, line.opcode.get(0)) 
		Assert.assertEquals("Check operand length", 0, line.operand.length) 
		Assert.assertEquals("Check label", 'Label', line.label) 
		Assert.assertEquals("Check operand length", "; Illegal CWAI", line.comment) 
	}

	/**
	 * Check CWAI Auto-Increment Indexed 
	 */
	@Test 
	def void testCWAIAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
		Label      	CWAI		  	,--X         ; Illegal CWAI
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cwaiInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the CWAI instruction"
		)

		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCWAIInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length) 
		Assert.assertEquals("Check opcode value", 0x3F, line.opcode.get(0)) 
		Assert.assertEquals("Check operand length", 0, line.operand.length) 
		Assert.assertEquals("Check label", 'Label', line.label) 
		Assert.assertEquals("Check operand length", "; Illegal CWAI", line.comment) 
	}


	/**
	 * Check CWAI Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testCWAIAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
		Label      	CWAI		  	[,--X]         ; Illegal CWAI
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cwaiInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the CWAI instruction"
		)

		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCWAIInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length) 
		Assert.assertEquals("Check opcode value", 0x3F, line.opcode.get(0)) 
		Assert.assertEquals("Check operand length", 0, line.operand.length) 
		Assert.assertEquals("Check label", 'Label', line.label) 
		Assert.assertEquals("Check operand length", "; Illegal CWAI", line.comment) 
	}
	
	/**
	 * Check CWAI Relative to PC Indexed 
	 */
	@Test 
	def void testCWAIRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
		Label      	CWAI		  	0,PC         ; Illegal CWAI
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cwaiInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the CWAI instruction"
		)

		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCWAIInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length) 
		Assert.assertEquals("Check opcode value", 0x3F, line.opcode.get(0)) 
		Assert.assertEquals("Check operand length", 0, line.operand.length) 
		Assert.assertEquals("Check label", 'Label', line.label) 
		Assert.assertEquals("Check operand length", "; Illegal CWAI", line.comment) 
	}
	
	/**
	 * Check CWAI Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testCWAIRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
		Label      	CWAI		  	[0,PC]         ; Illegal CWAI
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cwaiInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Indexed mode is not valid for the CWAI instruction"
		)

		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC counter after instruction", 0x8001, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCWAIInstruction
		Assert.assertEquals("Check opcode length", 1, line.opcode.length) 
		Assert.assertEquals("Check opcode value", 0x3F, line.opcode.get(0)) 
		Assert.assertEquals("Check operand length", 0, line.operand.length) 
		Assert.assertEquals("Check label", 'Label', line.label) 
		Assert.assertEquals("Check operand length", "; Illegal CWAI", line.comment) 
	}
	
	/**
	 * Check CWAI instruction with duplicate label 
	 */
	@Test 
	def void testCWAIWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start		NOP
					NOP    
		Start      	CWAI		  	#Const+2
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.instructionLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"Label Start is already defined"
		)
	}
	
	/**
	 * Check Assembled CWAI immediate instruction  
	 */
	@Test 
	def void testCWAIImmediatInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CWAI		  	#Const+2  ; 8000   3C 07        START:    CWAI
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCWAIInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x3C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x07, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   3C 07        START:    CWAI", line.comment)	
	}
	
	/**
	 * Check Assembled CWAI immediate with limit negative operand  
	 */
	@Test 
	def void testCWAIImmediatInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CWAI		  	#-129
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.cwaiInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -129 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCWAIInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}
	
	/**
	 * Check Assembled CWAI immediate with limit negative operand  
	 */
	@Test 
	def void testCWAIImmediatInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CWAI		  	#-128
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCWAIInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}

	/**
	 * Check Assembled CWAI immediate with positive limit operand  
	 */
	@Test 
	def void testCWAIImmediatInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CWAI		  	#127
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCWAIInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}

	/**
	 * Check Assembled CWAI immediate with positive limit operand  
	 */
	@Test 
	def void testCWAIImmediatInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CWAI		  	#128
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.cwaiInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 128 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCWAIInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}
}