package information.client.api.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.googlecode.genericdao.search.Filter;

import information.client.api.dao.ImageMetaDao;
import information.client.api.domain.ImageMeta;
import information.client.api.responsedto.ImageMetaDto;
import information.client.api.service.ImageMetaService;

@Service
public class ImageMetaServiceImpl implements ImageMetaService{
	
	@Resource
	private ImageMetaDao imageMetaDao;

	@Override
	public List<ImageMetaDto> getImageMetaByMappingId(String mappingId) {
		List<ImageMetaDto> result = new ArrayList<ImageMetaDto> () ;
		
		List<ImageMeta> list = imageMetaDao.find(Filter.equal("mappingId", mappingId));
		
		return result ; 
	}
	
	public ImageMetaDto domainToDto(ImageMeta imageMeta) {
		ImageMetaDto imageMetaDto = new ImageMetaDto();
		
		return imageMetaDto ; 
	}
}
