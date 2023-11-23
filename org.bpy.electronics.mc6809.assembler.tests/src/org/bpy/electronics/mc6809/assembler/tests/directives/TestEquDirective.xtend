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
package org.bpy.electronics.mc6809.assembler.tests.directives

import org.eclipse.xtext.testing.XtextRunner
import org.junit.runner.RunWith
import org.eclipse.xtext.testing.InjectWith
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import org.bpy.electronics.mc6809.assembler.assembler.Model
import org.junit.Test
import org.junit.Assert
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective
import org.bpy.electronics.mc6809.assembler.util.CommandUtil
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestEquDirective {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check EQU directive with a simple decimal value
	 */
	@Test 
	def void testWithDecimalValue() {
		val result = parseHelper.parse('''
		Label1       EQU    1234 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
	}

	/**
	 * Check EQU directive with a simple negative decimal value
	 */
	@Test 
	def void testWithNegativeDecimalValue() {
		val result = parseHelper.parse('''
		Label1       EQU    -25 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
	}
	
	@Test
	/**
	 * Check EQU directive with an addition of two decimal values 
	 */
	def void testWithAdditionOfTwoDecimalValue() {
		
		val result = parseHelper.parse('''
		Label1       EQU    12+24		 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
	}
	
	@Test
	/**
	 * Check EQU directive with an addition of three decimal values
	 */
	def void testWithAdditionOfThreeDecimalValue() {
		val result = parseHelper.parse('''
		Label1       EQU    12+24+5		 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
	}

	@Test
	/**
	 * Check EQU directive with an addition of two decimal values and a multiplication
	 * check the parenthesis priority
	 */
	def void testWithAdditionOfTwoDecimalValueAndMultiplication() {
		val result = parseHelper.parse('''
		Label1       EQU    (12+24)*5		 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
	}

	@Test
	/**
	 * Check EQU directive with an hexadecimal value
	 */
	def void testWithHexadecimalvalue() {
		val result = parseHelper.parse('''
		Label1       EQU    $FF00		 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
	}

	@Test
	/**
	 * Check EQU directive with the addition of two hexadecimal values
	 */
	def void testWithAdditionHexadecimalvalue() {
		val result = parseHelper.parse('''
		Label1       EQU    $A7+$25		 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
	}

	/**
	 * Check EQU directive with an addition of a decimal values and a hexadecimal value
	 */
	@Test
	def void testWithMultiplicationHexadecimalvalue() {
		val result = parseHelper.parse('''
		Label1       EQU    125*$A		 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
	}
	
	/**
	 * Check EQU directive with a binary value
	 */
	@Test 
	def void testWithABinaryValue() {
		val result = parseHelper.parse('''
		Label1       EQU   %10010011		 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
	}
	
	/**
	 * Check EQU directive with a simple octal value
	 */
	@Test 
	def void testWithOctalValue() {
		val result = parseHelper.parse('''
		Label1       EQU    @1234 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
	}
	
	/**
	 * Check EQU directive with a simple identifier defined by an anothoer EQU
	 */
	@Test 
	def void testWithIdentifierValue() {
		val result = parseHelper.parse('''
		Five       EQU    5         ; Five = 5
		Result     EQU    Five*2    ; so 10
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val line0 = result.sourceLines.get(0)
		val directiveLine0 = line0.lineContent as DirectiveLine
		val equDirective0 = directiveLine0.directive as EquDirective
		ExpressionParser.parse(equDirective0)
		
		val line1 = result.sourceLines.get(1)
		Assert.assertTrue("Must be a directive line", line1.lineContent instanceof DirectiveLine)
		
		val directiveLine1 = line1.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine1.directive instanceof EquDirective)
	}

	/**
	 * Check EQU directive with a simple octal value
	 */
	@Test 
	def void testWithCharacterValue() {
		val result = parseHelper.parse('''
		Label1       EQU    'A 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
	}

	/**
	 * Check EQU directive with a relative value to PC
	 */
	@Test 
	def void testEQURelativeToPC() {
		val result = parseHelper.parse('''
		             ORG    $2000
		Label1       EQU    * 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(1)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
	}


	/**
	 * Check EQU directive with a relative value to PC with expression
	 */
	@Test 
	def void testEQURelativeToPCWithEpxression() {
		val result = parseHelper.parse('''
		             ORG    $2000
		Label1       EQU    *-3 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(1)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
	}
	@Test
	def void testEQUWithSamples() { 
		val result = parseHelper.parse('''
		Label1       EQU    65535 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
	}

	/**
	 * Check EQU directive with a value which is upper to 65535
	 */
	@Test 
	def void testWithHighestLimit() {
		val result = parseHelper.parse('''
		Label1       EQU    65535 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}

	/**
	 * Check EQU directive with a value which is upper to 65535
	 */
	@Test 
	def void testWithTooHighValue() {
		val result = parseHelper.parse('''
		Label1       EQU    65536 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.equDirective,DirectiveValidator::INVALID_RANGE,"EQU value can't exceed 65535 (16 bits value)")
	}

	/**
	 * Check EQU directive with a value which is lower than -32768
	 */
	@Test 
	def void testWithTooLowValue() {
		val result = parseHelper.parse('''
		Label1       EQU    -32769 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.equDirective,DirectiveValidator::INVALID_RANGE,"EQU value can't be lower than -32768 (16 bits value)")
	}

	/**
	 * Check EQU directive with a value which is lower than -32768
	 */
	@Test 
	def void testWithLowestNegativeValue() {
		val result = parseHelper.parse('''
		Label1       EQU    -32768 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}

	/**
	 * Check EQU directive with a missing label
	 */
	@Test 
	def void testWithMissingLabel() {
		val result = parseHelper.parse('''
		; test EQU without label
		 	    EQU    100 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.directiveLine,DirectiveValidator::MISSING_LABEL,"No label defined for EQU directive")
	}

	/**
	 * Check EQU directive with a duplicate label
	 */
	@Test 
	def void testWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; test EQU without label
		EquLabel 	    EQU    	100 
		EquLabel		EQU		200
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.directiveLine,AssemblerEngine::DUPLICATE_LABEL,"The label EquLabel for an EQU directive is already defined")
	}

	/**
	 * Check EQU directive with a duplicate label defined by a SET directive
	 */
	@Test 
	def void testWithSETDuplicateLabel() {
		val result = parseHelper.parse('''
		; test EQU without label
		EquLabel 	    SET    	100 
		EquLabel		EQU		200
		''')
		Assert.assertNotNull(result)
		result.assertWarning(AssemblerPackage.eINSTANCE.directiveLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"The label EquLabel for an EQU directive is already defined by a SET directive"
		)
	}
	
	@Test
	/**
	 * Check EQU directive with an subtraction of two decimal values 
	 */
	def void testWithSubstractionOfTwoDecimalValue() {
		
		val result = parseHelper.parse('''
		Label1       EQU    32-15		 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
		
		val equDirective = directiveLine.directive as EquDirective
	 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective))	
		Assert.assertEquals("Operand must be equals to 17", 17, ExpressionParser.parse(equDirective))		
	}

	@Test
	/**
	 * Check EQU directive with an modulo of two decimal values 
	 */
	def void testWithModuloOfTwoDecimalValue() {
		
		val result = parseHelper.parse('''
		Label1       EQU    46%5		 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
		
		val equDirective = directiveLine.directive as EquDirective
	 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective))	
		Assert.assertEquals("Operand must be equals to 1", 1, ExpressionParser.parse(equDirective))		
	}

	@Test
	/**
	 * Check EQU directive with a logical AND of two hexadecimal values 
	 */
	def void testWithLogicalAndOfTwoHexaDecimalValue() {
		
		val result = parseHelper.parse('''
		Label1       EQU    $FFFF&&$FF		 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
		
		val equDirective = directiveLine.directive as EquDirective
	 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective))	
		Assert.assertEquals("Operand must be equals to 255", 255, ExpressionParser.parse(equDirective))		
	}

	@Test
	/**
	 * Check EQU directive with a logical Or of two hexadecimal values 
	 */
	def void testWithLogicalOrOfTwoHexaDecimalValue() {
		
		val result = parseHelper.parse('''
		Label1       EQU    $FF00||$FF		 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
		
		val equDirective = directiveLine.directive as EquDirective
	 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective))	
		Assert.assertEquals("Operand must be equals to 65535", 65535, ExpressionParser.parse(equDirective))		
	}

	@Test
	/**
	 * Check EQU directive with a logical XOr of two hexadecimal values 
	 */
	def void testWithLogicalXOrOfTwoBinaryValue() {
		
		val result = parseHelper.parse('''
		Label1       EQU    %01010101^%00001111		 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
		
		val equDirective = directiveLine.directive as EquDirective
	 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective))	
		Assert.assertEquals("Operand must be equals to 90", 90, ExpressionParser.parse(equDirective))		
	}

	@Test
	/**
	 * Check EQU directive with a nagate of an hexadecimal values 
	 */
	def void testWithNegateOfHexaDecimalValue() {
		
		val result = parseHelper.parse('''
		Label1       EQU    !$AA		 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
		
		val equDirective = directiveLine.directive as EquDirective
	 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective))	
		Assert.assertEquals("Operand must be equals to 65365", 65365, ExpressionParser.parse(equDirective))		
	}

	@Test
	/**
	 * Check EQU directive with a left shift of a values 
	 */
	def void testWithLeftShiftValue() {
		
		val result = parseHelper.parse('''
		Label1       EQU    20<<2		 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
		
		val equDirective = directiveLine.directive as EquDirective
	 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective))	
		Assert.assertEquals("Operand must be equals to 80", 80, ExpressionParser.parse(equDirective))		
	}

	@Test
	/**
	 * Check EQU directive with a right shift of a values 
	 */
	def void testWithRightShiftValue() {
		
		val result = parseHelper.parse('''
		Label1       EQU    88>>2		 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
		
		val equDirective = directiveLine.directive as EquDirective
	 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective))	
		Assert.assertEquals("Operand must be equals to 22", 22, ExpressionParser.parse(equDirective))		
	}
//	
//	@Test
//	def void testSorek() {
//		val result = parseHelper.parse('''
//		START			ORG			$2000
//		DEBUT			EQU			START
//		COMPT 			EQU 		$05 					; donnée 8 bits
//		ADRDEB			EQU 		1000 					; donnée 16 bits
//		FIN 			EQU 		DEBUT+$60 				; 
//		
//		VALHEX 			EQU 		$8000 					; VALHEX aura pour valeur $8000
//		;DEBBIN 		EQU 		-$0200 					; ==> negative hexa decimal not managed
//		FINATT 			EQU 		NOMVAR+30 				;
//		FINTIT 			EQU 		NOMVAR-VARFIN 			;
//		TOUCHA 			EQU 		'A 						; assigne $0041 au symbole TOUCHA
//		FONCTA 			EQU 		TOUCHA+%10000000 		; assigne $00C1 au symbole FONCTA
//		
//		TOTO 			EQU 		* 						; TOTO aura pour valeur $2000, car on affecte la
//															; valeur courante de l'adresse à TOTO
//		TITI 			EQU 		*-3 					; TITI aura pour valeurs $1FFD ($2000-3)
//		''')
//		Assert.assertNotNull(result)
//		result.assertNoErrors
//	}
}