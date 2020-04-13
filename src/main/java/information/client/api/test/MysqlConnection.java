package information.client.api.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnection {
	private String url = "jdbc:mysql://localhost/test";
	private Connection connection ;
	
	public MysqlConnection() {
		this.init();
	}
	
	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection(url, "root", "4235");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	}
}
