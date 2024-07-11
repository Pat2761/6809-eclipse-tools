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
import org.bpy.electronics.mc6809.assembler.assembler.ExgInstruction;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledEXGInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class TestEXGInstruction {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check EXG 8 bits with extra space 
	 */
	@Test 
	public void testSimpleEXGWithExtraSpace1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    	$8000\n");
		strBuilder.append("	       EXG		A,B  \n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an EXG directive line", instructionLine.getInstruction() instanceof ExgInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check EXG 8 bits with extra space 
	 */
	@Test 
	public void testSimpleEXGWithExtraSpace2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    	$8000\n");
		strBuilder.append("	       EXG		CC,DP  \n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an EXG directive line", instructionLine.getInstruction() instanceof ExgInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check EXG 16 bits with extra space 
	 */
	@Test 
	public void testSimpleEXGWithExtraSpace3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    	$8000\n");
		strBuilder.append("	       EXG		U,S  \n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an EXG directive line", instructionLine.getInstruction() instanceof ExgInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG 16 bits with extra space 
	 */
	@Test 
	public void testSimpleEXGWithExtraSpace4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    	$8000\n");
		strBuilder.append("	       EXG		X,Y  \n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an EXG directive line", instructionLine.getInstruction() instanceof ExgInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG 16 bits with extra space 
	 */
	@Test 
	public void testSimpleEXGWithExtraSpace5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    	$8000\n");
		strBuilder.append("	       EXG		X,PC  \n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an EXG directive line", instructionLine.getInstruction() instanceof ExgInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG A,A 
	 */
	@Test 
	public void testSimpleEXGResultAA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       	ORG    	$8000\n");
		strBuilder.append("ExgText	   EXG		A,A  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register A with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x88, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG A,B 
	 */
	@Test 
	public void testSimpleEXGResultAB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		A,B  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x89, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG A,D 
	 */
	@Test 
	public void testSimpleEXGResultAD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		A,D  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register A with a part of itself is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x80, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG A,CC 
	 */
	@Test 
	public void testSimpleEXGResultACC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		A,CC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x8A, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG A,DP 
	 */
	@Test 
	public void testSimpleEXGResultADP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		A,DP  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x8B, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG A,X 
	 */
	@Test 
	public void testSimpleEXGResultAX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		A,X  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register A with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x81, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG A,Y 
	 */
	@Test 
	public void testSimpleEXGResultAY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		A,Y  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register A with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x82, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG A,S 
	 */
	@Test 
	public void testSimpleEXGResultAS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		A,S  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register A with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x84, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG A,U 
	 */
	@Test 
	public void testSimpleEXGResultAU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		A,U  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register A with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x83, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG A,PC 
	 */
	@Test 
	public void testSimpleEXGResultAPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		A,PC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register A with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x85, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG B,A 
	 */
	@Test 
	public void testSimpleEXGResultBA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		B,A  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x98, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG A,B 
	 */
	@Test 
	public void testSimpleEXGResultBB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		B,B  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register B with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x99, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG B,D 
	 */
	@Test 
	public void testSimpleEXGResultBD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		B,D  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register B with a part of itself is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x90, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG B,CC 
	 */
	@Test 
	public void testSimpleEXGResultBCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		B,CC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x9A, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG A,DP 
	 */
	@Test 
	public void testSimpleEXGResultBDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		B,DP  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x9B, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG B,X 
	 */
	@Test 
	public void testSimpleEXGResultBX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		B,X  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register B with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x91, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG B,Y 
	 */
	@Test 
	public void testSimpleEXGResultBY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		B,Y  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register B with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x92, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG B,S 
	 */
	@Test 
	public void testSimpleEXGResultBS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		B,S  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register B with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x94, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG B,U 
	 */
	@Test 
	public void testSimpleEXGResultBU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		B,U  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register B with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x93, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG B,PC 
	 */
	@Test 
	public void testSimpleEXGResultBPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		B,PC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register B with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x95, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG CC,A 
	 */
	@Test 
	public void testSimpleEXGResultCCA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		CC,A  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xA8, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG CC,B 
	 */
	@Test 
	public void testSimpleEXGResultCCB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		CC,B  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xA9, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG CC,D 
	 */
	@Test 
	public void testSimpleEXGResultCCD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		CC,D  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register CC with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xA0, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG CC,CC 
	 */
	@Test 
	public void testSimpleEXGResultCCCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		CC,CC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register CC with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xAA, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG CC,DP 
	 */
	@Test 
	public void testSimpleEXGResultCCDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		CC,DP  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xAB, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG CC,X 
	 */
	@Test 
	public void testSimpleEXGResultCCX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		CC,X  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register CC with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xA1, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG CC,Y 
	 */
	@Test 
	public void testSimpleEXGResultCCY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		CC,Y  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register CC with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xA2, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG CC,S 
	 */
	@Test 
	public void testSimpleEXGResultCCS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		CC,S  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register CC with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xA4, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG CC,U 
	 */
	@Test 
	public void testSimpleEXGResultCCU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		CC,U  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register CC with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xA3, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG CC,PC 
	 */
	@Test 
	public void testSimpleEXGResultCCPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		CC,PC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
	
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register CC with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xA5, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}


	/**
	 * Check EXG DP,A 
	 */
	@Test 
	public void testSimpleEXGResultDPA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		DP,A  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xB8, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG DP,B 
	 */
	@Test 
	public void testSimpleEXGResultDPB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		DP,B  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xB9, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG DP,D 
	 */
	@Test 
	public void testSimpleEXGResultDPD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		DP,D  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());

			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register DP with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xB0, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG DP,CC 
	 */
	@Test 
	public void testSimpleEXGResultDPCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		DP,CC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xBA, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG DP,DP 
	 */
	@Test 
	public void testSimpleEXGResultDPDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		DP,DP  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register DP with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xBB, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG DP,X 
	 */
	@Test 
	public void testSimpleEXGResultDPX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		DP,X  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register DP with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xB1, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG DP,Y 
	 */
	@Test 
	public void testSimpleEXGResultDPY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		DP,Y  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register DP with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xB2, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG DP,S 
	 */
	@Test 
	public void testSimpleEXGResultDPS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		DP,S  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register DP with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xB4, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG DP,U 
	 */
	@Test 
	public void testSimpleEXGResultDPU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		DP,U  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register DP with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xB3, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG DP,PC 
	 */
	@Test 
	public void testSimpleEXGResultDPPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		DP,PC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register DP with a 16 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0xB5, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG D,A 
	 */
	@Test 
	public void testSimpleEXGResultDA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		D,A  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register D with a part of itself is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x08, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG D,B 
	 */
	@Test 
	public void testSimpleEXGResultDB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		D,B  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register D with a part of itself is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x09, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG D,D 
	 */
	@Test 
	public void testSimpleEXGResultDD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		D,D  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register D with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x00, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG D,CC 
	 */
	@Test 
	public void testSimpleEXGResultDCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		D,CC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register D with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x0A, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG D,DP 
	 */
	@Test 
	public void testSimpleEXGResultDDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		D,DP  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register D with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x0B, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG D,X 
	 */
	@Test 
	public void testSimpleEXGResultDX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		D,X  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x01, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG D,Y 
	 */
	@Test 
	public void testSimpleEXGResultDY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		D,Y  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x02, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG D,S 
	 */
	@Test 
	public void testSimpleEXGResultDS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		D,S  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x04, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG D,U 
	 */
	@Test 
	public void testSimpleEXGResultDU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		D,U  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x03, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG D,PC 
	 */
	@Test 
	public void testSimpleEXGResultDPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		D,PC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x05, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG X,A 
	 */
	@Test 
	public void testSimpleEXGResultXA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		X,A  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register X with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x18, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG X,B 
	 */
	@Test 
	public void testSimpleEXGResultXB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		X,B  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register X with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x19, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG X,D 
	 */
	@Test 
	public void testSimpleEXGResultXD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		X,D  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x10, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG X,CC 
	 */
	@Test 
	public void testSimpleEXGResultXCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		X,CC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register X with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x1A, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG X,DP 
	 */
	@Test 
	public void testSimpleEXGResultXDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		X,DP  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register X with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x1B, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG X,X 
	 */
	@Test 
	public void testSimpleEXGResultXX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		X,X  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register X with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x11, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG X,Y 
	 */
	@Test 
	public void testSimpleEXGResultXY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		X,Y  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x12, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG X,S 
	 */
	@Test 
	public void testSimpleEXGResultXS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		X,S  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x14, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG X,U 
	 */
	@Test 
	public void testSimpleEXGResultXU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		X,U  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x13, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG X,PC 
	 */
	@Test 
	public void testSimpleEXGResultXPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		X,PC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x15, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG Y,A 
	 */
	@Test 
	public void testSimpleEXGResultYA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		Y,A  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register Y with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x28, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG Y,B 
	 */
	@Test 
	public void testSimpleEXGResultYB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		Y,B  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register Y with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x29, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG Y,D 
	 */
	@Test 
	public void testSimpleEXGResultYD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		Y,D  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x20, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG Y,CC 
	 */
	@Test 
	public void testSimpleEXGResultYCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		Y,CC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register Y with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x2A, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG Y,DP 
	 */
	@Test 
	public void testSimpleEXGResultYDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		Y,DP  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register Y with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x2B, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG Y,X 
	 */
	@Test 
	public void testSimpleEXGResultYX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		Y,X  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x21, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG Y,Y 
	 */
	@Test 
	public void testSimpleEXGResultYY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		Y,Y  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register Y with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x22, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG Y,S 
	 */
	@Test 
	public void testSimpleEXGResultYS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		Y,S  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x24, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG X,U 
	 */
	@Test 
	public void testSimpleEXGResultYU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		Y,U  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x23, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG Y,PC 
	 */
	@Test 
	public void testSimpleEXGResultYPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		Y,PC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x25, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG U,A 
	 */
	@Test 
	public void testSimpleEXGResultUA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		U,A  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register U with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x38, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG U,B 
	 */
	@Test 
	public void testSimpleEXGResultUB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		U,B  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register U with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x39, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG U,D 
	 */
	@Test 
	public void testSimpleEXGResultUD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		U,D  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x30, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG U,CC 
	 */
	@Test 
	public void testSimpleEXGResultUCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		U,CC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register U with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x3A, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG U,DP 
	 */
	@Test 
	public void testSimpleEXGResultUDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		U,DP  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register U with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x3B, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG U,X 
	 */
	@Test 
	public void testSimpleEXGResultUX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		U,X  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x31, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG U,Y 
	 */
	@Test 
	public void testSimpleEXGResultUY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		U,Y  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x32, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG U,S 
	 */
	@Test 
	public void testSimpleEXGResultUS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		U,S  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x34, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG U,U 
	 */
	@Test 
	public void testSimpleEXGResultUU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		U,U  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register U with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x33, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG U,PC 
	 */
	@Test 
	public void testSimpleEXGResultUPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		U,PC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x35, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG S,A 
	 */
	@Test 
	public void testSimpleEXGResultSA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		S,A  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register S with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x48, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG S,B 
	 */
	@Test 
	public void testSimpleEXGResultSB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		S,B  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register S with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x49, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG S,D 
	 */
	@Test 
	public void testSimpleEXGResultSD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		S,D  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x40, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG S,CC 
	 */
	@Test 
	public void testSimpleEXGResultSCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		S,CC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register S with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x4A, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG S,DP 
	 */
	@Test 
	public void testSimpleEXGResultSDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		S,DP  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register S with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x4B, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG S,X 
	 */
	@Test 
	public void testSimpleEXGResultSX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		S,X  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x41, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG S,Y 
	 */
	@Test 
	public void testSimpleEXGResultSY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		S,Y  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x42, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG S,S 
	 */
	@Test 
	public void testSimpleEXGResultSS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		S,S  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register S with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x44, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG S,U 
	 */
	@Test 
	public void testSimpleEXGResultSU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		S,U  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x43, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG S,PC 
	 */
	@Test 
	public void testSimpleEXGResultSPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		S,PC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x45, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG PC,A 
	 */
	@Test 
	public void testSimpleEXGResultPCA() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		PC,A  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register PC with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x58, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG PC,B 
	 */
	@Test 
	public void testSimpleEXGResultPCB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		PC,B  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register PC with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x59, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG PC,D 
	 */
	@Test 
	public void testSimpleEXGResultPCD() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		PC,D  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x50, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG PC,CC 
	 */
	@Test 
	public void testSimpleEXGResultPCCC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		PC,CC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register PC with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x5A, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG PC,DP 
	 */
	@Test 
	public void testSimpleEXGResultPCDP() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		PC,DP  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register PC with a 8 bits register is suspicious"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x5B, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG PC,X 
	 */
	@Test 
	public void testSimpleEXGResultPCX() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		PC,X  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x51, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG PC,Y 
	 */
	@Test 
	public void testSimpleEXGResultPCY() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		PC,Y  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x52, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG PC,S 
	 */
	@Test 
	public void testSimpleEXGResultPCS() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		PC,S  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x54, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG PC,U 
	 */
	@Test 
	public void testSimpleEXGResultPCU() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		PC,U  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x53, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel());
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check EXG PC,PC 
	 */
	@Test 
	public void testSimpleEXGResultPCPC() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		       	ORG    	$8000\n");
		strBuilder.append("ExgText	   	EXG		PC,PC  ; test EXG\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertWarning(result,
				AssemblerPackage.eINSTANCE.getExgInstruction(),
				InstructionValidator.ILLEGAL_EXCHANGE,
				"Exchanging the register PC with itself has no effect"
			);
	
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledEXGInstruction line = (AssembledEXGInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x1E, line.getOpcode()[0]);
			Assert.assertEquals("Operand length", 1, line.getOperand().length);
			Assert.assertEquals("Check opcode", 0x55, line.getOperand()[0]);
			Assert.assertEquals("Check label", "ExgText", line.getLabel()); 	
			Assert.assertEquals("Check comment", "; test EXG", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
}