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

import org.bpy.electronics.mc6809.assembler.assembler.AbxInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AdcInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AddInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AdddInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AndCCInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AndInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AslInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.BitInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BlankLine;
import org.bpy.electronics.mc6809.assembler.assembler.BszDirective;
import org.bpy.electronics.mc6809.assembler.assembler.ClrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.CmpInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.ComInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.CommentLine;
import org.bpy.electronics.mc6809.assembler.assembler.CwaiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.DaaInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.DecInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.EndDirective;
import org.bpy.electronics.mc6809.assembler.assembler.EorInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.ExgInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.FcbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FccDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FdbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FillDirective;
import org.bpy.electronics.mc6809.assembler.assembler.IncInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.JmpInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.JsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LdInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LeaInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LslInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.MulInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.NamDirective;
import org.bpy.electronics.mc6809.assembler.assembler.NegInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.NopInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.OptDirective;
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;
import org.bpy.electronics.mc6809.assembler.assembler.PagDirective;
import org.bpy.electronics.mc6809.assembler.assembler.RegDirective;
import org.bpy.electronics.mc6809.assembler.assembler.RmbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SetDPDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SetDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.assembler.SpcDirective;
import org.bpy.electronics.mc6809.assembler.assembler.TfrInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.comment.AssembledBlankLine;
import org.bpy.electronics.mc6809.assembler.engine.data.comment.AssembledCommentLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledBszDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledEndDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledEquDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFcbDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFccDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFdbDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFillDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledNamDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledOptDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledOrgDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledPagDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledRegDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledRmbDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledSetDPDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledSetDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledSpcDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledABXInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledADCAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledADCBInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledADDAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledADDBInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledADDDInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledANDAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledANDBInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledANDCCInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledASLAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledASLBInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledASLInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledASRAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledASRBInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledASRInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledBITAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledBITBInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCLRAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCLRBInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCLRInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCMPAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCMPBInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCMPDInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCMPSInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCMPUInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCMPXInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCMPYInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCOMAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCOMBInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCOMInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledCWAIInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledDAAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledDECAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledDECBInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledDECInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledEORAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledEORBInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledEXGInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledINCAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledINCBInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledINCInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledJMPInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledJSRInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLDAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLDBInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLDDInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLDSInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLDUInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLDXInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLDYInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLEASInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLEAUInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLEAXInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLEAYInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLSLAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLSLBInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLSLInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLSRAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLSRBInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledLSRInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledMULInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledNEGAInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledNEGBInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledNEGInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledNOPInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AssembledTFRInstruction;
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
	/** Contains the collection of assembled line  */
	private Map<Object, AbstractAssemblyLine> assembledLinesMap;
	/** Contains the current DP Page */
	private int currentDPPage;
	
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
		currentDPPage = 0;
		
		assemblyLines = new ArrayList<>();
		AssemblerErrorManager.getInstance().clear();
		
		labelsPositionObject = new HashMap<>();
		labelsEquSet = new HashMap<>();
		assembledLinesMap = new HashMap<>();
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
				InstructionLine instructionLine = (InstructionLine) sourceLine.getLineContent();
				parseInstructionLine(instructionLine);
				
			} else {
				logger.log(Level.SEVERE,"Unknow directive {0}" + sourceLine.getLineContent().getClass().getSimpleName());
			}
			lineNumber++;
		}
	}
	
	/**
	 * Allow to parse an instruction line.
	 * 
	 * @param instructionLine reference on the instruction line
	 */
	private void parseInstructionLine(InstructionLine instructionLine) {
		if (instructionLine.getInstruction() instanceof AbxInstruction) {
			parse((AbxInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof AdcInstruction) {
			parse((AdcInstruction)instructionLine.getInstruction());
				
		} else if (instructionLine.getInstruction() instanceof AddInstruction) {
			parse((AddInstruction)instructionLine.getInstruction());
				
		} else if (instructionLine.getInstruction() instanceof AdddInstruction) {
			parse((AdddInstruction)instructionLine.getInstruction());
				
		} else if (instructionLine.getInstruction() instanceof AndInstruction) {
			parse((AndInstruction)instructionLine.getInstruction());
				
		} else if (instructionLine.getInstruction() instanceof AndCCInstruction) {
			parse((AndCCInstruction)instructionLine.getInstruction());
				
		} else if (instructionLine.getInstruction() instanceof AslInstruction) {
			parse((AslInstruction)instructionLine.getInstruction());
				
		} else if (instructionLine.getInstruction() instanceof AsrInstruction) {
			parse((AsrInstruction)instructionLine.getInstruction());
				
		} else if (instructionLine.getInstruction() instanceof BitInstruction) {
			parse((BitInstruction)instructionLine.getInstruction());
				
		} else if (instructionLine.getInstruction() instanceof ClrInstruction) {
			parse((ClrInstruction)instructionLine.getInstruction());
				
		} else if (instructionLine.getInstruction() instanceof CmpInstruction) {
			parse((CmpInstruction)instructionLine.getInstruction());
				
		} else if (instructionLine.getInstruction() instanceof ComInstruction) {
			parse((ComInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof CwaiInstruction) {
			parse((CwaiInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof DaaInstruction) {
			parse((DaaInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof DecInstruction) {
			parse((DecInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof EorInstruction) {
			parse((EorInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof ExgInstruction) {
			parse((ExgInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof IncInstruction) {
			parse((IncInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof JmpInstruction) {
			parse((JmpInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof JsrInstruction) {
			parse((JsrInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof LdInstruction) {
			parse((LdInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof LeaInstruction) {
			parse((LeaInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof LslInstruction) {
			parse((LslInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof LsrInstruction) {
			parse((LsrInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof MulInstruction) {
			parse((MulInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof NegInstruction) {
			parse((NegInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof NopInstruction) {
			parse((NopInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof TfrInstruction) {
			parse((TfrInstruction)instructionLine.getInstruction());
				
		} else {
			logger.log(Level.SEVERE,"Unknow instruction {0}" + instructionLine.getClass().getSimpleName());
		}
	}

	/**	
	 * Parse the TFR instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(TfrInstruction instruction) {
		AbstractAssemblyLine line=new AssembledTFRInstruction();
    	((AssembledTFRInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**	
	 * Parse the NEG instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(NegInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("NEGA".equals(instruction.getInstruction())) {
			line = new AssembledNEGAInstruction();
			((AssembledNEGAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("NEGB".equals(instruction.getInstruction())) {
			line = new AssembledNEGBInstruction();
			((AssembledNEGBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("NEG".equals(instruction.getInstruction())) {
			line = new AssembledNEGInstruction();
			((AssembledNEGInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			// not possible 
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**	
	 * Parse the MUL instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(MulInstruction instruction) {
		AbstractAssemblyLine line=new AssembledMULInstruction();
    	((AssembledMULInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**	
	 * Parse the LSR instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(LsrInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("LSRA".equals(instruction.getInstruction())) {
			line = new AssembledLSRAInstruction();
			((AssembledLSRAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("LSRB".equals(instruction.getInstruction())) {
			line = new AssembledLSRBInstruction();
			((AssembledLSRBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("LSR".equals(instruction.getInstruction())) {
			line = new AssembledLSRInstruction();
			((AssembledLSRInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			// not possible 
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**	
	 * Parse the LSL instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(LslInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("LSLA".equals(instruction.getInstruction())) {
			line = new AssembledLSLAInstruction();
			((AssembledLSLAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("LSLB".equals(instruction.getInstruction())) {
			line = new AssembledLSLBInstruction();
			((AssembledLSLBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("LSL".equals(instruction.getInstruction())) {
			line = new AssembledLSLInstruction();
			((AssembledLSLInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			// not possible 
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**	
	 * Parse the LEA instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(LeaInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("LEAS".equals(instruction.getInstruction())) {
			line = new AssembledLEASInstruction();
			((AssembledLEASInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("LEAU".equals(instruction.getInstruction())) {
			line = new AssembledLEAUInstruction();
			((AssembledLEAUInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("LEAX".equals(instruction.getInstruction())) {
			line = new AssembledLEAXInstruction();
			((AssembledLEAXInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("LEAY".equals(instruction.getInstruction())) {
			line = new AssembledLEAYInstruction();
			((AssembledLEAYInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			// not possible 
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	private void parse(LdInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("LDA".equals(instruction.getInstruction())) {
			line = new AssembledLDAInstruction();
			((AssembledLDAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("LDB".equals(instruction.getInstruction())) {
			line = new AssembledLDBInstruction();
			((AssembledLDBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("LDD".equals(instruction.getInstruction())) {
			line = new AssembledLDDInstruction();
			((AssembledLDDInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("LDS".equals(instruction.getInstruction())) {
			line = new AssembledLDSInstruction();
			((AssembledLDSInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("LDU".equals(instruction.getInstruction())) {
			line = new AssembledLDUInstruction();
			((AssembledLDUInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("LDX".equals(instruction.getInstruction())) {
			line = new AssembledLDXInstruction();
			((AssembledLDXInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("LDY".equals(instruction.getInstruction())) {
			line = new AssembledLDYInstruction();
			((AssembledLDYInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
//			line = new AssembledINCInstruction();
//			((AssembledINCInstruction) line).parse(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**	
	 * Parse the JSR instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(JsrInstruction instruction) {
		AbstractAssemblyLine line=new AssembledJSRInstruction();
    	((AssembledJSRInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**	
	 * Parse the JMP instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(JmpInstruction instruction) {
		AbstractAssemblyLine line=new AssembledJMPInstruction();
    	((AssembledJMPInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**	
	 * Parse the INC instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(IncInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("INCA".equals(instruction.getInstruction())) {
			line = new AssembledINCAInstruction();
			((AssembledINCAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("INCB".equals(instruction.getInstruction())) {
			line = new AssembledINCBInstruction();
			((AssembledINCBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			line = new AssembledINCInstruction();
			((AssembledINCInstruction) line).parse(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**	
	 * Parse the EXG instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(ExgInstruction instruction) {
		AbstractAssemblyLine line=new AssembledEXGInstruction();
    	((AssembledEXGInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**	
	 * Parse the EORA and EORB instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(EorInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("EORA".equals(instruction.getInstruction())) {
			line = new AssembledEORAInstruction();
			((AssembledEORAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("EORB".equals(instruction.getInstruction())) {
			line = new AssembledEORBInstruction();
			((AssembledEORBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**
	 * Parse the DECA, DECB and DEC instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(DecInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("DECA".equals(instruction.getInstruction())) {
			line = new AssembledDECAInstruction();
			((AssembledDECAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("DECB".equals(instruction.getInstruction())) {
			line = new AssembledDECBInstruction();
			((AssembledDECBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			line = new AssembledDECInstruction();
			((AssembledDECInstruction) line).parse(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	private void parse(DaaInstruction instruction) {
		AbstractAssemblyLine line = new AssembledDAAInstruction();
		((AssembledDAAInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**
	 * Parse the CWAI instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(CwaiInstruction instruction) {
		AbstractAssemblyLine line = new AssembledCWAIInstruction();
		((AssembledCWAIInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**
	 * Parse the COMA, COMB and COM instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(ComInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("COMA".equals(instruction.getInstruction())) {
			line = new AssembledCOMAInstruction();
			((AssembledCOMAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("COMB".equals(instruction.getInstruction())) {
			line = new AssembledCOMBInstruction();
			((AssembledCOMBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			line = new AssembledCOMInstruction();
			((AssembledCOMInstruction) line).parse(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**
	 * Parse the CMPA, CMPB, CMPD, CMPU, CMPS, CMPX and CMPY instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(CmpInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("CMPA".equals(instruction.getInstruction())) {
			line = new AssembledCMPAInstruction();
			((AssembledCMPAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("CMPB".equals(instruction.getInstruction())) {
			line = new AssembledCMPBInstruction();
			((AssembledCMPBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("CMPD".equals(instruction.getInstruction())) {
			line = new AssembledCMPDInstruction();
			((AssembledCMPDInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("CMPS".equals(instruction.getInstruction())) {
			line = new AssembledCMPSInstruction();
			((AssembledCMPSInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("CMPU".equals(instruction.getInstruction())) {
			line = new AssembledCMPUInstruction();
			((AssembledCMPUInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("CMPX".equals(instruction.getInstruction())) {
			line = new AssembledCMPXInstruction();
			((AssembledCMPXInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("CMPY".equals(instruction.getInstruction())) {
			line = new AssembledCMPYInstruction();
			((AssembledCMPYInstruction) line).parse(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**
	 * Parse the CLRA, CLRB and CLR instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(ClrInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("CLRA".equals(instruction.getInstruction())) {
			line = new AssembledCLRAInstruction();
			((AssembledCLRAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("CLRB".equals(instruction.getInstruction())) {
			line = new AssembledCLRBInstruction();
			((AssembledCLRBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			line = new AssembledCLRInstruction();
			((AssembledCLRInstruction) line).parse(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**
	 * Parse the BITA and BITB instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(BitInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BITA".equals(instruction.getInstruction())) {
			line = new AssembledBITAInstruction();
			((AssembledBITAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("BITB".equals(instruction.getInstruction())) {
			line = new AssembledBITBInstruction();
			((AssembledBITBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**
	 * Parse the ASRA, ASRB and ASR instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(AsrInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("ASRA".equals(instruction.getInstruction())) {
			line = new AssembledASRAInstruction();
			((AssembledASRAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("ASRB".equals(instruction.getInstruction())) {
			line = new AssembledASRBInstruction();
			((AssembledASRBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			line = new AssembledASRInstruction();
			((AssembledASRInstruction) line).parse(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**
	 * Parse the ASLA, ASLB and ASL instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(AslInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("ASLA".equals(instruction.getInstruction())) {
			line = new AssembledASLAInstruction();
			((AssembledASLAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("ASLB".equals(instruction.getInstruction())) {
			line = new AssembledASLBInstruction();
			((AssembledASLBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			line = new AssembledASLInstruction();
			((AssembledASLInstruction) line).parse(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**
	 * Parse the ANDA and ANDB instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(AndCCInstruction instruction) {
		AbstractAssemblyLine line = new AssembledANDCCInstruction();
		((AssembledANDCCInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**
	 * Parse the ANDA and ANDB instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(AndInstruction instruction) {
		AbstractAssemblyLine line;

		if ("ANDA".equals(instruction.getInstruction())) {
			line = new AssembledANDAInstruction();
			((AssembledANDAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("ANDB".equals(instruction.getInstruction())) {
			line = new AssembledANDBInstruction();
			((AssembledANDBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			line = null;
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	private void parse(AdddInstruction instruction) {

		AbstractAssemblyLine line = new AssembledADDDInstruction();
		((AssembledADDDInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	private void parse(AddInstruction instruction) {
		AbstractAssemblyLine line;

		if ("ADDA".equals(instruction.getInstruction())) {
			line = new AssembledADDAInstruction();
			((AssembledADDAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("ADDB".equals(instruction.getInstruction())) {
			line = new AssembledADDBInstruction();
			((AssembledADDBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			line = null;
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	private void parse(NopInstruction instruction) {
		AssembledNOPInstruction line = new AssembledNOPInstruction();
		line.parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
}

	/**
	 * Parse an ADC directive line.
	 *  
	 * @param instruction reference on the ABX instruction
	 */
	private void parse(AdcInstruction instruction) {
		AbstractAssemblyLine line;

		if ("ADCA".equals(instruction.getInstruction())) {
			line = new AssembledADCAInstruction();
			((AssembledADCAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("ADCB".equals(instruction.getInstruction())) {
			line = new AssembledADCBInstruction();
			((AssembledADCBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			line = null;
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
	}

	/**
	 * Parse an ABX directive line.
	 *  
	 * @param instruction reference on the ABX instruction
	 */
	private void parse(AbxInstruction instruction) {
		AssembledABXInstruction line = new AssembledABXInstruction();
		line.parse(instruction, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += line.getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__NAME);
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
		assembledLinesMap.put(blankLine, line);
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
		assembledLinesMap.put(commentLine, assembledCommentLine);
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

		} else if (directiveLine.getDirective() instanceof FdbDirective) {
			FdbDirective fdbDirective = (FdbDirective)directiveLine.getDirective();
			parseDirective(fdbDirective);

		} else if (directiveLine.getDirective() instanceof FccDirective) {
			FccDirective fccDirective = (FccDirective)directiveLine.getDirective();
			parseDirective(fccDirective);

		} else if (directiveLine.getDirective() instanceof RmbDirective) {
			RmbDirective rmbDirective = (RmbDirective)directiveLine.getDirective();
			parseDirective(rmbDirective);

		} else if (directiveLine.getDirective() instanceof SetDPDirective) {
			SetDPDirective setdpDirective = (SetDPDirective)directiveLine.getDirective();
			parseDirective(setdpDirective);

		} else {
			logger.log(Level.SEVERE,"Unknow directive {0}", directiveLine.getDirective().getClass().getSimpleName());
		}
		
		return needStop;
	}

	/**
	 * Parse an SETDP directive line.
	 *  
	 * @param setdpDirective reference on the SETDP directive
	 */
	private void parseDirective(SetDPDirective setdpDirective) {
		AssembledSetDPDirectiveLine line = new AssembledSetDPDirectiveLine();
		line.parse(setdpDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(setdpDirective, line);
		currentPcValue += line.getPcIncrement();
		
		currentDPPage = line.getValue();
		
		registerLabelPosition(line, 
				line.getDirective().eContainer(),
				AssemblerPackage.Literals.DIRECTIVE_LINE__NAME);
	}

	/**
	 * Parse an RMB directive line.
	 *  
	 * @param rmbDirective reference on the RMB directive
	 */
	private void parseDirective(RmbDirective rmbDirective) {
		AssembledRmbDirectiveLine line = new AssembledRmbDirectiveLine();
		line.parse(rmbDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(rmbDirective, line);
		currentPcValue += line.getPcIncrement();
		
		registerLabelPosition(line, 
				line.getDirective().eContainer(),
				AssemblerPackage.Literals.DIRECTIVE_LINE__NAME);
	}

	/**
	 * Parse an FCC directive line.
	 *  
	 * @param fccDirective reference on the FCC directive
	 */
	private void parseDirective(FccDirective fccDirective) {
		AssembledFccDirectiveLine line = new AssembledFccDirectiveLine();
		line.parse(fccDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(fccDirective, line);
		currentPcValue += line.getPcIncrement();
		
		registerLabelPosition(line, 
				line.getDirective().eContainer(),
				AssemblerPackage.Literals.DIRECTIVE_LINE__NAME);
	}

	/**
	 * Parse an FDB directive line.
	 *  
	 * @param fdbDirective reference on the FDB directive
	 */
	private void parseDirective(FdbDirective fdbDirective) {
		AssembledFdbDirectiveLine line = new AssembledFdbDirectiveLine();
		line.parse(fdbDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(fdbDirective, line);
		currentPcValue += line.getPcIncrement();
		
		registerLabelPosition(line, 
				line.getDirective().eContainer(),
				AssemblerPackage.Literals.DIRECTIVE_LINE__NAME);
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
		assembledLinesMap.put(fcbDirective, line);
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
		assembledLinesMap.put(regDirective, line);
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
		assembledLinesMap.put(spcDirective, line);
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
		assembledLinesMap.put(namDirective, line);
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
		assembledLinesMap.put(pagDirective, line);
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
		assembledLinesMap.put(optDirective, line);
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
		assembledLinesMap.put(fillDirective, line);
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
		assembledLinesMap.put(endDirective, line);

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
		assembledLinesMap.put(bszDirective, line);
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
		assembledLinesMap.put(setDirective, line);
		
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
		assembledLinesMap.put(equDirective, line);
		
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
		assembledLinesMap.put(directive, line);

		registerLabelPosition(line, 
				line.getDirective().eContainer(),
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
	 * Get the assembly line corresponding to the assembly line
	 * 
	 * @param objectLine Assembly line reference
	 * @return Reference on the assembled line, <b>null</b> if not found
	 */
	public AbstractAssemblyLine getAssemblyLine(Object objectLine) {
		return assembledLinesMap.get(objectLine);
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
			return null;
		}
	}

	public int getCurrentDPPage() {
		return currentDPPage;
	}

}
