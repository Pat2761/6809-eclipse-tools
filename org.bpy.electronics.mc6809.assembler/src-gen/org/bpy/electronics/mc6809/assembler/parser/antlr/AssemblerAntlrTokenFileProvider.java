/*
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class AssemblerAntlrTokenFileProvider implements IAntlrTokenFileProvider {

	@Override
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		return classLoader.getResourceAsStream("org/bpy/electronics/mc6809/assembler/parser/antlr/internal/InternalAssembler.tokens");
	}
}
