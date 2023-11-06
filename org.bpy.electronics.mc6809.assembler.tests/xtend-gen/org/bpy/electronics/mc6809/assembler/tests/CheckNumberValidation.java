package org.bpy.electronics.mc6809.assembler.tests;

import com.google.inject.Inject;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerValidator;
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
public class CheckNumberValidation {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  @Test
  public void testBinary1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(";******************************************************");
      _builder.newLine();
      _builder.append("Test\t\tEQU \t%01100011\t\t; Conform\t");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testBinary2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(";******************************************************");
      _builder.newLine();
      _builder.append("Test\t\tEQU \t%01200011\t\t; Not Conform\t");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getBinaryValue(), 
        AssemblerValidator.INVALID_FIGURE, 
        "2 is invalid in binary value");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testBinary3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(";******************************************************");
      _builder.newLine();
      _builder.append("Test\t\tEQU \t%51100011\t\t; Not Conform\t");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getBinaryValue(), 
        AssemblerValidator.INVALID_FIGURE, 
        "5 is invalid in binary value");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testBinary4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(";******************************************************");
      _builder.newLine();
      _builder.append("Test\t\tEQU \t%11100016\t\t; Not Conform\t");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getBinaryValue(), 
        AssemblerValidator.INVALID_FIGURE, 
        "6 is invalid in binary value");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOctal1() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(";******************************************************");
      _builder.newLine();
      _builder.append("Test\t\tEQU \t@0123\t\t; Conform\t");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOctal2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(";******************************************************");
      _builder.newLine();
      _builder.append("Test\t\tEQU \t@4567\t\t; Conform\t");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertNoErrors(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOctal3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(";******************************************************");
      _builder.newLine();
      _builder.append("Test\t\tEQU \t@8123\t\t; Not Conform\t");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getOctalValue(), 
        AssemblerValidator.INVALID_FIGURE, 
        "8 is invalid in octal value");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOctal4() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append(";******************************************************");
      _builder.newLine();
      _builder.append("Test\t\tEQU \t@4569\t\t; Not Conform\t");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      this._validationTestHelper.assertError(result, AssemblerPackage.eINSTANCE.getOctalValue(), 
        AssemblerValidator.INVALID_FIGURE, 
        "9 is invalid in octal value");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
