package com.nt.mvccontroller;

import org.springframework.web.bind.annotation.GetMapping;

//@Controller
//@RequestMapping("/player-dash")
public class IPLPlayerController {

	@GetMapping("/player-home")
	public String showPlayerHome()
	{
		return "player_home";
	}
	
}
