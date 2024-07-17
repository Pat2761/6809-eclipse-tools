package org.bpy.electronics.mc6809.rcp.views;

import java.io.StringReader;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.assembler.AssemblerStandaloneSetup;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
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

public class AssemblyView extends ViewPart {
	
	private static final Logger logger = Logger.getLogger(AssemblyView.class.getName());
	
	private static final int LINE_NUMBER_COLUMN = 0; 
	private static final int ADDRESS_COLUMN = 1; 
	private static final int CODE_COLUMN = 2; 
	private static final int LABEL_COLUMN = 3; 
	private static final int INSTRUCTION_COLUMN = 4; 
	private static final int OPERAND_COLUMN = 5; 
	private static final int COMMENT_COLUMN = 6; 

	/** XText parser reference */
	@Inject
	private IParser parser;
	@Inject @Extension private ISerializer serializer;
	
	/** Caret Listener */
	private CaretListener caretListener;
	private Grid grid;
	
	public AssemblyView() {
		com.google.inject.Injector injector = new AssemblerStandaloneSetup().createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
	}

	@Override
	public void createPartControl(Composite parent) {

	    grid = new Grid(parent,SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
	    grid.setFont(SWTResourceManager.getFont("Courier New", 10, SWT.BOLD));
	    grid.setHeaderVisible(true);
	    GridColumn column = new GridColumn(grid,SWT.NONE);
	    column.setText("N°");
	    column.setWidth(45);
	    GridColumn column2 = new GridColumn(grid,SWT.NONE);
	    column2.setText("Add");
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
	
	private void initializeListener() {
		caretListener = event -> {updateDisplay();} ;
		
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().addPartListener(new IPartListener() {

			@Override
			public void partOpened(IWorkbenchPart part) {

				IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
				//assembleCurrent
				if (currentEditor != null) {
					Control control = currentEditor.getAdapter(Control.class);
					if (control instanceof StyledText) {
						StyledText text = (StyledText) control;
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
					if (control instanceof StyledText) {
						StyledText text = (StyledText) control;
						text.removeCaretListener(caretListener);
					}
				}

				//clearPanel();
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

	private void updateDisplay() {
		
		IEditorPart currentEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		if (currentEditor instanceof ITextEditor) {
			IEditorInput input = currentEditor.getEditorInput();
			IDocument document = (((ITextEditor) currentEditor).getDocumentProvider()).getDocument(input);
			
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
				
			} else {
				logger.log(Level.SEVERE,"Unkonowned type " + assembledLine.getClass().getName());
			}
		}
 	}	

	private void displayDirective(AbstractAssembledDirectiveLine line) {
		 GridItem item = new GridItem(grid,SWT.NONE);
		 item.setText(LINE_NUMBER_COLUMN, ""+line.getLineNumber());
		 item.setText(ADDRESS_COLUMN, "" + String.format("%04X", line.getPcAddress()));
		 
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
			 logger.log(Level.SEVERE, "Unknoned directive " + line.getClass().getSimpleName());
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
		 
		 StringBuilder strBuilder = new StringBuilder();
		 for (int value : directive.getValues()) {
				 strBuilder.append(String.format("%02X ", value&0xFF));
		 }
		 item.setText(CODE_COLUMN, strBuilder.toString());
	}

	
	/** 
	 * Display specific information about FCC directive in the grid.
	 * 
	 * @param item Reference to to grid item used for display information
	 * @param directive Directive to display
	 */
	private void display(GridItem item, AssembledFccDirectiveLine directive) {
		 item.setText(INSTRUCTION_COLUMN, directive.getDirective().getDirective());
		 
		 if (directive.getValues().length >0) {
//			 String expressionRepresentation = serializer.serialize(directive.getDirective().getOperand());		 
//			 item.setText(OPERAND_COLUMN, expressionRepresentation);
		 }
		 
//		 StringBuilder strBuilder = new StringBuilder();
//		 for (int value : directive.getValues()) {
//				 strBuilder.append(String.format("%02X ", value&0xFF));
//		 }
//		 item.setText(CODE_COLUMN, strBuilder.toString());
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
		 
		 StringBuilder strBuilder = new StringBuilder();
		 for (int value : directive.getValues()) {
				 strBuilder.append(String.format("%04X ", value&0xFFFF));
		 }
		 item.setText(CODE_COLUMN, strBuilder.toString());
	}

	private void display(GridItem item, AssembledFillDirectiveLine directive) {
		// TODO Auto-generated method stub
		
	}

	private void display(GridItem item, AssembledNamDirectiveLine directive) {
		// TODO Auto-generated method stub
		
	}

	private void display(GridItem item, AssembledOptDirectiveLine directive) {
		// TODO Auto-generated method stub
		
	}

	private void display(GridItem item, AssembledPagDirectiveLine directive) {
		// TODO Auto-generated method stub
		
	}

	private void display(GridItem item, AssembledRegDirectiveLine directive) {
		// TODO Auto-generated method stub
		
	}

	private void display(GridItem item, AssembledRmbDirectiveLine directive) {
		// TODO Auto-generated method stub
		
	}

	private void display(GridItem item, AssembledSetDirectiveLine directive) {
		// TODO Auto-generated method stub
		
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
		 StringBuilder strBuilder = new StringBuilder();
		 
		 if (directive.getDirective().getSpaceCount()!= null) {
			 String expressionRepresentation = serializer.serialize(directive.getDirective().getSpaceCount());		 
			 strBuilder.append(expressionRepresentation);
		 }
	
		 if (directive.getDirective().getKeepCount()!= null) {
			 String expressionRepresentation = serializer.serialize(directive.getDirective().getKeepCount());		 
			 strBuilder.append(',');
			 strBuilder.append(expressionRepresentation);
		 }

		 item.setText(OPERAND_COLUMN, strBuilder.toString());
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

	private void displayLabelLine(AssembledLabelLine assembledLine) {
		 GridItem item = new GridItem(grid,SWT.NONE);
		 item.setText("" + assembledLine.getLineNumber());
		 item.setText(LABEL_COLUMN, assembledLine.getLabel());
		 if (assembledLine.getComment() != null) {
			 item.setText(COMMENT_COLUMN, assembledLine.getComment());
		 }
	}

	private void displayBlankLine(AssembledBlankLine blankLine) {
		 GridItem item = new GridItem(grid,SWT.NONE);
		 item.setColumnSpan(0, 6);
		 item.setText("" + blankLine.getLineNumber());
	}

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

	private void displayInstruction(AbstractInstructionAssemblyLine assembledLine) {
		 GridItem item = new GridItem(grid,SWT.NONE);
		 item.setText(LINE_NUMBER_COLUMN, ""+assembledLine.getLineNumber());
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
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
