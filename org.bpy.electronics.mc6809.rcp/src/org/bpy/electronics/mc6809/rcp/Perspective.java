package org.bpy.electronics.mc6809.rcp;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class Perspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		defineActions(layout);
		defineLayout(layout);
	}

	private void defineLayout(IPageLayout layout) {
      String editorArea = layout.getEditorArea();

      IFolderLayout left = layout.createFolder("left", IPageLayout.LEFT, (float) 0.25, editorArea);
      left.addView("org.eclipse.ui.navigator.ProjectExplorer");
      IFolderLayout right = layout.createFolder("right", IPageLayout.RIGHT, (float) 0.80, editorArea);
      right.addView("org.eclipse.ui.views.ContentOutline");
      
      IFolderLayout down = layout.createFolder("bottom", IPageLayout.BOTTOM, (float)0.7, editorArea);
      down.addView("org.eclipse.ui.console.ConsoleView");
      down.addView("org.eclipse.ui.views.ProblemView");
      down.addView("org.eclipse.ui.views.PropertySheet");
      down.addView("org.bpy.electronics.mc6809.rcp.assembled");
	}

	private void defineActions(IPageLayout layout) {
		layout.addNewWizardShortcut("org.bpy.electronics.mc6809.rcp.newproject");
		layout.addNewWizardShortcut("org.bpy.electronics.mc6809.rcp.newFile");
	}

}
