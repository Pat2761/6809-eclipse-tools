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
	 * Check EQU directive with an addition of two decimal values and a multiplication
	 * check the parenthesis priority
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
	 * Check EQU directive with an addition of two decimal values and a multiplication
	 * check the parenthesis priority
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
}