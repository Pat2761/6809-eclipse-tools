package org.bpy.electronics.mc6809.assembler.tests.formatter.instructions

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
import org.bpy.electronics.mc6809.assembler.tests.formatter.AbstractTestFormatter

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)
class TestAbxInstructionFormatter extends AbstractTestFormatter {
	 
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ISerializer
	
	@Test
	def void  testFormatterSpaceOnly01() {
		tabPolicy = PreferenceManager::SPACE_ONLY
		instructionPosition = 10
		operandPosition = 22
		commentPosition = 40
		
		val test = ''' ABX  ; comment
		'''
		
		val result = parseHelper.parse(test).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","         ",result.substring(0,9))
		Assert.assertEquals("Check spaces after instruction","ABX                          ",result.substring(10,39))
		Assert.assertEquals("Check comment","; comment",result.substring(40,49))
	}
	
	@Test
	def void  testFormatterSpaceOnly02() {
		tabPolicy = PreferenceManager::SPACE_ONLY
		instructionPosition = 10
		operandPosition = 22
		commentPosition = 40
		
		val test = '''Label ABX  ; comment
		'''
		
		val result = parseHelper.parse(test).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Label    ",result.substring(0,9))
		Assert.assertEquals("Check spaces after instruction","ABX                          ",result.substring(10,39))
		Assert.assertEquals("Check comment","; comment",result.substring(40,49))
	}
	
	@Test
	def void  testFormatterSpaceOnly03() {
		tabPolicy = PreferenceManager::SPACE_ONLY
		instructionPosition = 10
		operandPosition = 22
		commentPosition = 40
		
		val test = '''Label: ABX  ; comment
		'''
		
		val result = parseHelper.parse(test).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Label:   ",result.substring(0,9))
		Assert.assertEquals("Check spaces after instruction","ABX                          ",result.substring(10,39))
		Assert.assertEquals("Check comment","; comment",result.substring(40,49))
	}
	
	@Test
	def void  testFormatterTabOnly01() {
		tabPolicy = PreferenceManager::TAB_ONLY
		tabSize = 3
		instructionPosition = 10
		operandPosition = 25
		commentPosition = 49
		
		val test = ''' ABX  ; comment
		'''
		
		val result = parseHelper.parse(test).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","\t\t\tA",result.substring(0,4))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t\t\t\t;",result.substring(3,19))
		Assert.assertEquals("Check comment","; comment",result.substring(19,25))
	}
}