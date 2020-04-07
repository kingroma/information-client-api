package information.client.api.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
DROP TABLE T_CONTENT ; 
CREATE TABLE T_CONTENT (
	CONTENT_ID VARCHAR(30) , 
	CONTENT_NAME VARCHAR(100) ,
	SORT_SN INT , 
	USE_AT VARCHAR(1) ,
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP
) ;
ALTER TABLE T_CONTENT CONVERT TO CHARACTER SET UTF8;
 * */
@Entity
@Table(name = "t_content")
public class Content implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "content_id" , unique = true , nullable = false , length = 30)
	private String contentId ; 
	
	@Column(name = "content_name")
	private String contentName ; 
	
	@Column(name = "sort_sn")
	private Integer sortSn ;
	
	@Column(name = "useAt")
	private String useAt ;
	
	@Column(name = "regist_date")
	private Timestamp registDate ;
	
	@Column(name = "update_date")
	private Timestamp updateDate ;

	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public Integer getSortSn() {
		return sortSn;
	}

	public void setSortSn(Integer sortSn) {
		this.sortSn = sortSn;
	}

	public String getUseAt() {
		return useAt;
	}

	public void setUseAt(String useAt) {
		this.useAt = useAt;
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
	
	
}
