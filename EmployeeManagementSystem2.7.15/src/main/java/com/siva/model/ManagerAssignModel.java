package com.siva.model;

import lombok.Data;

@Data
public class ManagerAssignModel {
  
	private Integer empId;
	private String empName;
	private String empMail;	
	private String managerName;
	private String assignAction="assign";
}	
