/**
 * 
 */
package advice1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
  @author zeng
  @date 2019年3月26日 下午9:09:37
  @Descripton
 */
public class StringDemo1 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("bean-config1.xml");
		IBusiness bean = (IBusiness) context.getBean("myProxy");//获得代理的实例对象
		bean.business1();
		bean.business2();
		bean.business3();
	}
}
