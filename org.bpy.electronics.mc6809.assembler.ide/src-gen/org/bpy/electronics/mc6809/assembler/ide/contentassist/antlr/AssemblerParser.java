/*
 * generated by Xtext 2.29.0
 */
package org.bpy.electronics.mc6809.assembler.ide.contentassist.antlr;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.Map;
import org.bpy.electronics.mc6809.assembler.ide.contentassist.antlr.internal.InternalAssemblerParser;
import org.bpy.electronics.mc6809.assembler.services.AssemblerGrammarAccess;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class AssemblerParser extends AbstractContentAssistParser {

	@Singleton
	public static final class NameMappings {
		
		private final Map<AbstractElement, String> mappings;
		
		@Inject
		public NameMappings(AssemblerGrammarAccess grammarAccess) {
			ImmutableMap.Builder<AbstractElement, String> builder = ImmutableMap.builder();
			init(builder, grammarAccess);
			this.mappings = builder.build();
		}
		
		public String getRuleName(AbstractElement element) {
			return mappings.get(element);
		}
		
		private static void init(ImmutableMap.Builder<AbstractElement, String> builder, AssemblerGrammarAccess grammarAccess) {
			builder.put(grammarAccess.getSourceLineAccess().getAlternatives(), "rule__SourceLine__Alternatives");
			builder.put(grammarAccess.getDirectiveLineAccess().getAlternatives(), "rule__DirectiveLine__Alternatives");
			builder.put(grammarAccess.getPrimaryAccess().getAlternatives(), "rule__Primary__Alternatives");
			builder.put(grammarAccess.getEndOfLineAccess().getAlternatives(), "rule__EndOfLine__Alternatives");
			builder.put(grammarAccess.getBlankLineAccess().getGroup(), "rule__BlankLine__Group__0");
			builder.put(grammarAccess.getCommentLineAccess().getGroup(), "rule__CommentLine__Group__0");
			builder.put(grammarAccess.getRmbDirectiveAccess().getGroup(), "rule__RmbDirective__Group__0");
			builder.put(grammarAccess.getRmbDirectiveAccess().getGroup_3(), "rule__RmbDirective__Group_3__0");
			builder.put(grammarAccess.getRmbDirectiveAccess().getGroup_4(), "rule__RmbDirective__Group_4__0");
			builder.put(grammarAccess.getEndDirectiveAccess().getGroup(), "rule__EndDirective__Group__0");
			builder.put(grammarAccess.getEndDirectiveAccess().getGroup_3(), "rule__EndDirective__Group_3__0");
			builder.put(grammarAccess.getEndDirectiveAccess().getGroup_4(), "rule__EndDirective__Group_4__0");
			builder.put(grammarAccess.getOrgDirectiveAccess().getGroup(), "rule__OrgDirective__Group__0");
			builder.put(grammarAccess.getOrgDirectiveAccess().getGroup_3(), "rule__OrgDirective__Group_3__0");
			builder.put(grammarAccess.getOrgDirectiveAccess().getGroup_4(), "rule__OrgDirective__Group_4__0");
			builder.put(grammarAccess.getEquDirectiveAccess().getGroup(), "rule__EquDirective__Group__0");
			builder.put(grammarAccess.getMultiplicationAccess().getGroup(), "rule__Multiplication__Group__0");
			builder.put(grammarAccess.getMultiplicationAccess().getGroup_1(), "rule__Multiplication__Group_1__0");
			builder.put(grammarAccess.getDivisionAccess().getGroup(), "rule__Division__Group__0");
			builder.put(grammarAccess.getDivisionAccess().getGroup_1(), "rule__Division__Group_1__0");
			builder.put(grammarAccess.getModuloAccess().getGroup(), "rule__Modulo__Group__0");
			builder.put(grammarAccess.getModuloAccess().getGroup_1(), "rule__Modulo__Group_1__0");
			builder.put(grammarAccess.getAdditionAccess().getGroup(), "rule__Addition__Group__0");
			builder.put(grammarAccess.getAdditionAccess().getGroup_1(), "rule__Addition__Group_1__0");
			builder.put(grammarAccess.getSubstractionAccess().getGroup(), "rule__Substraction__Group__0");
			builder.put(grammarAccess.getSubstractionAccess().getGroup_1(), "rule__Substraction__Group_1__0");
			builder.put(grammarAccess.getLeftShiftAccess().getGroup(), "rule__LeftShift__Group__0");
			builder.put(grammarAccess.getLeftShiftAccess().getGroup_1(), "rule__LeftShift__Group_1__0");
			builder.put(grammarAccess.getRightShiftAccess().getGroup(), "rule__RightShift__Group__0");
			builder.put(grammarAccess.getRightShiftAccess().getGroup_1(), "rule__RightShift__Group_1__0");
			builder.put(grammarAccess.getAndAccess().getGroup(), "rule__And__Group__0");
			builder.put(grammarAccess.getAndAccess().getGroup_1(), "rule__And__Group_1__0");
			builder.put(grammarAccess.getOrAccess().getGroup(), "rule__Or__Group__0");
			builder.put(grammarAccess.getOrAccess().getGroup_1(), "rule__Or__Group_1__0");
			builder.put(grammarAccess.getXorAccess().getGroup(), "rule__Xor__Group__0");
			builder.put(grammarAccess.getXorAccess().getGroup_1(), "rule__Xor__Group_1__0");
			builder.put(grammarAccess.getPrimaryAccess().getGroup_6(), "rule__Primary__Group_6__0");
			builder.put(grammarAccess.getPrimaryAccess().getGroup_7(), "rule__Primary__Group_7__0");
			builder.put(grammarAccess.getDecimalValueAccess().getGroup(), "rule__DecimalValue__Group__0");
			builder.put(grammarAccess.getModelAccess().getSourceLinesAssignment(), "rule__Model__SourceLinesAssignment");
			builder.put(grammarAccess.getSourceLineAccess().getLineContentAssignment_0(), "rule__SourceLine__LineContentAssignment_0");
			builder.put(grammarAccess.getSourceLineAccess().getLineContentAssignment_1(), "rule__SourceLine__LineContentAssignment_1");
			builder.put(grammarAccess.getSourceLineAccess().getLineContentAssignment_2(), "rule__SourceLine__LineContentAssignment_2");
			builder.put(grammarAccess.getBlankLineAccess().getBlankLineAssignment_1(), "rule__BlankLine__BlankLineAssignment_1");
			builder.put(grammarAccess.getCommentLineAccess().getCommentAssignment_0(), "rule__CommentLine__CommentAssignment_0");
			builder.put(grammarAccess.getDirectiveLineAccess().getDirectiveAssignment_0(), "rule__DirectiveLine__DirectiveAssignment_0");
			builder.put(grammarAccess.getDirectiveLineAccess().getDirectiveAssignment_1(), "rule__DirectiveLine__DirectiveAssignment_1");
			builder.put(grammarAccess.getDirectiveLineAccess().getDirectiveAssignment_2(), "rule__DirectiveLine__DirectiveAssignment_2");
			builder.put(grammarAccess.getDirectiveLineAccess().getDirectiveAssignment_3(), "rule__DirectiveLine__DirectiveAssignment_3");
			builder.put(grammarAccess.getRmbDirectiveAccess().getNameAssignment_0(), "rule__RmbDirective__NameAssignment_0");
			builder.put(grammarAccess.getRmbDirectiveAccess().getDirectiveAssignment_2(), "rule__RmbDirective__DirectiveAssignment_2");
			builder.put(grammarAccess.getRmbDirectiveAccess().getOperandAssignment_3_1(), "rule__RmbDirective__OperandAssignment_3_1");
			builder.put(grammarAccess.getRmbDirectiveAccess().getCommentAssignment_4_1(), "rule__RmbDirective__CommentAssignment_4_1");
			builder.put(grammarAccess.getEndDirectiveAccess().getNameAssignment_0(), "rule__EndDirective__NameAssignment_0");
			builder.put(grammarAccess.getEndDirectiveAccess().getDirectiveAssignment_2(), "rule__EndDirective__DirectiveAssignment_2");
			builder.put(grammarAccess.getEndDirectiveAccess().getOperandAssignment_3_1(), "rule__EndDirective__OperandAssignment_3_1");
			builder.put(grammarAccess.getEndDirectiveAccess().getCommentAssignment_4_1(), "rule__EndDirective__CommentAssignment_4_1");
			builder.put(grammarAccess.getOrgDirectiveAccess().getNameAssignment_0(), "rule__OrgDirective__NameAssignment_0");
			builder.put(grammarAccess.getOrgDirectiveAccess().getDirectiveAssignment_2(), "rule__OrgDirective__DirectiveAssignment_2");
			builder.put(grammarAccess.getOrgDirectiveAccess().getOperandAssignment_3_1(), "rule__OrgDirective__OperandAssignment_3_1");
			builder.put(grammarAccess.getOrgDirectiveAccess().getCommentAssignment_4_1(), "rule__OrgDirective__CommentAssignment_4_1");
			builder.put(grammarAccess.getEquDirectiveAccess().getNameAssignment_0(), "rule__EquDirective__NameAssignment_0");
			builder.put(grammarAccess.getEquDirectiveAccess().getDirectiveAssignment_2(), "rule__EquDirective__DirectiveAssignment_2");
			builder.put(grammarAccess.getEquDirectiveAccess().getOperandAssignment_4(), "rule__EquDirective__OperandAssignment_4");
			builder.put(grammarAccess.getEquDirectiveAccess().getCommentAssignment_6(), "rule__EquDirective__CommentAssignment_6");
			builder.put(grammarAccess.getExpressionAccess().getOperandAssignment(), "rule__Expression__OperandAssignment");
			builder.put(grammarAccess.getMultiplicationAccess().getOperationAssignment_1_1(), "rule__Multiplication__OperationAssignment_1_1");
			builder.put(grammarAccess.getMultiplicationAccess().getRightAssignment_1_2(), "rule__Multiplication__RightAssignment_1_2");
			builder.put(grammarAccess.getDivisionAccess().getOpretationAssignment_1_1(), "rule__Division__OpretationAssignment_1_1");
			builder.put(grammarAccess.getDivisionAccess().getRightAssignment_1_2(), "rule__Division__RightAssignment_1_2");
			builder.put(grammarAccess.getModuloAccess().getOpretationAssignment_1_1(), "rule__Modulo__OpretationAssignment_1_1");
			builder.put(grammarAccess.getModuloAccess().getRightAssignment_1_2(), "rule__Modulo__RightAssignment_1_2");
			builder.put(grammarAccess.getAdditionAccess().getRightAssignment_1_2(), "rule__Addition__RightAssignment_1_2");
			builder.put(grammarAccess.getSubstractionAccess().getRightAssignment_1_2(), "rule__Substraction__RightAssignment_1_2");
			builder.put(grammarAccess.getLeftShiftAccess().getRightAssignment_1_2(), "rule__LeftShift__RightAssignment_1_2");
			builder.put(grammarAccess.getRightShiftAccess().getRightAssignment_1_2(), "rule__RightShift__RightAssignment_1_2");
			builder.put(grammarAccess.getAndAccess().getRightAssignment_1_2(), "rule__And__RightAssignment_1_2");
			builder.put(grammarAccess.getOrAccess().getRightAssignment_1_2(), "rule__Or__RightAssignment_1_2");
			builder.put(grammarAccess.getXorAccess().getRightAssignment_1_2(), "rule__Xor__RightAssignment_1_2");
			builder.put(grammarAccess.getPrimaryAccess().getValueAssignment_0(), "rule__Primary__ValueAssignment_0");
			builder.put(grammarAccess.getPrimaryAccess().getValueAssignment_1(), "rule__Primary__ValueAssignment_1");
			builder.put(grammarAccess.getPrimaryAccess().getValueAssignment_2(), "rule__Primary__ValueAssignment_2");
			builder.put(grammarAccess.getPrimaryAccess().getValueAssignment_3(), "rule__Primary__ValueAssignment_3");
			builder.put(grammarAccess.getPrimaryAccess().getValueAssignment_4(), "rule__Primary__ValueAssignment_4");
			builder.put(grammarAccess.getPrimaryAccess().getValueAssignment_5(), "rule__Primary__ValueAssignment_5");
			builder.put(grammarAccess.getPrimaryAccess().getValueAssignment_6_2(), "rule__Primary__ValueAssignment_6_2");
			builder.put(grammarAccess.getIdentifierValueAccess().getValueAssignment(), "rule__IdentifierValue__ValueAssignment");
			builder.put(grammarAccess.getStringValueAccess().getValueAssignment(), "rule__StringValue__ValueAssignment");
			builder.put(grammarAccess.getDecimalValueAccess().getIsNegativeAssignment_0(), "rule__DecimalValue__IsNegativeAssignment_0");
			builder.put(grammarAccess.getDecimalValueAccess().getValueAssignment_1(), "rule__DecimalValue__ValueAssignment_1");
			builder.put(grammarAccess.getHexaDecimalValueAccess().getValueAssignment(), "rule__HexaDecimalValue__ValueAssignment");
			builder.put(grammarAccess.getOctalValueAccess().getValueAssignment(), "rule__OctalValue__ValueAssignment");
			builder.put(grammarAccess.getBinaryValueAccess().getValueAssignment(), "rule__BinaryValue__ValueAssignment");
			builder.put(grammarAccess.getCharacterValueAccess().getValueAssignment(), "rule__CharacterValue__ValueAssignment");
		}
	}
	
	@Inject
	private NameMappings nameMappings;

	@Inject
	private AssemblerGrammarAccess grammarAccess;

	@Override
	protected InternalAssemblerParser createParser() {
		InternalAssemblerParser result = new InternalAssemblerParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		return nameMappings.getRuleName(element);
	}

	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] {  };
	}

	public AssemblerGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(AssemblerGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
	public NameMappings getNameMappings() {
		return nameMappings;
	}
	
	public void setNameMappings(NameMappings nameMappings) {
		this.nameMappings = nameMappings;
	}
}
