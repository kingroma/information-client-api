package information.client.api.test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import information.client.api.util.DomainUtil;

public class ContentTest {
	public static void main(String[] args) {
		insertContent();
	}
	
	public static void insertContentProgram() {
		MysqlConnection mysqlConnection = new MysqlConnection();
		
		Connection connection = mysqlConnection.getConnection();
		
		try {
			// insert into t_genre values ('1','titl1','synopsis1',now(),now()) ;
			for ( int i = 0 ; i < 7 ; i ++ ) {
				String sql = "insert into t_content_program values (?,?,?,'Y',now(),now())";
				PreparedStatement pstmt = connection.prepareStatement(sql);
				
				for ( int j = 0 ; j < 1 ; j ++ ) {
					String genreId = DomainUtil.getUUID(20);
					pstmt.setString(1, ""+i);
					pstmt.setString(2, "nm" + i);
					pstmt.setInt(3,  i);
					pstmt.executeUpdate();
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insertContent() {
		MysqlConnection mysqlConnection = new MysqlConnection();
		
		Connection connection = mysqlConnection.getConnection();
		
		try {
			// insert into t_genre values ('1','titl1','synopsis1',now(),now()) ;
			for ( int i = 0 ; i < 7 ; i ++ ) {
				String sql = "insert into t_content values (?,?,?,'Y',now(),now())";
				PreparedStatement pstmt = connection.prepareStatement(sql);
				
				for ( int j = 0 ; j < 1 ; j ++ ) {
					String genreId = DomainUtil.getUUID(20);
					pstmt.setString(1, ""+i);
					pstmt.setString(2, "nm" + i);
					pstmt.setInt(3,  i);
					pstmt.executeUpdate();
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
