package lab07;
public class UserServiceImpl implements UserService {
private UserDao userDao;
public User query(String userId) {
return userDao.getById(userId);
}
public void setUserDao(UserDao userDao) {
this.userDao = userDao;
}
}
