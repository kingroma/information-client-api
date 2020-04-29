package information.client.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserRankHistPK implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "user_id")
	private String userId ; 
	
	@Column(name = "summoner_id")
	private String summonerId ; 
	
	@Column(name = "input_time")
	private String inputTime ; 
	
	@Override
	public int hashCode() {
		final int prime = 31 ; 
		int result = 1 ;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((summonerId == null) ? 0 : summonerId.hashCode());
		result = prime * result + ((inputTime == null) ? 0 : inputTime.hashCode());
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
		UserRankHistPK other = (UserRankHistPK) obj;
		
		if ( (this.userId == null && other.getUserId() != null ) || 
				( this.userId != null && other.getUserId() == null ) ) { 
			return false ; 
		}
		
		if ( !this.userId.equals(other.getUserId())) {
			return false ; 
		}
		
		if ( (this.summonerId == null && other.getSummonerId() != null ) || 
				( this.summonerId != null && other.getSummonerId() == null ) ) { 
			return false ; 
		}
		
		if ( !this.summonerId.equals(other.getSummonerId())) {
			return false ; 
		}
		
		if ( (this.inputTime == null && other.getInputTime() != null ) || 
				( this.inputTime != null && other.getInputTime() == null ) ) { 
			return false ; 
		}
		
		if ( !this.inputTime.equals(other.getInputTime())) {
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

	public String getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}

	public String getInputTime() {
		return inputTime;
	}

	public void setInputTime(String inputTime) {
		this.inputTime = inputTime;
	}
	
	
}
