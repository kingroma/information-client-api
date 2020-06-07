package information.client.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserMusicBoxListPK  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "box_id")
	private String boxId ;
	
	@Column(name = "music_id")
	private String musicId ;

	@Override
	public int hashCode() {
		final int prime = 31 ; 
		int result = 1 ;
		result = prime * result + ((boxId == null) ? 0 : boxId.hashCode());
		result = prime * result + ((musicId == null) ? 0 : musicId.hashCode());
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
		UserMusicBoxListPK other = (UserMusicBoxListPK) obj;
		
		if ( (this.boxId == null && other.getBoxId() != null ) || 
				( this.boxId != null && other.getBoxId() == null ) ) { 
			return false ; 
		}
		
		if ( !this.boxId.equals(other.getBoxId())) {
			return false ; 
		}
		
		if ( (this.musicId == null && other.getMusicId() != null ) || 
				( this.musicId != null && other.getMusicId() == null ) ) { 
			return false ; 
		}
		
		if ( !this.musicId.equals(other.getMusicId())) {
			return false ; 
		}
		
		return true ; 
	}
	
	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public String getMusicId() {
		return musicId;
	}

	public void setMusicId(String musicId) {
		this.musicId = musicId;
	} 
	
	
}
