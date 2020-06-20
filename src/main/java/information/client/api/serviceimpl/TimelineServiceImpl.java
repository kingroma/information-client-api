package information.client.api.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Sort;

import information.client.api.dao.ImageMetaDao;
import information.client.api.dao.TimelineDao;
import information.client.api.domain.ImageMeta;
import information.client.api.domain.Program;
import information.client.api.domain.Timeline;
import information.client.api.domain.TimelineProgram;
import information.client.api.responsedto.ImageMetaDto;
import information.client.api.responsedto.TimelineDto;
import information.client.api.responsedto.TimelineProgramDto;
import information.client.api.responsedto.TotalDto;
import information.client.api.service.TimelineService;
import information.client.api.util.DomainUtil;

@Service
public class TimelineServiceImpl implements TimelineService{
	
	@Resource
	private TimelineDao timelineDao;

	@Resource
	private ImageMetaDao imageMetaDao;
	
	@Override
	@Transactional
	public TotalDto<TimelineDto> listAll( int offset , int limit ) {
		TotalDto<TimelineDto> result = new TotalDto<TimelineDto>();
		Sort sort = new Sort("registDate",true);
		List<Timeline> list = timelineDao.findAll(sort,offset,limit);
		
		if ( list != null ) {
			for ( Timeline t : list ) { 
				result.add(domainToDto(t));
			}
		}
		return result ; 
	}
	
	private TimelineDto domainToDto(Timeline t) {
		TimelineDto dto = new TimelineDto();
		
		dto.setTimelineId(t.getTimelineId());
		dto.setTitle(t.getTitle());
		dto.setText(t.getText());
		
		Filter[] imageMetaFilters = {
				Filter.equal("mappingId", dto.getTimelineId() )
			};

		List<ImageMeta> imageMetaList = imageMetaDao.find(imageMetaFilters);
		List<ImageMetaDto> imageMetaDto = new ArrayList<ImageMetaDto>();
		if ( imageMetaList != null && imageMetaList.size() > 0 ) {
			ImageMeta im = imageMetaList.get(DomainUtil.random(imageMetaList.size()));
			ImageMetaDto imd = new ImageMetaDto();
			imd.setImageId(im.getImageId());
			imd.setImageType(im.getImageType());
			imd.setMappingId(im.getMappingId());
			imageMetaDto.add(imd);
		}
		dto.setImageMeta(imageMetaDto);
		
		List<TimelineProgram> list = t.getTimelineProgram();
		List<TimelineProgramDto> timelineProgramDtoList = new ArrayList<TimelineProgramDto>();
		if ( list != null ) {
			for ( TimelineProgram tp : list ) {
				TimelineProgramDto tpd = new TimelineProgramDto();
				String programId = tp.getId().getProgramId();
				tpd.setProgramId(programId);
				
				Filter[] imageMetaFilters2 = {
						Filter.equal("mappingId", programId ),
						Filter.equal("imageType", Program.ProgramType.programBasic)
					};
				
				List<ImageMeta> imageMetaList2 = imageMetaDao.find(imageMetaFilters2);
				List<ImageMetaDto> imageMetaDto2 = new ArrayList<ImageMetaDto>();
				if ( imageMetaList2 != null && imageMetaList2.size() > 0 ) {
					ImageMeta im2 = imageMetaList2.get(DomainUtil.random(imageMetaList2.size()));
					ImageMetaDto imd2 = new ImageMetaDto();
					imd2.setImageId(im2.getImageId());
					imd2.setImageType(im2.getImageType());
					imd2.setMappingId(im2.getMappingId());
					imageMetaDto2.add(imd2);
				}
				tpd.setImageMeta(imageMetaDto2);
				
				timelineProgramDtoList.add(tpd);
			}
		}
		
		dto.setTimelineProgram(timelineProgramDtoList);
		return dto;
	}
}
