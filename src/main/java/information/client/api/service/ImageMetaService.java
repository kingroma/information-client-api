package information.client.api.service;

import java.util.List;

import information.client.api.responsedto.ImageMetaDto;

public interface ImageMetaService {
	public List<ImageMetaDto> getImageMetaByMappingId(String mappingId);
}
