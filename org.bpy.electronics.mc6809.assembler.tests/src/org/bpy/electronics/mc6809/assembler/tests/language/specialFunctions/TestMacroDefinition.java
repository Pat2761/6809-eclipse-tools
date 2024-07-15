package org.bpy.electronics.mc6809.assembler.tests.language.specialFunctions;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
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

public class TestMacroDefinition {
	@Inject
	ParseHelper<Model> parseHelper;
	@Inject
	@Extension
	private ValidationTestHelper validationTestHelper;

	@Test
	public void testSimpleCaseEmptyMacro() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append(" 			 .macro MyMacro\n");
		strBuilder.append("	       .endm \n");
		Model result;
		try {
			result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertNoErrors(result);
			validationTestHelper.assertWarning(result, AssemblerPackage.eINSTANCE.getMacroDefinition(), InstructionValidator.EMPTY_MACRO,
					"Macro MyMacro can't be empty");

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	@Test
	public void testSimpleCaseMacro1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append(" 			 .macro MyMacro\n");
		strBuilder.append("	       NOP \n");
		strBuilder.append("	       .endm \n");
		Model result;
		try {
			result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertNoIssues(result);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	@Test
	public void testSimpleCaseMacro2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append(" 			 .macro MyMacro          ; Definition of macro\n");
		strBuilder.append("Bcl      NOP \n");
		strBuilder.append("	       BNE Bcl \n");
		strBuilder.append("	       .endm \n");
		Model result;
		try {
			result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertNoIssues(result);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	@Test
	public void testSimpleDupliccateMacro() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append(" 			 .macro MyMacro          ; Definition of macro\n");
		strBuilder.append("	       NOP \n");
		strBuilder.append("	       .endm \n");
		strBuilder.append("	       NOP \n");
		strBuilder.append(" 			 .macro MyMacro          ; Definition of macro\n");
		strBuilder.append("	       NOP \n");
		strBuilder.append("	       .endm \n");
		Model result;
		try {
			result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getMacroDefinition(), InstructionValidator.DUPLICATE_MACRO,
					"Macro MyMacro is already defined");

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	@Test
	public void testAssemblyMacro() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append(" 			 .macro Wait          ; Definition of macro\n");
		strBuilder.append("	       NOP \n");
		strBuilder.append("	       .endm \n");
		strBuilder.append("	       NOP \n");
		strBuilder.append(" 			 Wait                 ; wait\n");
		strBuilder.append("	       NOP \n");
		Model result;
		try {
			result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertNoErrors(result);

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	@Test
	public void testAssemblyMacroWithNoMacro() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append(" 			 .macro Wait          ; Definition of macro\n");
		strBuilder.append("	       NOP \n");
		strBuilder.append("	       .endm \n");
		strBuilder.append("	       NOP \n");
		strBuilder.append(" 			 Wait1                 ; wait\n");
		strBuilder.append("	       NOP \n");
		Model result;
		try {
			result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getOtherKindOfInstructions(), InstructionValidator.UNRECOGNIZED_INSTRUCTION,
					"The instruction Wait1 is not recognized");

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	@Test
	public void testAssemblyMacro2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");	
		strBuilder.append(" 			 ORG         $8000    ; Start of ROM\n");
		strBuilder.append(" 			 .macro Wait          ; Definition of macro\n");
		strBuilder.append("	       NOP \n");
		strBuilder.append("	       .endm\n");
		strBuilder.append("	       NOP \n");
		strBuilder.append(" 			 Wait                 ; wait\n");
		strBuilder.append(" 			 Wait                 ; wait\n");
		strBuilder.append("	       NOP \n");
		Model result;
		try {
			result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertNoErrors(result);
			
			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("4 NOP instructions", 0x8004, engine.getCurrentPcValue());

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}

	@Test
	public void testAssemblyMacro3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");	
		strBuilder.append(" 			 ORG         $8000    ; Start of ROM\n");
		strBuilder.append(" 			 .macro Wait5         ; Definition of macro\n");
		strBuilder.append("Wait     LDA			 #5       ; wait 5   \n");
		strBuilder.append("	       DECA			          ; A=A-1   \n");
		strBuilder.append("	       BNE			 Wait	    ; Test if A=0   \n");
		strBuilder.append("	       .endm\n");
		strBuilder.append("	       NOP \n");
		strBuilder.append(" 			 Wait5                ; wait\n");
		strBuilder.append(" 			 Wait5                ; wait\n");
		strBuilder.append("	       NOP \n");
		Model result;
		try {
			result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertNoErrors(result);
			
			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("4 NOP instructions", 0x8004, engine.getCurrentPcValue());

		} catch (Exception e) {
			Assert.assertTrue("Exception", true);
		}
	}
}
