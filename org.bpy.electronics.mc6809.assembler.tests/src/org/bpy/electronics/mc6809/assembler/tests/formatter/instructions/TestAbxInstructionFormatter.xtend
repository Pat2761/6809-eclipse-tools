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
	def void  testFormatterSpaceOnly() {
		tabPolicy = PreferenceManager::SPACE_ONLY
		instructionPosition = 10
		operandPosition = 22
		commentPosition = 40
		
		val test1 = ''' ABX ; Instruction without operand
		''' 
		val test2 = '''W ABX ; Instruction without operand
		'''
		val test3 = '''W2: ABX ; Instruction without operand
		'''
		val test4 = '''Wait1234: ABX ; Instruction without operand
		'''

		val result1 = parseHelper.parse(test1).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","         A",result1.substring(0,10))
		Assert.assertEquals("Check spaces after instruction","ABX                           ;",result1.substring(9,40))
		Assert.assertEquals("Check comment","; Instruction without operand",result1.substring(39,68))
		
		val result2 = parseHelper.parse(test2).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","W        A",result2.substring(0,10))
		Assert.assertEquals("Check spaces after instruction","ABX                           ;",result2.substring(9,40))
		Assert.assertEquals("Check comment","; Instruction without operand",result1.substring(39,68))
		
		val result3 = parseHelper.parse(test3).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","W2:      A",result3.substring(0,10))
		Assert.assertEquals("Check spaces after instruction","ABX                           ;",result3.substring(9,40))
		Assert.assertEquals("Check comment","; Instruction without operand",result1.substring(39,68))
		
		val result4 = parseHelper.parse(test4).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Wait1234: A",result4.substring(0,11))
		Assert.assertEquals("Check spaces after instruction","ABX                           ;",result4.substring(10,41))
		Assert.assertEquals("Check comment","; Instruction without operand",result4.substring(40,69))
	}
}