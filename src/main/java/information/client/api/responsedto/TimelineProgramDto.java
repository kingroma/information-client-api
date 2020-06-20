package information.client.api.responsedto;

import java.util.ArrayList;
import java.util.List;

public class TimelineProgramDto {
	private String programId ; 
	
	private List<ImageMetaDto> imageMeta ; 

	public String getProgramId() {
		return programId;
	}

	public void setProgramId(String programId) {
		this.programId = programId;
	}

	public List<ImageMetaDto> getImageMeta() {
		return imageMeta;
	}

	public void setImageMeta(List<ImageMetaDto> imageMeta) {
		this.imageMeta = imageMeta;
	}

	
	
}
