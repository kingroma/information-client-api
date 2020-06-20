package information.client.api.responsedto;

import java.util.List;

import information.client.api.domain.Content.ContentType;

public class ContentDto {
	private String contentId ; 
	
	private String contentName ; 
	
	private String contentType ; 
	
	private List<ContentProgramDto> list;

	private String useAt = null ; 
	
	private String sortSn = null ; 
	
	public String getContentId() {
		return contentId;
	}

	public void setContentId(String contentId) {
		this.contentId = contentId;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public List<ContentProgramDto> getList() {
		return list;
	}

	public void setList(List<ContentProgramDto> list) {
		this.list = list;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getUseAt() {
		return useAt;
	}

	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

	public String getSortSn() {
		return sortSn;
	}

	public void setSortSn(String sortSn) {
		this.sortSn = sortSn;
	} 
	
}
