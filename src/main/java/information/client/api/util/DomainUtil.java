package information.client.api.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DomainUtil {
	
	private static Random random = new Random();
	
	private static final String UUID_SPELLS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	
	public static final long ONE_DAY_LONG = 1000 * 60 * 60 *24 ;
	
	public static String getUUID(int length) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0 ; i < length ; i ++) {
			sb.append(UUID_SPELLS.charAt(random.nextInt(UUID_SPELLS.length())));
		}
		
		return sb.toString();
	}
	
	public static Timestamp nowTimestamp() {
		return new Timestamp(new Date().getTime());
	}
	
	private static final SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmss");
	public static String nowYyyyMmDdHhMmSs() {
		String output = null ;
		try {
			output = sdf1.format(new Date());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return output ; 
	}
	
	public static long yyyyMmDdHhMmSsToLong(String input) {
		long output = 0l;
		if ( input != null ) {
			try {
				output = sdf1.parse(input).getTime();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return output ; 
	}
	
	public static String longToYyyyMmDdHhMmSs(Long input) {
		String output = null;
		if ( input != null ) {
			output = sdf1.format(new Date(input));
		}
		return output ; 
	}
	
	public static String convertMethodName(String field) {
		return 
				"get" + 
				Character.toUpperCase(field.charAt(0)) + 
				field.substring(1,field.length());
	}
	
	private static final String[] canPrintObj = {};
	public static String changeObjValueToString(Object obj) {
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		sb.append(obj.getClass().getName());
		sb.append(" ");
		for ( Field f : obj.getClass().getDeclaredFields() ) {
			try {
				String fieldName = f.getName();
				String methodName = convertMethodName(f.getName());
				Method m = obj.getClass().getMethod(methodName, null);
				Object o = m.invoke(obj, null);
				sb.append(fieldName);
				sb.append("=");
				sb.append(o);
				sb.append(", ");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		sb.delete(sb.length()-2, sb.length());
		
		sb.append(" ] ");
		
		return sb.toString();
	}
	
	private static Random r = new Random();
	public static int random(int size) {
		return r.nextInt(size);
	}
	
	public static void main(String[] args) {
		System.out.println(getUUID(20));
	}
}
