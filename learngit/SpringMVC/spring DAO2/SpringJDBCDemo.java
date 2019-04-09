package service;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import dao.IUserDAO;
import potity.User;

public class SpringJDBCDemo {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");
		IUserDAO dao = (IUserDAO) context.getBean("userDAO");
		
		//1. 插入操作
		User user = new User();
		user.setUserId(8);
		user.setUserName("张三");
		user.setUserPassword("333333");
		dao.insert(user);       
		
		//2. 查询操作1
		System.out.println(dao.find(1).toString());

		//3. 查询student.user表所有记录
		List<User> list = dao.findAll();
		Iterator<User> it = list.iterator();
		while (it.hasNext()) {
			User u = it.next();
			System.out.println(u.toString());
		}
		
		
	
	}

}
