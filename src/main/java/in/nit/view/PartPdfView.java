package in.nit.view;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.nit.model.Part;

public class PartPdfView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// download file
		response.addHeader("Content-Disposition", "attachment;filename=shipment.pdf");
		// create element
		Paragraph p = new Paragraph("Welcome to Part");
		// add element to Document
		document.add(p);
		// read data from model
		@SuppressWarnings("unchecked")
		List<Part> list = (List<Part>) model.get("list");
		// creating a table with no of column
		PdfPTable t = new PdfPTable(8);
		t.addCell("ID");
		t.addCell("PART CODE");
		t.addCell("PART LINE");
		t.addCell("PART WIDTH");
		t.addCell("PART HIEGHT");
		t.addCell("BASE COST");
		t.addCell("BASE CURRENCY");
		t.addCell("DISCRIPTION");
		

		// adding data to table
		for (Part part : list) {
			t.addCell(part.getId().toString());
			t.addCell(part.getPartCode());
			t.addCell(part.getPartLine().toString());
			t.addCell(part.getPartWid().toString());
			t.addCell(part.getPartHgt().toString());
			t.addCell(part.getBaseCost().toString());
			t.addCell(part.getBaseCurrency());
			t.addCell(part.getDesc().toString());
		}
		// ADD table to document
		document.add(t);
		// print date and time
		document.add(new Paragraph(new Date().toString()));

	}
}
