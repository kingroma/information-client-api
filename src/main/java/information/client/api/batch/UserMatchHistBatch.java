package information.client.api.batch;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import information.client.api.data.MatchData;
import information.client.api.data.MatchListData;
import information.client.api.data.MatchReferenceData;
import information.client.api.data.ParticipantData;
import information.client.api.data.ParticipantIdentityData;
import information.client.api.data.SummonerData;
import information.client.api.domain.User;
import information.client.api.domain.UserMatchHist;
import information.client.api.domain.UserMatchHistPK;
import information.client.api.external.RiotApi;
import information.client.api.service.CodeService;
import information.client.api.service.UserService;
import information.client.api.util.DomainUtil;
import information.client.api.util.LolChampionUtil;

public class UserMatchHistBatch extends Thread{
	private static final Logger logger = LoggerFactory.getLogger(UserMatchHistBatch.class);
	
	private RiotApi api = new RiotApi();
	
	private int LOOP_TIME = 10 * 60 * 1000;  

	private int GAP_TIME = 100 ;
	
	private int SUCCESS_GAP_TIME = 5000 ;
	
	private UserService userService ;
	
	private CodeService codeService ;
	
	@Override
	public void run() {
		while( true ) {
			try {
				String season = codeService.lolSeason();
				String version = codeService.lolVersion();
				
				LolChampionUtil util = LolChampionUtil.getInstance(version);
				
				if ( userService != null ) {
					List<User> userList = userService.listAll();
					
					if ( userList != null ) {
						for ( User user : userList ) {
							String userId = user.getUserId();
							String summonerId = user.getSummonerId();
							
							if ( summonerId != null && !summonerId.isEmpty() ) {
								SummonerData sd = api.getSummoner(summonerId);
								Long beginTime = null ;
								
								Long beginTimeTemp = userService.getMaxMatchTime(userId);
								if ( beginTimeTemp != null && beginTimeTemp != 0l  ) {
									beginTime = beginTimeTemp;
								}
								
								if ( sd != null && sd.getAccountId() != null && !sd.getAccountId().isEmpty() ) {
									MatchListData mld = api.getSummonerSoloMatch(sd.getAccountId(),null);
									
									for ( MatchReferenceData mrd : mld.getMatches() ) {
										Thread.sleep(GAP_TIME);
										
										String matchId = String.valueOf(mrd.getGameId());
										
										UserMatchHist temp = userService.getUserMatchHist(userId, matchId);
										if ( temp == null ) {
											MatchData md = api.getMatch(matchId);
											if ( md != null ) {
												UserMatchHist umh = new UserMatchHist();
												UserMatchHistPK id = new UserMatchHistPK();
												
												id.setUserId(userId);
												id.setMatchId(String.valueOf(mrd.getGameId()));
												id.setSummonerId(summonerId);
												umh.setId(id);
												
												umh.setSeason(mrd.getSeason());
												umh.setMatchTime(DomainUtil.longToYyyyMmDdHhMmSs(mrd.getTimestamp()));
												umh.setLane(mrd.getLane());
												umh.setChampion(mrd.getChampion());
												
												ParticipantIdentityData pidTarget = null ; 
												ParticipantData pdTarget = null ; 
												
												for ( ParticipantIdentityData pid : md.getParticipantIdentities() ) {
													if ( summonerId.equalsIgnoreCase(pid.getPlayer().getSummonerName())) {
														pidTarget = pid ; 
														break;
													}
												}
												
												for ( ParticipantData pd : md.getParticipants() ) {
													if ( pidTarget != null && pd.getParticipantId() == pidTarget.getParticipantId() ) {
														pdTarget = pd ; 
														break;
													}
												}
												
												if ( pdTarget != null && pidTarget != null ) {
													umh.setKills(pdTarget.getStats().getKills());
													umh.setDeaths(pdTarget.getStats().getAssists());
													umh.setAssists(pdTarget.getStats().getAssists());
													umh.setWin(pdTarget.getStats().getWin().toString());
													
													userService.saveUserMatchHist(umh);
													
													Thread.sleep(SUCCESS_GAP_TIME);
												}
											}
										}
									}
								}
							}
						}
					}
				}
				logger.info("UserMatchHist Finish " + new Date());
				Thread.sleep(LOOP_TIME);
			}catch(Exception e) {
				logger.warn("UserMatchHist Batch Error " , e );
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
