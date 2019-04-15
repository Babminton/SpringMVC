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
  @date 2019年4月15日 下午4:07:08
  @Descripton
 */
public class AccountServiceTest {

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
	 * Test method for {@link lab07.AccountService#transfer(java.lang.String, java.lang.String, long)}.
	 */
	@Test
	public void testTransfer() {
		Account a1=new Account("1",1000);
		Account a2=new Account("2",2000);
		//创建mock对象
		AccountManager mockAccountManager=EasyMock.createMock(AccountManager.class);
		
		mockAccountManager.updateAccount(a1);
		mockAccountManager.updateAccount(a2);
	//	记录mock对象期望的行为--记录
	   EasyMock.expect(mockAccountManager.findAccountForUser("1")).andReturn(a1);
	   EasyMock.expect(mockAccountManager.findAccountForUser("2")).andReturn(a2);
	   //依赖注入
	   AccountService accountService=new AccountService();
	   accountService.setAccountManager(mockAccountManager);
	//   进入replay阶段--回放
	    EasyMock.replay(mockAccountManager);
		accountService.transfer("1", "2", 500);
	    assertEquals(500, a1.getBalance());
		assertEquals(2500, a2.getBalance());
	
		//较验
		EasyMock.verify(mockAccountManager);	
	}

}
