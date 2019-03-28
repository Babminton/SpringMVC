/**
 * 
 */
package advice2;

import java.util.Date;

/**
  @author zeng
  @date 2019年3月20日 下午9:31:35
  @Descripton  接口IBusiness的实现类
 */
public class Component implements IBusiness {

	@Override
	public void business1() {
		System.out.println("业务1"+new Date().toString());
		
	}

	@Override
	public void business2() {
		System.out.println("业务2"+new Date().toString());
		
	}
	@Override
	public void business3() {
		System.out.println("业务3"+new Date().toString());
		
	}

}
