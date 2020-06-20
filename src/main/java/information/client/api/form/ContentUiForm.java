package information.client.api.form;

import java.util.List;

import information.client.api.util.DomainUtil;

public class ContentUiForm {
	private String contentId;

	private String contentName;
	
	private String contentType;
	
	private String sortSn;
	
	private String useAt;

	private List<String> programId;
	
	private List<String> title;
	
	private List<String> imageId;
	
	private List<String> imageType;

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

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getSortSn() {
		return sortSn;
	}

	public void setSortSn(String sortSn) {
		this.sortSn = sortSn;
	}

	public String getUseAt() {
		return useAt;
	}

	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

	public List<String> getProgramId() {
		return programId;
	}

	public void setProgramId(List<String> programId) {
		this.programId = programId;
	}

	public List<String> getTitle() {
		return title;
	}

	public void setTitle(List<String> title) {
		this.title = title;
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

	@Override
	public String toString() {
		return DomainUtil.changeObjValueToString(this);
	}
}
