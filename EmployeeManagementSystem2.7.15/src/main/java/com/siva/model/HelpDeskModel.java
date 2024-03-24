package com.siva.model;

import lombok.Data;

@Data
public class HelpDeskModel {

	private Integer empId;
	private Integer mgrId;
	private Integer adminId;
	private String empName;
	private String email;
	private Long mobileNo;
	private String message;
	private Integer msgId;
	private String response;
	private String status="pending";
	public HelpDeskModel(String empName, String email, String message, String status) {
		super();
		this.empName = empName;
		this.email = email;
		this.message = message;
		this.status = status;
	}
	public HelpDeskModel() {
		// TODO Auto-generated constructor stub
	}
	public HelpDeskModel(Integer empId, String empName, String email, Long mobileNo, String message, String status,Integer msgId) {
		super();
		this.msgId=msgId;
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.message = message;
		this.status = status;
	}
	
}
