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
import org.bpy.electronics.mc6809.assembler.assembler.OptDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerManager;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledOptDirectiveLine;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator;
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

public class TestOptDirective {
	@Inject
	ParseHelper<Model> parseHelper;
	@Inject
	@Extension
	private ValidationTestHelper validationHelper;

	/**
	 * Check OPT directive with nothing
	 */
	@Test
	public void testOPTEmpty() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append(" 		   OPT    \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an OPT directive line", directiveLine.getDirective() instanceof OptDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive with nothing
	 */
	@Test
	public void testOPTEmptyWithoutExtraSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append(" 		   OPT\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an OPT directive line", directiveLine.getDirective() instanceof OptDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive with nothing and comment
	 */
	@Test
	public void testOPTEmptyWithComment() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append(" 		   OPT    ; All by default\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an OPT directive line", directiveLine.getDirective() instanceof OptDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive with one option
	 */
	@Test
	public void testOPTWithOneOption() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append(" 		   OPT    CON\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an OPT directive line", directiveLine.getDirective() instanceof OptDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive with list of options
	 */
	@Test
	public void testOPTWithListOfOptions() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append(" 		   OPT    CON,PAG,NOM,NOE\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an OPT directive line", directiveLine.getDirective() instanceof OptDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive with list of options and comment
	 */
	@Test
	public void testOPTWithListOfOptionsAndComment() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append(" 		   OPT    CON,PAG,NOM,NOE   ; Options\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an OPT directive line", directiveLine.getDirective() instanceof OptDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive with list duplicate option
	 */
	@Test
	public void testOPTWithListOfDuplicateOption() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append(" 		   OPT    CON,PAG,CON,NOE   ; Options\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getOptDirective(), DirectiveValidator.DUPLICATE_OPTION,
					"Duplicate option CON");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive with duplicate label
	 */
	@Test
	public void testOPTWithListOfDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    	$8000\n");
		strBuilder.append("Label		EQU		10	       \n");
		strBuilder.append("Label	   	OPT    	CON			   ; Options\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(), DirectiveValidator.UNEXPECTED_LABEL,
					"No label may be set for OPT directive");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive with inconsistency PAG NOP option
	 */
	@Test
	public void testOPTWithInconsistencyPAG_NOP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    	$8000\n");
		strBuilder.append("Label		EQU		10	       \n");
		strBuilder.append("		   	OPT    	PAG,NOP			   ; Options\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getOptDirective(), DirectiveValidator.INCONSISTENCY_ERROR,
					"The OPT directive does not contain at the same time the PAG and NOP options");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive with inconsistency CON NOC option
	 */
	@Test
	public void testOPTWithInconsistencyCON_NOC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    	$8000\n");
		strBuilder.append(" 		   	OPT    	CON,NOC			   ; Options\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getOptDirective(), DirectiveValidator.INCONSISTENCY_ERROR,
					"The OPT directive does not contain at the same time the CON and NOC options");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive with inconsistency MAC NOM option
	 */
	@Test
	public void testOPTWithInconsistencyMAC_NOM() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    	$8000\n");
		strBuilder.append("		   	OPT    	MAC,NOM			   ; Options\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getOptDirective(), DirectiveValidator.INCONSISTENCY_ERROR,
					"The OPT directive does not contain at the same time the MAC and NOM options");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive with inconsistency EXP NOE option
	 */
	@Test
	public void testOPTWithInconsistencyEXP_NOE() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    	$8000\n");
		strBuilder.append("		   	OPT    	EXP,NOE			   ; Options\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getOptDirective(), DirectiveValidator.INCONSISTENCY_ERROR,
					"The OPT directive does not contain at the same time the EXP and NOE options");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive check Page formatting
	 */
	@Test
	public void testOPTPageFormating0() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	OPT    					   ; Options\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AbstractAssemblyLine line = engine.getAssembledLine(1);

			AssembledOptDirectiveLine optLine = (AssembledOptDirectiveLine) line;
			Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination());
			Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode());
			Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls());
			Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive check Page formatting
	 */
	@Test
	public void testOPTPageFormating1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	OPT    	PAG				   ; Options\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AbstractAssemblyLine line = engine.getAssembledLine(1);

			AssembledOptDirectiveLine optLine = (AssembledOptDirectiveLine) line;
			Assert.assertTrue("Enable page formatting and numbering", optLine.isEnablePagination());
			Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode());
			Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls());
			Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive check Page formatting
	 */
	@Test
	public void testOPTPageFormating2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	OPT    	NOP				   ; Options\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AbstractAssemblyLine line = engine.getAssembledLine(1);

			AssembledOptDirectiveLine optLine = (AssembledOptDirectiveLine) line;
			Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination());
			Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode());
			Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls());
			Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive check print conditionally skipped code
	 */
	@Test
	public void testOPTPrintConditionallySkippedCode1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	OPT    	CON				   ; Options\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AbstractAssemblyLine line = engine.getAssembledLine(1);

			AssembledOptDirectiveLine optLine = (AssembledOptDirectiveLine) line;
			Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination());
			Assert.assertTrue("Print conditionally skipped code", optLine.isConditionallySkippedCode());
			Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls());
			Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive check print conditionally skipped code
	 */
	@Test
	public void testOPTPrintConditionallySkippedCode2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	OPT    	NOC				   ; Options\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AbstractAssemblyLine line = engine.getAssembledLine(1);

			AssembledOptDirectiveLine optLine = (AssembledOptDirectiveLine) line;
			Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination());
			Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode());
			Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls());
			Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive check suppress printing of macro calls
	 */
	@Test
	public void testOPTSuppressPrintingOfMacroCalls1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	OPT    	NOM				   ; Options\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AbstractAssemblyLine line = engine.getAssembledLine(1);

			AssembledOptDirectiveLine optLine = (AssembledOptDirectiveLine) line;
			Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination());
			Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode());
			Assert.assertTrue("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls());
			Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive check suppress printing of macro calls
	 */
	@Test
	public void testOPTSuppressPrintingOfMacroCalls2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	OPT    	NOC				   ; Options\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AbstractAssemblyLine line = engine.getAssembledLine(1);

			AssembledOptDirectiveLine optLine = (AssembledOptDirectiveLine) line;
			Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination());
			Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode());
			Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls());
			Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive check Print macro expansion line
	 */
	@Test
	public void testOPTSuppressPrintPrintMacroExpansionLine1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	OPT    	EXP				   ; Options\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AbstractAssemblyLine line = engine.getAssembledLine(1);

			AssembledOptDirectiveLine optLine = (AssembledOptDirectiveLine) line;
			Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination());
			Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode());
			Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls());
			Assert.assertTrue("Print macro expansion lines", optLine.isPrintMacroExpansionLines());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive check Print macro expansion line
	 */
	@Test
	public void testOPTSuppressPrintPrintMacroExpansionLine2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("			   	OPT    	NOE				   ; Options\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AbstractAssemblyLine line = engine.getAssembledLine(1);

			AssembledOptDirectiveLine optLine = (AssembledOptDirectiveLine) line;
			Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination());
			Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode());
			Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls());
			Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check OPT directive check program counter
	 */
	@Test
	public void testOPTProgramCounter() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("					ORG		$4000\n");
		strBuilder.append("			   	OPT    	NOE				   ; Options\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			Assert.assertEquals("Check PC after OPT instruction", 0x4000, engine.getCurrentPcValue());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

}