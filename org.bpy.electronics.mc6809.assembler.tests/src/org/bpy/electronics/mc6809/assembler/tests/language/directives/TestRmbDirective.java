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
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.RmbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledRmbDirectiveLine;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerValidator;
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator;
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

public class TestRmbDirective {
	@Inject
	ParseHelper<Model> parseHelper;
	@Inject
	@Extension
	private ValidationTestHelper validationHelper;

	/**
	 * Check RMB directive with a simple value
	 */
	@Test
	public void testRmbWithDecimalValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("	       RMB    12 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an RMB directive line", directiveLine.getDirective() instanceof RmbDirective);

			RmbDirective rmbDirective = (RmbDirective) directiveLine.getDirective();
			Assert.assertNull("Label must be null", CommandUtil.getLabel(rmbDirective));
			Assert.assertEquals("Operand must be equals to 12", 12, ExpressionParser.parse(rmbDirective));
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check RMB directive with a simple identifier defined by an another EQU
	 */
	@Test
	public void testWithIdentifierValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; Starting assembly file\n");
		strBuilder.append("Start       EQU    $4000         ; Starting code\n");
		strBuilder.append("\n");
		strBuilder.append("; Starting code section\n");
		strBuilder.append("            ORG    Start         ; Start program at $4000\n");
		strBuilder.append("RmbLabel    RMB    Start/2       ; reserve $2000\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line0 = result.getSourceLines().get(1);
			DirectiveLine directiveLine0 = (DirectiveLine) line0.getLineContent();
			EquDirective equDirective0 = (EquDirective) directiveLine0.getDirective();
			ExpressionParser.parse(equDirective0);

			SourceLine line1 = result.getSourceLines().get(5);
			Assert.assertTrue("Must be a directive line", line1.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine1 = (DirectiveLine) line1.getLineContent();
			Assert.assertTrue("Must be an RMB directive line", directiveLine1.getDirective() instanceof RmbDirective);

			RmbDirective rmbDirective = (RmbDirective) directiveLine1.getDirective();
			Assert.assertEquals("Label must be RmbLabel", "RmbLabel", CommandUtil.getLabel(rmbDirective));
			Assert.assertEquals("Operand must be equals to $2000", 0x2000, ExpressionParser.parse(rmbDirective));
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check RMB directive with the lowest limit
	 */
	@Test
	public void testRMBWithLowestValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000   ; With value\n");
		strBuilder.append("           RMB    1 \n");
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
	 * Check RMB directive with the upper limit
	 */
	@Test
	public void testRMBWithUpperLimitValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	   ORG    $8000   ; With value\n");
		strBuilder.append("       RMB    $FFFF \n");
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
	 * Check RMB directive with the too high limit
	 */
	@Test
	public void testRMBWithToHighLimitValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000   ; With value\n");
		strBuilder.append("           RMB    $FFFF+1 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRmbDirective(), DirectiveValidator.INVALID_RANGE,
					"RMB value maximum value is $FFFF");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check RMB directive with duplicate Label
	 */
	@Test
	public void testFCBWithDuplicateLabels() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("	         ORG    $8000\n");
		strBuilder.append("Label1	     BSZ	10    \n");
		strBuilder.append("Label1       RMB    32 \n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(), AssemblerEngine.DUPLICATE_LABEL,
					"Label Label1 is already defined");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check RMB directive assembly result
	 */
	@Test
	public void testRmbAssemblyResult() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("	        	ORG    	$8000\n");
		strBuilder.append("Label1       	RMB    	32 		; 32 bytes reserved\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledRmbDirectiveLine line = (AssembledRmbDirectiveLine) engine.getAssembledLine(1);
			Assert.assertEquals("Check Label", "Label1", line.getLabel());
			Assert.assertEquals("Check Comment", "; 32 bytes reserved", line.getComment());

			Assert.assertEquals("Check Impact on PC", 0x8020, engine.getCurrentPcValue());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check RMB with error in expression
	 */
	@Test
	public void testRmbWithErrorExpression() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	RMB    	10*Deux 		; Toto vaudra $2000\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertIssue(result.eResource(), AssemblerPackage.Literals.RMB_DIRECTIVE, ExpressionParser.EXPRESSION_ERROR, 110,
					7, Severity.ERROR, "Can't find Deux definition");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check RMB with binary error syntax
	 */
	@Test
	public void testRmbWithBinaryErrorSyntax() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	RMB    	%01111211 		; Toto vaudra $2000\n");
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
	 * Check RMB with octal error syntax
	 */
	@Test
	public void testRmbWithOctalErrorSyntax() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	RMB    	@128	 		; Toto vaudra $2000\n");
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