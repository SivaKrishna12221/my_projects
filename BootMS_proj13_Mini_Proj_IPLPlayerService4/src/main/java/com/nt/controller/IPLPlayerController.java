package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.IPLPlayer;
import com.nt.service.IIplMgmtService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/player-service")
@Tag(name="ipl-api",description = "ipl-player service")
public class IPLPlayerController {

	@Autowired
	private IIplMgmtService service;
	@PostMapping("/save-player")
	@Operation(summary = "save ",description = "save the player details")
	@ApiResponses(value= {
	@ApiResponse(responseCode = "200",description = "player details saved successfully")		
	})	
	public ResponseEntity<String> registerPlayerDetails(@RequestBody IPLPlayer player) {
		log.info("player-service:postMapping:save-player-before service method called");
     String result  =service.registerPlayerDetails(player);
		log.info("player-serice:after service method");
     return ResponseEntity.ok(result);
	}
	public ResponseEntity<String> playerNotFoundMessage()
	{
		return ResponseEntity.ok("player is not available");
	}
	
	@GetMapping("/find-player/{id}")
	@Operation(summary="find-player",description="finding player deatials")
	@ApiResponses(value= {
			@ApiResponse(responseCode ="200",description = "player details find successfully")
	})
	public ResponseEntity<IPLPlayer> fetchPlayerDatails(@PathVariable Integer id)
	{
		log.info("find-player getmapping");
	  IPLPlayer player=	service.fetchPlayerDeatialsById(id);
		log.info("find-player after service");
	  return ResponseEntity.ok(player);
	  
	}
}
