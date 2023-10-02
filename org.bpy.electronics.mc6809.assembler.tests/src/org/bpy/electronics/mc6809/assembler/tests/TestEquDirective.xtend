package org.bpy.electronics.mc6809.assembler.tests

import org.eclipse.xtext.testing.XtextRunner
import org.junit.runner.RunWith
import org.eclipse.xtext.testing.InjectWith
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import org.bpy.electronics.mc6809.assembler.assembler.Model
import org.junit.Test
import org.junit.Assert
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine
import org.bpy.electronics.mc6809.assembler.assembler.AssemblyLine
import org.bpy.electronics.mc6809.assembler.assembler.Directive
import org.bpy.electronics.mc6809.assembler.assembler.Expression
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestEquDirective {
	@Inject
	ParseHelper<Model> parseHelper
	
	
	@Test
	/**
	 * Check EQU directive with a simple decimal value
	 */
	def void testWithDecimalValue() {
		val result = parseHelper.parse('''
		Label       EQU    1234 
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(0)
		Assert.assertTrue("Must be an Source line", line instanceof SourceLine)
		val assemblyLine = (line as SourceLine).assemblyLine
		Assert.assertTrue("Must be an assembly line", assemblyLine instanceof AssemblyLine)
		val directive = (assemblyLine as AssemblyLine).command
		Assert.assertTrue("Must be an directive", directive instanceof Directive)
		val equDirective = (directive as Directive).directive
		Assert.assertTrue("Must be an EQU directive", equDirective instanceof EquDirective)
		
		val label = (assemblyLine as AssemblyLine).labelField
		Assert.assertEquals("Bad label value", "Label", label.label)
		
		val expression = (equDirective as EquDirective).constant.value;
		Assert.assertTrue("Must be an directive", expression instanceof Expression)
		
		val equValue = ExpressionParser.resolveExpression(expression as Expression)
		Assert.assertEquals("Bad EQU Value", 1234,equValue)
	}
	
}