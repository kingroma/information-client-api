package information.client.api.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
DROP TABLE T_PROGRAM_PRODUCT ; 
CREATE TABLE T_PROGRAM_PRODUCT ( 
	PROGRAM_ID VARCHAR(30) ,
	PRODUCT_ID VARCHAR(30) , 
	TITLE VARCHAR(100) , 
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP
) ;
ALTER TABLE T_PROGRAM_PRODUCT CONVERT TO CHARACTER SET UTF8; 
 * */
@Entity
@Table(name = "t_program_product")
public class ProgramProduct implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProgramProductPK id ;
	
	@Column(name = "title")
	private String title ;
	
	@Column(name = "regist_date")
	private Timestamp registDate ;
	
	@Column(name = "update_date")
	private Timestamp updateDate ;
	
	@ManyToOne
	@JoinColumn(name = "program_id", insertable = false , updatable = false)
	private Program progarm;
	
	
	public ProgramProductPK getId() {
		return id;
	}

	public void setId(ProgramProductPK id) {
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

	public Program getProgarm() {
		return progarm;
	}

	public void setProgarm(Program progarm) {
		this.progarm = progarm;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public int hashCode() {
		final int prime = 31  ; 
		int result = 1 ; 
		result = prime * result + ((id == null ) ? 0 : id.hashCode()) ;
		return result ; 
	}
	
}
