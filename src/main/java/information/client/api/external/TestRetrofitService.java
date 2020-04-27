package information.client.api.external;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface TestRetrofitService {

	@GET("getContents")
	public Call<Map<String,String>> getTest(
			@Query("keywordType") String keywordType , 
			@Query("keyword") String keyword 
			);
}
