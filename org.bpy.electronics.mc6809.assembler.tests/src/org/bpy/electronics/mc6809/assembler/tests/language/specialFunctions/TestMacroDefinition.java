package org.bpy.electronics.mc6809.assembler.tests.language.specialFunctions;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.RelativeMode;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerManager;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledBNEInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledDECAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLDAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.others.MacroAssembledElement;
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
			Assert.assertTrue("Exception", false);
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
			Assert.assertTrue("Exception", false);
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
			Assert.assertTrue("Exception", false);
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
			Assert.assertTrue("Exception", false);
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
			Assert.assertTrue("Exception", false);
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
			Assert.assertTrue("Exception", false);
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
			
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals("4 NOP instructions", 0x8004, engine.getCurrentPcValue());

		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}

	@Test
	public void testAssemblyMacro3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");	
		strBuilder.append(" 			 ORG         $8000    ; Start of ROM\n");
		strBuilder.append(" 			 .macro Wait5         ; Definition of macro\n");
		strBuilder.append("		    LDA			 #5       ; wait 5   \n");
		strBuilder.append("Wait	    DECA			          ; A=A-1   \n");
		strBuilder.append("	       BNE			 Wait	    ; Test if A=0   \n");
		strBuilder.append("	       .endm\n");
		strBuilder.append("	       NOP                  ; PC=8000  \n");
		strBuilder.append(" 			 Wait5                ; wait : PC=8001\n");
		strBuilder.append(" 			 Wait5                ; wait : PC=8005\n");
		strBuilder.append("	       NOP                  ; PC = 800B\n");
		Model result;
		try {
			result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationTestHelper.assertNoErrors(result);
			
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			Assert.assertEquals(" = x8000 + 1 + (2+1+2) + (2+1+2) +1", 0x800C, engine.getCurrentPcValue());

			// assembled first assembled Macro
			{
				AbstractAssemblyLine macro1 = engine.getAssembledLine().get(4);
				Assert.assertTrue("Check type of object", macro1 instanceof MacroAssembledElement);

				MacroAssembledElement assembledMacro1 = (MacroAssembledElement)macro1;
				AbstractAssemblyLine line0 = assembledMacro1.getAssemblyLines().get(0);
				Assert.assertTrue("Check type of object", line0 instanceof AssembledLDAInstruction);
				AbstractAssemblyLine line1 = assembledMacro1.getAssemblyLines().get(1);
				Assert.assertTrue("Check type of object", line1 instanceof AssembledDECAInstruction);
				AssembledDECAInstruction decaInstruction = (AssembledDECAInstruction) line1;
				Assert.assertEquals("check label", "Wait_1", decaInstruction.getLabel());
				AbstractAssemblyLine line2 = assembledMacro1.getAssemblyLines().get(2);
				Assert.assertTrue("Check type of object", line2 instanceof AssembledBNEInstruction);
				AssembledBNEInstruction bneInstruction = (AssembledBNEInstruction) line2;
			   String operand = ((RelativeMode)(bneInstruction.getInstruction().getOperand())).getOffset().getValue(); 
				Assert.assertEquals("check operand", "Wait_1", operand);
			}	
				
			// assembled second assembled Macro
			{
				AbstractAssemblyLine macro1 = engine.getAssembledLine().get(5);
				Assert.assertTrue("Check type of object", macro1 instanceof MacroAssembledElement);
				MacroAssembledElement assembledMacro1 = (MacroAssembledElement)macro1;
				AbstractAssemblyLine line1 = assembledMacro1.getAssemblyLines().get(1);
				Assert.assertTrue("Check type of object", line1 instanceof AssembledDECAInstruction);
				AssembledDECAInstruction decaInstruction = (AssembledDECAInstruction) line1;
				Assert.assertEquals("check label", "Wait_2", decaInstruction.getLabel());
				AbstractAssemblyLine line2 = assembledMacro1.getAssemblyLines().get(2);
				Assert.assertTrue("Check type of object", line2 instanceof AssembledBNEInstruction);
				AssembledBNEInstruction bneInstruction = (AssembledBNEInstruction) line2;
			   String operand = ((RelativeMode)(bneInstruction.getInstruction().getOperand())).getOffset().getValue(); 
				Assert.assertEquals("check operand", "Wait_2", operand);
			}

		} catch (Exception e) {
			Assert.assertTrue("Exception", false);
		}
	}
}
