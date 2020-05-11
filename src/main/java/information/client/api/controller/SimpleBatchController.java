package information.client.api.controller;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import information.client.api.batch.UserMatchHistBatch;
import information.client.api.batch.UserRankHistBatch;
import information.client.api.service.CodeService;
import information.client.api.service.UserService;

@Controller
public class SimpleBatchController {
	private static final Logger logger = LoggerFactory.getLogger(SimpleBatchController.class);
	
	@Autowired
	private UserService userService ;
	
	@Autowired
	private CodeService codeService ; 
	
	public SimpleBatchController() {
	}
	
	@PostConstruct 
	public void loop() {
		UserRankHistBatch batch1 = new UserRankHistBatch();
		batch1.setUserService(userService);
		batch1.setCodeService(codeService);
//		batch1.start();
		
		UserMatchHistBatch batch2 = new UserMatchHistBatch();
		batch2.setUserService(userService);
		batch2.setCodeService(codeService);
		//batch2.start();
	}
}
