package com.nt.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.exceptionmodel.ErrorMessage;
import com.nt.exceptions.TeamNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(TeamNotFoundException.class)
	public ResponseEntity<ErrorMessage> teamnotfound(TeamNotFoundException ex) {
		ErrorMessage mes = new ErrorMessage();
		mes.setLdt(LocalDateTime.now());
		mes.setMessage(ex.getMessage());
		mes.setPath("/ipl-teams/find-team/{id}");
		mes.setStatus("500 interanal server");
		return ResponseEntity.ok(mes);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> globalException(Exception e)
	{
	ErrorMessage mes=	new ErrorMessage();
	mes.setLdt(LocalDateTime.now());
	mes.setMessage(e.getLocalizedMessage());
	mes.setStatus("500 internal server error");
	mes.setPath("/ipl-teams/**");
	return ResponseEntity.ok(mes);
	}
}
