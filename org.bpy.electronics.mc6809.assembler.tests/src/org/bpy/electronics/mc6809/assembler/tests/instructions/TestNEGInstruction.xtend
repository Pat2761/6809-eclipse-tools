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
import org.bpy.electronics.mc6809.assembler.assembler.NegInstruction
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
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledNEGInstruction
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)
    
class TestNEGInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check NEG direct mode 
	 */
	@Test 
	def void testNEGDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       NEG		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an NEG directive line", instructionLine.instruction instanceof NegInstruction)

		val negInstruction = instructionLine.instruction as NegInstruction
		assertEquals("Must be an NEG instruction", negInstruction.instruction,"NEG")
		assertTrue("Must be a direct addressing mode", negInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check NEG extended mode 
	 */
	@Test 
	def void testNEGExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       NEG		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an NEG directive line", instructionLine.instruction instanceof NegInstruction)

		val negInstruction = instructionLine.instruction as NegInstruction
		assertEquals("Must be an NEG instruction", negInstruction.instruction,"NEG")
		assertTrue("Must be a extended addressing mode", negInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check NEG extended mode 
	 */
	@Test 
	def void testNEGExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       NEG		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an NEG directive line", instructionLine.instruction instanceof NegInstruction)

		val negInstruction = instructionLine.instruction as NegInstruction
		assertEquals("Must be an NEG instruction", negInstruction.instruction,"NEG")
		assertTrue("Must be a extended addressing mode", negInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check NEG extended indirect mode 
	 */
	@Test 
	def void testNEGExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       NEG		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an NEG directive line", instructionLine.instruction instanceof NegInstruction)

		val negInstruction = instructionLine.instruction as NegInstruction
		assertEquals("Must be an NEG instruction", negInstruction.instruction,"NEG")
		assertTrue("Must be a extended indirect addressing mode", negInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check NEG Constant-Offset Indexed 
	 */
	@Test 
	def void testNEGConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	NEG		  	Const,X
					NEG		  	,X
					NEG		  	$9,U
					NEG		  	$9,S
					NEG		  	$9,X
					NEG		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an NEG directive line", instructionLine.instruction instanceof NegInstruction)

		val negInstruction = instructionLine.instruction as NegInstruction
		assertEquals("Must be an NEG instruction", negInstruction.instruction,"NEG")
		assertTrue("Must be a Constant-Offset Indexed mode", negInstruction.operand instanceof IndexedOperand)
		val indexedOperand = negInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check NEG Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testNEGConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	NEG		  	[Const,X]
					NEG		  	[,X]
					NEG		  	[$9,U]
					NEG		  	[$9,S]
					NEG		  	[$9,X]
					NEG		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an NEG directive line", instructionLine.instruction instanceof NegInstruction)

		val negInstruction = instructionLine.instruction as NegInstruction
		assertEquals("Must be an NEG instruction", negInstruction.instruction,"NEG")
		assertTrue("Must be a Constant-Offset Indexed mode", negInstruction.operand instanceof IndexedOperand)
		val indexedOperand = negInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check NEG Accumulator Indexed 
	 */
	@Test 
	def void testNEGAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	NEG		  	A,X
					NEG		  	B,X
					NEG		  	D,U
					NEG		  	A,S
					NEG		  	B,X
					NEG		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an NEG directive line", instructionLine.instruction instanceof NegInstruction)

		val negInstruction = instructionLine.instruction as NegInstruction
		assertEquals("Must be an NEG instruction", negInstruction.instruction,"NEG")
		assertTrue("Must be a Constant-Offset Indexed mode", negInstruction.operand instanceof IndexedOperand)
		val indexedOperand = negInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check NEG Accumulator Indexed Indirect
	 */
	@Test 
	def void testNEGAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	NEG		  	[A,X]
					NEG		  	[B,X]
					NEG		  	[D,U]
					NEG		  	[A,S]
					NEG		  	[B,X]
					NEG		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an NEG directive line", instructionLine.instruction instanceof NegInstruction)

		val negInstruction = instructionLine.instruction as NegInstruction
		assertEquals("Must be an NEG instruction", negInstruction.instruction,"NEG")
		assertTrue("Must be a Constant-Offset Indexed mode", negInstruction.operand instanceof IndexedOperand)
		val indexedOperand = negInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check NEG Auto-Increment Indexed 
	 */
	@Test 
	def void testNEGAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	NEG		  	,--X
			       	NEG		  	,-X
			       	NEG		  	,X+
			       	NEG		  	,X++
			       	NEG		  	,--S
			       	NEG		  	,-S
			       	NEG		  	,U+
			       	NEG		  	,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an NEG directive line", instructionLine.instruction instanceof NegInstruction)

		val negInstruction = instructionLine.instruction as NegInstruction
		assertEquals("Must be an NEG instruction", negInstruction.instruction,"NEG")
		assertTrue("Must be a Constant-Offset Indexed mode", negInstruction.operand instanceof IndexedOperand)
		val indexedOperand = negInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check NEG Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testNEGAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	NEG		  	[,--X]
			       	NEG		  	[,X++]
			       	NEG		  	[,--S]
			       	NEG		  	[,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an NEG directive line", instructionLine.instruction instanceof NegInstruction)

		val negInstruction = instructionLine.instruction as NegInstruction
		assertEquals("Must be an NEG instruction", negInstruction.instruction,"NEG")
		assertTrue("Must be a Constant-Offset Indexed mode", negInstruction.operand instanceof IndexedOperand)
		val indexedOperand = negInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check NEG Relative to PC Indexed 
	 */
	@Test 
	def void testNEGRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	NEG		  	0,PC
			       	NEG		  	,PC
			       	NEG		  	Const,PC
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an NEG directive line", instructionLine.instruction instanceof NegInstruction)

		val negInstruction = instructionLine.instruction as NegInstruction
		assertEquals("Must be an NEG instruction", negInstruction.instruction,"NEG")
		assertTrue("Must be a Constant-Offset Indexed mode", negInstruction.operand instanceof IndexedOperand)
		val indexedOperand = negInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check NEG Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testNEGRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	NEG		  	[0,PC]
			       	NEG		  	[,PC]
			       	NEG		  	[Const,PC]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an NEG directive line", instructionLine.instruction instanceof NegInstruction)

		val negInstruction = instructionLine.instruction as NegInstruction
		assertEquals("Must be an NEG instruction", negInstruction.instruction,"NEG")
		assertTrue("Must be a Constant-Offset Indexed mode", negInstruction.operand instanceof IndexedOperand)
		val indexedOperand = negInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
	
	/**
	 * Check NEG instruction with duplicate label 
	 */
	@Test 
	def void testNEGWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start		NOP
					NOP    
		Start      	NEG		  		<Const+2
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.instructionLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"Label Start is already defined"
		)
	}
	
	@Test 
	def void testNEGWithImmediateMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  		#25           ; Check illegal mode
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.negInstruction,
			InstructionValidator.ILLEGAL_MODE,
			"Immediate mode is not valid for the NEG instruction"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check State", 0x8001, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check Opcode length", 1, line.opcode.length)
		Assert.assertEquals("Check Opcode value", 0x3F, line.opcode.get(0))
		Assert.assertEquals("Check Operand length", 0, line.operand.length)
		Assert.assertEquals("Check label", "Start", line.label)
		Assert.assertEquals("Check comment", "; Check illegal mode", line.comment)
	}
	
	/**
	 * Check Assembled NEG direct mode instruction  
	 */
	@Test 
	def void testNEGDirectInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	<Const*2  ; 8000   00 0A        START:    NEG   <Const*2 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x00, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x0A, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   00 0A        START:    NEG   <Const*2 ", line.comment)	
	}
	
	/**
	 * Check Assembled NEG direct with limit negative operand  
	 */
	@Test 
	def void testNEGDirectInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	<-129
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.negInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -129 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}
	
	/**
	 * Check Assembled NEG direct with limit negative operand  
	 */
	@Test 
	def void testNEGDirectInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	<-128
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}

	/**
	 * Check Assembled NEG direct with positive limit operand  
	 */
	@Test 
	def void testNEGDirectInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	<127
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}

	/**
	 * Check Assembled NEG direct with positive limit operand  
	 */
	@Test 
	def void testNEGDirectInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	<128
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.negInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 128 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}
	
	/**
	 * Check Assembled NEG extended mode instruction  
	 */
	@Test 
	def void testNEGExtendedInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	>Const*1000  ; 8000   70 13 88     START:    NEG   >Const*1000 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x70, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   70 13 88     START:    NEG   >Const*1000 ", line.comment)	
	}
	
	/**
	 * Check Assembled NEG extended with limit negative operand  
	 */
	@Test 
	def void testNEGExtendedInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	>-32769
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.negInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}
	
	/**
	 * Check Assembled NEG extended with limit negative operand  
	 */
	@Test 
	def void testNEGExtendedInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	>-32768
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}

	/**
	 * Check Assembled NEG extended with positive limit operand  
	 */
	@Test 
	def void testNEGExtendedInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	>65535
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}

	/**
	 * Check Assembled NEG extended with positive limit operand  
	 */
	@Test 
	def void testNEGExtendedInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	>65536
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.negInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 65536 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}
	
	/**
	 * Check Assembled NEG extended indirect mode instruction  
	 */
	@Test 
	def void testNEGExtendedIndirectInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[Const*1000]  ; 8000   AB 9F 13 88  START:    NEG   [Const*1000]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0x9F, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 9F 13 88  START:    NEG   [Const*1000]", line.comment)	
	}
	
	/**
	 * Check Assembled NEG extended indirect with limit negative operand  
	 */
	@Test 
	def void testNEGExtendedIndirectInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-32769]
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.negInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}
	
	/**
	 * Check Assembled NEG extended indirect with limit negative operand  
	 */
	@Test 
	def void testNEGExtendedIndirectInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-32768]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}

	/**
	 * Check Assembled NEG extended indirect with positive limit operand  
	 */
	@Test 
	def void testNEGExtendedIndirectInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[65535]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}

	/**
	 * Check Assembled NEG extended indirect with positive limit operand  
	 */
	@Test 
	def void testNEGExtendedIndirectInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[65536]
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.negInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 65536 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}
	
	/**
	 * Check Assembled NEG Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAccumulatorMovingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	A,X  ; 8000   AB 86        START:    NEG   A,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x86, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 86        START:    NEG   A,X", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAccumulatorMovingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	A,Y  ; 8000   	60 A6        START:    NEG   A,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 A6        START:    NEG   A,Y", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAccumulatorMovingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	A,U  ; 8000   	60 C6        START:    NEG   A,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 C6        START:    NEG   A,U", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAccumulatorMovingMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	A,S  ; 8000   	60 E6        START:    NEG   A,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 E6        START:    NEG   A,S", line.comment)	
	}
	
	/**
	 * Check Assembled NEG Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAccumulatorMovingMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	B,X  ; 8000   AB 85        START:    NEG   B,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x85, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 85        START:    NEG   B,X", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAccumulatorMovingMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	B,Y  ; 8000   	60 A5        START:    NEG   B,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 A5        START:    NEG   B,Y", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAccumulatorMovingMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	B,U  ; 8000   	60 C5        START:    NEG   B,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 C5        START:    NEG   B,U", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAccumulatorMovingMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	B,S  ; 8000   	60 E5        START:    NEG   B,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 E5        START:    NEG   B,S", line.comment)	
	}
	
	/**
	 * Check Assembled NEG Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAccumulatorMovingMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	D,X  ; 8000   AB 8B        START:    NEG   D,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8B, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    NEG   D,X", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAccumulatorMovingMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	D,Y  ; 8000   	60 AB        START:    NEG   D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xAB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 AB        START:    NEG   D,Y", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAccumulatorMovingMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	D,U  ; 8000   	60 CB        START:    NEG   D,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xCB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 CB        START:    NEG   D,U", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAccumulatorMovingMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	D,S  ; 8000   	60 EB        START:    NEG   D,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xEB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 EB        START:    NEG   D,S", line.comment)	
	}
	
	/**
	 * Check Assembled NEG Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedIndorectAccumulatorMovingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[A,X]  ; 8000   AB 96        START:    NEG   [A,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x96, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 96        START:    NEG   [A,X]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedIndirectAccumulatorMovingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[A,Y]  ; 8000   	60 B6        START:    NEG   [A,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 B6        START:    NEG   [A,Y]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedIndirectAccumulatorMovingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[A,U]  ; 8000   	60 D6        START:    NEG   [A,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 D6        START:    NEG   [A,U]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedIndirectAccumulatorMovingMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[A,S]  ; 8000   	60 F6        START:    NEG   [A,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 F6        START:    NEG   [A,S]", line.comment)	
	}
	
	/**
	 * Check Assembled NEG Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedIndirectAccumulatorMovingMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[B,X]  ; 8000   AB 95        START:    NEG   [B,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x95, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 95        START:    NEG   [B,X]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedIndirectAccumulatorMovingMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[B,Y]  ; 8000   	60 B5        START:    NEG   [B,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 B5        START:    NEG   [B,Y]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedIndirectAccumulatorMovingMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[B,U]  ; 8000   	60 D5        START:    NEG   [B,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 D5        START:    NEG   [B,U]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedIndirectAccumulatorMovingMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[B,S]  ; 8000   	60 F5        START:    NEG   [B,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 F5        START:    NEG   [B,S]", line.comment)	
	}
	
	/**
	 * Check Assembled NEG Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedIndirectAccumulatorMovingMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[D,X]  ; 8000   AB 9B        START:    NEG   [D,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9B, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    NEG   [D,X]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedIndirectAccumulatorMovingMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[D,Y]  ; 8000   	60 BB        START:    NEG   [D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xBB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 BB        START:    NEG   [D,Y]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedIndirectAccumulatorMovingMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[D,U]  ; 8000   	60 DB        START:    NEG   [D,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xDB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 DB        START:    NEG   [D,U]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testNEGIndexedIndirectAccumulatorMovingMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[D,S]  ; 8000   	60 FB        START:    NEG   [D,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xFB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 FB        START:    NEG   [D,S]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	,X+  ; 8000   	60 80        START:    NEG   ,X+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 80        START:    NEG   ,X+", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	,X++  ; 8000   	60 81        START:    NEG   ,X++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x81, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 81        START:    NEG   ,X++", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	,Y+  ; 8000   	60 A0        START:    NEG   ,Y+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 A0        START:    NEG   ,Y+", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	,Y++  ; 8000   	60 A1        START:    NEG   ,Y++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 A1        START:    NEG   ,Y++", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	,S+  ; 8000   	60 E0        START:    NEG   ,S+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 E0        START:    NEG   ,S+", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	,S++  ; 8000   	60 E1        START:    NEG   ,S++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 E1        START:    NEG   ,S++", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	,U+  ; 8000   	60 C0        START:    NEG   ,U+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 C0        START:    NEG   ,U+", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	,U++  ; 8000   	60 C1        START:    NEG   ,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 C1        START:    NEG   ,U++", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	,-X  ; 8000   	60 82        START:    NEG   ,-X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x82, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 82        START:    NEG   ,-X", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	,--X  ; 8000   	60 83        START:    NEG   ,--X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x83, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 83        START:    NEG   ,--X", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	,-Y  ; 8000   	60 A2        START:    NEG   ,-Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 A2        START:    NEG   ,-Y", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	,--Y  ; 8000   	60 A3        START:    NEG   ,--Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 A3        START:    NEG   ,--Y", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementMode13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	,-S  ; 8000   	60 E2        START:    NEG   ,-S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 E2        START:    NEG   ,-S", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementMode14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	,--S  ; 8000   	60 E3        START:    NEG   ,--S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 E3        START:    NEG   ,--S", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementMode15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	,-U  ; 8000   	60 C2        START:    NEG   ,-U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 C2        START:    NEG   ,-U", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementMode16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	,--U  ; 8000   	60 C3        START:    NEG   ,--U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 C3        START:    NEG   ,--U", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementIndirectMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[,X+]  ; 8000   	60 80        START:    NEG   ,X+
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Mode indorect instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementIndirectMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[,X++]  ; 8000   	60 91        START:    NEG   [,X++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x91, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 91        START:    NEG   [,X++]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Mode indirect instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementIndirectMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[,Y+]  ; 8000   	60 A0        START:    NEG   ,Y+
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementIndirectMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[,Y++]  ; 8000   	60 B1        START:    NEG   [,Y++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 B1        START:    NEG   [,Y++]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementIndirectMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[,S+]  ; 8000   	60 E0        START:    NEG   [,S+]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementIndirectMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[,S++]  ; 8000   	60 F1        START:    NEG   [,S++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 F1        START:    NEG   [,S++]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementIndirectMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[,U+]  ; 8000   	60 C0        START:    NEG   [,U+]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementindirectMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[,U++]  ; 8000   	60 D1        START:    NEG   [,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 D1        START:    NEG   [,U++]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementIndirectMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[,-X]  ; 8000   	60 82        START:    NEG   [,-X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementIndirectMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[,--X]  ; 8000   	60 93        START:    NEG   [,--X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x93, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 93        START:    NEG   [,--X]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement INdirect Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementIndirectMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[,-Y]  ; 8000   	60 A2        START:    NEG   [,-Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementIndirectMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[,--Y]  ; 8000   	60 B3        START:    NEG   [,--Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 B3        START:    NEG   [,--Y]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementIndirectMode13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[,-S]  ; 8000   	60 E2        START:    NEG   [,-S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementIndirectMode14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[,--S]  ; 8000   	60 F3        START:    NEG   [,--S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 F3        START:    NEG   [,--S]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement indirect Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementIndirectMode15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[,-U]  ; 8000   	60 C2        START:    NEG   [,-U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled NEG Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testNEGIndexedAutoIncrementDecrementIndirectMode16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	NEG		  	[,--U]  ; 8000   	60 D3        START:    NEG   [,--U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 D3        START:    NEG   [,--U]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	1234,X  ; 8000   	60 89 04 D2            NEG   1234,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 89 04 D2            NEG   1234,X", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	1234,Y  ; 8000   	60 A9 04 D2            NEG   1234,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 A9 04 D2            NEG   1234,Y", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	1234,U  ; 8000   	60 C9 04 D2            NEG   1234,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 C9 04 D2            NEG   1234,U", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	1234,S  ; 8000   	60 E9 04 D2            NEG   1234,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 E9 04 D2            NEG   1234,S", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	34,X  ; 8000   	60 88 22            NEG   34,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 88 22            NEG   34,X", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	34,Y  ; 8000   	60 A8 22            NEG   34,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 A8 22            NEG   34,Y", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	34,U  ; 8000   	60 C8 22            NEG   34,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 C8 22            NEG   34,U", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	34,S  ; 8000   	60 E8 22            NEG   34,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 E8 22            NEG   34,S", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	,X  ; 8000   	60 84            NEG   ,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 84            NEG   ,X", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	,Y  ; 8000   	60 A4            NEG   ,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 A4            NEG   ,Y", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	,U  ; 8000   	60 C4            NEG   ,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 C4            NEG   ,U", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	,S  ; 8000   	60 E4            NEG   ,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 E4            NEG   ,S", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	0,X  ; 8000   	60 84            NEG   0,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 84            NEG   0,X", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	0,Y  ; 8000   	60 A4            NEG   0,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 A4            NEG   0,Y", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	0,U  ; 8000   	60 C4            NEG   0,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 C4            NEG   0,U", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	0,S  ; 8000   	60 E4            NEG   0,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 E4            NEG   0,S", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove17() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-16,X  ; 8000   	60 10            NEG   -16,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x10, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 10            NEG   -16,X", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove19() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	1,X  ; 8000   	60 01            NEG   1,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x01, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 01            NEG   1,X", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove20() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	15,X  ; 8000   	60 0F            NEG   15,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 0F            NEG   15,X", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove21() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-16,Y  ; 8000   	60 30            NEG   -16,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x30, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 30            NEG   -16,Y", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove23() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	1,Y  ; 8000   	60 21            NEG   1,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x21, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 21            NEG   1,Y", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove24() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	15,Y  ; 8000   	60 2F            NEG   15,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x2F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 2F            NEG   15,Y", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove25() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-16,U  ; 8000   	60 50            NEG   -16,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x50, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 50            NEG   -16,U", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove26() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	1,U  ; 8000   	60 41            NEG   1,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x41, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 41            NEG   1,U", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove27() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	15,U  ; 8000   	60 4F            NEG   15,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x4F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 4F            NEG   15,U", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove28() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-16,S  ; 8000   	60 70            NEG   -16,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x70, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 70            NEG   -16,S", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove29() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	1,S  ; 8000   	60 61            NEG   1,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x61, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 61            NEG   1,S", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove30() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	15,S  ; 8000   	60 6F            NEG   15,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x6F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 6F            NEG   15,S", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove31() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-128,X  ; 8000   	60 88 80            NEG   -128,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 88 80            NEG   -128,X", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove32() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	127,X  ; 8000   	60 88 7F            NEG   127,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 88 7F            NEG   127,X", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove33() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-128,Y  ; 8000   	60 A8 80            NEG   -128,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 A8 80            NEG   -128,Y", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove34() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	127,Y  ; 8000   	60 A8 7F            NEG   127,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 A8 7F            NEG   127,Y", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove35() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-128,U  ; 8000   	60 C8 80            NEG   -128,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 C8 80            NEG   -128,U", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove36() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	127,U  ; 8000   	60 C8 7F            NEG   127,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 C8 7F            NEG   127,U", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove37() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-128,S  ; 8000   	60 E8 80            NEG   -128,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 E8 80            NEG   -128,S", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove38() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	127,S  ; 8000   	60 E8 7F            NEG   127,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 E8 7F            NEG   127,S", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove39() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-32768,X  ; 8000   	60 89 80 00             NEG   -32768,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 89 80 00             NEG   -32768,X", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove40() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  32767,X  ; 8000   	60 89 7F FF             NEG   32767,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 89 7F FF             NEG   32767,X", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove41() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-32768,Y  ; 8000   	60 A9 80 00             NEG   -32768,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 A9 80 00             NEG   -32768,Y", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove42() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  32767,Y  ; 8000   	60 A9 7F FF             NEG   32767,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 A9 7F FF             NEG   32767,Y", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove43() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-32768,U  ; 8000   	60 C9 80 00             NEG   -32768,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 C9 80 00             NEG   -32768,U", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove44() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  32767,U  ; 8000   	60 C9 7F FF             NEG   32767,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 C9 7F FF             NEG   32767,U", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove45() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-32768,S  ; 8000   	60 E9 80 00             NEG   -32768,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 E9 80 00             NEG   -32768,S", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove46() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  32767,S  ; 8000   	60 E9 7F FF             NEG   32767,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 E9 7F FF             NEG   32767,S", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove47() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-32769,X  ; 8000   	60 89 80 00             NEG   -32769,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 89 80 00             NEG   -32769,X", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove48() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  32768,X  ; 8000   	60 89 7F FF             NEG   32768,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 89 7F FF             NEG   32768,X", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove49() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-32769,Y  ; 8000   	60 A9 80 00             NEG   -32769,Y
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 A9 80 00             NEG   -32769,Y", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove50() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  32768,Y  ; 8000   	60 A9 7F FF             NEG   32768,Y
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 A9 7F FF             NEG   32768,Y", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove51() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-32769,U  ; 8000   	60 C9 80 00             NEG   -32769,U
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 C9 80 00             NEG   -32769,U", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove52() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  32768,U  ; 8000   	60 C9 7F FF             NEG   32768,U
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 C9 7F FF             NEG   32768,U", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove53() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-32769,S  ; 8000   	60 E9 80 00             NEG   -32769,S
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 E9 80 00             NEG   -32769,S", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantMove54() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  32768,S  ; 8000   	60 E9 7F FF             NEG   32768,S
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 E9 7F FF             NEG   32768,S", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[1234,X]  ; 8000   	60 99 04 D2            NEG   [1234,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 99 04 D2            NEG   [1234,X]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[1234,Y]  ; 8000   	60 B9 04 D2            NEG   [1234,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 B9 04 D2            NEG   [1234,Y]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[1234,U]  ; 8000   	60 D9 04 D2            NEG   [1234,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 D9 04 D2            NEG   [1234,U]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[1234,S]  ; 8000   	60 F9 04 D2            NEG   [1234,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 F9 04 D2            NEG   [1234,S]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[34,X]  ; 8000   	60 98 22            NEG   [34,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 98 22            NEG   [34,X]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[34,Y]  ; 8000   	60 B8 22            NEG   [34,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 B8 22            NEG   [34,Y]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[34,U]  ; 8000   	60 D8 22            NEG   [34,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 D8 22            NEG   [34,U]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[34,S]  ; 8000   	60 F8 22            NEG   [34,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 F8 22            NEG   [34,S]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[,X]  ; 8000   	60 94            NEG   [,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 94            NEG   [,X]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[,Y]  ; 8000   	60 B4            NEG   [,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 B4            NEG   [,Y]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[,U]  ; 8000   	60 D4            NEG   [,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 D4            NEG   [,U]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[,S]  ; 8000   	60 F4            NEG   [,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 F4            NEG   [,S]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[0,X]  ; 8000   	60 94            NEG   [0,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 94            NEG   [0,X]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[0,Y]  ; 8000   	60 B4            NEG   [0,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 B4            NEG   [0,Y]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[0,U]  ; 8000   	60 D4            NEG   [0,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 D4            NEG   [0,U]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[0,S]  ; 8000   	60 F4            NEG   [0,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 F4            NEG   [0,S]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove17() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-16,X]  ; 8000   	60 98 F0            NEG   [-16,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 98 F0            NEG   [-16,X]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove18() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[15,X]  ; 8000   	60 98 0F            NEG   [15,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 98 0F            NEG   [15,X]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove19() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-16,Y]  ; 8000   	60 B8 F0            NEG   [-16,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 B8 F0            NEG   [-16,Y]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove20() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[15,Y]  ; 8000   	60 B8 0F            NEG   [15,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 B8 0F            NEG   [15,Y]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove21() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-16,U]  ; 8000   	60 D8 F0            NEG   [-16,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 D8 F0            NEG   [-16,U]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove22() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[15,U]  ; 8000   	60 D8 0F            NEG   [15,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 D8 0F            NEG   [15,U]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove23() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-16,S]  ; 8000   	60 F8 F0            NEG   [-16,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 F8 F0            NEG   [-16,S]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove24() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[15,S]  ; 8000   	60 F8 0F            NEG   [15,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 F8 0F            NEG   [15,S]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove31() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-128,X]  ; 8000   	60 98 80            NEG   [-128,X}
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 98 80            NEG   [-128,X}", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove32() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[127,X]  ; 8000   	60 98 7F            NEG   [127,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 98 7F            NEG   [127,X]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove33() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-128,Y]  ; 8000   	60 B8 80            NEG   [-128,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 B8 80            NEG   [-128,Y]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove34() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[127,Y]  ; 8000   	60 B8 7F            NEG   [127,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 B8 7F            NEG   [127,Y]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove35() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-128,U]  ; 8000   	60 D8 80            NEG   [-128,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 D8 80            NEG   [-128,U]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant INdirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove36() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[127,U]  ; 8000   	60 D8 7F            NEG   [127,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 D8 7F            NEG   [127,U]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove37() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-128,S]  ; 8000   	60 F8 80            NEG   [-128,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 F8 80            NEG   [-128,S]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove38() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[127,S]  ; 8000   	60 F8 7F            NEG   [127,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 F8 7F            NEG   [127,S]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove39() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-32768,X]  ; 8000   	60 99 80 00             NEG   [-32768,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 99 80 00             NEG   [-32768,X]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove40() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  [32767,X]  ; 8000   	60 99 7F FF             NEG   [32767,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 99 7F FF             NEG   [32767,X]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove41() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-32768,Y]  ; 8000   	60 B9 80 00             NEG   [-32768,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 B9 80 00             NEG   [-32768,Y]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove42() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  [32767,Y]  ; 8000   	60 B9 7F FF             NEG   [32767,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 B9 7F FF             NEG   [32767,Y]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove43() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-32768,U]  ; 8000   	60 D9 80 00             NEG   [-32768,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 D9 80 00             NEG   [-32768,U]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove44() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  [32767,U]  ; 8000   	60 D9 7F FF             NEG   [32767,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 D9 7F FF             NEG   [32767,U]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove45() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-32768,S]  ; 8000   	60 F9 80 00             NEG   [-32768,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 F9 80 00             NEG   [-32768,S]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove46() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  [32767,S]  ; 8000   	60 F9 7F FF             NEG   [32767,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 F9 7F FF             NEG   [32767,S]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove47() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-32769,X]  ; 8000   	60 99 80 00             NEG   [-32769,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 99 80 00             NEG   [-32769,X]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove48() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  [32768,X]  ; 8000   	60 99 7F FF             NEG   [32768,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 99 7F FF             NEG   [32768,X]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove49() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-32769,Y]  ; 8000   	60 B9 80 00             NEG   [-32769,Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 B9 80 00             NEG   [-32769,Y]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove50() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  [32768,Y]  ; 8000   	60 B9 7F FF             NEG   [32768,Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 B9 7F FF             NEG   [32768,Y]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove51() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-32769,U]  ; 8000   	60 D9 80 00             NEG   [-32769,U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 D9 80 00             NEG   [-32769,U]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove52() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  [32768,U]  ; 8000   	60 D9 7F FF             NEG   [32768,U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 D9 7F FF             NEG   [32768,U]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove53() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-32769,S]  ; 8000   	60 F9 80 00             NEG   [-32769,S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 F9 80 00             NEG   [-32769,S]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testNEGIndexedConstantIndirectMove54() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  [32768,S]  ; 8000   	60 F9 7F FF             NEG   [32768,S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 F9 7F FF             NEG   [32768,S]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testNEGIndexedRelatifToPCMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	0,PCR  ; 8000   	60 8C 00            NEG   0,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 8C 00            NEG   0,PCR", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testNEGIndexedRelatifToPCMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-128,PCR  ; 8000   	60 8C 80            NEG   -128,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 8C 80            NEG   -128,PCR", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testNEGIndexedRelatifToPCMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	127,PCR  ; 8000   	60 8C 7F            NEG   127,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 8C 7F            NEG   127,PCR", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testNEGIndexedRelatifToPCMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-129,PCR  ; 8000   	60 8D FF 7F            NEG   -129,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 8D FF 7F            NEG   -129,PCR", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testNEGIndexedRelatifToPCMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	128,PCR  ; 8000   	60 8D 00 80            NEG   128,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 8D 00 80            NEG   128,PCR", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testNEGIndexedRelatifToPCMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-32768,PCR  ; 8000   	60 8D 80 00            NEG   -32768,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 8D 80 00            NEG   -32768,PCR", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testNEGIndexedRelatifToPCMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	32767,PCR  ; 8000   	60 8D 7F FF            NEG   32767,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 8D 7F FF            NEG   32767,PCR", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testNEGIndexedRelatifToPCMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	-32769,PCR  ; 8000   	60 8D 80 00            NEG   -32769,PCR
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value -32769 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 8D 80 00            NEG   -32769,PCR", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testNEGIndexedRelatifToPCMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	32768,PCR  ; 8000   	60 8D 7F FF            NEG   32768,PCR
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value 32768 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 8D 7F FF            NEG   32768,PCR", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testNEGIndexedRelatifIndirectToPCMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[0,PCR]  ; 8000   	60 9C 00            NEG   [0,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 9C 00            NEG   [0,PCR]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testNEGIndexedRelatifIndirectToPCMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-128,PCR]  ; 8000   	60 9C 80            NEG   [-128,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 9C 80            NEG   [-128,PCR]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testNEGIndexedRelatifIndirectToPCMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[127,PCR]  ; 8000   	60 9C 7F            NEG   [127,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 9C 7F            NEG   [127,PCR]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testNEGIndexedRelatifIndirectToPCMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-129,PCR]  ; 8000   	60 9D FF 7F            NEG   [-129,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 9D FF 7F            NEG   [-129,PCR]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testNEGIndexedRelatifIndirectToPCMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[128,PCR]  ; 8000   	60 9D 00 80            NEG   [128,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 9D 00 80            NEG   [128,PCR]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testNEGIndexedRelatifIndirectToPCMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-32768,PCR]  ; 8000   	60 9D 80 00            NEG   [-32768,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 9D 80 00            NEG   [-32768,PCR]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testNEGIndexedRelatifIndirectToPCMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[32767,PCR]  ; 8000   	60 9D 7F FF            NEG   [32767,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 9D 7F FF            NEG   [32767,PCR]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testNEGIndexedRelatifIndirectToPCMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[-32769,PCR]  ; 8000   	60 9D 80 00            NEG   [-32769,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value -32769 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 9D 80 00            NEG   [-32769,PCR]", line.comment)	
	}

	/**
	 * Check Assembled NEG Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testNEGIndexedRelatifIndirectToPCMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	NEG		  	[32768,PCR]  ; 8000   	60 9D 7F FF            NEG   [32768,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.negInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value 32768 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledNEGInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x60, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	60 9D 7F FF            NEG   [32768,PCR]", line.comment)	
	}
}