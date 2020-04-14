package information.client.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserWatchHistPK implements Serializable{
	private static final long serialVersionUID = 1L ;
	
	@Column(name = "user_id" , nullable = false )
	private String userId ; 
	
	@Column(name = "program_id" , nullable = false )
	private String programId ;
	
	@Column(name = "product_id" , nullable = false )
	private String productId ;
	
	@Override
	public int hashCode() {
		final int prime = 31 ; 
		int result = 1 ;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((programId == null) ? 0 : programId.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result ; 
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserWatchHistPK other = (UserWatchHistPK) obj;
		
		if ( (this.userId == null && other.getUserId() != null ) || 
				( this.userId != null && other.getUserId() == null ) ) { 
			return false ; 
		}
		
		if ( !this.userId.equals(other.getUserId())) {
			return false ; 
		}
		
		if ( (this.programId == null && other.getProgramId() != null ) || 
				( this.programId != null && other.getProgramId() == null ) ) { 
			return false ; 
		}
		
		if ( !this.programId.equals(other.getProgramId())) {
			return false ; 
		}
		
		if ( (this.productId == null && other.getProductId() != null ) || 
				( this.productId != null && other.getProductId() == null ) ) { 
			return false ; 
		}
		
		if ( !this.productId.equals(other.getProductId())) {
			return false ; 
		}
		
		return true ; 
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	
}
