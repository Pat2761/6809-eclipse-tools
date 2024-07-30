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
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.FdbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFdbDirectiveLine;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
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

public class TestFdbDirective {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check FDB directive with a simple value
	 */
	@Test 
	public void testFdbWithDecimalValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("	       FDB    1234 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an FDB directive line", directiveLine.getDirective() instanceof FdbDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check FDB directive with two values
	 */
	@Test 
	public void testFDBWithTwoValues() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("	       FDB    $FF,125+4000 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an FDB directive line", directiveLine.getDirective() instanceof FdbDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check FDB directive with three values
	 */
	@Test 
	public void testFdbWithThreeValues() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("	       FDB    1,0,3 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an FDB directive line", directiveLine.getDirective() instanceof FdbDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check FDB directive with three values
	 */
	@Test 
	public void testFdbWithThreeValuesWithComment() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("	       FDB    1,0,3      ; Set 1,0,3\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an FDB directive line", directiveLine.getDirective() instanceof FdbDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check FDB directive with three values
	 */
	@Test 
	public void testRmbWithThreeValuesWithCommentAndLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("FcbL       FDB    1,0,3      ; Set 1,0,3\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an FDB directive line", directiveLine.getDirective() instanceof FdbDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check FDB directive with three values
	 */
	@Test 
	public void testFdbWithThreeValuesWithLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("FcbL       FDB    1,0,3      \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an FDB directive line", directiveLine.getDirective() instanceof FdbDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check FDB directive with a bad negative value
	 */
	@Test 
	public void testFDBWithBadNegativeValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("	         ORG    $8000\n");
		strBuilder.append("Label1       FDB    10,0,-32769,40 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getFdbDirective(),DirectiveValidator.INVALID_RANGE,
					"FDB value can't lower than -32768 at location 3");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check FDB directive with a limit negative value
	 */
	@Test 
	public void testFCBWithLimitNegativeValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("	         ORG    $8000\n");
		strBuilder.append("Label1       FDB    10,-32768,128,40 \n");

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
	 * Check FDB directive with a bad positive value
	 */
	@Test 
	public void testFDBWithBadPositiveValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("	         ORG    $8000\n");
		strBuilder.append("Label1       FDB    65536,0,128,40 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getFdbDirective(),
					DirectiveValidator.INVALID_RANGE,"FDB value maximum value is 65535 at location 1");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check FDB directive with a limit positive value
	 */
	@Test 
	public void testFDBWithLimitPositiveValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("	         ORG    $8000\n");
		strBuilder.append("Label1       FDB    10,127,128,65535 \n");

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
	 * Check FDB directive with duplicate Label
	 */
	@Test 
	public void testFCBWithDuplicateLabels() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("	         ORG    $8000\n");
		strBuilder.append("Label1	     BSZ	10    \n");
		strBuilder.append("Label1       FDB    10 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getDirectiveLine(),
				InstructionValidator.DUPLICATE_LABEL,"Label Label1 is already defined");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check FDB directive with duplicate Label
	 */
	@Test 
	public void testFDBAssemblyResult() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("	        	ORG    	$8000\n");
		strBuilder.append("EquVal			EQU		15         \n");
		strBuilder.append("Label1			BSZ		10    \n");
		strBuilder.append("Label2			FDB    	10,,'A,EquVal*2,$2500 		; a comment\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledFdbDirectiveLine line = (AssembledFdbDirectiveLine) engine.getAssembledLine(3);
			Assert.assertEquals("Check Label","Label2",line.getLabel());
			Assert.assertEquals("Check Comment","; a comment",line.getComment());
	
			Assert.assertEquals("Check value 0",10,line.getValues()[0]);
			Assert.assertEquals("Check value 1",0,line.getValues()[1]);
			Assert.assertEquals("Check value 2",65,line.getValues()[2]);
			Assert.assertEquals("Check value 3",30,line.getValues()[3]);
			Assert.assertEquals("Check value 4",0x2500,line.getValues()[4]);
	
			Assert.assertEquals("Check Impact on PC",0x8014,engine.getCurrentPcValue());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check FDB with error in expression 
	 */
	@Test 
	public void testFdbWithErrorExpression() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	FDB    	10*Deux 		; Toto vaudra $2000\n");
		strBuilder.append("										; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getFdbDirective(), 
					InstructionValidator.EXPRESSION_ERROR, "Can't find Deux definition");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check FDB with binary error syntax
	 */
	@Test 
	public void testFdbWithBinaryErrorSyntax() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	FDB    	%01111211 		; Toto vaudra $2000\n");
		strBuilder.append("										; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertIssue(result.eResource(),AssemblerPackage.eINSTANCE.getBinaryValue(),
					AssemblerValidator.INVALID_FIGURE,111,8,Severity.ERROR, "2 is invalid in binary value");
	} catch (Exception e) {
		Assert.assertTrue("Exception detected", true);
	}
	}

	/**
	 * Check FDB with octal error syntax
	 */
	@Test 
	public void testFdbWithOctalErrorSyntax() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	FDB    	@128	 		; Toto vaudra $2000\n");
		strBuilder.append("										; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertIssue(result.eResource(),AssemblerPackage.eINSTANCE.getOctalValue(),
					AssemblerValidator.INVALID_FIGURE,111,3,Severity.ERROR, "8 is invalid in octal value");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
}