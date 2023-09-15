/*
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.ui;

import com.google.inject.Injector;
import org.bpy.electronics.mc6809.assembler.ui.internal.AssemblerActivator;
import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class AssemblerExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return FrameworkUtil.getBundle(AssemblerActivator.class);
	}
	
	@Override
	protected Injector getInjector() {
		AssemblerActivator activator = AssemblerActivator.getInstance();
		return activator != null ? activator.getInjector(AssemblerActivator.ORG_BPY_ELECTRONICS_MC6809_ASSEMBLER_ASSEMBLER) : null;
	}

}
