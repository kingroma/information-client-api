package information.client.api.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import information.client.api.util.DomainUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamStatsData {
	private Integer towerKills;

	private Integer riftHeraldKills;

	private Boolean firstBlood;

	private Integer inhibitorKills;

	private List<TeamBansData> bans;

	private Boolean firstBaron;

	private Boolean firstDragon;

	private Integer dominionVictoryScore;

	private Integer dragonKills;

	private Integer baronKills;

	private Boolean firstInhibitor;

	private Boolean firstTower;

	private Integer vilemawKills;

	private Boolean firstRiftHerald;

	private Integer teamId;

	private String win;

	public Integer getTowerKills() {
		return towerKills;
	}

	public void setTowerKills(Integer towerKills) {
		this.towerKills = towerKills;
	}

	public Integer getRiftHeraldKills() {
		return riftHeraldKills;
	}

	public void setRiftHeraldKills(Integer riftHeraldKills) {
		this.riftHeraldKills = riftHeraldKills;
	}

	public Boolean getFirstBlood() {
		return firstBlood;
	}

	public void setFirstBlood(Boolean firstBlood) {
		this.firstBlood = firstBlood;
	}

	public Integer getInhibitorKills() {
		return inhibitorKills;
	}

	public void setInhibitorKills(Integer inhibitorKills) {
		this.inhibitorKills = inhibitorKills;
	}

	public List<TeamBansData> getBans() {
		return bans;
	}

	public void setBans(List<TeamBansData> bans) {
		this.bans = bans;
	}

	public Boolean getFirstBaron() {
		return firstBaron;
	}

	public void setFirstBaron(Boolean firstBaron) {
		this.firstBaron = firstBaron;
	}

	public Boolean getFirstDragon() {
		return firstDragon;
	}

	public void setFirstDragon(Boolean firstDragon) {
		this.firstDragon = firstDragon;
	}

	public Integer getDominionVictoryScore() {
		return dominionVictoryScore;
	}

	public void setDominionVictoryScore(Integer dominionVictoryScore) {
		this.dominionVictoryScore = dominionVictoryScore;
	}

	public Integer getDragonKills() {
		return dragonKills;
	}

	public void setDragonKills(Integer dragonKills) {
		this.dragonKills = dragonKills;
	}

	public Integer getBaronKills() {
		return baronKills;
	}

	public void setBaronKills(Integer baronKills) {
		this.baronKills = baronKills;
	}

	public Boolean getFirstInhibitor() {
		return firstInhibitor;
	}

	public void setFirstInhibitor(Boolean firstInhibitor) {
		this.firstInhibitor = firstInhibitor;
	}

	public Boolean getFirstTower() {
		return firstTower;
	}

	public void setFirstTower(Boolean firstTower) {
		this.firstTower = firstTower;
	}

	public Integer getVilemawKills() {
		return vilemawKills;
	}

	public void setVilemawKills(Integer vilemawKills) {
		this.vilemawKills = vilemawKills;
	}

	public Boolean getFirstRiftHerald() {
		return firstRiftHerald;
	}

	public void setFirstRiftHerald(Boolean firstRiftHerald) {
		this.firstRiftHerald = firstRiftHerald;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getWin() {
		return win;
	}

	public void setWin(String win) {
		this.win = win;
	}
	
	@Override
	public String toString() {
		return DomainUtil.changeObjValueToString(this);
	}
}
