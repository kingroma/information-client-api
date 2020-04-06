package information.client.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
create table t_test (
	uuid varchar(30) primary key , 
    text varchar(100) 
);
 * */
@Entity
@Table(name = "t_test")
public class Test implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "uuid" , unique = true , nullable = false , length = 30 )
	private String uuid;
	
	@Column(name = "text" , length = 100 )
	private String text ;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	} 
}
