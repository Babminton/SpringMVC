
package dao;

import potity.User;
import java.util.List;
/**
  @author zeng
  @date 2019年4月1日 下午10:37:12
  @Descripton 
 */
public interface IUserDAO {
	public void inser(User user);
//	public User find(int id);
	public List<User> find(int id);
	
	public List<User> findAllUser();
	public void updateUser(User user);
    public void delectUser(int id);
    
	
}
