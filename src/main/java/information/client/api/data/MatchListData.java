package information.client.api.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import information.client.api.util.DomainUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MatchListData {
	private List<MatchReferenceData> matches ;
	
	private Integer startIndex ; 
	
	private Integer endIndex ; 
	
	private Integer totalGames ;

	public List<MatchReferenceData> getMatches() {
		return matches;
	}

	public void setMatches(List<MatchReferenceData> matches) {
		this.matches = matches;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(Integer startIndex) {
		this.startIndex = startIndex;
	}

	public Integer getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(Integer endIndex) {
		this.endIndex = endIndex;
	}

	public Integer getTotalGames() {
		return totalGames;
	}

	public void setTotalGames(Integer totalGames) {
		this.totalGames = totalGames;
	}
	
	@Override
	public String toString() {
		return DomainUtil.changeObjValueToString(this);
	}
}
