package information.client.api.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
DROP TABLE T_USER ;
CREATE TABLE T_USER (
	USER_ID VARCHAR(30) PRIMARY KEY , 
	USER_PW VARCHAR(30) , 
	USER_NM VARCHAR(30) , 
	SUMMONER_ID VARCHAR(30) , 
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP
);
ALTER TABLE T_USER CONVERT TO CHARACTER SET UTF8;
 * */
@Entity
@Table(name = "t_user")
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "user_id" , unique = true , nullable = false )
	private String userId;

	@Column(name = "user_pw")
	private String userPw;
	
	@Column(name = "user_nm")
	private String userNm ;

	@Column(name = "summoner_id")
	private String summonerId ; 
	
	@Column(name = "regist_date")
	private Timestamp registDate ;
	
	@Column(name = "update_date")
	private Timestamp updateDate ;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
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

	public String getSummonerId() {
		return summonerId;
	}

	public void setSummonerId(String summonerId) {
		this.summonerId = summonerId;
	}
	
	
	
}
