package org.bpy.electronics.mc6809.externaltools.ui.preferences;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.externaltools.ui.common.ILocationComponentWidget;
import org.bpy.electronics.mc6809.externaltools.ui.common.LocationComponentWidget;
import org.bpy.electronics.mc6809.externaltools.ui.listener.ControlAccessibleListener;
import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.variables.IStringVariableManager;
import org.eclipse.core.variables.VariablesPlugin;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;

public class LWToolPreferencePage extends PreferencePage implements IWorkbenchPreferencePage, ILocationComponentWidget {

	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(LWToolPreferencePage.class.getSimpleName());

	/** Widget for calculator tool path */
	private LocationComponentWidget lwToolLocation;

	/** Indicate if the page is correctly set */ 
	private boolean isValid = true;

	/**
	 * @wbp.parser.constructor
	 */
	public LWToolPreferencePage() {
	}

	public LWToolPreferencePage(String title) {
		super(title);
	}

	public LWToolPreferencePage(String title, ImageDescriptor image) {
		super(title, image);
	}

	@Override
	public void init(IWorkbench workbench) {
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite mainComposite = new Composite(parent, SWT.NULL);
		mainComposite.setLayout(new GridLayout(1, false));
		
		lwToolLocation = new LocationComponentWidget(mainComposite, this);

		return mainComposite;
	}

	private void validateEntries(String location) {
		IStringVariableManager manager = VariablesPlugin.getDefault().getStringVariableManager();
		try {
			String calculatorPath =  manager.performStringSubstitution(location);

			File file = new File(calculatorPath);
			if (!file.exists() || !file.isFile() || !file.getName().toLowerCase().endsWith(".exe")) {
				setMessage("The LWTool path must point to a valid executable file" );
				isValid  = false;
				return;
			}
		} catch (CoreException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}

		setMessage("Path of the executable file of LWTool");
		isValid = true;
	}

	@Override
	protected void performApply() {
		PreferenceManager.getInstance().setLWToolLocation(getDescription());
	}

	@Override
	protected void performDefaults() {
		PreferenceManager.getInstance().setLWToolLocation(PreferenceManager.DEFAULT_LWTOOL_LOCATION);
		super.performDefaults();
	}

	@Override
	public boolean performOk() {
		performApply();
		return super.performOk();
	}

	@Override
	public boolean isValid() {
		return isValid;
	}

	/*
	 * Fix for Bug 60163 Accessibility: New Builder Dialog missing object info for textInput controls
	 */
	public void addControlAccessibleListener(Control control, String controlName) {
		//strip mnemonic (&)
		String[] strs = controlName.split("&"); //$NON-NLS-1$
		StringBuilder stripped = new StringBuilder();
		for (String str : strs) {
			stripped.append(str);
		}
		control.getAccessible().addAccessibleListener(new ControlAccessibleListener(stripped.toString()));
	}

	@Override
	public void locationChange(String location) {
		validateEntries(location);
	}
}
