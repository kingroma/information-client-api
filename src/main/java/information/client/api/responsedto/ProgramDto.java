package information.client.api.responsedto;

import java.util.List;

public class ProgramDto {
	private String programId ;
	
	private String title ;
	
	private String synopsis ;
	
	private String programType ;

	private List<String> genres ; 
	
	private List<ProgramProductDto> products;
	
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

	public List<String> getGenres() {
		return genres;
	}

	public String getProgramType() {
		return programType;
	}

	public void setProgramType(String programType) {
		this.programType = programType;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<ProgramProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProgramProductDto> products) {
		this.products = products;
	}


}
