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
package org.bpy.electronics.mc6809.preferences.ui;

import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Spinner;

/**
 * Page which allow to define preference for listing generation
 * 
 * @author Patrick BRIAND
 *
 */
public class ListingPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	/** characters number for line number information */ 
	private Spinner lineNumberSize;
	/** characters number for address information */ 
	private Spinner adresseColumnSize;
	/** characters number for instruction information */ 
	private Spinner instructionColumnSize;
	/** characters number for lebel information */ 
	private Spinner labelColumnSize;
	/** characters number for operand information */ 
	private Spinner operandInstColumnSize;
	/** characters number for page orientation information */ 
	private Combo cboOrientation;
	/** characters number for opcode information */ 
	private Spinner opcodeColumnSize;
	/** characters number for operand information */ 
	private Spinner operandColumnSize;

	/**
	 * Constructor of the class.
	 * 
	 * @wbp.parser.constructor
	 */
	public ListingPreferencePage() {
		setTitle("Define listing preferences");
	}

	/**
	 * Constructor of the class.
	 * .
	 * @param title title of the preference page
	 */
	public ListingPreferencePage(String title) {
		super(title);
	}

	/**
	 * Constructor of the class.
	 * .
	 * @param title title of the preference page
	 * @param image image in the header of the preference page
	 */
	public ListingPreferencePage(String title, ImageDescriptor image) {
		super(title, image);
	}

	@Override
	public void init(IWorkbench workbench) {
		// nothing to do
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout(2, false));
		
		Label lblPageOrientation = new Label(container, SWT.NONE);
		lblPageOrientation.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPageOrientation.setText("Page orientation");
		
		cboOrientation = new Combo(container, SWT.NONE);
		cboOrientation.setItems("Landscape", "Portrait");
		cboOrientation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		new Label(container, SWT.NONE);
		new Label(container, SWT.NONE);
		
		Group grpDefineNumbersOf = new Group(container, SWT.SHADOW_ETCHED_IN);
		grpDefineNumbersOf.setText("define numbers of space for each column");
		grpDefineNumbersOf.setLayout(new GridLayout(2, false));
		grpDefineNumbersOf.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));
		
		Label lblLineNumberColumn = new Label(grpDefineNumbersOf, SWT.NONE);
		lblLineNumberColumn.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
		lblLineNumberColumn.setText("Line number column");
		
		lineNumberSize = new Spinner(grpDefineNumbersOf, SWT.BORDER);
		lineNumberSize.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		lineNumberSize.setMaximum(10);
		lineNumberSize.setMinimum(4);
		
		Label lblAddressColumn = new Label(grpDefineNumbersOf, SWT.NONE);
		lblAddressColumn.setText("Address column");
		
		adresseColumnSize = new Spinner(grpDefineNumbersOf, SWT.BORDER);
		adresseColumnSize.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		adresseColumnSize.setMaximum(20);
		adresseColumnSize.setMinimum(4);
		
		Label lblOpcodeColumn = new Label(grpDefineNumbersOf, SWT.NONE);
		lblOpcodeColumn.setText("Opcode column");
		
		opcodeColumnSize = new Spinner(grpDefineNumbersOf, SWT.BORDER);
		opcodeColumnSize.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		opcodeColumnSize.setMaximum(10);
		opcodeColumnSize.setMinimum(6);
		
		Label lblOperandColumn = new Label(grpDefineNumbersOf, SWT.NONE);
		lblOperandColumn.setText("Operand Column");
		
		operandColumnSize = new Spinner(grpDefineNumbersOf, SWT.BORDER);
		operandColumnSize.setMinimum(6);
		
		Label lblLabelColumn = new Label(grpDefineNumbersOf, SWT.NONE);
		lblLabelColumn.setText("Label column");
		
		labelColumnSize = new Spinner(grpDefineNumbersOf, SWT.BORDER);
		labelColumnSize.setMinimum(6);
		
		Label lblInstructionColumn = new Label(grpDefineNumbersOf, SWT.NONE);
		lblInstructionColumn.setText("Instruction Column");
		
		instructionColumnSize = new Spinner(grpDefineNumbersOf, SWT.BORDER);
		instructionColumnSize.setMinimum(5);
		
		Label lblOperandInstructionColumn = new Label(grpDefineNumbersOf, SWT.NONE);
		lblOperandInstructionColumn.setText("Operand instruction column");
		
		operandInstColumnSize = new Spinner(grpDefineNumbersOf, SWT.BORDER);
		operandInstColumnSize.setMinimum(20);
		
		intializeContent();
		container.pack();
		return container;
	}

	/** 
	 * Initialize the content of the preference page
	 */
	private void intializeContent() {
		if ("Landscape".equals(PreferenceManager.getInstance().getListingPageOrientation())) {
			cboOrientation.select(0);
		} else {
			cboOrientation.select(1);
		}
		lineNumberSize.setSelection(PreferenceManager.getInstance().getListingLineNumberSize());
		adresseColumnSize.setSelection(PreferenceManager.getInstance().getListingAddressSize());
		opcodeColumnSize.setSelection(PreferenceManager.getInstance().getListingOpcodeSize());
		operandColumnSize.setSelection(PreferenceManager.getInstance().getListingOperandSize());
		labelColumnSize.setSelection(PreferenceManager.getInstance().getListingLabelSize());
		instructionColumnSize.setSelection(PreferenceManager.getInstance().getListingInstructionSize());
		operandInstColumnSize.setSelection(PreferenceManager.getInstance().getListingOperandInstructionSize());
	}

	@Override
	protected void performApply() {
		PreferenceManager.getInstance().setListingPageOrientation(cboOrientation.getItem(cboOrientation.getSelectionIndex()));
		PreferenceManager.getInstance().setListingLineNumberSize(lineNumberSize.getSelection());
		PreferenceManager.getInstance().setListingAddressSize(adresseColumnSize.getSelection());
		PreferenceManager.getInstance().setListingOpcodeSize(opcodeColumnSize.getSelection());
		PreferenceManager.getInstance().setListingOperandize(operandColumnSize.getSelection());
		PreferenceManager.getInstance().setListingLabelize(labelColumnSize.getSelection());
		PreferenceManager.getInstance().setListingInstructionize(instructionColumnSize.getSelection());
		PreferenceManager.getInstance().setListingOperandInstructionize(operandInstColumnSize.getSelection());
	}

	@Override
	protected void performDefaults() {
		PreferenceManager.getInstance().setListingPageOrientation(PreferenceManager.DEFAULT_LISTING_ORIENTATION);
		if ("Landscape".equals(PreferenceManager.DEFAULT_LISTING_ORIENTATION)) {
			cboOrientation.select(0);
		} else {
			cboOrientation.select(1);
		}
		
		PreferenceManager.getInstance().setListingLineNumberSize(PreferenceManager.DEFAULT_LISTING_LINE_NUMBER_SPACES);
		lineNumberSize.setSelection(PreferenceManager.DEFAULT_LISTING_LINE_NUMBER_SPACES);
		PreferenceManager.getInstance().setListingAddressSize(PreferenceManager.DEFAULT_LISTING_ADDRESS_NUMBER_SPACES);
		adresseColumnSize.setSelection(PreferenceManager.DEFAULT_LISTING_ADDRESS_NUMBER_SPACES);
		PreferenceManager.getInstance().setListingOpcodeSize(PreferenceManager.DEFAULT_LISTING_OPCODE_NUMBER_SPACES);
		opcodeColumnSize.setSelection(PreferenceManager.DEFAULT_LISTING_OPCODE_NUMBER_SPACES);
		PreferenceManager.getInstance().setListingOperandize(PreferenceManager.DEFAULT_LISTING_OPERAND_NUMBER_SPACES);
		operandColumnSize.setSelection(PreferenceManager.DEFAULT_LISTING_OPERAND_NUMBER_SPACES);
		PreferenceManager.getInstance().setListingLabelize(PreferenceManager.DEFAULT_LISTING_LABEL_NUMBER_SPACES);
		labelColumnSize.setSelection(PreferenceManager.DEFAULT_LISTING_LABEL_NUMBER_SPACES);
		PreferenceManager.getInstance().setListingInstructionize(PreferenceManager.DEFAULT_LISTING_INSTRUCTION_NUMBER_SPACES);
		instructionColumnSize.setSelection(PreferenceManager.DEFAULT_LISTING_INSTRUCTION_NUMBER_SPACES);
		PreferenceManager.getInstance().setListingOperandInstructionize(PreferenceManager.DEFAULT_LISTING_OPERAND_INSTRUCTION_NUMBER_SPACES);
		operandInstColumnSize.setSelection(PreferenceManager.DEFAULT_LISTING_OPERAND_INSTRUCTION_NUMBER_SPACES);
		super.performDefaults();
	}

	@Override
	public boolean performOk() {
		performApply();
		return super.performOk();
	}

}
