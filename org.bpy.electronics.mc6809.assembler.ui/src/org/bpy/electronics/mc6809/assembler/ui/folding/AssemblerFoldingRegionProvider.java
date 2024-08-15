/*
 * MC6809 Toolkit
 * Copyright (C) 2023  Patrick BRIAND
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.bpy.electronics.mc6809.assembler.ui.folding;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import org.bpy.electronics.mc6809.assembler.assembler.MacroDefinition;
import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldedPosition;
import org.eclipse.xtext.ui.editor.folding.DefaultFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.folding.FoldedPosition;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionAcceptor;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionAcceptorExtension;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.ITextRegion;

import com.google.common.collect.Sets;

/**
 * Provide folder mechanism.
 * 
 * @author Patrick BRIAND
 *
 */
public class AssemblerFoldingRegionProvider  extends DefaultFoldingRegionProvider {

	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(AssemblerFoldingRegionProvider.class.getSimpleName());	
	Pattern commentLineRegex = Pattern.compile("^\\s*;");

	@Override
	protected Collection<FoldedPosition> doGetFoldingRegions(IXtextDocument xtextDocument, XtextResource xtextResource) {
		Collection<FoldedPosition> result = Sets.newLinkedHashSet();
		IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor = createAcceptor(xtextDocument, result);
		if (PreferenceManager.getInstance().getEnableFolding()) {

			if (PreferenceManager.getInstance().getMacroFolding()) {
				computeObjectFolding(xtextResource, foldingRegionAcceptor);
			}	
	
			if (PreferenceManager.getInstance().getCommentFolding()) {
				result.addAll(getCommentRegionsFolding(xtextDocument));
			}
		}
		return result;
	}
	
	@Override
	protected void computeObjectFolding(EObject eObject, IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
		if (eObject instanceof MacroDefinition) {
		    computeMacrosFolding(eObject, foldingRegionAcceptor);
		}
	}

	/**
	 * create the collection of folding comment elements.
	 * 
	 * @param xtextDocument reference on the XTEXT document
	 * 
	 * @return collection of folding elements
	 */
	public Collection<FoldedPosition> getCommentRegionsFolding(IXtextDocument xtextDocument) {
		List<FoldedPosition> folderedPositions = new ArrayList<>();
		
		try {
			
			int i=0;
			while (i < xtextDocument.getNumberOfLines()-1) {
				int nbSuccesiveComments = getNbSuccesiveComments(xtextDocument, i);
				if (nbSuccesiveComments > 1) {
					folderedPositions.add(newFolderedPosition(xtextDocument, i, i+nbSuccesiveComments));
					i += nbSuccesiveComments;
				} else {
					i++;
				}
			}
			
		} catch (BadLocationException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		return folderedPositions;
	}

	/**
	 * Compute a comment folding element
	 * 
	 * @param xtextDocument reference on the XTEXT document
	 * @param startLine first line to fold
	 * @param endLine last line to fold
	 * 
	 * @return a folding comment element
	 * 
	 * @throws BadLocationException in case of wrong position
	 */
	private FoldedPosition newFolderedPosition(IXtextDocument xtextDocument, int startLine, int endLine) throws BadLocationException {

		int offset = xtextDocument.getLineOffset(startLine);
		int contentStart = 0;
		int contentLength = xtextDocument.getLineLength(startLine);
		int length = xtextDocument.getLineOffset(endLine)-offset;
		DefaultFoldedPosition defaultFolderPosition = new DefaultFoldedPosition(offset, length, contentStart, contentLength);
		defaultFolderPosition.setInitiallyFolded(true);
		return defaultFolderPosition;
	}

	/**
	 * Compute the number of consecutive comments.
	 * 
	 * @param xtextDocument reference on the XTEXT document
	 * @param i line number
	 * @return number of consecutive comments line
	 * 
	 * @throws BadLocationException in case of wrong position
	 */
	private int getNbSuccesiveComments(IXtextDocument xtextDocument, int i) throws BadLocationException {
		int commentLineCounter = 1;
		String textLine = xtextDocument.get(xtextDocument.getLineOffset(i), xtextDocument.getLineLength(i));
		if (commentLineRegex.matcher(textLine).find()) {
			while (i<xtextDocument.getNumberOfLines()) {
				i++;
				textLine = xtextDocument.get(xtextDocument.getLineOffset(i), xtextDocument.getLineLength(i));
				if (commentLineRegex.matcher(textLine).find()) {
					commentLineCounter++;
				} else {
					break;
				}
			}
		}	
		return commentLineCounter;
	}

	/**
	 * Create folder structure for macros declaration.
	 * 
	 * @param eObject Reference on the macro definition
	 * @param foldingRegionAcceptor reference on the folder acceptor
	 */
	private void computeMacrosFolding(EObject eObject, IFoldingRegionAcceptor<ITextRegion> foldingRegionAcceptor) {
		ILocationInFileProvider locationInFileProvider = getLocationInFileProvider();
		ITextRegion region = locationInFileProvider.getFullTextRegion(eObject);
		if (region != null) {
			ITextRegion significant = locationInFileProvider.getSignificantTextRegion(eObject);
			if (significant == null)
				throw new NullPointerException("significant region may not be null");
			int offset = region.getOffset();
			((IFoldingRegionAcceptorExtension<ITextRegion>)foldingRegionAcceptor).accept(offset, region.getLength(), true, significant);
		}
	}
}
