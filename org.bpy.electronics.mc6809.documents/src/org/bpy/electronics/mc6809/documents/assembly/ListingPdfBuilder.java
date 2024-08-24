package org.bpy.electronics.mc6809.documents.assembly;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.bpy.electronics.mc6809.assembler.AssemblerStandaloneSetup;
import org.bpy.electronics.mc6809.assembler.assembler.Model;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerEngine;
import org.bpy.electronics.mc6809.assembler.engine.AssemblerManager;
import org.bpy.electronics.mc6809.assembler.engine.data.AbstractAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.comment.AssembledCommentLine;
import org.bpy.electronics.mc6809.assembler.engine.data.directives.AbstractAssembledDirectiveLine;
import org.bpy.electronics.mc6809.assembler.engine.data.instructions.AbstractInstructionAssemblyLine;
import org.bpy.electronics.mc6809.assembler.engine.data.others.MacroAssembledElement;
import org.bpy.electronics.mc6809.assembler.engine.data.others.MacroDeclarationElement;
import org.bpy.electronics.mc6809.assembler.services.AssemblerGrammarAccess.InstructionLineElements;
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

public class ListingPdfBuilder {

	private Document document;
	private PdfWriter writer;

	/** Reference on the serializer */
	@Inject @Extension 
	private ISerializer serializer;

	public ListingPdfBuilder () {
		com.google.inject.Injector injector = new AssemblerStandaloneSetup().createInjectorAndDoEMFRegistration();
		injector.injectMembers(this);
	}
	
	public void build(File pdfFile, Model model) {
		document = new Document();
		document.setPageSize(PageSize.A4);
		document.setMargins(36, 36, 50, 50);
		document.setMarginMirroring(true);
		
		try {
		   writer = PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
			document.open();
			AssemblerEngine engine = AssemblerManager.getInstance().getAssemblyModel(model, false);
			fillDocument(engine);
			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void fillDocument(AssemblerEngine engine) throws DocumentException {
		List<AbstractAssemblyLine> assembledLines = engine.getAssembledLine();

		Font documentFont = new Font(FontFamily.COURIER, 8);
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
		document.close();
	}

	private void setComment(AbstractAssemblyLine sourceLine, StringBuilder strBuilder) {
		StringBuilder localBuilder = new StringBuilder(); 
		
		if (sourceLine instanceof AbstractInstructionAssemblyLine) {
			if (sourceLine.getComment() != null) {
				localBuilder.append(sourceLine.getComment());
			}
		}
		strBuilder.append(localBuilder.toString());
	}

	private void setInstructionOperand(AbstractAssemblyLine sourceLine, StringBuilder strBuilder) {
		StringBuilder localBuilder = new StringBuilder(); 
		if (sourceLine instanceof AbstractInstructionAssemblyLine instructionAssemblyLine) {
			EObject operand = instructionAssemblyLine.getInstructionOperand();
			if (operand != null) {
				String strOperand = serializer.serialize(operand).replace(" ", "");
				localBuilder.append(strOperand);
			}
		} else if (sourceLine instanceof AbstractAssembledDirectiveLine directiveline) {
//			localBuilder.append(directiveline.getDirectiveName());
		} else if (sourceLine instanceof MacroDeclarationElement) {
			// TODO
		} else if (sourceLine instanceof MacroAssembledElement) {
		// TODO
		}
		
		fillWithMisisingSpace(localBuilder, 21);
		strBuilder.append(localBuilder.toString());
	}

	private void setInstruction(AbstractAssemblyLine sourceLine, StringBuilder strBuilder) {
		StringBuilder localBuilder = new StringBuilder(); 
		if (sourceLine instanceof AbstractInstructionAssemblyLine instructionAssemblyLine) {
			localBuilder.append(instructionAssemblyLine.getInstructionName());
		} else if (sourceLine instanceof AbstractAssembledDirectiveLine directiveline) {
			localBuilder.append(directiveline.getDirectiveName());
		} else if (sourceLine instanceof MacroDeclarationElement) {
			// TODO
		} else if (sourceLine instanceof MacroAssembledElement) {
		// TODO
		}
		
		fillWithMisisingSpace(localBuilder, 7);
		strBuilder.append(localBuilder.toString());
	}

	private void setLabel(AbstractAssemblyLine sourceLine, StringBuilder strBuilder) {
		StringBuilder localBuilder = new StringBuilder(); 
		if ( (sourceLine instanceof AssembledCommentLine commentLine) && 
				!(commentLine.isSpaceBefore())) {
			localBuilder.append(commentLine.getComment());
		} else {
			
			if (sourceLine.getLabel() != null) {
				localBuilder.append(sourceLine.getLabel());
			}
		}
		fillWithMisisingSpace(localBuilder, 7);
		strBuilder.append(localBuilder.toString());
	}

	private void setOperand(AbstractAssemblyLine sourceLine, StringBuilder strBuilder) {
		StringBuilder localBuilder = new StringBuilder(); 
		if (sourceLine instanceof AbstractInstructionAssemblyLine instructionLine) {
			for (int opcode : instructionLine.getOperand()) {
				localBuilder.append(String.format("%02X", opcode));
			}
		}
		fillWithMisisingSpace(localBuilder, 7);
		strBuilder.append(localBuilder.toString());
	}

	private void setOpcode(AbstractAssemblyLine sourceLine, StringBuilder strBuilder) {
		StringBuilder localBuilder = new StringBuilder(); 
		if (sourceLine instanceof AbstractInstructionAssemblyLine instructionLine) {
			for (int opcode : instructionLine.getOpcode()) {
				localBuilder.append(String.format("%02X", opcode));
			}
		}
		fillWithMisisingSpace(localBuilder, 5);
		strBuilder.append(localBuilder.toString());
	}

	private void setPcAddress(AbstractAssemblyLine sourceLine, StringBuilder strBuilder) {
		if (sourceLine.canDisplayPcAddress()) {
			strBuilder.append(String.format("%04X", sourceLine.getPcAddress()));
		}
		fillWithMisisingSpace(strBuilder, 5);
	}

	private void setLineNumber(AbstractAssemblyLine sourceLine, StringBuilder strBuilder) {
		StringBuilder localBuilder = new StringBuilder(); 
		localBuilder.append(String.format("%04d", sourceLine.getLineNumber()));
		fillWithMisisingSpace(localBuilder, 5);
		strBuilder.append(localBuilder.toString());
	}
	
	private void fillWithMisisingSpace(StringBuilder localBuilder, int neededLength) {
		if (localBuilder.length() < neededLength) {
			localBuilder.append(Strings.repeat(" ", neededLength-localBuilder.length()));
		} else {
			localBuilder.append(" ");
		}
	}


}
	