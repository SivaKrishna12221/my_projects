package com.nt.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.exception.PlayerNotFoundException;
import com.nt.exceptionmodel.ExceptionMessage;

@RestControllerAdvice

public class GlobalPlayerException {

	@ExceptionHandler(PlayerNotFoundException.class)
	public ResponseEntity<ExceptionMessage> playernotfound(PlayerNotFoundException pl)
	{
		ExceptionMessage em=new ExceptionMessage(LocalDateTime.now(), pl.getMessage(),"player-service/find-player", " 500 player not found");
		return ResponseEntity.ok(em);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionMessage> globalException(Exception e)
	{
		ExceptionMessage em=new ExceptionMessage();
		em.setLdt(LocalDateTime.now());
		em.setMessage(e.getMessage());
		em.setPath("/player-service");
		return ResponseEntity.ok(em);
	}
	
	
}
