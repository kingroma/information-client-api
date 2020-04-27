package information.client.api.daoimpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import information.client.api.dao.GenreDao;
import information.client.api.domain.Genre;

@Lazy
@Repository
public class GenreDaoImpl extends BaseDaoImpl<Genre,String> implements GenreDao{

}
