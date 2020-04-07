package information.client.api.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
DROP TABLE T_CONTENT_PROGRAM ; 
CREATE TABLE T_CONTENT_PROGRAM (
	CONTENT_ID VARCHAR(30) , 
	PROGRAM_ID VARCHAR(30) ,
	CONTENT_TYPE VARCHAR(100) , 
	SORT_SN INT , 
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP
) ;
ALTER TABLE T_CONTENT_PROGRAM CONVERT TO CHARACTER SET UTF8;
 * */
@Entity
@Table(name = "t_content_program")
public class ContentProgram implements Serializable{
	private static final long serialVersionUID = 1L ;
	
	public enum ContentType {
		MAIN , 
	}
	
	@EmbeddedId
	private ContentProgramPK id;
	
	@Column(name = "content_type")
	private ContentType contentType ;
	
	@Column(name = "sort_sn")
	private Integer sortSn ;
	 
	@Column(name = "regist_date")
	private Timestamp registDate ;
	
	@Column(name = "update_date")
	private Timestamp updateDate ;

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

	public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}
	
	
}
