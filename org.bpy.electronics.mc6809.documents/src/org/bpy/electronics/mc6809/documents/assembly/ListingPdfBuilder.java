package org.bpy.electronics.mc6809.documents.assembly;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.assembler.SourceLine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.comment.AssembledCommentLine;
import org.eclipse.ui.part.PageSite;

import com.google.common.base.Strings;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class ListingPdfBuilder {

	private Document document;
	private PdfWriter writer;

	public void build(File pdfFile, Model model) {
		document = new Document();
		document.setPageSize(PageSize.A4);
		document.setMargins(36, 72, 108, 180);
		document.setMarginMirroring(true);
		
		try {
		   writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
			document.open();
			AssemblerEngine.getInstance().engine(model);
			fillDocument();
			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void fillDocument() throws DocumentException {
		List<AbstractAssemblyLine> assembledLines = AssemblerEngine.getInstance().getAssembledLine();

		Font documentFont = new Font(FontFamily.COURIER, 10);
//		PdfContentByte canvas = writer.getDirectContentUnder(); 
//		canvas.setFontAndSize(documentFont.getBaseFont(), 12);
		
		for(AbstractAssemblyLine sourceLine : assembledLines) {
			StringBuilder strBuilder = new StringBuilder();
			
			setLineNumber(sourceLine, strBuilder);
			setPcAddress(sourceLine, strBuilder);
			setOpcode(sourceLine, strBuilder);
			setOperand(sourceLine, strBuilder);
			setLabel(sourceLine, strBuilder);
			setInstruction(sourceLine, strBuilder);
			setInstructionOperand(sourceLine, strBuilder);
			setComment(sourceLine, strBuilder);

			Chunk line = new Chunk(strBuilder.toString(), documentFont);
			document.add(new Paragraph(line));
		}
	}

	private void setComment(AbstractAssemblyLine sourceLine, StringBuilder strBuilder) {
		// TODO Auto-generated method stub
		
	}

	private void setInstructionOperand(AbstractAssemblyLine sourceLine, StringBuilder strBuilder) {
		// TODO Auto-generated method stub
		
	}

	private void setInstruction(AbstractAssemblyLine sourceLine, StringBuilder strBuilder) {
		// TODO Auto-generated method stub
		
	}

	private void setLabel(AbstractAssemblyLine sourceLine, StringBuilder strBuilder) {
		StringBuilder localBuilder = new StringBuilder(); 
		if ( (sourceLine instanceof AssembledCommentLine commentLine) && 
				!(commentLine.isSpaceBefore())) {
			localBuilder.append(commentLine.getComment());
		} else {
			
			if (sourceLine.getLabel() != null) {
				localBuilder.append(sourceLine.getLabel());
				if (localBuilder.length()<6) {
					localBuilder.append(Strings.repeat(" ", 7-localBuilder.length()));
				}
			} else {
				localBuilder.append(Strings.repeat(" ", 7));
			}
		}
		strBuilder.append(localBuilder.toString());
	}

	private void setOperand(AbstractAssemblyLine sourceLine, StringBuilder strBuilder) {
		StringBuilder localBuilder = new StringBuilder(); 
		if (sourceLine instanceof AbstractInstructionAssemblyLine instructionLine) {
			for (int opcode : instructionLine.getOperand()) {
				localBuilder.append(String.format("%02X", opcode));
			}
			localBuilder.append(Strings.repeat(" ", 7-localBuilder.length()));
		} else {
			localBuilder.append(Strings.repeat(" ", 7));
		}
		strBuilder.append(localBuilder.toString());
	}

	private void setOpcode(AbstractAssemblyLine sourceLine, StringBuilder strBuilder) {
		StringBuilder localBuilder = new StringBuilder(); 
		if (sourceLine instanceof AbstractInstructionAssemblyLine instructionLine) {
			for (int opcode : instructionLine.getOpcode()) {
				localBuilder.append(String.format("%02X", opcode));
			}
			localBuilder.append(Strings.repeat(" ", 5-localBuilder.length()));
		} else {
			localBuilder.append(Strings.repeat(" ", 5));
		}
		strBuilder.append(localBuilder.toString());
	}

	private void setPcAddress(AbstractAssemblyLine sourceLine, StringBuilder strBuilder) {
		if (sourceLine.canDisplayPcAddress()) {
			strBuilder.append(String.format("%04X ", sourceLine.getPcAddress()));
		} else {
			strBuilder.append("     ");
		}
	}

	private void setLineNumber(AbstractAssemblyLine sourceLine, StringBuilder strBuilder) {
		strBuilder.append(String.format("%04d  ", sourceLine.getLineNumber()));
	}
}
	