package com.nt.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.nt.model.IPLTeam;

@FeignClient("IPL-TEAM-SERVICE")
public interface IIPLTeamServiceFeignClient {

	@GetMapping("/ipl-teams/find-team/{id}")
	public ResponseEntity<IPLTeam> fetchTeamDetailsById(@PathVariable("id")Integer id);
}
