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
import org.bpy.electronics.mc6809.assembler.assembler.CmpInstruction
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
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCMPUInstruction
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestCMPUInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check CMPU immediat 
	 */
	@Test 
	def void testCMPUImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       CMPU		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an CMPU directive line", instructionLine.instruction instanceof CmpInstruction)

		val addInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPU instruction", addInstruction.instruction,"CMPU")
		assertTrue("Must be an immediate addressing mode", addInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check CMPU direct mode 
	 */
	@Test 
	def void testCMPUDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       CMPU		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an CMPU directive line", instructionLine.instruction instanceof CmpInstruction)

		val addInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPU instruction", addInstruction.instruction,"CMPU")
		assertTrue("Must be a direct addressing mode", addInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check CMPU extended mode 
	 */
	@Test 
	def void testCMPUExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       CMPU		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an CMPU directive line", instructionLine.instruction instanceof CmpInstruction)

		val addInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPU instruction", addInstruction.instruction,"CMPU")
		assertTrue("Must be a extended addressing mode", addInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check CMPU extended mode 
	 */
	@Test 
	def void testCMPUExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       CMPU		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an CMPU directive line", instructionLine.instruction instanceof CmpInstruction)

		val addInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPU instruction", addInstruction.instruction,"CMPU")
		assertTrue("Must be a extended addressing mode", addInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check CMPU extended indirect mode 
	 */
	@Test 
	def void testCMPUExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       CMPU		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an CMPU directive line", instructionLine.instruction instanceof CmpInstruction)

		val addInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPU instruction", addInstruction.instruction,"CMPU")
		assertTrue("Must be a extended indirect addressing mode", addInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check CMPU Constant-Offset Indexed 
	 */
	@Test 
	def void testCMPUConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPU		  	Const,X
					CMPU		  	,X
					CMPU		  	$9,U
					CMPU		  	$9,S
					CMPU		  	$9,X
					CMPU		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an CMPU directive line", instructionLine.instruction instanceof CmpInstruction)

		val addInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPU instruction", addInstruction.instruction,"CMPU")
		assertTrue("Must be a Constant-Offset Indexed mode", addInstruction.operand instanceof IndexedOperand)
		val indexedOperand = addInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check CMPU Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testCMPUConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPU		  	[Const,X]
					CMPU		  	[,X]
					CMPU		  	[$9,U]
					CMPU		  	[$9,S]
					CMPU		  	[$9,X]
					CMPU		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an CMPU directive line", instructionLine.instruction instanceof CmpInstruction)

		val addInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPU instruction", addInstruction.instruction,"CMPU")
		assertTrue("Must be a Constant-Offset Indexed mode", addInstruction.operand instanceof IndexedOperand)
		val indexedOperand = addInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check CMPU Accumulator Indexed 
	 */
	@Test 
	def void testCMPUAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPU		  	A,X
					CMPU		  	B,X
					CMPU		  	D,U
					CMPU		  	A,S
					CMPU		  	B,X
					CMPU		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an CMPU directive line", instructionLine.instruction instanceof CmpInstruction)

		val addInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPU instruction", addInstruction.instruction,"CMPU")
		assertTrue("Must be a Constant-Offset Indexed mode", addInstruction.operand instanceof IndexedOperand)
		val indexedOperand = addInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check CMPU Accumulator Indexed Indirect
	 */
	@Test 
	def void testCMPUAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPU		  	[A,X]
					CMPU		  	[B,X]
					CMPU		  	[D,U]
					CMPU		  	[A,S]
					CMPU		  	[B,X]
					CMPU		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an CMPU directive line", instructionLine.instruction instanceof CmpInstruction)

		val addInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPU instruction", addInstruction.instruction,"CMPU")
		assertTrue("Must be a Constant-Offset Indexed mode", addInstruction.operand instanceof IndexedOperand)
		val indexedOperand = addInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check CMPU Auto-Increment Indexed 
	 */
	@Test 
	def void testCMPUAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPU		  	,--X
			       	CMPU		  	,-X
			       	CMPU		  	,X+
			       	CMPU		  	,X++
			       	CMPU		  	,--S
			       	CMPU		  	,-S
			       	CMPU		  	,U+
			       	CMPU		  	,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an CMPU directive line", instructionLine.instruction instanceof CmpInstruction)

		val addInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPU instruction", addInstruction.instruction,"CMPU")
		assertTrue("Must be a Constant-Offset Indexed mode", addInstruction.operand instanceof IndexedOperand)
		val indexedOperand = addInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check CMPU Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testCMPUAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPU		  	[,--X]
			       	CMPU		  	[,X++]
			       	CMPU		  	[,--S]
			       	CMPU		  	[,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an CMPU directive line", instructionLine.instruction instanceof CmpInstruction)

		val addInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPU instruction", addInstruction.instruction,"CMPU")
		assertTrue("Must be a Constant-Offset Indexed mode", addInstruction.operand instanceof IndexedOperand)
		val indexedOperand = addInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check CMPU Relative to PC Indexed 
	 */
	@Test 
	def void testCMPURelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPU		  	0,PC
			       	CMPU		  	,PC
			       	CMPU		  	Const,PC
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an CMPU directive line", instructionLine.instruction instanceof CmpInstruction)

		val addInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPU instruction", addInstruction.instruction,"CMPU")
		assertTrue("Must be a Constant-Offset Indexed mode", addInstruction.operand instanceof IndexedOperand)
		val indexedOperand = addInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check CMPU Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testCMPURelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	CMPU		  	[0,PC]
			       	CMPU		  	[,PC]
			       	CMPU		  	[Const,PC]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an CMPU directive line", instructionLine.instruction instanceof CmpInstruction)

		val addInstruction = instructionLine.instruction as CmpInstruction
		assertEquals("Must be an CMPU instruction", addInstruction.instruction,"CMPU")
		assertTrue("Must be a Constant-Offset Indexed mode", addInstruction.operand instanceof IndexedOperand)
		val indexedOperand = addInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
	
	/**
	 * Check CMPU instruction with duplicate label 
	 */
	@Test 
	def void testCMPUWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start		NOP
					NOP    
		Start      	CMPU		  	#Const+2
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.instructionLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"Label Start is already defined"
		)
	}
	
	/**
	 * Check Assembled CMPU immediate instruction  
	 */
	@Test 
	def void testCMPUImmediatInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	#Const+2  ; 8000   11 83 07        START:    CMPU
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0x83, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x07, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   11 83 07        START:    CMPU", line.comment)	
	}
	
	/**
	 * Check Assembled CMPU immediate with limit negative operand  
	 */
	@Test 
	def void testCMPUImmediatInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	#-32769
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.cmpInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check operand", 0x8000, line.operand.get(0));
	}
	
	/**
	 * Check Assembled CMPU immediate with limit negative operand  
	 */
	@Test 
	def void testCMPUImmediatInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	#-32768
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check operand", 0x8000, line.operand.get(0));
	}

	/**
	 * Check Assembled CMPU immediate with positive limit operand  
	 */
	@Test 
	def void testCMPUImmediatInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	#32767
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check operand", 0x7FFF, line.operand.get(0));
	}

	/**
	 * Check Assembled CMPU immediate with positive limit operand  
	 */
	@Test 
	def void testCMPUImmediatInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	#32768
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.cmpInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 32768 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check operand", 0x7FFF, line.operand.get(0));
	}
	
	/**
	 * Check Assembled CMPU direct mode instruction  
	 */
	@Test 
	def void testCMPUDirectInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	<Const*2  ; 8000   11 93 0A        START:    CMPU   <Const*2 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0x93, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x0A, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   11 93 0A        START:    CMPU   <Const*2 ", line.comment)	
	}
	
	/**
	 * Check Assembled CMPU direct with limit negative operand  
	 */
	@Test 
	def void testCMPUDirectInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	<-129
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.cmpInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -129 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}
	
	/**
	 * Check Assembled CMPU direct with limit negative operand  
	 */
	@Test 
	def void testCMPUDirectInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	<-128
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}

	/**
	 * Check Assembled CMPU direct with positive limit operand  
	 */
	@Test 
	def void testCMPUDirectInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	<127
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}

	/**
	 * Check Assembled CMPU direct with positive limit operand  
	 */
	@Test 
	def void testCMPUDirectInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	<128
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.cmpInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 128 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}
	
	/**
	 * Check Assembled CMPU extended mode instruction  
	 */
	@Test 
	def void testCMPUExtendedInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	>Const*1000  ; 8000   11 B3 13 88     START:    CMPU   >Const*1000 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xB3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   11 B3 13 88     START:    CMPU   >Const*1000 ", line.comment)	
	}
	
	/**
	 * Check Assembled CMPU extended with limit negative operand  
	 */
	@Test 
	def void testCMPUExtendedInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	>-32769
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.cmpInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}
	
	/**
	 * Check Assembled CMPU extended with limit negative operand  
	 */
	@Test 
	def void testCMPUExtendedInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	>-32768
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}

	/**
	 * Check Assembled CMPU extended with positive limit operand  
	 */
	@Test 
	def void testCMPUExtendedInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	>65535
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}

	/**
	 * Check Assembled CMPU extended with positive limit operand  
	 */
	@Test 
	def void testCMPUExtendedInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	>65536
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.cmpInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 65536 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}
	
	/**
	 * Check Assembled CMPU extended indirect mode instruction  
	 */
	@Test 
	def void testCMPUExtendedIndirectInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[Const*1000]  ; 8000   AB 9F 13 88  START:    CMPU   [Const*1000]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 3, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check opcode", 0x9F, line.opcode.get(2));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 9F 13 88  START:    CMPU   [Const*1000]", line.comment)	
	}
	
	/**
	 * Check Assembled CMPU extended indirect with limit negative operand  
	 */
	@Test 
	def void testCMPUExtendedIndirectInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-32769]
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.cmpInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}
	
	/**
	 * Check Assembled CMPU extended indirect with limit negative operand  
	 */
	@Test 
	def void testCMPUExtendedIndirectInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-32768]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}

	/**
	 * Check Assembled CMPU extended indirect with positive limit operand  
	 */
	@Test 
	def void testCMPUExtendedIndirectInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[65535]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}

	/**
	 * Check Assembled CMPU extended indirect with positive limit operand  
	 */
	@Test 
	def void testCMPUExtendedIndirectInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[65536]
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.cmpInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 65536 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}
	
	/**
	 * Check Assembled CMPU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAccumulatorMovingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	A,X  ; 8000   10 A3 86        START:    CMPU   A,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x86, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   10 A3 86        START:    CMPU   A,X", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAccumulatorMovingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	A,Y  ; 8000   	10 A3 A6        START:    CMPU   A,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 A6        START:    CMPU   A,Y", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAccumulatorMovingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	A,U  ; 8000   	10 A3 C6        START:    CMPU   A,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 C6        START:    CMPU   A,U", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAccumulatorMovingMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	A,S  ; 8000   	10 A3 E6        START:    CMPU   A,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 E6        START:    CMPU   A,S", line.comment)	
	}
	
	/**
	 * Check Assembled CMPU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAccumulatorMovingMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	B,X  ; 8000   AB 85        START:    CMPU   B,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x85, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 85        START:    CMPU   B,X", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAccumulatorMovingMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	B,Y  ; 8000   	10 A3 A5        START:    CMPU   B,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 A5        START:    CMPU   B,Y", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAccumulatorMovingMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	B,U  ; 8000   	10 A3 C5        START:    CMPU   B,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 C5        START:    CMPU   B,U", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAccumulatorMovingMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	B,S  ; 8000   	10 A3 E5        START:    CMPU   B,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 E5        START:    CMPU   B,S", line.comment)	
	}
	
	/**
	 * Check Assembled CMPU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAccumulatorMovingMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	D,X  ; 8000   AB 8B        START:    CMPU   D,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8B, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    CMPU   D,X", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAccumulatorMovingMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	D,Y  ; 8000   	10 A3 AB        START:    CMPU   D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xAB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 AB        START:    CMPU   D,Y", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAccumulatorMovingMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	D,U  ; 8000   	10 A3 CB        START:    CMPU   D,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xCB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 CB        START:    CMPU   D,U", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAccumulatorMovingMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	D,S  ; 8000   	10 A3 EB        START:    CMPU   D,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xEB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 EB        START:    CMPU   D,S", line.comment)	
	}
	
	/**
	 * Check Assembled CMPU Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedIndorectAccumulatorMovingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[A,X]  ; 8000   AB 96        START:    CMPU   [A,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x96, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 96        START:    CMPU   [A,X]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedIndirectAccumulatorMovingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[A,Y]  ; 8000   	10 A3 B6        START:    CMPU   [A,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 B6        START:    CMPU   [A,Y]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedIndirectAccumulatorMovingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[A,U]  ; 8000   	10 A3 D6        START:    CMPU   [A,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 D6        START:    CMPU   [A,U]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedIndirectAccumulatorMovingMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[A,S]  ; 8000   	10 A3 F6        START:    CMPU   [A,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 F6        START:    CMPU   [A,S]", line.comment)	
	}
	
	/**
	 * Check Assembled CMPU Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedIndirectAccumulatorMovingMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[B,X]  ; 8000   AB 95        START:    CMPU   [B,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x95, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 95        START:    CMPU   [B,X]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedIndirectAccumulatorMovingMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[B,Y]  ; 8000   	10 A3 B5        START:    CMPU   [B,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 B5        START:    CMPU   [B,Y]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedIndirectAccumulatorMovingMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[B,U]  ; 8000   	10 A3 D5        START:    CMPU   [B,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 D5        START:    CMPU   [B,U]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedIndirectAccumulatorMovingMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[B,S]  ; 8000   	10 A3 F5        START:    CMPU   [B,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 F5        START:    CMPU   [B,S]", line.comment)	
	}
	
	/**
	 * Check Assembled CMPU Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedIndirectAccumulatorMovingMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[D,X]  ; 8000   AB 9B        START:    CMPU   [D,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9B, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    CMPU   [D,X]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedIndirectAccumulatorMovingMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[D,Y]  ; 8000   	10 A3 BB        START:    CMPU   [D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xBB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 BB        START:    CMPU   [D,Y]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedIndirectAccumulatorMovingMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[D,U]  ; 8000   	10 A3 DB        START:    CMPU   [D,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xDB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 DB        START:    CMPU   [D,U]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedIndirectAccumulatorMovingMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[D,S]  ; 8000   	10 A3 FB        START:    CMPU   [D,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xFB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 FB        START:    CMPU   [D,S]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	,X+  ; 8000   	10 A3 80        START:    CMPU   ,X+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 80        START:    CMPU   ,X+", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	,X++  ; 8000   	10 A3 81        START:    CMPU   ,X++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x81, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 81        START:    CMPU   ,X++", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	,Y+  ; 8000   	10 A3 A0        START:    CMPU   ,Y+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 A0        START:    CMPU   ,Y+", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	,Y++  ; 8000   	10 A3 A1        START:    CMPU   ,Y++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 A1        START:    CMPU   ,Y++", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	,S+  ; 8000   	10 A3 E0        START:    CMPU   ,S+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 E0        START:    CMPU   ,S+", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	,S++  ; 8000   	10 A3 E1        START:    CMPU   ,S++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 E1        START:    CMPU   ,S++", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	,U+  ; 8000   	10 A3 C0        START:    CMPU   ,U+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 C0        START:    CMPU   ,U+", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	,U++  ; 8000   	10 A3 C1        START:    CMPU   ,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 C1        START:    CMPU   ,U++", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	,-X  ; 8000   	10 A3 82        START:    CMPU   ,-X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x82, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 82        START:    CMPU   ,-X", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	,--X  ; 8000   	10 A3 83        START:    CMPU   ,--X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x83, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 83        START:    CMPU   ,--X", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	,-Y  ; 8000   	10 A3 A2        START:    CMPU   ,-Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 A2        START:    CMPU   ,-Y", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	,--Y  ; 8000   	10 A3 A3        START:    CMPU   ,--Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 A3        START:    CMPU   ,--Y", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementMode13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	,-S  ; 8000   	10 A3 E2        START:    CMPU   ,-S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 E2        START:    CMPU   ,-S", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementMode14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	,--S  ; 8000   	10 A3 E3        START:    CMPU   ,--S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 E3        START:    CMPU   ,--S", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementMode15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	,-U  ; 8000   	10 A3 C2        START:    CMPU   ,-U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 C2        START:    CMPU   ,-U", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementMode16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	,--U  ; 8000   	10 A3 C3        START:    CMPU   ,--U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 C3        START:    CMPU   ,--U", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementIndirectMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[,X+]  ; 8000   	10 A3 80        START:    CMPU   ,X+
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Mode indorect instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementIndirectMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[,X++]  ; 8000   	10 A3 91        START:    CMPU   [,X++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x91, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 91        START:    CMPU   [,X++]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Mode indirect instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementIndirectMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[,Y+]  ; 8000   	10 A3 A0        START:    CMPU   ,Y+
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementIndirectMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[,Y++]  ; 8000   	10 A3 B1        START:    CMPU   [,Y++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 B1        START:    CMPU   [,Y++]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementIndirectMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[,S+]  ; 8000   	10 A3 E0        START:    CMPU   [,S+]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementIndirectMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[,S++]  ; 8000   	10 A3 F1        START:    CMPU   [,S++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 F1        START:    CMPU   [,S++]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementIndirectMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[,U+]  ; 8000   	10 A3 C0        START:    CMPU   [,U+]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementindirectMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[,U++]  ; 8000   	10 A3 D1        START:    CMPU   [,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 D1        START:    CMPU   [,U++]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementIndirectMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[,-X]  ; 8000   	10 A3 82        START:    CMPU   [,-X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementIndirectMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[,--X]  ; 8000   	10 A3 93        START:    CMPU   [,--X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x93, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 93        START:    CMPU   [,--X]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement INdirect Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementIndirectMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[,-Y]  ; 8000   	10 A3 A2        START:    CMPU   [,-Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementIndirectMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[,--Y]  ; 8000   	10 A3 B3        START:    CMPU   [,--Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 B3        START:    CMPU   [,--Y]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementIndirectMode13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[,-S]  ; 8000   	10 A3 E2        START:    CMPU   [,-S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementIndirectMode14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[,--S]  ; 8000   	10 A3 F3        START:    CMPU   [,--S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 F3        START:    CMPU   [,--S]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement indirect Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementIndirectMode15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[,-U]  ; 8000   	10 A3 C2        START:    CMPU   [,-U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled CMPU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedAutoIncrementDecrementIndirectMode16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	CMPU		  	[,--U]  ; 8000   	10 A3 D3        START:    CMPU   [,--U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 D3        START:    CMPU   [,--U]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	1234,X  ; 8000   	10 A3 89 04 D2            CMPU   1234,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 89 04 D2            CMPU   1234,X", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	1234,Y  ; 8000   	10 A3 A9 04 D2            CMPU   1234,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 A9 04 D2            CMPU   1234,Y", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	1234,U  ; 8000   	10 A3 C9 04 D2            CMPU   1234,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 C9 04 D2            CMPU   1234,U", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	1234,S  ; 8000   	10 A3 E9 04 D2            CMPU   1234,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 E9 04 D2            CMPU   1234,S", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	34,X  ; 8000   	10 A3 88 22            CMPU   34,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 88 22            CMPU   34,X", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	34,Y  ; 8000   	10 A3 A8 22            CMPU   34,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 A8 22            CMPU   34,Y", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	34,U  ; 8000   	10 A3 C8 22            CMPU   34,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 C8 22            CMPU   34,U", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	34,S  ; 8000   	10 A3 E8 22            CMPU   34,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 E8 22            CMPU   34,S", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	,X  ; 8000   	10 A3 84            CMPU   ,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 84            CMPU   ,X", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	,Y  ; 8000   	10 A3 A4            CMPU   ,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 A4            CMPU   ,Y", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	,U  ; 8000   	10 A3 C4            CMPU   ,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 C4            CMPU   ,U", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	,S  ; 8000   	10 A3 E4            CMPU   ,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 E4            CMPU   ,S", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	0,X  ; 8000   	10 A3 84            CMPU   0,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 84            CMPU   0,X", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	0,Y  ; 8000   	10 A3 A4            CMPU   0,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 A4            CMPU   0,Y", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	0,U  ; 8000   	10 A3 C4            CMPU   0,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 C4            CMPU   0,U", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	0,S  ; 8000   	10 A3 E4            CMPU   0,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 E4            CMPU   0,S", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove17() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-16,X  ; 8000   	10 A3 10            CMPU   -16,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x10, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 10            CMPU   -16,X", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove19() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	1,X  ; 8000   	10 A3 01            CMPU   1,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x01, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 01            CMPU   1,X", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove20() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	15,X  ; 8000   	10 A3 0F            CMPU   15,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 0F            CMPU   15,X", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove21() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-16,Y  ; 8000   	10 A3 30            CMPU   -16,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x30, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 30            CMPU   -16,Y", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove23() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	1,Y  ; 8000   	10 A3 21            CMPU   1,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x21, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 21            CMPU   1,Y", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove24() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	15,Y  ; 8000   	10 A3 2F            CMPU   15,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x2F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 2F            CMPU   15,Y", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove25() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-16,U  ; 8000   	10 A3 50            CMPU   -16,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x50, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 50            CMPU   -16,U", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove26() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	1,U  ; 8000   	10 A3 41            CMPU   1,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x41, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 41            CMPU   1,U", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove27() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	15,U  ; 8000   	10 A3 4F            CMPU   15,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x4F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 4F            CMPU   15,U", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove28() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-16,S  ; 8000   	10 A3 70            CMPU   -16,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x70, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 70            CMPU   -16,S", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove29() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	1,S  ; 8000   	10 A3 61            CMPU   1,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x61, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 61            CMPU   1,S", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove30() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	15,S  ; 8000   	10 A3 6F            CMPU   15,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x6F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 6F            CMPU   15,S", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove31() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-128,X  ; 8000   	10 A3 88 80            CMPU   -128,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 88 80            CMPU   -128,X", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove32() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	127,X  ; 8000   	10 A3 88 7F            CMPU   127,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 88 7F            CMPU   127,X", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove33() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-128,Y  ; 8000   	10 A3 A8 80            CMPU   -128,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 A8 80            CMPU   -128,Y", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove34() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	127,Y  ; 8000   	10 A3 A8 7F            CMPU   127,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 A8 7F            CMPU   127,Y", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove35() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-128,U  ; 8000   	10 A3 C8 80            CMPU   -128,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 C8 80            CMPU   -128,U", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove36() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	127,U  ; 8000   	10 A3 C8 7F            CMPU   127,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 C8 7F            CMPU   127,U", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove37() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-128,S  ; 8000   	10 A3 E8 80            CMPU   -128,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 E8 80            CMPU   -128,S", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove38() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	127,S  ; 8000   	10 A3 E8 7F            CMPU   127,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 E8 7F            CMPU   127,S", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove39() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-32768,X  ; 8000   	10 A3 89 80 00             CMPU   -32768,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 89 80 00             CMPU   -32768,X", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove40() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  32767,X  ; 8000   	10 A3 89 7F FF             CMPU   32767,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 89 7F FF             CMPU   32767,X", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove41() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-32768,Y  ; 8000   	10 A3 A9 80 00             CMPU   -32768,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 A9 80 00             CMPU   -32768,Y", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove42() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  32767,Y  ; 8000   	10 A3 A9 7F FF             CMPU   32767,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 A9 7F FF             CMPU   32767,Y", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove43() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-32768,U  ; 8000   	10 A3 C9 80 00             CMPU   -32768,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 C9 80 00             CMPU   -32768,U", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove44() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  32767,U  ; 8000   	10 A3 C9 7F FF             CMPU   32767,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 C9 7F FF             CMPU   32767,U", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove45() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-32768,S  ; 8000   	10 A3 E9 80 00             CMPU   -32768,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 E9 80 00             CMPU   -32768,S", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove46() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  32767,S  ; 8000   	10 A3 E9 7F FF             CMPU   32767,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 E9 7F FF             CMPU   32767,S", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove47() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-32769,X  ; 8000   	10 A3 89 80 00             CMPU   -32769,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 89 80 00             CMPU   -32769,X", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove48() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  32768,X  ; 8000   	10 A3 89 7F FF             CMPU   32768,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 89 7F FF             CMPU   32768,X", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove49() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-32769,Y  ; 8000   	10 A3 A9 80 00             CMPU   -32769,Y
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 A9 80 00             CMPU   -32769,Y", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove50() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  32768,Y  ; 8000   	10 A3 A9 7F FF             CMPU   32768,Y
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 A9 7F FF             CMPU   32768,Y", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove51() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-32769,U  ; 8000   	10 A3 C9 80 00             CMPU   -32769,U
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 C9 80 00             CMPU   -32769,U", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove52() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  32768,U  ; 8000   	10 A3 C9 7F FF             CMPU   32768,U
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 C9 7F FF             CMPU   32768,U", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove53() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-32769,S  ; 8000   	10 A3 E9 80 00             CMPU   -32769,S
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 E9 80 00             CMPU   -32769,S", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantMove54() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  32768,S  ; 8000   	10 A3 E9 7F FF             CMPU   32768,S
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 E9 7F FF             CMPU   32768,S", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[1234,X]  ; 8000   	10 A3 99 04 D2            CMPU   [1234,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 99 04 D2            CMPU   [1234,X]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[1234,Y]  ; 8000   	10 A3 B9 04 D2            CMPU   [1234,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 B9 04 D2            CMPU   [1234,Y]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[1234,U]  ; 8000   	10 A3 D9 04 D2            CMPU   [1234,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 D9 04 D2            CMPU   [1234,U]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[1234,S]  ; 8000   	10 A3 F9 04 D2            CMPU   [1234,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 F9 04 D2            CMPU   [1234,S]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[34,X]  ; 8000   	10 A3 98 22            CMPU   [34,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 98 22            CMPU   [34,X]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[34,Y]  ; 8000   	10 A3 B8 22            CMPU   [34,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 B8 22            CMPU   [34,Y]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[34,U]  ; 8000   	10 A3 D8 22            CMPU   [34,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 D8 22            CMPU   [34,U]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[34,S]  ; 8000   	10 A3 F8 22            CMPU   [34,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 F8 22            CMPU   [34,S]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[,X]  ; 8000   	10 A3 94            CMPU   [,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 94            CMPU   [,X]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[,Y]  ; 8000   	10 A3 B4            CMPU   [,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 B4            CMPU   [,Y]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[,U]  ; 8000   	10 A3 D4            CMPU   [,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 D4            CMPU   [,U]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[,S]  ; 8000   	10 A3 F4            CMPU   [,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 F4            CMPU   [,S]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[0,X]  ; 8000   	10 A3 94            CMPU   [0,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 94            CMPU   [0,X]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[0,Y]  ; 8000   	10 A3 B4            CMPU   [0,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 B4            CMPU   [0,Y]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[0,U]  ; 8000   	10 A3 D4            CMPU   [0,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 D4            CMPU   [0,U]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[0,S]  ; 8000   	10 A3 F4            CMPU   [0,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 F4            CMPU   [0,S]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove17() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-16,X]  ; 8000   	10 A3 98 F0            CMPU   [-16,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 98 F0            CMPU   [-16,X]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove18() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[15,X]  ; 8000   	10 A3 98 0F            CMPU   [15,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 98 0F            CMPU   [15,X]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove19() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-16,Y]  ; 8000   	10 A3 B8 F0            CMPU   [-16,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 B8 F0            CMPU   [-16,Y]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove20() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[15,Y]  ; 8000   	10 A3 B8 0F            CMPU   [15,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 B8 0F            CMPU   [15,Y]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove21() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-16,U]  ; 8000   	10 A3 D8 F0            CMPU   [-16,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 D8 F0            CMPU   [-16,U]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove22() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[15,U]  ; 8000   	10 A3 D8 0F            CMPU   [15,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 D8 0F            CMPU   [15,U]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove23() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-16,S]  ; 8000   	10 A3 F8 F0            CMPU   [-16,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 F8 F0            CMPU   [-16,S]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove24() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[15,S]  ; 8000   	10 A3 F8 0F            CMPU   [15,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 F8 0F            CMPU   [15,S]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove31() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-128,X]  ; 8000   	10 A3 98 80            CMPU   [-128,X}
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 98 80            CMPU   [-128,X}", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove32() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[127,X]  ; 8000   	10 A3 98 7F            CMPU   [127,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 98 7F            CMPU   [127,X]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove33() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-128,Y]  ; 8000   	10 A3 B8 80            CMPU   [-128,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 B8 80            CMPU   [-128,Y]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove34() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[127,Y]  ; 8000   	10 A3 B8 7F            CMPU   [127,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 B8 7F            CMPU   [127,Y]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove35() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-128,U]  ; 8000   	10 A3 D8 80            CMPU   [-128,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 D8 80            CMPU   [-128,U]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant INdirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove36() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[127,U]  ; 8000   	10 A3 D8 7F            CMPU   [127,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 D8 7F            CMPU   [127,U]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove37() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-128,S]  ; 8000   	10 A3 F8 80            CMPU   [-128,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 F8 80            CMPU   [-128,S]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove38() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[127,S]  ; 8000   	10 A3 F8 7F            CMPU   [127,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 F8 7F            CMPU   [127,S]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove39() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-32768,X]  ; 8000   	10 A3 99 80 00             CMPU   [-32768,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 99 80 00             CMPU   [-32768,X]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove40() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  [32767,X]  ; 8000   	10 A3 99 7F FF             CMPU   [32767,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 99 7F FF             CMPU   [32767,X]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove41() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-32768,Y]  ; 8000   	10 A3 B9 80 00             CMPU   [-32768,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 B9 80 00             CMPU   [-32768,Y]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove42() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  [32767,Y]  ; 8000   	10 A3 B9 7F FF             CMPU   [32767,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 B9 7F FF             CMPU   [32767,Y]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove43() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-32768,U]  ; 8000   	10 A3 D9 80 00             CMPU   [-32768,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 D9 80 00             CMPU   [-32768,U]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove44() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  [32767,U]  ; 8000   	10 A3 D9 7F FF             CMPU   [32767,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 D9 7F FF             CMPU   [32767,U]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove45() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-32768,S]  ; 8000   	10 A3 F9 80 00             CMPU   [-32768,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 F9 80 00             CMPU   [-32768,S]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove46() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  [32767,S]  ; 8000   	10 A3 F9 7F FF             CMPU   [32767,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 F9 7F FF             CMPU   [32767,S]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove47() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-32769,X]  ; 8000   	10 A3 99 80 00             CMPU   [-32769,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 99 80 00             CMPU   [-32769,X]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove48() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  [32768,X]  ; 8000   	10 A3 99 7F FF             CMPU   [32768,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 99 7F FF             CMPU   [32768,X]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove49() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-32769,Y]  ; 8000   	10 A3 B9 80 00             CMPU   [-32769,Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 B9 80 00             CMPU   [-32769,Y]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove50() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  [32768,Y]  ; 8000   	10 A3 B9 7F FF             CMPU   [32768,Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 B9 7F FF             CMPU   [32768,Y]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove51() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-32769,U]  ; 8000   	10 A3 D9 80 00             CMPU   [-32769,U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 D9 80 00             CMPU   [-32769,U]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove52() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  [32768,U]  ; 8000   	10 A3 D9 7F FF             CMPU   [32768,U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 D9 7F FF             CMPU   [32768,U]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove53() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-32769,S]  ; 8000   	10 A3 F9 80 00             CMPU   [-32769,S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 F9 80 00             CMPU   [-32769,S]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedConstantIndirectMove54() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  [32768,S]  ; 8000   	10 A3 F9 7F FF             CMPU   [32768,S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 F9 7F FF             CMPU   [32768,S]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedRelatifToPCMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	0,PCR  ; 8000   	10 A3 8C 00            CMPU   0,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 8C 00            CMPU   0,PCR", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedRelatifToPCMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-128,PCR  ; 8000   	10 A3 8C 80            CMPU   -128,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 8C 80            CMPU   -128,PCR", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedRelatifToPCMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	127,PCR  ; 8000   	10 A3 8C 7F            CMPU   127,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 8C 7F            CMPU   127,PCR", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedRelatifToPCMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-129,PCR  ; 8000   	10 A3 8D FF 7F            CMPU   -129,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 8D FF 7F            CMPU   -129,PCR", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedRelatifToPCMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	128,PCR  ; 8000   	10 A3 8D 00 80            CMPU   128,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 8D 00 80            CMPU   128,PCR", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedRelatifToPCMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-32768,PCR  ; 8000   	10 A3 8D 80 00            CMPU   -32768,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 8D 80 00            CMPU   -32768,PCR", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedRelatifToPCMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	32767,PCR  ; 8000   	10 A3 8D 7F FF            CMPU   32767,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 8D 7F FF            CMPU   32767,PCR", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedRelatifToPCMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	-32769,PCR  ; 8000   	10 A3 8D 80 00            CMPU   -32769,PCR
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value -32769 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 8D 80 00            CMPU   -32769,PCR", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedRelatifToPCMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	32768,PCR  ; 8000   	10 A3 8D 7F FF            CMPU   32768,PCR
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value 32768 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 8D 7F FF            CMPU   32768,PCR", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedRelatifIndirectToPCMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[0,PCR]  ; 8000   	10 A3 9C 00            CMPU   [0,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 9C 00            CMPU   [0,PCR]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedRelatifIndirectToPCMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-128,PCR]  ; 8000   	10 A3 9C 80            CMPU   [-128,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 9C 80            CMPU   [-128,PCR]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedRelatifIndirectToPCMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[127,PCR]  ; 8000   	10 A3 9C 7F            CMPU   [127,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 9C 7F            CMPU   [127,PCR]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedRelatifIndirectToPCMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-129,PCR]  ; 8000   	10 A3 9D FF 7F            CMPU   [-129,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 9D FF 7F            CMPU   [-129,PCR]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedRelatifIndirectToPCMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[128,PCR]  ; 8000   	10 A3 9D 00 80            CMPU   [128,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 9D 00 80            CMPU   [128,PCR]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedRelatifIndirectToPCMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-32768,PCR]  ; 8000   	10 A3 9D 80 00            CMPU   [-32768,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 9D 80 00            CMPU   [-32768,PCR]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedRelatifIndirectToPCMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[32767,PCR]  ; 8000   	10 A3 9D 7F FF            CMPU   [32767,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 9D 7F FF            CMPU   [32767,PCR]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedRelatifIndirectToPCMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[-32769,PCR]  ; 8000   	10 A3 9D 80 00            CMPU   [-32769,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value -32769 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 9D 80 00            CMPU   [-32769,PCR]", line.comment)	
	}

	/**
	 * Check Assembled CMPU Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testCMPUIndexedRelatifIndirectToPCMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	CMPU		  	[32768,PCR]  ; 8000   	10 A3 9D 7F FF            CMPU   [32768,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.cmpInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value 32768 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledCMPUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x11, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xA3, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 A3 9D 7F FF            CMPU   [32768,PCR]", line.comment)	
	}
}