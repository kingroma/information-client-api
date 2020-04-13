package information.client.api.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
DROP TABLE T_PROGRAM_GENRE ; 
CREATE TABLE T_PROGRAM_GENRE (
	PROGRAM_ID VARCHAR(30) , 
	GENRE_ID VARCHAR(30) ,
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP,
	PRIMARY KEY ( GENRE_ID , PROGRAM_ID )
) ;
ALTER TABLE T_PROGRAM_GENRE CONVERT TO CHARACTER SET UTF8;
 * */
@Entity
@Table(name = "t_program_genre")
public class ProgramGenre implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private ProgramGenrePK id ;
	
	@Column(name = "regist_date")
	private Timestamp registDate ;
	
	@Column(name = "update_date")
	private Timestamp updateDate ;
	
	@ManyToOne
	@JoinColumn(name = "program_id", insertable = false , updatable = false)
	private Program progarm;
	
	@ManyToOne
	@JoinColumn(name = "genre_id", insertable = false , updatable = false)
	private Genre genre;
	
	@Override
	public int hashCode() {
		final int prime = 31  ; 
		int result = 1 ; 
		result = prime * result + ((id == null ) ? 0 : id.hashCode()) ;
		return result ; 
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}

	public ProgramGenrePK getId() {
		return id;
	}

	public void setId(ProgramGenrePK id) {
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

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	
}
