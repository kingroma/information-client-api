package information.client.api.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_user_lol")
public class UserLol {
	@Id
	private String userId ; 
	
	private String lolUserId ; 
	
	private String lolUserNm ; 
	
	
}
