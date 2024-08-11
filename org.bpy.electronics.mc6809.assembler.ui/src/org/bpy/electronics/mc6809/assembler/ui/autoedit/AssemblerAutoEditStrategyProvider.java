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
package org.bpy.electronics.mc6809.assembler.ui.autoedit;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AssemblerAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {

	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(AssemblerAutoEditStrategyProvider.class.getSimpleName());
	
	@Inject
	Provider<IGrammarAccess> iGrammar;

	@Override
	protected void configureIndentationEditStrategy(IEditStrategyAcceptor acceptor) {
		int instructionPosition = PreferenceManager.getInstance().getInstructionPosition();
		int operandPosition = PreferenceManager.getInstance().getOperandPosition();
		int commentPosition = PreferenceManager.getInstance().getCommentPosition();

		IAutoEditStrategy strategy = new IAutoEditStrategy() {

			@Override
			public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
				try {
					if ("\t".equals(command.text)) {
						int lineNumber = document.getLineOfOffset(command.offset);
						int lineStart = document.getLineOffset(lineNumber);

						int commandOffset = computeCursorPosition(document, lineStart, command.offset);
						if (commandOffset < instructionPosition-1) {
							command.text = computeInstructionPositionSpace(document, command);

						} else if (commandOffset < operandPosition-1) {
							command.text = computeOperandPositionSpace(document, command);
						
						} else if (commandOffset <= commentPosition-1) {
							command.text = computeCommentPositionSpace(document, command);
						}	
					}
				} catch (Exception e) {
					logger.log(Level.SEVERE, e.getMessage());
				}
			}
		};
			
		acceptor.accept(strategy, IDocument.DEFAULT_CONTENT_TYPE);
	}

	/**
	 * generate space for auto indentation to comment position
	 * 
	 * @param document reference on the document
	 * @param command reference on the command

	 * @return String with tabs and spaces
	 * 
	 * @throws BadLocationException in case of bad location
	 */
	protected String computeCommentPositionSpace(IDocument document, DocumentCommand command) throws BadLocationException {
		int commentPosition = PreferenceManager.getInstance().getCommentPosition();
		String tabPolicy = PreferenceManager.getInstance().getTabPolicy();

		int lineNumber = document.getLineOfOffset(command.offset);
		int lineStart = document.getLineOffset(lineNumber);
		
		int nbSpacesNeeded = commentPosition -1 -(command.offset - lineStart);

		if (PreferenceManager.SPACE_ONLY.equals(tabPolicy)) {
			return Strings.repeat(" ", nbSpacesNeeded);

		} else if (PreferenceManager.TAB_ONLY.equals(tabPolicy)) {
			return computeNbTabsAndSpacesNeeded(document, command, commentPosition);

		} else if (PreferenceManager.MIXED.equals(tabPolicy)) {
			return computeNbTabsAndSpacesNeeded(document, command, commentPosition);

		}
		return " ";
	}

	/**
	 * generate space for auto indentation to operand position
	 * 
	 * @param document reference on the document
	 * @param command reference on the command

	 * @return String with tabs and spaces
	 * 
	 * @throws BadLocationException in case of bad location
	 */
	protected String computeOperandPositionSpace(IDocument document, DocumentCommand command) throws BadLocationException {
		int operandPosition = PreferenceManager.getInstance().getOperandPosition();
		String tabPolicy = PreferenceManager.getInstance().getTabPolicy();

		int lineNumber = document.getLineOfOffset(command.offset);
		int lineStart = document.getLineOffset(lineNumber);
		
		int nbSpacesNeeded = operandPosition -1 -(command.offset - lineStart);

		if (PreferenceManager.SPACE_ONLY.equals(tabPolicy)) {
			return Strings.repeat(" ", nbSpacesNeeded);

		} else if (PreferenceManager.TAB_ONLY.equals(tabPolicy)) {
			return computeNbTabsAndSpacesNeeded(document, command, operandPosition);

		} else if (PreferenceManager.MIXED.equals(tabPolicy)) {
			return computeNbTabsAndSpacesNeeded(document, command, operandPosition);

		}
		return " ";
	}

	/**
	 * generate space for auto indentation to instruction position
	 * 
	 * @param document reference on the document
	 * @param command reference on the command

	 * @return String with tabs and spaces
	 * 
	 * @throws BadLocationException in case of bad location
	 */
	protected String computeInstructionPositionSpace(IDocument document, DocumentCommand command) throws BadLocationException {

		int lineNumber = document.getLineOfOffset(command.offset);
		int lineStart = document.getLineOffset(lineNumber);
		
		int instructionPosition = PreferenceManager.getInstance().getInstructionPosition();		
		String tabPolicy = PreferenceManager.getInstance().getTabPolicy();
		if (PreferenceManager.SPACE_ONLY.equals(tabPolicy)) {
			int nbSpacesNeeded = instructionPosition -1 -(command.offset - lineStart);
			return Strings.repeat(" ", nbSpacesNeeded);

		} else if (PreferenceManager.TAB_ONLY.equals(tabPolicy)) {
			return computeNbTabsAndSpacesNeeded(document, command, instructionPosition);

		} else if (PreferenceManager.MIXED.equals(tabPolicy)) {
			return computeNbTabsAndSpacesNeeded(document, command, instructionPosition);

		}
		return " ";
	}

	/**
	 * Create a string which contains tabs and spaces for reach the target column.
	 * 
	 * @param document reference on the document
	 * @param command reference on the command
	 * @param target target column
	 * 
	 * @return String with tabs and spaces
	 * 
	 * @throws BadLocationException in case of bad location
	 */
	private String computeNbTabsAndSpacesNeeded(IDocument document, DocumentCommand command, int target) throws BadLocationException {
		int lineNumber = document.getLineOfOffset(command.offset);
		int lineStart = document.getLineOffset(lineNumber);
		int tabSize = PreferenceManager.getInstance().getEditorTabSize();
 
		int nbTabsNeeded = 0;
		int cursorPosition = computeCursorPosition(document, lineStart, command.offset);
		if (cursorPosition%tabSize > 0) {
			nbTabsNeeded++;
			cursorPosition += (tabSize - cursorPosition%tabSize)-1;   
		}
		nbTabsNeeded += ((target-cursorPosition)/tabSize);
		cursorPosition += nbTabsNeeded*tabSize;
		
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(Strings.repeat("\t", nbTabsNeeded));
		if (target> cursorPosition) {
			strBuilder.append(Strings.repeat(" ", target -1 - cursorPosition));
		}
		return strBuilder.toString();
	}

	/**
	 * Compute the cursor position in the line.
	 * 
	 * @param document Reference on the document
	 * @param lineStart Index of the start line
	 * @param offset Position in char of the cursor in the document
	 * 
	 * @return cursor position  
	 * @throws BadLocationException bad location
	 */
	protected int computeCursorPosition(IDocument document, int lineStart, int offset) throws BadLocationException {
		
		int tabSise = PreferenceManager.getInstance().getEditorTabSize();
		String values = document.get(lineStart, offset - lineStart);
		int cursorPosition = 0;
		for (byte currentChar : values.getBytes()) {
			if ('\t' == currentChar) {
				cursorPosition += tabSise;
				cursorPosition -= cursorPosition%tabSise;
			} else {
				cursorPosition++;
			}
		}
		return cursorPosition;
	}
}
