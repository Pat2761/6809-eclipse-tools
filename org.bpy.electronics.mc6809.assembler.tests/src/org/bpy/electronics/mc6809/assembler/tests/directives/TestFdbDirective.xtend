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
import org.bpy.electronics.mc6809.assembler.util.CommandUtil
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator
import org.bpy.electronics.mc6809.assembler.assembler.FdbDirective
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestFdbDirective {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check FDB directive with a simple value
	 */
	@Test 
	def void testFdbWithDecimalValue() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       FDB    1234 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an FDB directive line", directiveLine.directive instanceof FdbDirective)
		
		val fdbDirective = directiveLine.directive as FdbDirective
	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(fdbDirective))	
	 	val values = ExpressionParser.parse(fdbDirective)
	 	Assert.assertEquals("Only one value defined", 1, values.size())	
		Assert.assertEquals("First value must be set to 1234", 1234, values.get(0))
	}

	/**
	 * Check FDB directive with two values
	 */
	@Test 
	def void testFDBWithTwoValues() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       FDB    $FF,125+4000 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an FDB directive line", directiveLine.directive instanceof FdbDirective)
		
		val fdbDirective = directiveLine.directive as FdbDirective
	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(fdbDirective))	
	 	val values = ExpressionParser.parse(fdbDirective)
	 	Assert.assertEquals("Only two value defined", 2, values.size())	
		Assert.assertEquals("Value 1 must be set to 255", 255, values.get(0))
		Assert.assertEquals("Value 2 must be set to 4125", 4125, values.get(1))
	}

	/**
	 * Check FDB directive with three values
	 */
	@Test 
	def void testFdbWithThreeValues() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       FDB    1,0,3 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an FDB directive line", directiveLine.directive instanceof FdbDirective)
		
		val fdbDirective = directiveLine.directive as FdbDirective
	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(fdbDirective))	
	 	val values = ExpressionParser.parse(fdbDirective)
	 	Assert.assertEquals("Only three value defined", 3, values.size())	
		Assert.assertEquals("Value 1 must be set to 1", 1, values.get(0))
		Assert.assertEquals("Value 2 must be set to 0", 0, values.get(1))
		Assert.assertEquals("Value 3 must be set to 3", 3, values.get(2))
	}

	/**
	 * Check FDB directive with three values
	 */
	@Test 
	def void testFdbWithThreeValuesWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       FDB    1,0,3      ; Set 1,0,3
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an FDB directive line", directiveLine.directive instanceof FdbDirective)
		
		val fdbDirective = directiveLine.directive as FdbDirective
	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(fdbDirective))	
	 	val values = ExpressionParser.parse(fdbDirective)
	 	Assert.assertEquals("Only three value defined", 3, values.size())	
		Assert.assertEquals("Value 1 must be set to 1", 1, values.get(0))
		Assert.assertEquals("Value 2 must be set to 0", 0, values.get(1))
		Assert.assertEquals("Value 3 must be set to 3", 3, values.get(2))
	}

	/**
	 * Check FDB directive with three values
	 */
	@Test 
	def void testRmbWithThreeValuesWithCommentAndLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		FcbL       FDB    1,0,3      ; Set 1,0,3
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an FCB directive line", directiveLine.directive instanceof FdbDirective)
		
		val fdbDirective = directiveLine.directive as FdbDirective
	 	Assert.assertEquals("Label must be equal to ", "FcbL", CommandUtil.getLabel(fdbDirective))	
	 	val values = ExpressionParser.parse(fdbDirective)
	 	Assert.assertEquals("Only three value defined", 3, values.size())	
		Assert.assertEquals("Value 1 must be set to 1", 1, values.get(0))
		Assert.assertEquals("Value 2 must be set to 0", 0, values.get(1))
		Assert.assertEquals("Value 3 must be set to 3", 3, values.get(2))
	}

	/**
	 * Check FDB directive with three values
	 */
	@Test 
	def void testFdbWithThreeValuesWithLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		FcbL       FDB    1,0,3      
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an FDB directive line", directiveLine.directive instanceof FdbDirective)
		
		val fdbDirective = directiveLine.directive as FdbDirective
	 	Assert.assertEquals("Label must be equals to FcbL", "FcbL", CommandUtil.getLabel(fdbDirective))	
	 	val values = ExpressionParser.parse(fdbDirective)
	 	Assert.assertEquals("Only three value defined", 3, values.size())	
		Assert.assertEquals("Value 1 must be set to 1", 1, values.get(0))
		Assert.assertEquals("Value 2 must be set to 0", 0, values.get(1))
		Assert.assertEquals("Value 3 must be set to 3", 3, values.get(2))
	}

	/**
	 * Check FDB directive with a bad negative value
	 */
//	@Test 
//	def void testFDBWithBadNegativeValue() {
//		val result = parseHelper.parse('''
//			         ORG    $8000
//		Label1       FDB    10,0,-32769,40 
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(AssemblerPackage.eINSTANCE.fdbDirective,DirectiveValidator::INVALID_RANGE,"FDB value can't lower than -32768 at location 3")
//	}

	/**
	 * Check FDB directive with a limit negative value
	 */
	@Test 
	def void testFCBWithLimitNegativeValue() {
		val result = parseHelper.parse('''
			         ORG    $8000
		Label1       FDB    10,-32768,128,40 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}
	/**
	 * Check FDB directive with a bad positive value
	 */
//	@Test 
//	def void testFDBWithBadPositiveValue() {
//		val result = parseHelper.parse('''
//			         ORG    $8000
//		Label1       FDB    65536,0,128,40 
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(AssemblerPackage.eINSTANCE.fdbDirective,DirectiveValidator::INVALID_RANGE,"FDB value maximum value is 65535 at location 1")
//	}

	/**
	 * Check FDB directive with a limit positive value
	 */
	@Test 
	def void testFDBWithLimitPositiveValue() {
		val result = parseHelper.parse('''
			         ORG    $8000
		Label1       FDB    10,127,128,65535 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}
}