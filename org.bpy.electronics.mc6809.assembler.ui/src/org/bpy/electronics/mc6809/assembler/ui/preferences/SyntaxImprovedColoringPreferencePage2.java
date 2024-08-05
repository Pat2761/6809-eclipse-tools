package org.bpy.electronics.mc6809.assembler.ui.preferences;

import org.bpy.electronics.mc6809.assembler.AssemblerStandaloneSetup;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.syntaxcoloring.SyntaxColoringPreferencePage;

import com.google.inject.Injector;

@SuppressWarnings("restriction")
public class SyntaxImprovedColoringPreferencePage2 extends SyntaxColoringPreferencePage {
	
	private EmbeddedEditorFactory factory;
	private AssemblerResourceProvider provider;

	public SyntaxImprovedColoringPreferencePage2() {
	}
	
}
