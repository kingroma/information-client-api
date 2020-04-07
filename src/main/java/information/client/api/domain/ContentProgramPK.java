package information.client.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ContentProgramPK implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "content_id" , nullable = false )
	private String contentId ; 
	
	@Column(name = "program_id" , nullable = false)
	private String programId ; 
	
	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	@Override
	public int hashCode() {
		final int prime = 31 ; 
		int result = 1 ; 
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((contentId == null) ? 0 : contentId.hashCode());
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
		ContentProgramPK other = (ContentProgramPK) obj;
		
		if ( (this.programId == null && other.getProgramId() != null ) || 
				( this.programId != null && other.getProgramId() == null ) ) { 
			return false ; 
		}
		
		if ( !this.programId.equals(other.getProgramId())) {
			return false ; 
		}
		
		if ( (this.contentId == null && other.getContentId() != null ) || 
				( this.contentId != null && other.getContentId() == null ) ) { 
			return false ; 
		}
		
		if ( !this.contentId.equals(other.getContentId())) {
			return false ; 
		}
		
		return true ; 
	}
}
