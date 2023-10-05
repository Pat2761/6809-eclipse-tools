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
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective
import org.bpy.electronics.mc6809.assembler.util.CommandUtil

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestEquDirective {
	@Inject
	ParseHelper<Model> parseHelper
	
	
	/**
	 * Check EQU directive with a simple decimal value
	 */
	@Test 
	def void testWithDecimalValue() {
		val result = parseHelper.parse('''
		Label1       EQU    1234 
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertEquals("",1,1)
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
		
		val equDirective = directiveLine.directive as EquDirective
	 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective))	
		Assert.assertEquals("Operand must be equals to 1234", 1234, ExpressionParser.parse(equDirective))		
	}
	
	@Test
	/**
	 * Check EQU directive with an addition of two decimal values 
	 */
	def void testWithAdditionOfTwoDecimalValue() {
		val result = parseHelper.parse('''
		Label1       EQU    12+24		 
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertEquals("",1,1)
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
		
		val equDirective = directiveLine.directive as EquDirective
	 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective))	
		Assert.assertEquals("Operand must be equals to 36", 36, ExpressionParser.parse(equDirective))		
	}

	
	@Test
	/**
	 * Check EQU directive with an addition of three decimal values
	 */
	def void testWithAdditionOfThreeDecimalValue() {
		val result = parseHelper.parse('''
		Label1       EQU    12+24+5		 
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertEquals("",1,1)
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
		
		val equDirective = directiveLine.directive as EquDirective
	 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective))	
		Assert.assertEquals("Operand must be equals to 41", 41, ExpressionParser.parse(equDirective))		
	}

	@Test
	/**
	 * Check EQU directive with an addition of two decimal values and a multiplication
	 * check the parenthesis priority
	 */
	def void testWithAdditionOfTwoDecimalValueAndMultiplication() {
		val result = parseHelper.parse('''
		Label1       EQU    (12+24)*5		 
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertEquals("",1,1)
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
		
		val equDirective = directiveLine.directive as EquDirective
	 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective))	
		Assert.assertEquals("Operand must be equals to 180", 180, ExpressionParser.parse(equDirective))		
	}

	@Test
	/**
	 * Check EQU directive with an hexadecimal value
	 */
	def void testWithHexadecimalvalue() {
		val result = parseHelper.parse('''
		Label1       EQU    $FF00		 
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertEquals("",1,1)
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
		
		val equDirective = directiveLine.directive as EquDirective
	 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective))	
		Assert.assertEquals("Operand must be equals to 65280", 65280, ExpressionParser.parse(equDirective))		
	}

	@Test
	/**
	 * Check EQU directive with the addition of two hexadecimal values
	 */
	def void testWithAdditionHexadecimalvalue() {
		val result = parseHelper.parse('''
		Label1       EQU    $A7+$25		 
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertEquals("",1,1)
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
		
		val equDirective = directiveLine.directive as EquDirective
	 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective))	
		Assert.assertEquals("Operand must be equals to 204", 204, ExpressionParser.parse(equDirective))		
	}

	/**
	 * Check EQU directive with an addition of a decimal values and a hexadecimal value
	 */
	@Test
	def void testWithMultiplicationHexadecimalvalue() {
		val result = parseHelper.parse('''
		Label1       EQU    125*$A		 
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertEquals("",1,1)
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
		
		val equDirective = directiveLine.directive as EquDirective
	 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective))	
		Assert.assertEquals("Operand must be equals to 1250", 1250, ExpressionParser.parse(equDirective))		
	}
	
	/**
	 * Check EQU directive with a binary value
	 */
	@Test 
	def void testWithABinaryValue() {
		val result = parseHelper.parse('''
		Label1       EQU    %10010011		 
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertEquals("",1,1)
		Assert.assertTrue("Must be an EQU directive line", directiveLine.directive instanceof EquDirective)
		
		val equDirective = directiveLine.directive as EquDirective
	 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective))	
		Assert.assertEquals("Operand must be equals to 147", 147, ExpressionParser.parse(equDirective))		
	}
	
}