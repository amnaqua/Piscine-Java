package repositories;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;

public class EmbeddedDataSourceTest {
	@Test
	@BeforeEach
	public void testDBConnection() throws SQLException {
		EmbeddedDatabaseBuilder dataSource = new EmbeddedDatabaseBuilder();
		DataSource ds = dataSource.setType(EmbeddedDatabaseType.HSQL).addScript("schema.sql").addScript("data.sql").build();
		ds.getConnection();
		Assertions.assertNotNull(ds);
	}
}
