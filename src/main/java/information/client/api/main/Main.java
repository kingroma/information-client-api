package information.client.api.main;

import java.text.SimpleDateFormat;
import java.util.Map;

import information.client.api.data.ChampionData;
import information.client.api.util.LolChampionUtil;

public class Main {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	
	public static void main(String[] args) {
		LolChampionUtil util = LolChampionUtil.getInstance("10.8.1");
		Map<String,ChampionData> map = util.getChampionMap();
		
		for ( String key : map.keySet() ) {
			System.out.println(map.get(key).getIconImageUrl());
			System.out.println(map.get(key).getScreenImageUrl());
		}
	}
	
	
	
	
}
