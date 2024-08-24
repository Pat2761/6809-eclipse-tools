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

import org.eclipse.xtext.testing.XtextRunner;
import org.junit.runner.RunWith;
import org.eclipse.xtext.testing.InjectWith;
import com.google.inject.Inject;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.junit.Test;
import org.junit.Assert;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Extension;
import org.bpy.electronics.mc6809.assembler.assembler.RegDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerManager;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledRegDirectiveLine;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class TestRegDirective {

	@Inject
	ParseHelper<Model> parseHelper;
	@Inject
	@Extension
	private ValidationTestHelper validationHelper;

	/**
	 * Check REG directive without comment
	 */
	@Test
	public void testREGWithoutCommentWithSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	     	  	ORG    	$8000\n");
		strBuilder.append("RGT_S 		REG 	PC,U,Y,X,DP,D,CC 	; tous les registres sauf S\n");
		strBuilder.append("RGT_U 		REG 	PC,S,Y,X,DP,D,CC 	; tous les registres sauf U\n");
		strBuilder.append("RGABCC 		REG 	A,B,CC 				; on peut aussi écrire D,CC\n");
		strBuilder.append("RGUYX 		REG 	U,Y,X\n");
		strBuilder.append("RGUDCC 		REG 	U,D,CC 				; on peut aussi écrire U,A,B,CC 		   FAIL    \n");
		strBuilder.append("RegD 		REG		D\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);

			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an REG directive line", directiveLine.getDirective() instanceof RegDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check REG directive with a missing label
	 */
	@Test
	public void testWithMissingLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append(" 	    REG     A ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(), DirectiveValidator.MISSING_LABEL,
					"No label defined for REG directive");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check REG directive with a missing register
	 */
	@Test
	public void testWithMissingRegister() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("Regs 	    REG     		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRegDirective(), DirectiveValidator.MISSING_OPTION,
					"no register defined in the REG Directive");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check REG directive with a duplicate register
	 */
	@Test
	public void testWithDuplicateRegister() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("Regs 	    REG    A,B,U,S,A 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRegDirective(), DirectiveValidator.DUPLICATE_OPTION,
					"Register A is duplicate in the REG Directive");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check REG directive with missing label
	 */
	@Test
	public void testRegWithMissingLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("	 	    REG    A,B,U,S,A 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(), DirectiveValidator.MISSING_LABEL,
					"No label defined for REG directive");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check REG directive impact on PC Address
	 */
	@Test
	public void testRegPcAddress() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("			ORG	   $C000\n");
		strBuilder.append("RegV 	    REG    A,B,U,S 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("Check PC Address", 0xC000, engine.getCurrentPcValue());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check REG directive with D and A register
	 */
	@Test
	public void testRegWithAAndDRegister() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("	 	    REG    A,D 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRegDirective(), DirectiveValidator.DUPLICATE_OPTION,
					"D register overwrite the A register in the REG Directive");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check REG directive with D and B register
	 */
	@Test
	public void testRegWithBAndDRegister() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("	 	    REG    B,D 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getRegDirective(), DirectiveValidator.DUPLICATE_OPTION,
					"D register overwrite the B register in the REG Directive");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check REG directive with duplicate label
	 */
	@Test
	public void testRegWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("Lab1		EQU		100\n");
		strBuilder.append("Lab1	 	REG    	B,D 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(), InstructionValidator.DUPLICATE_LABEL,
					"The label Lab1 for an REG directive is already defined");
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check equ value forREG directive
	 */
	@Test
	public void testRegEquValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("Lab2	 	REG    	B,X 		 ; Oups\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

					AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledRegDirectiveLine line = (AssembledRegDirectiveLine) engine.getAssembledLine(1);
			Assert.assertEquals("Check REG value", 0x14, engine.getEquSetLabelValue(line.getLabel()).intValue());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	/**
	 * Check REG directive value CC
	 */
	@Test
	public void testRegValueCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; test REG without label\n");
		strBuilder.append("CC1	 	    REG    CC 		 \n");
		strBuilder.append("L_A	 	    REG    A 		 \n");
		strBuilder.append("L_B	 	    REG    B 		 \n");
		strBuilder.append("L_D 	    	 REG    D\n");
		strBuilder.append("L_DP 	    REG    DP\n");
		strBuilder.append("L_X	 	    REG    X 		 \n");
		strBuilder.append("L_Y	 	    REG    Y 		 \n");
		strBuilder.append("L_U	 	    REG    U 		 \n");
		strBuilder.append("L_S	 	    REG    S 		 \n");
		strBuilder.append("L_PC	 		 REG    PC 		 \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledRegDirectiveLine regLineCC = (AssembledRegDirectiveLine) engine.getAssembledLine(1);
			Assert.assertEquals("Check value CC", 1, regLineCC.getValue());
			AssembledRegDirectiveLine regLineA = (AssembledRegDirectiveLine) engine.getAssembledLine(2);
			Assert.assertEquals("Check value A", 2, regLineA.getValue());
			AssembledRegDirectiveLine regLineB = (AssembledRegDirectiveLine) engine.getAssembledLine(3);
			Assert.assertEquals("Check value B", 4, regLineB.getValue());
			AssembledRegDirectiveLine regLineD = (AssembledRegDirectiveLine) engine.getAssembledLine(4);
			Assert.assertEquals("Check value D", 6, regLineD.getValue());
			AssembledRegDirectiveLine regLineDP = (AssembledRegDirectiveLine) engine.getAssembledLine(5);
			Assert.assertEquals("Check value DP", 8, regLineDP.getValue());
			AssembledRegDirectiveLine regLineX = (AssembledRegDirectiveLine) engine.getAssembledLine(6);
			Assert.assertEquals("Check value X", 16, regLineX.getValue());
			AssembledRegDirectiveLine regLineY = (AssembledRegDirectiveLine) engine.getAssembledLine(7);
			Assert.assertEquals("Check value Y", 32, regLineY.getValue());
			AssembledRegDirectiveLine regLineU = (AssembledRegDirectiveLine) engine.getAssembledLine(8);
			Assert.assertEquals("Check value U", 64, regLineU.getValue());
			AssembledRegDirectiveLine regLineS = (AssembledRegDirectiveLine) engine.getAssembledLine(9);
			Assert.assertEquals("Check value S", 64, regLineS.getValue());
			AssembledRegDirectiveLine regLinePC = (AssembledRegDirectiveLine) engine.getAssembledLine(10);
			Assert.assertEquals("Check value PC", 128, regLinePC.getValue());
			Assert.assertEquals("Check memorization", 128,engine.getEquSetManager().getValue("L_PC").intValue());
		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}
}