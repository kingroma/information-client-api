package information.client.api.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import information.client.api.dao.GenreDao;
import information.client.api.domain.Genre;
import information.client.api.responsedto.GenreDto;
import information.client.api.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService{
	@Resource
	private GenreDao genreDao;
	
	public List<GenreDto> listAll() {
		List<GenreDto> result = new ArrayList<GenreDto>();
		List<Genre> list = genreDao.findAll();
		
		if ( list != null && list.size() > 0 ) {
			for ( Genre g : list ) {
				GenreDto dto = new GenreDto();
				dto.setGenreId( g.getGenreId() ); 
				dto.setGenreName( g.getGenreName() );
				result.add(dto);
			}
		}
		
		return result ; 
	}
}
