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
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledRegDirectiveLine

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
	}

	/**
	 * Check REG directive with a missing label
	 */
	@Test 
	def void testWithMissingLabel() {
		val result = parseHelper.parse('''
		; test REG without label
		 	    REG     A ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.directiveLine,DirectiveValidator::MISSING_LABEL,"No label defined for REG directive")
	}

	/**
	 * Check REG directive with a missing register
	 */
	@Test 
	def void testWithMissingRegister() {
		val result = parseHelper.parse('''
		; test REG without label
		Regs 	    REG     		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.regDirective,DirectiveValidator::MISSING_OPTION,"no register defined in the REG Directive")
	}

	/**
	 * Check REG directive with a duplicate register
	 */
	@Test 
	def void testWithDuplicateRegister() {
		val result = parseHelper.parse('''
		; test REG without label
		Regs 	    REG    A,B,U,S,A 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.regDirective,DirectiveValidator::DUPLICATE_OPTION,"Register A is duplicate in the REG Directive")
	}

	/**
	 * Check REG directive with missing label
	 */
	@Test 
	def void testRegWithMissingLabel() {
		val result = parseHelper.parse('''
		; test REG without label
			 	    REG    A,B,U,S,A 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.directiveLine,DirectiveValidator::MISSING_LABEL,"No label defined for REG directive")
	}

	/**
	 * Check REG directive impact on PC Address
	 */
	@Test 
	def void testRegPcAddress() {
		val result = parseHelper.parse('''
		; test REG without label
					ORG	   $C000
		RegV 	    REG    A,B,U,S 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		Assert.assertEquals("Check PC Address", 0xC000, engine.currentPcValue)
	}

	/**
	 * Check REG directive with D and A register
	 */
	@Test 
	def void testRegWithAAndDRegister() {
		val result = parseHelper.parse('''
		; test REG without label
			 	    REG    A,D 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.regDirective,DirectiveValidator::DUPLICATE_OPTION,"D register overwrite the A register in the REG Directive")
	}

	/**
	 * Check REG directive with D and B register
	 */
	@Test 
	def void testRegWithBAndDRegister() {
		val result = parseHelper.parse('''
		; test REG without label
			 	    REG    B,D 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.regDirective,DirectiveValidator::DUPLICATE_OPTION,"D register overwrite the B register in the REG Directive")
	}

	/**
	 * Check REG directive with duplicate label
	 */
	@Test 
	def void testRegWithDuplicateLabel() {
		val result = parseHelper.parse('''
		; test REG without label
		Lab1		EQU		100
		Lab1	 	REG    	B,D 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertError(AssemblerPackage.eINSTANCE.directiveLine,AssemblerEngine::DUPLICATE_LABEL,"The label Lab1 for an REG directive is already defined")
	}

	/**
	 * Check equ value forREG directive 
	 */
	@Test 
	def void testRegEquValue() {
		val result = parseHelper.parse('''
		; test REG without label
		Lab2	 	REG    	B,X 		 ; Oups
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors

		val engine = AssemblerEngine.instance
		val line = engine.getAssembledLine(1) as AssembledRegDirectiveLine
		Assert.assertEquals("Check equ value",0x14, engine.getEquSetLabelValue(line.label))
	}

	/**
	 * Check REG directive value CC
	 */
	@Test 
	def void testRegValueCC() {
		val result = parseHelper.parse('''
		; test REG without label
		CC1	 	    REG    CC 		 
		L_A	 	    REG    A 		 
		L_B	 	    REG    B 		 
		L_D 	    REG    D
		L_DP 	    REG    DP
		L_X	 	    REG    X 		 
		L_Y	 	    REG    Y 		 
		L_U	 	    REG    U 		 
		L_S	 	    REG    S 		 
		L_PC	 	REG    PC 		 
		''')
		Assert.assertNotNull(result)
		result.assertNoErrors
		
		val engine = AssemblerEngine.instance
		val regLineCC = engine.getAssembledLine(1) as AssembledRegDirectiveLine
		Assert.assertEquals("Check value CC", 1, regLineCC.value)
		val regLineA = engine.getAssembledLine(2) as AssembledRegDirectiveLine
		Assert.assertEquals("Check value A", 2, regLineA.value)
		val regLineB = engine.getAssembledLine(3) as AssembledRegDirectiveLine
		Assert.assertEquals("Check value B", 4, regLineB.value)
		val regLineD = engine.getAssembledLine(4) as AssembledRegDirectiveLine
		Assert.assertEquals("Check value D", 6, regLineD.value)
		val regLineDP = engine.getAssembledLine(5) as AssembledRegDirectiveLine
		Assert.assertEquals("Check value DP", 8, regLineDP.value)
		val regLineX = engine.getAssembledLine(6) as AssembledRegDirectiveLine
		Assert.assertEquals("Check value X", 16, regLineX.value)
		val regLineY = engine.getAssembledLine(7) as AssembledRegDirectiveLine
		Assert.assertEquals("Check value X", 32, regLineY.value)
		val regLineU = engine.getAssembledLine(8) as AssembledRegDirectiveLine
		Assert.assertEquals("Check value U", 64, regLineU.value)
		val regLineS = engine.getAssembledLine(9) as AssembledRegDirectiveLine
		Assert.assertEquals("Check value U", 64, regLineS.value)
		val regLinePC = engine.getAssembledLine(10) as AssembledRegDirectiveLine
		Assert.assertEquals("Check value PC", 128, regLinePC.value)
	}
}