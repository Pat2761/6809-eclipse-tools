package org.bpy.electronics.mc6809.externaltools.ui.launch;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.ui.externaltools.internal.program.launchConfigurations.ProgramMainTab;


@SuppressWarnings("restriction")
public class LaunchConfigurationTabGroupLwTools extends AbstractLaunchConfigurationTabGroup {

	public LaunchConfigurationTabGroupLwTools() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		setTabs(new ProgramMainTab(), new LaunchConfigurationLwToolsParameters(), new CommonTab());
	}

}
