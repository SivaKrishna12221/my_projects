package com.siva.model;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class PaySlipModel {

	private Integer empId;
	private String name;
	private LocalDate ld;
	private Integer id;
	private MultipartFile file;
}
