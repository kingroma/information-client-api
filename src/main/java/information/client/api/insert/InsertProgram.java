package information.client.api.insert;

import java.util.ArrayList;
import java.util.List;

import information.client.api.domain.Program;
import information.client.api.domain.Program.ProgramType;
import information.client.api.domain.ProgramProduct;
import information.client.api.util.DomainUtil;

public class InsertProgram {
	public static void main(String[] args) {
		insertNewProgram();
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
