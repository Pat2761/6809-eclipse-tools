/*
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.validation;


import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.ComposedChecks;

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@ComposedChecks(validators = {DirectiveValidator.class})
public class AssembledSourceValidator extends AbstractAssemblerValidator {
	

	@Check
	public void prepareValidation(Model model) {
	}
	
}
