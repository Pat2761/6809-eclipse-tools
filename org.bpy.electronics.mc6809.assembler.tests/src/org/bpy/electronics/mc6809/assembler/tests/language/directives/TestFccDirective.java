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

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.FccDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFccDirectiveLine;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.assembler.validation.DirectiveValidator;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
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

public class TestFccDirective {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check Fcc directive without comment
	 */
	@Test 
	public void testFccWithoutCommentWithSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	 	      ORG    	$8000\n");
		strBuilder.append(" 		  FCC		\"Erreur AA115\"    \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an FCC directive line", directiveLine.getDirective() instanceof FccDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Fcc directive without comment
	 */
	@Test 
	public void testFccWithOverflow() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	 	      ORG    	$8000\n");
		strBuilder.append(" 		  		FCC		\"Erreur AA115\",$256    \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
			validationHelper.assertWarning(result, AssemblerPackage.eINSTANCE.getFccDirective(), InstructionValidator.OVERFLOW_ERROR,
					"Overflow error, Data may be lost");
		
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check Fcc directive without comment
	 */
	@Test 
	public void testFccWithoutCommentWithoutSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    	$8000\n");
		strBuilder.append("MyFcc	   	FCC		\"Erreur AA115\"\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
		SourceLine line = result.getSourceLines().get(2);
		Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
		
		DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
		Assert.assertTrue("Must be an FCC directive line", directiveLine.getDirective() instanceof FccDirective);
	} catch (Exception e) {
		Assert.assertTrue("Exception detected", true);
	}
	}


	/**
	 * Check Fcc directive with comment
	 */
	@Test 
	public void testFccWithCommentWithoutSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    	$8000\n");
		strBuilder.append("MyFcc	   	FCC		\"Erreur AA115\"         ; erreur definition\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an FCC directive line", directiveLine.getDirective() instanceof FccDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check FCC directive with duplicate Label
	 */
	@Test 
	public void testFCBWithDuplicateLabels() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("	         	ORG    $8000\n");
		strBuilder.append("Label1	    BSZ	10    \n");
		strBuilder.append("Label1       FCC    \"Erreur AA115\" \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertError(result, AssemblerPackage.eINSTANCE.getDirectiveLine(),
				AssemblerEngine.DUPLICATE_LABEL,
				"Label Label1 is already defined"
			);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check FDB directive without duplicate Label
	 */
	@Test 
	public void testFCCAssemblyResult() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("	        		ORG    	$8000\n");
		strBuilder.append("Label1       	FCC    	\"Erreur AA115\" 		; error message\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledFccDirectiveLine line = (AssembledFccDirectiveLine)engine.getAssembledLine(1);
			Assert.assertEquals("Check Label","Label1",line.getLabel());
			Assert.assertEquals("Check Comment","; error message",line.getComment());
	
			Assert.assertEquals("Check value 0",69,line.getValues()[0]);
			Assert.assertEquals("Check value 1",114,line.getValues()[1]);
			Assert.assertEquals("Check value 2",114,line.getValues()[2]);
			Assert.assertEquals("Check value 3",101,line.getValues()[3]);
			Assert.assertEquals("Check value 4",117,line.getValues()[4]);
			Assert.assertEquals("Check value 5",114,line.getValues()[5]);
			Assert.assertEquals("Check value 6",32,line.getValues()[6]);
			Assert.assertEquals("Check value 7",65,line.getValues()[7]);
			Assert.assertEquals("Check value 8",65,line.getValues()[8]);
			Assert.assertEquals("Check value 9",49,line.getValues()[9]);
			Assert.assertEquals("Check value 10",49,line.getValues()[10]);
			Assert.assertEquals("Check value 11",53,line.getValues()[11]);
	
			Assert.assertEquals("Check Impact on PC",0x800C,engine.getCurrentPcValue());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check FDB directive with list of parameters
	 */
	@Test 
	public void testFCCAssemblyResultWithLitOfParameters() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("	        		ORG    	$8000\n");
		strBuilder.append("Label1       	FCC    	\"Erreur AA115\",$25,\"Ola\" 		; error message\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			AssemblerEngine engine = AssemblerEngine.getInstance();
			AssembledFccDirectiveLine line = (AssembledFccDirectiveLine)engine.getAssembledLine(1);
			Assert.assertEquals("Check Label","Label1",line.getLabel());
			Assert.assertEquals("Check Comment","; error message",line.getComment());
	
			Assert.assertEquals("Check value 0",69,line.getValues()[0]);
			Assert.assertEquals("Check value 1",114,line.getValues()[1]);
			Assert.assertEquals("Check value 2",114,line.getValues()[2]);
			Assert.assertEquals("Check value 3",101,line.getValues()[3]);
			Assert.assertEquals("Check value 4",117,line.getValues()[4]);
			Assert.assertEquals("Check value 5",114,line.getValues()[5]);
			Assert.assertEquals("Check value 6",32,line.getValues()[6]);
			Assert.assertEquals("Check value 7",65,line.getValues()[7]);
			Assert.assertEquals("Check value 8",65,line.getValues()[8]);
			Assert.assertEquals("Check value 9",49,line.getValues()[9]);
			Assert.assertEquals("Check value 10",49,line.getValues()[10]);
			Assert.assertEquals("Check value 11",53,line.getValues()[11]);
			Assert.assertEquals("Check value 12",37,line.getValues()[12]);
			Assert.assertEquals("Check value 13",79,line.getValues()[13]);
			Assert.assertEquals("Check value 14",108,line.getValues()[14]);
			Assert.assertEquals("Check value 15",97,line.getValues()[15]);
	
			Assert.assertEquals("Check Impact on PC",0x8010,engine.getCurrentPcValue());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
}