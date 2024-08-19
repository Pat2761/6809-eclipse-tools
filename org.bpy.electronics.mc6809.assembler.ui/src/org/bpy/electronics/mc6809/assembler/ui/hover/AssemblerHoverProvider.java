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
package org.bpy.electronics.mc6809.assembler.ui.hover;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.Expression;
import org.bpy.electronics.mc6809.assembler.assembler.IdentifierValue;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.JmpInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.JsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.RelativeMode;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.exception.UnresolvedException;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

import org.bpy.electronics.mc6809.help.Activator;

/**
 * Class which supply information when the mouse is hover a line of code.
 * 
 * @author Patrick BRIAND
 *
 */
public class AssemblerHoverProvider extends DefaultEObjectHoverProvider {

	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(AssemblerHoverProvider.class.getSimpleName());

	@Override
	protected String getHoverInfoAsHtml(EObject o) {
		return getString(o);
	}

	/** 
	 * Get HTML string depending of the context.
	 * 
	 * @param o reference on the pointed object
	 * 
	 * @return a string which describe the element
	 */
	private String getString(EObject o) {

		if (o.eContainer() instanceof InstructionLine) {
			return getInstructionLineInformation(o);
		} else if (o.eContainer() instanceof DirectiveLine) {
			return getDirectiveLineInformation(o);
		} else if (o.eContainer() instanceof  Expression expression) {
			return getExpressionInformation(expression);
		} else if (o.eContainer() instanceof  RelativeMode relativeMode) {
			return getRelativeModeInformation(relativeMode);
		}
		return o.eContainer().getClass().getSimpleName();
	}

	/**
	 * Create a string for operand of type relative (Branch).
	 * 
	 * @param relativeMode reference on the operand 
	 * 
	 * @return a string for operand of type relative
	 */
	private String getRelativeModeInformation(RelativeMode relativeMode) {
		StringBuilder builder = new StringBuilder();
		builder.append("<b>Relative mode</b><br>\n");
		
		IdentifierValue identifierValue = relativeMode.getOffset();
		AbstractAssemblyLine targetLine = AssemblerEngine.getInstance().getLabelsPositionObject().get(identifierValue.getValue());
		if (targetLine != null) {
			builder.append("Branch to the address " + String.format("0x%04X <br>\n", targetLine.getPcAddress()));
		} else {
			builder.append("Label "  + identifierValue.getValue() + " isn't defined");
		}
		
		return builder.toString();
	}

	/**
	 * Return a string which describe the result of an expression.
	 * 
	 * @param expression reference on the expression
	 * 
	 * @return a string which describe the result of an expression
	 */
	private String getExpressionInformation(Expression expression) {
		StringBuilder builder = new StringBuilder();
		builder.append("<b>Expression</b><br>\n");
		try {
			int value = ExpressionParser.resolveExpression(expression);
			if (isContainedBy(expression, JsrInstruction.class)) {
				builder.append("Call sub routine at address = " + value);
			} else if (isContainedBy(expression, JmpInstruction.class)) {
				builder.append("Jump to address = " + value);
			} else {
				builder.append("The value of the expression = " + value);
			}
			builder.append(String.format(" (%Xh)<br>\n", value));
		} catch (UnresolvedException e) {
			builder.append("<b>ERROR DETECTED</b> ");
			builder.append(e.getMessage());
		}
		return builder.toString();
	}

	/**
	 * Check type of parent
	 * 
	 * @param eObject reference to the object to check
	 * @param fatherClass Type of parent
	 * 
	 * @return <b>true</b> if element is owned by the father class, <b>false</b> otherwise
	 */
	private boolean isContainedBy(EObject eObject, Class<?> fatherClass) {
		if (eObject == null) {
			return false;
		} else if (fatherClass.isInstance(eObject)) {
			return true;
		} else {
			return isContainedBy(eObject.eContainer(), fatherClass);
		}
	}

	/**
	 * Generate a string which describes a directive.
	 * 
	 * @param o reference on the directive
	 * 
	 * @return string which describes a directive
	 */
	private String getDirectiveLineInformation(EObject o) {
		try {
			Method intructionNameMethod = o.getClass().getMethod("getDirective");
			String instructionName = (String) intructionNameMethod.invoke(o);

			return readElementDescription(instructionName);
		} catch (NoSuchMethodException e1) {
			logger.log(Level.SEVERE, e1.getMessage());
		} catch (SecurityException e2) {
			logger.log(Level.SEVERE, e2.getMessage());
		} catch (IllegalAccessException e3) {
			logger.log(Level.SEVERE, e3.getMessage());
		} catch (IllegalArgumentException e4) {
			logger.log(Level.SEVERE, e4.getMessage());
		} catch (InvocationTargetException e5) {
			logger.log(Level.SEVERE, e5.getMessage());
		}
		return o.getClass().getName();
	}

	/**
	 * Generate a string which describes an instruction.
	 * 
	 * @param o reference on the instruction
	 * 
	 * @return string which describes an instruction
	 */
	private String getInstructionLineInformation(EObject o) {
		try {
			Method intructionNameMethod = o.getClass().getMethod("getInstruction");
			String instructionName = (String) intructionNameMethod.invoke(o);

			return readElementDescription(instructionName);
		} catch (NoSuchMethodException e1) {
			logger.log(Level.SEVERE, e1.getMessage());
		} catch (SecurityException e2) {
			logger.log(Level.SEVERE, e2.getMessage());
		} catch (IllegalAccessException e3) {
			logger.log(Level.SEVERE, e3.getMessage());
		} catch (IllegalArgumentException e4) {
			logger.log(Level.SEVERE, e4.getMessage());
		} catch (InvocationTargetException e5) {
			logger.log(Level.SEVERE, e5.getMessage());
		}
		return o.getClass().getName();
	}

	/**
	 * Read element description in the help plugin.
	 * 
	 * @param instructionName name of the element
	 * 
	 * @return  description of the element, <b>element name</b> if not found
	 */
	private String readElementDescription(String instructionName) {
		String htmlFileName = "/html/hover/en/html/" + instructionName + ".html";
		InputStream inputStream = Activator.class.getResourceAsStream(htmlFileName);
		if (inputStream != null) {
			try {
				return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
			} catch (IOException e) {
				return instructionName;
			}
		}
		return instructionName;
	}

}
