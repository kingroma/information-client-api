package information.client.api.service;

import java.util.List;

import information.client.api.dao.BaseDao;

public interface BaseService<T, D extends BaseDao<T, ?>> {
	public List<T> listAll();
	
}
