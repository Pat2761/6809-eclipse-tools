/*
 * generated by Xtext 2.29.0
 */
package org.bpy.electronics.mc6809.assembler.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.bpy.electronics.mc6809.assembler.services.AssemblerGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class AssemblerSyntacticSequencer extends AbstractSyntacticSequencer {

	protected AssemblerGrammarAccess grammarAccess;
	protected AbstractElementAlias match_EquDirective_WSTerminalRuleCall_5_q;
	protected AbstractElementAlias match_Primary_LeftParenthesisKeyword_6_0_a;
	protected AbstractElementAlias match_Primary_LeftParenthesisKeyword_6_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AssemblerGrammarAccess) access;
		match_EquDirective_WSTerminalRuleCall_5_q = new TokenAlias(false, true, grammarAccess.getEquDirectiveAccess().getWSTerminalRuleCall_5());
		match_Primary_LeftParenthesisKeyword_6_0_a = new TokenAlias(true, true, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_6_0());
		match_Primary_LeftParenthesisKeyword_6_0_p = new TokenAlias(true, false, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_6_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getEndOfLineRule())
			return getEndOfLineToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getWSRule())
			return getWSToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * EndOfLine: CR | END_OF_FILE;
	 */
	protected String getEndOfLineToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\n";
	}
	
	/**
	 * terminal WS         						: (' '|'\t')+;
	 */
	protected String getWSToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return " ";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if (match_EquDirective_WSTerminalRuleCall_5_q.equals(syntax))
				emit_EquDirective_WSTerminalRuleCall_5_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Primary_LeftParenthesisKeyword_6_0_a.equals(syntax))
				emit_Primary_LeftParenthesisKeyword_6_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Primary_LeftParenthesisKeyword_6_0_p.equals(syntax))
				emit_Primary_LeftParenthesisKeyword_6_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     WS?
	 *
	 * This ambiguous syntax occurs at:
	 *     directive='EQU' WS (ambiguity) EndOfLine (rule end)
	 *     directive='EQU' WS (ambiguity) comment=ANY_EXCEPT_COMMENT_END_OF_LINE
	 *     operand=Operand (ambiguity) EndOfLine (rule end)
	 *     operand=Operand (ambiguity) comment=ANY_EXCEPT_COMMENT_END_OF_LINE
	 
	 * </pre>
	 */
	protected void emit_EquDirective_WSTerminalRuleCall_5_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) value=BinaryValue
	 *     (rule start) (ambiguity) value=CharacterValue
	 *     (rule start) (ambiguity) value=DecimalValue
	 *     (rule start) (ambiguity) value=HexaDecimalValue
	 *     (rule start) (ambiguity) value=IdentifierValue
	 *     (rule start) (ambiguity) value=OctalValue
	 *     (rule start) (ambiguity) {Addition.left=}
	 *     (rule start) (ambiguity) {And.left=}
	 *     (rule start) (ambiguity) {Division.left=}
	 *     (rule start) (ambiguity) {LeftShift.left=}
	 *     (rule start) (ambiguity) {Modulo.left=}
	 *     (rule start) (ambiguity) {Multiplication.left=}
	 *     (rule start) (ambiguity) {Negate.left=}
	 *     (rule start) (ambiguity) {Or.left=}
	 *     (rule start) (ambiguity) {RigthShift.left=}
	 *     (rule start) (ambiguity) {Substraction.left=}
	 
	 * </pre>
	 */
	protected void emit_Primary_LeftParenthesisKeyword_6_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('+
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) {Addition.left=}
	 *     (rule start) (ambiguity) {And.left=}
	 *     (rule start) (ambiguity) {Division.left=}
	 *     (rule start) (ambiguity) {LeftShift.left=}
	 *     (rule start) (ambiguity) {Modulo.left=}
	 *     (rule start) (ambiguity) {Multiplication.left=}
	 *     (rule start) (ambiguity) {Negate.left=}
	 *     (rule start) (ambiguity) {Or.left=}
	 *     (rule start) (ambiguity) {RigthShift.left=}
	 *     (rule start) (ambiguity) {Substraction.left=}
	 
	 * </pre>
	 */
	protected void emit_Primary_LeftParenthesisKeyword_6_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
