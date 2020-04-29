package information.client.api.external;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TestRetrofitService {

	@GET("/lol/summoner/v4/summoners/by-name/{summonerName}")
	public Call<Map<String,String>> getSummonerInfoBySummonerName(
			@Path("summonerName") String summonerName  
			);
}
