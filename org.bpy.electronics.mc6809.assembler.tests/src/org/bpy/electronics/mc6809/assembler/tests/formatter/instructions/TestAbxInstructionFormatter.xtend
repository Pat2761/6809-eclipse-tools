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
		setJunitPreferences()
		
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
	
	@Test
	def void  testFormatterTabOnly() {
		tabPolicy = PreferenceManager::TAB_ONLY
		instructionPosition = 10
		operandPosition = 22
		commentPosition = 40
		
		val test1 = ''' ABX ; Instruction without operand
		'''
		val test2 = '''Z ABX ; Instruction without operand
		'''
		val test3 = '''X2: ABX ; Instruction without operand
		'''
		val test4 = '''X2c:	ABX	; Instruction without operand
		'''
		val test5 = '''X23 ABX ; Instruction without operand
		'''
		val test6 = '''Xai1 ABX	; Instruction without operand
		'''
		val test7 = '''Xai2: ABX ; Instruction without operand
		'''
		val test8 = '''Xait3: ABX ; Instruction without operand
		'''
		val test9 = '''Xait31: ABX ; Instruction without operand
		'''
		val test10 = '''XXait312: ABX ; Instruction without operand
		'''
		
		val result1 = parseHelper.parse(test1).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","\t\t\tA",result1.substring(0,4))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result1.substring(3,16))
		Assert.assertEquals("Check comment","; Instruction without operand",result1.substring(15,44))

		val result2 = parseHelper.parse(test2).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Z\t\t\tA",result2.substring(0,5))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result2.substring(4,17))
		Assert.assertEquals("Check comment","; Instruction without operand",result2.substring(16,45))

		val result3 = parseHelper.parse(test3).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","X2:\t\tA",result3.substring(0,6))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result3.substring(5,18))
		Assert.assertEquals("Check comment","; Instruction without operand",result3.substring(17,46))

		val result4 = parseHelper.parse(test4).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","X2c:\t\tA",result4.substring(0,7))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result4.substring(6,19))
		Assert.assertEquals("Check comment","; Instruction without operand",result4.substring(18,47))
		
		val result5 = parseHelper.parse(test5).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","X23\t\tA",result5.substring(0,6))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result5.substring(5,18))
		Assert.assertEquals("Check comment","; Instruction without operand",result5.substring(17,46))
		
		val result6 = parseHelper.parse(test6).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Xai1\t\tA",result6.substring(0,7))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result6.substring(6,19))
		Assert.assertEquals("Check comment","; Instruction without operand",result6.substring(18,47))
		
		val result7 = parseHelper.parse(test7).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Xai2:\t\tA",result7.substring(0,8))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result7.substring(7,20))
		Assert.assertEquals("Check comment","; Instruction without operand",result7.substring(19,48))
		
		val result8 = parseHelper.parse(test8).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Xait3:\tA",result8.substring(0,8))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result8.substring(7,20))
		Assert.assertEquals("Check comment","; Instruction without operand",result8.substring(19,48))
		
		val result9 = parseHelper.parse(test9).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Xait31:\tA",result9.substring(0,9))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result9.substring(8,21))
		Assert.assertEquals("Check comment","; Instruction without operand",result9.substring(20,49))
		
		val result10 = parseHelper.parse(test10).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","XXait312:\tA",result10.substring(0,11))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result10.substring(10,23))
		Assert.assertEquals("Check comment","; Instruction without operand",result10.substring(22,51))
	}

	@Test
	def void  testFormatterMixed() {
		tabPolicy = PreferenceManager::MIXED
		instructionPosition = 11
		operandPosition = 26
		commentPosition = 41
		
		val test1 = ''' ABX ; Instruction without operand
		'''
		val test2 = '''Z ABX ; Instruction without operand
		'''
		val test3 = '''X2: ABX ; Instruction without operand
		'''
		val test4 = '''X2c:	ABX	; Instruction without operand
		'''
		val test5 = '''X23 ABX ; Instruction without operand
		'''
		val test6 = '''Xai1 ABX	; Instruction without operand
		'''
		val test7 = '''Xai2: ABX ; Instruction without operand
		'''
		val test8 = '''Xait3: ABX ; Instruction without operand
		'''
		val test9 = '''Xait31: ABX ; Instruction without operand
		'''
		val test10 = '''XXait312: ABX ; Instruction without operand
		'''
		
		val result1 = parseHelper.parse(test1).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","\t\t\t A",result1.substring(0,5))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result1.substring(4,18))
		Assert.assertEquals("Check comment","; Instruction without operand",result1.substring(17,46))

		val result2 = parseHelper.parse(test2).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Z\t\t\t A",result2.substring(0,6))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result2.substring(5,19))
		Assert.assertEquals("Check comment","; Instruction without operand",result2.substring(18,47))

		val result3 = parseHelper.parse(test3).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","X2:\t\t A",result3.substring(0,7))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result3.substring(6,20))
		Assert.assertEquals("Check comment","; Instruction without operand",result3.substring(19,48))

		val result4 = parseHelper.parse(test4).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","X2c:\t\t A",result4.substring(0,8))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result4.substring(7,21))
		Assert.assertEquals("Check comment","; Instruction without operand",result4.substring(20,49))
		
		val result5 = parseHelper.parse(test5).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","X23\t\t A",result5.substring(0,7))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result5.substring(6,20))
		Assert.assertEquals("Check comment","; Instruction without operand",result5.substring(19,48))
		
		val result6 = parseHelper.parse(test6).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Xai1\t\t A",result6.substring(0,8))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result6.substring(7,21))
		Assert.assertEquals("Check comment","; Instruction without operand",result6.substring(20,49))
		
		val result7 = parseHelper.parse(test7).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Xai2:\t\t A",result7.substring(0,9))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result7.substring(8,22))
		Assert.assertEquals("Check comment","; Instruction without operand",result7.substring(21,50))
		
		val result8 = parseHelper.parse(test8).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Xait3:\t A",result8.substring(0,9))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result8.substring(8,22))
		Assert.assertEquals("Check comment","; Instruction without operand",result8.substring(21,50))
		
		val result9 = parseHelper.parse(test9).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Xait31:\t A",result9.substring(0,10))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result9.substring(9,23))
		Assert.assertEquals("Check comment","; Instruction without operand",result9.substring(22,51))
		
		val result10 = parseHelper.parse(test10).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","XXait312: A",result10.substring(0,11))
		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result10.substring(10,24))
		Assert.assertEquals("Check comment","; Instruction without operand",result10.substring(23,52))
	}
}