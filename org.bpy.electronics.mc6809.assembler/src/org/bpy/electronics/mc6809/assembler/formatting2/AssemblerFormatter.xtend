/*
 * generated by Xtext 2.28.0
 */
package org.bpy.electronics.mc6809.assembler.formatting2

import com.google.inject.Inject
import org.bpy.electronics.mc6809.assembler.assembler.Model
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine
import org.bpy.electronics.mc6809.assembler.services.AssemblerGrammarAccess
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.bpy.electronics.mc6809.assembler.assembler.CommentLine
import org.bpy.electronics.mc6809.assembler.assembler.AssemblerPackage
import org.bpy.electronics.mc6809.preferences.core.PreferenceManager
import com.google.common.base.Strings
import org.bpy.electronics.mc6809.assembler.assembler.LabelLine
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine
import org.bpy.electronics.mc6809.assembler.assembler.BltInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BlsInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BloInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BleInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BitInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BhsInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BhiInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BgtInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BgeInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BeqInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BcsInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BccInstruction
import org.bpy.electronics.mc6809.assembler.assembler.AsrInstruction
import org.bpy.electronics.mc6809.assembler.assembler.AslInstruction
import org.bpy.electronics.mc6809.assembler.assembler.AndCCInstruction
import org.bpy.electronics.mc6809.assembler.assembler.AndInstruction
import org.bpy.electronics.mc6809.assembler.assembler.AdddInstruction
import org.bpy.electronics.mc6809.assembler.assembler.AdcInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BmiInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BneInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BplInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BraInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BrnInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BsrInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BvcInstruction
import org.bpy.electronics.mc6809.assembler.assembler.BvsInstruction
import org.bpy.electronics.mc6809.assembler.assembler.ClrInstruction
import org.bpy.electronics.mc6809.assembler.assembler.CmpInstruction
import org.bpy.electronics.mc6809.assembler.assembler.ComInstruction
import org.bpy.electronics.mc6809.assembler.assembler.CwaiInstruction
import org.bpy.electronics.mc6809.assembler.assembler.DaaInstruction
import org.bpy.electronics.mc6809.assembler.assembler.DecInstruction
import org.bpy.electronics.mc6809.assembler.assembler.EorInstruction
import org.bpy.electronics.mc6809.assembler.assembler.ExgInstruction
import org.bpy.electronics.mc6809.assembler.assembler.IncInstruction
import org.bpy.electronics.mc6809.assembler.assembler.JmpInstruction
import org.bpy.electronics.mc6809.assembler.assembler.JsrInstruction
import org.bpy.electronics.mc6809.assembler.assembler.LdInstruction
import org.bpy.electronics.mc6809.assembler.assembler.LeaInstruction
import org.bpy.electronics.mc6809.assembler.assembler.LslInstruction
import org.bpy.electronics.mc6809.assembler.assembler.LsrInstruction
import org.bpy.electronics.mc6809.assembler.assembler.MulInstruction
import org.bpy.electronics.mc6809.assembler.assembler.NegInstruction
import org.bpy.electronics.mc6809.assembler.assembler.NopInstruction
import org.bpy.electronics.mc6809.assembler.assembler.OrInstruction
import org.bpy.electronics.mc6809.assembler.assembler.OrCCInstruction
import org.bpy.electronics.mc6809.assembler.assembler.PshsInstruction
import org.bpy.electronics.mc6809.assembler.assembler.PshuInstruction
import org.bpy.electronics.mc6809.assembler.assembler.PulsInstruction
import org.bpy.electronics.mc6809.assembler.assembler.PuluInstruction
import org.bpy.electronics.mc6809.assembler.assembler.RolInstruction
import org.bpy.electronics.mc6809.assembler.assembler.RorInstruction
import org.bpy.electronics.mc6809.assembler.assembler.RtiInstruction
import org.bpy.electronics.mc6809.assembler.assembler.RtsInstruction
import org.bpy.electronics.mc6809.assembler.assembler.SbcInstruction
import org.bpy.electronics.mc6809.assembler.assembler.SexInstruction
import org.bpy.electronics.mc6809.assembler.assembler.StInstruction
import org.bpy.electronics.mc6809.assembler.assembler.SubInstruction
import org.bpy.electronics.mc6809.assembler.assembler.SubdInstruction
import org.bpy.electronics.mc6809.assembler.assembler.SwiInstruction
import org.bpy.electronics.mc6809.assembler.assembler.Swi2Instruction
import org.bpy.electronics.mc6809.assembler.assembler.Swi3Instruction
import org.bpy.electronics.mc6809.assembler.assembler.SyncInstruction
import org.bpy.electronics.mc6809.assembler.assembler.TfrInstruction
import org.bpy.electronics.mc6809.assembler.assembler.TstInstruction
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion
import org.eclipse.xtext.formatting2.IHiddenRegionFormatter
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1
import org.bpy.electronics.mc6809.assembler.assembler.Label

