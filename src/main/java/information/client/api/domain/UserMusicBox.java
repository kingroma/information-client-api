package information.client.api.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
DROP TABLE T_USER_MUSIC_BOX ; 
CREATE TABLE T_USER_MUSIC_BOX ( 
	BOX_ID VARCHAR(30) ,
	BOX_NAME VARCHAR(30) , 
	USER_ID VARCHAR(100) , 
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP , 
	PRIMARY KEY (BOX_ID)
) ;
ALTER TABLE T_USER_MUSIC_BOX CONVERT TO CHARACTER SET UTF8; 
 * */

@Entity
@Table(name = "t_user_music_box")
public class UserMusicBox implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "box_id")
	private String boxId ; 
	
	@Column(name = "box_name")
	private String boxName ; 
	
	@Column(name = "user_id")
	private String userId ;
	
	@Column(name = "regist_date")
	private Timestamp registDate ;
	
	@Column(name = "update_date")
	private Timestamp updateDate ;

	public String getBoxId() {
		return boxId;
	}

	public void setBoxId(String boxId) {
		this.boxId = boxId;
	}

	public String getBoxName() {
		return boxName;
	}

	public void setBoxName(String boxName) {
		this.boxName = boxName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
