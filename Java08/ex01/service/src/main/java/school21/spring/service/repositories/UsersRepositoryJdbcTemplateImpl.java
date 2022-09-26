package school21.spring.service.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {
	JdbcTemplate jdbcTemplate;

	public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public User findById(Long id) throws SQLException {
		String query = "SELECT * FROM data WHERE id = " + id.toString();
		return (jdbcTemplate.queryForObject(query, new UserMapper()));
	}

	@Override
	public List<User> findAll() throws SQLException {
		String query = "SELECT * FROM data";
		return (jdbcTemplate.query(query, new UserMapper()));
	}

	@Override
	public void save(User entity) throws SQLException {
		String query = "INSERT INTO data(email) VALUES(?)";
		jdbcTemplate.update(query, entity.getEmail());
	}

	@Override
	public void update(User entity) throws SQLException {
		String query = "UPDATE data SET email=? WHERE id=?";
		jdbcTemplate.update(query, entity.getEmail(), entity.getId());
	}

	@Override
	public void delete(Long id) throws SQLException {
		String query = "DELETE FROM data WHERE id=?";
		jdbcTemplate.update(query, id);
	}

	@Override
	public Optional<User> findByEmail(String email) throws SQLException {
		String query = "SELECT * FROM data WHERE email=?";
		return (jdbcTemplate.query(query, new Object[]{email}, new UserMapper()).stream().findAny());
	}

	public static class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet resultSet, int i) throws SQLException {
			User user = new User();
			user.setId(resultSet.getLong("id"));
			user.setEmail(resultSet.getString("email"));
			return (user);
		}
	}
}
