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
import org.bpy.electronics.mc6809.assembler.assembler.LdInstruction
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue
import org.bpy.electronics.mc6809.assembler.assembler.ImmediatOperand
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
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLDYInstruction
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestLDYInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check LDY immediat 
	 */
	@Test 
	def void testLDYImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDY		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDY directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDY instruction", instruction.instruction,"LDY")
		assertTrue("Must be an immediate addressing mode", instruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check LDY direct mode 
	 */
	@Test 
	def void testLDYDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDY		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDY directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDY instruction", instruction.instruction,"LDY")
		assertTrue("Must be a direct addressing mode", instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check LDY extended mode 
	 */
	@Test 
	def void testLDYExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDY		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDY directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDY instruction", instruction.instruction,"LDY")
		assertTrue("Must be a extended addressing mode", instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDY extended mode 
	 */
	@Test 
	def void testLDYExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDY		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDY directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDY instruction", instruction.instruction,"LDY")
		assertTrue("Must be a extended addressing mode", instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDY extended indirect mode 
	 */
	@Test 
	def void testLDYExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDY		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDY directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDY instruction", instruction.instruction,"LDY")
		assertTrue("Must be a extended indirect addressing mode", instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check LDY Constant-Offset Indexed 
	 */
	@Test 
	def void testLDYConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDY		  	Const,X
					LDY		  	,X
					LDY		  	$9,U
					LDY		  	$9,S
					LDY		  	$9,X
					LDY		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDY directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDY instruction", instruction.instruction,"LDY")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check LDY Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testLDYConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDY		  	[Const,X]
					LDY		  	[,X]
					LDY		  	[$9,U]
					LDY		  	[$9,S]
					LDY		  	[$9,X]
					LDY		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDY directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDY instruction", instruction.instruction,"LDY")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check LDY Accumulator Indexed 
	 */
	@Test 
	def void testLDYAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDY		  	A,X
					LDY		  	B,X
					LDY		  	D,U
					LDY		  	A,S
					LDY		  	B,X
					LDY		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDY directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDY instruction", instruction.instruction,"LDY")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check LDY Accumulator Indexed Indirect
	 */
	@Test 
	def void testLDYAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDY		  	[A,X]
					LDY		  	[B,X]
					LDY		  	[D,U]
					LDY		  	[A,S]
					LDY		  	[B,X]
					LDY		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDY directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDY instruction", instruction.instruction,"LDY")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check LDY Auto-Increment Indexed 
	 */
	@Test 
	def void testLDYAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDY		  	,--X
			       	LDY		  	,-X
			       	LDY		  	,X+
			       	LDY		  	,X++
			       	LDY		  	,--S
			       	LDY		  	,-S
			       	LDY		  	,U+
			       	LDY		  	,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDY directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDY instruction", instruction.instruction,"LDY")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check LDY Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testLDYAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDY		  	[,--X]
			       	LDY		  	[,X++]
			       	LDY		  	[,--S]
			       	LDY		  	[,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDY directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDY instruction", instruction.instruction,"LDY")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check LDY Relative to PC Indexed 
	 */
	@Test 
	def void testLDYRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDY		  	0,PC
			       	LDY		  	,PC
			       	LDY		  	Const,PC
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDY directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDY instruction", instruction.instruction,"LDY")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check LDY Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testLDYRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDY		  	[0,PC]
			       	LDY		  	[,PC]
			       	LDY		  	[Const,PC]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDY directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDY instruction", instruction.instruction,"LDY")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
	
	/**
	 * Check LDY instruction with duplicate label 
	 */
	@Test 
	def void testLDYWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start		NOP
					NOP    
		Start      	LDY		  	#Const+2
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.instructionLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"Label Start is already defined"
		)
	}
	
	/**
	 * Check Assembled LDY immediate instruction  
	 */
	@Test 
	def void testLDYImmediatInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	#Const+2  ; 8000   10 8E 07        START:    LDY
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0x8E, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x07, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   10 8E 07        START:    LDY", line.comment)	
	}
	
	/**
	 * Check Assembled LDY immediate with limit negative operand  
	 */
	@Test 
	def void testLDYImmediatInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	#-32769
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check operand", 0x8000, line.operand.get(0));
	}
	
	/**
	 * Check Assembled LDY immediate with limit negative operand  
	 */
	@Test 
	def void testLDYImmediatInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	#-32768
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check operand", 0x8000, line.operand.get(0));
	}

	/**
	 * Check Assembled LDY immediate with positive limit operand  
	 */
	@Test 
	def void testLDYImmediatInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	#32767
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check operand", 0x7FFF, line.operand.get(0));
	}

	/**
	 * Check Assembled LDY immediate with positive limit operand  
	 */
	@Test 
	def void testLDYImmediatInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	#32768
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 32768 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check operand", 0x7FFF, line.operand.get(0));
	}
	
	/**
	 * Check Assembled LDY direct mode instruction  
	 */
	@Test 
	def void testLDYDirectInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	<Const*2  ; 8000   10 9E 0A        START:    LDY   <Const*2 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0x9E, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x0A, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   10 9E 0A        START:    LDY   <Const*2 ", line.comment)	
	}
	
	/**
	 * Check Assembled LDY direct with limit negative operand  
	 */
	@Test 
	def void testLDYDirectInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	<-129
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -129 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}
	
	/**
	 * Check Assembled LDY direct with limit negative operand  
	 */
	@Test 
	def void testLDYDirectInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	<-128
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}

	/**
	 * Check Assembled LDY direct with positive limit operand  
	 */
	@Test 
	def void testLDYDirectInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	<127
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}

	/**
	 * Check Assembled LDY direct with positive limit operand  
	 */
	@Test 
	def void testLDYDirectInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	<128
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 128 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}
	
	/**
	 * Check Assembled LDY extended mode instruction  
	 */
	@Test 
	def void testLDYExtendedInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	>Const*1000  ; 8000   10 BE 13 88     START:    LDY   >Const*1000 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xBE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   10 BE 13 88     START:    LDY   >Const*1000 ", line.comment)	
	}
	
	/**
	 * Check Assembled LDY extended with limit negative operand  
	 */
	@Test 
	def void testLDYExtendedInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	>-32769
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}
	
	/**
	 * Check Assembled LDY extended with limit negative operand  
	 */
	@Test 
	def void testLDYExtendedInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	>-32768
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}

	/**
	 * Check Assembled LDY extended with positive limit operand  
	 */
	@Test 
	def void testLDYExtendedInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	>65535
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}

	/**
	 * Check Assembled LDY extended with positive limit operand  
	 */
	@Test 
	def void testLDYExtendedInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	>65536
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 65536 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}
	
	/**
	 * Check Assembled LDY extended indirect mode instruction  
	 */
	@Test 
	def void testLDYExtendedIndirectInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[Const*1000]  ; 8000   AB 9F 13 88  START:    LDY   [Const*1000]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 3, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check opcode", 0x9F, line.opcode.get(2));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 9F 13 88  START:    LDY   [Const*1000]", line.comment)	
	}
	
	/**
	 * Check Assembled LDY extended indirect with limit negative operand  
	 */
	@Test 
	def void testLDYExtendedIndirectInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-32769]
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}
	
	/**
	 * Check Assembled LDY extended indirect with limit negative operand  
	 */
	@Test 
	def void testLDYExtendedIndirectInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-32768]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}

	/**
	 * Check Assembled LDY extended indirect with positive limit operand  
	 */
	@Test 
	def void testLDYExtendedIndirectInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[65535]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}

	/**
	 * Check Assembled LDY extended indirect with positive limit operand  
	 */
	@Test 
	def void testLDYExtendedIndirectInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[65536]
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 65536 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}
	
	/**
	 * Check Assembled LDY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAccumulatorMovingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	A,X  ; 8000   10 A3 86        START:    LDY   A,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x86, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   10 A3 86        START:    LDY   A,X", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAccumulatorMovingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	A,Y  ; 8000   	10 AE A6        START:    LDY   A,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE A6        START:    LDY   A,Y", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAccumulatorMovingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	A,U  ; 8000   	10 AE C6        START:    LDY   A,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE C6        START:    LDY   A,U", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAccumulatorMovingMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	A,S  ; 8000   	10 AE E6        START:    LDY   A,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE E6        START:    LDY   A,S", line.comment)	
	}
	
	/**
	 * Check Assembled LDY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAccumulatorMovingMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	B,X  ; 8000   AB 85        START:    LDY   B,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x85, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 85        START:    LDY   B,X", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAccumulatorMovingMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	B,Y  ; 8000   	10 AE A5        START:    LDY   B,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE A5        START:    LDY   B,Y", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAccumulatorMovingMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	B,U  ; 8000   	10 AE C5        START:    LDY   B,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE C5        START:    LDY   B,U", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAccumulatorMovingMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	B,S  ; 8000   	10 AE E5        START:    LDY   B,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE E5        START:    LDY   B,S", line.comment)	
	}
	
	/**
	 * Check Assembled LDY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAccumulatorMovingMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	D,X  ; 8000   AB 8B        START:    LDY   D,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8B, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    LDY   D,X", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAccumulatorMovingMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	D,Y  ; 8000   	10 AE AB        START:    LDY   D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xAB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE AB        START:    LDY   D,Y", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAccumulatorMovingMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	D,U  ; 8000   	10 AE CB        START:    LDY   D,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xCB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE CB        START:    LDY   D,U", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAccumulatorMovingMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	D,S  ; 8000   	10 AE EB        START:    LDY   D,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xEB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE EB        START:    LDY   D,S", line.comment)	
	}
	
	/**
	 * Check Assembled LDY Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedIndorectAccumulatorMovingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[A,X]  ; 8000   AB 96        START:    LDY   [A,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x96, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 96        START:    LDY   [A,X]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedIndirectAccumulatorMovingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[A,Y]  ; 8000   	10 AE B6        START:    LDY   [A,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE B6        START:    LDY   [A,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedIndirectAccumulatorMovingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[A,U]  ; 8000   	10 AE D6        START:    LDY   [A,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE D6        START:    LDY   [A,U]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedIndirectAccumulatorMovingMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[A,S]  ; 8000   	10 AE F6        START:    LDY   [A,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE F6        START:    LDY   [A,S]", line.comment)	
	}
	
	/**
	 * Check Assembled LDY Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedIndirectAccumulatorMovingMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[B,X]  ; 8000   AB 95        START:    LDY   [B,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x95, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 95        START:    LDY   [B,X]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedIndirectAccumulatorMovingMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[B,Y]  ; 8000   	10 AE B5        START:    LDY   [B,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE B5        START:    LDY   [B,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedIndirectAccumulatorMovingMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[B,U]  ; 8000   	10 AE D5        START:    LDY   [B,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE D5        START:    LDY   [B,U]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedIndirectAccumulatorMovingMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[B,S]  ; 8000   	10 AE F5        START:    LDY   [B,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE F5        START:    LDY   [B,S]", line.comment)	
	}
	
	/**
	 * Check Assembled LDY Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedIndirectAccumulatorMovingMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[D,X]  ; 8000   AB 9B        START:    LDY   [D,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9B, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    LDY   [D,X]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedIndirectAccumulatorMovingMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[D,Y]  ; 8000   	10 AE BB        START:    LDY   [D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xBB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE BB        START:    LDY   [D,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedIndirectAccumulatorMovingMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[D,U]  ; 8000   	10 AE DB        START:    LDY   [D,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xDB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE DB        START:    LDY   [D,U]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDYIndexedIndirectAccumulatorMovingMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[D,S]  ; 8000   	10 AE FB        START:    LDY   [D,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xFB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE FB        START:    LDY   [D,S]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	,X+  ; 8000   	10 AE 80        START:    LDY   ,X+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 80        START:    LDY   ,X+", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	,X++  ; 8000   	10 AE 81        START:    LDY   ,X++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x81, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 81        START:    LDY   ,X++", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	,Y+  ; 8000   	10 AE A0        START:    LDY   ,Y+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE A0        START:    LDY   ,Y+", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	,Y++  ; 8000   	10 AE A1        START:    LDY   ,Y++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE A1        START:    LDY   ,Y++", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	,S+  ; 8000   	10 AE E0        START:    LDY   ,S+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE E0        START:    LDY   ,S+", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	,S++  ; 8000   	10 AE E1        START:    LDY   ,S++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE E1        START:    LDY   ,S++", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	,U+  ; 8000   	10 AE C0        START:    LDY   ,U+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE C0        START:    LDY   ,U+", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	,U++  ; 8000   	10 AE C1        START:    LDY   ,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE C1        START:    LDY   ,U++", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	,-X  ; 8000   	10 AE 82        START:    LDY   ,-X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x82, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 82        START:    LDY   ,-X", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	,--X  ; 8000   	10 AE 83        START:    LDY   ,--X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x83, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 83        START:    LDY   ,--X", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	,-Y  ; 8000   	10 AE A2        START:    LDY   ,-Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE A2        START:    LDY   ,-Y", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	,--Y  ; 8000   	10 AE A3        START:    LDY   ,--Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE A3        START:    LDY   ,--Y", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementMode13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	,-S  ; 8000   	10 AE E2        START:    LDY   ,-S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE E2        START:    LDY   ,-S", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementMode14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	,--S  ; 8000   	10 AE E3        START:    LDY   ,--S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE E3        START:    LDY   ,--S", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementMode15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	,-U  ; 8000   	10 AE C2        START:    LDY   ,-U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE C2        START:    LDY   ,-U", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementMode16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	,--U  ; 8000   	10 AE C3        START:    LDY   ,--U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE C3        START:    LDY   ,--U", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementIndirectMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[,X+]  ; 8000   	10 AE 80        START:    LDY   ,X+
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Mode indorect instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementIndirectMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[,X++]  ; 8000   	10 AE 91        START:    LDY   [,X++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x91, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 91        START:    LDY   [,X++]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Mode indirect instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementIndirectMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[,Y+]  ; 8000   	10 AE A0        START:    LDY   ,Y+
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementIndirectMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[,Y++]  ; 8000   	10 AE B1        START:    LDY   [,Y++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE B1        START:    LDY   [,Y++]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementIndirectMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[,S+]  ; 8000   	10 AE E0        START:    LDY   [,S+]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementIndirectMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[,S++]  ; 8000   	10 AE F1        START:    LDY   [,S++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE F1        START:    LDY   [,S++]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementIndirectMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[,U+]  ; 8000   	10 AE C0        START:    LDY   [,U+]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementindirectMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[,U++]  ; 8000   	10 AE D1        START:    LDY   [,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE D1        START:    LDY   [,U++]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementIndirectMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[,-X]  ; 8000   	10 AE 82        START:    LDY   [,-X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementIndirectMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[,--X]  ; 8000   	10 AE 93        START:    LDY   [,--X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x93, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 93        START:    LDY   [,--X]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement INdirect Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementIndirectMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[,-Y]  ; 8000   	10 AE A2        START:    LDY   [,-Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementIndirectMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[,--Y]  ; 8000   	10 AE B3        START:    LDY   [,--Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE B3        START:    LDY   [,--Y]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementIndirectMode13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[,-S]  ; 8000   	10 AE E2        START:    LDY   [,-S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementIndirectMode14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[,--S]  ; 8000   	10 AE F3        START:    LDY   [,--S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE F3        START:    LDY   [,--S]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement indirect Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementIndirectMode15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[,-U]  ; 8000   	10 AE C2        START:    LDY   [,-U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDY Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDYIndexedAutoIncrementDecrementIndirectMode16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDY		  	[,--U]  ; 8000   	10 AE D3        START:    LDY   [,--U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE D3        START:    LDY   [,--U]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	1234,X  ; 8000   	10 AE 89 04 D2            LDY   1234,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 89 04 D2            LDY   1234,X", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	1234,Y  ; 8000   	10 AE A9 04 D2            LDY   1234,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE A9 04 D2            LDY   1234,Y", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	1234,U  ; 8000   	10 AE C9 04 D2            LDY   1234,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE C9 04 D2            LDY   1234,U", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	1234,S  ; 8000   	10 AE E9 04 D2            LDY   1234,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE E9 04 D2            LDY   1234,S", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	34,X  ; 8000   	10 AE 88 22            LDY   34,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 88 22            LDY   34,X", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	34,Y  ; 8000   	10 AE A8 22            LDY   34,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE A8 22            LDY   34,Y", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	34,U  ; 8000   	10 AE C8 22            LDY   34,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE C8 22            LDY   34,U", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	34,S  ; 8000   	10 AE E8 22            LDY   34,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE E8 22            LDY   34,S", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	,X  ; 8000   	10 AE 84            LDY   ,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 84            LDY   ,X", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	,Y  ; 8000   	10 AE A4            LDY   ,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE A4            LDY   ,Y", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	,U  ; 8000   	10 AE C4            LDY   ,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE C4            LDY   ,U", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	,S  ; 8000   	10 AE E4            LDY   ,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE E4            LDY   ,S", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	0,X  ; 8000   	10 AE 84            LDY   0,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 84            LDY   0,X", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	0,Y  ; 8000   	10 AE A4            LDY   0,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE A4            LDY   0,Y", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	0,U  ; 8000   	10 AE C4            LDY   0,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE C4            LDY   0,U", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	0,S  ; 8000   	10 AE E4            LDY   0,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE E4            LDY   0,S", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove17() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-16,X  ; 8000   	10 AE 10            LDY   -16,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x10, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 10            LDY   -16,X", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove19() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	1,X  ; 8000   	10 AE 01            LDY   1,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x01, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 01            LDY   1,X", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove20() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	15,X  ; 8000   	10 AE 0F            LDY   15,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 0F            LDY   15,X", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove21() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-16,Y  ; 8000   	10 AE 30            LDY   -16,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x30, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 30            LDY   -16,Y", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove23() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	1,Y  ; 8000   	10 AE 21            LDY   1,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x21, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 21            LDY   1,Y", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove24() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	15,Y  ; 8000   	10 AE 2F            LDY   15,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x2F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 2F            LDY   15,Y", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove25() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-16,U  ; 8000   	10 AE 50            LDY   -16,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x50, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 50            LDY   -16,U", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove26() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	1,U  ; 8000   	10 AE 41            LDY   1,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x41, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 41            LDY   1,U", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove27() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	15,U  ; 8000   	10 AE 4F            LDY   15,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x4F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 4F            LDY   15,U", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove28() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-16,S  ; 8000   	10 AE 70            LDY   -16,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x70, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 70            LDY   -16,S", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove29() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	1,S  ; 8000   	10 AE 61            LDY   1,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x61, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 61            LDY   1,S", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove30() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	15,S  ; 8000   	10 AE 6F            LDY   15,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x6F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 6F            LDY   15,S", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove31() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-128,X  ; 8000   	10 AE 88 80            LDY   -128,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 88 80            LDY   -128,X", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove32() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	127,X  ; 8000   	10 AE 88 7F            LDY   127,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 88 7F            LDY   127,X", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove33() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-128,Y  ; 8000   	10 AE A8 80            LDY   -128,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE A8 80            LDY   -128,Y", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove34() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	127,Y  ; 8000   	10 AE A8 7F            LDY   127,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE A8 7F            LDY   127,Y", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove35() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-128,U  ; 8000   	10 AE C8 80            LDY   -128,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE C8 80            LDY   -128,U", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove36() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	127,U  ; 8000   	10 AE C8 7F            LDY   127,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE C8 7F            LDY   127,U", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove37() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-128,S  ; 8000   	10 AE E8 80            LDY   -128,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE E8 80            LDY   -128,S", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove38() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	127,S  ; 8000   	10 AE E8 7F            LDY   127,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE E8 7F            LDY   127,S", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove39() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-32768,X  ; 8000   	10 AE 89 80 00             LDY   -32768,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 89 80 00             LDY   -32768,X", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove40() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  32767,X  ; 8000   	10 AE 89 7F FF             LDY   32767,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 89 7F FF             LDY   32767,X", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove41() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-32768,Y  ; 8000   	10 AE A9 80 00             LDY   -32768,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE A9 80 00             LDY   -32768,Y", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove42() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  32767,Y  ; 8000   	10 AE A9 7F FF             LDY   32767,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE A9 7F FF             LDY   32767,Y", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove43() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-32768,U  ; 8000   	10 AE C9 80 00             LDY   -32768,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE C9 80 00             LDY   -32768,U", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove44() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  32767,U  ; 8000   	10 AE C9 7F FF             LDY   32767,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE C9 7F FF             LDY   32767,U", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove45() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-32768,S  ; 8000   	10 AE E9 80 00             LDY   -32768,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE E9 80 00             LDY   -32768,S", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove46() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  32767,S  ; 8000   	10 AE E9 7F FF             LDY   32767,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE E9 7F FF             LDY   32767,S", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove47() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-32769,X  ; 8000   	10 AE 89 80 00             LDY   -32769,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 89 80 00             LDY   -32769,X", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove48() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  32768,X  ; 8000   	10 AE 89 7F FF             LDY   32768,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 89 7F FF             LDY   32768,X", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove49() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-32769,Y  ; 8000   	10 AE A9 80 00             LDY   -32769,Y
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE A9 80 00             LDY   -32769,Y", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove50() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  32768,Y  ; 8000   	10 AE A9 7F FF             LDY   32768,Y
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE A9 7F FF             LDY   32768,Y", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove51() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-32769,U  ; 8000   	10 AE C9 80 00             LDY   -32769,U
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE C9 80 00             LDY   -32769,U", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove52() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  32768,U  ; 8000   	10 AE C9 7F FF             LDY   32768,U
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE C9 7F FF             LDY   32768,U", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove53() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-32769,S  ; 8000   	10 AE E9 80 00             LDY   -32769,S
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE E9 80 00             LDY   -32769,S", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantMove54() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  32768,S  ; 8000   	10 AE E9 7F FF             LDY   32768,S
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE E9 7F FF             LDY   32768,S", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[1234,X]  ; 8000   	10 AE 99 04 D2            LDY   [1234,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 99 04 D2            LDY   [1234,X]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[1234,Y]  ; 8000   	10 AE B9 04 D2            LDY   [1234,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE B9 04 D2            LDY   [1234,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[1234,U]  ; 8000   	10 AE D9 04 D2            LDY   [1234,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE D9 04 D2            LDY   [1234,U]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[1234,S]  ; 8000   	10 AE F9 04 D2            LDY   [1234,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE F9 04 D2            LDY   [1234,S]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[34,X]  ; 8000   	10 AE 98 22            LDY   [34,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 98 22            LDY   [34,X]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[34,Y]  ; 8000   	10 AE B8 22            LDY   [34,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE B8 22            LDY   [34,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[34,U]  ; 8000   	10 AE D8 22            LDY   [34,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE D8 22            LDY   [34,U]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[34,S]  ; 8000   	10 AE F8 22            LDY   [34,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE F8 22            LDY   [34,S]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[,X]  ; 8000   	10 AE 94            LDY   [,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 94            LDY   [,X]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[,Y]  ; 8000   	10 AE B4            LDY   [,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE B4            LDY   [,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[,U]  ; 8000   	10 AE D4            LDY   [,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE D4            LDY   [,U]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[,S]  ; 8000   	10 AE F4            LDY   [,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE F4            LDY   [,S]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[0,X]  ; 8000   	10 AE 94            LDY   [0,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 94            LDY   [0,X]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[0,Y]  ; 8000   	10 AE B4            LDY   [0,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE B4            LDY   [0,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[0,U]  ; 8000   	10 AE D4            LDY   [0,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE D4            LDY   [0,U]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[0,S]  ; 8000   	10 AE F4            LDY   [0,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE F4            LDY   [0,S]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove17() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-16,X]  ; 8000   	10 AE 98 F0            LDY   [-16,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 98 F0            LDY   [-16,X]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove18() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[15,X]  ; 8000   	10 AE 98 0F            LDY   [15,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 98 0F            LDY   [15,X]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove19() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-16,Y]  ; 8000   	10 AE B8 F0            LDY   [-16,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE B8 F0            LDY   [-16,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove20() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[15,Y]  ; 8000   	10 AE B8 0F            LDY   [15,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE B8 0F            LDY   [15,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove21() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-16,U]  ; 8000   	10 AE D8 F0            LDY   [-16,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE D8 F0            LDY   [-16,U]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove22() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[15,U]  ; 8000   	10 AE D8 0F            LDY   [15,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE D8 0F            LDY   [15,U]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove23() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-16,S]  ; 8000   	10 AE F8 F0            LDY   [-16,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE F8 F0            LDY   [-16,S]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove24() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[15,S]  ; 8000   	10 AE F8 0F            LDY   [15,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE F8 0F            LDY   [15,S]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove31() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-128,X]  ; 8000   	10 AE 98 80            LDY   [-128,X}
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 98 80            LDY   [-128,X}", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove32() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[127,X]  ; 8000   	10 AE 98 7F            LDY   [127,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 98 7F            LDY   [127,X]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove33() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-128,Y]  ; 8000   	10 AE B8 80            LDY   [-128,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE B8 80            LDY   [-128,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove34() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[127,Y]  ; 8000   	10 AE B8 7F            LDY   [127,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE B8 7F            LDY   [127,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove35() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-128,U]  ; 8000   	10 AE D8 80            LDY   [-128,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE D8 80            LDY   [-128,U]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant INdirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove36() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[127,U]  ; 8000   	10 AE D8 7F            LDY   [127,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE D8 7F            LDY   [127,U]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove37() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-128,S]  ; 8000   	10 AE F8 80            LDY   [-128,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE F8 80            LDY   [-128,S]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove38() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[127,S]  ; 8000   	10 AE F8 7F            LDY   [127,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE F8 7F            LDY   [127,S]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove39() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-32768,X]  ; 8000   	10 AE 99 80 00             LDY   [-32768,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 99 80 00             LDY   [-32768,X]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove40() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  [32767,X]  ; 8000   	10 AE 99 7F FF             LDY   [32767,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 99 7F FF             LDY   [32767,X]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove41() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-32768,Y]  ; 8000   	10 AE B9 80 00             LDY   [-32768,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE B9 80 00             LDY   [-32768,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove42() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  [32767,Y]  ; 8000   	10 AE B9 7F FF             LDY   [32767,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE B9 7F FF             LDY   [32767,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove43() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-32768,U]  ; 8000   	10 AE D9 80 00             LDY   [-32768,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE D9 80 00             LDY   [-32768,U]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove44() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  [32767,U]  ; 8000   	10 AE D9 7F FF             LDY   [32767,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE D9 7F FF             LDY   [32767,U]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove45() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-32768,S]  ; 8000   	10 AE F9 80 00             LDY   [-32768,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE F9 80 00             LDY   [-32768,S]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove46() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  [32767,S]  ; 8000   	10 AE F9 7F FF             LDY   [32767,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE F9 7F FF             LDY   [32767,S]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove47() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-32769,X]  ; 8000   	10 AE 99 80 00             LDY   [-32769,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 99 80 00             LDY   [-32769,X]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove48() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  [32768,X]  ; 8000   	10 AE 99 7F FF             LDY   [32768,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 99 7F FF             LDY   [32768,X]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove49() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-32769,Y]  ; 8000   	10 AE B9 80 00             LDY   [-32769,Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE B9 80 00             LDY   [-32769,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove50() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  [32768,Y]  ; 8000   	10 AE B9 7F FF             LDY   [32768,Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE B9 7F FF             LDY   [32768,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove51() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-32769,U]  ; 8000   	10 AE D9 80 00             LDY   [-32769,U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE D9 80 00             LDY   [-32769,U]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove52() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  [32768,U]  ; 8000   	10 AE D9 7F FF             LDY   [32768,U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE D9 7F FF             LDY   [32768,U]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove53() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-32769,S]  ; 8000   	10 AE F9 80 00             LDY   [-32769,S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE F9 80 00             LDY   [-32769,S]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDYIndexedConstantIndirectMove54() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  [32768,S]  ; 8000   	10 AE F9 7F FF             LDY   [32768,S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE F9 7F FF             LDY   [32768,S]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDYIndexedRelatifToPCMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	0,PCR  ; 8000   	10 AE 8C 00            LDY   0,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 8C 00            LDY   0,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDYIndexedRelatifToPCMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-128,PCR  ; 8000   	10 AE 8C 80            LDY   -128,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 8C 80            LDY   -128,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDYIndexedRelatifToPCMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	127,PCR  ; 8000   	10 AE 8C 7F            LDY   127,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 8C 7F            LDY   127,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDYIndexedRelatifToPCMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-129,PCR  ; 8000   	10 AE 8D FF 7F            LDY   -129,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 8D FF 7F            LDY   -129,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDYIndexedRelatifToPCMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	128,PCR  ; 8000   	10 AE 8D 00 80            LDY   128,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 8D 00 80            LDY   128,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDYIndexedRelatifToPCMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-32768,PCR  ; 8000   	10 AE 8D 80 00            LDY   -32768,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 8D 80 00            LDY   -32768,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDYIndexedRelatifToPCMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	32767,PCR  ; 8000   	10 AE 8D 7F FF            LDY   32767,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 8D 7F FF            LDY   32767,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDYIndexedRelatifToPCMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	-32769,PCR  ; 8000   	10 AE 8D 80 00            LDY   -32769,PCR
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value -32769 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 8D 80 00            LDY   -32769,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDYIndexedRelatifToPCMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	32768,PCR  ; 8000   	10 AE 8D 7F FF            LDY   32768,PCR
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value 32768 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 8D 7F FF            LDY   32768,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDYIndexedRelatifIndirectToPCMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[0,PCR]  ; 8000   	10 AE 9C 00            LDY   [0,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 9C 00            LDY   [0,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDYIndexedRelatifIndirectToPCMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-128,PCR]  ; 8000   	10 AE 9C 80            LDY   [-128,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 9C 80            LDY   [-128,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDYIndexedRelatifIndirectToPCMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[127,PCR]  ; 8000   	10 AE 9C 7F            LDY   [127,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 9C 7F            LDY   [127,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDYIndexedRelatifIndirectToPCMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-129,PCR]  ; 8000   	10 AE 9D FF 7F            LDY   [-129,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 9D FF 7F            LDY   [-129,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDYIndexedRelatifIndirectToPCMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[128,PCR]  ; 8000   	10 AE 9D 00 80            LDY   [128,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 9D 00 80            LDY   [128,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDYIndexedRelatifIndirectToPCMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-32768,PCR]  ; 8000   	10 AE 9D 80 00            LDY   [-32768,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 9D 80 00            LDY   [-32768,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDYIndexedRelatifIndirectToPCMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[32767,PCR]  ; 8000   	10 AE 9D 7F FF            LDY   [32767,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 9D 7F FF            LDY   [32767,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDYIndexedRelatifIndirectToPCMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[-32769,PCR]  ; 8000   	10 AE 9D 80 00            LDY   [-32769,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value -32769 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 9D 80 00            LDY   [-32769,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDY Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDYIndexedRelatifIndirectToPCMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDY		  	[32768,PCR]  ; 8000   	10 AE 9D 7F FF            LDY   [32768,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value 32768 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDYInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xAE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 AE 9D 7F FF            LDY   [32768,PCR]", line.comment)	
	}
}