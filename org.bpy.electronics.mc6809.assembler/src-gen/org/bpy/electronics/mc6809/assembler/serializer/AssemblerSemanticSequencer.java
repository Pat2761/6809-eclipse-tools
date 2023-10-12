/*
 * generated by Xtext 2.29.0
 */
package org.bpy.electronics.mc6809.assembler.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.bpy.electronics.mc6809.assembler.assembler.Addition;
import org.bpy.electronics.mc6809.assembler.assembler.And;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.BinaryValue;
import org.bpy.electronics.mc6809.assembler.assembler.BlankLine;
import org.bpy.electronics.mc6809.assembler.assembler.CharacterValue;
import org.bpy.electronics.mc6809.assembler.assembler.CommentLine;
import org.bpy.electronics.mc6809.assembler.assembler.DecimalValue;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.Division;
import org.bpy.electronics.mc6809.assembler.assembler.EndDirective;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Expression;
import org.bpy.electronics.mc6809.assembler.assembler.HexaDecimalValue;
import org.bpy.electronics.mc6809.assembler.assembler.IdentifierValue;
import org.bpy.electronics.mc6809.assembler.assembler.LeftShift;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.Modulo;
import org.bpy.electronics.mc6809.assembler.assembler.Multiplication;
import org.bpy.electronics.mc6809.assembler.assembler.Not;
import org.bpy.electronics.mc6809.assembler.assembler.OctalValue;
import org.bpy.electronics.mc6809.assembler.assembler.Or;
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;
import org.bpy.electronics.mc6809.assembler.assembler.RightShift;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.assembler.StringValue;
import org.bpy.electronics.mc6809.assembler.assembler.Substraction;
import org.bpy.electronics.mc6809.assembler.assembler.Xor;
import org.bpy.electronics.mc6809.assembler.services.AssemblerGrammarAccess;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class AssemblerSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private AssemblerGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == AssemblerPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case AssemblerPackage.ADDITION:
				sequence_Addition(context, (Addition) semanticObject); 
				return; 
			case AssemblerPackage.AND:
				sequence_And(context, (And) semanticObject); 
				return; 
			case AssemblerPackage.BINARY_VALUE:
				sequence_BinaryValue(context, (BinaryValue) semanticObject); 
				return; 
			case AssemblerPackage.BLANK_LINE:
				sequence_BlankLine(context, (BlankLine) semanticObject); 
				return; 
			case AssemblerPackage.CHARACTER_VALUE:
				sequence_CharacterValue(context, (CharacterValue) semanticObject); 
				return; 
			case AssemblerPackage.COMMENT_LINE:
				sequence_CommentLine(context, (CommentLine) semanticObject); 
				return; 
			case AssemblerPackage.DECIMAL_VALUE:
				sequence_DecimalValue(context, (DecimalValue) semanticObject); 
				return; 
			case AssemblerPackage.DIRECTIVE_LINE:
				sequence_DirectiveLine(context, (DirectiveLine) semanticObject); 
				return; 
			case AssemblerPackage.DIVISION:
				sequence_Division(context, (Division) semanticObject); 
				return; 
			case AssemblerPackage.END_DIRECTIVE:
				sequence_EndDirective(context, (EndDirective) semanticObject); 
				return; 
			case AssemblerPackage.EQU_DIRECTIVE:
				sequence_EquDirective(context, (EquDirective) semanticObject); 
				return; 
			case AssemblerPackage.EXPRESSION:
				if (rule == grammarAccess.getExpressionRule()) {
					sequence_Expression(context, (Expression) semanticObject); 
					return; 
				}
				else if (rule == grammarAccess.getMultiplicationRule()
						|| action == grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0()
						|| rule == grammarAccess.getDivisionRule()
						|| action == grammarAccess.getDivisionAccess().getDivisionLeftAction_1_0()
						|| rule == grammarAccess.getModuloRule()
						|| action == grammarAccess.getModuloAccess().getModuloLeftAction_1_0()
						|| rule == grammarAccess.getAdditionRule()
						|| action == grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0()
						|| rule == grammarAccess.getSubstractionRule()
						|| action == grammarAccess.getSubstractionAccess().getSubstractionLeftAction_1_0()
						|| rule == grammarAccess.getLeftShiftRule()
						|| action == grammarAccess.getLeftShiftAccess().getLeftShiftLeftAction_1_0()
						|| rule == grammarAccess.getRightShiftRule()
						|| action == grammarAccess.getRightShiftAccess().getRightShiftLeftAction_1_0()
						|| rule == grammarAccess.getAndRule()
						|| action == grammarAccess.getAndAccess().getAndLeftAction_1_0()
						|| rule == grammarAccess.getOrRule()
						|| action == grammarAccess.getOrAccess().getOrLeftAction_1_0()
						|| rule == grammarAccess.getXorRule()
						|| action == grammarAccess.getXorAccess().getXorLeftAction_1_0()
						|| rule == grammarAccess.getPrimaryRule()) {
					sequence_Primary(context, (Expression) semanticObject); 
					return; 
				}
				else break;
			case AssemblerPackage.HEXA_DECIMAL_VALUE:
				sequence_HexaDecimalValue(context, (HexaDecimalValue) semanticObject); 
				return; 
			case AssemblerPackage.IDENTIFIER_VALUE:
				sequence_IdentifierValue(context, (IdentifierValue) semanticObject); 
				return; 
			case AssemblerPackage.LEFT_SHIFT:
				sequence_LeftShift(context, (LeftShift) semanticObject); 
				return; 
			case AssemblerPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case AssemblerPackage.MODULO:
				sequence_Modulo(context, (Modulo) semanticObject); 
				return; 
			case AssemblerPackage.MULTIPLICATION:
				sequence_Multiplication(context, (Multiplication) semanticObject); 
				return; 
			case AssemblerPackage.NOT:
				sequence_Primary(context, (Not) semanticObject); 
				return; 
			case AssemblerPackage.OCTAL_VALUE:
				sequence_OctalValue(context, (OctalValue) semanticObject); 
				return; 
			case AssemblerPackage.OR:
				sequence_Or(context, (Or) semanticObject); 
				return; 
			case AssemblerPackage.ORG_DIRECTIVE:
				sequence_OrgDirective(context, (OrgDirective) semanticObject); 
				return; 
			case AssemblerPackage.RIGHT_SHIFT:
				sequence_RightShift(context, (RightShift) semanticObject); 
				return; 
			case AssemblerPackage.SOURCE_LINE:
				sequence_SourceLine(context, (SourceLine) semanticObject); 
				return; 
			case AssemblerPackage.STRING_VALUE:
				sequence_StringValue(context, (StringValue) semanticObject); 
				return; 
			case AssemblerPackage.SUBSTRACTION:
				sequence_Substraction(context, (Substraction) semanticObject); 
				return; 
			case AssemblerPackage.XOR:
				sequence_Xor(context, (Xor) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * <pre>
	 * Contexts:
	 *     Multiplication returns Addition
	 *     Multiplication.Multiplication_1_0 returns Addition
	 *     Division returns Addition
	 *     Division.Division_1_0 returns Addition
	 *     Modulo returns Addition
	 *     Modulo.Modulo_1_0 returns Addition
	 *     Addition returns Addition
	 *     Addition.Addition_1_0 returns Addition
	 *     Substraction returns Addition
	 *     Substraction.Substraction_1_0 returns Addition
	 *     LeftShift returns Addition
	 *     LeftShift.LeftShift_1_0 returns Addition
	 *     RightShift returns Addition
	 *     RightShift.RightShift_1_0 returns Addition
	 *     And returns Addition
	 *     And.And_1_0 returns Addition
	 *     Or returns Addition
	 *     Or.Or_1_0 returns Addition
	 *     Xor returns Addition
	 *     Xor.Xor_1_0 returns Addition
	 *     Primary returns Addition
	 *
	 * Constraint:
	 *     (left=Addition_Addition_1_0 right=Substraction)
	 * </pre>
	 */
	protected void sequence_Addition(ISerializationContext context, Addition semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.ADDITION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.ADDITION__LEFT));
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.ADDITION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.ADDITION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAdditionAccess().getAdditionLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAdditionAccess().getRightSubstractionParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Multiplication returns And
	 *     Multiplication.Multiplication_1_0 returns And
	 *     Division returns And
	 *     Division.Division_1_0 returns And
	 *     Modulo returns And
	 *     Modulo.Modulo_1_0 returns And
	 *     Addition returns And
	 *     Addition.Addition_1_0 returns And
	 *     Substraction returns And
	 *     Substraction.Substraction_1_0 returns And
	 *     LeftShift returns And
	 *     LeftShift.LeftShift_1_0 returns And
	 *     RightShift returns And
	 *     RightShift.RightShift_1_0 returns And
	 *     And returns And
	 *     And.And_1_0 returns And
	 *     Or returns And
	 *     Or.Or_1_0 returns And
	 *     Xor returns And
	 *     Xor.Xor_1_0 returns And
	 *     Primary returns And
	 *
	 * Constraint:
	 *     (left=And_And_1_0 right=Or)
	 * </pre>
	 */
	protected void sequence_And(ISerializationContext context, And semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.AND__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.AND__LEFT));
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.AND__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.AND__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getAndAccess().getAndLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getAndAccess().getRightOrParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     BinaryValue returns BinaryValue
	 *
	 * Constraint:
	 *     value=BINARY
	 * </pre>
	 */
	protected void sequence_BinaryValue(ISerializationContext context, BinaryValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.BINARY_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.BINARY_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getBinaryValueAccess().getValueBINARYTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     BlankLine returns BlankLine
	 *
	 * Constraint:
	 *     blankLine=WS?
	 * </pre>
	 */
	protected void sequence_BlankLine(ISerializationContext context, BlankLine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     CharacterValue returns CharacterValue
	 *
	 * Constraint:
	 *     value=CHARACTER
	 * </pre>
	 */
	protected void sequence_CharacterValue(ISerializationContext context, CharacterValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.CHARACTER_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.CHARACTER_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCharacterValueAccess().getValueCHARACTERTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     CommentLine returns CommentLine
	 *
	 * Constraint:
	 *     comment=ANY_EXCEPT_COMMENT_END_OF_LINE
	 * </pre>
	 */
	protected void sequence_CommentLine(ISerializationContext context, CommentLine semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.COMMENT_LINE__COMMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.COMMENT_LINE__COMMENT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getCommentLineAccess().getCommentANY_EXCEPT_COMMENT_END_OF_LINETerminalRuleCall_0_0(), semanticObject.getComment());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     DecimalValue returns DecimalValue
	 *
	 * Constraint:
	 *     (isNegative?='-'? value=INT)
	 * </pre>
	 */
	protected void sequence_DecimalValue(ISerializationContext context, DecimalValue semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     DirectiveLine returns DirectiveLine
	 *
	 * Constraint:
	 *     (directive=EquDirective | directive=OrgDirective | directive=EndDirective)
	 * </pre>
	 */
	protected void sequence_DirectiveLine(ISerializationContext context, DirectiveLine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Multiplication returns Division
	 *     Multiplication.Multiplication_1_0 returns Division
	 *     Division returns Division
	 *     Division.Division_1_0 returns Division
	 *     Modulo returns Division
	 *     Modulo.Modulo_1_0 returns Division
	 *     Addition returns Division
	 *     Addition.Addition_1_0 returns Division
	 *     Substraction returns Division
	 *     Substraction.Substraction_1_0 returns Division
	 *     LeftShift returns Division
	 *     LeftShift.LeftShift_1_0 returns Division
	 *     RightShift returns Division
	 *     RightShift.RightShift_1_0 returns Division
	 *     And returns Division
	 *     And.And_1_0 returns Division
	 *     Or returns Division
	 *     Or.Or_1_0 returns Division
	 *     Xor returns Division
	 *     Xor.Xor_1_0 returns Division
	 *     Primary returns Division
	 *
	 * Constraint:
	 *     (left=Division_Division_1_0 opretation='/' right=Modulo)
	 * </pre>
	 */
	protected void sequence_Division(ISerializationContext context, Division semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.DIVISION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.DIVISION__LEFT));
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.DIVISION__OPRETATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.DIVISION__OPRETATION));
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.DIVISION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.DIVISION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getDivisionAccess().getDivisionLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getDivisionAccess().getOpretationSolidusKeyword_1_1_0(), semanticObject.getOpretation());
		feeder.accept(grammarAccess.getDivisionAccess().getRightModuloParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     EndDirective returns EndDirective
	 *
	 * Constraint:
	 *     (name=IdentifierValue? directive='END' operand=Expression? comment=ANY_EXCEPT_COMMENT_END_OF_LINE?)
	 * </pre>
	 */
	protected void sequence_EndDirective(ISerializationContext context, EndDirective semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     EquDirective returns EquDirective
	 *
	 * Constraint:
	 *     (name=IdentifierValue? directive='EQU' operand=Expression? comment=ANY_EXCEPT_COMMENT_END_OF_LINE?)
	 * </pre>
	 */
	protected void sequence_EquDirective(ISerializationContext context, EquDirective semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Expression returns Expression
	 *
	 * Constraint:
	 *     operand=Multiplication
	 * </pre>
	 */
	protected void sequence_Expression(ISerializationContext context, Expression semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.EXPRESSION__OPERAND) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.EXPRESSION__OPERAND));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getExpressionAccess().getOperandMultiplicationParserRuleCall_0(), semanticObject.getOperand());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     HexaDecimalValue returns HexaDecimalValue
	 *
	 * Constraint:
	 *     value=HEXA
	 * </pre>
	 */
	protected void sequence_HexaDecimalValue(ISerializationContext context, HexaDecimalValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.HEXA_DECIMAL_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.HEXA_DECIMAL_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getHexaDecimalValueAccess().getValueHEXATerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     IdentifierValue returns IdentifierValue
	 *
	 * Constraint:
	 *     value=ID
	 * </pre>
	 */
	protected void sequence_IdentifierValue(ISerializationContext context, IdentifierValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.IDENTIFIER_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.IDENTIFIER_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getIdentifierValueAccess().getValueIDTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Multiplication returns LeftShift
	 *     Multiplication.Multiplication_1_0 returns LeftShift
	 *     Division returns LeftShift
	 *     Division.Division_1_0 returns LeftShift
	 *     Modulo returns LeftShift
	 *     Modulo.Modulo_1_0 returns LeftShift
	 *     Addition returns LeftShift
	 *     Addition.Addition_1_0 returns LeftShift
	 *     Substraction returns LeftShift
	 *     Substraction.Substraction_1_0 returns LeftShift
	 *     LeftShift returns LeftShift
	 *     LeftShift.LeftShift_1_0 returns LeftShift
	 *     RightShift returns LeftShift
	 *     RightShift.RightShift_1_0 returns LeftShift
	 *     And returns LeftShift
	 *     And.And_1_0 returns LeftShift
	 *     Or returns LeftShift
	 *     Or.Or_1_0 returns LeftShift
	 *     Xor returns LeftShift
	 *     Xor.Xor_1_0 returns LeftShift
	 *     Primary returns LeftShift
	 *
	 * Constraint:
	 *     (left=LeftShift_LeftShift_1_0 right=RightShift)
	 * </pre>
	 */
	protected void sequence_LeftShift(ISerializationContext context, LeftShift semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.LEFT_SHIFT__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.LEFT_SHIFT__LEFT));
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.LEFT_SHIFT__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.LEFT_SHIFT__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getLeftShiftAccess().getLeftShiftLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getLeftShiftAccess().getRightRightShiftParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     sourceLines+=SourceLine+
	 * </pre>
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Multiplication returns Modulo
	 *     Multiplication.Multiplication_1_0 returns Modulo
	 *     Division returns Modulo
	 *     Division.Division_1_0 returns Modulo
	 *     Modulo returns Modulo
	 *     Modulo.Modulo_1_0 returns Modulo
	 *     Addition returns Modulo
	 *     Addition.Addition_1_0 returns Modulo
	 *     Substraction returns Modulo
	 *     Substraction.Substraction_1_0 returns Modulo
	 *     LeftShift returns Modulo
	 *     LeftShift.LeftShift_1_0 returns Modulo
	 *     RightShift returns Modulo
	 *     RightShift.RightShift_1_0 returns Modulo
	 *     And returns Modulo
	 *     And.And_1_0 returns Modulo
	 *     Or returns Modulo
	 *     Or.Or_1_0 returns Modulo
	 *     Xor returns Modulo
	 *     Xor.Xor_1_0 returns Modulo
	 *     Primary returns Modulo
	 *
	 * Constraint:
	 *     (left=Modulo_Modulo_1_0 opretation='%' right=Addition)
	 * </pre>
	 */
	protected void sequence_Modulo(ISerializationContext context, Modulo semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.MODULO__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.MODULO__LEFT));
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.MODULO__OPRETATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.MODULO__OPRETATION));
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.MODULO__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.MODULO__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getModuloAccess().getModuloLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getModuloAccess().getOpretationPercentSignKeyword_1_1_0(), semanticObject.getOpretation());
		feeder.accept(grammarAccess.getModuloAccess().getRightAdditionParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Multiplication returns Multiplication
	 *     Multiplication.Multiplication_1_0 returns Multiplication
	 *     Division returns Multiplication
	 *     Division.Division_1_0 returns Multiplication
	 *     Modulo returns Multiplication
	 *     Modulo.Modulo_1_0 returns Multiplication
	 *     Addition returns Multiplication
	 *     Addition.Addition_1_0 returns Multiplication
	 *     Substraction returns Multiplication
	 *     Substraction.Substraction_1_0 returns Multiplication
	 *     LeftShift returns Multiplication
	 *     LeftShift.LeftShift_1_0 returns Multiplication
	 *     RightShift returns Multiplication
	 *     RightShift.RightShift_1_0 returns Multiplication
	 *     And returns Multiplication
	 *     And.And_1_0 returns Multiplication
	 *     Or returns Multiplication
	 *     Or.Or_1_0 returns Multiplication
	 *     Xor returns Multiplication
	 *     Xor.Xor_1_0 returns Multiplication
	 *     Primary returns Multiplication
	 *
	 * Constraint:
	 *     (left=Multiplication_Multiplication_1_0 operation='*' right=Division)
	 * </pre>
	 */
	protected void sequence_Multiplication(ISerializationContext context, Multiplication semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.MULTIPLICATION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.MULTIPLICATION__LEFT));
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.MULTIPLICATION__OPERATION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.MULTIPLICATION__OPERATION));
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.MULTIPLICATION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.MULTIPLICATION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getMultiplicationAccess().getMultiplicationLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getMultiplicationAccess().getOperationAsteriskKeyword_1_1_0(), semanticObject.getOperation());
		feeder.accept(grammarAccess.getMultiplicationAccess().getRightDivisionParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     OctalValue returns OctalValue
	 *
	 * Constraint:
	 *     value=OCTAL
	 * </pre>
	 */
	protected void sequence_OctalValue(ISerializationContext context, OctalValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.OCTAL_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.OCTAL_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOctalValueAccess().getValueOCTALTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Multiplication returns Or
	 *     Multiplication.Multiplication_1_0 returns Or
	 *     Division returns Or
	 *     Division.Division_1_0 returns Or
	 *     Modulo returns Or
	 *     Modulo.Modulo_1_0 returns Or
	 *     Addition returns Or
	 *     Addition.Addition_1_0 returns Or
	 *     Substraction returns Or
	 *     Substraction.Substraction_1_0 returns Or
	 *     LeftShift returns Or
	 *     LeftShift.LeftShift_1_0 returns Or
	 *     RightShift returns Or
	 *     RightShift.RightShift_1_0 returns Or
	 *     And returns Or
	 *     And.And_1_0 returns Or
	 *     Or returns Or
	 *     Or.Or_1_0 returns Or
	 *     Xor returns Or
	 *     Xor.Xor_1_0 returns Or
	 *     Primary returns Or
	 *
	 * Constraint:
	 *     (left=Or_Or_1_0 right=Xor)
	 * </pre>
	 */
	protected void sequence_Or(ISerializationContext context, Or semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.OR__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.OR__LEFT));
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.OR__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.OR__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getOrAccess().getOrLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getOrAccess().getRightXorParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     OrgDirective returns OrgDirective
	 *
	 * Constraint:
	 *     (name=IdentifierValue? directive='ORG' operand=Expression? comment=ANY_EXCEPT_COMMENT_END_OF_LINE?)
	 * </pre>
	 */
	protected void sequence_OrgDirective(ISerializationContext context, OrgDirective semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Multiplication returns Expression
	 *     Multiplication.Multiplication_1_0 returns Expression
	 *     Division returns Expression
	 *     Division.Division_1_0 returns Expression
	 *     Modulo returns Expression
	 *     Modulo.Modulo_1_0 returns Expression
	 *     Addition returns Expression
	 *     Addition.Addition_1_0 returns Expression
	 *     Substraction returns Expression
	 *     Substraction.Substraction_1_0 returns Expression
	 *     LeftShift returns Expression
	 *     LeftShift.LeftShift_1_0 returns Expression
	 *     RightShift returns Expression
	 *     RightShift.RightShift_1_0 returns Expression
	 *     And returns Expression
	 *     And.And_1_0 returns Expression
	 *     Or returns Expression
	 *     Or.Or_1_0 returns Expression
	 *     Xor returns Expression
	 *     Xor.Xor_1_0 returns Expression
	 *     Primary returns Expression
	 *
	 * Constraint:
	 *     (
	 *         value=DecimalValue | 
	 *         value=HexaDecimalValue | 
	 *         value=OctalValue | 
	 *         value=BinaryValue | 
	 *         value=CharacterValue | 
	 *         value=IdentifierValue
	 *     )
	 * </pre>
	 */
	protected void sequence_Primary(ISerializationContext context, Expression semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Multiplication returns Not
	 *     Multiplication.Multiplication_1_0 returns Not
	 *     Division returns Not
	 *     Division.Division_1_0 returns Not
	 *     Modulo returns Not
	 *     Modulo.Modulo_1_0 returns Not
	 *     Addition returns Not
	 *     Addition.Addition_1_0 returns Not
	 *     Substraction returns Not
	 *     Substraction.Substraction_1_0 returns Not
	 *     LeftShift returns Not
	 *     LeftShift.LeftShift_1_0 returns Not
	 *     RightShift returns Not
	 *     RightShift.RightShift_1_0 returns Not
	 *     And returns Not
	 *     And.And_1_0 returns Not
	 *     Or returns Not
	 *     Or.Or_1_0 returns Not
	 *     Xor returns Not
	 *     Xor.Xor_1_0 returns Not
	 *     Primary returns Not
	 *
	 * Constraint:
	 *     value=Primary
	 * </pre>
	 */
	protected void sequence_Primary(ISerializationContext context, Not semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.EXPRESSION__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.EXPRESSION__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getPrimaryAccess().getValuePrimaryParserRuleCall_6_2_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Multiplication returns RightShift
	 *     Multiplication.Multiplication_1_0 returns RightShift
	 *     Division returns RightShift
	 *     Division.Division_1_0 returns RightShift
	 *     Modulo returns RightShift
	 *     Modulo.Modulo_1_0 returns RightShift
	 *     Addition returns RightShift
	 *     Addition.Addition_1_0 returns RightShift
	 *     Substraction returns RightShift
	 *     Substraction.Substraction_1_0 returns RightShift
	 *     LeftShift returns RightShift
	 *     LeftShift.LeftShift_1_0 returns RightShift
	 *     RightShift returns RightShift
	 *     RightShift.RightShift_1_0 returns RightShift
	 *     And returns RightShift
	 *     And.And_1_0 returns RightShift
	 *     Or returns RightShift
	 *     Or.Or_1_0 returns RightShift
	 *     Xor returns RightShift
	 *     Xor.Xor_1_0 returns RightShift
	 *     Primary returns RightShift
	 *
	 * Constraint:
	 *     (left=RightShift_RightShift_1_0 right=And)
	 * </pre>
	 */
	protected void sequence_RightShift(ISerializationContext context, RightShift semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.RIGHT_SHIFT__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.RIGHT_SHIFT__LEFT));
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.RIGHT_SHIFT__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.RIGHT_SHIFT__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getRightShiftAccess().getRightShiftLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getRightShiftAccess().getRightAndParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     SourceLine returns SourceLine
	 *
	 * Constraint:
	 *     (lineContent=BlankLine | lineContent=CommentLine | lineContent=DirectiveLine)
	 * </pre>
	 */
	protected void sequence_SourceLine(ISerializationContext context, SourceLine semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     StringValue returns StringValue
	 *
	 * Constraint:
	 *     value=STRING
	 * </pre>
	 */
	protected void sequence_StringValue(ISerializationContext context, StringValue semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.STRING_VALUE__VALUE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.STRING_VALUE__VALUE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getStringValueAccess().getValueSTRINGTerminalRuleCall_0(), semanticObject.getValue());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Multiplication returns Substraction
	 *     Multiplication.Multiplication_1_0 returns Substraction
	 *     Division returns Substraction
	 *     Division.Division_1_0 returns Substraction
	 *     Modulo returns Substraction
	 *     Modulo.Modulo_1_0 returns Substraction
	 *     Addition returns Substraction
	 *     Addition.Addition_1_0 returns Substraction
	 *     Substraction returns Substraction
	 *     Substraction.Substraction_1_0 returns Substraction
	 *     LeftShift returns Substraction
	 *     LeftShift.LeftShift_1_0 returns Substraction
	 *     RightShift returns Substraction
	 *     RightShift.RightShift_1_0 returns Substraction
	 *     And returns Substraction
	 *     And.And_1_0 returns Substraction
	 *     Or returns Substraction
	 *     Or.Or_1_0 returns Substraction
	 *     Xor returns Substraction
	 *     Xor.Xor_1_0 returns Substraction
	 *     Primary returns Substraction
	 *
	 * Constraint:
	 *     (left=Substraction_Substraction_1_0 right=LeftShift)
	 * </pre>
	 */
	protected void sequence_Substraction(ISerializationContext context, Substraction semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.SUBSTRACTION__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.SUBSTRACTION__LEFT));
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.SUBSTRACTION__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.SUBSTRACTION__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSubstractionAccess().getSubstractionLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getSubstractionAccess().getRightLeftShiftParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
	/**
	 * <pre>
	 * Contexts:
	 *     Multiplication returns Xor
	 *     Multiplication.Multiplication_1_0 returns Xor
	 *     Division returns Xor
	 *     Division.Division_1_0 returns Xor
	 *     Modulo returns Xor
	 *     Modulo.Modulo_1_0 returns Xor
	 *     Addition returns Xor
	 *     Addition.Addition_1_0 returns Xor
	 *     Substraction returns Xor
	 *     Substraction.Substraction_1_0 returns Xor
	 *     LeftShift returns Xor
	 *     LeftShift.LeftShift_1_0 returns Xor
	 *     RightShift returns Xor
	 *     RightShift.RightShift_1_0 returns Xor
	 *     And returns Xor
	 *     And.And_1_0 returns Xor
	 *     Or returns Xor
	 *     Or.Or_1_0 returns Xor
	 *     Xor returns Xor
	 *     Xor.Xor_1_0 returns Xor
	 *     Primary returns Xor
	 *
	 * Constraint:
	 *     (left=Xor_Xor_1_0 right=Primary)
	 * </pre>
	 */
	protected void sequence_Xor(ISerializationContext context, Xor semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.XOR__LEFT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.XOR__LEFT));
			if (transientValues.isValueTransient(semanticObject, AssemblerPackage.Literals.XOR__RIGHT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, AssemblerPackage.Literals.XOR__RIGHT));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getXorAccess().getXorLeftAction_1_0(), semanticObject.getLeft());
		feeder.accept(grammarAccess.getXorAccess().getRightPrimaryParserRuleCall_1_2_0(), semanticObject.getRight());
		feeder.finish();
	}
	
	
}
