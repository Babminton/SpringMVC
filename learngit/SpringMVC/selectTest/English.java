/**
 * 
 */
package selectTest;

/**
  @author zeng
  @date 2019年3月9日 下午5:49:09
  @Descripton
 */
public class English implements Itest {
  String coursename;
public void setCoursename(String coursename) {
	this.coursename = coursename;
}

@Override
public void disInfo() {
    
	System.out.println(coursename);
}
  
  
}
