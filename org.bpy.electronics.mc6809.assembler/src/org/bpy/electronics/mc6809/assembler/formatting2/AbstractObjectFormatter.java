package org.bpy.electronics.mc6809.assembler.formatting2;

import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.IHiddenRegionFormatting;
import org.eclipse.xtext.formatting2.ITextReplacer;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

import com.google.common.base.Strings;

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
		int nbSpacesNeeded = operandPosition- startWsPosition;
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
	private void setWhiteSpace(EObject line, EAttribute elementAttribut, int nbSpaces) {
	
		final String spaces = getSpacesNeeded(nbSpaces);
		
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
	
	private String getSpacesNeeded(int nbSpaces) {
		int instructionSize = getInstructioName().length();

		if (PreferenceManager.SPACE_ONLY.equals(tabPolicy)) {
			return Strings.repeat(" ", nbSpaces);

		} else if (PreferenceManager.TAB_ONLY.equals(tabPolicy)) {
			int nbTabsNeeded = ((instructionSize%tabSize)==0) ? nbSpaces/tabSize : nbSpaces/tabSize + 1;
			if (nbTabsNeeded<1) {
				nbTabsNeeded =1;
			}
			return Strings.repeat("\t", nbTabsNeeded);

		} else {
			StringBuilder strBuilder = new StringBuilder();

			int nbTabsNeeded = ((instructionSize%tabSize)==0) ? nbSpaces/tabSize -1: nbSpaces/tabSize;
			if (nbTabsNeeded<0) {
				nbTabsNeeded =0;
			}
			strBuilder.append(Strings.repeat("\t", nbTabsNeeded));
			int tabRepresentation = nbTabsNeeded*tabSize;
			int nbSpacesMissing = nbSpaces-tabRepresentation;
			strBuilder.append(Strings.repeat(" ", instructionSize%tabSize) );
			if (nbSpacesMissing != 0) {
				strBuilder.append(Strings.repeat(" ", nbSpacesMissing));
			}
			return strBuilder.toString();
		}
	}


}
