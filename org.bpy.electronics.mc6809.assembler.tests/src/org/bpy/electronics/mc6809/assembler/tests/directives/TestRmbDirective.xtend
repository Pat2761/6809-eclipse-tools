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
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective
import org.bpy.electronics.mc6809.assembler.assembler.RmbDirective
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestRmbDirective {
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
			       RMB    12 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an RMB directive line", directiveLine.directive instanceof RmbDirective)
		
		val rmbDirective = directiveLine.directive as RmbDirective
	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(rmbDirective))	
		Assert.assertEquals("Operand must be equals to 12", 12, ExpressionParser.parse(rmbDirective))		
	}
	

	/**
	 * Check RMB directive with a simple identifier defined by an another EQU
	 */
	@Test 
	def void testWithIdentifierValue() {
		val result = parseHelper.parse('''
		; Starting assembly file
		Start       EQU    $4000         ; Starting code
		
		; Starting code section
		            ORG    Start         ; Start program at $4000
		RmbLabel    RMB    Start/2       ; reserve $2000
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val line0 = result.sourceLines.get(1)
		val directiveLine0 = line0.lineContent as DirectiveLine
		val equDirective0 = directiveLine0.directive as EquDirective
		ExpressionParser.parse(equDirective0)
		
		val line1 = result.sourceLines.get(5)
		Assert.assertTrue("Must be a directive line", line1.lineContent instanceof DirectiveLine)
		
		val directiveLine1 = line1.lineContent as DirectiveLine
		Assert.assertTrue("Must be an RMB directive line", directiveLine1.directive instanceof RmbDirective)
		
		val rmbDirective = directiveLine1.directive as RmbDirective
	 	Assert.assertEquals("Label must be RmbLabel", "RmbLabel", CommandUtil.getLabel(rmbDirective))	
		Assert.assertEquals("Operand must be equals to $2000", 0x2000, ExpressionParser.parse(rmbDirective))		
	}

	/**
	 * Check RMB directive with a negative value
	 */
//	@Test 
//	def void testWithNegativeValue() {
//		val result = parseHelper.parse('''
//			         ORG    $8000   ; With value
//		Label1       RMB    0 
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(AssemblerPackage.eINSTANCE.rmbDirective,DirectiveValidator::INVALID_RANGE,"RMB value can't lower than 1")
//	}

	/**
	 * Check RMB directive with the lowest limit
	 */
	@Test 
	def void testRMBWithLowestValue() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000   ; With value
		           RMB    1 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}

	/**
	 * Check RMB directive with the upper limit
	 */
	@Test 
	def void testRMBWithUpperLimitValue() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			   ORG    $8000   ; With value
		       RMB    $FFFF 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}

	/**
	 * Check RMB directive with the too high limit
	 */
//	@Test 
//	def void testRMBWithToHighLimitValue() {
//		val result = parseHelper.parse('''
//		; -----------------------------------------
//			       ORG    $8000   ; With value
//		           RMB    $FFFF+1 
//		''')
//		Assert.assertNotNull(result)
//		result.assertError(AssemblerPackage.eINSTANCE.rmbDirective,DirectiveValidator::INVALID_RANGE,"RMB value maximum value is $FFFF")
//	}
}