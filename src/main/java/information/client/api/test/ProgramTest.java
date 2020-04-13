package information.client.api.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import information.client.api.domain.Program.ProgramType;
import information.client.api.util.DomainUtil;

public class ProgramTest {
	private static ProgramType[] pt = {ProgramType.basic,ProgramType.series};
	
	public static void main(String[] args) {
		// insertProgram();
		// insertProgramProduct();
		
		// insertGenre();
		// insertProgramGenre();
	}
	
	public static void insertGenre() {
		MysqlConnection mysqlConnection = new MysqlConnection();
		
		Connection connection = mysqlConnection.getConnection();
		
		try {
			// insert into t_genre values ('1','titl1','synopsis1',now(),now()) ;
			for ( int i = 0 ; i < 10 ; i ++ ) {
				String sql = "insert into t_genre values (?,?,now(),now())";
				PreparedStatement pstmt = connection.prepareStatement(sql);
				
				for ( int j = 0 ; j < 1 ; j ++ ) {
					String genreId = DomainUtil.getUUID(20);
					pstmt.setString(1, ""+i);
					pstmt.setString(2, "nm" + i);
					pstmt.executeUpdate();
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insertProgramGenre() {
		MysqlConnection mysqlConnection = new MysqlConnection();
		
		Connection connection = mysqlConnection.getConnection();
		
		Random random = new Random();
		try {
			for ( int i = 0 ; i < 10 ; i ++ ) {
				//  program_id , genre_id ,
				String sql = "insert into t_program_genre values (?,?,now(),now())";
				PreparedStatement pstmt = connection.prepareStatement(sql);
				int lenth = random.nextInt(2) + 1; 
				
				for ( int j = 0 ; j < lenth ; j ++ ) {
					int genreId = random.nextInt(10);
					pstmt.setString(1, "" + i);
					pstmt.setString(2, "" + genreId);
					pstmt.executeUpdate();
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insertProgramProduct() {
		MysqlConnection mysqlConnection = new MysqlConnection();
		
		Connection connection = mysqlConnection.getConnection();
		
		try {
			// insert into t_program values ('1','titl1','synopsis1',now(),now()) ;
			for ( int i = 0 ; i < 10 ; i ++ ) {
				String sql = "insert into t_program_product values (?,?,?,now(),now())";
				PreparedStatement pstmt = connection.prepareStatement(sql);
				int lenth = (i%2 == 0 ? 1 : 3) ; 
				
				for ( int j = 0 ; j < lenth ; j ++ ) {
					String productId = DomainUtil.getUUID(20);
					pstmt.setString(1, ""+i);
					pstmt.setString(2, productId);
					pstmt.setString(3, "title" + i);
					pstmt.executeUpdate();
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void insertProgram() {
		MysqlConnection mysqlConnection = new MysqlConnection();
		
		Connection connection = mysqlConnection.getConnection();
		
		try {
			// insert into t_program values ('1','titl1','synopsis1',now(),now()) ;
			for ( int i = 0 ; i < 10 ; i ++ ) {
				
				String sql = "insert into t_program values (?,?,?,?,now(),now())";
				PreparedStatement pstmt = connection.prepareStatement(sql);
				pstmt.setString(1, "" + i);
				pstmt.setString(2, "title" + i);
				pstmt.setString(3, (i%2 == 0 ? pt[0] : pt[1]).toString() );
				pstmt.setString(4, "synopsis" + i);
				
				pstmt.executeUpdate();
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void selectAllProgram() {
		MysqlConnection mysqlConnection = new MysqlConnection();
		
		Connection connection = mysqlConnection.getConnection();
		
		try {
			String sql = "select * from t_program";
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while ( rs.next() ) {
				String programId = rs.getString("program_id");
				String title = rs.getString("title");
				String synopsis = rs.getString("synopsis");
				String registDate = rs.getString("regist_date");
				String udpateDate = rs.getString("update_date");
				
				System.out.println(programId);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
