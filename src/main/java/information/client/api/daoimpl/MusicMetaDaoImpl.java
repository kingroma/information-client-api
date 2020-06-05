package information.client.api.daoimpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import information.client.api.dao.MusicMetaDao;
import information.client.api.domain.MusicMeta;

@Lazy
@Repository
public class MusicMetaDaoImpl extends BaseDaoImpl<MusicMeta,String> implements MusicMetaDao {

}
