package information.client.api.service;

import java.util.Map;

import information.client.api.data.ChampionData;

public interface RiotService {
	public Map<String,String> thisDaySummonerTier(String userId,String summonerId);
	
	public ChampionData myTop1Champion(String userId,String summonerId);
}
