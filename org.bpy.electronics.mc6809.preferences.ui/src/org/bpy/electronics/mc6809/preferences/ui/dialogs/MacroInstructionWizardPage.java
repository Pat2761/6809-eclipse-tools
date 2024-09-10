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
package org.bpy.electronics.mc6809.preferences.ui.dialogs;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerManager;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.ui.internal.AssemblerActivator;
import org.bpy.electronics.mc6809.preferences.core.data.MacroInstructionData;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Injector;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;

/**
 * Wizard page for create or modify a macro instruction
 * 
 * @author Patrick BRIAND
 *
 */
public class MacroInstructionWizardPage extends WizardPage {

	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(MacroInstructionWizardPage.class.getSimpleName());

	/** Contains the list of possible instructions */
	private static HashMap<String, Boolean> possibleInstructions = new HashMap<>();
	
	/** Initialization of the possible instructions */
	static {
		possibleInstructions.put("ABX", false);
		possibleInstructions.put("ADCA", true);
		possibleInstructions.put("ADCB", true);
		possibleInstructions.put("ADDA", true);
		possibleInstructions.put("ADDB", true);
		possibleInstructions.put("ADDD", true);
		possibleInstructions.put("ANDA", true);
		possibleInstructions.put("ANDB", true);
		possibleInstructions.put("ANDCC", true);
		possibleInstructions.put("ASLA", false);
		possibleInstructions.put("ASLB", false);
		possibleInstructions.put("ASL", true);
		possibleInstructions.put("ASRA", false);
		possibleInstructions.put("ASRB", false);
		possibleInstructions.put("ASR", true);
		possibleInstructions.put("BITA", true);
		possibleInstructions.put("BITB", true);
		possibleInstructions.put("ASR", true);
		possibleInstructions.put("CLRA", false);
		possibleInstructions.put("CLRB", false);
		possibleInstructions.put("CLR", true);
		possibleInstructions.put("CMPA", true);
		possibleInstructions.put("CMPB", true);
		possibleInstructions.put("CMPD", true);
		possibleInstructions.put("CMPX", true);
		possibleInstructions.put("CMPY", true);
		possibleInstructions.put("CMPU", true);
		possibleInstructions.put("CMPS", true);
		possibleInstructions.put("COMA", false);
		possibleInstructions.put("COMB", false);
		possibleInstructions.put("COM", true);
		possibleInstructions.put("CWAI", true);
		possibleInstructions.put("DAA", false);
		possibleInstructions.put("DECA", false);
		possibleInstructions.put("DECB", false);
		possibleInstructions.put("DEC", true);
		possibleInstructions.put("EORA", true);
		possibleInstructions.put("EORB", true);
		possibleInstructions.put("EXG", true);
		possibleInstructions.put("CMPS", true);
		possibleInstructions.put("INCA", false);
		possibleInstructions.put("INCB", false);
		possibleInstructions.put("INC", true);
		possibleInstructions.put("LDA", true);
		possibleInstructions.put("LDB", true);
		possibleInstructions.put("LDD", true);
		possibleInstructions.put("LDS", true);
		possibleInstructions.put("LDU", true);
		possibleInstructions.put("LDX", true);
		possibleInstructions.put("LDY", true);
		possibleInstructions.put("LEAS", true);
		possibleInstructions.put("LEAU", true);
		possibleInstructions.put("LEAY", true);
		possibleInstructions.put("LEAX", true);
		possibleInstructions.put("LSLA", false);
		possibleInstructions.put("LSLB", false);
		possibleInstructions.put("LSL", true);
		possibleInstructions.put("LSRA", false);
		possibleInstructions.put("LSRB", false);
		possibleInstructions.put("LSR", true);
		possibleInstructions.put("MUL", false);
		possibleInstructions.put("NEGA", false);
		possibleInstructions.put("NEGB", false);
		possibleInstructions.put("NEG", true);

		possibleInstructions.put("NOP", false);
		possibleInstructions.put("ORA", true);
		possibleInstructions.put("ORB", true);
		possibleInstructions.put("ORCC", true);
		possibleInstructions.put("PSHS", true);
		possibleInstructions.put("PSHU", true);
		possibleInstructions.put("PULS", true);
		possibleInstructions.put("PULU", true);
		possibleInstructions.put("ROLA", false);
		possibleInstructions.put("ROLB", false);
		possibleInstructions.put("ROL", true);
		possibleInstructions.put("RORA", false);
		possibleInstructions.put("RORB", false);
		possibleInstructions.put("ROR", true);
		possibleInstructions.put("RTI", false);
		possibleInstructions.put("RTS", false);
		possibleInstructions.put("SBCA", true);
		possibleInstructions.put("SBCB", true);
		possibleInstructions.put("SEX", false);
		possibleInstructions.put("STA", true);
		possibleInstructions.put("STB", true);
		possibleInstructions.put("STD", true);
		possibleInstructions.put("STX", true);
		possibleInstructions.put("STY", true);
		possibleInstructions.put("STU", true);
		possibleInstructions.put("STS", true);
		possibleInstructions.put("SUBA", true);
		possibleInstructions.put("SUBB", true);
		possibleInstructions.put("SUBD", true);
		possibleInstructions.put("SWI", false);
		possibleInstructions.put("SWI2", false);
		possibleInstructions.put("SWI3", false);
		possibleInstructions.put("SYNC", false);
		possibleInstructions.put("TFR", true);
		possibleInstructions.put("TSTA", false);
		possibleInstructions.put("TSTB", false);
		possibleInstructions.put("TST", true);
	}

