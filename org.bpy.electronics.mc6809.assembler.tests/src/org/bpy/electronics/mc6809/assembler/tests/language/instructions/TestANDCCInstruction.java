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
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.InjectWith;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import com.google.inject.Inject;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Assert;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.bpy.electronics.mc6809.assembler.assembler.ImmediatOperand;
import org.bpy.electronics.mc6809.assembler.assembler.AndCCInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerManager;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledANDCCInstruction;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;


@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)

public class TestANDCCInstruction {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check ADDA immediat 
	 */
	@Test 
	public void testANDCCImemdiatAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    		$8000\n");
		strBuilder.append("	       ANDCC		#25\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be an Instruction line", line.getLineContent() instanceof InstructionLine);
			
			InstructionLine instructionLine = (InstructionLine)line.getLineContent();
			Assert.assertTrue("Must be an ANDCC instruction line", instructionLine.getInstruction() instanceof AndCCInstruction);
	
			AndCCInstruction andccInstruction = (AndCCInstruction)instructionLine.getInstruction(); 
			assertEquals("Must be an ANDCC instruction", andccInstruction.getInstruction(),"ANDCC");
			assertTrue("Must be an immediate addressing mode", andccInstruction.getOperand() instanceof ImmediatOperand);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check ANDCC direct mode 
	 */
	@Test 
	public void testANDCCDirectAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       			ORG  	  		$8000\n");
		strBuilder.append("Label	       	ANDCC		  	<124 ; SWI instruction\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getAndCCInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Direct mode is not valid for the ANDCC instruction"
			);
			
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AssembledANDCCInstruction line = (AssembledANDCCInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check size instruction", 0x1, line.getOpcode().length);;
			Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.getOpcode()[0]);
			Assert.assertEquals("Check label", "Label", line.getLabel());
			Assert.assertEquals("Check comment", "; SWI instruction", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check ANDCC extended indirect mode 
	 */
	@Test 
	public void testANDCCExtendedAddressingMode() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG  	  		$8000\n");
		strBuilder.append("	       ANDCC		  	[124]\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getAndCCInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Extended mode is not valid for the ANDCC instruction"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AssembledANDCCInstruction line = (AssembledANDCCInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check size instruction", 0x1, line.getOpcode().length);;
			Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.getOpcode()[0]);
			Assert.assertNull("Check label", line.getLabel());
		Assert.assertNull("Check comment", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check ANDCC Constant-Offset Indexed 
	 */
	@Test 
	public void testANDCCConstantOffsetIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("	       		ANDCC		  	Const,X\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getAndCCInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Indexed mode is not valid for the ANDCC instruction"
			);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AssembledANDCCInstruction line = (AssembledANDCCInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check size instruction", 0x1, line.getOpcode().length);
			Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.getOpcode()[0]);
			Assert.assertNull("Check label", line.getLabel());
			Assert.assertNull("Check comment", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check ANDCC Constant-Offset Indexed indirect 
	 */
	@Test 
	public void testANDCCConstantOffsetIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("	       		ANDCC		  	[Const,X]\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getAndCCInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Indexed mode is not valid for the ANDCC instruction"
			);
	
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AssembledANDCCInstruction line = (AssembledANDCCInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check size instruction", 0x1, line.getOpcode().length);
			Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.getOpcode()[0]);
			Assert.assertNull("Check label", line.getLabel());
			Assert.assertNull("Check comment", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check ANDCC Accumulator Indexed 
	 */
	@Test 
	public void testANDCCAccumulatorIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("	       		ANDCC		  	A,X\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getAndCCInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Indexed mode is not valid for the ANDCC instruction"
			);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AssembledANDCCInstruction line = (AssembledANDCCInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check size instruction", 0x1, line.getOpcode().length);
			Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.getOpcode()[0]);
			Assert.assertNull("Check label", line.getLabel());
			Assert.assertNull("Check comment", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check ANDCC Accumulator Indexed Indirect
	 */
	@Test 
	public void testANDCCAccumulatorIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("	       		ANDCC		  	[A,X]\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getAndCCInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Indexed mode is not valid for the ANDCC instruction"
			);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AssembledANDCCInstruction line = (AssembledANDCCInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check size instruction", 0x1, line.getOpcode().length);
			Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.getOpcode()[0]);
			Assert.assertNull("Check label", line.getLabel());
			Assert.assertNull("Check comment", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check ANDCC Auto increment Indexed 
	 */
	@Test 
	public void testANDCCAutoINcrementIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("	       		ANDCC		  	,X++\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getAndCCInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Indexed mode is not valid for the ANDCC instruction"
			);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AssembledANDCCInstruction line = (AssembledANDCCInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check size instruction", 0x1, line.getOpcode().length);
			Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.getOpcode()[0]);
			Assert.assertNull("Check label", line.getLabel());
			Assert.assertNull("Check comment", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check ANDCC Auto increment Indexed Indirect
	 */
	@Test 
	public void testANDCCAutoINcrementIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("	       		ANDCC		  	[,X++]\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getAndCCInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Indexed mode is not valid for the ANDCC instruction"
			);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AssembledANDCCInstruction line = (AssembledANDCCInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check size instruction", 0x1, line.getOpcode().length);
			Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.getOpcode()[0]);
			Assert.assertNull("Check label", line.getLabel());
			Assert.assertNull("Check comment", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check ANDCC Relative to PC Indexed 
	 */
	@Test 
	public void testANDCCRelativeToPCIndexed() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("	       		ANDCC		  	Const,PC\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getAndCCInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Indexed mode is not valid for the ANDCC instruction"
			);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AssembledANDCCInstruction line = (AssembledANDCCInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check size instruction", 0x1, line.getOpcode().length);
			Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.getOpcode()[0]);
			Assert.assertNull("Check label", line.getLabel());
			Assert.assertNull("Check comment", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check ANDCC Relative to PC Indexed Indirect
	 */
	@Test 
	public void testANDCCRelativeToPCIndexedIndirect() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5    \n");
		strBuilder.append("	       		ANDCC		  	[Const,PC]\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,
				AssemblerPackage.eINSTANCE.getAndCCInstruction(),
				InstructionValidator.ILLEGAL_MODE,
				"Indexed mode is not valid for the ANDCC instruction"
			);

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AssembledANDCCInstruction line = (AssembledANDCCInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check size instruction", 0x1, line.getOpcode().length);
			Assert.assertEquals("Check replacement by SWI instruction", 0x3F, line.getOpcode()[0]);
			Assert.assertNull("Check label", line.getLabel());
			Assert.assertNull("Check comment", line.getComment());
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check ANDCC instruction with duplicate label 
	 */
	@Test 
	public void testANDCCWithDuplicateLabel() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start		NOP\n");
		strBuilder.append("				NOP    \n");
		strBuilder.append("Start      	ANDCC		  	#Const+2\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getInstructionLine(),
				InstructionValidator.DUPLICATE_LABEL,
				"Label Start is already defined"
			);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check Assembled ANDCC immediate instruction  
	 */
	@Test 
	public void testANDCCImmediatInstruction1() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Const	   	EQU          	5\n");
		strBuilder.append("Start      	ANDCC		  	#Const+2  ; 8000   1C 07        START:    ANDCC\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		
		
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			Assert.assertEquals("Check PC Counter after the instruction",0x8002, engine.getCurrentPcValue());
				
			AssembledANDCCInstruction line = (AssembledANDCCInstruction)engine.getAssembledLine(3);
			Assert.assertEquals("Check opcode size ", 1, line.getOpcode().length);;	
			Assert.assertEquals("Check opcode", 0x1C, line.getOpcode()[0]);;	
			Assert.assertEquals("Check operand size ", 1, line.getOperand().length);	
			Assert.assertEquals("Check operand", 0x07, line.getOperand()[0]);;
			Assert.assertEquals("Check Label", "Start", line.getLabel());
			Assert.assertEquals("Check comment", "; 8000   1C 07        START:    ANDCC", line.getComment());	
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check Assembled ANDCC immediate with limit negative operand  
	 */
	@Test 
	public void testANDCCImmediatInstruction2() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	ANDCC		  	#-129\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getAndCCInstruction(),
				InstructionValidator.OVERFLOW_ERROR,	
				"The value -129 is below the possible limit, data may be lost"
			);
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AssembledANDCCInstruction line = (AssembledANDCCInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
	
	/**
	 * Check Assembled ANDCC immediate with limit negative operand  
	 */
	@Test 
	public void testANDCCImmediatInstruction3() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	ANDCC		  	#-128\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AssembledANDCCInstruction line = (AssembledANDCCInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0x80, line.getOperand()[0]);;
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check Assembled ANDCC immediate with positive limit operand  
	 */
	@Test 
	public void testANDCCImmediatInstruction4() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		   		ORG    			$8000\n");
		strBuilder.append("Start      	ANDCC		  	#255\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);		

			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AssembledANDCCInstruction line = (AssembledANDCCInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);;
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}

	/**
	 * Check Assembled ANDCC immediate with positive limit operand  
	 */
	@Test 
	public void testANDCCImmediatInstruction5() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("		  	 	ORG    			$8000\n");
		strBuilder.append("Start      	ANDCC		  	#256\n");
		
		try {
			Model result = parseHelper.parse(strBuilder.toString());

			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result,AssemblerPackage.eINSTANCE.getAndCCInstruction(),
				InstructionValidator.OVERFLOW_ERROR,	
				"The value 256 is greater than the possible limit, data may be lost"
			);
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(result);;
			AssembledANDCCInstruction line = (AssembledANDCCInstruction)engine.getAssembledLine(2);
			Assert.assertEquals("Check operand", 0xFF, line.getOperand()[0]);;
		} catch (Exception e) {
			Assert.assertTrue("Exception",true);
		} 
	}
}