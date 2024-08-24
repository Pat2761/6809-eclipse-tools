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
package org.bpy.electronics.mc6809.assembler.tests.language.instructions;

import org.junit.runner.RunWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.InjectWith;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import com.google.inject.Inject;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.junit.Test;
import org.bpy.electronics.mc6809.assembler.assembler.TfrInstruction;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerManager;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledTFRInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class TestTFRInstruction {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check TFR 8 bits with extra space 
	 */
	@Test 
	public void testSimpleTFRWithExtraSpace1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    	$8000\n");
		strBuilder.append("	       TFR		A,B  \n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an TFR directive line", instructionLine.getInstruction() instanceof TfrInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check TFR 8 bits with extra space 
	 */
	@Test 
	public void testSimpleTFRWithExtraSpace2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    	$8000\n");
		strBuilder.append("	       TFR		CC,DP  \n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an TFR directive line", instructionLine.getInstruction() instanceof TfrInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check TFR 16 bits with extra space 
	 */
	@Test 
	public void testSimpleTFRWithExtraSpace3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    	$8000\n");
		strBuilder.append("	       TFR		U,S  \n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an TFR directive line", instructionLine.getInstruction() instanceof TfrInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR 16 bits with extra space 
	 */
	@Test 
	public void testSimpleTFRWithExtraSpace4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    	$8000\n");
		strBuilder.append("	       TFR		X,Y  \n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an TFR directive line", instructionLine.getInstruction() instanceof TfrInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR 16 bits with extra space 
	 */
	@Test 
	public void testSimpleTFRWithExtraSpace5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    	$8000\n");
		strBuilder.append("	       TFR		X,PC  \n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an TFR directive line", instructionLine.getInstruction() instanceof TfrInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR A,A 
	 */
	@Test 
	public void testSimpleTFRResultAA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    	$8000\n");
		strBuilder.append("ExgText	   TFR		A,A  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register A with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals(	"Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR A,B 
	 */
	@Test 
	public void testSimpleTFRResultAB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		A,B  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR A,D 
	 */
	@Test 
	public void testSimpleTFRResultAD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		A,D  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register A with a part of itself is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR A,CC 
	 */
	@Test 
	public void testSimpleTFRResultACC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		A,CC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x8A, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR A,DP 
	 */
	@Test 
	public void testSimpleTFRResultADP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		A,DP  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x8B, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR A,X 
	 */
	@Test 
	public void testSimpleTFRResultAX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		A,X  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register A with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x81, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR A,Y 
	 */
	@Test 
	public void testSimpleTFRResultAY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		A,Y  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register A with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x82, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR A,S 
	 */
	@Test 
	public void testSimpleTFRResultAS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		A,S  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register A with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x84, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR A,U 
	 */
	@Test 
	public void testSimpleTFRResultAU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		A,U  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register A with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x83, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR A,PC 
	 */
	@Test 
	public void testSimpleTFRResultAPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		A,PC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register A with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x85, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR B,A 
	 */
	@Test 
	public void testSimpleTFRResultBA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		B,A  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR A,B 
	 */
	@Test 
	public void testSimpleTFRResultBB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		B,B  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register B with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR B,D 
	 */
	@Test 
	public void testSimpleTFRResultBD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		B,D  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register B with a part of itself is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x90, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR B,CC 
	 */
	@Test 
	public void testSimpleTFRResultBCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		B,CC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x9A, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR A,DP 
	 */
	@Test 
	public void testSimpleTFRResultBDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		B,DP  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x9B, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR B,X 
	 */
	@Test 
	public void testSimpleTFRResultBX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		B,X  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register B with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x91, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR B,Y 
	 */
	@Test 
	public void testSimpleTFRResultBY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		B,Y  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register B with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x92, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR B,S 
	 */
	@Test 
	public void testSimpleTFRResultBS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		B,S  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register B with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x94, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR B,U 
	 */
	@Test 
	public void testSimpleTFRResultBU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		B,U  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register B with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x93, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR B,PC 
	 */
	@Test 
	public void testSimpleTFRResultBPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		B,PC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register B with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x95, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR CC,A 
	 */
	@Test 
	public void testSimpleTFRResultCCA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		CC,A  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR CC,B 
	 */
	@Test 
	public void testSimpleTFRResultCCB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		CC,B  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR CC,D 
	 */
	@Test 
	public void testSimpleTFRResultCCD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		CC,D  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register CC with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xA0, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR CC,CC 
	 */
	@Test 
	public void testSimpleTFRResultCCCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		CC,CC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register CC with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xAA, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR CC,DP 
	 */
	@Test 
	public void testSimpleTFRResultCCDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		CC,DP  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xAB, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR CC,X 
	 */
	@Test 
	public void testSimpleTFRResultCCX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		CC,X  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register CC with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xA1, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR CC,Y 
	 */
	@Test 
	public void testSimpleTFRResultCCY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		CC,Y  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register CC with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xA2, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR CC,S 
	 */
	@Test 
	public void testSimpleTFRResultCCS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		CC,S  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register CC with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xA4, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR CC,U 
	 */
	@Test 
	public void testSimpleTFRResultCCU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		CC,U  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register CC with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xA3, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR CC,PC 
	 */
	@Test 
	public void testSimpleTFRResultCCPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		CC,PC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
	
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register CC with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xA5, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}


	/**
	 * Check TFR DP,A 
	 */
	@Test 
	public void testSimpleTFRResultDPA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		DP,A  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR DP,B 
	 */
	@Test 
	public void testSimpleTFRResultDPB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		DP,B  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR DP,D 
	 */
	@Test 
	public void testSimpleTFRResultDPD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		DP,D  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register DP with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xB0, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR DP,CC 
	 */
	@Test 
	public void testSimpleTFRResultDPCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		DP,CC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xBA, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR DP,DP 
	 */
	@Test 
	public void testSimpleTFRResultDPDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		DP,DP  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register DP with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xBB, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR DP,X 
	 */
	@Test 
	public void testSimpleTFRResultDPX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		DP,X  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register DP with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xB1, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR DP,Y 
	 */
	@Test 
	public void testSimpleTFRResultDPY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		DP,Y  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register DP with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xB2, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR DP,S 
	 */
	@Test 
	public void testSimpleTFRResultDPS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		DP,S  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register DP with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xB4, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR DP,U 
	 */
	@Test 
	public void testSimpleTFRResultDPU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		DP,U  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register DP with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xB3, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR DP,PC 
	 */
	@Test 
	public void testSimpleTFRResultDPPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		DP,PC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register DP with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xB5, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR D,A 
	 */
	@Test 
	public void testSimpleTFRResultDA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		D,A  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register D with a part of itself is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x08, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR D,B 
	 */
	@Test 
	public void testSimpleTFRResultDB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		D,B  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register D with a part of itself is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x09, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR D,D 
	 */
	@Test 
	public void testSimpleTFRResultDD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		D,D  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register D with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x00, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR D,CC 
	 */
	@Test 
	public void testSimpleTFRResultDCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		D,CC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register D with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x0A, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR D,DP 
	 */
	@Test 
	public void testSimpleTFRResultDDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		D,DP  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register D with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x0B, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR D,X 
	 */
	@Test 
	public void testSimpleTFRResultDX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		D,X  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x01, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR D,Y 
	 */
	@Test 
	public void testSimpleTFRResultDY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		D,Y  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x02, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR D,S 
	 */
	@Test 
	public void testSimpleTFRResultDS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		D,S  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x04, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR D,U 
	 */
	@Test 
	public void testSimpleTFRResultDU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		D,U  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x03, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR D,PC 
	 */
	@Test 
	public void testSimpleTFRResultDPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		D,PC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x05, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR X,A 
	 */
	@Test 
	public void testSimpleTFRResultXA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		X,A  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register X with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x18, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR X,B 
	 */
	@Test 
	public void testSimpleTFRResultXB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		X,B  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register X with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x19, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR X,D 
	 */
	@Test 
	public void testSimpleTFRResultXD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		X,D  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x10, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR X,CC 
	 */
	@Test 
	public void testSimpleTFRResultXCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		X,CC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register X with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x1A, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR X,DP 
	 */
	@Test 
	public void testSimpleTFRResultXDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		X,DP  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register X with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x1B, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR X,X 
	 */
	@Test 
	public void testSimpleTFRResultXX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		X,X  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register X with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x11, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR X,Y 
	 */
	@Test 
	public void testSimpleTFRResultXY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		X,Y  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x12, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR X,S 
	 */
	@Test 
	public void testSimpleTFRResultXS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		X,S  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x14, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR X,U 
	 */
	@Test 
	public void testSimpleTFRResultXU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		X,U  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x13, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR X,PC 
	 */
	@Test 
	public void testSimpleTFRResultXPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		X,PC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x15, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR Y,A 
	 */
	@Test 
	public void testSimpleTFRResultYA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		Y,A  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register Y with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x28, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR Y,B 
	 */
	@Test 
	public void testSimpleTFRResultYB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		Y,B  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register Y with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x29, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR Y,D 
	 */
	@Test 
	public void testSimpleTFRResultYD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		Y,D  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x20, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR Y,CC 
	 */
	@Test 
	public void testSimpleTFRResultYCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		Y,CC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register Y with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x2A, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR Y,DP 
	 */
	@Test 
	public void testSimpleTFRResultYDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		Y,DP  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register Y with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x2B, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR Y,X 
	 */
	@Test 
	public void testSimpleTFRResultYX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		Y,X  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x21, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR Y,Y 
	 */
	@Test 
	public void testSimpleTFRResultYY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		Y,Y  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register Y with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x22, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR Y,S 
	 */
	@Test 
	public void testSimpleTFRResultYS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		Y,S  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x24, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR X,U 
	 */
	@Test 
	public void testSimpleTFRResultYU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		Y,U  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x23, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR Y,PC 
	 */
	@Test 
	public void testSimpleTFRResultYPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		Y,PC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x25, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR U,A 
	 */
	@Test 
	public void testSimpleTFRResultUA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		U,A  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register U with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x38, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR U,B 
	 */
	@Test 
	public void testSimpleTFRResultUB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		U,B  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register U with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x39, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR U,D 
	 */
	@Test 
	public void testSimpleTFRResultUD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		U,D  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x30, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR U,CC 
	 */
	@Test 
	public void testSimpleTFRResultUCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		U,CC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register U with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x3A, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR U,DP 
	 */
	@Test 
	public void testSimpleTFRResultUDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		U,DP  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register U with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x3B, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR U,X 
	 */
	@Test 
	public void testSimpleTFRResultUX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		U,X  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x31, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR U,Y 
	 */
	@Test 
	public void testSimpleTFRResultUY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		U,Y  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x32, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR U,S 
	 */
	@Test 
	public void testSimpleTFRResultUS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		U,S  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x34, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR U,U 
	 */
	@Test 
	public void testSimpleTFRResultUU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		U,U  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register U with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x33, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR U,PC 
	 */
	@Test 
	public void testSimpleTFRResultUPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		U,PC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x35, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR S,A 
	 */
	@Test 
	public void testSimpleTFRResultSA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		S,A  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register S with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x48, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR S,B 
	 */
	@Test 
	public void testSimpleTFRResultSB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		S,B  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register S with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x49, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR S,D 
	 */
	@Test 
	public void testSimpleTFRResultSD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		S,D  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x40, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR S,CC 
	 */
	@Test 
	public void testSimpleTFRResultSCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		S,CC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register S with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x4A, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR S,DP 
	 */
	@Test 
	public void testSimpleTFRResultSDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		S,DP  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register S with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x4B, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR S,X 
	 */
	@Test 
	public void testSimpleTFRResultSX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		S,X  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x41, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR S,Y 
	 */
	@Test 
	public void testSimpleTFRResultSY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		S,Y  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x42, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR S,S 
	 */
	@Test 
	public void testSimpleTFRResultSS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		S,S  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register S with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x44, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR S,U 
	 */
	@Test 
	public void testSimpleTFRResultSU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		S,U  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x43, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR S,PC 
	 */
	@Test 
	public void testSimpleTFRResultSPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		S,PC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x45, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR PC,A 
	 */
	@Test 
	public void testSimpleTFRResultPCA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		PC,A  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register PC with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x58, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR PC,B 
	 */
	@Test 
	public void testSimpleTFRResultPCB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		PC,B  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register PC with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x59, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR PC,D 
	 */
	@Test 
	public void testSimpleTFRResultPCD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		PC,D  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x50, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR PC,CC 
	 */
	@Test 
	public void testSimpleTFRResultPCCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		PC,CC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register PC with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x5A, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR PC,DP 
	 */
	@Test 
	public void testSimpleTFRResultPCDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		PC,DP  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register PC with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x5B, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR PC,X 
	 */
	@Test 
	public void testSimpleTFRResultPCX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		PC,X  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x51, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR PC,Y 
	 */
	@Test 
	public void testSimpleTFRResultPCY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		PC,Y  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x52, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR PC,S 
	 */
	@Test 
	public void testSimpleTFRResultPCS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		PC,S  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x54, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR PC,U 
	 */
	@Test 
	public void testSimpleTFRResultPCU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		PC,U  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x53, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check TFR PC,PC 
	 */
	@Test 
	public void testSimpleTFRResultPCPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	TFR		PC,PC  ; test TFR\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getTfrInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register PC with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result, false);
			AssembledTFRInstruction line = (AssembledTFRInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1F, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x55, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel()); 	
			Assert.assertEquals("Check comment", "; test TFR", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
}