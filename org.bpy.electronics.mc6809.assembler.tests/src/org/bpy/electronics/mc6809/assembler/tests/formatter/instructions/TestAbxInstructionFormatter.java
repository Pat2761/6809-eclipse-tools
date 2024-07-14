package org.bpy.electronics.mc6809.assembler.tests.formatter.instructions;

import com.google.inject.Inject;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.tests.formatter.AbstractTestFormatter;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.eclipse.xtext.resource.SaveOptions;
import org.junit.Assert;
import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.eclipse.xtext.xbase.lib.Extension;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class TestAbxInstructionFormatter extends AbstractTestFormatter {
	 
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ISerializer serializer;
	
	@Test
	public void  testFormatterSpaceOnly() {
//		setTabPolicy(PreferenceManager.SPACE_ONLY);
//		setInstructionPosition(10);
//		setOperandPosition(22);
//		setCommentPosition(40);
//		setJunitPreferences();
//		
//		String test1 = " ABX ; Instruction without operand"; 
//		String test2 = "W ABX ; Instruction without operand";
//		String test3 = "W2: ABX ; Instruction without operand";
//		String test4 = "Wait1234: ABX ; Instruction without operand";
//
//		try {
//			String result1 = serializer.serialize(parseHelper.parse(test1), SaveOptions.newBuilder().format().getOptions());
//			Assert.assertEquals("Check spaces before instruction","         A",result1.substring(0,10));
//			Assert.assertEquals("Check spaces after instruction","ABX                           ;",result1.substring(9,40));
//			Assert.assertEquals("Check comment","; Instruction without operand",result1.substring(39,68));
//			
//			String result2 = serializer.serialize(parseHelper.parse(test2), SaveOptions.newBuilder().format().getOptions());
//			Assert.assertEquals("Check spaces before instruction","W        A",result2.substring(0,10));
//			Assert.assertEquals("Check spaces after instruction","ABX                           ;",result2.substring(9,40));
//			Assert.assertEquals("Check comment","; Instruction without operand",result1.substring(39,68));
//			
//			String result3 = serializer.serialize(parseHelper.parse(test3), SaveOptions.newBuilder().format().getOptions());
//			Assert.assertEquals("Check spaces before instruction","W2:      A",result3.substring(0,10));
//			Assert.assertEquals("Check spaces after instruction","ABX                           ;",result3.substring(9,40));
//			Assert.assertEquals("Check comment","; Instruction without operand",result1.substring(39,68));
//			
//			String result4 = serializer.serialize(parseHelper.parse(test4), SaveOptions.newBuilder().format().getOptions());
//			Assert.assertEquals("Check spaces before instruction","Wait1234: A",result4.substring(0,11));
//			Assert.assertEquals("Check spaces after instruction","ABX                           ;",result4.substring(10,41));
//			Assert.assertEquals("Check comment","; Instruction without operand",result4.substring(40,69));
//		} catch (Exception e) {
//			Assert.assertTrue("Exception detected", true);
//		}
	}
	
	@Test
	public void  testFormatterTabOnly() {
//		setTabPolicy(PreferenceManager.TAB_ONLY);
//		setInstructionPosition(10);
//		setOperandPosition(22);
//		setCommentPosition(40);
//		
//		String test1 = " ABX ; Instruction without operand";
//		String test2 = "Z ABX ; Instruction without operand";
//		String test3 = "X2: ABX ; Instruction without operand";
//		String test4 = "X2c:	ABX	; Instruction without operand";
//		String test5 = "X23 ABX ; Instruction without operand";
//		String test6 = "Xai1 ABX	; Instruction without operand";
//		String test7 = "Xai2: ABX ; Instruction without operand";
//		String test8 = "Xait3: ABX ; Instruction without operand";
//		String test9 = "Xait31: ABX ; Instruction without operand";
//		String test10 = "XXait312: ABX ; Instruction without operand";
//		
//		try {
//		String result1 = serializer.serialize(parseHelper.parse(test1), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","\t\t\tA",result1.substring(0,4));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result1.substring(3,16));
//		Assert.assertEquals("Check comment","; Instruction without operand",result1.substring(15,44));
//
//		String result2 = serializer.serialize(parseHelper.parse(test2), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","Z\t\t\tA",result2.substring(0,5));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result2.substring(4,17));
//		Assert.assertEquals("Check comment","; Instruction without operand",result2.substring(16,45));
//
//		String result3 = serializer.serialize(parseHelper.parse(test3), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","X2:\t\tA",result3.substring(0,6));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result3.substring(5,18));
//		Assert.assertEquals("Check comment","; Instruction without operand",result3.substring(17,46));
//
//		String result4 = serializer.serialize(parseHelper.parse(test4), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","X2c:\t\tA",result4.substring(0,7));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result4.substring(6,19));
//		Assert.assertEquals("Check comment","; Instruction without operand",result4.substring(18,47));
//		
//		String result5 = serializer.serialize(parseHelper.parse(test5), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","X23\t\tA",result5.substring(0,6));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result5.substring(5,18));
//		Assert.assertEquals("Check comment","; Instruction without operand",result5.substring(17,46));
//		
//		String result6 = serializer.serialize(parseHelper.parse(test6), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","Xai1\t\tA",result6.substring(0,7));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result6.substring(6,19));
//		Assert.assertEquals("Check comment","; Instruction without operand",result6.substring(18,47));
//		
//		String result7 = serializer.serialize(parseHelper.parse(test7), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","Xai2:\t\tA",result7.substring(0,8));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result7.substring(7,20));
//		Assert.assertEquals("Check comment","; Instruction without operand",result7.substring(19,48));
//		
//		String result8 = serializer.serialize(parseHelper.parse(test8), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","Xait3:\tA",result8.substring(0,8));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result8.substring(7,20));
//		Assert.assertEquals("Check comment","; Instruction without operand",result8.substring(19,48));
//		
//		String result9 = serializer.serialize(parseHelper.parse(test9), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","Xait31:\tA",result9.substring(0,9));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result9.substring(8,21));
//		Assert.assertEquals("Check comment","; Instruction without operand",result9.substring(20,49));
//		
//		String result10 = serializer.serialize(parseHelper.parse(test10), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","XXait312:\tA",result10.substring(0,11));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t;",result10.substring(10,23));
//		Assert.assertEquals("Check comment","; Instruction without operand",result10.substring(22,51));
//		} catch (Exception e) {
//			Assert.assertTrue("Exception detected", true);
//		}
	}

	@Test
	public void  testFormatterMixed() {
//		setTabPolicy(PreferenceManager.MIXED);
//		setInstructionPosition(11);
//		setOperandPosition(26);
//		setCommentPosition(41);
//		
//		String test1 = " ABX ; Instruction without operand";
//		String test2 = "Z ABX ; Instruction without operand";
//		String test3 = "X2: ABX ; Instruction without operand";
//		String test4 = "X2c:	ABX	; Instruction without operand";
//		String test5 = "X23 ABX ; Instruction without operand";
//		String test6 = "Xai1 ABX	; Instruction without operand";
//		String test7 = "Xai2: ABX ; Instruction without operand";
//		String test8 = "Xait3: ABX ; Instruction without operand";
//		String test9 = "Xait31: ABX ; Instruction without operand";
//		String test10 = "XXait312: ABX ; Instruction without operand";
//	try {	
//		String result1 = serializer.serialize(parseHelper.parse(test1), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","\t\t\t A",result1.substring(0,5));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result1.substring(4,18));
//		Assert.assertEquals("Check comment","; Instruction without operand",result1.substring(17,46));
//
//		String result2 = serializer.serialize(parseHelper.parse(test2), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","Z\t\t\t A",result2.substring(0,6));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result2.substring(5,19));
//		Assert.assertEquals("Check comment","; Instruction without operand",result2.substring(18,47));
//
//		String result3 = serializer.serialize(parseHelper.parse(test3), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","X2:\t\t A",result3.substring(0,7));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result3.substring(6,20));
//		Assert.assertEquals("Check comment","; Instruction without operand",result3.substring(19,48));
//
//		String result4 = serializer.serialize(parseHelper.parse(test4), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","X2c:\t\t A",result4.substring(0,8));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result4.substring(7,21));
//		Assert.assertEquals("Check comment","; Instruction without operand",result4.substring(20,49));
//		
//		String result5 = serializer.serialize(parseHelper.parse(test5), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","X23\t\t A",result5.substring(0,7));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result5.substring(6,20));
//		Assert.assertEquals("Check comment","; Instruction without operand",result5.substring(19,48));
//		
//		String result6 = serializer.serialize(parseHelper.parse(test6), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","Xai1\t\t A",result6.substring(0,8));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result6.substring(7,21));
//		Assert.assertEquals("Check comment","; Instruction without operand",result6.substring(20,49));
//		
//		String result7 = serializer.serialize(parseHelper.parse(test7), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","Xai2:\t\t A",result7.substring(0,9));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result7.substring(8,22));
//		Assert.assertEquals("Check comment","; Instruction without operand",result7.substring(21,50));
//		
//		String result8 = serializer.serialize(parseHelper.parse(test8), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","Xait3:\t A",result8.substring(0,9));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result8.substring(8,22));
//		Assert.assertEquals("Check comment","; Instruction without operand",result8.substring(21,50));
//		
//		String result9 = serializer.serialize(parseHelper.parse(test9), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","Xait31:\t A",result9.substring(0,10));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result9.substring(9,23));
//		Assert.assertEquals("Check comment","; Instruction without operand",result9.substring(22,51));
//		
//		String result10 = serializer.serialize(parseHelper.parse(test10), SaveOptions.newBuilder().format().getOptions());
//		Assert.assertEquals("Check spaces before instruction","XXait312: A",result10.substring(0,11));
//		Assert.assertEquals("Check spaces after instruction","ABX\t\t\t\t\t\t\t\t\t ;",result10.substring(10,24));
//		Assert.assertEquals("Check comment","; Instruction without operand",result10.substring(23,52));
//	} catch (Exception e) {
//		Assert.assertTrue("Exception detected", true);
//	}
	}
}