package com.siva.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequestModel {

	private Integer empId;
	private String empName;
	private String email;
	private Integer mgrId;
	private String managerName;
	private LocalDate fromDate;
	private LocalDate toDate;
	private String reason;
	private String response;
	private String status="pending";
}
