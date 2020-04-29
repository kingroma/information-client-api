package information.client.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserMatchHistPK implements Serializable{
	private static final long serialVersionUID = 1L ;
	
	@Column(name = "user_id" , nullable = false )
	private String userId ; 
	
	@Column(name = "match_id" , nullable = false )
	private String matchId ; 
	
	@Column(name = "summoner_id" , nullable = false )
	private String summonerId ; 
	
	@Override
	public int hashCode() {
		final int prime = 31 ; 
		int result = 1 ;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((matchId == null) ? 0 : matchId.hashCode());
		result = prime * result + ((summonerId == null) ? 0 : summonerId.hashCode());
		return result ; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserMatchHistPK other = (UserMatchHistPK) obj;
		
		if ( (this.userId == null && other.getUserId() != null ) || 
				( this.userId != null && other.getUserId() == null ) ) { 
			return false ; 
		}
		
		if ( !this.userId.equals(other.getUserId())) {
			return false ; 
		}
		
		if ( (this.matchId == null && other.getMatchId() != null ) || 
				( this.matchId != null && other.getMatchId() == null ) ) { 
			return false ; 
		}
		
		if ( !this.matchId.equals(other.getMatchId())) {
			return false ; 
		}
		
		if ( (this.summonerId == null && other.getSummonerId() != null ) || 
				( this.summonerId != null && other.getSummonerId() == null ) ) { 
			return false ; 
		}
		
		if ( !this.summonerId.equals(other.getSummonerId())) {
			return false ; 
		}
		
		return true ; 
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMatchId() {
		return matchId;
	}

	public void setMatchId(String matchId) {
		this.matchId = matchId;
	}

	public String getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}
	
	
}
