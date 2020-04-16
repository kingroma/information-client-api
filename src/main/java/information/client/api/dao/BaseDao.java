package information.client.api.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

import com.googlecode.genericdao.dao.jpa.GenericDAO;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Sort;

public interface BaseDao<T, ID extends Serializable> extends GenericDAO<T, ID> {
	public EntityManager getEntityManager();
	
	public List<T> findAll(Sort sort);
	
	public List<T> find(Filter... filters) ;
	
	public List<T> find(Sort sort, Filter... filters);
	
	public List<T> find(Sort[] sorts, Filter... filters);
	
	public List<T> find(int offset, int limit, Sort sorts, Filter... filters);
	
	public List<T> find(int offset, int limit, Sort[] sort, Filter... filters);
}
