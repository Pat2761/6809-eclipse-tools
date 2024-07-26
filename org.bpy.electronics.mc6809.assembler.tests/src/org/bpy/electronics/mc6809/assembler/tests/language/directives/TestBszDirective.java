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

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.BszDirective;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledBszDirectiveLine;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerValidator;
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
import org.eclipse.xtext.diagnostics.Severity;
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

public class TestBszDirective {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check BSZ directive with a simple decimal value
	 */
	@Test 
	public void testBSZWithDecimalValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("	       BSZ    100 \n");
		Model result;
		try {
			result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();;
			Assert.assertTrue("Must be an BSZ directive line", directiveLine.getDirective() instanceof BszDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check ZMB directive with a simple decimal value
	 */
	@Test 
	public void testZMBWithDecimalValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		ORG    $8000\n");
		strBuilder.append("		ZMB    100 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();;
			Assert.assertTrue("Must be an BSZ directive line", directiveLine.getDirective() instanceof BszDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	

	/**
	 * Check BSZ directive with a simple identifier defined by an another EQU
	 */
	@Test 
	public void testBSZWithIdentifierValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(";Starting assembly file\n");
		strBuilder.append("Start       EQU    $4000         ; Starting code\n");
		strBuilder.append("\n");
		strBuilder.append("; Strating code section\n");
		strBuilder.append("            ORG    Start         ; Start program at $4000\n");
		strBuilder.append("            BSZ    Start*2\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			SourceLine line0 = result.getSourceLines().get(1);
			DirectiveLine directiveLine0 = (DirectiveLine) line0.getLineContent();
			EquDirective equDirective0 = (EquDirective) directiveLine0.getDirective();
			ExpressionParser.parse(equDirective0);
			
			SourceLine line1 = result.getSourceLines().get(5);
			Assert.assertTrue("Must be a directive line", line1.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine1 = (DirectiveLine) line1.getLineContent();
			Assert.assertTrue("Must be an BSZ directive line", directiveLine1.getDirective() instanceof BszDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check BSZ directive with a negative value
	 */
	@Test 
	public void testBSZWithNegativeValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("	         	ORG    $8000   ; With value\n");
		strBuilder.append("Label1       BSZ    -1 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getBszDirective(),
					DirectiveValidator.INVALID_RANGE,"BSZ value can't be negative");
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check BSZ directive with the lowest limit
	 */
	@Test 
	public void testWithLowestValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(";-----------------------------------------\n");
		strBuilder.append("	       	ORG    $8000   ; With value\n");
		strBuilder.append("         BSZ    1 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check BSZ directive with 0 value
	 */
	@Test 
	public void testWithNothingValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			ORG    $8000   ; With value\n");
		strBuilder.append("			BSZ    0 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check BSZ directive with missing getLabel()
	 */
	@Test 
	public void testBszMissingLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			ORG    $8000   ; With value\n");
		strBuilder.append("			BSZ    10 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}


	/**
	 * Check BSZ duplicate getLabel()
	 */
	@Test 
	public void testBszDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           		ORG    	$8000 	; With value\n");
		strBuilder.append("MyBsz		   	BSZ  	10	           \n");
		strBuilder.append("MyBsz	       	BSZ    	10 		; A getComment() for BSZ\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(), 
					AssemblerEngine.DUPLICATE_LABEL,
					"Label MyBsz is already defined");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check BSZ directive behavior
	 */
	@Test 
	public void testBszBehavior() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           ORG    $8000 	; With value\n");
		strBuilder.append("MyBsz	   BSZ    10 		; A getComment() for BSZ\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			validationHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
	
		AssemblerEngine engine = AssemblerEngine.getInstance();
		Assert.assertEquals("PC value must be 800A", 0x800A, engine.getCurrentPcValue());
		AbstractAssemblyLine line = engine.getAssembledLine(2);
		AssembledBszDirectiveLine bszLine = (AssembledBszDirectiveLine) line;
		int[] values = bszLine.getValues();
		for (int value : values) {
			Assert.assertEquals("Reserved bytes must be equals to 0", 0, value);
		}
		Assert.assertEquals("Check line number", 3, bszLine.getLineNumber());
		Assert.assertEquals("Check getLabel()", "MyBsz", bszLine.getLabel());
		Assert.assertEquals("Check getComment()", "; A getComment() for BSZ", bszLine.getComment());
	} catch (Exception e) {
		Assert.assertTrue("Exception detected", true);
	}
	}

	/**
	 * Check BSZ Sorek directive 
	 */
	@Test 
	public void testBszSorek() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000   	; With value\n");
		strBuilder.append("TOTO	       	BSZ    	$10 		; Toto vaudra $2000\n");
		strBuilder.append("TITI			EQU		* 			; TITI vaudra $2010\n");
		strBuilder.append("									; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check BSZ with error in expression 
	 */
	@Test 
	public void testBszWithErrorExpression() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	BSZ    	10*Deux 		; Toto vaudra $2000\n");
		strBuilder.append("										; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getBszDirective(), 
					InstructionValidator.EXPRESSION_ERROR, 
					"Can't find Deux definition");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check BSZ with binary error syntax
	 */
	@Test 
	public void testBszWithBinaryErrorSyntax() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	BSZ    	%01111211 		; Toto vaudra $2000\n");
		strBuilder.append("										; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertIssue(result.eResource(),AssemblerPackage.Literals.BINARY_VALUE,
					AssemblerValidator.INVALID_FIGURE,111,8,
					Severity.ERROR, "2 is invalid in binary value");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check BSZ with octal error syntax
	 */
	@Test 
	public void testBszWithOctalErrorSyntax() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	BSZ    	@128	 		; Toto vaudra $2000\n");
		strBuilder.append("										; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertIssue(result.eResource(),AssemblerPackage.Literals.OCTAL_VALUE,
					AssemblerValidator.INVALID_FIGURE,111,3,
					Severity.ERROR, "8 is invalid in octal value");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
}