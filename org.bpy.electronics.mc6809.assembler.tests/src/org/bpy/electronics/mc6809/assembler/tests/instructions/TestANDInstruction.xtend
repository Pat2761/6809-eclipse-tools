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
import org.bpy.electronics.mc6809.assembler.assembler.AndInstruction
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

class TestANDInstruction {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check ANDA immediat 
	 */
	@Test 
	def void testANDAImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ANDA		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDA instruction", AndInstruction.instruction,"ANDA")
		assertTrue("Must be an immediate addressing mode", AndInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check ANDA direct mode 
	 */
	@Test 
	def void testANDADirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ANDA		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDA instruction", AndInstruction.instruction,"ANDA")
		assertTrue("Must be a direct addressing mode", AndInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check ANDA extended mode 
	 */
	@Test 
	def void testANDAExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ANDA		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDA instruction", AndInstruction.instruction,"ANDA")
		assertTrue("Must be a extended addressing mode", AndInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ANDA extended mode 
	 */
	@Test 
	def void testANDAExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ANDA		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDA instruction", AndInstruction.instruction,"ANDA")
		assertTrue("Must be a extended addressing mode", AndInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ANDA extended indirect mode 
	 */
	@Test 
	def void testANDAExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ANDA		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDA instruction", AndInstruction.instruction,"ANDA")
		assertTrue("Must be a extended indirect addressing mode", AndInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check ANDA Constant-Offset Indexed 
	 */
	@Test 
	def void testANDAConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDA		  	Const,X
					ANDA		  	,X
					ANDA		  	$9,U
					ANDA		  	$9,S
					ANDA		  	$9,X
					ANDA		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDA instruction", AndInstruction.instruction,"ANDA")
		assertTrue("Must be a Constant-Offset Indexed mode", AndInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AndInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check ANDA Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testANDAConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDA		  	[Const,X]
					ANDA		  	[,X]
					ANDA		  	[$9,U]
					ANDA		  	[$9,S]
					ANDA		  	[$9,X]
					ANDA		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDA instruction", AndInstruction.instruction,"ANDA")
		assertTrue("Must be a Constant-Offset Indexed mode", AndInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AndInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check ANDA Accumulator Indexed 
	 */
	@Test 
	def void testANDAAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDA		  	A,X
					ANDA		  	B,X
					ANDA		  	D,U
					ANDA		  	A,S
					ANDA		  	B,X
					ANDA		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDA instruction", AndInstruction.instruction,"ANDA")
		assertTrue("Must be a Constant-Offset Indexed mode", AndInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AndInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check ANDA Accumulator Indexed Indirect
	 */
	@Test 
	def void testANDAAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDA		  	[A,X]
					ANDA		  	[B,X]
					ANDA		  	[D,U]
					ANDA		  	[A,S]
					ANDA		  	[B,X]
					ANDA		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDA instruction", AndInstruction.instruction,"ANDA")
		assertTrue("Must be a Constant-Offset Indexed mode", AndInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AndInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check ANDA Auto-Increment Indexed 
	 */
	@Test 
	def void testANDAAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDA		  	0,--X
			       	ANDA		  	0,-X
			       	ANDA		  	Const,X+
			       	ANDA		  	Const,X++
			       	ANDA		  	0,--S
			       	ANDA		  	0,-S
			       	ANDA		  	Const,U+
			       	ANDA		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDA instruction", AndInstruction.instruction,"ANDA")
		assertTrue("Must be a Constant-Offset Indexed mode", AndInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AndInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check ANDA Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testANDAAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDA		  	[0,--X]
			       	ANDA		  	[0,-X]
			       	ANDA		  	[Const,X+]
			       	ANDA		  	[Const,X++]
			       	ANDA		  	[0,--S]
			       	ANDA		  	[0,-S]
			       	ANDA		  	[Const,U+]
			       	ANDA		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDA instruction", AndInstruction.instruction,"ANDA")
		assertTrue("Must be a Constant-Offset Indexed mode", AndInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AndInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check ANDA Relative to PC Indexed 
	 */
	@Test 
	def void testANDARelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDA		  	0,PCR
			       	ANDA		  	,PCR
			       	ANDA		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDA instruction", AndInstruction.instruction,"ANDA")
		assertTrue("Must be a Constant-Offset Indexed mode", AndInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AndInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check ANDA Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testANDARelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDA		  	[0,PCR]
			       	ANDA		  	[,PCR]
			       	ANDA		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDA instruction", AndInstruction.instruction,"ANDA")
		assertTrue("Must be a Constant-Offset Indexed mode", AndInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AndInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}

	/**
	 * Check ANDB immediat 
	 */
	@Test 
	def void testANDBImemdiatAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ANDB		  	#124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDB instruction", AndInstruction.instruction,"ANDB")
		assertTrue("Must be an immediate addressing mode", AndInstruction.operand instanceof ImmediatOperand)
	}
	
	/**
	 * Check ANDB direct mode 
	 */
	@Test 
	def void testANDBDirectAddressingMode() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ANDB		  	<124
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDB instruction", AndInstruction.instruction,"ANDB")
		assertTrue("Must be a direct addressing mode", AndInstruction.operand instanceof DirectOperand)
	}

	/**
	 * Check ANDB extended mode 
	 */
	@Test 
	def void testANDBExtendedAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ANDB		  	$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDB instruction", AndInstruction.instruction,"ANDB")
		assertTrue("Must be a extended addressing mode", AndInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ANDB extended mode 
	 */
	@Test 
	def void testANDBExtendedAddressingMode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ANDB		  	>$1234
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDB instruction", AndInstruction.instruction,"ANDB")
		assertTrue("Must be a extended addressing mode", AndInstruction.operand instanceof ExtendedOperand)
	}

	/**
	 * Check ANDB extended indirect mode 
	 */
	@Test 
	def void testANDBExtendedIndirectAddressingMode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    		$8000
			       ANDB		  	[$1234]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDB instruction", AndInstruction.instruction,"ANDB")
		assertTrue("Must be a extended indirect addressing mode", AndInstruction.operand instanceof ExtendedIndirectOperand)
	}

	/**
	 * Check ANDB Constant-Offset Indexed 
	 */
	@Test 
	def void testANDBConstantOffsetIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDB		  	Const,X
					ANDB		  	,X
					ANDB		  	$9,U
					ANDB		  	$9,S
					ANDB		  	$9,X
					ANDB		  	$9,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDB instruction", AndInstruction.instruction,"ANDB")
		assertTrue("Must be a Constant-Offset Indexed mode", AndInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AndInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed mode", indexedOperand.mode instanceof ConstantIndexedMode)
	}

	/**
	 * Check ANDB Constant-Offset Indexed indirect 
	 */
	@Test 
	def void testANDBConstantOffsetIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDB		  	[Const,X]
					ANDB		  	[,X]
					ANDB		  	[$9,U]
					ANDB		  	[$9,S]
					ANDB		  	[$9,X]
					ANDB		  	[$9,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDB instruction", AndInstruction.instruction,"ANDB")
		assertTrue("Must be a Constant-Offset Indexed mode", AndInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AndInstruction.operand as IndexedOperand
		assertTrue("Must be a Constant-Offset Indexed indirect mode", indexedOperand.mode instanceof ConstantIndexedMovingIndirectMode)
	}

	/**
	 * Check ANDB Accumulator Indexed 
	 */
	@Test 
	def void testANDBAccumulatorIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDB		  	A,X
					ANDB		  	B,X
					ANDB		  	D,U
					ANDB		  	A,S
					ANDB		  	B,X
					ANDB		  	D,Y
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDB instruction", AndInstruction.instruction,"ANDB")
		assertTrue("Must be a Constant-Offset Indexed mode", AndInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AndInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed mode", indexedOperand.mode instanceof AccumulatorMovingMode)
	}

	/**
	 * Check ANDB Accumulator Indexed Indirect
	 */
	@Test 
	def void testANDBAccumulatorIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDB		  	[A,X]
					ANDB		  	[B,X]
					ANDB		  	[D,U]
					ANDB		  	[A,S]
					ANDB		  	[B,X]
					ANDB		  	[D,Y]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDB instruction", AndInstruction.instruction,"ANDB")
		assertTrue("Must be a Constant-Offset Indexed mode", AndInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AndInstruction.operand as IndexedOperand
		assertTrue("Must be a Accumulator Indexed indirect mode", indexedOperand.mode instanceof AccumulatorMovingIndirectMode)
	}

	/**
	 * Check ANDB Auto-Increment Indexed 
	 */
	@Test 
	def void testANDBAutoIncrementIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDB		  	0,--X
			       	ANDB		  	0,-X
			       	ANDB		  	Const,X+
			       	ANDB		  	Const,X++
			       	ANDB		  	0,--S
			       	ANDB		  	0,-S
			       	ANDB		  	Const,U+
			       	ANDB		  	Const,U++
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDB instruction", AndInstruction.instruction,"ANDB")
		assertTrue("Must be a Constant-Offset Indexed mode", AndInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AndInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed mode", indexedOperand.mode instanceof AutoIncDecMode)
	}


	/**
	 * Check ANDB Auto-Increment Indexed Indirect
	 */
	@Test 
	def void testANDBAutoIncrementIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDB		  	[0,--X]
			       	ANDB		  	[0,-X]
			       	ANDB		  	[Const,X+]
			       	ANDB		  	[Const,X++]
			       	ANDB		  	[0,--S]
			       	ANDB		  	[0,-S]
			       	ANDB		  	[Const,U+]
			       	ANDB		  	[Const,U++]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDB instruction", AndInstruction.instruction,"ANDB")
		assertTrue("Must be a Constant-Offset Indexed mode", AndInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AndInstruction.operand as IndexedOperand
		assertTrue("Must be a Auto-Increment Indexed indirect mode", indexedOperand.mode instanceof AutoIncDecIndirectMode)
	}
	
	/**
	 * Check ANDB Relative to PC Indexed 
	 */
	@Test 
	def void testANDBRelativePCIndexed() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDB		  	0,PCR
			       	ANDB		  	,PCR
			       	ANDB		  	Const,PCR
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDB instruction", AndInstruction.instruction,"ANDB")
		assertTrue("Must be a Constant-Offset Indexed mode", AndInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AndInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed mode", indexedOperand.mode instanceof RelatifToPCMode)
	}
	
	/**
	 * Check ANDB Relative to PC Indexed Indirect 
	 */
	@Test 
	def void testANDBRelativePCIndexedIndirect() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    			$8000
		Const	   	EQU          	5    
			       	ANDB		  	[0,PCR]
			       	ANDB		  	[,PCR]
			       	ANDB		  	[Const,PCR]
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(3)
		Assert.assertTrue("Must be an Instruction line", line.lineContent instanceof InstructionLine)
		
		val instructionLine = line.lineContent as InstructionLine
		Assert.assertTrue("Must be an ADD directive line", instructionLine.instruction instanceof AndInstruction)

		val AndInstruction = instructionLine.instruction as AndInstruction
		assertEquals("Must be an ANDB instruction", AndInstruction.instruction,"ANDB")
		assertTrue("Must be a Constant-Offset Indexed mode", AndInstruction.operand instanceof IndexedOperand)
		val indexedOperand = AndInstruction.operand as IndexedOperand
		assertTrue("Must be a Relative to Indexed Indirect mode", indexedOperand.mode instanceof RelatifToPCIndirectMode)
	}
}