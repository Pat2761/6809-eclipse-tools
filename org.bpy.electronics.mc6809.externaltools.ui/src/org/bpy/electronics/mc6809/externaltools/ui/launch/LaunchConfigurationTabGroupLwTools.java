package org.bpy.electronics.mc6809.externaltools.ui.launch;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class LaunchConfigurationTabGroupLwTools extends AbstractLaunchConfigurationTabGroup {

	public LaunchConfigurationTabGroupLwTools() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		System.out.println("BPY: A que coucou");
		setTabs(new LaunchConfigurationLwToolsParameters(), new CommonTab());
	}

}
