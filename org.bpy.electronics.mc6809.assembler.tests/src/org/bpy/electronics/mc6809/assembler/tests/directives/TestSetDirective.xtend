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
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.bpy.electronics.mc6809.assembler.assembler.SetDirective
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestSetDirective {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check SET directive with a simple value
	 */
	@Test 
	def void testSETWithDecimalValue() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		SetValue   SET    5 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an SET directive line", directiveLine.directive instanceof SetDirective)
	}
	
	/**
	 * Check SET directive with a identifier and expression
	 */
	@Test 
	def void testSETWithIdentifierValue() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		SetValue   SET    5 
		SetValue   SET    SetValue*2 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an SET directive line", directiveLine.directive instanceof SetDirective)
	}
	
	/**
	 * Check SET directive with a identifier and relative to PC
	 */
	@Test 
	def void testSETWithIdentifierValueRelativeToPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		SetValue   SET    5 
		SetValue   SET    *+2 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an SET directive line", directiveLine.directive instanceof SetDirective)
	}

	/**
	 * Check SET directive relative to PC
	 */
	@Test 
	def void testSETRelativeToPC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		SetValue   SET    * 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an SET directive line", directiveLine.directive instanceof SetDirective)
	}
	/**
	 * Check SET directive with a value which is upper to 65535
	 */
	@Test 
	def void testWithHighestLimit() {
		val result = parseHelper.parse('''
		Label1       SET    65535 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}

	/**
	 * Check SET directive with a value which is upper to 65535
	 */
	@Test 
	def void testWithTooHighValue() {
		val result = parseHelper.parse('''
		Label1       SET    65536 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.setDirective,DirectiveValidator::INVALID_RANGE,"SET value can't exceed 65535 (16 bits value)")
	}

	/**
	 * Check SET directive with a value which is lower than -32768
	 */
	@Test 
	def void testWithTooLowValue() {
		val result = parseHelper.parse('''
		Label1       SET    -32769 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.setDirective,DirectiveValidator::INVALID_RANGE,"SET value can't be lower than -32768 (16 bits value)")
	}

	/**
	 * Check SET directive with a value which is lower than -32768
	 */
	@Test 
	def void testWithLowestNegativeValue() {
		val result = parseHelper.parse('''
		Label1       SET    -32768 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}

	/**
	 * Check SET directive with a missing label
	 */
	@Test 
	def void testWithMissingLabel() {
		val result = parseHelper.parse('''
		; test SET without label
		 	    SET    100 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.directiveLine,DirectiveValidator::MISSING_LABEL,"No label defined for SET directive")
	}

	/**
	 * Check SET directive after an EQU directive with same label
	 */
	@Test 
	def void testWithEQUWthSameLabel() {
		val result = parseHelper.parse('''
		; test  SET 
		MySET			 EQU 	200
		MySET 	   		 SET    100 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.directiveLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"The label MySET for an SET directive is already defined")
	}

	/**
	 * Check SET directive after an SET directive with same label
	 */
	@Test 
	def void testWithSETWthSameLabel() {
		val result = parseHelper.parse('''
		; test  SET 
		MySET			 SET 	200
		MySET 	   		 SET    100 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}

	/**
	 * Check SET directive with missing label in expression
	 */
	@Test 
	def void testWithSETWthMissingLabelInExpression() {
		val result = parseHelper.parse('''
		; test  SET 
		MySET 	   		 SET    100*Deux 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.setDirective,
			ExpressionParser::EXPRESSION_ERROR,
			"Can't find Deux definition"
		)
	}
}
