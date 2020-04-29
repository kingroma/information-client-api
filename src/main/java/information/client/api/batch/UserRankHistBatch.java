package information.client.api.batch;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import information.client.api.data.LeagueData;
import information.client.api.data.SummonerData;
import information.client.api.domain.User;
import information.client.api.domain.UserRankHist;
import information.client.api.domain.UserRankHistPK;
import information.client.api.external.RiotApi;
import information.client.api.service.CodeService;
import information.client.api.service.UserService;
import information.client.api.util.DomainUtil;

public class UserRankHistBatch extends Thread{
	private static final Logger logger = LoggerFactory.getLogger(UserRankHistBatch.class);
	
	private RiotApi api = new RiotApi();
	
	private int LOOP_TIME = 10 * 60 * 1000;  
	
	private int GAP_TIME = 3000 ;
	
	private UserService userService ; 
	
	private CodeService codeService ;
	
	@Override
	public void run() {
		while( true ) {
			try {
				if ( userService != null ) {
					List<User> userList = userService.listAll();
					
					String season = codeService.lolSeason();
					String version = codeService.lolVersion();
					
					if ( userList != null ) {
						for ( User user : userList ) {
							Thread.sleep(GAP_TIME);
							String userId = user.getUserId();
							String summonerId = user.getSummonerId();
							
							if ( summonerId != null && !summonerId.isEmpty() ) {
								SummonerData sd = api.getSummoner(summonerId);
								if ( sd != null && sd.getId() != null && !sd.getId().isEmpty() ) {
									LeagueData ld = api.getSoloRankInfo(sd.getId(),season);
									
									if ( ld != null ) {
										UserRankHist urh = new UserRankHist();
										UserRankHistPK urhp = new UserRankHistPK();
										
										urhp.setUserId(userId);
										urhp.setSummonerId(summonerId);
										urhp.setInputTime(DomainUtil.nowYyyyMmDdHhMmSs());
										
										urh.setId(urhp);
										urh.setLeaguePoints(ld.getLeaguePoints());
										urh.setTier(ld.getTier());
										urh.setRank(ld.getRank());
										userService.saveUserRankHist(urh);
									}
								}
							}
						}
					}
				}
				logger.info("UserRankHistBatch Finish " + new Date());
				Thread.sleep(LOOP_TIME);
			}catch(Exception e) {
				logger.warn("UserRankHist Batch Error " , e );
			}
		}
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public CodeService getCodeService() {
		return codeService;
	}

	public void setCodeService(CodeService codeService) {
		this.codeService = codeService;
	}

	
}
