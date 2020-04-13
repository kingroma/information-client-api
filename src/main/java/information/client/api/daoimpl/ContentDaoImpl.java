package information.client.api.daoimpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import information.client.api.dao.ContentDao;
import information.client.api.domain.Content;

@Lazy
@Repository
public class ContentDaoImpl extends BaseDaoImpl<Content,String> implements ContentDao{

}