	/** Widget for define the name of the macro instruction */
	private Text txtMacroIstructionName;
	/** Widget for define the operand of the instruction if necessary */
	private Text txtOperandValue;
	/** Widget for select the corresponding instruction */
	private Combo comboInstruction;
	
	/** name of the macro instruction */
	private String macroInstructionName;
	/** Name of the real instruction used */
	private String realInstructionName;
	/** Value of the operand */
	private String realOperandString;
	/** Opcode of the instruction */
	private int[] opcode;
	/** Operand of the instruction */
	private int[] operand;
	
	/** Collection of existing macro instructions */
	private Map<String, MacroInstructionData> existingMacroInstructions;

	/** Injector on the Game parser */
	private static final Injector injector = AssemblerActivator.getInstance().getInjector("org.bpy.electronics.mc6809.assembler.Assembler"); //$NON-NLS-1$

	
	/**
	 * Constructor of the class.
	 */
	public MacroInstructionWizardPage(Map<String,MacroInstructionData> existingMacroInstructions) {
		super("MacroInstructionWizardPage");
		
		this.existingMacroInstructions = existingMacroInstructions;
		setTitle("Edit macro instruction");
		setDescription("Allow to define a macro instruction");
	}

	/**
	 * Get the name of the macro instruction.
	 * 
	 * @return name of the macro instruction
	 */
	public String getMacroInstructionName() {
		return macroInstructionName;
	}

	/**
	 * Get the Name of the real instruction used.
	 * 
	 * @return Name of the real instruction used
	 */
	public String getRealInstructionName() {
		return realInstructionName;
	}

	/**
	 * get the value of the operand.
	 * 
	 * @return value of the operand
	 */
	public String getRealOperandString() {
		return realOperandString;
	}

	/**
	 * Get the opcode of the macro instruction
	 * 
	 * @return  opcode of the macro instruction
	 */
	public int[] getOpcode() {
		return opcode;
	}

	/**
	 * Get the operand of the macro instruction
	 * 
	 * @return  operand of the macro instruction
	 */
	public int[] getOperand() {
		return operand;
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);

		setControl(container);
		container.setLayout(new GridLayout(2, false));
		
		Label lblMacroInstructionName = new Label(container, SWT.NONE);
		lblMacroInstructionName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblMacroInstructionName.setText("Macro instruction name :");
		
		txtMacroIstructionName = new Text(container, SWT.BORDER);
		txtMacroIstructionName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtMacroIstructionName.addModifyListener(e -> updatePageState());
		
		Label lblEquivalentInstruction = new Label(container, SWT.NONE);
		lblEquivalentInstruction.setText("Equivalent instruction:");
		
		comboInstruction = new Combo(container, SWT.READ_ONLY);
		comboInstruction.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
	
