package org.bpy.electronics.mc6809.assembler.util;

import org.bpy.electronics.mc6809.assembler.assembler.Addition;
import org.bpy.electronics.mc6809.assembler.assembler.DecimalValue;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Expression;
import org.bpy.electronics.mc6809.assembler.assembler.Multiplication;
import org.eclipse.emf.ecore.EObject;

public class ExpressionParser {

	public static int parse(EquDirective equDirective) {
		if (equDirective.getOperand() != null && equDirective.getOperand().getOperand() != null) {
			EObject operand = equDirective.getOperand().getOperand();
			return resolveExpression((Expression)operand);
		} else {
			return -1;
		}
	}
	
	public static int resolveExpression(Expression expression) {
		if (expression instanceof Multiplication) {
			return resolveExpression((Multiplication)expression);
			
		} else if (expression instanceof Addition) { 	
			return resolveExpression((Addition)expression);
			
		} else {
			if (expression.getValue() instanceof DecimalValue) {
				return ((DecimalValue)expression.getValue()).getValue();
			}
			System.out.println(expression.getClass().getSimpleName());
			return -1;
		}
	}
	
	public static int resolveExpression(Multiplication multiplication) {
		int left=1;
		int right=1;
		
		if (multiplication.getLeft() != null) {
			left = resolveExpression((Expression)multiplication.getLeft());
		}
		if (multiplication.getRight() != null) {
			right = resolveExpression((Expression)multiplication.getRight());
		}
		return left*right;
	}

	public static int resolveExpression(Addition addition) {
		int left=1;
		int right=1;
		
		if (addition.getLeft() != null) {
			left = resolveExpression((Expression)addition.getLeft());
		}
		if (addition.getRight() != null) {
			right = resolveExpression((Expression)addition.getRight());
		}
		return left+right;
	}
}
