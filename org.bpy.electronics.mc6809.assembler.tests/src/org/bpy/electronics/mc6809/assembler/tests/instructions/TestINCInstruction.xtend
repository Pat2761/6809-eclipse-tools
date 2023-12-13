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
import org.bpy.electronics.mc6809.assembler.assembler.IncInstruction
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
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledINCInstruction
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)
 
class TestINCInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check INC direct mode 
	 */
	@Test 
	def void testINCDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       INC		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a direct addressing mode", incInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check INC extended mode 
	 */
	@Test 
	def void testINCExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       INC		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a extended addressing mode", incInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check INC extended mode 
	 */
	@Test 
	def void testINCExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       INC		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a extended addressing mode", incInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check INC extended indirect mode 
	 */
	@Test 
	def void testINCExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       INC		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a extended indirect addressing mode", incInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check INC Constant-Offset Indexed 
	 */
	@Test 
	def void testINCConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	INC		  	Const,X
					INC		  	,X
					INC		  	$9,U
					INC		  	$9,S
					INC		  	$9,X
					INC		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a Constant-Offset Indexed mode", incInstruction.operand instanceof IndexedOperand)
		val indexedOperand = incInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check INC Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testINCConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	INC		  	[Const,X]
					INC		  	[,X]
					INC		  	[$9,U]
					INC		  	[$9,S]
					INC		  	[$9,X]
					INC		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a Constant-Offset Indexed mode", incInstruction.operand instanceof IndexedOperand)
		val indexedOperand = incInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check INC Accumulator Indexed 
	 */
	@Test 
	def void testINCAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	INC		  	A,X
					INC		  	B,X
					INC		  	D,U
					INC		  	A,S
					INC		  	B,X
					INC		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a Constant-Offset Indexed mode", incInstruction.operand instanceof IndexedOperand)
		val indexedOperand = incInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check INC Accumulator Indexed Indirect
	 */
	@Test 
	def void testINCAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	INC		  	[A,X]
					INC		  	[B,X]
					INC		  	[D,U]
					INC		  	[A,S]
					INC		  	[B,X]
					INC		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a Constant-Offset Indexed mode", incInstruction.operand instanceof IndexedOperand)
		val indexedOperand = incInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check INC Auto-Increment Indexed 
	 */
	@Test 
	def void testINCAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	INC		  	,--X
			       	INC		  	,-X
			       	INC		  	,X+
			       	INC		  	,X++
			       	INC		  	,--S
			       	INC		  	,-S
			       	INC		  	,U+
			       	INC		  	,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a Constant-Offset Indexed mode", incInstruction.operand instanceof IndexedOperand)
		val indexedOperand = incInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check INC Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testINCAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	INC		  	[,--X]
			       	INC		  	[,X++]
			       	INC		  	[,--S]
			       	INC		  	[,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a Constant-Offset Indexed mode", incInstruction.operand instanceof IndexedOperand)
		val indexedOperand = incInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check INC Relative to PC Indexed 
	 */
	@Test 
	def void testINCRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	INC		  	0,PC
			       	INC		  	,PC
			       	INC		  	Const,PC
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a Constant-Offset Indexed mode", incInstruction.operand instanceof IndexedOperand)
		val indexedOperand = incInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check INC Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testINCRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	INC		  	[0,PC]
			       	INC		  	[,PC]
			       	INC		  	[Const,PC]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an INC directive line", instructionLine.instruction instanceof IncInstruction)

		val incInstruction = instructionLine.instruction as IncInstruction
		assertEquals("Must be an INC instruction", incInstruction.instruction,"INC")
		assertTrue("Must be a Constant-Offset Indexed mode", incInstruction.operand instanceof IndexedOperand)
		val indexedOperand = incInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
	
	/**
	 * Check INC instruction with duplicate label 
	 */
	@Test 
	def void testINCWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start		NOP
					NOP    
		Start      	INC		  		<Const+2
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.instructionLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"Label Start is already defined"
		)
	}
	
	/**
	 * Check Assembled INC direct mode instruction  
	 */
	@Test 
	def void testINCDirectInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	<Const*2  ; 8000   0C 0A        START:    INC   <Const*2 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x0C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x0A, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   0C 0A        START:    INC   <Const*2 ", line.comment)	
	}
	
	/**
	 * Check Assembled INC direct with limit negative operand  
	 */
	@Test 
	def void testINCDirectInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	<-129
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.incInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -129 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}
	
	/**
	 * Check Assembled INC direct with limit negative operand  
	 */
	@Test 
	def void testINCDirectInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	<-128
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}

	/**
	 * Check Assembled INC direct with positive limit operand  
	 */
	@Test 
	def void testINCDirectInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	<127
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}

	/**
	 * Check Assembled INC direct with positive limit operand  
	 */
	@Test 
	def void testINCDirectInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	<128
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.incInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 128 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(0));
	}
	
	/**
	 * Check Assembled INC extended mode instruction  
	 */
	@Test 
	def void testINCExtendedInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	>Const*1000  ; 8000   7C 13 88     START:    INC   >Const*1000 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x7C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   7C 13 88     START:    INC   >Const*1000 ", line.comment)	
	}
	
	/**
	 * Check Assembled INC extended with limit negative operand  
	 */
	@Test 
	def void testINCExtendedInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	>-32769
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.incInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}
	
	/**
	 * Check Assembled INC extended with limit negative operand  
	 */
	@Test 
	def void testINCExtendedInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	>-32768
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}

	/**
	 * Check Assembled INC extended with positive limit operand  
	 */
	@Test 
	def void testINCExtendedInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	>65535
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}

	/**
	 * Check Assembled INC extended with positive limit operand  
	 */
	@Test 
	def void testINCExtendedInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	>65536
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.incInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 65536 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}
	
	/**
	 * Check Assembled INC extended indirect mode instruction  
	 */
	@Test 
	def void testINCExtendedIndirectInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[Const*1000]  ; 8000   AB 9F 13 88  START:    INC   [Const*1000]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0x9F, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 9F 13 88  START:    INC   [Const*1000]", line.comment)	
	}
	
	/**
	 * Check Assembled INC extended indirect with limit negative operand  
	 */
	@Test 
	def void testINCExtendedIndirectInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-32769]
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.incInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}
	
	/**
	 * Check Assembled INC extended indirect with limit negative operand  
	 */
	@Test 
	def void testINCExtendedIndirectInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-32768]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}

	/**
	 * Check Assembled INC extended indirect with positive limit operand  
	 */
	@Test 
	def void testINCExtendedIndirectInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[65535]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}

	/**
	 * Check Assembled INC extended indirect with positive limit operand  
	 */
	@Test 
	def void testINCExtendedIndirectInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[65536]
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.incInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 65536 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}
	
	/**
	 * Check Assembled INC Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedAccumulatorMovingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	A,X  ; 8000   AB 86        START:    INC   A,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x86, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 86        START:    INC   A,X", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedAccumulatorMovingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	A,Y  ; 8000   	6C A6        START:    INC   A,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C A6        START:    INC   A,Y", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedAccumulatorMovingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	A,U  ; 8000   	6C C6        START:    INC   A,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C C6        START:    INC   A,U", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedAccumulatorMovingMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	A,S  ; 8000   	6C E6        START:    INC   A,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C E6        START:    INC   A,S", line.comment)	
	}
	
	/**
	 * Check Assembled INC Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedAccumulatorMovingMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	B,X  ; 8000   AB 85        START:    INC   B,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x85, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 85        START:    INC   B,X", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedAccumulatorMovingMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	B,Y  ; 8000   	6C A5        START:    INC   B,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C A5        START:    INC   B,Y", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedAccumulatorMovingMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	B,U  ; 8000   	6C C5        START:    INC   B,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C C5        START:    INC   B,U", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedAccumulatorMovingMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	B,S  ; 8000   	6C E5        START:    INC   B,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C E5        START:    INC   B,S", line.comment)	
	}
	
	/**
	 * Check Assembled INC Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedAccumulatorMovingMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	D,X  ; 8000   AB 8B        START:    INC   D,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8B, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 8B        START:    INC   D,X", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedAccumulatorMovingMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	D,Y  ; 8000   	6C AB        START:    INC   D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xAB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C AB        START:    INC   D,Y", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedAccumulatorMovingMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	D,U  ; 8000   	6C CB        START:    INC   D,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xCB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C CB        START:    INC   D,U", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedAccumulatorMovingMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	D,S  ; 8000   	6C EB        START:    INC   D,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xEB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C EB        START:    INC   D,S", line.comment)	
	}
	
	/**
	 * Check Assembled INC Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedIndorectAccumulatorMovingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[A,X]  ; 8000   AB 96        START:    INC   [A,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x96, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 96        START:    INC   [A,X]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedIndirectAccumulatorMovingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[A,Y]  ; 8000   	6C B6        START:    INC   [A,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C B6        START:    INC   [A,Y]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedIndirectAccumulatorMovingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[A,U]  ; 8000   	6C D6        START:    INC   [A,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C D6        START:    INC   [A,U]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedIndirectAccumulatorMovingMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[A,S]  ; 8000   	6C F6        START:    INC   [A,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C F6        START:    INC   [A,S]", line.comment)	
	}
	
	/**
	 * Check Assembled INC Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedIndirectAccumulatorMovingMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[B,X]  ; 8000   AB 95        START:    INC   [B,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x95, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 95        START:    INC   [B,X]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedIndirectAccumulatorMovingMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[B,Y]  ; 8000   	6C B5        START:    INC   [B,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C B5        START:    INC   [B,Y]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedIndirectAccumulatorMovingMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[B,U]  ; 8000   	6C D5        START:    INC   [B,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C D5        START:    INC   [B,U]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedIndirectAccumulatorMovingMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[B,S]  ; 8000   	6C F5        START:    INC   [B,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C F5        START:    INC   [B,S]", line.comment)	
	}
	
	/**
	 * Check Assembled INC Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedIndirectAccumulatorMovingMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[D,X]  ; 8000   AB 9B        START:    INC   [D,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9B, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   AB 9B        START:    INC   [D,X]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedIndirectAccumulatorMovingMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[D,Y]  ; 8000   	6C BB        START:    INC   [D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xBB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C BB        START:    INC   [D,Y]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedIndirectAccumulatorMovingMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[D,U]  ; 8000   	6C DB        START:    INC   [D,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xDB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C DB        START:    INC   [D,U]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testINCIndexedIndirectAccumulatorMovingMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[D,S]  ; 8000   	6C FB        START:    INC   [D,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xFB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C FB        START:    INC   [D,S]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	,X+  ; 8000   	6C 80        START:    INC   ,X+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 80        START:    INC   ,X+", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	,X++  ; 8000   	6C 81        START:    INC   ,X++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x81, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 81        START:    INC   ,X++", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	,Y+  ; 8000   	6C A0        START:    INC   ,Y+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C A0        START:    INC   ,Y+", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	,Y++  ; 8000   	6C A1        START:    INC   ,Y++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C A1        START:    INC   ,Y++", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	,S+  ; 8000   	6C E0        START:    INC   ,S+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C E0        START:    INC   ,S+", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	,S++  ; 8000   	6C E1        START:    INC   ,S++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C E1        START:    INC   ,S++", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	,U+  ; 8000   	6C C0        START:    INC   ,U+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C C0        START:    INC   ,U+", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	,U++  ; 8000   	6C C1        START:    INC   ,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C C1        START:    INC   ,U++", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	,-X  ; 8000   	6C 82        START:    INC   ,-X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x82, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 82        START:    INC   ,-X", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	,--X  ; 8000   	6C 83        START:    INC   ,--X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x83, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 83        START:    INC   ,--X", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	,-Y  ; 8000   	6C A2        START:    INC   ,-Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C A2        START:    INC   ,-Y", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	,--Y  ; 8000   	6C A3        START:    INC   ,--Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C A3        START:    INC   ,--Y", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementMode13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	,-S  ; 8000   	6C E2        START:    INC   ,-S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C E2        START:    INC   ,-S", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementMode14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	,--S  ; 8000   	6C E3        START:    INC   ,--S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C E3        START:    INC   ,--S", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementMode15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	,-U  ; 8000   	6C C2        START:    INC   ,-U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C C2        START:    INC   ,-U", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementMode16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	,--U  ; 8000   	6C C3        START:    INC   ,--U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C C3        START:    INC   ,--U", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementIndirectMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[,X+]  ; 8000   	6C 80        START:    INC   ,X+
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Mode indorect instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementIndirectMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[,X++]  ; 8000   	6C 91        START:    INC   [,X++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x91, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 91        START:    INC   [,X++]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Mode indirect instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementIndirectMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[,Y+]  ; 8000   	6C A0        START:    INC   ,Y+
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementIndirectMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[,Y++]  ; 8000   	6C B1        START:    INC   [,Y++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C B1        START:    INC   [,Y++]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementIndirectMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[,S+]  ; 8000   	6C E0        START:    INC   [,S+]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementIndirectMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[,S++]  ; 8000   	6C F1        START:    INC   [,S++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C F1        START:    INC   [,S++]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementIndirectMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[,U+]  ; 8000   	6C C0        START:    INC   [,U+]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementindirectMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[,U++]  ; 8000   	6C D1        START:    INC   [,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C D1        START:    INC   [,U++]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementIndirectMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[,-X]  ; 8000   	6C 82        START:    INC   [,-X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementIndirectMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[,--X]  ; 8000   	6C 93        START:    INC   [,--X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x93, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 93        START:    INC   [,--X]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement INdirect Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementIndirectMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[,-Y]  ; 8000   	6C A2        START:    INC   [,-Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementIndirectMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[,--Y]  ; 8000   	6C B3        START:    INC   [,--Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C B3        START:    INC   [,--Y]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementIndirectMode13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[,-S]  ; 8000   	6C E2        START:    INC   [,-S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementIndirectMode14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[,--S]  ; 8000   	6C F3        START:    INC   [,--S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C F3        START:    INC   [,--S]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement indirect Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementIndirectMode15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[,-U]  ; 8000   	6C C2        START:    INC   [,-U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled INC Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testINCIndexedAutoIncrementDecrementIndirectMode16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	INC		  	[,--U]  ; 8000   	6C D3        START:    INC   [,--U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C D3        START:    INC   [,--U]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	1234,X  ; 8000   	6C 89 04 D2            INC   1234,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 89 04 D2            INC   1234,X", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	1234,Y  ; 8000   	6C A9 04 D2            INC   1234,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C A9 04 D2            INC   1234,Y", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	1234,U  ; 8000   	6C C9 04 D2            INC   1234,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C C9 04 D2            INC   1234,U", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	1234,S  ; 8000   	6C E9 04 D2            INC   1234,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C E9 04 D2            INC   1234,S", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	34,X  ; 8000   	6C 88 22            INC   34,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 88 22            INC   34,X", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	34,Y  ; 8000   	6C A8 22            INC   34,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C A8 22            INC   34,Y", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	34,U  ; 8000   	6C C8 22            INC   34,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C C8 22            INC   34,U", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	34,S  ; 8000   	6C E8 22            INC   34,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C E8 22            INC   34,S", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	,X  ; 8000   	6C 84            INC   ,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 84            INC   ,X", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	,Y  ; 8000   	6C A4            INC   ,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C A4            INC   ,Y", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	,U  ; 8000   	6C C4            INC   ,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C C4            INC   ,U", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	,S  ; 8000   	6C E4            INC   ,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C E4            INC   ,S", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	0,X  ; 8000   	6C 84            INC   0,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 84            INC   0,X", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	0,Y  ; 8000   	6C A4            INC   0,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C A4            INC   0,Y", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	0,U  ; 8000   	6C C4            INC   0,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C C4            INC   0,U", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	0,S  ; 8000   	6C E4            INC   0,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C E4            INC   0,S", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove17() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-16,X  ; 8000   	6C 10            INC   -16,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x10, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 10            INC   -16,X", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove19() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	1,X  ; 8000   	6C 01            INC   1,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x01, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 01            INC   1,X", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove20() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	15,X  ; 8000   	6C 0F            INC   15,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 0F            INC   15,X", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove21() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-16,Y  ; 8000   	6C 30            INC   -16,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x30, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 30            INC   -16,Y", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove23() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	1,Y  ; 8000   	6C 21            INC   1,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x21, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 21            INC   1,Y", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove24() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	15,Y  ; 8000   	6C 2F            INC   15,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x2F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 2F            INC   15,Y", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove25() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-16,U  ; 8000   	6C 50            INC   -16,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x50, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 50            INC   -16,U", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove26() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	1,U  ; 8000   	6C 41            INC   1,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x41, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 41            INC   1,U", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove27() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	15,U  ; 8000   	6C 4F            INC   15,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x4F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 4F            INC   15,U", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove28() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-16,S  ; 8000   	6C 70            INC   -16,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x70, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 70            INC   -16,S", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove29() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	1,S  ; 8000   	6C 61            INC   1,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x61, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 61            INC   1,S", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove30() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	15,S  ; 8000   	6C 6F            INC   15,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x6F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 6F            INC   15,S", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove31() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-128,X  ; 8000   	6C 88 80            INC   -128,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 88 80            INC   -128,X", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove32() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	127,X  ; 8000   	6C 88 7F            INC   127,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 88 7F            INC   127,X", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove33() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-128,Y  ; 8000   	6C A8 80            INC   -128,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C A8 80            INC   -128,Y", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove34() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	127,Y  ; 8000   	6C A8 7F            INC   127,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C A8 7F            INC   127,Y", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove35() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-128,U  ; 8000   	6C C8 80            INC   -128,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C C8 80            INC   -128,U", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove36() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	127,U  ; 8000   	6C C8 7F            INC   127,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C C8 7F            INC   127,U", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove37() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-128,S  ; 8000   	6C E8 80            INC   -128,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C E8 80            INC   -128,S", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove38() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	127,S  ; 8000   	6C E8 7F            INC   127,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C E8 7F            INC   127,S", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove39() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-32768,X  ; 8000   	6C 89 80 00             INC   -32768,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 89 80 00             INC   -32768,X", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove40() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  32767,X  ; 8000   	6C 89 7F FF             INC   32767,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 89 7F FF             INC   32767,X", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove41() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-32768,Y  ; 8000   	6C A9 80 00             INC   -32768,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C A9 80 00             INC   -32768,Y", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove42() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  32767,Y  ; 8000   	6C A9 7F FF             INC   32767,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C A9 7F FF             INC   32767,Y", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove43() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-32768,U  ; 8000   	6C C9 80 00             INC   -32768,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C C9 80 00             INC   -32768,U", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove44() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  32767,U  ; 8000   	6C C9 7F FF             INC   32767,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C C9 7F FF             INC   32767,U", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove45() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-32768,S  ; 8000   	6C E9 80 00             INC   -32768,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C E9 80 00             INC   -32768,S", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove46() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  32767,S  ; 8000   	6C E9 7F FF             INC   32767,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C E9 7F FF             INC   32767,S", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove47() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-32769,X  ; 8000   	6C 89 80 00             INC   -32769,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 89 80 00             INC   -32769,X", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove48() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  32768,X  ; 8000   	6C 89 7F FF             INC   32768,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 89 7F FF             INC   32768,X", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove49() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-32769,Y  ; 8000   	6C A9 80 00             INC   -32769,Y
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C A9 80 00             INC   -32769,Y", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove50() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  32768,Y  ; 8000   	6C A9 7F FF             INC   32768,Y
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C A9 7F FF             INC   32768,Y", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove51() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-32769,U  ; 8000   	6C C9 80 00             INC   -32769,U
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C C9 80 00             INC   -32769,U", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove52() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  32768,U  ; 8000   	6C C9 7F FF             INC   32768,U
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C C9 7F FF             INC   32768,U", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove53() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-32769,S  ; 8000   	6C E9 80 00             INC   -32769,S
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C E9 80 00             INC   -32769,S", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantMove54() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  32768,S  ; 8000   	6C E9 7F FF             INC   32768,S
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C E9 7F FF             INC   32768,S", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[1234,X]  ; 8000   	6C 99 04 D2            INC   [1234,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 99 04 D2            INC   [1234,X]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[1234,Y]  ; 8000   	6C B9 04 D2            INC   [1234,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C B9 04 D2            INC   [1234,Y]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[1234,U]  ; 8000   	6C D9 04 D2            INC   [1234,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C D9 04 D2            INC   [1234,U]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[1234,S]  ; 8000   	6C F9 04 D2            INC   [1234,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C F9 04 D2            INC   [1234,S]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[34,X]  ; 8000   	6C 98 22            INC   [34,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 98 22            INC   [34,X]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[34,Y]  ; 8000   	6C B8 22            INC   [34,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C B8 22            INC   [34,Y]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[34,U]  ; 8000   	6C D8 22            INC   [34,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C D8 22            INC   [34,U]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[34,S]  ; 8000   	6C F8 22            INC   [34,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C F8 22            INC   [34,S]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[,X]  ; 8000   	6C 94            INC   [,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 94            INC   [,X]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[,Y]  ; 8000   	6C B4            INC   [,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C B4            INC   [,Y]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[,U]  ; 8000   	6C D4            INC   [,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C D4            INC   [,U]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[,S]  ; 8000   	6C F4            INC   [,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C F4            INC   [,S]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[0,X]  ; 8000   	6C 94            INC   [0,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 94            INC   [0,X]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[0,Y]  ; 8000   	6C B4            INC   [0,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C B4            INC   [0,Y]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[0,U]  ; 8000   	6C D4            INC   [0,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C D4            INC   [0,U]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[0,S]  ; 8000   	6C F4            INC   [0,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C F4            INC   [0,S]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove17() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-16,X]  ; 8000   	6C 98 F0            INC   [-16,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 98 F0            INC   [-16,X]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove18() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[15,X]  ; 8000   	6C 98 0F            INC   [15,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 98 0F            INC   [15,X]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove19() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-16,Y]  ; 8000   	6C B8 F0            INC   [-16,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C B8 F0            INC   [-16,Y]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove20() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[15,Y]  ; 8000   	6C B8 0F            INC   [15,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C B8 0F            INC   [15,Y]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove21() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-16,U]  ; 8000   	6C D8 F0            INC   [-16,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C D8 F0            INC   [-16,U]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove22() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[15,U]  ; 8000   	6C D8 0F            INC   [15,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C D8 0F            INC   [15,U]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove23() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-16,S]  ; 8000   	6C F8 F0            INC   [-16,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C F8 F0            INC   [-16,S]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove24() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[15,S]  ; 8000   	6C F8 0F            INC   [15,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C F8 0F            INC   [15,S]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove31() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-128,X]  ; 8000   	6C 98 80            INC   [-128,X}
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 98 80            INC   [-128,X}", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove32() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[127,X]  ; 8000   	6C 98 7F            INC   [127,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 98 7F            INC   [127,X]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove33() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-128,Y]  ; 8000   	6C B8 80            INC   [-128,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C B8 80            INC   [-128,Y]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove34() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[127,Y]  ; 8000   	6C B8 7F            INC   [127,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C B8 7F            INC   [127,Y]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove35() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-128,U]  ; 8000   	6C D8 80            INC   [-128,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C D8 80            INC   [-128,U]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant INdirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove36() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[127,U]  ; 8000   	6C D8 7F            INC   [127,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C D8 7F            INC   [127,U]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove37() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-128,S]  ; 8000   	6C F8 80            INC   [-128,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C F8 80            INC   [-128,S]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove38() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[127,S]  ; 8000   	6C F8 7F            INC   [127,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C F8 7F            INC   [127,S]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove39() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-32768,X]  ; 8000   	6C 99 80 00             INC   [-32768,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 99 80 00             INC   [-32768,X]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove40() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  [32767,X]  ; 8000   	6C 99 7F FF             INC   [32767,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 99 7F FF             INC   [32767,X]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove41() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-32768,Y]  ; 8000   	6C B9 80 00             INC   [-32768,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C B9 80 00             INC   [-32768,Y]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove42() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  [32767,Y]  ; 8000   	6C B9 7F FF             INC   [32767,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C B9 7F FF             INC   [32767,Y]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove43() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-32768,U]  ; 8000   	6C D9 80 00             INC   [-32768,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C D9 80 00             INC   [-32768,U]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove44() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  [32767,U]  ; 8000   	6C D9 7F FF             INC   [32767,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C D9 7F FF             INC   [32767,U]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove45() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-32768,S]  ; 8000   	6C F9 80 00             INC   [-32768,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C F9 80 00             INC   [-32768,S]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove46() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  [32767,S]  ; 8000   	6C F9 7F FF             INC   [32767,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C F9 7F FF             INC   [32767,S]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove47() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-32769,X]  ; 8000   	6C 99 80 00             INC   [-32769,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 99 80 00             INC   [-32769,X]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove48() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  [32768,X]  ; 8000   	6C 99 7F FF             INC   [32768,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 99 7F FF             INC   [32768,X]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove49() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-32769,Y]  ; 8000   	6C B9 80 00             INC   [-32769,Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C B9 80 00             INC   [-32769,Y]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove50() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  [32768,Y]  ; 8000   	6C B9 7F FF             INC   [32768,Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C B9 7F FF             INC   [32768,Y]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove51() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-32769,U]  ; 8000   	6C D9 80 00             INC   [-32769,U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C D9 80 00             INC   [-32769,U]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove52() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  [32768,U]  ; 8000   	6C D9 7F FF             INC   [32768,U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C D9 7F FF             INC   [32768,U]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove53() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-32769,S]  ; 8000   	6C F9 80 00             INC   [-32769,S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C F9 80 00             INC   [-32769,S]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testINCIndexedConstantIndirectMove54() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  [32768,S]  ; 8000   	6C F9 7F FF             INC   [32768,S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C F9 7F FF             INC   [32768,S]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testINCIndexedRelatifToPCMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	0,PCR  ; 8000   	6C 8C 00            INC   0,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 8C 00            INC   0,PCR", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testINCIndexedRelatifToPCMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-128,PCR  ; 8000   	6C 8C 80            INC   -128,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 8C 80            INC   -128,PCR", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testINCIndexedRelatifToPCMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	127,PCR  ; 8000   	6C 8C 7F            INC   127,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 8C 7F            INC   127,PCR", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testINCIndexedRelatifToPCMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-129,PCR  ; 8000   	6C 8D FF 7F            INC   -129,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 8D FF 7F            INC   -129,PCR", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testINCIndexedRelatifToPCMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	128,PCR  ; 8000   	6C 8D 00 80            INC   128,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 8D 00 80            INC   128,PCR", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testINCIndexedRelatifToPCMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-32768,PCR  ; 8000   	6C 8D 80 00            INC   -32768,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 8D 80 00            INC   -32768,PCR", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testINCIndexedRelatifToPCMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	32767,PCR  ; 8000   	6C 8D 7F FF            INC   32767,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 8D 7F FF            INC   32767,PCR", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testINCIndexedRelatifToPCMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	-32769,PCR  ; 8000   	6C 8D 80 00            INC   -32769,PCR
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value -32769 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 8D 80 00            INC   -32769,PCR", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testINCIndexedRelatifToPCMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	32768,PCR  ; 8000   	6C 8D 7F FF            INC   32768,PCR
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value 32768 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 8D 7F FF            INC   32768,PCR", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testINCIndexedRelatifIndirectToPCMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[0,PCR]  ; 8000   	6C 9C 00            INC   [0,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 9C 00            INC   [0,PCR]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testINCIndexedRelatifIndirectToPCMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-128,PCR]  ; 8000   	6C 9C 80            INC   [-128,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 9C 80            INC   [-128,PCR]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testINCIndexedRelatifIndirectToPCMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[127,PCR]  ; 8000   	6C 9C 7F            INC   [127,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 9C 7F            INC   [127,PCR]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testINCIndexedRelatifIndirectToPCMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-129,PCR]  ; 8000   	6C 9D FF 7F            INC   [-129,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 9D FF 7F            INC   [-129,PCR]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testINCIndexedRelatifIndirectToPCMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[128,PCR]  ; 8000   	6C 9D 00 80            INC   [128,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 9D 00 80            INC   [128,PCR]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testINCIndexedRelatifIndirectToPCMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-32768,PCR]  ; 8000   	6C 9D 80 00            INC   [-32768,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 9D 80 00            INC   [-32768,PCR]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testINCIndexedRelatifIndirectToPCMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[32767,PCR]  ; 8000   	6C 9D 7F FF            INC   [32767,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 9D 7F FF            INC   [32767,PCR]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testINCIndexedRelatifIndirectToPCMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[-32769,PCR]  ; 8000   	6C 9D 80 00            INC   [-32769,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value -32769 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 9D 80 00            INC   [-32769,PCR]", line.comment)	
	}

	/**
	 * Check Assembled INC Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testINCIndexedRelatifIndirectToPCMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	INC		  	[32768,PCR]  ; 8000   	6C 9D 7F FF            INC   [32768,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.incInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value 32768 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledINCInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0x6C, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	6C 9D 7F FF            INC   [32768,PCR]", line.comment)	
	}
}