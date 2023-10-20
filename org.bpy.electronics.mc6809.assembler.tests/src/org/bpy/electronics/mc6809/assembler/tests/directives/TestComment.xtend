package org.bpy.electronics.mc6809.assembler.tests.directives

import com.google.inject.Inject
import org.bpy.electronics.mc6809.assembler.assembler.Model
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)
class TestComment {
	@Inject
	ParseHelper<Model> parseHelper
	
	@Test
	def void testComment01() {
		val result = parseHelper.parse('''
			; ---------------------------------------------------------------
			; Check for comment
			; ---------------------------------------------------------------
			
			; it is the end
			
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
	}
	
	@Test
	def void testOneMainLine() {
		val result = parseHelper.parse('''
			; ---------------------------------------------------------------
			
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
	}

	@Test
	def void testOneMainLinePlusSpace() {
		val result = parseHelper.parse('''
			; ---------------------------------------------------------------
			
			
		''')
		Assert.assertNotNull(result)
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
	}
}