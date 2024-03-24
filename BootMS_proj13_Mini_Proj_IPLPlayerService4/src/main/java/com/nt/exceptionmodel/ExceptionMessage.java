package com.nt.exceptionmodel;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionMessage {

	private LocalDateTime ldt;
	private String message;
	private String status;
	private String path;
}
