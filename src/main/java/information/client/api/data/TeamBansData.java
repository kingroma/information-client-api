package information.client.api.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import information.client.api.util.DomainUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamBansData {
	private Integer championId ;
	
	private Integer pickTurn ;

	public Integer getChampionId() {
		return championId;
	}

	public void setChampionId(Integer championId) {
		this.championId = championId;
	}

	public Integer getPickTurn() {
		return pickTurn;
	}

	public void setPickTurn(Integer pickTurn) {
		this.pickTurn = pickTurn;
	}
	
	@Override
	public String toString() {
		return DomainUtil.changeObjValueToString(this);
	}
}
