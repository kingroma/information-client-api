package information.client.api.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
DROP TABLE T_USER_WATCH_HIST;
CREATE TABLE T_USER_WATCH_HIST (
	USER_ID VARCHAR(30) , 
	PROGRAM_ID VARCHAR(30) , 
	PRODUCT_ID VARCHAR(30) , 
	REGIST_DATE TIMESTAMP DEFAULT NOW(), 
	UPDATE_DATE TIMESTAMP , 
	PRIMARY KEY (USER_ID , PROGRAM_ID , PRODUCT_ID)
) ; 
ALTER TABLE T_USER_WATCH_HIST CONVERT TO CHARACTER SET UTF8;
 * */
@Entity
@Table(name = "t_user_watch_hist")
public class UserWatchHist implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private UserWatchHistPK id ;
	
	@Column(name = "regist_date")
	private Timestamp registDate ;
	
	@Column(name = "update_date")
	private Timestamp updateDate ;

	public UserWatchHistPK getId() {
		return id;
	}

	public void setId(UserWatchHistPK id) {
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
	
	
}
