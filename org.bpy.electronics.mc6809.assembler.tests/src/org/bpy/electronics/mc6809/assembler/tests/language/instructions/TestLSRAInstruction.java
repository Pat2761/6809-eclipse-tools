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

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.LsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLSRAInstruction;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
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

public class TestLSRAInstruction {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check LSRA with extra space
	 */
	@Test 
	public void testSimpleLSRAWithExtraSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       LSRA  \n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an INC Accumulator line", instructionLine.getInstruction() instanceof LsrInstruction);
			LsrInstruction lsrInstruction = (LsrInstruction)instructionLine.getInstruction();
			Assert.assertEquals("Must be an LSRA instruction", "LSRA", lsrInstruction.getInstruction());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check LSRA with extra space
	 */
	@Test 
	public void testSimpleLSRAWithoutExtraSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("	       LSRA\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an INC Accumulator line", instructionLine.getInstruction() instanceof LsrInstruction);
			LsrInstruction lsrInstruction = (LsrInstruction)instructionLine.getInstruction();
			Assert.assertEquals("Must be an LSRA instruction", "LSRA", lsrInstruction.getInstruction());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check LSRA with extra space
	 */
	@Test 
	public void testSimpleLSRAWithExtraSpaceWithComment() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    	$8000\n");
		strBuilder.append("	       LSRA  			; It is a comment \n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an INC Accumulator line", instructionLine.getInstruction() instanceof LsrInstruction);
			LsrInstruction lsrInstruction = (LsrInstruction)instructionLine.getInstruction();
			Assert.assertEquals("Must be an LSRA instruction", "LSRA", lsrInstruction.getInstruction());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check LSRA with extra space
	 */
	@Test 
	public void testSimpleLSRAWithoutExtraSpaceWithComment() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("	       LSRA					; It is a comment\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
		
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an INC Accumulator line", instructionLine.getInstruction() instanceof LsrInstruction);
			LsrInstruction lsrInstruction = (LsrInstruction)instructionLine.getInstruction();
			Assert.assertEquals("Must be an LSRA instruction", "LSRA", lsrInstruction.getInstruction());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check LSRA instruction with duplicate label 
	 */
	@Test 
	public void testLSRAWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   	   ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start		   NOP\n");
		strBuilder.append("			      NOP    \n");
		strBuilder.append("Start      	LSRA		  	\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getInstructionLine(),
				AssemblerEngine.DUPLICATE_LABEL,"Label Start is already defined");
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check LSRA assembly instruction  
	 */
	@Test 
	public void testLSRAAssembly() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	LSRA		  		    ; 44   LSRA\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after instruction", 0x8001, engine.getCurrentPcValue());
			AssembledLSRAInstruction line = (AssembledLSRAInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x44, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 0, line.getOperand().length);
			Assert.assertEquals("Check label", "Start" , line.getLabel());
			Assert.assertEquals("Check comment", "; 44   LSRA" , line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
}