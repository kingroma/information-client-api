package information.client.api.external;

import java.util.List;

import information.client.api.data.LeagueData;
import information.client.api.data.MatchData;
import information.client.api.data.MatchListData;
import information.client.api.data.SummonerData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RiotRetrofitService {

	@GET("/lol/summoner/v4/summoners/by-name/{summonerName}")
	public Call<SummonerData> getSummonerInfoBySummonerName( @Path("summonerName") String summonerName );
	
	@GET("/lol/league/v4/entries/by-summoner/{encryptedSummonerId}")
	public Call<List<LeagueData>> getSummonerLeagueByEncryptedSummonerId( @Path("encryptedSummonerId") String encryptedSummonerId );
	
	@GET("/lol/match/v4/matchlists/by-account/{accountId}")
	public Call<MatchListData> getSummonerSoloMatchsByAccountId(
			@Path("accountId") String accountId,
			@Query("queue") String queue ,
			@Query("season") String season ,
			@Query("beginIndex") Integer beginIndex , 
			@Query("endIndex") Integer endIndex , 
			@Query("beginTime") Long beginTime
			);
	
	@GET("/lol/match/v4/matches/{matchId}")
	public Call<MatchData> getMatchDataByMatchId(
			@Path("matchId") String matchId
			);
	
	
	
}
