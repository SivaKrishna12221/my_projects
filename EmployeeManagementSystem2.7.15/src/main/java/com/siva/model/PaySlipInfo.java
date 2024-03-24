package com.siva.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaySlipInfo {

	private Integer empId;
	private String name;
	private String email;
	private Long mobileNo;
	private String filePath;
}
