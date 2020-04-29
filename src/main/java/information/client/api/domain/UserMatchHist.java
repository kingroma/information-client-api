package information.client.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
DROP TABLE T_USER_MATCH_HIST ; 
CREATE TABLE T_USER_MATCH_HIST (
	USER_ID VARCHAR(30) , 
	MATCH_ID VARCHAR(30) ,
	SUMMONER_ID VARCHAR(30) ,
	
	CHAMPION INT ,
	SEASON INT , 
	MATCH_TIME VARCHAR(14) ,
	LANE VARCHAR(30) , 
	KILLS INT , 
	DEATHS INT , 
	ASSISTS INT , 
	WIN VARCHAR(30) ,
	PRIMARY KEY ( USER_ID , MATCH_ID , SUMMONER_ID )
) ;
ALTER TABLE T_USER_MATCH_HIST CONVERT TO CHARACTER SET UTF8;
 * */

@Entity
@Table(name = "t_user_match_hist")
public class UserMatchHist implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private UserMatchHistPK id ;
	
	@Column(name = "champion")
	private Integer champion ;
	
	@Column(name = "season")
	private Integer season ;
	
	@Column(name = "match_time")
	private String matchTime;
	
	@Column(name = "lane")
	private String lane ; 
	
	@Column(name = "kills")
	private Integer kills ; 
	
	@Column(name = "deaths")
    private Integer deaths ;
    
	@Column(name = "assists")
    private Integer assists ;
    
	@Column(name = "win")
    private String win ;

	public UserMatchHistPK getId() {
		return id;
	}

	public void setId(UserMatchHistPK id) {
		this.id = id;
	}

	public Integer getChampion() {
		return champion;
	}

	public void setChampion(Integer champion) {
		this.champion = champion;
	}

	public Integer getSeason() {
		return season;
	}

	public void setSeason(Integer season) {
		this.season = season;
	}

	public String getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(String matchTime) {
		this.matchTime = matchTime;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public Integer getKills() {
		return kills;
	}

	public void setKills(Integer kills) {
		this.kills = kills;
	}

	public Integer getDeaths() {
		return deaths;
	}

	public void setDeaths(Integer deaths) {
		this.deaths = deaths;
	}

	public Integer getAssists() {
		return assists;
	}

	public void setAssists(Integer assists) {
		this.assists = assists;
	}

	public String getWin() {
		return win;
	}

	public void setWin(String win) {
		this.win = win;
	}
    
    
}
