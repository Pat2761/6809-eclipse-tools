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
import org.bpy.electronics.mc6809.assembler.assembler.BinaryValue;
import org.bpy.electronics.mc6809.assembler.assembler.DecimalValue;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Expression;
import org.bpy.electronics.mc6809.assembler.assembler.HexaDecimalValue;
import org.bpy.electronics.mc6809.assembler.assembler.Multiplication;
import org.bpy.electronics.mc6809.assembler.assembler.OctalValue;
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
			
		} else {
			if (expression.getValue() instanceof DecimalValue) {
				return ((DecimalValue)expression.getValue()).getValue();
			
			} else if( expression.getValue() instanceof HexaDecimalValue) {
				return (resolveHexadecimalValue((HexaDecimalValue)expression.getValue()));
			
			} else if( expression.getValue() instanceof BinaryValue) {
				return (resolveBinaryValue((BinaryValue)expression.getValue()));

			} else if( expression.getValue() instanceof OctalValue) {
				return (resolveOctalValue((OctalValue)expression.getValue()));
			}
			
			logger.log(Level.SEVERE, "{0} isn''t managed in this version" ,expression.getValue().getClass().getSimpleName());
			return -1;
		}
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
		String strValue = binaryValue.getValue().replaceFirst("\\%", "");
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
}
