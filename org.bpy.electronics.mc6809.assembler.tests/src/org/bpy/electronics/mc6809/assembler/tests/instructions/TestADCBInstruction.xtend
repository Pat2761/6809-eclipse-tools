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
import org.bpy.electronics.mc6809.assembler.assembler.AdcInstruction
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
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledADCBInstruction
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestADCBInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check ADCB immediat 
	 */
	@Test 
	def void testADCBImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADCB		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof AdcInstruction)

		val adcInstruction = instructionLine.instruction as AdcInstruction
		assertEquals("Must be an ADCB instruction", adcInstruction.instruction,"ADCB")
		assertTrue("Must be an immediate addressing mode", adcInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check ADCB direct mode 
	 */
	@Test 
	def void testADCBDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADCB		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof AdcInstruction)

		val adcInstruction = instructionLine.instruction as AdcInstruction
		assertEquals("Must be an ADCB instruction", adcInstruction.instruction,"ADCB")
		assertTrue("Must be a direct addressing mode", adcInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check ADCB extended mode 
	 */
	@Test 
	def void testADCBExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADCB		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof AdcInstruction)

		val adcInstruction = instructionLine.instruction as AdcInstruction
		assertEquals("Must be an ADCB instruction", adcInstruction.instruction,"ADCB")
		assertTrue("Must be a extended addressing mode", adcInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ADCB extended mode 
	 */
	@Test 
	def void testADCBExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADCB		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof AdcInstruction)

		val adcInstruction = instructionLine.instruction as AdcInstruction
		assertEquals("Must be an ADCB instruction", adcInstruction.instruction,"ADCB")
		assertTrue("Must be a extended addressing mode", adcInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ADCB extended indirect mode 
	 */
	@Test 
	def void testADCBExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADCB		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof AdcInstruction)

		val adcInstruction = instructionLine.instruction as AdcInstruction
		assertEquals("Must be an ADCB instruction", adcInstruction.instruction,"ADCB")
		assertTrue("Must be a extended indirect addressing mode", adcInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check ADCB Constant-Offset Indexed 
	 */
	@Test 
	def void testADCBConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADCB		  	Const,X
					ADCB		  	,X
					ADCB		  	$9,U
					ADCB		  	$9,S
					ADCB		  	$9,X
					ADCB		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof AdcInstruction)

		val adcInstruction = instructionLine.instruction as AdcInstruction
		assertEquals("Must be an ADCB instruction", adcInstruction.instruction,"ADCB")
		assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.operand instanceof IndexedOperand)
		val indexedOperand = adcInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check ADCB Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testADCBConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADCB		  	[Const,X]
					ADCB		  	[,X]
					ADCB		  	[$9,U]
					ADCB		  	[$9,S]
					ADCB		  	[$9,X]
					ADCB		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof AdcInstruction)

		val adcInstruction = instructionLine.instruction as AdcInstruction
		assertEquals("Must be an ADCB instruction", adcInstruction.instruction,"ADCB")
		assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.operand instanceof IndexedOperand)
		val indexedOperand = adcInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check ADCB Accumulator Indexed 
	 */
	@Test 
	def void testADCBAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADCB		  	A,X
					ADCB		  	B,X
					ADCB		  	D,U
					ADCB		  	A,S
					ADCB		  	B,X
					ADCB		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof AdcInstruction)

		val adcInstruction = instructionLine.instruction as AdcInstruction
		assertEquals("Must be an ADCB instruction", adcInstruction.instruction,"ADCB")
		assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.operand instanceof IndexedOperand)
		val indexedOperand = adcInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check ADCB Accumulator Indexed Indirect
	 */
	@Test 
	def void testADCBAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADCB		  	[A,X]
					ADCB		  	[B,X]
					ADCB		  	[D,U]
					ADCB		  	[A,S]
					ADCB		  	[B,X]
					ADCB		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof AdcInstruction)

		val adcInstruction = instructionLine.instruction as AdcInstruction
		assertEquals("Must be an ADCB instruction", adcInstruction.instruction,"ADCB")
		assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.operand instanceof IndexedOperand)
		val indexedOperand = adcInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check ADCB Auto-Increment Indexed 
	 */
	@Test 
	def void testADCBAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADCB		  	,--X
			       	ADCB		  	,-X
			       	ADCB		  	,X+
			       	ADCB		  	,X++
			       	ADCB		  	,--S
			       	ADCB		  	,-S
			       	ADCB		  	,U+
			       	ADCB		  	,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof AdcInstruction)

		val adcInstruction = instructionLine.instruction as AdcInstruction
		assertEquals("Must be an ADCB instruction", adcInstruction.instruction,"ADCB")
		assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.operand instanceof IndexedOperand)
		val indexedOperand = adcInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check ADCB Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testADCBAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADCB		  	[,--X]
			       	ADCB		  	[,X++]
			       	ADCB		  	[,--S]
			       	ADCB		  	[,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof AdcInstruction)

		val adcInstruction = instructionLine.instruction as AdcInstruction
		assertEquals("Must be an ADCB instruction", adcInstruction.instruction,"ADCB")
		assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.operand instanceof IndexedOperand)
		val indexedOperand = adcInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check ADCB Relative to PC Indexed 
	 */
	@Test 
	def void testADCBRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADCB		  	0,PC
			       	ADCB		  	,PC
			       	ADCB		  	Const,PC
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof AdcInstruction)

		val adcInstruction = instructionLine.instruction as AdcInstruction
		assertEquals("Must be an ADCB instruction", adcInstruction.instruction,"ADCB")
		assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.operand instanceof IndexedOperand)
		val indexedOperand = adcInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check ADCB Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testADCBRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADCB		  	[0,PC]
			       	ADCB		  	[,PC]
			       	ADCB		  	[Const,PC]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADC directive line", instructionLine.instruction instanceof AdcInstruction)

		val adcInstruction = instructionLine.instruction as AdcInstruction
		assertEquals("Must be an ADCB instruction", adcInstruction.instruction,"ADCB")
		assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.operand instanceof IndexedOperand)
		val indexedOperand = adcInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
	
	/**
	 * Check ADCB instruction with duplicate label 
	 */
	@Test 
	def void testADCBWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start		NOP
					NOP    
		Start      	ADCB		  	#Const+2
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.instructionLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"Label Start is already defined"
		)
	}
	
	/**
	 * Check Assembled ADCB immediate instruction  
	 */
	@Test 
	def void testADCBImmediatInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	#Const+2  ; 8000   C9 07        START:    ADCB
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xC9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x07, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   C9 07        START:    ADCB", line.comment)	
	}
	
	/**
	 * Check Assembled ADCB immediate with limit negative operand  
	 */
	@Test 
	def void testADCBImmediatInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	#-129
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.adcInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -129 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}
	
	/**
	 * Check Assembled ADCB immediate with limit negative operand  
	 */
	@Test 
	def void testADCBImmediatInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	#-128
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}

	/**
	 * Check Assembled ADCB immediate with positive limit operand  
	 */
	@Test 
	def void testADCBImmediatInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	#255
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
	}

	/**
	 * Check Assembled ADCB immediate with positive limit operand  
	 */
	@Test 
	def void testADCBImmediatInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	#256
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.adcInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 256 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
	}
	
	/**
	 * Check Assembled ADCB direct mode instruction  
	 */
	@Test 
	def void testADCBDirectInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	<Const*2  ; 8000   D9 0A        START:    ADCB   <Const*2 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xD9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x0A, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   D9 0A        START:    ADCB   <Const*2 ", line.comment)	
	}
	
	/**
	 * Check Assembled ADCB direct with limit negative operand  
	 */
	@Test 
	def void testADCBDirectInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	<-129
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.adcInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -129 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}
	
	/**
	 * Check Assembled ADCB direct with limit negative operand  
	 */
	@Test 
	def void testADCBDirectInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	<-128
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
	}

	/**
	 * Check Assembled ADCB direct with positive limit operand  
	 */
	@Test 
	def void testADCBDirectInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	<255
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
	}

	/**
	 * Check Assembled ADCB direct with positive limit operand  
	 */
	@Test 
	def void testADCBDirectInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	<256
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.adcInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 256 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
	}
	
	/**
	 * Check Assembled ADCB extended mode instruction  
	 */
	@Test 
	def void testADCBExtendedInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	>Const*1000  ; 8000   F9 13 88     START:    ADCB   >Const*1000 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xF9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   F9 13 88     START:    ADCB   >Const*1000 ", line.comment)	
	}
	
	/**
	 * Check Assembled ADCB extended with limit negative operand  
	 */
	@Test 
	def void testADCBExtendedInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	>-32769
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.adcInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}
	
	/**
	 * Check Assembled ADCB extended with limit negative operand  
	 */
	@Test 
	def void testADCBExtendedInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	>-32768
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}

	/**
	 * Check Assembled ADCB extended with positive limit operand  
	 */
	@Test 
	def void testADCBExtendedInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	>65535
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}

	/**
	 * Check Assembled ADCB extended with positive limit operand  
	 */
	@Test 
	def void testADCBExtendedInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	>65536
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.adcInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 65536 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}
	
	/**
	 * Check Assembled ADCB extended indirect mode instruction  
	 */
	@Test 
	def void testADCBExtendedIndirectInstruction1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[Const*1000]  ; 8000   E9 9F 13 88  START:    ADCB   [Const*1000]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 2, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check opcode", 0x9F, line.opcode.get(1));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x13, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x88, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   E9 9F 13 88  START:    ADCB   [Const*1000]", line.comment)	
	}
	
	/**
	 * Check Assembled ADCB extended indirect with limit negative operand  
	 */
	@Test 
	def void testADCBExtendedIndirectInstruction2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-32769]
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.adcInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value -32769 is below the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}
	
	/**
	 * Check Assembled ADCB extended indirect with limit negative operand  
	 */
	@Test 
	def void testADCBExtendedIndirectInstruction3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-32768]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
	}

	/**
	 * Check Assembled ADCB extended indirect with positive limit operand  
	 */
	@Test 
	def void testADCBExtendedIndirectInstruction4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[65535]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}

	/**
	 * Check Assembled ADCB extended indirect with positive limit operand  
	 */
	@Test 
	def void testADCBExtendedIndirectInstruction5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[65536]
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.adcInstruction,
			ExpressionParser::OVERFLOW_ERROR,	
			"The value 65536 is greater than the possible limit, data may be lost"
		)
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
	}
	
	/**
	 * Check Assembled ADCB Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAccumulatorMovingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	A,X  ; 8000   A9 86        START:    ADCB   A,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x86, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   A9 86        START:    ADCB   A,X", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAccumulatorMovingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	A,Y  ; 8000   	E9 A6        START:    ADCB   A,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 A6        START:    ADCB   A,Y", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAccumulatorMovingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	A,U  ; 8000   	E9 C6        START:    ADCB   A,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 C6        START:    ADCB   A,U", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAccumulatorMovingMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	A,S  ; 8000   	E9 E6        START:    ADCB   A,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 E6        START:    ADCB   A,S", line.comment)	
	}
	
	/**
	 * Check Assembled ADCB Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAccumulatorMovingMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	B,X  ; 8000   A9 85        START:    ADCB   B,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x85, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   A9 85        START:    ADCB   B,X", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAccumulatorMovingMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	B,Y  ; 8000   	E9 A5        START:    ADCB   B,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 A5        START:    ADCB   B,Y", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAccumulatorMovingMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	B,U  ; 8000   	E9 C5        START:    ADCB   B,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 C5        START:    ADCB   B,U", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAccumulatorMovingMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	B,S  ; 8000   	E9 E5        START:    ADCB   B,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 E5        START:    ADCB   B,S", line.comment)	
	}
	
	/**
	 * Check Assembled ADCB Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAccumulatorMovingMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	D,X  ; 8000   A9 8B        START:    ADCB   D,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8B, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   A9 8B        START:    ADCB   D,X", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAccumulatorMovingMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	D,Y  ; 8000   	E9 AB        START:    ADCB   D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xAB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 AB        START:    ADCB   D,Y", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAccumulatorMovingMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	D,U  ; 8000   	E9 CB        START:    ADCB   D,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xCB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 CB        START:    ADCB   D,U", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAccumulatorMovingMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	D,S  ; 8000   	E9 EB        START:    ADCB   D,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xEB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 EB        START:    ADCB   D,S", line.comment)	
	}
	
	/**
	 * Check Assembled ADCB Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedIndorectAccumulatorMovingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[A,X]  ; 8000   A9 96        START:    ADCB   [A,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x96, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   A9 96        START:    ADCB   [A,X]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedIndirectAccumulatorMovingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[A,Y]  ; 8000   	E9 B6        START:    ADCB   [A,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 B6        START:    ADCB   [A,Y]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedIndirectAccumulatorMovingMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[A,U]  ; 8000   	E9 D6        START:    ADCB   [A,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 D6        START:    ADCB   [A,U]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedIndirectAccumulatorMovingMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[A,S]  ; 8000   	E9 F6        START:    ADCB   [A,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF6, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 F6        START:    ADCB   [A,S]", line.comment)	
	}
	
	/**
	 * Check Assembled ADCB Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedIndirectAccumulatorMovingMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[B,X]  ; 8000   A9 95        START:    ADCB   [B,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x95, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   A9 95        START:    ADCB   [B,X]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedIndirectAccumulatorMovingMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[B,Y]  ; 8000   	E9 B5        START:    ADCB   [B,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 B5        START:    ADCB   [B,Y]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedIndirectAccumulatorMovingMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[B,U]  ; 8000   	E9 D5        START:    ADCB   [B,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 D5        START:    ADCB   [B,U]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedIndirectAccumulatorMovingMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[B,S]  ; 8000   	E9 F5        START:    ADCB   [B,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF5, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 F5        START:    ADCB   [B,S]", line.comment)	
	}
	
	/**
	 * Check Assembled ADCB Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedIndirectAccumulatorMovingMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[D,X]  ; 8000   A9 9B        START:    ADCB   [D,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9B, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   A9 9B        START:    ADCB   [D,X]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedIndirectAccumulatorMovingMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[D,Y]  ; 8000   	E9 BB        START:    ADCB   [D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xBB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 BB        START:    ADCB   [D,Y]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedIndirectAccumulatorMovingMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[D,U]  ; 8000   	E9 DB        START:    ADCB   [D,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xDB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 DB        START:    ADCB   [D,U]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed indirect Accumulator Moving Mode instruction  
	 */
	@Test 
	def void testADCBIndexedIndirectAccumulatorMovingMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[D,S]  ; 8000   	E9 FB        START:    ADCB   [D,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xFB, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 FB        START:    ADCB   [D,S]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	,X+  ; 8000   	E9 80        START:    ADCB   ,X+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x80, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 80        START:    ADCB   ,X+", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	,X++  ; 8000   	E9 81        START:    ADCB   ,X++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x81, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 81        START:    ADCB   ,X++", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	,Y+  ; 8000   	E9 A0        START:    ADCB   ,Y+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 A0        START:    ADCB   ,Y+", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	,Y++  ; 8000   	E9 A1        START:    ADCB   ,Y++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 A1        START:    ADCB   ,Y++", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	,S+  ; 8000   	E9 E0        START:    ADCB   ,S+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 E0        START:    ADCB   ,S+", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	,S++  ; 8000   	E9 E1        START:    ADCB   ,S++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 E1        START:    ADCB   ,S++", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	,U+  ; 8000   	E9 C0        START:    ADCB   ,U+
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC0, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 C0        START:    ADCB   ,U+", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	,U++  ; 8000   	E9 C1        START:    ADCB   ,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 C1        START:    ADCB   ,U++", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	,-X  ; 8000   	E9 82        START:    ADCB   ,-X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x82, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 82        START:    ADCB   ,-X", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	,--X  ; 8000   	E9 83        START:    ADCB   ,--X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x83, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 83        START:    ADCB   ,--X", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	,-Y  ; 8000   	E9 A2        START:    ADCB   ,-Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 A2        START:    ADCB   ,-Y", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	,--Y  ; 8000   	E9 A3        START:    ADCB   ,--Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 A3        START:    ADCB   ,--Y", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementMode13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	,-S  ; 8000   	E9 E2        START:    ADCB   ,-S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 E2        START:    ADCB   ,-S", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementMode14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	,--S  ; 8000   	E9 E3        START:    ADCB   ,--S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 E3        START:    ADCB   ,--S", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementMode15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	,-U  ; 8000   	E9 C2        START:    ADCB   ,-U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC2, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 C2        START:    ADCB   ,-U", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementMode16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	,--U  ; 8000   	E9 C3        START:    ADCB   ,--U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 C3        START:    ADCB   ,--U", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementIndirectMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[,X+]  ; 8000   	E9 80        START:    ADCB   ,X+
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Mode indorect instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementIndirectMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[,X++]  ; 8000   	E9 91        START:    ADCB   [,X++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x91, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 91        START:    ADCB   [,X++]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Mode indirect instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementIndirectMode3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[,Y+]  ; 8000   	E9 A0        START:    ADCB   ,Y+
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementIndirectMode4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[,Y++]  ; 8000   	E9 B1        START:    ADCB   [,Y++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 B1        START:    ADCB   [,Y++]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementIndirectMode5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[,S+]  ; 8000   	E9 E0        START:    ADCB   [,S+]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementIndirectMode6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[,S++]  ; 8000   	E9 F1        START:    ADCB   [,S++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 F1        START:    ADCB   [,S++]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementIndirectMode7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[,U+]  ; 8000   	E9 C0        START:    ADCB   [,U+]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_INCREMENT,
			"Cannot use post increment with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementindirectMode8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[,U++]  ; 8000   	E9 D1        START:    ADCB   [,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD1, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 D1        START:    ADCB   [,U++]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementIndirectMode9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[,-X]  ; 8000   	E9 82        START:    ADCB   [,-X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementIndirectMode10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[,--X]  ; 8000   	E9 93        START:    ADCB   [,--X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x93, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 93        START:    ADCB   [,--X]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement INdirect Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementIndirectMode11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[,-Y]  ; 8000   	E9 A2        START:    ADCB   [,-Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementIndirectMode12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[,--Y]  ; 8000   	E9 B3        START:    ADCB   [,--Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 B3        START:    ADCB   [,--Y]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementIndirectMode13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[,-S]  ; 8000   	E9 E2        START:    ADCB   [,-S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementIndirectMode14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[,--S]  ; 8000   	E9 F3        START:    ADCB   [,--S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 F3        START:    ADCB   [,--S]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement indirect Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementIndirectMode15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[,-U]  ; 8000   	E9 C2        START:    ADCB   [,-U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::ILLEGAL_DECREMENT,
			"Cannot use pre decrement with 1 for indirect mode"
		)
	}

	/**
	 * Check Assembled ADCB Indexed Auto Increment Decrement Indirect Mode instruction  
	 */
	@Test 
	def void testADCBIndexedAutoIncrementDecrementIndirectMode16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Const	   	EQU          	5
		Start      	ADCB		  	[,--U]  ; 8000   	E9 D3        START:    ADCB   [,--U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(3) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD3, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 D3        START:    ADCB   [,--U]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	1234,X  ; 8000   	E9 89 04 D2            ADCB   1234,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 89 04 D2            ADCB   1234,X", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	1234,Y  ; 8000   	E9 A9 04 D2            ADCB   1234,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 A9 04 D2            ADCB   1234,Y", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	1234,U  ; 8000   	E9 C9 04 D2            ADCB   1234,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 C9 04 D2            ADCB   1234,U", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	1234,S  ; 8000   	E9 E9 04 D2            ADCB   1234,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 E9 04 D2            ADCB   1234,S", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	34,X  ; 8000   	E9 88 22            ADCB   34,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 88 22            ADCB   34,X", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	34,Y  ; 8000   	E9 A8 22            ADCB   34,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 A8 22            ADCB   34,Y", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	34,U  ; 8000   	E9 C8 22            ADCB   34,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 C8 22            ADCB   34,U", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	34,S  ; 8000   	E9 E8 22            ADCB   34,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 E8 22            ADCB   34,S", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	,X  ; 8000   	E9 84            ADCB   ,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 84            ADCB   ,X", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	,Y  ; 8000   	E9 A4            ADCB   ,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 A4            ADCB   ,Y", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	,U  ; 8000   	E9 C4            ADCB   ,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 C4            ADCB   ,U", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	,S  ; 8000   	E9 E4            ADCB   ,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 E4            ADCB   ,S", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	0,X  ; 8000   	E9 84            ADCB   0,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x84, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 84            ADCB   0,X", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	0,Y  ; 8000   	E9 A4            ADCB   0,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 A4            ADCB   0,Y", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	0,U  ; 8000   	E9 C4            ADCB   0,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 C4            ADCB   0,U", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	0,S  ; 8000   	E9 E4            ADCB   0,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 E4            ADCB   0,S", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove17() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-16,X  ; 8000   	E9 10            ADCB   -16,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x10, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 10            ADCB   -16,X", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove19() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	1,X  ; 8000   	E9 01            ADCB   1,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x01, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 01            ADCB   1,X", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove20() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	15,X  ; 8000   	E9 0F            ADCB   15,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 0F            ADCB   15,X", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove21() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-16,Y  ; 8000   	E9 30            ADCB   -16,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x30, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 30            ADCB   -16,Y", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove23() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	1,Y  ; 8000   	E9 21            ADCB   1,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x21, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 21            ADCB   1,Y", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove24() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	15,Y  ; 8000   	E9 2F            ADCB   15,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x2F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 2F            ADCB   15,Y", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove25() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-16,U  ; 8000   	E9 50            ADCB   -16,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x50, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 50            ADCB   -16,U", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove26() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	1,U  ; 8000   	E9 41            ADCB   1,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x41, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 41            ADCB   1,U", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove27() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	15,U  ; 8000   	E9 4F            ADCB   15,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x4F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 4F            ADCB   15,U", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove28() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-16,S  ; 8000   	E9 70            ADCB   -16,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x70, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 70            ADCB   -16,S", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove29() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	1,S  ; 8000   	E9 61            ADCB   1,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x61, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 61            ADCB   1,S", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove30() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	15,S  ; 8000   	E9 6F            ADCB   15,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x6F, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 6F            ADCB   15,S", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove31() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-128,X  ; 8000   	E9 88 80            ADCB   -128,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 88 80            ADCB   -128,X", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove32() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	127,X  ; 8000   	E9 88 7F            ADCB   127,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x88, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 88 7F            ADCB   127,X", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove33() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-128,Y  ; 8000   	E9 A8 80            ADCB   -128,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 A8 80            ADCB   -128,Y", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove34() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	127,Y  ; 8000   	E9 A8 7F            ADCB   127,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 A8 7F            ADCB   127,Y", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove35() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-128,U  ; 8000   	E9 C8 80            ADCB   -128,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 C8 80            ADCB   -128,U", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove36() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	127,U  ; 8000   	E9 C8 7F            ADCB   127,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 C8 7F            ADCB   127,U", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove37() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-128,S  ; 8000   	E9 E8 80            ADCB   -128,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 E8 80            ADCB   -128,S", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove38() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	127,S  ; 8000   	E9 E8 7F            ADCB   127,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 E8 7F            ADCB   127,S", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove39() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-32768,X  ; 8000   	E9 89 80 00             ADCB   -32768,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 89 80 00             ADCB   -32768,X", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove40() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  32767,X  ; 8000   	E9 89 7F FF             ADCB   32767,X
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 89 7F FF             ADCB   32767,X", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove41() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-32768,Y  ; 8000   	E9 A9 80 00             ADCB   -32768,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 A9 80 00             ADCB   -32768,Y", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove42() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  32767,Y  ; 8000   	E9 A9 7F FF             ADCB   32767,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 A9 7F FF             ADCB   32767,Y", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove43() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-32768,U  ; 8000   	E9 C9 80 00             ADCB   -32768,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 C9 80 00             ADCB   -32768,U", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove44() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  32767,U  ; 8000   	E9 C9 7F FF             ADCB   32767,U
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 C9 7F FF             ADCB   32767,U", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove45() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-32768,S  ; 8000   	E9 E9 80 00             ADCB   -32768,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 E9 80 00             ADCB   -32768,S", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove46() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  32767,S  ; 8000   	E9 E9 7F FF             ADCB   32767,S
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 E9 7F FF             ADCB   32767,S", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove47() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-32769,X  ; 8000   	E9 89 80 00             ADCB   -32769,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 89 80 00             ADCB   -32769,X", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove48() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  32768,X  ; 8000   	E9 89 7F FF             ADCB   32768,X
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x89, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 89 7F FF             ADCB   32768,X", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove49() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-32769,Y  ; 8000   	E9 A9 80 00             ADCB   -32769,Y
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 A9 80 00             ADCB   -32769,Y", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove50() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  32768,Y  ; 8000   	E9 A9 7F FF             ADCB   32768,Y
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xA9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 A9 7F FF             ADCB   32768,Y", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove51() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-32769,U  ; 8000   	E9 C9 80 00             ADCB   -32769,U
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 C9 80 00             ADCB   -32769,U", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove52() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  32768,U  ; 8000   	E9 C9 7F FF             ADCB   32768,U
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xC9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 C9 7F FF             ADCB   32768,U", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove53() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-32769,S  ; 8000   	E9 E9 80 00             ADCB   -32769,S
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 E9 80 00             ADCB   -32769,S", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantMove54() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  32768,S  ; 8000   	E9 E9 7F FF             ADCB   32768,S
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xE9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 E9 7F FF             ADCB   32768,S", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[1234,X]  ; 8000   	E9 99 04 D2            ADCB   [1234,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 99 04 D2            ADCB   [1234,X]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[1234,Y]  ; 8000   	E9 B9 04 D2            ADCB   [1234,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 B9 04 D2            ADCB   [1234,Y]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[1234,U]  ; 8000   	E9 D9 04 D2            ADCB   [1234,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 D9 04 D2            ADCB   [1234,U]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[1234,S]  ; 8000   	E9 F9 04 D2            ADCB   [1234,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x04, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xD2, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 F9 04 D2            ADCB   [1234,S]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[34,X]  ; 8000   	E9 98 22            ADCB   [34,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 98 22            ADCB   [34,X]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[34,Y]  ; 8000   	E9 B8 22            ADCB   [34,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 B8 22            ADCB   [34,Y]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[34,U]  ; 8000   	E9 D8 22            ADCB   [34,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 D8 22            ADCB   [34,U]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[34,S]  ; 8000   	E9 F8 22            ADCB   [34,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x22, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 F8 22            ADCB   [34,S]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[,X]  ; 8000   	E9 94            ADCB   [,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 94            ADCB   [,X]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[,Y]  ; 8000   	E9 B4            ADCB   [,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 B4            ADCB   [,Y]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove11() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[,U]  ; 8000   	E9 D4            ADCB   [,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 D4            ADCB   [,U]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove12() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[,S]  ; 8000   	E9 F4            ADCB   [,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 F4            ADCB   [,S]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove13() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[0,X]  ; 8000   	E9 94            ADCB   [0,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0x94, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 94            ADCB   [0,X]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove14() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[0,Y]  ; 8000   	E9 B4            ADCB   [0,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 B4            ADCB   [0,Y]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove15() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[0,U]  ; 8000   	E9 D4            ADCB   [0,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 D4            ADCB   [0,U]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove16() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[0,S]  ; 8000   	E9 F4            ADCB   [0,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 1, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF4, line.operand.get(0));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 F4            ADCB   [0,S]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove17() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-16,X]  ; 8000   	E9 98 F0            ADCB   [-16,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 98 F0            ADCB   [-16,X]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove18() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[15,X]  ; 8000   	E9 98 0F            ADCB   [15,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 98 0F            ADCB   [15,X]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove19() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-16,Y]  ; 8000   	E9 B8 F0            ADCB   [-16,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 B8 F0            ADCB   [-16,Y]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove20() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[15,Y]  ; 8000   	E9 B8 0F            ADCB   [15,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 B8 0F            ADCB   [15,Y]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove21() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-16,U]  ; 8000   	E9 D8 F0            ADCB   [-16,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 D8 F0            ADCB   [-16,U]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove22() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[15,U]  ; 8000   	E9 D8 0F            ADCB   [15,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 D8 0F            ADCB   [15,U]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove23() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-16,S]  ; 8000   	E9 F8 F0            ADCB   [-16,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xF0, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 F8 F0            ADCB   [-16,S]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove24() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[15,S]  ; 8000   	E9 F8 0F            ADCB   [15,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x0F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 F8 0F            ADCB   [15,S]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove31() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-128,X]  ; 8000   	E9 98 80            ADCB   [-128,X}
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 98 80            ADCB   [-128,X}", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove32() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[127,X]  ; 8000   	E9 98 7F            ADCB   [127,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x98, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 98 7F            ADCB   [127,X]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove33() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-128,Y]  ; 8000   	E9 B8 80            ADCB   [-128,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 B8 80            ADCB   [-128,Y]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove34() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[127,Y]  ; 8000   	E9 B8 7F            ADCB   [127,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 B8 7F            ADCB   [127,Y]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove35() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-128,U]  ; 8000   	E9 D8 80            ADCB   [-128,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 D8 80            ADCB   [-128,U]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant INdirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove36() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[127,U]  ; 8000   	E9 D8 7F            ADCB   [127,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 D8 7F            ADCB   [127,U]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove37() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-128,S]  ; 8000   	E9 F8 80            ADCB   [-128,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 F8 80            ADCB   [-128,S]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove38() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[127,S]  ; 8000   	E9 F8 7F            ADCB   [127,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF8, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 F8 7F            ADCB   [127,S]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove39() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-32768,X]  ; 8000   	E9 99 80 00             ADCB   [-32768,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 99 80 00             ADCB   [-32768,X]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove40() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  [32767,X]  ; 8000   	E9 99 7F FF             ADCB   [32767,X]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 99 7F FF             ADCB   [32767,X]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove41() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-32768,Y]  ; 8000   	E9 B9 80 00             ADCB   [-32768,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 B9 80 00             ADCB   [-32768,Y]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove42() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  [32767,Y]  ; 8000   	E9 B9 7F FF             ADCB   [32767,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 B9 7F FF             ADCB   [32767,Y]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove43() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-32768,U]  ; 8000   	E9 D9 80 00             ADCB   [-32768,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 D9 80 00             ADCB   [-32768,U]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove44() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  [32767,U]  ; 8000   	E9 D9 7F FF             ADCB   [32767,U]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 D9 7F FF             ADCB   [32767,U]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove45() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-32768,S]  ; 8000   	E9 F9 80 00             ADCB   [-32768,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 F9 80 00             ADCB   [-32768,S]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove46() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  [32767,S]  ; 8000   	E9 F9 7F FF             ADCB   [32767,S]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 F9 7F FF             ADCB   [32767,S]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove47() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-32769,X]  ; 8000   	E9 99 80 00             ADCB   [-32769,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 99 80 00             ADCB   [-32769,X]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove48() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  [32768,X]  ; 8000   	E9 99 7F FF             ADCB   [32768,X]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x99, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 99 7F FF             ADCB   [32768,X]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove49() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-32769,Y]  ; 8000   	E9 B9 80 00             ADCB   [-32769,Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 B9 80 00             ADCB   [-32769,Y]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove50() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  [32768,Y]  ; 8000   	E9 B9 7F FF             ADCB   [32768,Y]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xB9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 B9 7F FF             ADCB   [32768,Y]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove51() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-32769,U]  ; 8000   	E9 D9 80 00             ADCB   [-32769,U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 D9 80 00             ADCB   [-32769,U]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove52() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  [32768,U]  ; 8000   	E9 D9 7F FF             ADCB   [32768,U]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xD9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 D9 7F FF             ADCB   [32768,U]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove53() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-32769,S]  ; 8000   	E9 F9 80 00             ADCB   [-32769,S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value -32769 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 F9 80 00             ADCB   [-32769,S]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed Constant Indirect move Mode instruction  
	 */
	@Test 
	def void testADCBIndexedConstantIndirectMove54() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  [32768,S]  ; 8000   	E9 F9 7F FF             ADCB   [32768,S]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"Overflow detected for value 32768 , data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0xF9, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 F9 7F FF             ADCB   [32768,S]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testADCBIndexedRelatifToPCMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	0,PCR  ; 8000   	E9 8C 00            ADCB   0,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 8C 00            ADCB   0,PCR", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testADCBIndexedRelatifToPCMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-128,PCR  ; 8000   	E9 8C 80            ADCB   -128,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 8C 80            ADCB   -128,PCR", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testADCBIndexedRelatifToPCMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	127,PCR  ; 8000   	E9 8C 7F            ADCB   127,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 8C 7F            ADCB   127,PCR", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testADCBIndexedRelatifToPCMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-129,PCR  ; 8000   	E9 8D FF 7F            ADCB   -129,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 8D FF 7F            ADCB   -129,PCR", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testADCBIndexedRelatifToPCMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	128,PCR  ; 8000   	E9 8D 00 80            ADCB   128,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 8D 00 80            ADCB   128,PCR", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testADCBIndexedRelatifToPCMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-32768,PCR  ; 8000   	E9 8D 80 00            ADCB   -32768,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 8D 80 00            ADCB   -32768,PCR", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testADCBIndexedRelatifToPCMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	32767,PCR  ; 8000   	E9 8D 7F FF            ADCB   32767,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 8D 7F FF            ADCB   32767,PCR", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testADCBIndexedRelatifToPCMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	-32769,PCR  ; 8000   	E9 8D 80 00            ADCB   -32769,PCR
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value -32769 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 8D 80 00            ADCB   -32769,PCR", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed relatif to PC Mode instruction  
	 */
	@Test 
	def void testADCBIndexedRelatifToPCMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	32768,PCR  ; 8000   	E9 8D 7F FF            ADCB   32768,PCR
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value 32768 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x8D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 8D 7F FF            ADCB   32768,PCR", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testADCBIndexedRelatifIndirectToPCMove1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[0,PCR]  ; 8000   	E9 9C 00            ADCB   [0,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 9C 00            ADCB   [0,PCR]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testADCBIndexedRelatifIndirectToPCMove2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-128,PCR]  ; 8000   	E9 9C 80            ADCB   [-128,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 9C 80            ADCB   [-128,PCR]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testADCBIndexedRelatifIndirectToPCMove3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[127,PCR]  ; 8000   	E9 9C 7F            ADCB   [127,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8003, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 2, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9C, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 9C 7F            ADCB   [127,PCR]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testADCBIndexedRelatifIndirectToPCMove4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-129,PCR]  ; 8000   	E9 9D FF 7F            ADCB   [-129,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 9D FF 7F            ADCB   [-129,PCR]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testADCBIndexedRelatifIndirectToPCMove5() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[128,PCR]  ; 8000   	E9 9D 00 80            ADCB   [128,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 9D 00 80            ADCB   [128,PCR]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testADCBIndexedRelatifIndirectToPCMove6() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-32768,PCR]  ; 8000   	E9 9D 80 00            ADCB   [-32768,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 9D 80 00            ADCB   [-32768,PCR]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testADCBIndexedRelatifIndirectToPCMove7() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[32767,PCR]  ; 8000   	E9 9D 7F FF            ADCB   [32767,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 9D 7F FF            ADCB   [32767,PCR]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testADCBIndexedRelatifIndirectToPCMove8() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[-32769,PCR]  ; 8000   	E9 9D 80 00            ADCB   [-32769,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value -32769 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x80, line.operand.get(1));
		Assert.assertEquals("Check operand", 0x00, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 9D 80 00            ADCB   [-32769,PCR]", line.comment)	
	}

	/**
	 * Check Assembled ADCB Indexed relatif indirect to PC Mode instruction  
	 */
	@Test 
	def void testADCBIndexedRelatifIndirectToPCMove9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
				   	ORG    			$8000
		Start      	ADCB		  	[32768,PCR]  ; 8000   	E9 9D 7F FF            ADCB   [32768,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.adcInstruction,
			AbstractInstructionAssemblyLine::OVERFLOW_ERROR,
			"The value 32768 is out than the possible limit, data may be lost"
		)
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Counter after the instruction",0x8004, engine.currentPcValue)
		
		val line = engine.getAssembledLine(2) as AssembledADCBInstruction
		Assert.assertEquals("Check opcode size ", 1, line.opcode.length);	
		Assert.assertEquals("Check opcode", 0xE9, line.opcode.get(0));	
		Assert.assertEquals("Check operand size ", 3, line.operand.length);	
		Assert.assertEquals("Check operand", 0x9D, line.operand.get(0));
		Assert.assertEquals("Check operand", 0x7F, line.operand.get(1));
		Assert.assertEquals("Check operand", 0xFF, line.operand.get(2));
		Assert.assertEquals("Check Label", "Start", line.label)
		Assert.assertEquals("Check comment", "; 8000   	E9 9D 7F FF            ADCB   [32768,PCR]", line.comment)	
	}
}