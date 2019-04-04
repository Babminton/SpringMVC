package demo;


import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import dao.UserDAO;
import potity.User;

/**
  @author zeng
  @date 2019年4月2日 下午8:36:56
  @Descripton
 */
public class Demo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		UserDAO userDAO;
		User user;
		ApplicationContext context=new ClassPathXmlApplicationContext("beans-config1.xml");

		userDAO=(UserDAO)context.getBean("myDAO");
		user=(User)context.getBean("user");
		
	  //插入数据
  /*   	user.setId(1);
	    user.setName("曾祥渠");
	    user.setPassword("123");
	   userDAO.inser(user);*/
		
		//查找单条数据
		 List<User> user4=userDAO.find(1);
		 

	    for(User user3 : user4){
		    System.out.println("find()start");
	    	  System.out.println(user3.getId()+"**"+user3.getName()+"**"+user3.getPassword());	    	  
	    }
	  
	    //查找所有数据
	    List<User> user1=userDAO.findAllUser();
        System.out.println(user1.size());
        System.out.println(user1.get(0).getId());
        //遍历
        for (User user2 : user1) {
        	 System.out.println(user2.getId()+"*"+user2.getName()+"*"+user2.getPassword());
		}
        
   //更新
        
    /*    user.setId(1);
        user.setName("遥不可及");
        user.setPassword("123456789");
        userDAO.updateUser(user);
	   */
      //根据id删除消息行
    //	userDAO.delectUser(1);

        
	}
	
}
	
	
