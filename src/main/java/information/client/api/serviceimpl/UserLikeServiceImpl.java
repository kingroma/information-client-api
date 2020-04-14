package information.client.api.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import information.client.api.dao.UserLikeDao;
import information.client.api.service.UserLikeService;

@Service
public class UserLikeServiceImpl implements UserLikeService{

	@Resource
	private UserLikeDao userLikeDao;
}
