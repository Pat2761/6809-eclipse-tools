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
package org.bpy.electronics.mc6809.assembler.ui.highlighting;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * Define coloring elements
 * 
 * @author Patrick BRIAND
 *
 */
public class AssemblerHighlightingConfiguration implements IHighlightingConfiguration {

	/** Constant for coloring Comments */
	public static final String COMMENT_ID = HighlightingStyles.COMMENT_ID;
	/** Constant for coloring String */
	public static final String STRING_ID = HighlightingStyles.STRING_ID;
	/** Constant for coloring Number */
	public static final String NUMBER_ID = HighlightingStyles.NUMBER_ID;

	/** Constant for coloring Comments */
	public static final String LABEL_ID = "labelID";
	/** Constant for coloring Comments */
	public static final String MACRO_ID = "macroID";
	/** Constant for coloring Identifier */
	public static final String IDENTIFIER_ID = "identifierID";
	/** Constant for coloring directive */
	public static final String DIRECTIVE_NAME_ID = "directiveNameID";
	/** Constant for coloring directive */
	public static final String INSTRUCTION_NAME_ID = "instructionNameID";
	/** Constant for coloring directive */
	public static final String CALL_SUBROUTINE_ID = "callSubRoutineID";
	/** Constant for coloring Identifier */
	public static final String BRANCH_ID = "branchID";
	/** Constant for coloring Identifier */
	public static final String REGISTER_ID = "registerID";

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(STRING_ID, "String", stringTextStyle());
		acceptor.acceptDefaultHighlighting(NUMBER_ID, "Number", numberTextStyle());

		acceptor.acceptDefaultHighlighting(COMMENT_ID, "Comment", commentTextStyle());
		acceptor.acceptDefaultHighlighting(LABEL_ID, "Label", labelTextStyle());
		acceptor.acceptDefaultHighlighting(MACRO_ID, "Macro", macroTextStyle());
		acceptor.acceptDefaultHighlighting(IDENTIFIER_ID, "Identifier", identifierTextStyle());
		acceptor.acceptDefaultHighlighting(DIRECTIVE_NAME_ID, "Directive name", directiveNameTextStyle());
		acceptor.acceptDefaultHighlighting(INSTRUCTION_NAME_ID, "Instruction name", instructionNameTextStyle());
		acceptor.acceptDefaultHighlighting(CALL_SUBROUTINE_ID, "Call subroutine", callSubroutineTextStyle());
		acceptor.acceptDefaultHighlighting(BRANCH_ID, "Branch instruction", branchStyle());
		acceptor.acceptDefaultHighlighting(REGISTER_ID, "Register", registerStyle());
	}

	/**
	 * get the default style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle defaultTextStyle() {
		return new TextStyle();
	}

	/**
	 * get the register style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle registerStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(102, 102, 0));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	/**
	 * get the sub routine style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle callSubroutineTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(153, 0, 0));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	/**
	 * get the instruction name style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle instructionNameTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 18, 154));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	/**
	 * get the branch instruction style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle branchStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(153, 0, 153));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	/**
	 * get the directive style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle directiveNameTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(55, 125, 34));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	/**
	 * get the identifier style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle identifierTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(255, 255, 255));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	/**
	 * get the label style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle labelTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 153, 0));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	/**
	 * get the macro style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle macroTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(157, 118, 207));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	/**
	 * get the number style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle numberTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(176, 98, 31));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	/**
	 * get the String style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle stringTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(42, 0, 255));
		return textStyle;
	}

	/**
	 * get the comment style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle commentTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(128, 128, 128));
		return textStyle;
	}
}
