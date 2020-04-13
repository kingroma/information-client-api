package information.client.api.daoimpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import information.client.api.dao.ImageMetaDao;
import information.client.api.domain.ImageMeta;

@Lazy
@Repository
public class ImageMetaDaoImpl extends BaseDaoImpl<ImageMeta,String> implements ImageMetaDao{

}
