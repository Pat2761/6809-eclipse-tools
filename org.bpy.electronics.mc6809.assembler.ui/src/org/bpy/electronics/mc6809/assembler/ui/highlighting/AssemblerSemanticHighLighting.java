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

import java.util.ArrayList;
import java.util.List;

import org.bpy.electronics.mc6809.assembler.assembler.BinaryValue;
import org.bpy.electronics.mc6809.assembler.assembler.CommentLine;
import org.bpy.electronics.mc6809.assembler.assembler.DecimalValue;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.Expression;
import org.bpy.electronics.mc6809.assembler.assembler.HexaDecimalValue;
import org.bpy.electronics.mc6809.assembler.assembler.IdentifierValue;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Label;
import org.bpy.electronics.mc6809.assembler.assembler.LabelLine;
import org.bpy.electronics.mc6809.assembler.assembler.MacroDefinition;
import org.bpy.electronics.mc6809.assembler.assembler.OctalValue;
import org.bpy.electronics.mc6809.assembler.assembler.OtherKindOfInstructions;
import org.bpy.electronics.mc6809.assembler.assembler.RelativeMode;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;

public class AssemblerSemanticHighLighting implements ISemanticHighlightingCalculator {

	protected static final List<String> branchInstructionsName = new ArrayList<>();
	protected static final List<String> subroutineCall = new ArrayList<>();
	protected static final List<String> registers = new ArrayList<>();

	static {
		registers.add("A");
		registers.add("B");
		registers.add("D");
		registers.add("X");
		registers.add("Y");
		registers.add("U");
		registers.add("S");
		registers.add("DP");
		registers.add("CC");
		registers.add("PC");
		
		subroutineCall.add("JSR");
		subroutineCall.add("BSR");
		subroutineCall.add("LBSR");
		
		branchInstructionsName.add("JMP");
		branchInstructionsName.add("BCC");
		branchInstructionsName.add("LBCC");
		branchInstructionsName.add("BCS");
		branchInstructionsName.add("LBCS");
		branchInstructionsName.add("BEQ");
		branchInstructionsName.add("LBEQ");
		branchInstructionsName.add("BGE");
		branchInstructionsName.add("LBGE");
		branchInstructionsName.add("BGT");
		branchInstructionsName.add("LBGT");
		branchInstructionsName.add("BHI");
		branchInstructionsName.add("LBHI");
		branchInstructionsName.add("BHS");
		branchInstructionsName.add("LBHS");
		branchInstructionsName.add("BLE");
		branchInstructionsName.add("LBLE");
		branchInstructionsName.add("BLO");
		branchInstructionsName.add("LBLO");
		branchInstructionsName.add("BLS");
		branchInstructionsName.add("LBLS");
		branchInstructionsName.add("BLT");
		branchInstructionsName.add("LBLT");
		branchInstructionsName.add("BMI");
		branchInstructionsName.add("LBMI");
		branchInstructionsName.add("BNE");
		branchInstructionsName.add("LBNE");
		branchInstructionsName.add("BPL");
		branchInstructionsName.add("LBPL");
		branchInstructionsName.add("BRA");
		branchInstructionsName.add("LBRA");
		branchInstructionsName.add("BRN");
		branchInstructionsName.add("LBRN");
		branchInstructionsName.add("BVC");
		branchInstructionsName.add("LBVC");
		branchInstructionsName.add("BVS");
		branchInstructionsName.add("LBVS");

	}
	
