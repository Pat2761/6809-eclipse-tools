package org.bpy.electronics.mc6809.assembler.tests.formatter;

import com.google.inject.Inject;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Extension;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.eclipse.xtext.resource.SaveOptions;
import org.junit.Assert;
import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class TestCommentLineFormatter extends AbstractTestFormatter {
	 
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ISerializer serializer;
	
	@Test
	public void  testFormatterSpaceOnly01() {
		setTabPolicy(PreferenceManager.SPACE_ONLY);
		setTabSize(3);
		setInstructionPosition(25);
		setOperandPosition(35);
		setCommentPosition(54);
		setCommentLineAtInstructionLevel(false);
		String test = "		; test\n";
		try {
			String result = serializer.serialize(parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions());
			char value = result.charAt(54);
			Assert.assertEquals("; must be at 54", ';', value);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	@Test
	public void  testFormatterSpaceOnly02() {
		setTabPolicy(PreferenceManager.SPACE_ONLY);
		setTabSize(3);
		setInstructionPosition(25);
		setOperandPosition(35);
		setCommentPosition(54);
		setCommentLineAtInstructionLevel(true);
		String test = "		; test\n";
		try {
			String result = serializer.serialize(parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions());
			char value = result.charAt(25);
			Assert.assertEquals("; must be at 25", ';', value);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	@Test
	public void  testFormatterTabOnly01() {
		setTabPolicy(PreferenceManager.TAB_ONLY);
		setTabSize(3);
		setInstructionPosition(25);
		setOperandPosition(37);
		setCommentPosition(55);
		setCommentLineAtInstructionLevel(false);
		String test = "		; test\n";
		try {
			String result = serializer.serialize(parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions());
			char value = result.charAt(19);
			Assert.assertEquals("; must be at 19", ';', value);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	@Test
	public void  testFormatterTabOnly02() {
		setTabPolicy(PreferenceManager.TAB_ONLY);
		setTabSize(3);
		setInstructionPosition(25);
		setOperandPosition(37);
		setCommentPosition(55);
		setCommentLineAtInstructionLevel(true);
		String test = "		; test\n";
		try {
			String result = serializer.serialize(parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions());
			char value = result.charAt(9);
			Assert.assertEquals("; must be at 9", ';', value);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}
	
	@Test
	public void  testFormatterMixed01() {
		setTabPolicy(PreferenceManager.MIXED);
		setTabSize(3);
		setInstructionPosition(24);
		setOperandPosition(32);
		setCommentPosition(54);
		setCommentLineAtInstructionLevel(false);
		String test = "		; test\n";
		try {
			String result = serializer.serialize(parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions());
			char value = result.charAt(20);
			Assert.assertEquals("; must be at 20", ';', value);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	@Test
	public void  testFormatterMixed02() {
		setTabPolicy(PreferenceManager.MIXED);
		setTabSize(3);
		setInstructionPosition(24);
		setOperandPosition(32);
		setCommentPosition(54);
		setCommentLineAtInstructionLevel(true);
		String test = "		; test\n";
		try {
			String result = serializer.serialize(parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions());
			char value = result.charAt(10);
			Assert.assertEquals("; must be at 10", ';', value);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}
}