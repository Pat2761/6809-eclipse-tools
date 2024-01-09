package org.bpy.electronics.mc6809.rcp;

import org.bpy.electronics.mc6809.rcp.preferences.PreferenceManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator extends AbstractUIPlugin /*BundleActivator*/ {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	private static Activator plugin;

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		plugin = this;
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		plugin=null;
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	@Override
	protected void initializeDefaultPreferences(IPreferenceStore store) {
		store.setDefault(PreferenceManager.TAB_POLICY, PreferenceManager.SPACE_ONLY);
		store.setDefault(PreferenceManager.TAB_SIZE, 3);
		store.setDefault(PreferenceManager.LABEL_SIZE, 15);
		store.setDefault(PreferenceManager.INSTRUCTION_SIZE, 6);
		store.setDefault(PreferenceManager.OPERAND_SIZE, 20);
	}

}
