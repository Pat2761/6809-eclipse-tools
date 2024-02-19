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
package org.bpy.electronics.mc6809.assembler.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.assembler.assembler.Addition;
import org.bpy.electronics.mc6809.assembler.assembler.And;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.BinaryValue;
import org.bpy.electronics.mc6809.assembler.assembler.BszDirective;
import org.bpy.electronics.mc6809.assembler.assembler.CharacterValue;
import org.bpy.electronics.mc6809.assembler.assembler.CommaExpression;
import org.bpy.electronics.mc6809.assembler.assembler.DecimalValue;
import org.bpy.electronics.mc6809.assembler.assembler.DirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.Division;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Expression;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedIndirectOperand;
import org.bpy.electronics.mc6809.assembler.assembler.ExtendedOperand;
import org.bpy.electronics.mc6809.assembler.assembler.FcbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FdbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FillDirective;
import org.bpy.electronics.mc6809.assembler.assembler.HexaDecimalValue;
import org.bpy.electronics.mc6809.assembler.assembler.IdentifierValue;
import org.bpy.electronics.mc6809.assembler.assembler.ImmediatOperand;
import org.bpy.electronics.mc6809.assembler.assembler.LeftShift;
import org.bpy.electronics.mc6809.assembler.assembler.ListOfExpression;
import org.bpy.electronics.mc6809.assembler.assembler.Modulo;
import org.bpy.electronics.mc6809.assembler.assembler.Multiplication;
import org.bpy.electronics.mc6809.assembler.assembler.Not;
import org.bpy.electronics.mc6809.assembler.assembler.NumericalValue;
import org.bpy.electronics.mc6809.assembler.assembler.OctalValue;
import org.bpy.electronics.mc6809.assembler.assembler.Or;
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;
import org.bpy.electronics.mc6809.assembler.assembler.PagDirective;
import org.bpy.electronics.mc6809.assembler.assembler.RightShift;
import org.bpy.electronics.mc6809.assembler.assembler.RmbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SetDPDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SetDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SpcDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Substraction;
import org.bpy.electronics.mc6809.assembler.assembler.Xor;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorDescription;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * This class allow to parse expression 
 * 
 * @author Patrick
 *
 */
public class ExpressionParser {
	
	public static final String EXPRESSION_ERROR = "expressionError";
	public static final String OVERFLOW_ERROR = "overflowError";
	
	private static EReference eReference;
	private static Object assemblyLine; 
	
	/**
	 * Add a private constructor to hide the implicit public one.
	 */
	private ExpressionParser() {
	}

	/** Looger of the class */
	private static Logger logger = Logger.getLogger("ExpressionParser");
	private static Map<String, AbstractAssemblyLine> labelsPosition;

	/** 
	 *  Parse the operand of an FDB directive.
	 *  
	 *  @param fdbDirective reference on the FDB directive
	 *  @return value of the operand 
	 */
	public static List<Integer> parse(FdbDirective fdbDirective) {
		assemblyLine = fdbDirective;
		eReference = AssemblerPackage.Literals.FDB_DIRECTIVE__OPERAND;
		return parse(fdbDirective.getOperand()); 
	}

	/** 
	 *  Parse the operand of an FCB directive.
	 *  
	 *  @param fcbDirective reference on the FCB directive
	 *  @return value of the operand 
	 */
	public static List<Integer> parse(FcbDirective fcbDirective) {
		assemblyLine = fcbDirective;
		eReference = AssemblerPackage.Literals.FCB_DIRECTIVE__OPERAND;
		return parse(fcbDirective.getOperand()); 
	}

	private static List<Integer> parse(ListOfExpression operand) {
		List<Integer> listValues = new ArrayList<>();
		if (operand != null) {
			Expression expression = operand.getExpression();
			if (expression != null) {
				listValues.add(ExpressionParser.resolveExpression(expression.getOperand()));
				
				if (operand.getCommaExpressions() != null) {
					for (CommaExpression commaExpression : operand.getCommaExpressions()) {
						if (commaExpression.getExpression() != null) {
							listValues.add(ExpressionParser.resolveExpression(commaExpression.getExpression().getOperand()));
						} else {
							listValues.add(0);
						}
 					}
				}
			}
		}
		return listValues;
	}

