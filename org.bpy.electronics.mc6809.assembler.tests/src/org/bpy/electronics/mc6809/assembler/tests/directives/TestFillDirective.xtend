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
package org.bpy.electronics.mc6809.assembler.tests.directives

import org.eclipse.xtext.testing.XtextRunner
import org.junit.runner.RunWith
import org.eclipse.xtext.testing.InjectWith
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import org.bpy.electronics.mc6809.assembler.assembler.Model
import org.junit.Test
import org.junit.Assert
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective
import org.bpy.electronics.mc6809.assembler.assembler.FillDirective
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledEndDirectiveLine
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledFillDirectiveLine
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestFillDirective {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check FILL directive with a simple values
	 */
	@Test 
	def void testFILLWithDecimalValue() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000
			       FILL   $80,25 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an FILL directive line", directiveLine.directive instanceof FillDirective)
	}

	/**
	 * Check FILL directive with a simple identifier defined by an another EQU
	 */
	@Test 
	def void testFILLWithIdentifierValue() {
		val result = parseHelper.parse('''
		; Starting assembly file
		Start		EQU		$8000
		Val1       	EQU    	$40            ; Number 
		
		; Strating code section
		           	ORG    	Start         ; Start program at $4000
		           	FILL   	Val1,10       ; Fill example
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)

		val line1 = result.sourceLines.get(6)
		Assert.assertTrue("Must be a directive line", line1.lineContent instanceof DirectiveLine)
		
		val directiveLine1 = line1.lineContent as DirectiveLine
		Assert.assertTrue("Must be an FILL directive line", directiveLine1.directive instanceof FillDirective)

		val engine = AssemblerEngine.instance
		Assert.assertEquals("PC value must be 800A", 0x800A, engine.currentPcValue)
		val line = engine.getAssembledLine(6)
		val bszLine = line as AssembledFillDirectiveLine
		Assert.assertEquals("Check line number", 7, bszLine.lineNumber)
		Assert.assertNull("Check label", bszLine.label)
		Assert.assertEquals("Check comment", "; Fill example", bszLine.comment)

		for (value : bszLine.values) {
			Assert.assertEquals("Reserved bytes must be equals to 64", 64, value)
		}
	}

	/**
	 * Check FILL directive with duplicate label
	 */
	@Test 
	def void testFILLWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; Starting assembly file
		Start		EQU		$8000
		Val1       	EQU    	$40            ; Number 
		
		; Strating code section
		           	ORG    	Start         ; Start program at $4000
		Val2       	BSZ		6	
		Val2       	FILL   	Val1,10       ; Fill example
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.directiveLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"Label Val2 is already defined"
		)
		
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
	}
	
	/**
	 * Check FILL directive with Low value limit
	 */
	@Test 
	def void testFILLWithLowValueLimit() {
		val result = parseHelper.parse('''
		; Starting assembly file
		Val2       	FILL   	-128,10       ; Fill example
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}
	
	/**
	 * Check FILL directive with High value limit
	 */
	@Test 
	def void testFILLWithHighValueLimit() {
		val result = parseHelper.parse('''
		; Starting assembly file
		Val2       	FILL   	255,10       ; Fill example
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}
	
	/**
	 * Check FILL directive with Low value limit
	 */
	@Test 
	def void testFILLWithLowBadValueLimit() {
		val result = parseHelper.parse('''
		; Starting assembly file
		Val2       	FILL   	-129,10       ; Fill example
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.Literals.FILL_DIRECTIVE,
			DirectiveValidator::INVALID_RANGE,
			"FILL value minimum value is -128"			
		)
	}
	
	/**
	 * Check FILL directive with High value limit
	 */
	@Test 
	def void testFILLWithHighBadValueLimit() {
		val result = parseHelper.parse('''
		; Starting assembly file
		Val2       	FILL   	256,10       ; Fill example
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.Literals.FILL_DIRECTIVE,
			DirectiveValidator::INVALID_RANGE,
			"FILL maximum value to set is 255"			
		)
	}

	/**
	 * Check FILL directive with Low occurrence limit
	 */
	@Test 
	def void testFILLWithLowOccurrenceLimit() {
		val result = parseHelper.parse('''
		; Starting assembly file
		Val2       	FILL   	10,1       ; Fill example
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}
	
	/**
	 * Check FILL directive with High occurrence limit
	 */
	@Test 
	def void testFILLWithHighOccurrenceLimit() {
		val result = parseHelper.parse('''
		; Starting assembly file
		Val2       	FILL   	127,9       ; Fill example
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
	}
	
	/**
	 * Check FILL directive with Low occurrence limit
	 */
	@Test 
	def void testFILLWithLowBadOccurrenceLimit() {
		val result = parseHelper.parse('''
		; Starting assembly file
		Val2       	FILL   	45,-1       ; Fill example
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.Literals.FILL_DIRECTIVE,
			DirectiveValidator::INVALID_RANGE,
			"FILL value occurrence can't be negative"			
		)
	}

	/**
	 * Check FILL directive with no occurrence
	 */
	@Test 
	def void testFILLWithLowNoOccurrenceLimit() {
		val result = parseHelper.parse('''
		; Starting assembly file
		Val2       	FILL   	45,0       ; Fill example
		''')
		Assert.assertNotNull(result)
		result.assertWarning(AssemblerPackage.Literals.FILL_DIRECTIVE,
			DirectiveValidator::INVALID_RANGE,
			"FILL occurrence can't be null"			
		)
	}
	
	/**
	 * Check FILL directive with High value limit
	 */
	@Test 
	def void testFILLWithHighBadOccurrenceLimit() {
		val result = parseHelper.parse('''
		; Starting assembly file
		Val2       	FILL   	255,65536       ; Fill example
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.Literals.FILL_DIRECTIVE,
			DirectiveValidator::INVALID_RANGE,
			"FILL value maximum value is $FFFF"			
		)
	}
}