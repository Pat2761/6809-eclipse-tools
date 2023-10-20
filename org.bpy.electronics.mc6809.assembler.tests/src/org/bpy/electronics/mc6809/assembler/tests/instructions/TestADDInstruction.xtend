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
import org.bpy.electronics.mc6809.assembler.assembler.AddInstruction
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

class TestADDInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check ADDA immediat 
	 */
	@Test 
	def void testADDAImmediatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADDA		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDA instruction", AddInstruction.instruction,"ADDA")
		assertTrue("Must be an immediate addressing mode", AddInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check ADDA direct mode 
	 */
	@Test 
	def void testADDADirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADDA		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDA instruction", AddInstruction.instruction,"ADDA")
		assertTrue("Must be a direct addressing mode", AddInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check ADDA extended mode 
	 */
	@Test 
	def void testADDAExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADDA		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDA instruction", AddInstruction.instruction,"ADDA")
		assertTrue("Must be a extended addressing mode", AddInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ADDA extended mode 
	 */
	@Test 
	def void testADDAExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADDA		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDA instruction", AddInstruction.instruction,"ADDA")
		assertTrue("Must be a extended addressing mode", AddInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ADDA extended indirect mode 
	 */
	@Test 
	def void testADDAExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADDA		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDA instruction", AddInstruction.instruction,"ADDA")
		assertTrue("Must be a extended indirect addressing mode", AddInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check ADDA Constant-Offset Indexed 
	 */
	@Test 
	def void testADDAConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDA		  	Const,X
					ADDA		  	,X
					ADDA		  	$9,U
					ADDA		  	$9,S
					ADDA		  	$9,X
					ADDA		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDA instruction", AddInstruction.instruction,"ADDA")
		assertTrue("Must be a Constant-Offset Indexed mode", AddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AddInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check ADDA Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testADDAConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDA		  	[Const,X]
					ADDA		  	[,X]
					ADDA		  	[$9,U]
					ADDA		  	[$9,S]
					ADDA		  	[$9,X]
					ADDA		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDA instruction", AddInstruction.instruction,"ADDA")
		assertTrue("Must be a Constant-Offset Indexed mode", AddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AddInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check ADDA Accumulator Indexed 
	 */
	@Test 
	def void testADDAAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDA		  	A,X
					ADDA		  	B,X
					ADDA		  	D,U
					ADDA		  	A,S
					ADDA		  	B,X
					ADDA		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDA instruction", AddInstruction.instruction,"ADDA")
		assertTrue("Must be a Constant-Offset Indexed mode", AddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AddInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check ADDA Accumulator Indexed Indirect
	 */
	@Test 
	def void testADDAAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDA		  	[A,X]
					ADDA		  	[B,X]
					ADDA		  	[D,U]
					ADDA		  	[A,S]
					ADDA		  	[B,X]
					ADDA		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDA instruction", AddInstruction.instruction,"ADDA")
		assertTrue("Must be a Constant-Offset Indexed mode", AddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AddInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check ADDA Auto-Increment Indexed 
	 */
	@Test 
	def void testADDAAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDA		  	0,--X
			       	ADDA		  	0,-X
			       	ADDA		  	Const,X+
			       	ADDA		  	Const,X++
			       	ADDA		  	0,--S
			       	ADDA		  	0,-S
			       	ADDA		  	Const,U+
			       	ADDA		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDA instruction", AddInstruction.instruction,"ADDA")
		assertTrue("Must be a Constant-Offset Indexed mode", AddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AddInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check ADDA Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testADDAAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDA		  	[0,--X]
			       	ADDA		  	[0,-X]
			       	ADDA		  	[Const,X+]
			       	ADDA		  	[Const,X++]
			       	ADDA		  	[0,--S]
			       	ADDA		  	[0,-S]
			       	ADDA		  	[Const,U+]
			       	ADDA		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDA instruction", AddInstruction.instruction,"ADDA")
		assertTrue("Must be a Constant-Offset Indexed mode", AddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AddInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check ADDA Relative to PC Indexed 
	 */
	@Test 
	def void testADDARelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDA		  	0,PCR
			       	ADDA		  	,PCR
			       	ADDA		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDA instruction", AddInstruction.instruction,"ADDA")
		assertTrue("Must be a Constant-Offset Indexed mode", AddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AddInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check ADDA Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testADDARelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDA		  	[0,PCR]
			       	ADDA		  	[,PCR]
			       	ADDA		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDA instruction", AddInstruction.instruction,"ADDA")
		assertTrue("Must be a Constant-Offset Indexed mode", AddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AddInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}

	/**
	 * Check ADDB immediat 
	 */
	@Test 
	def void testADDBImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADDB		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDB instruction", AddInstruction.instruction,"ADDB")
		assertTrue("Must be an immediate addressing mode", AddInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check ADDB direct mode 
	 */
	@Test 
	def void testADDBDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADDB		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDB instruction", AddInstruction.instruction,"ADDB")
		assertTrue("Must be a direct addressing mode", AddInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check ADDB extended mode 
	 */
	@Test 
	def void testADDBExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADDB		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDB instruction", AddInstruction.instruction,"ADDB")
		assertTrue("Must be a extended addressing mode", AddInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ADDB extended mode 
	 */
	@Test 
	def void testADDBExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADDB		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDB instruction", AddInstruction.instruction,"ADDB")
		assertTrue("Must be a extended addressing mode", AddInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ADDB extended indirect mode 
	 */
	@Test 
	def void testADDBExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ADDB		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDB instruction", AddInstruction.instruction,"ADDB")
		assertTrue("Must be a extended indirect addressing mode", AddInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check ADDB Constant-Offset Indexed 
	 */
	@Test 
	def void testADDBConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDB		  	Const,X
					ADDB		  	,X
					ADDB		  	$9,U
					ADDB		  	$9,S
					ADDB		  	$9,X
					ADDB		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDB instruction", AddInstruction.instruction,"ADDB")
		assertTrue("Must be a Constant-Offset Indexed mode", AddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AddInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check ADDB Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testADDBConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDB		  	[Const,X]
					ADDB		  	[,X]
					ADDB		  	[$9,U]
					ADDB		  	[$9,S]
					ADDB		  	[$9,X]
					ADDB		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDB instruction", AddInstruction.instruction,"ADDB")
		assertTrue("Must be a Constant-Offset Indexed mode", AddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AddInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check ADDB Accumulator Indexed 
	 */
	@Test 
	def void testADDBAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDB		  	A,X
					ADDB		  	B,X
					ADDB		  	D,U
					ADDB		  	A,S
					ADDB		  	B,X
					ADDB		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDB instruction", AddInstruction.instruction,"ADDB")
		assertTrue("Must be a Constant-Offset Indexed mode", AddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AddInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check ADDB Accumulator Indexed Indirect
	 */
	@Test 
	def void testADDBAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDB		  	[A,X]
					ADDB		  	[B,X]
					ADDB		  	[D,U]
					ADDB		  	[A,S]
					ADDB		  	[B,X]
					ADDB		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDB instruction", AddInstruction.instruction,"ADDB")
		assertTrue("Must be a Constant-Offset Indexed mode", AddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AddInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check ADDB Auto-Increment Indexed 
	 */
	@Test 
	def void testADDBAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDB		  	0,--X
			       	ADDB		  	0,-X
			       	ADDB		  	Const,X+
			       	ADDB		  	Const,X++
			       	ADDB		  	0,--S
			       	ADDB		  	0,-S
			       	ADDB		  	Const,U+
			       	ADDB		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDB instruction", AddInstruction.instruction,"ADDB")
		assertTrue("Must be a Constant-Offset Indexed mode", AddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AddInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check ADDB Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testADDBAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDB		  	[0,--X]
			       	ADDB		  	[0,-X]
			       	ADDB		  	[Const,X+]
			       	ADDB		  	[Const,X++]
			       	ADDB		  	[0,--S]
			       	ADDB		  	[0,-S]
			       	ADDB		  	[Const,U+]
			       	ADDB		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDB instruction", AddInstruction.instruction,"ADDB")
		assertTrue("Must be a Constant-Offset Indexed mode", AddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AddInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check ADDB Relative to PC Indexed 
	 */
	@Test 
	def void testADDBRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDB		  	0,PCR
			       	ADDB		  	,PCR
			       	ADDB		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDB instruction", AddInstruction.instruction,"ADDB")
		assertTrue("Must be a Constant-Offset Indexed mode", AddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AddInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check ADDB Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testADDBRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ADDB		  	[0,PCR]
			       	ADDB		  	[,PCR]
			       	ADDB		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AddInstruction)

		val AddInstruction = instructionLine.instruction as AddInstruction
		assertEquals("Must be an ADDB instruction", AddInstruction.instruction,"ADDB")
		assertTrue("Must be a Constant-Offset Indexed mode", AddInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AddInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}