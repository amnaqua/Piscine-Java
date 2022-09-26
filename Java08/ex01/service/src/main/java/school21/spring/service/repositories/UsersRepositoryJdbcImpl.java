package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {
	DataSource dataSource;

	public UsersRepositoryJdbcImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public User findById(Long id) throws SQLException {
		User user;
		Connection connection = dataSource.getConnection();
		Statement statement = connection.createStatement();
		String query = "SELECT * FROM data WHERE id = " + id.toString() + ";";
		ResultSet resultSet = statement.executeQuery(query);
		resultSet.next();
		user = new User(resultSet.getLong("id"), resultSet.getString("email"));
		statement.close();
		connection.close();
		return (user);
	}

	@Override
	public List<User> findAll() throws SQLException {
		List<User> userList = new ArrayList<>();
		Connection connection = dataSource.getConnection();
		Statement statement = connection.createStatement();
		String query = "SELECT * FROM data;";
		ResultSet resultSet = statement.executeQuery(query);
		while (resultSet.next()) {
			userList.add(new User(resultSet.getLong("id"), resultSet.getString("email")));
		}
		statement.close();
		connection.close();
		return (userList);
	}

	@Override
	public void save(User entity) throws SQLException {
		String query = "INSERT INTO data(email) VALUES (?);";
		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, entity.getEmail());
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}

	@Override
	public void update(User entity) throws SQLException {
		String query = "UPDATE data SET email = ? WHERE id = ?;";
		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, entity.getEmail());
		preparedStatement.setLong(2, entity.getId());
		preparedStatement.execute();
		preparedStatement.close();
		connection.close();
	}

	@Override
	public void delete(Long id) throws SQLException {
		Connection connection = dataSource.getConnection();
		Statement statement = connection.createStatement();
		String query = "DELETE FROM data WHERE id = " + id.toString() + ";";
		statement.executeQuery(query);
		statement.close();
		connection.close();
	}

	@Override
	public Optional<User> findByEmail(String email) throws SQLException {
		Optional<User> optionalUser;
		Connection connection = dataSource.getConnection();
		Statement statement = connection.createStatement();
		String query = "SELECT * FROM data WHERE email = '" + email + "';";
		ResultSet resultSet = statement.executeQuery(query);
		resultSet.next();
		optionalUser = Optional.of(new User(resultSet.getLong("id"), resultSet.getString("email")));
		statement.close();
		connection.close();
		return (optionalUser);
	}
}
