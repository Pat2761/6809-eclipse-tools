package org.bpy.electronics.mc6809.preferences.ui.dialogs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Combo;

public class MacroInstructionWizardPage extends WizardPage {
	private Text txtMacroIstructionName;
	private Text txtOperandValue;

	private static HashMap<String, Boolean> possibleInstructions = new HashMap<>();
	private Combo comboInstruction;
	
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
	
	public MacroInstructionWizardPage() {
		super("MacroInstructionWizardPage");
		setTitle("Edit macro instruction");
		setDescription("Allow to define a macro instruction");
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
		
		Label lblEquivalentInstruction = new Label(container, SWT.NONE);
		lblEquivalentInstruction.setText("Equivalent instruction:");
		
		comboInstruction = new Combo(container, SWT.NONE);
		comboInstruction.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		Label lblOperand = new Label(container, SWT.NONE);
		lblOperand.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblOperand.setText("Operand:");
		
		txtOperandValue = new Text(container, SWT.BORDER);
		txtOperandValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		populateControl();
	}

	private void populateControl() {
		List<String> instructions = new ArrayList<>(possibleInstructions.keySet());
		Collections.sort(instructions);
		comboInstruction.add(" ");
		for (String instruction : instructions) {
			comboInstruction.add(instruction);
		}
		
		
	}
	
	
}
