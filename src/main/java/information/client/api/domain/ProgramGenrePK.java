package information.client.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProgramGenrePK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "program_id", nullable = false)
	private String programId ; 
	
	@Column(name = "genre_id", nullable = false)
	private String genreId ;  
	
	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getGenreId() {
		return genreId;
	}

	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}

	@Override
	public int hashCode() {
		final int prime = 31 ; 
		int result = 1 ; 
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((genreId == null) ? 0 : genreId.hashCode());
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
		ProgramGenrePK other = (ProgramGenrePK) obj;
		
		if ( (this.programId == null && other.getProgramId() != null ) || 
				( this.programId != null && other.getProgramId() == null ) ) { 
			return false ; 
		}
		
		if ( !this.programId.equals(other.getProgramId())) {
			return false ; 
		}
		
		if ( (this.genreId == null && other.getGenreId() != null ) || 
				( this.genreId != null && other.getGenreId() == null ) ) { 
			return false ; 
		}
		
		if ( !this.genreId.equals(other.getGenreId())) {
			return false ; 
		}
		
		return true ; 
	}
	
}
