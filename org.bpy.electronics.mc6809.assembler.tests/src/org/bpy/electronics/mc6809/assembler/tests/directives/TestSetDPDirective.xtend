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
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser
import org.eclipse.xtext.diagnostics.Severity
import org.bpy.electronics.mc6809.assembler.validation.AssemblerValidator
import org.bpy.electronics.mc6809.assembler.assembler.SetDPDirective

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestSetDPDirective {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper h
	
	/**
	 * Check SETDP directive without comment
	 */
	@Test 
	def void testSetDPWithoutCommentWithSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   SETDP    
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an SETDP directive line", directiveLine.directive instanceof SetDPDirective)
	}
	
	/**
	 * Check SETDP directive without comment
	 */
	@Test 
	def void testSetDPWithoutCommentWithoutSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   SETDP
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an SETDP directive line", directiveLine.directive instanceof SetDPDirective)
	}
	
	/**
	 * Check SETDP directive with value
	 */
	@Test 
	def void testSetDPWithValueWithoutComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   SETDP    1
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an SETDP directive line", directiveLine.directive instanceof SetDPDirective)
	}

	/**
	 * Check SETDP directive with value and comment
	 */
	@Test 
	def void testSetDPWithValueWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   SETDP    1        ; Page 1
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an SETDP directive line", directiveLine.directive instanceof SetDPDirective)
	}

	/**
	 * Check SETDP directive with expression and comment
	 */
	@Test 
	def void testSetDPWithExpressionWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG  	  $8000
		 		   SETDP    	1+1        ; Page 1
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an SETDP directive line", directiveLine.directive instanceof SetDPDirective)
	}

	/**
	 * Check SETDP directive with negative operand
	 */
	@Test 
	def void testSetDPWithNegativeOperand() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		 		   SETDP    -1        ; Page 1
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.setDPDirective, DirectiveValidator::INVALID_RANGE,"SETDP value can't be negative")
	}

	/**
	 * Check SETDP directive with operand equals to 0
	 */
	@Test 
	def void testSetDPWith0() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		 		   SETDP    1-1 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}

	/**
	 * Check SETDP directive with operand equals to 255
	 */
	@Test 
	def void testSetDPWith255() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    			$8000
		 		   SETDP    		255	 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}

	/**
	 * Check SETDP directive with operand equals to 256
	 */
	@Test 
	def void testSetDPWith256() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		 		   SETDP    256 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.setDPDirective, DirectiveValidator::INVALID_RANGE,"The SETDP value cannot be greater than 255")
	}
	
	/**
	 * Check SETDP directive with an unexpected label
	 */
	@Test 
	def void testSetDPWithUnexpectedLabel() {
		val result = parseHelper.parse('''
		; test PAG with label
		APAG 	    SETDP    	1 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.directiveLine,DirectiveValidator::UNEXPECTED_LABEL,"No label may be set for SETDP directive")
	}
	
	
	/**
	 * Check PC counter after SETDP directive 
	 */
	@Test 
	def void testSetDPPCCounter0() {
		val result = parseHelper.parse('''
		; -----------------------------------------
					ORG			$2000
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC after SETDP instruction", 0x2000, engine.currentPcValue)		
		Assert.assertEquals("Check SETDP value", 0, engine.currentDPPage)		
		
	}

	/**
	 * Check PC counter after SETDP directive 
	 */
	@Test 
	def void testSetDPPCCounter() {
		val result = parseHelper.parse('''
		; -----------------------------------------
					ORG			$2000
				   	SETDP    	1			   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC after SETDP instruction", 0x2000, engine.currentPcValue)		
		Assert.assertEquals("Check SETDP value", 1, engine.currentDPPage)		
		
	}
	
	/**
	 * Check  with error in expression 
	 */
	@Test 
	def void testSetDPWithErrorExpression() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			           	ORG    		$2000  		 	; With value
				       	SETDP    	10*Deux 		; Toto vaudra $2000
													; Et en mémoire entre $2000 et $2010, il y aura des 0
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.setDPDirective, ExpressionParser::EXPRESSION_ERROR, "Can't find Deux definition")
	}

	/**
	 * Check SETDP with binary error syntax
	 */
	@Test 
	def void testSetDPWithBinaryErrorSyntax() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			           	ORG    	$2000  		 	; With value
				       	SETDP  	%01111211 		; Toto vaudra $2000
												; Et en mémoire entre $2000 et $2010, il y aura des 0
		''')
		Assert.assertNotNull(result)
		h.assertIssue(result.eResource,AssemblerPackage.Literals.BINARY_VALUE,AssemblerValidator::INVALID_FIGURE,110,8,Severity::ERROR, "2 is invalid in binary value")
	}

	/**
	 * Check SETDP with octal error syntax
	 */
	@Test 
	def void testSetDPWithOctalErrorSyntax() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			           	ORG    		$2000  		 	; With value
			       		SETDP    	@128	 		; Toto vaudra $2000
													; Et en mémoire entre $2000 et $2010, il y aura des 0
		''')
		Assert.assertNotNull(result)
		h.assertIssue(result.eResource,AssemblerPackage.Literals.OCTAL_VALUE,AssemblerValidator::INVALID_FIGURE,113,3,Severity::ERROR, "8 is invalid in octal value")
	}
	
}
	