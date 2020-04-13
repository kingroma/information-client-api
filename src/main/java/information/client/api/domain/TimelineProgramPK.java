package information.client.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TimelineProgramPK implements Serializable{
	private static final long serialVersionUID = 1L ;
	
	@Column(name = "timeline_id" , nullable = false )
	private String timelineId ; 
	
	@Column(name = "program_id" , nullable = false)
	private String programId ;

	@Override
	public int hashCode() {
		final int prime = 31 ; 
		int result = 1 ;
		result = prime * result + ((timelineId == null) ? 0 : timelineId.hashCode());
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
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
		TimelineProgramPK other = (TimelineProgramPK) obj;
		
		if ( (this.programId == null && other.getProgramId() != null ) || 
				( this.programId != null && other.getProgramId() == null ) ) { 
			return false ; 
		}
		
		if ( !this.programId.equals(other.getProgramId())) {
			return false ; 
		}
		
		if ( (this.timelineId == null && other.getTimelineId() != null ) || 
				( this.timelineId != null && other.getTimelineId() == null ) ) { 
			return false ; 
		}
		
		if ( !this.timelineId.equals(other.getTimelineId())) {
			return false ; 
		}
		
		return true ; 
	}
	
	public String getTimelineId() {
		return timelineId;
	}

	public void setTimelineId(String timelineId) {
		this.timelineId = timelineId;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	} 
}
