package potity;
/**
 * 
 * @ClassName: User
 * @Description: POJO类，对应于student.user表
 * @author zzw
 * @date 2019年4月4日 下午8:54:05
 */
public class User {
	private int userId;
	private String userName;
	private String userPassword;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}
}
