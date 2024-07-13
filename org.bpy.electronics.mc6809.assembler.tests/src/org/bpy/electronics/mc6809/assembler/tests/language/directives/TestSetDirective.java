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
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Extension;
import org.bpy.electronics.mc6809.assembler.assembler.SetDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerValidator;
import org.eclipse.xtext.diagnostics.Severity;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class TestSetDirective {
	@Inject
	ParseHelper<Model> parseHelper;
	@Inject
	@Extension
	private ValidationTestHelper validationHelper;

	/**
	 * Check SET directive with a simple value
	 */
	@Test
	public void testSETWithDecimalValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	         ORG    $8000\n");
		strBuilder.append("SetValue   SET    5 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an SET directive line", directiveLine.getDirective() instanceof SetDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check SET directive with a identifier and expression
	 */
	@Test
	public void testSETWithIdentifierValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("SetValue   SET    5 \n");
		strBuilder.append("SetValue   SET    SetValue*2 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an SET directive line", directiveLine.getDirective() instanceof SetDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check SET directive with a identifier and relative to PC
	 */
	@Test
	public void testSETWithIdentifierValueRelativeToPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("SetValue   SET    5 \n");
		strBuilder.append("SetValue   SET    *+2 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an SET directive line", directiveLine.getDirective() instanceof SetDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check SET directive relative to PC
	 */
	@Test
	public void testSETRelativeToPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("SetValue   SET    * \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an SET directive line", directiveLine.getDirective() instanceof SetDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check SET directive with a value which is upper to 65535
	 */
	@Test
	public void testWithHighestLimit() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       SET    65535 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check SET directive with a value which is upper to 65535
	 */
	@Test
	public void testWithTooHighValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       SET    65536 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getSetDirective(), DirectiveValidator.INVALID_RANGE,
					"SET value can't exceed 65535 (16 bits value)");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check SET directive with a value which is lower than -32768
	 */
	@Test
	public void testWithTooLowValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       SET    -32769 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getSetDirective(), DirectiveValidator.INVALID_RANGE,
					"SET value can't be lower than -32768 (16 bits value)");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check SET directive with a value which is lower than -32768
	 */
	@Test
	public void testWithLowestNegativeValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       SET    -32768 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check SET directive with a missing label
	 */
	@Test
	public void testWithMissingLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test SET without label\n");
		strBuilder.append(" 	    SET    100 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(), DirectiveValidator.MISSING_LABEL,
					"No label defined for SET directive");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check SET directive after an EQU directive with same label
	 */
	@Test
	public void testWithEQUWthSameLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test  SET \n");
		strBuilder.append("MySET			 EQU 	200\n");
		strBuilder.append("MySET 	   		 SET    100 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(), AssemblerEngine.DUPLICATE_LABEL,
					"The label MySET for an SET directive is already defined");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check SET directive after an SET directive with same label
	 */
	@Test
	public void testWithSETWthSameLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test  SET \n");
		strBuilder.append("MySET			 SET 	200\n");
		strBuilder.append("MySET 	   		 SET    100 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check SET directive with missing label in expression
	 */
	@Test
	public void testWithSETWthMissingLabelInExpression() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test  SET \n");
		strBuilder.append("MySET 	   		 SET    100*Deux \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getSetDirective(), ExpressionParser.EXPRESSION_ERROR,
					"Can't find Deux definition");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check SET directive with modulo division by 0
	 */
	@Test
	public void testWithSETWithModuloDivisionByZero() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test  SET \n");
		strBuilder.append("MySET 	   		 SET    100%0 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getSetDirective(), ExpressionParser.EXPRESSION_ERROR,
					"Division by 0 is not allow, the result of the expression will be false");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check SET directive with modulo division by 0
	 */
	@Test
	public void testWithSETWithDivisionByZero() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test  SET \n");
		strBuilder.append("MySET 	   		 SET    100/0 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getSetDirective(), ExpressionParser.EXPRESSION_ERROR,
					"Division by 0 is not allow, the result of the expression will be false");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check SET with error in expression
	 */
	@Test
	public void testSetWithErrorExpression() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	SET    	10*Deux 		; Toto vaudra $2000\n");
		strBuilder.append("										; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getSetDirective(), ExpressionParser.EXPRESSION_ERROR,
					"Can't find Deux definition");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check SET with binary error syntax
	 */
	@Test
	public void testSetWithBinaryErrorSyntax() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	SET    	%01111211 		; Toto vaudra $2000\n");
		strBuilder.append("										; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertIssue(result.eResource(), AssemblerPackage.Literals.BINARY_VALUE, AssemblerValidator.INVALID_FIGURE, 111, 8,
					Severity.ERROR, "2 is invalid in binary value");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check SET with octal error syntax
	 */
	@Test
	public void testSetWithOctalErrorSyntax() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	SET    	@128	 		; Toto vaudra $2000\n");
		strBuilder.append("										; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertIssue(result.eResource(), AssemblerPackage.Literals.OCTAL_VALUE, AssemblerValidator.INVALID_FIGURE, 111, 3,
					Severity.ERROR, "8 is invalid in octal value");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}
}
