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

import java.io.StringReader;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.assembler.AssemblerStandaloneSetup;
import org.bpy.electronics.mc6809.assembler.assembler.AdcInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AddInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AdddInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AndCCInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AndInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AslInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BccInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BcsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BeqInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BgeInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BgtInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BhiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BhsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BitInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BleInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BloInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BlsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BltInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BmiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BneInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BplInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BraInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BrnInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BvcInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BvsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.ClrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.CmpInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.ComInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.CwaiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.DecInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.EorInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.ExgInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.IncInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.JmpInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.JsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LdInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LeaInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LslInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.NegInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.OrCCInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.OrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.PshsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.PshuInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.PulsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.PuluInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.Register;
import org.bpy.electronics.mc6809.assembler.assembler.RolInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.RorInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.SbcInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.StInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.SubInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.TfrInstruction;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine;
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
import org.bpy.electronics.mc6809.assembler.engine.data.others.MacroDeclarationElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.IDocument;
import org.eclipse.nebula.widgets.grid.Grid;
import org.eclipse.nebula.widgets.grid.GridColumn;
import org.eclipse.nebula.widgets.grid.GridItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.SWTException;
import org.eclipse.swt.custom.CaretListener;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPartListener;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.xbase.lib.Extension;

import com.google.inject.Inject;

/**
 * Display the result of the assembly file in a Nebula grid.
 * 
 * @author Patrick BRIAND
 *
 */
public class AssemblyView extends ViewPart {
	
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

	/** XText parser reference */
	@Inject
	private IParser parser;
	/** Reference on the serializer */
	@Inject @Extension private ISerializer serializer;
	
	/** Caret Listener */
	private CaretListener caretListener;
	/** reference on the grid */
	private Grid grid;
	
	/**
	 * Constructor of the class.
	 * Initiate the injector
	 */
	public AssemblyView() {
		com.google.inject.Injector injector = new AssemblerStandaloneSetup().createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
	}

