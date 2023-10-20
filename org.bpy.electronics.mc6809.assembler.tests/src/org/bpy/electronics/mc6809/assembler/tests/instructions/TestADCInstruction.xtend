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

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestADCInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check ADCA immediat 
	 */
	@Test 
	def void testADCAImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADCA		  	#124
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
		assertEquals("Must be an ADCA instruction", adcInstruction.instruction,"ADCA")
		assertTrue("Must be an immediate addressing mode", adcInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check ADCA direct mode 
	 */
	@Test 
	def void testADCADirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADCA		  	<124
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
		assertEquals("Must be an ADCA instruction", adcInstruction.instruction,"ADCA")
		assertTrue("Must be a direct addressing mode", adcInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check ADCA extended mode 
	 */
	@Test 
	def void testADCAExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADCA		  	$1234
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
		assertEquals("Must be an ADCA instruction", adcInstruction.instruction,"ADCA")
		assertTrue("Must be a extended addressing mode", adcInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ADCA extended mode 
	 */
	@Test 
	def void testADCAExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADCA		  	>$1234
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
		assertEquals("Must be an ADCA instruction", adcInstruction.instruction,"ADCA")
		assertTrue("Must be a extended addressing mode", adcInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ADCA extended indirect mode 
	 */
	@Test 
	def void testADCAExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADCA		  	[$1234]
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
		assertEquals("Must be an ADCA instruction", adcInstruction.instruction,"ADCA")
		assertTrue("Must be a extended indirect addressing mode", adcInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check ADCA Constant-Offset Indexed 
	 */
	@Test 
	def void testADCAConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADCA		  	Const,X
					ADCA		  	,X
					ADCA		  	$9,U
					ADCA		  	$9,S
					ADCA		  	$9,X
					ADCA		  	$9,Y
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
		assertEquals("Must be an ADCA instruction", adcInstruction.instruction,"ADCA")
		assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.operand instanceof IndexedOperand)
		val indexedOperand = adcInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check ADCA Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testADCAConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADCA		  	[Const,X]
					ADCA		  	[,X]
					ADCA		  	[$9,U]
					ADCA		  	[$9,S]
					ADCA		  	[$9,X]
					ADCA		  	[$9,Y]
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
		assertEquals("Must be an ADCA instruction", adcInstruction.instruction,"ADCA")
		assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.operand instanceof IndexedOperand)
		val indexedOperand = adcInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check ADCA Accumulator Indexed 
	 */
	@Test 
	def void testADCAAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADCA		  	A,X
					ADCA		  	B,X
					ADCA		  	D,U
					ADCA		  	A,S
					ADCA		  	B,X
					ADCA		  	D,Y
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
		assertEquals("Must be an ADCA instruction", adcInstruction.instruction,"ADCA")
		assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.operand instanceof IndexedOperand)
		val indexedOperand = adcInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check ADCA Accumulator Indexed Indirect
	 */
	@Test 
	def void testADCAAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADCA		  	[A,X]
					ADCA		  	[B,X]
					ADCA		  	[D,U]
					ADCA		  	[A,S]
					ADCA		  	[B,X]
					ADCA		  	[D,Y]
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
		assertEquals("Must be an ADCA instruction", adcInstruction.instruction,"ADCA")
		assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.operand instanceof IndexedOperand)
		val indexedOperand = adcInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check ADCA Auto-Increment Indexed 
	 */
	@Test 
	def void testADCAAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADCA		  	0,--X
			       	ADCA		  	0,-X
			       	ADCA		  	Const,X+
			       	ADCA		  	Const,X++
			       	ADCA		  	0,--S
			       	ADCA		  	0,-S
			       	ADCA		  	Const,U+
			       	ADCA		  	Const,U++
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
		assertEquals("Must be an ADCA instruction", adcInstruction.instruction,"ADCA")
		assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.operand instanceof IndexedOperand)
		val indexedOperand = adcInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check ADCA Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testADCAAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADCA		  	[0,--X]
			       	ADCA		  	[0,-X]
			       	ADCA		  	[Const,X+]
			       	ADCA		  	[Const,X++]
			       	ADCA		  	[0,--S]
			       	ADCA		  	[0,-S]
			       	ADCA		  	[Const,U+]
			       	ADCA		  	[Const,U++]
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
		assertEquals("Must be an ADCA instruction", adcInstruction.instruction,"ADCA")
		assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.operand instanceof IndexedOperand)
		val indexedOperand = adcInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check ADCA Relative to PC Indexed 
	 */
	@Test 
	def void testADCARelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADCA		  	0,PCR
			       	ADCA		  	,PCR
			       	ADCA		  	Const,PCR
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
		assertEquals("Must be an ADCA instruction", adcInstruction.instruction,"ADCA")
		assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.operand instanceof IndexedOperand)
		val indexedOperand = adcInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check ADCA Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testADCARelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADCA		  	[0,PCR]
			       	ADCA		  	[,PCR]
			       	ADCA		  	[Const,PCR]
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
		assertEquals("Must be an ADCA instruction", adcInstruction.instruction,"ADCA")
		assertTrue("Must be a Constant-Offset Indexed mode", adcInstruction.operand instanceof IndexedOperand)
		val indexedOperand = adcInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}

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
			       	ADCB		  	0,--X
			       	ADCB		  	0,-X
			       	ADCB		  	Const,X+
			       	ADCB		  	Const,X++
			       	ADCB		  	0,--S
			       	ADCB		  	0,-S
			       	ADCB		  	Const,U+
			       	ADCB		  	Const,U++
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
			       	ADCB		  	[0,--X]
			       	ADCB		  	[0,-X]
			       	ADCB		  	[Const,X+]
			       	ADCB		  	[Const,X++]
			       	ADCB		  	[0,--S]
			       	ADCB		  	[0,-S]
			       	ADCB		  	[Const,U+]
			       	ADCB		  	[Const,U++]
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
			       	ADCB		  	0,PCR
			       	ADCB		  	,PCR
			       	ADCB		  	Const,PCR
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
			       	ADCB		  	[0,PCR]
			       	ADCB		  	[,PCR]
			       	ADCB		  	[Const,PCR]
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
}