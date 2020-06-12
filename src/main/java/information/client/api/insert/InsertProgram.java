package information.client.api.insert;

import java.util.ArrayList;
import java.util.List;

import information.client.api.domain.Program;
import information.client.api.domain.Program.ProgramType;
import information.client.api.domain.ProgramProduct;
import information.client.api.util.DomainUtil;

public class InsertProgram {
	public static void main(String[] args) {
		// insertNewProgram();
		for(int i = 0 ; i < 20 ; i ++ ) {
			System.out.println(i);
			System.out.println(DomainUtil.getUUID(20));
		}
		
 		// insertProgram();
	}
	
	public static void insertProgram() {
		// -- PROGRAM_ID , TITLE , PROGRAM_TYPE , SYNOPSIS , WATCH_COUNT , REGIST_DATE , UPDATE_DATE 
		// INSERT INTO T_PROGRAM VALUES( '1','TITLE1','programBasic','synopsis1',1,now(),now());
		String programId = DomainUtil.getUUID(20);
		String title = "";
		String programType = ProgramType.programBasic.toString() ; // ProgramType.programBasic.toString();
		String synopsis = ""  ; 
		synopsis = synopsis.replaceAll("\n", "").replaceAll("\r", "");
		System.out.println("INSERT INTO T_PROGRAM VALUES (" +  
				"'" + programId + "' , " +
				"'" + title + "' , " +
				"'" + programType + "' , " +
				"'" + synopsis + "' , " +
				"0 , now() , now() " +
				
		
				" );");

		// -- PROGRAM_ID , PRODUCT_ID , TITLE , TEXT , SEASON , EPISODE , REGIST_DATE , UPDATE_DATE 
		// INSERT INTO T_PROGRAM_PRODUCT VALUES ( '1','1' ,'TITL1','TEXT24',NULL,NULL,NOW(),NOW()) ;
		String programProductId = DomainUtil.getUUID(20);
		
		System.out.println("INSERT INTO T_PROGRAM_PRODUCT VALUES ( " + 
				"'" + programId + "' , " +
				"'" + programProductId + "' , " +
				"'" + title + "' , " +
				"'" + synopsis + "' , " +
				"" + null + " , " +
				"" + null + " , " +
				"now() , now() " +
				" );");
		
		
		// 장르
		// -- GENRE_ID , GENRE_NAME , REGIST_DATE , UPDATE_DATE 
		// INSERT INTO T_GENRE VALUES ('1','NM1',NOW(),NOW()) ;
		String genreId = DomainUtil.getUUID(20);
		String genreNm = "영화";
		System.out.println("INSERT INTO T_GENRE VALUES ('"+genreId+"','"+genreNm+"',NOW(),NOW()) ;");
		
		// 프로그램 장르 연결 
		// -- PROGRAM_ID , GENRE_ID 
		// INSERT INTO T_PROGRAM_GENRE VALUES ( '1' , '1' , NOW(), NOW());
		System.out.println("INSERT INTO T_PROGRAM_GENRE VALUES ( '" + programId + "' , '" + genreId + "' , NOW(), NOW());");
		
		
		// INSERT INTO T_IMAGE_META VALUES ( '')
// 		-- IMAGE_ID , MAPPING_ID , IMAGE_TYPE 
//		INSERT INTO T_IMAGE_META VALUES( '1' , '1' , 'contentBasic' , now(),now());
		String imageId = DomainUtil.getUUID(20);
		
		// System.out.println("INSERT INTO T_IMAGE_META VALUES( '1' , '1' , 'contentBasic' , now(),now());");
	}
	
	public static void insertNewProgram() {
		String programId = DomainUtil.getUUID(20);
		String synopsis = null ;
		String title = null ; 
		String programType = ProgramType.programBasic.toString();
		
		Program program = new Program();
		program.setProgramId(programId);
		program.setProgramType(programType);
		program.setSynopsis(synopsis);
		program.setTitle(title);
		program.setRegistDate(DomainUtil.nowTimestamp());
		program.setUpdateDate(DomainUtil.nowTimestamp());
		program.setWatchCount(0);
		
		List<ProgramProduct> list = new ArrayList<ProgramProduct>();
		ProgramProduct pp = new ProgramProduct();
		
		// LoginView
		// 
	}
	
	
}
