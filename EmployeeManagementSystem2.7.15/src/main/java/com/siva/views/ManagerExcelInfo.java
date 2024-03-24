package com.siva.views;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.siva.entity.Manager;

@Component("mgr-excel")
public class ManagerExcelInfo extends AbstractXlsView{

	private int i=0;
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<Manager> mgrs=(List<Manager>)model.get("mgrsList");
		Sheet sheet1 = workbook.createSheet("sheet2");
		
		for(Manager m:mgrs)
		{
		 Row row = sheet1.createRow(i);
		 row.createCell(0).setCellValue(m.getMgrId());
		 row.createCell(1).setCellValue(m.getName());
		 row.createCell(2).setCellValue(m.getRole());
		 row.createCell(3).setCellValue(String.valueOf(m.getDob()));
		 row.createCell(4).setCellValue(m.getMobileNo());
		 row.createCell(5).setCellValue(m.getEmail());
		 row.createCell(6).setCellValue(m.getAddress()+","+m.getCity()+","+m.getState());
		 i++;
		}
	}
}
