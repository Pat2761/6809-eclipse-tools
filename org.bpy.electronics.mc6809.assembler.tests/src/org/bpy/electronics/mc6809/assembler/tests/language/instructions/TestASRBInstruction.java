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
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;

import com.google.inject.Inject;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.junit.Test;
import org.bpy.electronics.mc6809.assembler.assembler.AsrInstruction;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerManager;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledASRBInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class TestASRBInstruction {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationTestHelper;
	
	/**
	 * Check ASRB with extra space
	 */
	@Test 
	public void testSimpleASRBWithExtraSpace() {
		
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("	       ASRB \n"); 
		Model result;
		try {
			result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			
		   SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an ASRB directive line", instructionLine.getInstruction() instanceof AsrInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check ASRB with extra space
	 */
	@Test 
	public void testSimpleASRBWithoutExtraSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("	       ASRB\n"); 
		Model result;
		try {
			result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			
		   SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an ASRB directive line", instructionLine.getInstruction() instanceof AsrInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check ASRB with extra space
	 */
	@Test 
	public void testSimpleASRBWithExtraSpaceWithComment() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ASRB  			; It is a comment\n");
		strBuilder.append("	       ASRB\n"); 
		Model result;
		try {
			result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			
		   SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an ASRB directive line", instructionLine.getInstruction() instanceof AsrInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check ASRB with extra space
	 */
	@Test 
	public void testSimpleASRBWithoutExtraSpaceWithComment() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("	       ASRB					; It is a comment\n"); 
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		
		   SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an ASRB directive line", instructionLine.getInstruction() instanceof AsrInstruction);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
		
	/**
	 * Check ASRB instruction with duplicate label 
	 */
	@Test 
	public void testASLBWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   	ORG    			$8000\n");
		strBuilder.append("Const	   EQU          	5\n");
		strBuilder.append("Start		NOP\n");
		strBuilder.append("			   NOP    \n");
		strBuilder.append("Start      ASRB		  	\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
		    validationTestHelper.assertError(result, 
		    		AssemblerPackage.eINSTANCE.getInstructionLine(), 
		    		InstructionValidator.DUPLICATE_LABEL, 
		    		"Label Start is already defined");
		    	 
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check Assembled ASRB
	 */
	@Test 
	public void testAssembledASRB() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	      	ORG    $8000\n");
		strBuilder.append("LabelAsrb	ASRB					; Asrb comment\n");
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			validationTestHelper.assertNoErrors(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			
			Assert.assertEquals("Check PC after instruction", 0x8001, engine.getCurrentPcValue());
			
			AssembledASRBInstruction line = (AssembledASRBInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check label", "LabelAsrb" , line.getLabel());
			Assert.assertEquals("Check comment", "; Asrb comment" , line.getComment());
			Assert.assertEquals("Check lineNumber", 3 , line.getLineNumber());
			Assert.assertEquals("Check cycle number", 3 , line.getCyclesNumber());
			
			int[] code = line.getOpcode();
			int[] operand = line.getOperand();
			
			Assert.assertEquals("Check Opcode size",1,code.length);
			Assert.assertEquals("Check Opcode code",0x57,code[0]);
			Assert.assertEquals("Check Operand size",0,operand.length);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
}