package information.client.api.serviceimpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import information.client.api.dao.MusicMetaDao;
import information.client.api.service.MusicMetaService;

@Service
public class MusicMetaServiceImpl implements MusicMetaService{

	@Resource
	private MusicMetaDao musicMetaDao;
	
	
}
