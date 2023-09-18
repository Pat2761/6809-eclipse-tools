 
package org.bpy.electronics.mc6809.rcp.handlers;

import org.eclipse.e4.core.di.annotations.CanExecute;
import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.swt.custom.BusyIndicator;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

public class ShowHelpContentHandler {
	
	@Execute
	public void execute() {
		System.out.println("BPY:");
		BusyIndicator.showWhile(null, () -> PlatformUI.getWorkbench().getHelpSystem().displayHelp());
		System.out.println("BPY:");
	}
		
	
	@CanExecute
	public boolean canExecute() {
		return true;
	}
}