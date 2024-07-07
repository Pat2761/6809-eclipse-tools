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
import org.bpy.electronics.mc6809.assembler.assembler.FailDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
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

public class TestFailDirective {
	@Inject ParseHelper<Model> parseHelper;
	@Inject @Extension private ValidationTestHelper validationHelper;
	
	/**
	 * Check FAIL directive without comment
	 */
	@Test 
	public void testFAILWithoutCommentWithSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       		ORG    $8000\n");
		strBuilder.append(" 		  	FAIL    \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an FAIL directive line", directiveLine.getDirective() instanceof FailDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	/**
	 * Check FAIL directive without comment
	 */
	@Test 
	public void testFAILWithoutCommentWithoutSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append(" 		   FAIL\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
		
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an FAIL directive line", directiveLine.getDirective() instanceof FailDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	/**
	 * Check FAIL directive with comment
	 */
	@Test 
	public void testFailWithComment() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; -----------------------------------------\n");
		strBuilder.append("	       ORG    $8000\n");
		strBuilder.append("	       FAIL  ; It is fail \n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
			validationHelper.assertNoErrors(result);
		
			SourceLine line = result.getSourceLines().get(2);
			Assert.assertTrue("Must be a directive line", line.getLineContent() instanceof DirectiveLine);
			
			DirectiveLine directiveLine = (DirectiveLine)line.getLineContent();
			Assert.assertTrue("Must be an FAIL directive line", directiveLine.getDirective() instanceof FailDirective);
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
}