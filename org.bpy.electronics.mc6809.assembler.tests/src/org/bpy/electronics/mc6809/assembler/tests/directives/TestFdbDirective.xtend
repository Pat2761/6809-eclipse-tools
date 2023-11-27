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
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator
import org.bpy.electronics.mc6809.assembler.assembler.FdbDirective
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledFdbDirectiveLine
import org.bpy.electronics.mc6809.assembler.validation.AssemblerValidator
import org.eclipse.xtext.diagnostics.Severity
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestFdbDirective {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper h
	
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
	}

	/**
	 * Check FDB directive with a bad negative value
	 */
	@Test 
	def void testFDBWithBadNegativeValue() {
		val result = parseHelper.parse('''
			         ORG    $8000
		Label1       FDB    10,0,-32769,40 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.fdbDirective,DirectiveValidator::INVALID_RANGE,"FDB value can't lower than -32768 at location 3")
	}

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
	@Test 
	def void testFDBWithBadPositiveValue() {
		val result = parseHelper.parse('''
			         ORG    $8000
		Label1       FDB    65536,0,128,40 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.fdbDirective,DirectiveValidator::INVALID_RANGE,"FDB value maximum value is 65535 at location 1")
	}

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
	
	
	/**
	 * Check FDB directive with duplicate Label
	 */
	@Test 
	def void testFCBWithDuplicateLabels() {
		val result = parseHelper.parse('''
			         ORG    $8000
		Label1	     BSZ	10    
		Label1       FDB    10 
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.directiveLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"Label Label1 is already defined"
		)
	}

	/**
	 * Check FDB directive with duplicate Label
	 */
	@Test 
	def void testFDBAssemblyResult() {
		val result = parseHelper.parse('''
			        	ORG    	$8000
		EquVal			EQU		15         
		Label1			BSZ		10    
		Label2			FDB    	10,,'A,EquVal*2,$2500 		; a comment
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(3) as AssembledFdbDirectiveLine;
		Assert.assertEquals("Check Label","Label2",line.label)
		Assert.assertEquals("Check Comment","; a comment",line.comment)

		Assert.assertEquals("Check value 0",10,line.values.get(0))
		Assert.assertEquals("Check value 1",0,line.values.get(1))
		Assert.assertEquals("Check value 2",65,line.values.get(2))
		Assert.assertEquals("Check value 3",30,line.values.get(3))
		Assert.assertEquals("Check value 4",0x2500,line.values.get(4))

		Assert.assertEquals("Check Impact on PC",0x8014,engine.currentPcValue)
	}

	/**
	 * Check FDB with error in expression 
	 */
	@Test 
	def void testFdbWithErrorExpression() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			           	ORG    	$2000  		 	; With value
		TOTO	       	FDB    	10*Deux 		; Toto vaudra $2000
												; Et en mémoire entre $2000 et $2010, il y aura des 0
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.fdbDirective, ExpressionParser::EXPRESSION_ERROR, "Can't find Deux definition")
	}

	/**
	 * Check FDB with binary error syntax
	 */
	@Test 
	def void testFdbWithBinaryErrorSyntax() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			           	ORG    	$2000  		 	; With value
		TOTO	       	FDB    	%01111211 		; Toto vaudra $2000
												; Et en mémoire entre $2000 et $2010, il y aura des 0
		''')
		Assert.assertNotNull(result)
		h.assertIssue(result.eResource,AssemblerPackage.Literals.BINARY_VALUE,AssemblerValidator::INVALID_FIGURE,113,8,Severity::ERROR, "2 is invalid in binary value")
	}

	/**
	 * Check FDB with octal error syntax
	 */
	@Test 
	def void testFdbWithOctalErrorSyntax() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			           	ORG    	$2000  		 	; With value
		TOTO	       	FDB    	@128	 		; Toto vaudra $2000
												; Et en mémoire entre $2000 et $2010, il y aura des 0
		''')
		Assert.assertNotNull(result)
		h.assertIssue(result.eResource,AssemblerPackage.Literals.OCTAL_VALUE,AssemblerValidator::INVALID_FIGURE,113,3,Severity::ERROR, "8 is invalid in octal value")
	}
	
}