package information.client.api.serviceimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import information.client.api.dao.ProgramDao;
import information.client.api.domain.Genre;
import information.client.api.domain.Program;
import information.client.api.domain.ProgramGenre;
import information.client.api.domain.ProgramProduct;
import information.client.api.dto.ProgramDto;
import information.client.api.dto.ProgramProductDto;
import information.client.api.form.ProgramForm;
import information.client.api.service.ProgramService;
import information.client.api.util.DomainUtil;

@Service
public class ProgramServiceImpl extends BaseServiceImpl<Program,ProgramDao> implements ProgramService {
	
	protected ProgramServiceImpl() {
		super(ProgramDao.class);
	}
	
	@Override
	public List<Program> findAll() {
		return dao.findAll();
	}
	
	@Override
	@Transactional
	public ProgramDto findById(String programId) {
		Program p = null ;
		ProgramDto dto = null ; 
		try {
			p = dao.findById(programId);
			dto = domainToDto(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return dto ; 
	}
	
	@Override
	@Transactional
	public Program save(ProgramForm form) {
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
			System.out.println(program.getProgramId());
			try {
				program = dao.save(program);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return program ; 
	}
	
	private ProgramDto domainToDto(Program p) {
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
		}
		
		if ( ppList != null ) {
			for ( ProgramProduct pp : ppList) { 
				ProgramProductDto ppDto = new ProgramProductDto();
				ppDto.setProgramId(pp.getId().getProgramId());
				ppDto.setProductId(pp.getId().getProductId());
				ppDto.setTitle(pp.getTitle());
				programProducts.add(ppDto);
			}
		}
		
		ProgramDto dto = new ProgramDto();
		dto.setProgramId(p.getProgramId());
		dto.setTitle(p.getTitle());
		dto.setSynopsis(p.getSynopsis());
		dto.setGenres(genres);
		dto.setProducts(programProducts);
		
		return dto;
	}
}
