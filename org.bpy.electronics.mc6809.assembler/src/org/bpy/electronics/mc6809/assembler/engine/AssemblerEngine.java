package org.bpy.electronics.mc6809.assembler.engine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage;
import org.bpy.electronics.mc6809.assembler.assembler.BlankLine;
import org.bpy.electronics.mc6809.assembler.assembler.CommentLine;
import org.bpy.electronics.mc6809.assembler.assembler.DirectiveLine;
import org.bpy.electronics.mc6809.assembler.assembler.EquDirective;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.OrgDirective;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledCommentLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledEquDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AssembledOrgDirectiveLine;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.assembler.util.ExpressionParser;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorDescription;
import org.bpy.electronics.mc6809.assembler.validation.AssemblerErrorManager;
import org.eclipse.emf.ecore.EReference;

public class AssemblerEngine {
	private static final Logger logger = Logger.getLogger(AssemblerEngine.class.getSimpleName());
	
	public static final String DUPLICATE_LABEL = "duplicateLabel";
	
	private int currentPcValue;
	private int lineNumber;
	private List<AbstractAssemblyLine> assemblyLines;
	private static AssemblerEngine eInstance;
	
	private Map<String, AbstractAssemblyLine> labelsPositionObject;
	private Map<String, AbstractAssemblyLine> labelsEquSet;
	
	public AssemblerEngine() {
		clear();
	}

	public static AssemblerEngine getInstance() {
		if (eInstance == null) {
			eInstance = new AssemblerEngine();
		}
		return eInstance;
	}
	
	public void clear() {
		lineNumber = 1;
		currentPcValue = 0;
		assemblyLines = new ArrayList<>();
		AssemblerErrorManager.getInstance().clear();
		
		labelsPositionObject = new HashMap<>();
		labelsEquSet = new HashMap<>();
		
	}

	public int getCurrentPcValue() {
		return currentPcValue;
	}

	public Map<String, AbstractAssemblyLine> getLabelsPositionObject() {
		return labelsPositionObject;
	}

	public Map<String, AbstractAssemblyLine> getLabelsEquSet() {
		return labelsEquSet;
	}

	public void engine(Model model) {
		lineNumber = 1;
		currentPcValue = -1;
		assemblyLines = new ArrayList<>();

		AssemblerErrorManager.getInstance().clear();

		List<SourceLine> sourceLines = model.getSourceLines();
		for (SourceLine sourceLine : sourceLines) {
			if (sourceLine.getLineContent() instanceof BlankLine) {
				
			} else if (sourceLine.getLineContent() instanceof CommentLine commentLine) {
				parseCommentLine(commentLine);
				
			} else if (sourceLine.getLineContent() instanceof DirectiveLine directiveLine) {
				parseDirectiveLine(directiveLine);
			
			} else if (sourceLine.getLineContent() instanceof InstructionLine) {
				logger.log(Level.SEVERE,"Unknow directive {0}" + sourceLine.getLineContent().getClass().getSimpleName());
				
			} else {
				logger.log(Level.SEVERE,"Unknow directive {0}" + sourceLine.getLineContent().getClass().getSimpleName());
			}
			lineNumber++;
		}
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
	 */
	private void parseDirectiveLine(DirectiveLine directiveLine) {
		if (directiveLine.getDirective() instanceof OrgDirective orgDirective) {
			parseDirective(orgDirective);
		}else if (directiveLine.getDirective() instanceof EquDirective equDirective) {
				parseDirective(equDirective);
		} else {
			logger.log(Level.SEVERE,"Unknow directive {0}", directiveLine.getDirective().getClass().getSimpleName());
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
			AssemblerErrorDescription problemDescription = new AssemblerErrorDescription(
					"The label " + label + " for an EQU directive is already defined", 
					AssemblerPackage.Literals.DIRECTIVE_LINE__NAME,
					DUPLICATE_LABEL);
			AssemblerErrorManager.getInstance().addProblem(line.getDirective(), problemDescription );
		} else {
			labelsEquSet.put(label, line);
		}
	}

	private void parseDirective(OrgDirective directive) {
		int pcValue = ExpressionParser.parse(directive);
		currentPcValue = pcValue;
		
		AssembledOrgDirectiveLine line = new AssembledOrgDirectiveLine();
		line.parse(directive, currentPcValue, lineNumber);
		assemblyLines.add(line);

		registerLabelPosition(line, 
				"Label " + CommandUtil.getLabel(directive) + " is already defined",
				AssemblerPackage.Literals.DIRECTIVE_LINE__NAME);
	}

	private void registerLabelPosition(AssembledOrgDirectiveLine directive, String message, EReference reference) {
		if (directive.getLabel() != null) {
			if (labelsPositionObject.containsKey(directive.getLabel())) {
				AssemblerErrorDescription problemDescription = new AssemblerErrorDescription(message, 
						reference,
						DUPLICATE_LABEL);
				AssemblerErrorManager.getInstance().addProblem(directive.getDirective(), problemDescription );
			} else {
				labelsPositionObject.put(directive.getLabel(), directive);
			}
		}
	}

	public AbstractAssemblyLine getAssembledLine(int location) {
	  return assemblyLines.get(location);
	}
}
