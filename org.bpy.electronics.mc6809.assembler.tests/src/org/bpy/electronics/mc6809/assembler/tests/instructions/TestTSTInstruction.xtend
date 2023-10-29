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
import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertTrue
import org.bpy.electronics.mc6809.assembler.assembler.TstInstruction
import org.bpy.electronics.mc6809.assembler.assembler.IndexedOperand
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCMode
import org.bpy.electronics.mc6809.assembler.assembler.DirectOperand
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedOperand
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedIndirectOperand
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMode
import org.bpy.electronics.mc6809.assembler.assembler.ConstantIndexedMovingIndirectMode
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingMode
import org.bpy.electronics.mc6809.assembler.assembler.AccumulatorMovingIndirectMode
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecMode
import org.bpy.electronics.mc6809.assembler.assembler.AutoIncDecIndirectMode
import org.bpy.electronics.mc6809.assembler.assembler.RelatifToPCIndirectMode

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestTSTInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check TSTA with extra space
	 */
	@Test 
	def void testSimpleTSTAWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       TSTA  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Tst Accumulateur line", instructionLine.instruction instanceof TstInstruction)
		val tstInstruction = instructionLine.instruction as TstInstruction
		Assert.assertEquals("Must be an TSTA instruction", "TSTA", tstInstruction.instruction)
	}
	
	/**
	 * Check TSTA with extra space
	 */
	@Test 
	def void testSimpleTSTAWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       TSTA
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Tst Accumulateur line", instructionLine.instruction instanceof TstInstruction)
		val tstInstruction = instructionLine.instruction as TstInstruction
		Assert.assertEquals("Must be an TSTA instruction", "TSTA", tstInstruction.instruction)
	}
	
	/**
	 * Check TSTA with extra space
	 */
	@Test 
	def void testSimpleTSTAWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       TSTA  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Tst Accumulateur line", instructionLine.instruction instanceof TstInstruction)
		val tstInstruction = instructionLine.instruction as TstInstruction
		Assert.assertEquals("Must be an TSTA instruction", "TSTA", tstInstruction.instruction)
	}
	
	/**
	 * Check TSTA with extra space
	 */
	@Test 
	def void testSimpleTSTAWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       TSTA					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Tst Accumulateur line", instructionLine.instruction instanceof TstInstruction)
		val tstInstruction = instructionLine.instruction as TstInstruction
		Assert.assertEquals("Must be an TSTA instruction", "TSTA", tstInstruction.instruction)
	}
	
	/**
	 * Check TSTB with extra space
	 */
	@Test 
	def void testSimpleTSTBWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       TSTB  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Tst Accumulateur line", instructionLine.instruction instanceof TstInstruction)
		val tstInstruction = instructionLine.instruction as TstInstruction
		Assert.assertEquals("Must be an TSTB instruction", "TSTB", tstInstruction.instruction)
	}
	
	/**
	 * Check TSTB with extra space
	 */
	@Test 
	def void testSimpleTSTBWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       TSTB
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Tst Accumulateur line", instructionLine.instruction instanceof TstInstruction)
		val tstInstruction = instructionLine.instruction as TstInstruction
		Assert.assertEquals("Must be an TSTB instruction", "TSTB", tstInstruction.instruction)
	}
	
	/**
	 * Check TSTB with extra space
	 */
	@Test 
	def void testSimpleTSTBWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       TSTB  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Tst Accumulateur line", instructionLine.instruction instanceof TstInstruction)
		val tstInstruction = instructionLine.instruction as TstInstruction
		Assert.assertEquals("Must be an TSTB instruction", "TSTB", tstInstruction.instruction)
	}
	
	/**
	 * Check TSTB with extra space
	 */
	@Test 
	def void testSimpleTSTBWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       TSTB					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Tst Accumulateur line", instructionLine.instruction instanceof TstInstruction)
		val tstInstruction = instructionLine.instruction as TstInstruction
		Assert.assertEquals("Must be an TSTB instruction", "TSTB", tstInstruction.instruction)
	}
	
		/**
	 * Check TST direct mode 
	 */
	@Test 
	def void testTSTDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       TST		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof TstInstruction)

		val TstInstruction = instructionLine.instruction as TstInstruction
		assertEquals("Must be an TST instruction", TstInstruction.instruction,"TST")
		assertTrue("Must be a direct addressing mode", TstInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check TST extended mode 
	 */
	@Test 
	def void testTSTExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       TST		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof TstInstruction)

		val TstInstruction = instructionLine.instruction as TstInstruction
		assertEquals("Must be an TST instruction", TstInstruction.instruction,"TST")
		assertTrue("Must be a extended addressing mode", TstInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check TST extended mode 
	 */
	@Test 
	def void testTSTExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       TST		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof TstInstruction)

		val TstInstruction = instructionLine.instruction as TstInstruction
		assertEquals("Must be an TST instruction", TstInstruction.instruction,"TST")
		assertTrue("Must be a extended addressing mode", TstInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check TST extended indirect mode 
	 */
	@Test 
	def void testTSTExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       TST		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof TstInstruction)

		val TstInstruction = instructionLine.instruction as TstInstruction
		assertEquals("Must be an TST instruction", TstInstruction.instruction,"TST")
		assertTrue("Must be a extended indirect addressing mode", TstInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check TST Constant-Offset Indexed 
	 */
	@Test 
	def void testTSTConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	TST		  	Const,X
					TST		  	,X
					TST		  	$9,U
					TST		  	$9,S
					TST		  	$9,X
					TST		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof TstInstruction)

		val TstInstruction = instructionLine.instruction as TstInstruction
		assertEquals("Must be an TST instruction", TstInstruction.instruction,"TST")
		assertTrue("Must be a Constant-Offset Indexed mode", TstInstruction.operand instanceof IndexedOperand)
		val indexedOperand = TstInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check TST Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testTSTConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	TST		  	[Const,X]
					TST		  	[,X]
					TST		  	[$9,U]
					TST		  	[$9,S]
					TST		  	[$9,X]
					TST		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof TstInstruction)

		val TstInstruction = instructionLine.instruction as TstInstruction
		assertEquals("Must be an TST instruction", TstInstruction.instruction,"TST")
		assertTrue("Must be a Constant-Offset Indexed mode", TstInstruction.operand instanceof IndexedOperand)
		val indexedOperand = TstInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check TST Accumulator Indexed 
	 */
	@Test 
	def void testTSTAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	TST		  	A,X
					TST		  	B,X
					TST		  	D,U
					TST		  	A,S
					TST		  	B,X
					TST		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof TstInstruction)

		val TstInstruction = instructionLine.instruction as TstInstruction
		assertEquals("Must be an TST instruction", TstInstruction.instruction,"TST")
		assertTrue("Must be a Constant-Offset Indexed mode", TstInstruction.operand instanceof IndexedOperand)
		val indexedOperand = TstInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check TST Accumulator Indexed Indirect
	 */
	@Test 
	def void testTSTAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	TST		  	[A,X]
					TST		  	[B,X]
					TST		  	[D,U]
					TST		  	[A,S]
					TST		  	[B,X]
					TST		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof TstInstruction)

		val TstInstruction = instructionLine.instruction as TstInstruction
		assertEquals("Must be an TST instruction", TstInstruction.instruction,"TST")
		assertTrue("Must be a Constant-Offset Indexed mode", TstInstruction.operand instanceof IndexedOperand)
		val indexedOperand = TstInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check TST Auto-Increment Indexed 
	 */
	@Test 
	def void testTSTAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	TST		  	0,--X
			       	TST		  	0,-X
			       	TST		  	Const,X+
			       	TST		  	Const,X++
			       	TST		  	0,--S
			       	TST		  	0,-S
			       	TST		  	Const,U+
			       	TST		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof TstInstruction)

		val TstInstruction = instructionLine.instruction as TstInstruction
		assertEquals("Must be an TST instruction", TstInstruction.instruction,"TST")
		assertTrue("Must be a Constant-Offset Indexed mode", TstInstruction.operand instanceof IndexedOperand)
		val indexedOperand = TstInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check TST Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testTSTAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	TST		  	[0,--X]
			       	TST		  	[0,-X]
			       	TST		  	[Const,X+]
			       	TST		  	[Const,X++]
			       	TST		  	[0,--S]
			       	TST		  	[0,-S]
			       	TST		  	[Const,U+]
			       	TST		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof TstInstruction)

		val TstInstruction = instructionLine.instruction as TstInstruction
		assertEquals("Must be an TST instruction", TstInstruction.instruction,"TST")
		assertTrue("Must be a Constant-Offset Indexed mode", TstInstruction.operand instanceof IndexedOperand)
		val indexedOperand = TstInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check TST Relative to PC Indexed 
	 */
	@Test 
	def void testTSTRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	TST		  	0,PCR
			       	TST		  	,PCR
			       	TST		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof TstInstruction)

		val TstInstruction = instructionLine.instruction as TstInstruction
		assertEquals("Must be an TST instruction", TstInstruction.instruction,"TST")
		assertTrue("Must be a Constant-Offset Indexed mode", TstInstruction.operand instanceof IndexedOperand)
		val indexedOperand = TstInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check TST Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testTSTRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	TST		  	[0,PCR]
			       	TST		  	[,PCR]
			       	TST		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof TstInstruction)

		val TstInstruction = instructionLine.instruction as TstInstruction
		assertEquals("Must be an TST instruction", TstInstruction.instruction,"TST")
		assertTrue("Must be a Constant-Offset Indexed mode", TstInstruction.operand instanceof IndexedOperand)
		val indexedOperand = TstInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}