package information.client.api.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
DROP TABLE T_TIMELINE_PROGRAM ; 
CREATE TABLE T_TIMELINE_PROGRAM ( 
	TIMELINE_ID VARCHAR(30) ,
	PROGRAM_ID VARCHAR(30) , 
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP ,
	PRIMARY KEY (TIMELINE_ID , PROGRAM_ID )
) ;
ALTER TABLE T_TIMELINE_PROGRAM CONVERT TO CHARACTER SET UTF8; 
 * */
@Entity
@Table(name = "t_timeline_program")
public class TimelineProgram implements Serializable {
	private static final long serialVersionUID = 1L ;
	
	@EmbeddedId
	private TimelineProgramPK id ;
	
	@Column(name = "regist_date")
	private Timestamp registDate ;
	
	@Column(name = "update_date")
	private Timestamp updateDate ;

	@ManyToOne
	@JoinColumn(name = "timeline_id" , insertable = false , updatable = false )
	private Timeline timeline ;
	
	public TimelineProgramPK getId() {
		return id;
	}

	public void setId(TimelineProgramPK id) {
		this.id = id;
	}

	public Timestamp getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Timestamp registDate) {
		this.registDate = registDate;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public Timeline getTimeline() {
		return timeline;
	}

	public void setTimeline(Timeline timeline) {
		this.timeline = timeline;
	}
	
}
