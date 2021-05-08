package api;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

@ApplicationScoped
public class ProveedorDataSource {
	
	@Resource(name="jdbc/MySqlPoolPf")
	@Produces
	private DataSource dataSource;
}
