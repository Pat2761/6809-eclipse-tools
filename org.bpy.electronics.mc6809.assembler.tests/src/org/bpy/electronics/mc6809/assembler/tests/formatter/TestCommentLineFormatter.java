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
		setTabSize(5);
		setInstructionPosition(11);
		setOperandPosition(26);
		setCommentPosition(56);
		String test = "		; test";
		try {
			String result = serializer.serialize(parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions());
			char value = result.charAt(55);
			Assert.assertEquals("; must be at 56", ';', value);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	@Test
	public void  testFormatterTabOnly01() {
		setTabPolicy(PreferenceManager.TAB_ONLY);
		setTabSize(5);
		setInstructionPosition(11);
		setOperandPosition(26);
		setCommentPosition(56);
		String test = "		; test";
		try {
			String result = serializer.serialize(parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions());
			char value = result.charAt(55);
			Assert.assertEquals("; must be at 11", ';', value);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	@Test
	public void  testFormatterMixed01() {
		setTabPolicy(PreferenceManager.MIXED);
		setTabSize(5);
		setInstructionPosition(15);
		setOperandPosition(27);
		setCommentPosition(58);
		String test = "		; test";
		try {
			String result = serializer.serialize(parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions());
			char value = result.charAt(13);
			Assert.assertEquals("; must be at 11", ';', value);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}
}