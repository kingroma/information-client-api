package information.client.api.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.googlecode.genericdao.search.Filter;

import information.client.api.dao.MusicMetaDao;
import information.client.api.dao.UserMusicBoxDao;
import information.client.api.domain.MusicMeta;
import information.client.api.domain.UserMusicBox;
import information.client.api.responsedto.MusicMetaDto;
import information.client.api.responsedto.UserMusicBoxDto;
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
	
	public List<UserMusicBoxDto> getUserMusicBox( String userId ){
		List<UserMusicBox> list = userMusicBoxDao.find(new Filter("userId",userId));
		
		return domainToUserMusicBoxDto(list) ; 
	}
	
	private MusicMetaDto domainToMusicMetaDto(MusicMeta m){
		MusicMetaDto dto = new MusicMetaDto();
		
		if ( m != null ) {
			dto.setArtist(m.getArtist());
			dto.setDescription(m.getDescription());
			dto.setMusicId(m.getMusicId());
			dto.setMusicName(m.getMusicName());
		}
		
		return dto ; 
	}
	
	private List<UserMusicBoxDto> domainToUserMusicBoxDto(List<UserMusicBox> list){
		List<UserMusicBoxDto> dtoList = new ArrayList<UserMusicBoxDto>();
		
		if ( list != null && list.size() > 0 ) {
			for ( UserMusicBox umb : list ) {
				UserMusicBoxDto dto = new UserMusicBoxDto();
				dto.setBoxId(umb.getBoxId());
				dto.setBoxName(umb.getBoxName());
				dto.setUserId(umb.getUserId());
				
				dtoList.add(dto);
			}
		}
		
		return dtoList ; 
	}
}
