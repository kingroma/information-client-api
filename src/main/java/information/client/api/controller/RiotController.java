package information.client.api.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import information.client.api.data.ChampionData;
import information.client.api.service.RiotService;

@Controller
@RequestMapping("/riot")
public class RiotController {
	private static final Logger logger = LoggerFactory.getLogger(RiotController.class);
	
	@Resource
	private RiotService riotService;
	
	@RequestMapping(value = "/thisDaySummonerTier")
	@ResponseBody
	public Map<String,String> thisDaySummonerTier( HttpServletResponse response , 
			@RequestParam(value = "userId", required = false) String userId ,
			@RequestParam(value = "summonerId", required = false) String summonerId
			) {
		Map<String,String> map = riotService.thisDaySummonerTier(userId, summonerId);
		
		return map;
	}
	
	@RequestMapping(value = "/myTop1Champion")
	@ResponseBody
	public ChampionData myTop1Champion( HttpServletResponse response , 
			@RequestParam(value = "userId", required = false) String userId ,
			@RequestParam(value = "summonerId", required = false) String summonerId
			) {
		ChampionData cd = riotService.myTop1Champion(userId, summonerId);
		if ( cd == null ) {
			cd = new ChampionData();
		}
		return cd;
	}
}
