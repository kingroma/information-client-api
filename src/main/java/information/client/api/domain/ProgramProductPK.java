package information.client.api.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProgramProductPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "program_id",nullable = false )
	private String programId ; 
	
	@Column(name = "product_id",nullable = false )
	private String productId;
	
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

	@Override
	public int hashCode() {
		final int prime = 31 ; 
		int result = 1 ; 
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
		ProgramProductPK other = (ProgramProductPK) obj;
		
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
	
}
