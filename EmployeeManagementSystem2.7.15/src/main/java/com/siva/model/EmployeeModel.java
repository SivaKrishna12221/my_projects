package com.siva.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeModel {
    private Integer empId;
	private String firstName;
	private String lastName;
	private LocalDate dob;
	private Long mobileNo;
	private String email;
	private String password;
	private String confirmPassword;
	private String address;
	private String city;
	private String state;
	private Long pincode;
	private String role;
	private String status = "active";
	private String managerAssign = "Not assign";
	private String managerAssingAction="assign";
    private Integer admId;
}
