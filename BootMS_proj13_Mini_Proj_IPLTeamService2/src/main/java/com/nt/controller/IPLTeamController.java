package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nt.model.IPLTeam;
import com.nt.service.IIPLMgmtService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/ipl-teams")
public class IPLTeamController {

	@Autowired    
	private IIPLMgmtService iplservice;

	@PostMapping("/register-team")
	@Operation(summary="register",description="register team details")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200",description = "register team details successfully")
	})
	public ResponseEntity<String> registerIPLTeamDetails(@RequestBody IPLTeam team) {
		String result = iplservice.registerIplTeamDeatials(team);
		return ResponseEntity.ok(result);
	}
	@GetMapping("/find-team/{id}")
	public ResponseEntity<IPLTeam> findIPLTeamUsingId(@PathVariable Integer id)
	{
	  IPLTeam  team	=iplservice.fetchIplTeamById(id);
	  return ResponseEntity.ok(team);
	}
	@GetMapping("/find-all-teams")
	public ResponseEntity<List<IPLTeam>> findAllIPLTeams()
	{
		List<IPLTeam> lsteams=iplservice.fetchAllTeamsDetails();
		return ResponseEntity.ok(lsteams);
	}
}
