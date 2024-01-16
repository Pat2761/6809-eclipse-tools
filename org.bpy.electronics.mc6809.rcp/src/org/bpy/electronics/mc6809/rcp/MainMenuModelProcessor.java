package org.bpy.electronics.mc6809.rcp;

import org.eclipse.e4.core.di.annotations.Execute;
import org.eclipse.e4.ui.model.application.MApplication;
import org.eclipse.e4.ui.model.application.ui.basic.MTrimmedWindow;
import org.eclipse.e4.ui.model.application.ui.menu.MMenu;
import org.eclipse.e4.ui.workbench.modeling.EModelService;

import com.google.inject.Inject;

public class MainMenuModelProcessor {

	@Inject
	MApplication application;

	@Inject
	EModelService modelService;

	@Execute
	public void execute() {
		MTrimmedWindow window = (MTrimmedWindow) this.modelService.find("window.main", this.application);
		if (window == null || window.getMainMenu() != null) {
			return;
		}

		window.setMainMenu(createEmptyMainMenu());
	}

	private MMenu createEmptyMainMenu() {
		final MMenu mainMenu = this.modelService.createModelElement(MMenu.class);
		mainMenu.setElementId("org.eclipse.ui.main.menu");
		return mainMenu;
	}
}