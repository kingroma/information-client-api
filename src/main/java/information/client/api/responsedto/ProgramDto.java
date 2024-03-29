package information.client.api.responsedto;

import java.util.List;

public class ProgramDto {
	private String programId ;
	
	private String title ;
	
	private String synopsis ;
	
	private String programType ;
	
	private String useAt ;

	private List<String> genres ; 
	
	private List<ProgramProductDto> products;
	
	private List<ProgramImageMetaDto> imageMeta ;
	
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

	public List<ProgramImageMetaDto> getImageMeta() {
		return imageMeta;
	}

	public void setImageMeta(List<ProgramImageMetaDto> imageMeta) {
		this.imageMeta = imageMeta;
	}

	public String getUseAt() {
		return useAt;
	}

	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

	

}
