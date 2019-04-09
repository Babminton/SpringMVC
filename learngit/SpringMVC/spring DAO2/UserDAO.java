package dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import potity.User;

public class UserDAO implements IUserDAO {

	private JdbcTemplate template;
	
	public void setDataSource(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);       //setter注入，利用dataSource构造JdbcTemplate实例对象
	}
	
	@Override
	public void insert(User user) {
		String sql = "insert into user values(?,?,?)";

		//已验证，可执行
//		template.update(new PreparedStatementCreator() {
//			
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//				PreparedStatement ps = con.prepareStatement(sql);
//				ps.setInt(1, user.getUserId());           //为第1个?占位符设置参数
//				ps.setString(2, user.getUserName());
//				ps.setString(3, user.getUserPassword());
//				return ps;
//			}
//		});
		
		//已验证，可执行
		template.update(sql, new PreparedStatementSetter() {
		
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, user.getUserId());			//为第1个?占位符设置参数
				ps.setString(2, user.getUserName());
				ps.setString(3, user.getUserPassword());
			}
		});
	}

	@Override
	public User find(int id) {
		String sql = "select * from user where id=?";
		
		//已验证，可执行
		List list = template.queryForList(sql, new Object[] {id});
		if (list.size() == 1) {
			User user = new User();
			Map map = (Map) list.get(0);
			user.setUserId((Integer)map.get("id"));
			user.setUserName((String)map.get("name"));
			user.setUserPassword((String)map.get("password"));
			return user;
		}
		return null;

	}

	@Override
	public List<User> findAll() {
		
		String sql = "select * from user";
		List<User> list = template.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User u = new User();
				u.setUserId(rs.getInt("id"));
				u.setUserName(rs.getString("name"));
				u.setUserPassword(rs.getString("password"));
				
				return u;
			}
		});
		
		return list;
	}
	
	@Override
	public void remove(int id) {
		String sql = "delete user where id=?";
		template.update(sql, new PreparedStatementSetter() {			
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, id);
			}
		});
	}

	@Override
	public void update(User user) {
		String sql = "update user set password=? where userid=?";
		template.update(sql, new PreparedStatementSetter() {			
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, user.getUserPassword());
				ps.setInt(2, user.getUserId());
			}
		});

	}

	@Override
	public List<User> find(String sql) {
		List<User> list = (List<User>) template.query(sql, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserId(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setUserPassword(rs.getString(3));
				
				return user;
			}
		});
		
		return list;
	}

}
