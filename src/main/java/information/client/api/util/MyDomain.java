package information.client.api.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyDomain {
	private static final String URLS[] = {
			"http://bot.whatismyipaddress.com",
			"http://icanhazip.com",
			"http://ipecho.net/plain"};
	
	public static String getMyExternalIP() {
		StringBuilder result = new StringBuilder() ;
		
		for ( String URL : URLS ) {
			try {
				result = new StringBuilder();
				URL url = new URL(URL);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				
				String line = null ;
				while ((line = br.readLine()) != null ) {
					result.append(line);
				}
				break;
			} catch (Exception e) {
				// e.printStackTrace();
			}
		}
		
		return result.toString() ; 
	}
}
