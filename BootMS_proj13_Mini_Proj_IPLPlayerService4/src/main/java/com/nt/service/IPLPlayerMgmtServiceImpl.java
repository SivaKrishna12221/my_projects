package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.nt.exception.PlayerNotFoundException;
import com.nt.feign.IIPLTeamServiceFeignClient;
import com.nt.model.IPLPlayer;
import com.nt.model.IPLTeam;
import com.nt.repo.IIPLPlayerRepository;

@Service("player-service")
public class IPLPlayerMgmtServiceImpl implements IIplMgmtService{

	@Autowired
	private IIPLPlayerRepository playerRepo;
	@Autowired
	private IIPLTeamServiceFeignClient feign;
	@Override
	public String registerPlayerDetails(IPLPlayer player) {
	    IPLTeam team=feign.fetchTeamDetailsById(player.getTeam().getTeamId()).getBody();
	    player.setTeam(team);
		Integer id =playerRepo.save(player).getPid();
		return "Player:"+id+" is registered succesfully";
	}
	@Override
	public IPLPlayer fetchPlayerDeatialsById(Integer id) throws PlayerNotFoundException {
		
		return playerRepo.findById(id).get();
	}
}
