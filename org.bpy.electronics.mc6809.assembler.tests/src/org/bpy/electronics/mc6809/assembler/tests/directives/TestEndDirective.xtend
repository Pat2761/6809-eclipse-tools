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
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.bpy.electronics.mc6809.assembler.assembler.EndDirective
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledEndDirectiveLine

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestEndDirective {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	
	/**
	 * Check ORG directive with no value , return 0
	 */
	@Test 
	def void testEndWithNoValueValue() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    $8000   ; With value
			       END
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an END directive line", directiveLine.directive instanceof EndDirective)
	}

	/**
	 * Check END directive with the value
	 */
	@Test 
	def void checkEndValueWithValue() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			   		ORG    	$8000   	; With value
					BSZ		$0A	
		Start		BSZ		1   		
		       		END    	Start 		; That's all folk
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("PC value must be 800B", 0x800B, engine.currentPcValue)
		val line = engine.getAssembledLine(4)
		val endLine = line as AssembledEndDirectiveLine
		Assert.assertEquals("Check line number", 5, endLine.lineNumber)
		Assert.assertNull("Check label", endLine.label)
		Assert.assertEquals("Check comment", "; That's all folk", endLine.comment)
		Assert.assertEquals("Check start value", 0x800A, endLine.value)
	}

	/**
	 * Check END directive without the value
	 */
	@Test 
	def void checkEndWithoutValue() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			   		ORG    	$8000   	; With value
					BSZ		$0A	
		Start		BSZ		1   		
		       		END
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("PC value must be 800B", 0x800B, engine.currentPcValue)
		val line = engine.getAssembledLine(4)
		val endLine = line as AssembledEndDirectiveLine
		Assert.assertEquals("Check line number", 5, endLine.lineNumber)
		Assert.assertNull("Check label", endLine.label)
		Assert.assertNull("Check comment",  endLine.comment)
		Assert.assertEquals("Check start value", 0, endLine.value)
	}
}