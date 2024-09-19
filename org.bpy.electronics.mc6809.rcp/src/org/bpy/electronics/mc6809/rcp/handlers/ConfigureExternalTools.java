package org.bpy.electronics.mc6809.rcp.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.internal.ui.DebugUIPlugin;
import org.eclipse.debug.internal.ui.launchConfigurations.LaunchHistory;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.externaltools.internal.model.IExternalToolConstants;

public class ConfigureExternalTools implements IHandler {

	@Override
	public void addHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		String fIdentifier = IExternalToolConstants.ID_EXTERNAL_TOOLS_LAUNCH_GROUP;
		LaunchHistory history = DebugUIPlugin.getDefault().getLaunchConfigurationManager().getLaunchHistory(fIdentifier );
		ILaunchConfiguration configuration = history.getRecentLaunch();
		IStructuredSelection selection = null;
		if (configuration == null) {
			selection = new StructuredSelection();
		} else {
			selection = new StructuredSelection(configuration);
		}
	int result = DebugUITools.openLaunchConfigurationDialogOnGroup(DebugUIPlugin.getShell(), selection, fIdentifier);

		return null;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isHandled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void removeHandlerListener(IHandlerListener handlerListener) {
		// TODO Auto-generated method stub

	}

}
