package com.siva.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewProjectDetails{
	private Integer empId;
	private String empName;
	private Integer mgrId;
	private String manager;
	private Long managerMobileNo;
	private String managerEmail;
	private String projectName;
	
}
