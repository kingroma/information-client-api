package information.client.api.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import information.client.api.util.DomainUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ParticipantIdentityData {
	private Integer participantId;

	private PlayerData player;

	public Integer getParticipantId() {
		return participantId;
	}

	public void setParticipantId(Integer participantId) {
		this.participantId = participantId;
	}

	public PlayerData getPlayer() {
		return player;
	}

	public void setPlayer(PlayerData player) {
		this.player = player;
	}

	@Override
	public String toString() {
		return DomainUtil.changeObjValueToString(this);
	}
}
