/*
 * European Scoring Tool For Baseball
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
package org.bpy.electronics.mc6809.assembler.tests

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
import org.bpy.electronics.mc6809.assembler.assembler.FcbDirective
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestFcbDirective {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check RMB directive with a simple value
	 */
	@Test 
	def void testRmbWithDecimalValue() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       FCB    12 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an FCB directive line", directiveLine.directive instanceof FcbDirective)
		
		val fcbDirective = directiveLine.directive as FcbDirective
	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(fcbDirective))	
	 	val values = ExpressionParser.parse(fcbDirective)
	 	Assert.assertEquals("Only one value defined", 1, values.size())	
		Assert.assertEquals("First value must be set to 12", 12, values.get(0))
	}

	/**
	 * Check RMB directive with two values
	 */
	@Test 
	def void testRmbWithTwoValues() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       FCB    $FF,'A 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an FCB directive line", directiveLine.directive instanceof FcbDirective)
		
		val fcbDirective = directiveLine.directive as FcbDirective
	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(fcbDirective))	
	 	val values = ExpressionParser.parse(fcbDirective)
	 	Assert.assertEquals("Only two value defined", 2, values.size())	
		Assert.assertEquals("Value 1 must be set to 255", 255, values.get(0))
		Assert.assertEquals("Value 2 must be set to 65", 65, values.get(1))
	}

	/**
	 * Check RMB directive with three values
	 */
	@Test 
	def void testRmbWithThreeValues() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       FCB    1,,3 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an FCB directive line", directiveLine.directive instanceof FcbDirective)
		
		val fcbDirective = directiveLine.directive as FcbDirective
	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(fcbDirective))	
	 	val values = ExpressionParser.parse(fcbDirective)
	 	Assert.assertEquals("Only three value defined", 3, values.size())	
		Assert.assertEquals("Value 1 must be set to 1", 1, values.get(0))
		Assert.assertEquals("Value 2 must be set to 0", 0, values.get(1))
		Assert.assertEquals("Value 3 must be set to 3", 3, values.get(2))
	}

	/**
	 * Check RMB directive with three values
	 */
	@Test 
	def void testRmbWithThreeValuesWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       FCB    1,,3      ; Set 1,0,3
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an FCB directive line", directiveLine.directive instanceof FcbDirective)
		
		val fcbDirective = directiveLine.directive as FcbDirective
	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(fcbDirective))	
	 	val values = ExpressionParser.parse(fcbDirective)
	 	Assert.assertEquals("Only three value defined", 3, values.size())	
		Assert.assertEquals("Value 1 must be set to 1", 1, values.get(0))
		Assert.assertEquals("Value 2 must be set to 0", 0, values.get(1))
		Assert.assertEquals("Value 3 must be set to 3", 3, values.get(2))
	}

	/**
	 * Check RMB directive with three values
	 */
	@Test 
	def void testRmbWithThreeValuesWithCommentAndLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		FcbL       FCB    1,,3      ; Set 1,0,3
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an FCB directive line", directiveLine.directive instanceof FcbDirective)
		
		val fcbDirective = directiveLine.directive as FcbDirective
	 	Assert.assertEquals("Label must be equald to ", "FcbL", CommandUtil.getLabel(fcbDirective))	
	 	val values = ExpressionParser.parse(fcbDirective)
	 	Assert.assertEquals("Only three value defined", 3, values.size())	
		Assert.assertEquals("Value 1 must be set to 1", 1, values.get(0))
		Assert.assertEquals("Value 2 must be set to 0", 0, values.get(1))
		Assert.assertEquals("Value 3 must be set to 3", 3, values.get(2))
	}

	/**
	 * Check RMB directive with three values
	 */
	@Test 
	def void testRmbWithThreeValuesWithLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		FcbL       FCB    1,,3      
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an FCB directive line", directiveLine.directive instanceof FcbDirective)
		
		val fcbDirective = directiveLine.directive as FcbDirective
	 	Assert.assertEquals("Label must be equals to FcbL", "FcbL", CommandUtil.getLabel(fcbDirective))	
	 	val values = ExpressionParser.parse(fcbDirective)
	 	Assert.assertEquals("Only three value defined", 3, values.size())	
		Assert.assertEquals("Value 1 must be set to 1", 1, values.get(0))
		Assert.assertEquals("Value 2 must be set to 0", 0, values.get(1))
		Assert.assertEquals("Value 3 must be set to 3", 3, values.get(2))
	}

	/**
	 * Check FCB directive with a bad negative value
	 */
	@Test 
	def void testFCBWithBadNegativeValue() {
		val result = parseHelper.parse('''
			         ORG    $8000
		Label1       FCB    10,0,-128,40 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.fcbDirective,DirectiveValidator::INVALID_RANGE,"RMB value can't lower than -127 at location 3")
	}

	/**
	 * Check FCB directive with a limit negative value
	 */
	@Test 
	def void testFCBWithLimitNegativeValue() {
		val result = parseHelper.parse('''
			         ORG    $8000
		Label1       FCB    10,-127,128,40 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}
	/**
	 * Check FCB directive with a bad positive value
	 */
	@Test 
	def void testFCBWithBadPositiveValue() {
		val result = parseHelper.parse('''
			         ORG    $8000
		Label1       FCB    256,0,128,40 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.fcbDirective,DirectiveValidator::INVALID_RANGE,"FCB value maximum value is $FF at location 1")
	}

	/**
	 * Check FCB directive with a limit positive value
	 */
	@Test 
	def void testFCBWithLimitPositiveValue() {
		val result = parseHelper.parse('''
			         ORG    $8000
		Label1       FCB    10,127,128,255 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}
}