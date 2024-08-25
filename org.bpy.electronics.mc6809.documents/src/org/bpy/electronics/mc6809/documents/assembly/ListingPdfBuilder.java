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
package org.bpy.electronics.mc6809.documents.assembly;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.electronics.mc6809.assembler.AssemblerStandaloneSetup;
import org.bpy.electronics.mc6809.assembler.assembler.AssemblyOption;
import org.bpy.electronics.mc6809.assembler.assembler.CommaExpression;
import org.bpy.electronics.mc6809.assembler.assembler.FcbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FccDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FdbDirective;
import org.bpy.electronics.mc6809.assembler.assembler.FillDirective;
import org.bpy.electronics.mc6809.assembler.assembler.InstructionLine;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.OptDirective;
import org.bpy.electronics.mc6809.assembler.assembler.RegDirective;
import org.bpy.electronics.mc6809.assembler.assembler.Register;
import org.bpy.electronics.mc6809.assembler.assembler.SpcDirective;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerManager;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.comment.AssembledBlankLine;
import org.bpy.electronics.mc6809.assembler.engine.data.comment.AssembledCommentLine;
import org.bpy.electronics.mc6809.assembler.engine.data.comment.AssembledLabelLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AbstractAssembledDirectiveLine;
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
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.others.MacroAssembledElement;
import org.bpy.electronics.mc6809.assembler.engine.data.others.MacroDeclarationElement;
import org.bpy.electronics.mc6809.assembler.util.CommandUtil;
import org.bpy.electronics.mc6809.preferences.core.PreferenceManager;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.xbase.lib.Extension;

import com.google.common.base.Strings;
import com.google.inject.Inject;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Create a pdf file which contains the result of an assembly file.
 * 
 * @author Patrick BRIAND
 *
 */
public class ListingPdfBuilder {

	/** Logger of the class */
	private static final Logger logger = Logger.getLogger(ListingPdfBuilder.class.getSimpleName());

	/** reference on the IText document */
	private Document document;
	/** reference on the IText writer */
	private PdfWriter writer;

	/** Reference on the XTEXT serializer */
	@Inject
	@Extension
	private ISerializer serializer;

	private Font documentFont;

	/**
	 * Constructor of the class. Initiate the injection
	 */
	public ListingPdfBuilder() {
		com.google.inject.Injector injector = new AssemblerStandaloneSetup().createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
	}

