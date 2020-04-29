package information.client.api.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import information.client.api.util.DomainUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchData {
	private Long gameId ; 	

	private List<ParticipantIdentityData> participantIdentities ;
	
	private Integer queueId ; 
	
	private String gameType ;
	
	private Long gameDuration ;
	
	private List<TeamStatsData> teams ;
	
	private String platformId ;
	
	private Long gameCreation ;
	
	private Integer seasonId ;
	
	private String gameVersion ;
	
	private Integer mapId ;
	
	private String gameMode ;
	
	private List<ParticipantData> participants ;

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public List<ParticipantIdentityData> getParticipantIdentities() {
		return participantIdentities;
	}

	public void setParticipantIdentities(List<ParticipantIdentityData> participantIdentities) {
		this.participantIdentities = participantIdentities;
	}

	public Integer getQueueId() {
		return queueId;
	}

	public void setQueueId(Integer queueId) {
		this.queueId = queueId;
	}

	public String getGameType() {
		return gameType;
	}

	public void setGameType(String gameType) {
		this.gameType = gameType;
	}

	public Long getGameDuration() {
		return gameDuration;
	}

	public void setGameDuration(Long gameDuration) {
		this.gameDuration = gameDuration;
	}

	public List<TeamStatsData> getTeams() {
		return teams;
	}

	public void setTeams(List<TeamStatsData> teams) {
		this.teams = teams;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public Long getGameCreation() {
		return gameCreation;
	}

	public void setGameCreation(Long gameCreation) {
		this.gameCreation = gameCreation;
	}

	public Integer getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(Integer seasonId) {
		this.seasonId = seasonId;
	}

	public String getGameVersion() {
		return gameVersion;
	}

	public void setGameVersion(String gameVersion) {
		this.gameVersion = gameVersion;
	}

	public Integer getMapId() {
		return mapId;
	}

	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}

	public String getGameMode() {
		return gameMode;
	}

	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}

	public List<ParticipantData> getParticipants() {
		return participants;
	}

	public void setParticipants(List<ParticipantData> participants) {
		this.participants = participants;
	} 
	
	@Override
	public String toString() {
		return DomainUtil.changeObjValueToString(this);
	}
}
