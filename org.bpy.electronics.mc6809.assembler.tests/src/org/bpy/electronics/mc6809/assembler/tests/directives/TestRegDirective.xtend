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
import org.bpy.electronics.mc6809.assembler.assembler.RegDirective
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class TestRegDirective {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	/**
	 * Check REG directive without comment
	 */
	@Test 
	def void testREGWithoutCommentWithSpace() {
		val result = parseHelper.parse('''
		; -----------------------------------------
			       	ORG    	$8000
		RGT_S 		REG 	PC,U,Y,X,DP,D,CC 	; tous les registres sauf S
		RGT_U 		REG 	PC,S,Y,X,DP,D,CC 	; tous les registres sauf U
		RGABCC 		REG 	A,B,CC 				; on peut aussi écrire D,CC
		RGUYX 		REG 	U,Y,X
		RGUDCC 		REG 	U,D,CC 				; on peut aussi écrire U,A,B,CC 		   FAIL    
		RegD 		REG		D
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		val errors = result.eResource.errors
		Assert.assertTrue('''Unexpected errors: �errors.join(", ")�''', errors.isEmpty)
		
		val line = result.sourceLines.get(2)
		Assert.assertTrue("Must be a directive line", line.lineContent instanceof DirectiveLine)
		
		val directiveLine = line.lineContent as DirectiveLine
		Assert.assertTrue("Must be an REG directive line", directiveLine.directive instanceof RegDirective)
		
//		val endDirective = directiveLine.directive as EndDirective
//	 	Assert.assertNull("Label must be null", CommandUtil.getLabel(endDirective))	
//		Assert.assertEquals("Operand must be equals to 1000", 1000, ExpressionParser.parse(endDirective))		
	}


}