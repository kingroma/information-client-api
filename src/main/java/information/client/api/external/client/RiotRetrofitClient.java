package information.client.api.external.client;

import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import information.client.api.external.TestRetrofitService;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class RiotRetrofitClient {
	private static final String BASE_URL = "";
	
	public static TestRetrofitService getTestRetrofitService() {
		return getInstance().create(TestRetrofitService.class);
	}
	
	public static Retrofit getInstance() {
		Gson gson = new GsonBuilder().create();
		
		return new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create(gson))
				.client(jsonPlaceholderOkHttpClient())
				.build()
				;
	}
	
	public static OkHttpClient jsonPlaceholderOkHttpClient() {

        return new OkHttpClient.Builder()
                .addInterceptor(new JsonPlaceholderInterceptor())
                .build();
    }
	
	public static class JsonPlaceholderInterceptor implements Interceptor {
	    @Override
	    public Response intercept(Chain chain) throws IOException {

	        return chain.proceed(
	                chain.request().newBuilder()
	                		.addHeader("tokenId", "a1a6scaeda3akfc4aba4d2ceh5acbagh")
	                        .build()
	        );
	    }
	} 
}
