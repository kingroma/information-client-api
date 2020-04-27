package information.client.api.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;

import information.client.api.batch.TestBatch;

@Controller
public class SimpleBatchController {
	private static final Logger logger = LoggerFactory.getLogger(SimpleBatchController.class);
	
	public SimpleBatchController() {
		loop();
	}
	
	public void loop() {
		TestBatch tb = new TestBatch();
		tb.start();
	}
}
