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
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledOrgDirectiveLine;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
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

public class TestOrgDirective {
	@Inject
	ParseHelper<Model> parseHelper;
	@Inject
	@Extension
	private ValidationTestHelper validationHelper;

	/**
	 * Check ORG directive with a simple decimal value
	 */
	@Test
	public void testOrgWithHexaDecimalValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(1);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an ORG directive line", directiveLine.getDirective() instanceof OrgDirective);

			OrgDirective orgDirective = (OrgDirective) directiveLine.getDirective();
			Assert.assertNull("Label must be null", CommandUtil.getLabel(orgDirective));
			Assert.assertEquals("Operand must be equals to 8000", 0x8000, ExpressionParser.parse(orgDirective));
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ORG directive with no value , return 0
	 */
	@Test
	public void testOrgWithNoValueValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    ; Without value \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(1);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an ORG directive line", directiveLine.getDirective() instanceof OrgDirective);

			OrgDirective orgDirective = (OrgDirective)directiveLine.getDirective();
		 	Assert.assertNull("Label must be null", CommandUtil.getLabel(orgDirective));	
			Assert.assertEquals("Operand must be equals to 0", 0, ExpressionParser.parse(orgDirective));		
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ORG directive with a simple identifier defined by an anothoer EQU
	 */
	@Test
	public void testOrgWithIdentifierValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; Starting assembly file\n");
		strBuilder.append("Start       EQU    $4000         ; Starting code\n");
		strBuilder.append("\n");
		strBuilder.append("; Strating code section\n");
		strBuilder.append("            ORG    Start         ; Start program at $4000\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line0 = result.getSourceLines().get(1);
			DirectiveLine directiveLine0 = (DirectiveLine) line0.getLineContent();
			EquDirective equDirective0 = (EquDirective) directiveLine0.getDirective();
			ExpressionParser.parse(equDirective0);

			SourceLine line1 = result.getSourceLines().get(4);
			Assert.assertTrue("Must be a directive line", line1.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine1 = (DirectiveLine) line1.getLineContent();
			Assert.assertTrue("Must be an ORG directive line", directiveLine1.getDirective() instanceof OrgDirective);

			OrgDirective orgDirective = (OrgDirective) directiveLine1.getDirective();
			Assert.assertNull("Label must be null", CommandUtil.getLabel(orgDirective));
			Assert.assertEquals("Operand must be equals to $4000", 0x4000, ExpressionParser.parse(orgDirective));
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ORG directive with a simple identifier defined by an anothoer EQU
	 */
	@Test
	public void testWithComplexeValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; Starting assembly file\n");
		strBuilder.append("Start       EQU    $4000         ; Starting code\n");
		strBuilder.append("\n");
		strBuilder.append("; Strating code section\n");
		strBuilder.append("            ORG    (Start*2)+32         ; Start program at $4000\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line0 = result.getSourceLines().get(1);
			DirectiveLine directiveLine0 = (DirectiveLine) line0.getLineContent();
			EquDirective equDirective0 = (EquDirective) directiveLine0.getDirective();
			ExpressionParser.parse(equDirective0);

			SourceLine line1 = result.getSourceLines().get(4);
			Assert.assertTrue("Must be a directive line", line1.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine1 = (DirectiveLine) line1.getLineContent();
			Assert.assertTrue("Must be an ORG directive line", directiveLine1.getDirective() instanceof OrgDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ORG directive with a relative to PC value
	 */
	@Test
	public void testORGWithRelativeValueToPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; Strating code section\n");
		strBuilder.append("            ORG    *+100         ; Start program at $4000\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line1 = result.getSourceLines().get(1);
			Assert.assertTrue("Must be a directive line", line1.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine1 = (DirectiveLine) line1.getLineContent();
			Assert.assertTrue("Must be an ORG directive line", directiveLine1.getDirective() instanceof OrgDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ORG directive with a negative value
	 */
	@Test
	public void testWithNegativeValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("Label1       ORG    -1 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getOrgDirective(), DirectiveValidator.INVALID_RANGE,
					"ORG value can't be negative");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ORG directive with the lowest limit
	 */
	@Test
	public void testWithLowestValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("        ORG    0 \n");

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
	 * Check ORG directive with the upper limit
	 */
	@Test
	public void testWithUpperLimitValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("       ORG    $FFFF \n");

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
	 * Check ORG directive with the too high limit
	 */
	@Test
	public void testWithToHighLimitValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("       ORG    $FFFF+1 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getOrgDirective(), DirectiveValidator.INVALID_RANGE,
					"ORG value maximum value is $FFFF");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check Sorek ORG directive
	 */
	@Test
	public void testSorekOrg1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("       ORG    $0400 		; opérande du type constante\n");

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
	 * Check Sorek ORG directive
	 */
	@Test
	public void testSorekOrg2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("RESET	EQU			$4000		; Reset\n");
		strBuilder.append("\n");
		strBuilder.append("        ORG         RESET       ; opérande du type symbole\n");

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
	 * Check Sorek ORG directive
	 */
	@Test
	public void testSorekOrg3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("        ORG         *+100       ; opérande du type expression\n");

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
	 * Check Sorek ORG directive
	 */
	@Test
	public void testSorekOrg4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("SBR1			EQU			100	\n");
		strBuilder.append("LGTAB			EQU			200\n");
		strBuilder.append("\n");
		strBuilder.append("	      		ORG         SBR1+LGTAB*8       ; opérande du type expression\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	@Test
	public void checkNoValueResult() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    ; Without value \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine assemblerEngine = AssemblerEngine.getInstance();

			AbstractAssemblyLine assemblyLine = assemblerEngine.getAssembledLine(1);
			Assert.assertTrue("assemblyLine must be an Assembly line", assemblyLine instanceof AssembledOrgDirectiveLine);
			AssembledOrgDirectiveLine orgDirective = (AssembledOrgDirectiveLine) assemblyLine;

			Assert.assertEquals("PC must be set to 0", 0, orgDirective.getPcAddress());
			Assert.assertEquals("Line number must be 2", 2, orgDirective.getLineNumber());

			Assert.assertEquals("Check current PC position", 0, assemblerEngine.getCurrentPcValue());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	@Test
	public void checkWithValueResult() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    	$8000			; Without value \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine assemblerEngine = AssemblerEngine.getInstance();

			AbstractAssemblyLine assemblyLine = assemblerEngine.getAssembledLine(1);
			Assert.assertTrue("assemblyLine must be an Assembly line", assemblyLine instanceof AssembledOrgDirectiveLine);
			AssembledOrgDirectiveLine orgDirective = (AssembledOrgDirectiveLine) assemblyLine;

			Assert.assertEquals("PC must be set to 8000", 0x8000, orgDirective.getPcAddress());
			Assert.assertEquals("Line number must be 2", 2, orgDirective.getLineNumber());

			Assert.assertEquals("Check current PC position", 0x8000, assemblerEngine.getCurrentPcValue());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	@Test
	public void checkDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("OrgPos	       ORG    				; Without value \n");
		strBuilder.append("OrgPos	       ORG    $8000			; With value \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(), InstructionValidator.DUPLICATE_LABEL,
					"Label OrgPos is already defined");

			AssemblerEngine assemblerEngine = AssemblerEngine.getInstance();
			AbstractAssemblyLine assemblyLine = assemblerEngine.getAssembledLine(2);
			Assert.assertTrue("assemblyLine must be an Assembly line", assemblyLine instanceof AssembledOrgDirectiveLine);
			AssembledOrgDirectiveLine orgDirective = (AssembledOrgDirectiveLine) assemblyLine;

			Assert.assertEquals("PC must be set to 8000", 0x8000, orgDirective.getPcAddress());
			Assert.assertEquals("Line number must be 3", 3, orgDirective.getLineNumber());
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ORG with error in expression
	 */
	@Test
	public void testOrgWithErrorExpression() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	ORG    	10*Deux 		; Toto vaudra $2000\n");
		strBuilder.append("										; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getOrgDirective(), InstructionValidator.EXPRESSION_ERROR,
					"Can't find Deux definition");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ORG with binary error syntax
	 */
	@Test
	public void testOrgWithBinaryErrorSyntax() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	ORG    	%01111211 		; Toto vaudra $2000\n");
		strBuilder.append("										; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertIssue(result.eResource(), AssemblerPackage.Literals.BINARY_VALUE, 
					AssemblerValidator.INVALID_FIGURE, 111, 8,
					Severity.ERROR, "2 is invalid in binary value");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	/**
	 * Check ORG with octal error syntax
	 */
	@Test
	public void testOrgWithOctalErrorSyntax() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("TOTO	       	ORG    	@128	 		; Toto vaudra $2000\n");
		strBuilder.append("										; Et en mémoire entre $2000 et $2010, il y aura des 0\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertIssue(result.eResource(), AssemblerPackage.Literals.OCTAL_VALUE, 
					AssemblerValidator.INVALID_FIGURE, 67, 3,
					Severity.ERROR, "8 is invalid in octal value");
		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

}