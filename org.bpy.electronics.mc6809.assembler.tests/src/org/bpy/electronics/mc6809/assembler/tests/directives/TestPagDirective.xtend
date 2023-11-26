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
import org.bpy.electronics.mc6809.assembler.assembler.PagDirective
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestPagDirective {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check PAG directive without comment
	 */
	@Test 
	def void testPAGWithoutCommentWithSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   PAG    
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an PAG directive line", directiveLine.directive instanceof PagDirective)
	}
	
	/**
	 * Check PAG directive without comment
	 */
	@Test 
	def void testPAGWithoutCommentWithoutSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   PAG
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an PAG directive line", directiveLine.directive instanceof PagDirective)
	}
	
	/**
	 * Check PAG directive with value
	 */
	@Test 
	def void testPAGWithValueWithoutComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   PAG    1
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an PAG directive line", directiveLine.directive instanceof PagDirective)
	}

	/**
	 * Check PAG directive with value and comment
	 */
	@Test 
	def void testPAGWithValueWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   PAG    1        ; Page 1
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an PAG directive line", directiveLine.directive instanceof PagDirective)
	}

	/**
	 * Check PAG directive with expression and comment
	 */
	@Test 
	def void testPAGWithExpressionWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   PAG    1+1        ; Page 1
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an PAG directive line", directiveLine.directive instanceof PagDirective)
	}

	/**
	 * Check PAG directive with negative operand
	 */
	@Test 
	def void testPAGWithNegativeOperand() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   PAG    -1        ; Page 1
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.pagDirective, DirectiveValidator::INVALID_RANGE,"PAG value can't be negative")
	}

	/**
	 * Check PAG directive with operand equals to 0
	 */
	@Test 
	def void testPAGWith0() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   PAG    1-1 
		''')
		Assert.assertNotNull(result)
		result.assertWarning(AssemblerPackage.eINSTANCE.pagDirective, DirectiveValidator::INVALID_RANGE,"Null page value is suspicious")
	}

	/**
	 * Check PAG directive with operand equals to 9
	 */
	@Test 
	def void testPAGWith9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   PAG    9 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}

	/**
	 * Check PAG directive with operand equals to 10
	 */
	@Test 
	def void testPAGWith10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   PAG    10 
		''')
		Assert.assertNotNull(result)
		result.assertWarning(AssemblerPackage.eINSTANCE.pagDirective, DirectiveValidator::INVALID_RANGE,"PAG value superior to 9 is suspicious")
	}
	
		/**
	 * Check SPC directive with an unexpected label
	 */
	@Test 
	def void testWithUnexpectedLabel() {
		val result = parseHelper.parse('''
		; test PAG with label
		APAG 	    PAG    	1 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.directiveLine,DirectiveValidator::UNEXPECTED_LABEL,"No label may be set for PAG directive")
	}
	
	/**
	 * Check PAG directive with label
	 */
	@Test 
	def void testPagWithLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		Label	   	PAG    	1			   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.directiveLine, DirectiveValidator::UNEXPECTED_LABEL,"No label may be set for PAG directive")
	}
	
	/**
	 * Check PC counter after PAG directive 
	 */
	@Test 
	def void testPagPCCounter() {
		val result = parseHelper.parse('''
		; -----------------------------------------
					ORG		$2000
				   	PAG    	1			   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC after PAG instruction", 0x2000, engine.currentPcValue)		
		
	}
}
	