package information.client.api.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import information.client.api.dao.BaseDao;
import information.client.api.service.BaseService;
import information.client.api.util.ApplicationContextUtils;

@Transactional
public class BaseServiceImpl<T,D extends BaseDao<T, ?>> implements BaseService<T,D>, ApplicationContextAware, InitializingBean {

	protected D dao;
	
	protected Class<D> daoClass;
	 
	protected ApplicationContext applicationContext ;
	
	protected BaseServiceImpl(Class<D> daoClass) {
		this.daoClass = daoClass;
	}
	
	@Override
	public List<T> listAll() {
		return dao.findAll();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		if(dao == null)	{
			dao = (D)ApplicationContextUtils.getBeanByType(applicationContext, daoClass);
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;		
	}

}
