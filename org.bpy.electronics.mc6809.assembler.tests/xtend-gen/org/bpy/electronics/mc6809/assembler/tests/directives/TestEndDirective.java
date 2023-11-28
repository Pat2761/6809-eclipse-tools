/**
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
 */
package org.bpy.electronics.mc6809.assembler.tests.directives;

import com.google.inject.Inject;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.EndDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledEndDirectiveLine;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)
@SuppressWarnings("all")
public class TestEndDirective {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  /**
   * Check ORG directive with no value , return 0
   */
  @Test
  public void testEndWithNoValueValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("ORG    $8000   ; With value");
      _builder.newLine();
      _builder.append("\t       ");
      _builder.append("END");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(2);
      EObject _lineContent = line.getLineContent();
      Assert.assertTrue("Must be a directive line", (_lineContent instanceof DirectiveLine));
      EObject _lineContent_1 = line.getLineContent();
      final DirectiveLine directiveLine = ((DirectiveLine) _lineContent_1);
      EObject _directive = directiveLine.getDirective();
      Assert.assertTrue("Must be an END directive line", (_directive instanceof EndDirective));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check END directive with the value
   */
  @Test
  public void checkEndValueWithValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t   \t\t");
      _builder.append("ORG    \t$8000   \t; With value");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BSZ\t\t$0A\t");
      _builder.newLine();
      _builder.append("Start\t\tBSZ\t\t1   \t\t");
      _builder.newLine();
      _builder.append("       \t\t");
      _builder.append("END    \tStart \t\t; That\'s all folk");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("PC value must be 800B", 0x800B, engine.getCurrentPcValue());
      final AbstractAssemblyLine line = engine.getAssembledLine(4);
      final AssembledEndDirectiveLine endLine = ((AssembledEndDirectiveLine) line);
      Assert.assertEquals("Check line number", 5, endLine.getLineNumber());
      Assert.assertNull("Check label", endLine.getLabel());
      Assert.assertEquals("Check comment", "; That\'s all folk", endLine.getComment());
      Assert.assertEquals("Check start value", 0x800A, endLine.getValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  /**
   * Check END directive without the value
   */
  @Test
  public void checkEndWithoutValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("; -----------------------------------------");
      _builder.newLine();
      _builder.append("\t   \t\t");
      _builder.append("ORG    \t$8000   \t; With value");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("BSZ\t\t$0A\t");
      _builder.newLine();
      _builder.append("Start\t\tBSZ\t\t1   \t\t");
      _builder.newLine();
      _builder.append("       \t\t");
      _builder.append("END");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
      final AssemblerEngine engine = AssemblerEngine.getInstance();
      Assert.assertEquals("PC value must be 800B", 0x800B, engine.getCurrentPcValue());
      final AbstractAssemblyLine line = engine.getAssembledLine(4);
      final AssembledEndDirectiveLine endLine = ((AssembledEndDirectiveLine) line);
      Assert.assertEquals("Check line number", 5, endLine.getLineNumber());
      Assert.assertNull("Check label", endLine.getLabel());
      Assert.assertNull("Check comment", endLine.getComment());
      Assert.assertEquals("Check start value", 0, endLine.getValue());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
