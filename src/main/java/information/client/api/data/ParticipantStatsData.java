package information.client.api.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import information.client.api.util.DomainUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParticipantStatsData {
	private Integer item0; //
	private Integer item2; //
	private Integer totalUnitsHealed; //
	private Integer item1; //
	private Integer largestMultiKill; //
	private Integer goldEarned; //
	private Boolean firstInhibitorKill; //
	private Long physicalDamageTaken; //
	private Integer nodeNeutralizeAssist; //
	private Integer totalPlayerScore; //
	private Integer champLevel; //
	private Long damageDealtToObjectives; //
	private Long totalDamageTaken; //
	private Integer neutralMinionsKilled; //
	private Integer deaths; //
	private Integer tripleKills; //
	private Long magicDamageDealtToChampions; //
	private Integer wardsKilled; //
	private Integer pentaKills; //
	private Long damageSelfMitigated; //
	private Integer largestCriticalStrike; //
	private Integer nodeNeutralize; //
	private Integer totalTimeCrowdControlDealt; //
	private Boolean firstTowerKill; //
	private Long magicDamageDealt; //
	private Integer totalScoreRank; //
	private Integer nodeCapture; //
	private Integer wardsPlaced; //
	private Long totalDamageDealt; //
	private Long timeCCingOthers; //
	private Long magicalDamageTaken; //
	private Integer largestKillingSpree; //
	private Long totalDamageDealtToChampions; //
	private Long physicalDamageDealtToChampions; //
	private Integer neutralMinionsKilledTeamJungle; //
	private Integer totalMinionsKilled; //
	private Boolean firstInhibitorAssist; //
	private Integer visionWardsBoughtInGame; //
	private Integer objectivePlayerScore; //
	private Integer kills; //
	private Boolean firstTowerAssist; //
	private Integer combatPlayerScore; //
	private Integer inhibitorKills; //
	private Integer turretKills; //
	private Integer participantId; //
	private Long trueDamageTaken; //
	private Boolean firstBloodAssist; //
	private Integer nodeCaptureAssist; //
	private Integer assists; //
	private Integer teamObjective; //
	private Integer altarsNeutralized; //
	private Integer goldSpent; //
	private Long damageDealtToTurrets; //
	private Integer altarsCaptured; //
	private Boolean win; //
	private Long totalHeal; //
	private Integer unrealKills; //
	private Long visionScore; //
	private Long physicalDamageDealt; //
	private Boolean firstBloodKill; //
	private Integer longestTimeSpentLiving; //
	private Integer killingSprees; //
	private Integer sightWardsBoughtInGame; //
	private Long trueDamageDealtToChampions; //
	private Integer neutralMinionsKilledEnemyJungle; //
	private Integer doubleKills; //
	private Long trueDamageDealt; //
	private Integer quadraKills; //
	private Integer item4; //
	private Integer item3; //
	private Integer item6; //
	private Integer item5; //
	private Integer playerScore0; //
	private Integer playerScore1; //
	private Integer playerScore2; //
	private Integer playerScore3; //
	private Integer playerScore4; //
	private Integer playerScore5; //
	private Integer playerScore6; //
	private Integer playerScore7; //
	private Integer playerScore8; //
	private Integer playerScore9; //
	private Integer perk0; // Primary path keystone rune.
	private Integer perk0Var1; // Post game rune stats.
	private Integer perk0Var2; // Post game rune stats.
	private Integer perk0Var3; // Post game rune stats.
	private Integer perk1; // Primary path rune.
	private Integer perk1Var1; // Post game rune stats.
	private Integer perk1Var2; // Post game rune stats.
	private Integer perk1Var3; // Post game rune stats.
	private Integer perk2; // Primary path rune.
	private Integer perk2Var1; // Post game rune stats.
	private Integer perk2Var2; // Post game rune stats.
	private Integer perk2Var3; // Post game rune stats.
	private Integer perk3; // Primary path rune.
	private Integer perk3Var1; // Post game rune stats.
	private Integer perk3Var2; // Post game rune stats.
	private Integer perk3Var3; // Post game rune stats.
	private Integer perk4; // Secondary path rune.
	private Integer perk4Var1; // Post game rune stats.
	private Integer perk4Var2; // Post game rune stats.
	private Integer perk4Var3; // Post game rune stats.
	private Integer perk5; // Secondary path rune.
	private Integer perk5Var1; // Post game rune stats.
	private Integer perk5Var2; // Post game rune stats.
	private Integer perk5Var3; // Post game rune stats.
	private Integer perkPrimaryStyle; // Primary rune path
	private Integer perkSubStyle; // Secondary rune path

	public Integer getItem0() {
		return item0;
	}

	public void setItem0(Integer item0) {
		this.item0 = item0;
	}

	public Integer getItem2() {
		return item2;
	}

	public void setItem2(Integer item2) {
		this.item2 = item2;
	}

	public Integer getTotalUnitsHealed() {
		return totalUnitsHealed;
	}

	public void setTotalUnitsHealed(Integer totalUnitsHealed) {
		this.totalUnitsHealed = totalUnitsHealed;
	}

	public Integer getItem1() {
		return item1;
	}

	public void setItem1(Integer item1) {
		this.item1 = item1;
	}

	public Integer getLargestMultiKill() {
		return largestMultiKill;
	}

	public void setLargestMultiKill(Integer largestMultiKill) {
		this.largestMultiKill = largestMultiKill;
	}

	public Integer getGoldEarned() {
		return goldEarned;
	}

	public void setGoldEarned(Integer goldEarned) {
		this.goldEarned = goldEarned;
	}

	public Boolean getFirstInhibitorKill() {
		return firstInhibitorKill;
	}

	public void setFirstInhibitorKill(Boolean firstInhibitorKill) {
		this.firstInhibitorKill = firstInhibitorKill;
	}

	public Long getPhysicalDamageTaken() {
		return physicalDamageTaken;
	}

	public void setPhysicalDamageTaken(Long physicalDamageTaken) {
		this.physicalDamageTaken = physicalDamageTaken;
	}

	public Integer getNodeNeutralizeAssist() {
		return nodeNeutralizeAssist;
	}

	public void setNodeNeutralizeAssist(Integer nodeNeutralizeAssist) {
		this.nodeNeutralizeAssist = nodeNeutralizeAssist;
	}

	public Integer getTotalPlayerScore() {
		return totalPlayerScore;
	}

	public void setTotalPlayerScore(Integer totalPlayerScore) {
		this.totalPlayerScore = totalPlayerScore;
	}

	public Integer getChampLevel() {
		return champLevel;
	}

	public void setChampLevel(Integer champLevel) {
		this.champLevel = champLevel;
	}

	public Long getDamageDealtToObjectives() {
		return damageDealtToObjectives;
	}

	public void setDamageDealtToObjectives(Long damageDealtToObjectives) {
		this.damageDealtToObjectives = damageDealtToObjectives;
	}

	public Long getTotalDamageTaken() {
		return totalDamageTaken;
	}

	public void setTotalDamageTaken(Long totalDamageTaken) {
		this.totalDamageTaken = totalDamageTaken;
	}

	public Integer getNeutralMinionsKilled() {
		return neutralMinionsKilled;
	}

	public void setNeutralMinionsKilled(Integer neutralMinionsKilled) {
		this.neutralMinionsKilled = neutralMinionsKilled;
	}

	public Integer getDeaths() {
		return deaths;
	}

	public void setDeaths(Integer deaths) {
		this.deaths = deaths;
	}

	public Integer getTripleKills() {
		return tripleKills;
	}

	public void setTripleKills(Integer tripleKills) {
		this.tripleKills = tripleKills;
	}

	public Long getMagicDamageDealtToChampions() {
		return magicDamageDealtToChampions;
	}

	public void setMagicDamageDealtToChampions(Long magicDamageDealtToChampions) {
		this.magicDamageDealtToChampions = magicDamageDealtToChampions;
	}

	public Integer getWardsKilled() {
		return wardsKilled;
	}

	public void setWardsKilled(Integer wardsKilled) {
		this.wardsKilled = wardsKilled;
	}

	public Integer getPentaKills() {
		return pentaKills;
	}

	public void setPentaKills(Integer pentaKills) {
		this.pentaKills = pentaKills;
	}

	public Long getDamageSelfMitigated() {
		return damageSelfMitigated;
	}

	public void setDamageSelfMitigated(Long damageSelfMitigated) {
		this.damageSelfMitigated = damageSelfMitigated;
	}

	public Integer getLargestCriticalStrike() {
		return largestCriticalStrike;
	}

	public void setLargestCriticalStrike(Integer largestCriticalStrike) {
		this.largestCriticalStrike = largestCriticalStrike;
	}

	public Integer getNodeNeutralize() {
		return nodeNeutralize;
	}

	public void setNodeNeutralize(Integer nodeNeutralize) {
		this.nodeNeutralize = nodeNeutralize;
	}

	public Integer getTotalTimeCrowdControlDealt() {
		return totalTimeCrowdControlDealt;
	}

	public void setTotalTimeCrowdControlDealt(Integer totalTimeCrowdControlDealt) {
		this.totalTimeCrowdControlDealt = totalTimeCrowdControlDealt;
	}

	public Boolean getFirstTowerKill() {
		return firstTowerKill;
	}

	public void setFirstTowerKill(Boolean firstTowerKill) {
		this.firstTowerKill = firstTowerKill;
	}

	public Long getMagicDamageDealt() {
		return magicDamageDealt;
	}

	public void setMagicDamageDealt(Long magicDamageDealt) {
		this.magicDamageDealt = magicDamageDealt;
	}

	public Integer getTotalScoreRank() {
		return totalScoreRank;
	}

	public void setTotalScoreRank(Integer totalScoreRank) {
		this.totalScoreRank = totalScoreRank;
	}

	public Integer getNodeCapture() {
		return nodeCapture;
	}

	public void setNodeCapture(Integer nodeCapture) {
		this.nodeCapture = nodeCapture;
	}

	public Integer getWardsPlaced() {
		return wardsPlaced;
	}

	public void setWardsPlaced(Integer wardsPlaced) {
		this.wardsPlaced = wardsPlaced;
	}

	public Long getTotalDamageDealt() {
		return totalDamageDealt;
	}

	public void setTotalDamageDealt(Long totalDamageDealt) {
		this.totalDamageDealt = totalDamageDealt;
	}

	public Long getTimeCCingOthers() {
		return timeCCingOthers;
	}

	public void setTimeCCingOthers(Long timeCCingOthers) {
		this.timeCCingOthers = timeCCingOthers;
	}

	public Long getMagicalDamageTaken() {
		return magicalDamageTaken;
	}

	public void setMagicalDamageTaken(Long magicalDamageTaken) {
		this.magicalDamageTaken = magicalDamageTaken;
	}

	public Integer getLargestKillingSpree() {
		return largestKillingSpree;
	}

	public void setLargestKillingSpree(Integer largestKillingSpree) {
		this.largestKillingSpree = largestKillingSpree;
	}

	public Long getTotalDamageDealtToChampions() {
		return totalDamageDealtToChampions;
	}

	public void setTotalDamageDealtToChampions(Long totalDamageDealtToChampions) {
		this.totalDamageDealtToChampions = totalDamageDealtToChampions;
	}

	public Long getPhysicalDamageDealtToChampions() {
		return physicalDamageDealtToChampions;
	}

	public void setPhysicalDamageDealtToChampions(Long physicalDamageDealtToChampions) {
		this.physicalDamageDealtToChampions = physicalDamageDealtToChampions;
	}

	public Integer getNeutralMinionsKilledTeamJungle() {
		return neutralMinionsKilledTeamJungle;
	}

	public void setNeutralMinionsKilledTeamJungle(Integer neutralMinionsKilledTeamJungle) {
		this.neutralMinionsKilledTeamJungle = neutralMinionsKilledTeamJungle;
	}

	public Integer getTotalMinionsKilled() {
		return totalMinionsKilled;
	}

	public void setTotalMinionsKilled(Integer totalMinionsKilled) {
		this.totalMinionsKilled = totalMinionsKilled;
	}

	public Boolean getFirstInhibitorAssist() {
		return firstInhibitorAssist;
	}

	public void setFirstInhibitorAssist(Boolean firstInhibitorAssist) {
		this.firstInhibitorAssist = firstInhibitorAssist;
	}

	public Integer getVisionWardsBoughtInGame() {
		return visionWardsBoughtInGame;
	}

	public void setVisionWardsBoughtInGame(Integer visionWardsBoughtInGame) {
		this.visionWardsBoughtInGame = visionWardsBoughtInGame;
	}

	public Integer getObjectivePlayerScore() {
		return objectivePlayerScore;
	}

	public void setObjectivePlayerScore(Integer objectivePlayerScore) {
		this.objectivePlayerScore = objectivePlayerScore;
	}

	public Integer getKills() {
		return kills;
	}

	public void setKills(Integer kills) {
		this.kills = kills;
	}

	public Boolean getFirstTowerAssist() {
		return firstTowerAssist;
	}

	public void setFirstTowerAssist(Boolean firstTowerAssist) {
		this.firstTowerAssist = firstTowerAssist;
	}

	public Integer getCombatPlayerScore() {
		return combatPlayerScore;
	}

	public void setCombatPlayerScore(Integer combatPlayerScore) {
		this.combatPlayerScore = combatPlayerScore;
	}

	public Integer getInhibitorKills() {
		return inhibitorKills;
	}

	public void setInhibitorKills(Integer inhibitorKills) {
		this.inhibitorKills = inhibitorKills;
	}

	public Integer getTurretKills() {
		return turretKills;
	}

	public void setTurretKills(Integer turretKills) {
		this.turretKills = turretKills;
	}

	public Integer getParticipantId() {
		return participantId;
	}

	public void setParticipantId(Integer participantId) {
		this.participantId = participantId;
	}

	public Long getTrueDamageTaken() {
		return trueDamageTaken;
	}

	public void setTrueDamageTaken(Long trueDamageTaken) {
		this.trueDamageTaken = trueDamageTaken;
	}

	public Boolean getFirstBloodAssist() {
		return firstBloodAssist;
	}

	public void setFirstBloodAssist(Boolean firstBloodAssist) {
		this.firstBloodAssist = firstBloodAssist;
	}

	public Integer getNodeCaptureAssist() {
		return nodeCaptureAssist;
	}

	public void setNodeCaptureAssist(Integer nodeCaptureAssist) {
		this.nodeCaptureAssist = nodeCaptureAssist;
	}

	public Integer getAssists() {
		return assists;
	}

	public void setAssists(Integer assists) {
		this.assists = assists;
	}

	public Integer getTeamObjective() {
		return teamObjective;
	}

	public void setTeamObjective(Integer teamObjective) {
		this.teamObjective = teamObjective;
	}

	public Integer getAltarsNeutralized() {
		return altarsNeutralized;
	}

	public void setAltarsNeutralized(Integer altarsNeutralized) {
		this.altarsNeutralized = altarsNeutralized;
	}

	public Integer getGoldSpent() {
		return goldSpent;
	}

	public void setGoldSpent(Integer goldSpent) {
		this.goldSpent = goldSpent;
	}

	public Long getDamageDealtToTurrets() {
		return damageDealtToTurrets;
	}

	public void setDamageDealtToTurrets(Long damageDealtToTurrets) {
		this.damageDealtToTurrets = damageDealtToTurrets;
	}

	public Integer getAltarsCaptured() {
		return altarsCaptured;
	}

	public void setAltarsCaptured(Integer altarsCaptured) {
		this.altarsCaptured = altarsCaptured;
	}

	public Boolean getWin() {
		return win;
	}

	public void setWin(Boolean win) {
		this.win = win;
	}

	public Long getTotalHeal() {
		return totalHeal;
	}

	public void setTotalHeal(Long totalHeal) {
		this.totalHeal = totalHeal;
	}

	public Integer getUnrealKills() {
		return unrealKills;
	}

	public void setUnrealKills(Integer unrealKills) {
		this.unrealKills = unrealKills;
	}

	public Long getVisionScore() {
		return visionScore;
	}

	public void setVisionScore(Long visionScore) {
		this.visionScore = visionScore;
	}

	public Long getPhysicalDamageDealt() {
		return physicalDamageDealt;
	}

	public void setPhysicalDamageDealt(Long physicalDamageDealt) {
		this.physicalDamageDealt = physicalDamageDealt;
	}

	public Boolean getFirstBloodKill() {
		return firstBloodKill;
	}

	public void setFirstBloodKill(Boolean firstBloodKill) {
		this.firstBloodKill = firstBloodKill;
	}

	public Integer getLongestTimeSpentLiving() {
		return longestTimeSpentLiving;
	}

	public void setLongestTimeSpentLiving(Integer longestTimeSpentLiving) {
		this.longestTimeSpentLiving = longestTimeSpentLiving;
	}

	public Integer getKillingSprees() {
		return killingSprees;
	}

	public void setKillingSprees(Integer killingSprees) {
		this.killingSprees = killingSprees;
	}

	public Integer getSightWardsBoughtInGame() {
		return sightWardsBoughtInGame;
	}

	public void setSightWardsBoughtInGame(Integer sightWardsBoughtInGame) {
		this.sightWardsBoughtInGame = sightWardsBoughtInGame;
	}

	public Long getTrueDamageDealtToChampions() {
		return trueDamageDealtToChampions;
	}

	public void setTrueDamageDealtToChampions(Long trueDamageDealtToChampions) {
		this.trueDamageDealtToChampions = trueDamageDealtToChampions;
	}

	public Integer getNeutralMinionsKilledEnemyJungle() {
		return neutralMinionsKilledEnemyJungle;
	}

	public void setNeutralMinionsKilledEnemyJungle(Integer neutralMinionsKilledEnemyJungle) {
		this.neutralMinionsKilledEnemyJungle = neutralMinionsKilledEnemyJungle;
	}

	public Integer getDoubleKills() {
		return doubleKills;
	}

	public void setDoubleKills(Integer doubleKills) {
		this.doubleKills = doubleKills;
	}

	public Long getTrueDamageDealt() {
		return trueDamageDealt;
	}

	public void setTrueDamageDealt(Long trueDamageDealt) {
		this.trueDamageDealt = trueDamageDealt;
	}

	public Integer getQuadraKills() {
		return quadraKills;
	}

	public void setQuadraKills(Integer quadraKills) {
		this.quadraKills = quadraKills;
	}

	public Integer getItem4() {
		return item4;
	}

	public void setItem4(Integer item4) {
		this.item4 = item4;
	}

	public Integer getItem3() {
		return item3;
	}

	public void setItem3(Integer item3) {
		this.item3 = item3;
	}

	public Integer getItem6() {
		return item6;
	}

	public void setItem6(Integer item6) {
		this.item6 = item6;
	}

	public Integer getItem5() {
		return item5;
	}

	public void setItem5(Integer item5) {
		this.item5 = item5;
	}

	public Integer getPlayerScore0() {
		return playerScore0;
	}

	public void setPlayerScore0(Integer playerScore0) {
		this.playerScore0 = playerScore0;
	}

	public Integer getPlayerScore1() {
		return playerScore1;
	}

	public void setPlayerScore1(Integer playerScore1) {
		this.playerScore1 = playerScore1;
	}

	public Integer getPlayerScore2() {
		return playerScore2;
	}

	public void setPlayerScore2(Integer playerScore2) {
		this.playerScore2 = playerScore2;
	}

	public Integer getPlayerScore3() {
		return playerScore3;
	}

	public void setPlayerScore3(Integer playerScore3) {
		this.playerScore3 = playerScore3;
	}

	public Integer getPlayerScore4() {
		return playerScore4;
	}

	public void setPlayerScore4(Integer playerScore4) {
		this.playerScore4 = playerScore4;
	}

	public Integer getPlayerScore5() {
		return playerScore5;
	}

	public void setPlayerScore5(Integer playerScore5) {
		this.playerScore5 = playerScore5;
	}

	public Integer getPlayerScore6() {
		return playerScore6;
	}

	public void setPlayerScore6(Integer playerScore6) {
		this.playerScore6 = playerScore6;
	}

	public Integer getPlayerScore7() {
		return playerScore7;
	}

	public void setPlayerScore7(Integer playerScore7) {
		this.playerScore7 = playerScore7;
	}

	public Integer getPlayerScore8() {
		return playerScore8;
	}

	public void setPlayerScore8(Integer playerScore8) {
		this.playerScore8 = playerScore8;
	}

	public Integer getPlayerScore9() {
		return playerScore9;
	}

	public void setPlayerScore9(Integer playerScore9) {
		this.playerScore9 = playerScore9;
	}

	public Integer getPerk0() {
		return perk0;
	}

	public void setPerk0(Integer perk0) {
		this.perk0 = perk0;
	}

	public Integer getPerk0Var1() {
		return perk0Var1;
	}

	public void setPerk0Var1(Integer perk0Var1) {
		this.perk0Var1 = perk0Var1;
	}

	public Integer getPerk0Var2() {
		return perk0Var2;
	}

	public void setPerk0Var2(Integer perk0Var2) {
		this.perk0Var2 = perk0Var2;
	}

	public Integer getPerk0Var3() {
		return perk0Var3;
	}

	public void setPerk0Var3(Integer perk0Var3) {
		this.perk0Var3 = perk0Var3;
	}

	public Integer getPerk1() {
		return perk1;
	}

	public void setPerk1(Integer perk1) {
		this.perk1 = perk1;
	}

	public Integer getPerk1Var1() {
		return perk1Var1;
	}

	public void setPerk1Var1(Integer perk1Var1) {
		this.perk1Var1 = perk1Var1;
	}

	public Integer getPerk1Var2() {
		return perk1Var2;
	}

	public void setPerk1Var2(Integer perk1Var2) {
		this.perk1Var2 = perk1Var2;
	}

	public Integer getPerk1Var3() {
		return perk1Var3;
	}

	public void setPerk1Var3(Integer perk1Var3) {
		this.perk1Var3 = perk1Var3;
	}

	public Integer getPerk2() {
		return perk2;
	}

	public void setPerk2(Integer perk2) {
		this.perk2 = perk2;
	}

	public Integer getPerk2Var1() {
		return perk2Var1;
	}

	public void setPerk2Var1(Integer perk2Var1) {
		this.perk2Var1 = perk2Var1;
	}

	public Integer getPerk2Var2() {
		return perk2Var2;
	}

	public void setPerk2Var2(Integer perk2Var2) {
		this.perk2Var2 = perk2Var2;
	}

	public Integer getPerk2Var3() {
		return perk2Var3;
	}

	public void setPerk2Var3(Integer perk2Var3) {
		this.perk2Var3 = perk2Var3;
	}

	public Integer getPerk3() {
		return perk3;
	}

	public void setPerk3(Integer perk3) {
		this.perk3 = perk3;
	}

	public Integer getPerk3Var1() {
		return perk3Var1;
	}

	public void setPerk3Var1(Integer perk3Var1) {
		this.perk3Var1 = perk3Var1;
	}

	public Integer getPerk3Var2() {
		return perk3Var2;
	}

	public void setPerk3Var2(Integer perk3Var2) {
		this.perk3Var2 = perk3Var2;
	}

	public Integer getPerk3Var3() {
		return perk3Var3;
	}

	public void setPerk3Var3(Integer perk3Var3) {
		this.perk3Var3 = perk3Var3;
	}

	public Integer getPerk4() {
		return perk4;
	}

	public void setPerk4(Integer perk4) {
		this.perk4 = perk4;
	}

	public Integer getPerk4Var1() {
		return perk4Var1;
	}

	public void setPerk4Var1(Integer perk4Var1) {
		this.perk4Var1 = perk4Var1;
	}

	public Integer getPerk4Var2() {
		return perk4Var2;
	}

	public void setPerk4Var2(Integer perk4Var2) {
		this.perk4Var2 = perk4Var2;
	}

	public Integer getPerk4Var3() {
		return perk4Var3;
	}

	public void setPerk4Var3(Integer perk4Var3) {
		this.perk4Var3 = perk4Var3;
	}

	public Integer getPerk5() {
		return perk5;
	}

	public void setPerk5(Integer perk5) {
		this.perk5 = perk5;
	}

	public Integer getPerk5Var1() {
		return perk5Var1;
	}

	public void setPerk5Var1(Integer perk5Var1) {
		this.perk5Var1 = perk5Var1;
	}

	public Integer getPerk5Var2() {
		return perk5Var2;
	}

	public void setPerk5Var2(Integer perk5Var2) {
		this.perk5Var2 = perk5Var2;
	}

	public Integer getPerk5Var3() {
		return perk5Var3;
	}

	public void setPerk5Var3(Integer perk5Var3) {
		this.perk5Var3 = perk5Var3;
	}

	public Integer getPerkPrimaryStyle() {
		return perkPrimaryStyle;
	}

	public void setPerkPrimaryStyle(Integer perkPrimaryStyle) {
		this.perkPrimaryStyle = perkPrimaryStyle;
	}

	public Integer getPerkSubStyle() {
		return perkSubStyle;
	}

	public void setPerkSubStyle(Integer perkSubStyle) {
		this.perkSubStyle = perkSubStyle;
	}

	@Override
	public String toString() {
		return DomainUtil.changeObjValueToString(this);
	}

}
