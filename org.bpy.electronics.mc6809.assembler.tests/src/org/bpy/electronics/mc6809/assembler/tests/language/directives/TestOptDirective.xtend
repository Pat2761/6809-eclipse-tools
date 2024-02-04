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
package org.bpy.electronics.mc6809.assembler.tests.language.directives

import org.eclipse.xtext.testing.XtextRunner
import org.junit.runner.RunWith
import org.eclipse.xtext.testing.InjectWith
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import org.bpy.electronics.mc6809.assembler.assembler.Model
import org.junit.Test
import org.junit.Assert
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.bpy.electronics.mc6809.assembler.assembler.OptDirective
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledOptDirectiveLine

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestOptDirective {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check OPT directive with nothing
	 */
	@Test 
	def void testOPTEmpty() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   OPT    
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an OPT directive line", directiveLine.directive instanceof OptDirective)
	}
	
	
	/**
	 * Check OPT directive with nothing
	 */
	@Test 
	def void testOPTEmptyWithoutExtraSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   OPT
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an OPT directive line", directiveLine.directive instanceof OptDirective)
	}

	/**
	 * Check OPT directive with nothing and comment
	 */
	@Test 
	def void testOPTEmptyWithComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   OPT    ; All by default
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an OPT directive line", directiveLine.directive instanceof OptDirective)
	}

	/**
	 * Check OPT directive with one option
	 */
	@Test 
	def void testOPTWithOneOption() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   OPT    CON
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an OPT directive line", directiveLine.directive instanceof OptDirective)
	}

	/**
	 * Check OPT directive with list of options
	 */
	@Test 
	def void testOPTWithListOfOptions() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   OPT    CON,PAG,NOM,NOE
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an OPT directive line", directiveLine.directive instanceof OptDirective)
	}
	
	/**
	 * Check OPT directive with list of options and comment
	 */
	@Test 
	def void testOPTWithListOfOptionsAndComment() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   OPT    CON,PAG,NOM,NOE   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an OPT directive line", directiveLine.directive instanceof OptDirective)
	}
	
	/**
	 * Check OPT directive with list duplicate option
	 */
	@Test 
	def void testOPTWithListOfDuplicateOption() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
		 		   OPT    CON,PAG,CON,NOE   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.optDirective,DirectiveValidator::DUPLICATE_OPTION,"Duplicate option CON")
	}
	
	/**
	 * Check OPT directive with duplicate label
	 */
	@Test 
	def void testOPTWithListOfDuplicateLabel() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    	$8000
		Label		EQU		10	       
		Label	   	OPT    	CON			   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.directiveLine, DirectiveValidator::UNEXPECTED_LABEL,"No label may be set for OPT directive")
	}
	
	/**
	 * Check OPT directive with inconsistency PAG NOP option 
	 */
	@Test 
	def void testOPTWithInconsistencyPAG_NOP() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    	$8000
		Label		EQU		10	       
				   	OPT    	PAG,NOP			   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.optDirective, DirectiveValidator::INCONSISTENCY_ERROR,"The OPT directive does not contain at the same time the PAG and NOP options")
	}
	
	/**
	 * Check OPT directive with inconsistency CON NOC option 
	 */
	@Test 
	def void testOPTWithInconsistencyCON_NOC() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    	$8000
		 		   	OPT    	CON,NOC			   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.optDirective, DirectiveValidator::INCONSISTENCY_ERROR,"The OPT directive does not contain at the same time the CON and NOC options")
	}

	/**
	 * Check OPT directive with inconsistency MAC NOM option 
	 */
	@Test 
	def void testOPTWithInconsistencyMAC_NOM() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    	$8000
				   	OPT    	MAC,NOM			   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.optDirective, DirectiveValidator::INCONSISTENCY_ERROR,"The OPT directive does not contain at the same time the MAC and NOM options")
	}

	/**
	 * Check OPT directive with inconsistency EXP NOE option 
	 */
	@Test 
	def void testOPTWithInconsistencyEXP_NOE() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    	$8000
				   	OPT    	EXP,NOE			   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.optDirective, DirectiveValidator::INCONSISTENCY_ERROR,"The OPT directive does not contain at the same time the EXP and NOE options")
	}

	/**
	 * Check OPT directive check Page formatting  
	 */
	@Test 
	def void testOPTPageFormating0() {
		val result = parseHelper.parse('''
		; -----------------------------------------
					   	OPT    					   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1)
		
		val optLine = line as AssembledOptDirectiveLine
		Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination)
		Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode)
		Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls)
		Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines)
	}

	/**
	 * Check OPT directive check Page formatting  
	 */
	@Test 
	def void testOPTPageFormating1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
					   	OPT    	PAG				   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1)
		
		val optLine = line as AssembledOptDirectiveLine
		Assert.assertTrue("Enable page formatting and numbering", optLine.isEnablePagination)
		Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode)
		Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls)
		Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines)
	}

	/**
	 * Check OPT directive check Page formatting  
	 */
	@Test 
	def void testOPTPageFormating2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
					   	OPT    	NOP				   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1)
		
		val optLine = line as AssembledOptDirectiveLine
		Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination)
		Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode)
		Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls)
		Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines)
	}

	/**
	 * Check OPT directive check print conditionally skipped code
	 */
	@Test 
	def void testOPTPrintConditionallySkippedCode1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
					   	OPT    	CON				   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1)
		
		val optLine = line as AssembledOptDirectiveLine
		Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination)
		Assert.assertTrue("Print conditionally skipped code", optLine.isConditionallySkippedCode)
		Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls)
		Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines)
	}

	/**
	 * Check OPT directive check print conditionally skipped code 
	 */
	@Test 
	def void testOPTPrintConditionallySkippedCode2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
					   	OPT    	NOC				   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1)
		
		val optLine = line as AssembledOptDirectiveLine
		Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination)
		Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode)
		Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls)
		Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines)
	}

	/**
	 * Check OPT directive check suppress printing of macro calls 
	 */
	@Test 
	def void testOPTSuppressPrintingOfMacroCalls1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
					   	OPT    	NOM				   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1)
		
		val optLine = line as AssembledOptDirectiveLine
		Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination)
		Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode)
		Assert.assertTrue("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls)
		Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines)
	}

	/**
	 * Check OPT directive check suppress printing of macro calls  
	 */
	@Test 
	def void testOPTSuppressPrintingOfMacroCalls2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
					   	OPT    	NOC				   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1)
		
		val optLine = line as AssembledOptDirectiveLine
		Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination)
		Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode)
		Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls)
		Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines)
	}

	/**
	 * Check OPT directive check Print macro expansion line 
	 */
	@Test 
	def void testOPTSuppressPrintPrintMacroExpansionLine1() {
		val result = parseHelper.parse('''
		; -----------------------------------------
					   	OPT    	EXP				   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1)
		
		val optLine = line as AssembledOptDirectiveLine
		Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination)
		Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode)
		Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls)
		Assert.assertTrue("Print macro expansion lines", optLine.isPrintMacroExpansionLines)
	}

	/**
	 * Check OPT directive check Print macro expansion line 
	 */
	@Test 
	def void testOPTSuppressPrintPrintMacroExpansionLine2() {
		val result = parseHelper.parse('''
		; -----------------------------------------
					   	OPT    	NOE				   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1)
		
		val optLine = line as AssembledOptDirectiveLine
		Assert.assertFalse("Enable page formatting and numbering", optLine.isEnablePagination)
		Assert.assertFalse("Print conditionally skipped code", optLine.isConditionallySkippedCode)
		Assert.assertFalse("Suppress printing of macro calls ", optLine.isSuppressPrintingOfMacroCalls)
		Assert.assertFalse("Print macro expansion lines", optLine.isPrintMacroExpansionLines)
	}

	/**
	 * Check OPT directive check program counter 
	 */
	@Test 
	def void testOPTProgramCounter() {
		val result = parseHelper.parse('''
		; -----------------------------------------
						ORG		$4000
					   	OPT    	NOE				   ; Options
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC after OPT instruction", 0x4000, engine.currentPcValue)		
	}
}