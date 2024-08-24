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
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SetDPDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerManager;
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

public class TestSetDPDirective {
	@Inject
	ParseHelper<Model> parseHelper;
	@Inject
	@Extension
	private ValidationTestHelper validationHelper;

	/**
	 * Check SETDP directive without comment
	 */
	@Test
	public void testSetDPWithoutCommentWithSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append(" 		   SETDP    \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an SETDP directive line",
					directiveLine.getDirective() instanceof SetDPDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check SETDP directive without comment
	 */
	@Test
	public void testSetDPWithoutCommentWithoutSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append(" 		   SETDP\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an SETDP directive line",
					directiveLine.getDirective() instanceof SetDPDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check SETDP directive with value
	 */
	@Test
	public void testSetDPWithValueWithoutComment() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG      $8000\n");
		strBuilder.append(" 	   SETDP    1\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an SETDP directive line",
					directiveLine.getDirective() instanceof SetDPDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check SETDP directive with value and comment
	 */
	@Test
	public void testSetDPWithValueWithComment() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG      $8000\n");
		strBuilder.append(" 	   SETDP    1        ; Page 1\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an SETDP directive line",
					directiveLine.getDirective() instanceof SetDPDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check SETDP directive with expression and comment
	 */
	@Test
	public void testSetDPWithExpressionWithComment() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG		    $8000\n");
		strBuilder.append(" 		   	SETDP    	1+1        ; Page 1\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an SETDP directive line",
					directiveLine.getDirective() instanceof SetDPDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check SETDP directive with negative operand
	 */
	@Test
	public void testSetDPWithNegativeOperand() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    	 $8000\n");
		strBuilder.append(" 		SETDP    -1        ; Page 1\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getSetDPDirective(),
					DirectiveValidator.INVALID_RANGE, "SETDP value can't be negative");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check SETDP directive with operand equals to 0
	 */
	@Test
	public void testSetDPWith0() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    	$8000\n");
		strBuilder.append(" 	   SETDP    1-1 \n");

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
	 * Check SETDP directive with operand equals to 255
	 */
	@Test
	public void testSetDPWith255() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    			$8000\n");
		strBuilder.append(" 		   SETDP    		255	 \n");

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
	 * Check SETDP directive with operand equals to 256
	 */
	@Test
	public void testSetDPWith256() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    	$8000\n");
		strBuilder.append(" 		   SETDP    256 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getSetDPDirective(),
					DirectiveValidator.INVALID_RANGE, "The SETDP value cannot be greater than 255");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check SETDP directive with an unexpected label
	 */
	@Test
	public void testSetDPWithUnexpectedLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test PAG with label\n");
		strBuilder.append("APAG 	    SETDP    	1 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(),
					DirectiveValidator.UNEXPECTED_LABEL, "No label may be set for SETDP directive");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check PC counter after SETDP directive
	 */
	@Test
	public void testSetDPPCCounter0() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			ORG			$2000\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC after SETDP instruction", 0x2000, engine.getCurrentPcValue());
			Assert.assertEquals("Check SETDP value", 0, engine.getCurrentDPPage());

		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check PC counter after SETDP directive
	 */
	@Test
	public void testSetDPPCCounter() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			ORG			$2000\n");
		strBuilder.append("		   	SETDP    	1			   ; Options\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

					AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC after SETDP instruction", 0x2000, engine.getCurrentPcValue());
			Assert.assertEquals("Check SETDP value", 1, engine.getCurrentDPPage());

		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check with error in expression
	 */
	@Test
	public void testSetDPWithErrorExpression() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    		$2000  		 	; With value\n");
		strBuilder.append("		       	SETDP    	10*Deux 		; Toto vaudra $2000\n");
		strBuilder.append(
				"											; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getSetDPDirective(),
					InstructionValidator.EXPRESSION_ERROR, "Can't find Deux definition");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check SETDP with binary error syntax
	 */
	@Test
	public void testSetDPWithBinaryErrorSyntax() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    	$2000  		 	; With value\n");
		strBuilder.append("		       	SETDP  	%01111211 		; Toto vaudra $2000\n");
		strBuilder.append(
				"										; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertIssue(result.eResource(), AssemblerPackage.eINSTANCE.getBinaryValue(),
					AssemblerValidator.INVALID_FIGURE, 108, 8, Severity.ERROR, "2 is invalid in binary value");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check SETDP with octal error syntax
	 */
	@Test
	public void testSetDPWithOctalErrorSyntax() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	           	ORG    		$2000  		 	; With value\n");
		strBuilder.append("	       		SETDP    	@128	 		; Toto vaudra $2000\n");
		strBuilder.append(
				"											; Et en mémoire entre $2000 et $2010, il y aura des 0\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertIssue(result.eResource(), AssemblerPackage.eINSTANCE.getOctalValue(),
					AssemblerValidator.INVALID_FIGURE, 111, 3, Severity.ERROR, "8 is invalid in octal value");
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

}