class AssemblerFormatter extends AbstractFormatter2 {

	/** Reference on grammar acces */
	@Inject extension AssemblerGrammarAccess

	/** Reference on the preference manager */
	PreferenceManager preferenceManager

	/** Current value of the tab policy */
	String tabPolicy

	/** Current value of the tab size */
	int tabSize

	/** Current column value of the instruction */
	int instructionPosition

	/** Current column value of the operand */
	int operandPosition

	/** Current column value of the comment */
	int commentPosition

	/**
	 * Allow to initialize the formatter.
	 * read formatter preference
	 * call formatter for all children of the model 
	 * 
	 */
	def dispatch void format(Model model, extension IFormattableDocument document) {
		preferenceManager = PreferenceManager.instance
		tabPolicy = preferenceManager.getStringPreferenceValue(PreferenceManager::TAB_POLICY)
		tabSize = preferenceManager.getIntPreferenceValue(PreferenceManager::TAB_SIZE)
		instructionPosition = preferenceManager.getIntPreferenceValue(PreferenceManager::INSTRUCTION_POSITION)
		operandPosition = preferenceManager.getIntPreferenceValue(PreferenceManager::OPERAND_POSITION)
		commentPosition = preferenceManager.getIntPreferenceValue(PreferenceManager::COMMENT_POSITION)

		for (sourceLine : model.sourceLines) {
			sourceLine.format
		}
	}

	/** 
	 * Call the formatter for a source line
	 */
	def dispatch void format(SourceLine sourceLine, extension IFormattableDocument document) {
		sourceLine.lineContent.format
	}

	/** 
	 * Call the formatter for a line which start with space and contains only a comment
	 */
	def dispatch void format(CommentLine commentLine, extension IFormattableDocument document) {
		if (commentLine.startingSpace !== null) {

			if (PreferenceManager::SPACE_ONLY == tabPolicy) {
				commentLine.formatSpaceOnly(document)

			} else if (PreferenceManager::TAB_ONLY == tabPolicy) {
				commentLine.formatTabOnly(document)

			} else {
				commentLine.formatMixed(document)

			}
		}
	}

	/**
	 * Format a comment line when the tab policy is Space only
	 */
	def private void formatSpaceOnly(CommentLine commentLine, extension IFormattableDocument document) {
		val fmt = document.formatter.createHiddenRegionFormatting => [it.space = " "]
		val replacer = commentLine.regionFor.feature(AssemblerPackage.Literals.COMMENT_LINE__STARTING_SPACE).
			createWhitespaceReplacer(fmt)
		document.addReplacer(replacer)

		val strPosition = Strings.repeat(' ', (commentPosition - 1) > 1 ? (commentPosition - 1) : 1)
		commentLine.regionFor.feature(AssemblerPackage.Literals.COMMENT_LINE__COMMENT).prepend [
			space = strPosition
		]
	}