	@Override
	public void createPartControl(Composite parent) {

	    grid = new Grid(parent,SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
	    grid.setFont(SWTResourceManager.getFont("Courier New", 10, SWT.NORMAL));
	    grid.setHeaderVisible(true);
	    GridColumn column = new GridColumn(grid,SWT.NONE);
	    column.setText("N°");
	    column.setWidth(45);
	    GridColumn column2 = new GridColumn(grid,SWT.NONE);
	    column2.setText("Addr");
	    column2.setWidth(70);
	    GridColumn column3 = new GridColumn(grid,SWT.NONE);
	    column3.setText("Code");
	    column3.setWidth(100);
	    GridColumn column4 = new GridColumn(grid,SWT.NONE);
	    column4.setText("Label");
	    column4.setWidth(100);
	    
	    GridColumn column5 = new GridColumn(grid,SWT.NONE);
	    column5.setText("Instruction");
	    column5.setWidth(100);
	    GridColumn column6 = new GridColumn(grid,SWT.NONE);
	    column6.setText("Operand");
	    column6.setWidth(150);
	    GridColumn column7 = new GridColumn(grid,SWT.NONE);
	    column7.setText("Comment");
	    column7.setWidth(400);
	    
	    initializeListener();
	}
	
	/** 
	 * Initialize the listener needed by this view. 
	 */
	private void initializeListener() {
		caretListener = event -> updateDisplay();
		
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().addPartListener(new IPartListener() {

			@Override
			public void partOpened(IWorkbenchPart part) {

				IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				//assembleCurrent
				if (currentEditor != null) {
					Control control = currentEditor.getAdapter(Control.class);
					if (control instanceof StyledText text) {
						text.addCaretListener(caretListener);
						//setCursorPosition(text.getCaretOffset());
					}

					updateDisplay();
				}
			}

			@Override
			public void partDeactivated(IWorkbenchPart part) {
				// nothing to do
			}

			@Override
			public void partClosed(IWorkbenchPart part) {
				IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				if (currentEditor != null) {
					Control control = currentEditor.getAdapter(Control.class);
					if (control instanceof StyledText text) {
						text.removeCaretListener(caretListener);
					}
				}
			}

			@Override
			public void partBroughtToTop(IWorkbenchPart part) {
				updateDisplay();
			}

			@Override
			public void partActivated(IWorkbenchPart part) {
				updateDisplay();
			}
		});
	}

	/**
	 * Update the display when the content editor change.
	 */
	private void updateDisplay() {
		IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (currentEditor instanceof ITextEditor textEditor) {
			IEditorInput input = textEditor.getEditorInput();
			IDocument document = textEditor.getDocumentProvider().getDocument(input);
			
			try {
				
				String content = document.get();
				IParseResult parserResult = parser.parse(new StringReader(content));
				Model model = (Model) parserResult.getRootASTElement();
				AssemblerEngine engine = AssemblerEngine.getInstance();
				engine.engine(model);
				
			} catch (StringIndexOutOfBoundsException|SWTException e) {
				logger.log(Level.SEVERE, e.getMessage());
			}
		}
		
		grid.clearItems();
		AssemblerEngine engine = AssemblerEngine.getInstance();
		for (AbstractAssemblyLine assembledLine : engine.getAssembledLine()) {
			System.out.println(assembledLine);
			
			
			if (assembledLine instanceof AbstractInstructionAssemblyLine line) {
				displayInstruction(line);
				
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
				
			} else {
				logger.log(Level.SEVERE,"Unkonowned type {0}" , assembledLine.getClass().getName());
			}
		}
		System.out.println("-----------------------------------");
 	}	

	private void displayMacroDeclaration(MacroDeclarationElement macroDeclaration) {
		 GridItem item = new GridItem(grid,SWT.NONE);

		item.setText(LINE_NUMBER_COLUMN, "" + macroDeclaration.getLineNumber());
		item.setText(ADDRESS_COLUMN, String.format("%04X", macroDeclaration.getPcAddress()));
		item.setText(INSTRUCTION_COLUMN, ".macro");
		item.setText(OPERAND_COLUMN, macroDeclaration.getMacroDefinition().getName().getValue());

		if (macroDeclaration.getMacroComment() != null) {
			item.setText(COMMENT_COLUMN, macroDeclaration.getMacroComment());
		}

		for (InstructionLine internalInstruction : macroDeclaration.getMacroDefinition().getInstructions()) {
			GridItem subItem = new GridItem(item, SWT.NONE);
			
			EObject operand = null;
			if (internalInstruction instanceof AdcInstruction adcInstruction) {
				operand  = adcInstruction.getOperand();

			} else if (internalInstruction instanceof AddInstruction addaInstruction) {
				operand = addaInstruction.getOperand();

			} else if (internalInstruction instanceof AdddInstruction adddInstruction) {
				operand = adddInstruction.getOperand();

			} else if (internalInstruction instanceof AndInstruction andInstruction) {
				operand = andInstruction.getOperand();

			} else if (internalInstruction instanceof AndCCInstruction andccInstruction) {
				operand = andccInstruction.getOperand();

			} else if (internalInstruction instanceof AslInstruction aslInstruction) {
				operand = aslInstruction.getOperand();

			} else if (internalInstruction instanceof AsrInstruction asrInstruction) {
				operand = asrInstruction.getOperand();

			} else if (internalInstruction instanceof BitInstruction bitInstruction) {
				operand = bitInstruction.getOperand();

			} else if (internalInstruction instanceof ClrInstruction clrInstruction) {
				operand = clrInstruction.getOperand();

			} else if (internalInstruction instanceof CmpInstruction cmpInstruction) {
				operand = cmpInstruction.getOperand();

			} else if (internalInstruction instanceof ComInstruction comInstruction) {
				operand = comInstruction.getOperand();

			} else if (internalInstruction instanceof CwaiInstruction cwaiInstruction) {
				operand = cwaiInstruction.getOperand();

			} else if (internalInstruction instanceof DecInstruction decInstruction) {
				operand = decInstruction.getOperand();

			} else if (internalInstruction instanceof EorInstruction eorInstruction) {
				operand = eorInstruction.getOperand();

			} else if (internalInstruction instanceof ExgInstruction exgInstruction) {
				displayRegisterOperand(exgInstruction.getReg1(),exgInstruction.getReg2());

			} else if (internalInstruction instanceof IncInstruction incInstruction) {
				operand = incInstruction.getOperand();

			} else if (internalInstruction instanceof JmpInstruction jmpInstruction) {
				operand = jmpInstruction.getOperand();
			} else if (internalInstruction instanceof JsrInstruction jsrInstruction) {
				operand = jsrInstruction.getOperand();

			} else if (internalInstruction instanceof LdInstruction ldInstruction) {
				operand = ldInstruction.getOperand();

			} else if (internalInstruction instanceof LeaInstruction leaInstruction) {
				operand = leaInstruction.getOperand();

			} else if (internalInstruction instanceof LslInstruction lslInstruction) {
				operand = lslInstruction.getOperand();

			} else if (internalInstruction instanceof LsrInstruction lsrInstruction) {
				operand = lsrInstruction.getOperand();

			} else if (internalInstruction instanceof NegInstruction negInstruction) {
				operand = negInstruction.getOperand();

			} else if (internalInstruction instanceof OrInstruction orInstruction) {
				operand = orInstruction.getOperand();
		
			} else if (internalInstruction instanceof OrCCInstruction orccInstruction) {
				operand = orccInstruction.getOperand();

			} else if (internalInstruction instanceof PshsInstruction pshsInstruction) {
				operand = pshsInstruction.getOperand();
			} else if (internalInstruction instanceof PshuInstruction pshuInstruction) {
				operand = pshuInstruction.getOperand();
			} else if (internalInstruction instanceof PulsInstruction pulsInstruction) {
				operand = pulsInstruction.getOperand();
			} else if (internalInstruction instanceof PuluInstruction puluInstruction) {
				operand = puluInstruction.getOperand();

			} else if (internalInstruction instanceof RolInstruction rolInstruction) {
				operand = rolInstruction.getOperand();

			} else if (internalInstruction instanceof RorInstruction rorInstruction) {
				operand = rorInstruction.getOperand();

			} else if (internalInstruction instanceof SbcInstruction sbcInstruction) {
				operand = sbcInstruction.getOperand();

			} else if (internalInstruction instanceof StInstruction stInstruction) {
				operand = stInstruction.getOperand();
			
			} else if (internalInstruction instanceof SubInstruction subInstruction) {
				operand = subInstruction.getOperand();

			} else if (internalInstruction instanceof TfrInstruction tfrInstruction) {
				displayRegisterOperand(tfrInstruction.getReg1(),tfrInstruction.getReg2());

			} else if (internalInstruction instanceof BccInstruction bccInstruction) {
				operand = bccInstruction.getOperand();

			} else if (internalInstruction instanceof BcsInstruction bcsInstruction) {
				operand = bcsInstruction.getOperand();

			} else if (internalInstruction instanceof BeqInstruction beqInstruction) {
				operand = beqInstruction.getOperand();

			} else if (internalInstruction instanceof BgeInstruction bgeInstruction) {
				operand = bgeInstruction.getOperand();

			} else if (internalInstruction instanceof BgtInstruction bgtInstruction) {
				operand = bgtInstruction.getOperand();

			} else if (internalInstruction instanceof BhiInstruction bhiInstruction) {
				operand = bhiInstruction.getOperand();

			} else if (internalInstruction instanceof BhsInstruction bhsInstruction) {
				operand = bhsInstruction.getOperand();

			} else if (internalInstruction instanceof BleInstruction bleInstruction) {
				operand = bleInstruction.getOperand();

			} else if (internalInstruction instanceof BloInstruction bloInstruction) {
				operand = bloInstruction.getOperand();

			} else if (internalInstruction instanceof BlsInstruction blsInstruction) {
				operand = blsInstruction.getOperand();

			} else if (internalInstruction instanceof BltInstruction bltInstruction) {
				operand = bltInstruction.getOperand();

			} else if (internalInstruction instanceof BmiInstruction bmiInstruction) {
				operand = bmiInstruction.getOperand();

			} else if (internalInstruction instanceof BneInstruction bneInstruction) {
				operand = bneInstruction.getOperand();

			} else if (internalInstruction instanceof BplInstruction bplInstruction) {
				operand = bplInstruction.getOperand();

			} else if (internalInstruction instanceof BraInstruction braInstruction) {
				operand = braInstruction.getOperand();
			
			} else if (internalInstruction instanceof BrnInstruction brnInstruction) {
				operand = brnInstruction.getOperand();

			} else if (internalInstruction instanceof BsrInstruction bsrInstruction) {
				operand = bsrInstruction.getOperand();

			} else if (internalInstruction instanceof BvcInstruction bvcInstruction) {
				operand = bvcInstruction.getOperand();
			
			} else if (internalInstruction instanceof BvsInstruction bvsInstruction) {
				operand = bvsInstruction.getOperand();
			
			} else {
				// Nothing to do
			}

			if (operand != null) {
				String operandRepresentation = serializer.serialize(operand);		 
				item.setText(OPERAND_COLUMN, operandRepresentation);
			}	
		}
	}

	/** 
	 * Display a directive line
	 * 
	 * @param line reference on the line
	 */
	private void displayDirective(AbstractAssembledDirectiveLine line) {
		 GridItem item = new GridItem(grid,SWT.NONE);
		 item.setText(LINE_NUMBER_COLUMN, ""+line.getLineNumber());
		 item.setText(ADDRESS_COLUMN, String.format("%04X", line.getPcAddress()));
		 
		 if (line.getLabel() != null) {
			 item.setText(LABEL_COLUMN,line.getLabel());
		 }

		 if (line instanceof AssembledBszDirectiveLine directive) {
			 display(item,directive);
		 } else if (line instanceof AssembledEndDirectiveLine directive) {
			 display(item,directive);
		 } else if (line instanceof AssembledEquDirectiveLine directive) {
			 display(item,directive);
		 } else if (line instanceof AssembledFcbDirectiveLine directive) {
			 display(item,directive);
		 } else if (line instanceof AssembledFccDirectiveLine directive) {
			 display(item,directive);
		 } else if (line instanceof AssembledFdbDirectiveLine directive) {
			 display(item,directive);
		 } else if (line instanceof AssembledFillDirectiveLine directive) {
			 display(item,directive);
		 } else if (line instanceof AssembledNamDirectiveLine directive) {
			 display(item,directive);
		 } else if (line instanceof AssembledOptDirectiveLine directive) {
			 display(item,directive);
		 } else if (line instanceof AssembledOrgDirectiveLine directive) {
			 display(item,directive);
		 } else if (line instanceof AssembledPagDirectiveLine directive) {
			 display(item,directive);
		 } else if (line instanceof AssembledRegDirectiveLine directive) {
			 display(item,directive);
		 } else if (line instanceof AssembledRmbDirectiveLine directive) {
			 display(item,directive);
		 } else if (line instanceof AssembledSetDirectiveLine directive) {
			 display(item,directive);
		 } else if (line instanceof AssembledSetDPDirectiveLine directive) {
			 display(item,directive);
		 } else if (line instanceof AssembledSpcDirectiveLine directive) {
			 display(item,directive);
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
	 * @param item Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledBszDirectiveLine directive) {
		 item.setText(INSTRUCTION_COLUMN, directive.getDirective().getDirective());
		 
		 if (directive.getDirective().getOperand() != null) {
			 String expressionRepresentation = serializer.serialize(directive.getDirective().getOperand());
			 item.setText(OPERAND_COLUMN, expressionRepresentation);
		 }
	}

	/** 
	 * Display specific information about END directive in the grid.
	 * 
	 * @param item Reference to to grid item used for display information
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
	 * @param item Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledEquDirectiveLine directive) {
		 item.setText(INSTRUCTION_COLUMN, "EQU");
		 
		 if (directive.getDirective().getOperand() != null) {
			 String expressionRepresentation = serializer.serialize(directive.getDirective().getOperand());
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
	 * @param item Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledFcbDirectiveLine directive) {
		 item.setText(INSTRUCTION_COLUMN, directive.getDirective().getDirective());
		 
		 if (directive.getDirective().getOperand() != null) {
			 String expressionRepresentation = serializer.serialize(directive.getDirective().getOperand());		 
			 item.setText(OPERAND_COLUMN, expressionRepresentation);
		 }
		 
		 StringBuilder strBuister = new StringBuilder();
		 for (int value : directive.getValues()) {
				 strBuister.append(String.format(BYTE_FORMAT, value&0xFF));
		 }
		 item.setText(CODE_COLUMN, strBuister.toString());
	}

	
	/** 
	 * Display specific information about FCC directive in the grid.
	 * 
	 * @param item Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledFccDirectiveLine directive) {
		 item.setText(INSTRUCTION_COLUMN, directive.getDirective().getDirective());
		 
		 StringBuilder strBuister  = new StringBuilder();
		 if (directive.getValues().length >0) {
			 for (int value : directive.getValues()) {
				 strBuister.append(String.format(BYTE_FORMAT, value & 0xFF));
			 }
		 }
		 item.setText(CODE_COLUMN, strBuister.toString());
		 
		 strBuister  = new StringBuilder();
		 for (EObject parameter : directive.getDirective().getParameters()) {
			 String representation = serializer.serialize(parameter);		 
			 if (!strBuister.isEmpty()) {
				 strBuister.append(',');
			 }
			 strBuister.append(representation);
		 }
		 item.setText(OPERAND_COLUMN,strBuister.toString());
	}

	/** 
	 * Display specific information about FDB directive in the grid.
	 * 
	 * @param item Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledFdbDirectiveLine directive) {
		 item.setText(INSTRUCTION_COLUMN, directive.getDirective().getDirective());
		 
		 if (directive.getDirective().getOperand() != null) {
			 String expressionRepresentation = serializer.serialize(directive.getDirective().getOperand());		 
			 item.setText(OPERAND_COLUMN, expressionRepresentation);
		 }
		 
		 StringBuilder strBuister = new StringBuilder();
		 for (int value : directive.getValues()) {
				 strBuister.append(String.format(WORD_FORMAT, value&0xFFFF));
		 }
		 item.setText(CODE_COLUMN, strBuister.toString());
	}

	/** 
	 * Display specific information about FILL directive in the grid.
	 * 
	 * @param item Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledFillDirectiveLine directive) {
		 item.setText(INSTRUCTION_COLUMN, "FILL");
		 
		 StringBuilder strBuister = new StringBuilder();
		 String valueRepresentation = serializer.serialize(directive.getDirective().getValue());
		 strBuister.append(valueRepresentation);
		 strBuister.append(',');
		 String numberRepresentation = serializer.serialize(directive.getDirective().getNumber());
		 strBuister.append(numberRepresentation);
		 item.setText(OPERAND_COLUMN, strBuister.toString());
		 
		 strBuister = new StringBuilder();
		 for (int value : directive.getValues()) {
			 strBuister.append(String.format(BYTE_FORMAT, value&0xFF));
		 }
		 item.setText(CODE_COLUMN, strBuister.toString());
	}

	/** 
	 * Display specific information about NAM directive in the grid.
	 * 
	 * @param item Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledNamDirectiveLine directive) {
		 item.setText(INSTRUCTION_COLUMN, directive.getDirective().getDirective());
		 item.setText(OPERAND_COLUMN, directive.getValue());
	}

	/** 
	 * Display specific information about OPT directive in the grid.
	 * 
	 * @param item Reference to to grid item used for display information
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
	 * @param item Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledPagDirectiveLine directive) {
		 item.setText(INSTRUCTION_COLUMN, "PAG");
		 if (directive.getDirective().getOperand() != null) {
			 item.setText(OPERAND_COLUMN, serializer.serialize(directive.getDirective().getOperand()));
		 }
		
	}

	/** 
	 * Display specific information about PAG directive in the grid.
	 * 
	 * @param item Reference to to grid item used for display information
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
	 * @param item Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledRmbDirectiveLine directive) {
		 item.setText(INSTRUCTION_COLUMN, "RMB");

		 if (directive.getDirective().getOperand() != null) {
			 String expressionRepresentation = serializer.serialize(directive.getDirective().getOperand());		
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
	 * @param item Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledSetDirectiveLine directive) {
		 item.setText(INSTRUCTION_COLUMN, "SET");
		 
		 if (directive.getDirective().getOperand() != null) {
			 String expressionRepresentation = serializer.serialize(directive.getDirective().getOperand());
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
	 * @param item Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledSetDPDirectiveLine directive) {
		 item.setText(INSTRUCTION_COLUMN, "SETDP");
		 
		 if (directive.getDirective().getOperand() != null) {
			 String expressionRepresentation = serializer.serialize(directive.getDirective().getOperand());		 
			 item.setText(OPERAND_COLUMN, expressionRepresentation);
		 }
	}

	/** 
	 * Display specific information about SPC directive in the grid.
	 * 
	 * @param item Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledSpcDirectiveLine directive) {
		 item.setText(INSTRUCTION_COLUMN, "SPC");
		 StringBuilder strBuister = new StringBuilder();
		 
		 if (directive.getDirective().getSpaceCount()!= null) {
			 String expressionRepresentation = serializer.serialize(directive.getDirective().getSpaceCount());		 
			 strBuister.append(expressionRepresentation);
		 }
	
		 if (directive.getDirective().getKeepCount()!= null) {
			 String expressionRepresentation = serializer.serialize(directive.getDirective().getKeepCount());		 
			 strBuister.append(',');
			 strBuister.append(expressionRepresentation);
		 }

		 item.setText(OPERAND_COLUMN, strBuister.toString());
	}

	/** 
	 * Display an ORG directive in the grid.
	 * 
	 * @param item Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledOrgDirectiveLine directive) {
		 item.setText(INSTRUCTION_COLUMN, "ORG");

		 if (directive.getDirective().getOperand() != null) {
			 String expressionRepresentation = serializer.serialize(directive.getDirective().getOperand());
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
		 GridItem item = new GridItem(grid,SWT.NONE);
		 item.setText("" + assembledLine.getLineNumber());
		 item.setText(LABEL_COLUMN, assembledLine.getLabel());
		 if (assembledLine.getComment() != null) {
			 item.setText(COMMENT_COLUMN, assembledLine.getComment());
		 }
	}

	/**
	 * Display a blank line (see XText grammar).
	 * 
	 * @param blankLine reference on the assembled line
	 */
	private void displayBlankLine(AssembledBlankLine blankLine) {
		 GridItem item = new GridItem(grid,SWT.NONE);
		 item.setColumnSpan(0, 6);
		 item.setText("" + blankLine.getLineNumber());
	}

	/**
	 * Display a comment line (see XText grammar).
	 * 
	 * @param blankLine reference on the assembled line
	 */
	private void displayCommentLine(AssembledCommentLine assembledLine) {
		 GridItem item = new GridItem(grid,SWT.NONE);
		 item.setText("" + assembledLine.getLineNumber());
		 if(assembledLine.isSpaceBefore()) {
			 item.setText(COMMENT_COLUMN, assembledLine.getComment());
		 } else {
			 item.setColumnSpan(LABEL_COLUMN, COMMENT_COLUMN);
			 item.setText(LABEL_COLUMN, assembledLine.getComment());
		 }
	}

	/**
	 * Display an instruction line (see XText grammar).
	 * 
	 * @param blankLine reference on the instruction line
	 */
	private void displayInstruction(AbstractInstructionAssemblyLine assembledLine) {
		 GridItem item = new GridItem(grid,SWT.NONE);
		 item.setText(LINE_NUMBER_COLUMN, "" + assembledLine.getLineNumber());
		 item.setText(ADDRESS_COLUMN, "" + String.format("%04X", assembledLine.getPcAddress()));
		
		 StringBuilder code = new StringBuilder();
		 for (int currentByte : assembledLine.getOpcode()) {
			 code.append(String.format("%02X", currentByte)) ;
		 }
		 
		 for (int currentByte : assembledLine.getOperand()) {
			 code.append(String.format("%02X", currentByte)) ;
		 }
		 
		 item.setText(CODE_COLUMN,code.toString());
		 if (assembledLine.getLabel() != null) {
			 item.setText(LABEL_COLUMN, assembledLine.getLabel());
		 }
		 
		 item.setText(INSTRUCTION_COLUMN, assembledLine.getInstructionName());
		 if (assembledLine.getComment() != null) {
			 item.setText(COMMENT_COLUMN, assembledLine.getComment());
		 }
		 
		 setOperandFiest(item, assembledLine);
	}		 

	private void setOperandFiest(GridItem item, AbstractInstructionAssemblyLine assembledLine) {
		EObject operand = null;
		if (assembledLine instanceof AssembledADCAInstruction adcaInstruction) {
			operand = adcaInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledADCBInstruction adcbInstruction) {
			operand = adcbInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledADDAInstruction addaInstruction) {
			operand = addaInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledADDBInstruction addbInstruction) {
			operand = addbInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledADDDInstruction adddInstruction) {
			operand = adddInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledANDAInstruction andaInstruction) {
			operand = andaInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledANDBInstruction andbInstruction) {
			operand = andbInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledANDCCInstruction andccInstruction) {
			operand = andccInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledASLAInstruction aslaInstruction) {
			operand = aslaInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledASLBInstruction aslbInstruction) {
			operand = aslbInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledASLInstruction aslInstruction) {
			operand = aslInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledASRAInstruction asraInstruction) {
			operand = asraInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledASRBInstruction asrbInstruction) {
			operand = asrbInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledASRInstruction asrInstruction) {
			operand = asrInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledBITAInstruction bitaInstruction) {
			operand = bitaInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledBITBInstruction bitbInstruction) {
			operand = bitbInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledCLRAInstruction clraInstruction) {
			operand = clraInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledCLRBInstruction clrbInstruction) {
			operand = clrbInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledCLRInstruction clrInstruction) {
			operand = clrInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledCMPAInstruction cmpaInstruction) {
			operand = cmpaInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledCMPBInstruction cmpbInstruction) {
			operand = cmpbInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledCMPDInstruction cmpdInstruction) {
			operand = cmpdInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledCMPXInstruction cmpxInstruction) {
			operand = cmpxInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledCMPYInstruction cmpyInstruction) {
			operand = cmpyInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledCMPSInstruction cmpsInstruction) {
			operand = cmpsInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledCMPUInstruction cmpuInstruction) {
			operand = cmpuInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledCOMAInstruction comaInstruction) {
			operand = comaInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledCOMBInstruction combInstruction) {
			operand = combInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledCOMInstruction comInstruction) {
			operand = comInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledCWAIInstruction cwaiInstruction) {
			operand = cwaiInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledDECAInstruction decaInstruction) {
			operand = decaInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledDECBInstruction decbInstruction) {
			operand = decbInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledDECInstruction decInstruction) {
			operand = decInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledEORAInstruction eoraInstruction) {
			operand = eoraInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledEORBInstruction eorbInstruction) {
			operand = eorbInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledEXGInstruction exgInstruction) {
			displayRegisterOperand(exgInstruction.getInstruction().getReg1(),exgInstruction.getInstruction().getReg2());

		} else if (assembledLine instanceof AssembledINCAInstruction incaInstruction) {
			operand = incaInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledINCBInstruction incbInstruction) {
			operand = incbInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledINCInstruction incInstruction) {
			operand = incInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledJMPInstruction jmpInstruction) {
			operand = jmpInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledJSRInstruction jsrInstruction) {
			operand = jsrInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledLDAInstruction ldaInstruction) {
			operand = ldaInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLDBInstruction ldbInstruction) {
			operand = ldbInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLDDInstruction lddInstruction) {
			operand = lddInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledSTXInstruction ldxInstruction) {
			operand = ldxInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLDYInstruction ldyInstruction) {
			operand = ldyInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLDSInstruction ldsInstruction) {
			operand = ldsInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLDUInstruction lduInstruction) {
			operand = lduInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledLEASInstruction leasInstruction) {
			operand = leasInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLEAUInstruction leauInstruction) {
			operand = leauInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLEAXInstruction leaxInstruction) {
			operand = leaxInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLEAYInstruction leayInstruction) {
			operand = leayInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledLSLAInstruction lslaInstruction) {
			operand = lslaInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLSLBInstruction lslbInstruction) {
			operand = lslbInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLSLInstruction lslInstruction) {
			operand = lslInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledLSRAInstruction lsraInstruction) {
			operand = lsraInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLSRBInstruction lsrbInstruction) {
			operand = lsrbInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLSRInstruction lsrInstruction) {
			operand = lsrInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledNEGInstruction negInstruction) {
			operand = negInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledORAInstruction oraInstruction) {
			operand = oraInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledORBInstruction orbInstruction) {
			operand = orbInstruction.getInstruction().getOperand();
	
		} else if (assembledLine instanceof AssembledORCCInstruction orccInstruction) {
			operand = orccInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledPSHSInstruction pshsInstruction) {
			operand = pshsInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledPSHUInstruction pshuInstruction) {
			operand = pshuInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledPULSInstruction pulsInstruction) {
			operand = pulsInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledPULUInstruction puluInstruction) {
			operand = puluInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledROLAInstruction rolaInstruction) {
			operand = rolaInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledROLBInstruction rolbInstruction) {
			operand = rolbInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledROLInstruction rolInstruction) {
			operand = rolInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledRORAInstruction roraInstruction) {
			operand = roraInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledRORBInstruction rorbInstruction) {
			operand = rorbInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledRORInstruction rorInstruction) {
			operand = rorInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledSBCAInstruction sbcaInstruction) {
			operand = sbcaInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledSBCBInstruction sbcbInstruction) {
			operand = sbcbInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledSTAInstruction staInstruction) {
			operand = staInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledSTBInstruction stbInstruction) {
			operand = stbInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledSTDInstruction stdInstruction) {
			operand = stdInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledSTXInstruction stxInstruction) {
			operand = stxInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledSTYInstruction styInstruction) {
			operand = styInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledSTSInstruction stsInstruction) {
			operand = stsInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledSTUInstruction stuInstruction) {
			operand = stuInstruction.getInstruction().getOperand();
		
		} else if (assembledLine instanceof AssembledSUBAInstruction subaInstruction) {
			operand = subaInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledSUBBInstruction subbInstruction) {
			operand = subbInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledSUBDInstruction subdInstruction) {
			operand = subdInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledTFRInstruction tfrInstruction) {
			displayRegisterOperand(tfrInstruction.getInstruction().getReg1(),tfrInstruction.getInstruction().getReg2());

		} else if (assembledLine instanceof AssembledBCCInstruction bccInstruction) {
			operand = bccInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBCCInstruction lbccInstruction) {
			operand = lbccInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledBCSInstruction bcsInstruction) {
			operand = bcsInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBCSInstruction lbcsInstruction) {
			operand = lbcsInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledBEQInstruction beqInstruction) {
			operand = beqInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBEQInstruction lbeqInstruction) {
			operand = lbeqInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledBGEInstruction bgeInstruction) {
			operand = bgeInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBGEInstruction lbgeInstruction) {
			operand = lbgeInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledBGTInstruction bgtInstruction) {
			operand = bgtInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBGTInstruction lbgtInstruction) {
			operand = lbgtInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledBHIInstruction bhiInstruction) {
			operand = bhiInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBHIInstruction lbhiInstruction) {
			operand = lbhiInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledBHSInstruction bhsInstruction) {
			operand = bhsInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBHSInstruction lbhsInstruction) {
			operand = lbhsInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledBLEInstruction bleInstruction) {
			operand = bleInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBLEInstruction lbleInstruction) {
			operand = lbleInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledBLOInstruction bloInstruction) {
			operand = bloInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBLOInstruction lbloInstruction) {
			operand = lbloInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledBLSInstruction blsInstruction) {
			operand = blsInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBLSInstruction lblsInstruction) {
			operand = lblsInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledBLTInstruction bltInstruction) {
			operand = bltInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBLTInstruction lbltInstruction) {
			operand = lbltInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledBMIInstruction bmiInstruction) {
			operand = bmiInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBMIInstruction lbmiInstruction) {
			operand = lbmiInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledBNEInstruction bneInstruction) {
			operand = bneInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBNEInstruction lbneInstruction) {
			operand = lbneInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledBPLInstruction bplInstruction) {
			operand = bplInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBPLInstruction lbplInstruction) {
			operand = lbplInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledBRAInstruction braInstruction) {
			operand = braInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBRAInstruction lbraInstruction) {
			operand = lbraInstruction.getInstruction().getOperand();
		
		} else if (assembledLine instanceof AssembledBRNInstruction brnInstruction) {
			operand = brnInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBRNInstruction lbrnInstruction) {
			operand = lbrnInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledBSRInstruction bsrInstruction) {
			operand = bsrInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBSRInstruction lbsrInstruction) {
			operand = lbsrInstruction.getInstruction().getOperand();

		} else if (assembledLine instanceof AssembledBVCInstruction bvcInstruction) {
			operand = bvcInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBVCInstruction lbvcInstruction) {
			operand = lbvcInstruction.getInstruction().getOperand();
		
		} else if (assembledLine instanceof AssembledBVSInstruction bvsInstruction) {
			operand = bvsInstruction.getInstruction().getOperand();
		} else if (assembledLine instanceof AssembledLBVSInstruction lbvsInstruction) {
			operand = lbvsInstruction.getInstruction().getOperand();
		
		} else {
			// Nothing to do
		}

		if (operand != null) {
			String operandRepresentation = serializer.serialize(operand);		 
			item.setText(OPERAND_COLUMN, operandRepresentation);
		}	
	}

	private void displayRegisterOperand(Register reg1, Register reg2) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(reg1.getName());
		strBuilder.append(',');
		strBuilder.append(reg2.getName());
	}

	private void displayOperand(GridItem item, EObject operand) {
		String operandRepresentation = serializer.serialize(operand);		 
		item.setText(OPERAND_COLUMN, operandRepresentation);
	}

	@Override
	public void setFocus() {
		// Nothing to do here
	}

}
