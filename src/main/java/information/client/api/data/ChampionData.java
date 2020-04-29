package information.client.api.data;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import information.client.api.util.DomainUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChampionData {
	private String version ;
	
	private String id ; 
	
	private String key ; 
	
	private String name ; 
	
	private String title ;
	
	private String iconImageUrl = "";
	
	private String screenImageUrl = "";
	
	public ChampionData() {}
	
	public ChampionData(Map<String,Object> map) {
		if ( map != null ) {
			this.version = (String)map.get("version");
			this.id = (String)map.get("id");
			this.key = (String)map.get("key");
			this.name = (String)map.get("name");
			this.title = (String)map.get("title");
		}
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Override
	public String toString() {
		return DomainUtil.changeObjValueToString(this);
	}

	public String getIconImageUrl() {
		return iconImageUrl;
	}

	public void setIconImageUrl(String iconImageUrl) {
		this.iconImageUrl = iconImageUrl;
	}

	public String getScreenImageUrl() {
		return screenImageUrl;
	}

	public void setScreenImageUrl(String screenImageUrl) {
		this.screenImageUrl = screenImageUrl;
	}
}
