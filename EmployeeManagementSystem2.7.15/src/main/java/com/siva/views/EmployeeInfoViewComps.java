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
import com.siva.entity.Employee;

@Component("emp-pdf")
public class EmployeeInfoViewComps extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		List<Employee> emps=(List<Employee>)map.get("empsList");
	
		Paragraph para=new Paragraph("Employee Report",new Font(Font.ITALIC));
		document.add(para);
		Table table=new Table(8,emps.size());
		table.addCell("SI.No");
		table.addCell("EmpId");
		table.addCell("Name");
		table.addCell("Role");
		table.addCell("DOB");
		table.addCell("MobileNo");
		table.addCell("Email");
		table.addCell("Address");
		int i=1;
		for(Employee e:emps)
		{
			table.addCell(String.valueOf(i));
			table.addCell(String.valueOf(e.getEmpId()));
			table.addCell(e.getName());
			table.addCell(e.getRole());
			table.addCell(String.valueOf(e.getDob()));
			table.addCell(String.valueOf(e.getMobileNo()));
			table.addCell(e.getEmail());
			table.addCell(e.getAddress()+","+e.getCity()+","+e.getState());
			i++;
		}
		document.add(table);
		
		
		
	}
}
