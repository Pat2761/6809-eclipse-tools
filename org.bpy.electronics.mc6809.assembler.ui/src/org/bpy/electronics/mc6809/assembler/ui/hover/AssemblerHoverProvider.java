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
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.Expression;
import org.bpy.electronics.mc6809.assembler.assembler.IdentifierValue;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.JmpInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.JsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.Label;
import org.bpy.electronics.mc6809.assembler.assembler.MacroDefinition;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.OtherKindOfInstructions;
import org.bpy.electronics.mc6809.assembler.assembler.RelativeMode;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerManager;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.exception.UnresolvedException;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;
import org.eclipse.xtext.xbase.lib.Extension;

import com.google.common.base.Strings;
import com.google.inject.Inject;

import org.bpy.electronics.mc6809.help.Activator;
import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.bpy.electronics.mc6809.preferences.core.data.MacroInstructionData;

/**
 * Class which supply information when the mouse is hover a line of code.
 * 
 * @author Patrick BRIAND
 *
 */
public class AssemblerHoverProvider extends DefaultEObjectHoverProvider {

	/** Column number for instruction */
	private static final int INSTRUCTION_POSITION = 12;
	/** Column number for operand */
	private static final int OPERAND_POSITION = 18;
	/** Column number for comment */
	private static final int COMMENT_POSITION = 40;
	
	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(AssemblerHoverProvider.class.getSimpleName());

	/** Reference on the assembler engine */
	private AssemblerEngine assemblerEngine;

	/** Reference on the XTEXT serializer */
	@Inject
	@Extension
	private ISerializer serializer;

	
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

