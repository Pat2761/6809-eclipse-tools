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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.BlankLine;
import org.bpy.electronics.mc6809.assembler.assembler.BszDirective;
import org.bpy.electronics.mc6809.assembler.assembler.CommentLine;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.EndDirective;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FcbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FillDirective;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.NamDirective;
import org.bpy.electronics.mc6809.assembler.assembler.OptDirective;
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;
import org.bpy.electronics.mc6809.assembler.assembler.PagDirective;
import org.bpy.electronics.mc6809.assembler.assembler.RegDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SetDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.assembler.SpcDirective;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledBlankLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledBszDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledCommentLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledEndDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledEquDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledFcbDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledFillDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledNamDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledOptDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledOrgDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledPagDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledRegDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledSetDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledSpcDirectiveLine;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorDescription;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerWarningDescription;
import org.eclipse.emf.ecore.EReference;

/**
 * This is the main class which allow to assemble the current resource and
 * validate some point of the assembly code
 * 
 * @author Patrick
 *
 */
public class AssemblerEngine {
	
	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(AssemblerEngine.class.getSimpleName());
	
	/** String marker for the error manager in case of duplicate label */
	public static final String DUPLICATE_LABEL = "duplicateLabel";
	
	/** State of the current PC */
	private int currentPcValue;
	/** memorize the current line number */ 
	private int lineNumber;
	private List<AbstractAssemblyLine> assemblyLines;
	private static AssemblerEngine eInstance;
	
	/** Contains the collection of label which reference assembly line */
	private Map<String, AbstractAssemblyLine> labelsPositionObject;
	/** Contains the collection of Labels which define values */
	private Map<String, AbstractAssemblyLine> labelsEquSet;
	
	/**
	 * Constructor of the class
	 */
	public AssemblerEngine() {
		clear();
	}

	/**
	 * Get instance on the engine
	 * @return instance of the engine
	 */
	public static AssemblerEngine getInstance() {
		if (eInstance == null) {
			eInstance = new AssemblerEngine();
		}
		return eInstance;
	}
	
	/**
	 * Clear fields before assembling
	 */
	public void clear() {
		lineNumber = 1;
		currentPcValue = 0;
		assemblyLines = new ArrayList<>();
		AssemblerErrorManager.getInstance().clear();
		
		labelsPositionObject = new HashMap<>();
		labelsEquSet = new HashMap<>();
		
	}

	/**
	 * Return the value of the current PC pointer
	 * @return value of the current PC pointer
	 */ 
	public int getCurrentPcValue() {
		return currentPcValue;
	}

	/**
	 * return the collection of label which reference assembly line
	 * @return collection of label which reference assembly line
	 */
	public Map<String, AbstractAssemblyLine> getLabelsPositionObject() {
		return labelsPositionObject;
	}

	/**
	 * return the collection of Labels which define values
	 * @return collection of Labels which define values
	 */
	public Map<String, AbstractAssemblyLine> getLabelsEquSet() {
		return labelsEquSet;
	}

	/**
	 * Entry point of the engine
	 * @param model reference on the EMF model of the AS9 file
	 */
	public void engine(Model model) {
		lineNumber = 1;
		currentPcValue = -1;
		assemblyLines = new ArrayList<>();

		AssemblerErrorManager.getInstance().clear();

		List<SourceLine> sourceLines = model.getSourceLines();
		for (SourceLine sourceLine : sourceLines) {
			if (sourceLine.getLineContent() instanceof BlankLine) {
				BlankLine blankLine = (BlankLine)sourceLine.getLineContent();
				parseBlankLine(blankLine);
				
			} else if (sourceLine.getLineContent() instanceof CommentLine) {
				CommentLine commentLine = (CommentLine)sourceLine.getLineContent(); 
				parseCommentLine(commentLine);
				
			} else if (sourceLine.getLineContent() instanceof DirectiveLine) {
				DirectiveLine directiveLine = (DirectiveLine)sourceLine.getLineContent();
				boolean needStop = parseDirectiveLine(directiveLine);
				if (needStop) {
					break;
				}
			
			} else if (sourceLine.getLineContent() instanceof InstructionLine) {
				logger.log(Level.SEVERE,"Unknow directive {0}" + sourceLine.getLineContent().getClass().getSimpleName());
				
			} else {
				logger.log(Level.SEVERE,"Unknow directive {0}" + sourceLine.getLineContent().getClass().getSimpleName());
			}
			lineNumber++;
		}
	}
	
