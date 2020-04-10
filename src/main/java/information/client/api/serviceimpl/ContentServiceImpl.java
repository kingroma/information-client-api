package information.client.api.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import information.client.api.dao.ContentDao;
import information.client.api.domain.Content;
import information.client.api.domain.Program;
import information.client.api.responsedto.ContentDto;
import information.client.api.responsedto.TotalDto;
import information.client.api.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService{

	@Resource
	private ContentDao contentDao ; 
	
	public TotalDto<ContentDto> findAll(){
		TotalDto<ContentDto> result = new TotalDto<ContentDto>();
		List<Content> list = contentDao.findAll();
		
		if ( list != null ) {
			for ( Content c : list ) { 
				result.add(domainToDto(c));
			}
		}
		return result ; 
	}
	
	private ContentDto domainToDto(Content c) {
		ContentDto dto = new ContentDto();
		
		return dto ; 
	}
	
}
