package information.client.api;

import information.client.api.util.Mp3MetaParser;

public class Main {

	public static void main(String[] args) {
		try {
			String fileLocation = "samples/sample.mp3" ;
			
			System.out.println(Mp3MetaParser.getMp3Info(fileLocation).toString());
        } catch (Exception e) {
			e.printStackTrace();
		}
	        
	}

}
