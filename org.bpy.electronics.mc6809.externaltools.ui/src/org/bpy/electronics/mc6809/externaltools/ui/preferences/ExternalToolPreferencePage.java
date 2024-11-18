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

/**
 * 
 * 
 * @author Patrick BRIAND
 *
 */
public class ExternalToolPreferencePage extends PreferencePage implements IWorkbenchPreferencePage, ILocationComponentWidget {

	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(ExternalToolPreferencePage.class.getSimpleName());
	
	/** Indicate if the page is correctly set */ 
	private boolean isValid = true;

	/** Widget for calculator tool path */
	private LocationComponentWidget locationCalculator;
	
	/**
	 * @wbp.parser.constructor
	 */
	public ExternalToolPreferencePage() {
		// Nothing to do
	}

	public ExternalToolPreferencePage(String title) {
		super(title);
		// Nothing to do
	}

	public ExternalToolPreferencePage(String title, ImageDescriptor image) {
		super(title, image);
		// Nothing to do
	}

	@Override
	public void init(IWorkbench workbench) {
		// Nothing to do
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite mainComposite = new Composite(parent, SWT.NONE);
		mainComposite.setLayout(new GridLayout(1, false));
		
		locationCalculator = new LocationComponentWidget(mainComposite, this);
		return mainComposite;
	}

	private void validateEntries(String location) {
		IStringVariableManager manager = VariablesPlugin.getDefault().getStringVariableManager();
		try {
			String calculatorPath =  manager.performStringSubstitution(location);

			File file = new File(calculatorPath);
			if (!file.exists() || !file.isFile() || !file.getName().toLowerCase().endsWith(".exe")) {
				setMessage("The calculator path must point to a valid executable file" );
				isValid  = false;
				return;
			}
		} catch (CoreException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}

		setMessage("Path of the calculator");
		isValid = true;
	}
	
	@Override
	protected void performApply() {
		PreferenceManager.getInstance().setCalculatorLocation(locationCalculator.getText());
	}

	@Override
	protected void performDefaults() {
		PreferenceManager.getInstance().setCalculatorLocation(PreferenceManager.DEFAULT_CALCULATOR_LOCATION);
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
	
	/**
	 * Returns the label used for the location widgets. Subclasses may wish to override.
	 */
	protected String getLocationLabel() {
		return "Location";
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
