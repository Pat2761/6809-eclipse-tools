/*
 * generated by Xtext 2.28.0
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
	protected AbstractElementAlias match_DirectiveLine_WSTerminalRuleCall_4_q;
	protected AbstractElementAlias match_ExtendedOperand_GreaterThanSignKeyword_0_q;
	protected AbstractElementAlias match_InstructionLine_WSTerminalRuleCall_4_q;
	protected AbstractElementAlias match_Primary_LeftParenthesisKeyword_7_0_a;
	protected AbstractElementAlias match_Primary_LeftParenthesisKeyword_7_0_p;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (AssemblerGrammarAccess) access;
		match_DirectiveLine_WSTerminalRuleCall_4_q = new TokenAlias(false, true, grammarAccess.getDirectiveLineAccess().getWSTerminalRuleCall_4());
		match_ExtendedOperand_GreaterThanSignKeyword_0_q = new TokenAlias(false, true, grammarAccess.getExtendedOperandAccess().getGreaterThanSignKeyword_0());
		match_InstructionLine_WSTerminalRuleCall_4_q = new TokenAlias(false, true, grammarAccess.getInstructionLineAccess().getWSTerminalRuleCall_4());
		match_Primary_LeftParenthesisKeyword_7_0_a = new TokenAlias(true, true, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_7_0());
		match_Primary_LeftParenthesisKeyword_7_0_p = new TokenAlias(true, false, grammarAccess.getPrimaryAccess().getLeftParenthesisKeyword_7_0());
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
			if (match_DirectiveLine_WSTerminalRuleCall_4_q.equals(syntax))
				emit_DirectiveLine_WSTerminalRuleCall_4_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ExtendedOperand_GreaterThanSignKeyword_0_q.equals(syntax))
				emit_ExtendedOperand_GreaterThanSignKeyword_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_InstructionLine_WSTerminalRuleCall_4_q.equals(syntax))
				emit_InstructionLine_WSTerminalRuleCall_4_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Primary_LeftParenthesisKeyword_7_0_a.equals(syntax))
				emit_Primary_LeftParenthesisKeyword_7_0_a(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Primary_LeftParenthesisKeyword_7_0_p.equals(syntax))
				emit_Primary_LeftParenthesisKeyword_7_0_p(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     WS?
	 *
	 * This ambiguous syntax occurs at:
	 *     comment=ANY_EXCEPT_COMMENT_END_OF_LINE (ambiguity) EndOfLine (rule end)
	 *     directive=BszDirective (ambiguity) EndOfLine (rule end)
	 *     directive=EndDirective (ambiguity) EndOfLine (rule end)
	 *     directive=EquDirective (ambiguity) EndOfLine (rule end)
	 *     directive=FailDirective (ambiguity) EndOfLine (rule end)
	 *     directive=FcbDirective (ambiguity) EndOfLine (rule end)
	 *     directive=FccDirective (ambiguity) EndOfLine (rule end)
	 *     directive=FdbDirective (ambiguity) EndOfLine (rule end)
	 *     directive=FillDirective (ambiguity) EndOfLine (rule end)
	 *     directive=NamDirective (ambiguity) EndOfLine (rule end)
	 *     directive=OptDirective (ambiguity) EndOfLine (rule end)
	 *     directive=OrgDirective (ambiguity) EndOfLine (rule end)
	 *     directive=PagDirective (ambiguity) EndOfLine (rule end)
	 *     directive=RegDirective (ambiguity) EndOfLine (rule end)
	 *     directive=RmbDirective (ambiguity) EndOfLine (rule end)
	 *     directive=SetDirective (ambiguity) EndOfLine (rule end)
	 *     directive=SpcDirective (ambiguity) EndOfLine (rule end)
	 
	 * </pre>
	 */
	protected void emit_DirectiveLine_WSTerminalRuleCall_4_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '&gt;'?
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) operand=Expression
	 
	 * </pre>
	 */
	protected void emit_ExtendedOperand_GreaterThanSignKeyword_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     WS?
	 *
	 * This ambiguous syntax occurs at:
	 *     comment=ANY_EXCEPT_COMMENT_END_OF_LINE (ambiguity) EndOfLine (rule end)
	 *     instruction=AbxInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=AdcInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=AddInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=AdddInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=AndCCInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=AndInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=AslInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=AsrInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BccInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BcsInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BeqInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BgeInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BgtInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BhiInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BhsInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BitInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BleInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BloInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BlsInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BltInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BmiInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BneInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BplInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BraInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BrnInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BsrInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BvcInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=BvsInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=ClrInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=CmpInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=ComInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=CwaiInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=DaaInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=DecInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=EorInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=ExgInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=IncInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=JmpInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=JsrInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=Ld16Instruction (ambiguity) EndOfLine (rule end)
	 *     instruction=Ld8Instruction (ambiguity) EndOfLine (rule end)
	 *     instruction=LeaInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=LslInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=LsrInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=MulInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=NegInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=NopInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=OrInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=OrccInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=PshsInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=PshuInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=PulsInstruction (ambiguity) EndOfLine (rule end)
	 *     instruction=PuluInstruction (ambiguity) EndOfLine (rule end)
	 
	 * </pre>
	 */
	protected void emit_InstructionLine_WSTerminalRuleCall_4_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '('*
	 *
	 * This ambiguous syntax occurs at:
	 *     (rule start) (ambiguity) '!' value=Primary
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
	 *     (rule start) (ambiguity) {Or.left=}
	 *     (rule start) (ambiguity) {RightShift.left=}
	 *     (rule start) (ambiguity) {Substraction.left=}
	 *     (rule start) (ambiguity) {Xor.left=}
	 
	 * </pre>
	 */
	protected void emit_Primary_LeftParenthesisKeyword_7_0_a(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
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
	 *     (rule start) (ambiguity) {Or.left=}
	 *     (rule start) (ambiguity) {RightShift.left=}
	 *     (rule start) (ambiguity) {Substraction.left=}
	 *     (rule start) (ambiguity) {Xor.left=}
	 
	 * </pre>
	 */
	protected void emit_Primary_LeftParenthesisKeyword_7_0_p(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
