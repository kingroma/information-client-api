package information.client.api.util;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.springframework.jdbc.datasource.ConnectionHandle;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;

public class MyHibernateJpaDialect extends HibernateJpaDialect {

	private static final long serialVersionUID = 1L;

	@Override
	public ConnectionHandle getJdbcConnection(EntityManager entityManager, boolean readOnly)
			throws PersistenceException, SQLException {

		ConnectionHandle connectionHandle = super.getJdbcConnection(entityManager, readOnly);
		if (null != connectionHandle && null != connectionHandle.getConnection()) {
			if (readOnly) {
				connectionHandle.getConnection().setReadOnly(true);
			}
			else {
				connectionHandle.getConnection().setReadOnly(false);
			}
		}

		return connectionHandle;
	}
}