package information.client.api.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
DROP TABLE T_PROGRAM ;
CREATE TABLE T_PROGRAM (
	PROGRAM_ID VARCHAR(30) PRIMARY KEY ,
	TITLE VARCHAR(100) , 
	PROGRAM_TYPE VARCHAR(30) , 
	SYNOPSIS VARCHAR(200) , 
	WATCH_COUNT INT ,
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP 
) ;
ALTER TABLE T_PROGRAM CONVERT TO CHARACTER SET UTF8;
 * */
@Entity
@Table(name = "t_program")
public class Program implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static enum ProgramType  {
		programBasic , programSeries 
	}
	
	@Id
	@Column(name = "program_id" , unique = true , nullable = false , length = 30 )
	private String programId ; 
	
	@Column(name = "title")
	private String title ; 
	
	@Column(name = "program_type")
	private String programType ;
	
	@Column(name = "synopsis")
	private String synopsis ; 
	
	@Column(name = "watch_count")
	private Integer watchCount ;
	
	@Column(name = "regist_date")
	private Timestamp registDate ;
	
	@Column(name = "update_date")
	private Timestamp updateDate ;
	
	@OneToMany(mappedBy = "progarm",fetch=FetchType.LAZY)
	private List<ProgramGenre> programGenre ;

	@OneToMany(mappedBy = "progarm",fetch=FetchType.LAZY)
	private List<ProgramProduct> programProduct ;
	
	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
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

	public List<ProgramGenre> getProgramGenre() {
		return programGenre;
	}

	public void setProgramGenre(List<ProgramGenre> programGenre) {
		this.programGenre = programGenre;
	}

	public List<ProgramProduct> getProgramProduct() {
		return programProduct;
	}

	public void setProgramProduct(List<ProgramProduct> programProduct) {
		this.programProduct = programProduct;
	} 

	public String getProgramType() {
		return programType;
	}

	public void setProgramType(String programType) {
		this.programType = programType;
	}

	public Integer getWatchCount() {
		return watchCount;
	}

	public void setWatchCount(Integer watchCount) {
		this.watchCount = watchCount;
	}

	@Override
	public int hashCode() {
		final int prime = 31 ; 
		int result = 1 ; 
		result = prime * result + ((programId == null ) ? 0 : programId.hashCode() );
		
		return result ; 
	}
	
}
