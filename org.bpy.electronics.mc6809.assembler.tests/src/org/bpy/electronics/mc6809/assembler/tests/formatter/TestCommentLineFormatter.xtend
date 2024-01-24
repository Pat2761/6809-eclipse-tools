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

class TestCommentLineFormatter extends AbstractTestFormatter {
	 
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ISerializer
	
	@Test
	def void  testFormatterSpaceOnly01() {
		tabPolicy = PreferenceManager::SPACE_ONLY
		val test = '''		; test
		'''
		println(test)
		val expectedResult = '''                                                    ; test
		'''
		val result = parseHelper.parse(test).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals(expectedResult,	result)
	}

	@Test
	def void  testFormatterTabOnly01() {
		tabPolicy = PreferenceManager::TAB_ONLY
		commentPosition = 54
		val test = '''		; test
		'''
		val expectedResult = '''																		; test
		'''
		val result = parseHelper.parse(test).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals(expectedResult,	result)
	}

	@Test
	def void  testFormatterMixed01() {
		tabPolicy = PreferenceManager::MIXED
		commentPosition = 52
		val test = '''		; test
		'''
		val expectedResult = '''																	 ; test
		'''
		val result = parseHelper.parse(test).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals(expectedResult,	result)
	}
}