package information.client.api.service;

import java.util.List;

import information.client.api.responsedto.ContentDto;

public interface ContentService {
	public List<ContentDto> listAll() ; 
	
	public List<ContentDto> list(String contentType) ;
}
