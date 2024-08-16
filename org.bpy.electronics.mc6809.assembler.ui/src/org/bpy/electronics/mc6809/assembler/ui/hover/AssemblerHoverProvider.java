package org.bpy.electronics.mc6809.assembler.ui.hover;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ui.editor.hover.html.DefaultEObjectHoverProvider;

import org.bpy.electronics.mc6809.help.Activator;

public class AssemblerHoverProvider extends DefaultEObjectHoverProvider {

	private static final Logger logger = Logger.getLogger(AssemblerHoverProvider.class.getSimpleName());

	@Override
	protected String getHoverInfoAsHtml(EObject o) {
		return getString(o);
	}

	private String getString(EObject o) {

		if (o.eContainer() instanceof InstructionLine) {
			return getInstructionLineInformation(o);
		}
		return null;
	}

	private String getInstructionLineInformation(EObject o) {
		try {
			Method intructionNameMethod = o.getClass().getMethod("getInstruction");
			String instructionName = (String) intructionNameMethod.invoke(o);

			return readInstructionDescription(instructionName);
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

	private String readInstructionDescription(String instructionName) {
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
