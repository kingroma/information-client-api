package information.client.api.service;

import information.client.api.responsedto.TimelineDto;
import information.client.api.responsedto.TotalDto;

public interface TimelineService {
	public TotalDto<TimelineDto> listAll( int offset , int limit ) ;
	
	
}
