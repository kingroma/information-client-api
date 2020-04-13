package information.client.api.dao;

import information.client.api.domain.ProgramProduct;
import information.client.api.domain.ProgramProductPK;

public interface ProgramProductDao extends BaseDao<ProgramProduct, ProgramProductPK> {
	public ProgramProduct findById(String productId);
}
