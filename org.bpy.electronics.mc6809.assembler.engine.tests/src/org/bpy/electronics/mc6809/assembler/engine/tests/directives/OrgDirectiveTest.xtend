package org.bpy.electronics.mc6809.assembler.engine.tests.directives

import org.junit.runner.RunWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.InjectWith
import org.bpy.electronics.mc6809.assembler.tests.AssemblerInjectorProvider
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import org.bpy.electronics.mc6809.assembler.assembler.Model
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine
import org.junit.Assert

@RunWith(XtextRunner)
@InjectWith(AssemblerInjectorProvider)

class OrgDirectiveTest {
	@Inject ParseHelper<Model> parseHelper
	@Inject extension ValidationTestHelper
	
	@Test
	def void checkSimpleORGDirective() {
				val result = parseHelper.parse('''
		;******************************************************
		Test		ORG 	$8000		; Start code at $8000	
				''')
		Assert.assertNotNull(result)
		result.assertNoErrors
				
		val engine = new AssemblerEngine()		
		engine.engine(result)
		
		print(engine)
	}
}