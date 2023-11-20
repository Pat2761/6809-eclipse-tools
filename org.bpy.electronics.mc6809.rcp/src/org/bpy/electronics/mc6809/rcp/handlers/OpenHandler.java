package org.bpy.electronics.mc6809.rcp.handlers;

import org.bpy.electronics.mc6809.rcp.dialogs.UnderConstruction;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.widgets.Shell;

public class OpenHandler {

	@Execute
	public void execute(Shell shell){
		
		UnderConstruction underConstruction = new UnderConstruction(shell);
		underConstruction.open();
	}
}
