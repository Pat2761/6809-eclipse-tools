/*
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.bpy.electronics.mc6809.assembler.AssemblerRuntimeModule;
import org.bpy.electronics.mc6809.assembler.AssemblerStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class AssemblerIdeSetup extends AssemblerStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new AssemblerRuntimeModule(), new AssemblerIdeModule()));
	}
	
}
