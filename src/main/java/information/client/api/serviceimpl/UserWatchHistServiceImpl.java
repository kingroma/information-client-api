package information.client.api.serviceimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Sort;

import information.client.api.dao.ProgramDao;
import information.client.api.dao.UserWatchHistDao;
import information.client.api.domain.Program;
import information.client.api.domain.UserWatchHist;
import information.client.api.domain.UserWatchHistPK;
import information.client.api.responsedto.ProgramDto;
import information.client.api.responsedto.TotalDto;
import information.client.api.responsedto.UserWatchHistDto;
import information.client.api.service.UserWatchHistService;
import information.client.api.util.DomainUtil;

@Service
public class UserWatchHistServiceImpl implements UserWatchHistService{
	
	private final int LIMIT = 10 ;
	
	@Resource
	private UserWatchHistDao userWatchHistDao ;
	
	@Resource
	private ProgramDao programDao ; 
	
	@Override
	public TotalDto<UserWatchHistDto> getUserWatchHistRecentProgram(String userId) throws Exception {
		TotalDto<UserWatchHistDto> result = new TotalDto<UserWatchHistDto>();
		
		Filter filters = Filter.equal("id.userId", userId);
		
		Sort sort = new Sort("updateDate", true);
		List<UserWatchHist> userWatchHistList = userWatchHistDao.find(0, LIMIT , sort , filters);
		
		if ( userWatchHistList != null && userWatchHistList.size() > 0 ) {
			Set<String> programSet = new HashSet<String>();
			List<Program> programs = new ArrayList<Program>();
			
			for ( UserWatchHist uwh : userWatchHistList ) {
				String programId = uwh.getId().getProgramId();
				
				if ( !programSet.contains(programId) ) {
					Program program = programDao.findById(programId);
					programs.add(program);
					
					programSet.add(programId);
				}
			}
			
			for ( Program p : programs ) {
				String programId = p.getProgramId();
				String title = p.getTitle();
				
				UserWatchHistDto dto = new UserWatchHistDto();
				dto.setProgramId(programId);
				dto.setTitle(title);
				result.add(dto);
			}
		}
		
		result.settingTotalCount();
		return result;
	}
	
	public Boolean save(String userId , String programId , String productId) throws Exception {
		UserWatchHist entity = new UserWatchHist();
		UserWatchHistPK id = new UserWatchHistPK();
		
		id.setUserId(userId);
		id.setProgramId(programId);
		id.setProductId(productId);
		
		entity.setId(id);
		
		entity.setUpdateDate(DomainUtil.nowTimestamp());
		userWatchHistDao.save(entity);
		
		return true ; 
	}
}
