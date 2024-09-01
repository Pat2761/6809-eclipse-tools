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
 * You shoust have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.bpy.electronics.mc6809.rcp.views;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.assembler.AssemblerStandaloneSetup;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Register;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerManager;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.comment.AssembledBlankLine;
import org.bpy.electronics.mc6809.assembler.engine.data.comment.AssembledCommentLine;
import org.bpy.electronics.mc6809.assembler.engine.data.comment.AssembledLabelLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AbstractAssembledDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledBszDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledEndDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledEquDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFcbDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFccDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFdbDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFillDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledNamDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledOptDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledOrgDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledPagDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledRegDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledRmbDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledSetDPDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledSetDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledSpcDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.*;
import org.bpy.electronics.mc6809.assembler.engine.data.others.MacroAssembledElement;
import org.bpy.electronics.mc6809.assembler.engine.data.others.MacroDeclarationElement;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CaretListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.xbase.lib.Extension;

import com.google.inject.Inject;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

/**
 * Display the result of the assembly file in a Nebula grid.
 * 
 * @author Patrick BRIAND
 *
 */
public class AssemblyView extends ViewPart /*implements IAssemblerChangeListener*/ {

	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(AssemblyView.class.getName());

	/** Format definition for display a byte value */
	private static final String BYTE_FORMAT = "%02X ";
	/** Format definition for display a word value */
	private static final String WORD_FORMAT = "%04X ";

	/** Column number of the line number */
	private static final int LINE_NUMBER_COLUMN = 0;
	/** Column number of the address of the instruction */
	private static final int ADDRESS_COLUMN = 1;
	/** Column number of the code of the instruction */
	private static final int CODE_COLUMN = 2;
	/** Column number of the label of the instruction */
	private static final int LABEL_COLUMN = 3;
	/** Column number of the instruction name */
	private static final int INSTRUCTION_COLUMN = 4;
	/** Column number of the instruction operand */
	private static final int OPERAND_COLUMN = 5;
	/** Column number of the instruction comment */
	private static final int COMMENT_COLUMN = 6;

	/** Reference on the serializer */
	@Inject
	@Extension
	private ISerializer serializer;

	/** reference on the grid */
	private Grid grid;

	private Timer timer;

	/** Caret Listener */
	private CaretListener caretListener;

	/**
	 * Constructor of the class. Initiate the injector
	 */
	public AssemblyView() {
		com.google.inject.Injector injector = new AssemblerStandaloneSetup().createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
	}

	@Override
	public void createPartControl(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(1, false));

		grid = new Grid(composite, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		grid.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		grid.setVisibleLinesColumnPack(true);
		grid.setSelectionEnabled(false);
		grid.setAutoHeight(true);
		grid.setFont(SWTResourceManager.getFont("Courier New", 10, SWT.NORMAL));
		grid.setHeaderVisible(true);

		GridColumn column = new GridColumn(grid, SWT.NONE | SWT.TOGGLE);
		column.setText("N°");
		column.setWidth(60);
		column.setTree(true);
		GridColumn column2 = new GridColumn(grid, SWT.NONE);
		column2.setText("Addr");
		column2.setWidth(70);
		GridColumn column3 = new GridColumn(grid, SWT.NONE);
		column3.setText("Code");
		column3.setWidth(100);
		GridColumn column4 = new GridColumn(grid, SWT.NONE);
		column4.setText("Label");
		column4.setWidth(100);

		GridColumn column5 = new GridColumn(grid, SWT.NONE);
		column5.setText("Instruction");
		column5.setWidth(100);
		GridColumn column6 = new GridColumn(grid, SWT.NONE);
		column6.setText("Operand");
		column6.setWidth(150);
		GridColumn column7 = new GridColumn(grid, SWT.NONE);
		column7.setText("Comment");
		column7.setWidth(600);
		initializeListener();
	}

