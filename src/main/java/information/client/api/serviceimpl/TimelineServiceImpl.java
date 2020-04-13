package information.client.api.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import information.client.api.dao.TimelineDao;
import information.client.api.service.TimelineService;

@Service
public class TimelineServiceImpl implements TimelineService{
	
	@Resource
	private TimelineDao timelineDao;

}