	/**
	 * Parse a blank line 
	 * 
	 * @param blankLine reference on the blank line
	 */
	private void parseBlankLine(BlankLine blankLine) {
		AssembledBlankLine line = new AssembledBlankLine();
		line.parse(blankLine, currentPcValue, lineNumber);
		assemblyLines.add(line);
	}

	/**
	 * Parse a comment line 
	 * 
	 * @param commentLine reference on the comment line
	 */
	private void parseCommentLine(CommentLine commentLine) {
		AssembledCommentLine assembledCommentLine = new AssembledCommentLine();
		assembledCommentLine.parse(commentLine, currentPcValue, lineNumber);
		assemblyLines.add(assembledCommentLine);
	}

	/**
	 * Parse a directive line
	 * 
	 * @param directiveLine reference on the directive line
	 * @return <b>true</b> stop the assembler,<b>false</b> otherwise continue 
	 */
	private boolean parseDirectiveLine(DirectiveLine directiveLine) {
		boolean needStop = false;
		
		if (directiveLine.getDirective() instanceof OrgDirective) {
			OrgDirective orgDirective = (OrgDirective)directiveLine.getDirective();
			parseDirective(orgDirective);
		
		} else if (directiveLine.getDirective() instanceof EquDirective) {
			EquDirective equDirective = (EquDirective)directiveLine.getDirective();
			parseDirective(equDirective);
		
		} else if (directiveLine.getDirective() instanceof SetDirective) {
			SetDirective setDirective = (SetDirective)directiveLine.getDirective();
			parseDirective(setDirective);
		
		} else if (directiveLine.getDirective() instanceof BszDirective) {
			BszDirective bszDirective = (BszDirective)directiveLine.getDirective();
			parseDirective(bszDirective);
		
		} else if (directiveLine.getDirective() instanceof EndDirective) {
			EndDirective endDirective = (EndDirective)directiveLine.getDirective();
			parseDirective(endDirective);
			needStop = true;
			
		} else if (directiveLine.getDirective() instanceof FillDirective) {
			FillDirective fillDirective = (FillDirective)directiveLine.getDirective();
			parseDirective(fillDirective);

		} else if (directiveLine.getDirective() instanceof OptDirective) {
			OptDirective optDirective = (OptDirective)directiveLine.getDirective();
			parseDirective(optDirective);

		} else if (directiveLine.getDirective() instanceof PagDirective) {
			PagDirective pagDirective = (PagDirective)directiveLine.getDirective();
			parseDirective(pagDirective);

		} else if (directiveLine.getDirective() instanceof NamDirective) {
			NamDirective namDirective = (NamDirective)directiveLine.getDirective();
			parseDirective(namDirective);

		} else if (directiveLine.getDirective() instanceof SpcDirective) {
			SpcDirective spcDirective = (SpcDirective)directiveLine.getDirective();
			parseDirective(spcDirective);

		} else if (directiveLine.getDirective() instanceof RegDirective) {
			RegDirective regDirective = (RegDirective)directiveLine.getDirective();
			parseDirective(regDirective);

		} else if (directiveLine.getDirective() instanceof FcbDirective) {
			FcbDirective fcbDirective = (FcbDirective)directiveLine.getDirective();
			parseDirective(fcbDirective);

		} else {
			logger.log(Level.SEVERE,"Unknow directive {0}", directiveLine.getDirective().getClass().getSimpleName());
		}
		
		return needStop;
	}

