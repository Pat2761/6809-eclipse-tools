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
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective
import org.bpy.electronics.mc6809.assembler.assembler.FillDirective

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestFillDirective {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check BSZ directive with a simple values
	 */
	@Test 
	def void testBSZWithDecimalValue() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       FILL   $80,25 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an FILL directive line", directiveLine.directive instanceof FillDirective)
		
//		val endDirective = directiveLine.directive as EndDirective
//	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(endDirective))	
//		Assert.assertEquals("Operand must be equals to 1000", 1000, ExpressionParser.parse(endDirective))		
	}
	

	/**
	 * Check BSZ directive with a simple identifier defined by an another EQU
	 */
	@Test 
	def void testBSZWithIdentifierValue() {
		val result = parseHelper.parse('''
		; Starting assembly file
		Val1       EQU    $40            ; Number 
		
		; Strating code section
		           ORG    Start         ; Start program at $4000
		           FILL   Val1,10       ; Fill example
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
		Assert.assertTrue("Must be an FILL directive line", directiveLine1.directive instanceof FillDirective)
	}
}