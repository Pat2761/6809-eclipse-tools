package org.bpy.electronics.mc6809.assembler.ui.autoedit;

import java.util.Set;

import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.eclipse.core.commands.Command;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;
import org.eclipse.xtext.ui.editor.model.XtextDocument;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class AssemblerAutoEditStrategyProvider extends DefaultAutoEditStrategyProvider {

	@Inject
	Provider<IGrammarAccess> iGrammar;

	@Override
	protected void configureIndentationEditStrategy(IEditStrategyAcceptor acceptor) {
		int instructionPosition = PreferenceManager.getInstance().getIntPreferenceValue(PreferenceManager.INSTRUCTION_POSITION);
		int operandPosition = PreferenceManager.getInstance().getIntPreferenceValue(PreferenceManager.OPERAND_POSITION);
		int commentPosition = PreferenceManager.getInstance().getIntPreferenceValue(PreferenceManager.COMMENT_POSITION);

		IAutoEditStrategy strategy = new IAutoEditStrategy() {

			@Override
			public void customizeDocumentCommand(IDocument document, DocumentCommand command) {
				try {
					if ("\t".equals(command.text)) {
						int lineNumber = document.getLineOfOffset(command.offset);
						int lineStart = document.getLineOffset(lineNumber);

						if (command.offset < lineStart + instructionPosition-1) {
							int nbSpacesNeeded = instructionPosition -(command.offset - lineStart);
							command.text = computeInstructionPositionSpace(nbSpacesNeeded);

						} else if (command.offset < lineStart+operandPosition-1) {
							int nbSpacesNeeded = operandPosition -(command.offset - lineStart);
							command.text = computeInstructionPositionSpace(nbSpacesNeeded);
						
						} else if (command.offset <= lineStart+commentPosition) {
							int nbSpacesNeeded = commentPosition -(command.offset - lineStart);
							command.text = computeInstructionPositionSpace(nbSpacesNeeded);
						}	
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		};

		acceptor.accept(strategy, IDocument.DEFAULT_CONTENT_TYPE);

//	    super.configure(acceptor);
	}

	protected String computeInstructionPositionSpace(int nbSpacesNeeded) {
		String tabPolicy = PreferenceManager.getInstance().getStringPreferenceValue(PreferenceManager.TAB_POLICY);
		int tabSize = PreferenceManager.getInstance().getIntPreferenceValue(PreferenceManager.TAB_SIZE);
		
		if (PreferenceManager.SPACE_ONLY.equals(tabPolicy)) {
			return Strings.repeat(" ", nbSpacesNeeded-1);

		} else if (PreferenceManager.TAB_ONLY.equals(tabPolicy)) {
			int nbTabsNeeded = (nbSpacesNeeded)/tabSize;
			return Strings.repeat("\t", nbTabsNeeded);
		}
		return " ";
	}

}
