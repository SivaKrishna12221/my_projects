package com.nt.service;

import java.util.List;

import com.nt.exceptions.TeamNotFoundException;
import com.nt.model.IPLTeam;

public interface IIPLMgmtService {

	public String registerIplTeamDeatials(IPLTeam team);
	
	public IPLTeam fetchIplTeamById(Integer id)throws TeamNotFoundException;
	
	public List<IPLTeam>  fetchAllTeamsDetails();
	
	
}
