package org.bpy.electronics.mc6809.assembler.tests.language;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerValidator;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class CheckNumberValidation {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;

	@Test 
	public void testBinary1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(";******************************************************\n");
		strBuilder.append("Test		EQU 	%01100011		; Conform	\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}	

	@Test 
	public void testBinary2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(";******************************************************\n");
		strBuilder.append("Test		EQU 	%01200011		; Not Conform	\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getBinaryValue(), 
			AssemblerValidator.INVALID_FIGURE,"2 is invalid in binary value");
			
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}	

	@Test 
	public void testBinary3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(";******************************************************\n");
		strBuilder.append("Test		EQU 	%51100011		; Not Conform	\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getBinaryValue(), 
				AssemblerValidator.INVALID_FIGURE,
				"5 is invalid in binary value");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}	

	@Test 
	public void testBinary4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(";******************************************************\n");
		strBuilder.append("Test		EQU 	%11100016		; Not Conform	\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getBinaryValue(), 
				AssemblerValidator.INVALID_FIGURE,
				"6 is invalid in binary value");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}	

	@Test 
	public void testOctal1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(";******************************************************\n");
		strBuilder.append("Test		EQU 	@0123		; Conform	\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}	

	@Test 
	public void testOctal2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(";******************************************************\n");
		strBuilder.append("Test		EQU 	@4567		; Conform	\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}	

	@Test 
	public void testOctal3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(";******************************************************\n");
		strBuilder.append("Test		EQU 	@8123		; Not Conform	\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getOctalValue(), 
				AssemblerValidator.INVALID_FIGURE,
				"8 is invalid in octal value");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}	

	@Test 
	public void testOctal4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(";******************************************************\n");
		strBuilder.append("Test		EQU 	@4569		; Not Conform	\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getOctalValue(), 
				AssemblerValidator.INVALID_FIGURE,
				"9 is invalid in octal value");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}	
}