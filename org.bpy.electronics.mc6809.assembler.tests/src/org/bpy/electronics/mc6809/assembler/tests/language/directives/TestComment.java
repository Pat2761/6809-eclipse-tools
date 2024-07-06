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

import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Inject;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)
public class TestComment {
	
	@Inject ParseHelper<Model> parseHelper;
	
	@Test
	public void testComment01() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("; ---------------------------------------------------------------\n");
		strBuilder.append("; Check for comment\n");
		strBuilder.append("; ---------------------------------------------------------------\n");
		strBuilder.append("\n");
		strBuilder.append("; it is the end\n");
		strBuilder.append("\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
	
	@Test
	public void testOneMainLine() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("		; ---------------------------------------------------------------\n");
		strBuilder.append("	\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}

	@Test
	public void testOneMainLinePlusSpace() {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("	; ---------------------------------------------------------------\n");
		strBuilder.append("	\n");
		strBuilder.append("	\n");

		try {
			Model result = parseHelper.parse(strBuilder.toString());
		
			Assert.assertNotNull(result);
			Assert.assertTrue("No errors found", result.eResource().getErrors().isEmpty());
		} catch (Exception e) {
			Assert.assertTrue("Exception detected", true);
		}
	}
}