package information.client.api.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import information.client.api.util.DomainUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MasteryData {
	private Integer rank;
	private Integer masteryId;

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Integer getMasteryId() {
		return masteryId;
	}

	public void setMasteryId(Integer masteryId) {
		this.masteryId = masteryId;
	}

	@Override
	public String toString() {
		return DomainUtil.changeObjValueToString(this);
	}

}
