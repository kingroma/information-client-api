package information.client.api.data;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import information.client.api.util.DomainUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SummonerData {
	private String id;

	private String accountId;

	private String puuid;

	private String name;

	private Integer profileIconId;

	private Long revisionDate;

	private Integer summonerLevel;

	public SummonerData() {
	}

	public SummonerData(Map<String, Object> map) {
		if (map != null) {
			this.id = (String) map.get("id");
			this.accountId = (String) map.get("accountId");
			this.puuid = (String) map.get("puuid");
			this.name = (String) map.get("name");
			this.profileIconId = (Integer) (map.get("profileIconId"));
			this.revisionDate = (Long) (map.get("revisionDate"));
			this.summonerLevel = (Integer) (map.get("summonerLevel"));
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getPuuid() {
		return puuid;
	}

	public void setPuuid(String puuid) {
		this.puuid = puuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getProfileIconId() {
		return profileIconId;
	}

	public void setProfileIconId(Integer profileIconId) {
		this.profileIconId = profileIconId;
	}

	public Long getRevisionDate() {
		return revisionDate;
	}

	public Date getRevisionDateToDate() {
		return new Date(revisionDate);
	}

	public void setRevisionDate(Long revisionDate) {
		this.revisionDate = revisionDate;
	}

	public Integer getSummonerLevel() {
		return summonerLevel;
	}

	public void setSummonerLevel(Integer summonerLevel) {
		this.summonerLevel = summonerLevel;
	}

	@Override
	public String toString() {
		return DomainUtil.changeObjValueToString(this);
	}
}
