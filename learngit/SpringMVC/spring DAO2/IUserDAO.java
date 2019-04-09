package dao;

import java.util.List;
import potity.User;

/**
 * 
 * @ClassName: IUserDAO
 * @Description: 相对于User类，spring.user表的CRUD方法声明
 * @author zeng
 * @date 2019年4月4日 下午8:55:55
 */
public interface IUserDAO {
	public void insert(User user);
	public User find(int id);
	
	//
	public void remove(int id);
	public void update(User user);
	public List<User> find(String sql);
	public List<User> findAll();
}
