/*
 * European Scoring Tool For Baseball
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

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.assembler.assembler.Addition;
import org.bpy.electronics.mc6809.assembler.assembler.And;
import org.bpy.electronics.mc6809.assembler.assembler.BinaryValue;
import org.bpy.electronics.mc6809.assembler.assembler.CharacterValue;
import org.bpy.electronics.mc6809.assembler.assembler.DecimalValue;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Expression;
import org.bpy.electronics.mc6809.assembler.assembler.HexaDecimalValue;
import org.bpy.electronics.mc6809.assembler.assembler.IdentifierValue;
import org.bpy.electronics.mc6809.assembler.assembler.LeftShift;
import org.bpy.electronics.mc6809.assembler.assembler.Modulo;
import org.bpy.electronics.mc6809.assembler.assembler.Multiplication;
import org.bpy.electronics.mc6809.assembler.assembler.Not;
import org.bpy.electronics.mc6809.assembler.assembler.OctalValue;
import org.bpy.electronics.mc6809.assembler.assembler.Or;
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;
import org.bpy.electronics.mc6809.assembler.assembler.RightShift;
import org.bpy.electronics.mc6809.assembler.assembler.Substraction;
import org.bpy.electronics.mc6809.assembler.assembler.Xor;
import org.eclipse.emf.ecore.EObject;

/**
 * This class allow to parse expression 
 * 
 * @author Patrick
 *
 */
public class ExpressionParser {
	
	/** Memorize the EQU values */
	private static Map<String, Integer> equValues; 
	
	/**
	 * Add a private constructor to hide the implicit public one.
	 */
	private ExpressionParser() {
		equValues = new HashMap<>();
	}

	/** Looger of the class */
	private static Logger logger = Logger.getLogger("ExpressionParser");

	/** 
	 *  Parse the operand of an EQU directive.
	 *  
	 *  @param equDirective reference on the EQU directive
	 *  @return value of the operand 
	 */
	public static int parse(EquDirective equDirective) {
		if (equDirective.getOperand() != null && equDirective.getOperand().getOperand() != null) {
			EObject operand = equDirective.getOperand().getOperand();
			int equValue = resolveExpression((Expression)operand);
			
			if (equValues == null) {
				equValues = new HashMap<>();
			}
			
			equValues.put(equDirective.getName().getValue(), equValue);
			return equValue;
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
		if (orgDirective.getOperand() != null && orgDirective.getOperand().getOperand() != null) {
			EObject operand = orgDirective.getOperand().getOperand();
			int equValue = resolveExpression((Expression)operand);
			
			return equValue;
		} else {
			return -1;
		}
	}
	
	/**
	 * resolve an expression object 
	 * 
	 * @param expression reference on the expression
	 * @return value of the expression
	 */
	public static int resolveExpression(Expression expression) {
		
		if (expression instanceof Multiplication) {
			return resolveExpression((Multiplication)expression);
			
		} else if (expression instanceof Addition) { 	
			return resolveExpression((Addition)expression);
			
		} else if (expression instanceof Substraction) { 	
			return resolveExpression((Substraction)expression);
			
		} else if (expression instanceof Modulo) { 	
			return resolveExpression((Modulo)expression);
			
		} else if (expression instanceof And) { 	
			return resolveExpression((And)expression);
			
		} else if (expression instanceof Or) { 	
			return resolveExpression((Or)expression);
			
		} else if (expression instanceof Xor) { 	
			return resolveExpression((Xor)expression);
			
		} else if (expression instanceof Not) { 	
			return resolveExpression((Not)expression);
			
		} else if (expression instanceof LeftShift) { 	
			return resolveExpression((LeftShift)expression);
			
		} else if (expression instanceof RightShift) { 	
			return resolveExpression((RightShift)expression);
			
		} else {
			if (expression.getValue() instanceof DecimalValue) {
				return (resolveDecimalValue((DecimalValue)expression.getValue()));
			
			} else if( expression.getValue() instanceof HexaDecimalValue) {
				return (resolveHexadecimalValue((HexaDecimalValue)expression.getValue()));
			
			} else if( expression.getValue() instanceof BinaryValue) {
				return (resolveBinaryValue((BinaryValue)expression.getValue()));

			} else if( expression.getValue() instanceof OctalValue) {
				return (resolveOctalValue((OctalValue)expression.getValue()));

			} else if( expression.getValue() instanceof IdentifierValue) {
				return (resolveIdentifierValue((IdentifierValue)expression.getValue()));

			} else if( expression.getValue() instanceof CharacterValue) {
				return (resolveCharacterValue((CharacterValue)expression.getValue()));
			}
			
			logger.log(Level.SEVERE, "{0} isn''t managed in this version" ,expression.getValue().getClass().getSimpleName());
			return -1;
		}
	}
	
	private static int resolveDecimalValue(DecimalValue value) {
		int sign = 1;
		if (value.isIsNegative()) {
			sign = -1;
		}
		return value.getValue()*sign;
	}

	/**
	 * Convert an character value expression into a decimal value
	 * 
	 * @param value Character value to convert
	 * @return decimal value of the binary expression
	 */
	private static int resolveCharacterValue(CharacterValue value) {
		char strValue = value.getValue().replaceFirst("\\'", "").charAt(0);
		return (int) strValue;
	}

	/**
	 * Convert an identifier value expression into a decimal value
	 * 
	 * @param value Identifier value to convert
	 * @return decimal value of the binary expression
	 */
	private static int resolveIdentifierValue(IdentifierValue value) {
		if (equValues.containsKey(value.getValue())) {
			return equValues.get(value.getValue());
		} else {
			logger.log(Level.SEVERE, "Can''t resolve {0} value", value.getValue());
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
 		return -1;
	}

	/**
	 * Convert an binary value expression into a decimal value
	 * 
	 * @param binaryValue binary value to convert
	 * @return decimal value of the binary expression
	 */
	private static int resolveBinaryValue(BinaryValue binaryValue) {
		String strValue = binaryValue.getValue().replaceFirst("0b", "");
		try {
			return Integer.parseInt(strValue, 2);
		} catch (NumberFormatException ex) {
			logger.log(Level.SEVERE, ex.getMessage());
		}
 		return -1;
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
		int r=0; 
		
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
