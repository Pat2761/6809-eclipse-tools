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

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Create the header and footer of the PDF listing	
 * 
 * @author Patrick BRIAND
 *
 */
public class ListingHeader extends PdfPageEventHelper {

	/** title of the document */
	private String header;
	/** Reference for put the total number of page */
	private PdfTemplate total;
	/** font used by header and footer */
	private Font headerFont;

	/**
	 * Set the title of the document.
	 *  
	 * @param header title of the document
	 */
	public void setHeader(String header) {
		this.header = header;
	}

	@Override
	public void onOpenDocument(PdfWriter writer, Document document) {
		total = writer.getDirectContent().createTemplate(30, 16);
		headerFont = new Font(FontFamily.COURIER, 10);
	}

	@Override
	public void onCloseDocument(PdfWriter writer, Document document) {
		Phrase phrase = new Phrase(String.valueOf(writer.getPageNumber()));
		phrase.setFont(headerFont);
		ColumnText.showTextAligned(total, Element.ALIGN_LEFT, phrase, 2, 2, 0);
	}

	@Override
	public void onEndPage(PdfWriter writer, Document document) {
		PdfPTable headerTable = new PdfPTable(3);
		PdfPTable footerTable = new PdfPTable(3);
		try {
			headerTable.setWidths(new int[] { 24, 24, 2 });
			headerTable.setTotalWidth(527);
			headerTable.setLockedWidth(true);
			headerTable.getDefaultCell().setFixedHeight(16);
			headerTable.getDefaultCell().setBorder(Rectangle.BOTTOM);
			headerTable.addCell(header);
			headerTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
			headerTable.addCell("");
			PdfPCell cell = new PdfPCell();
			cell.setBorder(Rectangle.BOTTOM);
			headerTable.addCell(cell);
			headerTable.writeSelectedRows(0, -1, 34, 803, writer.getDirectContent());
			
			footerTable.setWidths(new int[] { 24, 24, 2 });
			footerTable.setTotalWidth(527);
			footerTable.setLockedWidth(true);
			footerTable.getDefaultCell().setFixedHeight(16);
			footerTable.getDefaultCell().setBorder(Rectangle.TOP);
			footerTable.addCell("");
			footerTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
			footerTable.addCell(String.format("Page %d of", writer.getPageNumber()));
			PdfPCell cell1 = new PdfPCell(Image.getInstance(total));
			cell1.setBorder(Rectangle.TOP);
			footerTable.addCell(cell1);
			footerTable.writeSelectedRows(0, -1, 34, 50, writer.getDirectContent());
			
		} catch (DocumentException de) {
			throw new ExceptionConverter(de);
		}
	}
}
