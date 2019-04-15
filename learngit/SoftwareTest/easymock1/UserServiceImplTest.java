/**
 * 
 */
package lab07;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
  @author zeng
  @date 2019年4月15日 下午3:43:00
  @Descripton
 */
public class UserServiceImplTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link lab07.UserServiceImpl#query(java.lang.String)}.
	 */
	@Test
	public void testQuery() {
		User user=new User();
		user.setId("123");
		user.setAge(12);
		user.setName("曾先生");
		//创建mock对象
		UserDao userDao=EasyMock.createMock(UserDao.class);
		//	记录mock对象期望的行为--记录
		EasyMock.expect(userDao.getById("123")).andReturn(user);
		//依赖注入
		UserServiceImpl us=new UserServiceImpl();
		us.setUserDao(userDao);
		//   进入replay阶段--回放
		EasyMock.replay(userDao);
		user=us.query("123");
		assertEquals("123", user.getId());
		assertEquals(12, user.getAge());
		assertEquals("曾先生", user.getName());
		//校验
		EasyMock.verify(userDao);	
	}

}
