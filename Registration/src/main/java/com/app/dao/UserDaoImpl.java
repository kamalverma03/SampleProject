package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.app.model.User;

@Repository
public class UserDaoImpl {

	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public void addUser(User user)
	{
		String sql = "insert into user_ (userID, password, firstName, lastName,role) values(?,?,?,?,?)";
		String insert_role_sql = "insert into authorities (userID, authority) values(?, 'ROLE_USER')";
		jdbcTemplate.update(sql, new Object[] {user.getUserId(),user.getPassword(), user.getFirstName(), user.getLastName(),user.getRole()});
		jdbcTemplate.update(insert_role_sql, new Object[] {user.getUserId()});
	}
	
	public List<User> getMerchantList()
	{
		String sql = "select * from user_ where role = ?";
		String role = "Merchant";
		return jdbcTemplate.query(sql, new Object[] { role },
				new UserMapper());
	}
	
	public User getUser(String userId)
	{
		String sql = "select * from user_ where userId=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { userId },
				new UserMapper());
	}
	
	public String getRole(String userId)
	{
		String sql = "select role from user_roles where userId=?";
		return jdbcTemplate.queryForObject(sql, new Object[] { userId },
				String.class);
	}
	
	
	private static final class UserMapper implements RowMapper<User> {

		@Override
		public User mapRow(ResultSet resultSet, int rowNum)
				throws SQLException {
			User user = new User();
			user.setUserId(resultSet.getString("userId"));
			user.setPassword(resultSet.getString("password"));
			user.setFirstName(resultSet.getString("firstName"));
			user.setLastName(resultSet.getString("lastName"));
			user.setRole(resultSet.getString("role"));
			return user;
		}

	}
	
}
