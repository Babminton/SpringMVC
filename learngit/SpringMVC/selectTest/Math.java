/**
 * 
 */
package selectTest;

/**
  @author zeng
  @date 2019年3月9日 下午5:49:22
  @Descripton
 */
public class Math implements Itest{
     String testCode;
 	String testname;
 	
	public Math(String testCode, String testname) {
	
		this.testCode = testCode;
		this.testname = testname;
	}

	/* (non-Javadoc)
	 * @see selectTest.Itest#disInfo()
	 */
	@Override
	public void disInfo() {
		System.out.println(testCode+"   "+testname);
	}
	
	}
 
     
  

