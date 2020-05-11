package information.client.api.daoimpl;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.googlecode.genericdao.search.Filter;

import information.client.api.dao.ProgramProductDao;
import information.client.api.domain.ProgramProduct;
import information.client.api.domain.ProgramProductPK;

@Lazy
@Repository
public class ProgramProductDaoImpl extends BaseDaoImpl<ProgramProduct,ProgramProductPK> implements ProgramProductDao{
	public ProgramProduct findById(String productId) {
		List<ProgramProduct> programProducts = find(Filter.equal("id.productId", productId));
		
		return programProducts == null || programProducts.isEmpty() ? 
				null : programProducts.get(0);
	}
}
