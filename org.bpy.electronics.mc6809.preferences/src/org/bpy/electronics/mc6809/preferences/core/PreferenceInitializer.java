package org.bpy.electronics.mc6809.preferences.core;

import org.bpy.electronics.mc6809.preferences.Activator;
import org.eclipse.core.internal.preferences.InstancePreferences;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.BackingStoreException;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	public PreferenceInitializer() {
		// nothing to do
	}

	@Override
	public void initializeDefaultPreferences() {
		InstancePreferences node = (InstancePreferences) InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);

		try {
			node.flush();
		} catch (BackingStoreException e) {
			// nothing to do
		}
		
	}

}
