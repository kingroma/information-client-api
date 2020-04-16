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
DROP TABLE T_CONTENT_PROGRAM ; 
CREATE TABLE T_CONTENT_PROGRAM (
	CONTENT_ID VARCHAR(30) , 
	PROGRAM_ID VARCHAR(30) ,
	SORT_SN INT , 
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP , 
	PRIMARY KEY ( CONTENT_ID , PROGRAM_ID ) 
) ;
ALTER TABLE T_CONTENT_PROGRAM CONVERT TO CHARACTER SET UTF8;
 * */
@Entity
@Table(name = "t_content_program")
public class ContentProgram implements Serializable{
	private static final long serialVersionUID = 1L ;
	
	@EmbeddedId
	private ContentProgramPK id;
	
	@Column(name = "sort_sn")
	private Integer sortSn ;
	 
	@Column(name = "regist_date")
	private Timestamp registDate ;
	
	@Column(name = "update_date")
	private Timestamp updateDate ;
	
	@ManyToOne
	@JoinColumn(name = "content_id" , insertable = false , updatable = false)
	private Content content;
	
	public ContentProgramPK getId() {
		
		return id;
	}

	public void setId(ContentProgramPK id) {
		this.id = id;
	}

	public Integer getSortSn() {
		return sortSn;
	}

	public void setSortSn(Integer sortSn) {
		this.sortSn = sortSn;
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

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}
	
	
}