		comboInstruction.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String instructionName = comboInstruction.getText();
				if (instructionName.isBlank() || !possibleInstructions.get(instructionName)) {
					txtOperandValue.setText("");
					txtOperandValue.setEnabled(false);
				} else {
					txtOperandValue.setEnabled(true);
				}
				updatePageState();
			}
		});
	
		Label lblOperand = new Label(container, SWT.NONE);
		lblOperand.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblOperand.setText("Operand:");
		
		txtOperandValue = new Text(container, SWT.BORDER);
		txtOperandValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtOperandValue.setEnabled(false);
		txtOperandValue.addModifyListener(e -> updatePageState());
		
		populateControl();
	}

	/**
	 * Populate the wizard.
	 */
	private void populateControl() {
		List<String> instructions = new ArrayList<>(possibleInstructions.keySet());
		Collections.sort(instructions);
		comboInstruction.add(" ");
		for (String instruction : instructions) {
			comboInstruction.add(instruction);
		}
		updatePageState();
	}

	/**
	 * Check the consistency of the informations defined in this wizard
	 */
	private void updatePageState() {
		
		if (txtMacroIstructionName.getText().isBlank()) {
			setErrorMessage("Macro instruction must be named");
			setPageComplete(false);
			return;
		}
		
		if (existingMacroInstructions.containsKey(txtMacroIstructionName.getText())) {
			setErrorMessage("Macro instruction " + txtMacroIstructionName.getText() + " already exist");
			setPageComplete(false);
			return;
		}
		
		if (comboInstruction.getSelectionIndex()<1) {
			setErrorMessage("You have to select an instruction");
			setPageComplete(false);
			return;
		}
		
		String instructionName = comboInstruction.getText();
		boolean needOperand  = possibleInstructions.get(instructionName);
		if (needOperand && txtOperandValue.getText().isBlank()) {
			setErrorMessage("An operand must be defined for the isntruction " + instructionName);
			setPageComplete(false);
			return;
		}
		
		String assemblerLine = " " + instructionName;
		if (needOperand) {
			assemblerLine +=  " " + txtOperandValue.getText();
		}
		assemblerLine += "\n";
		String message = parseAssemblyLine(assemblerLine);
		if (message != null) {
			setErrorMessage(message);
			setPageComplete(false);
			return;
		}
		
		setErrorMessage(null);
		setPageComplete(true);
	}

	/**
	 * Assemble and signal error or warnings if exist.
	 * 
	 * @param assemblerLine reference on the assembly line to assemble
	 * @return error or warning message, <b>null</b> if the line has no problems
	 */
	private String parseAssemblyLine(String assemblerLine) {

		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		resourceSet.addLoadOption(XtextResource.OPTION_RESOLVE_ALL, Boolean.TRUE);
		Resource resource = resourceSet.createResource(URI.createURI("dummy:/" + AssemblerManager.STUB_FILE_NAME));
		
		try {
			InputStream in = new ByteArrayInputStream(assemblerLine.getBytes());
		  
			resource.load(in, resourceSet.getLoadOptions());
			Model model = (Model) resource.getContents().get(0);
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(model,AssemblerManager.STUB_FILE_NAME);
			org.eclipse.emf.common.util.Diagnostic diagnostic = Diagnostician.INSTANCE.validate(model);

			EList<Diagnostic> errors = resource.getErrors();
			if (!errors.isEmpty()) {
				return errors.get(0).getMessage();
			}

			EList<Diagnostic> warnings = resource.getWarnings();
			if (!warnings.isEmpty()) {
				return warnings.get(0).getMessage();
			}

			List<org.eclipse.emf.common.util.Diagnostic> diagnostics = diagnostic.getChildren();
			if (!diagnostics.isEmpty()) {
				return diagnostics.get(0).getMessage();
			}

			// no errors so update data for memorisation
			updateValideData(engine);
			
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
		
		return null;
	}

	/**
	 * Set field information for create a new macro instruction.
	 * 
	 * @param engine reference on ghe assembly file engine
	 */
	private void updateValideData(AssemblerEngine engine) {
		macroInstructionName = txtMacroIstructionName.getText();
		realInstructionName = comboInstruction.getText();
		realOperandString = txtOperandValue.getText();
		
		AbstractInstructionAssemblyLine instructionLine = (AbstractInstructionAssemblyLine) engine.getAssembledLine().get(0);

	   opcode = Arrays.copyOf(instructionLine.getOpcode(), instructionLine.getOpcode().length);
	   operand = Arrays.copyOf(instructionLine.getOperand(), instructionLine.getOperand().length);
	}
}
