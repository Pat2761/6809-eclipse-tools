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

class TestADCAInstructionFormatter extends AbstractTestFormatter {
	 
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ISerializer
	
	@Test
	def void  testFormatterSpaceOnly() {
		tabPolicy = PreferenceManager::SPACE_ONLY
		instructionPosition = 10
		operandPosition = 22
		commentPosition = 40
		
		val test1 = ''' ADCA #$25 ; Instruction with operand
		''' 
		val test2 = '''W ADCA #$25 ; Instruction with operand
		'''
		val test3 = '''W2: ADCA #$25 ; Instruction with operand
		'''
		val test4 = '''Wait1234: ADCA #$25 ; Instruction with operand
		'''
		val test5 = '''Wait1234: ADCA #$25+$A ; Instruction with operand
		'''

		val result1 = parseHelper.parse(test1).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","         A",result1.substring(0,10))
		Assert.assertEquals("Check spaces after instruction","A        #",result1.substring(12,22))
		Assert.assertEquals("Check spaces after operand","#$25              ;",result1.substring(21,40))
		Assert.assertEquals("Check comment","; Instruction with operand",result1.substring(39,65))
		
		val result2 = parseHelper.parse(test2).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","W        A",result2.substring(0,10))
		Assert.assertEquals("Check spaces after instruction","A        #",result2.substring(12,22))
		Assert.assertEquals("Check spaces after operand","#$25              ;",result2.substring(21,40))
		Assert.assertEquals("Check comment","; Instruction with operand",result2.substring(39,65))
		
		val result3 = parseHelper.parse(test3).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","W2:      A",result3.substring(0,10))
		Assert.assertEquals("Check spaces after instruction","A        #",result3.substring(12,22))
		Assert.assertEquals("Check spaces after operand","#$25              ;",result3.substring(21,40))
		Assert.assertEquals("Check comment","; Instruction with operand",result3.substring(39,65))
		
		val result4 = parseHelper.parse(test4).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Wait1234: A",result4.substring(0,11))
		Assert.assertEquals("Check spaces after instruction","A        #",result4.substring(13,23))
		Assert.assertEquals("Check spaces after operand","#$25              ;",result4.substring(22,41))
		Assert.assertEquals("Check comment","; Instruction with operand",result4.substring(40,66))
		
		val result5 = parseHelper.parse(test5).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Wait1234: A",result5.substring(0,11))
		Assert.assertEquals("Check spaces after instruction","A        #",result5.substring(13,23))
		Assert.assertEquals("Check spaces after operand","#$25+$A          ;",result5.substring(22,41))
		Assert.assertEquals("Check comment","; Instruction with operand",result5.substring(40,65))
	}
	
