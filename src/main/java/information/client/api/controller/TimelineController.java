package information.client.api.controller;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import information.client.api.service.TimelineService;

@Controller 
@RequestMapping("/timeline")
public class TimelineController {

	private static final Logger logger = LoggerFactory.getLogger(TimelineController.class);
	
	@Resource
	private TimelineService timelineService;
	
	
}
