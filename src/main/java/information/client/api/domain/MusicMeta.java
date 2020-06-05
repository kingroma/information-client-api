package information.client.api.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * 
DROP TABLE T_MUSIC_META ; 
CREATE TABLE T_MUSIC_META (
	MUSIC_ID VARCHAR(30) PRIMARY KEY, 
	MUSIC_NAME VARCHAR(100) ,
	ARTIST VARCHAR(100) ,
	DESCRIPTION VARCHAR(1000) , 
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP
) ;
ALTER TABLE T_MUSIC_META CONVERT TO CHARACTER SET UTF8;
 * */

public class MusicMeta implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "music_id" , nullable = false)
	private String musicId;
	
	@Column(name = "music_name")
	private String musicName ;
	
	@Column(name = "artist")
	private String artist ;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "regist_date")
	private Timestamp registDate ;
	
	@Column(name = "update_date")
	private Timestamp updateDate ;

	public String getMusicId() {
		return musicId;
	}

	public void setMusicId(String musicId) {
		this.musicId = musicId;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
