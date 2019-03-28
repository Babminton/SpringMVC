/**
 * 
 */
package advice1;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
  @author zeng
  @date 2019年3月26日 下午8:53:56
  @Descripton
 */
public class LogBeforeAdvice implements MethodBeforeAdvice{

	/* (non-Javadoc)
	 * @see org.springframework.aop.MethodBeforeAdvice#before(java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public void before(Method method, Object[] arg1, Object arg2) throws Throwable {
		UserValidate.validateUser();
		
	}

}
