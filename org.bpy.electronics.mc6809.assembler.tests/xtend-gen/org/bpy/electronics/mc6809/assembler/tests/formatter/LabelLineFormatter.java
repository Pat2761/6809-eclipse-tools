package org.bpy.electronics.mc6809.assembler.tests.formatter;

import com.google.inject.Inject;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider;
import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)
@SuppressWarnings("all")
public class LabelLineFormatter extends AbstractTestFormatter {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Inject
  @Extension
  private ISerializer _iSerializer;

  @Test
  public void testFormatterSpaceOnly01() {
    try {
      this.setTabPolicy(PreferenceManager.SPACE_ONLY);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("TEST:\t\t   ; test ");
      final String test = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("TEST:                                              ; test ");
      final String expectedResult = _builder_1.toString();
      Assert.assertEquals(expectedResult, this._iSerializer.serialize(this.parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFormatterSpaceOnly02() {
    try {
      this.setTabPolicy(PreferenceManager.SPACE_ONLY);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("TEST\t\t   ; test ");
      final String test = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("TEST                                               ; test ");
      final String expectedResult = _builder_1.toString();
      Assert.assertEquals(expectedResult, this._iSerializer.serialize(this.parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFormatterTabOnly01() {
    try {
      this.setTabPolicy(PreferenceManager.TAB_ONLY);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("TEST:\t\t   ; test ");
      final String test = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("TEST:                                              ; test ");
      final String expectedResult = _builder_1.toString();
      Assert.assertEquals(expectedResult, this._iSerializer.serialize(this.parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFormatterTabOnly02() {
    try {
      this.setTabPolicy(PreferenceManager.TAB_ONLY);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("TEST\t\t   ; test ");
      final String test = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("TEST                                               ; test ");
      final String expectedResult = _builder_1.toString();
      Assert.assertEquals(expectedResult, this._iSerializer.serialize(this.parseHelper.parse(test), SaveOptions.newBuilder().format().getOptions()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
