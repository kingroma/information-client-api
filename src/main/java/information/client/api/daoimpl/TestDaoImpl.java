package information.client.api.daoimpl;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import information.client.api.dao.TestDao;
import information.client.api.domain.Test;

@Lazy
@Repository
public class TestDaoImpl extends BaseDaoImpl<Test, String> implements TestDao {

}
