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
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.bpy.electronics.mc6809.assembler.assembler.FailDirective
import org.bpy.electronics.mc6809.assembler.assembler.OptDirective

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestOptDirective {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check OPT directive with nothing
	 */
	@Test 
	def void testOPTEmpty() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   OPT    
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an OPT directive line", directiveLine.directive instanceof OptDirective)
		
//		val endDirective = directiveLine.directive as EndDirective
//	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(endDirective))	
//		Assert.assertEquals("Operand must be equals to 1000", 1000, ExpressionParser.parse(endDirective))		
	}
	
	
	/**
	 * Check OPT directive with nothing
	 */
	@Test 
	def void testOPTEmptyWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   OPT
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an OPT directive line", directiveLine.directive instanceof OptDirective)
		
//		val endDirective = directiveLine.directive as EndDirective
//	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(endDirective))	
//		Assert.assertEquals("Operand must be equals to 1000", 1000, ExpressionParser.parse(endDirective))		
	}

	/**
	 * Check OPT directive with nothing and comment
	 */
	@Test 
	def void testOPTEmptyWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   OPT    ; All by defult
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an OPT directive line", directiveLine.directive instanceof OptDirective)
		
//		val endDirective = directiveLine.directive as EndDirective
//	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(endDirective))	
//		Assert.assertEquals("Operand must be equals to 1000", 1000, ExpressionParser.parse(endDirective))		
	}

	/**
	 * Check OPT directive with one option
	 */
	@Test 
	def void testOPTWithOneOption() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   OPT    CON
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an OPT directive line", directiveLine.directive instanceof OptDirective)
		
//		val endDirective = directiveLine.directive as EndDirective
//	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(endDirective))	
//		Assert.assertEquals("Operand must be equals to 1000", 1000, ExpressionParser.parse(endDirective))		
	}

	/**
	 * Check OPT directive with list of options
	 */
	@Test 
	def void testOPTWithListOfOptions() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   OPT    CON,PAG,NOM,NOE
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an OPT directive line", directiveLine.directive instanceof OptDirective)
		
//		val endDirective = directiveLine.directive as EndDirective
//	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(endDirective))	
//		Assert.assertEquals("Operand must be equals to 1000", 1000, ExpressionParser.parse(endDirective))		
	}
	

	/**
	 * Check OPT directive with list of options and comment
	 */
	@Test 
	def void testOPTWithListOfOptionsAndComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   OPT    CON,PAG,NOM,NOE   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an OPT directive line", directiveLine.directive instanceof OptDirective)
		
//		val endDirective = directiveLine.directive as EndDirective
//	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(endDirective))	
//		Assert.assertEquals("Operand must be equals to 1000", 1000, ExpressionParser.parse(endDirective))		
	}
	
}