/**
 * 
 */
package selectTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import onlymyfun.first.HelloBean;

/**
  @author zeng
  @date 2019年3月9日 下午5:48:35
  @Descripton
 */
public class SpringExample2 {
   
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans-config.xml");  //定位xml资源文件并解析
		Student bean = (Student) context.getBean("student");                            //从Spring IoC容器通过Bean的id获得Bean
		bean.getEng().disInfo();                                             //使用Bean
		bean.getMath().disInfo();  
	}
}
