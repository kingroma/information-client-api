package information.client.api.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import information.client.api.dao.MusicMetaDao;
import information.client.api.dao.UserMusicBoxDao;
import information.client.api.domain.MusicMeta;
import information.client.api.domain.UserMusicBox;
import information.client.api.responsedto.MusicMetaDto;
import information.client.api.service.MusicMetaService;

@Service
public class MusicMetaServiceImpl implements MusicMetaService{

	@Resource
	private MusicMetaDao musicMetaDao;
	
	@Resource
	private UserMusicBoxDao userMusicBoxDao;
	
	public MusicMetaDto getInformation(String musicId){
		MusicMeta musicMeta = musicMetaDao.find(musicId);
		
		return domainToMusicMetaDto(musicMeta);
	}
	
	public List<UserMusicBox> getUserMusicBox( String userId ){
		return null ; 
	}
	
	private MusicMetaDto domainToMusicMetaDto(MusicMeta m){
		MusicMetaDto dto = new MusicMetaDto();
		
		
		return dto ; 
	}
}
