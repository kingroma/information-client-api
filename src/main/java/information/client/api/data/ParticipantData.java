package information.client.api.data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import information.client.api.util.DomainUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParticipantData {
	private Integer participantId; 	
	
	private Integer championId ;
	
	private List<RuneData> runes ;
	
	private ParticipantStatsData stats ;
	
	private Integer teamId ;
	
	private ParticipantTimelineData timeline ;
	
	private Integer spell1Id ;
	
	private Integer spell2Id ;
	
	private String highestAchievedSeasonTier ;
	
	private List<MasteryData> masteries;

	public Integer getParticipantId() {
		return participantId;
	}

	public void setParticipantId(Integer participantId) {
		this.participantId = participantId;
	}

	public Integer getChampionId() {
		return championId;
	}

	public void setChampionId(Integer championId) {
		this.championId = championId;
	}

	public List<RuneData> getRunes() {
		return runes;
	}

	public void setRunes(List<RuneData> runes) {
		this.runes = runes;
	}

	public ParticipantStatsData getStats() {
		return stats;
	}

	public void setStats(ParticipantStatsData stats) {
		this.stats = stats;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public ParticipantTimelineData getTimeline() {
		return timeline;
	}

	public void setTimeline(ParticipantTimelineData timeline) {
		this.timeline = timeline;
	}

	public Integer getSpell1Id() {
		return spell1Id;
	}

	public void setSpell1Id(Integer spell1Id) {
		this.spell1Id = spell1Id;
	}

	public Integer getSpell2Id() {
		return spell2Id;
	}

	public void setSpell2Id(Integer spell2Id) {
		this.spell2Id = spell2Id;
	}

	public String getHighestAchievedSeasonTier() {
		return highestAchievedSeasonTier;
	}

	public void setHighestAchievedSeasonTier(String highestAchievedSeasonTier) {
		this.highestAchievedSeasonTier = highestAchievedSeasonTier;
	}

	public List<MasteryData> getMasteries() {
		return masteries;
	}

	public void setMasteries(List<MasteryData> masteries) {
		this.masteries = masteries;
	} 
	
	@Override
	public String toString() {
		return DomainUtil.changeObjValueToString(this);
	}
}
