package information.client.api.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Sort;

import information.client.api.dao.UserMatchHistDao;
import information.client.api.dao.UserRankHistDao;
import information.client.api.data.ChampionData;
import information.client.api.domain.UserMatchHist;
import information.client.api.domain.UserRankHist;
import information.client.api.service.CodeService;
import information.client.api.service.RiotService;
import information.client.api.util.DomainUtil;
import information.client.api.util.LolChampionUtil;

@Service
public class RiotServiceImpl implements RiotService{
	
	@Resource
	private UserRankHistDao userRankHistDao ;
	
	@Resource
	private UserMatchHistDao userMatchHistDao ;
	
	@Resource
	private CodeService codeService ; 
	
	@Override
	public Map<String,String> thisDaySummonerTier(String userId,String summonerId){
		int count = 10 ; 
		List<String> thisDayList = new ArrayList<String>();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		try {
			for ( int i = 0 ; i < count ; i ++ ) {
				thisDayList.add(sdf.format(new Date().getTime() - DomainUtil.ONE_DAY_LONG * i ));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Map<String,String> map = new HashMap<String,String>();
		
		for ( int i = 0 ; i < count ; i ++ ) {
			List<Filter> filterList = new ArrayList<Filter>();
			Sort sort = new Sort("id.inputTime",true);
			Filter filter = Filter.like("id.inputTime", thisDayList.get(i) + "%");
			filterList.add(filter);
			
			if(userId != null && !userId.isEmpty()) {
				filterList.add(Filter.equal("id.userId", userId));
			}
			
			if(summonerId != null && !summonerId.isEmpty()) {
				filterList.add(Filter.equal("id.summonerId", summonerId));
			}
			
			
			Filter f[] = new Filter[filterList.size()];
			filterList.toArray(f);
			
			List<UserRankHist> list = userRankHistDao.find(sort, f);
			
			if ( list != null && list.size() > 0 ) {
				UserRankHist urh = list.get(0);
				
				String tier = urh.getTier();
				String rank = urh.getRank();
				Integer point = urh.getLeaguePoints();
				
				map.put(thisDayList.get(i),tier+"_"+rank+"_"+point);
			}
		}
		
		
		return map ;
	}
	
	public ChampionData myTop1Champion(String userId,String summonerId){
		ChampionData cd = null ; 
		
		List<Filter> filterList = new ArrayList<Filter>();
		if(userId != null && !userId.isEmpty()) {
			filterList.add(Filter.equal("id.userId", userId));
		}
		
		if(summonerId != null && !summonerId.isEmpty()) {
			filterList.add(Filter.equal("id.summonerId", summonerId));
		}
		
		String version = codeService.lolVersion();
		
		Filter[] filters = new Filter[filterList.size()];
		
		List<UserMatchHist> list = userMatchHistDao.find(filterList.toArray(filters));
		
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		
		for ( UserMatchHist umh : list ) {
			Integer champion = umh.getChampion();
			
			if ( map.get(champion) == null ) { map.put(champion, 1) ; }
			else { map.put(champion, map.get(champion) + 1 ); }
		}
		
		int max = 0 ;
		Integer maxKey = -1 ;
		
		for ( Integer key : map.keySet() ) {
			if ( max < map.get(key) ) {
				max = map.get(key);
				maxKey = key ; 
			}
		}
		
		if (maxKey != -1 ) {
			cd = LolChampionUtil.getInstance(version).getData(maxKey);
		}
		
		return cd ; 
	}
}
