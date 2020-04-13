package information.client.api.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
DROP TABLE T_TIMELINE ; 
CREATE TABLE T_TIMELINE ( 
	TIMELINE_ID VARCHAR(30) PRIMARY KEY ,
	TITLE VARCHAR(100) ,
	TEXT VARCHAR(1000) ,  
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP
) ;
ALTER TABLE T_TIMELINE CONVERT TO CHARACTER SET UTF8; 
 * */
@Entity
@Table(name = "t_timeline")
public class Timeline implements Serializable{
	private static final long serialVersionUID = 1L ; 
	
	@Id
	@Column(name = "timeline_id" , unique = true , nullable = false , length = 30)
	private String timelineId ; 

	@Column(name = "title")
	private String title ; 
	
	@Column(name = "text")
	private String text ; 
	
	@Column(name = "regist_date")
	private Timestamp registDate ;
	
	@Column(name = "update_date")
	private Timestamp updateDate ;

	@OneToMany(mappedBy = "timeline" , fetch = FetchType.LAZY)
	private List<TimelineProgram> timelineProgram ; 
	
	
	public String getTimelineId() {
		return timelineId;
	}

	public void setTimelineId(String timelineId) {
		this.timelineId = timelineId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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

	public List<TimelineProgram> getTimelineProgram() {
		return timelineProgram;
	}

	public void setTimelineProgram(List<TimelineProgram> timelineProgram) {
		this.timelineProgram = timelineProgram;
	}
	
	
}