	/**
	 * Parse an FCB directive line.
	 *  
	 * @param fcbDirective reference on the FCB directive
	 */
	private void parseDirective(FcbDirective fcbDirective) {
		AssembledFcbDirectiveLine line = new AssembledFcbDirectiveLine();
		line.parse(fcbDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		currentPcValue += line.getPcIncrement();
		
		registerLabelPosition(line, 
				line.getDirective().eContainer(),
				AssemblerPackage.Literals.DIRECTIVE_LINE__NAME);
	}

	/**
	 * Parse an REG directive line.
	 *  
	 * @param regDirective reference on the REG directive
	 */
	private void parseDirective(RegDirective regDirective) {
		AssembledRegDirectiveLine line = new AssembledRegDirectiveLine();
		line.parse(regDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		currentPcValue += line.getPcIncrement();
		
		String label = line.getLabel();
		if (labelsEquSet.containsKey(label)) {
	
			AssemblerErrorDescription problemDescription = new AssemblerErrorDescription(
					"The label " + label + " for an REG directive is already defined", 
					AssemblerPackage.Literals.DIRECTIVE_LINE__NAME,
					DUPLICATE_LABEL);
			AssemblerErrorManager.getInstance().addProblem(line.getDirective().eContainer(), problemDescription );
		} else {
			labelsEquSet.put(label, line);
		}
	}

	/**
	 * Parse an SPC directive line.
	 *  
	 * @param spcDirective reference on the SPC directive
	 */
	private void parseDirective(SpcDirective spcDirective) {
		AssembledSpcDirectiveLine line = new AssembledSpcDirectiveLine();
		line.parse(spcDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		currentPcValue += line.getPcIncrement();
	}

	/**
	 * Parse an NAM directive line.
	 *  
	 * @param namDirective reference on the NAM directive
	 */
	private void parseDirective(NamDirective namDirective) {
		AssembledNamDirectiveLine line = new AssembledNamDirectiveLine();
		line.parse(namDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		currentPcValue += line.getPcIncrement();
	}

	/**
	 * Parse an PAG directive line.
	 *  
	 * @param pagDirective reference on the PAG directive
	 */
	private void parseDirective(PagDirective pagDirective) {
		AssembledPagDirectiveLine line = new AssembledPagDirectiveLine();
		line.parse(pagDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		currentPcValue += line.getPcIncrement();
	}

	/**
	 * Parse an Opt directive line.
	 *  
	 * @param optDirective reference on the OPT directive
	 */
	private void parseDirective(OptDirective optDirective) {
		AssembledOptDirectiveLine line = new AssembledOptDirectiveLine();
		line.parse(optDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		currentPcValue += line.getPcIncrement();
	}

	/**
	 * Parse an Fill directive line.
	 *  
	 * @param fillDirective reference on the FILL directive
	 */
	private void parseDirective(FillDirective fillDirective) {
		AssembledFillDirectiveLine line = new AssembledFillDirectiveLine();
		line.parse(fillDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		currentPcValue += line.getPcIncrement();
		
		registerLabelPosition(line, 
				line.getDirective().eContainer(),
				AssemblerPackage.Literals.DIRECTIVE_LINE__NAME);
	}

	/**
	 * Parse an End directive line.
	 *  
	 * @param endDirective reference on the END directive
	 */
	private void parseDirective(EndDirective endDirective) {
		AssembledEndDirectiveLine line = new AssembledEndDirectiveLine();
		line.parse(endDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);

		if (line.getTarget() == null) {
			line.setValue(0);
		} else {
			AbstractAssemblyLine referencedLine = labelsPositionObject.get(line.getTarget());
			if (referencedLine == null) {
	
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription(
						"The label " + line.getTarget() + " Can't be found", 
						AssemblerPackage.Literals.DIRECTIVE_LINE__NAME,
						DUPLICATE_LABEL);
				AssemblerErrorManager.getInstance().addProblem(line.getDirective().eContainer(), problemDescription );
				line.setValue(0);
			} else {
				line.setValue(referencedLine.getPcAddress());
			}
		}
	}

	/**
	 * Parse an BSZ directive line.
	 * Memorize the BSZ label 
	 *  
	 * @param bszDirective reference on the BSZ directive
	 */
	private void parseDirective(BszDirective bszDirective) {
		AssembledBszDirectiveLine line = new AssembledBszDirectiveLine();
		line.parse(bszDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		currentPcValue += line.getPcIncrement();
		
		registerLabelPosition(line, 
				bszDirective.eContainer(),
				AssemblerPackage.Literals.DIRECTIVE_LINE__NAME);
	}

	/**
	 * Parse an SET directive line.
	 * Memorize the SET label and check that it don't override EQU label 
	 *  
	 * @param setDirective reference on the SET directive
	 */
	private void parseDirective(SetDirective setDirective) {
		AssembledSetDirectiveLine line = new AssembledSetDirectiveLine();
		line.parse(setDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		
		String label = line.getLabel();
		if (labelsEquSet.containsKey(label)) {
			
			AbstractAssemblyLine element = labelsEquSet.get(label);
			if (element instanceof AssembledEquDirectiveLine) {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription(
						"The label " + label + " for an SET directive is already defined", 
						AssemblerPackage.Literals.DIRECTIVE_LINE__NAME,
						DUPLICATE_LABEL);
				AssemblerErrorManager.getInstance().addProblem(line.getDirective().eContainer(), problemDescription );
			} else {
				labelsEquSet.put(label, line);
			}
		} else {
			labelsEquSet.put(label, line);
		}
	}

	/**
	 * Parse an EQU directive line.
	 * Memorize the EQU label and check that there the label 
	 * isn't duplicate
	 * 
	 * @param equDirective reference on the EQU directive
	 */
	private void parseDirective(EquDirective equDirective) {
		AssembledEquDirectiveLine line = new AssembledEquDirectiveLine();
		line.parse(equDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		
		String label = line.getLabel();
		if (labelsEquSet.containsKey(label)) {
			
			AbstractAssemblyLine element = labelsEquSet.get(label);
			if (element instanceof AssembledSetDirectiveLine) {
				AssemblerWarningDescription warningDescription = new AssemblerWarningDescription(
						"The label " + label + " for an EQU directive is already defined by a SET directive", 
						AssemblerPackage.Literals.DIRECTIVE_LINE__NAME,
						DUPLICATE_LABEL);
				AssemblerErrorManager.getInstance().addWarning(line.getDirective().eContainer(), warningDescription);
	
				labelsEquSet.put(label, line);
				
			} else {
			
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription(
						"The label " + label + " for an EQU directive is already defined", 
						AssemblerPackage.Literals.DIRECTIVE_LINE__NAME,
						DUPLICATE_LABEL);
				AssemblerErrorManager.getInstance().addProblem(line.getDirective().eContainer(), problemDescription );
			}
		} else {
			labelsEquSet.put(label, line);
		}
	}

	/**
	 * Parse an ORG directive line.
	 * Memorize the ORG label and check that there the label 
	 * isn't duplicate
	 * 
	 * @param orgDirective reference on the ORG directive
	 */
	private void parseDirective(OrgDirective directive) {
		int pcValue = ExpressionParser.parse(directive);
		currentPcValue = pcValue;
		
		AssembledOrgDirectiveLine line = new AssembledOrgDirectiveLine();
		line.parse(directive, currentPcValue, lineNumber);
		assemblyLines.add(line);

		registerLabelPosition(line, 
				line.getDirective(),
				AssemblerPackage.Literals.DIRECTIVE_LINE__NAME);
	}

	/**
	 * Register the label position, and send an error if thelabel is duplicate
	 * @param directive reference on the directive
	 * @param objectWithProblem reference on EMF object which has the problem
	 * @param message Error message
	 * @param reference EMF reference of the object
	 */
	private void registerLabelPosition(AbstractAssemblyLine directive,Object objectWithProblem, EReference reference) {
		if (directive.getLabel() != null) {
			if (labelsPositionObject.containsKey(directive.getLabel())) {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + directive.getLabel() + " is already defined",
						reference,
						DUPLICATE_LABEL);
				AssemblerErrorManager.getInstance().addProblem(objectWithProblem, problemDescription );
			} else {
				labelsPositionObject.put(directive.getLabel(), directive);
			}
		}
	}

	/**
	 * Get an assembly line.
	 *  
	 * @param location number of line
	 * @return reference on the assembly line
	 */
	public AbstractAssemblyLine getAssembledLine(int location) {
	  return assemblyLines.get(location);
	}

	/**
	 * Get the value for a label 
	 * 
	 * @param value value of the label
	 * @return value pointed by the label
	 */
	public Integer getEquSetLabelValue(String value) {
		
		AbstractAssemblyLine assemblyLine = labelsEquSet.get(value);
		if (assemblyLine instanceof AssembledEquDirectiveLine) {
			AssembledEquDirectiveLine equDirectiveLine = (AssembledEquDirectiveLine)assemblyLine;
			return equDirectiveLine.getValue();
		
		} else if (assemblyLine instanceof AssembledSetDirectiveLine) {
			AssembledSetDirectiveLine setDirectiveLine = (AssembledSetDirectiveLine)assemblyLine;
			return setDirectiveLine.getValue();
		
		} else if (assemblyLine instanceof AssembledRegDirectiveLine) {
			AssembledRegDirectiveLine regDirectiveLine = (AssembledRegDirectiveLine)assemblyLine;
			return regDirectiveLine.getValue();
		
		} else {
			logger.log(Level.SEVERE,"getEquSetLabelValue:" + assemblyLine.getClass().getSimpleName());
			return null;
		}
	}
}
