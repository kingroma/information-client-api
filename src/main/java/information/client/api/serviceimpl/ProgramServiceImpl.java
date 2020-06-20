package information.client.api.serviceimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.genericdao.search.Filter;

import information.client.api.dao.ImageMetaDao;
import information.client.api.dao.ProgramDao;
import information.client.api.domain.Genre;
import information.client.api.domain.ImageMeta;
import information.client.api.domain.Program;
import information.client.api.domain.ProgramGenre;
import information.client.api.domain.ProgramProduct;
import information.client.api.form.ProgramForm;
import information.client.api.responsedto.ImageMetaDto;
import information.client.api.responsedto.ProgramDto;
import information.client.api.responsedto.ProgramImageMetaDto;
import information.client.api.responsedto.ProgramProductDto;
import information.client.api.responsedto.TotalDto;
import information.client.api.service.ProgramService;
import information.client.api.sort.ProgramProductSeasonEpisodeSortASC;
import information.client.api.util.DomainUtil;

@Service
public class ProgramServiceImpl implements ProgramService {
	
	@Resource
	private ProgramDao programDao ;
	
	@Resource 
	private ImageMetaDao imageMetaDao;
	
	@Override
	public Integer countAll() {
		return programDao.countAll();
	}
	
	@Override
	@Transactional
	public TotalDto<ProgramDto> listAll() {
		TotalDto<ProgramDto> result = new TotalDto<ProgramDto>();
		List<Program> list = programDao.findAll();
		
		if ( list != null ) {
			for ( Program p : list ) { 
				result.add(domainToDto(p));
			}
		}
		return result ; 
	}
	
	@Override
	@Transactional
	public TotalDto<ProgramDto> listAll( int offset , int limit ) {
		TotalDto<ProgramDto> result = new TotalDto<ProgramDto>();
		List<Program> list = programDao.findAll(offset,limit);
		
		if ( list != null ) {
			for ( Program p : list ) { 
				result.add(domainToDto(p));
			}
		}
		return result ; 
	}
	
	@Override
	@Transactional
	public List<ProgramDto> search(String search){
		List<Program> list = programDao.find(Filter.like("title", "%" + search + "%"));
		
		List<ProgramDto> result = new ArrayList<ProgramDto>();
		if ( list != null  && list.size() > 0 ) {
			for ( Program p : list ) {
				result.add(domainToDto(p));
			}
		}
		
		return result ; 
	}
	
	@Override
	@Transactional
	public ProgramDto getByIdWithProgramProduct(String programId) {
		Program p = null ;
		ProgramDto dto = null ; 
		
		p = programDao.findById(programId);
		if ( p != null ) {
			dto = domainToDto(p);	
		}
			
		return dto ; 
	}
	
	@Override
	@Transactional
	public ProgramDto save(ProgramForm form) {
		ProgramDto dto = null ;
		Program program = null ; 
		
		if ( form != null ) {
			
			if ( form.getProgramId() == null || form.getProgramId().isEmpty() ) {
				form.setProgramId(DomainUtil.getUUID(20));
			}
			program = new Program();
			program.setProgramId(form.getProgramId());
			program.setTitle(form.getTitle());
			program.setSynopsis(form.getSynopsis());
			program.setRegistDate(new Timestamp(new Date().getTime()));
			program.setUpdateDate(new Timestamp(new Date().getTime()));
			
			program = programDao.save(program);
			dto = domainToDto(program);
		}
		
		return dto ; 
	}
	
	private ProgramDto domainToDto(Program p) {
		ProgramDto dto = new ProgramDto();
		
		dto.setProgramId(p.getProgramId());
		dto.setTitle(p.getTitle());
		dto.setSynopsis(p.getSynopsis());
		dto.setProgramType(p.getProgramType());
		dto.setUseAt(p.getUseAt());
		
		Filter[] imageMetaFilters = {
				Filter.equal("mappingId", p.getProgramId()), 
				Filter.equal("imageType", p.getProgramType() )
			};
	
		List<ImageMeta> imageMetaList = imageMetaDao.find(imageMetaFilters);
		List<ProgramImageMetaDto> programImageMetaDtoList = new ArrayList<ProgramImageMetaDto>();
		
		if ( imageMetaList != null ) {
			for ( ImageMeta im : imageMetaList ) {
				ProgramImageMetaDto programImageMetaDto = new ProgramImageMetaDto();
				
				programImageMetaDto.setImageId(im.getImageId());
				programImageMetaDto.setImageType(im.getImageType());
				programImageMetaDto.setMappingId(im.getMappingId());
				
				programImageMetaDtoList.add(programImageMetaDto);
			}
			dto.setImageMeta(programImageMetaDtoList);
		}
		
		List<String> genres = new ArrayList<String>();
		List<ProgramProductDto> programProducts = new ArrayList<ProgramProductDto>();
		
		List<ProgramGenre> pgList = p.getProgramGenre();
		List<ProgramProduct> ppList = p.getProgramProduct();
		
		if ( pgList != null ) { 
			for ( ProgramGenre pg : pgList ) {
				Genre g = pg.getGenre();
				if ( g != null && g.getGenreName() != null ) {
					genres.add(g.getGenreName());
				}
			}
			dto.setGenres(genres);
		}
		
		if ( ppList != null ) {
			ppList.sort(new ProgramProductSeasonEpisodeSortASC());
			for ( ProgramProduct pp : ppList) { 
				ProgramProductDto ppDto = new ProgramProductDto();
				ppDto.setProgramId(pp.getId().getProgramId());
				ppDto.setProductId(pp.getId().getProductId());
				ppDto.setTitle(pp.getTitle());
				ppDto.setText(pp.getText());
				ppDto.setSeason(pp.getSeason());
				ppDto.setEpisode(pp.getEpisode());
				ppDto.setUseAt(pp.getUseAt());
				
				Filter[] imageMetaFilters2 = {
						Filter.equal("mappingId", pp.getId().getProductId()), 
						Filter.equal("imageType", p.getProgramType() )
					};
			
				List<ImageMeta> imageMetaList2 = imageMetaDao.find(imageMetaFilters2);
				List<ImageMetaDto> programImageMetaDtoList2 = new ArrayList<ImageMetaDto>();
				
				if ( imageMetaList2 != null ) {
					for ( ImageMeta im : imageMetaList2 ) {
						ImageMetaDto imageMetaDto = new ImageMetaDto();
						
						imageMetaDto.setImageId(im.getImageId());
						imageMetaDto.setImageType(im.getImageType());
						imageMetaDto.setMappingId(im.getMappingId());
						
						programImageMetaDtoList2.add(imageMetaDto);
					}
					ppDto.setImageMeta(programImageMetaDtoList2);
				}
				
				programProducts.add(ppDto);
			}
			dto.setProducts(programProducts);
		}
		
		return dto;
	}
}
