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
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.comment.AssembledBlankLine;
import org.bpy.electronics.mc6809.assembler.engine.data.comment.AssembledCommentLine;
import org.bpy.electronics.mc6809.assembler.engine.data.comment.AssembledLabelLine;
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
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.*;
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
	/** Contains the collection of Register definition */
	private Map<String, Integer> regDefinitionValues;
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
		regDefinitionValues = new HashMap<>();
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
		currentPcValue = 0;
		assemblyLines = new ArrayList<>();

		AssemblerErrorManager.getInstance().clear();

		assemblePass1(model);
		assemblePass2(model);
		
	}
	
	private void assemblePass1(Model model) {
		lineNumber = 1;

		List<SourceLine> sourceLines = model.getSourceLines();
		for (SourceLine sourceLine : sourceLines) {
			if (sourceLine.getLineContent() instanceof BlankLine) {
				BlankLine blankLine = (BlankLine)sourceLine.getLineContent();
				parseBlankLine(blankLine);
				
			} else if (sourceLine.getLineContent() instanceof CommentLine) {
				CommentLine commentLine = (CommentLine)sourceLine.getLineContent(); 
				parseCommentLine(commentLine);
				
			} else if (sourceLine.getLineContent() instanceof LabelLine) {
				LabelLine labelLine = (LabelLine)sourceLine.getLineContent(); 
				parseLabelLine(labelLine);
				
			} else if (sourceLine.getLineContent() instanceof DirectiveLine) {
				DirectiveLine directiveLine = (DirectiveLine)sourceLine.getLineContent();
				boolean needStop = parseDirectiveLine(directiveLine);
				if (needStop) {
					break;
				}
			} else if(sourceLine.getLineContent() instanceof SpecialFunctions) {
				SpecialFunctions specialFuntions = (SpecialFunctions)sourceLine.getLineContent();
				parse(specialFuntions);
				
			} else if (sourceLine.getLineContent() instanceof InstructionLine) {
				InstructionLine instructionLine = (InstructionLine) sourceLine.getLineContent();
				parseInstructionLinePass1(instructionLine);
				
			} else {
				logger.log(Level.SEVERE,"Unknow directive {0}" + sourceLine.getLineContent().getClass().getSimpleName());
			}
			lineNumber++;
		}
	}

	/**
	 * Allow to parse and assemble specials funtions
	 * 
	 * @param specialFuntions
	 */
	private void parse(SpecialFunctions specialFuntions) {
		if (specialFuntions.getSpecialFuntion() instanceof MacroDefinition) {
			MacroDefinition macroDefinition = (MacroDefinition)specialFuntions.getSpecialFuntion();
			parse(macroDefinition);
		}
	}

	/**
	 * Allow to parse a macro definition
	 * 
	 * @param macroDefinition reference on the macro definition
	 */
	private void parse(MacroDefinition macroDefinition) {
		// TODO : Manage macro definition	
	}

	private void assemblePass2(Model model) {
		lineNumber = 1;

		List<SourceLine> sourceLines = model.getSourceLines();
		for (SourceLine sourceLine : sourceLines) {
			if (sourceLine.getLineContent() instanceof InstructionLine) {
				InstructionLine instructionLine = (InstructionLine) sourceLine.getLineContent();
				parseInstructionLinePass2(instructionLine);
			}
			lineNumber++;
		}
	}

	private void parseInstructionLinePass2(InstructionLine instructionLine) {
		if (instructionLine.getInstruction() instanceof BccInstruction) {
			parsePass2((BccInstruction)instructionLine.getInstruction());
		
		} else if (instructionLine.getInstruction() instanceof BcsInstruction) {
			parsePass2((BcsInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BeqInstruction) {
			parsePass2((BeqInstruction)instructionLine.getInstruction());

		} else if (instructionLine.getInstruction() instanceof BgeInstruction) {
			parsePass2((BgeInstruction)instructionLine.getInstruction());

		} else if (instructionLine.getInstruction() instanceof BgtInstruction) {
			parsePass2((BgtInstruction)instructionLine.getInstruction());

		} else if (instructionLine.getInstruction() instanceof BhiInstruction) {
			parsePass2((BhiInstruction)instructionLine.getInstruction());

		} else if (instructionLine.getInstruction() instanceof BhsInstruction) {
			parsePass2((BhsInstruction)instructionLine.getInstruction());

		} else if (instructionLine.getInstruction() instanceof BleInstruction) {
			parsePass2((BleInstruction)instructionLine.getInstruction());

		} else if (instructionLine.getInstruction() instanceof BloInstruction) {
			parsePass2((BloInstruction)instructionLine.getInstruction());

		} else if (instructionLine.getInstruction() instanceof BlsInstruction) {
			parsePass2((BlsInstruction)instructionLine.getInstruction());

		} else if (instructionLine.getInstruction() instanceof BltInstruction) {
			parsePass2((BltInstruction)instructionLine.getInstruction());

		} else if (instructionLine.getInstruction() instanceof BmiInstruction) {
			parsePass2((BmiInstruction)instructionLine.getInstruction());

		} else if (instructionLine.getInstruction() instanceof BneInstruction) {
			parsePass2((BneInstruction)instructionLine.getInstruction());

		} else if (instructionLine.getInstruction() instanceof BplInstruction) {
			parsePass2((BplInstruction)instructionLine.getInstruction());

		} else if (instructionLine.getInstruction() instanceof BraInstruction) {
			parsePass2((BraInstruction)instructionLine.getInstruction());

		} else if (instructionLine.getInstruction() instanceof BrnInstruction) {
			parsePass2((BrnInstruction)instructionLine.getInstruction());

		} else if (instructionLine.getInstruction() instanceof BsrInstruction) {
			parsePass2((BsrInstruction)instructionLine.getInstruction());

		} else if (instructionLine.getInstruction() instanceof BvcInstruction) {
			parsePass2((BvcInstruction)instructionLine.getInstruction());

		} else if (instructionLine.getInstruction() instanceof BvsInstruction) {
			parsePass2((BvsInstruction)instructionLine.getInstruction());

		} else if (instructionLine.getInstruction() instanceof JmpInstruction) {
			parsePass2((JmpInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof JsrInstruction) {
			parsePass2((JsrInstruction)instructionLine.getInstruction());
			
		}
	}

	private void parsePass2(JsrInstruction instruction) {
		AssembledJSRInstruction currentAssembledLine = (AssembledJSRInstruction)assembledLinesMap.get(instruction);
		currentAssembledLine.computeOperand(labelsPositionObject);

	}

	private void parsePass2(JmpInstruction instruction) {
		AssembledJMPInstruction currentAssembledLine = (AssembledJMPInstruction) assembledLinesMap.get(instruction);
		currentAssembledLine.computeOperand(labelsPositionObject);
	}

	/**
	 * Second step of the assembly of a BVS Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BvsInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BVS".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BVS_INSTRUCTION__OPERAND
							);

				} else if ("LBVS".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BVS_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BVS_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Second step of the assembly of a BVC Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BvcInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BVC".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BVC_INSTRUCTION__OPERAND
							);

				} else if ("LBVC".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BVC_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BVC_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Second step of the assembly of a BSR Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BsrInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BSR".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BSR_INSTRUCTION__OPERAND
							);

				} else if ("LBSR".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BSR_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BSR_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Second step of the assembly of a BRN Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BrnInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BRN".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BRN_INSTRUCTION__OPERAND
							);

				} else if ("LBRN".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BRN_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BRN_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Second step of the assembly of a BRA Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BraInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BRA".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BRA_INSTRUCTION__OPERAND
							);

				} else if ("LBRA".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BRA_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BRA_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Second step of the assembly of a BPL Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BplInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BPL".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BPL_INSTRUCTION__OPERAND
							);

				} else if ("LBPL".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BPL_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BPL_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Second step of the assembly of a BNE Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BneInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BNE".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BNE_INSTRUCTION__OPERAND
							);

				} else if ("LBNE".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BNE_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BNE_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Second step of the assembly of a BMI Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BmiInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BMI".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BMI_INSTRUCTION__OPERAND
							);

				} else if ("LBMI".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BMI_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BMI_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Second step of the assembly of a BLT Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BltInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BLT".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BLT_INSTRUCTION__OPERAND
							);

				} else if ("LBLT".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BLT_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BLT_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Second step of the assembly of a BLs Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BlsInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BLS".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BLS_INSTRUCTION__OPERAND
							);

				} else if ("LBLS".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BLS_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BLS_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Second step of the assembly of a BLO Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BloInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BLO".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BLO_INSTRUCTION__OPERAND
							);

				} else if ("LBLO".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BLO_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BLO_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Second step of the assembly of a BLE Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BleInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BLE".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BLE_INSTRUCTION__OPERAND
							);

				} else if ("LBLE".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BLE_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BLE_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Second step of the assembly of a BHS Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BhsInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BHS".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BHS_INSTRUCTION__OPERAND
							);

				} else if ("LBHS".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BHS_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BHS_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Second step of the assembly of a BHI Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BhiInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BHI".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BHI_INSTRUCTION__OPERAND
							);

				} else if ("LBHI".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BHI_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BHI_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Second step of the assembly of a BGT Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BgtInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BGT".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BGT_INSTRUCTION__OPERAND
							);

				} else if ("LBGT".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BGT_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BGT_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Second step of the assembly of a BGE Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BgeInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BGE".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BGE_INSTRUCTION__OPERAND
							);

				} else if ("LBGE".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BGE_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BGE_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Second step of the assembly of a BEQ Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BeqInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BEQ".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BEQ_INSTRUCTION__OPERAND
							);

				} else if ("LBEQ".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BEQ_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BEQ_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Second step of the assembly of a BCS Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BcsInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BCS".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BCS_INSTRUCTION__OPERAND
							);

				} else if ("LBCS".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BCS_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BCS_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Second step of the assembly of a BCC Instruction. 
	 * Compute the jump 
	 * 
	 * @param instruction reference on the EMF instruction
	 */
	private void parsePass2(BccInstruction instruction) {
		String label = instruction.getOperand().getOffset().getValue();
		if (label != null) {
			
			AbstractAssemblyLine targetLine = labelsPositionObject.get(label);
			if (targetLine != null) {
				
				if ("BCC".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.BYTE_MODE,
							AssemblerPackage.Literals.BCC_INSTRUCTION__OPERAND
							);

				} else if ("LBCC".equals(instruction.getInstruction())) {
					
					AbstractAssemblyLine currentAssembledLine = assembledLinesMap.get(instruction);
					((AbstractRelativeBranchInstruction)currentAssembledLine).computeOperand(targetLine.getPcAddress(),
							AbstractRelativeBranchInstruction.WORD_MODE,
							AssemblerPackage.Literals.BCC_INSTRUCTION__OPERAND
							);

				}
			} else {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription("Label " + label + " isn't defined",
						AssemblerPackage.Literals.BCC_INSTRUCTION__OPERAND,
						InstructionValidator.MISSING_LABEL);
				AssemblerErrorManager.getInstance().addProblem(instruction, problemDescription);
			}
		}
	}

	/**
	 * Allow to parse an instruction line.
	 * 
	 * @param instructionLine reference on the instruction line
	 */
	private void parseInstructionLinePass1(InstructionLine instructionLine) {
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
			
		} else if (instructionLine.getInstruction() instanceof OrInstruction) {
			parse((OrInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof OrCCInstruction) {
			parse((OrCCInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof PshsInstruction) {
			parse((PshsInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof PshuInstruction) {
			parse((PshuInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof PulsInstruction) {
			parse((PulsInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof PuluInstruction) {
			parse((PuluInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof RolInstruction) {
			parse((RolInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof RorInstruction) {
			parse((RorInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof RtiInstruction) {
			parse((RtiInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof RtsInstruction) {
			parse((RtsInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof SbcInstruction) {
			parse((SbcInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof SexInstruction) {
			parse((SexInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof StInstruction) {
			parse((StInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof SubInstruction) {
			parse((SubInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof SubdInstruction) {
			parse((SubdInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof SwiInstruction) {
			parse((SwiInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof Swi2Instruction) {
			parse((Swi2Instruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof Swi3Instruction) {
			parse((Swi3Instruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof SyncInstruction) {
			parse((SyncInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof TfrInstruction) {
			parse((TfrInstruction)instructionLine.getInstruction());
				
		} else if (instructionLine.getInstruction() instanceof TstInstruction) {
			parse((TstInstruction)instructionLine.getInstruction());
				
		// Start branch instruction
		} else if (instructionLine.getInstruction() instanceof BccInstruction) {
			parsePass1((BccInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BcsInstruction) {
			parsePass1((BcsInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BeqInstruction) {
			parsePass1((BeqInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BgeInstruction) {
			parsePass1((BgeInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BgtInstruction) {
			parsePass1((BgtInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BhiInstruction) {
			parsePass1((BhiInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BhsInstruction) {
			parsePass1((BhsInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BleInstruction) {
			parsePass1((BleInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BloInstruction) {
			parsePass1((BloInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BlsInstruction) {
			parsePass1((BlsInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BltInstruction) {
			parsePass1((BltInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BmiInstruction) {
			parsePass1((BmiInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BneInstruction) {
			parsePass1((BneInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BplInstruction) {
			parsePass1((BplInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BraInstruction) {
			parsePass1((BraInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BrnInstruction) {
			parsePass1((BrnInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BsrInstruction) {
			parsePass1((BsrInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BvcInstruction) {
			parsePass1((BvcInstruction)instructionLine.getInstruction());
			
		} else if (instructionLine.getInstruction() instanceof BvsInstruction) {
			parsePass1((BvsInstruction)instructionLine.getInstruction());
			
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
			line = new AssembledBVSInstruction();
			((AssembledBVSInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBVS".equals(instruction.getInstruction())) {
			line = new AssembledLBVSInstruction();
			((AssembledLBVSInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the BVC instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BvcInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BVC".equals(instruction.getInstruction())) {
			line = new AssembledBVCInstruction();
			((AssembledBVCInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBVC".equals(instruction.getInstruction())) {
			line = new AssembledLBVCInstruction();
			((AssembledLBVCInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the BSR instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BsrInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BSR".equals(instruction.getInstruction())) {
			line = new AssembledBSRInstruction();
			((AssembledBSRInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBSR".equals(instruction.getInstruction())) {
			line = new AssembledLBSRInstruction();
			((AssembledLBSRInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 3;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the BRN instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BrnInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BRN".equals(instruction.getInstruction())) {
			line = new AssembledBRNInstruction();
			((AssembledBRNInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBRN".equals(instruction.getInstruction())) {
			line = new AssembledLBRNInstruction();
			((AssembledLBRNInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the BRA instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BraInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BRA".equals(instruction.getInstruction())) {
			line = new AssembledBRAInstruction();
			((AssembledBRAInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBRA".equals(instruction.getInstruction())) {
			line = new AssembledLBRAInstruction();
			((AssembledLBRAInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 3;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the BPL instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BplInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BPL".equals(instruction.getInstruction())) {
			line = new AssembledBPLInstruction();
			((AssembledBPLInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBPL".equals(instruction.getInstruction())) {
			line = new AssembledLBPLInstruction();
			((AssembledLBPLInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the BNE instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BneInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BNE".equals(instruction.getInstruction())) {
			line = new AssembledBNEInstruction();
			((AssembledBNEInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBNE".equals(instruction.getInstruction())) {
			line = new AssembledLBNEInstruction();
			((AssembledLBNEInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the BMI instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BmiInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BMI".equals(instruction.getInstruction())) {
			line = new AssembledBMIInstruction();
			((AssembledBMIInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBMI".equals(instruction.getInstruction())) {
			line = new AssembledLBMIInstruction();
			((AssembledLBMIInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the BLT instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BltInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BLT".equals(instruction.getInstruction())) {
			line = new AssembledBLTInstruction();
			((AssembledBLTInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBLT".equals(instruction.getInstruction())) {
			line = new AssembledLBLTInstruction();
			((AssembledLBLTInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the BLS instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BlsInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BLS".equals(instruction.getInstruction())) {
			line = new AssembledBLSInstruction();
			((AssembledBLSInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBLS".equals(instruction.getInstruction())) {
			line = new AssembledLBLSInstruction();
			((AssembledLBLSInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the BLO instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BloInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BLO".equals(instruction.getInstruction())) {
			line = new AssembledBLOInstruction();
			((AssembledBLOInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBLO".equals(instruction.getInstruction())) {
			line = new AssembledLBLOInstruction();
			((AssembledLBLOInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the BLE instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BleInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BLE".equals(instruction.getInstruction())) {
			line = new AssembledBLEInstruction();
			((AssembledBLEInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBLE".equals(instruction.getInstruction())) {
			line = new AssembledLBLEInstruction();
			((AssembledLBLEInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the BHS instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BhsInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BHS".equals(instruction.getInstruction())) {
			line = new AssembledBHSInstruction();
			((AssembledBHSInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBHS".equals(instruction.getInstruction())) {
			line = new AssembledLBHSInstruction();
			((AssembledLBHSInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the BHI instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BhiInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BHI".equals(instruction.getInstruction())) {
			line = new AssembledBHIInstruction();
			((AssembledBHIInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBHI".equals(instruction.getInstruction())) {
			line = new AssembledLBHIInstruction();
			((AssembledLBHIInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the BGT instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BgtInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BGT".equals(instruction.getInstruction())) {
			line = new AssembledBGTInstruction();
			((AssembledBGTInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBGT".equals(instruction.getInstruction())) {
			line = new AssembledLBGTInstruction();
			((AssembledLBGTInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the BGE instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BgeInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BGE".equals(instruction.getInstruction())) {
			line = new AssembledBGEInstruction();
			((AssembledBGEInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBGE".equals(instruction.getInstruction())) {
			line = new AssembledLBGEInstruction();
			((AssembledLBGEInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the BEQ instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BeqInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BEQ".equals(instruction.getInstruction())) {
			line = new AssembledBEQInstruction();
			((AssembledBEQInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBEQ".equals(instruction.getInstruction())) {
			line = new AssembledLBEQInstruction();
			((AssembledLBEQInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the BCS instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BcsInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BCS".equals(instruction.getInstruction())) {
			line = new AssembledBCSInstruction();
			((AssembledBCSInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBCS".equals(instruction.getInstruction())) {
			line = new AssembledLBCSInstruction();
			((AssembledLBCSInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the BCC instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parsePass1(BccInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("BCC".equals(instruction.getInstruction())) {
			line = new AssembledBCCInstruction();
			((AssembledBCCInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 2;
		} else if ("LBCC".equals(instruction.getInstruction())) {
			line = new AssembledLBCCInstruction();
			((AssembledLBCCInstruction) line).parse(instruction, currentPcValue, lineNumber);
			currentPcValue += 4;
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the TST instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(TstInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("TSTA".equals(instruction.getInstruction())) {
			line = new AssembledTSTAInstruction();
			((AssembledTSTAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("TSTB".equals(instruction.getInstruction())) {
			line = new AssembledTSTBInstruction();
			((AssembledTSTBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			line = new AssembledTSTInstruction();
			((AssembledTSTInstruction) line).parse(instruction, currentPcValue, lineNumber);
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the SYNC instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(SyncInstruction instruction) {
		AbstractAssemblyLine line=new AssembledSYNCInstruction();
    	((AssembledSYNCInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the SWI3 instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(Swi3Instruction instruction) {
		AbstractAssemblyLine line=new AssembledSWI3Instruction();
    	((AssembledSWI3Instruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the SWI2 instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(Swi2Instruction instruction) {
		AbstractAssemblyLine line=new AssembledSWI2Instruction();
    	((AssembledSWI2Instruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the SWI instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(SwiInstruction instruction) {
		AbstractAssemblyLine line=new AssembledSWIInstruction();
    	((AssembledSWIInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the SUBD instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(SubdInstruction instruction) {
		AbstractAssemblyLine line=new AssembledSUBDInstruction();
    	((AssembledSUBDInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the SUB instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(SubInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("SUBA".equals(instruction.getInstruction())) {
			line = new AssembledSUBAInstruction();
			((AssembledSUBAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("SUBB".equals(instruction.getInstruction())) {
			line = new AssembledSUBBInstruction();
			((AssembledSUBBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			// not possible
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the ST instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(StInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("STA".equals(instruction.getInstruction())) {
			line = new AssembledSTAInstruction();
			((AssembledSTAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("STB".equals(instruction.getInstruction())) {
			line = new AssembledSTBInstruction();
			((AssembledSTBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("STD".equals(instruction.getInstruction())) {
			line = new AssembledSTDInstruction();
			((AssembledSTDInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("STS".equals(instruction.getInstruction())) {
			line = new AssembledSTSInstruction();
			((AssembledSTSInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("STU".equals(instruction.getInstruction())) {
			line = new AssembledSTUInstruction();
			((AssembledSTUInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("STX".equals(instruction.getInstruction())) {
			line = new AssembledSTXInstruction();
			((AssembledSTXInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("STY".equals(instruction.getInstruction())) {
			line = new AssembledSTYInstruction();
			((AssembledSTYInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the SEX instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(SexInstruction instruction) {
		AbstractAssemblyLine line=new AssembledSEXInstruction();
    	((AssembledSEXInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the SBC instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(SbcInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("SBCA".equals(instruction.getInstruction())) {
			line = new AssembledSBCAInstruction();
			((AssembledSBCAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("SBCB".equals(instruction.getInstruction())) {
			line = new AssembledSBCBInstruction();
			((AssembledSBCBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			// not possible 
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the RTS instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(RtsInstruction instruction) {
		AbstractAssemblyLine line=new AssembledRTSInstruction();
    	((AssembledRTSInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the RTI instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(RtiInstruction instruction) {
		AbstractAssemblyLine line=new AssembledRTIInstruction();
    	((AssembledRTIInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the ROR instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(RorInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("RORA".equals(instruction.getInstruction())) {
			line = new AssembledRORAInstruction();
			((AssembledRORAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("RORB".equals(instruction.getInstruction())) {
			line = new AssembledRORBInstruction();
			((AssembledRORBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("ROR".equals(instruction.getInstruction())) {
			line = new AssembledRORInstruction();
			((AssembledRORInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			// not possible 
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the ROL instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(RolInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("ROLA".equals(instruction.getInstruction())) {
			line = new AssembledROLAInstruction();
			((AssembledROLAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("ROLB".equals(instruction.getInstruction())) {
			line = new AssembledROLBInstruction();
			((AssembledROLBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("ROL".equals(instruction.getInstruction())) {
			line = new AssembledROLInstruction();
			((AssembledROLInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			// not possible 
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the PULU instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(PuluInstruction instruction) {
		AbstractAssemblyLine line=new AssembledPULUInstruction();
    	((AssembledPULUInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the PULS instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(PulsInstruction instruction) {
		AbstractAssemblyLine line=new AssembledPULSInstruction();
    	((AssembledPULSInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the PSHU instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(PshuInstruction instruction) {
		AbstractAssemblyLine line=new AssembledPSHUInstruction();
    	((AssembledPSHUInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the PSHS instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(PshsInstruction instruction) {
		AbstractAssemblyLine line=new AssembledPSHSInstruction();
    	((AssembledPSHSInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the ORCC instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(OrCCInstruction instruction) {
		AssembledORCCInstruction line = new AssembledORCCInstruction();
		line.parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the OR instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(OrInstruction instruction) {
		AbstractAssemblyLine line=null;

		if ("ORA".equals(instruction.getInstruction())) {
			line = new AssembledORAInstruction();
			((AssembledORAInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else if ("ORB".equals(instruction.getInstruction())) {
			line = new AssembledORBInstruction();
			((AssembledORBInstruction) line).parse(instruction, currentPcValue, lineNumber);
		} else {
			// not possible 
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	/**	
	 * Parse the NOP instruction.
	 * 
	 * @param instruction reference of the instruction
	 */
	private void parse(NopInstruction instruction) {
		AssembledNOPInstruction line = new AssembledNOPInstruction();
		line.parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
		}

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	private void parse(DaaInstruction instruction) {
		AbstractAssemblyLine line = new AssembledDAAInstruction();
		((AssembledDAAInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
	}

	private void parse(AdddInstruction instruction) {

		AbstractAssemblyLine line = new AssembledADDDInstruction();
		((AssembledADDDInstruction) line).parse(instruction, currentPcValue, lineNumber);

		assemblyLines.add(line);
		assembledLinesMap.put(instruction, line);
		currentPcValue += ((AbstractInstructionAssemblyLine)line).getPcIncrement();
		
		registerLabelPosition(line, 
				instruction.eContainer(),
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
				AssemblerPackage.Literals.INSTRUCTION_LINE__LABEL);
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
	 * Parse a comment line 
	 * 
	 * @param labelLine reference on the label line
	 */
	private void parseLabelLine(LabelLine labelLine) {
		String label = labelLine.getLabel().getName().getValue();
		AssembledLabelLine assembledLabelLine = new AssembledLabelLine();
		assembledLabelLine.parse(labelLine, currentPcValue, lineNumber);
		assemblyLines.add(assembledLabelLine);
		
		registerLabelPosition(assembledLabelLine, 
				labelLine,
				AssemblerPackage.Literals.LABEL_LINE__LABEL);
		
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
				AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL);
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
				AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL);
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
				AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL);
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
				AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL);
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
				AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL);
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
					AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
					DUPLICATE_LABEL);
			AssemblerErrorManager.getInstance().addProblem(line.getDirective().eContainer(), problemDescription );
		} else {
			regDefinitionValues.put(label, line.getValue());	
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
				AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL);
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
						AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
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
				AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL);
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
						AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
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
						AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
						DUPLICATE_LABEL);
				AssemblerErrorManager.getInstance().addWarning(line.getDirective().eContainer(), warningDescription);
	
				labelsEquSet.put(label, line);
				
			} else {
			
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription(
						"The label " + label + " for an EQU directive is already defined", 
						AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL,
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
				AssemblerPackage.Literals.DIRECTIVE_LINE__LABEL);
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
	public Integer getRegDefintionValue(String value) {
		if (regDefinitionValues.containsKey(value)) {
			return regDefinitionValues.get(value);
		} else {
			return null;
		}
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
