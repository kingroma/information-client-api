package information.client.api.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import information.client.api.util.DomainUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueData {
	private String leagueId;
	
	private String queueType;
	
	private String tier;
	
	private String rank;
	
	private String summonerId;
	
	private String summonerName;
	
	private Integer leaguePoints;
	
	private Integer wins;
	
	private Integer losses;
	
	private Boolean veteran;
	
	private Boolean inactive;
	
	private Boolean freshBlood;
	
	private Boolean hotStreak;

	public String getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(String leagueId) {
		this.leagueId = leagueId;
	}

	public String getQueueType() {
		return queueType;
	}

	public void setQueueType(String queueType) {
		this.queueType = queueType;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}

	public String getSummonerName() {
		return summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	public Integer getLeaguePoints() {
		return leaguePoints;
	}

	public void setLeaguePoints(Integer leaguePoints) {
		this.leaguePoints = leaguePoints;
	}

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public Integer getLosses() {
		return losses;
	}

	public void setLosses(Integer losses) {
		this.losses = losses;
	}

	public Boolean getVeteran() {
		return veteran;
	}

	public void setVeteran(Boolean veteran) {
		this.veteran = veteran;
	}

	public Boolean getInactive() {
		return inactive;
	}

	public void setInactive(Boolean inactive) {
		this.inactive = inactive;
	}

	public Boolean getFreshBlood() {
		return freshBlood;
	}

	public void setFreshBlood(Boolean freshBlood) {
		this.freshBlood = freshBlood;
	}

	public Boolean getHotStreak() {
		return hotStreak;
	}

	public void setHotStreak(Boolean hotStreak) {
		this.hotStreak = hotStreak;
	}
	
	@Override
	public String toString() {
		return DomainUtil.changeObjValueToString(this);
	}
}
