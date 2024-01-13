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
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledSTSInstruction
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator
import org.bpy.electronics.mc6809.assembler.assembler.DirectOperand

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestSTSInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check STS direct mode 
	 */
	@Test 
	def void testSTSDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STS		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STS directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STS instruction", instruction.instruction,"STS")
		assertTrue("Must be a direct addressing mode", instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check STS extended mode 
	 */
	@Test 
	def void testSTSExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STS		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STS directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STS instruction", instruction.instruction,"STS")
		assertTrue("Must be a extended addressing mode", instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check STS extended mode 
	 */
	@Test 
	def void testSTSExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STS		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STS directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STS instruction", instruction.instruction,"STS")
		assertTrue("Must be a extended addressing mode", instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check STS extended indirect mode 
	 */
	@Test 
	def void testSTSExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       STS		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STS directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STS instruction", instruction.instruction,"STS")
		assertTrue("Must be a extended indirect addressing mode", instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check STS Constant-Offset Indexed 
	 */
	@Test 
	def void testSTSConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STS		  	Const,X
					STS		  	,X
					STS		  	$9,U
					STS		  	$9,S
					STS		  	$9,X
					STS		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STS directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STS instruction", instruction.instruction,"STS")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check STS Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testSTSConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STS		  	[Const,X]
					STS		  	[,X]
					STS		  	[$9,U]
					STS		  	[$9,S]
					STS		  	[$9,X]
					STS		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STS directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STS instruction", instruction.instruction,"STS")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check STS Accumulator Indexed 
	 */
	@Test 
	def void testSTSAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STS		  	A,X
					STS		  	B,X
					STS		  	D,U
					STS		  	A,S
					STS		  	B,X
					STS		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STS directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STS instruction", instruction.instruction,"STS")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check STS Accumulator Indexed Indirect
	 */
	@Test 
	def void testSTSAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STS		  	[A,X]
					STS		  	[B,X]
					STS		  	[D,U]
					STS		  	[A,S]
					STS		  	[B,X]
					STS		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STS directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STS instruction", instruction.instruction,"STS")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check STS Auto-Increment Indexed 
	 */
	@Test 
	def void testSTSAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STS		  	,--X
			       	STS		  	,-X
			       	STS		  	,X+
			       	STS		  	,X++
			       	STS		  	,--S
			       	STS		  	,-S
			       	STS		  	,U+
			       	STS		  	,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STS directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STS instruction", instruction.instruction,"STS")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check STS Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testSTSAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STS		  	[,--X]
			       	STS		  	[,X++]
			       	STS		  	[,--S]
			       	STS		  	[,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STS directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STS instruction", instruction.instruction,"STS")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check STS Relative to PC Indexed 
	 */
	@Test 
	def void testSTSRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STS		  	0,PC
			       	STS		  	,PC
			       	STS		  	Const,PC
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STS directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STS instruction", instruction.instruction,"STS")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check STS Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testSTSRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	STS		  	[0,PC]
			       	STS		  	[,PC]
			       	STS		  	[Const,PC]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an STS directive line", instructionLine.instruction instanceof StInstruction)

		val instruction = instructionLine.instruction as StInstruction
		assertEquals("Must be an STS instruction", instruction.instruction,"STS")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
	
	/**
	 * Check STS instruction with duplicate label 
	 */
	@Test 
	def void testSTSWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start		NOP
					NOP    
		Start      	STS		  	$123
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.instructionLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"Label Start is already defined"
		)
	}
	
	/**
	 * Check Assembled STS immediate instruction  
	 */
	@Test 
	def void testSTSImmediatInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	#Const+2  ; Illegal
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Immediate mode is not valid for the STS instruction"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8001, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x3F, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 0, line.operand.length);	
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; Illegal", line.comment)	
	}
	
	/**
	 * Check Assembled STS direct mode instruction  
	 */
	@Test 
	def void testSTSDirectInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	<Const*2  ; 8000   10 DF 0A        START:    STS   <Const*2 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xDF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x0A, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   10 DF 0A        START:    STS   <Const*2 ", line.comment)	
	}
	
	/**
	 * Check Assembled STS direct with limit negative operand  
	 */
	@Test 
	def void testSTSDirectInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	<-129
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.stInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -129 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}
	
	/**
	 * Check Assembled STS direct with limit negative operand  
	 */
	@Test 
	def void testSTSDirectInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	<-128
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}

	/**
	 * Check Assembled STS direct with positive limit operand  
	 */
	@Test 
	def void testSTSDirectInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	<127
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}

	/**
	 * Check Assembled STS direct with positive limit operand  
	 */
	@Test 
	def void testSTSDirectInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	<128
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.stInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 128 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}
	
	/**
	 * Check Assembled STS extended mode instruction  
	 */
	@Test 
	def void testSTSExtendedInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	>Const*1000  ; 8000   10 FF 13 88     START:    STS   >Const*1000 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xFF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   10 FF 13 88     START:    STS   >Const*1000 ", line.comment)	
	}
	
	/**
	 * Check Assembled STS extended with limit negative operand  
	 */
	@Test 
	def void testSTSExtendedInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	>-32769
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.stInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}
	
	/**
	 * Check Assembled STS extended with limit negative operand  
	 */
	@Test 
	def void testSTSExtendedInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	>-32768
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}

	/**
	 * Check Assembled STS extended with positive limit operand  
	 */
	@Test 
	def void testSTSExtendedInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	>65535
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}

	/**
	 * Check Assembled STS extended with positive limit operand  
	 */
	@Test 
	def void testSTSExtendedInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	>65536
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.stInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 65536 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}
	
	/**
	 * Check Assembled STS extended indirect mode instruction  
	 */
	@Test 
	def void testSTSExtendedIndirectInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[Const*1000]  ; 8000   AB 9F 13 88  START:    STS   [Const*1000]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 3, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check opcode", 0x9F, line.opcode.get(2));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 9F 13 88  START:    STS   [Const*1000]", line.comment)	
	}
	
	/**
	 * Check Assembled STS extended indirect with limit negative operand  
	 */
	@Test 
	def void testSTSExtendedIndirectInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-32769]
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.stInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}
	
	/**
	 * Check Assembled STS extended indirect with limit negative operand  
	 */
	@Test 
	def void testSTSExtendedIndirectInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-32768]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}

	/**
	 * Check Assembled STS extended indirect with positive limit operand  
	 */
	@Test 
	def void testSTSExtendedIndirectInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[65535]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}

	/**
	 * Check Assembled STS extended indirect with positive limit operand  
	 */
	@Test 
	def void testSTSExtendedIndirectInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[65536]
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.stInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 65536 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}
	
	/**
	 * Check Assembled STS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAccumulatorMovingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	A,X  ; 8000   10 A3 86        START:    STS   A,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x86, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   10 A3 86        START:    STS   A,X", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAccumulatorMovingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	A,Y  ; 8000   	10 EF A6        START:    STS   A,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF A6        START:    STS   A,Y", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAccumulatorMovingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	A,U  ; 8000   	10 EF C6        START:    STS   A,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF C6        START:    STS   A,U", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAccumulatorMovingMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	A,S  ; 8000   	10 EF E6        START:    STS   A,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF E6        START:    STS   A,S", line.comment)	
	}
	
	/**
	 * Check Assembled STS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAccumulatorMovingMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	B,X  ; 8000   AB 85        START:    STS   B,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x85, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 85        START:    STS   B,X", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAccumulatorMovingMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	B,Y  ; 8000   	10 EF A5        START:    STS   B,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF A5        START:    STS   B,Y", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAccumulatorMovingMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	B,U  ; 8000   	10 EF C5        START:    STS   B,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF C5        START:    STS   B,U", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAccumulatorMovingMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	B,S  ; 8000   	10 EF E5        START:    STS   B,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF E5        START:    STS   B,S", line.comment)	
	}
	
	/**
	 * Check Assembled STS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAccumulatorMovingMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	D,X  ; 8000   AB 8B        START:    STS   D,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8B, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    STS   D,X", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAccumulatorMovingMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	D,Y  ; 8000   	10 EF AB        START:    STS   D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xAB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF AB        START:    STS   D,Y", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAccumulatorMovingMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	D,U  ; 8000   	10 EF CB        START:    STS   D,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xCB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF CB        START:    STS   D,U", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAccumulatorMovingMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	D,S  ; 8000   	10 EF EB        START:    STS   D,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xEB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF EB        START:    STS   D,S", line.comment)	
	}
	
	/**
	 * Check Assembled STS Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedIndorectAccumulatorMovingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[A,X]  ; 8000   AB 96        START:    STS   [A,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x96, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 96        START:    STS   [A,X]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedIndirectAccumulatorMovingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[A,Y]  ; 8000   	10 EF B6        START:    STS   [A,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF B6        START:    STS   [A,Y]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedIndirectAccumulatorMovingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[A,U]  ; 8000   	10 EF D6        START:    STS   [A,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF D6        START:    STS   [A,U]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedIndirectAccumulatorMovingMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[A,S]  ; 8000   	10 EF F6        START:    STS   [A,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF F6        START:    STS   [A,S]", line.comment)	
	}
	
	/**
	 * Check Assembled STS Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedIndirectAccumulatorMovingMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[B,X]  ; 8000   AB 95        START:    STS   [B,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x95, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 95        START:    STS   [B,X]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedIndirectAccumulatorMovingMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[B,Y]  ; 8000   	10 EF B5        START:    STS   [B,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF B5        START:    STS   [B,Y]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedIndirectAccumulatorMovingMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[B,U]  ; 8000   	10 EF D5        START:    STS   [B,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF D5        START:    STS   [B,U]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedIndirectAccumulatorMovingMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[B,S]  ; 8000   	10 EF F5        START:    STS   [B,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF F5        START:    STS   [B,S]", line.comment)	
	}
	
	/**
	 * Check Assembled STS Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedIndirectAccumulatorMovingMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[D,X]  ; 8000   AB 9B        START:    STS   [D,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9B, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    STS   [D,X]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedIndirectAccumulatorMovingMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[D,Y]  ; 8000   	10 EF BB        START:    STS   [D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xBB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF BB        START:    STS   [D,Y]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedIndirectAccumulatorMovingMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[D,U]  ; 8000   	10 EF DB        START:    STS   [D,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xDB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF DB        START:    STS   [D,U]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testSTSIndexedIndirectAccumulatorMovingMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[D,S]  ; 8000   	10 EF FB        START:    STS   [D,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xFB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF FB        START:    STS   [D,S]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	,X+  ; 8000   	10 EF 80        START:    STS   ,X+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 80        START:    STS   ,X+", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	,X++  ; 8000   	10 EF 81        START:    STS   ,X++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x81, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 81        START:    STS   ,X++", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	,Y+  ; 8000   	10 EF A0        START:    STS   ,Y+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF A0        START:    STS   ,Y+", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	,Y++  ; 8000   	10 EF A1        START:    STS   ,Y++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF A1        START:    STS   ,Y++", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	,S+  ; 8000   	10 EF E0        START:    STS   ,S+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF E0        START:    STS   ,S+", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	,S++  ; 8000   	10 EF E1        START:    STS   ,S++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF E1        START:    STS   ,S++", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	,U+  ; 8000   	10 EF C0        START:    STS   ,U+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF C0        START:    STS   ,U+", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	,U++  ; 8000   	10 EF C1        START:    STS   ,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF C1        START:    STS   ,U++", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	,-X  ; 8000   	10 EF 82        START:    STS   ,-X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x82, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 82        START:    STS   ,-X", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	,--X  ; 8000   	10 EF 83        START:    STS   ,--X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x83, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 83        START:    STS   ,--X", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	,-Y  ; 8000   	10 EF A2        START:    STS   ,-Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF A2        START:    STS   ,-Y", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	,--Y  ; 8000   	10 EF A3        START:    STS   ,--Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF A3        START:    STS   ,--Y", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementMode13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	,-S  ; 8000   	10 EF E2        START:    STS   ,-S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF E2        START:    STS   ,-S", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementMode14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	,--S  ; 8000   	10 EF E3        START:    STS   ,--S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF E3        START:    STS   ,--S", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementMode15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	,-U  ; 8000   	10 EF C2        START:    STS   ,-U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF C2        START:    STS   ,-U", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementMode16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	,--U  ; 8000   	10 EF C3        START:    STS   ,--U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF C3        START:    STS   ,--U", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementIndirectMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[,X+]  ; 8000   	10 EF 80        START:    STS   ,X+
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Mode indorect instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementIndirectMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[,X++]  ; 8000   	10 EF 91        START:    STS   [,X++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x91, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 91        START:    STS   [,X++]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Mode indirect instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementIndirectMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[,Y+]  ; 8000   	10 EF A0        START:    STS   ,Y+
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementIndirectMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[,Y++]  ; 8000   	10 EF B1        START:    STS   [,Y++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF B1        START:    STS   [,Y++]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementIndirectMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[,S+]  ; 8000   	10 EF E0        START:    STS   [,S+]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementIndirectMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[,S++]  ; 8000   	10 EF F1        START:    STS   [,S++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF F1        START:    STS   [,S++]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementIndirectMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[,U+]  ; 8000   	10 EF C0        START:    STS   [,U+]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementindirectMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[,U++]  ; 8000   	10 EF D1        START:    STS   [,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF D1        START:    STS   [,U++]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementIndirectMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[,-X]  ; 8000   	10 EF 82        START:    STS   [,-X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementIndirectMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[,--X]  ; 8000   	10 EF 93        START:    STS   [,--X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x93, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 93        START:    STS   [,--X]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement INdirect Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementIndirectMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[,-Y]  ; 8000   	10 EF A2        START:    STS   [,-Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementIndirectMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[,--Y]  ; 8000   	10 EF B3        START:    STS   [,--Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF B3        START:    STS   [,--Y]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementIndirectMode13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[,-S]  ; 8000   	10 EF E2        START:    STS   [,-S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementIndirectMode14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[,--S]  ; 8000   	10 EF F3        START:    STS   [,--S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF F3        START:    STS   [,--S]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement indirect Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementIndirectMode15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[,-U]  ; 8000   	10 EF C2        START:    STS   [,-U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled STS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testSTSIndexedAutoIncrementDecrementIndirectMode16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	STS		  	[,--U]  ; 8000   	10 EF D3        START:    STS   [,--U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF D3        START:    STS   [,--U]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	1234,X  ; 8000   	10 EF 89 04 D2            STS   1234,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 89 04 D2            STS   1234,X", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	1234,Y  ; 8000   	10 EF A9 04 D2            STS   1234,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF A9 04 D2            STS   1234,Y", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	1234,U  ; 8000   	10 EF C9 04 D2            STS   1234,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF C9 04 D2            STS   1234,U", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	1234,S  ; 8000   	10 EF E9 04 D2            STS   1234,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF E9 04 D2            STS   1234,S", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	34,X  ; 8000   	10 EF 88 22            STS   34,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 88 22            STS   34,X", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	34,Y  ; 8000   	10 EF A8 22            STS   34,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF A8 22            STS   34,Y", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	34,U  ; 8000   	10 EF C8 22            STS   34,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF C8 22            STS   34,U", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	34,S  ; 8000   	10 EF E8 22            STS   34,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF E8 22            STS   34,S", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	,X  ; 8000   	10 EF 84            STS   ,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 84            STS   ,X", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	,Y  ; 8000   	10 EF A4            STS   ,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF A4            STS   ,Y", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	,U  ; 8000   	10 EF C4            STS   ,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF C4            STS   ,U", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	,S  ; 8000   	10 EF E4            STS   ,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF E4            STS   ,S", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	0,X  ; 8000   	10 EF 84            STS   0,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 84            STS   0,X", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	0,Y  ; 8000   	10 EF A4            STS   0,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF A4            STS   0,Y", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	0,U  ; 8000   	10 EF C4            STS   0,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF C4            STS   0,U", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	0,S  ; 8000   	10 EF E4            STS   0,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF E4            STS   0,S", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove17() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-16,X  ; 8000   	10 EF 10            STS   -16,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x10, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 10            STS   -16,X", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove19() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	1,X  ; 8000   	10 EF 01            STS   1,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x01, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 01            STS   1,X", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove20() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	15,X  ; 8000   	10 EF 0F            STS   15,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 0F            STS   15,X", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove21() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-16,Y  ; 8000   	10 EF 30            STS   -16,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x30, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 30            STS   -16,Y", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove23() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	1,Y  ; 8000   	10 EF 21            STS   1,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x21, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 21            STS   1,Y", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove24() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	15,Y  ; 8000   	10 EF 2F            STS   15,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x2F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 2F            STS   15,Y", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove25() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-16,U  ; 8000   	10 EF 50            STS   -16,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x50, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 50            STS   -16,U", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove26() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	1,U  ; 8000   	10 EF 41            STS   1,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x41, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 41            STS   1,U", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove27() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	15,U  ; 8000   	10 EF 4F            STS   15,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x4F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 4F            STS   15,U", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove28() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-16,S  ; 8000   	10 EF 70            STS   -16,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x70, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 70            STS   -16,S", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove29() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	1,S  ; 8000   	10 EF 61            STS   1,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x61, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 61            STS   1,S", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove30() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	15,S  ; 8000   	10 EF 6F            STS   15,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x6F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 6F            STS   15,S", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove31() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-128,X  ; 8000   	10 EF 88 80            STS   -128,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 88 80            STS   -128,X", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove32() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	127,X  ; 8000   	10 EF 88 7F            STS   127,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 88 7F            STS   127,X", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove33() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-128,Y  ; 8000   	10 EF A8 80            STS   -128,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF A8 80            STS   -128,Y", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove34() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	127,Y  ; 8000   	10 EF A8 7F            STS   127,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF A8 7F            STS   127,Y", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove35() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-128,U  ; 8000   	10 EF C8 80            STS   -128,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF C8 80            STS   -128,U", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove36() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	127,U  ; 8000   	10 EF C8 7F            STS   127,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF C8 7F            STS   127,U", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove37() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-128,S  ; 8000   	10 EF E8 80            STS   -128,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF E8 80            STS   -128,S", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove38() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	127,S  ; 8000   	10 EF E8 7F            STS   127,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF E8 7F            STS   127,S", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove39() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-32768,X  ; 8000   	10 EF 89 80 00             STS   -32768,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 89 80 00             STS   -32768,X", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove40() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  32767,X  ; 8000   	10 EF 89 7F FF             STS   32767,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 89 7F FF             STS   32767,X", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove41() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-32768,Y  ; 8000   	10 EF A9 80 00             STS   -32768,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF A9 80 00             STS   -32768,Y", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove42() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  32767,Y  ; 8000   	10 EF A9 7F FF             STS   32767,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF A9 7F FF             STS   32767,Y", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove43() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-32768,U  ; 8000   	10 EF C9 80 00             STS   -32768,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF C9 80 00             STS   -32768,U", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove44() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  32767,U  ; 8000   	10 EF C9 7F FF             STS   32767,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF C9 7F FF             STS   32767,U", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove45() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-32768,S  ; 8000   	10 EF E9 80 00             STS   -32768,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF E9 80 00             STS   -32768,S", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove46() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  32767,S  ; 8000   	10 EF E9 7F FF             STS   32767,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF E9 7F FF             STS   32767,S", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove47() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-32769,X  ; 8000   	10 EF 89 80 00             STS   -32769,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 89 80 00             STS   -32769,X", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove48() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  32768,X  ; 8000   	10 EF 89 7F FF             STS   32768,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 89 7F FF             STS   32768,X", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove49() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-32769,Y  ; 8000   	10 EF A9 80 00             STS   -32769,Y
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF A9 80 00             STS   -32769,Y", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove50() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  32768,Y  ; 8000   	10 EF A9 7F FF             STS   32768,Y
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF A9 7F FF             STS   32768,Y", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove51() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-32769,U  ; 8000   	10 EF C9 80 00             STS   -32769,U
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF C9 80 00             STS   -32769,U", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove52() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  32768,U  ; 8000   	10 EF C9 7F FF             STS   32768,U
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF C9 7F FF             STS   32768,U", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove53() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-32769,S  ; 8000   	10 EF E9 80 00             STS   -32769,S
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF E9 80 00             STS   -32769,S", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantMove54() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  32768,S  ; 8000   	10 EF E9 7F FF             STS   32768,S
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF E9 7F FF             STS   32768,S", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[1234,X]  ; 8000   	10 EF 99 04 D2            STS   [1234,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 99 04 D2            STS   [1234,X]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[1234,Y]  ; 8000   	10 EF B9 04 D2            STS   [1234,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF B9 04 D2            STS   [1234,Y]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[1234,U]  ; 8000   	10 EF D9 04 D2            STS   [1234,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF D9 04 D2            STS   [1234,U]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[1234,S]  ; 8000   	10 EF F9 04 D2            STS   [1234,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF F9 04 D2            STS   [1234,S]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[34,X]  ; 8000   	10 EF 98 22            STS   [34,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 98 22            STS   [34,X]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[34,Y]  ; 8000   	10 EF B8 22            STS   [34,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF B8 22            STS   [34,Y]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[34,U]  ; 8000   	10 EF D8 22            STS   [34,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF D8 22            STS   [34,U]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[34,S]  ; 8000   	10 EF F8 22            STS   [34,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF F8 22            STS   [34,S]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[,X]  ; 8000   	10 EF 94            STS   [,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 94            STS   [,X]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[,Y]  ; 8000   	10 EF B4            STS   [,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF B4            STS   [,Y]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[,U]  ; 8000   	10 EF D4            STS   [,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF D4            STS   [,U]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[,S]  ; 8000   	10 EF F4            STS   [,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF F4            STS   [,S]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[0,X]  ; 8000   	10 EF 94            STS   [0,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 94            STS   [0,X]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[0,Y]  ; 8000   	10 EF B4            STS   [0,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF B4            STS   [0,Y]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[0,U]  ; 8000   	10 EF D4            STS   [0,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF D4            STS   [0,U]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[0,S]  ; 8000   	10 EF F4            STS   [0,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF F4            STS   [0,S]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove17() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-16,X]  ; 8000   	10 EF 98 F0            STS   [-16,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 98 F0            STS   [-16,X]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove18() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[15,X]  ; 8000   	10 EF 98 0F            STS   [15,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 98 0F            STS   [15,X]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove19() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-16,Y]  ; 8000   	10 EF B8 F0            STS   [-16,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF B8 F0            STS   [-16,Y]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove20() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[15,Y]  ; 8000   	10 EF B8 0F            STS   [15,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF B8 0F            STS   [15,Y]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove21() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-16,U]  ; 8000   	10 EF D8 F0            STS   [-16,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF D8 F0            STS   [-16,U]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove22() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[15,U]  ; 8000   	10 EF D8 0F            STS   [15,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF D8 0F            STS   [15,U]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove23() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-16,S]  ; 8000   	10 EF F8 F0            STS   [-16,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF F8 F0            STS   [-16,S]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove24() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[15,S]  ; 8000   	10 EF F8 0F            STS   [15,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF F8 0F            STS   [15,S]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove31() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-128,X]  ; 8000   	10 EF 98 80            STS   [-128,X}
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 98 80            STS   [-128,X}", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove32() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[127,X]  ; 8000   	10 EF 98 7F            STS   [127,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 98 7F            STS   [127,X]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove33() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-128,Y]  ; 8000   	10 EF B8 80            STS   [-128,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF B8 80            STS   [-128,Y]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove34() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[127,Y]  ; 8000   	10 EF B8 7F            STS   [127,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF B8 7F            STS   [127,Y]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove35() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-128,U]  ; 8000   	10 EF D8 80            STS   [-128,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF D8 80            STS   [-128,U]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant INdirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove36() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[127,U]  ; 8000   	10 EF D8 7F            STS   [127,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF D8 7F            STS   [127,U]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove37() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-128,S]  ; 8000   	10 EF F8 80            STS   [-128,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF F8 80            STS   [-128,S]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove38() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[127,S]  ; 8000   	10 EF F8 7F            STS   [127,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF F8 7F            STS   [127,S]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove39() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-32768,X]  ; 8000   	10 EF 99 80 00             STS   [-32768,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 99 80 00             STS   [-32768,X]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove40() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  [32767,X]  ; 8000   	10 EF 99 7F FF             STS   [32767,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 99 7F FF             STS   [32767,X]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove41() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-32768,Y]  ; 8000   	10 EF B9 80 00             STS   [-32768,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF B9 80 00             STS   [-32768,Y]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove42() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  [32767,Y]  ; 8000   	10 EF B9 7F FF             STS   [32767,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF B9 7F FF             STS   [32767,Y]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove43() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-32768,U]  ; 8000   	10 EF D9 80 00             STS   [-32768,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF D9 80 00             STS   [-32768,U]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove44() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  [32767,U]  ; 8000   	10 EF D9 7F FF             STS   [32767,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF D9 7F FF             STS   [32767,U]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove45() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-32768,S]  ; 8000   	10 EF F9 80 00             STS   [-32768,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF F9 80 00             STS   [-32768,S]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove46() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  [32767,S]  ; 8000   	10 EF F9 7F FF             STS   [32767,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF F9 7F FF             STS   [32767,S]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove47() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-32769,X]  ; 8000   	10 EF 99 80 00             STS   [-32769,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 99 80 00             STS   [-32769,X]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove48() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  [32768,X]  ; 8000   	10 EF 99 7F FF             STS   [32768,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 99 7F FF             STS   [32768,X]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove49() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-32769,Y]  ; 8000   	10 EF B9 80 00             STS   [-32769,Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF B9 80 00             STS   [-32769,Y]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove50() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  [32768,Y]  ; 8000   	10 EF B9 7F FF             STS   [32768,Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF B9 7F FF             STS   [32768,Y]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove51() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-32769,U]  ; 8000   	10 EF D9 80 00             STS   [-32769,U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF D9 80 00             STS   [-32769,U]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove52() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  [32768,U]  ; 8000   	10 EF D9 7F FF             STS   [32768,U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF D9 7F FF             STS   [32768,U]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove53() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-32769,S]  ; 8000   	10 EF F9 80 00             STS   [-32769,S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF F9 80 00             STS   [-32769,S]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testSTSIndexedConstantIndirectMove54() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  [32768,S]  ; 8000   	10 EF F9 7F FF             STS   [32768,S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF F9 7F FF             STS   [32768,S]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testSTSIndexedRelatifToPCMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	0,PCR  ; 8000   	10 EF 8C 00            STS   0,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 8C 00            STS   0,PCR", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testSTSIndexedRelatifToPCMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-128,PCR  ; 8000   	10 EF 8C 80            STS   -128,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 8C 80            STS   -128,PCR", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testSTSIndexedRelatifToPCMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	127,PCR  ; 8000   	10 EF 8C 7F            STS   127,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 8C 7F            STS   127,PCR", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testSTSIndexedRelatifToPCMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-129,PCR  ; 8000   	10 EF 8D FF 7F            STS   -129,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 8D FF 7F            STS   -129,PCR", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testSTSIndexedRelatifToPCMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	128,PCR  ; 8000   	10 EF 8D 00 80            STS   128,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 8D 00 80            STS   128,PCR", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testSTSIndexedRelatifToPCMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-32768,PCR  ; 8000   	10 EF 8D 80 00            STS   -32768,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 8D 80 00            STS   -32768,PCR", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testSTSIndexedRelatifToPCMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	32767,PCR  ; 8000   	10 EF 8D 7F FF            STS   32767,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 8D 7F FF            STS   32767,PCR", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testSTSIndexedRelatifToPCMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	-32769,PCR  ; 8000   	10 EF 8D 80 00            STS   -32769,PCR
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value -32769 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 8D 80 00            STS   -32769,PCR", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testSTSIndexedRelatifToPCMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	32768,PCR  ; 8000   	10 EF 8D 7F FF            STS   32768,PCR
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value 32768 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 8D 7F FF            STS   32768,PCR", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testSTSIndexedRelatifIndirectToPCMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[0,PCR]  ; 8000   	10 EF 9C 00            STS   [0,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 9C 00            STS   [0,PCR]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testSTSIndexedRelatifIndirectToPCMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-128,PCR]  ; 8000   	10 EF 9C 80            STS   [-128,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 9C 80            STS   [-128,PCR]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testSTSIndexedRelatifIndirectToPCMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[127,PCR]  ; 8000   	10 EF 9C 7F            STS   [127,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 9C 7F            STS   [127,PCR]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testSTSIndexedRelatifIndirectToPCMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-129,PCR]  ; 8000   	10 EF 9D FF 7F            STS   [-129,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 9D FF 7F            STS   [-129,PCR]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testSTSIndexedRelatifIndirectToPCMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[128,PCR]  ; 8000   	10 EF 9D 00 80            STS   [128,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 9D 00 80            STS   [128,PCR]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testSTSIndexedRelatifIndirectToPCMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-32768,PCR]  ; 8000   	10 EF 9D 80 00            STS   [-32768,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 9D 80 00            STS   [-32768,PCR]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testSTSIndexedRelatifIndirectToPCMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[32767,PCR]  ; 8000   	10 EF 9D 7F FF            STS   [32767,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 9D 7F FF            STS   [32767,PCR]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testSTSIndexedRelatifIndirectToPCMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[-32769,PCR]  ; 8000   	10 EF 9D 80 00            STS   [-32769,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value -32769 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 9D 80 00            STS   [-32769,PCR]", line.comment)	
	}

	/**
	 * Check Assembled STS Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testSTSIndexedRelatifIndirectToPCMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	STS		  	[32768,PCR]  ; 8000   	10 EF 9D 7F FF            STS   [32768,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.stInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value 32768 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledSTSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEF, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EF 9D 7F FF            STS   [32768,PCR]", line.comment)	
	}
}