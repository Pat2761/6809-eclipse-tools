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
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLDUInstruction
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestLDUInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check LDU immediat 
	 */
	@Test 
	def void testLDUImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDU		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDU directive line", instructionLine.instruction instanceof LdInstruction)

		val addInstruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDU instruction", addInstruction.instruction,"LDU")
		assertTrue("Must be an immediate addressing mode", addInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check LDU direct mode 
	 */
	@Test 
	def void testLDUDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDU		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDU directive line", instructionLine.instruction instanceof LdInstruction)

		val addInstruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDU instruction", addInstruction.instruction,"LDU")
		assertTrue("Must be a direct addressing mode", addInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check LDU extended mode 
	 */
	@Test 
	def void testLDUExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDU		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDU directive line", instructionLine.instruction instanceof LdInstruction)

		val addInstruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDU instruction", addInstruction.instruction,"LDU")
		assertTrue("Must be a extended addressing mode", addInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDU extended mode 
	 */
	@Test 
	def void testLDUExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDU		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDU directive line", instructionLine.instruction instanceof LdInstruction)

		val addInstruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDU instruction", addInstruction.instruction,"LDU")
		assertTrue("Must be a extended addressing mode", addInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDU extended indirect mode 
	 */
	@Test 
	def void testLDUExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDU		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDU directive line", instructionLine.instruction instanceof LdInstruction)

		val addInstruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDU instruction", addInstruction.instruction,"LDU")
		assertTrue("Must be a extended indirect addressing mode", addInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check LDU Constant-Offset Indexed 
	 */
	@Test 
	def void testLDUConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDU		  	Const,X
					LDU		  	,X
					LDU		  	$9,U
					LDU		  	$9,S
					LDU		  	$9,X
					LDU		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDU directive line", instructionLine.instruction instanceof LdInstruction)

		val addInstruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDU instruction", addInstruction.instruction,"LDU")
		assertTrue("Must be a Constant-Offset Indexed mode", addInstruction.operand instanceof IndexedOperand)
		val indexedOperand = addInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check LDU Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testLDUConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDU		  	[Const,X]
					LDU		  	[,X]
					LDU		  	[$9,U]
					LDU		  	[$9,S]
					LDU		  	[$9,X]
					LDU		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDU directive line", instructionLine.instruction instanceof LdInstruction)

		val addInstruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDU instruction", addInstruction.instruction,"LDU")
		assertTrue("Must be a Constant-Offset Indexed mode", addInstruction.operand instanceof IndexedOperand)
		val indexedOperand = addInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check LDU Accumulator Indexed 
	 */
	@Test 
	def void testLDUAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDU		  	A,X
					LDU		  	B,X
					LDU		  	D,U
					LDU		  	A,S
					LDU		  	B,X
					LDU		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDU directive line", instructionLine.instruction instanceof LdInstruction)

		val addInstruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDU instruction", addInstruction.instruction,"LDU")
		assertTrue("Must be a Constant-Offset Indexed mode", addInstruction.operand instanceof IndexedOperand)
		val indexedOperand = addInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check LDU Accumulator Indexed Indirect
	 */
	@Test 
	def void testLDUAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDU		  	[A,X]
					LDU		  	[B,X]
					LDU		  	[D,U]
					LDU		  	[A,S]
					LDU		  	[B,X]
					LDU		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDU directive line", instructionLine.instruction instanceof LdInstruction)

		val addInstruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDU instruction", addInstruction.instruction,"LDU")
		assertTrue("Must be a Constant-Offset Indexed mode", addInstruction.operand instanceof IndexedOperand)
		val indexedOperand = addInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check LDU Auto-Increment Indexed 
	 */
	@Test 
	def void testLDUAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDU		  	,--X
			       	LDU		  	,-X
			       	LDU		  	,X+
			       	LDU		  	,X++
			       	LDU		  	,--S
			       	LDU		  	,-S
			       	LDU		  	,U+
			       	LDU		  	,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDU directive line", instructionLine.instruction instanceof LdInstruction)

		val addInstruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDU instruction", addInstruction.instruction,"LDU")
		assertTrue("Must be a Constant-Offset Indexed mode", addInstruction.operand instanceof IndexedOperand)
		val indexedOperand = addInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check LDU Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testLDUAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDU		  	[,--X]
			       	LDU		  	[,X++]
			       	LDU		  	[,--S]
			       	LDU		  	[,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDU directive line", instructionLine.instruction instanceof LdInstruction)

		val addInstruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDU instruction", addInstruction.instruction,"LDU")
		assertTrue("Must be a Constant-Offset Indexed mode", addInstruction.operand instanceof IndexedOperand)
		val indexedOperand = addInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check LDU Relative to PC Indexed 
	 */
	@Test 
	def void testLDURelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDU		  	0,PC
			       	LDU		  	,PC
			       	LDU		  	Const,PC
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDU directive line", instructionLine.instruction instanceof LdInstruction)

		val addInstruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDU instruction", addInstruction.instruction,"LDU")
		assertTrue("Must be a Constant-Offset Indexed mode", addInstruction.operand instanceof IndexedOperand)
		val indexedOperand = addInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check LDU Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testLDURelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDU		  	[0,PC]
			       	LDU		  	[,PC]
			       	LDU		  	[Const,PC]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDU directive line", instructionLine.instruction instanceof LdInstruction)

		val addInstruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDU instruction", addInstruction.instruction,"LDU")
		assertTrue("Must be a Constant-Offset Indexed mode", addInstruction.operand instanceof IndexedOperand)
		val indexedOperand = addInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
	
	/**
	 * Check LDU instruction with duplicate label 
	 */
	@Test 
	def void testLDUWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start		NOP
					NOP    
		Start      	LDU		  	#Const+2
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.instructionLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"Label Start is already defined"
		)
	}
	
	/**
	 * Check Assembled LDU immediate instruction  
	 */
	@Test 
	def void testLDUImmediatInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	#Const+2  ; 8000   CE 07        START:    LDU
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xCE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x07, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   CE 07        START:    LDU", line.comment)	
	}
	
	/**
	 * Check Assembled LDU immediate with limit negative operand  
	 */
	@Test 
	def void testLDUImmediatInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	#-32769
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check operand", 0x8000, line.operand.get(0));
	}
	
	/**
	 * Check Assembled LDU immediate with limit negative operand  
	 */
	@Test 
	def void testLDUImmediatInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	#-32768
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check operand", 0x8000, line.operand.get(0));
	}

	/**
	 * Check Assembled LDU immediate with positive limit operand  
	 */
	@Test 
	def void testLDUImmediatInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	#32767
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check operand", 0x7FFF, line.operand.get(0));
	}

	/**
	 * Check Assembled LDU immediate with positive limit operand  
	 */
	@Test 
	def void testLDUImmediatInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	#32768
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 32768 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check operand", 0x7FFF, line.operand.get(0));
	}
	
	/**
	 * Check Assembled LDU direct mode instruction  
	 */
	@Test 
	def void testLDUDirectInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	<Const*2  ; 8000   DE 0A        START:    LDU   <Const*2 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xDE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x0A, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   DE 0A        START:    LDU   <Const*2 ", line.comment)	
	}
	
	/**
	 * Check Assembled LDU direct with limit negative operand  
	 */
	@Test 
	def void testLDUDirectInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	<-129
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -129 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}
	
	/**
	 * Check Assembled LDU direct with limit negative operand  
	 */
	@Test 
	def void testLDUDirectInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	<-128
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}

	/**
	 * Check Assembled LDU direct with positive limit operand  
	 */
	@Test 
	def void testLDUDirectInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	<127
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}

	/**
	 * Check Assembled LDU direct with positive limit operand  
	 */
	@Test 
	def void testLDUDirectInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	<128
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 128 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}
	
	/**
	 * Check Assembled LDU extended mode instruction  
	 */
	@Test 
	def void testLDUExtendedInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	>Const*1000  ; 8000   FE 13 88     START:    LDU   >Const*1000 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xFE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   FE 13 88     START:    LDU   >Const*1000 ", line.comment)	
	}
	
	/**
	 * Check Assembled LDU extended with limit negative operand  
	 */
	@Test 
	def void testLDUExtendedInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	>-32769
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}
	
	/**
	 * Check Assembled LDU extended with limit negative operand  
	 */
	@Test 
	def void testLDUExtendedInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	>-32768
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}

	/**
	 * Check Assembled LDU extended with positive limit operand  
	 */
	@Test 
	def void testLDUExtendedInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	>65535
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}

	/**
	 * Check Assembled LDU extended with positive limit operand  
	 */
	@Test 
	def void testLDUExtendedInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	>65536
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 65536 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}
	
	/**
	 * Check Assembled LDU extended indirect mode instruction  
	 */
	@Test 
	def void testLDUExtendedIndirectInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[Const*1000]  ; 8000   AB 9F 13 88  START:    LDU   [Const*1000]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0x9F, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 9F 13 88  START:    LDU   [Const*1000]", line.comment)	
	}
	
	/**
	 * Check Assembled LDU extended indirect with limit negative operand  
	 */
	@Test 
	def void testLDUExtendedIndirectInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-32769]
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}
	
	/**
	 * Check Assembled LDU extended indirect with limit negative operand  
	 */
	@Test 
	def void testLDUExtendedIndirectInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-32768]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}

	/**
	 * Check Assembled LDU extended indirect with positive limit operand  
	 */
	@Test 
	def void testLDUExtendedIndirectInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[65535]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}

	/**
	 * Check Assembled LDU extended indirect with positive limit operand  
	 */
	@Test 
	def void testLDUExtendedIndirectInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[65536]
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 65536 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}
	
	/**
	 * Check Assembled LDU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAccumulatorMovingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	A,X  ; 8000   AB 86        START:    LDU   A,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x86, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 86        START:    LDU   A,X", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAccumulatorMovingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	A,Y  ; 8000   	EE A6        START:    LDU   A,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE A6        START:    LDU   A,Y", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAccumulatorMovingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	A,U  ; 8000   	EE C6        START:    LDU   A,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE C6        START:    LDU   A,U", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAccumulatorMovingMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	A,S  ; 8000   	EE E6        START:    LDU   A,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE E6        START:    LDU   A,S", line.comment)	
	}
	
	/**
	 * Check Assembled LDU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAccumulatorMovingMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	B,X  ; 8000   AB 85        START:    LDU   B,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x85, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 85        START:    LDU   B,X", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAccumulatorMovingMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	B,Y  ; 8000   	EE A5        START:    LDU   B,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE A5        START:    LDU   B,Y", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAccumulatorMovingMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	B,U  ; 8000   	EE C5        START:    LDU   B,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE C5        START:    LDU   B,U", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAccumulatorMovingMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	B,S  ; 8000   	EE E5        START:    LDU   B,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE E5        START:    LDU   B,S", line.comment)	
	}
	
	/**
	 * Check Assembled LDU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAccumulatorMovingMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	D,X  ; 8000   AB 8B        START:    LDU   D,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8B, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    LDU   D,X", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAccumulatorMovingMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	D,Y  ; 8000   	EE AB        START:    LDU   D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xAB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE AB        START:    LDU   D,Y", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAccumulatorMovingMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	D,U  ; 8000   	EE CB        START:    LDU   D,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xCB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE CB        START:    LDU   D,U", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAccumulatorMovingMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	D,S  ; 8000   	EE EB        START:    LDU   D,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xEB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE EB        START:    LDU   D,S", line.comment)	
	}
	
	/**
	 * Check Assembled LDU Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedIndorectAccumulatorMovingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[A,X]  ; 8000   AB 96        START:    LDU   [A,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x96, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 96        START:    LDU   [A,X]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedIndirectAccumulatorMovingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[A,Y]  ; 8000   	EE B6        START:    LDU   [A,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE B6        START:    LDU   [A,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedIndirectAccumulatorMovingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[A,U]  ; 8000   	EE D6        START:    LDU   [A,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE D6        START:    LDU   [A,U]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedIndirectAccumulatorMovingMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[A,S]  ; 8000   	EE F6        START:    LDU   [A,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE F6        START:    LDU   [A,S]", line.comment)	
	}
	
	/**
	 * Check Assembled LDU Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedIndirectAccumulatorMovingMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[B,X]  ; 8000   AB 95        START:    LDU   [B,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x95, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 95        START:    LDU   [B,X]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedIndirectAccumulatorMovingMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[B,Y]  ; 8000   	EE B5        START:    LDU   [B,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE B5        START:    LDU   [B,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedIndirectAccumulatorMovingMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[B,U]  ; 8000   	EE D5        START:    LDU   [B,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE D5        START:    LDU   [B,U]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedIndirectAccumulatorMovingMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[B,S]  ; 8000   	EE F5        START:    LDU   [B,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE F5        START:    LDU   [B,S]", line.comment)	
	}
	
	/**
	 * Check Assembled LDU Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedIndirectAccumulatorMovingMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[D,X]  ; 8000   AB 9B        START:    LDU   [D,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9B, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    LDU   [D,X]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedIndirectAccumulatorMovingMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[D,Y]  ; 8000   	EE BB        START:    LDU   [D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xBB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE BB        START:    LDU   [D,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedIndirectAccumulatorMovingMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[D,U]  ; 8000   	EE DB        START:    LDU   [D,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xDB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE DB        START:    LDU   [D,U]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDUIndexedIndirectAccumulatorMovingMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[D,S]  ; 8000   	EE FB        START:    LDU   [D,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xFB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE FB        START:    LDU   [D,S]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	,X+  ; 8000   	EE 80        START:    LDU   ,X+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 80        START:    LDU   ,X+", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	,X++  ; 8000   	EE 81        START:    LDU   ,X++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x81, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 81        START:    LDU   ,X++", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	,Y+  ; 8000   	EE A0        START:    LDU   ,Y+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE A0        START:    LDU   ,Y+", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	,Y++  ; 8000   	EE A1        START:    LDU   ,Y++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE A1        START:    LDU   ,Y++", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	,S+  ; 8000   	EE E0        START:    LDU   ,S+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE E0        START:    LDU   ,S+", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	,S++  ; 8000   	EE E1        START:    LDU   ,S++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE E1        START:    LDU   ,S++", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	,U+  ; 8000   	EE C0        START:    LDU   ,U+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE C0        START:    LDU   ,U+", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	,U++  ; 8000   	EE C1        START:    LDU   ,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE C1        START:    LDU   ,U++", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	,-X  ; 8000   	EE 82        START:    LDU   ,-X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x82, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 82        START:    LDU   ,-X", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	,--X  ; 8000   	EE 83        START:    LDU   ,--X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x83, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 83        START:    LDU   ,--X", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	,-Y  ; 8000   	EE A2        START:    LDU   ,-Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE A2        START:    LDU   ,-Y", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	,--Y  ; 8000   	EE A3        START:    LDU   ,--Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE A3        START:    LDU   ,--Y", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementMode13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	,-S  ; 8000   	EE E2        START:    LDU   ,-S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE E2        START:    LDU   ,-S", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementMode14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	,--S  ; 8000   	EE E3        START:    LDU   ,--S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE E3        START:    LDU   ,--S", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementMode15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	,-U  ; 8000   	EE C2        START:    LDU   ,-U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE C2        START:    LDU   ,-U", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementMode16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	,--U  ; 8000   	EE C3        START:    LDU   ,--U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE C3        START:    LDU   ,--U", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementIndirectMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[,X+]  ; 8000   	EE 80        START:    LDU   ,X+
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Mode indorect instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementIndirectMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[,X++]  ; 8000   	EE 91        START:    LDU   [,X++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x91, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 91        START:    LDU   [,X++]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Mode indirect instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementIndirectMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[,Y+]  ; 8000   	EE A0        START:    LDU   ,Y+
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementIndirectMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[,Y++]  ; 8000   	EE B1        START:    LDU   [,Y++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE B1        START:    LDU   [,Y++]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementIndirectMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[,S+]  ; 8000   	EE E0        START:    LDU   [,S+]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementIndirectMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[,S++]  ; 8000   	EE F1        START:    LDU   [,S++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE F1        START:    LDU   [,S++]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementIndirectMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[,U+]  ; 8000   	EE C0        START:    LDU   [,U+]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementindirectMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[,U++]  ; 8000   	EE D1        START:    LDU   [,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE D1        START:    LDU   [,U++]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementIndirectMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[,-X]  ; 8000   	EE 82        START:    LDU   [,-X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementIndirectMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[,--X]  ; 8000   	EE 93        START:    LDU   [,--X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x93, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 93        START:    LDU   [,--X]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement INdirect Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementIndirectMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[,-Y]  ; 8000   	EE A2        START:    LDU   [,-Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementIndirectMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[,--Y]  ; 8000   	EE B3        START:    LDU   [,--Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE B3        START:    LDU   [,--Y]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementIndirectMode13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[,-S]  ; 8000   	EE E2        START:    LDU   [,-S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementIndirectMode14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[,--S]  ; 8000   	EE F3        START:    LDU   [,--S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE F3        START:    LDU   [,--S]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement indirect Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementIndirectMode15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[,-U]  ; 8000   	EE C2        START:    LDU   [,-U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDU Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDUIndexedAutoIncrementDecrementIndirectMode16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDU		  	[,--U]  ; 8000   	EE D3        START:    LDU   [,--U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE D3        START:    LDU   [,--U]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	1234,X  ; 8000   	EE 89 04 D2            LDU   1234,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 89 04 D2            LDU   1234,X", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	1234,Y  ; 8000   	EE A9 04 D2            LDU   1234,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE A9 04 D2            LDU   1234,Y", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	1234,U  ; 8000   	EE C9 04 D2            LDU   1234,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE C9 04 D2            LDU   1234,U", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	1234,S  ; 8000   	EE E9 04 D2            LDU   1234,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE E9 04 D2            LDU   1234,S", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	34,X  ; 8000   	EE 88 22            LDU   34,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 88 22            LDU   34,X", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	34,Y  ; 8000   	EE A8 22            LDU   34,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE A8 22            LDU   34,Y", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	34,U  ; 8000   	EE C8 22            LDU   34,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE C8 22            LDU   34,U", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	34,S  ; 8000   	EE E8 22            LDU   34,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE E8 22            LDU   34,S", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	,X  ; 8000   	EE 84            LDU   ,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 84            LDU   ,X", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	,Y  ; 8000   	EE A4            LDU   ,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE A4            LDU   ,Y", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	,U  ; 8000   	EE C4            LDU   ,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE C4            LDU   ,U", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	,S  ; 8000   	EE E4            LDU   ,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE E4            LDU   ,S", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	0,X  ; 8000   	EE 84            LDU   0,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 84            LDU   0,X", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	0,Y  ; 8000   	EE A4            LDU   0,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE A4            LDU   0,Y", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	0,U  ; 8000   	EE C4            LDU   0,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE C4            LDU   0,U", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	0,S  ; 8000   	EE E4            LDU   0,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE E4            LDU   0,S", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove17() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-16,X  ; 8000   	EE 10            LDU   -16,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x10, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 10            LDU   -16,X", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove19() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	1,X  ; 8000   	EE 01            LDU   1,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x01, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 01            LDU   1,X", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove20() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	15,X  ; 8000   	EE 0F            LDU   15,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 0F            LDU   15,X", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove21() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-16,Y  ; 8000   	EE 30            LDU   -16,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x30, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 30            LDU   -16,Y", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove23() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	1,Y  ; 8000   	EE 21            LDU   1,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x21, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 21            LDU   1,Y", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove24() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	15,Y  ; 8000   	EE 2F            LDU   15,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x2F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 2F            LDU   15,Y", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove25() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-16,U  ; 8000   	EE 50            LDU   -16,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x50, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 50            LDU   -16,U", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove26() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	1,U  ; 8000   	EE 41            LDU   1,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x41, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 41            LDU   1,U", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove27() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	15,U  ; 8000   	EE 4F            LDU   15,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x4F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 4F            LDU   15,U", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove28() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-16,S  ; 8000   	EE 70            LDU   -16,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x70, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 70            LDU   -16,S", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove29() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	1,S  ; 8000   	EE 61            LDU   1,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x61, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 61            LDU   1,S", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove30() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	15,S  ; 8000   	EE 6F            LDU   15,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x6F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 6F            LDU   15,S", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove31() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-128,X  ; 8000   	EE 88 80            LDU   -128,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 88 80            LDU   -128,X", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove32() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	127,X  ; 8000   	EE 88 7F            LDU   127,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 88 7F            LDU   127,X", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove33() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-128,Y  ; 8000   	EE A8 80            LDU   -128,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE A8 80            LDU   -128,Y", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove34() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	127,Y  ; 8000   	EE A8 7F            LDU   127,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE A8 7F            LDU   127,Y", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove35() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-128,U  ; 8000   	EE C8 80            LDU   -128,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE C8 80            LDU   -128,U", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove36() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	127,U  ; 8000   	EE C8 7F            LDU   127,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE C8 7F            LDU   127,U", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove37() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-128,S  ; 8000   	EE E8 80            LDU   -128,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE E8 80            LDU   -128,S", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove38() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	127,S  ; 8000   	EE E8 7F            LDU   127,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE E8 7F            LDU   127,S", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove39() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-32768,X  ; 8000   	EE 89 80 00             LDU   -32768,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 89 80 00             LDU   -32768,X", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove40() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  32767,X  ; 8000   	EE 89 7F FF             LDU   32767,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 89 7F FF             LDU   32767,X", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove41() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-32768,Y  ; 8000   	EE A9 80 00             LDU   -32768,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE A9 80 00             LDU   -32768,Y", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove42() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  32767,Y  ; 8000   	EE A9 7F FF             LDU   32767,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE A9 7F FF             LDU   32767,Y", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove43() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-32768,U  ; 8000   	EE C9 80 00             LDU   -32768,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE C9 80 00             LDU   -32768,U", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove44() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  32767,U  ; 8000   	EE C9 7F FF             LDU   32767,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE C9 7F FF             LDU   32767,U", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove45() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-32768,S  ; 8000   	EE E9 80 00             LDU   -32768,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE E9 80 00             LDU   -32768,S", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove46() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  32767,S  ; 8000   	EE E9 7F FF             LDU   32767,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE E9 7F FF             LDU   32767,S", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove47() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-32769,X  ; 8000   	EE 89 80 00             LDU   -32769,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 89 80 00             LDU   -32769,X", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove48() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  32768,X  ; 8000   	EE 89 7F FF             LDU   32768,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 89 7F FF             LDU   32768,X", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove49() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-32769,Y  ; 8000   	EE A9 80 00             LDU   -32769,Y
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE A9 80 00             LDU   -32769,Y", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove50() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  32768,Y  ; 8000   	EE A9 7F FF             LDU   32768,Y
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE A9 7F FF             LDU   32768,Y", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove51() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-32769,U  ; 8000   	EE C9 80 00             LDU   -32769,U
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE C9 80 00             LDU   -32769,U", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove52() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  32768,U  ; 8000   	EE C9 7F FF             LDU   32768,U
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE C9 7F FF             LDU   32768,U", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove53() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-32769,S  ; 8000   	EE E9 80 00             LDU   -32769,S
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE E9 80 00             LDU   -32769,S", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantMove54() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  32768,S  ; 8000   	EE E9 7F FF             LDU   32768,S
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE E9 7F FF             LDU   32768,S", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[1234,X]  ; 8000   	EE 99 04 D2            LDU   [1234,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 99 04 D2            LDU   [1234,X]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[1234,Y]  ; 8000   	EE B9 04 D2            LDU   [1234,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE B9 04 D2            LDU   [1234,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[1234,U]  ; 8000   	EE D9 04 D2            LDU   [1234,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE D9 04 D2            LDU   [1234,U]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[1234,S]  ; 8000   	EE F9 04 D2            LDU   [1234,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE F9 04 D2            LDU   [1234,S]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[34,X]  ; 8000   	EE 98 22            LDU   [34,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 98 22            LDU   [34,X]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[34,Y]  ; 8000   	EE B8 22            LDU   [34,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE B8 22            LDU   [34,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[34,U]  ; 8000   	EE D8 22            LDU   [34,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE D8 22            LDU   [34,U]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[34,S]  ; 8000   	EE F8 22            LDU   [34,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE F8 22            LDU   [34,S]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[,X]  ; 8000   	EE 94            LDU   [,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 94            LDU   [,X]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[,Y]  ; 8000   	EE B4            LDU   [,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE B4            LDU   [,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[,U]  ; 8000   	EE D4            LDU   [,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE D4            LDU   [,U]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[,S]  ; 8000   	EE F4            LDU   [,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE F4            LDU   [,S]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[0,X]  ; 8000   	EE 94            LDU   [0,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 94            LDU   [0,X]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[0,Y]  ; 8000   	EE B4            LDU   [0,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE B4            LDU   [0,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[0,U]  ; 8000   	EE D4            LDU   [0,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE D4            LDU   [0,U]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[0,S]  ; 8000   	EE F4            LDU   [0,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE F4            LDU   [0,S]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove17() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-16,X]  ; 8000   	EE 98 F0            LDU   [-16,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 98 F0            LDU   [-16,X]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove18() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[15,X]  ; 8000   	EE 98 0F            LDU   [15,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 98 0F            LDU   [15,X]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove19() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-16,Y]  ; 8000   	EE B8 F0            LDU   [-16,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE B8 F0            LDU   [-16,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove20() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[15,Y]  ; 8000   	EE B8 0F            LDU   [15,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE B8 0F            LDU   [15,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove21() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-16,U]  ; 8000   	EE D8 F0            LDU   [-16,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE D8 F0            LDU   [-16,U]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove22() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[15,U]  ; 8000   	EE D8 0F            LDU   [15,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE D8 0F            LDU   [15,U]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove23() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-16,S]  ; 8000   	EE F8 F0            LDU   [-16,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE F8 F0            LDU   [-16,S]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove24() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[15,S]  ; 8000   	EE F8 0F            LDU   [15,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE F8 0F            LDU   [15,S]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove31() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-128,X]  ; 8000   	EE 98 80            LDU   [-128,X}
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 98 80            LDU   [-128,X}", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove32() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[127,X]  ; 8000   	EE 98 7F            LDU   [127,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 98 7F            LDU   [127,X]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove33() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-128,Y]  ; 8000   	EE B8 80            LDU   [-128,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE B8 80            LDU   [-128,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove34() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[127,Y]  ; 8000   	EE B8 7F            LDU   [127,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE B8 7F            LDU   [127,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove35() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-128,U]  ; 8000   	EE D8 80            LDU   [-128,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE D8 80            LDU   [-128,U]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant INdirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove36() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[127,U]  ; 8000   	EE D8 7F            LDU   [127,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE D8 7F            LDU   [127,U]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove37() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-128,S]  ; 8000   	EE F8 80            LDU   [-128,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE F8 80            LDU   [-128,S]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove38() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[127,S]  ; 8000   	EE F8 7F            LDU   [127,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE F8 7F            LDU   [127,S]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove39() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-32768,X]  ; 8000   	EE 99 80 00             LDU   [-32768,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 99 80 00             LDU   [-32768,X]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove40() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  [32767,X]  ; 8000   	EE 99 7F FF             LDU   [32767,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 99 7F FF             LDU   [32767,X]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove41() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-32768,Y]  ; 8000   	EE B9 80 00             LDU   [-32768,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE B9 80 00             LDU   [-32768,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove42() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  [32767,Y]  ; 8000   	EE B9 7F FF             LDU   [32767,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE B9 7F FF             LDU   [32767,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove43() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-32768,U]  ; 8000   	EE D9 80 00             LDU   [-32768,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE D9 80 00             LDU   [-32768,U]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove44() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  [32767,U]  ; 8000   	EE D9 7F FF             LDU   [32767,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE D9 7F FF             LDU   [32767,U]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove45() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-32768,S]  ; 8000   	EE F9 80 00             LDU   [-32768,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE F9 80 00             LDU   [-32768,S]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove46() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  [32767,S]  ; 8000   	EE F9 7F FF             LDU   [32767,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE F9 7F FF             LDU   [32767,S]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove47() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-32769,X]  ; 8000   	EE 99 80 00             LDU   [-32769,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 99 80 00             LDU   [-32769,X]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove48() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  [32768,X]  ; 8000   	EE 99 7F FF             LDU   [32768,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 99 7F FF             LDU   [32768,X]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove49() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-32769,Y]  ; 8000   	EE B9 80 00             LDU   [-32769,Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE B9 80 00             LDU   [-32769,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove50() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  [32768,Y]  ; 8000   	EE B9 7F FF             LDU   [32768,Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE B9 7F FF             LDU   [32768,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove51() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-32769,U]  ; 8000   	EE D9 80 00             LDU   [-32769,U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE D9 80 00             LDU   [-32769,U]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove52() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  [32768,U]  ; 8000   	EE D9 7F FF             LDU   [32768,U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE D9 7F FF             LDU   [32768,U]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove53() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-32769,S]  ; 8000   	EE F9 80 00             LDU   [-32769,S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE F9 80 00             LDU   [-32769,S]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDUIndexedConstantIndirectMove54() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  [32768,S]  ; 8000   	EE F9 7F FF             LDU   [32768,S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE F9 7F FF             LDU   [32768,S]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDUIndexedRelatifToPCMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	0,PCR  ; 8000   	EE 8C 00            LDU   0,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 8C 00            LDU   0,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDUIndexedRelatifToPCMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-128,PCR  ; 8000   	EE 8C 80            LDU   -128,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 8C 80            LDU   -128,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDUIndexedRelatifToPCMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	127,PCR  ; 8000   	EE 8C 7F            LDU   127,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 8C 7F            LDU   127,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDUIndexedRelatifToPCMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-129,PCR  ; 8000   	EE 8D FF 7F            LDU   -129,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 8D FF 7F            LDU   -129,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDUIndexedRelatifToPCMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	128,PCR  ; 8000   	EE 8D 00 80            LDU   128,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 8D 00 80            LDU   128,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDUIndexedRelatifToPCMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-32768,PCR  ; 8000   	EE 8D 80 00            LDU   -32768,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 8D 80 00            LDU   -32768,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDUIndexedRelatifToPCMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	32767,PCR  ; 8000   	EE 8D 7F FF            LDU   32767,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 8D 7F FF            LDU   32767,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDUIndexedRelatifToPCMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	-32769,PCR  ; 8000   	EE 8D 80 00            LDU   -32769,PCR
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value -32769 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 8D 80 00            LDU   -32769,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDUIndexedRelatifToPCMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	32768,PCR  ; 8000   	EE 8D 7F FF            LDU   32768,PCR
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value 32768 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 8D 7F FF            LDU   32768,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDUIndexedRelatifIndirectToPCMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[0,PCR]  ; 8000   	EE 9C 00            LDU   [0,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 9C 00            LDU   [0,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDUIndexedRelatifIndirectToPCMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-128,PCR]  ; 8000   	EE 9C 80            LDU   [-128,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 9C 80            LDU   [-128,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDUIndexedRelatifIndirectToPCMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[127,PCR]  ; 8000   	EE 9C 7F            LDU   [127,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 9C 7F            LDU   [127,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDUIndexedRelatifIndirectToPCMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-129,PCR]  ; 8000   	EE 9D FF 7F            LDU   [-129,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 9D FF 7F            LDU   [-129,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDUIndexedRelatifIndirectToPCMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[128,PCR]  ; 8000   	EE 9D 00 80            LDU   [128,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 9D 00 80            LDU   [128,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDUIndexedRelatifIndirectToPCMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-32768,PCR]  ; 8000   	EE 9D 80 00            LDU   [-32768,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 9D 80 00            LDU   [-32768,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDUIndexedRelatifIndirectToPCMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[32767,PCR]  ; 8000   	EE 9D 7F FF            LDU   [32767,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 9D 7F FF            LDU   [32767,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDUIndexedRelatifIndirectToPCMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[-32769,PCR]  ; 8000   	EE 9D 80 00            LDU   [-32769,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value -32769 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 9D 80 00            LDU   [-32769,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDU Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDUIndexedRelatifIndirectToPCMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDU		  	[32768,PCR]  ; 8000   	EE 9D 7F FF            LDU   [32768,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value 32768 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDUInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	EE 9D 7F FF            LDU   [32768,PCR]", line.comment)	
	}
}