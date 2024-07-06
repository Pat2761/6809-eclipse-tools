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

import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.EndDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledEndDirectiveLine;
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

public class TestEndDirective {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension public ValidationTestHelper validationHelper;
	
	
	/**
	 * Check ORG directive with no value , return 0
	 */
	@Test 
	public void testEndWithNoValueValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000   ; With value\n");
		strBuilder.append("	       END\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine) line.getLineContent();
			Assert.assertTrue("Must be an END directive line", directiveLine.getDirective() instanceof EndDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exption detected", true);
		}
	}

	/**
	 * Check END directive with the value
	 */
	@Test 
	public void checkEndValueWithValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	   			ORG    	$8000   	; With value\n");
		strBuilder.append("				BSZ		$0A	\n");
		strBuilder.append("Start		BSZ		1   		\n");
		strBuilder.append("       		END    	Start 		; That's all folk\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("PC value must be 800B", 0x800B, engine.getCurrentPcValue());
			AbstractAssemblyLine line = engine.getAssembledLine(4);
			AssembledEndDirectiveLine endLine = (AssembledEndDirectiveLine) line;
			Assert.assertEquals("Check line number", 5, endLine.getLineNumber());
			Assert.assertNull("Check label", endLine.getLabel());
			Assert.assertEquals("Check comment", "; That's all folk", endLine.getComment());
			Assert.assertEquals("Check start value", 0x800A, endLine.getValue());
		} catch (Exception e) {
			Assert.assertTrue("Exption detected", true);
		}
	}

	/**
	 * Check END directive without the value
	 */
	@Test 
	public void checkEndWithoutValue() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	   			ORG    	$8000   	; With value\n");
		strBuilder.append("				BSZ		$0A	\n");
		strBuilder.append("Start		BSZ		1   		\n");
		strBuilder.append("       		END\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);

			AssemblerEngine engine = AssemblerEngine.getInstance();
			Assert.assertEquals("PC value must be 800B", 0x800B, engine.getCurrentPcValue());
			AbstractAssemblyLine line = engine.getAssembledLine(4);
			AssembledEndDirectiveLine endLine = (AssembledEndDirectiveLine) line;
			Assert.assertEquals("Check line number", 5, endLine.getLineNumber());
			Assert.assertNull("Check label", endLine.getLabel());
			Assert.assertNull("Check comment",  endLine.getComment());
			Assert.assertEquals("Check start value", 0, endLine.getValue());
		} catch (Exception e) {
			Assert.assertTrue("Exption detected", true);
		}
	}
}