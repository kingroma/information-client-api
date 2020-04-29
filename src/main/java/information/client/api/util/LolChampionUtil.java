package information.client.api.util;

import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import information.client.api.data.ChampionData;
import information.client.api.domain.Code;
import information.client.api.service.CodeService;

public class LolChampionUtil {
	private static final long ONE_DAY = 1000 * 60 * 60 * 24 ;
	private static Date lastUpdate = null ; 
	private final String CHAMPION_JSON_URL = "http://ddragon.leagueoflegends.com/cdn/{version}/data/ko_KR/champion.json";
	private final String CHAMPION_ICON_IMAGE_URL = "http://ddragon.leagueoflegends.com/cdn/{version}/img/champion/{name}.png";
	private final String CHAMPION_SCREEN_IMAGE = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/{name}_0.jpg";
	
	private static String version = null ;
	
	private static LolChampionUtil INSTANCE = null ; 
	
	private Map<String,ChampionData> championStringMap = null ; 
	
	private LolChampionUtil() {
		// champion
		ObjectMapper om = new ObjectMapper();
		championStringMap = new HashMap<String,ChampionData>();
		
		String targetUrl = CHAMPION_JSON_URL.replace("{version}", version);
		
		try {
			URL url = new URL(targetUrl);
			Map<String,Object> map = (Map<String,Object>)om.readValue(url, Map.class);
			Map<String,Object> data = (Map<String,Object>)map.get("data");
			
			for ( String name : data.keySet() ) {
				Map<String,Object> info = (Map<String,Object>)data.get(name);
				String key = (String)info.get("key");
				
				ChampionData cd = new ChampionData(info);
				
				String iconImageUrl = CHAMPION_ICON_IMAGE_URL.replace("{version}", cd.getVersion()).replace("{name}", cd.getId());
				String screenImageUrl = CHAMPION_SCREEN_IMAGE.replace("{name}", cd.getId());
				
				cd.setIconImageUrl(iconImageUrl);
				cd.setScreenImageUrl(screenImageUrl);
				championStringMap.put(key,cd);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static LolChampionUtil getInstance(String v) {
		version = v;
		if ( INSTANCE == null ) {
			lastUpdate = new Date();
			INSTANCE = new LolChampionUtil();
		}
		
		if ( lastUpdate.getTime() + ONE_DAY < new Date().getTime() ) {
			INSTANCE = new LolChampionUtil();
		}
		
		return INSTANCE;
	}

	public Map<String, ChampionData> getChampionMap() {
		return championStringMap;
	}
	
	public ChampionData getData(String key) {
		return championStringMap.get(key);
	}
	
	public ChampionData getData(Integer key) {
		return championStringMap.get(String.valueOf(key));
	}
}
