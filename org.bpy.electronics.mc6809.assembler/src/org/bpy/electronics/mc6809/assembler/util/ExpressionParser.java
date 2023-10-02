package org.bpy.electronics.mc6809.assembler.util;

import org.bpy.electronics.mc6809.assembler.assembler.Expression;

public class ExpressionParser {

	public static int resolveExpression(Expression expresion) {
		if (expresion.getAddition() != null) {
			return resolveAddition(expresion.getAddition());
		}
		
		return -1;
	}

	private static int resolveAddition(Expression addition) {
		return 0;
	}
}
