package information.client.api.service;

import information.client.api.responsedto.ProgramProductDto;
import information.client.api.responsedto.TotalDto;

public interface ProgramProductService {
	public TotalDto<ProgramProductDto> findAll();
	
	public ProgramProductDto findById(String productId);
}