	/**
	 * Entry point of the PDF generation.
	 * 
	 * @param pdfFile reference on the generated file
	 * @param model   reference on the model
	 */
	public void build(File pdfFile, Model model) {
		document = new Document();
		if ("Landscape".equals(PreferenceManager.getInstance().getListingPageOrientation())) {
			document.setPageSize(PageSize.A4.rotate());
		} else {
			document.setPageSize(PageSize.A4);
		}
		document.setMargins(36, 36, 50, 50);
		document.setMarginMirroring(true);

		try {
			writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
			document.open();
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(model, false);
			fillDocument(engine);
			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}

	private void fillDocument(AssemblerEngine engine) throws DocumentException {
		List<AbstractAssemblyLine> assembledLines = engine.getAssembledLine();

		documentFont = new Font(FontFamily.COURIER, 8);
//		PdfContentByte canvas = writer.getDirectContentUnder(); 
//		canvas.setFontAndSize(documentFont.getBaseFont(), 12);

		for (AbstractAssemblyLine sourceLine : assembledLines) {
			writeSourceLine(sourceLine);
		}
		document.close();
	}

	/**
	 * Write an abstract assembly line in the PDF document.
	 * 
	 * @param sourceLine reference on the abstract assembly line
	 * @throws DocumentException
	 */
	private void writeSourceLine(AbstractAssemblyLine sourceLine) throws DocumentException {
		if (sourceLine instanceof AssembledBlankLine blankLine) {
			writeSourceLine(blankLine);
		} else if (sourceLine instanceof AssembledCommentLine commentLine) {
			writeSourceLine(commentLine);
		} else if (sourceLine instanceof AssembledLabelLine labelLine) {
			writeSourceLine(labelLine);
		} else if (sourceLine instanceof AbstractInstructionAssemblyLine instructionLine) {
			writeSourceLine(instructionLine);
		} else if (sourceLine instanceof MacroDeclarationElement macroDeclaration) {
			writeSourceLine(macroDeclaration);
		} else if (sourceLine instanceof MacroAssembledElement assembledMacro) {
			writeSourceLine(assembledMacro);
		} else if (sourceLine instanceof AbstractAssembledDirectiveLine directiveLine) {
			writeSourceLine(directiveLine);
		}
	}

	/**
	 * Write an instruction line in the PDF document
	 * 
	 * @param instructionLine reference on the instruction line
	 * @throws DocumentException
	 */
	private void writeSourceLine(AbstractAssembledDirectiveLine directiveLine) throws DocumentException {
		StringBuilder builder = new StringBuilder();
		builder.append(setLineNumber(directiveLine.getLineNumber()));
		if (directiveLine.canDisplayPcAddress()) {
			builder.append(setPcAddress(directiveLine.getPcAddress()));
		} else {
			builder.append(setPcAddress(-1));
		}
		List<String> extrasBytes = new ArrayList<>();
		builder.append(setDirectiveOperand(directiveLine, extrasBytes));
		builder.append(setLabel(directiveLine.getLabel()));
		builder.append(setInstructionName(directiveLine.getDirectiveName()));
		builder.append(getOperand(directiveLine));
		builder.append(setComment(directiveLine.getComment()));

		builder.append("\n");
		Chunk line = new Chunk(builder.toString(), documentFont);
		document.add(new Paragraph(line));

		for (String extraLine : extrasBytes) {
			Chunk extraChunk = new Chunk(extraLine, documentFont);
			document.add(new Paragraph(extraChunk));
		}
	}

	private String getOperand(AbstractAssembledDirectiveLine directiveLine) {
		if (directiveLine instanceof AssembledBszDirectiveLine line) {
			return setInstructionOperand(line.getDirective().getOperand());
		} else if (directiveLine instanceof AssembledEndDirectiveLine line) {
			return setInstructionOperand(line.getDirective().getOperand());
		} else if (directiveLine instanceof AssembledEquDirectiveLine line) {
			return setInstructionOperand(line.getDirective().getOperand());
		} else if (directiveLine instanceof AssembledFailDirectiveLine) {
			return setInstructionOperand(null);
		} else if (directiveLine instanceof AssembledFcbDirectiveLine line) {
			return setFcbOperand(line.getDirective());
		} else if (directiveLine instanceof AssembledFccDirectiveLine line) {
			return setFccOperand(line.getDirective());
		} else if (directiveLine instanceof AssembledFdbDirectiveLine line) {
			return setFdbOperand(line.getDirective());
		} else if (directiveLine instanceof AssembledFillDirectiveLine line) {
			return setFillOperand(line.getDirective());
		} else if (directiveLine instanceof AssembledNamDirectiveLine line) {
			return setInstructionOperand(line.getDirective().getOperand());
		} else if (directiveLine instanceof AssembledOptDirectiveLine line) {
			return setOptOperand(line.getDirective());
		} else if (directiveLine instanceof AssembledOrgDirectiveLine line) {
			return setInstructionOperand(line.getDirective().getOperand());
		} else if (directiveLine instanceof AssembledPagDirectiveLine line) {
			return setInstructionOperand(line.getDirective().getOperand());
		} else if (directiveLine instanceof AssembledRegDirectiveLine line) {
			return setRegOperand(line.getDirective());
		} else if (directiveLine instanceof AssembledRmbDirectiveLine line) {
			return setInstructionOperand(line.getDirective().getOperand());
		} else if (directiveLine instanceof AssembledSetDirectiveLine line) {
			return setInstructionOperand(line.getDirective().getOperand());
		} else if (directiveLine instanceof AssembledSetDPDirectiveLine line) {
			return setInstructionOperand(line.getDirective().getOperand());
		} else if (directiveLine instanceof AssembledSpcDirectiveLine line) {
			return setSpcOperand(line.getDirective());
		}
		return null;
	}

	private String setFcbOperand(FcbDirective directive) {
		StringBuilder strBuilder = new StringBuilder();
		if (directive.getOperand() != null) {
			String expressionRepresentation = serializer.serialize(directive.getOperand());
			strBuilder.append(expressionRepresentation);
		}
		fillWithMisisingSpace(strBuilder, PreferenceManager.getInstance().getListingOperandInstructionSize());
		return strBuilder.toString();
	}

	private String setFccOperand(FccDirective directive) {
		StringBuilder strBuilder = new StringBuilder();
		for (EObject parameter : directive.getParameters()) {
			String representation = serializer.serialize(parameter);
			if (!strBuilder.isEmpty()) {
				strBuilder.append(',');
			}
			strBuilder.append(representation);
		}
		fillWithMisisingSpace(strBuilder, PreferenceManager.getInstance().getListingOperandInstructionSize());
		return strBuilder.toString();
	}

	private String setFdbOperand(FdbDirective directive) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(serializer.serialize(directive.getOperand()).replace(" ", ""));
		fillWithMisisingSpace(strBuilder, PreferenceManager.getInstance().getListingOperandInstructionSize());
		return strBuilder.toString();
	}

