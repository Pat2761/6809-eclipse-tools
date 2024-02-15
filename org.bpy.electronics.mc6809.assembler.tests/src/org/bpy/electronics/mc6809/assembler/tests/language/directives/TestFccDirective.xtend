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
import org.bpy.electronics.mc6809.assembler.assembler.FccDirective
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFccDirectiveLine

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestFccDirective {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check Fcc directive without comment
	 */
	@Test 
	def void testFccWithoutCommentWithSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		 		   FCC		"Erreur AA115"    
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an FCC directive line", directiveLine.directive instanceof FccDirective)
	}

	/**
	 * Check Fcc directive without comment
	 */
	@Test 
	def void testFccWithoutCommentWithoutSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		MyFcc	   FCC		"Erreur AA115"
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an FCC directive line", directiveLine.directive instanceof FccDirective)
	}


	/**
	 * Check Fcc directive with comment
	 */
	@Test 
	def void testFccWithCommentWithoutSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       ORG    	$8000
		MyFcc	   FCC		"Erreur AA115"         ; erreur definition
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an FCC directive line", directiveLine.directive instanceof FccDirective)
	}
	
	/**
	 * Check FCC directive with duplicate Label
	 */
	@Test 
	def void testFCBWithDuplicateLabels() {
		val result = parseHelper.parse('''
			         ORG    $8000
		Label1	     BSZ	10    
		Label1       FCC    "Erreur AA115" 
		''')
		Assert.assertNotNull(result)
		result.assertError(
			AssemblerPackage.eINSTANCE.directiveLine,
			AssemblerEngine::DUPLICATE_LABEL,
			"Label Label1 is already defined"
		)
	}

	/**
	 * Check FDB directive with duplicate Label
	 */
	@Test 
	def void testFDBAssemblyResult() {
		val result = parseHelper.parse('''
			        	ORG    	$8000
		Label1       	FCC    	"Erreur AA115" 		; error message
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1) as AssembledFccDirectiveLine;
		Assert.assertEquals("Check Label","Label1",line.label)
		Assert.assertEquals("Check Comment","; error message",line.comment)

		Assert.assertEquals("Check value 0",69,line.values.get(0))
		Assert.assertEquals("Check value 1",114,line.values.get(1))
		Assert.assertEquals("Check value 2",114,line.values.get(2))
		Assert.assertEquals("Check value 3",101,line.values.get(3))
		Assert.assertEquals("Check value 4",117,line.values.get(4))
		Assert.assertEquals("Check value 5",114,line.values.get(5))
		Assert.assertEquals("Check value 6",32,line.values.get(6))
		Assert.assertEquals("Check value 7",65,line.values.get(7))
		Assert.assertEquals("Check value 8",65,line.values.get(8))
		Assert.assertEquals("Check value 9",49,line.values.get(9))
		Assert.assertEquals("Check value 10",49,line.values.get(10))
		Assert.assertEquals("Check value 11",53,line.values.get(11))

		Assert.assertEquals("Check Impact on PC",0x800C,engine.currentPcValue)
	}
}