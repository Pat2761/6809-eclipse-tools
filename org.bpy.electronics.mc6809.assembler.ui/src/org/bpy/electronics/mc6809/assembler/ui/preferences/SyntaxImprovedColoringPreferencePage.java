package org.bpy.electronics.mc6809.assembler.ui.preferences;

import static org.eclipse.xtext.ui.editor.preferences.PreferenceConstants.SEPARATOR;

import java.util.Comparator;

import org.bpy.electronics.mc6809.assembler.AssemblerStandaloneSetup;
import org.bpy.electronics.mc6809.assembler.ui.internal.AssemblerActivator;
import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.eclipse.core.runtime.preferences.ConfigurationScope;
import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.jface.preference.ColorSelector;
import org.eclipse.jface.preference.IPreferenceNode;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.preference.PreferenceStore;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.texteditor.ChainedPreferenceStore;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorFactory.Builder;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.PreferenceStoreAccessor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

import org.eclipse.swt.layout.FillLayout;

@SuppressWarnings("restriction")
public class SyntaxImprovedColoringPreferencePage extends PreferencePage implements IWorkbenchPreferencePage, IHighlightingConfigurationAcceptor, Comparator<Triple<String, String, TextStyle>> {

	private static final StringBuilder TEXT_TO_DISPLAY = new StringBuilder();
	
	static {
		TEXT_TO_DISPLAY.append(";--------------------------------------------------------\n");
		TEXT_TO_DISPLAY.append("; Commentaire d'entête\n");
		TEXT_TO_DISPLAY.append("; -------------------------------------------------------\n");
		TEXT_TO_DISPLAY.append("Start:			ORG		$8000				; test\n");
		TEXT_TO_DISPLAY.append("\n");
		TEXT_TO_DISPLAY.append("Val1				EQU			1						; vaut 1\n");
		TEXT_TO_DISPLAY.append("					FCC			\"A string\"			; a string\n");
		TEXT_TO_DISPLAY.append("\n");
		TEXT_TO_DISPLAY.append("															; macro definition\n");
		TEXT_TO_DISPLAY.append("					.macro	MACRO			; une macro\n");
		TEXT_TO_DISPLAY.append("					LDA			#$25				; \n");
		TEXT_TO_DISPLAY.append("Loop:			DECA								;\n");
		TEXT_TO_DISPLAY.append("					BNE			Loop				; Loop\n");
		TEXT_TO_DISPLAY.append("					.endm								; end of macro\n");
		TEXT_TO_DISPLAY.append("\n");
		TEXT_TO_DISPLAY.append("Nop1			NOP\n");
		TEXT_TO_DISPLAY.append("Nop2:			NOP								; Nop\n");
		TEXT_TO_DISPLAY.append("\n");
		TEXT_TO_DISPLAY.append("CalMac		MACRO							; call macro\n");
		TEXT_TO_DISPLAY.append("\n");
		TEXT_TO_DISPLAY.append("					LDA			#Val1				; A=1\n");	
		TEXT_TO_DISPLAY.append("					BNE			Nop1				; a branch\n");
		TEXT_TO_DISPLAY.append("					BSR			Nop2				; Jsr\n");
		TEXT_TO_DISPLAY.append("\n");
		TEXT_TO_DISPLAY.append("; end of file\n");
	}

	private @Inject @Named(Constants.LANGUAGE_NAME) String languageName;
	private java.util.List<Triple<String, String, TextStyle>> highlightings;

	@Inject
	IPreferenceStoreAccess store;

	/**
	 * Create the preference page.
	 */
	public SyntaxImprovedColoringPreferencePage() {
		Injector injector = new AssemblerStandaloneSetup().createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
	}

	/**
	 * Create contents of the preference page.
	 * @param parent
	 */
	@Override
	public Control createContents(Composite parent) {
		Composite highlightingComposite = new Composite(parent, SWT.NULL);
		highlightingComposite.setLayout(new GridLayout(4, false));
		
		Label lblNewLabel = new Label(highlightingComposite, SWT.NONE);
		GridData gdLblNewLabel = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gdLblNewLabel.widthHint = 168;
		lblNewLabel.setLayoutData(gdLblNewLabel);
		lblNewLabel.setText("Token Styles");
		new Label(highlightingComposite, SWT.NONE);
		new Label(highlightingComposite, SWT.NONE);
		new Label(highlightingComposite, SWT.NONE);
		
		List list = new List(highlightingComposite, SWT.BORDER);
		GridData gdList = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 5);
		gdList.heightHint = 223;
		list.setLayoutData(gdList);
		