	@Override
	public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor, CancelIndicator cancelIndicator) {
		if ((resource == null) || (resource.getParseResult() == null)) { 
			return;
		}	
		
		ICompositeNode root = resource.getParseResult().getRootNode();
		for (ILeafNode node : root.getLeafNodes()) {

			if (!node.isHidden()) {
				
				if (node.getSemanticElement() instanceof CommentLine) {
					setCommentColoration(acceptor, node);
				
				} else if (node.getSemanticElement() instanceof LabelLine) {
					setLabelLineColoration(acceptor, node);
		
				} else if (node.getSemanticElement() instanceof IdentifierValue) {
					setIdentifierColoration(acceptor, node);
		
				} else if (node.getSemanticElement() instanceof MacroDefinition) {
					setMacroColoration(acceptor, node);
					
				} else if (node.getSemanticElement() instanceof InstructionLine) {
					setInstructionColoration(acceptor, node);
					
				} else if (node.getSemanticElement() instanceof DirectiveLine) {
					setDirectiveColoration(acceptor, node);

				} else if (node.getSemanticElement() instanceof OtherKindOfInstructions) {
					setOtherInstructionColoration(acceptor, node);
					
				} else if ((node.getSemanticElement() instanceof BinaryValue) ||
						(node.getSemanticElement() instanceof OctalValue) ||
						(node.getSemanticElement() instanceof DecimalValue) ||
						(node.getSemanticElement() instanceof HexaDecimalValue) ) {
					setNumericValues(acceptor, node);

				} else if (node.getGrammarElement() instanceof Keyword) {
					setKeywordColoration(acceptor, node);
					
				} else if (node.getGrammarElement() instanceof EnumLiteralDeclaration) {
					setEnumColoration(acceptor, node);
				}
			}
		}	
	}

	/**
	 * Define coloring the enumeration elements.
	 * Use here for the register values 
	 * 
	 * @param acceptor reference on the acceptor
	 * @param node reference to the node
	 */
	private void setEnumColoration(IHighlightedPositionAcceptor acceptor, ILeafNode node) {
		if (node.getParent().getGrammarElement() instanceof RuleCall ruleCall) {
			AbstractRule rule = ruleCall.getRule();
			if ((rule instanceof EnumRule enumRule) && ("Register".equals(enumRule.getName())) ) {
				acceptor.addPosition(node.getOffset(), node.getText().length(),  AssemblerHighlightingConfiguration.REGISTER_ID);
			}
		}
	}

	/**
	 * Define coloring keywords elements.
	 * Use here for the name of the instruction, directives and other instruction type 
	 * 
	 * @param acceptor reference on the acceptor
	 * @param node reference to the node
	 */
	private void setKeywordColoration(IHighlightedPositionAcceptor acceptor, ILeafNode node) {
		ICompositeNode greatParent = node.getParent().getParent();
		ICompositeNode parent = node.getParent();

		if ((greatParent.getSemanticElement() instanceof DirectiveLine) && 
			 !(parent.getSemanticElement() instanceof Label)	) {
			acceptor.addPosition(node.getOffset(), node.getText().length(),  AssemblerHighlightingConfiguration.DIRECTIVE_NAME_ID);
		
		} else if ((greatParent.getSemanticElement() instanceof InstructionLine) &&
			 !(parent.getSemanticElement() instanceof Label)	) {

			if (isBranchInstruction(node.getText())) {
				acceptor.addPosition(node.getOffset(), node.getText().length(),  AssemblerHighlightingConfiguration.BRANCH_ID);

			} else if (isSubroutineCall(node.getText())) {
				acceptor.addPosition(node.getOffset(), node.getText().length(),  AssemblerHighlightingConfiguration.CALL_SUBROUTINE_ID);

			} else {
				acceptor.addPosition(node.getOffset(), node.getText().length(),  AssemblerHighlightingConfiguration.INSTRUCTION_NAME_ID);
			}
		
		} else {
			if (isRegister(node.getText())) {
				acceptor.addPosition(node.getOffset(), node.getText().length(),  AssemblerHighlightingConfiguration.REGISTER_ID);
			}
		}
	}

	/**
	 * Set numeric coloring value.
	 * 
	 * @param acceptor reference on the acceptor
	 * @param node reference to the node
	 */
	private void setNumericValues(IHighlightedPositionAcceptor acceptor, ILeafNode node) {
		acceptor.addPosition(node.getOffset(), node.getText().length(),  AssemblerHighlightingConfiguration.NUMBER_ID);
	}

	/**
	 * Set comment coloring value.
	 * 
	 * @param acceptor reference on the acceptor
	 * @param node reference to the node
	 */
	private void setCommentColoration(IHighlightedPositionAcceptor acceptor, ILeafNode node) {
		acceptor.addPosition(node.getOffset(), node.getText().length(),  AssemblerHighlightingConfiguration.COMMENT_ID);
	}

	/**
	 * Set identifier coloring value.
	 * 
	 * @param acceptor reference on the acceptor
	 * @param node reference to the node
	 */
	private void setIdentifierColoration(IHighlightedPositionAcceptor acceptor, ILeafNode node) {
		// in case of label use
		
		if (node.getParent().getParent().getSemanticElement() instanceof Label) {
			acceptor.addPosition(node.getOffset(), node.getText().length(),  AssemblerHighlightingConfiguration.LABEL_ID);
	
		} else if (node.getParent().getParent().getSemanticElement() instanceof OtherKindOfInstructions) {
			acceptor.addPosition(node.getOffset(), node.getText().length(),  AssemblerHighlightingConfiguration.MACRO_ID);
	
		} else if ((node.getParent().getParent().getSemanticElement() instanceof RelativeMode)||
				     (node.getParent().getParent().getSemanticElement() instanceof Expression ))
				{
			acceptor.addPosition(node.getOffset(), node.getText().length(),  AssemblerHighlightingConfiguration.LABEL_ID);
		}
	}

	/**
	 * Set macro call coloring value.
	 * 
	 * @param acceptor reference on the acceptor
	 * @param node reference to the node
	 */
	private void setOtherInstructionColoration(IHighlightedPositionAcceptor acceptor, ILeafNode node) {
		if ((node.getGrammarElement() instanceof RuleCall ruleCall) &&
		  isComment(ruleCall.getRule())) {
			setCommentColoration(acceptor, node);
		}
		
	}

	/**
	 * Set label coloring value.
	 * 
	 * @param acceptor reference on the acceptor
	 * @param node reference to the node
	 */
	private void setLabelLineColoration(IHighlightedPositionAcceptor acceptor, ILeafNode node) {
		if ((node.getGrammarElement() instanceof RuleCall ruleCall ) &&
			isComment(ruleCall.getRule())) {
			setCommentColoration(acceptor, node);
		}
	}

	/**
	 * Set directive coloring value.
	 * 
	 * @param acceptor reference on the acceptor
	 * @param node reference to the node
	 */
	private void setDirectiveColoration(IHighlightedPositionAcceptor acceptor, ILeafNode node) {
		if ((node.getGrammarElement() instanceof RuleCall ruleCall) &&
			isComment(ruleCall.getRule())) {
			setCommentColoration(acceptor, node);
		} 
	}

	/**
	 * Set instruction coloring value.
	 * 
	 * @param acceptor reference on the acceptor
	 * @param node reference to the node
	 */
	private void setInstructionColoration(IHighlightedPositionAcceptor acceptor, ILeafNode node) {
		if ((node.getGrammarElement() instanceof RuleCall ruleCall ) && (isComment(ruleCall.getRule()))) {
			setCommentColoration(acceptor, node);
		} 
	}

	/**
	 * Set macro coloring value.
	 * 
	 * @param acceptor reference on the acceptor
	 * @param node reference to the node
	 */
	private void setMacroColoration(IHighlightedPositionAcceptor acceptor, ILeafNode node) {
		if (".macro".equals(node.getText()) || ".endm".equals(node.getText())) {
			acceptor.addPosition(node.getOffset(), node.getText().length(),  AssemblerHighlightingConfiguration.MACRO_ID);

		} else if ((node.getGrammarElement() instanceof RuleCall ruleCall) && 
			isComment(ruleCall.getRule())) {
			acceptor.addPosition(node.getOffset(), node.getText().length(),  AssemblerHighlightingConfiguration.COMMENT_ID);
		}
	}

	/**
	 * Check if it is a sub routine call instruction.
	 * 
	 * @param text test to test
	 * @return <b>true</b> if it is a sub routine call instruction, <b>false</b> otherwise
	 */
	private boolean isSubroutineCall(String text) {
		return subroutineCall.contains(text);
	}

	/**
	 * Check if it is a branch instruction.
	 * 
	 * @param text test to test
	 * @return <b>true</b> if it is a branch instruction, <b>false</b> otherwise
	 */
	private boolean isBranchInstruction(String text) {
		return branchInstructionsName.contains(text);
	}

	/**
	 * Check if it is a comment.
	 * 
	 * @param rule reference on the rule to test
	 * @return <b>true</b> if it is a comment, <b>false</b> otherwise 
	 */
	private boolean isComment(AbstractRule rule) {
		return (rule instanceof TerminalRule terminalRule) && 
				(terminalRule.getName().equals("ANY_EXCEPT_COMMENT_END_OF_LINE"));
	}

	/**
	 * Check if it is a register.
	 * 
	 * @param text Text to test
	 * @return <b>true</b> if it is a register name, <b>false</b> otherwise 
	 */
	private boolean isRegister(String text) {
		return registers.contains(text);
	}
}
