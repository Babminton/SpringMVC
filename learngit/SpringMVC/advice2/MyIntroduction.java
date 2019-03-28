/**
 * 
 */
package advice2;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.IntroductionInterceptor;

/**
  @author zeng
  @date 2019年3月26日 下午9:41:21
  @Descripton Introduction 未对象动态增加原来没有的职责
 */
public class MyIntroduction implements IntroductionInterceptor,IOther {

	/* (non-Javadoc)
	 * @see org.aopalliance.intercept.MethodInterceptor#invoke(org.aopalliance.intercept.MethodInvocation)
	 */
	@Override
	public boolean implementsInterface(Class myclass) {
		// TODO Auto-generated method stub
		return myclass.isAssignableFrom(IOther.class);
	}
	
	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {
		// TODO Auto-generated method stub
		if(implementsInterface(methodInvocation.getMethod().getDeclaringClass())){
			
			return methodInvocation.getMethod().invoke(this ,methodInvocation.getArguments());
		}else{
			
			return methodInvocation.proceed();
		}	
	}
	@Override
	public void validateUser() {
		  System.out.println("验证用户");
		
	}

}
