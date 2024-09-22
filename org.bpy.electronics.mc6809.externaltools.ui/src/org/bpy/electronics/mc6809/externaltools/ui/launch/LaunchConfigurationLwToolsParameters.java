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
package org.bpy.electronics.mc6809.externaltools.ui.launch;

import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Button;

/**
 * Define a tab which allow to define parameters of LWTools
 * 
 * Usage: lwasm.exe [OPTION...] INPUTFILE
 * lwasm, a HD6309 and MC6809 cross-assembler
 *
 *  -3, --6309                  Set assembler to 6309 mode (default)
 *  -9, --6809                  Set assembler to 6809 only mode
 *  -d, --debug[=LEVEL]         Set debug mode
 *  -b, --decb                  Generate DECB .bin format output, equivalent of
 *                              --format=decb
 *      --depend                Output a dependency list to stdout; do not do
 *                              any actual output though assembly is completed
 *                              as usual
 *  -f, --format=TYPE           Select output format: decb, raw, obj, os9
 *  -I, --includedir=PATH       Add entry to include path
 *  -l, --list[=FILE]           Generate list [to FILE]
 *      --obj                   Generate proprietary object file format for
 *                              later linking, equivalent of --format=obj
 *  -o, --output=FILE           Output to FILE
 *  -p, --pragma=PRAGMA         Set an assembler pragma to any value understood
 *                              by the "pragma" pseudo op
 *  -r, --raw                   Generate raw binary format output, equivalent of
 *                              --format=raw
 *  -s, --symbols               Generate symbol list in listing, no effect
 *                              without --list
 *  -?, --help                  give this help list
 *      --usage                 give a short usage message
 *  -V, --version               print program version
 * 
 * @author Patrick BRIAND
 *
 */
public class LaunchConfigurationLwToolsParameters extends AbstractLaunchConfigurationTab {
	private Text text;
	private Text text_1;

	/**
	 * @wbp.parser.entryPoint
	 */
	@Override
	public void createControl(Composite parent) {
	     Composite comp = new Group(parent, SWT.BORDER);
	     comp.setToolTipText("Generate list [to FILE]");
        setControl(comp);
        
        GridLayoutFactory.swtDefaults().numColumns(2).applyTo(comp);
        comp.setLayout(new GridLayout(3, false));

        Label lblOutputFormat = new Label(comp, SWT.NONE);
        lblOutputFormat.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblOutputFormat.setText("Output format:");
        GridDataFactory.swtDefaults().applyTo(lblOutputFormat);
        
        Combo combo = new Combo(comp, SWT.NONE);
        combo.setToolTipText(" Select output format: decb, raw, obj, os9");
        combo.setItems(new String[] {"DECB", "RAW", "OBJ", "OS9"});
        combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
        
        Label lblListFile = new Label(comp, SWT.NONE);
        lblListFile.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblListFile.setText("List file:");
        
        text = new Text(comp, SWT.BORDER);
        text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        Button button = new Button(comp, SWT.NONE);
        button.setText("...");
        
        Label lblOuputFile = new Label(comp, SWT.NONE);
        lblOuputFile.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblOuputFile.setText("Ouput file");
        
        text_1 = new Text(comp, SWT.BORDER);
        text_1.setToolTipText("Output to FILE");
        text_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        
        Button button_1 = new Button(comp, SWT.NONE);
        button_1.setText("...");
        
        Button btnGenerateSymbol = new Button(comp, SWT.CHECK);
        btnGenerateSymbol.setToolTipText("Generate symbol list in listing, no effect without --list");
        btnGenerateSymbol.setText("Generate symbol");
        new Label(comp, SWT.NONE);
        new Label(comp, SWT.NONE);
        
        Button btnCheckButton = new Button(comp, SWT.CHECK);
        btnCheckButton.setToolTipText("give a short usage message");
        btnCheckButton.setText("Usage message");
        new Label(comp, SWT.NONE);
        new Label(comp, SWT.NONE);
        
        Button btnVersion = new Button(comp, SWT.CHECK);
        btnVersion.setToolTipText("print program version");
        btnVersion.setText("Version");
        new Label(comp, SWT.NONE);
        new Label(comp, SWT.NONE);}


	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canSave() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setLaunchConfigurationDialog(ILaunchConfigurationDialog dialog) {
		// TODO Auto-generated method stub

	}

	@Override
	public void launched(ILaunch launch) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Parameters";
	}

	@Override
	public Image getImage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void activated(ILaunchConfigurationWorkingCopy workingCopy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deactivated(ILaunchConfigurationWorkingCopy workingCopy) {
		// TODO Auto-generated method stub

	}


	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		// TODO Auto-generated method stub
		
	}
}
