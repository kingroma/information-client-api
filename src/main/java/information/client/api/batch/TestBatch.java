package information.client.api.batch;

import java.util.Date;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

import information.client.api.external.client.RiotRetrofitClient;
import retrofit2.Response;

public class TestBatch extends Thread{
	public TestBatch() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				System.out.println(new Date());
				Thread.sleep(5000);
				Response<Map<String,String>> response = RiotRetrofitClient.getTestRetrofitService().getTest("","").execute();
				if ( response.isSuccessful() ) {
					Map<String,String> map = response.body();
				}else {
					response.errorBody();
					RestError re = (RestError)RiotRetrofitClient.getInstance().responseBodyConverter(RestError.class, RestError.class.getAnnotations()).convert(response.errorBody());
					String m = re.message;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public class RestError {
		@SerializedName("error_message")
		public String message ; 
	}
}
