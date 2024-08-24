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

public class ListingPreferencePage extends PreferencePage implements IWorkbenchPreferencePage {
	private Spinner lineNumberSize;
	private Spinner adresseColumnSize;
	private Spinner instructionColumnSize;
	private Spinner labelColumnSize;
	private Spinner operandInstColumnSize;
	private Combo cboOrientation;
	private Spinner opcodeColumnSize;
	private Spinner operandColumnSize;

	/**
	 * @wbp.parser.constructor
	 */
	public ListingPreferencePage() {
		setTitle("Define listing preferences");
	}

	public ListingPreferencePage(String title) {
		super(title);
	}

	public ListingPreferencePage(String title, ImageDescriptor image) {
		super(title, image);
	}

	@Override
	public void init(IWorkbench workbench) {
	}

	@Override
	protected Control createContents(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		container.setLayout(new GridLayout(2, false));
		
		Label lblPageOrientation = new Label(container, SWT.NONE);
		lblPageOrientation.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblPageOrientation.setText("Page orientation");
		
		cboOrientation = new Combo(container, SWT.NONE);
		cboOrientation.setItems(new String[] {"Landscape", "Portrait"});
		cboOrientation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
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
