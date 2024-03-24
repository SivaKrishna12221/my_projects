package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.exceptions.TeamNotFoundException;
import com.nt.model.IPLTeam;
import com.nt.repo.IIplTeamRepository;
@Service("ipl-service")
public class IPLMgmtServiceImpl implements IIPLMgmtService {

	@Autowired
	private IIplTeamRepository teamRepo;
	@Override
	public String registerIplTeamDeatials(IPLTeam team) {
		Integer id=teamRepo.save(team).getTeamId();
		return "Team:"+id+" is Registered Succesfully"; 
	}
	@Override
	public IPLTeam fetchIplTeamById(Integer id) throws TeamNotFoundException {
		
		return teamRepo.findById(id).get();
	}
	@Override
	public List<IPLTeam> fetchAllTeamsDetails() {
		
	return	teamRepo.findAll();
	}

}
