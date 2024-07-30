package org.bpy.electronics.mc6809.assembler.formatting2;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

public abstract class AbstractObjectFormatter {

	protected IFormattableDocument document;
	protected String tabPolicy;
	protected int tabSize;
	protected int instructionPosition;
	protected int operandPosition;
	protected AssemblerFormatter assemblerFormatter;

	public abstract String getInstructioName();
	public abstract EAttribute getSeparatorAttribute();
	public abstract EObject getInstruction();
	public abstract EObject getOperand();
	public abstract void format(AssemblerFormatter assemblerFormatter, EObject instruction, int instructionPosition, int operandPosition);
	
	protected AbstractObjectFormatter(IFormattableDocument doc, String tabPolicy, int tabSize) {
		this.document = doc;
		this.tabPolicy = tabPolicy;
		this.tabSize = tabSize;
	}

	protected void format() {
		int startWsPosition = instructionPosition + getInstructioName().length();
		int nbSpacesNeeded = operandPosition-startWsPosition;
		if (nbSpacesNeeded<1) {
			nbSpacesNeeded = 1; 
		}
		
		if (getOperand() != null) {
			setWhiteSpace(getInstruction(), getSeparatorAttribute(), nbSpacesNeeded);
		}	
	}

	/**
	 * Set white space.
	 *  
	 * @param document reference on the document
	 * @param line reference on the instruction or directive line
	 * @param elementAttribut reference on the white space to remove 
	 */
	protected void setWhiteSpace(EObject line, EAttribute elementAttribut, int nbSpaces) {
	
		final String spaces = assemblerFormatter.buildSpaceStringFromPolicy(getInstructioName().length(),nbSpaces,instructionPosition);
		
		IHiddenRegionFormatting hiddenRegion = document.getFormatter().createHiddenRegionFormatting();
		Procedure1<IHiddenRegionFormatting> spcFunction = it -> it.setSpace(spaces);

		ITextRegionExtensions textRegionExtensions = assemblerFormatter.getTextRegionFormatter();
		
		IHiddenRegionFormatting fmt = ObjectExtensions.<IHiddenRegionFormatting>operator_doubleArrow(hiddenRegion, spcFunction);
		ITextReplacer replacer = assemblerFormatter.createWhitespaceReplacer(textRegionExtensions.regionFor(line).feature(elementAttribut), fmt);
		try {
			document.addReplacer(replacer);
		} catch (Exception ex) {
			//	Nothing to do, just for avoid unexpected messages
		}
	}
}
