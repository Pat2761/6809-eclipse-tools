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
package org.bpy.electronics.mc6809.assembler.engine;

import java.util.ArrayList;
import java.util.List;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.BlankLine;
import org.bpy.electronics.mc6809.assembler.assembler.CommentLine;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledCommentLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledDirectiveLine;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerValidator;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerWarningDescription;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.Resource;

public class AssemblerEngine {
	
	private int currentPcValue;
	private int lineNumber;
	private List<AbstractAssemblyLine> assemblyLines;
	
	public AssemblerEngine() {
		lineNumber = 1;
		currentPcValue = -1;
		assemblyLines = new ArrayList<>();
	}
	
	public void engine(Model model) {
		AssemblerErrorManager.getInstance().clear();

		List<SourceLine> sourceLines = model.getSourceLines();
		for (SourceLine sourceLine : sourceLines) {
			if (sourceLine.getLineContent() instanceof BlankLine) {
				
			} else if (sourceLine.getLineContent() instanceof CommentLine) {
				parseCommentLine((CommentLine)sourceLine.getLineContent());
				
			} else if (sourceLine.getLineContent() instanceof DirectiveLine) {
				DirectiveLine directiveLine = (DirectiveLine) sourceLine.getLineContent();
				parseDirectiveLine(directiveLine);
			
			} else if (sourceLine.getLineContent() instanceof InstructionLine) {
				
			}
			lineNumber++;
		}
		
		IResource resource = (IResource) model.eResource();
		try {
			IMarker marker = resource.createMarker(IMarker.PROBLEM);
			marker.setAttribute(IMarker.PRIORITY, IMarker.PRIORITY_HIGH);
			marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);
			marker.setAttribute(IMarker.MESSAGE, "A que coucou");
			
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Diagnostician validator = Diagnostician.INSTANCE;
//		validator.
//		AssembledSourceValidator validator = injector.getInstance(AssembledSourceValidator.class);
		
	}

	private void parseCommentLine(CommentLine commentLine) {
		AssembledCommentLine assembledCommentLine = new AssembledCommentLine();
		assembledCommentLine.parse(commentLine, currentPcValue, lineNumber);
		assemblyLines.add(assembledCommentLine);
	}

	private void parseDirectiveLine(DirectiveLine directiveLine) {
		if (directiveLine.getDirective() instanceof OrgDirective) {
			parseOrgDirective((OrgDirective)directiveLine.getDirective());
		}
	}

	private void parseOrgDirective(OrgDirective directive) {
		int pcValue = ExpressionParser.parse(directive);
		currentPcValue = pcValue;
		AssembledDirectiveLine line = new AssembledDirectiveLine();
		line.parse(directive, currentPcValue, lineNumber);
		assemblyLines.add(line);

		AssemblerWarningDescription problemDescription = new AssemblerWarningDescription("Un message", AssemblerPackage.Literals.ORG_DIRECTIVE__OPERAND, AssemblerValidator.INVALID_FIGURE);
		AssemblerErrorManager.getInstance().addProblem(directive, problemDescription );
	}

	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder();
		for (AbstractAssemblyLine line : assemblyLines) {
			strBuilder.append(line.toString());
			strBuilder.append("\r\n");
		}
		return strBuilder.toString();
	}
	
}
