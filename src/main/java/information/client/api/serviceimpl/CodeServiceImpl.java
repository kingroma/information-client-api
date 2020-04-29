package information.client.api.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.googlecode.genericdao.search.Filter;

import information.client.api.dao.CodeDao;
import information.client.api.domain.Code;
import information.client.api.service.CodeService;

@Service
public class CodeServiceImpl implements CodeService{
	
	private final String VERSION_CODE_ID = "lol_version";
	
	private final String SEASON_CODE_ID = "lol_season";
	
	@Resource
	private CodeDao codeDao;
	
	@Override
	public Code getCode(String codeId) {
		Code code = null ; 
		List<Code> list = codeDao.find(Filter.equal("codeId", codeId));
		
		if ( list != null && list.size() > 0 ) {
			code = list.get(0);
		}
		return code ; 
	}
	
	@Override
	public String lolSeason() {
		String output = null ; 
		Code code = codeDao.find(SEASON_CODE_ID);
		
		if ( code != null ) {
			output = code.getValue1();
		}
		
		return output ; 
	}
	
	@Override
	public String lolVersion() {
		String output = null ; 
		Code code = codeDao.find(VERSION_CODE_ID);
		
		if ( code != null ) {
			output = code.getValue1();
		}
		
		return output ; 
	}
}
