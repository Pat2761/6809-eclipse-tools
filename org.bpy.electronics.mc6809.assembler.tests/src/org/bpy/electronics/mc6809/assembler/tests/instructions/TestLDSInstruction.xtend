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
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLDSInstruction
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestLDSInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check LDS immediat 
	 */
	@Test 
	def void testLDSImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDS		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDS directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDS instruction", instruction.instruction,"LDS")
		assertTrue("Must be an immediate addressing mode", instruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check LDS direct mode 
	 */
	@Test 
	def void testLDSDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDS		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDS directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDS instruction", instruction.instruction,"LDS")
		assertTrue("Must be a direct addressing mode", instruction.operand instanceof DirectOperand)
	}

	/**
	 * Check LDS extended mode 
	 */
	@Test 
	def void testLDSExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDS		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDS directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDS instruction", instruction.instruction,"LDS")
		assertTrue("Must be a extended addressing mode", instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDS extended mode 
	 */
	@Test 
	def void testLDSExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDS		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDS directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDS instruction", instruction.instruction,"LDS")
		assertTrue("Must be a extended addressing mode", instruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check LDS extended indirect mode 
	 */
	@Test 
	def void testLDSExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       LDS		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDS directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDS instruction", instruction.instruction,"LDS")
		assertTrue("Must be a extended indirect addressing mode", instruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check LDS Constant-Offset Indexed 
	 */
	@Test 
	def void testLDSConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDS		  	Const,X
					LDS		  	,X
					LDS		  	$9,U
					LDS		  	$9,S
					LDS		  	$9,X
					LDS		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDS directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDS instruction", instruction.instruction,"LDS")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check LDS Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testLDSConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDS		  	[Const,X]
					LDS		  	[,X]
					LDS		  	[$9,U]
					LDS		  	[$9,S]
					LDS		  	[$9,X]
					LDS		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDS directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDS instruction", instruction.instruction,"LDS")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check LDS Accumulator Indexed 
	 */
	@Test 
	def void testLDSAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDS		  	A,X
					LDS		  	B,X
					LDS		  	D,U
					LDS		  	A,S
					LDS		  	B,X
					LDS		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDS directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDS instruction", instruction.instruction,"LDS")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check LDS Accumulator Indexed Indirect
	 */
	@Test 
	def void testLDSAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDS		  	[A,X]
					LDS		  	[B,X]
					LDS		  	[D,U]
					LDS		  	[A,S]
					LDS		  	[B,X]
					LDS		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDS directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDS instruction", instruction.instruction,"LDS")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check LDS Auto-Increment Indexed 
	 */
	@Test 
	def void testLDSAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDS		  	,--X
			       	LDS		  	,-X
			       	LDS		  	,X+
			       	LDS		  	,X++
			       	LDS		  	,--S
			       	LDS		  	,-S
			       	LDS		  	,U+
			       	LDS		  	,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDS directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDS instruction", instruction.instruction,"LDS")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check LDS Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testLDSAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDS		  	[,--X]
			       	LDS		  	[,X++]
			       	LDS		  	[,--S]
			       	LDS		  	[,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDS directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDS instruction", instruction.instruction,"LDS")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check LDS Relative to PC Indexed 
	 */
	@Test 
	def void testLDSRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDS		  	0,PC
			       	LDS		  	,PC
			       	LDS		  	Const,PC
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDS directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDS instruction", instruction.instruction,"LDS")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check LDS Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testLDSRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	LDS		  	[0,PC]
			       	LDS		  	[,PC]
			       	LDS		  	[Const,PC]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an LDS directive line", instructionLine.instruction instanceof LdInstruction)

		val instruction = instructionLine.instruction as LdInstruction
		assertEquals("Must be an LDS instruction", instruction.instruction,"LDS")
		assertTrue("Must be a Constant-Offset Indexed mode", instruction.operand instanceof IndexedOperand)
		val indexedOperand = instruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
	
	/**
	 * Check LDS instruction with duplicate label 
	 */
	@Test 
	def void testLDSWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start		NOP
					NOP    
		Start      	LDS		  	#Const+2
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.instructionLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"Label Start is already defined"
		)
	}
	
	/**
	 * Check Assembled LDS immediate instruction  
	 */
	@Test 
	def void testLDSImmediatInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	#Const+2  ; 8000   10 CE 07        START:    LDS
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xCE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x07, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   10 CE 07        START:    LDS", line.comment)	
	}
	
	/**
	 * Check Assembled LDS immediate with limit negative operand  
	 */
	@Test 
	def void testLDSImmediatInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	#-32769
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check operand", 0x8000, line.operand.get(0));
	}
	
	/**
	 * Check Assembled LDS immediate with limit negative operand  
	 */
	@Test 
	def void testLDSImmediatInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	#-32768
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check operand", 0x8000, line.operand.get(0));
	}

	/**
	 * Check Assembled LDS immediate with positive limit operand  
	 */
	@Test 
	def void testLDSImmediatInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	#32767
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check operand", 0x7FFF, line.operand.get(0));
	}

	/**
	 * Check Assembled LDS immediate with positive limit operand  
	 */
	@Test 
	def void testLDSImmediatInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	#32768
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 32768 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check operand", 0x7FFF, line.operand.get(0));
	}
	
	/**
	 * Check Assembled LDS direct mode instruction  
	 */
	@Test 
	def void testLDSDirectInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	<Const*2  ; 8000   10 DE 0A        START:    LDS   <Const*2 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xDE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x0A, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   10 DE 0A        START:    LDS   <Const*2 ", line.comment)	
	}
	
	/**
	 * Check Assembled LDS direct with limit negative operand  
	 */
	@Test 
	def void testLDSDirectInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	<-129
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -129 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}
	
	/**
	 * Check Assembled LDS direct with limit negative operand  
	 */
	@Test 
	def void testLDSDirectInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	<-128
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}

	/**
	 * Check Assembled LDS direct with positive limit operand  
	 */
	@Test 
	def void testLDSDirectInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	<127
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}

	/**
	 * Check Assembled LDS direct with positive limit operand  
	 */
	@Test 
	def void testLDSDirectInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	<128
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 128 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}
	
	/**
	 * Check Assembled LDS extended mode instruction  
	 */
	@Test 
	def void testLDSExtendedInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	>Const*1000  ; 8000   10 FE 13 88     START:    LDS   >Const*1000 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xFE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   10 FE 13 88     START:    LDS   >Const*1000 ", line.comment)	
	}
	
	/**
	 * Check Assembled LDS extended with limit negative operand  
	 */
	@Test 
	def void testLDSExtendedInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	>-32769
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}
	
	/**
	 * Check Assembled LDS extended with limit negative operand  
	 */
	@Test 
	def void testLDSExtendedInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	>-32768
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}

	/**
	 * Check Assembled LDS extended with positive limit operand  
	 */
	@Test 
	def void testLDSExtendedInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	>65535
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}

	/**
	 * Check Assembled LDS extended with positive limit operand  
	 */
	@Test 
	def void testLDSExtendedInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	>65536
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 65536 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}
	
	/**
	 * Check Assembled LDS extended indirect mode instruction  
	 */
	@Test 
	def void testLDSExtendedIndirectInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[Const*1000]  ; 8000   AB 9F 13 88  START:    LDS   [Const*1000]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 3, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check opcode", 0x9F, line.opcode.get(2));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 9F 13 88  START:    LDS   [Const*1000]", line.comment)	
	}
	
	/**
	 * Check Assembled LDS extended indirect with limit negative operand  
	 */
	@Test 
	def void testLDSExtendedIndirectInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-32769]
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}
	
	/**
	 * Check Assembled LDS extended indirect with limit negative operand  
	 */
	@Test 
	def void testLDSExtendedIndirectInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-32768]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}

	/**
	 * Check Assembled LDS extended indirect with positive limit operand  
	 */
	@Test 
	def void testLDSExtendedIndirectInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[65535]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}

	/**
	 * Check Assembled LDS extended indirect with positive limit operand  
	 */
	@Test 
	def void testLDSExtendedIndirectInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[65536]
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.ldInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 65536 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}
	
	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAccumulatorMovingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	A,X  ; 8000   10 A3 86        START:    LDS   A,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x86, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   10 A3 86        START:    LDS   A,X", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAccumulatorMovingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	A,Y  ; 8000   	10 EE A6        START:    LDS   A,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE A6        START:    LDS   A,Y", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAccumulatorMovingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	A,U  ; 8000   	10 EE C6        START:    LDS   A,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE C6        START:    LDS   A,U", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAccumulatorMovingMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	A,S  ; 8000   	10 EE E6        START:    LDS   A,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE E6        START:    LDS   A,S", line.comment)	
	}
	
	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAccumulatorMovingMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	B,X  ; 8000   AB 85        START:    LDS   B,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x85, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 85        START:    LDS   B,X", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAccumulatorMovingMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	B,Y  ; 8000   	10 EE A5        START:    LDS   B,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE A5        START:    LDS   B,Y", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAccumulatorMovingMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	B,U  ; 8000   	10 EE C5        START:    LDS   B,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE C5        START:    LDS   B,U", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAccumulatorMovingMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	B,S  ; 8000   	10 EE E5        START:    LDS   B,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE E5        START:    LDS   B,S", line.comment)	
	}
	
	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAccumulatorMovingMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	D,X  ; 8000   AB 8B        START:    LDS   D,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8B, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    LDS   D,X", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAccumulatorMovingMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	D,Y  ; 8000   	10 EE AB        START:    LDS   D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xAB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE AB        START:    LDS   D,Y", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAccumulatorMovingMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	D,U  ; 8000   	10 EE CB        START:    LDS   D,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xCB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE CB        START:    LDS   D,U", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAccumulatorMovingMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	D,S  ; 8000   	10 EE EB        START:    LDS   D,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xEB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE EB        START:    LDS   D,S", line.comment)	
	}
	
	/**
	 * Check Assembled LDS Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedIndorectAccumulatorMovingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[A,X]  ; 8000   AB 96        START:    LDS   [A,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x96, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 96        START:    LDS   [A,X]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedIndirectAccumulatorMovingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[A,Y]  ; 8000   	10 EE B6        START:    LDS   [A,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE B6        START:    LDS   [A,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedIndirectAccumulatorMovingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[A,U]  ; 8000   	10 EE D6        START:    LDS   [A,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE D6        START:    LDS   [A,U]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedIndirectAccumulatorMovingMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[A,S]  ; 8000   	10 EE F6        START:    LDS   [A,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE F6        START:    LDS   [A,S]", line.comment)	
	}
	
	/**
	 * Check Assembled LDS Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedIndirectAccumulatorMovingMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[B,X]  ; 8000   AB 95        START:    LDS   [B,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x95, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 95        START:    LDS   [B,X]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedIndirectAccumulatorMovingMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[B,Y]  ; 8000   	10 EE B5        START:    LDS   [B,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE B5        START:    LDS   [B,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedIndirectAccumulatorMovingMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[B,U]  ; 8000   	10 EE D5        START:    LDS   [B,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE D5        START:    LDS   [B,U]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedIndirectAccumulatorMovingMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[B,S]  ; 8000   	10 EE F5        START:    LDS   [B,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE F5        START:    LDS   [B,S]", line.comment)	
	}
	
	/**
	 * Check Assembled LDS Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedIndirectAccumulatorMovingMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[D,X]  ; 8000   AB 9B        START:    LDS   [D,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9B, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    LDS   [D,X]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedIndirectAccumulatorMovingMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[D,Y]  ; 8000   	10 EE BB        START:    LDS   [D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xBB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE BB        START:    LDS   [D,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedIndirectAccumulatorMovingMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[D,U]  ; 8000   	10 EE DB        START:    LDS   [D,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xDB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE DB        START:    LDS   [D,U]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testLDSIndexedIndirectAccumulatorMovingMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[D,S]  ; 8000   	10 EE FB        START:    LDS   [D,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xFB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE FB        START:    LDS   [D,S]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	,X+  ; 8000   	10 EE 80        START:    LDS   ,X+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 80        START:    LDS   ,X+", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	,X++  ; 8000   	10 EE 81        START:    LDS   ,X++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x81, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 81        START:    LDS   ,X++", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	,Y+  ; 8000   	10 EE A0        START:    LDS   ,Y+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE A0        START:    LDS   ,Y+", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	,Y++  ; 8000   	10 EE A1        START:    LDS   ,Y++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE A1        START:    LDS   ,Y++", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	,S+  ; 8000   	10 EE E0        START:    LDS   ,S+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE E0        START:    LDS   ,S+", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	,S++  ; 8000   	10 EE E1        START:    LDS   ,S++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE E1        START:    LDS   ,S++", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	,U+  ; 8000   	10 EE C0        START:    LDS   ,U+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE C0        START:    LDS   ,U+", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	,U++  ; 8000   	10 EE C1        START:    LDS   ,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE C1        START:    LDS   ,U++", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	,-X  ; 8000   	10 EE 82        START:    LDS   ,-X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x82, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 82        START:    LDS   ,-X", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	,--X  ; 8000   	10 EE 83        START:    LDS   ,--X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x83, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 83        START:    LDS   ,--X", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	,-Y  ; 8000   	10 EE A2        START:    LDS   ,-Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE A2        START:    LDS   ,-Y", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	,--Y  ; 8000   	10 EE A3        START:    LDS   ,--Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE A3        START:    LDS   ,--Y", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementMode13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	,-S  ; 8000   	10 EE E2        START:    LDS   ,-S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE E2        START:    LDS   ,-S", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementMode14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	,--S  ; 8000   	10 EE E3        START:    LDS   ,--S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE E3        START:    LDS   ,--S", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementMode15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	,-U  ; 8000   	10 EE C2        START:    LDS   ,-U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE C2        START:    LDS   ,-U", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementMode16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	,--U  ; 8000   	10 EE C3        START:    LDS   ,--U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE C3        START:    LDS   ,--U", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementIndirectMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[,X+]  ; 8000   	10 EE 80        START:    LDS   ,X+
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode indorect instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementIndirectMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[,X++]  ; 8000   	10 EE 91        START:    LDS   [,X++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x91, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 91        START:    LDS   [,X++]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Mode indirect instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementIndirectMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[,Y+]  ; 8000   	10 EE A0        START:    LDS   ,Y+
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementIndirectMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[,Y++]  ; 8000   	10 EE B1        START:    LDS   [,Y++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE B1        START:    LDS   [,Y++]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementIndirectMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[,S+]  ; 8000   	10 EE E0        START:    LDS   [,S+]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementIndirectMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[,S++]  ; 8000   	10 EE F1        START:    LDS   [,S++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE F1        START:    LDS   [,S++]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementIndirectMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[,U+]  ; 8000   	10 EE C0        START:    LDS   [,U+]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementindirectMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[,U++]  ; 8000   	10 EE D1        START:    LDS   [,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE D1        START:    LDS   [,U++]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementIndirectMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[,-X]  ; 8000   	10 EE 82        START:    LDS   [,-X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementIndirectMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[,--X]  ; 8000   	10 EE 93        START:    LDS   [,--X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x93, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 93        START:    LDS   [,--X]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement INdirect Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementIndirectMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[,-Y]  ; 8000   	10 EE A2        START:    LDS   [,-Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementIndirectMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[,--Y]  ; 8000   	10 EE B3        START:    LDS   [,--Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE B3        START:    LDS   [,--Y]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementIndirectMode13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[,-S]  ; 8000   	10 EE E2        START:    LDS   [,-S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementIndirectMode14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[,--S]  ; 8000   	10 EE F3        START:    LDS   [,--S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE F3        START:    LDS   [,--S]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement indirect Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementIndirectMode15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[,-U]  ; 8000   	10 EE C2        START:    LDS   [,-U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled LDS Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testLDSIndexedAutoIncrementDecrementIndirectMode16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	LDS		  	[,--U]  ; 8000   	10 EE D3        START:    LDS   [,--U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE D3        START:    LDS   [,--U]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	1234,X  ; 8000   	10 EE 89 04 D2            LDS   1234,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 89 04 D2            LDS   1234,X", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	1234,Y  ; 8000   	10 EE A9 04 D2            LDS   1234,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE A9 04 D2            LDS   1234,Y", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	1234,U  ; 8000   	10 EE C9 04 D2            LDS   1234,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE C9 04 D2            LDS   1234,U", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	1234,S  ; 8000   	10 EE E9 04 D2            LDS   1234,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE E9 04 D2            LDS   1234,S", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	34,X  ; 8000   	10 EE 88 22            LDS   34,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 88 22            LDS   34,X", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	34,Y  ; 8000   	10 EE A8 22            LDS   34,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE A8 22            LDS   34,Y", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	34,U  ; 8000   	10 EE C8 22            LDS   34,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE C8 22            LDS   34,U", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	34,S  ; 8000   	10 EE E8 22            LDS   34,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE E8 22            LDS   34,S", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	,X  ; 8000   	10 EE 84            LDS   ,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 84            LDS   ,X", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	,Y  ; 8000   	10 EE A4            LDS   ,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE A4            LDS   ,Y", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	,U  ; 8000   	10 EE C4            LDS   ,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE C4            LDS   ,U", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	,S  ; 8000   	10 EE E4            LDS   ,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE E4            LDS   ,S", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	0,X  ; 8000   	10 EE 84            LDS   0,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 84            LDS   0,X", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	0,Y  ; 8000   	10 EE A4            LDS   0,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE A4            LDS   0,Y", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	0,U  ; 8000   	10 EE C4            LDS   0,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE C4            LDS   0,U", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	0,S  ; 8000   	10 EE E4            LDS   0,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE E4            LDS   0,S", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove17() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-16,X  ; 8000   	10 EE 10            LDS   -16,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x10, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 10            LDS   -16,X", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove19() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	1,X  ; 8000   	10 EE 01            LDS   1,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x01, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 01            LDS   1,X", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove20() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	15,X  ; 8000   	10 EE 0F            LDS   15,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 0F            LDS   15,X", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove21() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-16,Y  ; 8000   	10 EE 30            LDS   -16,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x30, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 30            LDS   -16,Y", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove23() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	1,Y  ; 8000   	10 EE 21            LDS   1,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x21, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 21            LDS   1,Y", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove24() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	15,Y  ; 8000   	10 EE 2F            LDS   15,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x2F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 2F            LDS   15,Y", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove25() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-16,U  ; 8000   	10 EE 50            LDS   -16,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x50, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 50            LDS   -16,U", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove26() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	1,U  ; 8000   	10 EE 41            LDS   1,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x41, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 41            LDS   1,U", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove27() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	15,U  ; 8000   	10 EE 4F            LDS   15,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x4F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 4F            LDS   15,U", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove28() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-16,S  ; 8000   	10 EE 70            LDS   -16,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x70, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 70            LDS   -16,S", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove29() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	1,S  ; 8000   	10 EE 61            LDS   1,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x61, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 61            LDS   1,S", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove30() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	15,S  ; 8000   	10 EE 6F            LDS   15,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x6F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 6F            LDS   15,S", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove31() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-128,X  ; 8000   	10 EE 88 80            LDS   -128,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 88 80            LDS   -128,X", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove32() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	127,X  ; 8000   	10 EE 88 7F            LDS   127,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 88 7F            LDS   127,X", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove33() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-128,Y  ; 8000   	10 EE A8 80            LDS   -128,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE A8 80            LDS   -128,Y", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove34() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	127,Y  ; 8000   	10 EE A8 7F            LDS   127,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE A8 7F            LDS   127,Y", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove35() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-128,U  ; 8000   	10 EE C8 80            LDS   -128,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE C8 80            LDS   -128,U", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove36() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	127,U  ; 8000   	10 EE C8 7F            LDS   127,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE C8 7F            LDS   127,U", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove37() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-128,S  ; 8000   	10 EE E8 80            LDS   -128,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE E8 80            LDS   -128,S", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove38() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	127,S  ; 8000   	10 EE E8 7F            LDS   127,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE E8 7F            LDS   127,S", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove39() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-32768,X  ; 8000   	10 EE 89 80 00             LDS   -32768,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 89 80 00             LDS   -32768,X", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove40() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  32767,X  ; 8000   	10 EE 89 7F FF             LDS   32767,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 89 7F FF             LDS   32767,X", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove41() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-32768,Y  ; 8000   	10 EE A9 80 00             LDS   -32768,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE A9 80 00             LDS   -32768,Y", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove42() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  32767,Y  ; 8000   	10 EE A9 7F FF             LDS   32767,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE A9 7F FF             LDS   32767,Y", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove43() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-32768,U  ; 8000   	10 EE C9 80 00             LDS   -32768,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE C9 80 00             LDS   -32768,U", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove44() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  32767,U  ; 8000   	10 EE C9 7F FF             LDS   32767,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE C9 7F FF             LDS   32767,U", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove45() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-32768,S  ; 8000   	10 EE E9 80 00             LDS   -32768,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE E9 80 00             LDS   -32768,S", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove46() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  32767,S  ; 8000   	10 EE E9 7F FF             LDS   32767,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE E9 7F FF             LDS   32767,S", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove47() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-32769,X  ; 8000   	10 EE 89 80 00             LDS   -32769,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 89 80 00             LDS   -32769,X", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove48() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  32768,X  ; 8000   	10 EE 89 7F FF             LDS   32768,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 89 7F FF             LDS   32768,X", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove49() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-32769,Y  ; 8000   	10 EE A9 80 00             LDS   -32769,Y
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE A9 80 00             LDS   -32769,Y", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove50() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  32768,Y  ; 8000   	10 EE A9 7F FF             LDS   32768,Y
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE A9 7F FF             LDS   32768,Y", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove51() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-32769,U  ; 8000   	10 EE C9 80 00             LDS   -32769,U
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE C9 80 00             LDS   -32769,U", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove52() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  32768,U  ; 8000   	10 EE C9 7F FF             LDS   32768,U
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE C9 7F FF             LDS   32768,U", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove53() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-32769,S  ; 8000   	10 EE E9 80 00             LDS   -32769,S
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE E9 80 00             LDS   -32769,S", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantMove54() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  32768,S  ; 8000   	10 EE E9 7F FF             LDS   32768,S
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE E9 7F FF             LDS   32768,S", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[1234,X]  ; 8000   	10 EE 99 04 D2            LDS   [1234,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 99 04 D2            LDS   [1234,X]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[1234,Y]  ; 8000   	10 EE B9 04 D2            LDS   [1234,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE B9 04 D2            LDS   [1234,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[1234,U]  ; 8000   	10 EE D9 04 D2            LDS   [1234,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE D9 04 D2            LDS   [1234,U]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[1234,S]  ; 8000   	10 EE F9 04 D2            LDS   [1234,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE F9 04 D2            LDS   [1234,S]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[34,X]  ; 8000   	10 EE 98 22            LDS   [34,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 98 22            LDS   [34,X]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[34,Y]  ; 8000   	10 EE B8 22            LDS   [34,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE B8 22            LDS   [34,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[34,U]  ; 8000   	10 EE D8 22            LDS   [34,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE D8 22            LDS   [34,U]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[34,S]  ; 8000   	10 EE F8 22            LDS   [34,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE F8 22            LDS   [34,S]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[,X]  ; 8000   	10 EE 94            LDS   [,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 94            LDS   [,X]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[,Y]  ; 8000   	10 EE B4            LDS   [,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE B4            LDS   [,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[,U]  ; 8000   	10 EE D4            LDS   [,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE D4            LDS   [,U]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[,S]  ; 8000   	10 EE F4            LDS   [,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE F4            LDS   [,S]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[0,X]  ; 8000   	10 EE 94            LDS   [0,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 94            LDS   [0,X]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[0,Y]  ; 8000   	10 EE B4            LDS   [0,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE B4            LDS   [0,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[0,U]  ; 8000   	10 EE D4            LDS   [0,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE D4            LDS   [0,U]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[0,S]  ; 8000   	10 EE F4            LDS   [0,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE F4            LDS   [0,S]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove17() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-16,X]  ; 8000   	10 EE 98 F0            LDS   [-16,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 98 F0            LDS   [-16,X]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove18() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[15,X]  ; 8000   	10 EE 98 0F            LDS   [15,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 98 0F            LDS   [15,X]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove19() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-16,Y]  ; 8000   	10 EE B8 F0            LDS   [-16,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE B8 F0            LDS   [-16,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove20() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[15,Y]  ; 8000   	10 EE B8 0F            LDS   [15,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE B8 0F            LDS   [15,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove21() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-16,U]  ; 8000   	10 EE D8 F0            LDS   [-16,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE D8 F0            LDS   [-16,U]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove22() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[15,U]  ; 8000   	10 EE D8 0F            LDS   [15,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE D8 0F            LDS   [15,U]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove23() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-16,S]  ; 8000   	10 EE F8 F0            LDS   [-16,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE F8 F0            LDS   [-16,S]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove24() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[15,S]  ; 8000   	10 EE F8 0F            LDS   [15,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE F8 0F            LDS   [15,S]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove31() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-128,X]  ; 8000   	10 EE 98 80            LDS   [-128,X}
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 98 80            LDS   [-128,X}", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove32() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[127,X]  ; 8000   	10 EE 98 7F            LDS   [127,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 98 7F            LDS   [127,X]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove33() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-128,Y]  ; 8000   	10 EE B8 80            LDS   [-128,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE B8 80            LDS   [-128,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove34() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[127,Y]  ; 8000   	10 EE B8 7F            LDS   [127,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE B8 7F            LDS   [127,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove35() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-128,U]  ; 8000   	10 EE D8 80            LDS   [-128,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE D8 80            LDS   [-128,U]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant INdirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove36() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[127,U]  ; 8000   	10 EE D8 7F            LDS   [127,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE D8 7F            LDS   [127,U]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove37() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-128,S]  ; 8000   	10 EE F8 80            LDS   [-128,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE F8 80            LDS   [-128,S]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove38() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[127,S]  ; 8000   	10 EE F8 7F            LDS   [127,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE F8 7F            LDS   [127,S]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove39() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-32768,X]  ; 8000   	10 EE 99 80 00             LDS   [-32768,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 99 80 00             LDS   [-32768,X]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove40() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  [32767,X]  ; 8000   	10 EE 99 7F FF             LDS   [32767,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 99 7F FF             LDS   [32767,X]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove41() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-32768,Y]  ; 8000   	10 EE B9 80 00             LDS   [-32768,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE B9 80 00             LDS   [-32768,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove42() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  [32767,Y]  ; 8000   	10 EE B9 7F FF             LDS   [32767,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE B9 7F FF             LDS   [32767,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove43() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-32768,U]  ; 8000   	10 EE D9 80 00             LDS   [-32768,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE D9 80 00             LDS   [-32768,U]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove44() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  [32767,U]  ; 8000   	10 EE D9 7F FF             LDS   [32767,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE D9 7F FF             LDS   [32767,U]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove45() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-32768,S]  ; 8000   	10 EE F9 80 00             LDS   [-32768,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE F9 80 00             LDS   [-32768,S]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove46() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  [32767,S]  ; 8000   	10 EE F9 7F FF             LDS   [32767,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE F9 7F FF             LDS   [32767,S]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove47() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-32769,X]  ; 8000   	10 EE 99 80 00             LDS   [-32769,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 99 80 00             LDS   [-32769,X]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove48() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  [32768,X]  ; 8000   	10 EE 99 7F FF             LDS   [32768,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 99 7F FF             LDS   [32768,X]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove49() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-32769,Y]  ; 8000   	10 EE B9 80 00             LDS   [-32769,Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE B9 80 00             LDS   [-32769,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove50() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  [32768,Y]  ; 8000   	10 EE B9 7F FF             LDS   [32768,Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE B9 7F FF             LDS   [32768,Y]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove51() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-32769,U]  ; 8000   	10 EE D9 80 00             LDS   [-32769,U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE D9 80 00             LDS   [-32769,U]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove52() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  [32768,U]  ; 8000   	10 EE D9 7F FF             LDS   [32768,U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE D9 7F FF             LDS   [32768,U]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove53() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-32769,S]  ; 8000   	10 EE F9 80 00             LDS   [-32769,S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE F9 80 00             LDS   [-32769,S]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testLDSIndexedConstantIndirectMove54() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  [32768,S]  ; 8000   	10 EE F9 7F FF             LDS   [32768,S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE F9 7F FF             LDS   [32768,S]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDSIndexedRelatifToPCMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	0,PCR  ; 8000   	10 EE 8C 00            LDS   0,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 8C 00            LDS   0,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDSIndexedRelatifToPCMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-128,PCR  ; 8000   	10 EE 8C 80            LDS   -128,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 8C 80            LDS   -128,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDSIndexedRelatifToPCMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	127,PCR  ; 8000   	10 EE 8C 7F            LDS   127,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 8C 7F            LDS   127,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDSIndexedRelatifToPCMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-129,PCR  ; 8000   	10 EE 8D FF 7F            LDS   -129,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 8D FF 7F            LDS   -129,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDSIndexedRelatifToPCMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	128,PCR  ; 8000   	10 EE 8D 00 80            LDS   128,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 8D 00 80            LDS   128,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDSIndexedRelatifToPCMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-32768,PCR  ; 8000   	10 EE 8D 80 00            LDS   -32768,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 8D 80 00            LDS   -32768,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDSIndexedRelatifToPCMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	32767,PCR  ; 8000   	10 EE 8D 7F FF            LDS   32767,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 8D 7F FF            LDS   32767,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDSIndexedRelatifToPCMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	-32769,PCR  ; 8000   	10 EE 8D 80 00            LDS   -32769,PCR
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value -32769 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 8D 80 00            LDS   -32769,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testLDSIndexedRelatifToPCMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	32768,PCR  ; 8000   	10 EE 8D 7F FF            LDS   32768,PCR
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value 32768 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 8D 7F FF            LDS   32768,PCR", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDSIndexedRelatifIndirectToPCMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[0,PCR]  ; 8000   	10 EE 9C 00            LDS   [0,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 9C 00            LDS   [0,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDSIndexedRelatifIndirectToPCMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-128,PCR]  ; 8000   	10 EE 9C 80            LDS   [-128,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 9C 80            LDS   [-128,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDSIndexedRelatifIndirectToPCMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[127,PCR]  ; 8000   	10 EE 9C 7F            LDS   [127,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 9C 7F            LDS   [127,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDSIndexedRelatifIndirectToPCMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-129,PCR]  ; 8000   	10 EE 9D FF 7F            LDS   [-129,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 9D FF 7F            LDS   [-129,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDSIndexedRelatifIndirectToPCMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[128,PCR]  ; 8000   	10 EE 9D 00 80            LDS   [128,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 9D 00 80            LDS   [128,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDSIndexedRelatifIndirectToPCMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-32768,PCR]  ; 8000   	10 EE 9D 80 00            LDS   [-32768,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 9D 80 00            LDS   [-32768,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDSIndexedRelatifIndirectToPCMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[32767,PCR]  ; 8000   	10 EE 9D 7F FF            LDS   [32767,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 9D 7F FF            LDS   [32767,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDSIndexedRelatifIndirectToPCMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[-32769,PCR]  ; 8000   	10 EE 9D 80 00            LDS   [-32769,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value -32769 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 9D 80 00            LDS   [-32769,PCR]", line.comment)	
	}

	/**
	 * Check Assembled LDS Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testLDSIndexedRelatifIndirectToPCMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	LDS		  	[32768,PCR]  ; 8000   	10 EE 9D 7F FF            LDS   [32768,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.ldInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value 32768 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8005, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledLDSInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x10, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0xEE, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	10 EE 9D 7F FF            LDS   [32768,PCR]", line.comment)	
	}
}