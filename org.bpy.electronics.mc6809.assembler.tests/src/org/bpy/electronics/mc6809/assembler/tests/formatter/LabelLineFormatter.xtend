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
import org.bpy.electronics.mc6809.preferences.core.PreferenceManager

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)
class LabelLineFormatter extends AbstractTestFormatter {
	
	 
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ISerializer
	
	@Test
	def void  testFormatterSpaceOnly01() {
		tabPolicy = PreferenceManager::SPACE_ONLY
		val test = '''TEST:		   ; test '''
		val expectedResult = '''TEST:                                              ; test '''
		Assert.assertEquals(expectedResult,	parseHelper.parse(test).serialize(SaveOptions.newBuilder.format().getOptions()))
	}

	@Test
	def void  testFormatterSpaceOnly02() {
		tabPolicy = PreferenceManager::SPACE_ONLY
		val test = '''TEST		   ; test '''
		val expectedResult = '''TEST                                               ; test '''
		Assert.assertEquals(expectedResult,	parseHelper.parse(test).serialize(SaveOptions.newBuilder.format().getOptions()))
	}
	
	@Test
	def void  testFormatterTabOnly01() {
		tabPolicy = PreferenceManager::TAB_ONLY
		val test = '''TEST:		   ; test '''
		val expectedResult = '''TEST:                                              ; test '''
		Assert.assertEquals(expectedResult,	parseHelper.parse(test).serialize(SaveOptions.newBuilder.format().getOptions()))
	}

	@Test
	def void  testFormatterTabOnly02() {
		tabPolicy = PreferenceManager::TAB_ONLY
		val test = '''TEST		   ; test '''
		val expectedResult = '''TEST                                               ; test '''
		Assert.assertEquals(expectedResult,	parseHelper.parse(test).serialize(SaveOptions.newBuilder.format().getOptions()))
	}
}