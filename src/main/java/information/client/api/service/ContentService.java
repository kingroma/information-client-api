package information.client.api.service;

import information.client.api.responsedto.ContentDto;
import information.client.api.responsedto.TotalDto;

public interface ContentService {
	public TotalDto<ContentDto> findAll() ; 
}
