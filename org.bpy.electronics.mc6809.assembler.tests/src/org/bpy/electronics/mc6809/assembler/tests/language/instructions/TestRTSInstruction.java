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
 * MERCHANTABILITY or FITNESS FOR A PARTSCULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.bpy.electronics.mc6809.assembler.tests.language.instructions;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.RtsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledRTSInstruction;
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

public class TestRTSInstruction {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check RTS with extra space
	 */
	@Test 
	public void testSimpleRTSWithExtraSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       RTS  \n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an RTS Accumulator line", instructionLine.getInstruction() instanceof RtsInstruction);
			RtsInstruction rtsInstruction = (RtsInstruction)instructionLine.getInstruction();
			Assert.assertEquals("Must be an RTS instruction", "RTS", rtsInstruction.getInstruction());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check RTS with extra space
	 */
	@Test 
	public void testSimpleRTSWithoutExtraSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("	       RTS\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an RTS Accumulator line", instructionLine.getInstruction() instanceof RtsInstruction);
			RtsInstruction rtsInstruction = (RtsInstruction)instructionLine.getInstruction();
			Assert.assertEquals("Must be an RTS instruction", "RTS", rtsInstruction.getInstruction());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check RTS with extra space
	 */
	@Test 
	public void testSimpleRTSWithExtraSpaceWithComment() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    	$8000\n");
		strBuilder.append("	       RTS  			; It is a comment \n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an RTS Accumulator line", instructionLine.getInstruction() instanceof RtsInstruction);
			RtsInstruction rtsInstruction = (RtsInstruction)instructionLine.getInstruction();
			Assert.assertEquals("Must be an RTS instruction", "RTS", rtsInstruction.getInstruction());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check RTS with extra space
	 */
	@Test 
	public void testSimpleRTSWithoutExtraSpaceWithComment() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("	       RTS					; It is a comment\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
		
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an RTS Accumulator line", instructionLine.getInstruction() instanceof RtsInstruction);
			RtsInstruction rtsInstruction = (RtsInstruction)instructionLine.getInstruction();
			Assert.assertEquals("Must be an RTS instruction", "RTS", rtsInstruction.getInstruction());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}	
	
	/**
	 * Check RTS instruction with duplicate label 
	 */
	@Test 
	public void testRTSWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   	   ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start		   NOP\n");
		strBuilder.append("			      NOP    \n");
		strBuilder.append("Start      	RTS		  	\n");
		
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
	 * Check RTS assembly instruction  
	 */
	@Test 
	public void testRTSAssembly() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	RTS		  		    ; 39   RTS\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("Check PC Counter after instruction", 0x8001, engine.getCurrentPcValue());
			AssembledRTSInstruction line = (AssembledRTSInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check opcode length", 1, line.getOpcode().length);
			Assert.assertEquals("Check opcode", 0x39, line.getOpcode()[0]);
			Assert.assertEquals("Check operand length", 0, line.getOperand().length);
			Assert.assertEquals("Check label", "Start" , line.getLabel());
			Assert.assertEquals("Check comment", "; 39   RTS" , line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
}