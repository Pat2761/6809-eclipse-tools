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
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledDirectiveLine

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestOrgDirective {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check ORG directive with a simple decimal value
	 */
	@Test 
	def void testOrgWithHexaDecimalValue() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(1)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an ORG directive line", directiveLine.directive instanceof OrgDirective)
		
//		val orgDirective = directiveLine.directive as OrgDirective
//	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(orgDirective))	
//		Assert.assertEquals("Operand must be equals to 8000", 0x8000, ExpressionParser.parse(orgDirective))		
	}
	
	/**
	 * Check ORG directive with no value , return 0
	 */
	@Test 
	def void testOrgWithNoValueValue() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    ; Without value 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(1)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an ORG directive line", directiveLine.directive instanceof OrgDirective)
		
//		val orgDirective = directiveLine.directive as OrgDirective
//	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(orgDirective))	
//		Assert.assertEquals("Operand must be equals to 0", 0, ExpressionParser.parse(orgDirective))		
	}

	/**
	 * Check ORG directive with a simple identifier defined by an anothoer EQU
	 */
	@Test 
	def void testOrgWithIdentifierValue() {
		val result = parseHelper.parse('''
		; Starting assembly file
		Start       EQU    $4000         ; Starting code
		
		; Strating code section
		            ORG    Start         ; Start program at $4000
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val line0 = result.sourceLines.get(1)
		val directiveLine0 = line0.lineContent as DirectiveLine
		val equDirective0 = directiveLine0.directive as EquDirective
		ExpressionParser.parse(equDirective0)
		
		val line1 = result.sourceLines.get(4)
		Assert.assertTrue("Must be a directive line", line1.lineContent instanceof DirectiveLine)
		
		val directiveLine1 = line1.lineContent as DirectiveLine
		Assert.assertTrue("Must be an ORG directive line", directiveLine1.directive instanceof OrgDirective)
		
//		val orgDirective = directiveLine1.directive as OrgDirective
//	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(orgDirective))	
//		Assert.assertEquals("Operand must be equals to $4000", 0x4000, ExpressionParser.parse(orgDirective))		
	}

	/**
	 * Check ORG directive with a simple identifier defined by an anothoer EQU
	 */
	@Test 
	def void testWithComplexeValue() {
		val result = parseHelper.parse('''
		; Starting assembly file
		Start       EQU    $4000         ; Starting code
		
		; Strating code section
		            ORG    (Start*2)+32         ; Start program at $4000
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val line0 = result.sourceLines.get(1)
		val directiveLine0 = line0.lineContent as DirectiveLine
		val equDirective0 = directiveLine0.directive as EquDirective
		ExpressionParser.parse(equDirective0)
		
		val line1 = result.sourceLines.get(4)
		Assert.assertTrue("Must be a directive line", line1.lineContent instanceof DirectiveLine)
		
		val directiveLine1 = line1.lineContent as DirectiveLine
		Assert.assertTrue("Must be an ORG directive line", directiveLine1.directive instanceof OrgDirective)
	}

	/**
	 * Check ORG directive with a relative to PC value
	 */
	@Test 
	def void testORGWithRelativeValueToPC() {
		val result = parseHelper.parse('''
		; Strating code section
		            ORG    *+100         ; Start program at $4000
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val line1 = result.sourceLines.get(1)
		Assert.assertTrue("Must be a directive line", line1.lineContent instanceof DirectiveLine)
		
		val directiveLine1 = line1.lineContent as DirectiveLine
		Assert.assertTrue("Must be an ORG directive line", directiveLine1.directive instanceof OrgDirective)
	}

	/**
	 * Check ORG directive with a negative value
	 */
	@Test 
	def void testWithNegativeValue() {
		val result = parseHelper.parse('''
		Label1       ORG    -1 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.orgDirective,DirectiveValidator::INVALID_RANGE,"ORG value can't be negative")
	}

	/**
	 * Check ORG directive with the lowest limit
	 */
	@Test 
	def void testWithLowestValue() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		        ORG    0 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}

	/**
	 * Check ORG directive with the upper limit
	 */
	@Test 
	def void testWithUpperLimitValue() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		       ORG    $FFFF 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}

	/**
	 * Check ORG directive with the too high limit
	 */
	@Test 
	def void testWithToHighLimitValue() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		       ORG    $FFFF+1 
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.orgDirective,DirectiveValidator::INVALID_RANGE,"ORG value maximum value is $FFFF")
	}

	/**
	 * Check Sorek ORG directive 
	 */
	@Test 
	def void testSorekOrg1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		       ORG    $0400 		; opérande du type constante
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}

	/**
	 * Check Sorek ORG directive 
	 */
	@Test 
	def void testSorekOrg2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		RESET	EQU			$4000		; Reset
		
		        ORG         RESET       ; opérande du type symbole
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}

	/**
	 * Check Sorek ORG directive 
	 */
	@Test 
	def void testSorekOrg3() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		        ORG         *+100       ; opérande du type expression
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}

	/**
	 * Check Sorek ORG directive 
	 */
	@Test 
	def void testSorekOrg4() {
		val result = parseHelper.parse('''
		; -----------------------------------------
		SBR1			EQU			100	
		LGTAB			EQU			200
		
			      		ORG         SBR1+LGTAB*8       ; opérande du type expression
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}
	
	@Test
	def void checkNoValueResult() {
	val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    ; Without value 
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val assemblerEngine = AssemblerEngine.getInstance()
		result.assertNoErrors
	
		val assemblyLine = assemblerEngine.getAssembledLine(1)
		Assert.assertTrue("assemblyLine must be an Assembly line", assemblyLine instanceof AssembledDirectiveLine)
		val orgDirective = assemblyLine as AssembledDirectiveLine
		
		Assert.assertEquals("PC must be set to 0", 0, orgDirective.pcAddress)
		Assert.assertEquals("Line number must be 2", 2, orgDirective.lineNumber)
	
		Assert.assertEquals("Check current PC position", 0, assemblerEngine.currentPcValue)	
	}

	@Test
	def void checkWithValueResult() {
	val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000			; Without value 
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val assemblerEngine = AssemblerEngine.getInstance()
		result.assertNoErrors
	
		val assemblyLine = assemblerEngine.getAssembledLine(1)
		Assert.assertTrue("assemblyLine must be an Assembly line", assemblyLine instanceof AssembledDirectiveLine)
		val orgDirective = assemblyLine as AssembledDirectiveLine
		
		Assert.assertEquals("PC must be set to 8000", 0x8000, orgDirective.pcAddress)
		Assert.assertEquals("Line number must be 2", 2, orgDirective.lineNumber)
	
		Assert.assertEquals("Check current PC position", 0x8000, assemblerEngine.currentPcValue)	
	}

	@Test
	def void checkDuplicateLabel() {
	val result = parseHelper.parse('''
		; -----------------------------------------
		OrgPos	       ORG    				; Without value 
		OrgPos	       ORG    $8000			; With value 
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
	
		val assemblerEngine = AssemblerEngine.getInstance()

		result.assertError(AssemblerPackage.eINSTANCE.directiveLine, AssemblerEngine.DUPLICATE_LABEL,"Label OrgPos is already defined")
	
		val assemblyLine = assemblerEngine.getAssembledLine(2)
		Assert.assertTrue("assemblyLine must be an Assembly line", assemblyLine instanceof AssembledDirectiveLine)
		val orgDirective = assemblyLine as AssembledDirectiveLine
		
		Assert.assertEquals("PC must be set to 8000", 0x8000, orgDirective.pcAddress)
		Assert.assertEquals("Line number must be 3", 3, orgDirective.lineNumber)
	}
}