package org.bpy.electronics.mc6809.externaltools.ui.preferences;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

public class ExternalToolPreferenceMainPage extends PreferencePage implements IWorkbenchPreferencePage {
	private Text txtThisPreferencePage;

	/**
	 * @wbp.parser.constructor
	 */
	public ExternalToolPreferenceMainPage() {
		// TODO Auto-generated constructor stub
	}

	public ExternalToolPreferenceMainPage(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	public ExternalToolPreferenceMainPage(String title, ImageDescriptor image) {
		super(title, image);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected Control createContents(Composite parent) {
		Composite mainComposite = new Composite(parent, SWT.NONE);
		mainComposite.setLayout(new GridLayout(1, false));
		
		txtThisPreferencePage = new Text(mainComposite, SWT.BORDER);
		txtThisPreferencePage.setText("This preference page allows you to configure by default parameters linked to external tools");
		txtThisPreferencePage.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		txtThisPreferencePage.setEditable(false);
		return mainComposite;
	}
}
