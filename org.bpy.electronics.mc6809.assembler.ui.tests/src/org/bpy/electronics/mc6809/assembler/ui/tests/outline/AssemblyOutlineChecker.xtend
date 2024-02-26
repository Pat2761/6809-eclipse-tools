package org.bpy.electronics.mc6809.assembler.ui.tests.outline

import org.eclipse.xtext.ui.testing.AbstractOutlineTest
import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import org.bpy.electronics.mc6809.assembler.ui.tests.AssemblerUiInjectorProvider
import org.junit.Test

@RunWith(XtextRunner)
@InjectWith(AssemblerUiInjectorProvider)

class AssemblyOutlineChecker extends AbstractOutlineTest {
	
	@Test
	def void checkMacroDefinition() {
//		'''
//			.macro MAIN
//			NOP
//			SWI
//			.endm
//		'''.assertAllLabels('''
//		Main
//			NOP
//			SWI
//		''')
	}
}