	/**
	 * Initialize the listener
	 */
	protected void initializeListener() {

		caretListener = event -> {
			IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
			if ((currentEditor != null) && (currentEditor instanceof XtextEditor xtextEditor)) {
				String fileName = xtextEditor.getResource().getFullPath().toOSString();
				AssemblerEngine engine = AssemblerManager.getInstance().getRegistredAssemblyEngine(fileName);
				if (engine != null) {
	//				ManageUpdateDisplay(engine);
				}
			}
		};

		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().addPartListener(new IPartListener() {

			@Override
			public void partOpened(IWorkbenchPart part) {
				
				IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if ((currentEditor != null) && (currentEditor instanceof XtextEditor xtextEditor)) {
					Control control = currentEditor.getAdapter(Control.class);
					if (control instanceof StyledText text) {
						text.addCaretListener(caretListener);
					}
					
					String fileName = xtextEditor.getResource().getFullPath().toOSString();
					AssemblerEngine engine = AssemblerManager.getInstance().getRegistredAssemblyEngine(fileName);
					if (engine != null) {
						ManageUpdateDisplay(engine);
					} else {
					}
				}
				
			}

			@Override
			public void partDeactivated(IWorkbenchPart part) {
				// nothing to do
			}

			@Override
			public void partClosed(IWorkbenchPart part) {
				IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if ((currentEditor != null) && (currentEditor instanceof XtextEditor xtextEditor)) {
					Control control = xtextEditor.getAdapter(Control.class);
					if (control instanceof StyledText text) {
						text.removeCaretListener(caretListener);
					}
				}
		 		while (grid.getItemCount() > 0) {
					grid.getItems()[0].dispose();
				}
				grid.clearAll(true);
			}

			@Override
			public void partBroughtToTop(IWorkbenchPart part) {
				IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if ((currentEditor != null) && (currentEditor instanceof XtextEditor xtextEditor)) {
					Control control = currentEditor.getAdapter(Control.class);
					if (control instanceof StyledText text) {
						text.addCaretListener(caretListener);
						setCursorPosition(text.getCaretOffset());
					}
					
					String fileName = xtextEditor.getResource().getFullPath().toOSString();
					AssemblerEngine engine = AssemblerManager.getInstance().getRegistredAssemblyEngine(fileName);
					if (engine != null) {
						ManageUpdateDisplay(engine);

					}
				}
			}

			@Override
			public void partActivated(IWorkbenchPart part) {
			}
		});
	}

	protected void setCursorPosition(int caretOffset) {
		if (grid.getItemCount() >= 10) {
			
		}
	
	}

