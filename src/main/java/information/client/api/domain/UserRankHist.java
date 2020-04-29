package information.client.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
DROP TABLE T_USER_RANK_HIST ; 
CREATE TABLE T_USER_RANK_HIST ( 
	USER_ID VARCHAR(30) ,
	SUMMONER_ID VARCHAR(30) , 
	INPUT_TIME VARCHAR(14) ,
	TIER VARCHAR(30) ,
	RANK VARCHAR(30) , 
	LEAGUE_POINTS INT ,
	 
	PRIMARY KEY (USER_ID , SUMMONER_ID , INPUT_TIME)
) ;
ALTER TABLE T_USER_RANK_HIST CONVERT TO CHARACTER SET UTF8; 
 * */

@Entity
@Table(name = "t_user_rank_hist")
public class UserRankHist implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId 
	private UserRankHistPK id ;
	
	@Column(name = "tier")
	private String tier;
	
	@Column(name = "rank")
	private String rank ; 
	
	@Column(name = "league_points")
	private Integer leaguePoints ;

	public UserRankHistPK getId() {
		return id;
	}

	public void setId(UserRankHistPK id) {
		this.id = id;
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

	public Integer getLeaguePoints() {
		return leaguePoints;
	}

	public void setLeaguePoints(Integer leaguePoints) {
		this.leaguePoints = leaguePoints;
	} 
	
	
	
}
