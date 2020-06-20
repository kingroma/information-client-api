package information.client.api.responsedto;

import java.util.ArrayList;
import java.util.List;

public class TimelineDto {
	private String timelineId ; 
	
	private String title ; 
	
	private String text ;
	
	private List<ImageMetaDto> imageMeta ;
	
	private List<TimelineProgramDto> timelineProgram = new ArrayList<TimelineProgramDto>();

	public String getTimelineId() {
		return timelineId;
	}

	public void setTimelineId(String timelineId) {
		this.timelineId = timelineId;
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

	public List<TimelineProgramDto> getTimelineProgram() {
		return timelineProgram;
	}

	public void setTimelineProgram(List<TimelineProgramDto> timelineProgram) {
		this.timelineProgram = timelineProgram;
	}

	public List<ImageMetaDto> getImageMeta() {
		return imageMeta;
	}

	public void setImageMeta(List<ImageMetaDto> imageMeta) {
		this.imageMeta = imageMeta;
	}

	
}
