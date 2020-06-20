package information.client.api.form;

import java.util.List;

import information.client.api.util.DomainUtil;

public class ProgramUiForm {
	private String programId ; 
	
	private String title ; 
	
	private String programType ; 
	
	private String synopsis ; 
	
	private String useAt ;
	
	private List<String> genres ; 
	
	private List<String> imageId ; 
	
	private List<String> imageType ;
	
	private List<String> productId;

	private List<String> season ;
	
	private List<String> episode ; 

	private List<String> programProductTitle ; 
	
	private List<String> programProductText;
	
	private List<String> programProductUseAt;
	
	private List<String> programProductImageProductId ; 
	
	private List<String> programProductImageId ; 
	
	private List<String> programProductImageType ; 

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

	public String getProgramType() {
		return programType;
	}

	public void setProgramType(String programType) {
		this.programType = programType;
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

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<String> getImageId() {
		return imageId;
	}

	public void setImageId(List<String> imageId) {
		this.imageId = imageId;
	}

	public List<String> getImageType() {
		return imageType;
	}

	public void setImageType(List<String> imageType) {
		this.imageType = imageType;
	}

	public List<String> getProductId() {
		return productId;
	}

	public void setProductId(List<String> productId) {
		this.productId = productId;
	}

	public List<String> getSeason() {
		return season;
	}

	public void setSeason(List<String> season) {
		this.season = season;
	}

	public List<String> getEpisode() {
		return episode;
	}

	public void setEpisode(List<String> episode) {
		this.episode = episode;
	}

	public List<String> getProgramProductTitle() {
		return programProductTitle;
	}

	public void setProgramProductTitle(List<String> programProductTitle) {
		this.programProductTitle = programProductTitle;
	}

	public List<String> getProgramProductText() {
		return programProductText;
	}

	public void setProgramProductText(List<String> programProductText) {
		this.programProductText = programProductText;
	} 
	
	
	
	public String getUseAt() {
		return useAt;
	}

	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

	public List<String> getProgramProductUseAt() {
		return programProductUseAt;
	}

	public void setProgramProductUseAt(List<String> programProductUseAt) {
		this.programProductUseAt = programProductUseAt;
	}
	
	public List<String> getProgramProductImageId() {
		return programProductImageId;
	}

	public void setProgramProductImageId(List<String> programProductImageId) {
		this.programProductImageId = programProductImageId;
	}

	public List<String> getProgramProductImageType() {
		return programProductImageType;
	}

	public void setProgramProductImageType(List<String> programProductImageType) {
		this.programProductImageType = programProductImageType;
	}

	public List<String> getProgramProductImageProductId() {
		return programProductImageProductId;
	}

	public void setProgramProductImageProductId(List<String> programProductImageProductId) {
		this.programProductImageProductId = programProductImageProductId;
	}

	@Override
	public String toString() {
		return DomainUtil.changeObjValueToString(this);
	}
}
