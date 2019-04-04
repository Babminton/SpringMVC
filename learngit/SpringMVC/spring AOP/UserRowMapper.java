
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import potity.User;

/**
  @author zeng
  @date 2019年4月3日 下午12:47:18
  @Descripton
  在jdbc的操作中，很多情况下要将ResultSst里的数据封装到一个持久化的bean中
 */
public class UserRowMapper implements RowMapper<User> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	
	@Override
	public User mapRow(ResultSet rs, int rownum) throws SQLException {

		User user=new User();
		user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));	
        user.setPassword(rs.getString("password"));
        return user;
	}

}
