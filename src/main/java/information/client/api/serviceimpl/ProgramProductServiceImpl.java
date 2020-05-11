package information.client.api.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import information.client.api.dao.ProgramProductDao;
import information.client.api.domain.ProgramProduct;
import information.client.api.responsedto.ProgramProductDto;
import information.client.api.responsedto.TotalDto;
import information.client.api.service.ProgramProductService;

@Service
public class ProgramProductServiceImpl implements ProgramProductService{
	
	@Resource
	private ProgramProductDao programProductDao;
	
	public TotalDto<ProgramProductDto> findAll(){
		TotalDto<ProgramProductDto> result = new TotalDto<ProgramProductDto>();
		List<ProgramProduct> list = programProductDao.findAll();
		
		if ( list != null ) {
			for ( ProgramProduct pp : list ) {
				result.add(domainToDto(pp));
			}
		}
		
		return result ; 
	}
	
	@Override
	@Transactional
	public ProgramProductDto getById(String productId) { 
		ProgramProduct pp = null ; 
		ProgramProductDto dto = null ; 
		
		pp = programProductDao.findById(productId);
		if ( pp != null ) { 
			dto = domainToDto(pp);
		}
		
		return dto;
		
	}
	
	private ProgramProductDto domainToDto(ProgramProduct p) {
		ProgramProductDto dto = new ProgramProductDto();
		
		dto.setProductId(p.getId().getProductId());
		dto.setProgramId(p.getId().getProgramId());
		dto.setTitle(p.getTitle());
		dto.setText(p.getText());
		dto.setSeason(p.getSeason());
		
		return dto ; 
	}
}