	private String setFillOperand(FillDirective directive) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(serializer.serialize(directive.getValue()).replace(" ", ""));
		strBuilder.append(",");
		strBuilder.append(serializer.serialize(directive.getNumber()).replace(" ", ""));

		fillWithMisisingSpace(strBuilder, PreferenceManager.getInstance().getListingOperandInstructionSize());
		return strBuilder.toString();
	}

	private String setOptOperand(OptDirective directive) {
		StringBuilder strBuilder = new StringBuilder();
		for (AssemblyOption option : directive.getOptions()) {
			if (!strBuilder.isEmpty()) {
				strBuilder.append(",");
			}
			strBuilder.append(option.getLiteral());
		}
		fillWithMisisingSpace(strBuilder, PreferenceManager.getInstance().getListingOperandInstructionSize());
		return strBuilder.toString();
	}

	private String setRegOperand(RegDirective directive) {
		StringBuilder strBuilder = new StringBuilder();
		for (Register register : directive.getOptions()) {
			if (!strBuilder.isEmpty()) {
				strBuilder.append(",");
			}
			strBuilder.append(register.getLiteral());
		}

		fillWithMisisingSpace(strBuilder, PreferenceManager.getInstance().getListingOperandInstructionSize());
		return strBuilder.toString();
	}

	private String setSpcOperand(SpcDirective directive) {
		StringBuilder strBuilder = new StringBuilder();
		strBuilder.append(serializer.serialize(directive.getSpaceCount()).replace(" ", ""));
		strBuilder.append(",");
		strBuilder.append(serializer.serialize(directive.getKeepCount()).replace(" ", ""));

		fillWithMisisingSpace(strBuilder, PreferenceManager.getInstance().getListingOperandInstructionSize());
		return strBuilder.toString();
	}

	/**
	 * Write a macro call in the PDF document.
	 * 
	 * @param macrodeclaration reference on the macro declaration line
	 * @throws DocumentException
	 */
	private void writeSourceLine(MacroAssembledElement assembledMacro) throws DocumentException {
		for (AbstractAssemblyLine macroLine : assembledMacro.getAssemblyLines()) {
			writeSourceLine(macroLine);
		}
	}

	/**
	 * Write a macro declaration line in the PDF document
	 * 
	 * @param macrodeclaration reference on the macro declaration line
	 * @throws DocumentException
	 */
	private void writeSourceLine(MacroDeclarationElement macroDeclaration) throws DocumentException {
		StringBuilder builder = new StringBuilder();
		int lineNumber = macroDeclaration.getLineNumber();
		builder.append(setLineNumber(lineNumber));
		builder.append(setPcAddress(-1));
		builder.append(setOpcode(null));
		builder.append(setOperand(null));
		builder.append(setLabel(null));
		builder.append(setInstructionName(".macro"));
		builder.append(setMacroName(macroDeclaration.getMacroDefinition().getName().getValue()));
		builder.append(setComment(macroDeclaration.getComment()));

		builder.append("\n");
		Chunk line = new Chunk(builder.toString(), documentFont);
		document.add(new Paragraph(line));

		for (InstructionLine macroContent : macroDeclaration.getMacroDefinition().getInstructions()) {
			writeSourceLine(macroContent);
		}

		builder = new StringBuilder();
		builder.append(setLineNumber(-1));
		builder.append(setPcAddress(-1));
		builder.append(setOpcode(null));
		builder.append(setOperand(null));
		builder.append(setLabel(null));
		builder.append(setInstructionName(".endm"));
		builder.append(setInstructionOperand(null));
		builder.append(setComment(macroDeclaration.getComment()));
		builder.append("\n");
		line = new Chunk(builder.toString(), documentFont);
		document.add(new Paragraph(line));
	}

	/**
	 * Write an instruction line in the PDF document
	 * 
	 * @param instructionLine reference on the instruction line
	 * @throws DocumentException
	 */
	private void writeSourceLine(InstructionLine instructionLine) throws DocumentException {
		StringBuilder builder = new StringBuilder();
		builder.append(setLineNumber(-1));
		builder.append(setPcAddress(-1));
		builder.append(setOpcode(null));
		builder.append(setOperand(null));
		if (instructionLine.getLabel() != null && instructionLine.getLabel().getName() != null) {
			builder.append(setLabel(instructionLine.getLabel().getName().getValue()));
		} else {
			builder.append(setLabel(null));
		}
		builder.append(setInstructionName(CommandUtil.getInstructionName(instructionLine.getInstruction())));
		builder.append(setInstructionOperand(CommandUtil.getOperand(instructionLine)));
		builder.append(setComment(instructionLine.getComment()));

		builder.append("\n");
		Chunk line = new Chunk(builder.toString(), documentFont);
		document.add(new Paragraph(line));
	}

	/**
	 * Write an assembled instruction line in the PDF document
	 * 
	 * @param instructionLine reference on the instruction line
	 * @throws DocumentException
	 */
	private void writeSourceLine(AbstractInstructionAssemblyLine instructionLine) throws DocumentException {
		StringBuilder builder = new StringBuilder();
		builder.append(setLineNumber(instructionLine.getLineNumber()));
		builder.append(setPcAddress(instructionLine.getPcAddress()));
		builder.append(setOpcode(instructionLine.getOpcode()));
		builder.append(setOperand(instructionLine.getOperand()));
		builder.append(setLabel(instructionLine.getLabel()));
		builder.append(setInstructionName(instructionLine.getInstructionName()));
		builder.append(setInstructionOperand(instructionLine.getInstructionOperand()));
		builder.append(setComment(instructionLine.getComment()));

		builder.append("\n");
		Chunk line = new Chunk(builder.toString(), documentFont);
		document.add(new Paragraph(line));
	}

	/**
	 * Write a label line in the PDF document
	 * 
	 * @param labelLine reference on the label line
	 * @throws DocumentException
	 */
	private void writeSourceLine(AssembledLabelLine labelLine) throws DocumentException {
		StringBuilder builder = new StringBuilder();
		builder.append(setLineNumber(labelLine.getLineNumber()));
		builder.append(setPcAddress(-1));
		builder.append(setOpcode(null));
		builder.append(setOperand(null));
		builder.append(setLabel(labelLine.getLabel()));

		if (labelLine.getComment() != null) {
			builder.append(setInstructionName(""));
			builder.append(setInstructionOperand(null));
			builder.append(setComment(labelLine.getComment()));
		}

		builder.append("\n");
		Chunk line = new Chunk(builder.toString(), documentFont);
		document.add(new Paragraph(line));
	}

	/**
	 * Write a comment line in the PDF document
	 * 
	 * @param blankLine reference on the blank line
	 * @throws DocumentException
	 */
	private void writeSourceLine(AssembledCommentLine commentLine) throws DocumentException {
		StringBuilder builder = new StringBuilder();
		builder.append(setLineNumber(commentLine.getLineNumber()));
		builder.append(setPcAddress(-1));
		builder.append(setOpcode(null));
		builder.append(setOperand(null));
		if (commentLine.isSpaceBefore()) {
			builder.append(setLabel(null));
			if (!PreferenceManager.getInstance().getCommentLineAtInstructionPosition()) {
				builder.append(setInstructionName(""));
				builder.append(setInstructionOperand(null));
			}
		}
		builder.append(setComment(commentLine.getComment()));

		builder.append("\n");
		Chunk line = new Chunk(builder.toString(), documentFont);
		document.add(new Paragraph(line));
	}

	/**
	 * Write a blank line in the PDF document
	 * 
	 * @param blankLine reference on the blank line
	 * @throws DocumentException
	 */
	private void writeSourceLine(AssembledBlankLine blankLine) throws DocumentException {
		StringBuilder builder = new StringBuilder();
		builder.append(setLineNumber(blankLine.getLineNumber()));

		builder.append("\n");
		Chunk line = new Chunk(builder.toString(), documentFont);
		document.add(new Paragraph(line));
	}

	/**
	 * get a string which represent the directive operand.
	 * 
	 * @param directiveLine reference on the directive line
	 * @param extrasBytes   List which contains extra bytes to display
	 * 
	 * @return A string which represent the operand
	 */
	private String setDirectiveOperand(AbstractAssembledDirectiveLine directiveLine, List<String> extrasBytes) {
		StringBuilder builder = new StringBuilder();

		int availableSpace = PreferenceManager.getInstance().getListingOpcodeSize() + PreferenceManager.getInstance().getListingOperandSize()
				+ 1;

		int nbBytesMax = (directiveLine instanceof AssembledFdbDirectiveLine) ? availableSpace / 4 : availableSpace / 2;
		String format = (directiveLine instanceof AssembledFdbDirectiveLine) ? "%04X" : "%02X";

		int[] values = getValues(directiveLine);
		if (values.length > 0) {
			int offset = 0;
			while (offset < values.length) {

				if (offset < nbBytesMax) {
					offset = consumedByteOperand(values, offset, nbBytesMax, format, builder);
				} else {
					StringBuilder extraBuilder = new StringBuilder();
					extraBuilder.append(Strings.repeat(" ", PreferenceManager.getInstance().getListingLineNumberSize() + 1));
					extraBuilder.append(Strings.repeat(" ", PreferenceManager.getInstance().getListingAddressSize() + 1));
					offset = consumedByteOperand(values, offset, nbBytesMax, format, extraBuilder);
					extraBuilder.append("\n");
					extrasBytes.add(extraBuilder.toString());
				}
			}
		}
		fillWithMisisingSpace(builder, availableSpace + 1);
		return builder.toString();
	}

	/**
	 * Create a string which represent a partial part of the operand.
	 * 
	 * @param values     operand values
	 * @param offset     index of start in the values
	 * @param format     String format
	 * @param nbBytesMax maximum number of bytes to extract
	 * @param builder    Where to store the extract bytes
	 * 
	 * @return the new index value
	 */
	private int consumedByteOperand(int[] values, int offset, int nbBytesMax, String format, StringBuilder builder) {
		int i;
		for (i = offset; i < offset + nbBytesMax; i++) {
			if (i < values.length) {
				builder.append(String.format(format, values[i]));
			} else {
				break;
			}
		}
		return i;
	}

	/**
	 * create a string which contains the macro name.
	 * 
	 * @param label name of macro
	 * @return string which contains the macro name.
	 */
	private String setMacroName(String label) {
		StringBuilder localBuilder = new StringBuilder(label);
		fillWithMisisingSpace(localBuilder, PreferenceManager.getInstance().getListingOperandInstructionSize());
		return localBuilder.toString();
	}

	/**
	 * Create a string for write the representation of the comment of the assembly
	 * line.
	 * 
	 * @param comment commment
	 * @param A       string which represent the operand
	 */
	private String setComment(String comment) {
		StringBuilder localBuilder = new StringBuilder();
		if (comment != null) {
			localBuilder.append(comment);
		}
		return localBuilder.toString();
	}

	/**
	 * Create a string for write the representation of the operand of the assembly
	 * line.
	 * 
	 * @param operand reference on the operand
	 * @param A       string which represent the operand
	 */
	private String setInstructionOperand(EObject operand) {
		StringBuilder localBuilder = new StringBuilder();
		if (operand != null) {
			String strOperand = serializer.serialize(operand).replace(" ", "");
			localBuilder.append(strOperand);
		}

		fillWithMisisingSpace(localBuilder, PreferenceManager.getInstance().getListingOperandInstructionSize());
		return localBuilder.toString();
	}

	/**
	 * Create a string for write the instruction name of the assembly line.
	 * 
	 * @param instructionName name of the instruction
	 * @param A               string which represent the instruction name
	 */
	private String setInstructionName(String instructionName) {
		StringBuilder localBuilder = new StringBuilder();
		localBuilder.append(instructionName);

		fillWithMisisingSpace(localBuilder, PreferenceManager.getInstance().getListingInstructionSize());
		return localBuilder.toString();
	}

	/**
	 * Create a string for write the label of the assembly line.
	 * 
	 * @param label label of the source line, <b>null</> if no label
	 * @return A string which represent the label
	 */
	private String setLabel(String label) {
		StringBuilder localBuilder = new StringBuilder();
		if (label != null) {
			localBuilder.append(label);
		}
		fillWithMisisingSpace(localBuilder, PreferenceManager.getInstance().getListingLabelSize());
		return localBuilder.toString();
	}

	/**
	 * Create a string for write the operand of the assembly line.
	 * 
	 * @param operand operand of the source line, <b>null</> if no operand
	 * @return A string which represent the operand
	 */
	private String setOperand(int[] operands) {
		StringBuilder localBuilder = new StringBuilder();
		int neededSpaces = PreferenceManager.getInstance().getListingOperandSize();

		if (operands != null) {
			for (int opcode : operands) {
				localBuilder.append(String.format("%02X", opcode));
			}
		}

		fillWithMisisingSpace(localBuilder, neededSpaces + 1);
		return localBuilder.toString();
	}

	/**
	 * Create a string for write the opcode of the assembly line.
	 * 
	 * @param opcode opcode of the source line, <b>null</> if no opcode
	 * @return A string which represent the opcode
	 */
	private String setOpcode(int[] opcodes) {
		StringBuilder localBuilder = new StringBuilder();
		if (opcodes != null) {
			for (int opcode : opcodes) {
				localBuilder.append(String.format("%02X", opcode));
			}
		}

		int neededSpaces = PreferenceManager.getInstance().getListingOpcodeSize() + 1;
		fillWithMisisingSpace(localBuilder, neededSpaces);
		return localBuilder.toString();
	}

	/**
	 * Write the PC address if necessary.
	 * 
	 * @param pcaddress pc address value, -1 if not display
	 * @return string whihc contains the formatted PC address
	 */
	private String setPcAddress(int pcAddress) {
		StringBuilder localBuilder = new StringBuilder();
		if (pcAddress > -1) {
			localBuilder.append(String.format("%04X", pcAddress));
		}

		int neededSpaces = PreferenceManager.getInstance().getListingAddressSize() + 1;
		fillWithMisisingSpace(localBuilder, neededSpaces);
		return localBuilder.toString();
	}

	/**
	 * get a string which represent the line number.
	 * 
	 * @param lineNumber line number
	 */
	private String setLineNumber(int lineNumber) {
		StringBuilder localBuilder = new StringBuilder();
		if (lineNumber > 0) {
			localBuilder.append(String.format("%04d", lineNumber));
		}

		int neededSpaces = PreferenceManager.getInstance().getListingLineNumberSize() + 1;
		fillWithMisisingSpace(localBuilder, neededSpaces);
		return localBuilder.toString();
	}

	/**
	 * get operand values of a directive.
	 * 
	 * @param directiveLine reference on the directive
	 * @return integer array which contains operand values
	 */
	private int[] getValues(AbstractAssembledDirectiveLine directiveLine) {
		int[] values = new int[0];
		if (directiveLine instanceof AssembledBszDirectiveLine bszDirective) {
			values = bszDirective.getValues();
		} else if (directiveLine instanceof AssembledFccDirectiveLine fccDirective) {
			values = fccDirective.getValues();
		} else if (directiveLine instanceof AssembledFcbDirectiveLine fcbDirective) {
			values = fcbDirective.getValues();
		} else if (directiveLine instanceof AssembledFdbDirectiveLine fdbDirective) {
			values = fdbDirective.getValues();
		} else if (directiveLine instanceof AssembledFillDirectiveLine fillDirectvie) {
			values = fillDirectvie.getValues();
		}

		return values;
	}

	/**
	 * Add missing spaces.
	 * 
	 * @param localBuilder reference on a String builder
	 * @param neededLength Number of needed spaces.
	 */
	private void fillWithMisisingSpace(StringBuilder strBuilder, int neededLength) {
		if (strBuilder.length() < neededLength) {
			strBuilder.append(Strings.repeat(" ", neededLength - strBuilder.length()));
		} else {
			strBuilder.append(" ");
		}
	}
}
