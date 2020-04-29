package information.client.api.external;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import information.client.api.data.LeagueData;
import information.client.api.data.MatchData;
import information.client.api.data.MatchListData;
import information.client.api.data.MatchReferenceData;
import information.client.api.data.SummonerData;
import information.client.api.domain.Code;
import information.client.api.external.client.RiotRetrofitClient;
import information.client.api.service.CodeService;
import retrofit2.Response;

public class RiotApi {
	
	private RiotRetrofitService rrs = null ;
	
	public RiotApi() {
		this.rrs = RiotRetrofitClient.getRiotRetrofitService();
	}
	
	public SummonerData getSummoner(String name) {
		SummonerData sd = null ; 
		try {
			Response<SummonerData> response = rrs.getSummonerInfoBySummonerName(name).execute();
			if ( response.isSuccessful() ) {
				sd = response.body();
			}else { 
				
				System.out.println("getSummoner Fail [ " + name + " ] , Message = " + response.code() + " / " + response.message() );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sd ;
	}
	
	private String season = "13";
	private final String SOLO_RANK_QUEUE_TYPE = "RANKED_SOLO_5x5";
	public LeagueData getSoloRankInfo(String encryptedSummonerId, String season ) {
		LeagueData ld = null ;
		
		try {
			
			Response<List<LeagueData>> response = rrs.getSummonerLeagueByEncryptedSummonerId(encryptedSummonerId).execute();
			if ( response.isSuccessful() ) {
				List<LeagueData> list = response.body();
				if ( list != null && list.size() > 0 ) {
					for ( LeagueData l : list ) {
						if ( SOLO_RANK_QUEUE_TYPE.equalsIgnoreCase(l.getQueueType())) {
							ld = l ;
						}
					}
				}
			}else { 
				System.out.println("getSoloRankInfo Fail [ " + encryptedSummonerId + " ] " );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ld ;
	}
	
	private final String SOLO_MATCH_QUEUE_TYPE = "420";
	public MatchListData getSummonerSoloMatch(String accountId, Long beginTime) {
		MatchListData mld = new MatchListData(); ;
		List<MatchReferenceData> list = new ArrayList<MatchReferenceData>();
		
		try {
			int beginIndex = 0 ;
			int endIndex = 100 ; 
			boolean isNext = true ; 
			
			while ( isNext ) {
				Response<MatchListData> response = rrs.getSummonerSoloMatchsByAccountId(accountId, SOLO_MATCH_QUEUE_TYPE, season, beginIndex, endIndex, beginTime).execute();
				if ( response.isSuccessful() ) {
					
					MatchListData temp = response.body();
					if ( temp != null && temp.getMatches() != null && temp.getMatches().size() > 0 ) {
						for ( MatchReferenceData md : temp.getMatches() ) {
							list.add(md);
						}
					} else {
						isNext = false ; 
					}
					
					beginIndex += 100 ; 
					endIndex += 100 ;	
				}else { 
					System.out.println("getSummonerMatchsByAccountId Fail [ " + accountId + " ] " );
					isNext = false ; 
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		mld.setMatches(list);
		return mld ;
	}
	
	public MatchData getMatch(String matchId) {
		MatchData md = null ;
		
		try {
			Response<MatchData> response = rrs.getMatchDataByMatchId(matchId).execute();
			if ( response.isSuccessful() ) {
				md = response.body();
			}else { 
				System.out.println("getMatch Fail [ " + matchId + " ] " );
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return md ;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
