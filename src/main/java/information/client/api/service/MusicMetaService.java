package information.client.api.service;

import java.util.List;

import information.client.api.responsedto.MusicMetaDto;
import information.client.api.responsedto.UserMusicBoxDto;

public interface MusicMetaService {
	public MusicMetaDto getInformation(String musicId) ; 
	
	public List<UserMusicBoxDto> getUserMusicBox( String userId );
}
