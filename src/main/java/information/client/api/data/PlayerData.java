package information.client.api.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import information.client.api.util.DomainUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerData {
	private Integer profileIcon ; 	
	
	private String accountId ;
	
	private String matchHistoryUri ; 	
	
	private String currentAccountId ;
	
	private String currentPlatformId ; 	
	
	private String summonerName ; 	
	
	private String summonerId ;
	
	private String platformId ;

	public Integer getProfileIcon() {
		return profileIcon;
	}

	public void setProfileIcon(Integer profileIcon) {
		this.profileIcon = profileIcon;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getMatchHistoryUri() {
		return matchHistoryUri;
	}

	public void setMatchHistoryUri(String matchHistoryUri) {
		this.matchHistoryUri = matchHistoryUri;
	}

	public String getCurrentAccountId() {
		return currentAccountId;
	}

	public void setCurrentAccountId(String currentAccountId) {
		this.currentAccountId = currentAccountId;
	}

	public String getCurrentPlatformId() {
		return currentPlatformId;
	}

	public void setCurrentPlatformId(String currentPlatformId) {
		this.currentPlatformId = currentPlatformId;
	}

	public String getSummonerName() {
		return summonerName;
	}

	public void setSummonerName(String summonerName) {
		this.summonerName = summonerName;
	}

	public String getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	} 
	
	@Override
	public String toString() {
		return DomainUtil.changeObjValueToString(this);
	}
}
