package information.client.api.daoimpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import information.client.api.dao.TokenDao;
import information.client.api.domain.Token;

@Lazy
@Repository
public class TokenDaoImpl extends BaseDaoImpl<Token,String> implements TokenDao{

}
