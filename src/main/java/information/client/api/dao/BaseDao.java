package information.client.api.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import com.googlecode.genericdao.dao.jpa.GenericDAO;
import com.googlecode.genericdao.search.Filter;

public interface BaseDao<T, ID extends Serializable> extends GenericDAO<T, ID> {
	public EntityManager getEntityManager();
	
	public List<T> find(Filter... filters) ;
}
