package com.siva.model;

import lombok.Data;

@Data
public class AssignProjectModel {
	private Integer empId;
	private Integer mgrId;
	private String empName;
	private String email;
	private String projectName;
	private String status;
	
}
