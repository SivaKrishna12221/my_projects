package com.siva.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.siva.entity.Manager;

@Component("mgr-pdf")
public class ManagerInfoPdfView extends AbstractPdfView{
   private int i=0;
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
	 List<Manager> mgrs=(List<Manager>	)model.get("mgrsList");
	 Paragraph para=new Paragraph("Manager Report",new Font(Font.ITALIC));
	 document.add(para);
	 
	 Table table=new Table(8,mgrs.size());
	 table.addCell("SI.No");
		table.addCell("MgrId");
		table.addCell("Name");
		table.addCell("Role");
		table.addCell("DOB");
		table.addCell("MobileNo");
		table.addCell("Email");
		table.addCell("Address");
		for(Manager m:mgrs)
		{
			table.addCell(String.valueOf(i));
			table.addCell(String.valueOf(m.getMgrId()));
			table.addCell(m.getName());
			table.addCell(m.getRole());
			table.addCell(String.valueOf(m.getDob()));
			table.addCell(String.valueOf(m.getMobileNo()));
			table.addCell(m.getEmail());
			table.addCell(m.getAddress()+","+m.getCity()+","+m.getState());
		}
		document.add(table);
	}
}
