/**
 * 
 */
package advice1;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

/**
  @author zeng
  @date 2019年3月27日 下午11:19:35
  @Descripton
 */
public class LogAfterAdivice implements AfterReturningAdvice {

	/* (non-Javadoc)
	 * @see org.springframework.aop.AfterReturningAdvice#afterReturning(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], java.lang.Object)
	 */
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		UserValidate.passUser();
	}

}