	@Test
	def void  testFormatterTabOnly() {
		tabPolicy = PreferenceManager::TAB_ONLY
		instructionPosition = 10
		operandPosition = 22
		commentPosition = 40
		
		val test1 = ''' ADCA #$25 ; Instruction with operand
		'''
		val test2 = '''Z ADCA #$25 ; Instruction with operand
		'''
		val test3 = '''X2: ADCA #$25 ; Instruction with operand
		'''
		val test4 = '''X2c:	ADCA #$25	; Instruction with operand
		'''
		val test5 = '''X23 ADCA #$25 ; Instruction with operand
		'''
		val test6 = '''Xai1 ADCA #$25	; Instruction with operand
		'''
		val test7 = '''Xai2: ADCA #$25 ; Instruction with operand
		'''
		val test8 = '''Xait3: ADCA #$25 ; Instruction with operand
		'''
		val test9 = '''Xait31: ADCA #$25 ; Instruction with operand
		'''
		val test10 = '''XXait312: ADCA #$25 ; Instruction with operand
		'''
		val test11 = '''Xait4 ADCA 1+2+3+4+5+6+7+8+9+10	; Instruction with operand
		'''
		
		val result1 = parseHelper.parse(test1).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","\t\t\tA",result1.substring(0,4))
		Assert.assertEquals("Check spaces after instruction","A\t\t\t#",result1.substring(6,11))
		Assert.assertEquals("Check spaces after operand","#$25\t\t\t\t\t;",result1.substring(10,20))
		Assert.assertEquals("Check comment","; Instruction with operand",result1.substring(19,45))

		val result2 = parseHelper.parse(test2).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Z\t\t\tA",result2.substring(0,5))
		Assert.assertEquals("Check spaces after instruction","A\t\t\t#",result2.substring(7,12))
		Assert.assertEquals("Check spaces after operand","#$25\t\t\t\t\t;",result2.substring(11,21))
		Assert.assertEquals("Check comment","; Instruction with operand",result2.substring(20,46))

		val result3 = parseHelper.parse(test3).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","X2:\t\tA",result3.substring(0,6))
		Assert.assertEquals("Check spaces after instruction","A\t\t\t#",result3.substring(8,13))
		Assert.assertEquals("Check spaces after operand","#$25\t\t\t\t\t;",result3.substring(12,22))
		Assert.assertEquals("Check comment","; Instruction with operand",result3.substring(21,47))

		val result4 = parseHelper.parse(test4).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","X2c:\t\tA",result4.substring(0,7))
		Assert.assertEquals("Check spaces after instruction","A\t\t\t#",result4.substring(9,14))
		Assert.assertEquals("Check spaces after operand","#$25\t\t\t\t\t;",result4.substring(13,23))
		Assert.assertEquals("Check comment","; Instruction with operand",result4.substring(22,48))
		
		val result5 = parseHelper.parse(test5).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","X23\t\tA",result5.substring(0,6))
		Assert.assertEquals("Check spaces after instruction","A\t\t\t#",result5.substring(8,13))
		Assert.assertEquals("Check spaces after operand","#$25\t\t\t\t\t;",result5.substring(12,22))
		Assert.assertEquals("Check comment","; Instruction with operand",result5.substring(21,47))
		
		val result6 = parseHelper.parse(test6).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Xai1\t\tA",result6.substring(0,7))
		Assert.assertEquals("Check spaces after instruction","A\t\t\t#",result6.substring(9,14))
		Assert.assertEquals("Check spaces after operand","#$25\t\t\t\t\t;",result6.substring(13,23))
		Assert.assertEquals("Check comment","; Instruction with operand",result6.substring(22,48))
		
		val result7 = parseHelper.parse(test7).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Xai2:\t\tA",result7.substring(0,8))
		Assert.assertEquals("Check spaces after instruction","A\t\t\t#",result7.substring(10,15))
		Assert.assertEquals("Check spaces after operand","#$25\t\t\t\t\t;",result7.substring(14,24))
		Assert.assertEquals("Check comment","; Instruction with operand",result7.substring(23,49))
		
		val result8 = parseHelper.parse(test8).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Xait3:\tA",result8.substring(0,8))
		Assert.assertEquals("Check spaces after instruction","A\t\t\t#",result8.substring(10,15))
		Assert.assertEquals("Check spaces after operand","#$25\t\t\t\t\t;",result8.substring(14,24))
		Assert.assertEquals("Check comment","; Instruction with operand",result8.substring(23,49))
		
		val result9 = parseHelper.parse(test9).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Xait31:\tA",result9.substring(0,9))
		Assert.assertEquals("Check spaces after instruction","A\t\t\t#",result9.substring(11,16))
		Assert.assertEquals("Check spaces after operand","#$25\t\t\t\t\t;",result9.substring(15,25))
		Assert.assertEquals("Check comment","; Instruction with operand",result9.substring(24,50))
		
		val result10 = parseHelper.parse(test10).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","XXait312:\tA",result10.substring(0,11))
		Assert.assertEquals("Check spaces after instruction","A\t\t\t#",result10.substring(13,18))
		Assert.assertEquals("Check spaces after operand","#$25\t\t\t\t\t;",result10.substring(17,27))
		Assert.assertEquals("Check comment","; Instruction with operand",result10.substring(26,52))
		
		val result11 = parseHelper.parse(test11).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Xait4\t\tA",result11.substring(0,8))
		Assert.assertEquals("Check spaces after instruction","A\t\t\t1",result11.substring(10,15))
		Assert.assertEquals("Check spaces after operand","1+2+3+4+5+6+7+8+9+10\t;",result11.substring(14,3))
		Assert.assertEquals("Check comment","; Instruction with operand",result11.substring(26,52))
	}