	private void ManageUpdateDisplay(AssemblerEngine engine) {
		if (timer != null) {
			timer.cancel();
		}
		timer = new Timer(true);
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				updateDisplay(engine);
				timer.cancel();
			}
		}, 0, 5000);
	}

	/**
	 * Update the display when the content editor change.
	 */
	private void updateDisplay(AssemblerEngine engine) {
		System.out.println("BPY:Update display");
		Display.getDefault().asyncExec(new Runnable() {
		    public void run() {
		 		while (grid.getItemCount() > 0) {
					grid.getItems()[0].dispose();
				}
				grid.clearAll(true);

				for (AbstractAssemblyLine assembledLine : engine.getAssembledLine()) {

					if (assembledLine instanceof AbstractInstructionAssemblyLine line) {
						GridItem item = new GridItem(grid, SWT.NONE);
						displayInstruction(item, line);

					} else if (assembledLine instanceof AssembledBlankLine line) {
						displayBlankLine(line);

					} else if (assembledLine instanceof AssembledCommentLine line) {
						displayCommentLine(line);

					} else if (assembledLine instanceof AssembledLabelLine line) {
						displayLabelLine(line);

					} else if (assembledLine instanceof AbstractAssembledDirectiveLine line) {
						displayDirective(line);

					} else if (assembledLine instanceof MacroDeclarationElement macroDeclaration) {
						displayMacroDeclaration(macroDeclaration);

					} else if (assembledLine instanceof MacroAssembledElement macroAssembledElement) {
						displayAssembledMacro(macroAssembledElement);

					} else {
						logger.log(Level.SEVERE, "Unkonowned type {0}", assembledLine.getClass().getName());
					}
				}
		    }
		});
		
	}

	/**
	 * Display an assembled macro instruction.
	 * 
	 * @param macroAssembledElement reference on the assembled element
	 */
	private void displayAssembledMacro(MacroAssembledElement macroAssembledElement) {
		GridItem item = new GridItem(grid, SWT.NONE);
		item.setText(LINE_NUMBER_COLUMN, "" + macroAssembledElement.getLineNumber());
		item.setText(ADDRESS_COLUMN, String.format("%04X", macroAssembledElement.getPcAddress()));
		item.setText(CODE_COLUMN, "");
		if (macroAssembledElement.getLabel() != null) {
			item.setText(LABEL_COLUMN, macroAssembledElement.getLabel());
		} else {
			item.setText(LABEL_COLUMN,"");
		}
		
		
		item.setText(INSTRUCTION_COLUMN, macroAssembledElement.getMacroDefinition().getName().getValue());
		item.setText(OPERAND_COLUMN, "");
		if (macroAssembledElement.getComment() != null) {
			item.setText(COMMENT_COLUMN, macroAssembledElement.getComment());
		} else {
			item.setText(COMMENT_COLUMN, "");
		}

		for (AbstractAssemblyLine assembledline : macroAssembledElement.getAssemblyLines()) {
			if (assembledline instanceof AbstractInstructionAssemblyLine instructionLine) {
				GridItem subItem = new GridItem(item, SWT.NONE);
				displayInstruction(subItem, instructionLine);
			}
		}
	}

	/**
	 * Display an macro declaration.
	 * 
	 * @param macroDeclaration reference on the macro definition
	 */
	private void displayMacroDeclaration(MacroDeclarationElement macroDeclaration) {
		GridItem item = new GridItem(grid, SWT.NONE);

		item.setText(LINE_NUMBER_COLUMN, "" + macroDeclaration.getLineNumber());
		item.setText(ADDRESS_COLUMN, String.format("%04X", macroDeclaration.getPcAddress()));
		item.setText(CODE_COLUMN, "");
		item.setText(LABEL_COLUMN, "");
		item.setText(INSTRUCTION_COLUMN, ".macro");
		item.setText(OPERAND_COLUMN, macroDeclaration.getMacroDefinition().getName().getValue());

		if (macroDeclaration.getMacroComment() != null) {
			item.setText(COMMENT_COLUMN, macroDeclaration.getMacroComment());
		} else {
			item.setText(COMMENT_COLUMN, "");
		}

		for (InstructionLine internalInstruction : macroDeclaration.getMacroDefinition().getInstructions()) {
			GridItem subItem = new GridItem(item, SWT.NONE);

			subItem.setText(LINE_NUMBER_COLUMN, "");
			subItem.setText(ADDRESS_COLUMN, "");
			subItem.setText(CODE_COLUMN, "");
			if ((internalInstruction.getLabel() != null) && (internalInstruction.getLabel().getName() != null)) {
				subItem.setText(LABEL_COLUMN, internalInstruction.getLabel().getName().getValue());
			} else {
				subItem.setText(LABEL_COLUMN, "");
			}
			
			CommandUtil.getInstructionName(internalInstruction);
			subItem.setText(INSTRUCTION_COLUMN, CommandUtil.getInstructionName(internalInstruction.getInstruction()));
			EObject operand = CommandUtil.getOperand(internalInstruction);
			
			if (operand != null) {
				String operandRepresentation = serializer.serialize(operand).replace(" ", "");
				subItem.setText(OPERAND_COLUMN, operandRepresentation);
			} else {
				subItem.setText(OPERAND_COLUMN, "");
			}
			if (internalInstruction.getComment() != null) {
				subItem.setText(COMMENT_COLUMN, internalInstruction.getComment());
			} else {
				subItem.setText(COMMENT_COLUMN, "");
			}
		}
		
		GridItem endItem = new GridItem(item, SWT.NONE);

		endItem.setText(LINE_NUMBER_COLUMN, "");
		endItem.setText(ADDRESS_COLUMN, "");
		endItem.setText(CODE_COLUMN, "");
		endItem.setText(LABEL_COLUMN, "");
		endItem.setText(INSTRUCTION_COLUMN, ".end");
		endItem.setText(OPERAND_COLUMN, "");

		if (macroDeclaration.getEndComment() != null) {
			endItem.setText(COMMENT_COLUMN, macroDeclaration.getEndComment());
		} else {
			endItem.setText(COMMENT_COLUMN, "");
		}
	}

	/**
	 * Display a directive line.
	 * 
	 * @param line reference on the line
	 */
	private void displayDirective(AbstractAssembledDirectiveLine line) {
		GridItem item = new GridItem(grid, SWT.NONE);
		item.setText(LINE_NUMBER_COLUMN, "" + line.getLineNumber());
		item.setText(ADDRESS_COLUMN, String.format("%04X", line.getPcAddress()));

		if (line.getLabel() != null) {
			item.setText(LABEL_COLUMN, line.getLabel());
		}

		if (line instanceof AssembledBszDirectiveLine directive) {
			display(item, directive);
		} else if (line instanceof AssembledEndDirectiveLine directive) {
			display(item, directive);
		} else if (line instanceof AssembledEquDirectiveLine directive) {
			display(item, directive);
		} else if (line instanceof AssembledFcbDirectiveLine directive) {
			display(item, directive);
		} else if (line instanceof AssembledFccDirectiveLine directive) {
			display(item, directive);
		} else if (line instanceof AssembledFdbDirectiveLine directive) {
			display(item, directive);
		} else if (line instanceof AssembledFillDirectiveLine directive) {
			display(item, directive);
		} else if (line instanceof AssembledNamDirectiveLine directive) {
			display(item, directive);
		} else if (line instanceof AssembledOptDirectiveLine directive) {
			display(item, directive);
		} else if (line instanceof AssembledOrgDirectiveLine directive) {
			display(item, directive);
		} else if (line instanceof AssembledPagDirectiveLine directive) {
			display(item, directive);
		} else if (line instanceof AssembledRegDirectiveLine directive) {
			display(item, directive);
		} else if (line instanceof AssembledRmbDirectiveLine directive) {
			display(item, directive);
		} else if (line instanceof AssembledSetDirectiveLine directive) {
			display(item, directive);
		} else if (line instanceof AssembledSetDPDirectiveLine directive) {
			display(item, directive);
		} else if (line instanceof AssembledSpcDirectiveLine directive) {
			display(item, directive);
		} else {
			logger.log(Level.SEVERE, "Unknoned directive {}", line.getClass().getSimpleName());
		}

		if (line.getComment() != null) {
			item.setText(COMMENT_COLUMN, line.getComment());
		}
	}

	/**
	 * Display specific information about BSZ directive in the grid.
	 * 
	 * @param item      Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledBszDirectiveLine directive) {
		item.setText(INSTRUCTION_COLUMN, directive.getDirective().getDirective());

		if (directive.getDirective().getOperand() != null) {
			String expressionRepresentation = serializer.serialize(directive.getDirective().getOperand()).replace(" ", "");;
			item.setText(OPERAND_COLUMN, expressionRepresentation);
		}
	}

	/**
	 * Display specific information about END directive in the grid.
	 * 
	 * @param item      Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledEndDirectiveLine directive) {
		item.setText(INSTRUCTION_COLUMN, directive.getDirective().getDirective());

		if (directive.getDirective().getOperand() != null) {
			item.setText(OPERAND_COLUMN, directive.getDirective().getOperand().getValue());
		}
	}

	/**
	 * Display specific information about SETDP directive in the grid.
	 * 
	 * @param item      Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledEquDirectiveLine directive) {
		item.setText(INSTRUCTION_COLUMN, "EQU");

		if (directive.getDirective().getOperand() != null) {
			String expressionRepresentation = serializer.serialize(directive.getDirective().getOperand()).replace(" ", "");
			if (directive.getDirective().isIsRelativeToPC()) {
				item.setText(OPERAND_COLUMN, '*' + expressionRepresentation);
			} else {
				item.setText(OPERAND_COLUMN, expressionRepresentation);
			}
		}
	}

	/**
	 * Display specific information about FCB directive in the grid.
	 * 
	 * @param item      Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledFcbDirectiveLine directive) {
		item.setText(INSTRUCTION_COLUMN, directive.getDirective().getDirective());

		if (directive.getDirective().getOperand() != null) {
			String expressionRepresentation = serializer.serialize(directive.getDirective().getOperand()).replace(" ", "");
			item.setText(OPERAND_COLUMN, expressionRepresentation);
		}

		StringBuilder strBuister = new StringBuilder();
		for (int value : directive.getValues()) {
			strBuister.append(String.format(BYTE_FORMAT, value & 0xFF));
		}
		item.setText(CODE_COLUMN, strBuister.toString());
	}

	/**
	 * Display specific information about FCC directive in the grid.
	 * 
	 * @param item      Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledFccDirectiveLine directive) {
		item.setText(INSTRUCTION_COLUMN, directive.getDirective().getDirective());

		StringBuilder strBuister = new StringBuilder();
		if (directive.getValues().length > 0) {
			for (int value : directive.getValues()) {
				strBuister.append(String.format(BYTE_FORMAT, value & 0xFF));
			}
		}
		item.setText(CODE_COLUMN, strBuister.toString());

		strBuister = new StringBuilder();
		for (EObject parameter : directive.getDirective().getParameters()) {
			String representation = serializer.serialize(parameter).replace(" ", "");
			if (!strBuister.isEmpty()) {
				strBuister.append(',');
			}
			strBuister.append(representation);
		}
		item.setText(OPERAND_COLUMN, strBuister.toString());
	}

	/**
	 * Display specific information about FDB directive in the grid.
	 * 
	 * @param item      Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledFdbDirectiveLine directive) {
		item.setText(INSTRUCTION_COLUMN, directive.getDirective().getDirective());

		if (directive.getDirective().getOperand() != null) {
			String expressionRepresentation = serializer.serialize(directive.getDirective().getOperand()).replace(" ", "");
			item.setText(OPERAND_COLUMN, expressionRepresentation);
		}

		StringBuilder strBuister = new StringBuilder();
		for (int value : directive.getValues()) {
			strBuister.append(String.format(WORD_FORMAT, value & 0xFFFF));
		}
		item.setText(CODE_COLUMN, strBuister.toString());
	}

	/**
	 * Display specific information about FILL directive in the grid.
	 * 
	 * @param item      Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledFillDirectiveLine directive) {
		item.setText(INSTRUCTION_COLUMN, "FILL");

		StringBuilder strBuister = new StringBuilder();
		String valueRepresentation = serializer.serialize(directive.getDirective().getValue()).replace(" ", "");
		strBuister.append(valueRepresentation);
		strBuister.append(',');
		String numberRepresentation = serializer.serialize(directive.getDirective().getNumber()).replace(" ", "");
		strBuister.append(numberRepresentation);
		item.setText(OPERAND_COLUMN, strBuister.toString());

		strBuister = new StringBuilder();
		for (int value : directive.getValues()) {
			strBuister.append(String.format(BYTE_FORMAT, value & 0xFF));
		}
		item.setText(CODE_COLUMN, strBuister.toString());
	}

	/**
	 * Display specific information about NAM directive in the grid.
	 * 
	 * @param item      Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledNamDirectiveLine directive) {
		item.setText(INSTRUCTION_COLUMN, directive.getDirective().getDirective());
		item.setText(OPERAND_COLUMN, directive.getValue());
	}

	/**
	 * Display specific information about OPT directive in the grid.
	 * 
	 * @param item      Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledOptDirectiveLine directive) {
		item.setText(INSTRUCTION_COLUMN, "OPT");

		StringBuilder strBuister = new StringBuilder();
		for (String value : directive.getValues()) {
			if (!strBuister.isEmpty()) {
				strBuister.append(',');
			}
			strBuister.append(value);
		}
		item.setText(OPERAND_COLUMN, strBuister.toString());
	}

	/**
	 * Display specific information about PAG directive in the grid.
	 * 
	 * @param item      Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledPagDirectiveLine directive) {
		item.setText(INSTRUCTION_COLUMN, "PAG");
		if (directive.getDirective().getOperand() != null) {
			item.setText(OPERAND_COLUMN, serializer.serialize(directive.getDirective().getOperand()).replace(" ", ""));
		}

	}

	/**
	 * Display specific information about PAG directive in the grid.
	 * 
	 * @param item      Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledRegDirectiveLine directive) {
		item.setText(INSTRUCTION_COLUMN, "REG");

		StringBuilder strBuister = new StringBuilder();
		for (Register option : directive.getDirective().getOptions()) {
			if (!strBuister.isEmpty()) {
				strBuister.append(',');
			}
			strBuister.append(option.getName());
		}
		item.setText(OPERAND_COLUMN, strBuister.toString());
	}

	/**
	 * Display specific information about PAG directive in the grid.
	 * 
	 * @param item      Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledRmbDirectiveLine directive) {
		item.setText(INSTRUCTION_COLUMN, "RMB");

		if (directive.getDirective().getOperand() != null) {
			String expressionRepresentation = serializer.serialize(directive.getDirective().getOperand()).replace(" ", "");
			if (directive.getDirective().isIsRelativeToPC()) {
				item.setText(OPERAND_COLUMN, '*' + expressionRepresentation);
			} else {
				item.setText(OPERAND_COLUMN, expressionRepresentation);
			}
		}
	}

	/**
	 * Display specific information about PAG directive in the grid.
	 * 
	 * @param item      Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledSetDirectiveLine directive) {
		item.setText(INSTRUCTION_COLUMN, "SET");

		if (directive.getDirective().getOperand() != null) {
			String expressionRepresentation = serializer.serialize(directive.getDirective().getOperand()).replace(" ", "");
			if (directive.getDirective().isIsRelativeToPC()) {
				item.setText(OPERAND_COLUMN, '*' + expressionRepresentation);
			} else {
				item.setText(OPERAND_COLUMN, expressionRepresentation);
			}
		}
	}

	/**
	 * Display specific information about SETDP directive in the grid.
	 * 
	 * @param item      Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledSetDPDirectiveLine directive) {
		item.setText(INSTRUCTION_COLUMN, "SETDP");

		if (directive.getDirective().getOperand() != null) {
			String expressionRepresentation = serializer.serialize(directive.getDirective().getOperand()).replace(" ", "");
			item.setText(OPERAND_COLUMN, expressionRepresentation);
		}
	}

	/**
	 * Display specific information about SPC directive in the grid.
	 * 
	 * @param item      Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledSpcDirectiveLine directive) {
		item.setText(INSTRUCTION_COLUMN, "SPC");
		StringBuilder strBuister = new StringBuilder();

		if (directive.getDirective().getSpaceCount() != null) {
			String expressionRepresentation = serializer.serialize(directive.getDirective().getSpaceCount()).replace(" ", "");
			strBuister.append(expressionRepresentation);
		}

		if (directive.getDirective().getKeepCount() != null) {
			String expressionRepresentation = serializer.serialize(directive.getDirective().getKeepCount()).replace(" ", "");
			strBuister.append(',');
			strBuister.append(expressionRepresentation);
		}

		item.setText(OPERAND_COLUMN, strBuister.toString());
	}

	/**
	 * Display an ORG directive in the grid.
	 * 
	 * @param item      Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledOrgDirectiveLine directive) {
		item.setText(INSTRUCTION_COLUMN, "ORG");

		if (directive.getDirective().getOperand() != null) {
			String expressionRepresentation = serializer.serialize(directive.getDirective().getOperand()).replace(" ", "");
			if (directive.getDirective().isIsRelativeToPC()) {
				item.setText(OPERAND_COLUMN, '*' + expressionRepresentation);
			} else {
				item.setText(OPERAND_COLUMN, expressionRepresentation);
			}
		}
	}

	/**
	 * Display a line of type label (see XText grammar).
	 * 
	 * @param assembledLine reference on the assembled line
	 */
	private void displayLabelLine(AssembledLabelLine assembledLine) {
		GridItem item = new GridItem(grid, SWT.NONE);
		item.setText(LINE_NUMBER_COLUMN, "" + assembledLine.getLineNumber());
		item.setText(ADDRESS_COLUMN, "");
		item.setText(CODE_COLUMN, "");
		item.setText(LABEL_COLUMN, assembledLine.getLabel());
		item.setText(INSTRUCTION_COLUMN, "");
		item.setText(OPERAND_COLUMN, "");
		
		if (assembledLine.getComment() != null) {
			item.setText(COMMENT_COLUMN, assembledLine.getComment());
		} else {
			item.setText(COMMENT_COLUMN, "");
		}
	}

	/**
	 * Display a blank line (see XText grammar).
	 * 
	 * @param blankLine reference on the assembled line
	 */
	private void displayBlankLine(AssembledBlankLine blankLine) {
		GridItem item = new GridItem(grid, SWT.NONE);
		item.setColumnSpan(ADDRESS_COLUMN, COMMENT_COLUMN-ADDRESS_COLUMN);
		item.setText("" + blankLine.getLineNumber());
	}

	/**
	 * Display a comment line (see XText grammar).
	 * 
	 * @param blankLine reference on the assembled line
	 */
	private void displayCommentLine(AssembledCommentLine assembledLine) {
		GridItem item = new GridItem(grid, SWT.NONE);
		item.setText("" + assembledLine.getLineNumber());
		if (assembledLine.isSpaceBefore()) {
			item.setText(COMMENT_COLUMN, assembledLine.getComment());
		} else {
			item.setColumnSpan(LABEL_COLUMN, COMMENT_COLUMN-LABEL_COLUMN);
			item.setText(LABEL_COLUMN, assembledLine.getComment());
		}
	}

	/**
	 * Display an instruction line (see XText grammar).
	 * 
	 * @param blankLine reference on the instruction line
	 */
	private void displayInstruction(GridItem item, AbstractInstructionAssemblyLine assembledLine) {
		item.setText(LINE_NUMBER_COLUMN, "" + assembledLine.getLineNumber());
		item.setText(ADDRESS_COLUMN, "" + String.format("%04X", assembledLine.getPcAddress()));

		StringBuilder code = new StringBuilder();
		for (int currentByte : assembledLine.getOpcode()) {
			code.append(String.format("%02X", currentByte));
		}

		for (int currentByte : assembledLine.getOperand()) {
			code.append(String.format("%02X", currentByte));
		}

		item.setText(CODE_COLUMN, code.toString());
		if (assembledLine.getLabel() != null) {
			item.setText(LABEL_COLUMN, assembledLine.getLabel());
		} else {
			item.setText(LABEL_COLUMN, "");
		}

		item.setText(INSTRUCTION_COLUMN, assembledLine.getInstructionName());
		
		setOperand(item, assembledLine);
	
		if (assembledLine.getComment() != null) {
			item.setText(COMMENT_COLUMN, assembledLine.getComment());
		} else {
			item.setText(COMMENT_COLUMN, "");
		}
	}

	/**
	 * Display the operand in the grid item.
	 * 
	 * @param item          Reference on the item
	 * @param assembledLine reference on the assembled line
	 */
	private void setOperand(GridItem item, AbstractInstructionAssemblyLine assembledLine) {
		EObject operand = assembledLine.getInstructionOperand();

		if (operand != null) {
			String operandRepresentation = serializer.serialize(operand).replace(" ", "");
			item.setText(OPERAND_COLUMN, operandRepresentation);
		} else {
			item.setText(OPERAND_COLUMN, "");
		}
	}
	@Override
	public void setFocus() {
		// Nothing to do here
	}
}
