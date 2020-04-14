package information.client.api.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
DROP TABLE T_USER_LIKE ;
CREATE TABLE T_USER_LIKE (
	LIKE_ID VARCHAR(30) PRIMARY KEY,
	MAPPING_ID VARCHAR(30) , 
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP 
) ; 
ALTER TABLE T_USER_LIKE CONVERT TO CHARACTER SET UTF8; 
ALTER TABLE T_USER_LIKE ADD INDEX USER_LIKE_MAPPING (MAPPING_ID);
 * */
@Entity
@Table(name = "t_user_like")
public class UserLike implements Serializable{
	private static final long serialVersionUID = 1L ;
	
	@Id
	@Column(name = "like_id" , nullable = false)
	private String likeId ; 	
	
	@Column(name = "mapping_id")
	private String mappingId ;
	
	@Column(name = "regist_date")
	private Timestamp registDate ;
	
	@Column(name = "update_date")
	private Timestamp updateDate ;

	public String getLikeId() {
		return likeId;
	}

	public void setLikeId(String likeId) {
		this.likeId = likeId;
	}

	public String getMappingId() {
		return mappingId;
	}

	public void setMappingId(String mappingId) {
		this.mappingId = mappingId;
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
