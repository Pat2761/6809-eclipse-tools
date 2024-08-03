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
public class SyntaxImprovedColoringPreferencePage extends SyntaxColoringPreferencePage {
	
	private EmbeddedEditorFactory factory;
	private AssemblerResourceProvider provider;

	public SyntaxImprovedColoringPreferencePage() {
		Injector injector = new AssemblerStandaloneSetup().createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
		
		provider = injector.getInstance(AssemblerResourceProvider.class);
		factory = injector.getInstance(EmbeddedEditorFactory.class);

	}

	@Override
	protected Control createContents(Composite parent) {
		Control content = super.createContents(parent);

		/* https://fr.slideshare.net/meysholdt/lightweight-xtext-editorsasswtwidgets */
		EmbeddedEditor editor = factory.newEditor(provider).withParent(parent);
		EmbeddedEditorModelAccess model = editor.createPartialEditor("", "Module hello world", "", false);
				
		return content;
	}
	
}
