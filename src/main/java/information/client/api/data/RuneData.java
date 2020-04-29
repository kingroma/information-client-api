package information.client.api.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import information.client.api.util.DomainUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RuneData {
	private Integer runeId;

	private Integer rank;

	public Integer getRuneId() {
		return runeId;
	}

	public void setRuneId(Integer runeId) {
		this.runeId = runeId;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return DomainUtil.changeObjValueToString(this);
	}
}
