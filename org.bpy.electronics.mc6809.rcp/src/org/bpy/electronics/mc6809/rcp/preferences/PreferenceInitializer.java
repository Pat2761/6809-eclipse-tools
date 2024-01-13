package org.bpy.electronics.mc6809.rcp.preferences;

import org.bpy.electronics.mc6809.rcp.Activator;
import org.eclipse.core.internal.preferences.InstancePreferences;
import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.BackingStoreException;

public class PreferenceInitializer extends AbstractPreferenceInitializer {

	public PreferenceInitializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initializeDefaultPreferences() {
		InstancePreferences node = (InstancePreferences) InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);

		try {
			node.flush();
		} catch (BackingStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
