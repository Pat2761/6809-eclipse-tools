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
import org.bpy.electronics.mc6809.assembler.assembler.BccInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BcsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BeqInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BgeInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BgtInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BhiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BhsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BitInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BlankLine;
import org.bpy.electronics.mc6809.assembler.assembler.BleInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BloInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BlsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BltInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BmiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BneInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BplInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BraInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BrnInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BszDirective;
import org.bpy.electronics.mc6809.assembler.assembler.BvcInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.BvsInstruction;
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
import org.bpy.electronics.mc6809.assembler.assembler.FailDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FcbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FccDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FdbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FillDirective;
import org.bpy.electronics.mc6809.assembler.assembler.IncInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.JmpInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.JsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LabelLine;
import org.bpy.electronics.mc6809.assembler.assembler.LdInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LeaInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LslInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.LsrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.MacroDefinition;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.MulInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.NamDirective;
import org.bpy.electronics.mc6809.assembler.assembler.NegInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.NopInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.OptDirective;
import org.bpy.electronics.mc6809.assembler.assembler.OrCCInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.OrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;
import org.bpy.electronics.mc6809.assembler.assembler.OtherKindOfInstructions;
import org.bpy.electronics.mc6809.assembler.assembler.PagDirective;
import org.bpy.electronics.mc6809.assembler.assembler.PshsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.PshuInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.PulsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.PuluInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.RegDirective;
import org.bpy.electronics.mc6809.assembler.assembler.RmbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.RolInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.RorInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.RtiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.RtsInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.SbcInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.SetDPDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SetDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SexInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.assembler.SpcDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SpecialFunctions;
import org.bpy.electronics.mc6809.assembler.assembler.StInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.SubInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.SubdInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.Swi2Instruction;
import org.bpy.electronics.mc6809.assembler.assembler.Swi3Instruction;
import org.bpy.electronics.mc6809.assembler.assembler.SwiInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.SyncInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.TfrInstruction;
import org.bpy.electronics.mc6809.assembler.assembler.TstInstruction;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.comment.AssembledBlankLine;
import org.bpy.electronics.mc6809.assembler.engine.data.comment.AssembledCommentLine;
import org.bpy.electronics.mc6809.assembler.engine.data.comment.AssembledLabelLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledBszDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledEndDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledEquDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AssembledFailDirectiveLine;
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
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.*;
import org.bpy.electronics.mc6809.assembler.engine.data.others.MacroAssembledElement;
import org.bpy.electronics.mc6809.assembler.engine.data.others.MacroDeclarationElement;
import org.bpy.electronics.mc6809.assembler.engine.exception.UnresolvedException;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorDescription;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerWarningDescription;
import org.bpy.electronics.mc6809.assembler.validation.InstructionValidator;
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
	
	/** State of the current PC */
	private int currentPcValue;
	/** memorize the current line number */ 
	private int lineNumber;
	/** List assembled lines for the parsed file */
	private List<AbstractAssemblyLine> assemblyLines;
	
	/** reference to the equ set manager */ 
	private EquSetManager equSetManager;
	
	/** Lis of the missing labels */
	private List<String> missingLabels;
	/** Contains the collection of label which reference assembly line */
	private Map<String, AbstractAssemblyLine> labelsPositionObject;
	/** Contains the collection of macro definition */
	private Map<String, MacroDefinition> macroDefinitions;
	/** Contains the collection of assembled line  */
	private Map<Object, AbstractAssemblyLine> assembledLinesMap;
	/** Contains counter for macro calls  */
	private Map<String, Integer> macroCallsCounter;
	/** Contains the current DP Page */
	private int currentDPPage;
	

	/**
	 * Constructor of the class
	 */
	public AssemblerEngine() {
		clear();
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
		assembledLinesMap = new HashMap<>();
		macroDefinitions = new HashMap<>();
		macroCallsCounter =new HashMap<>();
		missingLabels = new ArrayList<>();
	}

	public List<AbstractAssemblyLine> getAssembledLine() {
		return assemblyLines;
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
	 * Entry point of the engine
	 * @param model reference on the EMF model of the AS9 file
	 */
	public void engine(Model model) {
		currentPcValue = 0;
		assemblyLines = new ArrayList<>();
		clear();

		AssemblerErrorManager.getInstance().clear();
		equSetManager = new EquSetManager(this);
		
		assembleParseEquSetDirectives(model);
		assemblePass1(model);
		assemblePass2(model);
	}
	
	private void assembleParseEquSetDirectives(Model model) {
		for (SourceLine sourceLine : model.getSourceLines()) {
			
			if (sourceLine.getLineContent() instanceof DirectiveLine directiveLine) {
				
				if (directiveLine.getDirective() instanceof EquDirective equDirective) {
					preParseDirective(equDirective);
				
				} else if (directiveLine.getDirective() instanceof SetDirective setDirective) {
					preParseDirective(setDirective);
				
				} else if (directiveLine.getDirective() instanceof RegDirective regDirective) {
					preParseDirective(regDirective);
				}
			}
		}
	}

	/**
	 * Parse an SET directive line.
	 * Memorize the SET label and check that it don't override EQU label 
	 *  
	 * @param setDirective reference on the SET directive
	 */
	private void preParseDirective(SetDirective setDirective) {
		equSetManager.addDirective(setDirective);
	}

	/**
	 * Parse an REG directive line.
	 *  
	 * @param regDirective reference on the REG directive
	 */
	private void preParseDirective(RegDirective regDirective) {
		equSetManager.addDirective(regDirective);
	}

	/**
	 * Parse an EQU directive line.
	 * Memorize the EQU label and check that there the label 
	 * isn't duplicate
	 * 
	 * @param equDirective reference on the EQU directive
	 */
	private void preParseDirective(EquDirective equDirective) {
		equSetManager.addDirective(equDirective);
	}

	private void assemblePass1(Model model) {
		lineNumber = 1;
		assemblePass1(model.getSourceLines());
	}	

	private void assemblePass1(List<SourceLine> sourceLines ) {	
		for (SourceLine sourceLine : sourceLines) {
			
			if (sourceLine.getLineContent() instanceof BlankLine blankLine) {
				parseBlankLine(blankLine);
				
			} else if (sourceLine.getLineContent() instanceof CommentLine commentLine) {
				parseCommentLine(commentLine);
				
			} else if (sourceLine.getLineContent() instanceof LabelLine labelLine) {
				parseLabelLine(labelLine);
				
			} else if (sourceLine.getLineContent() instanceof DirectiveLine directiveLine) {
				boolean needStop = parseDirectiveLine(directiveLine);
				if (needStop) {
					break;
				}
			} else if(sourceLine.getLineContent() instanceof SpecialFunctions specialFunctions) {
				parse(specialFunctions);
				
			} else if (sourceLine.getLineContent() instanceof InstructionLine instructionLine) {
				parseInstructionLinePass1(instructionLine);
				
			} else if (sourceLine.getLineContent() instanceof OtherKindOfInstructions otherInstruction) {
				parseOtherInstructionLinePass1(otherInstruction);
				
			} else {
				
				logger.log(Level.SEVERE,"Unknow directive {0}", sourceLine.getLineContent().getClass().getSimpleName());
			}
			lineNumber++;
		}
	}

	private void parseOtherInstructionLinePass1(OtherKindOfInstructions otherInstruction) {
		String instructionName = otherInstruction.getName().getValue();
		
		int callCounter = 1;
		if (macroCallsCounter.containsKey(instructionName)) {
			callCounter = macroCallsCounter.get(instructionName);
			callCounter++;
		} 
		macroCallsCounter.put(instructionName, callCounter);
		
		if (macroDefinitions.containsKey(instructionName)) {

			MacroDefinition macroDefinition = macroDefinitions.get(instructionName);

			MacroAssembledElement assembledMacro = new MacroAssembledElement(this);
			assembledMacro.parsePass1(macroDefinition, callCounter);
			assembledMacro.setPcAddress(currentPcValue);
			if (otherInstruction.getLabel().getName() != null) {
				assembledMacro.setLabel(otherInstruction.getLabel().getName().getValue());
			}
			assembledMacro.setComment(otherInstruction.getComment());
			assembledMacro.setLineNumber(lineNumber);
			
			for(int i=0; i< assembledMacro.getInstructionLines().size(); i++) {

				InstructionLine instruction = assembledMacro.getInstructionLines().get(i);
				parseInstructionLinePass1(instruction);
				int assembledInstructionPosition = assemblyLines.size();
				AbstractAssemblyLine assembledLine = assemblyLines.get(assembledInstructionPosition-1);
				
				assembledMacro.addAssembledInstruction(assembledLine);
				assemblyLines.remove(assembledInstructionPosition-1);
			}
			
			assemblyLines.add(assembledMacro);
			assembledLinesMap.put(otherInstruction, assembledMacro);
			
		} else {
			AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("The instruction " + instructionName + " is not recognized",
					AssemblerPackage.eINSTANCE.getOtherKindOfInstructions_Name(),
					InstructionValidator.UNRECOGNIZED_INSTRUCTION);
			AssemblerErrorManager.getInstance().addProblem(otherInstruction, problemDescription);
		}
	}

	/**
	 * Allow to parse and assemble specials funtions
	 * 
	 * @param specialFuntions
	 */
	private void parse(SpecialFunctions specialFuntions) {
		if (specialFuntions.getSpecialFuntion() instanceof MacroDefinition) {
			parse(specialFuntions.getSpecialFuntion());
		}else {
			logger.log(Level.SEVERE,"Unknow special function {0}", specialFuntions.getSpecialFuntion().getClass().getSimpleName());
		}
	}

	/**
	 * Allow to parse a macro definition
	 * 
	 * @param macroDefinition reference on the macro definition
	 */
	private void parse(MacroDefinition macroDefinition) {
		String macroName = macroDefinition.getName().getValue();
		if (macroDefinitions.containsKey(macroName)) {
			AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Macro " + macroName + " is already defined",
					AssemblerPackage.eINSTANCE.getMacroDefinition_Name(),
					InstructionValidator.DUPLICATE_MACRO);
			AssemblerErrorManager.getInstance().addProblem(macroDefinition, problemDescription);

		} else {
			if (macroDefinition.getInstructions().isEmpty()) {
				AssemblerWarningDescription problemDescription = new AssemblerWarningDescription("Macro " + macroName + " can't be empty",
						AssemblerPackage.eINSTANCE.getMacroDefinition_Name(),
						InstructionValidator.EMPTY_MACRO);
				AssemblerErrorManager.getInstance().addWarning(macroDefinition, problemDescription);
			}
			
			MacroDeclarationElement macroDeclarationElement = new MacroDeclarationElement(this);
			macroDeclarationElement.parsePass1(macroDefinition,currentPcValue,lineNumber);
			assemblyLines.add(macroDeclarationElement);
			macroDefinitions.put(macroName, macroDefinition);
		}
	}

	private void assemblePass2(Model model) {
		lineNumber = 1;

		for (AbstractAssemblyLine assemblyLine : assemblyLines)  {
			if (assemblyLine instanceof MacroAssembledElement macroAssembled) {
				for (AbstractAssemblyLine macroAssembledLine : macroAssembled.getAssemblyLines()) {
					macroAssembledLine.parsePass2();
				}
			} else {
				assemblyLine.parsePass2();
			}
		}
	}

	/**
	 * Allow to parse an instruction line.
	 * 
	 * @param instructionLine reference on the instruction line
	 */
	private void parseInstructionLinePass1(InstructionLine instructionLine) {
		if (instructionLine.getInstruction() instanceof AbxInstruction abxInstruction) {
			parse(abxInstruction);
			
		} else if (instructionLine.getInstruction() instanceof AdcInstruction adcInstruction) {
			parse(adcInstruction);
				
		} else if (instructionLine.getInstruction() instanceof AddInstruction addInstruction) {
			parse(addInstruction);
				
		} else if (instructionLine.getInstruction() instanceof AdddInstruction adddInstruction) {
			parse(adddInstruction);
				
		} else if (instructionLine.getInstruction() instanceof AndInstruction andInstruction) {
			parse(andInstruction);
				
		} else if (instructionLine.getInstruction() instanceof AndCCInstruction andccInstruction) {
			parse(andccInstruction);
				
		} else if (instructionLine.getInstruction() instanceof AslInstruction aslInstruction) {
			parse(aslInstruction);
				
		} else if (instructionLine.getInstruction() instanceof AsrInstruction asrInstruction) {
			parse(asrInstruction);
				
		} else if (instructionLine.getInstruction() instanceof BitInstruction bitInstruction) {
			parse(bitInstruction);
				
		} else if (instructionLine.getInstruction() instanceof ClrInstruction clrInstruction) {
			parse(clrInstruction);
				
		} else if (instructionLine.getInstruction() instanceof CmpInstruction cmpInstruction) {
			parse(cmpInstruction);
				
		} else if (instructionLine.getInstruction() instanceof ComInstruction comInstruction) {
			parse(comInstruction);
			
		} else if (instructionLine.getInstruction() instanceof CwaiInstruction cwaiInstruction) {
			parse(cwaiInstruction);
			
		} else if (instructionLine.getInstruction() instanceof DaaInstruction daaInstruction) {
			parse(daaInstruction);
			
		} else if (instructionLine.getInstruction() instanceof DecInstruction decInstruction) {
			parse(decInstruction);
			
		} else if (instructionLine.getInstruction() instanceof EorInstruction eorInstruction) {
			parse(eorInstruction);
			
		} else if (instructionLine.getInstruction() instanceof ExgInstruction exgInstruction) {
			parse(exgInstruction);
			
		} else if (instructionLine.getInstruction() instanceof IncInstruction incInstruction) {
			parse(incInstruction);
			
		} else if (instructionLine.getInstruction() instanceof JmpInstruction jmpInstruction) {
			parse(jmpInstruction);
			
		} else if (instructionLine.getInstruction() instanceof JsrInstruction jsrInstruction) {
			parse(jsrInstruction);
			
		} else if (instructionLine.getInstruction() instanceof LdInstruction ldInstruction) {
			parse(ldInstruction);
			
		} else if (instructionLine.getInstruction() instanceof LeaInstruction leaInstruction) {
			parse(leaInstruction);
			
		} else if (instructionLine.getInstruction() instanceof LslInstruction lslInstruction) {
			parse(lslInstruction);
			
		} else if (instructionLine.getInstruction() instanceof LsrInstruction lsrInstruction) {
			parse(lsrInstruction);
			
		} else if (instructionLine.getInstruction() instanceof MulInstruction mulInstruction) {
			parse(mulInstruction);
			
		} else if (instructionLine.getInstruction() instanceof NegInstruction negInstruction) {
			parse(negInstruction);
			
		} else if (instructionLine.getInstruction() instanceof NopInstruction nopInstruction) {
			parse(nopInstruction);
			
		} else if (instructionLine.getInstruction() instanceof OrInstruction orInstruction) {
			parse(orInstruction);
			
		} else if (instructionLine.getInstruction() instanceof OrCCInstruction orccInstruction) {
			parse(orccInstruction);
			
		} else if (instructionLine.getInstruction() instanceof PshsInstruction pshsInstruction) {
			parse(pshsInstruction);
			
		} else if (instructionLine.getInstruction() instanceof PshuInstruction pshuInstruction) {
			parse(pshuInstruction);
			
		} else if (instructionLine.getInstruction() instanceof PulsInstruction pulsInstruction) {
			parse(pulsInstruction);
			
		} else if (instructionLine.getInstruction() instanceof PuluInstruction puluInstruction) {
			parse(puluInstruction);
			
		} else if (instructionLine.getInstruction() instanceof RolInstruction rolInstruction) {
			parse(rolInstruction);
			
		} else if (instructionLine.getInstruction() instanceof RorInstruction rorInstruction) {
			parse(rorInstruction);
			
		} else if (instructionLine.getInstruction() instanceof RtiInstruction rtiInstruction) {
			parse(rtiInstruction);
			
		} else if (instructionLine.getInstruction() instanceof RtsInstruction rtsInstruction) {
			parse(rtsInstruction);
			
		} else if (instructionLine.getInstruction() instanceof SbcInstruction sbcInstruction) {
			parse(sbcInstruction);
			
		} else if (instructionLine.getInstruction() instanceof SexInstruction sexInstruction) {
			parse(sexInstruction);
			
		} else if (instructionLine.getInstruction() instanceof StInstruction stInstruction ) {
			parse(stInstruction);
			
		} else if (instructionLine.getInstruction() instanceof SubInstruction subInstruction) {
			parse(subInstruction);
			
		} else if (instructionLine.getInstruction() instanceof SubdInstruction subdInstruction) {
			parse(subdInstruction);
			
		} else if (instructionLine.getInstruction() instanceof SwiInstruction swiInstruction) {
			parse(swiInstruction);
			
		} else if (instructionLine.getInstruction() instanceof Swi2Instruction swi2Instruction) {
			parse(swi2Instruction);
			
		} else if (instructionLine.getInstruction() instanceof Swi3Instruction swi3Instruction) {
			parse(swi3Instruction);
			
		} else if (instructionLine.getInstruction() instanceof SyncInstruction syncInstruction) {
			parse(syncInstruction);
			
		} else if (instructionLine.getInstruction() instanceof TfrInstruction tfrInstruction) {
			parse(tfrInstruction);
				
		} else if (instructionLine.getInstruction() instanceof TstInstruction tstInstruction) {
			parse(tstInstruction);
				
		// Start branch instruction
		} else if (instructionLine.getInstruction() instanceof BccInstruction bccINstruction) {
			parsePass1(bccINstruction);
			
		} else if (instructionLine.getInstruction() instanceof BcsInstruction bcsInstruction) {
			parsePass1(bcsInstruction);
			
		} else if (instructionLine.getInstruction() instanceof BeqInstruction beqInstruction) {
			parsePass1(beqInstruction);
			
		} else if (instructionLine.getInstruction() instanceof BgeInstruction bgeInstruction) {
			parsePass1(bgeInstruction);
			
		} else if (instructionLine.getInstruction() instanceof BgtInstruction bgtInstruction) {
			parsePass1(bgtInstruction);
			
		} else if (instructionLine.getInstruction() instanceof BhiInstruction bhiInstruction) {
			parsePass1(bhiInstruction);
			
		} else if (instructionLine.getInstruction() instanceof BhsInstruction bhsInstruction) {
			parsePass1(bhsInstruction);
			
		} else if (instructionLine.getInstruction() instanceof BleInstruction bleInstruction) {
			parsePass1(bleInstruction);
			
		} else if (instructionLine.getInstruction() instanceof BloInstruction bloInstruction) {
			parsePass1(bloInstruction);
			
		} else if (instructionLine.getInstruction() instanceof BlsInstruction blsInstruction) {
			parsePass1(blsInstruction);
			
		} else if (instructionLine.getInstruction() instanceof BltInstruction bltInstruction) {
			parsePass1(bltInstruction);
			
		} else if (instructionLine.getInstruction() instanceof BmiInstruction bmiInstruction) {
			parsePass1(bmiInstruction);
			
		} else if (instructionLine.getInstruction() instanceof BneInstruction bneInstruction) {
			parsePass1(bneInstruction);
			
		} else if (instructionLine.getInstruction() instanceof BplInstruction bplInstruction) {
			parsePass1(bplInstruction);
			
		} else if (instructionLine.getInstruction() instanceof BraInstruction braInstruction) {
			parsePass1(braInstruction);
			
		} else if (instructionLine.getInstruction() instanceof BrnInstruction brnInstruction) {
			parsePass1(brnInstruction);
			
		} else if (instructionLine.getInstruction() instanceof BsrInstruction bsrInstruction) {
			parsePass1(bsrInstruction);
			
		} else if (instructionLine.getInstruction() instanceof BvcInstruction bvcInstruction) {
			parsePass1(bvcInstruction);
			
		} else if (instructionLine.getInstruction() instanceof BvsInstruction bvsInstruction) {
			parsePass1(bvsInstruction);
			
		} else {
			logger.log(Level.SEVERE,"Unknow instruction {0}" + instructionLine.getClass().getSimpleName());
		}
	}

	/**	
	 * Parse the BVS instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BvsInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BVS".equals(instruction.getInstruction())) {
			line = new AssembledBVSInstruction(this);
			((AssembledBVSInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBVS".equals(instruction.getInstruction())) {
			line = new AssembledLBVSInstruction(this);
			((AssembledLBVSInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		if (line != null) {
			registerLabelPosition(line, 
					instruction.eContainer(),
					AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}
	}

	/**	
	 * Parse the BVC instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BvcInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BVC".equals(instruction.getInstruction())) {
			line = new AssembledBVCInstruction(this);
			((AssembledBVCInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBVC".equals(instruction.getInstruction())) {
			line = new AssembledLBVCInstruction(this);
			((AssembledLBVCInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		if (line != null) {
			registerLabelPosition(line, 
					instruction.eContainer(),
					AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}
	}

	/**	
	 * Parse the BSR instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BsrInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BSR".equals(instruction.getInstruction())) {
			line = new AssembledBSRInstruction(this);
			((AssembledBSRInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBSR".equals(instruction.getInstruction())) {
			line = new AssembledLBSRInstruction(this);
			((AssembledLBSRInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 3;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		if (line != null) {
			registerLabelPosition(line, 
					instruction.eContainer(),
					AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}
	}

	/**	
	 * Parse the BRN instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BrnInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BRN".equals(instruction.getInstruction())) {
			line = new AssembledBRNInstruction(this);
			((AssembledBRNInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBRN".equals(instruction.getInstruction())) {
			line = new AssembledLBRNInstruction(this);
			((AssembledLBRNInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		if (line != null) {
			registerLabelPosition(line, 
						instruction.eContainer(),
						AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}
	}

	/**	
	 * Parse the BRA instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BraInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BRA".equals(instruction.getInstruction())) {
			line = new AssembledBRAInstruction(this);
			((AssembledBRAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBRA".equals(instruction.getInstruction())) {
			line = new AssembledLBRAInstruction(this);
			((AssembledLBRAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 3;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		if (line != null) {
			registerLabelPosition(line, 
					instruction.eContainer(),
					AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}
	}

	/**	
	 * Parse the BPL instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BplInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BPL".equals(instruction.getInstruction())) {
			line = new AssembledBPLInstruction(this);
			((AssembledBPLInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBPL".equals(instruction.getInstruction())) {
			line = new AssembledLBPLInstruction(this);
			((AssembledLBPLInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		if (line != null) {
			registerLabelPosition(line, 
					instruction.eContainer(),
					AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}
	}

	/**	
	 * Parse the BNE instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BneInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BNE".equals(instruction.getInstruction())) {
			line = new AssembledBNEInstruction(this);
			((AssembledBNEInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBNE".equals(instruction.getInstruction())) {
			line = new AssembledLBNEInstruction(this);
			((AssembledLBNEInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		if (line != null) {
			registerLabelPosition(line, 
					instruction.eContainer(),
					AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}
	}

	/**	
	 * Parse the BMI instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BmiInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BMI".equals(instruction.getInstruction())) {
			line = new AssembledBMIInstruction(this);
			((AssembledBMIInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBMI".equals(instruction.getInstruction())) {
			line = new AssembledLBMIInstruction(this);
			((AssembledLBMIInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);

		if (line != null) {
			registerLabelPosition(line, 
					instruction.eContainer(),
					AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}
	}

	/**	
	 * Parse the BLT instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BltInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BLT".equals(instruction.getInstruction())) {
			line = new AssembledBLTInstruction(this);
			((AssembledBLTInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBLT".equals(instruction.getInstruction())) {
			line = new AssembledLBLTInstruction(this);
			((AssembledLBLTInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		if (line != null) {
			registerLabelPosition(line, 
					instruction.eContainer(),
					AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}
	}

	/**	
	 * Parse the BLS instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BlsInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BLS".equals(instruction.getInstruction())) {
			line = new AssembledBLSInstruction(this);
			((AssembledBLSInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBLS".equals(instruction.getInstruction())) {
			line = new AssembledLBLSInstruction(this);
			((AssembledLBLSInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		if (line != null) {
			registerLabelPosition(line, 
					instruction.eContainer(),
					AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}
	}

	/**	
	 * Parse the BLO instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BloInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BLO".equals(instruction.getInstruction())) {
			line = new AssembledBLOInstruction(this);
			((AssembledBLOInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBLO".equals(instruction.getInstruction())) {
			line = new AssembledLBLOInstruction(this);
			((AssembledLBLOInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		if (line != null) {
			registerLabelPosition(line, 
					instruction.eContainer(),
					AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}
	}

	/**	
	 * Parse the BLE instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BleInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BLE".equals(instruction.getInstruction())) {
			line = new AssembledBLEInstruction(this);
			((AssembledBLEInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBLE".equals(instruction.getInstruction())) {
			line = new AssembledLBLEInstruction(this);
			((AssembledLBLEInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		if (line != null) {
			registerLabelPosition(line, 
					instruction.eContainer(),
					AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}	
	}

	/**	
	 * Parse the BHS instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BhsInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BHS".equals(instruction.getInstruction())) {
			line = new AssembledBHSInstruction(this);
			((AssembledBHSInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBHS".equals(instruction.getInstruction())) {
			line = new AssembledLBHSInstruction(this);
			((AssembledLBHSInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		if (line != null) {
			registerLabelPosition(line, 
					instruction.eContainer(),
					AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}	
	}

	/**	
	 * Parse the BHI instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BhiInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BHI".equals(instruction.getInstruction())) {
			line = new AssembledBHIInstruction(this);
			((AssembledBHIInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBHI".equals(instruction.getInstruction())) {
			line = new AssembledLBHIInstruction(this);
			((AssembledLBHIInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		if (line != null) {
			registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}	
	}

	/**	
	 * Parse the BGT instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BgtInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BGT".equals(instruction.getInstruction())) {
			line = new AssembledBGTInstruction(this);
			((AssembledBGTInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBGT".equals(instruction.getInstruction())) {
			line = new AssembledLBGTInstruction(this);
			((AssembledLBGTInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		if (line != null) {
			registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}	
	}

	/**	
	 * Parse the BGE instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BgeInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BGE".equals(instruction.getInstruction())) {
			line = new AssembledBGEInstruction(this);
			((AssembledBGEInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBGE".equals(instruction.getInstruction())) {
			line = new AssembledLBGEInstruction(this);
			((AssembledLBGEInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		if (line != null) {
			registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}	
	}

	/**	
	 * Parse the BEQ instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BeqInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BEQ".equals(instruction.getInstruction())) {
			line = new AssembledBEQInstruction(this);
			((AssembledBEQInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBEQ".equals(instruction.getInstruction())) {
			line = new AssembledLBEQInstruction(this);
			((AssembledLBEQInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		if (line != null) {
			registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}	
	}

	/**	
	 * Parse the BCS instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BcsInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BCS".equals(instruction.getInstruction())) {
			line = new AssembledBCSInstruction(this);
			((AssembledBCSInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBCS".equals(instruction.getInstruction())) {
			line = new AssembledLBCSInstruction(this);
			((AssembledLBCSInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		if (line != null) {
			registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}	
	}

	/**	
	 * Parse the BCC instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BccInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BCC".equals(instruction.getInstruction())) {
			line = new AssembledBCCInstruction(this);
			((AssembledBCCInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBCC".equals(instruction.getInstruction())) {
			line = new AssembledLBCCInstruction(this);
			((AssembledLBCCInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		if (line != null) {
			registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
		}	
	}

	/**	
	 * Parse the TST instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(TstInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("TSTA".equals(instruction.getInstruction())) {
			line = new AssembledTSTAInstruction(this);
			((AssembledTSTAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("TSTB".equals(instruction.getInstruction())) {
			line = new AssembledTSTBInstruction(this);
			((AssembledTSTBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			line = new AssembledTSTInstruction(this);
			((AssembledTSTInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the TFR instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(TfrInstruction instruction) {
		AbstractAssemblyLine line=new AssembledTFRInstruction(this);
    	((AssembledTFRInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the SYNC instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(SyncInstruction instruction) {
		AbstractAssemblyLine line=new AssembledSYNCInstruction(this);
    	((AssembledSYNCInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the SWI3 instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(Swi3Instruction instruction) {
		AbstractAssemblyLine line=new AssembledSWI3Instruction(this);
    	((AssembledSWI3Instruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the SWI2 instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(Swi2Instruction instruction) {
		AbstractAssemblyLine line=new AssembledSWI2Instruction(this);
    	((AssembledSWI2Instruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the SWI instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(SwiInstruction instruction) {
		AbstractAssemblyLine line=new AssembledSWIInstruction(this);
    	((AssembledSWIInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the SUBD instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(SubdInstruction instruction) {
		AbstractAssemblyLine line=new AssembledSUBDInstruction(this);
    	((AssembledSUBDInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the SUB instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(SubInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("SUBA".equals(instruction.getInstruction())) {
			line = new AssembledSUBAInstruction(this);
			((AssembledSUBAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("SUBB".equals(instruction.getInstruction())) {
			line = new AssembledSUBBInstruction(this);
			((AssembledSUBBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the ST instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(StInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("STA".equals(instruction.getInstruction())) {
			line = new AssembledSTAInstruction(this);
			((AssembledSTAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("STB".equals(instruction.getInstruction())) {
			line = new AssembledSTBInstruction(this);
			((AssembledSTBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("STD".equals(instruction.getInstruction())) {
			line = new AssembledSTDInstruction(this);
			((AssembledSTDInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("STS".equals(instruction.getInstruction())) {
			line = new AssembledSTSInstruction(this);
			((AssembledSTSInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("STU".equals(instruction.getInstruction())) {
			line = new AssembledSTUInstruction(this);
			((AssembledSTUInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("STX".equals(instruction.getInstruction())) {
			line = new AssembledSTXInstruction(this);
			((AssembledSTXInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("STY".equals(instruction.getInstruction())) {
			line = new AssembledSTYInstruction(this);
			((AssembledSTYInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			// nothing to do
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the SEX instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(SexInstruction instruction) {
		AbstractAssemblyLine line=new AssembledSEXInstruction(this);
    	((AssembledSEXInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the SBC instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(SbcInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("SBCA".equals(instruction.getInstruction())) {
			line = new AssembledSBCAInstruction(this);
			((AssembledSBCAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("SBCB".equals(instruction.getInstruction())) {
			line = new AssembledSBCBInstruction(this);
			((AssembledSBCBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			// not possible 
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the RTS instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(RtsInstruction instruction) {
		AbstractAssemblyLine line=new AssembledRTSInstruction(this);
    	((AssembledRTSInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the RTI instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(RtiInstruction instruction) {
		AbstractAssemblyLine line=new AssembledRTIInstruction(this);
    	((AssembledRTIInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the ROR instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(RorInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("RORA".equals(instruction.getInstruction())) {
			line = new AssembledRORAInstruction(this);
			((AssembledRORAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("RORB".equals(instruction.getInstruction())) {
			line = new AssembledRORBInstruction(this);
			((AssembledRORBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("ROR".equals(instruction.getInstruction())) {
			line = new AssembledRORInstruction(this);
			((AssembledRORInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			// not possible 
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the ROL instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(RolInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("ROLA".equals(instruction.getInstruction())) {
			line = new AssembledROLAInstruction(this);
			((AssembledROLAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("ROLB".equals(instruction.getInstruction())) {
			line = new AssembledROLBInstruction(this);
			((AssembledROLBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("ROL".equals(instruction.getInstruction())) {
			line = new AssembledROLInstruction(this);
			((AssembledROLInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			// not possible 
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the PULU instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(PuluInstruction instruction) {
		AbstractAssemblyLine line=new AssembledPULUInstruction(this);
    	((AssembledPULUInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the PULS instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(PulsInstruction instruction) {
		AbstractAssemblyLine line=new AssembledPULSInstruction(this);
    	((AssembledPULSInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the PSHU instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(PshuInstruction instruction) {
		AbstractAssemblyLine line=new AssembledPSHUInstruction(this);
    	((AssembledPSHUInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the PSHS instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(PshsInstruction instruction) {
		AbstractAssemblyLine line=new AssembledPSHSInstruction(this);
    	((AssembledPSHSInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the ORCC instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(OrCCInstruction instruction) {
		AssembledORCCInstruction line = new AssembledORCCInstruction(this);
		line.parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the OR instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(OrInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("ORA".equals(instruction.getInstruction())) {
			line = new AssembledORAInstruction(this);
			((AssembledORAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("ORB".equals(instruction.getInstruction())) {
			line = new AssembledORBInstruction(this);
			((AssembledORBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			// not possible 
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the NOP instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(NopInstruction instruction) {
		AssembledNOPInstruction line = new AssembledNOPInstruction(this);
		line.parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
    }

	/**	
	 * Parse the NEG instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(NegInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("NEGA".equals(instruction.getInstruction())) {
			line = new AssembledNEGAInstruction(this);
			((AssembledNEGAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("NEGB".equals(instruction.getInstruction())) {
			line = new AssembledNEGBInstruction(this);
			((AssembledNEGBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("NEG".equals(instruction.getInstruction())) {
			line = new AssembledNEGInstruction(this);
			((AssembledNEGInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			// not possible 
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the MUL instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(MulInstruction instruction) {
		AbstractAssemblyLine line=new AssembledMULInstruction(this);
    	((AssembledMULInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the LSR instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(LsrInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("LSRA".equals(instruction.getInstruction())) {
			line = new AssembledLSRAInstruction(this);
			((AssembledLSRAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("LSRB".equals(instruction.getInstruction())) {
			line = new AssembledLSRBInstruction(this);
			((AssembledLSRBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("LSR".equals(instruction.getInstruction())) {
			line = new AssembledLSRInstruction(this);
			((AssembledLSRInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			// not possible 
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the LSL instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(LslInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("LSLA".equals(instruction.getInstruction())) {
			line = new AssembledLSLAInstruction(this);
			((AssembledLSLAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("LSLB".equals(instruction.getInstruction())) {
			line = new AssembledLSLBInstruction(this);
			((AssembledLSLBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("LSL".equals(instruction.getInstruction())) {
			line = new AssembledLSLInstruction(this);
			((AssembledLSLInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			// not possible 
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the LEA instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(LeaInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("LEAS".equals(instruction.getInstruction())) {
			line = new AssembledLEASInstruction(this);
			((AssembledLEASInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("LEAU".equals(instruction.getInstruction())) {
			line = new AssembledLEAUInstruction(this);
			((AssembledLEAUInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("LEAX".equals(instruction.getInstruction())) {
			line = new AssembledLEAXInstruction(this);
			((AssembledLEAXInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("LEAY".equals(instruction.getInstruction())) {
			line = new AssembledLEAYInstruction(this);
			((AssembledLEAYInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			// not possible 
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	private void parse(LdInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("LDA".equals(instruction.getInstruction())) {
			line = new AssembledLDAInstruction(this);
			((AssembledLDAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("LDB".equals(instruction.getInstruction())) {
			line = new AssembledLDBInstruction(this);
			((AssembledLDBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("LDD".equals(instruction.getInstruction())) {
			line = new AssembledLDDInstruction(this);
			((AssembledLDDInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("LDS".equals(instruction.getInstruction())) {
			line = new AssembledLDSInstruction(this);
			((AssembledLDSInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("LDU".equals(instruction.getInstruction())) {
			line = new AssembledLDUInstruction(this);
			((AssembledLDUInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("LDX".equals(instruction.getInstruction())) {
			line = new AssembledLDXInstruction(this);
			((AssembledLDXInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("LDY".equals(instruction.getInstruction())) {
			line = new AssembledLDYInstruction(this);
			((AssembledLDYInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the JSR instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(JsrInstruction instruction) {
		AssembledJSRInstruction line=new AssembledJSRInstruction(this);
    	line.parsePass1(instruction, currentPcValue, lineNumber);
		currentPcValue += line.getPcIncrement();

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the JMP instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(JmpInstruction instruction) {
		AssembledJMPInstruction line=new AssembledJMPInstruction(this);
    	line.parsePass1(instruction, currentPcValue, lineNumber);
		currentPcValue += line.getPcIncrement();

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the INC instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(IncInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("INCA".equals(instruction.getInstruction())) {
			line = new AssembledINCAInstruction(this);
			((AssembledINCAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("INCB".equals(instruction.getInstruction())) {
			line = new AssembledINCBInstruction(this);
			((AssembledINCBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			line = new AssembledINCInstruction(this);
			((AssembledINCInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the EXG instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(ExgInstruction instruction) {
		AbstractAssemblyLine line=new AssembledEXGInstruction(this);
    	((AssembledEXGInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**	
	 * Parse the EORA and EORB instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(EorInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("EORA".equals(instruction.getInstruction())) {
			line = new AssembledEORAInstruction(this);
			((AssembledEORAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("EORB".equals(instruction.getInstruction())) {
			line = new AssembledEORBInstruction(this);
			((AssembledEORBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**
	 * Parse the DECA, DECB and DEC instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(DecInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("DECA".equals(instruction.getInstruction())) {
			line = new AssembledDECAInstruction(this);
			((AssembledDECAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("DECB".equals(instruction.getInstruction())) {
			line = new AssembledDECBInstruction(this);
			((AssembledDECBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			line = new AssembledDECInstruction(this);
			((AssembledDECInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	private void parse(DaaInstruction instruction) {
		AbstractAssemblyLine line = new AssembledDAAInstruction(this);
		((AssembledDAAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**
	 * Parse the CWAI instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(CwaiInstruction instruction) {
		AbstractAssemblyLine line = new AssembledCWAIInstruction(this);
		((AssembledCWAIInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**
	 * Parse the COMA, COMB and COM instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(ComInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("COMA".equals(instruction.getInstruction())) {
			line = new AssembledCOMAInstruction(this);
			((AssembledCOMAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("COMB".equals(instruction.getInstruction())) {
			line = new AssembledCOMBInstruction(this);
			((AssembledCOMBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			line = new AssembledCOMInstruction(this);
			((AssembledCOMInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**
	 * Parse the CMPA, CMPB, CMPD, CMPU, CMPS, CMPX and CMPY instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(CmpInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("CMPA".equals(instruction.getInstruction())) {
			line = new AssembledCMPAInstruction(this);
			((AssembledCMPAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("CMPB".equals(instruction.getInstruction())) {
			line = new AssembledCMPBInstruction(this);
			((AssembledCMPBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("CMPD".equals(instruction.getInstruction())) {
			line = new AssembledCMPDInstruction(this);
			((AssembledCMPDInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("CMPS".equals(instruction.getInstruction())) {
			line = new AssembledCMPSInstruction(this);
			((AssembledCMPSInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("CMPU".equals(instruction.getInstruction())) {
			line = new AssembledCMPUInstruction(this);
			((AssembledCMPUInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("CMPX".equals(instruction.getInstruction())) {
			line = new AssembledCMPXInstruction(this);
			((AssembledCMPXInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("CMPY".equals(instruction.getInstruction())) {
			line = new AssembledCMPYInstruction(this);
			((AssembledCMPYInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**
	 * Parse the CLRA, CLRB and CLR instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(ClrInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("CLRA".equals(instruction.getInstruction())) {
			line = new AssembledCLRAInstruction(this);
			((AssembledCLRAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("CLRB".equals(instruction.getInstruction())) {
			line = new AssembledCLRBInstruction(this);
			((AssembledCLRBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			line = new AssembledCLRInstruction(this);
			((AssembledCLRInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**
	 * Parse the BITA and BITB instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(BitInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BITA".equals(instruction.getInstruction())) {
			line = new AssembledBITAInstruction(this);
			((AssembledBITAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("BITB".equals(instruction.getInstruction())) {
			line = new AssembledBITBInstruction(this);
			((AssembledBITBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**
	 * Parse the ASRA, ASRB and ASR instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(AsrInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("ASRA".equals(instruction.getInstruction())) {
			line = new AssembledASRAInstruction(this);
			((AssembledASRAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("ASRB".equals(instruction.getInstruction())) {
			line = new AssembledASRBInstruction(this);
			((AssembledASRBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			line = new AssembledASRInstruction(this);
			((AssembledASRInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**
	 * Parse the ASLA, ASLB and ASL instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(AslInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("ASLA".equals(instruction.getInstruction())) {
			line = new AssembledASLAInstruction(this);
			((AssembledASLAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("ASLB".equals(instruction.getInstruction())) {
			line = new AssembledASLBInstruction(this);
			((AssembledASLBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			line = new AssembledASLInstruction(this);
			((AssembledASLInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**
	 * Parse the ANDA and ANDB instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(AndCCInstruction instruction) {
		AbstractAssemblyLine line = new AssembledANDCCInstruction(this);
		((AssembledANDCCInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**
	 * Parse the ANDA and ANDB instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(AndInstruction instruction) {
		AbstractAssemblyLine line;

		if ("ANDA".equals(instruction.getInstruction())) {
			line = new AssembledANDAInstruction(this);
			((AssembledANDAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("ANDB".equals(instruction.getInstruction())) {
			line = new AssembledANDBInstruction(this);
			((AssembledANDBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			line = null;
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	private void parse(AdddInstruction instruction) {

		AbstractAssemblyLine line = new AssembledADDDInstruction(this);
		((AssembledADDDInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	private void parse(AddInstruction instruction) {
		AbstractAssemblyLine line;

		if ("ADDA".equals(instruction.getInstruction())) {
			line = new AssembledADDAInstruction(this);
			((AssembledADDAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("ADDB".equals(instruction.getInstruction())) {
			line = new AssembledADDBInstruction(this);
			((AssembledADDBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			line = null;
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**
	 * Parse an ADC directive line.
	 *  
	 * @param instruction reference on the ABX instruction
	 */
	private void parse(AdcInstruction instruction) {
		AbstractAssemblyLine line;

		if ("ADCA".equals(instruction.getInstruction())) {
			line = new AssembledADCAInstruction(this);
			((AssembledADCAInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else if ("ADCB".equals(instruction.getInstruction())) {
			line = new AssembledADCBInstruction(this);
			((AssembledADCBInstruction) line).parsePass1(instruction, currentPcValue, lineNumber);
		} else {
			line = null;
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**
	 * Parse an ABX directive line.
	 *  
	 * @param instruction reference on the ABX instruction
	 */
	private void parse(AbxInstruction instruction) {
		AssembledABXInstruction line = new AssembledABXInstruction(this);
		line.parsePass1(instruction, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += line.getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.eINSTANCE.getInstructionLine_Label());
	}

	/**
	 * Parse a blank line 
	 * 
	 * @param blankLine reference on the blank line
	 */
	private void parseBlankLine(BlankLine blankLine) {
		AssembledBlankLine line = new AssembledBlankLine(this);
		line.parsePass1(blankLine, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(blankLine, line);
	}

	/**
	 * Parse a comment line 
	 * 
	 * @param commentLine reference on the comment line
	 */
	private void parseCommentLine(CommentLine commentLine) {
		AssembledCommentLine assembledCommentLine = new AssembledCommentLine(this);
		assembledCommentLine.parsePass1(commentLine, currentPcValue, lineNumber);
		assemblyLines.add(assembledCommentLine);
		assembledLinesMap.put(commentLine, assembledCommentLine);
	}

	/**
	 * Parse a comment line 
	 * 
	 * @param labelLine reference on the label line
	 */
	private void parseLabelLine(LabelLine labelLine) {
		AssembledLabelLine assembledLabelLine = new AssembledLabelLine(this);
		assembledLabelLine.parsePass1(labelLine, currentPcValue, lineNumber);
		assemblyLines.add(assembledLabelLine);
		
		registerLabelPosition(assembledLabelLine, 
				labelLine,
				AssemblerPackage.eINSTANCE.getLabelLine_Label());
		
	}


	/**
	 * Parse a directive line
	 * 
	 * @param directiveLine reference on the directive line
	 * @return <b>true</b> stop the assembler,<b>false</b> otherwise continue 
	 * @throws UnresolvedException 
	 */
	private boolean parseDirectiveLine(DirectiveLine directiveLine) {
		boolean needStop = false;
		
		if (directiveLine.getDirective() instanceof OrgDirective orgDirective) {
			parseDirective(orgDirective);
		
		} else if (directiveLine.getDirective() instanceof EquDirective equDirective) {
			parseDirective(equDirective);
		
		} else if (directiveLine.getDirective() instanceof SetDirective setDirective) {
			parseDirective(setDirective);
		
		} else if (directiveLine.getDirective() instanceof BszDirective bszDirective) {
			parseDirective(bszDirective);
		
		} else if (directiveLine.getDirective() instanceof EndDirective endDirective) {
			parseDirective(endDirective);
			needStop = true;
			
		} else if (directiveLine.getDirective() instanceof FillDirective fillDirective) {
			parseDirective(fillDirective);

		} else if (directiveLine.getDirective() instanceof OptDirective optDirective) {
			parseDirective(optDirective);

		} else if (directiveLine.getDirective() instanceof PagDirective pagDirective) {
			parseDirective(pagDirective);

		} else if (directiveLine.getDirective() instanceof NamDirective namDirective) {
			parseDirective(namDirective);

		} else if (directiveLine.getDirective() instanceof SpcDirective spcDirective) {
			parseDirective(spcDirective);

		} else if (directiveLine.getDirective() instanceof RegDirective regDirective) {
			parseDirective(regDirective);

		} else if (directiveLine.getDirective() instanceof FcbDirective fcbDirective) {
			parseDirective(fcbDirective);

		} else if (directiveLine.getDirective() instanceof FdbDirective fdbDirective) {
			parseDirective(fdbDirective);

		} else if (directiveLine.getDirective() instanceof FccDirective fccDirective) {
			parseDirective(fccDirective);

		} else if (directiveLine.getDirective() instanceof RmbDirective rmbDirective) {
			parseDirective(rmbDirective);

		} else if (directiveLine.getDirective() instanceof SetDPDirective setdpDirective) {
			parseDirective(setdpDirective);

		} else if (directiveLine.getDirective() instanceof FailDirective failDirective) {
			parseDirective(failDirective);

		} else {
			logger.log(Level.SEVERE,"Unknow directive {0}", directiveLine.getDirective().getClass().getSimpleName());
		}
		
		return needStop;
	}

	/**
	 * Parse a FAIL directive line.
	 *  
	 * @param failDirective reference on the FAIL directive
	 */
	private void parseDirective(FailDirective failDirective) {
		AssembledFailDirectiveLine line = new AssembledFailDirectiveLine(this);
		line.parsePass1(failDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(failDirective, line);
		currentPcValue += line.getPcIncrement();

		registerLabelPosition(line, 
				line.getDirective().eContainer(),
				AssemblerPackage.eINSTANCE.getDirectiveLine_Label());
	}

	/**
	 * Parse an SETDP directive line.
	 *  
	 * @param setdpDirective reference on the SETDP directive
	 */
	private void parseDirective(SetDPDirective setdpDirective) {
		AssembledSetDPDirectiveLine line = new AssembledSetDPDirectiveLine(this);
		line.parsePass1(setdpDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(setdpDirective, line);
		currentPcValue += line.getPcIncrement();
		
		currentDPPage = line.getValue();
		
		registerLabelPosition(line, 
				line.getDirective().eContainer(),
				AssemblerPackage.eINSTANCE.getDirectiveLine_Label());
	}

	/**
	 * Parse an RMB directive line.
	 *  
	 * @param rmbDirective reference on the RMB directive
	 */
	private void parseDirective(RmbDirective rmbDirective) {
		AssembledRmbDirectiveLine line = new AssembledRmbDirectiveLine(this);
		line.parsePass1(rmbDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(rmbDirective, line);
		currentPcValue += line.getPcIncrement();
		
		registerLabelPosition(line, 
				line.getDirective().eContainer(),
				AssemblerPackage.eINSTANCE.getDirectiveLine_Label());
	}

	/**
	 * Parse an FCC directive line.
	 *  
	 * @param fccDirective reference on the FCC directive
	 */
	private void parseDirective(FccDirective fccDirective) {
		AssembledFccDirectiveLine line = new AssembledFccDirectiveLine(this);
		line.parsePass1(fccDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(fccDirective, line);
		currentPcValue += line.getPcIncrement();
		
		registerLabelPosition(line, 
				line.getDirective().eContainer(),
				AssemblerPackage.eINSTANCE.getDirectiveLine_Label());
	}

	/**
	 * Parse an FDB directive line.
	 *  
	 * @param fdbDirective reference on the FDB directive
	 */
	private void parseDirective(FdbDirective fdbDirective) {
		AssembledFdbDirectiveLine line = new AssembledFdbDirectiveLine(this);
		line.parsePass1(fdbDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(fdbDirective, line);
		currentPcValue += line.getPcIncrement();
		
		registerLabelPosition(line, 
				line.getDirective().eContainer(),
				AssemblerPackage.eINSTANCE.getDirectiveLine_Label());
	}

	/**
	 * Parse an FCB directive line.
	 *  
	 * @param fcbDirective reference on the FCB directive
	 */
	private void parseDirective(FcbDirective fcbDirective) {
		AssembledFcbDirectiveLine line = new AssembledFcbDirectiveLine(this);
		line.parsePass1(fcbDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(fcbDirective, line);
		currentPcValue += line.getPcIncrement();
		
		registerLabelPosition(line, 
				line.getDirective().eContainer(),
				AssemblerPackage.eINSTANCE.getDirectiveLine_Label());
	}

	/**
	 * Parse an REG directive line.
	 *  
	 * @param regDirective reference on the REG directive
	 */
	private void parseDirective(RegDirective regDirective) {
		AssembledRegDirectiveLine line = new AssembledRegDirectiveLine(this);
		line.parsePass1(regDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(regDirective, line);
		currentPcValue += line.getPcIncrement();
	}

	/**
	 * Parse an SPC directive line.
	 *  
	 * @param spcDirective reference on the SPC directive
	 */
	private void parseDirective(SpcDirective spcDirective) {
		AssembledSpcDirectiveLine line = new AssembledSpcDirectiveLine(this);
		line.parsePass1(spcDirective, currentPcValue, lineNumber);
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
		AssembledNamDirectiveLine line = new AssembledNamDirectiveLine(this);
		line.parsePass1(namDirective, currentPcValue, lineNumber);
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
		AssembledPagDirectiveLine line = new AssembledPagDirectiveLine(this);
		line.parsePass1(pagDirective, currentPcValue, lineNumber);
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
		AssembledOptDirectiveLine line = new AssembledOptDirectiveLine(this);
		line.parsePass1(optDirective, currentPcValue, lineNumber);
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
		AssembledFillDirectiveLine line = new AssembledFillDirectiveLine(this);
		line.parsePass1(fillDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(fillDirective, line);
		currentPcValue += line.getPcIncrement();
		
		registerLabelPosition(line, 
				line.getDirective().eContainer(),
				AssemblerPackage.eINSTANCE.getDirectiveLine_Label());
	}

	/**
	 * Parse an End directive line.
	 *  
	 * @param endDirective reference on the END directive
	 */
	private void parseDirective(EndDirective endDirective) {
		AssembledEndDirectiveLine line = new AssembledEndDirectiveLine(this);
		line.parsePass1(endDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(endDirective, line);
	}

	/**
	 * Parse an BSZ directive line.
	 * Memorize the BSZ label 
	 *  
	 * @param bszDirective reference on the BSZ directive
	 */
	private void parseDirective(BszDirective bszDirective) {
		AssembledBszDirectiveLine line = new AssembledBszDirectiveLine(this);
		line.parsePass1(bszDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(bszDirective, line);
		currentPcValue += line.getPcIncrement();
		
		registerLabelPosition(line, 
				bszDirective.eContainer(),
				AssemblerPackage.eINSTANCE.getDirectiveLine_Label());
	}

	/**
	 * Parse an SET directive line.
	 * Memorize the SET label and check that it don't override EQU label 
	 *  
	 * @param setDirective reference on the SET directive
	 */
	private void parseDirective(SetDirective setDirective) {
		AssembledSetDirectiveLine line = new AssembledSetDirectiveLine(this);
		line.parsePass1(setDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(setDirective, line);
		equSetManager.setValue(setDirective, line.getLabel(),  line.getValue().intValue());
		equSetManager.setSetActive(setDirective);
	}

	/**
	 * Parse an EQU directive line.
	 * Memorize the EQU label and check that there the label 
	 * isn't duplicate
	 * 
	 * @param equDirective reference on the EQU directive
	 */
	private void parseDirective(EquDirective equDirective) {
		AssembledEquDirectiveLine line = new AssembledEquDirectiveLine(this);
		line.parsePass1(equDirective, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(equDirective, line);
	}

	/**
	 * Parse an ORG directive line.
	 * Memorize the ORG label and check that there the label 
	 * isn't duplicate
	 * 
	 * @param orgDirective reference on the ORG directive
	 * @throws UnresolvedException 
	 */
	private void parseDirective(OrgDirective directive) {
		try {
			int pcValue = ExpressionParser.parse(this, directive);
			currentPcValue = pcValue;
		} catch (UnresolvedException e) {
			// TODO Auto-generated catch block
		}
		
		AssembledOrgDirectiveLine line = new AssembledOrgDirectiveLine(this);
		line.parsePass1(directive, currentPcValue, lineNumber);
		assemblyLines.add(line);
		assembledLinesMap.put(directive, line);

		registerLabelPosition(line, 
				line.getDirective().eContainer(),
				AssemblerPackage.eINSTANCE.getDirectiveLine_Label());
	}

	/**
	 * Register the label position, and send an error if thelabel is duplicate
	 * @param directive reference on the directive
	 * @param objectWithProblem reference on EMF object which has the problem
	 * @param reference EMF reference of the object
	 */
	private void registerLabelPosition(AbstractAssemblyLine directive,Object objectWithProblem, EReference reference) {
		if (directive.getLabel() != null) {
			if (labelsPositionObject.containsKey(directive.getLabel())) {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + directive.getLabel() + " is already defined",
						reference,
						InstructionValidator.DUPLICATE_LABEL);
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
	 * @param label value of the label
	 * @return value pointed by the label
	 */
	public Integer getEquSetLabelValue(String label) {

		return equSetManager.getValue(label);
	}

	/**
	 * Return the current DP page value.
	 * 
	 * @return vlaue of the DP
	 */
	public int getCurrentDPPage() {
		return currentDPPage;
	}

	/**
	 * Return the reference on the equ set manager
	 * @return reference on the equ set manager
	 */
	public EquSetManager getEquSetManager() {
		return equSetManager;
	}

	/**
	 * Add a missing label in the collection of missing labels.
	 * 
	 * @param missingLabel missing label name
	 */
	public void addMissingLabel(String missingLabel) {
		if (!missingLabels.contains(missingLabel)) {
			missingLabels.add(missingLabel);
		}
	}

	/**
	 * Get the collection of missing labels
	 * 
	 * @return collection of missing labels
	 */
	public List<String> getMissingLabels() {
		return missingLabels;
	}
}
