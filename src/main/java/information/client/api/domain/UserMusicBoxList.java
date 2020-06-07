package information.client.api.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
DROP TABLE T_USER_MUSIC_BOX_LIST ; 
CREATE TABLE T_USER_MUSIC_BOX_LIST (
	BOX_ID VARCHAR(30) , 
	MUSIC_ID VARCHAR(30) ,
	SORT_SN INT ,
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP
	PRIMARY KEY ( BOX_ID , MUSIC_ID )
) ;
ALTER TABLE T_USER_MUSIC_BOX_LIST CONVERT TO CHARACTER SET UTF8;
 * */

@Entity
@Table(name = "t_user_music_box_list")
public class UserMusicBoxList implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private UserMusicBoxListPK id;
	
	@Column(name = "sort_sn")
	private Integer sortSn;
	
	@Column(name = "regist_date")
	private Timestamp registDate ;
	
	@Column(name = "update_date")
	private Timestamp updateDate ;

	public UserMusicBoxListPK getId() {
		return id;
	}

	public void setId(UserMusicBoxListPK id) {
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
	
	
}
