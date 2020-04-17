package information.client.api.responsedto;

import java.util.List;

public class ContentProgramDto {
	private String programId ;
	
	private String title ;
	
	private List<ImageMetaDto> imageMeta ; 
	
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

	public List<ImageMetaDto> getImageMeta() {
		return imageMeta;
	}

	public void setImageMeta(List<ImageMetaDto> imageMeta) {
		this.imageMeta = imageMeta;
	} 
	
}