	@Test
	def void  testFormatterMixed() {
		tabPolicy = PreferenceManager::MIXED
		instructionPosition = 11
		operandPosition = 26
		commentPosition = 41
		
		val test1 = ''' ADCA #$25 ; Instruction with operand
		'''
		val test2 = '''Z ADCA #$25 ; Instruction with operand
		'''
		val test3 = '''X2: ADCA #$25 ; Instruction with operand
		'''
		val test4 = '''X2c:	ADCA #$25	; Instruction with operand
		'''
		val test5 = '''X23 ADCA #$25 ; Instruction with operand
		'''
		val test6 = '''Xai1 ADCA #$25	; Instruction with operand
		'''
		val test7 = '''Xai2: ADCA #$25 ; Instruction with operand
		'''
		val test8 = '''Xait3: ADCA #$25 ; Instruction with operand
		'''
		val test9 = '''Xait31: ADCA #$25 ; Instruction with operand
		'''
		val test10 = '''XXait312: ADCA #$25 ; Instruction with operand
		'''
		
		val result1 = parseHelper.parse(test1).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","\t\t\t A",result1.substring(0,5))
		Assert.assertEquals("Check spaces after instruction","ADCA #$25\t\t\t\t\t\t\t\t\t ;",result1.substring(4,18))
		Assert.assertEquals("Check comment","; Instruction with operand",result1.substring(17,46))

		val result2 = parseHelper.parse(test2).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Z\t\t\t A",result2.substring(0,6))
		Assert.assertEquals("Check spaces after instruction","ADCA #$25\t\t\t\t\t\t\t\t\t ;",result2.substring(5,19))
		Assert.assertEquals("Check comment","; Instruction with operand",result2.substring(18,47))

		val result3 = parseHelper.parse(test3).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","X2:\t\t A",result3.substring(0,7))
		Assert.assertEquals("Check spaces after instruction","ADCA #$25\t\t\t\t\t\t\t\t\t ;",result3.substring(6,20))
		Assert.assertEquals("Check comment","; Instruction with operand",result3.substring(19,48))

		val result4 = parseHelper.parse(test4).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","X2c:\t\t A",result4.substring(0,8))
		Assert.assertEquals("Check spaces after instruction","ADCA #$25\t\t\t\t\t\t\t\t\t ;",result4.substring(7,21))
		Assert.assertEquals("Check comment","; Instruction with operand",result4.substring(20,49))
		
		val result5 = parseHelper.parse(test5).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","X23\t\t A",result5.substring(0,7))
		Assert.assertEquals("Check spaces after instruction","ADCA #$25\t\t\t\t\t\t\t\t\t ;",result5.substring(6,20))
		Assert.assertEquals("Check comment","; Instruction with operand",result5.substring(19,48))
		
		val result6 = parseHelper.parse(test6).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Xai1\t\t A",result6.substring(0,8))
		Assert.assertEquals("Check spaces after instruction","ADCA #$25\t\t\t\t\t\t\t\t\t ;",result6.substring(7,21))
		Assert.assertEquals("Check comment","; Instruction with operand",result6.substring(20,49))
		
		val result7 = parseHelper.parse(test7).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Xai2:\t\t A",result7.substring(0,9))
		Assert.assertEquals("Check spaces after instruction","ADCA #$25\t\t\t\t\t\t\t\t\t ;",result7.substring(8,22))
		Assert.assertEquals("Check comment","; Instruction with operand",result7.substring(21,50))
		
		val result8 = parseHelper.parse(test8).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Xait3:\t A",result8.substring(0,9))
		Assert.assertEquals("Check spaces after instruction","ADCA #$25\t\t\t\t\t\t\t\t\t ;",result8.substring(8,22))
		Assert.assertEquals("Check comment","; Instruction with operand",result8.substring(21,50))
		
		val result9 = parseHelper.parse(test9).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","Xait31:\t A",result9.substring(0,10))
		Assert.assertEquals("Check spaces after instruction","ADCA #$25\t\t\t\t\t\t\t\t\t ;",result9.substring(9,23))
		Assert.assertEquals("Check comment","; Instruction with operand",result9.substring(22,51))
		
		val result10 = parseHelper.parse(test10).serialize(SaveOptions.newBuilder.format().getOptions())
		Assert.assertEquals("Check spaces before instruction","XXait312: A",result10.substring(0,11))
		Assert.assertEquals("Check spaces after instruction","ADCA #$25\t\t\t\t\t\t\t\t\t ;",result10.substring(10,24))
		Assert.assertEquals("Check comment","; Instruction with operand",result10.substring(23,52))
	}
}