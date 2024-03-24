package com.nt.service;

import com.nt.exception.PlayerNotFoundException;
import com.nt.model.IPLPlayer;

public interface IIplMgmtService {

	public String registerPlayerDetails(IPLPlayer player);
	
	public IPLPlayer fetchPlayerDeatialsById(Integer id)throws PlayerNotFoundException;
}
