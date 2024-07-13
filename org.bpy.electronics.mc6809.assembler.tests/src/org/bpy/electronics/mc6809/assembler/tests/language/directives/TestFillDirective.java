/*
 * MC6809 Toolkit
 * Copyright (C) 2023  Patrick BRIAND
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.bpy.electronics.mc6809.assembler.tests.language.directives;

import org.eclipse.xtext.testing.XtextRunner;
import org.junit.runner.RunWith;
import org.eclipse.xtext.testing.InjectWith;
import com.google.inject.Inject;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.junit.Test;
import org.junit.Assert;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Extension;
import org.bpy.electronics.mc6809.assembler.assembler.FillDirective;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFillDirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerValidator;
import org.eclipse.xtext.diagnostics.Severity;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class TestFillDirective {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check FILL directive with a simple values
	 */
	@Test 
	public void testFILLWithDecimalValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("	       FILL   $80,25 \n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
		SourceLine line = result.getSourceLines().get(2);
		Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
		
		DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();;
		Assert.assertTrue("Must be an FILL directive line", directiveLine.getDirective() instanceof FillDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check FILL directive with a simple identifier publicined by an another EQU
	 */
	@Test 
	public void testFILLWithIdentifierValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; Starting assembly file\n");
		strBuilder.append("Start			EQU		$8000\n");
		strBuilder.append("Val1       	EQU    	$40           ; Number \n");
		strBuilder.append("\n");
		strBuilder.append("; Strating code section\n");
		strBuilder.append("           	ORG    	Start         ; Start program at $4000\n");
		strBuilder.append("           	FILL   	Val1,10       ; Fill example\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			SourceLine line1 = result.getSourceLines().get(6);
			Assert.assertTrue("Must be a directive line", line1.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine1 = (DirectiveLine)line1.getLineContent();
			Assert.assertTrue("Must be an FILL directive line", directiveLine1.getDirective() instanceof FillDirective);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("PC value must be 800A", 0x800A, engine.getCurrentPcValue());
			AbstractAssemblyLine line = engine.getAssembledLine(6);
			AssembledFillDirectiveLine bszLine = (AssembledFillDirectiveLine)line;
			Assert.assertEquals("Check line number", 7, bszLine.getLineNumber());
			Assert.assertNull("Check label", bszLine.getLabel());
			Assert.assertEquals("Check comment", "; Fill example", bszLine.getComment());
	
			for (int value : bszLine.getValues()) {
				Assert.assertEquals("Reserved bytes must be equals to 64", 64, value);
			}
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check FILL directive with duplicate label
	 */
	@Test 
	public void testFILLWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; Starting assembly file\n");
		strBuilder.append("Start			EQU		$8000\n");
		strBuilder.append("Val1       	EQU    	$40            ; Number \n");
		strBuilder.append("\n");
		strBuilder.append("; Strating code section\n");
		strBuilder.append("           	ORG    	Start         ; Start program at $4000\n");
		strBuilder.append("Val2       	BSZ		6	\n");
		strBuilder.append("Val2       	FILL   	Val1,10       ; Fill example\n");
			
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getDirectiveLine(),
				AssemblerEngine.DUPLICATE_LABEL,
				"Label Val2 is already defined"
			);
		
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check FILL directive with Low value limit
	 */
	@Test 
	public void testFILLWithLowValueLimit() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; Starting assembly file\n");
		strBuilder.append("Val2       	FILL   	-128,10       ; Fill example\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check FILL directive with High value limit
	 */
	@Test 
	public void testFILLWithHighValueLimit() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; Starting assembly file\n");
		strBuilder.append("Val2       	FILL   	255,10       ; Fill example\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check FILL directive with Low value limit
	 */
	@Test 
	public void testFILLWithLowBadValueLimit() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; Starting assembly file\n");
		strBuilder.append("Val2       	FILL   	-129,10       ; Fill example\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.Literals.FILL_DIRECTIVE,
				DirectiveValidator.INVALID_RANGE,
				"FILL value minimum value is -128"			
			);
	} catch (Exception e) {
		Assert.assertTrue("Exception",true);
	} 
	}
	
	/**
	 * Check FILL directive with High value limit
	 */
	@Test 
	public void testFILLWithHighBadValueLimit() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; Starting assembly file\n");
		strBuilder.append("Val2       	FILL   	256,10       ; Fill example\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.Literals.FILL_DIRECTIVE,
				DirectiveValidator.INVALID_RANGE,
				"FILL maximum value to set is 255"			
			);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check FILL directive with Low occurrence limit
	 */
	@Test 
	public void testFILLWithLowOccurrenceLimit() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; Starting assembly file\n");
		strBuilder.append("Val2       	FILL   	10,1       ; Fill example\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check FILL directive with High occurrence limit
	 */
	@Test 
	public void testFILLWithHighOccurrenceLimit() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; Starting assembly file\n");
		strBuilder.append("Val2       	FILL   	127,9       ; Fill example\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check FILL directive with Low occurrence limit
	 */
	@Test 
	public void testFILLWithLowBadOccurrenceLimit() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; Starting assembly file\n");
		strBuilder.append("Val2       	FILL   	45,-1       ; Fill example\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.Literals.FILL_DIRECTIVE,
				DirectiveValidator.INVALID_RANGE,
				"FILL value occurrence can't be negative"			
			);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check FILL directive with no occurrence
	 */
	@Test 
	public void testFILLWithLowNoOccurrenceLimit() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; Starting assembly file\n");
		strBuilder.append("Val2       	FILL   	45,0       ; Fill example\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			validationHelper.assertWarning(result, AssemblerPackage.Literals.FILL_DIRECTIVE,
				DirectiveValidator.INVALID_RANGE,
				"FILL occurrence can't be null"			
			);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check FILL directive with High value limit
	 */
	@Test 
	public void testFILLWithHighBadOccurrenceLimit() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; Starting assembly file\n");
		strBuilder.append("Val2       	FILL   	255,65536       ; Fill example\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.Literals.FILL_DIRECTIVE,
				DirectiveValidator.INVALID_RANGE,
				"FILL value maximum value is $FFFF"			
			);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	
	/**
	 * Check FILL with error in expression 
	 */
	@Test 
	public void testBszWithErrorExpression() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	FILL   	10*Deux,2 		; Toto vaudra $2000\n");
		strBuilder.append("										; Et en mémoire entre $2000 et $2010, il y aura des 0\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getFillDirective(), 
					ExpressionParser.EXPRESSION_ERROR, "Can't find Deux definition");
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check FILL with binary error syntax
	 */
	@Test 
	public void testBszWithBinaryErrorSyntax() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	FILL   	%01111211,5 		; Toto vaudra $2000\n");
		strBuilder.append("										; Et en mémoire entre $2000 et $2010, il y aura des 0\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertIssue(result.eResource(),AssemblerPackage.Literals.BINARY_VALUE,
				AssemblerValidator.INVALID_FIGURE,111,8,Severity.ERROR, "2 is invalid in binary value");
	} catch (Exception e) {
		Assert.assertTrue("Exception",true);
	} 
	}

	/**
	 * Check FILL with octal error syntax
	 */
	@Test 
	public void testBszWithOctalErrorSyntax() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	FILL   	2,@128	 		; Toto vaudra $2000\n");
		strBuilder.append("										; Et en mémoire entre $2000 et $2010, il y aura des 0\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertIssue(result.eResource(),AssemblerPackage.Literals.OCTAL_VALUE,
					AssemblerValidator.INVALID_FIGURE,113,3,Severity.ERROR, "8 is invalid in octal value");
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
}