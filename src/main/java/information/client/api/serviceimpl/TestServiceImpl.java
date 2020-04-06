package information.client.api.serviceimpl;

import org.springframework.stereotype.Service;

import information.client.api.dao.TestDao;
import information.client.api.domain.Test;
import information.client.api.service.TestService;

@Service
public class TestServiceImpl extends BaseServiceImpl<Test,TestDao> implements TestService{

	protected TestServiceImpl() {
		super(TestDao.class);
	}
	
}
