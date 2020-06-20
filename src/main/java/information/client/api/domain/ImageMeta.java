package information.client.api.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
DROP TABLE T_IMAGE_META ; 
CREATE TABLE T_IMAGE_META (
	IMAGE_ID VARCHAR(30) PRIMARY KEY, 
	MAPPING_ID VARCHAR(30) ,
	SUB_ID VARCHAR(30) ,
	IMAGE_TYPE VARCHAR(100) , 
	REGIST_DATE TIMESTAMP , 
	UPDATE_DATE TIMESTAMP
) ;
ALTER TABLE T_IMAGE_META CONVERT TO CHARACTER SET UTF8;
ALTER TABLE T_IMAGE_META ADD INDEX IMAGE_MAPPING (MAPPING_ID);
 * */
@Entity
@Table(name = "t_image_meta")
public class ImageMeta implements Serializable{
	private static final long serialVersionUID = 1L ;
	
	@Id
	@Column(name = "image_id" , nullable = false)
	private String imageId ;
	
	@Column(name = "mapping_id")
	private String mappingId ;
	
	@Column(name = "sub_id")
	private String subId ;
	
	@Column(name = "image_type")
	private String imageType ; 
	
	@Column(name = "regist_date")
	private Timestamp registDate ;
	
	@Column(name = "update_date")
	private Timestamp updateDate ;


	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
	}

	public String getMappingId() {
		return mappingId;
	}

	public void setMappingId(String mappingId) {
		this.mappingId = mappingId;
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

	public String getImageType() {
		return imageType;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public String getSubId() {
		return subId;
	}

	public void setSubId(String subId) {
		this.subId = subId;
	}
	
}
