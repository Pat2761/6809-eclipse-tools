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
import org.bpy.electronics.mc6809.assembler.parser.antlr.AssemblerParser;
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
	    column.setWidth(25);
	    GridColumn column2 = new GridColumn(grid,SWT.NONE);
	    column2.setText("Address");
	    column2.setWidth(70);
	    GridColumn column3 = new GridColumn(grid,SWT.NONE);
	    column3.setText("Code");
	    column3.setWidth(100);
	    GridColumn column4 = new GridColumn(grid,SWT.NONE);
	    column4.setText("Label");
	    column4.setWidth(100);
	    
	    GridColumn column5 = new GridColumn(grid,SWT.NONE);
	    column5.setText("Instruction");
	    column5.setWidth(70);
	    GridColumn column6 = new GridColumn(grid,SWT.NONE);
	    column6.setText("Operand");
	    column6.setWidth(150);
	    GridColumn column7 = new GridColumn(grid,SWT.NONE);
	    column7.setText("Comment");
	    column7.setWidth(300);
	    
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
			if (assembledLine instanceof AbstractInstructionAssemblyLine) {
				displayInstruction((AbstractInstructionAssemblyLine)assembledLine);
				
			} else if (assembledLine instanceof AssembledBlankLine) {
				displayBlankLine((AssembledBlankLine)assembledLine);
				
			} else if (assembledLine instanceof AssembledCommentLine) {
				displayCommentLine((AssembledCommentLine)assembledLine);

			} else if (assembledLine instanceof AssembledLabelLine) {
				displayLabelLine((AssembledLabelLine)assembledLine);
				
			} else if (assembledLine instanceof AbstractAssembledDirectiveLine) {
				
			} else {
				logger.log(Level.SEVERE,"Unkonowned type " + assembledLine.getClass().getName());
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
		 if (assembledLine.getComment() != null) {
			 item.setText(COMMENT_COLUMN, assembledLine.getComment());
		 }
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
