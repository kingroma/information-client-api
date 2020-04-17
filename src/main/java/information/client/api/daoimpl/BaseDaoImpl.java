package information.client.api.daoimpl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.googlecode.genericdao.dao.jpa.GenericDAOImpl;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.Sort;
import com.googlecode.genericdao.search.jpa.JPASearchProcessor;

import information.client.api.dao.BaseDao;

public class BaseDaoImpl<T, ID extends Serializable> extends GenericDAOImpl<T, ID> implements BaseDao<T, ID> {

	@Override
	@PersistenceContext(unitName = "domainPU")
	public void setEntityManager(EntityManager entityManager) {
		super.setEntityManager(entityManager);
	}
	
	@Override
	@Autowired
	public void setSearchProcessor(JPASearchProcessor searchProcessor) {
		super.setSearchProcessor(searchProcessor);
	}
	
	@Override
	public Integer countAll() {
		Search s = new Search();
		List<T> list = search(s);
		
		return list.size();
	}
	
	@Override
	public List<T> findAll(Sort sort){
		Search s = new Search();
		s.addSort(sort);
		return search(s);
	}
	
	@Override
	public List<T> findAll(int offset, int limit) {
		Search s = new Search();
		s.setFirstResult(offset);
		s.setMaxResults(limit);
		return search(s);
	}
	
	@Override
	public List<T> findAll(Sort sort, int offset, int limit) {
		Search s = new Search();
		s.addSort(sort);
		s.setFirstResult(offset);
		s.setMaxResults(limit);
		return search(s);
	}
	
	@Override
	public List<T> find(Filter... filters) {
		Search s = new Search();
		for (Filter filter : filters) {
			s.addFilter(filter);
		}
		return search(s);
	}
	
	@Override
	public List<T> find(Sort sort, Filter... filters) {
		Search s = new Search();
		for (Filter filter : filters) {
			s.addFilter(filter);
		}
		s.addSort(sort);
		return search(s);
	}
	
	@Override
	public List<T> find(Sort[] sorts, Filter... filters) {
		Search s = new Search();
		for (Filter filter : filters) {
			s.addFilter(filter);
		}
		
		for (Sort sort : sorts) {
			s.addSort(sort);
		}
		return search(s);
	}
	
	@Override
	public List<T> find(int offset, int limit, Sort sort, Filter... filters) {
		Search s = new Search();
		for (Filter filter : filters) {
			s.addFilter(filter);
		}
		s.addSort(sort);
		s.setFirstResult(offset);
		s.setMaxResults(limit);
		return search(s);
	}
	
	@Override
	public List<T> find(int offset, int limit, Sort[] sorts, Filter... filters) {
		Search s = new Search();
		for (Filter filter : filters) {
			s.addFilter(filter);
		}
		
		for (Sort sort : sorts) {
			s.addSort(sort);
		}
		
		s.setFirstResult(offset);
		s.setMaxResults(limit);
		return search(s);
	}

	@Override
	public EntityManager getEntityManager() {
		return this.em();
	}
}
