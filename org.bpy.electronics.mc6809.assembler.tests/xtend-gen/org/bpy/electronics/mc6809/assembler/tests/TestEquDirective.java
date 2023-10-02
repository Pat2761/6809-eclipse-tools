package org.bpy.electronics.mc6809.assembler.tests;

import com.google.inject.Inject;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblyLine;
import org.bpy.electronics.mc6809.assembler.assembler.Directive;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Expression;
import org.bpy.electronics.mc6809.assembler.assembler.LabelField;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(AssemblerInjectorProvider.class)
@SuppressWarnings("all")
public class TestEquDirective {
  @Inject
  private ParseHelper<Model> parseHelper;

  @Test
  public void testWithDecimalValue() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Label       EQU    1234 ");
      _builder.newLine();
      final Model result = this.parseHelper.parse(_builder);
      Assert.assertNotNull(result);
      final EList<Resource.Diagnostic> errors = result.eResource().getErrors();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("Unexpected errors: �errors.join(\", \")�");
      Assert.assertTrue(_builder_1.toString(), errors.isEmpty());
      final SourceLine line = result.getSourceLines().get(0);
      Assert.assertTrue("Must be an Source line", (line instanceof SourceLine));
      final AssemblyLine assemblyLine = ((SourceLine) line).getAssemblyLine();
      Assert.assertTrue("Must be an assembly line", (assemblyLine instanceof AssemblyLine));
      final Directive directive = ((AssemblyLine) assemblyLine).getCommand();
      Assert.assertTrue("Must be an directive", (directive instanceof Directive));
      final EquDirective equDirective = ((Directive) directive).getDirective();
      Assert.assertTrue("Must be an EQU directive", (equDirective instanceof EquDirective));
      final LabelField label = ((AssemblyLine) assemblyLine).getLabelField();
      Assert.assertEquals("Bad label value", "Label", label.getLabel());
      final Expression expression = ((EquDirective) equDirective).getConstant().getValue();
      Assert.assertTrue("Must be an directive", (expression instanceof Expression));
      final int equValue = ExpressionParser.resolveExpression(((Expression) expression));
      Assert.assertEquals("Bad EQU Value", 1234, equValue);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
