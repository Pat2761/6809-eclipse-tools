package org.bpy.electronics.mc6809.assembler.tests.language

import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import org.bpy.electronics.mc6809.assembler.assembler.Model
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.Assert
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.validation.AssemblerValidator
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class CheckNumberValidation {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper

	@Test 
	def void testBinary1() {
		val result = parseHelper.parse('''
		;******************************************************
		Test		EQU 	%01100011		; Conform	
				''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}	

	@Test 
	def void testBinary2() {
		val result = parseHelper.parse('''
		;******************************************************
		Test		EQU 	%01200011		; Not Conform	
				''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.binaryValue, 
			AssemblerValidator::INVALID_FIGURE,
			"2 is invalid in binary value")
	}	

	@Test 
	def void testBinary3() {
		val result = parseHelper.parse('''
		;******************************************************
		Test		EQU 	%51100011		; Not Conform	
				''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.binaryValue, 
			AssemblerValidator::INVALID_FIGURE,
			"5 is invalid in binary value")
	}	

	@Test 
	def void testBinary4() {
		val result = parseHelper.parse('''
		;******************************************************
		Test		EQU 	%11100016		; Not Conform	
				''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.binaryValue, 
			AssemblerValidator::INVALID_FIGURE,
			"6 is invalid in binary value")
	}	

	@Test 
	def void testOctal1() {
		val result = parseHelper.parse('''
		;******************************************************
		Test		EQU 	@0123		; Conform	
				''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}	

	@Test 
	def void testOctal2() {
		val result = parseHelper.parse('''
		;******************************************************
		Test		EQU 	@4567		; Conform	
				''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}	

	@Test 
	def void testOctal3() {
		val result = parseHelper.parse('''
		;******************************************************
		Test		EQU 	@8123		; Not Conform	
				''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.octalValue, 
			AssemblerValidator::INVALID_FIGURE,
			"8 is invalid in octal value")
	}	

	@Test 
	def void testOctal4() {
		val result = parseHelper.parse('''
		;******************************************************
		Test		EQU 	@4569		; Not Conform	
				''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.octalValue, 
			AssemblerValidator::INVALID_FIGURE,
			"9 is invalid in octal value")
	}	
}