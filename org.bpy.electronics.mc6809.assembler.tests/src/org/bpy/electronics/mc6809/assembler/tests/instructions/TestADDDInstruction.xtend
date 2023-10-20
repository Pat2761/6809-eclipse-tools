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
import org.bpy.electronics.mc6809.assembler.assembler.AdddInstruction
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

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestADDDInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check ADDD immediat 
	 */
	@Test 
	def void testADDDImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADDD		  	#1242
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AdddInstruction)

		val AdddInstruction = instructionLine.instruction as AdddInstruction
		assertEquals("Must be an ADDD instruction", AdddInstruction.instruction,"ADDD")
		assertTrue("Must be an immediate addressing mode", AdddInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check ADDD direct mode 
	 */
	@Test 
	def void testADDDDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADDD		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AdddInstruction)

		val AdddInstruction = instructionLine.instruction as AdddInstruction
		assertEquals("Must be an ADDD instruction", AdddInstruction.instruction,"ADDD")
		assertTrue("Must be a direct addressing mode", AdddInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check ADDD extended mode 
	 */
	@Test 
	def void testADDDExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADDD		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AdddInstruction)

		val AdddInstruction = instructionLine.instruction as AdddInstruction
		assertEquals("Must be an ADDD instruction", AdddInstruction.instruction,"ADDD")
		assertTrue("Must be a extended addressing mode", AdddInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ADDD extended mode 
	 */
	@Test 
	def void testADDDExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADDD		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AdddInstruction)

		val AdddInstruction = instructionLine.instruction as AdddInstruction
		assertEquals("Must be an ADDD instruction", AdddInstruction.instruction,"ADDD")
		assertTrue("Must be a extended addressing mode", AdddInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ADDD extended indirect mode 
	 */
	@Test 
	def void testADDDExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADDD		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AdddInstruction)

		val AdddInstruction = instructionLine.instruction as AdddInstruction
		assertEquals("Must be an ADDD instruction", AdddInstruction.instruction,"ADDD")
		assertTrue("Must be a extended indirect addressing mode", AdddInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check ADDD Constant-Offset Indexed 
	 */
	@Test 
	def void testADDDConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDD		  	Const,X
					ADDD		  	,X
					ADDD		  	$9,U
					ADDD		  	$9,S
					ADDD		  	$9,X
					ADDD		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AdddInstruction)

		val AdddInstruction = instructionLine.instruction as AdddInstruction
		assertEquals("Must be an ADDD instruction", AdddInstruction.instruction,"ADDD")
		assertTrue("Must be a Constant-Offset Indexed mode", AdddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AdddInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check ADDD Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testADDDConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDD		  	[Const,X]
					ADDD		  	[,X]
					ADDD		  	[$9,U]
					ADDD		  	[$9,S]
					ADDD		  	[$9,X]
					ADDD		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AdddInstruction)

		val AdddInstruction = instructionLine.instruction as AdddInstruction
		assertEquals("Must be an ADDD instruction", AdddInstruction.instruction,"ADDD")
		assertTrue("Must be a Constant-Offset Indexed mode", AdddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AdddInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check ADDD Accumulator Indexed 
	 */
	@Test 
	def void testADDDAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDD		  	A,X
					ADDD		  	B,X
					ADDD		  	D,U
					ADDD		  	A,S
					ADDD		  	B,X
					ADDD		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AdddInstruction)

		val AdddInstruction = instructionLine.instruction as AdddInstruction
		assertEquals("Must be an ADDD instruction", AdddInstruction.instruction,"ADDD")
		assertTrue("Must be a Constant-Offset Indexed mode", AdddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AdddInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check ADDD Accumulator Indexed Indirect
	 */
	@Test 
	def void testADDDAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDD		  	[A,X]
					ADDD		  	[B,X]
					ADDD		  	[D,U]
					ADDD		  	[A,S]
					ADDD		  	[B,X]
					ADDD		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AdddInstruction)

		val AdddInstruction = instructionLine.instruction as AdddInstruction
		assertEquals("Must be an ADDD instruction", AdddInstruction.instruction,"ADDD")
		assertTrue("Must be a Constant-Offset Indexed mode", AdddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AdddInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check ADDD Auto-Increment Indexed 
	 */
	@Test 
	def void testADDDAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDD		  	0,--X
			       	ADDD		  	0,-X
			       	ADDD		  	Const,X+
			       	ADDD		  	Const,X++
			       	ADDD		  	0,--S
			       	ADDD		  	0,-S
			       	ADDD		  	Const,U+
			       	ADDD		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AdddInstruction)

		val AdddInstruction = instructionLine.instruction as AdddInstruction
		assertEquals("Must be an ADDD instruction", AdddInstruction.instruction,"ADDD")
		assertTrue("Must be a Constant-Offset Indexed mode", AdddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AdddInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check ADDD Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testADDDAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDD		  	[0,--X]
			       	ADDD		  	[0,-X]
			       	ADDD		  	[Const,X+]
			       	ADDD		  	[Const,X++]
			       	ADDD		  	[0,--S]
			       	ADDD		  	[0,-S]
			       	ADDD		  	[Const,U+]
			       	ADDD		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AdddInstruction)

		val AdddInstruction = instructionLine.instruction as AdddInstruction
		assertEquals("Must be an ADDD instruction", AdddInstruction.instruction,"ADDD")
		assertTrue("Must be a Constant-Offset Indexed mode", AdddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AdddInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check ADDD Relative to PC Indexed 
	 */
	@Test 
	def void testADDDRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDD		  	0,PCR
			       	ADDD		  	,PCR
			       	ADDD		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AdddInstruction)

		val AdddInstruction = instructionLine.instruction as AdddInstruction
		assertEquals("Must be an ADDD instruction", AdddInstruction.instruction,"ADDD")
		assertTrue("Must be a Constant-Offset Indexed mode", AdddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AdddInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check ADDD Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testADDDRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDD		  	[0,PCR]
			       	ADDD		  	[,PCR]
			       	ADDD		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AdddInstruction)

		val AdddInstruction = instructionLine.instruction as AdddInstruction
		assertEquals("Must be an ADDD instruction", AdddInstruction.instruction,"ADDD")
		assertTrue("Must be a Constant-Offset Indexed mode", AdddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AdddInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}

}