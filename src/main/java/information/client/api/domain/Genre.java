package information.client.api.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
DROP TABLE T_GENRE ; 
CREATE TABLE T_GENRE(
	GENRE_ID VARCHAR(30) PRIMARY KEY , 
	GENRE_NAME VARCHAR(100) , 
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP 
);
ALTER TABLE T_GENRE CONVERT TO CHARACTER SET UTF8;
 * */
@Entity
@Table(name = "t_genre")
public class Genre implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "genre_id" , unique = true , nullable = false , length = 30 )
	private String genreId ;
	
	@Column(name = "genre_name")
	private String genreName ; 
	
	@Column(name = "regist_date")
	private Timestamp registDate ;
	
	@Column(name = "update_date")
	private Timestamp updateDate ;
	
	@OneToMany(mappedBy = "genre" , fetch = FetchType.LAZY)
	private List<ProgramGenre> programGenre ;

	public String getGenreId() {
		return genreId;
	}

	public void setGenreId(String genreId) {
		this.genreId = genreId;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public List<ProgramGenre> getProgramGenre() {
		return programGenre;
	}

	public void setProgramGenre(List<ProgramGenre> programGenre) {
		this.programGenre = programGenre;
	}
	
	
}
