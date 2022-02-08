/**
 * 
 */
package in.ashokit.reports;

import java.awt.Color;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.ashokit.binding.response.PlanResponse;

/**
 * @author USER
 *
 */
public class PDFReportGenerator {

	public void exportPdf(List<PlanResponse> plans, HttpServletResponse response) throws Exception {
		
		Document document = new  Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);
		
		Paragraph paragraph = new Paragraph("List of Plans", font);
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(paragraph);
		
		PdfPTable table = new PdfPTable(5);
		table.setWidths(new float[] {1.5f, 1.5f, 2.0f, 3.0f, 2.0f});
		table.setSpacingBefore(10);
		
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.LIGHT_GRAY);
		cell.setPadding(5);
		
		Font font1 = FontFactory.getFont(FontFactory.HELVETICA);
		font1.setColor(Color.WHITE);
		
		cell.setPhrase(new Phrase("Plan ID", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Plan Name", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Holder Name", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("SSN", font1));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Status", font1));
		table.addCell(cell);
		
		for(PlanResponse plan : plans) {
			table.addCell(plan.getPlanId()+"");
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanHolderName());
			table.addCell(plan.getPlanHolderSsn()+"");
			table.addCell(plan.getPlanStatus());
		}
		
		
		document.add(table);
		document.close();
	}
}
