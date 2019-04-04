/**
 * 
 */
package dao;

import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;

//import javax.annotation.Resource;
import javax.sql.DataSource;

//import java.awt.List;
import java.sql.Connection;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.dao.support.DataAccessUtils;
import java.util.List;
import potity.User;

/**
  @author zeng
  @date 2019年4月3日 上午9:24:33
  @Descripton
 */
public class UserDAO implements IUserDAO{

	 private JdbcTemplate template;
		//利用datesourcez构造jdbcTemplate实例
		public void setDataSource(DataSource datasource){
			
			template=new JdbcTemplate(datasource);
		}
	

		//插入一条数据
		@Override
		public void inser(User user) {
			
			 int id=user.getId();
			 String name=user.getName();
			 String password=user.getPassword();	
			 template.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
					String sql1="insert into user value(?,?,?)";
					PreparedStatement preparedStatement=connection.prepareStatement(sql1);
					preparedStatement.setInt(1,id);
					preparedStatement.setString(2, name);
					preparedStatement.setString(3, password);
					return preparedStatement;
				}



				
		/*		public PreparedStatement createPreparedStatement(java.sql.Connection arg0) throws SQLException {
					// TODO Auto-generated method stub
					return null;
				}*/

			});
			
		}
/*	 @Descripton  程序失败，可能是包的使用顺序
 * @Override
	public User find(int id) {
         String sql2="select * from user where id=?";
         User user=template.queryForObject(sql2,new Object[]{id},new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rownum) throws SQLException {
				User user=new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));							
				return user;
			}
		});

		return user;
	}*/

		/* (non-Javadoc)
		 * @see dao.IUserDAO#find(int)
		 */
/*		//查找一条数据
		@Override
		public User find(int id) {
			 String sql2="select * from user where id=?";
			List rowsList=template.queryForList(sql2,new Object[]{id});
			Iterator it=((Iterable)rowsList).iterator();
			if(it.hasNext()){
				Map useMap=(Map)it.next();
				int id1=Integer.parseInt(useMap.get("id").toString());
				String name=useMap.get("name").toString();
				String password=useMap.get("password").toString();
				User user=new User();
				user.setId(id1);
                user.setName(name);	
                user.setPassword(password);
                return user;
			}
			
			return null;
		}*/

		@Override
		public  List<User> find(int id) {
			String sql2="select * from user where id=?";
			return template.query(sql2, new Object[]{id}, new UserRowMapper());
			
					
		}
		
		

		/* (non-Javadoc)
		 * @see dao.IUserDAO#update(potity.User)
		 */
		@Override
	 public void updateUser(User user) {
		String sql = "update user set name=?,password=? where id=?";
		template.update(sql, user.getName(),
			user.getPassword(), user.getId());
			System.out.println("updateUser is successful");  
		}

		@Override
		public List<User> findAllUser() {
			String sql="select * from user";
			
			return template.query(sql, new UserRowMapper());
		}

		/* (non-Javadoc)
		 * @see dao.IUserDAO#delectUser(int)
		 */
		@Override
		public void delectUser(int id) {
			String sql="delete from user where id=?";
			this.template.update(sql,id);
			
			System.out.println("删除成功");
		}


}