	/**
	 * Format a comment line when the tab policy is Tab only
	 */
	def private void formatTabOnly(CommentLine commentLine, extension IFormattableDocument document) {
		val nbTabs = commentPosition / tabSize

		val fmt = document.formatter.createHiddenRegionFormatting => [it.space = "\t"]
		val replacer = commentLine.regionFor.feature(AssemblerPackage.Literals.COMMENT_LINE__STARTING_SPACE).
			createWhitespaceReplacer(fmt)
		document.addReplacer(replacer)

		val strPosition = Strings.repeat('\t', (nbTabs - 1) > 1 ? (nbTabs - 1) : 1)
		commentLine.regionFor.feature(AssemblerPackage.Literals.COMMENT_LINE__COMMENT).prepend [
			space = strPosition
		]
	}

	/**
	 * Format a comment line when the tab policy is a mixed of space and tab
	 */
	def private void formatMixed(CommentLine commentLine, extension IFormattableDocument document) {
		val nbTabs = commentPosition / tabSize
		val nbSpaces = commentPosition - (tabSize * nbTabs);

		val fmt = document.formatter.createHiddenRegionFormatting => [it.space = "\t"]
		val replacer = commentLine.regionFor.feature(AssemblerPackage.Literals.COMMENT_LINE__STARTING_SPACE).
			createWhitespaceReplacer(fmt)
		document.addReplacer(replacer)

		var strPosition = Strings.repeat('\t', (nbTabs - 1) > 1 ? (nbTabs - 1) : 1)
		if (nbSpaces !== 0) {
			strPosition += Strings.repeat(' ', nbSpaces)
		}

		val spaces = strPosition
		commentLine.regionFor.feature(AssemblerPackage.Literals.COMMENT_LINE__COMMENT).prepend [
			space = spaces
		]
	}

	/** 
	 * Call the formatter for a line which start with a label and contains only comments
	 */
	def dispatch void format(LabelLine labelLine, extension IFormattableDocument document) {
		if (labelLine.comment !== null) {

			if (PreferenceManager::SPACE_ONLY == tabPolicy) {
				labelLine.formatSpaceOnly(document)

			} else if (PreferenceManager::TAB_ONLY == tabPolicy) {
				labelLine.formatTabOnly(document)

			} else {
				labelLine.formatMixed(document)
			}
		}
	}

	def private void formatMixed(LabelLine labelLine, extension IFormattableDocument document) {
	}

	def private void formatTabOnly(LabelLine labelLine, extension IFormattableDocument document) {
		var wsSpace = 0
		if (labelLine.ws1 !== null) {
			val fmt = document.formatter.createHiddenRegionFormatting => [it.space = " "]
			val replacer = labelLine.regionFor.feature(AssemblerPackage.Literals.LABEL_LINE__WS1).
				createWhitespaceReplacer(fmt)
			document.addReplacer(replacer)
			wsSpace = 1
		}

		var labelLength = labelLine.label.name.value.length + wsSpace
		if (labelLine.label.point) {
			labelLength++
		}
		val strPosition = Strings.repeat(' ', commentPosition - labelLength - 1)
		labelLine.regionFor.feature(AssemblerPackage.Literals.LABEL_LINE__COMMENT).prepend[space = strPosition]
	}

	def private void formatSpaceOnly(LabelLine labelLine, extension IFormattableDocument document) {
		var wsSpace = 0
		if (labelLine.ws1 !== null) {
			val fmt = document.formatter.createHiddenRegionFormatting => [it.space = " "]
			val replacer = labelLine.regionFor.feature(AssemblerPackage.Literals.LABEL_LINE__WS1).
				createWhitespaceReplacer(fmt)
			document.addReplacer(replacer)
			wsSpace = 1
		}

		var labelLength = labelLine.label.name.value.length + wsSpace
		if (labelLine.label.point) {
			labelLength++
		}
		val strPosition = Strings.repeat(' ', commentPosition - labelLength - 1)
		labelLine.regionFor.feature(AssemblerPackage.Literals.LABEL_LINE__COMMENT).prepend[space = strPosition]
	}

	def dispatch void format(InstructionLine instructionLine, extension IFormattableDocument document) {
		if (PreferenceManager::SPACE_ONLY == tabPolicy) {
			instructionLine.formatSpaceOnly(document)

		} else if (PreferenceManager::TAB_ONLY == tabPolicy) {
			instructionLine.formatTabOnly(document)

		} else if (PreferenceManager::MIXED == tabPolicy) {
			instructionLine.formatMixed(document)

		}
	}

