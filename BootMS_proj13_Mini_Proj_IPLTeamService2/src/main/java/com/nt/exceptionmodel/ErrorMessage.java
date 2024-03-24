package com.nt.exceptionmodel;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ErrorMessage {

	private LocalDateTime ldt;
	private String status;
	private String message;
	private String path;
}
