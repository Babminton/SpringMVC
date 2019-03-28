/**
 * 
 */
package advice2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import advice2.IBusiness;

/**
  @author zeng
  @date 2019年3月26日 下午9:09:37
  @Descripton
 */
public class StringDemo2 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean-config2.xml");
		IBusiness bean = (IBusiness) context.getBean("myProxyFactoryBean");
		bean.business1();
		bean.business2();
		bean.business3();
		System.out.println("zeng");
		//动态增加方法
		
	   ((IOther)bean).validateUser();
		

	}

	
}
