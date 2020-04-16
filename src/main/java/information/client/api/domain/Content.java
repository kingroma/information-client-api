package information.client.api.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
DROP TABLE T_CONTENT ; 
CREATE TABLE T_CONTENT (
	CONTENT_ID VARCHAR(30) PRIMARY KEY , 
	CONTENT_NAME VARCHAR(100) ,
	CONTENT_TYPE VARCHAR(100) , 
	SORT_SN INT DEFAULT 99 , 
	USE_AT VARCHAR(1) DEFAULT 'Y',
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP
) ;
ALTER TABLE T_CONTENT CONVERT TO CHARACTER SET UTF8;
 * */
@Entity
@Table(name = "t_content")
public class Content implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public enum ContentType {
		top, basic, issue
	}
	
	@Id
	@Column(name = "content_id" , unique = true , nullable = false , length = 30)
	private String contentId ; 
	
	@Column(name = "content_name")
	private String contentName ; 
	
	@Enumerated(EnumType.STRING)
	@Column(name = "content_type")
	private ContentType contentType ;
	
	@Column(name = "sort_sn")
	private Integer sortSn ;
	
	@Column(name = "use_at")
	private String useAt ;
	
	@Column(name = "regist_date")
	private Timestamp registDate ;
	
	@Column(name = "update_date")
	private Timestamp updateDate ;
	
	@OneToMany(mappedBy = "content" , fetch = FetchType.LAZY)
	private List<ContentProgram> contentProgram;

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

	public List<ContentProgram> getContentProgram() {
		return contentProgram;
	}

	public void setContentProgram(List<ContentProgram> contentProgram) {
		this.contentProgram = contentProgram;
	}

	public ContentType getContentType() {
		return contentType;
	}

	public void setContentType(ContentType contentType) {
		this.contentType = contentType;
	}
	
	public void setContentType(String contentType) {
		if ( contentType != null ) {
			if ( "basic".equalsIgnoreCase(contentType)) {
				this.contentType = ContentType.basic;
			}else if ( "top".equalsIgnoreCase(contentType)) {
				this.contentType = ContentType.top;
			}else if ( "issue".equalsIgnoreCase(contentType)) {
				this.contentType = ContentType.issue;
			}
		}
	}
	
	public static ContentType getContentTypeByString(String contentType) {
		ContentType result = null ; 
		if ( contentType != null ) {
			if ( "basic".equalsIgnoreCase(contentType)) {
				result = ContentType.basic;
			}else if ( "top".equalsIgnoreCase(contentType)) {
				result = ContentType.top;
			}else if ( "issue".equalsIgnoreCase(contentType)) {
				result = ContentType.issue;
			}
		}
		return result ; 
	}
}