		if (o instanceof Model model) {
			assemblerEngine = AssemblerManager.getInstance().getAssemblyModel(model);
		} else if (o.eContainer() instanceof InstructionLine) {
			return getInstructionLineInformation(o);
		} else if (o.eContainer() instanceof DirectiveLine) {
			return getDirectiveLineInformation(o);
		} else if (o.eContainer() instanceof  Expression expression) {
			return getExpressionInformation(expression);
		} else if (o.eContainer() instanceof  RelativeMode relativeMode) {
			return getRelativeModeInformation(relativeMode);
		} else if (o.eContainer() instanceof  Label label) {
			return getInformation(label);
		} else if (o.eContainer() instanceof OtherKindOfInstructions otherKindOfInstructions) {
			return getMacroDescription(otherKindOfInstructions); 
		}
		return o.eContainer().getClass().getSimpleName();
	}

	/**
	 * Provide information on a label.
	 * 
	 * @param label reference on the label
	 * @return String which describe the label value, <b>null</b> if cannot be resolved
	 */
	String getInformation(Label label) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append("<b>Label " + label.getName().getValue() + "</b><br>");
		
		assemblerEngine = AssemblerManager.getInstance().getAssemblyModel((Model)EcoreUtil.getRootContainer(label));
		Integer equValue = assemblerEngine.getEquSetLabelValue(label.getName().getValue());
		if (equValue != null) {
			strBuilder.append("Value = " + equValue);
			return strBuilder.toString();
		} 
		AbstractAssemblyLine assemblyLine = assemblerEngine.getLabelsPositionObject().get(label.getName().getValue());
		if (assemblyLine != null) {
			strBuilder.append("Address = " + String.format("%04X", assemblyLine.getPcAddress()));
			return strBuilder.toString();
		}
		return null;
	}

	/**
	 * Create description for the macro and macro instruction.
	 * 
	 * @param otherKindOfInstructions reference on the macro 
	 * @return HTML String to display
	 */
	private String getMacroDescription(OtherKindOfInstructions otherKindOfInstructions) {
		Map<String, MacroInstructionData> macros = PreferenceManager.getInstance().getMacroInstructionPreferences();

		if (macros.containsKey(otherKindOfInstructions.getName().getValue())) {
			return getMacroInstructionDescription(macros.get(otherKindOfInstructions.getName().getValue()));
		}
		
		assemblerEngine = AssemblerManager.getInstance().getAssemblyModel((Model)EcoreUtil.getRootContainer(otherKindOfInstructions));
		if (assemblerEngine.getMacroDefinitions().containsKey(otherKindOfInstructions.getName().getValue())) {
			return getMacroDescription(otherKindOfInstructions.getName().getValue());
		}
		
		return null;
	}

	/**
	 * Display a description of the macro instruction.
	 * 
	 * @param macroInstructionData reference on the macro instruction
	 * 
	 * @return HTML description of the macro instruction
	 */
	private String getMacroDescription(String name) {
		InputStream inputStream = Activator.class.getResourceAsStream("/html/hover/en/html/MacroInstructionTemplate.html");
		if (inputStream != null) {
			try {
				String htmlDescription = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
				htmlDescription = htmlDescription.replace("@@@TITLE@@@", name);
				htmlDescription = htmlDescription.replace("@@@DESCRIPTION@@@", "Macro defined in the assembly file");

				MacroDefinition macroDefinition = assemblerEngine.getMacroDefinitions().get(name);
				
				StringBuilder strBuilder = new StringBuilder("<pre>");
				for (InstructionLine line : macroDefinition.getInstructions()) {
					String strToDisplay = serializer.serialize(line);
					strToDisplay = formatInstructionLine(strToDisplay);
					strBuilder.append(strToDisplay + "\n");
				}
				strBuilder.append("</pre>");
				htmlDescription = htmlDescription.replace("@@@EquivalentInstruction@@@", strBuilder.toString() );
				return htmlDescription;
			} catch (IOException e) {
				return null;
			}
		}
		return null;
	}

	/**
	 * Format an instruction line 
	 * 
	 * @param strToDisplay String to display
	 * @return formatted string to display
	 */
	private String formatInstructionLine(String strToDisplay) {
		StringBuilder strBuilder = new StringBuilder();
		String[] parts = strToDisplay.split("\\s+");

		if (Character.isWhitespace(strToDisplay.charAt(0))) {
			strBuilder.append(Strings.repeat(" ", INSTRUCTION_POSITION));
		} else {
			strBuilder.append(parts[0]);
			int nbSpacesNeeded = ((INSTRUCTION_POSITION-parts[0].length())>0 ? INSTRUCTION_POSITION-parts[0].length() : 1) ;
			strBuilder.append(Strings.repeat(" ", nbSpacesNeeded));
		}
		strBuilder.append(parts[1]);
		int nbSpacesNeeded = (OPERAND_POSITION-strBuilder.length() > 0 ? OPERAND_POSITION-strBuilder.length() : 1);
		strBuilder.append(Strings.repeat(" ", nbSpacesNeeded));
		
		int nextPosition = 2;
		boolean commentDetected = false;
		while (nextPosition < parts.length) {

			if (commentDetected) {
				strBuilder.append(" " + parts[nextPosition]);
			} else if (parts[nextPosition].charAt(0) == ';') {
				// Next element is comment
				commentDetected = true;
				nbSpacesNeeded = (COMMENT_POSITION-strBuilder.length() > 0 ? COMMENT_POSITION-strBuilder.length() : 1);
				strBuilder.append(Strings.repeat(" ", nbSpacesNeeded));
				strBuilder.append(parts[nextPosition]);

			} else {
				strBuilder.append(parts[nextPosition]);
			}
			nextPosition++;
		}

 		return strBuilder.toString();
	}

	/**
	 * Display a description of the macro instruction.
	 * 
	 * @param macroInstructionData reference on the macro instruction
	 * 
	 * @return HTML description of the macro instruction
	 */
	private String getMacroInstructionDescription(MacroInstructionData macroInstructionData) {
		InputStream inputStream = Activator.class.getResourceAsStream("/html/hover/en/html/MacroInstructionTemplate.html");
		if (inputStream != null) {
			try {
				String htmlDescription = new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
				htmlDescription = htmlDescription.replace("@@@TITLE@@@", macroInstructionData.getMacroInstructionName());
				htmlDescription = htmlDescription.replace("@@@DESCRIPTION@@@", "Macro instruction defined in the preferences");
				String equivalentInstruction = macroInstructionData.getEquivalentInstructionName() + " " + macroInstructionData.getEquivalenoperand();
				htmlDescription = htmlDescription.replace("@@@EquivalentInstruction@@@", equivalentInstruction);
				return htmlDescription;
			} catch (IOException e) {
				return null;
			}
		}
		return null;
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
		AbstractAssemblyLine targetLine = assemblerEngine.getLabelsPositionObject().get(identifierValue.getValue());
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
			assemblerEngine = AssemblerManager.getInstance().getAssemblyModel((Model)EcoreUtil.getRootContainer(expression));

			int value = ExpressionParser.resolveExpression(assemblerEngine, expression);
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
