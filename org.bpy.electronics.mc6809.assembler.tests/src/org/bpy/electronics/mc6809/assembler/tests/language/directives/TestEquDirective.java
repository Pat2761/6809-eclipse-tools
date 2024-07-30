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
import org.junit.Test;
import org.junit.Assert;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.EquSetManager;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerValidator;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.xbase.lib.Extension;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;


@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class TestEquDirective {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check EQU directive with a simple decimal value
	 */
	@Test 
	public void testWithDecimalValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    1234 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

		
			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line;
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check EQU directive with a simple negative decimal value
	 */
	@Test 
	public void testWithNegativeDecimalValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    -25 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

		
			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	@Test
	/**
	 * Check EQU directive with an addition of two decimal values 
	 */
	public void testWithAdditionOfTwoDecimalValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    12+24		 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	@Test
	/**
	 * Check EQU directive with an addition of three decimal values
	 */
	public void testWithAdditionOfThreeDecimalValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    12+24+5		 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	@Test
	/**
	 * Check EQU directive with an addition of two decimal values and a multiplication
	 * check the parenthesis priority
	 */
	public void testWithAdditionOfTwoDecimalValueAndMultiplication() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    (12+24)*5		 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	@Test
	/**
	 * Check EQU directive with an hexadecimal value
	 */
	public void testWithHexadecimalvalue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    $FF00		 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	@Test
	/**
	 * Check EQU directive with the addition of two hexadecimal values
	 */
	public void testWithAdditionHexadecimalvalue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    $A7+$25		 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check EQU directive with an addition of a decimal values and a hexadecimal value
	 */
	@Test
	public void testWithMultiplicationHexadecimalvalue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    125*$A		 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check EQU directive with a binary value
	 */
	@Test 
	public void testWithABinaryValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU   %10010011		 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check EQU directive with a simple octal value
	 */
	@Test 
	public void testWithOctalValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    @1234 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check EQU directive with a simple identifier defined by an another EQU
	 */
	@Test 
	public void testWithIdentifierValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Five       EQU    5         ; Five = 5\n");
		strBuilder.append("Result     EQU    Five*2    ; so 10\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line0 = result.getSourceLines().get(0);
			DirectiveLine directiveLine0 = (DirectiveLine)line0.getLineContent();
			EquDirective equDirective0 = (EquDirective)directiveLine0.getDirective();
			ExpressionParser.parse(equDirective0);
			
			SourceLine line1 = result.getSourceLines().get(1);
			Assert.assertTrue("Must be a directive line", line1.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine1 = (DirectiveLine)line1.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine1.getDirective() instanceof EquDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check EQU directive with a simple octal value
	 */
	@Test 
	public void testWithCharacterValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    'A \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check EQU directive with a relative value to PC
	 */
	@Test 
	public void testEQURelativeToPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("             ORG    $2000\n");
		strBuilder.append("Label1       EQU    * \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(1);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}


	/**
	 * Check EQU directive with a relative value to PC with expression
	 */
	@Test 
	public void testEQURelativeToPCWithEpxression() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("             ORG    $2000\n");
		strBuilder.append("Label1       EQU    *-3 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(1);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	@Test
	public void testEQUWithSamples() { 
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    65535 \n");

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
	 * Check EQU directive with a value which is upper to 65535
	 */
	@Test 
	public void testWithTooHighValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    65536 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getEquDirective(),
				DirectiveValidator.INVALID_RANGE,"EQU value can't exceed 65535 (16 bits value)");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check EQU directive with a value which is lower than -32768
	 */
	@Test 
	public void testWithTooLowValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    -32769 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getEquDirective(),
				DirectiveValidator.INVALID_RANGE,"EQU value can't be lower than -32768 (16 bits value)");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check EQU directive with a value which is lower than -32768
	 */
	@Test 
	public void testWithLowestNegativeValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    -32768 \n");

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
	 * Check EQU directive with a missing label
	 */
	@Test 
	public void testWithMissingLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test EQU without label\n");
		strBuilder.append(" 	    EQU    100 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(),
				DirectiveValidator.MISSING_LABEL,"No label defined for EQU directive");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check EQU directive with a duplicate label
	 */
	@Test 
	public void testWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test EQU with duplicate label\n");
		strBuilder.append("EquLabel 	      EQU    	100 \n");
		strBuilder.append("EquLabel			EQU		200\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(),
				InstructionValidator.DUPLICATE_LABEL,"The label EquLabel for an EQU directive is already defined");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check EQU directive with a duplicate label defined by a SET directive
	 */
	@Test 
	public void testWithSETDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test EQU reused label\n");
		strBuilder.append("EquLabel 	      SET    	100 \n");
		strBuilder.append("EquLabel			EQU		200\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result, AssemblerPackage.eINSTANCE.getDirectiveLine(),
				InstructionValidator.DUPLICATE_LABEL,
				"The label EquLabel for an EQU directive is already defined by a SET directive");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check EQU directive with a missing EQU definition in the expression
	 */
	@Test 
	public void testWithMissingEquLabelExpression() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test EQU missing EQU\n");
		strBuilder.append("EquLabel		EQU		Label1+200\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getEquDirective(),
				InstructionValidator.EXPRESSION_ERROR,"Can't find Label1 definition");
			
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	@Test
	/**
	 * Check EQU directive with an subtraction of two decimal values 
	 */
	public void testWithSubstractionOfTwoDecimalValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    32-15		 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
			
			EquDirective equDirective = (EquDirective)directiveLine.getDirective();
		 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective));
			Assert.assertEquals("Operand must be equals to 17", 17, ExpressionParser.parse(equDirective));		
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	@Test
	/**
	 * Check EQU directive with an modulo of two decimal values 
	 */
	public void testWithModuloOfTwoDecimalValue() {
		
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    46%5		 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
			
			EquDirective equDirective = (EquDirective)directiveLine.getDirective() ;
		 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective));	
			Assert.assertEquals("Operand must be equals to 1", 1, ExpressionParser.parse(equDirective));	
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	@Test
	/**
	 * Check EQU directive with a logical AND of two hexadecimal values 
	 */
	public void testWithLogicalAndOfTwoHexaDecimalValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    $FFFF&&$FF		 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
			
			EquDirective equDirective = (EquDirective)directiveLine.getDirective();
		 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective));	
			Assert.assertEquals("Operand must be equals to 255", 255, ExpressionParser.parse(equDirective));		
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	@Test
	/**
	 * Check EQU directive with a logical Or of two hexadecimal values 
	 */
	public void testWithLogicalOrOfTwoHexaDecimalValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    $FF00||$FF		 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
			
			EquDirective equDirective = (EquDirective)directiveLine.getDirective() ;
		 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective));	
			Assert.assertEquals("Operand must be equals to 65535", 65535, ExpressionParser.parse(equDirective));		
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	@Test
	/**
	 * Check EQU directive with a logical XOr of two hexadecimal values 
	 */
	public void testWithLogicalXOrOfTwoBinaryValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    %01010101^%00001111		 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
			
			EquDirective equDirective = (EquDirective)directiveLine.getDirective();
		 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective));	
			Assert.assertEquals("Operand must be equals to 90", 90, ExpressionParser.parse(equDirective));		
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	@Test
	/**
	 * Check EQU directive with a nagate of an hexadecimal values 
	 */
	public void testWithNegateOfHexaDecimalValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    !$AA		 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
			
			EquDirective equDirective = (EquDirective)directiveLine.getDirective();
		 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective));	
			Assert.assertEquals("Operand must be equals to 65365", 65365, ExpressionParser.parse(equDirective));		
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	@Test
	/**
	 * Check EQU directive with a left shift of a values 
	 */
	public void testWithLeftShiftValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    20<<2		 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
			
			EquDirective equDirective = (EquDirective)directiveLine.getDirective();
		 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective));	
			Assert.assertEquals("Operand must be equals to 80", 80, ExpressionParser.parse(equDirective));		
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	@Test
	/**
	 * Check EQU directive with a right shift of a values 
	 */
	public void testWithRightShiftValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       EQU    88>>2		 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(0);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an EQU directive line", directiveLine.getDirective() instanceof EquDirective);
			
			EquDirective equDirective = (EquDirective)directiveLine.getDirective();
		 	Assert.assertEquals("Label must be set to Label1", "Label1" , CommandUtil.getLabel(equDirective));	
			Assert.assertEquals("Operand must be equals to 22", 22, ExpressionParser.parse(equDirective));		
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}


	/**
	 * Check EQU with error in expression 
	 */
	@Test 
	public void testEquWithErrorExpression() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	EQU    	10*Deux 			; Toto vaudra $2000\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getEquDirective(), 
					InstructionValidator.EXPRESSION_ERROR, "Can't find Deux definition");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check EQU with binary error syntax
	 */
	@Test 
	public void testEquWithBinaryErrorSyntax() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	EQU    	%01111211 		; Toto vaudra $2000\n");
		strBuilder.append("			   									; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertIssue(result.eResource(),AssemblerPackage.eINSTANCE.getBinaryValue(),
				AssemblerValidator.INVALID_FIGURE,111,8,Severity.ERROR,
				 "2 is invalid in binary value");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check EQU with octal error syntax
	 */
	@Test 
	public void testEquWithOctalErrorSyntax() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	EQU    	@128   	 		; Toto vaudra $2000\n");
		strBuilder.append("						         				; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertIssue(result.eResource(),AssemblerPackage.eINSTANCE.getOctalValue(),
				AssemblerValidator.INVALID_FIGURE,111,3,Severity.ERROR, 
				"8 is invalid in octal value");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check EQU with label before
	 */
	@Test 
	public void testEquWithLabelBefore() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("DEUX	       	EQU    	2        	 	; 2\n");
		strBuilder.append("TEN 	       	EQU    	5*DEUX  	 		; Toto vaudra 10\n");
		strBuilder.append("						         				; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoIssues(result);
			
			Assert.assertEquals("Check DEUX", 2, EquSetManager.getInstance().getValue("DEUX").intValue());
			Assert.assertEquals("Check TEN", 10, EquSetManager.getInstance().getValue("TEN").intValue());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check EQU with label after
	 */
	@Test 
	public void testEquWithLabelAfter() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TEN 	       	EQU    	5*DEUX  	 		; Toto vaudra 10\n");
		strBuilder.append(" 	       		NOP    			  	 		\n");
		strBuilder.append("DEUX	       	EQU    	2        	 	; 2\n");
		strBuilder.append("						         				; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoIssues(result);

			Assert.assertEquals("Check DEUX", 2, EquSetManager.getInstance().getValue("DEUX").intValue());
			Assert.assertEquals("Check TEN", 10, EquSetManager.getInstance().getValue("TEN").intValue());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
}