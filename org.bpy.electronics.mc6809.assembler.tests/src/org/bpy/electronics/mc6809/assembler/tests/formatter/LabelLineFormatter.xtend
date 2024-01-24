package org.bpy.electronics.mc6809.assembler.tests.formatter

import com.google.inject.Inject
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.junit.runner.RunWith
import org.junit.Test
import org.eclipse.xtext.testing.util.ParseHelper
import org.bpy.electronics.mc6809.assembler.assembler.Model
import org.eclipse.xtext.resource.SaveOptions
import org.junit.Assert

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)
class LabelLineFormatter {
	
	 
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ISerializer
	
	@Test
	def void  testFormatter01() {
		val test = '''TEST:		   ; test '''
		val expectedResult = '''TEST:                                              ; test '''
		Assert.assertEquals(expectedResult,	parseHelper.parse(test).serialize(SaveOptions.newBuilder.format().getOptions()))
	}

	@Test
	def void  testFormatter02() {
		val test = '''TEST		   ; test '''
		val expectedResult = '''TEST                                               ; test '''
		Assert.assertEquals(expectedResult,	parseHelper.parse(test).serialize(SaveOptions.newBuilder.format().getOptions()))
	}
}