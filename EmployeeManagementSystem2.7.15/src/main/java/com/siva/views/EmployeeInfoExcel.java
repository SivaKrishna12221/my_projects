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

import com.siva.entity.Employee;

@Component("emp-excel")
public class EmployeeInfoExcel extends AbstractXlsView{

	private int i=0;
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	
	 List<Employee> emps=(List<Employee>) model.get("empsList");
	 
     Sheet sheet1 = workbook.createSheet("emp_sheet1");
     for(Employee e:emps)
     {
    	Row row = sheet1.createRow(i);
    	row.createCell(0).setCellValue(e.getEmpId());
    	row.createCell(1).setCellValue(e.getName());
    	row.createCell(2).setCellValue(e.getRole());
    	row.createCell(3).setCellValue(String.valueOf(e.getDob()));
    	row.createCell(4).setCellValue(e.getMobileNo());
    	row.createCell(5).setCellValue(e.getEmail());
    	row.createCell(6).setCellValue(e.getAddress()+","+e.getCity()+","+e.getState());
    	i++;
     }
     
     
	}
}
