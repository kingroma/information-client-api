package information.client.api.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
DROP TABLE T_CODE ; 
CREATE TABLE T_CODE (
	CODE_ID VARCHAR(30) , 
	
	VALUE1 VARCHAR(100) ,
	VALUE2 VARCHAR(100) ,
	VALUE3 VARCHAR(100) ,
	VALUE4 VARCHAR(100) ,
	VALUE5 VARCHAR(100) ,
	
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP , 
	PRIMARY KEY ( CODE_ID ) 
) ;
ALTER TABLE T_CODE CONVERT TO CHARACTER SET UTF8;
 * */

@Entity
@Table(name = "t_code")
public class Code implements Serializable{
	private static final long serialVersionUID = 1L ;
	
	@Id
	@Column( name = "code_id" )
	private String codeId ;
	
	@Column(name = "value1")
	private String value1 ;
	
	@Column(name = "value2")
	private String value2 ; 
	
	@Column(name = "value3")
	private String value3 ;
	
	@Column(name = "value4")
	private String value4 ;
	
	@Column(name = "value5")
	private String value5 ;
	
	@Column(name = "regist_date")
	private Timestamp registDate ;
	
	@Column(name = "update_date")
	private Timestamp updateDate ;

	public String getCodeId() {
		return codeId;
	}

	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public String getValue4() {
		return value4;
	}

	public void setValue4(String value4) {
		this.value4 = value4;
	}

	public String getValue5() {
		return value5;
	}

	public void setValue5(String value5) {
		this.value5 = value5;
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
