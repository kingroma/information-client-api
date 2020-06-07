package information.client.api.service;

import java.util.List;

import information.client.api.domain.UserMusicBox;
import information.client.api.responsedto.MusicMetaDto;

public interface MusicMetaService {
	public MusicMetaDto getInformation(String musicId) ; 
	
	public List<UserMusicBox> getUserMusicBox( String userId );
}
