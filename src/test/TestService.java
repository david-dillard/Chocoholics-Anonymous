package test;

import static org.junit.Assert.*;

import org.junit.Test;
import chocAn.Service;
//import chocAn.Provider;

/**
 * This is the JUnit testing class for the ChocAn Service java class
 * @author Jacob Grinstead
 * @version 1.0
 */
public class TestService {
	
	/**
	 * This test ensures that service objects are returned
	 */
	@Test
	public void testGetProviderServicesForSuccess() {
		Service test = new Service();
		assertTrue(!test.getProviderServices("100000000").isEmpty());
	}
	
	/**
	 * This test ensures that service objects are NOT returned
	 */
	@Test
	public void testGetProviderServicesForFailure(){
		Service test = new Service();		
		assertTrue(test.getProviderServices("ThisWillFail").isEmpty());
	}
	
	/**
	 * This test assures that a member number can be extracted from a service object
	 */
	@Test
	public void testGetMemberNumberNumberForSuccess(){
		Service test = new Service();
		java.util.List<Service> list = test.getProviderServices("100000000");
		test=list.get(0);
		assertTrue("123456789".equals(test.getMemberNumber()));
	}
	
	/**
	 * This test assures that NO member number is extracted from a null service object
	 */
	@Test
	public void testGetMemberNumberForFailure(){
		Service test = new Service();
		assertTrue(null==test.getMemberNumber());
	}
}