	/**
	 * Format an instructionLine Object when the tab policy is Space only
	 * 
	 */
	def private void formatSpaceOnly(InstructionLine instructionLine, extension IFormattableDocument document) {
		val fmt = document.formatter.createHiddenRegionFormatting => [it.space = ' ']
		val replacer1 = instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS1).
			createWhitespaceReplacer(fmt)
		document.addReplacer(replacer1)

		if (instructionLine.ws2 !== null) {
			val replacer2 = instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS2).
				createWhitespaceReplacer(fmt)
			if (replacer2 !== null) {
				document.addReplacer(replacer2)
			}
		}

		var labelLength = 0;
		if (instructionLine.label.name !== null) {
			labelLength = instructionLine.label.name.value.length
			if (instructionLine.label.point) {
				labelLength++
			}
			labelLength++
		}
		val spacesBeforeInstruction = Strings.repeat(' ', instructionPosition - labelLength - 1)
		instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS1).append [
			space = spacesBeforeInstruction
		]

		instructionLine.instruction.format

		if (instructionLine.ws2 !== null) {
			val lastNodeInstruction = instructionLine.regionFor.feature(
				AssemblerPackage.Literals.INSTRUCTION_LINE__WS2).previousSemanticRegion
			var firstNodeInstruction = instructionLine.regionFor.feature(
				AssemblerPackage.Literals.INSTRUCTION_LINE__WS1).nextSemanticRegion

			var nbSpaces = 0
			if (firstNodeInstruction === lastNodeInstruction) {
				nbSpaces = commentPosition - firstNodeInstruction.text.trim.length - (instructionPosition) - 1
			} else {
				nbSpaces = commentPosition - lastNodeInstruction.text.trim.length - (operandPosition) - 2
			}
			val spacesAfterInstruction = Strings.repeat(' ', nbSpaces)
			instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS2).append [
				space = spacesAfterInstruction
			]
		}
	}

	/**
	 * Format an instructionLine Object when the tab policy is Space only
	 * 
	 */
	def private void formatTabOnly(InstructionLine instructionLine, extension IFormattableDocument document) {
		val fmt1 = document.formatter.createHiddenRegionFormatting => [it.space = '\t']
		val replacer1 = instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS1).
			createWhitespaceReplacer(fmt1)
		document.addReplacer(replacer1)

		if (instructionLine.ws2 !== null) {
			val fmt2 = document.formatter.createHiddenRegionFormatting => [it.space = '\t']
			val replacer2 = instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS2).
				createWhitespaceReplacer(fmt2)
			if (replacer2 !== null) {
				document.addReplacer(replacer2)
			}
		}

		var labelLength = 0;
		if (instructionLine.label.name !== null) {
			labelLength = instructionLine.label.name.value.trim.length
			if (instructionLine.label.point) {
				labelLength++
			}
		}

		val estimatedPosition = labelLength + tabSize;
		val labelEndPosition = (estimatedPosition % tabSize == 0 ? estimatedPosition : (estimatedPosition / tabSize) * tabSize)
		var nbTabNeeded = (instructionPosition - labelEndPosition) / tabSize
		if (instructionLine.label.name === null) {
			nbTabNeeded++
		}

		val tabsBeforeInstruction = Strings.repeat('\t', nbTabNeeded)
		instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS1).append [
			space = tabsBeforeInstruction
		]

		instructionLine.instruction.format

		if (instructionLine.ws2 !== null) {
			val lastNodeInstruction = instructionLine.regionFor.feature(
				AssemblerPackage.Literals.INSTRUCTION_LINE__WS2).previousSemanticRegion
			var firstNodeInstruction = instructionLine.regionFor.feature(
				AssemblerPackage.Literals.INSTRUCTION_LINE__WS1).nextSemanticRegion

			var nbTabs = 0
			if (firstNodeInstruction === lastNodeInstruction) {
				nbTabs = (commentPosition - firstNodeInstruction.text.trim.length - (instructionPosition) - 1) / tabSize
			} else {
				nbTabs = (commentPosition - lastNodeInstruction.text.trim.length - (operandPosition) - 2) / tabSize
			}
			val spacesAfterInstruction = Strings.repeat('\t', nbTabs)
			instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS2).append [
				space = spacesAfterInstruction
			]
		}
	}

	/**
	 * Format an instructionLine Object when the tab policy is Space only
	 * 
	 */
	def private void formatMixed(InstructionLine instructionLine, extension IFormattableDocument document) {

		val labelLength = instructionLine.label.length()
		val nbSpacesNeeded = instructionPosition - labelLength-1
		if (nbSpacesNeeded < 1 ) {
			val fmt1 = document.formatter.createHiddenRegionFormatting => [it.space = '\t']
			val replacer1 = instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS1).
				createWhitespaceReplacer(fmt1)
			document.addReplacer(replacer1)

		} else	if (nbSpacesNeeded < tabSize) {
			val fmt1 = document.formatter.createHiddenRegionFormatting => [it.space = '\t']
			val replacer1 = instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS1).
				createWhitespaceReplacer(fmt1)
			document.addReplacer(replacer1)

			val spaceNeeded = Strings.repeat('\t', (nbSpacesNeeded-tabSize)/tabSize)
			instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS1).append [
				space = spaceNeeded
			]
			
		} else {
			val fmt1 = document.formatter.createHiddenRegionFormatting => [it.space = '\t']
			val replacer1 = instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS1).createWhitespaceReplacer(fmt1)
			document.addReplacer(replacer1)

			val estimatedPosition = (labelLength == 0 ? 0 :labelLength + tabSize);
			val labelEndPosition = (estimatedPosition % tabSize == 0 ? estimatedPosition : (estimatedPosition / tabSize) * tabSize)
	
			val tabsToInsert = Strings.repeat('\t', (instructionPosition-labelEndPosition) / tabSize);
			val rest = (instructionPosition-labelEndPosition-1) % tabSize
			if (rest !== 0) {
				val spacesToInsert = Strings.repeat(' ', rest);
				instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS1).append [
					space = tabsToInsert + spacesToInsert
				]
			} else {
				instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS1).append [
					space = tabsToInsert
				]
			}
		}

		instructionLine.instruction.format
		
		if (instructionLine.ws2 !== null) {
			// a comment is defined
			val lastNodeInstruction = instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS2).previousSemanticRegion
			val firstNodeInstruction = instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS1).nextSemanticRegion
			
			var nbSpacesToComplete = 0; 
			if (lastNodeInstruction == firstNodeInstruction) {
				nbSpacesToComplete = commentPosition - firstNodeInstruction.text.trim.length - instructionPosition 
			} else {
				nbSpacesToComplete = commentPosition - lastNodeInstruction.text.trim.length - operandPosition 
			}
			
			if (nbSpacesToComplete < tabSize) {
				val fmt2 = document.formatter.createHiddenRegionFormatting => [it.space = ' ']
				val replacer2 = instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS2).createWhitespaceReplacer(fmt2)
				document.addReplacer(replacer2)
				nbSpacesToComplete--
				
				val spaceNeeded = Strings.repeat(' ', nbSpacesToComplete)
				instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS1).append [
					space = spaceNeeded
				]
				
			} else {
				val fmt2 = document.formatter.createHiddenRegionFormatting => [it.space = '\t']
				val replacer2 = instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS2).createWhitespaceReplacer(fmt2)
				document.addReplacer(replacer2)

				var estimatedPosition = 0
				if (lastNodeInstruction == firstNodeInstruction) {
					estimatedPosition = instructionPosition + firstNodeInstruction.text.trim.length + tabSize 
				} else {
					estimatedPosition = operandPosition + lastNodeInstruction.text.trim.length + tabSize 
				}
				
				val realInstructionPosition = (estimatedPosition % tabSize == 0 ? estimatedPosition : (estimatedPosition /	tabSize) * tabSize)
				val leftSapces = commentPosition - realInstructionPosition -1

				val tabsToInsert = Strings.repeat('\t', leftSapces / tabSize);
				val rest = leftSapces % tabSize
				if (rest !== 0) {
					val spacesToInsert = Strings.repeat(' ', rest);
					instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS2).append [
						space = tabsToInsert + spacesToInsert
					]
				} else {
					instructionLine.regionFor.feature(AssemblerPackage.Literals.INSTRUCTION_LINE__WS2).append [
						space = tabsToInsert
					]
				}
			} 
		}
	}

	/**
	 * Format an Adc instruction Object
	 * 
	 */
	def dispatch void format(AdcInstruction instruction, extension IFormattableDocument document) {
		if (PreferenceManager::SPACE_ONLY == tabPolicy) {
			document.formatSpaceOnlyInstruction(
				instruction.regionFor.feature(AssemblerPackage.Literals.ADC_INSTRUCTION__WS_OPERAND),
				instruction.instruction.length)

		} else if (PreferenceManager::TAB_ONLY == tabPolicy) {
			document.formatTabOnlyInstruction(
				instruction.regionFor.feature(AssemblerPackage.Literals.ADC_INSTRUCTION__WS_OPERAND),
				instruction.instruction.length)

		} else {
			document.formatMixedInstruction(
				instruction.regionFor.feature(AssemblerPackage.Literals.ADC_INSTRUCTION__WS_OPERAND),
				instruction.instruction.length)
		}
	}

	/**
	 * Allow to format the space between the instruction and the operand in case of tab policy 
	 * based on the space only policy
	 */
	def void formatSpaceOnlyInstruction(IFormattableDocument document, ISemanticRegion region, int instructionSize) {
		val fmt = document.formatter.createHiddenRegionFormatting => [it.space = ' ']
		val replacer1 = region.createWhitespaceReplacer(fmt)
		document.addReplacer(replacer1)

		var nbSpacesNeeded = operandPosition
		nbSpacesNeeded -= instructionSize
		nbSpacesNeeded -= instructionPosition

		val spacesAfterInstruction = Strings.repeat(' ', nbSpacesNeeded - 1)
		val Procedure1<IHiddenRegionFormatter> function = [
			it.space = spacesAfterInstruction
		]
		document.append(region, function)
	}

	/**
	 * Allow to format the space between the instruction and the operand in case of tab policy 
	 * based on the tab only policy
	 */
	def void formatTabOnlyInstruction(IFormattableDocument document, ISemanticRegion region, int instructionSize) {
		val fmt = document.formatter.createHiddenRegionFormatting => [it.space = '\t']
		val replacer1 = region.createWhitespaceReplacer(fmt)
		document.addReplacer(replacer1)

		val estimatedPosition = instructionPosition + instructionSize + tabSize;
		val realInstructionPosition = (estimatedPosition % tabSize == 0 ? estimatedPosition : (estimatedPosition /	tabSize) * tabSize)
		var nbTabNeeded = (operandPosition - realInstructionPosition) / tabSize

		val spacesAfterInstruction = Strings.repeat('\t', nbTabNeeded)
		val Procedure1<IHiddenRegionFormatter> function = [
			it.space = spacesAfterInstruction
		]
		document.append(region, function)
	}

	/**
	 * Allow to format the space between the instruction and the operand in case of tab policy 
	 * based on the mixed policy
	 */
	def void formatMixedInstruction(IFormattableDocument document, ISemanticRegion region, int instructionSize) {
		val nbSapcesToFill = operandPosition - instructionPosition - instructionSize
		
		if (nbSapcesToFill < 1) {
			val fmt = document.formatter.createHiddenRegionFormatting => [it.space = ' ']
			val replacer1 = region.createWhitespaceReplacer(fmt)
			document.addReplacer(replacer1)
		}

		if (nbSapcesToFill < tabSize) {
			val fmt = document.formatter.createHiddenRegionFormatting => [it.space = ' ']
			val replacer1 = region.createWhitespaceReplacer(fmt)
			document.addReplacer(replacer1)
			
			val spacesAfterInstruction = Strings.repeat(' ', nbSapcesToFill-1)
			val Procedure1<IHiddenRegionFormatter> function = [
				it.space = spacesAfterInstruction
			]
			document.append(region, function)
		
		} else {
			val fmt = document.formatter.createHiddenRegionFormatting => [it.space = '\t']
			val replacer1 = region.createWhitespaceReplacer(fmt)
			document.addReplacer(replacer1)
			
			val estimatedPosition = instructionPosition + instructionSize + tabSize;
			val realInstructionPosition = (estimatedPosition % tabSize == 0 ? estimatedPosition : (estimatedPosition /	tabSize) * tabSize)
			val leftSapces = operandPosition - realInstructionPosition -1
			
			val tabsAfterInstruction = Strings.repeat('\t', leftSapces/tabSize)
			val spacesAfterTabs = Strings.repeat(' ', leftSapces%tabSize)
			val Procedure1<IHiddenRegionFormatter> function = [
				it.space = tabsAfterInstruction + spacesAfterTabs
			]
			document.append(region, function)
		}
	}

	def dispatch void format(AdddInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(AndInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(AndCCInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(AslInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(AsrInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BccInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BcsInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BeqInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BgeInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BgtInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BhiInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BhsInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BitInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BleInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BloInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BlsInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BltInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BmiInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BneInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BplInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BraInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BrnInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BsrInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BvcInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(BvsInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(ClrInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(CmpInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(ComInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(CwaiInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(DaaInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(DecInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(EorInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(ExgInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(IncInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(JmpInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(JsrInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(LdInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(LeaInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(LslInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(LsrInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(MulInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(NegInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(NopInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(OrInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(OrCCInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(PshsInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(PshuInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(PulsInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(PuluInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(RolInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(RorInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(RtiInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(RtsInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(SbcInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(SexInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(StInstruction instruction, extension IFormattableDocument document) {
		println("ST")
	}

	def dispatch void format(SubInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(SubdInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(SwiInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(Swi2Instruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(Swi3Instruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(SyncInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(TfrInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def dispatch void format(TstInstruction instruction, extension IFormattableDocument document) {
		println("ABX")
	}

	def int length(Label label) {
		var labelLength = 0;
		if (label.name !== null) {
			labelLength = label.name.value.trim.length
			if (label.point) {
				labelLength++
			}
		}
		labelLength
	}


// TODO: implement for InstructionLine, TstInstruction, SubdInstruction, SubInstruction, StInstruction, SbcInstruction, RorInstruction, RolInstruction, PuluInstruction, PulsInstruction, PshuInstruction, PshsInstruction, OrCCInstruction, OrInstruction, NegInstruction, LsrInstruction, LslInstruction, LeaInstruction, LdInstruction, JsrInstruction, JmpInstruction, IncInstruction, EorInstruction, DecInstruction, CwaiInstruction, ComInstruction, CmpInstruction, ClrInstruction, BvsInstruction, BvcInstruction, BsrInstruction, BrnInstruction, BraInstruction, BplInstruction, BneInstruction, BmiInstruction, BltInstruction, BlsInstruction, BloInstruction, BleInstruction, BitInstruction, BhsInstruction, BhiInstruction, BgtInstruction, BgeInstruction, BeqInstruction, BcsInstruction, BccInstruction, AsrInstruction, AslInstruction, AndCCInstruction, AndInstruction, AdddInstruction, AddInstruction, AdcInstruction, ExtendedIndirectOperand, ExtendedOperand, DirectOperand, ImmediatOperand, IndexedOperand, ConstantIndexedMode, ConstantIndexedMovingIndirectMode, RelatifToPCMode, RelatifToPCIndirectMode, RelativeMode, DirectiveLine, SetDPDirective, SpcDirective, NamDirective, PagDirective, SetDirective, FillDirective, BszDirective, FdbDirective, FcbDirective, RmbDirective, EndDirective, OrgDirective, EquDirective, ListOfExpression, CommaExpression, Expression, Multiplication, Division, Modulo, Addition, Substraction, LeftShift, RightShift, And, Or, Xor, Not, NumericalValue
}
