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
import org.bpy.electronics.mc6809.assembler.assembler.AslInstruction
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

class TestASLInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check ASLA with extra space
	 */
	@Test 
	def void testSimpleASLAWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ASLA  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Asl Accumulateur line", instructionLine.instruction instanceof AslInstruction)
		val aslInstruction = instructionLine.instruction as AslInstruction
		Assert.assertEquals("Must be an ASLA instruction", "ASLA", aslInstruction.instruction)
	}
	
	/**
	 * Check ASLA with extra space
	 */
	@Test 
	def void testSimpleASLAWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       ASLA
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Asl Accumulateur line", instructionLine.instruction instanceof AslInstruction)
		val aslInstruction = instructionLine.instruction as AslInstruction
		Assert.assertEquals("Must be an ASLA instruction", "ASLA", aslInstruction.instruction)
	}
	
	/**
	 * Check ASLA with extra space
	 */
	@Test 
	def void testSimpleASLAWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       ASLA  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Asl Accumulateur line", instructionLine.instruction instanceof AslInstruction)
		val aslInstruction = instructionLine.instruction as AslInstruction
		Assert.assertEquals("Must be an ASLA instruction", "ASLA", aslInstruction.instruction)
	}
	
	/**
	 * Check ASLA with extra space
	 */
	@Test 
	def void testSimpleASLAWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       ASLA					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Asl Accumulateur line", instructionLine.instruction instanceof AslInstruction)
		val aslInstruction = instructionLine.instruction as AslInstruction
		Assert.assertEquals("Must be an ASLA instruction", "ASLA", aslInstruction.instruction)
	}
	
	/**
	 * Check ASLB with extra space
	 */
	@Test 
	def void testSimpleASLBWithExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ASLB  
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Asl Accumulateur line", instructionLine.instruction instanceof AslInstruction)
		val aslInstruction = instructionLine.instruction as AslInstruction
		Assert.assertEquals("Must be an ASLB instruction", "ASLB", aslInstruction.instruction)
	}
	
	/**
	 * Check ASLB with extra space
	 */
	@Test 
	def void testSimpleASLBWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       ASLB
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Asl Accumulateur line", instructionLine.instruction instanceof AslInstruction)
		val aslInstruction = instructionLine.instruction as AslInstruction
		Assert.assertEquals("Must be an ASLB instruction", "ASLB", aslInstruction.instruction)
	}
	
	/**
	 * Check ASLB with extra space
	 */
	@Test 
	def void testSimpleASLBWithExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
			       ASLB  			; It is a comment 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Asl Accumulateur line", instructionLine.instruction instanceof AslInstruction)
		val aslInstruction = instructionLine.instruction as AslInstruction
		Assert.assertEquals("Must be an ASLB instruction", "ASLB", aslInstruction.instruction)
	}
	
	/**
	 * Check ASLB with extra space
	 */
	@Test 
	def void testSimpleASLBWithoutExtraSpaceWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       ASLB					; It is a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an Asl Accumulateur line", instructionLine.instruction instanceof AslInstruction)
		val aslInstruction = instructionLine.instruction as AslInstruction
		Assert.assertEquals("Must be an ASLB instruction", "ASLB", aslInstruction.instruction)
	}
	
		/**
	 * Check ASL direct mode 
	 */
	@Test 
	def void testASLDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ASL		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AslInstruction)

		val AslInstruction = instructionLine.instruction as AslInstruction
		assertEquals("Must be an ASL instruction", AslInstruction.instruction,"ASL")
		assertTrue("Must be a direct addressing mode", AslInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check ASL extended mode 
	 */
	@Test 
	def void testASLExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ASL		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AslInstruction)

		val AslInstruction = instructionLine.instruction as AslInstruction
		assertEquals("Must be an ASL instruction", AslInstruction.instruction,"ASL")
		assertTrue("Must be a extended addressing mode", AslInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ASL extended mode 
	 */
	@Test 
	def void testASLExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ASL		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AslInstruction)

		val AslInstruction = instructionLine.instruction as AslInstruction
		assertEquals("Must be an ASL instruction", AslInstruction.instruction,"ASL")
		assertTrue("Must be a extended addressing mode", AslInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ASL extended indirect mode 
	 */
	@Test 
	def void testASLExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ASL		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AslInstruction)

		val AslInstruction = instructionLine.instruction as AslInstruction
		assertEquals("Must be an ASL instruction", AslInstruction.instruction,"ASL")
		assertTrue("Must be a extended indirect addressing mode", AslInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check ASL Constant-Offset Indexed 
	 */
	@Test 
	def void testASLConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ASL		  	Const,X
					ASL		  	,X
					ASL		  	$9,U
					ASL		  	$9,S
					ASL		  	$9,X
					ASL		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AslInstruction)

		val AslInstruction = instructionLine.instruction as AslInstruction
		assertEquals("Must be an ASL instruction", AslInstruction.instruction,"ASL")
		assertTrue("Must be a Constant-Offset Indexed mode", AslInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AslInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check ASL Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testASLConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ASL		  	[Const,X]
					ASL		  	[,X]
					ASL		  	[$9,U]
					ASL		  	[$9,S]
					ASL		  	[$9,X]
					ASL		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AslInstruction)

		val AslInstruction = instructionLine.instruction as AslInstruction
		assertEquals("Must be an ASL instruction", AslInstruction.instruction,"ASL")
		assertTrue("Must be a Constant-Offset Indexed mode", AslInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AslInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check ASL Accumulator Indexed 
	 */
	@Test 
	def void testASLAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ASL		  	A,X
					ASL		  	B,X
					ASL		  	D,U
					ASL		  	A,S
					ASL		  	B,X
					ASL		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AslInstruction)

		val AslInstruction = instructionLine.instruction as AslInstruction
		assertEquals("Must be an ASL instruction", AslInstruction.instruction,"ASL")
		assertTrue("Must be a Constant-Offset Indexed mode", AslInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AslInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check ASL Accumulator Indexed Indirect
	 */
	@Test 
	def void testASLAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ASL		  	[A,X]
					ASL		  	[B,X]
					ASL		  	[D,U]
					ASL		  	[A,S]
					ASL		  	[B,X]
					ASL		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AslInstruction)

		val AslInstruction = instructionLine.instruction as AslInstruction
		assertEquals("Must be an ASL instruction", AslInstruction.instruction,"ASL")
		assertTrue("Must be a Constant-Offset Indexed mode", AslInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AslInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check ASL Auto-Increment Indexed 
	 */
	@Test 
	def void testASLAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ASL		  	0,--X
			       	ASL		  	0,-X
			       	ASL		  	Const,X+
			       	ASL		  	Const,X++
			       	ASL		  	0,--S
			       	ASL		  	0,-S
			       	ASL		  	Const,U+
			       	ASL		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AslInstruction)

		val AslInstruction = instructionLine.instruction as AslInstruction
		assertEquals("Must be an ASL instruction", AslInstruction.instruction,"ASL")
		assertTrue("Must be a Constant-Offset Indexed mode", AslInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AslInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check ASL Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testASLAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ASL		  	[0,--X]
			       	ASL		  	[0,-X]
			       	ASL		  	[Const,X+]
			       	ASL		  	[Const,X++]
			       	ASL		  	[0,--S]
			       	ASL		  	[0,-S]
			       	ASL		  	[Const,U+]
			       	ASL		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AslInstruction)

		val AslInstruction = instructionLine.instruction as AslInstruction
		assertEquals("Must be an ASL instruction", AslInstruction.instruction,"ASL")
		assertTrue("Must be a Constant-Offset Indexed mode", AslInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AslInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check ASL Relative to PC Indexed 
	 */
	@Test 
	def void testASLRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ASL		  	0,PCR
			       	ASL		  	,PCR
			       	ASL		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AslInstruction)

		val AslInstruction = instructionLine.instruction as AslInstruction
		assertEquals("Must be an ASL instruction", AslInstruction.instruction,"ASL")
		assertTrue("Must be a Constant-Offset Indexed mode", AslInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AslInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check ASL Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testASLRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ASL		  	[0,PCR]
			       	ASL		  	[,PCR]
			       	ASL		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AslInstruction)

		val AslInstruction = instructionLine.instruction as AslInstruction
		assertEquals("Must be an ASL instruction", AslInstruction.instruction,"ASL")
		assertTrue("Must be a Constant-Offset Indexed mode", AslInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AslInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}