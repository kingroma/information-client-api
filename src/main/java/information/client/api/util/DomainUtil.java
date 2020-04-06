package information.client.api.util;

import java.util.Random;

public class DomainUtil {
	
	private static Random random = new Random();
	
	private static final String UUID_SPELLS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public static String getUUID(int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < length ; i ++) {
			sb.append(UUID_SPELLS.charAt(random.nextInt(UUID_SPELLS.length())));
		}
		
		return sb.toString();
	}
}
