package information.client.api.responsedto;

import java.util.List;

public class ProgramProductDto {
	private String programId ; 
	
	private String productId ; 
	
	private String title ;
	
	private String text ; 
	
	private String season ; 
	
	private String episode ; 
	
	private String useAt ;
	
	private List<ImageMetaDto> imageMeta ;
	
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
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getEpisode() {
		return episode;
	}

	public void setEpisode(String episode) {
		this.episode = episode;
	}

	public String getUseAt() {
		return useAt;
	}

	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

	public List<ImageMetaDto> getImageMeta() {
		return imageMeta;
	}

	public void setImageMeta(List<ImageMetaDto> imageMeta) {
		this.imageMeta = imageMeta;
	} 
	
	
}
