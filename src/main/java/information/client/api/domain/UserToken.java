package information.client.api.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
DROP TABLE T_USER_TOKEN ;
CREATE TABLE T_USER_TOKEN (
	TOKEN VARCHAR(30) PRIMARY KEY,
	USER_ID VARCHAR(30) , 
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP
);
ALTER TABLE T_USER_TOKEN CONVERT TO CHARACTER SET UTF8;
 * */
@Entity
@Table(name = "t_user_token")
public class UserToken implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "token" , unique = true , nullable = false )
	private String token; 
	
	@Column(name = "user_id")
	private String userId ;
	
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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
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
