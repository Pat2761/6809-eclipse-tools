package org.bpy.electronics.mc6809.rcp.launch;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class AssemblerLaunchConfigurationTabGroup extends AbstractLaunchConfigurationTabGroup {

	public AssemblerLaunchConfigurationTabGroup() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
      setTabs(new ILaunchConfigurationTab[] { new SampleTab() ,new CommonTab()});

	}

}