		Label lblColor = new Label(highlightingComposite, SWT.NONE);
		GridData gdLblColor = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gdLblColor.widthHint = 66;
		lblColor.setLayoutData(gdLblColor);
		lblColor.setText("Color");
		
		ColorSelector btnForegroundColorSelector = new ColorSelector(highlightingComposite);
//		Button btnNewButton = new Button(grpColorSelector, SWT.NONE);
//		btnNewButton.setText("New Button");
		new Label(highlightingComposite, SWT.NONE);
		
		Label lblBackground = new Label(highlightingComposite, SWT.NONE);
		GridData gdLblBackground = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gdLblBackground.widthHint = 84;
		lblBackground.setLayoutData(gdLblBackground);
		lblBackground.setText("Background");
		ColorSelector btnBackgroundColorSelector = new ColorSelector(highlightingComposite);
	   // new Label(highlightingComposite, SWT.NONE);
		//new Label(highlightingComposite, SWT.NONE);
		new Label(highlightingComposite, SWT.NONE);
	
		Group grpStyle = new Group(highlightingComposite, SWT.NONE);
		grpStyle.setLayout(new GridLayout(2, false));
		GridData gdGrpStyle = new GridData(SWT.FILL, SWT.TOP, false, false, 2, 1);
		gdGrpStyle.widthHint = 194;
		grpStyle.setLayoutData(gdGrpStyle);
		grpStyle.setText("Style");
		
		Button btnCheckButton = new Button(grpStyle, SWT.CHECK);
		btnCheckButton.setText("Italic");
		
		Button btnBold = new Button(grpStyle, SWT.CHECK);
		btnBold.setText("Bold");
		
		Button btnUderline = new Button(grpStyle, SWT.CHECK);
		btnUderline.setText("Underline");
		
		Button btnStrikeThrough = new Button(grpStyle, SWT.CHECK);
		btnStrikeThrough.setText("Strike through");
		new Label(highlightingComposite, SWT.NONE);
		
		Label lblFont = new Label(highlightingComposite, SWT.NONE);
		lblFont.setText("Font");
		
		Label lblNewLabel1 = new Label(highlightingComposite, SWT.NONE);
		lblNewLabel1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Button btnChange = new Button(highlightingComposite, SWT.NONE);
		btnChange.setText("Change");
		new Label(highlightingComposite, SWT.NONE);
		new Label(highlightingComposite, SWT.NONE);
		new Label(highlightingComposite, SWT.NONE);
		
		Label lblPreview = new Label(highlightingComposite, SWT.NONE);
		lblPreview.setText("Preview");
		new Label(highlightingComposite, SWT.NONE);
		new Label(highlightingComposite, SWT.NONE);
		new Label(highlightingComposite, SWT.NONE);
		
		Composite editorComposite = new Composite(highlightingComposite, SWT.NONE);
		editorComposite.setLayout(new FillLayout(SWT.HORIZONTAL));
		editorComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 4, 1));

		/* https://fr.slideshare.net/meysholdt/lightweight-xtext-editorsasswtwidgets */
		AssemblerActivator activator = AssemblerActivator.getInstance();
		Injector injector = activator.getInjector(AssemblerActivator.ORG_BPY_ELECTRONICS_MC6809_ASSEMBLER_ASSEMBLER);
		
		AssemblerResourceProvider provider = injector.getInstance(AssemblerResourceProvider.class);
		EmbeddedEditorFactory factory = injector.getInstance(EmbeddedEditorFactory.class);
		
		Builder builder = factory.newEditor(provider); 
		builder.readOnly();
		
		EmbeddedEditor editor = builder.withParent(editorComposite);
		EmbeddedEditorModelAccess model = editor.createPartialEditor("", TEXT_TO_DISPLAY.toString(), "", false);

		populatePage();
		
		return highlightingComposite;
	}

	private void populatePage() {
      ChainedPreferenceStore preferenceStore = (ChainedPreferenceStore) store.getPreferenceStore();
 	}

	@Inject
	public void collectHighlightings(IHighlightingConfiguration configuration) {
		configuration.configure(this);
	}

	/**
	 * Initialize the preference page.
	 */
	public void init(IWorkbench workbench) {
		// Initialize the preference page
	}

	@Override
	public void acceptDefaultHighlighting(String id, String name, TextStyle style) {
		System.out.println(name);
	}

	@Override
	public int compare(Triple<String, String, TextStyle> o1, Triple<String, String, TextStyle> o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
