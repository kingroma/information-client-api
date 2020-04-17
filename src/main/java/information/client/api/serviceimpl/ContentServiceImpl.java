package information.client.api.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Sort;

import information.client.api.dao.ContentDao;
import information.client.api.dao.ImageMetaDao;
import information.client.api.dao.ProgramDao;
import information.client.api.domain.Content;
import information.client.api.domain.Content.ContentType;
import information.client.api.domain.ContentProgram;
import information.client.api.domain.ImageMeta;
import information.client.api.domain.Program;
import information.client.api.responsedto.ContentDto;
import information.client.api.responsedto.ContentProgramDto;
import information.client.api.responsedto.ImageMetaDto;
import information.client.api.service.ContentService;
import information.client.api.sort.ContentProgramSortASC;

@Service
public class ContentServiceImpl implements ContentService{

	@Resource
	private ContentDao contentDao ; 
	
	@Resource 
	private ProgramDao programDao ; 
	
	@Resource
	private ImageMetaDao imageMetaDao ;

	@Override
	@Transactional
	public List<ContentDto> listAll(){
		List<ContentDto> result = new ArrayList<ContentDto>();
		
		Sort sort = new Sort("sortSn");
		List<Content> list = contentDao.findAll(sort);
		
		if ( list != null ) {
			for ( Content c : list ) { 
				result.add(domainToDto(c));
			}
		}
		return result ; 
	}
	
	@Override
	@Transactional
	public List<ContentDto> list(String contentType) {
		List<ContentDto> result = new ArrayList<ContentDto>();
		
		ContentType ct = Content.getContentTypeByString(contentType);
		Filter filter = new Filter("contentType",ct);
		Sort sort = new Sort("sortSn");
		
		List<Content> list = contentDao.find(sort, filter);
		
		if ( list != null ) {
			for ( Content c : list ) { 
				result.add(domainToDto(c));
			}
		}
		return result ; 
	}
	
	private ContentDto domainToDto(Content c) {
		ContentDto contentDto = new ContentDto();
		List<ContentProgramDto> contentProgramDtoList = new ArrayList<ContentProgramDto>();
		
		if ( c != null && c.getContentProgram() != null ) {
			contentDto.setContentId(c.getContentId());
			contentDto.setContentName(c.getContentName());
			contentDto.setContentType(c.getContentType().toString());
			
			List<ContentProgram> contentProgramList = c.getContentProgram();
			
			if ( contentProgramList != null && contentProgramList.size() > 0 ) {
				contentProgramList.sort(new ContentProgramSortASC());
				
				for ( ContentProgram cp : contentProgramList ) {
					String programId = cp.getId().getProgramId();
					
					Program p = programDao.find(programId);
					String title = p.getTitle();
					
					ContentProgramDto contentProgramDto = new ContentProgramDto();
					contentProgramDto.setProgramId(programId);
					contentProgramDto.setTitle(title);
					
					Filter[] imageMetaFilters = {
								Filter.equal("mappingId", programId), 
								Filter.equal("imageType", c.getContentType() )
							};
							// Filter("mappingId",programId);
					
					List<ImageMeta> imageMetaList = imageMetaDao.find(imageMetaFilters);
					List<ImageMetaDto> imageMetaDtoList = new ArrayList<ImageMetaDto>();
					
					if ( imageMetaList != null ) {
						for ( ImageMeta im : imageMetaList ) {
							ImageMetaDto imageMetaDto = new ImageMetaDto();
							
							imageMetaDto.setImageId(im.getImageId());
							imageMetaDto.setImageType(im.getImageType());
							imageMetaDto.setMappingId(im.getMappingId());
							
							imageMetaDtoList.add(imageMetaDto);
						}
						contentProgramDto.setImageMeta(imageMetaDtoList);
					}
					
					contentProgramDtoList.add(contentProgramDto);
				}
			}
			
			
		}

		contentDto.setList(contentProgramDtoList);
		return contentDto ; 
	}
	
}
