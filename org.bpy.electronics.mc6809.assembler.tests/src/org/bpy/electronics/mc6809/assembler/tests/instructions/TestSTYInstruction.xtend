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
import org.bpy.electronics.mc6809.assembler.assembler.StInstruction
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue
import org.bpy.electronics.mc6809.assembler.assembler.DirectOperand
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedOperand
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedIndirectOperand
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMode
import org.bpy.electronics.mc6809.assembler.assembler.IndexedOperand
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingMode
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecMode
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCMode
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecIndirectMode
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingIndirectMode
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCIndirectMode
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledSTYInstruction
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestSTYInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check STY direct mode 
	 */
	@Test 
	def void testSTYDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STY		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STY directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STY instruction", instruction.instruction,"STY")
		assertTrue("Must be a direct addressing mode", instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check STY extended mode 
	 */
	@Test 
	def void testSTYExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STY		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STY directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STY instruction", instruction.instruction,"STY")
		assertTrue("Must be a extended addressing mode", instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check STY extended mode 
	 */
	@Test 
	def void testSTYExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STY		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STY directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STY instruction", instruction.instruction,"STY")
		assertTrue("Must be a extended addressing mode", instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check STY extended indirect mode 
	 */
	@Test 
	def void testSTYExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STY		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STY directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STY instruction", instruction.instruction,"STY")
		assertTrue("Must be a extended indirect addressing mode", instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check STY Constant-Offset Indexed 
	 */
	@Test 
	def void testSTYConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STY		  	Const,X
					STY		  	,X
					STY		  	$9,U
					STY		  	$9,S
					STY		  	$9,X
					STY		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STY directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STY instruction", instruction.instruction,"STY")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check STY Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testSTYConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STY		  	[Const,X]
					STY		  	[,X]
					STY		  	[$9,U]
					STY		  	[$9,S]
					STY		  	[$9,X]
					STY		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STY directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STY instruction", instruction.instruction,"STY")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check STY Accumulator Indexed 
	 */
	@Test 
	def void testSTYAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STY		  	A,X
					STY		  	B,X
					STY		  	D,U
					STY		  	A,S
					STY		  	B,X
					STY		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STY directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STY instruction", instruction.instruction,"STY")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check STY Accumulator Indexed Indirect
	 */
	@Test 
	def void testSTYAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STY		  	[A,X]
					STY		  	[B,X]
					STY		  	[D,U]
					STY		  	[A,S]
					STY		  	[B,X]
					STY		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STY directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STY instruction", instruction.instruction,"STY")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check STY Auto-Increment Indexed 
	 */
	@Test 
	def void testSTYAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STY		  	,--X
			       	STY		  	,-X
			       	STY		  	,X+
			       	STY		  	,X++
			       	STY		  	,--S
			       	STY		  	,-S
			       	STY		  	,U+
			       	STY		  	,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STY directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STY instruction", instruction.instruction,"STY")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check STY Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testSTYAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STY		  	[,--X]
			       	STY		  	[,X++]
			       	STY		  	[,--S]
			       	STY		  	[,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STY directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STY instruction", instruction.instruction,"STY")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check STY Relative to PC Indexed 
	 */
	@Test 
	def void testSTYRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STY		  	0,PC
			       	STY		  	,PC
			       	STY		  	Const,PC
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STY directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STY instruction", instruction.instruction,"STY")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check STY Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testSTYRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STY		  	[0,PC]
			       	STY		  	[,PC]
			       	STY		  	[Const,PC]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STY directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STY instruction", instruction.instruction,"STY")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
	
	/**
	 * Check STY instruction with duplicate label 
	 */
	@Test 
	def void testSTYWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start		NOP
					NOP    
		Start      	STY		  	$123
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.instructionLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"Label Start is already defined"
		)
	}
	
	/**
	 * Check Assembled STY immediate instruction  
	 */
	@Test 
	def void testSTYImmediatInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	#Const+2  ; Illegal
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Immediate mode is not valid for the STY instruction"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8001, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x3F, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 0, line.operand.length);	
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; Illegal", line.comment)	
	}
	
	/**
	 * Check Assembled STY direct mode instruction  
	 */
	@Test 
	def void testSTYDirectInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	<Const*2  ; 8000   10 9F 0A        START:    STY   <Const*2 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0x9F, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x0A, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   10 9F 0A        START:    STY   <Const*2 ", line.comment)	
	}
	
	/**
	 * Check Assembled STY direct with limit negative operand  
	 */
	@Test 
	def void testSTYDirectInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	<-129
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.stInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -129 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}
	
	/**
	 * Check Assembled STY direct with limit negative operand  
	 */
	@Test 
	def void testSTYDirectInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	<-128
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}

	/**
	 * Check Assembled STY direct with positive limit operand  
	 */
	@Test 
	def void testSTYDirectInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	<127
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}

	/**
	 * Check Assembled STY direct with positive limit operand  
	 */
	@Test 
	def void testSTYDirectInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	<128
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.stInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 128 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}
	
	/**
	 * Check Assembled STY extended mode instruction  
	 */
	@Test 
	def void testSTYExtendedInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	>Const*1000  ; 8000   10 BF 13 88     START:    STY   >Const*1000 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xBF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   10 BF 13 88     START:    STY   >Const*1000 ", line.comment)	
	}
	
	/**
	 * Check Assembled STY extended with limit negative operand  
	 */
	@Test 
	def void testSTYExtendedInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	>-32769
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.stInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}
	
	/**
	 * Check Assembled STY extended with limit negative operand  
	 */
	@Test 
	def void testSTYExtendedInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	>-32768
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}

	/**
	 * Check Assembled STY extended with positive limit operand  
	 */
	@Test 
	def void testSTYExtendedInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	>65535
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}

	/**
	 * Check Assembled STY extended with positive limit operand  
	 */
	@Test 
	def void testSTYExtendedInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	>65536
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.stInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 65536 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}
	
	/**
	 * Check Assembled STY extended indirect mode instruction  
	 */
	@Test 
	def void testSTYExtendedIndirectInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[Const*1000]  ; 8000   AB 9F 13 88  START:    STY   [Const*1000]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 3, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check opcode", 0x9F, line.opcode.get(2));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 9F 13 88  START:    STY   [Const*1000]", line.comment)	
	}
	
	/**
	 * Check Assembled STY extended indirect with limit negative operand  
	 */
	@Test 
	def void testSTYExtendedIndirectInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-32769]
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.stInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}
	
	/**
	 * Check Assembled STY extended indirect with limit negative operand  
	 */
	@Test 
	def void testSTYExtendedIndirectInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-32768]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}

	/**
	 * Check Assembled STY extended indirect with positive limit operand  
	 */
	@Test 
	def void testSTYExtendedIndirectInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[65535]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}

	/**
	 * Check Assembled STY extended indirect with positive limit operand  
	 */
	@Test 
	def void testSTYExtendedIndirectInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[65536]
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.stInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 65536 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}
	
	/**
	 * Check Assembled STY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAccumulatorMovingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	A,X  ; 8000   10 A3 86        START:    STY   A,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x86, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   10 A3 86        START:    STY   A,X", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAccumulatorMovingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	A,Y  ; 8000   	10 AF A6        START:    STY   A,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF A6        START:    STY   A,Y", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAccumulatorMovingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	A,U  ; 8000   	10 AF C6        START:    STY   A,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF C6        START:    STY   A,U", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAccumulatorMovingMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	A,S  ; 8000   	10 AF E6        START:    STY   A,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF E6        START:    STY   A,S", line.comment)	
	}
	
	/**
	 * Check Assembled STY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAccumulatorMovingMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	B,X  ; 8000   AB 85        START:    STY   B,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x85, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 85        START:    STY   B,X", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAccumulatorMovingMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	B,Y  ; 8000   	10 AF A5        START:    STY   B,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF A5        START:    STY   B,Y", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAccumulatorMovingMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	B,U  ; 8000   	10 AF C5        START:    STY   B,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF C5        START:    STY   B,U", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAccumulatorMovingMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	B,S  ; 8000   	10 AF E5        START:    STY   B,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF E5        START:    STY   B,S", line.comment)	
	}
	
	/**
	 * Check Assembled STY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAccumulatorMovingMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	D,X  ; 8000   AB 8B        START:    STY   D,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8B, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    STY   D,X", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAccumulatorMovingMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	D,Y  ; 8000   	10 AF AB        START:    STY   D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xAB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF AB        START:    STY   D,Y", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAccumulatorMovingMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	D,U  ; 8000   	10 AF CB        START:    STY   D,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xCB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF CB        START:    STY   D,U", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAccumulatorMovingMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	D,S  ; 8000   	10 AF EB        START:    STY   D,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xEB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF EB        START:    STY   D,S", line.comment)	
	}
	
	/**
	 * Check Assembled STY Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedIndorectAccumulatorMovingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[A,X]  ; 8000   AB 96        START:    STY   [A,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x96, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 96        START:    STY   [A,X]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedIndirectAccumulatorMovingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[A,Y]  ; 8000   	10 AF B6        START:    STY   [A,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF B6        START:    STY   [A,Y]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedIndirectAccumulatorMovingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[A,U]  ; 8000   	10 AF D6        START:    STY   [A,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF D6        START:    STY   [A,U]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedIndirectAccumulatorMovingMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[A,S]  ; 8000   	10 AF F6        START:    STY   [A,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF F6        START:    STY   [A,S]", line.comment)	
	}
	
	/**
	 * Check Assembled STY Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedIndirectAccumulatorMovingMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[B,X]  ; 8000   AB 95        START:    STY   [B,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x95, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 95        START:    STY   [B,X]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedIndirectAccumulatorMovingMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[B,Y]  ; 8000   	10 AF B5        START:    STY   [B,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF B5        START:    STY   [B,Y]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedIndirectAccumulatorMovingMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[B,U]  ; 8000   	10 AF D5        START:    STY   [B,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF D5        START:    STY   [B,U]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedIndirectAccumulatorMovingMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[B,S]  ; 8000   	10 AF F5        START:    STY   [B,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF F5        START:    STY   [B,S]", line.comment)	
	}
	
	/**
	 * Check Assembled STY Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedIndirectAccumulatorMovingMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[D,X]  ; 8000   AB 9B        START:    STY   [D,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9B, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    STY   [D,X]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedIndirectAccumulatorMovingMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[D,Y]  ; 8000   	10 AF BB        START:    STY   [D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xBB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF BB        START:    STY   [D,Y]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedIndirectAccumulatorMovingMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[D,U]  ; 8000   	10 AF DB        START:    STY   [D,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xDB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF DB        START:    STY   [D,U]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTYIndexedIndirectAccumulatorMovingMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[D,S]  ; 8000   	10 AF FB        START:    STY   [D,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xFB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF FB        START:    STY   [D,S]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	,X+  ; 8000   	10 AF 80        START:    STY   ,X+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 80        START:    STY   ,X+", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	,X++  ; 8000   	10 AF 81        START:    STY   ,X++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x81, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 81        START:    STY   ,X++", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	,Y+  ; 8000   	10 AF A0        START:    STY   ,Y+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF A0        START:    STY   ,Y+", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	,Y++  ; 8000   	10 AF A1        START:    STY   ,Y++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF A1        START:    STY   ,Y++", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	,S+  ; 8000   	10 AF E0        START:    STY   ,S+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF E0        START:    STY   ,S+", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	,S++  ; 8000   	10 AF E1        START:    STY   ,S++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF E1        START:    STY   ,S++", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	,U+  ; 8000   	10 AF C0        START:    STY   ,U+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF C0        START:    STY   ,U+", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	,U++  ; 8000   	10 AF C1        START:    STY   ,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF C1        START:    STY   ,U++", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	,-X  ; 8000   	10 AF 82        START:    STY   ,-X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x82, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 82        START:    STY   ,-X", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	,--X  ; 8000   	10 AF 83        START:    STY   ,--X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x83, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 83        START:    STY   ,--X", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	,-Y  ; 8000   	10 AF A2        START:    STY   ,-Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF A2        START:    STY   ,-Y", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	,--Y  ; 8000   	10 AF A3        START:    STY   ,--Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF A3        START:    STY   ,--Y", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementMode13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	,-S  ; 8000   	10 AF E2        START:    STY   ,-S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF E2        START:    STY   ,-S", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementMode14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	,--S  ; 8000   	10 AF E3        START:    STY   ,--S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF E3        START:    STY   ,--S", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementMode15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	,-U  ; 8000   	10 AF C2        START:    STY   ,-U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF C2        START:    STY   ,-U", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementMode16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	,--U  ; 8000   	10 AF C3        START:    STY   ,--U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF C3        START:    STY   ,--U", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementIndirectMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[,X+]  ; 8000   	10 AF 80        START:    STY   ,X+
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Mode indorect instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementIndirectMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[,X++]  ; 8000   	10 AF 91        START:    STY   [,X++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x91, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 91        START:    STY   [,X++]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Mode indirect instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementIndirectMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[,Y+]  ; 8000   	10 AF A0        START:    STY   ,Y+
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementIndirectMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[,Y++]  ; 8000   	10 AF B1        START:    STY   [,Y++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF B1        START:    STY   [,Y++]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementIndirectMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[,S+]  ; 8000   	10 AF E0        START:    STY   [,S+]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementIndirectMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[,S++]  ; 8000   	10 AF F1        START:    STY   [,S++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF F1        START:    STY   [,S++]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementIndirectMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[,U+]  ; 8000   	10 AF C0        START:    STY   [,U+]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementindirectMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[,U++]  ; 8000   	10 AF D1        START:    STY   [,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF D1        START:    STY   [,U++]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementIndirectMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[,-X]  ; 8000   	10 AF 82        START:    STY   [,-X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementIndirectMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[,--X]  ; 8000   	10 AF 93        START:    STY   [,--X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x93, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 93        START:    STY   [,--X]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement INdirect Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementIndirectMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[,-Y]  ; 8000   	10 AF A2        START:    STY   [,-Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementIndirectMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[,--Y]  ; 8000   	10 AF B3        START:    STY   [,--Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF B3        START:    STY   [,--Y]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementIndirectMode13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[,-S]  ; 8000   	10 AF E2        START:    STY   [,-S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementIndirectMode14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[,--S]  ; 8000   	10 AF F3        START:    STY   [,--S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF F3        START:    STY   [,--S]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement indirect Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementIndirectMode15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[,-U]  ; 8000   	10 AF C2        START:    STY   [,-U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled STY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTYIndexedAutoIncrementDecrementIndirectMode16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STY		  	[,--U]  ; 8000   	10 AF D3        START:    STY   [,--U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF D3        START:    STY   [,--U]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	1234,X  ; 8000   	10 AF 89 04 D2            STY   1234,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 89 04 D2            STY   1234,X", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	1234,Y  ; 8000   	10 AF A9 04 D2            STY   1234,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF A9 04 D2            STY   1234,Y", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	1234,U  ; 8000   	10 AF C9 04 D2            STY   1234,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF C9 04 D2            STY   1234,U", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	1234,S  ; 8000   	10 AF E9 04 D2            STY   1234,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF E9 04 D2            STY   1234,S", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	34,X  ; 8000   	10 AF 88 22            STY   34,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 88 22            STY   34,X", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	34,Y  ; 8000   	10 AF A8 22            STY   34,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF A8 22            STY   34,Y", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	34,U  ; 8000   	10 AF C8 22            STY   34,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF C8 22            STY   34,U", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	34,S  ; 8000   	10 AF E8 22            STY   34,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF E8 22            STY   34,S", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	,X  ; 8000   	10 AF 84            STY   ,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 84            STY   ,X", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	,Y  ; 8000   	10 AF A4            STY   ,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF A4            STY   ,Y", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	,U  ; 8000   	10 AF C4            STY   ,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF C4            STY   ,U", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	,S  ; 8000   	10 AF E4            STY   ,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF E4            STY   ,S", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	0,X  ; 8000   	10 AF 84            STY   0,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 84            STY   0,X", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	0,Y  ; 8000   	10 AF A4            STY   0,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF A4            STY   0,Y", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	0,U  ; 8000   	10 AF C4            STY   0,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF C4            STY   0,U", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	0,S  ; 8000   	10 AF E4            STY   0,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF E4            STY   0,S", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove17() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-16,X  ; 8000   	10 AF 10            STY   -16,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x10, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 10            STY   -16,X", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove19() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	1,X  ; 8000   	10 AF 01            STY   1,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x01, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 01            STY   1,X", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove20() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	15,X  ; 8000   	10 AF 0F            STY   15,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 0F            STY   15,X", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove21() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-16,Y  ; 8000   	10 AF 30            STY   -16,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x30, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 30            STY   -16,Y", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove23() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	1,Y  ; 8000   	10 AF 21            STY   1,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x21, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 21            STY   1,Y", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove24() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	15,Y  ; 8000   	10 AF 2F            STY   15,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x2F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 2F            STY   15,Y", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove25() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-16,U  ; 8000   	10 AF 50            STY   -16,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x50, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 50            STY   -16,U", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove26() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	1,U  ; 8000   	10 AF 41            STY   1,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x41, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 41            STY   1,U", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove27() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	15,U  ; 8000   	10 AF 4F            STY   15,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x4F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 4F            STY   15,U", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove28() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-16,S  ; 8000   	10 AF 70            STY   -16,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x70, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 70            STY   -16,S", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove29() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	1,S  ; 8000   	10 AF 61            STY   1,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x61, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 61            STY   1,S", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove30() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	15,S  ; 8000   	10 AF 6F            STY   15,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x6F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 6F            STY   15,S", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove31() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-128,X  ; 8000   	10 AF 88 80            STY   -128,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 88 80            STY   -128,X", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove32() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	127,X  ; 8000   	10 AF 88 7F            STY   127,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 88 7F            STY   127,X", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove33() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-128,Y  ; 8000   	10 AF A8 80            STY   -128,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF A8 80            STY   -128,Y", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove34() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	127,Y  ; 8000   	10 AF A8 7F            STY   127,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF A8 7F            STY   127,Y", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove35() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-128,U  ; 8000   	10 AF C8 80            STY   -128,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF C8 80            STY   -128,U", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove36() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	127,U  ; 8000   	10 AF C8 7F            STY   127,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF C8 7F            STY   127,U", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove37() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-128,S  ; 8000   	10 AF E8 80            STY   -128,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF E8 80            STY   -128,S", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove38() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	127,S  ; 8000   	10 AF E8 7F            STY   127,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF E8 7F            STY   127,S", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove39() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-32768,X  ; 8000   	10 AF 89 80 00             STY   -32768,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 89 80 00             STY   -32768,X", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove40() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  32767,X  ; 8000   	10 AF 89 7F FF             STY   32767,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 89 7F FF             STY   32767,X", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove41() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-32768,Y  ; 8000   	10 AF A9 80 00             STY   -32768,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF A9 80 00             STY   -32768,Y", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove42() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  32767,Y  ; 8000   	10 AF A9 7F FF             STY   32767,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF A9 7F FF             STY   32767,Y", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove43() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-32768,U  ; 8000   	10 AF C9 80 00             STY   -32768,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF C9 80 00             STY   -32768,U", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove44() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  32767,U  ; 8000   	10 AF C9 7F FF             STY   32767,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF C9 7F FF             STY   32767,U", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove45() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-32768,S  ; 8000   	10 AF E9 80 00             STY   -32768,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF E9 80 00             STY   -32768,S", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove46() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  32767,S  ; 8000   	10 AF E9 7F FF             STY   32767,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF E9 7F FF             STY   32767,S", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove47() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-32769,X  ; 8000   	10 AF 89 80 00             STY   -32769,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 89 80 00             STY   -32769,X", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove48() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  32768,X  ; 8000   	10 AF 89 7F FF             STY   32768,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 89 7F FF             STY   32768,X", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove49() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-32769,Y  ; 8000   	10 AF A9 80 00             STY   -32769,Y
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF A9 80 00             STY   -32769,Y", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove50() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  32768,Y  ; 8000   	10 AF A9 7F FF             STY   32768,Y
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF A9 7F FF             STY   32768,Y", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove51() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-32769,U  ; 8000   	10 AF C9 80 00             STY   -32769,U
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF C9 80 00             STY   -32769,U", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove52() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  32768,U  ; 8000   	10 AF C9 7F FF             STY   32768,U
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF C9 7F FF             STY   32768,U", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove53() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-32769,S  ; 8000   	10 AF E9 80 00             STY   -32769,S
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF E9 80 00             STY   -32769,S", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantMove54() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  32768,S  ; 8000   	10 AF E9 7F FF             STY   32768,S
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF E9 7F FF             STY   32768,S", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[1234,X]  ; 8000   	10 AF 99 04 D2            STY   [1234,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 99 04 D2            STY   [1234,X]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[1234,Y]  ; 8000   	10 AF B9 04 D2            STY   [1234,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF B9 04 D2            STY   [1234,Y]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[1234,U]  ; 8000   	10 AF D9 04 D2            STY   [1234,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF D9 04 D2            STY   [1234,U]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[1234,S]  ; 8000   	10 AF F9 04 D2            STY   [1234,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF F9 04 D2            STY   [1234,S]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[34,X]  ; 8000   	10 AF 98 22            STY   [34,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 98 22            STY   [34,X]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[34,Y]  ; 8000   	10 AF B8 22            STY   [34,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF B8 22            STY   [34,Y]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[34,U]  ; 8000   	10 AF D8 22            STY   [34,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF D8 22            STY   [34,U]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[34,S]  ; 8000   	10 AF F8 22            STY   [34,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF F8 22            STY   [34,S]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[,X]  ; 8000   	10 AF 94            STY   [,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 94            STY   [,X]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[,Y]  ; 8000   	10 AF B4            STY   [,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF B4            STY   [,Y]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[,U]  ; 8000   	10 AF D4            STY   [,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF D4            STY   [,U]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[,S]  ; 8000   	10 AF F4            STY   [,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF F4            STY   [,S]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[0,X]  ; 8000   	10 AF 94            STY   [0,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 94            STY   [0,X]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[0,Y]  ; 8000   	10 AF B4            STY   [0,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF B4            STY   [0,Y]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[0,U]  ; 8000   	10 AF D4            STY   [0,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF D4            STY   [0,U]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[0,S]  ; 8000   	10 AF F4            STY   [0,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF F4            STY   [0,S]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove17() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-16,X]  ; 8000   	10 AF 98 F0            STY   [-16,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 98 F0            STY   [-16,X]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove18() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[15,X]  ; 8000   	10 AF 98 0F            STY   [15,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 98 0F            STY   [15,X]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove19() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-16,Y]  ; 8000   	10 AF B8 F0            STY   [-16,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF B8 F0            STY   [-16,Y]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove20() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[15,Y]  ; 8000   	10 AF B8 0F            STY   [15,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF B8 0F            STY   [15,Y]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove21() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-16,U]  ; 8000   	10 AF D8 F0            STY   [-16,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF D8 F0            STY   [-16,U]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove22() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[15,U]  ; 8000   	10 AF D8 0F            STY   [15,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF D8 0F            STY   [15,U]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove23() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-16,S]  ; 8000   	10 AF F8 F0            STY   [-16,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF F8 F0            STY   [-16,S]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove24() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[15,S]  ; 8000   	10 AF F8 0F            STY   [15,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF F8 0F            STY   [15,S]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove31() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-128,X]  ; 8000   	10 AF 98 80            STY   [-128,X}
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 98 80            STY   [-128,X}", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove32() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[127,X]  ; 8000   	10 AF 98 7F            STY   [127,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 98 7F            STY   [127,X]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove33() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-128,Y]  ; 8000   	10 AF B8 80            STY   [-128,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF B8 80            STY   [-128,Y]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove34() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[127,Y]  ; 8000   	10 AF B8 7F            STY   [127,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF B8 7F            STY   [127,Y]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove35() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-128,U]  ; 8000   	10 AF D8 80            STY   [-128,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF D8 80            STY   [-128,U]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant INdirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove36() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[127,U]  ; 8000   	10 AF D8 7F            STY   [127,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF D8 7F            STY   [127,U]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove37() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-128,S]  ; 8000   	10 AF F8 80            STY   [-128,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF F8 80            STY   [-128,S]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove38() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[127,S]  ; 8000   	10 AF F8 7F            STY   [127,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF F8 7F            STY   [127,S]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove39() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-32768,X]  ; 8000   	10 AF 99 80 00             STY   [-32768,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 99 80 00             STY   [-32768,X]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove40() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  [32767,X]  ; 8000   	10 AF 99 7F FF             STY   [32767,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 99 7F FF             STY   [32767,X]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove41() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-32768,Y]  ; 8000   	10 AF B9 80 00             STY   [-32768,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF B9 80 00             STY   [-32768,Y]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove42() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  [32767,Y]  ; 8000   	10 AF B9 7F FF             STY   [32767,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF B9 7F FF             STY   [32767,Y]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove43() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-32768,U]  ; 8000   	10 AF D9 80 00             STY   [-32768,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF D9 80 00             STY   [-32768,U]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove44() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  [32767,U]  ; 8000   	10 AF D9 7F FF             STY   [32767,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF D9 7F FF             STY   [32767,U]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove45() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-32768,S]  ; 8000   	10 AF F9 80 00             STY   [-32768,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF F9 80 00             STY   [-32768,S]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove46() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  [32767,S]  ; 8000   	10 AF F9 7F FF             STY   [32767,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF F9 7F FF             STY   [32767,S]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove47() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-32769,X]  ; 8000   	10 AF 99 80 00             STY   [-32769,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 99 80 00             STY   [-32769,X]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove48() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  [32768,X]  ; 8000   	10 AF 99 7F FF             STY   [32768,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 99 7F FF             STY   [32768,X]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove49() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-32769,Y]  ; 8000   	10 AF B9 80 00             STY   [-32769,Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF B9 80 00             STY   [-32769,Y]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove50() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  [32768,Y]  ; 8000   	10 AF B9 7F FF             STY   [32768,Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF B9 7F FF             STY   [32768,Y]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove51() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-32769,U]  ; 8000   	10 AF D9 80 00             STY   [-32769,U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF D9 80 00             STY   [-32769,U]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove52() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  [32768,U]  ; 8000   	10 AF D9 7F FF             STY   [32768,U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF D9 7F FF             STY   [32768,U]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove53() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-32769,S]  ; 8000   	10 AF F9 80 00             STY   [-32769,S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF F9 80 00             STY   [-32769,S]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTYIndexedConstantIndirectMove54() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  [32768,S]  ; 8000   	10 AF F9 7F FF             STY   [32768,S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF F9 7F FF             STY   [32768,S]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testSTYIndexedRelatifToPCMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	0,PCR  ; 8000   	10 AF 8C 00            STY   0,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 8C 00            STY   0,PCR", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testSTYIndexedRelatifToPCMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-128,PCR  ; 8000   	10 AF 8C 80            STY   -128,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 8C 80            STY   -128,PCR", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testSTYIndexedRelatifToPCMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	127,PCR  ; 8000   	10 AF 8C 7F            STY   127,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 8C 7F            STY   127,PCR", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testSTYIndexedRelatifToPCMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-129,PCR  ; 8000   	10 AF 8D FF 7F            STY   -129,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 8D FF 7F            STY   -129,PCR", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testSTYIndexedRelatifToPCMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	128,PCR  ; 8000   	10 AF 8D 00 80            STY   128,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 8D 00 80            STY   128,PCR", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testSTYIndexedRelatifToPCMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-32768,PCR  ; 8000   	10 AF 8D 80 00            STY   -32768,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 8D 80 00            STY   -32768,PCR", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testSTYIndexedRelatifToPCMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	32767,PCR  ; 8000   	10 AF 8D 7F FF            STY   32767,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 8D 7F FF            STY   32767,PCR", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testSTYIndexedRelatifToPCMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	-32769,PCR  ; 8000   	10 AF 8D 80 00            STY   -32769,PCR
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value -32769 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 8D 80 00            STY   -32769,PCR", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testSTYIndexedRelatifToPCMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	32768,PCR  ; 8000   	10 AF 8D 7F FF            STY   32768,PCR
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value 32768 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 8D 7F FF            STY   32768,PCR", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testSTYIndexedRelatifIndirectToPCMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[0,PCR]  ; 8000   	10 AF 9C 00            STY   [0,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 9C 00            STY   [0,PCR]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testSTYIndexedRelatifIndirectToPCMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-128,PCR]  ; 8000   	10 AF 9C 80            STY   [-128,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 9C 80            STY   [-128,PCR]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testSTYIndexedRelatifIndirectToPCMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[127,PCR]  ; 8000   	10 AF 9C 7F            STY   [127,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 9C 7F            STY   [127,PCR]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testSTYIndexedRelatifIndirectToPCMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-129,PCR]  ; 8000   	10 AF 9D FF 7F            STY   [-129,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 9D FF 7F            STY   [-129,PCR]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testSTYIndexedRelatifIndirectToPCMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[128,PCR]  ; 8000   	10 AF 9D 00 80            STY   [128,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 9D 00 80            STY   [128,PCR]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testSTYIndexedRelatifIndirectToPCMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-32768,PCR]  ; 8000   	10 AF 9D 80 00            STY   [-32768,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 9D 80 00            STY   [-32768,PCR]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testSTYIndexedRelatifIndirectToPCMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[32767,PCR]  ; 8000   	10 AF 9D 7F FF            STY   [32767,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 9D 7F FF            STY   [32767,PCR]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testSTYIndexedRelatifIndirectToPCMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[-32769,PCR]  ; 8000   	10 AF 9D 80 00            STY   [-32769,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value -32769 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 9D 80 00            STY   [-32769,PCR]", line.comment)	
	}

	/**
	 * Check Assembled STY Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testSTYIndexedRelatifIndirectToPCMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STY		  	[32768,PCR]  ; 8000   	10 AF 9D 7F FF            STY   [32768,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value 32768 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AF 9D 7F FF            STY   [32768,PCR]", line.comment)	
	}
}