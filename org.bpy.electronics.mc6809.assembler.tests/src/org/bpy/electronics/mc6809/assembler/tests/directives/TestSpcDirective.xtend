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
import org.bpy.electronics.mc6809.assembler.assembler.SpcDirective
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledSpcDirectiveLine
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser
import org.bpy.electronics.mc6809.assembler.validation.AssemblerValidator
import org.eclipse.xtext.diagnostics.Severity

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestSpcDirective {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper h
	
	/**
	 * Check SPC directive no value, no extra space, no comment 
	 */
	@Test 
	def void testSPCWithoutCommentWithSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		 		   SPC 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(1)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an SPC directive line", directiveLine.directive instanceof SpcDirective)
	}

	/**
	 * Check SPC directive with space count, no extra space, no comment 
	 */
	@Test 
	def void testSPCWithSpaceCountValue() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		 		   SPC 25
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(1)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an SPC directive line", directiveLine.directive instanceof SpcDirective)
	}

	/**
	 * Check SPC directive with space count and keep count, no extra space, no comment 
	 */
	@Test 
	def void testSPCWithSpaceCountAndKeepCountValue() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		 		   SPC 25,10
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(1)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an SPC directive line", directiveLine.directive instanceof SpcDirective)
	}

	/**
	 * Check SPC directive with space count and keep count, no extra space, and comment 
	 */
	@Test 
	def void tesSPCWithSpaceCountAndKeepCountValueAndComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		 		   SPC 25,10   ; check SPC
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(1)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an SPC directive line", directiveLine.directive instanceof SpcDirective)
	}

	/**
	 * Check SPC directive with expression 
	 */
	@Test 
	def void tesSPCWithExpression() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		Five       EQU 		5
		 		   SPC      (Five*2)+5   ; check SPC
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an SPC directive line", directiveLine.directive instanceof SpcDirective)
	}
	
	/**
	 * Check SPC directive with an unexpected label
	 */
	@Test 
	def void testWithUnexpectedLabel() {
		val result = parseHelper.parse('''
		; test SPC with label
		AnSPC 	    SPC    	1 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.directiveLine,DirectiveValidator::UNEXPECTED_LABEL,"No label may be set for SPC directive")
	}
	
	/**
	 * Check SPC directive space value with negative operand
	 */
	@Test 
	def void testSPCWithSpaceValueNegativeOperand() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   SPC    -1        ; Page 1
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.spcDirective, DirectiveValidator::INVALID_RANGE,"SPC space value can't be negative")
	}

	/**
	 * Check SPC directive with space value operand equals to 0
	 */
	@Test 
	def void testSPCWithSpaceValue0() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   SPC    1-1 
		''')
		Assert.assertNotNull(result)
		result.assertWarning(AssemblerPackage.eINSTANCE.spcDirective, DirectiveValidator::INVALID_RANGE,"0 Space count value is suspicious")
	}

	/**
	 * Check SPC directive with space value operand equals to 9
	 */
	@Test 
	def void testSPCWithSpaceValue9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   SPC    9 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}

	/**
	 * Check SPC directive with keep value operand equals to 10
	 */
	@Test 
	def void testSPCWithSpaceValue10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   SPC    10 
		''')
		Assert.assertNotNull(result)
		result.assertWarning(AssemblerPackage.eINSTANCE.spcDirective, DirectiveValidator::INVALID_RANGE,"SPC value superior to 9 is suspicious")
	}
	/**
	 * Check SPC directive keep value with negative operand
	 */
	@Test 
	def void testSPCWithKeepValueNegativeOperand() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   SPC    1,-1        ; Page 1
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.spcDirective, DirectiveValidator::INVALID_RANGE,"SPC keep count value can't be negative")
	}

	/**
	 * Check SPC directive with keep value operand equals to 0
	 */
	@Test 
	def void testSPCWithKeepValue0() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   SPC    1,0 
		''')
		Assert.assertNotNull(result)
		result.assertWarning(AssemblerPackage.eINSTANCE.spcDirective, DirectiveValidator::INVALID_RANGE,"0 keep count value is suspicious")
	}

	/**
	 * Check SPC directive with keep value operand equals to 9
	 */
	@Test 
	def void testSPCWithKeepValue9() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   SPC    1,9 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}

	/**
	 * Check SPC directive with space value operand equals to 10
	 */
	@Test 
	def void testSPCWithKeepValue10() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   SPC    1,10 
		''')
		Assert.assertNotNull(result)
		result.assertWarning(AssemblerPackage.eINSTANCE.spcDirective, DirectiveValidator::INVALID_RANGE,"SPC keep count value superior to 9 is suspicious")
	}

	/**
	 * Check SPC directive with label
	 */
	@Test 
	def void testSPCWithLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		Label 		   SPC    1 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.directiveLine, DirectiveValidator::UNEXPECTED_LABEL,"No label may be set for SPC directive")
	}

	/**
	 * Check PC counter SPC directive 
	 */
	@Test 
	def void testSPCPCCounter() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   SPC    1 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC after SPC instruction", 0x8000, engine.currentPcValue)		
	}
	
	/**
	 * Check SPC directive  assembly 
	 */
	@Test 
	def void testSPCAssembly1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		 		   SPC    1,2 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1) as AssembledSpcDirectiveLine
		Assert.assertEquals("Check Space count", 1, line.spaceCountValue)
		Assert.assertEquals("Check Keep count", 2, line.getkeepCountValue)
	}
	
	/**
	 * Check SPC directive  assembly 
	 */
	@Test 
	def void testSPCAssembly2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		 		   SPC    1 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1) as AssembledSpcDirectiveLine
		Assert.assertEquals("Check Space count", 1, line.spaceCountValue)
		Assert.assertEquals("Check Keep count", 0, line.getkeepCountValue)
	}
	
	
	/**
	 * Check SPC with error in expression 
	 */
	@Test 
	def void testSpcWithErrorExpression() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			           	ORG    	$2000  		 	; With value
		TOTO	       	SPC    	10*Deux 		; Toto vaudra $2000
												; Et en mémoire entre $2000 et $2010, il y aura des 0
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.spcDirective, ExpressionParser::EXPRESSION_ERROR, "Can't find Deux definition")
	}

	/**
	 * Check SPC with binary error syntax
	 */
	@Test 
	def void testBszWithBinaryErrorSyntax() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			           	ORG    	$2000  		 	; With value
		TOTO	       	SPC    	%01111211 		; Toto vaudra $2000
												; Et en mémoire entre $2000 et $2010, il y aura des 0
		''')
		Assert.assertNotNull(result)
		h.assertIssue(result.eResource,AssemblerPackage.Literals.BINARY_VALUE,AssemblerValidator::INVALID_FIGURE,113,8,Severity::ERROR, "2 is invalid in binary value")
	}

	/**
	 * Check SPC with octal error syntax
	 */
	@Test 
	def void testBszWithOctalErrorSyntax() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			           	ORG    	$2000  		 	; With value
		TOTO	       	SPC    	@128	 		; Toto vaudra $2000
												; Et en mémoire entre $2000 et $2010, il y aura des 0
		''')
		Assert.assertNotNull(result)
		h.assertIssue(result.eResource,AssemblerPackage.Literals.OCTAL_VALUE,AssemblerValidator::INVALID_FIGURE,113,3,Severity::ERROR, "8 is invalid in octal value")
	}
	
}
	