	/** 
	 * Parse the value of an immediate operand.
	 *  
	 * @param immediatOperand reference on the instruction operand
	 * @param instructionReference used in a case of error detection 
	 * @param instruction reference on the instruction
	 * @param min the minimal value for the this mode
	 * @param max the maximal value for the this mode
	 * @return value of the operand 
	 */
	public static int parse(ImmediatOperand immediatOperand, EReference instructionReference,EObject instruction, int min, int max) {
		
		eReference = instructionReference;
		assemblyLine = instruction;
		
		int value = 0;		
		if (immediatOperand.getOperand() != null && immediatOperand.getOperand().getOperand() != null) {
			EObject operand = immediatOperand.getOperand().getOperand();
			value = resolveExpression((Expression)operand);
		}
		
		if (value < min) {
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					"The value " + value + " is below the possible limit, data may be lost" , 
					eReference, 
					OVERFLOW_ERROR);
			AssemblerErrorManager.getInstance().addProblem(assemblyLine, errorDescription);
			value = min;
		} else if (value > max) {
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					"The value " + value + " is greater than the possible limit, data may be lost" , 
					eReference, 
					OVERFLOW_ERROR);
			AssemblerErrorManager.getInstance().addProblem(assemblyLine, errorDescription);
			value = max;
		}
		return value & ((max<<1) | 1);
	}

	/** 
	 * Parse the value of the instruction operand.
	 *  
	 * @param directOperand reference on the instruction operand
	 * @param instructionReference used in a case of error detection 
	 * @param instruction reference on the instruction
	 * @param min the minimal value for the this mode
	 * @param max the maximal value for the this mode
	 * @return value of the operand 
	 */
	public static int parse(DirectOperand directOperand, EReference instructionReference,EObject instruction) {
		
		eReference = instructionReference;
		assemblyLine = instruction;
		
		int value = 0;		
		if (directOperand.getOperand() != null && directOperand.getOperand().getOperand() != null) {
			EObject operand = directOperand.getOperand().getOperand();
			value = resolveExpression((Expression)operand);
		}
		
		if (value < -128) {
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					"The value " + value + " is below the possible limit, data may be lost" , 
					eReference, 
					OVERFLOW_ERROR);
			AssemblerErrorManager.getInstance().addProblem(assemblyLine, errorDescription);
			value = -128;
		} else if (value > 127) {
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					"The value " + value + " is greater than the possible limit, data may be lost" , 
					eReference, 
					OVERFLOW_ERROR);
			AssemblerErrorManager.getInstance().addProblem(assemblyLine, errorDescription);
			value = 127;
		}
		
		return value & 0xFF;
	}

	/** 
	 * Parse the value of the instruction operand.
	 *  
	 * @param extendedOperand reference on the instruction operand
	 * @param instructionReference used in a case of error detection 
	 * @param instruction reference on the instruction
	 * @return value of the operand 
	 */
	public static int parse(ExtendedOperand extendedOperand, EReference instructionReference, EObject instruction) {
		
		eReference = instructionReference;
		assemblyLine = instruction;
		labelsPosition = null;
		
		int value = 0;		
		if (extendedOperand.getOperand() != null && extendedOperand.getOperand().getOperand() != null) {
			EObject operand = extendedOperand.getOperand().getOperand();
			value = resolveExpression((Expression)operand);
		}
		
		if (value < Short.MIN_VALUE) {
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					"The value " + value + " is below the possible limit, data may be lost" , 
					eReference, 
					OVERFLOW_ERROR);
			AssemblerErrorManager.getInstance().addProblem(assemblyLine, errorDescription);
			value = Short.MIN_VALUE;
		} else if (value > 65535) {
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					"The value " + value + " is greater than the possible limit, data may be lost" , 
					eReference, 
					OVERFLOW_ERROR);
			AssemblerErrorManager.getInstance().addProblem(assemblyLine, errorDescription);
			value = 65535;
		}
		
		return value & 0xFFFF;
	}

	/** 
	 * Parse the value of the instruction operand.
	 *  
	 * @param extendedOperand reference on the instruction operand
	 * @param instructionReference used in a case of error detection 
	 * @param labelsPositionObject list of label and their values
	 * @param instruction reference on the instruction
	 * @return value of the operand 
	 */
	public static int parse(ExtendedOperand extendedOperand, EReference instructionReference,
			Map<String, AbstractAssemblyLine> labelsPositionObject, EObject instruction) {
		
		eReference = instructionReference;
		assemblyLine = instruction;
		labelsPosition = labelsPositionObject;
		
		int value = 0;		
		if (extendedOperand.getOperand() != null && extendedOperand.getOperand().getOperand() != null) {
			EObject operand = extendedOperand.getOperand().getOperand();
			value = resolveExpression((Expression)operand);
		}
		
		if (value < Short.MIN_VALUE) {
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					"The value " + value + " is below the possible limit, data may be lost" , 
					eReference, 
					OVERFLOW_ERROR);
			AssemblerErrorManager.getInstance().addProblem(assemblyLine, errorDescription);
			value = Short.MIN_VALUE;
		} else if (value > 65535) {
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					"The value " + value + " is greater than the possible limit, data may be lost" , 
					eReference, 
					OVERFLOW_ERROR);
			AssemblerErrorManager.getInstance().addProblem(assemblyLine, errorDescription);
			value = 65535;
		}
		
		return value & 0xFFFF;
	}

	/** 
	 * Parse the value of the instruction operand.
	 *  
	 * @param extendedOperand reference on the instruction operand
	 * @param instructionReference used in a case of error detection 
	 * @param instruction reference on the instruction
	 * @return value of the operand 
	 */
	public static int parse(ExtendedIndirectOperand extendedOperand, EReference instructionReference, EObject instruction) {
		
		eReference = instructionReference;
		assemblyLine = instruction;
		
		int value = 0;		
		if (extendedOperand.getOperand() != null && extendedOperand.getOperand().getOperand() != null) {
			EObject operand = extendedOperand.getOperand().getOperand();
			value = resolveExpression((Expression)operand);
		}
		
		if (value < Short.MIN_VALUE) {
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					"The value " + value + " is below the possible limit, data may be lost" , 
					eReference, 
					OVERFLOW_ERROR);
			AssemblerErrorManager.getInstance().addProblem(assemblyLine, errorDescription);
			value = Short.MIN_VALUE;
		} else if (value > 65535) {
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					"The value " + value + " is greater than the possible limit, data may be lost" , 
					eReference, 
					OVERFLOW_ERROR);
			AssemblerErrorManager.getInstance().addProblem(assemblyLine, errorDescription);
			value = 65535;
		}
		
		return value & 0xFFFF;
	}

	/** 
	 *  Parse the operand of an EQU directive.
	 *  
	 * @param equDirective reference on the EQU directive
	 * @param equDirectiveOperand used in a case of error detection 
	 * @return value of the operand 
	 */
	public static int parse(EquDirective equDirective) {
		
		eReference = AssemblerPackage.Literals.EQU_DIRECTIVE__OPERAND;
		assemblyLine = equDirective;
		
		if (equDirective.getOperand() != null && equDirective.getOperand().getOperand() != null) {
			EObject operand = equDirective.getOperand().getOperand();
			return resolveExpression((Expression)operand);
		} else {
			return -1;
		}
	}

	/** 
	 *  Parse the operand of an SET directive.
	 *  
	 *  @param setDirective reference on the SET directive
	 *  @return value of the operand 
	 */
	public static int parse(SetDirective setDirective) {
		
		eReference = AssemblerPackage.Literals.SET_DIRECTIVE__OPERAND;
		assemblyLine = setDirective;

		if (setDirective.getOperand() != null && setDirective.getOperand().getOperand() != null) {
			EObject operand = setDirective.getOperand().getOperand();
			return resolveExpression((Expression)operand);
		} else {
			return -1;
		}
	}

	/** 
	 *  Parse the operand of an ORG directive.
	 *  
	 *  @param orgDirective reference on the ORG directive
	 *  @return value of the operand 
	 */
	public static int parse(OrgDirective orgDirective) {
		assemblyLine = orgDirective;
		eReference = AssemblerPackage.Literals.ORG_DIRECTIVE__OPERAND;

		if (orgDirective.getOperand() != null && orgDirective.getOperand().getOperand() != null) {
			EObject operand = orgDirective.getOperand().getOperand();
			return resolveExpression((Expression)operand);
		} else {
			return 0;
		}
	}

	/** 
	 *  Parse the operand of an PAG directive.
	 *  
	 *  @param pagDirective reference on the PAG directive
	 *  @return value of the operand 
	 */
	public static int parse(PagDirective pagDirective) {
		
		assemblyLine = pagDirective;
		eReference = AssemblerPackage.Literals.PAG_DIRECTIVE__OPERAND;
		
		if (pagDirective.getOperand() != null && pagDirective.getOperand().getOperand() != null) {
			EObject operand = pagDirective.getOperand().getOperand();
			return resolveExpression((Expression)operand);
		} else {
			return 1;
		}
	}

	/** 
	 *  Parse the operand of an RMB directive.
	 *  
	 *  @param rmbDirective reference on the RMB directive
	 *  @return value of the operand 
	 */
	public static int parse(RmbDirective rmbDirective) {
		assemblyLine = rmbDirective;
		eReference = AssemblerPackage.Literals.RMB_DIRECTIVE__OPERAND;
		if (rmbDirective.getOperand() != null && rmbDirective.getOperand().getOperand() != null) {
			EObject operand = rmbDirective.getOperand().getOperand();
			return resolveExpression((Expression)operand);
		} else {
			return 0;
		}
	}

	/** 
	 *  Parse the operand of an BSZ directive.
	 *  
	 *  @param bszDirective reference on the BSZ directive
	 *  @return value of the operand 
	 */
	public static int parse(BszDirective bszDirective) {
		assemblyLine = bszDirective;
		eReference = AssemblerPackage.Literals.BSZ_DIRECTIVE__OPERAND;
		if (bszDirective.getOperand() != null && bszDirective.getOperand().getOperand() != null) {
			EObject operand = bszDirective.getOperand().getOperand();
			return resolveExpression((Expression)operand);
		} else {
			return 0;
		}
	}

	/** 
	 *  Parse the operand of an SETDP directive.
	 *  
	 *  @param directive reference on the SETDP directive
	 *  @return value of the operand 
	 */
	public static int parse(SetDPDirective directive) {
		assemblyLine = directive;
		eReference = AssemblerPackage.Literals.SET_DP_DIRECTIVE__OPERAND;
		if (directive.getOperand() != null && directive.getOperand().getOperand() != null) {
			EObject operand = directive.getOperand().getOperand();
			return resolveExpression((Expression)operand);
		} else {
			return 0;
		}
	}

	/** 
	 *  Parse the space count value of an SPC directive.
	 *  
	 *  @param spcDirective reference on the SPC directive
	 *  @return value of the operand 
	 */
	public static int getSpaceCount(SpcDirective spcDirective) {
		assemblyLine = spcDirective;
		eReference = AssemblerPackage.Literals.SPC_DIRECTIVE__SPACE_COUNT;
		Expression spaceCount = spcDirective.getSpaceCount();
		if (spaceCount != null) {
			return resolveExpression(spaceCount.getOperand());
		} else {
			return 1;
		}
	}

	/** 
	 *  Parse the keep count value of an SPC directive.
	 *  
	 *  @param spcDirective reference on the SPC directive
	 *  @return value of the operand 
	 */
	public static int getKeepCount(SpcDirective spcDirective) {
		assemblyLine = spcDirective;
		eReference = AssemblerPackage.Literals.SPC_DIRECTIVE__KEEP_COUNT;
		Expression keepCount = spcDirective.getKeepCount();
		if (keepCount != null) {
			return resolveExpression(keepCount.getOperand());
		} else {
			return 0;
		}
	}

	/**
	 * resolve an expression object 
	 * 
	 * @param expression reference on the expression
	 * @param directive reference on the directive for the error
	 * @param currentReference reference on the EMF reference for the error
	 * @return value of the expression
	 */
	public static int resolveExpression(Expression expression, FillDirective directive, EReference currentReference) {
		assemblyLine = directive;
		eReference = currentReference;
		return resolveExpression(expression);
	}
	
	/**
	 * resolve an expression object 
	 * 
	 * @param expression reference on the expression
	 * @return value of the expression
	 */
	private static int resolveExpression(Expression expression) {
		
		if (expression instanceof Multiplication) {
			Multiplication multiplication = (Multiplication)expression;
			return resolveExpression(multiplication);
			
		} else if (expression instanceof Division) {
			Division division = (Division)expression;
			return resolveExpression(division);
				
		} else if (expression instanceof Addition) { 	
			Addition addition = (Addition)expression;
			return resolveExpression(addition);
			
		} else if (expression instanceof Substraction) { 	
			Substraction substraction = (Substraction)expression;
			return resolveExpression(substraction);
			
		} else if (expression instanceof Modulo) { 	
			Modulo modulo = (Modulo)expression;
			return resolveExpression(modulo);
			
		} else if (expression instanceof And) { 	
			And and = (And)expression;
			return resolveExpression(and);
			
		} else if (expression instanceof Or) { 	
			Or or = (Or)expression;
			return resolveExpression(or);
			
		} else if (expression instanceof Xor) { 	
			Xor xor = (Xor)expression;
			return resolveExpression(xor);
			
		} else if (expression instanceof Not) { 	
			Not not = (Not)expression;
			return resolveExpression(not);
			
		} else if (expression instanceof LeftShift) { 	
			LeftShift leftshift = (LeftShift)expression;
			return resolveExpression(leftshift);
			
		} else if (expression instanceof RightShift) { 	
			RightShift rightShift = (RightShift)expression;
			return resolveExpression(rightShift);
			
		} else {
			if (expression.getValue() instanceof DecimalValue) {
				DecimalValue decimalValue = (DecimalValue)expression.getValue();
				return resolveDecimalValue(decimalValue);
			
			} else if( expression.getValue() instanceof HexaDecimalValue) {
				HexaDecimalValue hexaDecimalValue = (HexaDecimalValue)expression.getValue();
				return resolveHexadecimalValue(hexaDecimalValue);
			
			} else if( expression.getValue() instanceof BinaryValue) {
				BinaryValue binaryValue = (BinaryValue)expression.getValue();
				return resolveBinaryValue(binaryValue);

			} else if( expression.getValue() instanceof OctalValue) {
				OctalValue octalValue = (OctalValue)expression.getValue();
				return resolveOctalValue(octalValue);

			} else if( expression.getValue() instanceof IdentifierValue) {
				IdentifierValue identifierValue = (IdentifierValue)expression.getValue();
				return resolveIdentifierValue(identifierValue);

			} else if( expression.getValue() instanceof CharacterValue) {
				CharacterValue characterValue = (CharacterValue)expression.getValue();
				return resolveCharacterValue(characterValue);
			}
			
			logger.log(Level.SEVERE, "{0} isn''t managed in this version" ,expression.getValue().getClass().getSimpleName());
			return 0;
		}
	}

	public static int parse(NumericalValue deplacement) {
		EObject node = deplacement.getValue();
		if (node instanceof DecimalValue) {
			return resolveDecimalValue((DecimalValue)node);
		} else if (node instanceof HexaDecimalValue) {
			return resolveHexadecimalValue((HexaDecimalValue)node);
		} else if (node instanceof OctalValue) {
			return resolveOctalValue((OctalValue)node);
		} else if (node instanceof BinaryValue) {
			return resolveBinaryValue((BinaryValue)node);
		} else if (node instanceof CharacterValue) {
			return resolveCharacterValue((CharacterValue)node);
		} else if (node instanceof IdentifierValue) {
			return resolveIdentifierValue((IdentifierValue)node);
		}
		return 0;
	}
	
	private static int resolveDecimalValue(DecimalValue value) {
		int sign = 1;
		if (value.getSign()!=null && value.getSign().equals("-")) {
			sign = -1;
		}
		try {
			int intValue = Integer.parseInt(value.getValue());
			return intValue*sign;
		}	
		catch(NumberFormatException ex) {
			return 0;
		}
	}

	/**
	 * Convert an character value expression into a decimal value
	 * 
	 * @param value Character value to convert
	 * @return decimal value of the binary expression
	 */
	private static int resolveCharacterValue(CharacterValue value) {
		char strValue = value.getValue().replaceFirst("\\'", "").charAt(0);
		return strValue;
	}

	/**
	 * Convert an identifier value expression into a decimal value
	 * 
	 * @param value Identifier value to convert
	 * @return decimal value of the binary expression
	 */
	private static int resolveIdentifierValue(IdentifierValue labelValue) {
		Integer value = AssemblerEngine.getInstance().getEquSetLabelValue(labelValue.getValue());
		
		if (value != null) {
			return value.intValue();
		} else {
			
			if (labelsPosition != null) {
				AbstractAssemblyLine targetAssemblyLine = labelsPosition.get(labelValue.getValue());
				if (targetAssemblyLine == null) {
					AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
							"Can't find " + labelValue.getValue() + " definition", 
							eReference, 
							EXPRESSION_ERROR);
					AssemblerErrorManager.getInstance().addProblem(assemblyLine, errorDescription);
					
				} else {
					return targetAssemblyLine.getPcAddress();
				}
			} else {
				AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
						"Can't find " + labelValue.getValue() + " definition", 
						eReference, 
						EXPRESSION_ERROR);
				AssemblerErrorManager.getInstance().addProblem(assemblyLine, errorDescription);
			}
			
		}
		return 0;
	}

	/**
	 * Convert an octal value expression into a decimal value
	 * 
	 * @param value Octal value to convert
	 * @return decimal value of the binary expression
	 */
	private static int resolveOctalValue(OctalValue value) {
		String strValue = value.getValue().replaceFirst("\\@", "");
		try {
			return Integer.parseInt(strValue, 8);
		} catch (NumberFormatException ex) {
			logger.log(Level.SEVERE, ex.getMessage());
		}
 		return 0;
	}

	/**
	 * Convert an binary value expression into a decimal value
	 * 
	 * @param binaryValue binary value to convert
	 * @return decimal value of the binary expression
	 */
	private static int resolveBinaryValue(BinaryValue binaryValue) {
		String strValue = binaryValue.getValue().replaceFirst("%", "");
		try {
			return Integer.parseInt(strValue, 2);
		} catch (NumberFormatException ex) {
			logger.log(Level.SEVERE, ex.getMessage());
		}
 		return 0;
	}

	/**
	 * Convert an hexadecimal value expression into a decimal value
	 * 
	 * @param hexaDecimalValue Hexadecimal value to convert
	 * @return decimal value of the hexadecimal expression
	 */
	public static int resolveHexadecimalValue(HexaDecimalValue hexaDecimalValue) {
		String strValue = hexaDecimalValue.getValue().replaceFirst("\\$", "");
		try {
			return Integer.parseInt(strValue, 16);
		} catch (NumberFormatException ex) {
			logger.log(Level.SEVERE, ex.getMessage());
		}
 		return -1;
	}

	/**
	 * resolve an multiplication expression 
	 * 
	 * @param multiplication reference on the multiplication expression
	 * @return a decimal value of the multiplication
	 */
	public static int resolveExpression(Multiplication multiplication) {
		int left=1;
		int right=1;
		
		if (multiplication.getLeft() != null) {
			left = resolveExpression(multiplication.getLeft());
		}
		if (multiplication.getRight() != null) {
			right = resolveExpression(multiplication.getRight());
		}
		return left*right;
	}

	/**
	 * resolve an division expression 
	 * 
	 * @param division reference on the division expression
	 * @return a decimal value of the division
	 */
	public static int resolveExpression(Division division) {
		int left=1;
		int right=1;
		
		if (division.getLeft() != null) {
			left = resolveExpression(division.getLeft());
		}
		if (division.getRight() != null) {
			right = resolveExpression(division.getRight());
		}
		if (right == 0) {
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					"Division by 0 is not allow, the result of the expression will be false", 
					eReference, 
					EXPRESSION_ERROR);
			AssemblerErrorManager.getInstance().addProblem(assemblyLine, errorDescription);
			return 0;
		}
		return left/right;
	}

	/**
	 * resolve an addition expression
	 * 
	 * @param addition reference on the addition expression
	 * @return  a decimal value of the addition
	 */
	public static int resolveExpression(Addition addition) {
		int left=1;
		int right=1;
		
		if (addition.getLeft() != null) {
			left = resolveExpression(addition.getLeft());
		}
		if (addition.getRight() != null) {
			right = resolveExpression(addition.getRight());
		}
		return left+right;
	}

	/**
	 * resolve an subtraction expression
	 * 
	 * @param substraction reference on the addition expression
	 * @return  a decimal value of the addition
	 */
	public static int resolveExpression(Substraction substraction) {
		int left=0;
		int right=0;
		
		if (substraction.getLeft() != null) {
			left = resolveExpression(substraction.getLeft());
		}
		if (substraction.getRight() != null) {
			right = resolveExpression(substraction.getRight());
		}
		return left-right;
	}

	/**
	 * resolve an modulo expression
	 * 
	 * @param modulo reference on the addition expression
	 * @return  a decimal value of the addition
	 */
	public static int resolveExpression(Modulo modulo) {
		int left=0;
		int right=0;
		
		if (modulo.getLeft() != null) {
			left = resolveExpression(modulo.getLeft());
		}
		if (modulo.getRight() != null) {
			right = resolveExpression(modulo.getRight());
		}
		
		if (right == 0) {
			AssemblerErrorDescription errorDescription = new AssemblerErrorDescription(
					"Division by 0 is not allow, the result of the expression will be false", 
					eReference, 
					EXPRESSION_ERROR);
			AssemblerErrorManager.getInstance().addProblem(assemblyLine, errorDescription);
			return 0;
		}
		return left%right;
	}

	/**
	 * resolve an AND expression
	 * 
	 * @param and reference on the addition expression
	 * @return  a decimal value of the logical AND
	 */
	public static int resolveExpression(And and) {
		int left=0xFFFF;
		int right=0xFFFF;
		
		if (and.getLeft() != null) {
			left = resolveExpression(and.getLeft());
		}
		if (and.getRight() != null) {
			right = resolveExpression(and.getRight());
		}
		return left&right;
	}

	/**
	 * resolve an OR expression
	 * 
	 * @param or reference on the addition expression
	 * @return  a decimal value of the logical AND
	 */
	public static int resolveExpression(Or or) {
		int left=0;
		int right=0;
		
		if (or.getLeft() != null) {
			left = resolveExpression(or.getLeft());
		}
		if (or.getRight() != null) {
			right = resolveExpression(or.getRight());
		}
		return left|right;
	}

	/**
	 * resolve an XOR expression
	 * 
	 * @param xor reference on the exclusive OR expression
	 * @return  a decimal value of the logical XOR
	 */
	public static int resolveExpression(Xor xor) {
		int left=0;
		int right=0;
		
		if (xor.getLeft() != null) {
			left = resolveExpression(xor.getLeft());
		}
		if (xor.getRight() != null) {
			right = resolveExpression(xor.getRight());
		}
		return left^right;
	}

	/**
	 * resolve an NOT expression
	 * 
	 * @param not reference on the exclusive NOT expression
	 * @return  a decimal value of the logical NOT
	 */
	public static int resolveExpression(Not not) {
		
		int notValue = 0;
		
		if (not.getValue() != null) {
			notValue = resolveExpression((Expression)not.getValue());
			notValue = ~notValue;
			notValue = notValue & 0xFFFF;
		}
		return notValue;
	}

	/**
	 * resolve a left shift expression
	 * 
	 * @param leftShift reference on the left shift expression
	 * @return  a decimal value of the logical left shift
	 */
	public static int resolveExpression(LeftShift leftShift) {
		int left=0;
		int right=1;
		
		if (leftShift.getLeft() != null) {
			left = resolveExpression(leftShift.getLeft());
		}
		if (leftShift.getRight() != null) {
			right = resolveExpression(leftShift.getRight());
		}
		return (left<<right)&0xFFFF;
	}

	/**
	 * resolve a right shift expression
	 * 
	 * @param leftShift reference on the left shift expression
	 * @return  a decimal value of the logical left shift
	 */
	public static int resolveExpression(RightShift rightShift) {
		int left=0;
		int right=1;
		
		if (rightShift.getLeft() != null) {
			left = resolveExpression(rightShift.getLeft());
		}
		if (rightShift.getRight() != null) {
			right = resolveExpression(rightShift.getRight());
		}
		return left>>right;
	}

}
